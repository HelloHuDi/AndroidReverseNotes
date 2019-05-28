package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class NodeJS {
    private static final String GLOBAL = "global";
    private static final String NEXT_TICK = "nextTick";
    private static final String NODE = "node";
    private static final String PROCESS = "process";
    private static final String STARTUP_CALLBACK = "__run";
    private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
    private static final String STARTUP_SCRIPT_NAME = "startup";
    private static final String TMP_JS_EXT = ".js.tmp";
    private static final String VERSIONS = "versions";
    private String nodeVersion = null;
    private V8Function require;
    private V8 v8;

    /* renamed from: com.eclipsesource.v8.NodeJS$1 */
    static class AnonymousClass1 implements JavaVoidCallback {
        final /* synthetic */ NodeJS val$node;

        AnonymousClass1(NodeJS nodeJS) {
            this.val$node = nodeJS;
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.i(74991);
            V8Function v8Function = (V8Function) v8Array.get(0);
            try {
                NodeJS.access$000(this.val$node, v8Function.twin());
            } finally {
                v8Function.release();
                AppMethodBeat.o(74991);
            }
        }
    }

    static /* synthetic */ void access$000(NodeJS nodeJS, V8Function v8Function) {
        AppMethodBeat.i(75004);
        nodeJS.init(v8Function);
        AppMethodBeat.o(75004);
    }

    public static NodeJS createNodeJS() {
        AppMethodBeat.i(74993);
        NodeJS createNodeJS = createNodeJS(null);
        AppMethodBeat.o(74993);
        return createNodeJS;
    }

    public String getNodeVersion() {
        Throwable th;
        AppMethodBeat.i(74994);
        String str;
        if (this.nodeVersion != null) {
            str = this.nodeVersion;
            AppMethodBeat.o(74994);
            return str;
        }
        Releasable object;
        Releasable object2;
        try {
            object = this.v8.getObject(PROCESS);
            try {
                object2 = object.getObject(VERSIONS);
            } catch (Throwable th2) {
                th = th2;
                object2 = null;
            }
            try {
                this.nodeVersion = object2.getString(NODE);
                safeRelease(object);
                safeRelease(object2);
                str = this.nodeVersion;
                AppMethodBeat.o(74994);
                return str;
            } catch (Throwable th3) {
                th = th3;
                safeRelease(object);
                safeRelease(object2);
                AppMethodBeat.o(74994);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            object2 = null;
            object = null;
        }
    }

    public static NodeJS createNodeJS(File file) {
        AppMethodBeat.i(74995);
        V8 createV8Runtime = V8.createV8Runtime(GLOBAL);
        NodeJS nodeJS = new NodeJS(createV8Runtime);
        createV8Runtime.registerJavaMethod((JavaVoidCallback) new AnonymousClass1(nodeJS), STARTUP_CALLBACK);
        File createTemporaryScriptFile;
        try {
            createTemporaryScriptFile = createTemporaryScriptFile(STARTUP_SCRIPT, STARTUP_SCRIPT_NAME);
            createV8Runtime.createNodeRuntime(createTemporaryScriptFile.getAbsolutePath());
            createTemporaryScriptFile.delete();
            if (file != null) {
                nodeJS.exec(file);
            }
            AppMethodBeat.o(74995);
            return nodeJS;
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(74995);
            throw runtimeException;
        } catch (Throwable th) {
            createTemporaryScriptFile.delete();
            AppMethodBeat.o(74995);
        }
    }

    public V8 getRuntime() {
        return this.v8;
    }

    public boolean handleMessage() {
        AppMethodBeat.i(74996);
        this.v8.checkThread();
        boolean pumpMessageLoop = this.v8.pumpMessageLoop();
        AppMethodBeat.o(74996);
        return pumpMessageLoop;
    }

    public void release() {
        AppMethodBeat.i(74997);
        this.v8.checkThread();
        if (!this.require.isReleased()) {
            this.require.release();
        }
        if (!this.v8.isReleased()) {
            this.v8.release();
        }
        AppMethodBeat.o(74997);
    }

    public boolean isRunning() {
        AppMethodBeat.i(74998);
        this.v8.checkThread();
        boolean isRunning = this.v8.isRunning();
        AppMethodBeat.o(74998);
        return isRunning;
    }

    public V8Object require(File file) {
        AppMethodBeat.i(74999);
        this.v8.checkThread();
        V8Array v8Array = new V8Array(this.v8);
        try {
            v8Array.push(file.getAbsolutePath());
            V8Object v8Object = (V8Object) this.require.call(null, v8Array);
            return v8Object;
        } finally {
            v8Array.release();
            AppMethodBeat.o(74999);
        }
    }

    public void exec(File file) {
        Throwable th;
        AppMethodBeat.i(75000);
        V8Value createScriptExecutionCallback = createScriptExecutionCallback(file);
        Releasable object;
        Releasable v8Array;
        try {
            object = this.v8.getObject(PROCESS);
            try {
                v8Array = new V8Array(this.v8);
                try {
                    v8Array.push(createScriptExecutionCallback);
                    object.executeObjectFunction(NEXT_TICK, v8Array);
                    safeRelease(object);
                    safeRelease(v8Array);
                    safeRelease(createScriptExecutionCallback);
                    AppMethodBeat.o(75000);
                } catch (Throwable th2) {
                    th = th2;
                    safeRelease(object);
                    safeRelease(v8Array);
                    safeRelease(createScriptExecutionCallback);
                    AppMethodBeat.o(75000);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                v8Array = null;
                safeRelease(object);
                safeRelease(v8Array);
                safeRelease(createScriptExecutionCallback);
                AppMethodBeat.o(75000);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            v8Array = null;
            object = null;
        }
    }

    private V8Function createScriptExecutionCallback(final File file) {
        AppMethodBeat.i(75001);
        V8Function v8Function = new V8Function(this.v8, new JavaCallback() {
            public Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(74992);
                V8Array v8Array2 = new V8Array(NodeJS.this.v8);
                try {
                    v8Array2.push(file.getAbsolutePath());
                    Object call = NodeJS.this.require.call(null, v8Array2);
                    return call;
                } finally {
                    v8Array2.release();
                    AppMethodBeat.o(74992);
                }
            }
        });
        AppMethodBeat.o(75001);
        return v8Function;
    }

    private void safeRelease(Releasable releasable) {
        AppMethodBeat.i(75002);
        if (releasable != null) {
            releasable.release();
        }
        AppMethodBeat.o(75002);
    }

    private NodeJS(V8 v8) {
        this.v8 = v8;
    }

    private void init(V8Function v8Function) {
        this.require = v8Function;
    }

    private static File createTemporaryScriptFile(String str, String str2) {
        AppMethodBeat.i(75003);
        File createTempFile = File.createTempFile(str2, TMP_JS_EXT);
        PrintWriter printWriter = new PrintWriter(createTempFile, "UTF-8");
        try {
            printWriter.print(str);
            return createTempFile;
        } finally {
            printWriter.close();
            AppMethodBeat.o(75003);
        }
    }
}
