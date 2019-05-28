package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Function extends V8Object {
    public V8Function(V8 v8, JavaCallback javaCallback) {
        super(v8, javaCallback);
    }

    protected V8Function(V8 v8) {
        this(v8, null);
    }

    /* Access modifiers changed, original: protected */
    public V8Value createTwin() {
        AppMethodBeat.i(75491);
        V8Function v8Function = new V8Function(this.v8);
        AppMethodBeat.o(75491);
        return v8Function;
    }

    public String toString() {
        AppMethodBeat.i(75492);
        String str;
        if (this.released || this.v8.isReleased()) {
            str = "[Function released]";
            AppMethodBeat.o(75492);
            return str;
        }
        str = super.toString();
        AppMethodBeat.o(75492);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void initialize(long j, Object obj) {
        AppMethodBeat.i(75493);
        if (obj == null) {
            super.initialize(j, null);
            AppMethodBeat.o(75493);
            return;
        }
        JavaCallback javaCallback = (JavaCallback) obj;
        long[] initNewV8Function = this.v8.initNewV8Function(j);
        this.v8.createAndRegisterMethodDescriptor(javaCallback, initNewV8Function[1]);
        this.released = false;
        addObjectReference(initNewV8Function[0]);
        AppMethodBeat.o(75493);
    }

    public V8Function twin() {
        AppMethodBeat.i(75494);
        V8Function v8Function = (V8Function) super.twin();
        AppMethodBeat.o(75494);
        return v8Function;
    }

    public Object call(V8Object v8Object, V8Array v8Array) {
        AppMethodBeat.i(75495);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Object);
        this.v8.checkRuntime(v8Array);
        if (v8Object == null) {
            v8Object = this.v8;
        }
        Object executeFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), v8Object.isUndefined() ? this.v8.getHandle() : v8Object.getHandle(), this.objectHandle, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.o(75495);
        return executeFunction;
    }
}
