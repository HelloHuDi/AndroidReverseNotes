package com.tencent.p177mm.plugin.normsg;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Keep
/* renamed from: com.tencent.mm.plugin.normsg.CProxyStub */
public class CProxyStub implements InvocationHandler {
    @Keep
    private final long mNativePtr;

    private native void nativeFinalize();

    public native Object invoke(Object obj, Method method, Object[] objArr);

    private CProxyStub(long j) {
        AppMethodBeat.m2504i(10251);
        synchronized (this) {
            try {
                this.mNativePtr = j;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(10251);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(10252);
        try {
            synchronized (this) {
                nativeFinalize();
            }
            super.finalize();
            AppMethodBeat.m2505o(10252);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.m2505o(10252);
        }
    }
}
