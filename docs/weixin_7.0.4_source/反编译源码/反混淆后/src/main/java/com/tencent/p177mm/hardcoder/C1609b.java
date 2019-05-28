package com.tencent.p177mm.hardcoder;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1607a.C1605b;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.hardcoder.b */
public final class C1609b implements Runnable {
    private Queue<Object> eDZ = new ConcurrentLinkedQueue();
    private C6588h eEa;
    private boolean eEb = false;
    private Thread thread = null;

    /* renamed from: com.tencent.mm.hardcoder.b$a */
    public static class C1608a {
        public final int[] eDR;
        public final List<C1605b> eEc;
        public final int eEd;
        public final int eEe;
        public final int eEf;
        public final long time;

        public C1608a(long j, List<C1605b> list, int i, int i2, int i3, int[] iArr) {
            this.time = j;
            this.eEc = list;
            this.eEd = i;
            this.eEe = i2;
            this.eEf = i3;
            this.eDR = iArr;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 16, insn: 0x027b: AGET  (r5 ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 ?[ARRAY]), (r5 int), block:B:63:0x027a, method: com.tencent.mm.hardcoder.b.run():void
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
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at jadx.core.ProcessClass$$Lambda$65/1625142473.accept(Unknown Source)
        	at java.lang.Iterable.forEach(Unknown Source)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    public final void run() {
        /*
        r24 = this;
        r4 = 93960; // 0x16f08 float:1.31666E-40 double:4.64224E-319;
        com.tencent.matrix.trace.core.AppMethodBeat.m2504i(r4);
        r4 = "HardCoder.HCPerfStatThread";
        r5 = "[oneliang]HCPerfStatThread start to run.";
        com.tencent.p177mm.hardcoder.C1611c.m3271i(r4, r5);
        r4 = java.lang.Thread.currentThread();
        r4 = r4.isInterrupted();
        if (r4 != 0) goto L_0x044f;
        r0 = r24;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r0.eDZ;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r4.isEmpty();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r4 != 0) goto L_0x0417;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r24;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r0.eDZ;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r4.poll();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4 instanceof com.tencent.p177mm.hardcoder.C1609b.C1608a;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x040c;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = (com.tencent.p177mm.hardcoder.C1609b.C1608a) r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r10 = r4.time;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r9 = r4.eEc;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r12 = r4.eEd;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r13 = r4.eEf;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r14 = r4.eDR;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = "HardCoder.HardCoderReporter";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = "[oneliang]save task status,time:%s,size:%s,cpu:%s,io:%s";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6 = 4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6[r7] = r8;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = r9.size();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6[r7] = r8;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = 2;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6[r7] = r8;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = 3;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6[r7] = r8;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        com.tencent.p177mm.hardcoder.C1611c.m3269d(r4, r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r24;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r0.eEa;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r15 = com.tencent.p177mm.hardcoder.C1615d.m3273a(r10, r4);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r16 = com.tencent.p177mm.hardcoder.C1621f.C1620b.m3279h(r15);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = com.tencent.p177mm.hardcoder.C1623g.m3283PF();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r4 != 0) goto L_0x045a;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = 2;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = new long[r4];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = {0, 0};	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6 = r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r9.size();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r8 >= r4) goto L_0x000f;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r9.get(r8);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = (com.tencent.p177mm.hardcoder.C1607a.C1605b) r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.mo5055PD();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x0376;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.lastUpdateTime;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r10 - r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.lastUpdateTime = r10;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = -1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r12 == r5) goto L_0x02ed;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = -2;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r12 != r5) goto L_0x02cc;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDP;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r4.eDN;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r5[r7];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r20 + r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (int) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5[r7] = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = -1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r13 == r5) goto L_0x0318;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = -2;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r13 != r5) goto L_0x0306;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDQ;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r4.eDO;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r5[r7];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18 + r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (int) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5[r7] = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r14 == 0) goto L_0x00db;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r14.length;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 <= 0) goto L_0x00db;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDR = r14;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.mo5055PD();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x0331;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDI;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r5[r7];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = com.tencent.p177mm.hardcoder.C1623g.m3286jr(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 != 0) goto L_0x0457;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 2;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = new long[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = {0, 0};	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.mo5055PD();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x0334;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDI;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r5[r17];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = com.tencent.p177mm.hardcoder.C1623g.m3287js(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = com.tencent.p177mm.hardcoder.C1623g.m3288jt(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.eDU;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r22 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1));	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 != 0) goto L_0x0115;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDU = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDS;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 != 0) goto L_0x011b;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDS = r7;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDT;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 != 0) goto L_0x0121;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDT = r6;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.eDU;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18 + r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = 2;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18 / r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDU = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r7 == 0) goto L_0x01c5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.mo5055PD();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x01c5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r7[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDS;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r5[r17];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18 - r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r7[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDS;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r22 = r5[r17];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r20 - r22;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18 + r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = (int) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDV = r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = "HardCoder.HardCoderReporter";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = "bindTidsId:";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17.<init>(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r4.mo5056PE();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r17.append(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = ", start jiffies:[";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r17.append(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.eDS;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r19 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18[r19];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r17.append(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = ",";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r17.append(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.eDS;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r19 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18[r19];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r17.append(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = "], end jiffies:[";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r17.append(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r7[r18];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r17.append(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = ",";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r17.append(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r7[r18];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r17.append(r18);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = "], sum thread jiffies:";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.eDV;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.toString();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        com.tencent.p177mm.hardcoder.C1611c.m3269d(r5, r7);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = com.tencent.p177mm.hardcoder.HardCoderJNI.isHcDebug();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x0272;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r6 == 0) goto L_0x0272;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.mo5055PD();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x0272;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r6[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDT;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r5[r7];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18 - r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r6[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDT;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r22 = r5[r7];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r20 - r22;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18 + r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDW = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = "HardCoder.HardCoderReporter";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = "bindTidsId:";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7.<init>(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r4.mo5056PE();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = ", process start jiffies:[";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.eDT;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r17[r18];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = ",";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.eDT;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r17[r18];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = "], process end jiffies:[";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r6[r17];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = ",";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r6[r17];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = "], sum process jiffies:";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.eDW;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r7.toString();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        com.tencent.p177mm.hardcoder.C1611c.m3269d(r5, r7);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDX;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 != 0) goto L_0x03aa;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDY;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 != 0) goto L_0x03aa;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r16[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r15.get(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 != 0) goto L_0x0337;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = "HardCoder.HCPerfStatThread";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = "cpuStatusMap dosn't contain core 0 : %d";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = r16[r8];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r6[r7] = r8;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        com.tencent.p177mm.hardcoder.C1611c.m3270e(r4, r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x000f;
        r4 = move-exception;
        r5 = "HardCoder.HCPerfStatThread";
        r6 = new java.lang.StringBuilder;
        r7 = "Performance status thread need to interrupt:";
        r6.<init>(r7);
        r4 = r4.getMessage();
        r4 = r6.append(r4);
        r4 = r4.toString();
        com.tencent.p177mm.hardcoder.C1611c.m3270e(r5, r4);
        r4 = java.lang.Thread.currentThread();
        r4.interrupt();
        r4 = 93960; // 0x16f08 float:1.31666E-40 double:4.64224E-319;
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r4);
        return;
        r4.eDN = r12;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDP;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r5[r12];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r7;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r20 + r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = (int) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5[r12] = r7;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x00ba;
        r4 = move-exception;
        r5 = "HardCoder.HCPerfStatThread";
        r6 = "run exception:";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.p177mm.hardcoder.C1611c.printErrStackTrace(r5, r4, r6, r7);
        goto L_0x000f;
        r5 = 0;
        r4.eDN = r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDP;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r4.eDN;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r5[r7];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r20 + r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (int) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5[r7] = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x00ba;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDO = r13;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDQ;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r5[r13];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r7;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18 + r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = (int) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5[r13] = r7;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x00d4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDO = r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDQ;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r4.eDO;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r5[r7];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r18 + r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (int) r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r17 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5[r7] = r17;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x00d4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x00e6;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x00ff;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = new com.tencent.mm.hardcoder.f$a;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r16[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r15.get(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = (com.tencent.p177mm.hardcoder.C1615d.C1612a) r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r5.eEq;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r16[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r15.get(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = (com.tencent.p177mm.hardcoder.C1615d.C1612a) r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r5.eEr;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r2 = r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7.<init>(r0, r2);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDX = r7;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r16[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 >= 0) goto L_0x037b;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = "HardCoder.HCPerfStatThread";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = "cluster one is unused?may be possible.";	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        com.tencent.p177mm.hardcoder.C1611c.m3270e(r5, r7);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDY = r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r8 + 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r8 = r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x0086;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = new com.tencent.mm.hardcoder.f$a;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r16[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r15.get(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = (com.tencent.p177mm.hardcoder.C1615d.C1612a) r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r5.eEq;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r16[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r15.get(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = (com.tencent.p177mm.hardcoder.C1615d.C1612a) r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r5.eEr;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r2 = r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7.<init>(r0, r2);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.eDY = r7;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x0376;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDX;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x03da;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7 = r4.eDX;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r16[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r15.get(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = (com.tencent.p177mm.hardcoder.C1615d.C1612a) r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r5.eEq;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r16[r5];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r15.get(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = (com.tencent.p177mm.hardcoder.C1615d.C1612a) r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r5.eEr;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r5;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r2 = r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r7.mo5075v(r0, r2);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDY;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x0376;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4.eDY;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r16[r4];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r15.get(r4);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = (com.tencent.p177mm.hardcoder.C1615d.C1612a) r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r4.eEq;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r18 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = 1;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r16[r4];	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r15.get(r4);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = (com.tencent.p177mm.hardcoder.C1615d.C1612a) r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r4.eEr;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = (long) r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r20 = r0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r18;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r2 = r20;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5.mo5075v(r0, r2);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x0376;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = r4 instanceof com.tencent.p177mm.hardcoder.C1607a.C1605b;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r5 == 0) goto L_0x000f;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = (com.tencent.p177mm.hardcoder.C1607a.C1605b) r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        com.tencent.p177mm.hardcoder.C1618e.m3276a(r4);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x000f;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        monitor-enter(r24);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r24;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r0.eEb;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r4 == 0) goto L_0x0435;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r24;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r0.thread;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r4 == 0) goto L_0x0435;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r24;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r0.thread;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4.interrupt();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r24;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0.thread = r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = 0;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r24;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0.eEb = r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r0 = r24;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r0.eDZ;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = r4.isEmpty();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        if (r4 == 0) goto L_0x044c;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r24.wait();	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x0435;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r4 = move-exception;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        monitor-exit(r24);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        r5 = 93960; // 0x16f08 float:1.31666E-40 double:4.64224E-319;
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r5);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        throw r4;	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        monitor-exit(r24);	 Catch:{ all -> 0x0443, InterruptedException -> 0x02a3, Exception -> 0x02de }
        goto L_0x000f;
        r4 = 93960; // 0x16f08 float:1.31666E-40 double:4.64224E-319;
        com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r4);
        goto L_0x02cb;
        r7 = r5;
        goto L_0x00f3;
        r6 = r4;
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p177mm.hardcoder.C1609b.run():void");
    }

    public C1609b(Context context) {
        AppMethodBeat.m2504i(93958);
        this.eEa = new C6588h(context);
        C6588h c6588h = this.eEa;
        if (C6588h.context == null) {
            c6588h.mo14805PH();
            AppMethodBeat.m2505o(93958);
            return;
        }
        c6588h.mo14804PG();
        AppMethodBeat.m2505o(93958);
    }

    public final synchronized void start() {
        AppMethodBeat.m2504i(93959);
        if (this.thread == null) {
            this.thread = new Thread(this);
            this.thread.setPriority(5);
            this.thread.start();
        }
        AppMethodBeat.m2505o(93959);
    }

    /* renamed from: an */
    public final void mo5059an(Object obj) {
        AppMethodBeat.m2504i(93961);
        if (this.eDZ != null) {
            synchronized (this) {
                try {
                    this.eDZ.add(obj);
                    notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93961);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(93961);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(93962);
        super.finalize();
        this.eDZ.clear();
        AppMethodBeat.m2505o(93962);
    }
}
