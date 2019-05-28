package com.tencent.p177mm.plugin.backup.p344c;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C2600b;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C42758e;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C19940a;
import com.tencent.p177mm.plugin.backup.p346f.C45745h;
import com.tencent.p177mm.plugin.backup.p346f.C45745h.C19972a;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C42771c;
import com.tencent.p177mm.plugin.backup.p920g.C42771c.C19983b;
import com.tencent.p177mm.plugin.backup.p920g.C42771c.C42770c;
import com.tencent.p177mm.plugin.backup.p920g.C42772d;
import com.tencent.p177mm.plugin.backup.p920g.C45746l;
import com.tencent.p177mm.plugin.backup.p920g.C45746l.C33706a;
import com.tencent.p177mm.plugin.backup.p921i.C11153d;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C35987ai;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.backup.c.c */
public final class C33688c {
    private int jqS;
    boolean jrD = false;
    C2600b jrE;
    C38634d jrF;
    long jrG = 0;
    public long jrH = 0;

    /* renamed from: com.tencent.mm.plugin.backup.c.c$c */
    class C2647c {
        C33687a jrQ = new C33687a(C33688c.this, (byte) 0);
        LinkedBlockingQueue<Object> jsk = new LinkedBlockingQueue();
        C35987ai jsl = new C35987ai();
        C11138b jsm = null;
        private Runnable jsn = new C26481();

        /* renamed from: com.tencent.mm.plugin.backup.c.c$c$1 */
        class C26481 implements Runnable {
            C26481() {
            }

            public final void run() {
                AppMethodBeat.m2504i(17191);
                while (!C33688c.this.jrD) {
                    C35987ai c35987ai = null;
                    try {
                        c35987ai = C2647c.this.jsk.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                    }
                    C4990ab.m7411d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", Integer.valueOf(C2647c.this.jsk.size()), c35987ai);
                    if (c35987ai != null) {
                        if (c35987ai == C2647c.this.jsl) {
                            C2647c.this.jsl.open();
                            AppMethodBeat.m2505o(17191);
                            return;
                        }
                        String str;
                        C11138b c11138b = (C11138b) c35987ai;
                        c11138b.hkm = true;
                        StringBuilder stringBuilder = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
                        if (c11138b.hkm) {
                            str = "S.";
                        } else {
                            str = "W.";
                        }
                        c11138b.TAG = stringBuilder.append(str).append(c11138b.jre).append(".").append(c11138b.bCu).toString();
                        while (!C33688c.this.jrD) {
                            Runnable runnable = null;
                            try {
                                runnable = (Runnable) c11138b.jrP.poll(500, TimeUnit.MILLISECONDS);
                            } catch (Exception e2) {
                            }
                            if (runnable != null) {
                                int i;
                                long anU = C5046bo.anU();
                                runnable.run();
                                String str2 = "MicroMsg.BackupPackAndSend.TagQueueSucker";
                                String str3 = "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]";
                                Object[] objArr = new Object[6];
                                objArr[0] = Integer.valueOf(c11138b.jrP.size());
                                long j = C2647c.this.jrQ.jrM.get();
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
                                objArr[2] = Long.valueOf(C5046bo.m7566gb(anU));
                                objArr[3] = runnable;
                                objArr[4] = c11138b;
                                objArr[5] = C2647c.this.jsm;
                                C4990ab.m7411d(str2, str3, objArr);
                                if (!c11138b.hkm) {
                                    break;
                                }
                            }
                        }
                        System.gc();
                    }
                }
                AppMethodBeat.m2505o(17191);
            }
        }

        public C2647c() {
            AppMethodBeat.m2504i(17192);
            C7305d.m12301h(this.jsn, "tagRunnable").start();
            AppMethodBeat.m2505o(17192);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.c$b */
    class C11138b {
        String TAG;
        String bCu;
        boolean hkm;
        LinkedBlockingQueue<Runnable> jrP;
        C33687a jrQ;
        private long jrR;
        String jrS;
        Vector<String> jrT;
        private Vector<C40522gu> jrU;
        HashMap<Long, C19972a> jrV;
        long jrW;
        private final C19983b jrX;
        private final Runnable jrY;
        final Runnable jrZ;
        int jre;
        long jrg;
        long jrh;
        String talker;

        /* renamed from: com.tencent.mm.plugin.backup.c.c$b$3 */
        class C111393 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.backup.c.c$b$3$1 */
            class C111351 implements C33706a {
                C111351() {
                }

                /* renamed from: D */
                public final void mo22841D(final LinkedList<Long> linkedList) {
                    AppMethodBeat.m2504i(17181);
                    C7305d.m12301h(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(17180);
                            int i = 0;
                            while (linkedList != null && i < linkedList.size()) {
                                Long l = (Long) linkedList.get(i);
                                C19972a c19972a = (C19972a) C11138b.this.jrV.get(l);
                                String str = C11138b.this.TAG;
                                String str2 = "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s";
                                Object[] objArr = new Object[5];
                                objArr[0] = Integer.valueOf(i);
                                objArr[1] = Integer.valueOf(linkedList.size());
                                objArr[2] = l;
                                objArr[3] = c19972a == null ? BuildConfig.COMMAND : c19972a.jvy.cHr;
                                objArr[4] = c19972a == null ? BuildConfig.COMMAND : c19972a.jvy.path;
                                C4990ab.m7417i(str, str2, objArr);
                                if (c19972a != null) {
                                    C11138b.this.jrT.add(c19972a.jvy.cHr);
                                    C11138b.this.mo22845m(c19972a.jvy.cHr, c19972a.jvy.path, true);
                                }
                                i++;
                            }
                            C11138b.this.jrP.offer(C11138b.this.jrZ);
                            AppMethodBeat.m2505o(17180);
                        }
                    }, "AddBigFileToQueue").start();
                    AppMethodBeat.m2505o(17181);
                }
            }

            C111393() {
            }

            public final String toString() {
                AppMethodBeat.m2504i(17182);
                String str = C11138b.this.TAG + ".reqBigFile";
                AppMethodBeat.m2505o(17182);
                return str;
            }

            public final void run() {
                boolean z = true;
                AppMethodBeat.m2504i(17183);
                Assert.assertTrue(toString() + ", check running. ", C11138b.this.hkm);
                C4990ab.m7417i(C11138b.this.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", Integer.valueOf(C11138b.this.jrV.size()), Long.valueOf(C5046bo.m7566gb(C11138b.this.jrW)), C5007an.doQ());
                String str = "BigFileMap should not Empty";
                if (C11138b.this.jrV.isEmpty()) {
                    z = false;
                }
                Assert.assertTrue(str, z);
                new C45746l(C11138b.this.talker, C11138b.this.jrV, new C111351()).aUc();
                AppMethodBeat.m2505o(17183);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.c.c$b$4 */
        class C111404 implements Runnable {
            C111404() {
            }

            public final String toString() {
                AppMethodBeat.m2504i(17185);
                String str = C11138b.this.TAG + ".sendTag";
                AppMethodBeat.m2505o(17185);
                return str;
            }

            public final void run() {
                AppMethodBeat.m2504i(17186);
                Assert.assertTrue(toString() + ", check running. ", C11138b.this.hkm);
                int i;
                C42758e aSu;
                switch (C38634d.aSx()) {
                    case 1:
                        C4990ab.m7417i(C11138b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", Integer.valueOf(C33688c.this.jrF.aSu().jqX), Long.valueOf(C11138b.this.jrg), Long.valueOf(C11138b.this.jrh), Integer.valueOf(C11138b.this.jrT.size()), C11138b.this.bCu, C11138b.this.jrS, Long.valueOf(C5046bo.m7566gb(C11138b.this.jrW)));
                        if (C33688c.this.jrF.aSu().jqX < C11138b.this.jre + 1) {
                            i = C33688c.this.jrF.aSu().jqY;
                            aSu = C33688c.this.jrF.aSu();
                            if (C11138b.this.jre + 1 <= i) {
                                i = C11138b.this.jre + 1;
                            }
                            aSu.jqX = i;
                            C33688c.this.jrE.mo6651rj(C33688c.this.jrF.aSu().jqW);
                            break;
                        }
                        break;
                    case 21:
                    case 22:
                        C4990ab.m7417i(C11138b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", Integer.valueOf(C33688c.this.jrF.aSu().jqX), Long.valueOf(C11138b.this.jrg), Long.valueOf(C11138b.this.jrh), Integer.valueOf(C11138b.this.jrT.size()), C11138b.this.bCu, C11138b.this.jrS, Long.valueOf(C5046bo.m7566gb(C11138b.this.jrW)));
                        if (C33688c.this.jrF.aSu().jqX < C11138b.this.jre + 1) {
                            i = C33688c.this.jrF.aSu().jqY;
                            aSu = C33688c.this.jrF.aSu();
                            if (C11138b.this.jre + 1 <= i) {
                                i = C11138b.this.jre + 1;
                            }
                            aSu.jqX = i;
                            C33688c.this.jrE.mo6651rj(C33688c.this.jrF.aSu().jqW);
                            break;
                        }
                        break;
                }
                final boolean z = C11138b.this.jre == C33688c.this.jrF.aSu().jqY + -1;
                final C35987ai c35987ai = new C35987ai(!z);
                new C42772d(C11138b.this.talker, C11138b.this.jrg, C11138b.this.jrh, C11138b.this.jrS, C11138b.this.bCu, new LinkedList(C11138b.this.jrT), new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(17184);
                        C4990ab.m7417i(C11138b.this.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", Boolean.valueOf(z), c35987ai, Integer.valueOf(i), Integer.valueOf(i2), str, C11138b.this.jrS, ((C42772d) c1207m).jxy.jCG);
                        if (z && C11138b.this.jrS.equals(r0)) {
                            c35987ai.open();
                        }
                        AppMethodBeat.m2505o(17184);
                    }
                }).aUc();
                if (z) {
                    C4990ab.m7421w(C11138b.this.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", Integer.valueOf(C11138b.this.jre), Integer.valueOf(C33688c.this.jrF.aSu().jqY - 1));
                    c35987ai.block();
                }
                C11138b.this.hkm = false;
                AppMethodBeat.m2505o(17186);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.c.c$b$1 */
        class C111411 implements C19983b {
            C111411() {
            }

            /* renamed from: g */
            public final void mo22851g(boolean z, String str, int i) {
                boolean z2;
                AppMethodBeat.m2504i(17176);
                C33687a c33687a = C11138b.this.jrQ;
                long j = (long) i;
                c33687a.jrM.addAndGet(0 - j);
                if (c33687a.jrM.get() < 8388608) {
                    c33687a.jrN.open();
                }
                if (c33687a.jrM.get() < 16777216) {
                    c33687a.jrO.open();
                }
                String str2 = "MicroMsg.BackupPackAndSend";
                String str3 = "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]";
                Object[] objArr = new Object[6];
                objArr[0] = Long.valueOf(j);
                objArr[1] = Long.valueOf(c33687a.jrM.get());
                if (c33687a.jrM.get() >= 8388608) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[2] = Boolean.valueOf(z2);
                if (c33687a.jrM.get() >= 16777216) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[3] = Boolean.valueOf(z2);
                objArr[4] = Boolean.valueOf(c33687a.jrN.xzf);
                objArr[5] = Boolean.valueOf(c33687a.jrO.xzf);
                C4990ab.m7419v(str2, str3, objArr);
                C33688c.this.jrG += (long) i;
                C4990ab.m7417i(C11138b.this.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", Integer.valueOf(i), Boolean.valueOf(z), str);
                AppMethodBeat.m2505o(17176);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.c.c$b$2 */
        class C111422 implements C42770c {
            C111422() {
            }

            /* renamed from: a */
            public final void mo22852a(C42771c c42771c) {
                final C42771c c42771c2;
                AppMethodBeat.m2504i(17179);
                final long anU = C5046bo.anU();
                C33687a c33687a = C11138b.this.jrQ;
                long aUj = (long) c42771c.aUj();
                boolean z = C11138b.this.hkm;
                String str = "MicroMsg.BackupPackAndSend";
                String str2 = "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]";
                Object[] objArr = new Object[5];
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Long.valueOf(aUj);
                objArr[2] = Long.valueOf(c33687a.jrM.get());
                objArr[3] = Boolean.valueOf(c33687a.jrM.get() >= 8388608);
                objArr[4] = Boolean.valueOf(c33687a.jrM.get() >= 16777216);
                C4990ab.m7419v(str, str2, objArr);
                if (c33687a.jrM.get() + aUj >= 8388608) {
                    c33687a.jrN.close();
                }
                if (c33687a.jrM.get() >= 16777216) {
                    c33687a.jrO.close();
                }
                long anU2 = C5046bo.anU();
                while (!C33688c.this.jrD) {
                    if (c33687a.jrM.get() < (z ? 16777216 : 8388608)) {
                        c33687a.jrM.addAndGet(aUj);
                        str = "MicroMsg.BackupPackAndSend";
                        String str3 = "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]";
                        Object[] objArr2 = new Object[6];
                        objArr2[0] = Long.valueOf(C5046bo.m7566gb(anU2));
                        objArr2[1] = Boolean.valueOf(z);
                        objArr2[2] = Long.valueOf(aUj);
                        objArr2[3] = Long.valueOf(c33687a.jrM.get());
                        objArr2[4] = Boolean.valueOf(c33687a.jrM.get() >= 8388608);
                        objArr2[5] = Boolean.valueOf(c33687a.jrM.get() >= 16777216);
                        C4990ab.m7419v(str, str3, objArr2);
                        c42771c2 = c42771c;
                        C11138b.this.jrP.offer(new Runnable() {
                            public final String toString() {
                                AppMethodBeat.m2504i(17177);
                                String str = C11138b.this.TAG + ".sendFile";
                                AppMethodBeat.m2505o(17177);
                                return str;
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(17178);
                                Assert.assertTrue(toString() + ", check running. ", C11138b.this.hkm);
                                long anU = C5046bo.anU();
                                c42771c2.aUc();
                                long anU2 = C5046bo.anU();
                                C4990ab.m7417i(C11138b.this.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", Integer.valueOf(c42771c2.aUj()), Long.valueOf(anU2 - anU), Long.valueOf(anU2 - anU), c42771c2.jxp.jCx);
                                AppMethodBeat.m2505o(17178);
                            }
                        });
                        AppMethodBeat.m2505o(17179);
                    }
                    (z ? c33687a.jrO : c33687a.jrN).doJ();
                }
                c42771c2 = c42771c;
                C11138b.this.jrP.offer(/* anonymous class already generated */);
                AppMethodBeat.m2505o(17179);
            }
        }

        public final String toString() {
            return this.TAG;
        }

        public C11138b(C33687a c33687a, C19940a c19940a) {
            String displayName;
            AppMethodBeat.m2504i(17187);
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
            this.jrX = new C111411();
            this.jrY = new C111393();
            this.jrZ = new C111404();
            this.jrW = C5046bo.anU();
            this.jrQ = c33687a;
            this.talker = c19940a.jrd;
            this.jre = c19940a.jre;
            if (C1855t.m3896kH(this.talker)) {
                displayName = C1854s.getDisplayName(this.talker, this.talker);
            } else {
                displayName = C1854s.m3866mJ(this.talker);
            }
            this.bCu = displayName;
            this.TAG = "MicroMsg.BackupPackAndSend.tag." + (this.hkm ? "S." : "W.") + this.jre + "." + this.bCu;
            C4990ab.m7417i(this.TAG, "initTagNow [%d,%s,%s] [%s]", Integer.valueOf(this.jre), this.bCu, this.talker, C5007an.doQ());
            AppMethodBeat.m2505o(17187);
        }

        /* renamed from: a */
        public final boolean mo22843a(C40522gu c40522gu, long j, long j2, LinkedList<C19993u> linkedList, HashMap<Long, C19972a> hashMap) {
            AppMethodBeat.m2504i(17188);
            this.jrU.add(c40522gu);
            this.jrR = (j > 0 ? j : 0) + this.jrR;
            if (this.jrg == 0) {
                this.jrg = j2;
            }
            this.jrh = j2;
            this.jrV.putAll(hashMap);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C19993u c19993u = (C19993u) it.next();
                mo22845m(c19993u.cHr, c19993u.path, false);
            }
            C4990ab.m7417i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", Long.valueOf(this.jrg), Long.valueOf(this.jrh), Long.valueOf(j), Long.valueOf(this.jrR), Integer.valueOf(this.jrU.size()), Integer.valueOf(linkedList.size()), Long.valueOf(C5046bo.m7566gb(this.jrW)));
            if (this.jrR > 83886080 || this.jrU.size() > 80) {
                aSJ();
                AppMethodBeat.m2505o(17188);
                return true;
            }
            AppMethodBeat.m2505o(17188);
            return false;
        }

        public final void aSJ() {
            AppMethodBeat.m2504i(17189);
            this.jrS = "MSG_" + this.jrU.size() + "_" + this.talker + "_" + C5046bo.anU();
            C4990ab.m7417i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", Long.valueOf(this.jrg), Long.valueOf(this.jrh), Long.valueOf(this.jrR), Integer.valueOf(this.jrU.size()), Integer.valueOf(this.jrV.size()), this.jrS, Long.valueOf(C5046bo.m7566gb(this.jrW)));
            if (this.jrU.size() > 0) {
                mo22845m(this.jrS, null, false);
                if (this.jrV.isEmpty()) {
                    this.jrP.offer(this.jrZ);
                    AppMethodBeat.m2505o(17189);
                    return;
                }
                this.jrP.offer(this.jrY);
                AppMethodBeat.m2505o(17189);
                return;
            }
            C4990ab.m7421w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", Integer.valueOf(this.jrU.size()), Integer.valueOf(this.jrT.size()), Integer.valueOf(this.jrV.size()));
            Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.jrU.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.jrT.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.jrV.isEmpty());
            this.jrP.offer(this.jrZ);
            AppMethodBeat.m2505o(17189);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: m */
        public final void mo22845m(String str, String str2, boolean z) {
            boolean z2 = true;
            AppMethodBeat.m2504i(17190);
            C42770c c111422 = new C111422();
            C4990ab.m7417i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", Boolean.valueOf(z), Integer.valueOf(this.jrU.size()), str, str2);
            if (TextUtils.isEmpty(str2)) {
                String str3 = "chatMsgList should not empty";
                if (this.jrU.isEmpty()) {
                    z2 = false;
                }
                Assert.assertTrue(str3, z2);
                if (str != null) {
                    C42771c.m75837a(this.jrX, c111422, str, new LinkedList(this.jrU), C33688c.this.jrF.jqU);
                }
            } else {
                this.jrT.add(str);
                if (str != null) {
                    C42771c.m75836a(this.jrX, c111422, str, str2, C33688c.this.jrF.jqU);
                    AppMethodBeat.m2505o(17190);
                    return;
                }
            }
            AppMethodBeat.m2505o(17190);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.c$a */
    class C33687a {
        volatile AtomicLong jrM;
        C35987ai jrN;
        C35987ai jrO;

        private C33687a() {
            AppMethodBeat.m2504i(17175);
            this.jrM = new AtomicLong(0);
            this.jrN = new C35987ai(true);
            this.jrO = new C35987ai(true);
            AppMethodBeat.m2505o(17175);
        }

        /* synthetic */ C33687a(C33688c c33688c, byte b) {
            this();
        }
    }

    public C33688c(C38634d c38634d, int i, C2600b c2600b) {
        this.jrF = c38634d;
        this.jqS = i;
        this.jrE = c2600b;
        this.jrD = false;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(17193);
        C4990ab.m7413e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", C5007an.doQ());
        this.jrD = true;
        AppMethodBeat.m2505o(17193);
    }

    public final long aSH() {
        return this.jrG / 1024;
    }

    /* renamed from: fj */
    public final void mo54245fj(boolean z) {
        AppMethodBeat.m2504i(17194);
        C4990ab.m7416i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
        if (this.jqS == 1) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE);
        } else if (this.jqS == 2) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.FALSE);
        }
        Editor edit = C38634d.aSz().edit();
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
        AppMethodBeat.m2505o(17194);
    }

    public final void aSI() {
        AppMethodBeat.m2504i(17195);
        C4990ab.m7416i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
        C11153d c11153d = new C11153d();
        c11153d.f2888ID = this.jrF.jqO;
        try {
            C19978b.m30877K(c11153d.toByteArray(), 8);
            AppMethodBeat.m2505o(17195);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "BackupFinishRequest to buf err.", new Object[0]);
            AppMethodBeat.m2505o(17195);
        }
    }

    /* renamed from: a */
    public final void mo54240a(LinkedList<C19940a> linkedList, long j, boolean z) {
        AppMethodBeat.m2504i(17196);
        String str = "MicroMsg.BackupPackAndSend";
        String str2 = "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Long.valueOf(j);
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        final LinkedList<C19940a> linkedList2 = linkedList;
        final long j2 = j;
        final boolean z2 = z;
        C7305d.m12285a(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17174);
                if (linkedList2 == null) {
                    C4990ab.m7412e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
                    if (C33688c.this.jrE != null) {
                        C33688c.this.jrE.aSr();
                        C33688c.this.jrF.aSu().jqW = -21;
                        C33688c.this.jrE.mo6651rj(-21);
                    }
                    AppMethodBeat.m2505o(17174);
                    return;
                }
                int i;
                C19978b.aTW();
                LinkedList linkedList = linkedList2;
                HashSet hashSet = new HashSet();
                if (linkedList == null) {
                    i = 0;
                } else {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        hashSet.add(((C19940a) it.next()).jrd);
                    }
                    i = hashSet.size();
                }
                C33688c.this.jrF.aSu().mo68222O(14, 1, i);
                C33688c.this.jrE.mo6651rj(14);
                String str = (String) C38658d.aUr().aUs().mo61496Ry().get(2, null);
                C33688c.this.jrH = C5046bo.anU();
                C2647c c2647c = new C2647c();
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    C33688c.this.mo54241a((C19940a) it2.next(), c2647c, str, j2, z2);
                    if (C33688c.this.jrD) {
                        break;
                    }
                }
                if (C33688c.this.jrD) {
                    C4990ab.m7412e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
                    AppMethodBeat.m2505o(17174);
                    return;
                }
                long anU = C5046bo.anU();
                long anU2 = C5046bo.anU();
                c2647c.jsk.offer(c2647c.jsl);
                c2647c.jsl.block();
                C4990ab.m7417i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", Long.valueOf(C5046bo.m7566gb(anU2)));
                Assert.assertTrue(c2647c.jsk.isEmpty());
                C4990ab.m7417i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", Integer.valueOf(linkedList2.size()), Long.valueOf(C5046bo.m7566gb(C33688c.this.jrH)), Long.valueOf(C5046bo.m7566gb(anU)));
                C33688c.this.aSI();
                C33688c.this.jrF.aSu().mo68222O(15, i, i);
                C33688c.this.jrE.mo6651rj(15);
                C33688c.this.mo54245fj(true);
                C19978b.aTV();
                C19978b.aTX();
                C33688c.this.jrE.aSq();
                C4990ab.m7417i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", Long.valueOf(C33688c.this.jrG), Long.valueOf(C5046bo.m7566gb(C33688c.this.jrH)), Long.valueOf(C33688c.this.jrH));
                AppMethodBeat.m2505o(17174);
            }
        }, "backupPackThread", 10).start();
        AppMethodBeat.m2505o(17196);
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
    /* renamed from: a */
    public final boolean mo54241a(C19940a c19940a, C2647c c2647c, String str, long j, boolean z) {
        int i;
        C40522gu a;
        long anU;
        Throwable e;
        String str2;
        String str3;
        Object[] objArr;
        AppMethodBeat.m2504i(17197);
        C7617ak aoZ = C38658d.aUr().aUs().mo61499XR().aoZ(c19940a.jrd);
        if (aoZ != null) {
            i = aoZ.field_unReadCount;
        } else {
            i = 0;
        }
        C4990ab.m7417i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", Integer.valueOf(c19940a.jre), c19940a.jrd, Long.valueOf(c19940a.startTime), Long.valueOf(c19940a.endTime), Integer.valueOf(i));
        long anU2 = C5046bo.anU();
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i3 = i;
        while (true) {
            LinkedList linkedList = new LinkedList();
            long anU3 = j4 - C5046bo.anU();
            Cursor c = C38658d.aUr().aUs().mo61498XO().mo15315c(c19940a.jrd, c19940a.startTime, c19940a.endTime, i2);
            int i4 = i2;
            while (c.moveToNext()) {
                i4++;
                if (this.jrD) {
                    C4990ab.m7412e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg add msgInfoLinkedList is CANCELED!");
                    c.close();
                    AppMethodBeat.m2505o(17197);
                    return false;
                }
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(c);
                if (!z || c7620bi.getType() == 1) {
                    linkedList.add(c7620bi);
                }
            }
            c.close();
            j4 = anU3 + C5046bo.anU();
            if (linkedList.size() != 0) {
                int i5 = 0;
                anU3 = j2;
                int i6 = i3;
                while (i5 < linkedList.size()) {
                    if (this.jrD) {
                        C4990ab.m7412e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg packMsg is CANCELED!");
                        AppMethodBeat.m2505o(17197);
                        return false;
                    }
                    C7620bi c7620bi2 = (C7620bi) linkedList.get(i5);
                    PLong pLong = new PLong();
                    LinkedList linkedList2 = new LinkedList();
                    HashMap hashMap = new HashMap();
                    try {
                        j3 -= C5046bo.anU();
                        a = C45745h.m84542a(c7620bi2, false, str, pLong, linkedList2, hashMap, i6 > 0, false, j);
                        try {
                            anU = C5046bo.anU() + j3;
                        } catch (Exception e2) {
                            e = e2;
                            j2 = j3;
                            C4990ab.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupPackSessionMsg packedMsg", new Object[0]);
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
                            objArr[4] = Long.valueOf(c7620bi2.field_msgSvrId);
                            objArr[5] = Integer.valueOf(c7620bi2.getType());
                            objArr[6] = Long.valueOf(c7620bi2.field_createTime);
                            objArr[7] = c7620bi2.field_talker;
                            C4990ab.m7417i(str2, str3, objArr);
                            if (a != null) {
                            }
                            i5++;
                            j3 = anU;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        a = null;
                        j2 = j3;
                        C4990ab.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupPackSessionMsg packedMsg", new Object[0]);
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
                        objArr[4] = Long.valueOf(c7620bi2.field_msgSvrId);
                        objArr[5] = Integer.valueOf(c7620bi2.getType());
                        objArr[6] = Long.valueOf(c7620bi2.field_createTime);
                        objArr[7] = c7620bi2.field_talker;
                        C4990ab.m7417i(str2, str3, objArr);
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
                    objArr[4] = Long.valueOf(c7620bi2.field_msgSvrId);
                    objArr[5] = Integer.valueOf(c7620bi2.getType());
                    objArr[6] = Long.valueOf(c7620bi2.field_createTime);
                    objArr[7] = c7620bi2.field_talker;
                    C4990ab.m7417i(str2, str3, objArr);
                    if (a != null) {
                        i6--;
                        long anU4 = anU3 - C5046bo.anU();
                        j2 = pLong.value;
                        anU3 = c7620bi2.field_createTime;
                        if (c2647c.jsm == null) {
                            LinkedBlockingQueue linkedBlockingQueue = c2647c.jsk;
                            C11138b c11138b = new C11138b(c2647c.jrQ, c19940a);
                            c2647c.jsm = c11138b;
                            linkedBlockingQueue.offer(c11138b);
                        }
                        if (c2647c.jsm.mo22843a(a, j2, anU3, linkedList2, hashMap)) {
                            c2647c.jsm = null;
                        }
                        anU3 = anU4 + C5046bo.anU();
                    }
                    i5++;
                    j3 = anU;
                }
                i2 = i4;
                j2 = anU3;
                i3 = i6;
            } else {
                long anU5 = j2 - C5046bo.anU();
                if (c2647c.jsm == null) {
                    LinkedBlockingQueue linkedBlockingQueue2 = c2647c.jsk;
                    C11138b c11138b2 = new C11138b(c2647c.jrQ, c19940a);
                    c2647c.jsm = c11138b2;
                    linkedBlockingQueue2.offer(c11138b2);
                }
                c2647c.jsm.aSJ();
                c2647c.jsm = null;
                anU5 += C5046bo.anU();
                C4990ab.m7417i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", Integer.valueOf(c19940a.jre), c19940a.jrd, Integer.valueOf(i4), Long.valueOf(C5046bo.m7566gb(anU2)), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(anU5));
                AppMethodBeat.m2505o(17197);
                return true;
            }
        }
    }
}
