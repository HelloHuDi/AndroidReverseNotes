package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class q extends MMVideoView {
    private String cvF = "";
    private chw sAX;
    private b sDo;

    public q(Context context, b bVar) {
        super(context);
        this.mContext = context;
        this.sDo = bVar;
    }

    public final void akT() {
        this.fVa.fVf = 4;
        this.fVa.fVg = 2;
    }

    public final e cf(Context context) {
        AppMethodBeat.i(1802);
        TopStoryVideoPlayTextureView topStoryVideoPlayTextureView = new TopStoryVideoPlayTextureView(context);
        topStoryVideoPlayTextureView.setOpenWithNoneSurface(true);
        topStoryVideoPlayTextureView.setNeedResetExtractor(bwE());
        topStoryVideoPlayTextureView.setIsOnlineVideoType(true);
        AppMethodBeat.o(1802);
        return topStoryVideoPlayTextureView;
    }

    private static boolean bwE() {
        boolean z = false;
        AppMethodBeat.i(1803);
        try {
            g.RQ();
            z = g.RP().Ry().getBoolean(a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.o(1803);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", e, "check need reset error", new Object[z]);
            AppMethodBeat.o(1803);
        }
        return z;
    }

    public final void setVideoInfo(chw chw) {
        AppMethodBeat.i(1804);
        super.c(false, chw.videoUrl, chw.xgR);
        this.sAX = chw;
        this.fUL = c.au(chw.xgS, chw.xgT);
        this.fUM = this.sDo.cFS() + this.fUL + VideoMaterialUtil.MP4_SUFFIX;
        AppMethodBeat.o(1804);
    }

    public final void initView() {
        AppMethodBeat.i(1805);
        super.initView();
        AppMethodBeat.o(1805);
    }

    public final boolean mn(int i) {
        Exception e;
        AppMethodBeat.i(1806);
        if (this.fUO == 3) {
            AppMethodBeat.o(1806);
            return true;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        boolean z;
        try {
            boolean b;
            int i2;
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            if (i == 0 && this.fUQ != null && bwE()) {
                pInt4.value = 0;
                pInt3.value = 0;
                b = this.fUQ.b(i + 1, pInt3, pInt4);
            } else {
                b = false;
            }
            int i3 = i + 1;
            if (b) {
                i2 = pInt4.value;
            } else {
                i2 = i3;
            }
            if (this.fUK == null || this.fUQ == null || !this.fUQ.a(i, i2, pInt, pInt2)) {
                z = false;
                AppMethodBeat.o(1806);
                return z;
            }
            z = this.fUK.isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
            if (z) {
                try {
                    this.fUV = i2;
                } catch (Exception e2) {
                    e = e2;
                    ab.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", aZk(), e.toString());
                    AppMethodBeat.o(1806);
                    return z;
                }
            }
            AppMethodBeat.o(1806);
            return z;
        } catch (Exception e3) {
            e = e3;
            z = false;
            ab.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", aZk(), e.toString());
            AppMethodBeat.o(1806);
            return z;
        }
    }

    public final void h(String str, int i, int i2) {
        AppMethodBeat.i(1807);
        if (bo.isEqual(this.fUL, str)) {
            ab.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
            if (this.fUU && this.fUP == 3) {
                mm(getCurrPosSec());
            }
            AppMethodBeat.o(1807);
            return;
        }
        AppMethodBeat.o(1807);
    }

    public final boolean C(int i, boolean z) {
        AppMethodBeat.i(1808);
        if (this.fUQ != null) {
            int anZ = this.fUQ.anZ();
            if (i > anZ && anZ > 0) {
                ab.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", aZk(), Integer.valueOf(i), Integer.valueOf(anZ));
                i = anZ;
            }
        }
        boolean C = super.C(i, z);
        AppMethodBeat.o(1808);
        return C;
    }

    public final boolean a(int i, PInt pInt, PInt pInt2) {
        boolean z;
        AppMethodBeat.i(1809);
        pInt.value = Math.max(i, this.fUV);
        if (this.fUP == 1 || this.fUP == 0) {
            if (this.fUQ == null || !bwE()) {
                z = false;
            } else {
                pInt2.value = 0;
                pInt.value = 0;
                z = this.fUQ.b(i + 1, pInt, pInt2);
            }
            if (!z) {
                pInt.value = i;
                pInt2.value = pInt.value + 4;
            }
        } else {
            z = false;
        }
        if (this.fUP == 2) {
            if (this.fUQ != null) {
                z = this.fUQ.b(i, pInt, pInt2);
                pInt2.value += 4;
            }
            if (!z) {
                pInt.value = i - 8;
                if (pInt.value < 0) {
                    pInt.value = 0;
                }
                pInt2.value = (pInt.value + this.fUW) + 8;
            }
        }
        if (this.fUP == 3 || this.fUP == 4) {
            pInt.value = this.fUV;
            pInt2.value = this.fUR + 1;
        }
        if (pInt2.value >= this.fUR + 1) {
            pInt2.value = this.fUR + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + 2;
            AppMethodBeat.o(1809);
            return false;
        }
        ab.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", aZk(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW), this.fUL);
        AppMethodBeat.o(1809);
        return true;
    }

    public final void abJ(String str) {
        AppMethodBeat.i(1810);
        this.cvF = str;
        start();
        AppMethodBeat.o(1810);
    }

    public final void aEX() {
        AppMethodBeat.i(1811);
        super.aEX();
        this.sDo = null;
        AppMethodBeat.o(1811);
    }

    public final void start() {
        AppMethodBeat.i(1812);
        super.start();
        com.tencent.mm.plugin.websearch.api.a.a.kT(5);
        AppMethodBeat.o(1812);
    }

    public final boolean isPlaying() {
        boolean z;
        AppMethodBeat.i(1813);
        boolean isPlaying = super.isPlaying();
        if (isPlaying && this.fUP == 3) {
            z = true;
        } else {
            z = false;
        }
        ab.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", aZk(), Boolean.valueOf(z), Boolean.valueOf(isPlaying), Integer.valueOf(this.fUP));
        AppMethodBeat.o(1813);
        return isPlaying;
    }

    public final int getCurrPosMs() {
        AppMethodBeat.i(1814);
        int i = 0;
        if (this.klq != null) {
            i = this.klq.getCurrentPosition();
        }
        if (this.fUS > 0) {
            i = this.fUS * 1000;
        }
        AppMethodBeat.o(1814);
        return i;
    }

    public final int getCurrPosSec() {
        AppMethodBeat.i(1815);
        int i = 0;
        if (this.klq != null) {
            i = Math.round((((float) this.klq.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        if (this.fUS > 0) {
            i = this.fUS;
        }
        AppMethodBeat.o(1815);
        return i;
    }

    public final void ad(String str, int i) {
        AppMethodBeat.i(1816);
        super.ad(str, i);
        if (!(i == 0 || this.rcd == null)) {
            this.rcd.c(getSessionId(), getMediaId(), "download error", i, 0);
        }
        AppMethodBeat.o(1816);
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.i(1817);
        super.onError(i, i2);
        switch (i2) {
            case -3:
                b.kT(b.ubL);
                break;
            case -2:
                try {
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
                    if (this.klq instanceof TopStoryVideoPlayTextureView) {
                        ((TopStoryVideoPlayTextureView) this.klq).setNeedResetExtractor(true);
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", e, "%s onError [%s]", aZk(), e.toString());
                }
                b.kT(b.ubK);
                AppMethodBeat.o(1817);
                return;
            case -1:
                b.kT(b.ubJ);
                AppMethodBeat.o(1817);
                return;
        }
        AppMethodBeat.o(1817);
    }

    public final boolean cGT() {
        return false;
    }

    public final void akW() {
        AppMethodBeat.i(1818);
        ab.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", aZk());
        if (!this.vgk) {
            this.vgk = true;
            if (this.klq != null) {
                if (this.vgs) {
                    play();
                } else {
                    ((VideoPlayerTextureView) this.klq).bPd();
                }
            }
            gp((long) (getReportIdkey() + 10));
        }
        AppMethodBeat.o(1818);
    }

    public final void akV() {
        AppMethodBeat.i(1819);
        ab.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", aZk());
        if (this.vgk) {
            this.vgr = getCurrPosSec();
            this.vgs = isPlaying();
            this.vgy = 0;
            this.vgx = 0;
            pause();
            stopTimer();
            this.vgk = false;
            gp((long) (getReportIdkey() + 11));
        }
        AppMethodBeat.o(1819);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final void cGU() {
        AppMethodBeat.i(1820);
        ((TopStoryVideoPlayTextureView) this.klq).setAlpha(0.0f);
        AppMethodBeat.o(1820);
    }

    public final void cGV() {
        AppMethodBeat.i(1821);
        ((TopStoryVideoPlayTextureView) this.klq).setAlpha(1.0f);
        AppMethodBeat.o(1821);
    }

    public final void stop() {
        AppMethodBeat.i(1822);
        super.stop();
        this.sAX = null;
        AppMethodBeat.o(1822);
    }
}
