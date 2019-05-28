package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;

class V8ContextWrapper implements InvocationHandler {
    private static final String TAG = "V8ContextWrapper";
    private final MultiContextV8 multiContextV8;
    private final V8Context proxy = ((V8Context) Proxy.newProxyInstance(V8ContextWrapper.class.getClassLoader(), new Class[]{V8Context.class}, this));
    private final V8ContextImpl v8ContextImpl;
    private final long v8ContextPtr;

    final class V8ContextImpl extends V8Object implements V8Context {
        private final long ptr;

        V8ContextImpl(long j) {
            super(V8ContextWrapper.this.multiContextV8.getV8());
            AppMethodBeat.i(75450);
            this.objectHandle = this.v8.getGlobalObject();
            this.ptr = j;
            AppMethodBeat.o(75450);
        }

        public final void executeVoidScript(String str) {
            AppMethodBeat.i(75451);
            this.v8.executeVoidScript(str);
            AppMethodBeat.o(75451);
        }

        public final void executeVoidScript(String str, String str2, int i) {
            AppMethodBeat.i(75452);
            this.v8.executeVoidScript(str, str2, i);
            AppMethodBeat.o(75452);
        }

        public final void executeVoidScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.i(75453);
            this.v8.executeVoidScript(str, str2, i, str3, str4);
            AppMethodBeat.o(75453);
        }

        public final int executeIntegerScript(String str) {
            AppMethodBeat.i(75454);
            int executeIntegerScript = this.v8.executeIntegerScript(str);
            AppMethodBeat.o(75454);
            return executeIntegerScript;
        }

        public final int executeIntegerScript(String str, String str2, int i) {
            AppMethodBeat.i(75455);
            int executeIntegerScript = this.v8.executeIntegerScript(str, str2, i);
            AppMethodBeat.o(75455);
            return executeIntegerScript;
        }

        public final int executeIntegerScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.i(75456);
            int executeIntegerScript = this.v8.executeIntegerScript(str, str2, i, str3, str4);
            AppMethodBeat.o(75456);
            return executeIntegerScript;
        }

        public final double executeDoubleScript(String str) {
            AppMethodBeat.i(75457);
            double executeDoubleScript = this.v8.executeDoubleScript(str);
            AppMethodBeat.o(75457);
            return executeDoubleScript;
        }

        public final double executeDoubleScript(String str, String str2, int i) {
            AppMethodBeat.i(75458);
            double executeDoubleScript = this.v8.executeDoubleScript(str, str2, i);
            AppMethodBeat.o(75458);
            return executeDoubleScript;
        }

        public final double executeDoubleScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.i(75459);
            double executeDoubleScript = this.v8.executeDoubleScript(str, str2, i, str3, str4);
            AppMethodBeat.o(75459);
            return executeDoubleScript;
        }

        public final String executeStringScript(String str) {
            AppMethodBeat.i(75460);
            String executeStringScript = this.v8.executeStringScript(str);
            AppMethodBeat.o(75460);
            return executeStringScript;
        }

        public final String executeStringScript(String str, String str2, int i) {
            AppMethodBeat.i(75461);
            String executeStringScript = this.v8.executeStringScript(str, str2, i);
            AppMethodBeat.o(75461);
            return executeStringScript;
        }

        public final String executeStringScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.i(75462);
            String executeStringScript = this.v8.executeStringScript(str, str2, i, str3, str4);
            AppMethodBeat.o(75462);
            return executeStringScript;
        }

        public final boolean executeBooleanScript(String str) {
            AppMethodBeat.i(75463);
            boolean executeBooleanScript = this.v8.executeBooleanScript(str);
            AppMethodBeat.o(75463);
            return executeBooleanScript;
        }

        public final boolean executeBooleanScript(String str, String str2, int i) {
            AppMethodBeat.i(75464);
            boolean executeBooleanScript = this.v8.executeBooleanScript(str, str2, i);
            AppMethodBeat.o(75464);
            return executeBooleanScript;
        }

        public final boolean executeBooleanScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.i(75465);
            boolean executeBooleanScript = this.v8.executeBooleanScript(str, str2, i, str3, str4);
            AppMethodBeat.o(75465);
            return executeBooleanScript;
        }

        public final V8Array executeArrayScript(String str) {
            AppMethodBeat.i(75466);
            V8Array executeArrayScript = this.v8.executeArrayScript(str);
            AppMethodBeat.o(75466);
            return executeArrayScript;
        }

        public final V8Array executeArrayScript(String str, String str2, int i) {
            AppMethodBeat.i(75467);
            V8Array executeArrayScript = this.v8.executeArrayScript(str, str2, i);
            AppMethodBeat.o(75467);
            return executeArrayScript;
        }

        public final V8Array executeArrayScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.i(75468);
            V8Array executeArrayScript = this.v8.executeArrayScript(str, str2, i, str3, str4);
            AppMethodBeat.o(75468);
            return executeArrayScript;
        }

        public final Object executeScript(String str) {
            AppMethodBeat.i(75469);
            Object executeScript = this.v8.executeScript(str);
            AppMethodBeat.o(75469);
            return executeScript;
        }

        public final Object executeScript(String str, String str2, int i) {
            AppMethodBeat.i(75470);
            Object executeScript = this.v8.executeScript(str, str2, i);
            AppMethodBeat.o(75470);
            return executeScript;
        }

        public final Object executeScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.i(75471);
            Object executeScript = this.v8.executeScript(str, str2, i, str3, str4);
            AppMethodBeat.o(75471);
            return executeScript;
        }

        public final V8Object executeObjectScript(String str) {
            AppMethodBeat.i(75472);
            V8Object executeObjectScript = this.v8.executeObjectScript(str);
            AppMethodBeat.o(75472);
            return executeObjectScript;
        }

        public final V8Object executeObjectScript(String str, String str2, int i) {
            AppMethodBeat.i(75473);
            V8Object executeObjectScript = this.v8.executeObjectScript(str, str2, i);
            AppMethodBeat.o(75473);
            return executeObjectScript;
        }

        public final V8Object executeObjectScript(String str, String str2, int i, String str3, String str4) {
            AppMethodBeat.i(75474);
            V8Object executeObjectScript = this.v8.executeObjectScript(str, str2, i, str3, str4);
            AppMethodBeat.o(75474);
            return executeObjectScript;
        }

        public final void shareObject(String str, V8Context v8Context) {
            AppMethodBeat.i(75475);
            shareObjectImpl(str, v8Context, null);
            AppMethodBeat.o(75475);
        }

        public final void shareObject(String str, V8Context v8Context, String str2) {
            AppMethodBeat.i(75476);
            shareObjectImpl(str, v8Context, str2);
            AppMethodBeat.o(75476);
        }

        public final V8Object newV8Object() {
            AppMethodBeat.i(75477);
            V8Object v8Object = new V8Object(this.v8);
            AppMethodBeat.o(75477);
            return v8Object;
        }

        public final V8Array newV8Array() {
            AppMethodBeat.i(75478);
            V8Array v8Array = new V8Array(this.v8);
            AppMethodBeat.o(75478);
            return v8Array;
        }

        public final V8ArrayBuffer newV8ArrayBuffer(int i) {
            AppMethodBeat.i(75479);
            V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(this.v8, i);
            AppMethodBeat.o(75479);
            return v8ArrayBuffer;
        }

        public final V8ArrayBuffer newV8ArrayBuffer(ByteBuffer byteBuffer) {
            AppMethodBeat.i(75480);
            V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(this.v8, byteBuffer);
            AppMethodBeat.o(75480);
            return v8ArrayBuffer;
        }

        public final SharedV8ArrayBuffer newSharedV8ArrayBuffer(ByteBuffer byteBuffer) {
            AppMethodBeat.i(75481);
            SharedV8ArrayBuffer sharedV8ArrayBuffer = new SharedV8ArrayBuffer(this.v8, byteBuffer);
            AppMethodBeat.o(75481);
            return sharedV8ArrayBuffer;
        }

        public final V8Function newV8Function(JavaCallback javaCallback) {
            AppMethodBeat.i(75482);
            V8Function v8Function = new V8Function(this.v8, javaCallback);
            AppMethodBeat.o(75482);
            return v8Function;
        }

        public final V8TypedArray newV8TypedArray(V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
            AppMethodBeat.i(75483);
            V8TypedArray v8TypedArray = new V8TypedArray(this.v8, v8ArrayBuffer, i, i2, i3);
            AppMethodBeat.o(75483);
            return v8TypedArray;
        }

        public final String executeDebugScript(String str, String str2) {
            AppMethodBeat.i(75484);
            String executeDebugScript = this.v8.executeDebugScript(str, str2);
            AppMethodBeat.o(75484);
            return executeDebugScript;
        }

        public final V8Object getGlobalObject() {
            return this;
        }

        public final void release() {
            AppMethodBeat.i(75485);
            if (isReleased()) {
                AppMethodBeat.o(75485);
                return;
            }
            this.v8.releaseObjRef(this);
            V8ContextWrapper.this.multiContextV8.releaseContext(V8ContextWrapper.this);
            this.released = true;
            AppMethodBeat.o(75485);
        }

        public final long getPtr() {
            return this.ptr;
        }

        private void shareObjectImpl(String str, V8Context v8Context, String str2) {
            AppMethodBeat.i(75486);
            checkReleased();
            this.v8.checkThread();
            if (str == null || str.isEmpty()) {
                AppMethodBeat.o(75486);
            } else if (v8Context == null) {
                AppMethodBeat.o(75486);
            } else {
                V8Value object = getObject(str);
                if (str2 == null || str2.isEmpty()) {
                    str2 = str;
                }
                v8Context.add(str2, object);
                object.release();
                AppMethodBeat.o(75486);
            }
        }
    }

    V8ContextWrapper(MultiContextV8 multiContextV8, long j) {
        AppMethodBeat.i(75487);
        this.multiContextV8 = multiContextV8;
        this.v8ContextPtr = j;
        enterContext();
        this.v8ContextImpl = new V8ContextImpl(j);
        AppMethodBeat.o(75487);
    }

    public V8Context context() {
        return this.proxy;
    }

    /* Access modifiers changed, original: protected */
    public long getPtr() {
        return this.v8ContextPtr;
    }

    private void enterContext() {
        AppMethodBeat.i(75488);
        this.multiContextV8.enterContext(this);
        AppMethodBeat.o(75488);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(75489);
        if (this == obj) {
            AppMethodBeat.o(75489);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(75489);
            return false;
        } else {
            if (this.v8ContextPtr == ((V8ContextWrapper) obj).v8ContextPtr) {
                AppMethodBeat.o(75489);
                return true;
            }
            AppMethodBeat.o(75489);
            return false;
        }
    }

    public int hashCode() {
        return (int) (this.v8ContextPtr ^ (this.v8ContextPtr >>> 32));
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.i(75490);
        if (!method.getName().equals("isReleased")) {
            this.v8ContextImpl.checkReleased();
            enterContext();
        }
        try {
            Object invoke = method.invoke(this.v8ContextImpl, objArr);
            AppMethodBeat.o(75490);
            return invoke;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            AppMethodBeat.o(75490);
            throw cause;
        }
    }
}
