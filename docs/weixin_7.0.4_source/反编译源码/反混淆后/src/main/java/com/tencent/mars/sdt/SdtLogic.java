package com.tencent.mars.sdt;

import com.tencent.mars.Mars;
import java.util.ArrayList;

public class SdtLogic {
    private static final String TAG = "mars.SdtLogic";
    private static ICallBack callBack = null;

    public interface ICallBack {
    }

    private static native ArrayList<String> getLoadLibraries();

    public static native void setHttpNetcheckCGI(String str);

    static {
        ArrayList loadLibraries;
        try {
            loadLibraries = getLoadLibraries();
        } catch (UnsatisfiedLinkError e) {
            loadLibraries = null;
            Mars.loadDefaultMarsLibrary();
        }
        Mars.checkLoadedModules(loadLibraries, TAG);
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    private static void reportSignalDetectResults(String str) {
    }
}
