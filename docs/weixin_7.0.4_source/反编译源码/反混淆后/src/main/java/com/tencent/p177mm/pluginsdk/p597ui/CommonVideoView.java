package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoTextureView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.ui.CommonVideoView */
public class CommonVideoView extends AbstractVideoView {
    protected boolean bkJ;
    protected int hZs = 0;
    protected int iad;
    protected String url;

    public CommonVideoView(Context context) {
        super(context);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void initView() {
        AppMethodBeat.m2504i(117945);
        super.initView();
        this.TAG = "MicroMsg.CommonVideoView";
        AppMethodBeat.m2505o(117945);
    }

    /* renamed from: c */
    public void mo9063c(boolean z, String str, int i) {
        AppMethodBeat.m2504i(117946);
        C4990ab.m7417i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", aZk(), Boolean.valueOf(z), str, Integer.valueOf(i));
        this.bkJ = z;
        this.url = str;
        this.iad = i;
        ajo(str);
        AppMethodBeat.m2505o(117946);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cf */
    public C14979e mo9069cf(Context context) {
        AppMethodBeat.m2504i(117947);
        this.vgt = 0;
        VideoTextureView videoTextureView = new VideoTextureView(context);
        AppMethodBeat.m2505o(117947);
        return videoTextureView;
    }

    public void start() {
        AppMethodBeat.m2504i(117948);
        if (this.klq != null) {
            C4990ab.m7417i(this.TAG, "%s start path [%s] [%s]", aZk(), this.klq.getVideoPath(), C5046bo.dpG());
            if (C5046bo.isNullOrNil(this.klq.getVideoPath())) {
                this.klq.setVideoPath(this.url);
                aNt();
                cso();
            } else {
                play();
            }
            mo51409gp((long) (getReportIdkey() + 1));
        }
        AppMethodBeat.m2505o(117948);
    }

    public void setScaleType(C35873d c35873d) {
        AppMethodBeat.m2504i(117949);
        if (this.klq instanceof VideoTextureView) {
            ((VideoTextureView) this.klq).setScaleType(c35873d);
            mo51409gp((long) (getReportIdkey() + 14));
        }
        AppMethodBeat.m2505o(117949);
    }

    /* renamed from: as */
    public final boolean mo26910as(float f) {
        AppMethodBeat.m2504i(117950);
        C4990ab.m7417i(this.TAG, "%s set play rate [%f]", aZk(), Float.valueOf(f));
        if (this.klq instanceof VideoTextureView) {
            mo51409gp((long) (getReportIdkey() + 13));
            boolean as = ((VideoTextureView) this.klq).mo69821as(f);
            AppMethodBeat.m2505o(117950);
            return as;
        }
        AppMethodBeat.m2505o(117950);
        return false;
    }

    public int getVideoDurationSec() {
        AppMethodBeat.m2504i(117951);
        int videoDurationSec;
        if (this.iad <= 0) {
            videoDurationSec = super.getVideoDurationSec();
            AppMethodBeat.m2505o(117951);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.m2505o(117951);
        return videoDurationSec;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.m2504i(117952);
        try {
            if (this.klq instanceof VideoTextureView) {
                int downloadPercent = (int) (((((float) ((VideoTextureView) this.klq).getDownloadPercent()) * 1.0f) / 100.0f) * ((float) super.getVideoDurationSec()));
                AppMethodBeat.m2505o(117952);
                return downloadPercent;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "%s get cache time sec error", aZk());
        }
        AppMethodBeat.m2505o(117952);
        return 0;
    }

    /* renamed from: KM */
    public final int mo27218KM(int i) {
        this.hZs = i;
        return i;
    }

    public int getVideoSource() {
        return this.hZs;
    }

    /* renamed from: e */
    public final boolean mo26912e(double d, boolean z) {
        AppMethodBeat.m2504i(117953);
        if (isLive()) {
            C4990ab.m7421w(this.TAG, "%s it is live, don't seek ", aZk());
            AppMethodBeat.m2505o(117953);
            return false;
        }
        boolean e = super.mo26912e(d, z);
        AppMethodBeat.m2505o(117953);
        return e;
    }

    public void akW() {
        AppMethodBeat.m2504i(117954);
        super.akW();
        if (this.klq != null && (this.klq instanceof VideoTextureView)) {
            if (this.vgs) {
                play();
                AppMethodBeat.m2505o(117954);
                return;
            }
            ((VideoTextureView) this.klq).bPd();
        }
        AppMethodBeat.m2505o(117954);
    }

    public void akV() {
        AppMethodBeat.m2504i(117955);
        super.akV();
        AppMethodBeat.m2505o(117955);
    }

    /* renamed from: gO */
    public final void mo27219gO(int i, int i2) {
        AppMethodBeat.m2504i(117956);
        C4990ab.m7411d(this.TAG, "%s onInfo [%d %d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 701) {
            aNt();
            diQ();
            diO();
            mo51409gp((long) (getReportIdkey() + 40));
            AppMethodBeat.m2505o(117956);
            return;
        }
        if (i == 702) {
            bJc();
            diP();
            diR();
        }
        AppMethodBeat.m2505o(117956);
    }

    /* renamed from: EA */
    public void mo8553EA() {
        AppMethodBeat.m2504i(117957);
        if (isLive()) {
            C4990ab.m7417i(this.TAG, "%s it is live video, do not completion", aZk());
            stop();
            start();
            AppMethodBeat.m2505o(117957);
            return;
        }
        super.mo8553EA();
        AppMethodBeat.m2505o(117957);
    }

    public boolean isLive() {
        AppMethodBeat.m2504i(117958);
        boolean bTd = bTd();
        int duration = this.klq != null ? this.klq.getDuration() : 0;
        if (this.bkJ) {
            bTd = true;
        } else if (!bTd || duration > 0) {
            bTd = false;
        } else {
            bTd = true;
        }
        C4990ab.m7411d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", aZk(), Boolean.valueOf(bTd), Boolean.valueOf(bTd()), Integer.valueOf(duration), Boolean.valueOf(this.bkJ));
        AppMethodBeat.m2505o(117958);
        return bTd;
    }

    /* Access modifiers changed, original: protected */
    public int getReportIdkey() {
        return 0;
    }
}
