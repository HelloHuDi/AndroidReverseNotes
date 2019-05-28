package com.eclipsesource.p097v8.utils;

import com.eclipsesource.p097v8.C45010V8;
import com.eclipsesource.p097v8.JavaVoidCallback;
import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* renamed from: com.eclipsesource.v8.utils.V8Executor */
public class V8Executor extends Thread {
    private Exception exception;
    private volatile boolean forceTerminating;
    private boolean longRunning;
    private String messageHandler;
    private LinkedList<String[]> messageQueue;
    private String result;
    private C45010V8 runtime;
    private final String script;
    private volatile boolean shuttingDown;
    private volatile boolean terminated;

    /* renamed from: com.eclipsesource.v8.utils.V8Executor$ExecutorTermination */
    class ExecutorTermination implements JavaVoidCallback {
        ExecutorTermination() {
        }

        public void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(75084);
            if (V8Executor.this.forceTerminating) {
                RuntimeException runtimeException = new RuntimeException("V8Thread Termination");
                AppMethodBeat.m2505o(75084);
                throw runtimeException;
            }
            AppMethodBeat.m2505o(75084);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 5, insn: 0x00d6: INVOKE  (r5 com.eclipsesource.v8.V8Array), (r7 java.lang.String) com.eclipsesource.v8.V8Array.push(java.lang.String):com.eclipsesource.v8.V8Array type: VIRTUAL, block:B:59:0x00d4, method: com.eclipsesource.v8.utils.V8Executor.run():void
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:162)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:133)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal$$Lambda$62/242951823.accept(Unknown Source)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    public void run() {
        /*
        r9 = this;
        r3 = 0;
        r8 = 75087; // 0x1254f float:1.05219E-40 double:3.7098E-319;
        com.tencent.matrix.trace.core.AppMethodBeat.m2504i(r8);
        monitor-enter(r9);
        r1 = com.eclipsesource.p097v8.C45010V8.createV8Runtime();	 Catch:{ all -> 0x00a4 }
        r9.runtime = r1;	 Catch:{ all -> 0x00a4 }
        r1 = r9.runtime;	 Catch:{ all -> 0x00a4 }
        r2 = new com.eclipsesource.v8.utils.V8Executor$ExecutorTermination;	 Catch:{ all -> 0x00a4 }
        r2.<init>();	 Catch:{ all -> 0x00a4 }
        r4 = "__j2v8__checkThreadTerminate";	 Catch:{ all -> 0x00a4 }
        r1.registerJavaMethod(r2, r4);	 Catch:{ all -> 0x00a4 }
        r1 = r9.runtime;	 Catch:{ all -> 0x00a4 }
        r9.setup(r1);	 Catch:{ all -> 0x00a4 }
        monitor-exit(r9);	 Catch:{ all -> 0x00a4 }
        r1 = r9.forceTerminating;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x005e;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.runtime;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r4 = "__j2v8__checkThreadTerminate();\n";	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2.<init>(r4);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r4 = r9.script;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = r2.append(r4);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = r2.toString();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r4 = r9.getName();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r5 = -1;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = r1.executeScript(r2, r4, r5);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r2 == 0) goto L_0x004a;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r2.toString();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r9.result = r1;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r2 instanceof com.eclipsesource.p097v8.Releasable;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x0055;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r0 = r2;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r0 = (com.eclipsesource.p097v8.Releasable) r0;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r0;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1.release();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r2 instanceof com.eclipsesource.p097v8.Releasable;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x005e;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = (com.eclipsesource.p097v8.Releasable) r2;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2.release();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.forceTerminating;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x0143;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.longRunning;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x0143;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        monitor-enter(r9);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.messageQueue;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.shuttingDown;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x0076;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r9.wait();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.messageQueue;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x0082;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.shuttingDown;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x0086;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.forceTerminating;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x00b0;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        monitor-exit(r9);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        monitor-enter(r9);
        r1 = r9.runtime;	 Catch:{ all -> 0x00aa }
        r1 = r1.getLocker();	 Catch:{ all -> 0x00aa }
        r1 = r1.hasLock();	 Catch:{ all -> 0x00aa }
        if (r1 == 0) goto L_0x009c;	 Catch:{ all -> 0x00aa }
        r1 = r9.runtime;	 Catch:{ all -> 0x00aa }
        r1.release();	 Catch:{ all -> 0x00aa }
        r1 = 0;	 Catch:{ all -> 0x00aa }
        r9.runtime = r1;	 Catch:{ all -> 0x00aa }
        r1 = 1;	 Catch:{ all -> 0x00aa }
        r9.terminated = r1;	 Catch:{ all -> 0x00aa }
        monitor-exit(r9);	 Catch:{ all -> 0x00aa }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        return;
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00a4 }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        throw r1;
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00aa }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        throw r1;
        monitor-exit(r9);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.messageQueue;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x005e;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.messageQueue;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = 0;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r1.remove(r2);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = (java.lang.String[]) r1;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r4 = new com.eclipsesource.v8.V8Array;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = r9.runtime;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r4.<init>(r2);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r5 = new com.eclipsesource.v8.V8Array;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = r9.runtime;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r5.<init>(r2);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r6 = r1.length;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = r3;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        if (r2 >= r6) goto L_0x0105;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r7 = r1[r2];	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r5.push(r7);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = r2 + 1;
        goto L_0x00d2;
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = 75087; // 0x1254f float:1.05219E-40 double:3.7098E-319;
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r2);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        throw r1;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = move-exception;
        r9.exception = r1;	 Catch:{ all -> 0x0117, all -> 0x0167 }
        monitor-enter(r9);
        r1 = r9.runtime;	 Catch:{ all -> 0x0117, all -> 0x0167 }
        r1 = r1.getLocker();	 Catch:{ all -> 0x0117, all -> 0x0167 }
        r1 = r1.hasLock();	 Catch:{ all -> 0x0117, all -> 0x0167 }
        if (r1 == 0) goto L_0x00fd;	 Catch:{ all -> 0x0117, all -> 0x0167 }
        r1 = r9.runtime;	 Catch:{ all -> 0x0117, all -> 0x0167 }
        r1.release();	 Catch:{ all -> 0x0117, all -> 0x0167 }
        r1 = 0;	 Catch:{ all -> 0x0117, all -> 0x0167 }
        r9.runtime = r1;	 Catch:{ all -> 0x0117, all -> 0x0167 }
        r1 = 1;	 Catch:{ all -> 0x0117, all -> 0x0167 }
        r9.terminated = r1;	 Catch:{ all -> 0x0117, all -> 0x0167 }
        monitor-exit(r9);	 Catch:{ all -> 0x0117, all -> 0x0167 }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        goto L_0x00a3;
        r4.push(r5);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1 = r9.runtime;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = r9.messageHandler;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r1.executeVoidFunction(r2, r4);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r5.release();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r4.release();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        goto L_0x005e;
        r1 = move-exception;
        monitor-enter(r9);
        r2 = r9.runtime;	 Catch:{ all -> 0x016d }
        r2 = r2.getLocker();	 Catch:{ all -> 0x016d }
        r2 = r2.hasLock();	 Catch:{ all -> 0x016d }
        if (r2 == 0) goto L_0x012d;	 Catch:{ all -> 0x016d }
        r2 = r9.runtime;	 Catch:{ all -> 0x016d }
        r2.release();	 Catch:{ all -> 0x016d }
        r2 = 0;	 Catch:{ all -> 0x016d }
        r9.runtime = r2;	 Catch:{ all -> 0x016d }
        r2 = 1;	 Catch:{ all -> 0x016d }
        r9.terminated = r2;	 Catch:{ all -> 0x016d }
        monitor-exit(r9);	 Catch:{ all -> 0x016d }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        throw r1;
        r1 = move-exception;
        r5.release();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r4.release();	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        r2 = 75087; // 0x1254f float:1.05219E-40 double:3.7098E-319;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r2);	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        throw r1;	 Catch:{ all -> 0x0135, all -> 0x00dc, Exception -> 0x00e5 }
        monitor-enter(r9);
        r1 = r9.runtime;	 Catch:{ all -> 0x0161 }
        r1 = r1.getLocker();	 Catch:{ all -> 0x0161 }
        r1 = r1.hasLock();	 Catch:{ all -> 0x0161 }
        if (r1 == 0) goto L_0x0158;	 Catch:{ all -> 0x0161 }
        r1 = r9.runtime;	 Catch:{ all -> 0x0161 }
        r1.release();	 Catch:{ all -> 0x0161 }
        r1 = 0;	 Catch:{ all -> 0x0161 }
        r9.runtime = r1;	 Catch:{ all -> 0x0161 }
        r1 = 1;	 Catch:{ all -> 0x0161 }
        r9.terminated = r1;	 Catch:{ all -> 0x0161 }
        monitor-exit(r9);	 Catch:{ all -> 0x0161 }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        goto L_0x00a3;
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0161 }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        throw r1;
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0117, all -> 0x0167 }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        throw r1;
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x016d }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r8);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.p097v8.utils.V8Executor.run():void");
    }

    public V8Executor(String str, boolean z, String str2) {
        AppMethodBeat.m2504i(75085);
        this.terminated = false;
        this.shuttingDown = false;
        this.forceTerminating = false;
        this.exception = null;
        this.messageQueue = new LinkedList();
        this.script = str;
        this.longRunning = z;
        this.messageHandler = str2;
        AppMethodBeat.m2505o(75085);
    }

    public V8Executor(String str) {
        this(str, false, null);
    }

    /* Access modifiers changed, original: protected */
    public void setup(C45010V8 c45010v8) {
    }

    public String getResult() {
        return this.result;
    }

    public void postMessage(String... strArr) {
        AppMethodBeat.m2504i(75086);
        synchronized (this) {
            try {
                this.messageQueue.add(strArr);
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(75086);
            }
        }
    }

    public boolean hasException() {
        return this.exception != null;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean hasTerminated() {
        return this.terminated;
    }

    public void forceTermination() {
        AppMethodBeat.m2504i(75088);
        synchronized (this) {
            try {
                this.forceTerminating = true;
                this.shuttingDown = true;
                if (this.runtime != null) {
                    this.runtime.terminateExecution();
                }
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(75088);
            }
        }
    }

    public void shutdown() {
        AppMethodBeat.m2504i(75089);
        synchronized (this) {
            try {
                this.shuttingDown = true;
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(75089);
            }
        }
    }

    public boolean isShuttingDown() {
        return this.shuttingDown;
    }

    public boolean isTerminating() {
        return this.forceTerminating;
    }
}
