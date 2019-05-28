package com.eclipsesource.v8;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Inspector {
    private static JsInspectorChannelServer _server;

    public interface JsInspectorChannelServer {
        int notify(long j, long j2, String str);

        int sendData(long j, String str);
    }

    static native int JniNotify(long j, long j2, String str);

    static native void JniReceiveData(long j, String str);

    public static void setServer(JsInspectorChannelServer jsInspectorChannelServer) {
        _server = jsInspectorChannelServer;
    }

    public static void onReceiveData(long j, String str) {
        AppMethodBeat.i(75498);
        JniReceiveData(j, str);
        AppMethodBeat.o(75498);
    }

    public static int notify(long j, long j2, String str) {
        AppMethodBeat.i(75499);
        int JniNotify = JniNotify(j, j2, str);
        AppMethodBeat.o(75499);
        return JniNotify;
    }

    @Keep
    public static int jniCallbackSendData(long j, String str) {
        AppMethodBeat.i(75500);
        if (_server == null) {
            AppMethodBeat.o(75500);
            return -1;
        }
        int sendData = _server.sendData(j, str);
        AppMethodBeat.o(75500);
        return sendData;
    }

    @Keep
    public static int jniCallbackNotify(long j, long j2, String str) {
        AppMethodBeat.i(75501);
        if (_server == null) {
            AppMethodBeat.o(75501);
            return -1;
        }
        int notify = _server.notify(j, j2, str);
        AppMethodBeat.o(75501);
        return notify;
    }
}
