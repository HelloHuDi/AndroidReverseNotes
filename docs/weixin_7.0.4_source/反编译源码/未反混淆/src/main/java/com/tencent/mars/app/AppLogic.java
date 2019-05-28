package com.tencent.mars.app;

public class AppLogic {
    private static final String TAG = "mars.app.NativeAppJni$C2Java";
    private static ICallBack callBack = null;

    public static class AccountInfo {
        public long uin = 0;
        public String userName = "";

        public AccountInfo(long j, String str) {
            this.uin = j;
            this.userName = str;
        }
    }

    public interface ICallBack {
        AccountInfo getAccountInfo();

        String getAppFilePath();

        int getClientVersion();

        String getCurLanguage();

        DeviceInfo getDeviceType();
    }

    public static class DeviceInfo {
        public String devicename = "";
        public String devicetype = "";

        public DeviceInfo(String str, String str2) {
            this.devicename = str;
            this.devicetype = str2;
        }
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    public static String getAppFilePath() {
        if (callBack != null) {
            return callBack.getAppFilePath();
        }
        return null;
    }

    private static AccountInfo getAccountInfo() {
        if (callBack == null) {
            return null;
        }
        return callBack.getAccountInfo();
    }

    private static int getClientVersion() {
        if (callBack == null) {
            return 0;
        }
        return callBack.getClientVersion();
    }

    private static DeviceInfo getDeviceType() {
        if (callBack == null) {
            return null;
        }
        return callBack.getDeviceType();
    }

    private static String getCurLanguage() {
        if (callBack == null) {
            return null;
        }
        return callBack.getCurLanguage();
    }
}
