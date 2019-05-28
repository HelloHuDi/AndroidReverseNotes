package com.tencent.p177mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.pluginsdk.model.app.C44062z.C35801a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.tencent.mm.pluginsdk.model.app.al */
public final class C30061al {

    /* renamed from: com.tencent.mm.pluginsdk.model.app.al$a */
    public static class C30062a implements C1202f {
        private static int cqX = 0;
        Queue<Long> cqQ = new LinkedList();
        Queue<Long> cqR = new LinkedList();
        Map<Long, C1446a> cqS = new HashMap();
        private boolean cqT = false;
        private boolean cqU = false;
        int cqV = 0;
        private long cqW = 0;
        C1446a cqZ = new C1446a();
        private C7564ap cra = new C7564ap(C9638aw.m17180RS().oAl.getLooper(), new C300634(), false);
        private boolean running = false;
        private HashMap<Long, String> vcK = new HashMap();

        /* renamed from: com.tencent.mm.pluginsdk.model.app.al$a$4 */
        class C300634 implements C5015a {
            C300634() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(27399);
                C30062a.m47601i(C30062a.this);
                AppMethodBeat.m2505o(27399);
                return false;
            }

            public final String toString() {
                AppMethodBeat.m2504i(27400);
                String str = super.toString() + "|scenePusher";
                AppMethodBeat.m2505o(27400);
                return str;
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.model.app.al$a$3 */
        class C300643 implements Runnable {
            C300643() {
            }

            public final void run() {
                AppMethodBeat.m2504i(27397);
                long currentTimeMillis = System.currentTimeMillis() - C30062a.this.cqW;
                C4990ab.m7410d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + C30062a.this.running + " timeWait:" + currentTimeMillis + " sending:" + C30062a.this.cqU + " recving:" + C30062a.this.cqT);
                if (C30062a.this.running) {
                    if (currentTimeMillis < 180000) {
                        AppMethodBeat.m2505o(27397);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + C30062a.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + C30062a.this.cqU + " recving:" + C30062a.this.cqT);
                }
                C30062a.this.running = true;
                C30062a.this.cqU = false;
                C30062a.this.cqV = 4;
                C30062a.this.cqT = false;
                C30062a.this.cqZ.evE = SystemClock.elapsedRealtime();
                C30062a.this.cra.mo16770ae(10, 10);
                AppMethodBeat.m2505o(27397);
            }

            public final String toString() {
                AppMethodBeat.m2504i(27398);
                String str = super.toString() + "|run";
                AppMethodBeat.m2505o(27398);
                return str;
            }
        }

        /* renamed from: Fc */
        static /* synthetic */ int m47590Fc() {
            int i = cqX;
            cqX = i + 1;
            return i;
        }

        /* renamed from: Fd */
        static /* synthetic */ int m47591Fd() {
            int i = cqX;
            cqX = i - 1;
            return i;
        }

        /* renamed from: j */
        static /* synthetic */ void m47602j(C30062a c30062a) {
            AppMethodBeat.m2504i(27412);
            c30062a.m47589Fb();
            AppMethodBeat.m2505o(27412);
        }

        public C30062a() {
            AppMethodBeat.m2504i(27401);
            C9638aw.m17182Rg().mo14539a(220, (C1202f) this);
            C9638aw.m17182Rg().mo14539a(221, (C1202f) this);
            C9638aw.m17182Rg().mo14539a(222, (C1202f) this);
            AppMethodBeat.m2505o(27401);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.m2504i(27402);
            C9638aw.m17182Rg().mo14546b(220, (C1202f) this);
            C9638aw.m17182Rg().mo14546b(221, (C1202f) this);
            C9638aw.m17182Rg().mo14546b(222, (C1202f) this);
            this.vcK.clear();
            super.finalize();
            AppMethodBeat.m2505o(27402);
        }

        /* renamed from: z */
        public final void mo48321z(long j, String str) {
            AppMethodBeat.m2504i(27403);
            this.vcK.put(Long.valueOf(j), str);
            AppMethodBeat.m2505o(27403);
        }

        /* renamed from: jB */
        public static void m47603jB(long j) {
            AppMethodBeat.m2504i(27404);
            C9638aw.m17182Rg().mo14541a(new C40438af(j, null, null), 0);
            AppMethodBeat.m2505o(27404);
        }

        /* renamed from: A */
        public static void m47588A(long j, String str) {
            AppMethodBeat.m2504i(27405);
            C9638aw.m17182Rg().mo14541a(new C40438af(j, str, null), 0);
            AppMethodBeat.m2505o(27405);
        }

        /* renamed from: b */
        public static void m47593b(long j, String str, String str2) {
            AppMethodBeat.m2504i(27406);
            C9638aw.m17182Rg().mo14541a(new C40438af(j, str, str2), 0);
            AppMethodBeat.m2505o(27406);
        }

        private boolean dhK() {
            AppMethodBeat.m2504i(27407);
            List list;
            try {
                Cursor rawQuery = C14877am.aUq().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
                if (rawQuery == null) {
                    list = null;
                } else {
                    int count = rawQuery.getCount();
                    C4990ab.m7410d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:".concat(String.valueOf(count)));
                    if (count == 0) {
                        rawQuery.close();
                        list = null;
                    } else {
                        list = new ArrayList();
                        for (int i = 0; i < count; i++) {
                            rawQuery.moveToPosition(i);
                            C30065b c30065b = new C30065b();
                            c30065b.mo8995d(rawQuery);
                            list.add(c30065b);
                        }
                        rawQuery.close();
                    }
                }
            } catch (IllegalStateException e) {
                C4990ab.printErrStackTrace("MicroMsg.SceneAppMsg", e, "", new Object[0]);
                C30066c aUq = C14877am.aUq();
                aUq.bSd.mo10108hY("appattach", " update appattach set status = 198 , lastModifyTime = " + C5046bo.anT() + " where status = 101");
                aUq.doNotify();
                list = null;
            }
            if (list == null || list.size() == 0) {
                AppMethodBeat.m2505o(27407);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String mx = C5046bo.m7579mx(currentTimeMillis);
            for (C30065b c30065b2 : list) {
                if (this.cqS.containsKey(Long.valueOf(c30065b2.xDa))) {
                    C4990ab.m7410d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + c30065b2.xDa);
                } else {
                    C4990ab.m7410d("MicroMsg.SceneAppMsg", "summerbig Get file:" + c30065b2.field_fileFullPath + " status:" + c30065b2.field_status + " create:(" + C5046bo.m7579mx(c30065b2.field_createTime) + "," + C5046bo.m7579mx(c30065b2.field_createTime / 1000) + ", last:" + C5046bo.m7579mx(c30065b2.field_lastModifyTime) + " now:" + C5046bo.m7579mx(currentTimeMillis) + " " + (currentTimeMillis - c30065b2.field_lastModifyTime));
                    if (c30065b2.field_isUpload) {
                        if (currentTimeMillis - c30065b2.field_lastModifyTime <= 600 || c30065b2.field_status != 101) {
                            this.cqQ.offer(Long.valueOf(c30065b2.xDa));
                            this.cqS.put(Long.valueOf(c30065b2.xDa), null);
                        } else {
                            C4990ab.m7412e("MicroMsg.SceneAppMsg", "summerbig time out file: " + c30065b2.field_fileFullPath + " last:" + C5046bo.m7579mx(c30065b2.field_lastModifyTime) + " now:" + mx);
                            C4733l.m7104jC(c30065b2.xDa);
                        }
                    }
                }
            }
            C4990ab.m7410d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.cqS.size() + " [recv:" + this.cqR.size() + ",send:" + this.cqQ.size() + "]");
            if (this.cqR.size() + this.cqQ.size() == 0) {
                AppMethodBeat.m2505o(27407);
                return false;
            }
            AppMethodBeat.m2505o(27407);
            return true;
        }

        public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
            AppMethodBeat.m2504i(27408);
            C4990ab.m7411d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    int i;
                    long j;
                    long j2 = 0;
                    Object obj = null;
                    AppMethodBeat.m2504i(27395);
                    C30062a.m47590Fc();
                    if (c1207m.getType() == 222) {
                        C4990ab.m7410d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + i + " errCode:" + i2);
                        i = 0;
                        j = -1;
                    } else if (c1207m.getType() == 221) {
                        C30062a.this.cqT = false;
                        j = ((C43432e) c1207m).pJl;
                        i = ((C43432e) c1207m).retCode;
                    } else if (c1207m.getType() == 220) {
                        String str;
                        long j3;
                        C30062a.this.cqU = false;
                        long j4 = ((C30057ai) c1207m).pJl;
                        int i2 = ((C30057ai) c1207m).retCode;
                        C30057ai c30057ai = (C30057ai) c1207m;
                        if (c30057ai.pJj == null) {
                            str = null;
                        } else {
                            str = c30057ai.pJj.field_mediaSvrId;
                        }
                        c30057ai = (C30057ai) c1207m;
                        if (c30057ai.pJj == null) {
                            j3 = 0;
                        } else {
                            j3 = c30057ai.pJj.field_msgInfoId;
                        }
                        String str2 = (String) C30062a.this.vcK.remove(Long.valueOf(j3));
                        if (!C5046bo.isNullOrNil(((C30057ai) c1207m).fFa)) {
                            obj = 1;
                        }
                        if (obj == null && !C5046bo.isNullOrNil(str)) {
                            C30065b c30065b = new C30065b();
                            C14877am.aUq().mo16761b(j4, (C4925c) c30065b);
                            if (c30065b.xDa == j4) {
                                C4733l.m7084a(c30065b.field_msgInfoId, str, null);
                                C4990ab.m7410d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                                C30062a.m47588A(c30065b.field_msgInfoId, str2);
                            }
                        }
                        i = i2;
                        j = j4;
                    } else {
                        C4990ab.m7412e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + c1207m.getType());
                        C30062a.m47591Fd();
                        AppMethodBeat.m2505o(27395);
                        return;
                    }
                    if (!(j == -1 || C30062a.this.cqS.get(Long.valueOf(j)) == null)) {
                        j2 = ((C1446a) C30062a.this.cqS.get(Long.valueOf(j))).mo4908Mr();
                        C30062a.this.cqS.remove(Long.valueOf(j));
                    }
                    C4990ab.m7410d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + c1207m.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " rowid:" + j + " time:" + j2);
                    if (i != 0) {
                        C30062a.this.cqV = C30062a.this.cqV - 1;
                    }
                    C4990ab.m7410d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + C30062a.cqX + " stop:" + C30062a.this.cqV + " running:" + C30062a.this.running + " recving:" + C30062a.this.cqT + " sending:" + C30062a.this.cqU);
                    if (C30062a.this.cqV > 0) {
                        C30062a.m47601i(C30062a.this);
                    } else if (!(C30062a.this.cqU || C30062a.this.cqT)) {
                        C30062a.m47602j(C30062a.this);
                    }
                    C30062a.m47591Fd();
                    AppMethodBeat.m2505o(27395);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(27396);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.m2505o(27396);
                    return str;
                }
            });
            AppMethodBeat.m2505o(27408);
        }

        /* renamed from: Fb */
        private void m47589Fb() {
            AppMethodBeat.m2504i(27409);
            this.cqS.clear();
            this.cqQ.clear();
            this.cqR.clear();
            this.cqU = false;
            this.cqT = false;
            this.running = false;
            C4990ab.m7410d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.cqZ.mo4908Mr());
            AppMethodBeat.m2505o(27409);
        }

        public final void run() {
            AppMethodBeat.m2504i(27410);
            C9638aw.m17180RS().mo10302aa(new C300643());
            AppMethodBeat.m2505o(27410);
        }

        /* renamed from: i */
        static /* synthetic */ void m47601i(C30062a c30062a) {
            AppMethodBeat.m2504i(27411);
            C4990ab.m7411d("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene recving[%b][%d], sending[%b][%d]", Boolean.valueOf(c30062a.cqT), Integer.valueOf(c30062a.cqR.size()), Boolean.valueOf(c30062a.cqU), Integer.valueOf(c30062a.cqQ.size()));
            c30062a.cqW = System.currentTimeMillis();
            if ((!c30062a.cqT && c30062a.cqR.size() == 0) || (!c30062a.cqU && c30062a.cqQ.size() == 0)) {
                c30062a.dhK();
            }
            if (c30062a.cqT || c30062a.cqR.size() != 0 || c30062a.cqU || c30062a.cqQ.size() != 0) {
                if (!c30062a.cqU && c30062a.cqQ.size() > 0) {
                    final long a = C5046bo.m7514a((Long) c30062a.cqQ.poll(), -1);
                    C4990ab.m7416i("MicroMsg.SceneAppMsg", "summerbig Start Send :".concat(String.valueOf(a)));
                    if (a != -1) {
                        c30062a.cqS.put(Long.valueOf(a), new C1446a());
                        c30062a.cqU = true;
                        final C30065b c30065b = new C30065b();
                        C7620bi jf;
                        if (C14877am.aUq().mo16761b(a, (C4925c) c30065b)) {
                            String str;
                            if (c30065b.field_type == 8) {
                                C9638aw.m17190ZK();
                                jf = C18628c.m29080XO().mo15340jf(c30065b.field_msgInfoId);
                                if (jf.field_msgId == 0) {
                                    C4990ab.m7412e("MicroMsg.SceneAppMsg", "getEmoticonMd5 fail, msg is null :" + c30065b.field_msgInfoId);
                                    str = null;
                                } else {
                                    C8910b me = C8910b.m16064me(jf.field_content);
                                    if (me != null) {
                                        str = me.fgq;
                                    } else {
                                        str = C44218ap.aps(jf.field_content).cvZ;
                                    }
                                }
                                if (str == null) {
                                    C4990ab.m7412e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, send emoji, emoticonMd5 can not be null");
                                    C9638aw.m17190ZK();
                                    jf = C18628c.m29080XO().mo15340jf(c30065b.field_msgInfoId);
                                    jf.setStatus(5);
                                    C9638aw.m17190ZK();
                                    C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
                                    c30062a.cqU = false;
                                    AppMethodBeat.m2505o(27411);
                                    return;
                                }
                            }
                            str = null;
                            final String str2 = (String) c30062a.vcK.get(Long.valueOf(c30065b.field_msgInfoId));
                            if (c30065b.field_totalLen > 26214400) {
                                C9638aw.m17190ZK();
                                final C7620bi jf2 = C18628c.m29080XO().mo15340jf(c30065b.field_msgInfoId);
                                C9638aw.m17182Rg().mo14541a(new C44062z(C8910b.m16064me(C5046bo.anj(jf2.field_content)), c30065b.field_fileFullPath, jf2.field_talker, new C35801a() {
                                    /* renamed from: a */
                                    public final void mo9874a(String str, String str2, String str3, String str4, String str5, long j) {
                                        AppMethodBeat.m2504i(27394);
                                        if (C5046bo.isNullOrNil(str3)) {
                                            AppMethodBeat.m2505o(27394);
                                            return;
                                        }
                                        c30065b.field_signature = str3;
                                        c30065b.field_fakeAeskey = str4;
                                        c30065b.field_fakeSignature = str5;
                                        c30065b.field_lastModifyTime = C5046bo.anU();
                                        String str6 = jf2.field_content;
                                        if (C1855t.m3896kH(jf2.field_talker)) {
                                            int ox = C1829bf.m3761ox(jf2.field_content);
                                            if (ox != -1) {
                                                str6 = (jf2.field_content + " ").substring(ox + 2).trim();
                                            }
                                        }
                                        C8910b me = C8910b.m16064me(C5046bo.anj(str6));
                                        if (me != null) {
                                            me.filemd5 = str;
                                            me.eyr = str2;
                                            me.fgo = (int) j;
                                            C9638aw.m17190ZK();
                                            C7620bi jf = C18628c.m29080XO().mo15340jf(c30065b.field_msgInfoId);
                                            jf.setContent(C8910b.m16061a(me, null, null));
                                            C9638aw.m17190ZK();
                                            C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
                                        }
                                        C14877am.aUq().mo48326a(c30065b, new String[0]);
                                        C9638aw.m17182Rg().mo14541a(new C30057ai(a, null, str2), 0);
                                        AppMethodBeat.m2505o(27394);
                                    }
                                }), 0);
                                AppMethodBeat.m2505o(27411);
                                return;
                            }
                            C9638aw.m17182Rg().mo14541a(new C30057ai(a, str, str2), 0);
                        } else {
                            C4990ab.m7412e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, getAttachInfo fail, infoId = ".concat(String.valueOf(a)));
                            C9638aw.m17190ZK();
                            jf = C18628c.m29080XO().mo15340jf(c30065b.field_msgInfoId);
                            jf.setStatus(5);
                            C9638aw.m17190ZK();
                            C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
                            c30062a.cqU = false;
                            AppMethodBeat.m2505o(27411);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(27411);
                return;
            }
            c30062a.m47589Fb();
            C4990ab.m7410d("MicroMsg.SceneAppMsg", "summerbig No Data Any More , Stop Service");
            AppMethodBeat.m2505o(27411);
        }
    }
}
