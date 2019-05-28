package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

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
        AppMethodBeat.i(117945);
        super.initView();
        this.TAG = "MicroMsg.CommonVideoView";
        AppMethodBeat.o(117945);
    }

    public void c(boolean z, String str, int i) {
        AppMethodBeat.i(117946);
        ab.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", aZk(), Boolean.valueOf(z), str, Integer.valueOf(i));
        this.bkJ = z;
        this.url = str;
        this.iad = i;
        ajo(str);
        AppMethodBeat.o(117946);
    }

    /* Access modifiers changed, original: protected */
    public e cf(Context context) {
        AppMethodBeat.i(117947);
        this.vgt = 0;
        VideoTextureView videoTextureView = new VideoTextureView(context);
        AppMethodBeat.o(117947);
        return videoTextureView;
    }

    public void start() {
        AppMethodBeat.i(117948);
        if (this.klq != null) {
            ab.i(this.TAG, "%s start path [%s] [%s]", aZk(), this.klq.getVideoPath(), bo.dpG());
            if (bo.isNullOrNil(this.klq.getVideoPath())) {
                this.klq.setVideoPath(this.url);
                aNt();
                cso();
            } else {
                play();
            }
            gp((long) (getReportIdkey() + 1));
        }
        AppMethodBeat.o(117948);
    }

    public void setScaleType(d dVar) {
        AppMethodBeat.i(117949);
        if (this.klq instanceof VideoTextureView) {
            ((VideoTextureView) this.klq).setScaleType(dVar);
            gp((long) (getReportIdkey() + 14));
        }
        AppMethodBeat.o(117949);
    }

    public final boolean as(float f) {
        AppMethodBeat.i(117950);
        ab.i(this.TAG, "%s set play rate [%f]", aZk(), Float.valueOf(f));
        if (this.klq instanceof VideoTextureView) {
            gp((long) (getReportIdkey() + 13));
            boolean as = ((VideoTextureView) this.klq).as(f);
            AppMethodBeat.o(117950);
            return as;
        }
        AppMethodBeat.o(117950);
        return false;
    }

    public int getVideoDurationSec() {
        AppMethodBeat.i(117951);
        int videoDurationSec;
        if (this.iad <= 0) {
            videoDurationSec = super.getVideoDurationSec();
            AppMethodBeat.o(117951);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.o(117951);
        return videoDurationSec;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.i(117952);
        try {
            if (this.klq instanceof VideoTextureView) {
                int downloadPercent = (int) (((((float) ((VideoTextureView) this.klq).getDownloadPercent()) * 1.0f) / 100.0f) * ((float) super.getVideoDurationSec()));
                AppMethodBeat.o(117952);
                return downloadPercent;
            }
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "%s get cache time sec error", aZk());
        }
        AppMethodBeat.o(117952);
        return 0;
    }

    public final int KM(int i) {
        this.hZs = i;
        return i;
    }

    public int getVideoSource() {
        return this.hZs;
    }

    public final boolean e(double d, boolean z) {
        AppMethodBeat.i(117953);
        if (isLive()) {
            ab.w(this.TAG, "%s it is live, don't seek ", aZk());
            AppMethodBeat.o(117953);
            return false;
        }
        boolean e = super.e(d, z);
        AppMethodBeat.o(117953);
        return e;
    }

    public void akW() {
        AppMethodBeat.i(117954);
        super.akW();
        if (this.klq != null && (this.klq instanceof VideoTextureView)) {
            if (this.vgs) {
                play();
                AppMethodBeat.o(117954);
                return;
            }
            ((VideoTextureView) this.klq).bPd();
        }
        AppMethodBeat.o(117954);
    }

    public void akV() {
        AppMethodBeat.i(117955);
        super.akV();
        AppMethodBeat.o(117955);
    }

    public final void gO(int i, int i2) {
        AppMethodBeat.i(117956);
        ab.d(this.TAG, "%s onInfo [%d %d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 701) {
            aNt();
            diQ();
            diO();
            gp((long) (getReportIdkey() + 40));
            AppMethodBeat.o(117956);
            return;
        }
        if (i == 702) {
            bJc();
            diP();
            diR();
        }
        AppMethodBeat.o(117956);
    }

    public void EA() {
        AppMethodBeat.i(117957);
        if (isLive()) {
            ab.i(this.TAG, "%s it is live video, do not completion", aZk());
            stop();
            start();
            AppMethodBeat.o(117957);
            return;
        }
        super.EA();
        AppMethodBeat.o(117957);
    }

    public boolean isLive() {
        AppMethodBeat.i(117958);
        boolean bTd = bTd();
        int duration = this.klq != null ? this.klq.getDuration() : 0;
        if (this.bkJ) {
            bTd = true;
        } else if (!bTd || duration > 0) {
            bTd = false;
        } else {
            bTd = true;
        }
        ab.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", aZk(), Boolean.valueOf(bTd), Boolean.valueOf(bTd()), Integer.valueOf(duration), Boolean.valueOf(this.bkJ));
        AppMethodBeat.o(117958);
        return bTd;
    }

    /* Access modifiers changed, original: protected */
    public int getReportIdkey() {
        return 0;
    }
}
