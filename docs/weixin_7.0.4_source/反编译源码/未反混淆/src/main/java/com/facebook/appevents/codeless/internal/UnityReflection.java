package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class UnityReflection {
    private static final String CAPTURE_VIEW_HIERARCHY_METHOD = "CaptureViewHierarchy";
    private static final String EVENT_MAPPING_METHOD = "OnReceiveMapping";
    private static final String FB_UNITY_GAME_OBJECT = "UnityFacebookSDKPlugin";
    private static final String TAG = UnityReflection.class.getCanonicalName();
    private static final String UNITY_PLAYER_CLASS = "com.unity3d.player.UnityPlayer";
    private static final String UNITY_SEND_MESSAGE_METHOD = "UnitySendMessage";
    private static Class<?> unityPlayer;

    static {
        AppMethodBeat.i(72116);
        AppMethodBeat.o(72116);
    }

    public static void sendMessage(String str, String str2, String str3) {
        AppMethodBeat.i(72113);
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName(UNITY_PLAYER_CLASS);
            }
            unityPlayer.getMethod(UNITY_SEND_MESSAGE_METHOD, new Class[]{String.class, String.class, String.class}).invoke(unityPlayer, new Object[]{str, str2, str3});
            AppMethodBeat.o(72113);
        } catch (Exception e) {
            AppMethodBeat.o(72113);
        }
    }

    public static void captureViewHierarchy() {
        AppMethodBeat.i(72114);
        sendMessage(FB_UNITY_GAME_OBJECT, CAPTURE_VIEW_HIERARCHY_METHOD, "");
        AppMethodBeat.o(72114);
    }

    public static void sendEventMapping(String str) {
        AppMethodBeat.i(72115);
        sendMessage(FB_UNITY_GAME_OBJECT, EVENT_MAPPING_METHOD, str);
        AppMethodBeat.o(72115);
    }
}
