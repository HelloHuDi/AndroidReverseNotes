package com.eclipsesource.v8;

import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class MultiContextV8 {
    private final V8ContextSessionMgr contextSessionMgr;
    private final V8 v8;

    private MultiContextV8() {
        this(null);
    }

    private MultiContextV8(String str) {
        this(str, null, null);
    }

    private MultiContextV8(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(74976);
        this.v8 = V8.createV8Runtime(str, null, false, str2, bArr);
        this.contextSessionMgr = new V8ContextSessionMgr(getV8());
        AppMethodBeat.o(74976);
    }

    public static MultiContextV8 createMultiContextV8() {
        AppMethodBeat.i(74977);
        MultiContextV8 multiContextV8 = new MultiContextV8();
        AppMethodBeat.o(74977);
        return multiContextV8;
    }

    public static MultiContextV8 createMultiContextV8(String str) {
        AppMethodBeat.i(74978);
        MultiContextV8 multiContextV8 = new MultiContextV8(str);
        AppMethodBeat.o(74978);
        return multiContextV8;
    }

    public static MultiContextV8 createMultiContextV8(String str, byte[] bArr) {
        AppMethodBeat.i(74979);
        MultiContextV8 multiContextV8 = new MultiContextV8(null, str, bArr);
        AppMethodBeat.o(74979);
        return multiContextV8;
    }

    public static MultiContextV8 createMultiContextV8(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(74980);
        MultiContextV8 multiContextV8 = new MultiContextV8(str, str2, bArr);
        AppMethodBeat.o(74980);
        return multiContextV8;
    }

    public final V8Context createContext(int i) {
        AppMethodBeat.i(74981);
        V8Context context = new V8ContextWrapper(this, this.v8.createV8Context(i)).context();
        AppMethodBeat.o(74981);
        return context;
    }

    public final void release() {
        AppMethodBeat.i(74982);
        this.v8.release();
        AppMethodBeat.o(74982);
    }

    public final long getIsolatePtr() {
        AppMethodBeat.i(74983);
        long isolatePtr = this.v8.getIsolatePtr();
        AppMethodBeat.o(74983);
        return isolatePtr;
    }

    public final V8Locker getV8Locker() {
        AppMethodBeat.i(74984);
        V8Locker locker = this.v8.getLocker();
        AppMethodBeat.o(74984);
        return locker;
    }

    public final void waitForDebugger(String str) {
        AppMethodBeat.i(74985);
        this.v8.waitForDebugger(str);
        AppMethodBeat.o(74985);
    }

    public final void debuggerMessageLoop() {
        AppMethodBeat.i(74986);
        this.v8.debuggerMessageLoop();
        AppMethodBeat.o(74986);
    }

    public final void memoryPressureNotification(int i) {
        AppMethodBeat.i(74987);
        this.v8.memoryPressureNotification(i);
        AppMethodBeat.o(74987);
    }

    public final MemoryManager createMemoryManager() {
        AppMethodBeat.i(74988);
        MemoryManager memoryManager = new MemoryManager(this.v8);
        AppMethodBeat.o(74988);
        return memoryManager;
    }

    /* Access modifiers changed, original: protected|final */
    public final void enterContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.i(74989);
        this.contextSessionMgr.enterContext(v8ContextWrapper);
        AppMethodBeat.o(74989);
    }

    /* Access modifiers changed, original: protected|final */
    public final void releaseContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.i(74990);
        this.contextSessionMgr.releaseContext(v8ContextWrapper);
        AppMethodBeat.o(74990);
    }

    /* Access modifiers changed, original: protected|final */
    public final V8 getV8() {
        return this.v8;
    }
}
