package com.tencent.magicbrush.engine;

import com.tencent.magicbrush.p1173a.C45128b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

class JsEngine {
    static native void addJsInterface(long j, Object obj, String str);

    static native long createVM(String str, byte[] bArr);

    static native long createVMContext(long j, int i);

    static native String evaluateJavascript(long j, String str);

    static native String evaluateJavascriptCache(long j, String str, String str2, String str3, String str4);

    static native String evaluateJavascriptDebug(long j, String str, String str2);

    static native String evaluateJavascriptFile(long j, String str, String str2);

    static native ByteBuffer getNativeBuffer(int i, long j);

    static native int getNativeBufferId();

    static native void pumpMessageLoop(long j);

    static native boolean pushObject(long j, long j2, String str);

    static native void releaseVM(long j);

    static native void releaseVMContext(long j);

    static native boolean removeJsInterface(long j, String str);

    static native boolean removeObject(long j, String str);

    static native void setNativeBuffer(int i, ByteBuffer byteBuffer);

    static native void waitForDebuger(long j, String str);

    JsEngine() {
    }

    static {
        AppMethodBeat.m2504i(115881);
        C45128b.m82948yB();
        AppMethodBeat.m2505o(115881);
    }
}
