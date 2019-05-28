package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.view.ViewGroup;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9715b;
import com.tencent.p177mm.modelvideo.C9715b.C9714a;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p235i.C44686h.C26326a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.p878a.C45479b;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.topstory.p539a.C29426a.C29427a;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C29428a;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13979m.C13980d;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13979m.C13981a;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13979m.C13982c;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23325c;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.protocal.protobuf.chx;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.r */
public final class C39996r {
    C4232b sDo;
    private int sEV = 0;
    private boolean sFA;
    private boolean sFB;
    private C42192d sFs = new C42192d();
    C43699q sFt;
    public C35305f sFu;
    public chw sFv;
    public boolean sFw;
    public boolean sFx;
    public boolean sFy = false;
    private C42190a sFz = new C139911();

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.r$1 */
    class C139911 implements C42190a {
        C139911() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.r$a */
    class C39993a implements C26326a {
        boolean sFD;
        private boolean sFE;

        private C39993a() {
        }

        /* synthetic */ C39993a(C39996r c39996r, byte b) {
            this();
        }

        public final void onMoovReady(final String str, final int i, final int i2) {
            AppMethodBeat.m2504i(1827);
            if (this.sFD) {
                AppMethodBeat.m2505o(1827);
                return;
            }
            this.sFD = true;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(1823);
                    if (!(C39996r.this.sFt == null || C39996r.this.sDo == null)) {
                        C29428a c29428a = C39996r.this.sDo.cFR().sFp;
                        if (c29428a != null && c29428a.sAR == 0) {
                            c29428a.sAR = System.currentTimeMillis() - c29428a.sAE;
                            c29428a.sAS = (long) i;
                            c29428a.sAT = (long) (i + i2);
                            C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", Long.valueOf(c29428a.sAR), Integer.valueOf(i), Integer.valueOf(i2));
                        }
                        C39996r.this.sFt.mo21050ml(i);
                    }
                    AppMethodBeat.m2505o(1823);
                }
            });
            AppMethodBeat.m2505o(1827);
        }

        public final void onDataAvailable(final String str, final int i, final int i2) {
            AppMethodBeat.m2504i(1828);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(1824);
                    if (C39996r.this.sFt != null) {
                        C39996r.this.sFt.onDataAvailable(str, i, i2);
                    }
                    AppMethodBeat.m2505o(1824);
                }
            });
            AppMethodBeat.m2505o(1828);
        }

        /* renamed from: h */
        public final void mo8706h(final String str, final int i, final int i2) {
            AppMethodBeat.m2504i(1829);
            if (C39996r.this.sDo != null) {
                C13979m cFU = C39996r.this.sDo.cFU();
                long j = (long) i;
                long j2 = (long) i2;
                if (cFU.sET.containsKey(str)) {
                    chx chx = (chx) cFU.sET.get(str);
                    chx.cHr = str;
                    chx.xha = j2;
                    chx.xhj = j;
                    chx.xhk = C13979m.m22110aa(chx.xhj, chx.xha);
                    cFU.sET.put(str, chx);
                }
            }
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(1825);
                    if (C39996r.this.sFt != null) {
                        C39996r.this.sFt.mo9075h(str, i, i2);
                    }
                    if (C39996r.m68495ab((long) ((i * 100) / i2), (long) i)) {
                        C39993a.this.cHa();
                    }
                    AppMethodBeat.m2505o(1825);
                }
            });
            AppMethodBeat.m2505o(1829);
        }

        public final void cHa() {
            AppMethodBeat.m2504i(1830);
            if (!(this.sFE || C39996r.this.sFv == null || C39996r.this.sDo == null || (!C39996r.this.sDo.cFQ().bkJ() && !C39964g.cFp()))) {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
                this.sFE = true;
                C13979m cFU = C39996r.this.sDo.cFU();
                chw chw = C39996r.this.sFv;
                C13986n cGg = cFU.sDo.cGg();
                ArrayList<chw> arrayList = new ArrayList();
                synchronized (cGg) {
                    try {
                        int i;
                        int size = cGg.cGQ().size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (chw.xgS.equals(((chw) cGg.cGQ().get(i2)).xgS)) {
                                i = i2;
                                break;
                            }
                        }
                        i = -1;
                        if (i >= 0 && i + 1 < size) {
                            for (i++; i < size; i++) {
                                arrayList.add(cGg.cGQ().get(i));
                            }
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(1830);
                        }
                    }
                }
                HashMap hashMap = new HashMap();
                for (chw chw2 : arrayList) {
                    Object obj;
                    String au = C4210c.m6559au(chw2.xgS, chw2.xgT);
                    if (cFU.sET.containsKey(au)) {
                        obj = (chx) cFU.sET.get(au);
                    } else {
                        obj = new chx();
                        obj.cHr = au;
                        obj.xha = chw2.xha;
                    }
                    hashMap.put(au, obj);
                    int aa = (int) C13979m.m22110aa(C29427a.sAD.longValue(), chw2.xha);
                    if (aa < 20) {
                        aa = 20;
                    } else if (aa > 100) {
                        aa = 100;
                    }
                    if (obj.xhk < ((long) aa)) {
                        String str = cFU.sDo.cFS() + au + VideoMaterialUtil.MP4_SUFFIX;
                        String str2 = chw2.videoUrl;
                        C44686h c44686h = new C44686h();
                        c44686h.field_mediaId = au;
                        c44686h.url = str2;
                        c44686h.egx = 2;
                        c44686h.egD = 2;
                        c44686h.egy = 3;
                        c44686h.egI = aa;
                        c44686h.field_preloadRatio = aa;
                        c44686h.concurrentCount = 4;
                        c44686h.field_fullpath = str;
                        c44686h.egl = new C13980d(cFU, (byte) 0);
                        c44686h.egz = new C13982c(cFU, (byte) 0);
                        C37461f.afx().mo51222b(c44686h, -1);
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", au, Long.valueOf(obj.xhk), Integer.valueOf(aa));
                    } else {
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", au, Long.valueOf(obj.xhk));
                    }
                    if (hashMap.size() == 6) {
                        break;
                    }
                }
                cFU.sEU.clear();
                cFU.sEU.addAll(hashMap.keySet());
                cFU.sET.putAll(hashMap);
                C7305d.post(new C13981a(cFU.sES), "TopStory.DeleteVideoCacheTask");
            }
            AppMethodBeat.m2505o(1830);
        }

        /* renamed from: a */
        public final void mo8705a(final String str, int i, C9545d c9545d) {
            AppMethodBeat.m2504i(1831);
            if (C39964g.cFm() && C39996r.this.sFy) {
                C39996r.this.sFy = false;
                i = 404;
            }
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", str, Integer.valueOf(i));
            if (C39996r.this.sDo != null) {
                C13979m cFU = C39996r.this.sDo.cFU();
                if (cFU.sET.containsKey(str)) {
                    chx chx = (chx) cFU.sET.get(str);
                    if (i == 0) {
                        chx.cHr = str;
                        chx.xhj = chx.xha;
                        chx.xhk = C13979m.m22110aa(chx.xhj, chx.xha);
                        cFU.sET.put(str, chx);
                    }
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", str, Long.valueOf(chx.xhk), C5046bo.m7526b(chx.xhj, 100.0d), Integer.valueOf(i));
                }
            }
            int i2 = 0;
            try {
                i2 = C39996r.this.sDo.cGg().mo26218FL(C39996r.this.sDo.cFY()).xhg;
            } catch (Exception e) {
            }
            int Me = C13986n.m22116Me();
            if (c9545d == null) {
                c9545d = new C9545d();
            }
            String str2 = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
            Object[] objArr = new Object[17];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(2);
            objArr[3] = Long.valueOf(c9545d.field_startTime);
            objArr[4] = Long.valueOf(c9545d.field_endTime);
            objArr[5] = Integer.valueOf(c9545d.field_averageSpeed);
            objArr[6] = Integer.valueOf(c9545d.field_averageConnectCost);
            objArr[7] = Integer.valueOf(c9545d.field_firstConnectCost);
            objArr[8] = Integer.valueOf(c9545d.field_moovFailReason);
            objArr[9] = Integer.valueOf(c9545d.field_httpStatusCode);
            objArr[10] = c9545d.field_clientIP;
            objArr[11] = c9545d.field_serverIP;
            objArr[12] = c9545d.field_xErrorNo;
            objArr[13] = Integer.valueOf(c9545d.field_cSeqCheck);
            objArr[14] = Integer.valueOf(c9545d.field_isCrossNet ? 1 : 0);
            objArr[15] = Integer.valueOf(c9545d.field_usePrivateProtocol ? 1 : 0);
            objArr[16] = Integer.valueOf(Me);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryCdnDownloadError 16270 %s", String.format(str2, objArr));
            C7053e.pXa.mo8374X(16270, r0);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(1826);
                    if (!(C39996r.this.sFt == null || C39996r.this.sDo == null)) {
                        C29428a c29428a = C39996r.this.sDo.cFR().sFp;
                        if (c29428a != null && c29428a.sAQ == 0) {
                            c29428a.sAQ = System.currentTimeMillis() - c29428a.sAE;
                        }
                        C39996r.this.sFt.mo9058ad(str, i);
                        if (i != 0) {
                            C14419a.m22633kT(9);
                            AppMethodBeat.m2505o(1826);
                            return;
                        }
                        C14419a.m22633kT(27);
                    }
                    AppMethodBeat.m2505o(1826);
                }
            });
            AppMethodBeat.m2505o(1831);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.r$c */
    class C39995c implements C23325c {
        private C39995c() {
        }

        /* synthetic */ C39995c(C39996r c39996r, byte b) {
            this();
        }

        /* renamed from: gp */
        public final void mo26918gp(long j) {
            AppMethodBeat.m2504i(1836);
            C7053e.pXa.mo8378a(600, j, 1, false);
            AppMethodBeat.m2505o(1836);
        }

        /* renamed from: wB */
        public final void mo26927wB(String str) {
            AppMethodBeat.m2504i(1837);
            C7053e.pXa.mo8374X(14349, str);
            AppMethodBeat.m2505o(1837);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.r$b */
    class C39997b implements C9715b {
        private chx sFG;

        private C39997b() {
        }

        /* synthetic */ C39997b(C39996r c39996r, byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x014e  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0081  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: r */
        public final void mo8715r(String str, String str2, String str3) {
            chx chx;
            C39993a c39993a;
            AppMethodBeat.m2504i(1832);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", str, str2);
            C13979m cFU = C39996r.this.sDo.cFU();
            C29428a c29428a = cFU.sDo.cFR().sFp;
            if (c29428a != null) {
                if (cFU.sET.containsKey(str)) {
                    chx = (chx) cFU.sET.get(str);
                    if (chx.xhk >= 5) {
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", str, Long.valueOf(chx.xhk), C5046bo.m7580my(chx.xhj));
                        c29428a.sAM = 1;
                        c29428a.sAN = chx.xhk;
                        c29428a.sAO = chx.xhj;
                        C14419a.m22633kT(25);
                        this.sFG = chx;
                        c39993a = new C39993a(C39996r.this, (byte) 0);
                        if (this.sFG == null) {
                            boolean queryVideoMoovInfo;
                            long[] jArr = new long[2];
                            if (this.sFG.xhk < 100) {
                                C37961o.alm().mo73060a(C39996r.m68494a(str, str3, str2, c39993a), false);
                                C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
                                c2CDownloadRequest.fileKey = str;
                                c2CDownloadRequest.fileType = 90;
                                c2CDownloadRequest.url = str3;
                                c2CDownloadRequest.savePath = str2;
                                queryVideoMoovInfo = CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr);
                            } else {
                                queryVideoMoovInfo = true;
                                jArr[0] = new C45479b().mo73275vB(str2);
                            }
                            C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", str, Boolean.valueOf(queryVideoMoovInfo));
                            if (queryVideoMoovInfo && !c39993a.sFD) {
                                c39993a.onMoovReady(str, (int) jArr[0], (int) jArr[1]);
                            }
                            if (C39996r.m68495ab(this.sFG.xhk, this.sFG.xhj)) {
                                c39993a.cHa();
                            }
                            if (this.sFG.xhk == 100) {
                                c39993a.mo8706h(str, (int) this.sFG.xhj, (int) this.sFG.xha);
                                c39993a.mo8705a(str, 0, null);
                            }
                            AppMethodBeat.m2505o(1832);
                            return;
                        }
                        C37961o.alm().mo73060a(C39996r.m68494a(str, str3, str2, c39993a), false);
                        AppMethodBeat.m2505o(1832);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", str, Long.valueOf(chx.xhk), C5046bo.m7580my(chx.xhj));
                    c29428a.sAM = 3;
                } else {
                    chx = new chx();
                    chx.cHr = str;
                    cFU.sET.put(str, chx);
                }
            }
            cFU.cGP();
            chx = null;
            this.sFG = chx;
            c39993a = new C39993a(C39996r.this, (byte) 0);
            if (this.sFG == null) {
            }
        }

        /* renamed from: dV */
        public final void mo8713dV(String str) {
            AppMethodBeat.m2504i(1833);
            C37961o.alm().mo73064m(str, null);
            AppMethodBeat.m2505o(1833);
        }

        public final void requestVideoData(String str, int i, int i2) {
            AppMethodBeat.m2504i(1834);
            if (this.sFG == null || ((long) (i + i2)) > this.sFG.xhj) {
                C37961o.alm();
                C45150e.m83031k(str, i, i2);
                AppMethodBeat.m2505o(1834);
                return;
            }
            AppMethodBeat.m2505o(1834);
        }

        public final boolean isVideoDataAvailable(String str, int i, int i2) {
            boolean z;
            AppMethodBeat.m2504i(1835);
            if (this.sFG == null || ((long) (i + i2)) > this.sFG.xhj) {
                z = false;
            } else {
                z = true;
            }
            if (i == 0 && z && C39996r.this.sDo != null) {
                C29428a c29428a = C39996r.this.sDo.cFR().sFp;
                if (c29428a != null && c29428a.sAU == 0) {
                    c29428a.sAU = System.currentTimeMillis() - c29428a.sAE;
                    c29428a.sAV = (long) i;
                    c29428a.sAW = (long) (i + i2);
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", Long.valueOf(c29428a.sAR), Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
            if (!z) {
                z = C37961o.alm().isVideoDataAvailable(str, i, i2);
            }
            AppMethodBeat.m2505o(1835);
            return z;
        }

        /* renamed from: a */
        public final void mo8712a(C9714a c9714a) {
        }
    }

    public C39996r() {
        AppMethodBeat.m2504i(1838);
        AppMethodBeat.m2505o(1838);
    }

    /* renamed from: a */
    public final void mo63217a(C35305f c35305f, C35873d c35873d) {
        AppMethodBeat.m2504i(1839);
        if (c35305f == this.sFu || this.sDo == null) {
            AppMethodBeat.m2505o(1839);
            return;
        }
        if (this.sFt == null) {
            this.sFt = cGX();
        }
        cGW();
        c35305f.getVideoViewParent().addView(this.sFt);
        this.sFt.setVideoFooterView(c35305f.getControlBar());
        this.sFt.setScaleType(c35873d);
        this.sFt.setIMMVideoViewCallback(c35305f.getVideoViewCallback());
        this.sFs.mo67732a(this.sFz);
        this.sFu = c35305f;
        AppMethodBeat.m2505o(1839);
    }

    /* renamed from: a */
    public final void mo63216a(C4232b c4232b, chw chw, String str, int i) {
        AppMethodBeat.m2504i(1840);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", chw.xgS, chw.title, str);
        c4232b.cFR().mo74503b(c4232b.cFT());
        c4232b.cFR().cGS();
        c4232b.cFR().mo74501a(chw, i, str);
        this.sFt.setKeepScreenOn(true);
        this.sFt.cGV();
        this.sFt.abJ(str);
        this.sFv = chw;
        this.sFw = true;
        this.sFx = false;
        AppMethodBeat.m2505o(1840);
    }

    private void cGW() {
        AppMethodBeat.m2504i(1841);
        if (this.sFt.getParent() != null) {
            ((ViewGroup) this.sFt.getParent()).removeView(this.sFt);
        }
        AppMethodBeat.m2505o(1841);
    }

    private C43699q cGX() {
        AppMethodBeat.m2504i(1842);
        C43699q c43699q = new C43699q(this.sDo.bKU(), this.sDo);
        c43699q.setRootPath(this.sDo.cFS());
        c43699q.setIOnlineVideoProxy(new C39997b(this, (byte) 0));
        c43699q.setReporter(new C39995c(this, (byte) 0));
        AppMethodBeat.m2505o(1842);
        return c43699q;
    }

    private void clU() {
        AppMethodBeat.m2504i(1843);
        this.sFs.mo67732a(this.sFz);
        AppMethodBeat.m2505o(1843);
    }

    private void cGY() {
        AppMethodBeat.m2504i(1844);
        this.sFs.mo67733cy(false);
        AppMethodBeat.m2505o(1844);
    }

    public final boolean cGZ() {
        AppMethodBeat.m2504i(1845);
        if (this.sFt != null) {
            boolean isPlaying = this.sFt.isPlaying();
            AppMethodBeat.m2505o(1845);
            return isPlaying;
        }
        AppMethodBeat.m2505o(1845);
        return false;
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(1846);
        if (this.sFt != null) {
            this.sFt.setMute(z);
        }
        AppMethodBeat.m2505o(1846);
    }

    public final void cEf() {
        AppMethodBeat.m2504i(1847);
        if (this.sFt != null) {
            clU();
            this.sFt.setKeepScreenOn(true);
            this.sFt.play();
            this.sFx = false;
        }
        AppMethodBeat.m2505o(1847);
    }

    public final void cpN() {
        AppMethodBeat.m2504i(1848);
        if (this.sFt != null) {
            cGY();
            this.sFt.setKeepScreenOn(false);
            this.sFt.pause();
            this.sFx = true;
        }
        AppMethodBeat.m2505o(1848);
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(1849);
        if (this.sFt != null) {
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
            cGY();
            this.sFt.cGU();
            this.sFt.setKeepScreenOn(false);
            this.sFt.stop();
            this.sFv = null;
            this.sFw = false;
            this.sFx = false;
            if (this.sDo != null) {
                this.sDo.cFR().mo74503b(this.sDo.cFT());
                this.sDo.cFR().cGS();
            }
            if (this.sFu != null) {
                this.sFu.cGt();
            }
        }
        AppMethodBeat.m2505o(1849);
    }

    /* renamed from: d */
    public final void mo63225d(C4232b c4232b) {
        this.sEV++;
        this.sDo = c4232b;
    }

    public final void akW() {
        AppMethodBeat.m2504i(1850);
        if (this.sFt != null) {
            this.sFt.akW();
            if (this.sFu != null) {
                this.sFu.cGs();
            }
        }
        AppMethodBeat.m2505o(1850);
    }

    public final void akV() {
        AppMethodBeat.m2504i(1851);
        if (this.sFt != null) {
            this.sFt.akV();
        }
        AppMethodBeat.m2505o(1851);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(1852);
        this.sEV--;
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", Integer.valueOf(this.sEV));
        if (this.sEV <= 0) {
            if (this.sFt != null) {
                stopPlay();
                this.sFt.aEX();
            }
            this.sDo = null;
        }
        AppMethodBeat.m2505o(1852);
    }

    public final void onError(String str) {
        AppMethodBeat.m2504i(1853);
        if (this.sFt != null && this.sFt.getSessionId().equals(str)) {
            stopPlay();
        }
        AppMethodBeat.m2505o(1853);
    }

    /* renamed from: fT */
    public final void mo63226fT(int i, int i2) {
        AppMethodBeat.m2504i(1854);
        if (i == 0) {
            if (this.sFw && this.sFB) {
                this.sFB = false;
                cEf();
                AppMethodBeat.m2505o(1854);
                return;
            }
        } else if (i2 == 0) {
            if (this.sFw && cGZ()) {
                this.sFB = true;
                cpN();
                AppMethodBeat.m2505o(1854);
                return;
            }
        } else if (i2 == 1 && this.sFA && this.sFw && this.sFx) {
            this.sFA = false;
            cEf();
            this.sFu.cGp();
        }
        AppMethodBeat.m2505o(1854);
    }

    public final void abK(String str) {
        AppMethodBeat.m2504i(1855);
        C29428a c29428a = this.sDo.cFR().sFp;
        if (c29428a != null) {
            c29428a.sAI = 1;
        }
        if (this.sFt != null && this.sFt.getSessionId().equals(str)) {
            stopPlay();
        }
        C14419a.m22633kT(26);
        AppMethodBeat.m2505o(1855);
    }

    public final int getCurrPosSec() {
        AppMethodBeat.m2504i(1856);
        if (this.sFt != null) {
            int currPosSec = this.sFt.getCurrPosSec();
            AppMethodBeat.m2505o(1856);
            return currPosSec;
        }
        AppMethodBeat.m2505o(1856);
        return 0;
    }

    public final int getVideoDurationSec() {
        AppMethodBeat.m2504i(1857);
        if (this.sFt != null) {
            int videoDurationSec = this.sFt.getVideoDurationSec();
            AppMethodBeat.m2505o(1857);
            return videoDurationSec;
        }
        AppMethodBeat.m2505o(1857);
        return 0;
    }

    public final int getCurrPosMs() {
        AppMethodBeat.m2504i(1858);
        if (this.sFt != null) {
            int currPosMs = this.sFt.getCurrPosMs();
            AppMethodBeat.m2505o(1858);
            return currPosMs;
        }
        AppMethodBeat.m2505o(1858);
        return 0;
    }

    /* renamed from: ab */
    public static boolean m68495ab(long j, long j2) {
        if (j >= 50 || j2 > 5242880) {
            return true;
        }
        return false;
    }
}
