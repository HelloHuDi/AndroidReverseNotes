package com.tencent.p177mm.plugin.backup.p344c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C37786qo;
import com.tencent.p177mm.p230g.p231a.C45310bp;
import com.tencent.p177mm.p230g.p231a.C6458aa;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p1394h.C45747a;
import com.tencent.p177mm.plugin.backup.p1394h.C45747a.C386562;
import com.tencent.p177mm.plugin.backup.p1394h.C45748c;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19939d;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C42758e;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.C46545gv;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wcdb.DatabaseUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.c.d */
public final class C33689d {
    private static boolean jsA = false;
    private static int jsx = 0;
    private static int jsy = 1;
    private static int jsz = 2;
    private boolean eVT;
    private final int jqS;
    private final C38634d jrF;
    private HashMap<String, Pair<Long, Long>> jsB;
    private C27483a jsC;
    private boolean jsD;
    private int jsE;
    public boolean jsp = false;
    private final HashMap<String, String> jsq = C9638aw.m17190ZK().mo33890Yr().dry();
    private HashSet<String> jsr = new HashSet();
    private final int jss;
    private final long jst;
    private long jsu;
    private C19939d jsv;
    private int jsw = jsx;
    private Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.backup.c.d$a */
    class C27483a {
        private long beginTime;
        private long jsG;
        boolean jsH;

        private C27483a() {
            this.jsG = -1;
            this.jsH = false;
        }

        /* synthetic */ C27483a(C33689d c33689d, byte b) {
            this();
        }

        public final void begin() {
            AppMethodBeat.m2504i(17199);
            if (C38658d.aUr().aUs().eJN != null) {
                this.jsG = C38658d.aUr().aUs().eJN.mo15639iV(Thread.currentThread().getId());
                this.jsH = true;
                this.beginTime = C5046bo.anU();
            }
            AppMethodBeat.m2505o(17199);
        }

        public final void end() {
            AppMethodBeat.m2504i(17200);
            if (this.jsH && C38658d.aUr().aUs().eJN != null) {
                C38658d.aUr().aUs().eJN.mo15640mB(this.jsG);
                this.jsH = false;
            }
            AppMethodBeat.m2505o(17200);
        }

        public final void aSR() {
            AppMethodBeat.m2504i(17201);
            if (C5046bo.m7566gb(this.beginTime) > 500) {
                end();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
                begin();
                this.beginTime = C5046bo.anU();
            }
            AppMethodBeat.m2505o(17201);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.d$1 */
    class C336901 implements Runnable {
        C336901() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17198);
            C33691e.reset();
            C33691e.aST();
            C33689d.m55013a(C33689d.this).begin();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (String str : C33689d.this.jsq.keySet()) {
                long j;
                C33689d.aSO();
                String str2 = C38635g.m65502EZ(str) + str;
                if (C4872b.dnO()) {
                    C33689d.m55011a(C33689d.this, str2, hashMap, hashMap2);
                    if (C33689d.this.eVT) {
                        C4990ab.m7413e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferMsgList[%d], recovering session num[%d]", str, Long.valueOf(C33689d.this.jsu), Integer.valueOf(C33689d.this.jss));
                        C33689d.aSP();
                        C33689d.m55013a(C33689d.this).end();
                        C45748c.m84548k(hashMap);
                        C33689d.m55014a(C33689d.this, C33689d.this.jsD, C33689d.this.jsE);
                        AppMethodBeat.m2505o(17198);
                        return;
                    }
                }
                try {
                    C33689d.m55011a(C33689d.this, str2, hashMap, hashMap2);
                    if (C33689d.this.eVT) {
                        C4990ab.m7413e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferMsgList[%d], recovering session num[%d]", str, Long.valueOf(C33689d.this.jsu), Integer.valueOf(C33689d.this.jss));
                        C33689d.aSP();
                        C33689d.m55013a(C33689d.this).end();
                        C45748c.m84548k(hashMap);
                        C33689d.m55014a(C33689d.this, C33689d.this.jsD, C33689d.this.jsE);
                        AppMethodBeat.m2505o(17198);
                        return;
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.BackupRecoverMerger", e, "recoverFromSdcard MMThread.run():", new Object[0]);
                }
                C33689d.this.jsr.add(C33689d.this.jsq.get(str));
                C33689d.this.jsu = 1 + C33689d.this.jsu;
                C33689d.this.jrF.aSu().jqW = 26;
                C42758e aSu = C33689d.this.jrF.aSu();
                if (C33689d.this.jsu > C33689d.this.jst) {
                    j = 100;
                } else {
                    j = (C33689d.this.jsu * 100) / C33689d.this.jst;
                }
                aSu.jqZ = (int) j;
                C33689d.this.mo54248rl(26);
                C33689d.m55013a(C33689d.this).aSR();
                C33689d.aSP();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e2) {
                }
                C4990ab.m7417i("MicroMsg.BackupRecoverMerger", "msgDataId[%s] merge finish, transferMsgList[%d], transferSessions size[%d]", str, Long.valueOf(C33689d.this.jsu), Integer.valueOf(C33689d.this.jsr.size()));
            }
            C33689d.this.mo54248rl(30);
            C45748c.m84548k(hashMap);
            C4990ab.m7417i("MicroMsg.BackupRecoverMerger", "readFromSdcard build temDB finish! transferMsgList[%d], totalMsgList[%d], transferSession[%d], totalSession[%d]", Long.valueOf(C33689d.this.jsu), Long.valueOf(C33689d.this.jst), Integer.valueOf(C33689d.this.jsr.size()), Integer.valueOf(C33689d.this.jss));
            C33689d.m55013a(C33689d.this).end();
            if (C4872b.dnO()) {
                int e3;
                long j2;
                C42758e aSu2 = C33689d.this.jrF.aSu();
                if (C33689d.this.jsr.size() > C33689d.this.jss) {
                    e3 = C33689d.this.jss;
                } else {
                    e3 = C33689d.this.jsr.size();
                }
                aSu2.jqX = e3;
                C42758e aSu3 = C33689d.this.jrF.aSu();
                if (C33689d.this.jsu > C33689d.this.jst) {
                    j2 = 100;
                } else {
                    j2 = (C33689d.this.jsu * 100) / C33689d.this.jst;
                }
                aSu3.jqZ = (int) j2;
            } else {
                C33689d.this.jrF.aSu().jqX = C33689d.this.jss;
                C33689d.this.jrF.aSu().jqZ = (int) ((C33689d.this.jsu * 100) / C33689d.this.jst);
            }
            C33689d.this.jrF.aSu().jqY = C33689d.this.jss;
            C4990ab.dot();
            if (C33689d.this.jsw != C33689d.jsz) {
                C33689d.this.jsw = C33689d.jsz;
                C33689d.aSN();
                C4990ab.m7416i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp backupRecoverCloseTempDb merge success, restart sync");
                if (C33689d.this.jqS == 1) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.FALSE);
                } else if (C33689d.this.jqS == 2) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.FALSE);
                }
                if (C33689d.this.jsv != null) {
                    C33689d.this.jsv.aSt();
                }
                C9638aw.m17190ZK().mo33889Yq().drx();
                C9638aw.m17190ZK().mo33890Yr().drx();
                C33689d.this.jrF.aSu().mo68222O(27, C33689d.this.jsr.size() > C33689d.this.jss ? C33689d.this.jss : C33689d.this.jsr.size(), C33689d.this.jss);
                C33689d.this.mo54248rl(27);
                C33689d.this.jsw = C33689d.jsx;
                C33689d.m55029o(C33689d.this);
                C33689d.this.jrF.aSw();
            }
            AppMethodBeat.m2505o(17198);
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m55011a(C33689d c33689d, String str, HashMap hashMap, HashMap hashMap2) {
        AppMethodBeat.m2504i(17214);
        int a = c33689d.m55012a(str, hashMap, hashMap2);
        AppMethodBeat.m2505o(17214);
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ C27483a m55013a(C33689d c33689d) {
        AppMethodBeat.m2504i(17213);
        C27483a aSK = c33689d.aSK();
        AppMethodBeat.m2505o(17213);
        return aSK;
    }

    /* renamed from: o */
    static /* synthetic */ void m55029o(C33689d c33689d) {
        AppMethodBeat.m2504i(17216);
        c33689d.aSM();
        AppMethodBeat.m2505o(17216);
    }

    private C27483a aSK() {
        AppMethodBeat.m2504i(17202);
        if (this.jsC == null) {
            this.jsC = new C27483a(this, (byte) 0);
        }
        C27483a c27483a = this.jsC;
        AppMethodBeat.m2505o(17202);
        return c27483a;
    }

    public C33689d(C38634d c38634d, int i, C19939d c19939d, int i2, boolean z, LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        AppMethodBeat.m2504i(17203);
        this.jrF = c38634d;
        this.jqS = i;
        this.jsv = c19939d;
        this.jss = i2;
        jsA = z;
        this.jst = DatabaseUtils.longForQuery(C9638aw.m17190ZK().mo33890Yr().fni.dvx(), "SELECT COUNT(*) FROM BackupRecoverMsgListDataId", null);
        this.jsB = C33689d.m55016c(linkedList, linkedList2);
        this.jsr.clear();
        this.jsu = 0;
        C4990ab.m7417i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap size[%d], backupMode[%d], totalMsgList[%d], totalSession[%d], isQuickBackup[%b]", Integer.valueOf(this.jsq.size()), Integer.valueOf(i), Long.valueOf(this.jst), Integer.valueOf(i2), Boolean.valueOf(z));
        AppMethodBeat.m2505o(17203);
    }

    /* renamed from: c */
    private static HashMap<String, Pair<Long, Long>> m55016c(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        AppMethodBeat.m2504i(17204);
        HashMap hashMap = new HashMap();
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (longValue == 0) {
                    longValue = Long.MIN_VALUE;
                }
                if (!it.hasNext()) {
                    break;
                }
                long longValue2 = ((Long) it.next()).longValue();
                if (longValue2 == 0) {
                    longValue2 = Long.MAX_VALUE;
                }
                hashMap.put(str, new Pair(Long.valueOf(longValue), Long.valueOf(longValue2)));
            }
        }
        AppMethodBeat.m2505o(17204);
        return hashMap;
    }

    public final synchronized void aSL() {
        AppMethodBeat.m2504i(17205);
        if (this.jsp) {
            C4990ab.m7412e("MicroMsg.BackupRecoverMerger", "hasStartMerge , return");
            AppMethodBeat.m2505o(17205);
        } else {
            this.jsp = true;
            C4990ab.m7416i("MicroMsg.BackupRecoverMerger", "startMerge");
            this.jrF.aSv();
            C38658d.aUr().aUu();
            C4990ab.m7416i("MicroMsg.BackupRecoverMerger", "backupStartMerge");
            C4872b.m7238pf(true);
            C33689d.aSO();
            this.jsw = jsy;
            if (this.jqS == 1) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.TRUE);
            } else if (this.jqS == 2) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.TRUE);
            }
            C4990ab.m7417i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp start, mergeState[%d], totalMsgList size[%d], msgListDataIdHashMap size[%d]", Integer.valueOf(this.jsw), Long.valueOf(this.jst), Integer.valueOf(this.jsq.size()));
            C7305d.m12285a(new C336901(), "BackupRecoverMerger_recoverFromSdcard", 1).start();
            AppMethodBeat.m2505o(17205);
        }
    }

    /* JADX WARNING: Missing block: B:26:0x00d7, code skipped:
            if (jsA == false) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:28:0x00dc, code skipped:
            if (r8.jCt != 1) goto L_0x0022;
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            r7 = r22.jsB;
            r5 = (java.lang.String) com.tencent.p177mm.plugin.backup.p1394h.C38658d.aUr().aUs().mo61496Ry().get(2, null);
            r18 = com.tencent.p177mm.plugin.backup.p1394h.C38658d.aUr().aUs().mo61498XO();
            r12 = r8.vEB.wVI;
            r9 = r8.vEC.wVI;
     */
    /* JADX WARNING: Missing block: B:31:0x010e, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r12) != false) goto L_0x0116;
     */
    /* JADX WARNING: Missing block: B:33:0x0114, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r9) == false) goto L_0x0148;
     */
    /* JADX WARNING: Missing block: B:34:0x0116, code skipped:
            r5 = "MicroMsg.BackupMsgLogic";
            r6 = "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]";
            r7 = new java.lang.Object[2];
     */
    /* JADX WARNING: Missing block: B:35:0x0120, code skipped:
            if (r12 != null) goto L_0x0125;
     */
    /* JADX WARNING: Missing block: B:36:0x0122, code skipped:
            r12 = com.tencent.p177mm.loader.BuildConfig.COMMAND;
     */
    /* JADX WARNING: Missing block: B:37:0x0125, code skipped:
            r7[0] = r12;
     */
    /* JADX WARNING: Missing block: B:38:0x0128, code skipped:
            if (r9 != null) goto L_0x012d;
     */
    /* JADX WARNING: Missing block: B:39:0x012a, code skipped:
            r9 = com.tencent.p177mm.loader.BuildConfig.COMMAND;
     */
    /* JADX WARNING: Missing block: B:40:0x012d, code skipped:
            r7[1] = r9;
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7421w(r5, r6, r7);
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.BackupMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", java.lang.Integer.valueOf(r8.jCt), r12, r9);
            r6 = com.tencent.p177mm.plugin.backup.p1394h.C38658d.aUr().aUs();
     */
    /* JADX WARNING: Missing block: B:48:0x016d, code skipped:
            if (r6.uin != 0) goto L_0x0188;
     */
    /* JADX WARNING: Missing block: B:49:0x016f, code skipped:
            r5 = new com.tencent.p177mm.model.C1819b();
     */
    /* JADX WARNING: Missing block: B:51:0x017a, code skipped:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:52:0x017b, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.BackupRecoverMerger", r5, "readFromSdcard recoverMsg err", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:54:?, code skipped:
            r6 = r6.jys;
            r19 = com.tencent.p177mm.plugin.backup.p1394h.C38658d.aUr().aUs().mo61497XM();
     */
    /* JADX WARNING: Missing block: B:55:0x019a, code skipped:
            if (r6.has(r12) != false) goto L_0x01a2;
     */
    /* JADX WARNING: Missing block: B:57:0x01a0, code skipped:
            if (r5.equals(r12) == false) goto L_0x0206;
     */
    /* JADX WARNING: Missing block: B:58:0x01a2, code skipped:
            r14 = 1;
     */
    /* JADX WARNING: Missing block: B:59:0x01a4, code skipped:
            if (r14 == null) goto L_0x0209;
     */
    /* JADX WARNING: Missing block: B:60:0x01a6, code skipped:
            r13 = r9;
     */
    /* JADX WARNING: Missing block: B:62:0x01ad, code skipped:
            if (r8.vJh == 0) goto L_0x020b;
     */
    /* JADX WARNING: Missing block: B:63:0x01af, code skipped:
            r10 = r8.vJh;
     */
    /* JADX WARNING: Missing block: B:64:0x01b1, code skipped:
            if (r7 == null) goto L_0x01d3;
     */
    /* JADX WARNING: Missing block: B:65:0x01b3, code skipped:
            r6 = (android.util.Pair) r7.get(r13);
     */
    /* JADX WARNING: Missing block: B:66:0x01b9, code skipped:
            if (r6 == null) goto L_0x01d3;
     */
    /* JADX WARNING: Missing block: B:68:0x01c5, code skipped:
            if (r10 < ((java.lang.Long) r6.first).longValue()) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:70:0x01d1, code skipped:
            if (r10 > ((java.lang.Long) r6.second).longValue()) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:71:0x01d3, code skipped:
            r6 = com.tencent.p177mm.plugin.backup.p342b.C38635g.m65509Ko();
     */
    /* JADX WARNING: Missing block: B:72:0x01db, code skipped:
            if (r6.contains(r12) != false) goto L_0x01e3;
     */
    /* JADX WARNING: Missing block: B:74:0x01e1, code skipped:
            if (r6.contains(r9) == false) goto L_0x0213;
     */
    /* JADX WARNING: Missing block: B:75:0x01e3, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("MicroMsg.BackupMsgLogic", "recoverMsg hit the blockList: " + r12 + " " + r9);
     */
    /* JADX WARNING: Missing block: B:76:0x0206, code skipped:
            r14 = null;
     */
    /* JADX WARNING: Missing block: B:77:0x0209, code skipped:
            r13 = r12;
     */
    /* JADX WARNING: Missing block: B:78:0x020b, code skipped:
            r10 = ((long) r8.vIZ) * 1000;
     */
    /* JADX WARNING: Missing block: B:80:0x0219, code skipped:
            if (r8.ptF != 0) goto L_0x0224;
     */
    /* JADX WARNING: Missing block: B:82:0x021d, code skipped:
            if (r8.ptD == 0) goto L_0x0224;
     */
    /* JADX WARNING: Missing block: B:83:0x021f, code skipped:
            r8.ptF = (long) r8.ptD;
     */
    /* JADX WARNING: Missing block: B:85:0x022a, code skipped:
            if (r8.ptF == 0) goto L_0x0254;
     */
    /* JADX WARNING: Missing block: B:87:0x0230, code skipped:
            if (r5.equals(r12) == false) goto L_0x0252;
     */
    /* JADX WARNING: Missing block: B:88:0x0232, code skipped:
            r6 = r9;
     */
    /* JADX WARNING: Missing block: B:89:0x0233, code skipped:
            r9 = r18.mo15241Q(r6, r8.ptF);
     */
    /* JADX WARNING: Missing block: B:90:0x0245, code skipped:
            if (r9.field_msgId == 0) goto L_0x025f;
     */
    /* JADX WARNING: Missing block: B:91:0x0247, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.BackupMsgLogic", "recoverMsg msg exist");
     */
    /* JADX WARNING: Missing block: B:92:0x0252, code skipped:
            r6 = r12;
     */
    /* JADX WARNING: Missing block: B:93:0x0254, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("MicroMsg.BackupMsgLogic", "recoverMsg drop the item server id < 0");
     */
    /* JADX WARNING: Missing block: B:95:0x0265, code skipped:
            if (r8.ptF == 0) goto L_0x026c;
     */
    /* JADX WARNING: Missing block: B:96:0x0267, code skipped:
            r9.mo14774eI(r8.ptF);
     */
    /* JADX WARNING: Missing block: B:97:0x026c, code skipped:
            r9.mo14777eL((long) r8.vJg);
            r6 = (java.util.LinkedList) r25.get(r13);
     */
    /* JADX WARNING: Missing block: B:98:0x027a, code skipped:
            if (r6 == null) goto L_0x02e0;
     */
    /* JADX WARNING: Missing block: B:100:0x0280, code skipped:
            if (r6.size() <= 0) goto L_0x02e0;
     */
    /* JADX WARNING: Missing block: B:102:0x028e, code skipped:
            if (r10 == ((java.lang.Long) r6.getFirst()).longValue()) goto L_0x02d1;
     */
    /* JADX WARNING: Missing block: B:103:0x0290, code skipped:
            r6.clear();
     */
    /* JADX WARNING: Missing block: B:104:0x0293, code skipped:
            r6.add(java.lang.Long.valueOf(r10));
            r6 = r10;
     */
    /* JADX WARNING: Missing block: B:105:0x029b, code skipped:
            r9.mo14775eJ(r6);
            r9.mo14783hY(r8.vJi);
            r9.setType(r8.jCt);
            r6 = r19.aoO(r13);
     */
    /* JADX WARNING: Missing block: B:106:0x02ae, code skipped:
            if (r6 == null) goto L_0x02f3;
     */
    /* JADX WARNING: Missing block: B:108:0x02b6, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r6.field_username) != false) goto L_0x02f3;
     */
    /* JADX WARNING: Missing block: B:110:0x02bc, code skipped:
            if (r6.dsf() == false) goto L_0x02f3;
     */
    /* JADX WARNING: Missing block: B:111:0x02be, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("MicroMsg.BackupMsgLogic", "recoverMsg hit the blockList: ".concat(java.lang.String.valueOf(r13)));
     */
    /* JADX WARNING: Missing block: B:112:0x02d1, code skipped:
            r10 = ((java.lang.Long) r6.getLast()).longValue() + 1;
     */
    /* JADX WARNING: Missing block: B:113:0x02e0, code skipped:
            r6 = new java.util.LinkedList();
            r6.add(java.lang.Long.valueOf(r10));
            r25.put(r13, r6);
            r6 = r10;
     */
    /* JADX WARNING: Missing block: B:114:0x02f3, code skipped:
            if (r14 == null) goto L_0x034b;
     */
    /* JADX WARNING: Missing block: B:115:0x02f5, code skipped:
            r6 = 1;
     */
    /* JADX WARNING: Missing block: B:116:0x02f6, code skipped:
            r9.mo14781hO(r6);
            r9.mo14794ju(r13);
     */
    /* JADX WARNING: Missing block: B:117:0x02fc, code skipped:
            if (r14 == null) goto L_0x034d;
     */
    /* JADX WARNING: Missing block: B:118:0x02fe, code skipped:
            r6 = r8.vIY;
     */
    /* JADX WARNING: Missing block: B:119:0x0300, code skipped:
            r9.setStatus(r6);
     */
    /* JADX WARNING: Missing block: B:120:0x0309, code skipped:
            if (r24.get(r13) != null) goto L_0x0315;
     */
    /* JADX WARNING: Missing block: B:121:0x030b, code skipped:
            r24.put(r13, java.lang.Integer.valueOf(0));
     */
    /* JADX WARNING: Missing block: B:122:0x0315, code skipped:
            if (r14 != null) goto L_0x0334;
     */
    /* JADX WARNING: Missing block: B:124:0x031a, code skipped:
            if (r8.vIY != 3) goto L_0x0334;
     */
    /* JADX WARNING: Missing block: B:125:0x031c, code skipped:
            r24.put(r13, java.lang.Integer.valueOf(com.tencent.p177mm.sdk.platformtools.C5046bo.m7512a((java.lang.Integer) r24.get(r13), 0) + 1));
     */
    /* JADX WARNING: Missing block: B:126:0x0334, code skipped:
            r6 = com.tencent.p177mm.plugin.backup.p346f.C27486c.aTz().mo45286rq(r8.jCt);
     */
    /* JADX WARNING: Missing block: B:127:0x033e, code skipped:
            if (r6 != null) goto L_0x034f;
     */
    /* JADX WARNING: Missing block: B:128:0x0340, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.BackupMsgLogic", "recoverMsg unknown type");
     */
    /* JADX WARNING: Missing block: B:129:0x034b, code skipped:
            r6 = 0;
     */
    /* JADX WARNING: Missing block: B:130:0x034d, code skipped:
            r6 = 4;
     */
    /* JADX WARNING: Missing block: B:131:0x034f, code skipped:
            r6.mo35220a(r5, r8, r9);
     */
    /* JADX WARNING: Missing block: B:138:0x0022, code skipped:
            continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private int m55012a(String str, HashMap<String, Integer> hashMap, HashMap<String, LinkedList<Long>> hashMap2) {
        AppMethodBeat.m2504i(17206);
        long anU = C5046bo.anU();
        byte[] e = C5730e.m8632e(str, 0, -1);
        try {
            C40522gu c40522gu;
            C1819b c1819b;
            C46545gv c46545gv = (C46545gv) new C46545gv().parseFrom(e);
            Iterator it = c46545gv.jBw.iterator();
            while (it.hasNext()) {
                c40522gu = (C40522gu) it.next();
                synchronized (this.lock) {
                    try {
                        if (this.eVT) {
                            C4990ab.m7416i("MicroMsg.BackupRecoverMerger", "backupImp canceled");
                            AppMethodBeat.m2505o(17206);
                            return -1;
                        }
                    } finally {
                        while (true) {
                        }
                        c1819b = 17206;
                        AppMethodBeat.m2505o(17206);
                    }
                }
            }
            C33691e.aSS();
            C4990ab.m7417i("MicroMsg.BackupRecoverMerger", "readFromSdcard merge item time[%d]", Long.valueOf(C5046bo.m7566gb(anU)));
            int size = c46545gv.jBw.size();
            AppMethodBeat.m2505o(17206);
            return size;
            C33691e.m55032rm(c40522gu.jCt);
            aSK().aSR();
            throw c1819b;
        } catch (Exception e2) {
            Throwable th = e2;
            String str2 = "";
            try {
                C5728b c5728b = new C5728b(str);
                str2 = ((str2 + c5728b.exists() + ",") + c5728b.canRead() + ",") + c5728b.length() + ".";
            } catch (Exception e3) {
            }
            String str3 = "MicroMsg.BackupRecoverMerger";
            String str4 = "read mmPath err %s [%s] buflen:%d %s,";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(e == null ? -1 : e.length);
            objArr[3] = th;
            C4990ab.printErrStackTrace(str3, th, str4, objArr);
            AppMethodBeat.m2505o(17206);
            return 0;
        }
    }

    /* renamed from: l */
    public final void mo54247l(boolean z, int i) {
        AppMethodBeat.m2504i(17207);
        synchronized (this.lock) {
            try {
                C4990ab.m7417i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", Boolean.valueOf(z), Integer.valueOf(this.jsw), Integer.valueOf(i));
                this.eVT = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(17207);
            }
        }
        this.jsD = z;
        this.jsE = i;
    }

    private void aSM() {
        AppMethodBeat.m2504i(17208);
        this.jsp = false;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(17208);
            }
        }
    }

    /* renamed from: rl */
    public final void mo54248rl(int i) {
        AppMethodBeat.m2504i(17209);
        if (this.jsv != null) {
            this.jsv.mo6681rj(i);
        }
        AppMethodBeat.m2505o(17209);
    }

    public static void aSN() {
        AppMethodBeat.m2504i(17210);
        C4990ab.m7416i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
        C4879a.xxA.mo10055m(new C45310bp());
        C4879a.xxA.mo10055m(new C6458aa());
        C5730e.m8618N(C38635g.aSF(), true);
        C45747a aUt = C38658d.aUr().aUt();
        aUt.handler.post(new C386562());
        C9638aw.m17190ZK();
        C18628c.m29080XO().bOA();
        C4879a.xxA.mo10055m(new C37786qo());
        C4872b.m7238pf(false);
        AppMethodBeat.m2505o(17210);
    }

    public static void aSO() {
        AppMethodBeat.m2504i(17211);
        C38658d.aUr().aUs().mo61498XO().mo15242QW("BACKUP_MERGE_LOCK");
        AppMethodBeat.m2505o(17211);
    }

    public static void aSP() {
        AppMethodBeat.m2504i(17212);
        C38658d.aUr().aUs().mo61498XO().mo15243QX("BACKUP_MERGE_LOCK");
        AppMethodBeat.m2505o(17212);
    }
}
