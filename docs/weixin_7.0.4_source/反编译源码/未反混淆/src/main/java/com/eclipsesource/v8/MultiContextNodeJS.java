package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public final class MultiContextNodeJS {
    private static final String GLOBAL = "global";
    private static final String STARTUP_CALLBACK = "__run";
    private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
    private static final String STARTUP_SCRIPT_NAME = "startup";
    private static final String TMP_JS_EXT = ".js.tmp";
    private static IGetTmpFileDirectory sTmpFileDirectoryDelegate = new IGetTmpFileDirectory() {
        public final File getDirectory() {
            return null;
        }
    };
    private final V8Context mainContext;
    private final MultiContextV8 mv8;
    private V8Function require;

    /* renamed from: com.eclipsesource.v8.MultiContextNodeJS$1 */
    static class AnonymousClass1 implements JavaVoidCallback {
        final /* synthetic */ MultiContextNodeJS val$node;

        AnonymousClass1(MultiContextNodeJS multiContextNodeJS) {
            this.val$node = multiContextNodeJS;
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.i(74963);
            V8Function v8Function = (V8Function) v8Array.get(0);
            try {
                MultiContextNodeJS.access$000(this.val$node, v8Function.twin());
            } finally {
                v8Function.release();
                AppMethodBeat.o(74963);
            }
        }
    }

    public interface IGetTmpFileDirectory {
        File getDirectory();
    }

    static /* synthetic */ void access$000(MultiContextNodeJS multiContextNodeJS, V8Function v8Function) {
        AppMethodBeat.i(74974);
        multiContextNodeJS.init(v8Function);
        AppMethodBeat.o(74974);
    }

    public static MultiContextNodeJS createMultiContextNodeJS(int i) {
        AppMethodBeat.i(74964);
        MultiContextNodeJS createMultiContextNodeJS = createMultiContextNodeJS(i, null, null);
        AppMethodBeat.o(74964);
        return createMultiContextNodeJS;
    }

    public static MultiContextNodeJS createMultiContextNodeJS(int i, String str, byte[] bArr) {
        AppMethodBeat.i(74965);
        MultiContextV8 createMultiContextV8 = MultiContextV8.createMultiContextV8(GLOBAL, str, bArr);
        V8Context createContext = createMultiContextV8.createContext(i);
        MultiContextNodeJS multiContextNodeJS = new MultiContextNodeJS(createMultiContextV8, createContext);
        createContext.registerJavaMethod(new AnonymousClass1(multiContextNodeJS), STARTUP_CALLBACK);
        File createTemporaryScriptFile;
        try {
            createTemporaryScriptFile = createTemporaryScriptFile(STARTUP_SCRIPT, STARTUP_SCRIPT_NAME);
            if (!createMultiContextV8.getV8Locker().hasLock()) {
                createMultiContextV8.getV8Locker().acquire();
            }
            createMultiContextV8.getV8().createNodeRuntime(createTemporaryScriptFile.getAbsolutePath());
            createMultiContextV8.getV8Locker().release();
            createTemporaryScriptFile.delete();
            AppMethodBeat.o(74965);
            return multiContextNodeJS;
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(74965);
            throw runtimeException;
        } catch (Throwable th) {
            createTemporaryScriptFile.delete();
            AppMethodBeat.o(74965);
        }
    }

    public final V8Context getMainContext() {
        return this.mainContext;
    }

    public final MultiContextV8 getRuntime() {
        return this.mv8;
    }

    public final void wakeUpUVLoop() {
        AppMethodBeat.i(74966);
        this.mv8.getV8().wakeUpUVLoop();
        AppMethodBeat.o(74966);
    }

    public final void closeUVLoop() {
        AppMethodBeat.i(74967);
        this.mv8.getV8().closeUVLoop();
        AppMethodBeat.o(74967);
    }

    public final boolean handleMessage() {
        AppMethodBeat.i(74968);
        this.mv8.getV8().checkThread();
        boolean pumpMessageLoop = this.mv8.getV8().pumpMessageLoop();
        AppMethodBeat.o(74968);
        return pumpMessageLoop;
    }

    public final boolean isRunning() {
        AppMethodBeat.i(74969);
        this.mv8.getV8().checkThread();
        boolean isRunning = this.mv8.getV8().isRunning();
        AppMethodBeat.o(74969);
        return isRunning;
    }

    public final void release() {
        AppMethodBeat.i(74970);
        this.mv8.getV8().checkThread();
        if (!this.require.isReleased()) {
            this.require.release();
        }
        if (!this.mainContext.isReleased()) {
            this.mainContext.release();
        }
        this.mv8.release();
        AppMethodBeat.o(74970);
    }

    public final void waitForDebugger(String str) {
        AppMethodBeat.i(74971);
        this.mv8.waitForDebugger(str);
        AppMethodBeat.o(74971);
    }

    public final void debuggerMessageLoop() {
        AppMethodBeat.i(74972);
        this.mv8.debuggerMessageLoop();
        AppMethodBeat.o(74972);
    }

    private MultiContextNodeJS(MultiContextV8 multiContextV8, V8Context v8Context) {
        this.mv8 = multiContextV8;
        this.mainContext = v8Context;
    }

    private void init(V8Function v8Function) {
        this.require = v8Function;
    }

    private static File createTemporaryScriptFile(String str, String str2) {
        AppMethodBeat.i(74973);
        File createTempFile = File.createTempFile(str2, TMP_JS_EXT, sTmpFileDirectoryDelegate.getDirectory());
        PrintWriter printWriter = new PrintWriter(createTempFile, "UTF-8");
        try {
            printWriter.print(str);
            return createTempFile;
        } finally {
            printWriter.close();
            AppMethodBeat.o(74973);
        }
    }

    static {
        AppMethodBeat.i(74975);
        AppMethodBeat.o(74975);
    }

    public static void setGetTmpFileDirectoryDelegate(IGetTmpFileDirectory iGetTmpFileDirectory) {
        if (iGetTmpFileDirectory != null) {
            sTmpFileDirectoryDelegate = iGetTmpFileDirectory;
        }
    }
}
