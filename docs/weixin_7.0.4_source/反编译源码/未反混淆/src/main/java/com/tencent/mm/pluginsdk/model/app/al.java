package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class al {

    public static class a implements f {
        private static int cqX = 0;
        Queue<Long> cqQ = new LinkedList();
        Queue<Long> cqR = new LinkedList();
        Map<Long, com.tencent.mm.compatible.util.g.a> cqS = new HashMap();
        private boolean cqT = false;
        private boolean cqU = false;
        int cqV = 0;
        private long cqW = 0;
        com.tencent.mm.compatible.util.g.a cqZ = new com.tencent.mm.compatible.util.g.a();
        private ap cra = new ap(aw.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(27399);
                a.i(a.this);
                AppMethodBeat.o(27399);
                return false;
            }

            public final String toString() {
                AppMethodBeat.i(27400);
                String str = super.toString() + "|scenePusher";
                AppMethodBeat.o(27400);
                return str;
            }
        }, false);
        private boolean running = false;
        private HashMap<Long, String> vcK = new HashMap();

        static /* synthetic */ int Fc() {
            int i = cqX;
            cqX = i + 1;
            return i;
        }

        static /* synthetic */ int Fd() {
            int i = cqX;
            cqX = i - 1;
            return i;
        }

        static /* synthetic */ void j(a aVar) {
            AppMethodBeat.i(27412);
            aVar.Fb();
            AppMethodBeat.o(27412);
        }

        public a() {
            AppMethodBeat.i(27401);
            aw.Rg().a(220, (f) this);
            aw.Rg().a(221, (f) this);
            aw.Rg().a(222, (f) this);
            AppMethodBeat.o(27401);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.i(27402);
            aw.Rg().b(220, (f) this);
            aw.Rg().b(221, (f) this);
            aw.Rg().b(222, (f) this);
            this.vcK.clear();
            super.finalize();
            AppMethodBeat.o(27402);
        }

        public final void z(long j, String str) {
            AppMethodBeat.i(27403);
            this.vcK.put(Long.valueOf(j), str);
            AppMethodBeat.o(27403);
        }

        public static void jB(long j) {
            AppMethodBeat.i(27404);
            aw.Rg().a(new af(j, null, null), 0);
            AppMethodBeat.o(27404);
        }

        public static void A(long j, String str) {
            AppMethodBeat.i(27405);
            aw.Rg().a(new af(j, str, null), 0);
            AppMethodBeat.o(27405);
        }

        public static void b(long j, String str, String str2) {
            AppMethodBeat.i(27406);
            aw.Rg().a(new af(j, str, str2), 0);
            AppMethodBeat.o(27406);
        }

        private boolean dhK() {
            AppMethodBeat.i(27407);
            List list;
            try {
                Cursor rawQuery = am.aUq().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
                if (rawQuery == null) {
                    list = null;
                } else {
                    int count = rawQuery.getCount();
                    ab.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:".concat(String.valueOf(count)));
                    if (count == 0) {
                        rawQuery.close();
                        list = null;
                    } else {
                        list = new ArrayList();
                        for (int i = 0; i < count; i++) {
                            rawQuery.moveToPosition(i);
                            b bVar = new b();
                            bVar.d(rawQuery);
                            list.add(bVar);
                        }
                        rawQuery.close();
                    }
                }
            } catch (IllegalStateException e) {
                ab.printErrStackTrace("MicroMsg.SceneAppMsg", e, "", new Object[0]);
                c aUq = am.aUq();
                aUq.bSd.hY("appattach", " update appattach set status = 198 , lastModifyTime = " + bo.anT() + " where status = 101");
                aUq.doNotify();
                list = null;
            }
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(27407);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String mx = bo.mx(currentTimeMillis);
            for (b bVar2 : list) {
                if (this.cqS.containsKey(Long.valueOf(bVar2.xDa))) {
                    ab.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + bVar2.xDa);
                } else {
                    ab.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + bVar2.field_fileFullPath + " status:" + bVar2.field_status + " create:(" + bo.mx(bVar2.field_createTime) + "," + bo.mx(bVar2.field_createTime / 1000) + ", last:" + bo.mx(bVar2.field_lastModifyTime) + " now:" + bo.mx(currentTimeMillis) + " " + (currentTimeMillis - bVar2.field_lastModifyTime));
                    if (bVar2.field_isUpload) {
                        if (currentTimeMillis - bVar2.field_lastModifyTime <= 600 || bVar2.field_status != 101) {
                            this.cqQ.offer(Long.valueOf(bVar2.xDa));
                            this.cqS.put(Long.valueOf(bVar2.xDa), null);
                        } else {
                            ab.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + bVar2.field_fileFullPath + " last:" + bo.mx(bVar2.field_lastModifyTime) + " now:" + mx);
                            l.jC(bVar2.xDa);
                        }
                    }
                }
            }
            ab.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.cqS.size() + " [recv:" + this.cqR.size() + ",send:" + this.cqQ.size() + "]");
            if (this.cqR.size() + this.cqQ.size() == 0) {
                AppMethodBeat.o(27407);
                return false;
            }
            AppMethodBeat.o(27407);
            return true;
        }

        public final void onSceneEnd(final int i, final int i2, String str, final m mVar) {
            AppMethodBeat.i(27408);
            ab.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
            aw.RS().aa(new Runnable() {
                public final void run() {
                    int i;
                    long j;
                    long j2 = 0;
                    Object obj = null;
                    AppMethodBeat.i(27395);
                    a.Fc();
                    if (mVar.getType() == 222) {
                        ab.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + i + " errCode:" + i2);
                        i = 0;
                        j = -1;
                    } else if (mVar.getType() == 221) {
                        a.this.cqT = false;
                        j = ((e) mVar).pJl;
                        i = ((e) mVar).retCode;
                    } else if (mVar.getType() == 220) {
                        String str;
                        long j3;
                        a.this.cqU = false;
                        long j4 = ((ai) mVar).pJl;
                        int i2 = ((ai) mVar).retCode;
                        ai aiVar = (ai) mVar;
                        if (aiVar.pJj == null) {
                            str = null;
                        } else {
                            str = aiVar.pJj.field_mediaSvrId;
                        }
                        aiVar = (ai) mVar;
                        if (aiVar.pJj == null) {
                            j3 = 0;
                        } else {
                            j3 = aiVar.pJj.field_msgInfoId;
                        }
                        String str2 = (String) a.this.vcK.remove(Long.valueOf(j3));
                        if (!bo.isNullOrNil(((ai) mVar).fFa)) {
                            obj = 1;
                        }
                        if (obj == null && !bo.isNullOrNil(str)) {
                            b bVar = new b();
                            am.aUq().b(j4, (c) bVar);
                            if (bVar.xDa == j4) {
                                l.a(bVar.field_msgInfoId, str, null);
                                ab.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                                a.A(bVar.field_msgInfoId, str2);
                            }
                        }
                        i = i2;
                        j = j4;
                    } else {
                        ab.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + mVar.getType());
                        a.Fd();
                        AppMethodBeat.o(27395);
                        return;
                    }
                    if (!(j == -1 || a.this.cqS.get(Long.valueOf(j)) == null)) {
                        j2 = ((com.tencent.mm.compatible.util.g.a) a.this.cqS.get(Long.valueOf(j))).Mr();
                        a.this.cqS.remove(Long.valueOf(j));
                    }
                    ab.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + mVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " rowid:" + j + " time:" + j2);
                    if (i != 0) {
                        a.this.cqV = a.this.cqV - 1;
                    }
                    ab.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + a.cqX + " stop:" + a.this.cqV + " running:" + a.this.running + " recving:" + a.this.cqT + " sending:" + a.this.cqU);
                    if (a.this.cqV > 0) {
                        a.i(a.this);
                    } else if (!(a.this.cqU || a.this.cqT)) {
                        a.j(a.this);
                    }
                    a.Fd();
                    AppMethodBeat.o(27395);
                }

                public final String toString() {
                    AppMethodBeat.i(27396);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.o(27396);
                    return str;
                }
            });
            AppMethodBeat.o(27408);
        }

        private void Fb() {
            AppMethodBeat.i(27409);
            this.cqS.clear();
            this.cqQ.clear();
            this.cqR.clear();
            this.cqU = false;
            this.cqT = false;
            this.running = false;
            ab.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.cqZ.Mr());
            AppMethodBeat.o(27409);
        }

        public final void run() {
            AppMethodBeat.i(27410);
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27397);
                    long currentTimeMillis = System.currentTimeMillis() - a.this.cqW;
                    ab.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + " sending:" + a.this.cqU + " recving:" + a.this.cqT);
                    if (a.this.running) {
                        if (currentTimeMillis < 180000) {
                            AppMethodBeat.o(27397);
                            return;
                        }
                        ab.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.this.cqU + " recving:" + a.this.cqT);
                    }
                    a.this.running = true;
                    a.this.cqU = false;
                    a.this.cqV = 4;
                    a.this.cqT = false;
                    a.this.cqZ.evE = SystemClock.elapsedRealtime();
                    a.this.cra.ae(10, 10);
                    AppMethodBeat.o(27397);
                }

                public final String toString() {
                    AppMethodBeat.i(27398);
                    String str = super.toString() + "|run";
                    AppMethodBeat.o(27398);
                    return str;
                }
            });
            AppMethodBeat.o(27410);
        }

        static /* synthetic */ void i(a aVar) {
            AppMethodBeat.i(27411);
            ab.d("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene recving[%b][%d], sending[%b][%d]", Boolean.valueOf(aVar.cqT), Integer.valueOf(aVar.cqR.size()), Boolean.valueOf(aVar.cqU), Integer.valueOf(aVar.cqQ.size()));
            aVar.cqW = System.currentTimeMillis();
            if ((!aVar.cqT && aVar.cqR.size() == 0) || (!aVar.cqU && aVar.cqQ.size() == 0)) {
                aVar.dhK();
            }
            if (aVar.cqT || aVar.cqR.size() != 0 || aVar.cqU || aVar.cqQ.size() != 0) {
                if (!aVar.cqU && aVar.cqQ.size() > 0) {
                    final long a = bo.a((Long) aVar.cqQ.poll(), -1);
                    ab.i("MicroMsg.SceneAppMsg", "summerbig Start Send :".concat(String.valueOf(a)));
                    if (a != -1) {
                        aVar.cqS.put(Long.valueOf(a), new com.tencent.mm.compatible.util.g.a());
                        aVar.cqU = true;
                        final b bVar = new b();
                        bi jf;
                        if (am.aUq().b(a, (c) bVar)) {
                            String str;
                            if (bVar.field_type == 8) {
                                aw.ZK();
                                jf = com.tencent.mm.model.c.XO().jf(bVar.field_msgInfoId);
                                if (jf.field_msgId == 0) {
                                    ab.e("MicroMsg.SceneAppMsg", "getEmoticonMd5 fail, msg is null :" + bVar.field_msgInfoId);
                                    str = null;
                                } else {
                                    b me = b.me(jf.field_content);
                                    if (me != null) {
                                        str = me.fgq;
                                    } else {
                                        str = com.tencent.mm.storage.ap.aps(jf.field_content).cvZ;
                                    }
                                }
                                if (str == null) {
                                    ab.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, send emoji, emoticonMd5 can not be null");
                                    aw.ZK();
                                    jf = com.tencent.mm.model.c.XO().jf(bVar.field_msgInfoId);
                                    jf.setStatus(5);
                                    aw.ZK();
                                    com.tencent.mm.model.c.XO().a(jf.field_msgId, jf);
                                    aVar.cqU = false;
                                    AppMethodBeat.o(27411);
                                    return;
                                }
                            }
                            str = null;
                            final String str2 = (String) aVar.vcK.get(Long.valueOf(bVar.field_msgInfoId));
                            if (bVar.field_totalLen > 26214400) {
                                aw.ZK();
                                final bi jf2 = com.tencent.mm.model.c.XO().jf(bVar.field_msgInfoId);
                                aw.Rg().a(new z(b.me(bo.anj(jf2.field_content)), bVar.field_fileFullPath, jf2.field_talker, new com.tencent.mm.pluginsdk.model.app.z.a() {
                                    public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                        AppMethodBeat.i(27394);
                                        if (bo.isNullOrNil(str3)) {
                                            AppMethodBeat.o(27394);
                                            return;
                                        }
                                        bVar.field_signature = str3;
                                        bVar.field_fakeAeskey = str4;
                                        bVar.field_fakeSignature = str5;
                                        bVar.field_lastModifyTime = bo.anU();
                                        String str6 = jf2.field_content;
                                        if (t.kH(jf2.field_talker)) {
                                            int ox = bf.ox(jf2.field_content);
                                            if (ox != -1) {
                                                str6 = (jf2.field_content + " ").substring(ox + 2).trim();
                                            }
                                        }
                                        b me = b.me(bo.anj(str6));
                                        if (me != null) {
                                            me.filemd5 = str;
                                            me.eyr = str2;
                                            me.fgo = (int) j;
                                            aw.ZK();
                                            bi jf = com.tencent.mm.model.c.XO().jf(bVar.field_msgInfoId);
                                            jf.setContent(b.a(me, null, null));
                                            aw.ZK();
                                            com.tencent.mm.model.c.XO().a(jf.field_msgId, jf);
                                        }
                                        am.aUq().a(bVar, new String[0]);
                                        aw.Rg().a(new ai(a, null, str2), 0);
                                        AppMethodBeat.o(27394);
                                    }
                                }), 0);
                                AppMethodBeat.o(27411);
                                return;
                            }
                            aw.Rg().a(new ai(a, str, str2), 0);
                        } else {
                            ab.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, getAttachInfo fail, infoId = ".concat(String.valueOf(a)));
                            aw.ZK();
                            jf = com.tencent.mm.model.c.XO().jf(bVar.field_msgInfoId);
                            jf.setStatus(5);
                            aw.ZK();
                            com.tencent.mm.model.c.XO().a(jf.field_msgId, jf);
                            aVar.cqU = false;
                            AppMethodBeat.o(27411);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(27411);
                return;
            }
            aVar.Fb();
            ab.d("MicroMsg.SceneAppMsg", "summerbig No Data Any More , Stop Service");
            AppMethodBeat.o(27411);
        }
    }
}
