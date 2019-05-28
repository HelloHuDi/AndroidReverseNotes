package com.eclipsesource.p097v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.V8ContextWrapper */
class V8ContextWrapper implements InvocationHandler {
    private static final String TAG = "V8ContextWrapper";
    private final MultiContextV8 multiContextV8;
    private final V8Context proxy = ((V8Context) Proxy.newProxyInstance(V8ContextWrapper.class.getClassLoader(), new Class[]{V8Context.class}, this));
    private final V8ContextImpl v8ContextImpl;
    private final long v8ContextPtr;

    /* renamed from: com.eclipsesource.v8.V8ContextWrapper$V8ContextImpl */
    final class V8ContextImpl extends V8Object implements V8Context {
        private final long ptr;

        V8ContextImpl(long j) {
            super(V8ContextWrapper.this.multiContextV8.getV8());
            AppMethodBeat.m2504i(75450);
            this.objectHandle = this.f14672v8.getGlobalObject();
            this.ptr = j;
            AppMethodBeat.m2505o(75450);
        }

        public final void executeVoidScript(String str) {
            AppMethodBeat.m2504i(75451);
            this.f14672v8.executeVoidScript(str);
            AppMethodBeat.m2505o(75451);
        }

        public final void executeVoidScript(String str, String str2, int i) {
            AppMethodBeat.m2504i(75452);
            this.f14672v8.executeVoidScript(str, str2, i);
            AppMethodBeat.m2505o(75452);
        }

        public final void executeVoidScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.m2504i(75453);
            this.f14672v8.executeVoidScript(str, str2, i, str3, str4);
            AppMethodBeat.m2505o(75453);
        }

        public final int executeIntegerScript(String str) {
            AppMethodBeat.m2504i(75454);
            int executeIntegerScript = this.f14672v8.executeIntegerScript(str);
            AppMethodBeat.m2505o(75454);
            return executeIntegerScript;
        }

        public final int executeIntegerScript(String str, String str2, int i) {
            AppMethodBeat.m2504i(75455);
            int executeIntegerScript = this.f14672v8.executeIntegerScript(str, str2, i);
            AppMethodBeat.m2505o(75455);
            return executeIntegerScript;
        }

        public final int executeIntegerScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.m2504i(75456);
            int executeIntegerScript = this.f14672v8.executeIntegerScript(str, str2, i, str3, str4);
            AppMethodBeat.m2505o(75456);
            return executeIntegerScript;
        }

        public final double executeDoubleScript(String str) {
            AppMethodBeat.m2504i(75457);
            double executeDoubleScript = this.f14672v8.executeDoubleScript(str);
            AppMethodBeat.m2505o(75457);
            return executeDoubleScript;
        }

        public final double executeDoubleScript(String str, String str2, int i) {
            AppMethodBeat.m2504i(75458);
            double executeDoubleScript = this.f14672v8.executeDoubleScript(str, str2, i);
            AppMethodBeat.m2505o(75458);
            return executeDoubleScript;
        }

        public final double executeDoubleScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.m2504i(75459);
            double executeDoubleScript = this.f14672v8.executeDoubleScript(str, str2, i, str3, str4);
            AppMethodBeat.m2505o(75459);
            return executeDoubleScript;
        }

        public final String executeStringScript(String str) {
            AppMethodBeat.m2504i(75460);
            String executeStringScript = this.f14672v8.executeStringScript(str);
            AppMethodBeat.m2505o(75460);
            return executeStringScript;
        }

        public final String executeStringScript(String str, String str2, int i) {
            AppMethodBeat.m2504i(75461);
            String executeStringScript = this.f14672v8.executeStringScript(str, str2, i);
            AppMethodBeat.m2505o(75461);
            return executeStringScript;
        }

        public final String executeStringScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.m2504i(75462);
            String executeStringScript = this.f14672v8.executeStringScript(str, str2, i, str3, str4);
            AppMethodBeat.m2505o(75462);
            return executeStringScript;
        }

        public final boolean executeBooleanScript(String str) {
            AppMethodBeat.m2504i(75463);
            boolean executeBooleanScript = this.f14672v8.executeBooleanScript(str);
            AppMethodBeat.m2505o(75463);
            return executeBooleanScript;
        }

        public final boolean executeBooleanScript(String str, String str2, int i) {
            AppMethodBeat.m2504i(75464);
            boolean executeBooleanScript = this.f14672v8.executeBooleanScript(str, str2, i);
            AppMethodBeat.m2505o(75464);
            return executeBooleanScript;
        }

        public final boolean executeBooleanScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.m2504i(75465);
            boolean executeBooleanScript = this.f14672v8.executeBooleanScript(str, str2, i, str3, str4);
            AppMethodBeat.m2505o(75465);
            return executeBooleanScript;
        }

        public final V8Array executeArrayScript(String str) {
            AppMethodBeat.m2504i(75466);
            V8Array executeArrayScript = this.f14672v8.executeArrayScript(str);
            AppMethodBeat.m2505o(75466);
            return executeArrayScript;
        }

        public final V8Array executeArrayScript(String str, String str2, int i) {
            AppMethodBeat.m2504i(75467);
            V8Array executeArrayScript = this.f14672v8.executeArrayScript(str, str2, i);
            AppMethodBeat.m2505o(75467);
            return executeArrayScript;
        }

        public final V8Array executeArrayScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.m2504i(75468);
            V8Array executeArrayScript = this.f14672v8.executeArrayScript(str, str2, i, str3, str4);
            AppMethodBeat.m2505o(75468);
            return executeArrayScript;
        }

        public final Object executeScript(String str) {
            AppMethodBeat.m2504i(75469);
            Object executeScript = this.f14672v8.executeScript(str);
            AppMethodBeat.m2505o(75469);
            return executeScript;
        }

        public final Object executeScript(String str, String str2, int i) {
            AppMethodBeat.m2504i(75470);
            Object executeScript = this.f14672v8.executeScript(str, str2, i);
            AppMethodBeat.m2505o(75470);
            return executeScript;
        }

        public final Object executeScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.m2504i(75471);
            Object executeScript = this.f14672v8.executeScript(str, str2, i, str3, str4);
            AppMethodBeat.m2505o(75471);
            return executeScript;
        }

        public final V8Object executeObjectScript(String str) {
            AppMethodBeat.m2504i(75472);
            V8Object executeObjectScript = this.f14672v8.executeObjectScript(str);
            AppMethodBeat.m2505o(75472);
            return executeObjectScript;
        }

        public final V8Object executeObjectScript(String str, String str2, int i) {
            AppMethodBeat.m2504i(75473);
            V8Object executeObjectScript = this.f14672v8.executeObjectScript(str, str2, i);
            AppMethodBeat.m2505o(75473);
            return executeObjectScript;
        }

        public final V8Object executeObjectScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.m2504i(75474);
            V8Object executeObjectScript = this.f14672v8.executeObjectScript(str, str2, i, str3, str4);
            AppMethodBeat.m2505o(75474);
            return executeObjectScript;
        }

        public final void shareObject(String str, V8Context v8Context) {
            AppMethodBeat.m2504i(75475);
            shareObjectImpl(str, v8Context, null);
            AppMethodBeat.m2505o(75475);
        }

        public final void shareObject(String str, V8Context v8Context, String str2) {
            AppMethodBeat.m2504i(75476);
            shareObjectImpl(str, v8Context, str2);
            AppMethodBeat.m2505o(75476);
        }

        public final V8Object newV8Object() {
            AppMethodBeat.m2504i(75477);
            V8Object v8Object = new V8Object(this.f14672v8);
            AppMethodBeat.m2505o(75477);
            return v8Object;
        }

        public final V8Array newV8Array() {
            AppMethodBeat.m2504i(75478);
            V8Array v8Array = new V8Array(this.f14672v8);
            AppMethodBeat.m2505o(75478);
            return v8Array;
        }

        public final V8ArrayBuffer newV8ArrayBuffer(int i) {
            AppMethodBeat.m2504i(75479);
            V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(this.f14672v8, i);
            AppMethodBeat.m2505o(75479);
            return v8ArrayBuffer;
        }

        public final V8ArrayBuffer newV8ArrayBuffer(ByteBuffer byteBuffer) {
            AppMethodBeat.m2504i(75480);
            V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(this.f14672v8, byteBuffer);
            AppMethodBeat.m2505o(75480);
            return v8ArrayBuffer;
        }

        public final SharedV8ArrayBuffer newSharedV8ArrayBuffer(ByteBuffer byteBuffer) {
            AppMethodBeat.m2504i(75481);
            SharedV8ArrayBuffer sharedV8ArrayBuffer = new SharedV8ArrayBuffer(this.f14672v8, byteBuffer);
            AppMethodBeat.m2505o(75481);
            return sharedV8ArrayBuffer;
        }

        public final V8Function newV8Function(JavaCallback javaCallback) {
            AppMethodBeat.m2504i(75482);
            V8Function v8Function = new V8Function(this.f14672v8, javaCallback);
            AppMethodBeat.m2505o(75482);
            return v8Function;
        }

        public final V8TypedArray newV8TypedArray(V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
            AppMethodBeat.m2504i(75483);
            V8TypedArray v8TypedArray = new V8TypedArray(this.f14672v8, v8ArrayBuffer, i, i2, i3);
            AppMethodBeat.m2505o(75483);
            return v8TypedArray;
        }

        public final String executeDebugScript(String str, String str2) {
            AppMethodBeat.m2504i(75484);
            String executeDebugScript = this.f14672v8.executeDebugScript(str, str2);
            AppMethodBeat.m2505o(75484);
            return executeDebugScript;
        }

        public final V8Object getGlobalObject() {
            return this;
        }

        public final void release() {
            AppMethodBeat.m2504i(75485);
            if (isReleased()) {
                AppMethodBeat.m2505o(75485);
                return;
            }
            this.f14672v8.releaseObjRef(this);
            V8ContextWrapper.this.multiContextV8.releaseContext(V8ContextWrapper.this);
            this.released = true;
            AppMethodBeat.m2505o(75485);
        }

        public final long getPtr() {
            return this.ptr;
        }

        private void shareObjectImpl(String str, V8Context v8Context, String str2) {
            AppMethodBeat.m2504i(75486);
            checkReleased();
            this.f14672v8.checkThread();
            if (str == null || str.isEmpty()) {
                AppMethodBeat.m2505o(75486);
            } else if (v8Context == null) {
                AppMethodBeat.m2505o(75486);
            } else {
                V8Value object = getObject(str);
                if (str2 == null || str2.isEmpty()) {
                    str2 = str;
                }
                v8Context.add(str2, object);
                object.release();
                AppMethodBeat.m2505o(75486);
            }
        }
    }

    V8ContextWrapper(MultiContextV8 multiContextV8, long j) {
        AppMethodBeat.m2504i(75487);
        this.multiContextV8 = multiContextV8;
        this.v8ContextPtr = j;
        enterContext();
        this.v8ContextImpl = new V8ContextImpl(j);
        AppMethodBeat.m2505o(75487);
    }

    public V8Context context() {
        return this.proxy;
    }

    /* Access modifiers changed, original: protected */
    public long getPtr() {
        return this.v8ContextPtr;
    }

    private void enterContext() {
        AppMethodBeat.m2504i(75488);
        this.multiContextV8.enterContext(this);
        AppMethodBeat.m2505o(75488);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(75489);
        if (this == obj) {
            AppMethodBeat.m2505o(75489);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(75489);
            return false;
        } else {
            if (this.v8ContextPtr == ((V8ContextWrapper) obj).v8ContextPtr) {
                AppMethodBeat.m2505o(75489);
                return true;
            }
            AppMethodBeat.m2505o(75489);
            return false;
        }
    }

    public int hashCode() {
        return (int) (this.v8ContextPtr ^ (this.v8ContextPtr >>> 32));
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.m2504i(75490);
        if (!method.getName().equals("isReleased")) {
            this.v8ContextImpl.checkReleased();
            enterContext();
        }
        try {
            Object invoke = method.invoke(this.v8ContextImpl, objArr);
            AppMethodBeat.m2505o(75490);
            return invoke;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            AppMethodBeat.m2505o(75490);
            throw cause;
        }
    }
}
