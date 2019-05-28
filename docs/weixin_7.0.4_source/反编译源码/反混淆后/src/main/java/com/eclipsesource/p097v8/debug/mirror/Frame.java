package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.mirror.Frame */
public class Frame extends Mirror {
    private static final String ARGUMENT_COUNT = "argumentCount";
    private static final String ARGUMENT_NAME = "argumentName";
    private static final String ARGUMENT_VALUE = "argumentValue";
    private static final String COLUMN = "column";
    private static final String FUNC = "func";
    private static final String LINE = "line";
    private static final String LOCAL_COUNT = "localCount";
    private static final String LOCAL_NAME = "localName";
    private static final String LOCAL_VALUE = "localValue";
    private static final String NAME = "name";
    private static final String POSITION = "position";
    private static final String SCOPE = "scope";
    private static final String SCOPE_COUNT = "scopeCount";
    private static final String SCRIPT = "script";
    private static final String SOURCE_LOCATION = "sourceLocation";
    private static final String SOURCE_TEXT = "sourceText";

    public Frame(V8Object v8Object) {
        super(v8Object);
    }

    public int getScopeCount() {
        AppMethodBeat.m2504i(74858);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(SCOPE_COUNT, null);
        AppMethodBeat.m2505o(74858);
        return executeIntegerFunction;
    }

    public SourceLocation getSourceLocation() {
        AppMethodBeat.m2504i(74859);
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction(SOURCE_LOCATION, null);
        FunctionMirror function = getFunction();
        String scriptName = function.getScriptName();
        try {
            String str;
            V8Object v8Object = (V8Object) executeObjectFunction.get(SCRIPT);
            if (v8Object != null) {
                String string = v8Object.getString("name");
                v8Object.release();
                str = string;
            } else {
                Object str2 = null;
            }
            if (str2 != null || scriptName == null) {
                scriptName = "undefined";
            }
            SourceLocation sourceLocation = new SourceLocation(scriptName, executeObjectFunction.getInteger(POSITION), executeObjectFunction.getInteger(LINE), executeObjectFunction.getInteger(COLUMN), executeObjectFunction.getString(SOURCE_TEXT));
            return sourceLocation;
        } finally {
            function.release();
            executeObjectFunction.release();
            AppMethodBeat.m2505o(74859);
        }
    }

    public int getArgumentCount() {
        AppMethodBeat.m2504i(74860);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(ARGUMENT_COUNT, null);
        AppMethodBeat.m2505o(74860);
        return executeIntegerFunction;
    }

    public String getArgumentName(int i) {
        AppMethodBeat.m2504i(74861);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i);
        try {
            String executeStringFunction = this.v8Object.executeStringFunction(ARGUMENT_NAME, v8Array);
            return executeStringFunction;
        } finally {
            v8Array.release();
            AppMethodBeat.m2505o(74861);
        }
    }

    public ValueMirror getArgumentValue(int i) {
        AppMethodBeat.m2504i(74862);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i);
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction(ARGUMENT_VALUE, v8Array);
            if (Mirror.isValue(v8Object)) {
                ValueMirror valueMirror = new ValueMirror(v8Object);
                return valueMirror;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Argument value is not a ValueMirror");
            AppMethodBeat.m2505o(74862);
            throw illegalStateException;
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.m2505o(74862);
        }
    }

    public ValueMirror getLocalValue(int i) {
        AppMethodBeat.m2504i(74863);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i);
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction(LOCAL_VALUE, v8Array);
            if (Mirror.isValue(v8Object)) {
                ValueMirror createMirror = Mirror.createMirror(v8Object);
                return createMirror;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Local value is not a ValueMirror");
            AppMethodBeat.m2505o(74863);
            throw illegalStateException;
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.m2505o(74863);
        }
    }

    public int getLocalCount() {
        AppMethodBeat.m2504i(74864);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(LOCAL_COUNT, null);
        AppMethodBeat.m2505o(74864);
        return executeIntegerFunction;
    }

    public String getLocalName(int i) {
        AppMethodBeat.m2504i(74865);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i);
        try {
            String executeStringFunction = this.v8Object.executeStringFunction(LOCAL_NAME, v8Array);
            return executeStringFunction;
        } finally {
            v8Array.release();
            AppMethodBeat.m2505o(74865);
        }
    }

    public Scope getScope(int i) {
        AppMethodBeat.m2504i(74866);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i);
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction("scope", v8Array);
            Scope scope = new Scope(v8Object);
            return scope;
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.m2505o(74866);
        }
    }

    public FunctionMirror getFunction() {
        V8Object v8Object = null;
        AppMethodBeat.m2504i(74867);
        try {
            v8Object = this.v8Object.executeObjectFunction(FUNC, null);
            FunctionMirror functionMirror = new FunctionMirror(v8Object);
            return functionMirror;
        } finally {
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.m2505o(74867);
        }
    }

    public boolean isFrame() {
        return true;
    }
}
