package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvideo.MMVideoView;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C29735b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.q */
public final class C43699q extends MMVideoView {
    private String cvF = "";
    private chw sAX;
    private C4232b sDo;

    public C43699q(Context context, C4232b c4232b) {
        super(context);
        this.mContext = context;
        this.sDo = c4232b;
    }

    public final void akT() {
        this.fVa.fVf = 4;
        this.fVa.fVg = 2;
    }

    /* renamed from: cf */
    public final C14979e mo9069cf(Context context) {
        AppMethodBeat.m2504i(1802);
        TopStoryVideoPlayTextureView topStoryVideoPlayTextureView = new TopStoryVideoPlayTextureView(context);
        topStoryVideoPlayTextureView.setOpenWithNoneSurface(true);
        topStoryVideoPlayTextureView.setNeedResetExtractor(C43699q.bwE());
        topStoryVideoPlayTextureView.setIsOnlineVideoType(true);
        AppMethodBeat.m2505o(1802);
        return topStoryVideoPlayTextureView;
    }

    private static boolean bwE() {
        boolean z = false;
        AppMethodBeat.m2504i(1803);
        try {
            C1720g.m3537RQ();
            z = C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.m2505o(1803);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", e, "check need reset error", new Object[z]);
            AppMethodBeat.m2505o(1803);
        }
        return z;
    }

    public final void setVideoInfo(chw chw) {
        AppMethodBeat.m2504i(1804);
        super.mo9063c(false, chw.videoUrl, chw.xgR);
        this.sAX = chw;
        this.fUL = C4210c.m6559au(chw.xgS, chw.xgT);
        this.fUM = this.sDo.cFS() + this.fUL + VideoMaterialUtil.MP4_SUFFIX;
        AppMethodBeat.m2505o(1804);
    }

    public final void initView() {
        AppMethodBeat.m2504i(1805);
        super.initView();
        AppMethodBeat.m2505o(1805);
    }

    /* renamed from: mn */
    public final boolean mo9079mn(int i) {
        Exception e;
        AppMethodBeat.m2504i(1806);
        if (this.fUO == 3) {
            AppMethodBeat.m2505o(1806);
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
            if (i == 0 && this.fUQ != null && C43699q.bwE()) {
                pInt4.value = 0;
                pInt3.value = 0;
                b = this.fUQ.mo21146b(i + 1, pInt3, pInt4);
            } else {
                b = false;
            }
            int i3 = i + 1;
            if (b) {
                i2 = pInt4.value;
            } else {
                i2 = i3;
            }
            if (this.fUK == null || this.fUQ == null || !this.fUQ.mo21144a(i, i2, pInt, pInt2)) {
                z = false;
                AppMethodBeat.m2505o(1806);
                return z;
            }
            z = this.fUK.isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
            if (z) {
                try {
                    this.fUV = i2;
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.m7413e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", aZk(), e.toString());
                    AppMethodBeat.m2505o(1806);
                    return z;
                }
            }
            AppMethodBeat.m2505o(1806);
            return z;
        } catch (Exception e3) {
            e = e3;
            z = false;
            C4990ab.m7413e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", aZk(), e.toString());
            AppMethodBeat.m2505o(1806);
            return z;
        }
    }

    /* renamed from: h */
    public final void mo9075h(String str, int i, int i2) {
        AppMethodBeat.m2504i(1807);
        if (C5046bo.isEqual(this.fUL, str)) {
            C4990ab.m7411d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
            if (this.fUU && this.fUP == 3) {
                mo44255mm(getCurrPosSec());
            }
            AppMethodBeat.m2505o(1807);
            return;
        }
        AppMethodBeat.m2505o(1807);
    }

    /* renamed from: C */
    public final boolean mo44252C(int i, boolean z) {
        AppMethodBeat.m2504i(1808);
        if (this.fUQ != null) {
            int anZ = this.fUQ.anZ();
            if (i > anZ && anZ > 0) {
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", aZk(), Integer.valueOf(i), Integer.valueOf(anZ));
                i = anZ;
            }
        }
        boolean C = super.mo44252C(i, z);
        AppMethodBeat.m2505o(1808);
        return C;
    }

    /* renamed from: a */
    public final boolean mo9055a(int i, PInt pInt, PInt pInt2) {
        boolean z;
        AppMethodBeat.m2504i(1809);
        pInt.value = Math.max(i, this.fUV);
        if (this.fUP == 1 || this.fUP == 0) {
            if (this.fUQ == null || !C43699q.bwE()) {
                z = false;
            } else {
                pInt2.value = 0;
                pInt.value = 0;
                z = this.fUQ.mo21146b(i + 1, pInt, pInt2);
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
                z = this.fUQ.mo21146b(i, pInt, pInt2);
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
            AppMethodBeat.m2505o(1809);
            return false;
        }
        C4990ab.m7411d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", aZk(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW), this.fUL);
        AppMethodBeat.m2505o(1809);
        return true;
    }

    public final void abJ(String str) {
        AppMethodBeat.m2504i(1810);
        this.cvF = str;
        start();
        AppMethodBeat.m2505o(1810);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(1811);
        super.aEX();
        this.sDo = null;
        AppMethodBeat.m2505o(1811);
    }

    public final void start() {
        AppMethodBeat.m2504i(1812);
        super.start();
        C14419a.m22633kT(5);
        AppMethodBeat.m2505o(1812);
    }

    public final boolean isPlaying() {
        boolean z;
        AppMethodBeat.m2504i(1813);
        boolean isPlaying = super.isPlaying();
        if (isPlaying && this.fUP == 3) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7411d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", aZk(), Boolean.valueOf(z), Boolean.valueOf(isPlaying), Integer.valueOf(this.fUP));
        AppMethodBeat.m2505o(1813);
        return isPlaying;
    }

    public final int getCurrPosMs() {
        AppMethodBeat.m2504i(1814);
        int i = 0;
        if (this.klq != null) {
            i = this.klq.getCurrentPosition();
        }
        if (this.fUS > 0) {
            i = this.fUS * 1000;
        }
        AppMethodBeat.m2505o(1814);
        return i;
    }

    public final int getCurrPosSec() {
        AppMethodBeat.m2504i(1815);
        int i = 0;
        if (this.klq != null) {
            i = Math.round((((float) this.klq.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        if (this.fUS > 0) {
            i = this.fUS;
        }
        AppMethodBeat.m2505o(1815);
        return i;
    }

    /* renamed from: ad */
    public final void mo9058ad(String str, int i) {
        AppMethodBeat.m2504i(1816);
        super.mo9058ad(str, i);
        if (!(i == 0 || this.rcd == null)) {
            this.rcd.mo9209c(getSessionId(), getMediaId(), "download error", i, 0);
        }
        AppMethodBeat.m2505o(1816);
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.m2504i(1817);
        super.onError(i, i2);
        switch (i2) {
            case -3:
                C29735b.m47142kT(C29735b.ubL);
                break;
            case -2:
                try {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
                    if (this.klq instanceof TopStoryVideoPlayTextureView) {
                        ((TopStoryVideoPlayTextureView) this.klq).setNeedResetExtractor(true);
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", e, "%s onError [%s]", aZk(), e.toString());
                }
                C29735b.m47142kT(C29735b.ubK);
                AppMethodBeat.m2505o(1817);
                return;
            case -1:
                C29735b.m47142kT(C29735b.ubJ);
                AppMethodBeat.m2505o(1817);
                return;
        }
        AppMethodBeat.m2505o(1817);
    }

    public final boolean cGT() {
        return false;
    }

    public final void akW() {
        AppMethodBeat.m2504i(1818);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", aZk());
        if (!this.vgk) {
            this.vgk = true;
            if (this.klq != null) {
                if (this.vgs) {
                    play();
                } else {
                    ((VideoPlayerTextureView) this.klq).bPd();
                }
            }
            mo51409gp((long) (getReportIdkey() + 10));
        }
        AppMethodBeat.m2505o(1818);
    }

    public final void akV() {
        AppMethodBeat.m2504i(1819);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", aZk());
        if (this.vgk) {
            this.vgr = getCurrPosSec();
            this.vgs = isPlaying();
            this.vgy = 0;
            this.vgx = 0;
            pause();
            stopTimer();
            this.vgk = false;
            mo51409gp((long) (getReportIdkey() + 11));
        }
        AppMethodBeat.m2505o(1819);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final void cGU() {
        AppMethodBeat.m2504i(1820);
        ((TopStoryVideoPlayTextureView) this.klq).setAlpha(0.0f);
        AppMethodBeat.m2505o(1820);
    }

    public final void cGV() {
        AppMethodBeat.m2504i(1821);
        ((TopStoryVideoPlayTextureView) this.klq).setAlpha(1.0f);
        AppMethodBeat.m2505o(1821);
    }

    public final void stop() {
        AppMethodBeat.m2504i(1822);
        super.stop();
        this.sAX = null;
        AppMethodBeat.m2505o(1822);
    }
}
