package com.beyondsoft.fruit.utils;

import com.beyondsoft.fruit.BuildConfig;

/**
 * Created by mxh on 2017/9/12.
 * Describe：
 */

public class MUtils {
    public enum BuildType {
        debug,
        dogfood,
        release
    }

    public static boolean isNotDebug() {
        return !BuildType.debug.name().equalsIgnoreCase(BuildConfig.BUILD_TYPE);
    }

    public static boolean isDebug() {
        return BuildType.debug.name().equalsIgnoreCase(BuildConfig.BUILD_TYPE);
    }

    public static boolean isDogfood() {
        return BuildType.dogfood.name().equalsIgnoreCase(BuildConfig.BUILD_TYPE);
    }

    public static boolean isRelease() {
        return BuildType.release.name().equalsIgnoreCase(BuildConfig.BUILD_TYPE);
    }

    public static boolean isNotRelease() {
        //return false;
        return !BuildType.release.name().equalsIgnoreCase(BuildConfig.BUILD_TYPE);
    }
}
