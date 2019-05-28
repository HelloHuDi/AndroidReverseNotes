package com.tencent.mm.modelvideo;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.t.a.b;
import com.tencent.mm.modelvideo.t.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static int cqX = 0;
    private boolean cqU = false;
    int cqV = 0;
    private com.tencent.mm.compatible.util.g.a cqZ = new com.tencent.mm.compatible.util.g.a();
    private ap cra = new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(50739);
            m.h(m.this);
            AppMethodBeat.o(50739);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(50740);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(50740);
            return str;
        }
    }, false);
    private LinkedList<Long> fWe = new LinkedList();
    private Map<Long, com.tencent.mm.compatible.util.g.a> fWf = new HashMap();
    private Map<Long, String> fWg = new HashMap();
    private Object fWh = new Object();
    String fWi;
    private boolean running = false;

    /* renamed from: com.tencent.mm.modelvideo.m$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long fWj;

        AnonymousClass1(long j) {
            this.fWj = j;
        }

        public final void run() {
            long j = 0;
            AppMethodBeat.i(50733);
            m.alh();
            m.this.cqU = false;
            m.this.fWi = "";
            if (this.fWj > 0 && m.this.fWf.get(Long.valueOf(this.fWj)) != null) {
                j = ((com.tencent.mm.compatible.util.g.a) m.this.fWf.get(Long.valueOf(this.fWj))).Mr();
            }
            ab.d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.fWj + " time:" + j + " inCnt:" + m.cqX + " stop:" + m.this.cqV + " running:" + m.this.running + " sending:" + m.this.cqU);
            if (m.this.cqV > 0) {
                m.h(m.this);
            } else if (!m.this.cqU) {
                m.i(m.this);
            }
            m.ali();
            AppMethodBeat.o(50733);
        }

        public final String toString() {
            AppMethodBeat.i(50734);
            String str = super.toString() + "|onSceneEnd";
            AppMethodBeat.o(50734);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.m$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ long fWj;

        public AnonymousClass5(long j) {
            this.fWj = j;
        }

        /* JADX WARNING: Missing block: B:15:0x00b4, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(50741);
     */
        /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.i(50741);
            synchronized (m.this.fWh) {
                try {
                    String str = (String) m.this.fWg.get(Long.valueOf(this.fWj));
                    ab.i("MicroMsg.SightMassSendService", "cancel item, massSendId %d, cdnClientId %s", Long.valueOf(this.fWj), str);
                    if ("done_upload_cdn_client_id".equals(str)) {
                        ab.w("MicroMsg.SightMassSendService", "doing mass send cgi, ignore cancel!");
                    } else {
                        if (!bo.isNullOrNil(str)) {
                            m.this.fWg.put(Long.valueOf(this.fWj), "");
                            f.afx().rN(str);
                            m.this.e(this.fWj, 0, 0);
                        }
                        t all = o.all();
                        long j = this.fWj;
                        if (all.fni.delete("videoinfo2", "masssendid= ?", new String[]{String.valueOf(j)}) > 0) {
                            all.fry.cF(new com.tencent.mm.modelvideo.t.a.a("DELETE_".concat(String.valueOf(j)), b.DELETE, c.NORMAL, 3, j));
                            all.fry.doNotify();
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(50741);
                }
            }
        }
    }

    final class a implements com.tencent.mm.ai.f, com.tencent.mm.i.g.a {
        long fVs;
        s fVt;
        String fWl;
        List<s> foD;
        long startTime;

        private a() {
        }

        /* synthetic */ a(m mVar, byte b) {
            this();
        }

        public final int a(String str, int i, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            AppMethodBeat.i(50742);
            ab.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.fWl, Integer.valueOf(i), cVar, dVar);
            if (i == -21005) {
                ab.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.fWl);
                AppMethodBeat.o(50742);
                return 0;
            } else if (i != 0) {
                m.ak(this.foD);
                ab.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", Long.valueOf(this.fVs), Integer.valueOf(i));
                new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Integer.valueOf(0), "")).ajK();
                m.this.e(this.fVs, 3, i);
                AppMethodBeat.o(50742);
                return 0;
            } else if (cVar != null) {
                ab.v("MicroMsg.SightMassSendService", "progress length %d", Integer.valueOf(cVar.field_finishedLength));
                for (s sVar : this.foD) {
                    sVar.fXb = bo.anT();
                    sVar.fVG = cVar.field_finishedLength;
                    sVar.bJt = FilterEnum4Shaka.MIC_SHAKA_ADD_13;
                    u.f(sVar);
                }
                AppMethodBeat.o(50742);
                return 0;
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo, Long.valueOf(this.fVs));
                        m.ak(this.foD);
                        String r = com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY);
                        new com.tencent.mm.g.b.a.f(r).ajK();
                        new com.tencent.mm.g.b.a.d(r).ajK();
                        m.this.e(this.fVs, 3, dVar.field_retCode);
                    } else {
                        ab.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", Integer.valueOf(dVar.field_UploadHitCacheType), Long.valueOf(this.fVs));
                        ab.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + dVar.field_aesKey + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnvideourl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" ") + "length=\"" + dVar.field_fileLength + "\" ") + "cdnthumblength=\"" + dVar.field_thumbimgLength + "\"/></msg>");
                        for (s sVar2 : this.foD) {
                            if (bo.isNullOrNil(sVar2.alw())) {
                                sVar2.fXj = r1;
                                sVar2.bJt = 2097152;
                                boolean f = u.f(sVar2);
                                ab.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", Long.valueOf(this.fVs), sVar2.getFileName(), Boolean.valueOf(f));
                            }
                        }
                        synchronized (m.this.fWh) {
                            try {
                                if (bo.isNullOrNil((String) m.this.fWg.get(Long.valueOf(this.fVs)))) {
                                    ab.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.fVs), (String) m.this.fWg.get(Long.valueOf(this.fVs)), this.fWl);
                                } else {
                                    ab.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.fVs), (String) m.this.fWg.get(Long.valueOf(this.fVs)), this.fWl);
                                    m.this.fWg.put(Long.valueOf(this.fVs), "done_upload_cdn_client_id");
                                    g.Rg().a((int) com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, (com.tencent.mm.ai.f) this);
                                    if (!g.Rg().a(new e(this.fVs, this.fVt, dVar, this.fWl), 0)) {
                                        ab.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
                                        g.Rg().b((int) com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, (com.tencent.mm.ai.f) this);
                                        m.this.e(this.fVs, 3, 0);
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(50742);
                            }
                        }
                    }
                }
                AppMethodBeat.o(50742);
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return null;
        }

        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
            AppMethodBeat.i(50743);
            g.Rg().b((int) com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, (com.tencent.mm.ai.f) this);
            if (i == 4 && i2 == -22) {
                ab.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + i + " errCode:" + i2 + " massSendId:" + this.fVs);
                m.al(this.foD);
                m.this.e(this.fVs, i, i2);
                AppMethodBeat.o(50743);
            } else if (i == 4 && i2 != 0) {
                ab.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.fVs);
                m.ak(this.foD);
                m.this.e(this.fVs, i, i2);
                AppMethodBeat.o(50743);
            } else if (i == 0 && i2 == 0) {
                for (s sVar : this.foD) {
                    sVar.fXb = bo.anT();
                    sVar.status = 199;
                    sVar.bJt = ActUtil.HEIGHT;
                    if (u.f(sVar)) {
                        if (sVar == null) {
                            ab.e("MicroMsg.VideoLogic", "video info is null");
                        } else if (sVar.fXe > 0) {
                            bi jf = ((j) g.K(j.class)).bOr().jf((long) sVar.fXe);
                            int type = jf.getType();
                            ab.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", Integer.valueOf(type));
                            if (43 == type || 62 == type) {
                                jf.hO(1);
                                jf.ju(sVar.getUser());
                                jf.eI(sVar.cKK);
                                jf.setStatus(2);
                                jf.setContent(q.d(sVar.alt(), (long) sVar.fXd, false));
                                ((j) g.K(j.class)).bOr().a((long) sVar.fXe, jf);
                                ab.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", Long.valueOf(jf.field_msgId));
                            }
                        } else {
                            bi biVar = new bi();
                            biVar.ju(sVar.getUser());
                            biVar.setType(62);
                            biVar.hO(1);
                            biVar.jv(sVar.getFileName());
                            biVar.setStatus(2);
                            biVar.eJ(bf.oC(sVar.getUser()));
                            sVar.fXe = (int) bf.l(biVar);
                            sVar.bJt = Utility.DEFAULT_STREAM_BUFFER_SIZE;
                            u.f(sVar);
                            ab.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", Long.valueOf(biVar.field_msgId));
                        }
                    }
                    ab.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", Long.valueOf(this.fVs), sVar.getFileName(), Integer.valueOf(199));
                }
                g.RS().aa(new AnonymousClass1(this.fVs));
                AppMethodBeat.o(50743);
            } else {
                ab.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.fVs);
                m.ak(this.foD);
                m.this.e(this.fVs, i, i2);
                AppMethodBeat.o(50743);
            }
        }
    }

    public m() {
        AppMethodBeat.i(50744);
        AppMethodBeat.o(50744);
    }

    static /* synthetic */ int alh() {
        int i = cqX;
        cqX = i + 1;
        return i;
    }

    static /* synthetic */ int ali() {
        int i = cqX;
        cqX = i - 1;
        return i;
    }

    static /* synthetic */ void i(m mVar) {
        AppMethodBeat.i(50751);
        mVar.Fb();
        AppMethodBeat.o(50751);
    }

    public static void ak(List<s> list) {
        AppMethodBeat.i(50745);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(50745);
            return;
        }
        for (s fileName : list) {
            u.um(fileName.getFileName());
        }
        AppMethodBeat.o(50745);
    }

    public static void al(List<s> list) {
        AppMethodBeat.i(50746);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(50746);
            return;
        }
        for (s fileName : list) {
            u.un(fileName.getFileName());
        }
        AppMethodBeat.o(50746);
    }

    private String fT(long j) {
        AppMethodBeat.i(50747);
        List<s> fU = o.all().fU(j);
        if (fU.isEmpty()) {
            ab.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
            AppMethodBeat.o(50747);
            return null;
        }
        s sVar;
        for (s sVar2 : fU) {
            if (t.nJ(sVar2.getUser())) {
                ab.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", sVar2.getUser(), sVar2.fXl, Long.valueOf(j));
                AppMethodBeat.o(50747);
                return null;
            }
            f.afx();
            if (!com.tencent.mm.al.b.lg(2) && sVar2.fXi != 1) {
                r3 = new Object[4];
                f.afx();
                r3[0] = Boolean.valueOf(com.tencent.mm.al.b.lg(2));
                r3[1] = Integer.valueOf(sVar2.fXi);
                r3[2] = sVar2.fXl;
                r3[3] = Long.valueOf(j);
                ab.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", r3);
                AppMethodBeat.o(50747);
                return null;
            }
        }
        if (fU != null && !fU.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= fU.size()) {
                    sVar2 = null;
                    break;
                }
                s ut = u.ut(((s) fU.get(i2)).getFileName());
                if (ut != null) {
                    ab.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", sVar2.getFileName(), Integer.valueOf(i2), Integer.valueOf(fU.size()), Long.valueOf(j), sVar2.fXl);
                    fU.remove(i2);
                    fU.add(i2, ut);
                    sVar2 = ut;
                    break;
                }
                ab.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", sVar2.getFileName(), Integer.valueOf(i2), Integer.valueOf(fU.size()), Long.valueOf(j), sVar2.fXl);
                i = i2 + 1;
            }
        } else {
            sVar2 = null;
        }
        if (sVar2 == null) {
            ab.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
            AppMethodBeat.o(50747);
            return null;
        }
        String a = com.tencent.mm.al.c.a("upvideo", sVar2.createTime, sVar2.fXl, sVar2.getFileName());
        if (bo.isNullOrNil(a)) {
            ab.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", sVar2.getFileName(), Long.valueOf(sVar2.fVs), sVar2.fXl);
            AppMethodBeat.o(50747);
            return null;
        }
        String fileName = sVar2.getFileName();
        o.all();
        String ui = t.ui(fileName);
        o.all();
        fileName = t.uh(fileName);
        a aVar = new a(this, (byte) 0);
        aVar.foD = fU;
        aVar.fVs = j;
        aVar.fWl = a;
        aVar.startTime = bo.anU();
        aVar.fVt = sVar2;
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.egl = aVar;
        gVar.field_mediaId = a;
        gVar.field_fullpath = fileName;
        gVar.field_thumbpath = ui;
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        gVar.field_smallVideoFlag = 1;
        gVar.field_talker = sVar2.fXl;
        gVar.field_priority = com.tencent.mm.i.a.efC;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        Map z = br.z(sVar2.alw(), "msg");
        if (z != null) {
            gVar.field_fileId = (String) z.get(".msg.videomsg.$cdnvideourl");
            gVar.field_aesKey = (String) z.get(".msg.videomsg.$aeskey");
        } else {
            ab.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
        }
        if (f.afx().e(gVar)) {
            for (s sVar22 : fU) {
                if (sVar22.fXi != 1) {
                    sVar22.fXi = 1;
                    sVar22.bJt = SQLiteGlobal.journalSizeLimit;
                    boolean f = u.f(sVar22);
                    ab.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", sVar22.getFileName(), Boolean.valueOf(f));
                }
            }
            AppMethodBeat.o(50747);
            return a;
        }
        ab.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
        AppMethodBeat.o(50747);
        return null;
    }

    public final void e(long j, int i, int i2) {
        AppMethodBeat.i(50748);
        final long j2 = j;
        final int i3 = i;
        final int i4 = i2;
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50735);
                m.alh();
                m.this.cqU = false;
                m.this.fWi = "";
                long j = 0;
                if (j2 > 0 && m.this.fWf.get(Long.valueOf(j2)) != null) {
                    j = ((com.tencent.mm.compatible.util.g.a) m.this.fWf.get(Long.valueOf(j2))).Mr();
                }
                ab.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4));
                if (!(i3 == 0 && i4 == 0)) {
                    m.this.cqV = m.this.cqV - 1;
                }
                ab.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", Integer.valueOf(m.cqX), Integer.valueOf(m.this.cqV), Boolean.valueOf(m.this.running), Boolean.valueOf(m.this.cqU));
                if (m.this.cqV > 0) {
                    m.h(m.this);
                } else if (!m.this.cqU) {
                    ab.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
                    t all = o.all();
                    LinkedList k = m.this.fWe;
                    if (!(k == null || k.isEmpty())) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append('(');
                        for (int i = 0; i < k.size() - 1; i++) {
                            stringBuilder.append((Long) k.get(i));
                            stringBuilder.append(',');
                        }
                        Long l = (Long) k.get(k.size() - 1);
                        if (l != null) {
                            stringBuilder.append(l);
                        }
                        stringBuilder.append(')');
                        ab.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status=198, lastmodifytime=" + currentTimeMillis + " WHERE masssendid IN " + stringBuilder.toString());
                        all.fni.hY("videoinfo2", r0);
                    }
                    m.i(m.this);
                }
                m.ali();
                AppMethodBeat.o(50735);
            }

            public final String toString() {
                AppMethodBeat.i(50736);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(50736);
                return str;
            }
        });
        AppMethodBeat.o(50748);
    }

    private void Fb() {
        AppMethodBeat.i(50749);
        this.fWg.clear();
        this.fWf.clear();
        this.fWe.clear();
        this.cqU = false;
        this.running = false;
        ab.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.cqZ.Mr());
        AppMethodBeat.o(50749);
    }

    static /* synthetic */ void h(m mVar) {
        AppMethodBeat.i(50750);
        if (!mVar.cqU && mVar.fWe.isEmpty()) {
            List<s> alB = o.all().alB();
            if (alB.isEmpty()) {
                ab.d("MicroMsg.SightMassSendService", "unfinish massinfo count 0");
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (s sVar : alB) {
                    if (mVar.fWf.containsKey(Long.valueOf(sVar.fVs))) {
                        ab.d("MicroMsg.SightMassSendService", "Mass Send File is Already running %s, massSendId %d", sVar.getFileName(), Long.valueOf(sVar.fVs));
                    } else {
                        ab.d("MicroMsg.SightMassSendService", "Get file:" + sVar.getFileName() + " status:" + sVar.status + " user" + sVar.getUser() + " human:" + sVar.alt() + " massSendId:" + sVar.fVs + " massSendList:" + sVar.fXl + " create:" + bo.mx(sVar.createTime) + " last:" + bo.mx(sVar.fXb) + " now:" + bo.mx(currentTimeMillis) + " " + (currentTimeMillis - sVar.fXb));
                        if (sVar.status == 200) {
                            mVar.fWe.offer(Long.valueOf(sVar.fVs));
                            mVar.fWf.put(Long.valueOf(sVar.fVs), null);
                        }
                    }
                }
                ab.d("MicroMsg.SightMassSendService", "GetNeedRun procing:" + mVar.fWf.size() + " [send:" + mVar.fWe.size() + "]");
                mVar.fWe.size();
            }
        }
        if (mVar.cqU || !mVar.fWe.isEmpty()) {
            if (!mVar.cqU && mVar.fWe.size() > 0) {
                Long l = (Long) mVar.fWe.poll();
                ab.d("MicroMsg.SightMassSendService", "Start Mass Send, ID: %s", l);
                if (l != null) {
                    mVar.fWf.put(l, new com.tencent.mm.compatible.util.g.a());
                    mVar.cqU = true;
                    mVar.fWi = mVar.fT(l.longValue());
                    if (mVar.fWi == null) {
                        mVar.cqU = false;
                        mVar.cra.ae(10, 10);
                        AppMethodBeat.o(50750);
                        return;
                    }
                    mVar.fWg.put(l, mVar.fWi);
                }
            }
            AppMethodBeat.o(50750);
            return;
        }
        mVar.Fb();
        ab.d("MicroMsg.SightMassSendService", "No Data Any More , Stop Service");
        AppMethodBeat.o(50750);
    }
}
