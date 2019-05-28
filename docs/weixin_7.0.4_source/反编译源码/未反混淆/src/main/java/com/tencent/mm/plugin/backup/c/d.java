package com.tencent.mm.plugin.backup.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.DatabaseUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static boolean jsA = false;
    private static int jsx = 0;
    private static int jsy = 1;
    private static int jsz = 2;
    private boolean eVT;
    private final int jqS;
    private final com.tencent.mm.plugin.backup.b.d jrF;
    private HashMap<String, Pair<Long, Long>> jsB;
    private a jsC;
    private boolean jsD;
    private int jsE;
    public boolean jsp = false;
    private final HashMap<String, String> jsq = aw.ZK().Yr().dry();
    private HashSet<String> jsr = new HashSet();
    private final int jss;
    private final long jst;
    private long jsu;
    private com.tencent.mm.plugin.backup.b.b.d jsv;
    private int jsw = jsx;
    private Object lock = new Object();

    class a {
        private long beginTime;
        private long jsG;
        boolean jsH;

        private a() {
            this.jsG = -1;
            this.jsH = false;
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final void begin() {
            AppMethodBeat.i(17199);
            if (com.tencent.mm.plugin.backup.h.d.aUr().aUs().eJN != null) {
                this.jsG = com.tencent.mm.plugin.backup.h.d.aUr().aUs().eJN.iV(Thread.currentThread().getId());
                this.jsH = true;
                this.beginTime = bo.anU();
            }
            AppMethodBeat.o(17199);
        }

        public final void end() {
            AppMethodBeat.i(17200);
            if (this.jsH && com.tencent.mm.plugin.backup.h.d.aUr().aUs().eJN != null) {
                com.tencent.mm.plugin.backup.h.d.aUr().aUs().eJN.mB(this.jsG);
                this.jsH = false;
            }
            AppMethodBeat.o(17200);
        }

        public final void aSR() {
            AppMethodBeat.i(17201);
            if (bo.gb(this.beginTime) > 500) {
                end();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
                begin();
                this.beginTime = bo.anU();
            }
            AppMethodBeat.o(17201);
        }
    }

    static /* synthetic */ int a(d dVar, String str, HashMap hashMap, HashMap hashMap2) {
        AppMethodBeat.i(17214);
        int a = dVar.a(str, hashMap, hashMap2);
        AppMethodBeat.o(17214);
        return a;
    }

    static /* synthetic */ a a(d dVar) {
        AppMethodBeat.i(17213);
        a aSK = dVar.aSK();
        AppMethodBeat.o(17213);
        return aSK;
    }

    static /* synthetic */ void o(d dVar) {
        AppMethodBeat.i(17216);
        dVar.aSM();
        AppMethodBeat.o(17216);
    }

    private a aSK() {
        AppMethodBeat.i(17202);
        if (this.jsC == null) {
            this.jsC = new a(this, (byte) 0);
        }
        a aVar = this.jsC;
        AppMethodBeat.o(17202);
        return aVar;
    }

    public d(com.tencent.mm.plugin.backup.b.d dVar, int i, com.tencent.mm.plugin.backup.b.b.d dVar2, int i2, boolean z, LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        AppMethodBeat.i(17203);
        this.jrF = dVar;
        this.jqS = i;
        this.jsv = dVar2;
        this.jss = i2;
        jsA = z;
        this.jst = DatabaseUtils.longForQuery(aw.ZK().Yr().fni.dvx(), "SELECT COUNT(*) FROM BackupRecoverMsgListDataId", null);
        this.jsB = c(linkedList, linkedList2);
        this.jsr.clear();
        this.jsu = 0;
        ab.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap size[%d], backupMode[%d], totalMsgList[%d], totalSession[%d], isQuickBackup[%b]", Integer.valueOf(this.jsq.size()), Integer.valueOf(i), Long.valueOf(this.jst), Integer.valueOf(i2), Boolean.valueOf(z));
        AppMethodBeat.o(17203);
    }

    private static HashMap<String, Pair<Long, Long>> c(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        AppMethodBeat.i(17204);
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
        AppMethodBeat.o(17204);
        return hashMap;
    }

    public final synchronized void aSL() {
        AppMethodBeat.i(17205);
        if (this.jsp) {
            ab.e("MicroMsg.BackupRecoverMerger", "hasStartMerge , return");
            AppMethodBeat.o(17205);
        } else {
            this.jsp = true;
            ab.i("MicroMsg.BackupRecoverMerger", "startMerge");
            this.jrF.aSv();
            com.tencent.mm.plugin.backup.h.d.aUr().aUu();
            ab.i("MicroMsg.BackupRecoverMerger", "backupStartMerge");
            b.pf(true);
            aSO();
            this.jsw = jsy;
            if (this.jqS == 1) {
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.TRUE);
            } else if (this.jqS == 2) {
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.TRUE);
            }
            ab.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp start, mergeState[%d], totalMsgList size[%d], msgListDataIdHashMap size[%d]", Integer.valueOf(this.jsw), Long.valueOf(this.jst), Integer.valueOf(this.jsq.size()));
            com.tencent.mm.sdk.g.d.a(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17198);
                    e.reset();
                    e.aST();
                    d.a(d.this).begin();
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    for (String str : d.this.jsq.keySet()) {
                        long j;
                        d.aSO();
                        String str2 = g.EZ(str) + str;
                        if (b.dnO()) {
                            d.a(d.this, str2, hashMap, hashMap2);
                            if (d.this.eVT) {
                                ab.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferMsgList[%d], recovering session num[%d]", str, Long.valueOf(d.this.jsu), Integer.valueOf(d.this.jss));
                                d.aSP();
                                d.a(d.this).end();
                                com.tencent.mm.plugin.backup.h.c.k(hashMap);
                                d.a(d.this, d.this.jsD, d.this.jsE);
                                AppMethodBeat.o(17198);
                                return;
                            }
                        }
                        try {
                            d.a(d.this, str2, hashMap, hashMap2);
                            if (d.this.eVT) {
                                ab.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferMsgList[%d], recovering session num[%d]", str, Long.valueOf(d.this.jsu), Integer.valueOf(d.this.jss));
                                d.aSP();
                                d.a(d.this).end();
                                com.tencent.mm.plugin.backup.h.c.k(hashMap);
                                d.a(d.this, d.this.jsD, d.this.jsE);
                                AppMethodBeat.o(17198);
                                return;
                            }
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.BackupRecoverMerger", e, "recoverFromSdcard MMThread.run():", new Object[0]);
                        }
                        d.this.jsr.add(d.this.jsq.get(str));
                        d.this.jsu = 1 + d.this.jsu;
                        d.this.jrF.aSu().jqW = 26;
                        e aSu = d.this.jrF.aSu();
                        if (d.this.jsu > d.this.jst) {
                            j = 100;
                        } else {
                            j = (d.this.jsu * 100) / d.this.jst;
                        }
                        aSu.jqZ = (int) j;
                        d.this.rl(26);
                        d.a(d.this).aSR();
                        d.aSP();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e2) {
                        }
                        ab.i("MicroMsg.BackupRecoverMerger", "msgDataId[%s] merge finish, transferMsgList[%d], transferSessions size[%d]", str, Long.valueOf(d.this.jsu), Integer.valueOf(d.this.jsr.size()));
                    }
                    d.this.rl(30);
                    com.tencent.mm.plugin.backup.h.c.k(hashMap);
                    ab.i("MicroMsg.BackupRecoverMerger", "readFromSdcard build temDB finish! transferMsgList[%d], totalMsgList[%d], transferSession[%d], totalSession[%d]", Long.valueOf(d.this.jsu), Long.valueOf(d.this.jst), Integer.valueOf(d.this.jsr.size()), Integer.valueOf(d.this.jss));
                    d.a(d.this).end();
                    if (b.dnO()) {
                        int e3;
                        long j2;
                        e aSu2 = d.this.jrF.aSu();
                        if (d.this.jsr.size() > d.this.jss) {
                            e3 = d.this.jss;
                        } else {
                            e3 = d.this.jsr.size();
                        }
                        aSu2.jqX = e3;
                        e aSu3 = d.this.jrF.aSu();
                        if (d.this.jsu > d.this.jst) {
                            j2 = 100;
                        } else {
                            j2 = (d.this.jsu * 100) / d.this.jst;
                        }
                        aSu3.jqZ = (int) j2;
                    } else {
                        d.this.jrF.aSu().jqX = d.this.jss;
                        d.this.jrF.aSu().jqZ = (int) ((d.this.jsu * 100) / d.this.jst);
                    }
                    d.this.jrF.aSu().jqY = d.this.jss;
                    ab.dot();
                    if (d.this.jsw != d.jsz) {
                        d.this.jsw = d.jsz;
                        d.aSN();
                        ab.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp backupRecoverCloseTempDb merge success, restart sync");
                        if (d.this.jqS == 1) {
                            aw.ZK();
                            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.FALSE);
                        } else if (d.this.jqS == 2) {
                            aw.ZK();
                            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.FALSE);
                        }
                        if (d.this.jsv != null) {
                            d.this.jsv.aSt();
                        }
                        aw.ZK().Yq().drx();
                        aw.ZK().Yr().drx();
                        d.this.jrF.aSu().O(27, d.this.jsr.size() > d.this.jss ? d.this.jss : d.this.jsr.size(), d.this.jss);
                        d.this.rl(27);
                        d.this.jsw = d.jsx;
                        d.o(d.this);
                        d.this.jrF.aSw();
                    }
                    AppMethodBeat.o(17198);
                }
            }, "BackupRecoverMerger_recoverFromSdcard", 1).start();
            AppMethodBeat.o(17205);
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
            r5 = (java.lang.String) com.tencent.mm.plugin.backup.h.d.aUr().aUs().Ry().get(2, null);
            r18 = com.tencent.mm.plugin.backup.h.d.aUr().aUs().XO();
            r12 = r8.vEB.wVI;
            r9 = r8.vEC.wVI;
     */
    /* JADX WARNING: Missing block: B:31:0x010e, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r12) != false) goto L_0x0116;
     */
    /* JADX WARNING: Missing block: B:33:0x0114, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r9) == false) goto L_0x0148;
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
            r12 = com.tencent.mm.loader.BuildConfig.COMMAND;
     */
    /* JADX WARNING: Missing block: B:37:0x0125, code skipped:
            r7[0] = r12;
     */
    /* JADX WARNING: Missing block: B:38:0x0128, code skipped:
            if (r9 != null) goto L_0x012d;
     */
    /* JADX WARNING: Missing block: B:39:0x012a, code skipped:
            r9 = com.tencent.mm.loader.BuildConfig.COMMAND;
     */
    /* JADX WARNING: Missing block: B:40:0x012d, code skipped:
            r7[1] = r9;
            com.tencent.mm.sdk.platformtools.ab.w(r5, r6, r7);
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", java.lang.Integer.valueOf(r8.jCt), r12, r9);
            r6 = com.tencent.mm.plugin.backup.h.d.aUr().aUs();
     */
    /* JADX WARNING: Missing block: B:48:0x016d, code skipped:
            if (r6.uin != 0) goto L_0x0188;
     */
    /* JADX WARNING: Missing block: B:49:0x016f, code skipped:
            r5 = new com.tencent.mm.model.b();
     */
    /* JADX WARNING: Missing block: B:51:0x017a, code skipped:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:52:0x017b, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BackupRecoverMerger", r5, "readFromSdcard recoverMsg err", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:54:?, code skipped:
            r6 = r6.jys;
            r19 = com.tencent.mm.plugin.backup.h.d.aUr().aUs().XM();
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
            r6 = com.tencent.mm.plugin.backup.b.g.Ko();
     */
    /* JADX WARNING: Missing block: B:72:0x01db, code skipped:
            if (r6.contains(r12) != false) goto L_0x01e3;
     */
    /* JADX WARNING: Missing block: B:74:0x01e1, code skipped:
            if (r6.contains(r9) == false) goto L_0x0213;
     */
    /* JADX WARNING: Missing block: B:75:0x01e3, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BackupMsgLogic", "recoverMsg hit the blockList: " + r12 + " " + r9);
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
            r9 = r18.Q(r6, r8.ptF);
     */
    /* JADX WARNING: Missing block: B:90:0x0245, code skipped:
            if (r9.field_msgId == 0) goto L_0x025f;
     */
    /* JADX WARNING: Missing block: B:91:0x0247, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupMsgLogic", "recoverMsg msg exist");
     */
    /* JADX WARNING: Missing block: B:92:0x0252, code skipped:
            r6 = r12;
     */
    /* JADX WARNING: Missing block: B:93:0x0254, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BackupMsgLogic", "recoverMsg drop the item server id < 0");
     */
    /* JADX WARNING: Missing block: B:95:0x0265, code skipped:
            if (r8.ptF == 0) goto L_0x026c;
     */
    /* JADX WARNING: Missing block: B:96:0x0267, code skipped:
            r9.eI(r8.ptF);
     */
    /* JADX WARNING: Missing block: B:97:0x026c, code skipped:
            r9.eL((long) r8.vJg);
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
            r9.eJ(r6);
            r9.hY(r8.vJi);
            r9.setType(r8.jCt);
            r6 = r19.aoO(r13);
     */
    /* JADX WARNING: Missing block: B:106:0x02ae, code skipped:
            if (r6 == null) goto L_0x02f3;
     */
    /* JADX WARNING: Missing block: B:108:0x02b6, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r6.field_username) != false) goto L_0x02f3;
     */
    /* JADX WARNING: Missing block: B:110:0x02bc, code skipped:
            if (r6.dsf() == false) goto L_0x02f3;
     */
    /* JADX WARNING: Missing block: B:111:0x02be, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BackupMsgLogic", "recoverMsg hit the blockList: ".concat(java.lang.String.valueOf(r13)));
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
            r9.hO(r6);
            r9.ju(r13);
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
            r24.put(r13, java.lang.Integer.valueOf(com.tencent.mm.sdk.platformtools.bo.a((java.lang.Integer) r24.get(r13), 0) + 1));
     */
    /* JADX WARNING: Missing block: B:126:0x0334, code skipped:
            r6 = com.tencent.mm.plugin.backup.f.c.aTz().rq(r8.jCt);
     */
    /* JADX WARNING: Missing block: B:127:0x033e, code skipped:
            if (r6 != null) goto L_0x034f;
     */
    /* JADX WARNING: Missing block: B:128:0x0340, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupMsgLogic", "recoverMsg unknown type");
     */
    /* JADX WARNING: Missing block: B:129:0x034b, code skipped:
            r6 = 0;
     */
    /* JADX WARNING: Missing block: B:130:0x034d, code skipped:
            r6 = 4;
     */
    /* JADX WARNING: Missing block: B:131:0x034f, code skipped:
            r6.a(r5, r8, r9);
     */
    /* JADX WARNING: Missing block: B:138:0x0022, code skipped:
            continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(String str, HashMap<String, Integer> hashMap, HashMap<String, LinkedList<Long>> hashMap2) {
        AppMethodBeat.i(17206);
        long anU = bo.anU();
        byte[] e = com.tencent.mm.vfs.e.e(str, 0, -1);
        try {
            gu guVar;
            com.tencent.mm.model.b bVar;
            gv gvVar = (gv) new gv().parseFrom(e);
            Iterator it = gvVar.jBw.iterator();
            while (it.hasNext()) {
                guVar = (gu) it.next();
                synchronized (this.lock) {
                    try {
                        if (this.eVT) {
                            ab.i("MicroMsg.BackupRecoverMerger", "backupImp canceled");
                            AppMethodBeat.o(17206);
                            return -1;
                        }
                    } finally {
                        while (true) {
                        }
                        bVar = 17206;
                        AppMethodBeat.o(17206);
                    }
                }
            }
            e.aSS();
            ab.i("MicroMsg.BackupRecoverMerger", "readFromSdcard merge item time[%d]", Long.valueOf(bo.gb(anU)));
            int size = gvVar.jBw.size();
            AppMethodBeat.o(17206);
            return size;
            e.rm(guVar.jCt);
            aSK().aSR();
            throw bVar;
        } catch (Exception e2) {
            Throwable th = e2;
            String str2 = "";
            try {
                com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str);
                str2 = ((str2 + bVar2.exists() + ",") + bVar2.canRead() + ",") + bVar2.length() + ".";
            } catch (Exception e3) {
            }
            String str3 = "MicroMsg.BackupRecoverMerger";
            String str4 = "read mmPath err %s [%s] buflen:%d %s,";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(e == null ? -1 : e.length);
            objArr[3] = th;
            ab.printErrStackTrace(str3, th, str4, objArr);
            AppMethodBeat.o(17206);
            return 0;
        }
    }

    public final void l(boolean z, int i) {
        AppMethodBeat.i(17207);
        synchronized (this.lock) {
            try {
                ab.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", Boolean.valueOf(z), Integer.valueOf(this.jsw), Integer.valueOf(i));
                this.eVT = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17207);
            }
        }
        this.jsD = z;
        this.jsE = i;
    }

    private void aSM() {
        AppMethodBeat.i(17208);
        this.jsp = false;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17208);
            }
        }
    }

    public final void rl(int i) {
        AppMethodBeat.i(17209);
        if (this.jsv != null) {
            this.jsv.rj(i);
        }
        AppMethodBeat.o(17209);
    }

    public static void aSN() {
        AppMethodBeat.i(17210);
        ab.i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
        com.tencent.mm.sdk.b.a.xxA.m(new bp());
        com.tencent.mm.sdk.b.a.xxA.m(new aa());
        com.tencent.mm.vfs.e.N(g.aSF(), true);
        com.tencent.mm.plugin.backup.h.a aUt = com.tencent.mm.plugin.backup.h.d.aUr().aUt();
        aUt.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17684);
                Iterator it = a.this.jyk.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                        String str = (String) aVar.obj;
                        ab.d("MicroMsg.BackupRecoverDelayData", "getContact:".concat(String.valueOf(str)));
                        com.tencent.mm.model.ao.a.flu.ai(str, "");
                    } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                        am.bYI().aiH((String) aVar.obj);
                    }
                }
                a.this.jyk.clear();
                AppMethodBeat.o(17684);
            }
        });
        aw.ZK();
        c.XO().bOA();
        com.tencent.mm.sdk.b.a.xxA.m(new qo());
        b.pf(false);
        AppMethodBeat.o(17210);
    }

    public static void aSO() {
        AppMethodBeat.i(17211);
        com.tencent.mm.plugin.backup.h.d.aUr().aUs().XO().QW("BACKUP_MERGE_LOCK");
        AppMethodBeat.o(17211);
    }

    public static void aSP() {
        AppMethodBeat.i(17212);
        com.tencent.mm.plugin.backup.h.d.aUr().aUs().XO().QX("BACKUP_MERGE_LOCK");
        AppMethodBeat.o(17212);
    }
}
