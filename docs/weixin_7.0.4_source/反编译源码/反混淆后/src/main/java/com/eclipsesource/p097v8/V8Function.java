package com.eclipsesource.p097v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.V8Function */
public class V8Function extends V8Object {
    public V8Function(C45010V8 c45010v8, JavaCallback javaCallback) {
        super(c45010v8, javaCallback);
    }

    protected V8Function(C45010V8 c45010v8) {
        this(c45010v8, null);
    }

    /* Access modifiers changed, original: protected */
    public V8Value createTwin() {
        AppMethodBeat.m2504i(75491);
        V8Function v8Function = new V8Function(this.f14672v8);
        AppMethodBeat.m2505o(75491);
        return v8Function;
    }

    public String toString() {
        AppMethodBeat.m2504i(75492);
        String str;
        if (this.released || this.f14672v8.isReleased()) {
            str = "[Function released]";
            AppMethodBeat.m2505o(75492);
            return str;
        }
        str = super.toString();
        AppMethodBeat.m2505o(75492);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void initialize(long j, Object obj) {
        AppMethodBeat.m2504i(75493);
        if (obj == null) {
            super.initialize(j, null);
            AppMethodBeat.m2505o(75493);
            return;
        }
        JavaCallback javaCallback = (JavaCallback) obj;
        long[] initNewV8Function = this.f14672v8.initNewV8Function(j);
        this.f14672v8.createAndRegisterMethodDescriptor(javaCallback, initNewV8Function[1]);
        this.released = false;
        addObjectReference(initNewV8Function[0]);
        AppMethodBeat.m2505o(75493);
    }

    public V8Function twin() {
        AppMethodBeat.m2504i(75494);
        V8Function v8Function = (V8Function) super.twin();
        AppMethodBeat.m2505o(75494);
        return v8Function;
    }

    public Object call(V8Object v8Object, V8Array v8Array) {
        AppMethodBeat.m2504i(75495);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Object);
        this.f14672v8.checkRuntime(v8Array);
        if (v8Object == null) {
            v8Object = this.f14672v8;
        }
        Object executeFunction = this.f14672v8.executeFunction(this.f14672v8.getV8RuntimePtr(), v8Object.isUndefined() ? this.f14672v8.getHandle() : v8Object.getHandle(), this.objectHandle, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.m2505o(75495);
        return executeFunction;
    }
}
