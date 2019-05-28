package com.tencent.mars.magicbox;

public class IPxxLogic {
    private static ICallBack callBack = null;

    public interface ICallBack {
        String getCrashFilePath(int i);

        String getUplodLogExtrasInfo();

        void recoverLinkAddrs();

        void setNewDnsDebugHostInfo(String str, int i);

        void uploadLogFail();

        void uploadLogResponse(long j, long j2);

        void uploadLogSuccess();
    }

    public static native void onIPxx(String str, int i);

    public static native void setHost(String str);

    public static native void uploadFile(String str, int i, long j, String str2);

    public static native void uploadLog(int i, int[] iArr, boolean z, long j, String str);

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    private static String getUplodLogExtrasInfo() {
        if (callBack == null) {
            return null;
        }
        return callBack.getUplodLogExtrasInfo();
    }

    private static void setNewDnsDebugHostInfo(String str, int i) {
        if (callBack != null) {
            callBack.setNewDnsDebugHostInfo(str, i);
        }
    }

    private static String getCrashFilePath(int i) {
        if (callBack == null) {
            return null;
        }
        return callBack.getCrashFilePath(i);
    }

    public static void uploadLogResponse(long j, long j2) {
        if (callBack != null) {
            callBack.uploadLogResponse(j, j2);
        }
    }

    public static void uploadLogFail() {
        if (callBack != null) {
            callBack.uploadLogFail();
        }
    }

    public static void uploadLogSuccess() {
        if (callBack != null) {
            callBack.uploadLogSuccess();
        }
    }

    public static void recoverLinkAddrs() {
        if (callBack != null) {
            callBack.recoverLinkAddrs();
        }
    }
}
