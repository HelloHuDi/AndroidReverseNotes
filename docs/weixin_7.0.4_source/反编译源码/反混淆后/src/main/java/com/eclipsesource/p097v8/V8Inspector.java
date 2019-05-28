package com.eclipsesource.p097v8;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.V8Inspector */
public class V8Inspector {
    private static JsInspectorChannelServer _server;

    /* renamed from: com.eclipsesource.v8.V8Inspector$JsInspectorChannelServer */
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
        AppMethodBeat.m2504i(75498);
        V8Inspector.JniReceiveData(j, str);
        AppMethodBeat.m2505o(75498);
    }

    public static int notify(long j, long j2, String str) {
        AppMethodBeat.m2504i(75499);
        int JniNotify = V8Inspector.JniNotify(j, j2, str);
        AppMethodBeat.m2505o(75499);
        return JniNotify;
    }

    @Keep
    public static int jniCallbackSendData(long j, String str) {
        AppMethodBeat.m2504i(75500);
        if (_server == null) {
            AppMethodBeat.m2505o(75500);
            return -1;
        }
        int sendData = _server.sendData(j, str);
        AppMethodBeat.m2505o(75500);
        return sendData;
    }

    @Keep
    public static int jniCallbackNotify(long j, long j2, String str) {
        AppMethodBeat.m2504i(75501);
        if (_server == null) {
            AppMethodBeat.m2505o(75501);
            return -1;
        }
        int notify = _server.notify(j, j2, str);
        AppMethodBeat.m2505o(75501);
        return notify;
    }
}
