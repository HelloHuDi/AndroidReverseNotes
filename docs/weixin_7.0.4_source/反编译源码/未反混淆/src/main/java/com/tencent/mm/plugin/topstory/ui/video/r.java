package com.tencent.mm.plugin.topstory.ui.video;

import android.view.ViewGroup;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.h;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;

public final class r {
    b sDo;
    private int sEV = 0;
    private boolean sFA;
    private boolean sFB;
    private d sFs = new d();
    q sFt;
    public f sFu;
    public chw sFv;
    public boolean sFw;
    public boolean sFx;
    public boolean sFy = false;
    private com.tencent.mm.model.d.a sFz = new com.tencent.mm.model.d.a() {
    };

    class a implements com.tencent.mm.i.h.a {
        boolean sFD;
        private boolean sFE;

        private a() {
        }

        /* synthetic */ a(r rVar, byte b) {
            this();
        }

        public final void onMoovReady(final String str, final int i, final int i2) {
            AppMethodBeat.i(1827);
            if (this.sFD) {
                AppMethodBeat.o(1827);
                return;
            }
            this.sFD = true;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(1823);
                    if (!(r.this.sFt == null || r.this.sDo == null)) {
                        com.tencent.mm.plugin.topstory.a.b.a aVar = r.this.sDo.cFR().sFp;
                        if (aVar != null && aVar.sAR == 0) {
                            aVar.sAR = System.currentTimeMillis() - aVar.sAE;
                            aVar.sAS = (long) i;
                            aVar.sAT = (long) (i + i2);
                            ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", Long.valueOf(aVar.sAR), Integer.valueOf(i), Integer.valueOf(i2));
                        }
                        r.this.sFt.ml(i);
                    }
                    AppMethodBeat.o(1823);
                }
            });
            AppMethodBeat.o(1827);
        }

        public final void onDataAvailable(final String str, final int i, final int i2) {
            AppMethodBeat.i(1828);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(1824);
                    if (r.this.sFt != null) {
                        r.this.sFt.onDataAvailable(str, i, i2);
                    }
                    AppMethodBeat.o(1824);
                }
            });
            AppMethodBeat.o(1828);
        }

        public final void h(final String str, final int i, final int i2) {
            AppMethodBeat.i(1829);
            if (r.this.sDo != null) {
                m cFU = r.this.sDo.cFU();
                long j = (long) i;
                long j2 = (long) i2;
                if (cFU.sET.containsKey(str)) {
                    chx chx = (chx) cFU.sET.get(str);
                    chx.cHr = str;
                    chx.xha = j2;
                    chx.xhj = j;
                    chx.xhk = m.aa(chx.xhj, chx.xha);
                    cFU.sET.put(str, chx);
                }
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(1825);
                    if (r.this.sFt != null) {
                        r.this.sFt.h(str, i, i2);
                    }
                    if (r.ab((long) ((i * 100) / i2), (long) i)) {
                        a.this.cHa();
                    }
                    AppMethodBeat.o(1825);
                }
            });
            AppMethodBeat.o(1829);
        }

        public final void cHa() {
            AppMethodBeat.i(1830);
            if (!(this.sFE || r.this.sFv == null || r.this.sDo == null || (!r.this.sDo.cFQ().bkJ() && !g.cFp()))) {
                ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
                this.sFE = true;
                m cFU = r.this.sDo.cFU();
                chw chw = r.this.sFv;
                n cGg = cFU.sDo.cGg();
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
                            AppMethodBeat.o(1830);
                        }
                    }
                }
                HashMap hashMap = new HashMap();
                for (chw chw2 : arrayList) {
                    Object obj;
                    String au = com.tencent.mm.plugin.topstory.ui.c.au(chw2.xgS, chw2.xgT);
                    if (cFU.sET.containsKey(au)) {
                        obj = (chx) cFU.sET.get(au);
                    } else {
                        obj = new chx();
                        obj.cHr = au;
                        obj.xha = chw2.xha;
                    }
                    hashMap.put(au, obj);
                    int aa = (int) m.aa(com.tencent.mm.plugin.topstory.a.a.a.sAD.longValue(), chw2.xha);
                    if (aa < 20) {
                        aa = 20;
                    } else if (aa > 100) {
                        aa = 100;
                    }
                    if (obj.xhk < ((long) aa)) {
                        String str = cFU.sDo.cFS() + au + VideoMaterialUtil.MP4_SUFFIX;
                        String str2 = chw2.videoUrl;
                        h hVar = new h();
                        hVar.field_mediaId = au;
                        hVar.url = str2;
                        hVar.egx = 2;
                        hVar.egD = 2;
                        hVar.egy = 3;
                        hVar.egI = aa;
                        hVar.field_preloadRatio = aa;
                        hVar.concurrentCount = 4;
                        hVar.field_fullpath = str;
                        hVar.egl = new d(cFU, (byte) 0);
                        hVar.egz = new c(cFU, (byte) 0);
                        f.afx().b(hVar, -1);
                        ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", au, Long.valueOf(obj.xhk), Integer.valueOf(aa));
                    } else {
                        ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", au, Long.valueOf(obj.xhk));
                    }
                    if (hashMap.size() == 6) {
                        break;
                    }
                }
                cFU.sEU.clear();
                cFU.sEU.addAll(hashMap.keySet());
                cFU.sET.putAll(hashMap);
                com.tencent.mm.sdk.g.d.post(new a(cFU.sES), "TopStory.DeleteVideoCacheTask");
            }
            AppMethodBeat.o(1830);
        }

        public final void a(final String str, int i, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(1831);
            if (g.cFm() && r.this.sFy) {
                r.this.sFy = false;
                i = 404;
            }
            ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", str, Integer.valueOf(i));
            if (r.this.sDo != null) {
                m cFU = r.this.sDo.cFU();
                if (cFU.sET.containsKey(str)) {
                    chx chx = (chx) cFU.sET.get(str);
                    if (i == 0) {
                        chx.cHr = str;
                        chx.xhj = chx.xha;
                        chx.xhk = m.aa(chx.xhj, chx.xha);
                        cFU.sET.put(str, chx);
                    }
                    ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", str, Long.valueOf(chx.xhk), bo.b(chx.xhj, 100.0d), Integer.valueOf(i));
                }
            }
            int i2 = 0;
            try {
                i2 = r.this.sDo.cGg().FL(r.this.sDo.cFY()).xhg;
            } catch (Exception e) {
            }
            int Me = n.Me();
            if (dVar == null) {
                dVar = new com.tencent.mm.i.d();
            }
            String str2 = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
            Object[] objArr = new Object[17];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(2);
            objArr[3] = Long.valueOf(dVar.field_startTime);
            objArr[4] = Long.valueOf(dVar.field_endTime);
            objArr[5] = Integer.valueOf(dVar.field_averageSpeed);
            objArr[6] = Integer.valueOf(dVar.field_averageConnectCost);
            objArr[7] = Integer.valueOf(dVar.field_firstConnectCost);
            objArr[8] = Integer.valueOf(dVar.field_moovFailReason);
            objArr[9] = Integer.valueOf(dVar.field_httpStatusCode);
            objArr[10] = dVar.field_clientIP;
            objArr[11] = dVar.field_serverIP;
            objArr[12] = dVar.field_xErrorNo;
            objArr[13] = Integer.valueOf(dVar.field_cSeqCheck);
            objArr[14] = Integer.valueOf(dVar.field_isCrossNet ? 1 : 0);
            objArr[15] = Integer.valueOf(dVar.field_usePrivateProtocol ? 1 : 0);
            objArr[16] = Integer.valueOf(Me);
            ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryCdnDownloadError 16270 %s", String.format(str2, objArr));
            e.pXa.X(16270, r0);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(1826);
                    if (!(r.this.sFt == null || r.this.sDo == null)) {
                        com.tencent.mm.plugin.topstory.a.b.a aVar = r.this.sDo.cFR().sFp;
                        if (aVar != null && aVar.sAQ == 0) {
                            aVar.sAQ = System.currentTimeMillis() - aVar.sAE;
                        }
                        r.this.sFt.ad(str, i);
                        if (i != 0) {
                            com.tencent.mm.plugin.websearch.api.a.a.kT(9);
                            AppMethodBeat.o(1826);
                            return;
                        }
                        com.tencent.mm.plugin.websearch.api.a.a.kT(27);
                    }
                    AppMethodBeat.o(1826);
                }
            });
            AppMethodBeat.o(1831);
        }
    }

    class c implements com.tencent.mm.pluginsdk.ui.h.c {
        private c() {
        }

        /* synthetic */ c(r rVar, byte b) {
            this();
        }

        public final void gp(long j) {
            AppMethodBeat.i(1836);
            e.pXa.a(600, j, 1, false);
            AppMethodBeat.o(1836);
        }

        public final void wB(String str) {
            AppMethodBeat.i(1837);
            e.pXa.X(14349, str);
            AppMethodBeat.o(1837);
        }
    }

    class b implements com.tencent.mm.modelvideo.b {
        private chx sFG;

        private b() {
        }

        /* synthetic */ b(r rVar, byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x014e  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0081  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void r(String str, String str2, String str3) {
            chx chx;
            a aVar;
            AppMethodBeat.i(1832);
            ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", str, str2);
            m cFU = r.this.sDo.cFU();
            com.tencent.mm.plugin.topstory.a.b.a aVar2 = cFU.sDo.cFR().sFp;
            if (aVar2 != null) {
                if (cFU.sET.containsKey(str)) {
                    chx = (chx) cFU.sET.get(str);
                    if (chx.xhk >= 5) {
                        ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", str, Long.valueOf(chx.xhk), bo.my(chx.xhj));
                        aVar2.sAM = 1;
                        aVar2.sAN = chx.xhk;
                        aVar2.sAO = chx.xhj;
                        com.tencent.mm.plugin.websearch.api.a.a.kT(25);
                        this.sFG = chx;
                        aVar = new a(r.this, (byte) 0);
                        if (this.sFG == null) {
                            boolean queryVideoMoovInfo;
                            long[] jArr = new long[2];
                            if (this.sFG.xhk < 100) {
                                o.alm().a(r.a(str, str3, str2, aVar), false);
                                C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
                                c2CDownloadRequest.fileKey = str;
                                c2CDownloadRequest.fileType = 90;
                                c2CDownloadRequest.url = str3;
                                c2CDownloadRequest.savePath = str2;
                                queryVideoMoovInfo = CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr);
                            } else {
                                queryVideoMoovInfo = true;
                                jArr[0] = new com.tencent.mm.plugin.a.b().vB(str2);
                            }
                            ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", str, Boolean.valueOf(queryVideoMoovInfo));
                            if (queryVideoMoovInfo && !aVar.sFD) {
                                aVar.onMoovReady(str, (int) jArr[0], (int) jArr[1]);
                            }
                            if (r.ab(this.sFG.xhk, this.sFG.xhj)) {
                                aVar.cHa();
                            }
                            if (this.sFG.xhk == 100) {
                                aVar.h(str, (int) this.sFG.xhj, (int) this.sFG.xha);
                                aVar.a(str, 0, null);
                            }
                            AppMethodBeat.o(1832);
                            return;
                        }
                        o.alm().a(r.a(str, str3, str2, aVar), false);
                        AppMethodBeat.o(1832);
                        return;
                    }
                    ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", str, Long.valueOf(chx.xhk), bo.my(chx.xhj));
                    aVar2.sAM = 3;
                } else {
                    chx = new chx();
                    chx.cHr = str;
                    cFU.sET.put(str, chx);
                }
            }
            cFU.cGP();
            chx = null;
            this.sFG = chx;
            aVar = new a(r.this, (byte) 0);
            if (this.sFG == null) {
            }
        }

        public final void dV(String str) {
            AppMethodBeat.i(1833);
            o.alm().m(str, null);
            AppMethodBeat.o(1833);
        }

        public final void requestVideoData(String str, int i, int i2) {
            AppMethodBeat.i(1834);
            if (this.sFG == null || ((long) (i + i2)) > this.sFG.xhj) {
                o.alm();
                com.tencent.mm.al.e.k(str, i, i2);
                AppMethodBeat.o(1834);
                return;
            }
            AppMethodBeat.o(1834);
        }

        public final boolean isVideoDataAvailable(String str, int i, int i2) {
            boolean z;
            AppMethodBeat.i(1835);
            if (this.sFG == null || ((long) (i + i2)) > this.sFG.xhj) {
                z = false;
            } else {
                z = true;
            }
            if (i == 0 && z && r.this.sDo != null) {
                com.tencent.mm.plugin.topstory.a.b.a aVar = r.this.sDo.cFR().sFp;
                if (aVar != null && aVar.sAU == 0) {
                    aVar.sAU = System.currentTimeMillis() - aVar.sAE;
                    aVar.sAV = (long) i;
                    aVar.sAW = (long) (i + i2);
                    ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", Long.valueOf(aVar.sAR), Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
            if (!z) {
                z = o.alm().isVideoDataAvailable(str, i, i2);
            }
            AppMethodBeat.o(1835);
            return z;
        }

        public final void a(com.tencent.mm.modelvideo.b.a aVar) {
        }
    }

    public r() {
        AppMethodBeat.i(1838);
        AppMethodBeat.o(1838);
    }

    public final void a(f fVar, com.tencent.mm.pluginsdk.ui.h.d dVar) {
        AppMethodBeat.i(1839);
        if (fVar == this.sFu || this.sDo == null) {
            AppMethodBeat.o(1839);
            return;
        }
        if (this.sFt == null) {
            this.sFt = cGX();
        }
        cGW();
        fVar.getVideoViewParent().addView(this.sFt);
        this.sFt.setVideoFooterView(fVar.getControlBar());
        this.sFt.setScaleType(dVar);
        this.sFt.setIMMVideoViewCallback(fVar.getVideoViewCallback());
        this.sFs.a(this.sFz);
        this.sFu = fVar;
        AppMethodBeat.o(1839);
    }

    public final void a(b bVar, chw chw, String str, int i) {
        AppMethodBeat.i(1840);
        ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", chw.xgS, chw.title, str);
        bVar.cFR().b(bVar.cFT());
        bVar.cFR().cGS();
        bVar.cFR().a(chw, i, str);
        this.sFt.setKeepScreenOn(true);
        this.sFt.cGV();
        this.sFt.abJ(str);
        this.sFv = chw;
        this.sFw = true;
        this.sFx = false;
        AppMethodBeat.o(1840);
    }

    private void cGW() {
        AppMethodBeat.i(1841);
        if (this.sFt.getParent() != null) {
            ((ViewGroup) this.sFt.getParent()).removeView(this.sFt);
        }
        AppMethodBeat.o(1841);
    }

    private q cGX() {
        AppMethodBeat.i(1842);
        q qVar = new q(this.sDo.bKU(), this.sDo);
        qVar.setRootPath(this.sDo.cFS());
        qVar.setIOnlineVideoProxy(new b(this, (byte) 0));
        qVar.setReporter(new c(this, (byte) 0));
        AppMethodBeat.o(1842);
        return qVar;
    }

    private void clU() {
        AppMethodBeat.i(1843);
        this.sFs.a(this.sFz);
        AppMethodBeat.o(1843);
    }

    private void cGY() {
        AppMethodBeat.i(1844);
        this.sFs.cy(false);
        AppMethodBeat.o(1844);
    }

    public final boolean cGZ() {
        AppMethodBeat.i(1845);
        if (this.sFt != null) {
            boolean isPlaying = this.sFt.isPlaying();
            AppMethodBeat.o(1845);
            return isPlaying;
        }
        AppMethodBeat.o(1845);
        return false;
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(1846);
        if (this.sFt != null) {
            this.sFt.setMute(z);
        }
        AppMethodBeat.o(1846);
    }

    public final void cEf() {
        AppMethodBeat.i(1847);
        if (this.sFt != null) {
            clU();
            this.sFt.setKeepScreenOn(true);
            this.sFt.play();
            this.sFx = false;
        }
        AppMethodBeat.o(1847);
    }

    public final void cpN() {
        AppMethodBeat.i(1848);
        if (this.sFt != null) {
            cGY();
            this.sFt.setKeepScreenOn(false);
            this.sFt.pause();
            this.sFx = true;
        }
        AppMethodBeat.o(1848);
    }

    public final void stopPlay() {
        AppMethodBeat.i(1849);
        if (this.sFt != null) {
            ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
            cGY();
            this.sFt.cGU();
            this.sFt.setKeepScreenOn(false);
            this.sFt.stop();
            this.sFv = null;
            this.sFw = false;
            this.sFx = false;
            if (this.sDo != null) {
                this.sDo.cFR().b(this.sDo.cFT());
                this.sDo.cFR().cGS();
            }
            if (this.sFu != null) {
                this.sFu.cGt();
            }
        }
        AppMethodBeat.o(1849);
    }

    public final void d(b bVar) {
        this.sEV++;
        this.sDo = bVar;
    }

    public final void akW() {
        AppMethodBeat.i(1850);
        if (this.sFt != null) {
            this.sFt.akW();
            if (this.sFu != null) {
                this.sFu.cGs();
            }
        }
        AppMethodBeat.o(1850);
    }

    public final void akV() {
        AppMethodBeat.i(1851);
        if (this.sFt != null) {
            this.sFt.akV();
        }
        AppMethodBeat.o(1851);
    }

    public final void aEX() {
        AppMethodBeat.i(1852);
        this.sEV--;
        ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", Integer.valueOf(this.sEV));
        if (this.sEV <= 0) {
            if (this.sFt != null) {
                stopPlay();
                this.sFt.aEX();
            }
            this.sDo = null;
        }
        AppMethodBeat.o(1852);
    }

    public final void onError(String str) {
        AppMethodBeat.i(1853);
        if (this.sFt != null && this.sFt.getSessionId().equals(str)) {
            stopPlay();
        }
        AppMethodBeat.o(1853);
    }

    public final void fT(int i, int i2) {
        AppMethodBeat.i(1854);
        if (i == 0) {
            if (this.sFw && this.sFB) {
                this.sFB = false;
                cEf();
                AppMethodBeat.o(1854);
                return;
            }
        } else if (i2 == 0) {
            if (this.sFw && cGZ()) {
                this.sFB = true;
                cpN();
                AppMethodBeat.o(1854);
                return;
            }
        } else if (i2 == 1 && this.sFA && this.sFw && this.sFx) {
            this.sFA = false;
            cEf();
            this.sFu.cGp();
        }
        AppMethodBeat.o(1854);
    }

    public final void abK(String str) {
        AppMethodBeat.i(1855);
        com.tencent.mm.plugin.topstory.a.b.a aVar = this.sDo.cFR().sFp;
        if (aVar != null) {
            aVar.sAI = 1;
        }
        if (this.sFt != null && this.sFt.getSessionId().equals(str)) {
            stopPlay();
        }
        com.tencent.mm.plugin.websearch.api.a.a.kT(26);
        AppMethodBeat.o(1855);
    }

    public final int getCurrPosSec() {
        AppMethodBeat.i(1856);
        if (this.sFt != null) {
            int currPosSec = this.sFt.getCurrPosSec();
            AppMethodBeat.o(1856);
            return currPosSec;
        }
        AppMethodBeat.o(1856);
        return 0;
    }

    public final int getVideoDurationSec() {
        AppMethodBeat.i(1857);
        if (this.sFt != null) {
            int videoDurationSec = this.sFt.getVideoDurationSec();
            AppMethodBeat.o(1857);
            return videoDurationSec;
        }
        AppMethodBeat.o(1857);
        return 0;
    }

    public final int getCurrPosMs() {
        AppMethodBeat.i(1858);
        if (this.sFt != null) {
            int currPosMs = this.sFt.getCurrPosMs();
            AppMethodBeat.o(1858);
            return currPosMs;
        }
        AppMethodBeat.o(1858);
        return 0;
    }

    public static boolean ab(long j, long j2) {
        if (j >= 50 || j2 > 5242880) {
            return true;
        }
        return false;
    }
}
