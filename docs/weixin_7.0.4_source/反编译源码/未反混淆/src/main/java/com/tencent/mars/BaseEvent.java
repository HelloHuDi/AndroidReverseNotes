package com.tencent.mars;

public class BaseEvent {
    public static native void onCreate();

    public static native void onDestroy();

    public static native void onExceptionCrash();

    public static native void onForeground(boolean z);

    public static native void onNetworkChange();

    public static native void onSingalCrash(int i);
}
