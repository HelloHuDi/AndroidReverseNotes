package com.tencent.p177mm.modelvideo;

import android.os.SystemClock;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9719c;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9722b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.view.C31128d;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.modelvideo.m */
public final class C18709m {
    private static int cqX = 0;
    private boolean cqU = false;
    int cqV = 0;
    private C1446a cqZ = new C1446a();
    private C7564ap cra = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C187084(), false);
    private LinkedList<Long> fWe = new LinkedList();
    private Map<Long, C1446a> fWf = new HashMap();
    private Map<Long, String> fWg = new HashMap();
    private Object fWh = new Object();
    String fWi;
    private boolean running = false;

    /* renamed from: com.tencent.mm.modelvideo.m$3 */
    class C187073 implements Runnable {
        C187073() {
        }

        public final void run() {
            AppMethodBeat.m2504i(50737);
            C4990ab.m7410d("MicroMsg.SightMassSendService", "Try Run service runningFlag:" + C18709m.this.running + " sending:" + C18709m.this.cqU);
            if (!C18709m.this.running) {
                C18709m.this.cqV = 5;
                C18709m.this.cqZ.evE = SystemClock.elapsedRealtime();
                C18709m.this.cqU = false;
            }
            C18709m.this.running = true;
            C18709m.this.cra.mo16770ae(10, 10);
            AppMethodBeat.m2505o(50737);
        }

        public final String toString() {
            AppMethodBeat.m2504i(50738);
            String str = super.toString() + "|run";
            AppMethodBeat.m2505o(50738);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.m$4 */
    class C187084 implements C5015a {
        C187084() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(50739);
            C18709m.m29253h(C18709m.this);
            AppMethodBeat.m2505o(50739);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(50740);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.m2505o(50740);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.m$1 */
    class C187101 implements Runnable {
        final /* synthetic */ long fWj;

        C187101(long j) {
            this.fWj = j;
        }

        public final void run() {
            long j = 0;
            AppMethodBeat.m2504i(50733);
            C18709m.alh();
            C18709m.this.cqU = false;
            C18709m.this.fWi = "";
            if (this.fWj > 0 && C18709m.this.fWf.get(Long.valueOf(this.fWj)) != null) {
                j = ((C1446a) C18709m.this.fWf.get(Long.valueOf(this.fWj))).mo4908Mr();
            }
            C4990ab.m7410d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.fWj + " time:" + j + " inCnt:" + C18709m.cqX + " stop:" + C18709m.this.cqV + " running:" + C18709m.this.running + " sending:" + C18709m.this.cqU);
            if (C18709m.this.cqV > 0) {
                C18709m.m29253h(C18709m.this);
            } else if (!C18709m.this.cqU) {
                C18709m.m29254i(C18709m.this);
            }
            C18709m.ali();
            AppMethodBeat.m2505o(50733);
        }

        public final String toString() {
            AppMethodBeat.m2504i(50734);
            String str = super.toString() + "|onSceneEnd";
            AppMethodBeat.m2505o(50734);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.m$5 */
    public class C187125 implements Runnable {
        final /* synthetic */ long fWj;

        public C187125(long j) {
            this.fWj = j;
        }

        /* JADX WARNING: Missing block: B:15:0x00b4, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(50741);
     */
        /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(50741);
            synchronized (C18709m.this.fWh) {
                try {
                    String str = (String) C18709m.this.fWg.get(Long.valueOf(this.fWj));
                    C4990ab.m7417i("MicroMsg.SightMassSendService", "cancel item, massSendId %d, cdnClientId %s", Long.valueOf(this.fWj), str);
                    if ("done_upload_cdn_client_id".equals(str)) {
                        C4990ab.m7420w("MicroMsg.SightMassSendService", "doing mass send cgi, ignore cancel!");
                    } else {
                        if (!C5046bo.isNullOrNil(str)) {
                            C18709m.this.fWg.put(Long.valueOf(this.fWj), "");
                            C37461f.afx().mo51227rN(str);
                            C18709m.this.mo33974e(this.fWj, 0, 0);
                        }
                        C9720t all = C37961o.all();
                        long j = this.fWj;
                        if (all.fni.delete("videoinfo2", "masssendid= ?", new String[]{String.valueOf(j)}) > 0) {
                            all.fry.mo10126cF(new C9718a("DELETE_".concat(String.valueOf(j)), C9722b.DELETE, C9719c.NORMAL, 3, j));
                            all.fry.doNotify();
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(50741);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.m$a */
    final class C18713a implements C1202f, C1628a {
        long fVs;
        C26493s fVt;
        String fWl;
        List<C26493s> foD;
        long startTime;

        private C18713a() {
        }

        /* synthetic */ C18713a(C18709m c18709m, byte b) {
            this();
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(50742);
            C4990ab.m7411d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.fWl, Integer.valueOf(i), c18496c, c9545d);
            if (i == -21005) {
                C4990ab.m7411d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.fWl);
                AppMethodBeat.m2505o(50742);
                return 0;
            } else if (i != 0) {
                C18709m.m29244ak(this.foD);
                C4990ab.m7413e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", Long.valueOf(this.fVs), Integer.valueOf(i));
                new C9514f(C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_TinyVideo), Integer.valueOf(0), "")).ajK();
                C18709m.this.mo33974e(this.fVs, 3, i);
                AppMethodBeat.m2505o(50742);
                return 0;
            } else if (c18496c != null) {
                C4990ab.m7419v("MicroMsg.SightMassSendService", "progress length %d", Integer.valueOf(c18496c.field_finishedLength));
                for (C26493s c26493s : this.foD) {
                    c26493s.fXb = C5046bo.anT();
                    c26493s.fVG = c18496c.field_finishedLength;
                    c26493s.bJt = FilterEnum4Shaka.MIC_SHAKA_ADD_13;
                    C26494u.m42253f(c26493s);
                }
                AppMethodBeat.m2505o(50742);
                return 0;
            } else {
                if (c9545d != null) {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", Integer.valueOf(c9545d.field_retCode), c9545d.field_arg, c9545d.field_transInfo, Long.valueOf(this.fVs));
                        C18709m.m29244ak(this.foD);
                        String r = C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_TinyVideo), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY);
                        new C9514f(r).ajK();
                        new C42099d(r).ajK();
                        C18709m.this.mo33974e(this.fVs, 3, c9545d.field_retCode);
                    } else {
                        C4990ab.m7417i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", Integer.valueOf(c9545d.field_UploadHitCacheType), Long.valueOf(this.fVs));
                        C4990ab.m7417i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + c9545d.field_aesKey + "\" cdnthumbaeskey=\"" + c9545d.field_aesKey + "\" cdnvideourl=\"" + c9545d.field_fileId + "\" ") + "cdnthumburl=\"" + c9545d.field_fileId + "\" ") + "length=\"" + c9545d.field_fileLength + "\" ") + "cdnthumblength=\"" + c9545d.field_thumbimgLength + "\"/></msg>");
                        for (C26493s c26493s2 : this.foD) {
                            if (C5046bo.isNullOrNil(c26493s2.alw())) {
                                c26493s2.fXj = r1;
                                c26493s2.bJt = 2097152;
                                boolean f = C26494u.m42253f(c26493s2);
                                C4990ab.m7417i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", Long.valueOf(this.fVs), c26493s2.getFileName(), Boolean.valueOf(f));
                            }
                        }
                        synchronized (C18709m.this.fWh) {
                            try {
                                if (C5046bo.isNullOrNil((String) C18709m.this.fWg.get(Long.valueOf(this.fVs)))) {
                                    C4990ab.m7417i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.fVs), (String) C18709m.this.fWg.get(Long.valueOf(this.fVs)), this.fWl);
                                } else {
                                    C4990ab.m7417i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.fVs), (String) C18709m.this.fWg.get(Long.valueOf(this.fVs)), this.fWl);
                                    C18709m.this.fWg.put(Long.valueOf(this.fVs), "done_upload_cdn_client_id");
                                    C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_ZIPAI_LIGHTWHITE, (C1202f) this);
                                    if (!C1720g.m3540Rg().mo14541a(new C32836e(this.fVs, this.fVt, c9545d, this.fWl), 0)) {
                                        C4990ab.m7412e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
                                        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_LIGHTWHITE, (C1202f) this);
                                        C18709m.this.mo33974e(this.fVs, 3, 0);
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(50742);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(50742);
                return 0;
            }
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return null;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(50743);
            C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_LIGHTWHITE, (C1202f) this);
            if (i == 4 && i2 == -22) {
                C4990ab.m7412e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + i + " errCode:" + i2 + " massSendId:" + this.fVs);
                C18709m.m29245al(this.foD);
                C18709m.this.mo33974e(this.fVs, i, i2);
                AppMethodBeat.m2505o(50743);
            } else if (i == 4 && i2 != 0) {
                C4990ab.m7412e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.fVs);
                C18709m.m29244ak(this.foD);
                C18709m.this.mo33974e(this.fVs, i, i2);
                AppMethodBeat.m2505o(50743);
            } else if (i == 0 && i2 == 0) {
                for (C26493s c26493s : this.foD) {
                    c26493s.fXb = C5046bo.anT();
                    c26493s.status = 199;
                    c26493s.bJt = ActUtil.HEIGHT;
                    if (C26494u.m42253f(c26493s)) {
                        if (c26493s == null) {
                            C4990ab.m7412e("MicroMsg.VideoLogic", "video info is null");
                        } else if (c26493s.fXe > 0) {
                            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) c26493s.fXe);
                            int type = jf.getType();
                            C4990ab.m7417i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", Integer.valueOf(type));
                            if (43 == type || 62 == type) {
                                jf.mo14781hO(1);
                                jf.mo14794ju(c26493s.getUser());
                                jf.mo14774eI(c26493s.cKK);
                                jf.setStatus(2);
                                jf.setContent(C37963q.m64228d(c26493s.alt(), (long) c26493s.fXd, false));
                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a((long) c26493s.fXe, jf);
                                C4990ab.m7411d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", Long.valueOf(jf.field_msgId));
                            }
                        } else {
                            C7620bi c7620bi = new C7620bi();
                            c7620bi.mo14794ju(c26493s.getUser());
                            c7620bi.setType(62);
                            c7620bi.mo14781hO(1);
                            c7620bi.mo14795jv(c26493s.getFileName());
                            c7620bi.setStatus(2);
                            c7620bi.mo14775eJ(C1829bf.m3756oC(c26493s.getUser()));
                            c26493s.fXe = (int) C1829bf.m3752l(c7620bi);
                            c26493s.bJt = Utility.DEFAULT_STREAM_BUFFER_SIZE;
                            C26494u.m42253f(c26493s);
                            C4990ab.m7411d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", Long.valueOf(c7620bi.field_msgId));
                        }
                    }
                    C4990ab.m7419v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", Long.valueOf(this.fVs), c26493s.getFileName(), Integer.valueOf(199));
                }
                C1720g.m3539RS().mo10302aa(new C187101(this.fVs));
                AppMethodBeat.m2505o(50743);
            } else {
                C4990ab.m7412e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.fVs);
                C18709m.m29244ak(this.foD);
                C18709m.this.mo33974e(this.fVs, i, i2);
                AppMethodBeat.m2505o(50743);
            }
        }
    }

    public C18709m() {
        AppMethodBeat.m2504i(50744);
        AppMethodBeat.m2505o(50744);
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

    /* renamed from: i */
    static /* synthetic */ void m29254i(C18709m c18709m) {
        AppMethodBeat.m2504i(50751);
        c18709m.m29241Fb();
        AppMethodBeat.m2505o(50751);
    }

    /* renamed from: ak */
    public static void m29244ak(List<C26493s> list) {
        AppMethodBeat.m2504i(50745);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(50745);
            return;
        }
        for (C26493s fileName : list) {
            C26494u.m42261um(fileName.getFileName());
        }
        AppMethodBeat.m2505o(50745);
    }

    /* renamed from: al */
    public static void m29245al(List<C26493s> list) {
        AppMethodBeat.m2504i(50746);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(50746);
            return;
        }
        for (C26493s fileName : list) {
            C26494u.m42262un(fileName.getFileName());
        }
        AppMethodBeat.m2505o(50746);
    }

    /* renamed from: fT */
    private String m29251fT(long j) {
        AppMethodBeat.m2504i(50747);
        List<C26493s> fU = C37961o.all().mo21061fU(j);
        if (fU.isEmpty()) {
            C4990ab.m7412e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
            AppMethodBeat.m2505o(50747);
            return null;
        }
        C26493s c26493s;
        for (C26493s c26493s2 : fU) {
            if (C1855t.m3924nJ(c26493s2.getUser())) {
                C4990ab.m7421w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", c26493s2.getUser(), c26493s2.fXl, Long.valueOf(j));
                AppMethodBeat.m2505o(50747);
                return null;
            }
            C37461f.afx();
            if (!C31259b.m50439lg(2) && c26493s2.fXi != 1) {
                r3 = new Object[4];
                C37461f.afx();
                r3[0] = Boolean.valueOf(C31259b.m50439lg(2));
                r3[1] = Integer.valueOf(c26493s2.fXi);
                r3[2] = c26493s2.fXl;
                r3[3] = Long.valueOf(j);
                C4990ab.m7421w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", r3);
                AppMethodBeat.m2505o(50747);
                return null;
            }
        }
        if (fU != null && !fU.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= fU.size()) {
                    c26493s2 = null;
                    break;
                }
                C26493s ut = C26494u.m42268ut(((C26493s) fU.get(i2)).getFileName());
                if (ut != null) {
                    C4990ab.m7417i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", c26493s2.getFileName(), Integer.valueOf(i2), Integer.valueOf(fU.size()), Long.valueOf(j), c26493s2.fXl);
                    fU.remove(i2);
                    fU.add(i2, ut);
                    c26493s2 = ut;
                    break;
                }
                C4990ab.m7421w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", c26493s2.getFileName(), Integer.valueOf(i2), Integer.valueOf(fU.size()), Long.valueOf(j), c26493s2.fXl);
                i = i2 + 1;
            }
        } else {
            c26493s2 = null;
        }
        if (c26493s2 == null) {
            C4990ab.m7420w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
            AppMethodBeat.m2505o(50747);
            return null;
        }
        String a = C37458c.m63162a("upvideo", c26493s2.createTime, c26493s2.fXl, c26493s2.getFileName());
        if (C5046bo.isNullOrNil(a)) {
            C4990ab.m7421w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", c26493s2.getFileName(), Long.valueOf(c26493s2.fVs), c26493s2.fXl);
            AppMethodBeat.m2505o(50747);
            return null;
        }
        String fileName = c26493s2.getFileName();
        C37961o.all();
        String ui = C9720t.m17304ui(fileName);
        C37961o.all();
        fileName = C9720t.m17303uh(fileName);
        C18713a c18713a = new C18713a(this, (byte) 0);
        c18713a.foD = fU;
        c18713a.fVs = j;
        c18713a.fWl = a;
        c18713a.startTime = C5046bo.anU();
        c18713a.fVt = c26493s2;
        C42130g c42130g = new C42130g();
        c42130g.egl = c18713a;
        c42130g.field_mediaId = a;
        c42130g.field_fullpath = fileName;
        c42130g.field_thumbpath = ui;
        c42130g.field_fileType = C42129a.MediaType_VIDEO;
        c42130g.field_smallVideoFlag = 1;
        c42130g.field_talker = c26493s2.fXl;
        c42130g.field_priority = C42129a.efC;
        c42130g.field_needStorage = false;
        c42130g.field_isStreamMedia = false;
        Map z = C5049br.m7595z(c26493s2.alw(), "msg");
        if (z != null) {
            c42130g.field_fileId = (String) z.get(".msg.videomsg.$cdnvideourl");
            c42130g.field_aesKey = (String) z.get(".msg.videomsg.$aeskey");
        } else {
            C4990ab.m7416i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
        }
        if (C37461f.afx().mo51225e(c42130g)) {
            for (C26493s c26493s22 : fU) {
                if (c26493s22.fXi != 1) {
                    c26493s22.fXi = 1;
                    c26493s22.bJt = SQLiteGlobal.journalSizeLimit;
                    boolean f = C26494u.m42253f(c26493s22);
                    C4990ab.m7417i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", c26493s22.getFileName(), Boolean.valueOf(f));
                }
            }
            AppMethodBeat.m2505o(50747);
            return a;
        }
        C4990ab.m7412e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
        AppMethodBeat.m2505o(50747);
        return null;
    }

    /* renamed from: e */
    public final void mo33974e(long j, int i, int i2) {
        AppMethodBeat.m2504i(50748);
        final long j2 = j;
        final int i3 = i;
        final int i4 = i2;
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(50735);
                C18709m.alh();
                C18709m.this.cqU = false;
                C18709m.this.fWi = "";
                long j = 0;
                if (j2 > 0 && C18709m.this.fWf.get(Long.valueOf(j2)) != null) {
                    j = ((C1446a) C18709m.this.fWf.get(Long.valueOf(j2))).mo4908Mr();
                }
                C4990ab.m7417i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4));
                if (!(i3 == 0 && i4 == 0)) {
                    C18709m.this.cqV = C18709m.this.cqV - 1;
                }
                C4990ab.m7417i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", Integer.valueOf(C18709m.cqX), Integer.valueOf(C18709m.this.cqV), Boolean.valueOf(C18709m.this.running), Boolean.valueOf(C18709m.this.cqU));
                if (C18709m.this.cqV > 0) {
                    C18709m.m29253h(C18709m.this);
                } else if (!C18709m.this.cqU) {
                    C4990ab.m7420w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
                    C9720t all = C37961o.all();
                    LinkedList k = C18709m.this.fWe;
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
                        C4990ab.m7417i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status=198, lastmodifytime=" + currentTimeMillis + " WHERE masssendid IN " + stringBuilder.toString());
                        all.fni.mo10108hY("videoinfo2", r0);
                    }
                    C18709m.m29254i(C18709m.this);
                }
                C18709m.ali();
                AppMethodBeat.m2505o(50735);
            }

            public final String toString() {
                AppMethodBeat.m2504i(50736);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.m2505o(50736);
                return str;
            }
        });
        AppMethodBeat.m2505o(50748);
    }

    /* renamed from: Fb */
    private void m29241Fb() {
        AppMethodBeat.m2504i(50749);
        this.fWg.clear();
        this.fWf.clear();
        this.fWe.clear();
        this.cqU = false;
        this.running = false;
        C4990ab.m7410d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.cqZ.mo4908Mr());
        AppMethodBeat.m2505o(50749);
    }

    /* renamed from: h */
    static /* synthetic */ void m29253h(C18709m c18709m) {
        AppMethodBeat.m2504i(50750);
        if (!c18709m.cqU && c18709m.fWe.isEmpty()) {
            List<C26493s> alB = C37961o.all().alB();
            if (alB.isEmpty()) {
                C4990ab.m7410d("MicroMsg.SightMassSendService", "unfinish massinfo count 0");
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (C26493s c26493s : alB) {
                    if (c18709m.fWf.containsKey(Long.valueOf(c26493s.fVs))) {
                        C4990ab.m7411d("MicroMsg.SightMassSendService", "Mass Send File is Already running %s, massSendId %d", c26493s.getFileName(), Long.valueOf(c26493s.fVs));
                    } else {
                        C4990ab.m7410d("MicroMsg.SightMassSendService", "Get file:" + c26493s.getFileName() + " status:" + c26493s.status + " user" + c26493s.getUser() + " human:" + c26493s.alt() + " massSendId:" + c26493s.fVs + " massSendList:" + c26493s.fXl + " create:" + C5046bo.m7579mx(c26493s.createTime) + " last:" + C5046bo.m7579mx(c26493s.fXb) + " now:" + C5046bo.m7579mx(currentTimeMillis) + " " + (currentTimeMillis - c26493s.fXb));
                        if (c26493s.status == 200) {
                            c18709m.fWe.offer(Long.valueOf(c26493s.fVs));
                            c18709m.fWf.put(Long.valueOf(c26493s.fVs), null);
                        }
                    }
                }
                C4990ab.m7410d("MicroMsg.SightMassSendService", "GetNeedRun procing:" + c18709m.fWf.size() + " [send:" + c18709m.fWe.size() + "]");
                c18709m.fWe.size();
            }
        }
        if (c18709m.cqU || !c18709m.fWe.isEmpty()) {
            if (!c18709m.cqU && c18709m.fWe.size() > 0) {
                Long l = (Long) c18709m.fWe.poll();
                C4990ab.m7411d("MicroMsg.SightMassSendService", "Start Mass Send, ID: %s", l);
                if (l != null) {
                    c18709m.fWf.put(l, new C1446a());
                    c18709m.cqU = true;
                    c18709m.fWi = c18709m.m29251fT(l.longValue());
                    if (c18709m.fWi == null) {
                        c18709m.cqU = false;
                        c18709m.cra.mo16770ae(10, 10);
                        AppMethodBeat.m2505o(50750);
                        return;
                    }
                    c18709m.fWg.put(l, c18709m.fWi);
                }
            }
            AppMethodBeat.m2505o(50750);
            return;
        }
        c18709m.m29241Fb();
        C4990ab.m7410d("MicroMsg.SightMassSendService", "No Data Any More , Stop Service");
        AppMethodBeat.m2505o(50750);
    }
}
