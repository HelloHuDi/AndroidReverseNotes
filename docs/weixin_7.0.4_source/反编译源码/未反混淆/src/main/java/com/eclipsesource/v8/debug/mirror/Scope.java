package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Scope extends Mirror {
    private static final String SCOPE_OBJECT = "scopeObject";
    private static final String SCOPE_TYPE = "scopeType";
    private static final String SET_VARIABLE_VALUE = "setVariableValue";

    public enum ScopeType {
        Global(0),
        Local(1),
        With(2),
        Closure(3),
        Catch(4),
        Block(5),
        Script(6);
        
        int index;

        static {
            AppMethodBeat.o(74901);
        }

        private ScopeType(int i) {
            this.index = i;
        }
    }

    Scope(V8Object v8Object) {
        super(v8Object);
    }

    public ScopeType getType() {
        AppMethodBeat.i(74902);
        ScopeType scopeType = ScopeType.values()[this.v8Object.executeIntegerFunction(SCOPE_TYPE, null)];
        AppMethodBeat.o(74902);
        return scopeType;
    }

    public void setVariableValue(String str, int i) {
        AppMethodBeat.i(74903);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(i);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74903);
        }
    }

    public void setVariableValue(String str, V8Value v8Value) {
        AppMethodBeat.i(74904);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(v8Value);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74904);
        }
    }

    public void setVariableValue(String str, boolean z) {
        AppMethodBeat.i(74905);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(z);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74905);
        }
    }

    public void setVariableValue(String str, String str2) {
        AppMethodBeat.i(74906);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(str2);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74906);
        }
    }

    public void setVariableValue(String str, double d) {
        AppMethodBeat.i(74907);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(d);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74907);
        }
    }

    public ObjectMirror getScopeObject() {
        V8Object v8Object = null;
        AppMethodBeat.i(74908);
        try {
            v8Object = this.v8Object.executeObjectFunction(SCOPE_OBJECT, null);
            ObjectMirror objectMirror = (ObjectMirror) Mirror.createMirror(v8Object);
            return objectMirror;
        } finally {
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.o(74908);
        }
    }
}
