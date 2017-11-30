package me.bakumon.demo.flavorsdemo;

/**
 * Created by guesswhoami on 2017/8/10.
 */

public class ENV {

    private final static String TestHost = "http://192.168.100.107:8080" + "/demo";//测试环境
    private final static String PreReleaseHost = "http://43.204.40.226/demo";//预上线环境
    private final static String ReleaseHost = "http://www.xxx.com/demo";//正式环境

    private final static String TestImageHost = "http://192.168.100.165:8080/pic";//测试环境
    private final static String PreReleaseImageHost = "http://21.95.202.219/pic";//预上线环境
    private final static String ReleaseImageHost = "http://www.xxx.com/pic";//正式环境

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

    public static String getImageHost() {
        if (BuildConfig.ENV_TYPE == 1) {
            return TestImageHost;
        } else if (BuildConfig.ENV_TYPE == 2) {
            return PreReleaseImageHost;
        } else if (BuildConfig.ENV_TYPE == 3) {
            return ReleaseImageHost;
        }
        return ReleaseImageHost;
    }

}
