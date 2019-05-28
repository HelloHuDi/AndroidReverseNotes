package com.bumptech.glide.p086c.p088b.p785b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bumptech.glide.c.b.b.c */
final class C44984c {
    final Map<String, C17517a> aCX = new HashMap();
    final C25413b aCY = new C25413b();

    /* renamed from: com.bumptech.glide.c.b.b.c$a */
    static class C17517a {
        final Lock aCZ = new ReentrantLock();
        int aDa;

        C17517a() {
            AppMethodBeat.m2504i(91975);
            AppMethodBeat.m2505o(91975);
        }
    }

    /* renamed from: com.bumptech.glide.c.b.b.c$b */
    static class C25413b {
        final Queue<C17517a> aDb = new ArrayDeque();

        C25413b() {
            AppMethodBeat.m2504i(91976);
            AppMethodBeat.m2505o(91976);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: mV */
        public final C17517a mo42460mV() {
            C17517a c17517a;
            AppMethodBeat.m2504i(91977);
            synchronized (this.aDb) {
                try {
                    c17517a = (C17517a) this.aDb.poll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(91977);
                    }
                }
            }
            if (c17517a == null) {
                c17517a = new C17517a();
            }
            AppMethodBeat.m2505o(91977);
            return c17517a;
        }
    }

    C44984c() {
        AppMethodBeat.m2504i(91978);
        AppMethodBeat.m2505o(91978);
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: EliminatePhiNodes
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMerge(EliminatePhiNodes.java:114)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMergeInstructions(EliminatePhiNodes.java:68)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.visit(EliminatePhiNodes.java:31)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal$$Lambda$62/242951823.accept(Unknown Source)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at jadx.core.ProcessClass$$Lambda$65/1625142473.accept(Unknown Source)
        	at java.lang.Iterable.forEach(Unknown Source)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    final void release(java.lang.String r8) {
        /*
        r7 = this;
        r6 = 91979; // 0x1674b float:1.2889E-40 double:4.54437E-319;
        com.tencent.matrix.trace.core.AppMethodBeat.m2504i(r6);
        monitor-enter(r7);
        r0 = r7.aCX;	 Catch:{ all -> 0x0043 }
        r0 = r0.get(r8);	 Catch:{ all -> 0x0043 }
        r1 = "Argument must not be null";	 Catch:{ all -> 0x0043 }
        r0 = com.bumptech.glide.p095h.C8561i.m15217d(r0, r1);	 Catch:{ all -> 0x0043 }
        r0 = (com.bumptech.glide.p086c.p088b.p785b.C44984c.C17517a) r0;	 Catch:{ all -> 0x0043 }
        r1 = r0.aDa;	 Catch:{ all -> 0x0043 }
        if (r1 > 0) goto L_0x0049;	 Catch:{ all -> 0x0043 }
    L_0x001a:
        r1 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0043 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0043 }
        r3 = "Cannot release a lock that is not held, safeKey: ";	 Catch:{ all -> 0x0043 }
        r2.<init>(r3);	 Catch:{ all -> 0x0043 }
        r2 = r2.append(r8);	 Catch:{ all -> 0x0043 }
        r3 = ", interestedThreads: ";	 Catch:{ all -> 0x0043 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0043 }
        r0 = r0.aDa;	 Catch:{ all -> 0x0043 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0043 }
        r0 = r0.toString();	 Catch:{ all -> 0x0043 }
        r1.<init>(r0);	 Catch:{ all -> 0x0043 }
        r0 = 91979; // 0x1674b float:1.2889E-40 double:4.54437E-319;	 Catch:{ all -> 0x0043 }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r0);	 Catch:{ all -> 0x0043 }
        throw r1;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r0 = move-exception;	 Catch:{ all -> 0x0043 }
        monitor-exit(r7);	 Catch:{ all -> 0x0043 }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r6);
        throw r0;
    L_0x0049:
        r1 = r0.aDa;	 Catch:{ all -> 0x0043 }
        r1 = r1 + -1;	 Catch:{ all -> 0x0043 }
        r0.aDa = r1;	 Catch:{ all -> 0x0043 }
        r1 = r0.aDa;	 Catch:{ all -> 0x0043 }
        if (r1 != 0) goto L_0x00a8;	 Catch:{ all -> 0x0043 }
    L_0x0053:
        r1 = r7.aCX;	 Catch:{ all -> 0x0043 }
        r1 = r1.remove(r8);	 Catch:{ all -> 0x0043 }
        r1 = (com.bumptech.glide.p086c.p088b.p785b.C44984c.C17517a) r1;	 Catch:{ all -> 0x0043 }
        r2 = r1.equals(r0);	 Catch:{ all -> 0x0043 }
        if (r2 != 0) goto L_0x0093;	 Catch:{ all -> 0x0043 }
    L_0x0061:
        r2 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0043 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0043 }
        r4 = "Removed the wrong lock, expected to remove: ";	 Catch:{ all -> 0x0043 }
        r3.<init>(r4);	 Catch:{ all -> 0x0043 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x0043 }
        r3 = ", but actually removed: ";	 Catch:{ all -> 0x0043 }
        r0 = r0.append(r3);	 Catch:{ all -> 0x0043 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0043 }
        r1 = ", safeKey: ";	 Catch:{ all -> 0x0043 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0043 }
        r0 = r0.append(r8);	 Catch:{ all -> 0x0043 }
        r0 = r0.toString();	 Catch:{ all -> 0x0043 }
        r2.<init>(r0);	 Catch:{ all -> 0x0043 }
        r0 = 91979; // 0x1674b float:1.2889E-40 double:4.54437E-319;	 Catch:{ all -> 0x0043 }
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r0);	 Catch:{ all -> 0x0043 }
        throw r2;	 Catch:{ all -> 0x0043 }
    L_0x0093:
        r2 = r7.aCY;	 Catch:{ all -> 0x0043 }
        r3 = r2.aDb;	 Catch:{ all -> 0x0043 }
        monitor-enter(r3);	 Catch:{ all -> 0x0043 }
        r4 = r2.aDb;	 Catch:{ all -> 0x00b2 }
        r4 = r4.size();	 Catch:{ all -> 0x00b2 }
        r5 = 10;	 Catch:{ all -> 0x00b2 }
        if (r4 >= r5) goto L_0x00a7;	 Catch:{ all -> 0x00b2 }
    L_0x00a2:
        r2 = r2.aDb;	 Catch:{ all -> 0x00b2 }
        r2.offer(r1);	 Catch:{ all -> 0x00b2 }
    L_0x00a7:
        monitor-exit(r3);	 Catch:{ all -> 0x00b2 }
    L_0x00a8:
        monitor-exit(r7);	 Catch:{ all -> 0x0043 }
        r0 = r0.aCZ;
        r0.unlock();
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r6);
        return;
    L_0x00b2:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00b2 }
        r1 = 91979; // 0x1674b float:1.2889E-40 double:4.54437E-319;
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r1);	 Catch:{ all -> 0x0043 }
        throw r0;	 Catch:{ all -> 0x0043 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p086c.p088b.p785b.C44984c.release(java.lang.String):void");
    }
}
