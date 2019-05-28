package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.g.l;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class c {
    private int jqS;
    boolean jrD = false;
    com.tencent.mm.plugin.backup.b.b.b jrE;
    d jrF;
    long jrG = 0;
    public long jrH = 0;

    class c {
        a jrQ = new a(c.this, (byte) 0);
        LinkedBlockingQueue<Object> jsk = new LinkedBlockingQueue();
        ai jsl = new ai();
        b jsm = null;
        private Runnable jsn = new Runnable() {
            public final void run() {
                AppMethodBeat.i(17191);
                while (!c.this.jrD) {
                    ai aiVar = null;
                    try {
                        aiVar = c.this.jsk.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                    }
                    ab.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", Integer.valueOf(c.this.jsk.size()), aiVar);
                    if (aiVar != null) {
                        if (aiVar == c.this.jsl) {
                            c.this.jsl.open();
                            AppMethodBeat.o(17191);
                            return;
                        }
                        String str;
                        b bVar = (b) aiVar;
                        bVar.hkm = true;
                        StringBuilder stringBuilder = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
                        if (bVar.hkm) {
                            str = "S.";
                        } else {
                            str = "W.";
                        }
                        bVar.TAG = stringBuilder.append(str).append(bVar.jre).append(".").append(bVar.bCu).toString();
                        while (!c.this.jrD) {
                            Runnable runnable = null;
                            try {
                                runnable = (Runnable) bVar.jrP.poll(500, TimeUnit.MILLISECONDS);
                            } catch (Exception e2) {
                            }
                            if (runnable != null) {
                                int i;
                                long anU = bo.anU();
                                runnable.run();
                                String str2 = "MicroMsg.BackupPackAndSend.TagQueueSucker";
                                String str3 = "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]";
                                Object[] objArr = new Object[6];
                                objArr[0] = Integer.valueOf(bVar.jrP.size());
                                long j = c.this.jrQ.jrM.get();
                                String str4 = "[%s,%s,%s]";
                                Object[] objArr2 = new Object[3];
                                objArr2[0] = Long.valueOf(j);
                                if (j >= 8388608) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                objArr2[1] = Integer.valueOf(i);
                                if (j >= 16777216) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                objArr2[2] = Integer.valueOf(i);
                                objArr[1] = String.format(str4, objArr2);
                                objArr[2] = Long.valueOf(bo.gb(anU));
                                objArr[3] = runnable;
                                objArr[4] = bVar;
                                objArr[5] = c.this.jsm;
                                ab.d(str2, str3, objArr);
                                if (!bVar.hkm) {
                                    break;
                                }
                            }
                        }
                        System.gc();
                    }
                }
                AppMethodBeat.o(17191);
            }
        };

        public c() {
            AppMethodBeat.i(17192);
            com.tencent.mm.sdk.g.d.h(this.jsn, "tagRunnable").start();
            AppMethodBeat.o(17192);
        }
    }

    class b {
        String TAG;
        String bCu;
        boolean hkm;
        LinkedBlockingQueue<Runnable> jrP;
        a jrQ;
        private long jrR;
        String jrS;
        Vector<String> jrT;
        private Vector<gu> jrU;
        HashMap<Long, com.tencent.mm.plugin.backup.f.h.a> jrV;
        long jrW;
        private final com.tencent.mm.plugin.backup.g.c.b jrX;
        private final Runnable jrY;
        final Runnable jrZ;
        int jre;
        long jrg;
        long jrh;
        String talker;

        public final String toString() {
            return this.TAG;
        }

        public b(a aVar, com.tencent.mm.plugin.backup.b.f.a aVar2) {
            String displayName;
            AppMethodBeat.i(17187);
            this.TAG = "";
            this.jrP = new LinkedBlockingQueue();
            this.jrg = 0;
            this.jrh = 0;
            this.jrR = 0;
            this.jrS = "";
            this.jrT = new Vector();
            this.jrU = new Vector();
            this.jrV = new HashMap();
            this.jrW = 0;
            this.hkm = false;
            this.jrX = new com.tencent.mm.plugin.backup.g.c.b() {
                public final void g(boolean z, String str, int i) {
                    boolean z2;
                    AppMethodBeat.i(17176);
                    a aVar = b.this.jrQ;
                    long j = (long) i;
                    aVar.jrM.addAndGet(0 - j);
                    if (aVar.jrM.get() < 8388608) {
                        aVar.jrN.open();
                    }
                    if (aVar.jrM.get() < 16777216) {
                        aVar.jrO.open();
                    }
                    String str2 = "MicroMsg.BackupPackAndSend";
                    String str3 = "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]";
                    Object[] objArr = new Object[6];
                    objArr[0] = Long.valueOf(j);
                    objArr[1] = Long.valueOf(aVar.jrM.get());
                    if (aVar.jrM.get() >= 8388608) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[2] = Boolean.valueOf(z2);
                    if (aVar.jrM.get() >= 16777216) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[3] = Boolean.valueOf(z2);
                    objArr[4] = Boolean.valueOf(aVar.jrN.xzf);
                    objArr[5] = Boolean.valueOf(aVar.jrO.xzf);
                    ab.v(str2, str3, objArr);
                    c.this.jrG += (long) i;
                    ab.i(b.this.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", Integer.valueOf(i), Boolean.valueOf(z), str);
                    AppMethodBeat.o(17176);
                }
            };
            this.jrY = new Runnable() {
                public final String toString() {
                    AppMethodBeat.i(17182);
                    String str = b.this.TAG + ".reqBigFile";
                    AppMethodBeat.o(17182);
                    return str;
                }

                public final void run() {
                    boolean z = true;
                    AppMethodBeat.i(17183);
                    Assert.assertTrue(toString() + ", check running. ", b.this.hkm);
                    ab.i(b.this.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", Integer.valueOf(b.this.jrV.size()), Long.valueOf(bo.gb(b.this.jrW)), an.doQ());
                    String str = "BigFileMap should not Empty";
                    if (b.this.jrV.isEmpty()) {
                        z = false;
                    }
                    Assert.assertTrue(str, z);
                    new l(b.this.talker, b.this.jrV, new com.tencent.mm.plugin.backup.g.l.a() {
                        public final void D(final LinkedList<Long> linkedList) {
                            AppMethodBeat.i(17181);
                            com.tencent.mm.sdk.g.d.h(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(17180);
                                    int i = 0;
                                    while (linkedList != null && i < linkedList.size()) {
                                        Long l = (Long) linkedList.get(i);
                                        com.tencent.mm.plugin.backup.f.h.a aVar = (com.tencent.mm.plugin.backup.f.h.a) b.this.jrV.get(l);
                                        String str = b.this.TAG;
                                        String str2 = "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s";
                                        Object[] objArr = new Object[5];
                                        objArr[0] = Integer.valueOf(i);
                                        objArr[1] = Integer.valueOf(linkedList.size());
                                        objArr[2] = l;
                                        objArr[3] = aVar == null ? BuildConfig.COMMAND : aVar.jvy.cHr;
                                        objArr[4] = aVar == null ? BuildConfig.COMMAND : aVar.jvy.path;
                                        ab.i(str, str2, objArr);
                                        if (aVar != null) {
                                            b.this.jrT.add(aVar.jvy.cHr);
                                            b.this.m(aVar.jvy.cHr, aVar.jvy.path, true);
                                        }
                                        i++;
                                    }
                                    b.this.jrP.offer(b.this.jrZ);
                                    AppMethodBeat.o(17180);
                                }
                            }, "AddBigFileToQueue").start();
                            AppMethodBeat.o(17181);
                        }
                    }).aUc();
                    AppMethodBeat.o(17183);
                }
            };
            this.jrZ = new Runnable() {
                public final String toString() {
                    AppMethodBeat.i(17185);
                    String str = b.this.TAG + ".sendTag";
                    AppMethodBeat.o(17185);
                    return str;
                }

                public final void run() {
                    AppMethodBeat.i(17186);
                    Assert.assertTrue(toString() + ", check running. ", b.this.hkm);
                    int i;
                    e aSu;
                    switch (d.aSx()) {
                        case 1:
                            ab.i(b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", Integer.valueOf(c.this.jrF.aSu().jqX), Long.valueOf(b.this.jrg), Long.valueOf(b.this.jrh), Integer.valueOf(b.this.jrT.size()), b.this.bCu, b.this.jrS, Long.valueOf(bo.gb(b.this.jrW)));
                            if (c.this.jrF.aSu().jqX < b.this.jre + 1) {
                                i = c.this.jrF.aSu().jqY;
                                aSu = c.this.jrF.aSu();
                                if (b.this.jre + 1 <= i) {
                                    i = b.this.jre + 1;
                                }
                                aSu.jqX = i;
                                c.this.jrE.rj(c.this.jrF.aSu().jqW);
                                break;
                            }
                            break;
                        case 21:
                        case 22:
                            ab.i(b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", Integer.valueOf(c.this.jrF.aSu().jqX), Long.valueOf(b.this.jrg), Long.valueOf(b.this.jrh), Integer.valueOf(b.this.jrT.size()), b.this.bCu, b.this.jrS, Long.valueOf(bo.gb(b.this.jrW)));
                            if (c.this.jrF.aSu().jqX < b.this.jre + 1) {
                                i = c.this.jrF.aSu().jqY;
                                aSu = c.this.jrF.aSu();
                                if (b.this.jre + 1 <= i) {
                                    i = b.this.jre + 1;
                                }
                                aSu.jqX = i;
                                c.this.jrE.rj(c.this.jrF.aSu().jqW);
                                break;
                            }
                            break;
                    }
                    final boolean z = b.this.jre == c.this.jrF.aSu().jqY + -1;
                    final ai aiVar = new ai(!z);
                    new com.tencent.mm.plugin.backup.g.d(b.this.talker, b.this.jrg, b.this.jrh, b.this.jrS, b.this.bCu, new LinkedList(b.this.jrT), new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(17184);
                            ab.i(b.this.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", Boolean.valueOf(z), aiVar, Integer.valueOf(i), Integer.valueOf(i2), str, b.this.jrS, ((com.tencent.mm.plugin.backup.g.d) mVar).jxy.jCG);
                            if (z && b.this.jrS.equals(r0)) {
                                aiVar.open();
                            }
                            AppMethodBeat.o(17184);
                        }
                    }).aUc();
                    if (z) {
                        ab.w(b.this.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", Integer.valueOf(b.this.jre), Integer.valueOf(c.this.jrF.aSu().jqY - 1));
                        aiVar.block();
                    }
                    b.this.hkm = false;
                    AppMethodBeat.o(17186);
                }
            };
            this.jrW = bo.anU();
            this.jrQ = aVar;
            this.talker = aVar2.jrd;
            this.jre = aVar2.jre;
            if (t.kH(this.talker)) {
                displayName = s.getDisplayName(this.talker, this.talker);
            } else {
                displayName = s.mJ(this.talker);
            }
            this.bCu = displayName;
            this.TAG = "MicroMsg.BackupPackAndSend.tag." + (this.hkm ? "S." : "W.") + this.jre + "." + this.bCu;
            ab.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", Integer.valueOf(this.jre), this.bCu, this.talker, an.doQ());
            AppMethodBeat.o(17187);
        }

        public final boolean a(gu guVar, long j, long j2, LinkedList<u> linkedList, HashMap<Long, com.tencent.mm.plugin.backup.f.h.a> hashMap) {
            AppMethodBeat.i(17188);
            this.jrU.add(guVar);
            this.jrR = (j > 0 ? j : 0) + this.jrR;
            if (this.jrg == 0) {
                this.jrg = j2;
            }
            this.jrh = j2;
            this.jrV.putAll(hashMap);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                m(uVar.cHr, uVar.path, false);
            }
            ab.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", Long.valueOf(this.jrg), Long.valueOf(this.jrh), Long.valueOf(j), Long.valueOf(this.jrR), Integer.valueOf(this.jrU.size()), Integer.valueOf(linkedList.size()), Long.valueOf(bo.gb(this.jrW)));
            if (this.jrR > 83886080 || this.jrU.size() > 80) {
                aSJ();
                AppMethodBeat.o(17188);
                return true;
            }
            AppMethodBeat.o(17188);
            return false;
        }

        public final void aSJ() {
            AppMethodBeat.i(17189);
            this.jrS = "MSG_" + this.jrU.size() + "_" + this.talker + "_" + bo.anU();
            ab.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", Long.valueOf(this.jrg), Long.valueOf(this.jrh), Long.valueOf(this.jrR), Integer.valueOf(this.jrU.size()), Integer.valueOf(this.jrV.size()), this.jrS, Long.valueOf(bo.gb(this.jrW)));
            if (this.jrU.size() > 0) {
                m(this.jrS, null, false);
                if (this.jrV.isEmpty()) {
                    this.jrP.offer(this.jrZ);
                    AppMethodBeat.o(17189);
                    return;
                }
                this.jrP.offer(this.jrY);
                AppMethodBeat.o(17189);
                return;
            }
            ab.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", Integer.valueOf(this.jrU.size()), Integer.valueOf(this.jrT.size()), Integer.valueOf(this.jrV.size()));
            Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.jrU.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.jrT.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.jrV.isEmpty());
            this.jrP.offer(this.jrZ);
            AppMethodBeat.o(17189);
        }

        /* Access modifiers changed, original: final */
        public final void m(String str, String str2, boolean z) {
            boolean z2 = true;
            AppMethodBeat.i(17190);
            com.tencent.mm.plugin.backup.g.c.c anonymousClass2 = new com.tencent.mm.plugin.backup.g.c.c() {
                public final void a(com.tencent.mm.plugin.backup.g.c cVar) {
                    final com.tencent.mm.plugin.backup.g.c cVar2;
                    AppMethodBeat.i(17179);
                    final long anU = bo.anU();
                    a aVar = b.this.jrQ;
                    long aUj = (long) cVar.aUj();
                    boolean z = b.this.hkm;
                    String str = "MicroMsg.BackupPackAndSend";
                    String str2 = "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]";
                    Object[] objArr = new Object[5];
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Long.valueOf(aUj);
                    objArr[2] = Long.valueOf(aVar.jrM.get());
                    objArr[3] = Boolean.valueOf(aVar.jrM.get() >= 8388608);
                    objArr[4] = Boolean.valueOf(aVar.jrM.get() >= 16777216);
                    ab.v(str, str2, objArr);
                    if (aVar.jrM.get() + aUj >= 8388608) {
                        aVar.jrN.close();
                    }
                    if (aVar.jrM.get() >= 16777216) {
                        aVar.jrO.close();
                    }
                    long anU2 = bo.anU();
                    while (!c.this.jrD) {
                        if (aVar.jrM.get() < (z ? 16777216 : 8388608)) {
                            aVar.jrM.addAndGet(aUj);
                            str = "MicroMsg.BackupPackAndSend";
                            String str3 = "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]";
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = Long.valueOf(bo.gb(anU2));
                            objArr2[1] = Boolean.valueOf(z);
                            objArr2[2] = Long.valueOf(aUj);
                            objArr2[3] = Long.valueOf(aVar.jrM.get());
                            objArr2[4] = Boolean.valueOf(aVar.jrM.get() >= 8388608);
                            objArr2[5] = Boolean.valueOf(aVar.jrM.get() >= 16777216);
                            ab.v(str, str3, objArr2);
                            cVar2 = cVar;
                            b.this.jrP.offer(new Runnable() {
                                public final String toString() {
                                    AppMethodBeat.i(17177);
                                    String str = b.this.TAG + ".sendFile";
                                    AppMethodBeat.o(17177);
                                    return str;
                                }

                                public final void run() {
                                    AppMethodBeat.i(17178);
                                    Assert.assertTrue(toString() + ", check running. ", b.this.hkm);
                                    long anU = bo.anU();
                                    cVar2.aUc();
                                    long anU2 = bo.anU();
                                    ab.i(b.this.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", Integer.valueOf(cVar2.aUj()), Long.valueOf(anU2 - anU), Long.valueOf(anU2 - anU), cVar2.jxp.jCx);
                                    AppMethodBeat.o(17178);
                                }
                            });
                            AppMethodBeat.o(17179);
                        }
                        (z ? aVar.jrO : aVar.jrN).doJ();
                    }
                    cVar2 = cVar;
                    b.this.jrP.offer(/* anonymous class already generated */);
                    AppMethodBeat.o(17179);
                }
            };
            ab.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", Boolean.valueOf(z), Integer.valueOf(this.jrU.size()), str, str2);
            if (TextUtils.isEmpty(str2)) {
                String str3 = "chatMsgList should not empty";
                if (this.jrU.isEmpty()) {
                    z2 = false;
                }
                Assert.assertTrue(str3, z2);
                if (str != null) {
                    com.tencent.mm.plugin.backup.g.c.a(this.jrX, anonymousClass2, str, new LinkedList(this.jrU), c.this.jrF.jqU);
                }
            } else {
                this.jrT.add(str);
                if (str != null) {
                    com.tencent.mm.plugin.backup.g.c.a(this.jrX, anonymousClass2, str, str2, c.this.jrF.jqU);
                    AppMethodBeat.o(17190);
                    return;
                }
            }
            AppMethodBeat.o(17190);
        }
    }

    class a {
        volatile AtomicLong jrM;
        ai jrN;
        ai jrO;

        private a() {
            AppMethodBeat.i(17175);
            this.jrM = new AtomicLong(0);
            this.jrN = new ai(true);
            this.jrO = new ai(true);
            AppMethodBeat.o(17175);
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }
    }

    public c(d dVar, int i, com.tencent.mm.plugin.backup.b.b.b bVar) {
        this.jrF = dVar;
        this.jqS = i;
        this.jrE = bVar;
        this.jrD = false;
    }

    public final void cancel() {
        AppMethodBeat.i(17193);
        ab.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", an.doQ());
        this.jrD = true;
        AppMethodBeat.o(17193);
    }

    public final long aSH() {
        return this.jrG / 1024;
    }

    public final void fj(boolean z) {
        AppMethodBeat.i(17194);
        ab.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
        if (this.jqS == 1) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE);
        } else if (this.jqS == 2) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.FALSE);
        }
        Editor edit = d.aSz().edit();
        edit.putString("BACKUP_PC_CHOOSE_SESSION", null);
        if (z) {
            if (this.jqS == 1) {
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
            } else if (this.jqS == 2) {
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
            }
        }
        edit.commit();
        AppMethodBeat.o(17194);
    }

    public final void aSI() {
        AppMethodBeat.i(17195);
        ab.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
        com.tencent.mm.plugin.backup.i.d dVar = new com.tencent.mm.plugin.backup.i.d();
        dVar.ID = this.jrF.jqO;
        try {
            com.tencent.mm.plugin.backup.g.b.K(dVar.toByteArray(), 8);
            AppMethodBeat.o(17195);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "BackupFinishRequest to buf err.", new Object[0]);
            AppMethodBeat.o(17195);
        }
    }

    public final void a(LinkedList<com.tencent.mm.plugin.backup.b.f.a> linkedList, long j, boolean z) {
        AppMethodBeat.i(17196);
        String str = "MicroMsg.BackupPackAndSend";
        String str2 = "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Long.valueOf(j);
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        final LinkedList<com.tencent.mm.plugin.backup.b.f.a> linkedList2 = linkedList;
        final long j2 = j;
        final boolean z2 = z;
        com.tencent.mm.sdk.g.d.a(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17174);
                if (linkedList2 == null) {
                    ab.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
                    if (c.this.jrE != null) {
                        c.this.jrE.aSr();
                        c.this.jrF.aSu().jqW = -21;
                        c.this.jrE.rj(-21);
                    }
                    AppMethodBeat.o(17174);
                    return;
                }
                int i;
                com.tencent.mm.plugin.backup.g.b.aTW();
                LinkedList linkedList = linkedList2;
                HashSet hashSet = new HashSet();
                if (linkedList == null) {
                    i = 0;
                } else {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        hashSet.add(((com.tencent.mm.plugin.backup.b.f.a) it.next()).jrd);
                    }
                    i = hashSet.size();
                }
                c.this.jrF.aSu().O(14, 1, i);
                c.this.jrE.rj(14);
                String str = (String) com.tencent.mm.plugin.backup.h.d.aUr().aUs().Ry().get(2, null);
                c.this.jrH = bo.anU();
                c cVar = new c();
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    c.this.a((com.tencent.mm.plugin.backup.b.f.a) it2.next(), cVar, str, j2, z2);
                    if (c.this.jrD) {
                        break;
                    }
                }
                if (c.this.jrD) {
                    ab.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
                    AppMethodBeat.o(17174);
                    return;
                }
                long anU = bo.anU();
                long anU2 = bo.anU();
                cVar.jsk.offer(cVar.jsl);
                cVar.jsl.block();
                ab.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", Long.valueOf(bo.gb(anU2)));
                Assert.assertTrue(cVar.jsk.isEmpty());
                ab.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", Integer.valueOf(linkedList2.size()), Long.valueOf(bo.gb(c.this.jrH)), Long.valueOf(bo.gb(anU)));
                c.this.aSI();
                c.this.jrF.aSu().O(15, i, i);
                c.this.jrE.rj(15);
                c.this.fj(true);
                com.tencent.mm.plugin.backup.g.b.aTV();
                com.tencent.mm.plugin.backup.g.b.aTX();
                c.this.jrE.aSq();
                ab.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", Long.valueOf(c.this.jrG), Long.valueOf(bo.gb(c.this.jrH)), Long.valueOf(c.this.jrH));
                AppMethodBeat.o(17174);
            }
        }, "backupPackThread", 10).start();
        AppMethodBeat.o(17196);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d0 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d0 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.backup.b.f.a aVar, c cVar, String str, long j, boolean z) {
        int i;
        gu a;
        long anU;
        Throwable e;
        String str2;
        String str3;
        Object[] objArr;
        AppMethodBeat.i(17197);
        ak aoZ = com.tencent.mm.plugin.backup.h.d.aUr().aUs().XR().aoZ(aVar.jrd);
        if (aoZ != null) {
            i = aoZ.field_unReadCount;
        } else {
            i = 0;
        }
        ab.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", Integer.valueOf(aVar.jre), aVar.jrd, Long.valueOf(aVar.startTime), Long.valueOf(aVar.endTime), Integer.valueOf(i));
        long anU2 = bo.anU();
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i3 = i;
        while (true) {
            LinkedList linkedList = new LinkedList();
            long anU3 = j4 - bo.anU();
            Cursor c = com.tencent.mm.plugin.backup.h.d.aUr().aUs().XO().c(aVar.jrd, aVar.startTime, aVar.endTime, i2);
            int i4 = i2;
            while (c.moveToNext()) {
                i4++;
                if (this.jrD) {
                    ab.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg add msgInfoLinkedList is CANCELED!");
                    c.close();
                    AppMethodBeat.o(17197);
                    return false;
                }
                bi biVar = new bi();
                biVar.d(c);
                if (!z || biVar.getType() == 1) {
                    linkedList.add(biVar);
                }
            }
            c.close();
            j4 = anU3 + bo.anU();
            if (linkedList.size() != 0) {
                int i5 = 0;
                anU3 = j2;
                int i6 = i3;
                while (i5 < linkedList.size()) {
                    if (this.jrD) {
                        ab.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg packMsg is CANCELED!");
                        AppMethodBeat.o(17197);
                        return false;
                    }
                    bi biVar2 = (bi) linkedList.get(i5);
                    PLong pLong = new PLong();
                    LinkedList linkedList2 = new LinkedList();
                    HashMap hashMap = new HashMap();
                    try {
                        j3 -= bo.anU();
                        a = h.a(biVar2, false, str, pLong, linkedList2, hashMap, i6 > 0, false, j);
                        try {
                            anU = bo.anU() + j3;
                        } catch (Exception e2) {
                            e = e2;
                            j2 = j3;
                            ab.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupPackSessionMsg packedMsg", new Object[0]);
                            anU = j2;
                            str2 = "MicroMsg.BackupPackAndSend";
                            str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                            objArr = new Object[8];
                            if (a == null) {
                            }
                            objArr[0] = Boolean.valueOf(a == null);
                            objArr[1] = Integer.valueOf(linkedList2.size());
                            objArr[2] = Long.valueOf(pLong.value);
                            objArr[3] = Integer.valueOf(hashMap.size());
                            objArr[4] = Long.valueOf(biVar2.field_msgSvrId);
                            objArr[5] = Integer.valueOf(biVar2.getType());
                            objArr[6] = Long.valueOf(biVar2.field_createTime);
                            objArr[7] = biVar2.field_talker;
                            ab.i(str2, str3, objArr);
                            if (a != null) {
                            }
                            i5++;
                            j3 = anU;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        a = null;
                        j2 = j3;
                        ab.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupPackSessionMsg packedMsg", new Object[0]);
                        anU = j2;
                        str2 = "MicroMsg.BackupPackAndSend";
                        str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                        objArr = new Object[8];
                        if (a == null) {
                        }
                        objArr[0] = Boolean.valueOf(a == null);
                        objArr[1] = Integer.valueOf(linkedList2.size());
                        objArr[2] = Long.valueOf(pLong.value);
                        objArr[3] = Integer.valueOf(hashMap.size());
                        objArr[4] = Long.valueOf(biVar2.field_msgSvrId);
                        objArr[5] = Integer.valueOf(biVar2.getType());
                        objArr[6] = Long.valueOf(biVar2.field_createTime);
                        objArr[7] = biVar2.field_talker;
                        ab.i(str2, str3, objArr);
                        if (a != null) {
                        }
                        i5++;
                        j3 = anU;
                    }
                    str2 = "MicroMsg.BackupPackAndSend";
                    str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                    objArr = new Object[8];
                    objArr[0] = Boolean.valueOf(a == null);
                    objArr[1] = Integer.valueOf(linkedList2.size());
                    objArr[2] = Long.valueOf(pLong.value);
                    objArr[3] = Integer.valueOf(hashMap.size());
                    objArr[4] = Long.valueOf(biVar2.field_msgSvrId);
                    objArr[5] = Integer.valueOf(biVar2.getType());
                    objArr[6] = Long.valueOf(biVar2.field_createTime);
                    objArr[7] = biVar2.field_talker;
                    ab.i(str2, str3, objArr);
                    if (a != null) {
                        i6--;
                        long anU4 = anU3 - bo.anU();
                        j2 = pLong.value;
                        anU3 = biVar2.field_createTime;
                        if (cVar.jsm == null) {
                            LinkedBlockingQueue linkedBlockingQueue = cVar.jsk;
                            b bVar = new b(cVar.jrQ, aVar);
                            cVar.jsm = bVar;
                            linkedBlockingQueue.offer(bVar);
                        }
                        if (cVar.jsm.a(a, j2, anU3, linkedList2, hashMap)) {
                            cVar.jsm = null;
                        }
                        anU3 = anU4 + bo.anU();
                    }
                    i5++;
                    j3 = anU;
                }
                i2 = i4;
                j2 = anU3;
                i3 = i6;
            } else {
                long anU5 = j2 - bo.anU();
                if (cVar.jsm == null) {
                    LinkedBlockingQueue linkedBlockingQueue2 = cVar.jsk;
                    b bVar2 = new b(cVar.jrQ, aVar);
                    cVar.jsm = bVar2;
                    linkedBlockingQueue2.offer(bVar2);
                }
                cVar.jsm.aSJ();
                cVar.jsm = null;
                anU5 += bo.anU();
                ab.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", Integer.valueOf(aVar.jre), aVar.jrd, Integer.valueOf(i4), Long.valueOf(bo.gb(anU2)), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(anU5));
                AppMethodBeat.o(17197);
                return true;
            }
        }
    }
}
