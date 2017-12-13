# FlavorsDemo

利用 productFlavors 构造变体做 Url 环境(开发、预上线、生产)的区分，多渠道可以使用 [walle(Android Signature V2 Scheme签名下的新一代渠道包打包神器)](https://github.com/Meituan-Dianping/walle)实现。这里有个 [WalleDemo](https://github.com/Bakumon/WalleDemo)。

## 目的

1. 为了避免打不同环境包时，频繁更改 ENV.java 文件可能导致的错误。
2. 提高打包效率

## 怎么用

1. 在 app 的 build.gradle 配置文件中加入 productFlavors 的配置，具体见 demo
2. 修改 AndroidManifest.xml ：android:label="${app_name}"
3. 修改 ENV.java

## 获取环境类型

```java
public static String getHttpHost() {
    if (BuildConfig.ENV_TYPE == 1) {
        return TestHost;
    } else if (BuildConfig.ENV_TYPE == 2) {
        return PreReleaseHost;
    } else if (BuildConfig.ENV_TYPE == 3) {
        return ReleaseHost;
    }
    return ReleaseHost;
}
```

## 怎么打包

使用 gradle 命令：

### assembleDevelop:

    打开发环境包：

    1.app-develop-debug.apk
    2.app-develop-release.apk

### assemblePreRelease:

    打预上线环境包：

    1.app-preRelease-debug.apk
    2.app-preRelease-release.apk

### assembleProduct:

    打生产环境包：

    5.app-product-debug.apk
    6.app-product-release.apk

### assembleDebug:

    打所有 debug 包：

    1.app-develop-debug.apk
    2.app-preRelease-debug.apk
    3.app-product-debug.apk

### assembleRelease:

    打所有 release 包：

    1.app-develop-release.apk
    2.app-preRelease-release.apk
    3.app-product-release.apk

### assemble

    打所有包：

    1.app-develop-debug.apk
    2.app-develop-release.apk
    3.app-preRelease-debug.apk
    4.app-preRelease-release.apk
    5.app-product-debug.apk
    6.app-product-release.apk

## 怎么直接 run 到手机上

    点击 studio 左下角 "Build Variants"，给 app 选择默认的命令即可。

    比如，可以选择 "productRelease"，run 的时候就直接把生产环境的 release 包安装到了手机上。

## 自定义 apk 文件名

   demo 输出的文件名是这样的：

   > 应用名-变种名-编译类型-版本号-版本名称-创建时间.apk

   自定义 apk 文件名时，需要的信息都可以从 variant 中取到，以下表格列举一些 String 类型的变量：

   注：以下取到的值都是当前编译下，所以当改变编译类型或变种等，值也会跟着改变。

   |variant的成员变量|含义|示例|
   |---|---|---|
   |baseName|变种名和编译类型的结合|develop-debug|
   |name|variant的名称|developDebug|
   |flavorName|变种名|develop|
   |buildType.name|编译类型|debug|
   |versionCode|版本号|1|
   |versionName|版本名称|1.0|
   |applicationId|包名|me.bakuon.demo.flavorsdemo|

   gradle 插件 3.0.0 以后版本自定义 apk 文件名方法有所改变，具体见 [demo](/app/build.gradle)