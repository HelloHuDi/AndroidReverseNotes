package com.eclipsesource.p097v8;

import com.eclipsesource.p097v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.MultiContextV8 */
public final class MultiContextV8 {
    private final V8ContextSessionMgr contextSessionMgr;
    /* renamed from: v8 */
    private final C45010V8 f17722v8;

    private MultiContextV8() {
        this(null);
    }

    private MultiContextV8(String str) {
        this(str, null, null);
    }

    private MultiContextV8(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(74976);
        this.f17722v8 = C45010V8.createV8Runtime(str, null, false, str2, bArr);
        this.contextSessionMgr = new V8ContextSessionMgr(getV8());
        AppMethodBeat.m2505o(74976);
    }

    public static MultiContextV8 createMultiContextV8() {
        AppMethodBeat.m2504i(74977);
        MultiContextV8 multiContextV8 = new MultiContextV8();
        AppMethodBeat.m2505o(74977);
        return multiContextV8;
    }

    public static MultiContextV8 createMultiContextV8(String str) {
        AppMethodBeat.m2504i(74978);
        MultiContextV8 multiContextV8 = new MultiContextV8(str);
        AppMethodBeat.m2505o(74978);
        return multiContextV8;
    }

    public static MultiContextV8 createMultiContextV8(String str, byte[] bArr) {
        AppMethodBeat.m2504i(74979);
        MultiContextV8 multiContextV8 = new MultiContextV8(null, str, bArr);
        AppMethodBeat.m2505o(74979);
        return multiContextV8;
    }

    public static MultiContextV8 createMultiContextV8(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(74980);
        MultiContextV8 multiContextV8 = new MultiContextV8(str, str2, bArr);
        AppMethodBeat.m2505o(74980);
        return multiContextV8;
    }

    public final V8Context createContext(int i) {
        AppMethodBeat.m2504i(74981);
        V8Context context = new V8ContextWrapper(this, this.f17722v8.createV8Context(i)).context();
        AppMethodBeat.m2505o(74981);
        return context;
    }

    public final void release() {
        AppMethodBeat.m2504i(74982);
        this.f17722v8.release();
        AppMethodBeat.m2505o(74982);
    }

    public final long getIsolatePtr() {
        AppMethodBeat.m2504i(74983);
        long isolatePtr = this.f17722v8.getIsolatePtr();
        AppMethodBeat.m2505o(74983);
        return isolatePtr;
    }

    public final V8Locker getV8Locker() {
        AppMethodBeat.m2504i(74984);
        V8Locker locker = this.f17722v8.getLocker();
        AppMethodBeat.m2505o(74984);
        return locker;
    }

    public final void waitForDebugger(String str) {
        AppMethodBeat.m2504i(74985);
        this.f17722v8.waitForDebugger(str);
        AppMethodBeat.m2505o(74985);
    }

    public final void debuggerMessageLoop() {
        AppMethodBeat.m2504i(74986);
        this.f17722v8.debuggerMessageLoop();
        AppMethodBeat.m2505o(74986);
    }

    public final void memoryPressureNotification(int i) {
        AppMethodBeat.m2504i(74987);
        this.f17722v8.memoryPressureNotification(i);
        AppMethodBeat.m2505o(74987);
    }

    public final MemoryManager createMemoryManager() {
        AppMethodBeat.m2504i(74988);
        MemoryManager memoryManager = new MemoryManager(this.f17722v8);
        AppMethodBeat.m2505o(74988);
        return memoryManager;
    }

    /* Access modifiers changed, original: protected|final */
    public final void enterContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.m2504i(74989);
        this.contextSessionMgr.enterContext(v8ContextWrapper);
        AppMethodBeat.m2505o(74989);
    }

    /* Access modifiers changed, original: protected|final */
    public final void releaseContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.m2504i(74990);
        this.contextSessionMgr.releaseContext(v8ContextWrapper);
        AppMethodBeat.m2505o(74990);
    }

    /* Access modifiers changed, original: protected|final */
    public final C45010V8 getV8() {
        return this.f17722v8;
    }
}
