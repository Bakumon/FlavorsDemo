# FlavorsDemo

利用 productFlavors 构造变体做 Url 环境(开发、预上线、生产)的区分，多渠道可以使用 [walle(Android Signature V2 Scheme签名下的新一代渠道包打包神器)](https://github.com/Meituan-Dianping/walle)实现。这里有个 [WalleDemo](https://github.com/Bakumon/WalleDemo)。

## 目的

1. 为了避免打不同环境包时，频繁更改 ENV.java 文件可能导致的错误。
2. 提高打包效率

## 怎么用

1. 在 app 的 build.gradle 配置文件中加入 productFlavors 的配置，具体见 demo
2. 修改 AndroidManifest.xml ：android:label="${app_name}"
3. 修改 ENV.java

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