package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class WebVideoWrapper extends RelativeLayout implements a, h, b, c {
    private boolean bkJ;
    private h hZY;
    private int iad;
    private d iaf;
    private Context mContext;
    private b rcd;
    private String url;

    public WebVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(9860);
        this.mContext = context;
        this.iaf = new d();
        if (this.hZY == null) {
            CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
            commonVideoView.setReporter(this);
            commonVideoView.setIMMVideoViewCallback(this);
            gp(200);
            this.hZY = commonVideoView;
        }
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        addView((View) this.hZY, layoutParams);
        AppMethodBeat.o(9860);
    }

    public final void c(boolean z, String str, int i) {
        AppMethodBeat.i(9861);
        this.iad = i;
        this.bkJ = z;
        this.url = str;
        if (this.hZY != null) {
            this.hZY.c(this.bkJ, this.url, this.iad);
        }
        AppMethodBeat.o(9861);
    }

    public void setIMMVideoViewCallback(b bVar) {
        this.rcd = bVar;
    }

    public void setVideoFooterView(g gVar) {
        AppMethodBeat.i(9862);
        if (this.hZY != null) {
            this.hZY.setVideoFooterView(gVar);
        }
        AppMethodBeat.o(9862);
    }

    public final void cpU() {
        AppMethodBeat.i(9863);
        if (this.hZY != null) {
            this.hZY.cpU();
        }
        AppMethodBeat.o(9863);
    }

    public int getPlayerType() {
        AppMethodBeat.i(9864);
        if (this.hZY != null) {
            int playerType = this.hZY.getPlayerType();
            AppMethodBeat.o(9864);
            return playerType;
        }
        AppMethodBeat.o(9864);
        return 0;
    }

    public final boolean s(double d) {
        AppMethodBeat.i(9865);
        if (this.hZY != null) {
            boolean s = this.hZY.s(d);
            AppMethodBeat.o(9865);
            return s;
        }
        AppMethodBeat.o(9865);
        return false;
    }

    public final boolean e(double d, boolean z) {
        AppMethodBeat.i(9866);
        if (this.hZY != null) {
            boolean e = this.hZY.e(d, z);
            AppMethodBeat.o(9866);
            return e;
        }
        AppMethodBeat.o(9866);
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(9867);
        if (this.hZY != null) {
            this.hZY.setIsShowBasicControls(z);
        }
        AppMethodBeat.o(9867);
    }

    public void setFullDirection(int i) {
        AppMethodBeat.i(9868);
        if (this.hZY != null) {
            this.hZY.setFullDirection(i);
        }
        AppMethodBeat.o(9868);
    }

    public int getVideoDurationSec() {
        AppMethodBeat.i(9869);
        int videoDurationSec;
        if (this.hZY != null) {
            videoDurationSec = this.hZY.getVideoDurationSec();
            AppMethodBeat.o(9869);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.o(9869);
        return videoDurationSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.i(9870);
        if (this.hZY != null) {
            int currPosMs = this.hZY.getCurrPosMs();
            AppMethodBeat.o(9870);
            return currPosMs;
        }
        AppMethodBeat.o(9870);
        return 0;
    }

    public int getCurrPosSec() {
        AppMethodBeat.i(9871);
        if (this.hZY != null) {
            int currPosSec = this.hZY.getCurrPosSec();
            AppMethodBeat.o(9871);
            return currPosSec;
        }
        AppMethodBeat.o(9871);
        return 0;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.i(9872);
        if (this.hZY != null) {
            int cacheTimeSec = this.hZY.getCacheTimeSec();
            AppMethodBeat.o(9872);
            return cacheTimeSec;
        }
        AppMethodBeat.o(9872);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(9873);
        if (this.hZY != null) {
            boolean isPlaying = this.hZY.isPlaying();
            AppMethodBeat.o(9873);
            return isPlaying;
        }
        AppMethodBeat.o(9873);
        return false;
    }

    public final boolean isLive() {
        AppMethodBeat.i(9874);
        if (this.hZY != null) {
            boolean isLive = this.hZY.isLive();
            AppMethodBeat.o(9874);
            return isLive;
        }
        AppMethodBeat.o(9874);
        return false;
    }

    public void setCover(Bitmap bitmap) {
        AppMethodBeat.i(9875);
        if (this.hZY != null) {
            this.hZY.setCover(bitmap);
        }
        AppMethodBeat.o(9875);
    }

    public final void start() {
        AppMethodBeat.i(9876);
        if (this.hZY != null) {
            this.hZY.start();
            setKeepScreenOn(true);
            this.iaf.a(this);
        }
        AppMethodBeat.o(9876);
    }

    public final void stop() {
        AppMethodBeat.i(9877);
        if (this.hZY != null) {
            this.hZY.stop();
            this.iaf.cy(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.o(9877);
    }

    public final boolean pause() {
        AppMethodBeat.i(9878);
        if (this.hZY != null) {
            setKeepScreenOn(false);
            this.iaf.cy(false);
            boolean pause = this.hZY.pause();
            AppMethodBeat.o(9878);
            return pause;
        }
        AppMethodBeat.o(9878);
        return false;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(9879);
        if (this.hZY != null) {
            this.hZY.setMute(z);
        }
        AppMethodBeat.o(9879);
    }

    public final void akW() {
        AppMethodBeat.i(9880);
        if (this.hZY != null) {
            this.hZY.akW();
        }
        AppMethodBeat.o(9880);
    }

    public final void akV() {
        AppMethodBeat.i(9881);
        if (this.hZY != null) {
            this.hZY.akV();
        }
        this.iaf.cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(9881);
    }

    public final void aEX() {
        AppMethodBeat.i(9882);
        if (this.hZY != null) {
            this.hZY.aEX();
        }
        this.iaf.cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(9882);
    }

    public void setScaleType(h.d dVar) {
        AppMethodBeat.i(9883);
        if (this.hZY != null) {
            this.hZY.setScaleType(dVar);
        }
        AppMethodBeat.o(9883);
    }

    public final boolean as(float f) {
        AppMethodBeat.i(9884);
        if (f <= 0.0f) {
            AppMethodBeat.o(9884);
            return false;
        } else if (this.hZY != null) {
            boolean as = this.hZY.as(f);
            AppMethodBeat.o(9884);
            return as;
        } else {
            AppMethodBeat.o(9884);
            return false;
        }
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(9885);
        ab.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.c(str, str2, str3, i, i2);
        }
        AppMethodBeat.o(9885);
    }

    public final void cp(String str, String str2) {
        AppMethodBeat.i(9886);
        ab.i("MicroMsg.WebVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.cp(str, str2);
        }
        AppMethodBeat.o(9886);
    }

    public final void cq(String str, String str2) {
        AppMethodBeat.i(9887);
        ab.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.cq(str, str2);
        }
        AppMethodBeat.o(9887);
    }

    public final void d(String str, String str2, int i, int i2) {
        AppMethodBeat.i(9888);
        ab.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.d(str, str2, i, i2);
        }
        AppMethodBeat.o(9888);
    }

    public final void cr(String str, String str2) {
        AppMethodBeat.i(9889);
        ab.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.iaf.cy(false);
        if (this.rcd != null) {
            this.rcd.cr(str, str2);
        }
        AppMethodBeat.o(9889);
    }

    public final void cs(String str, String str2) {
        AppMethodBeat.i(9890);
        ab.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.iaf.a(this);
        if (this.rcd != null) {
            this.rcd.cs(str, str2);
        }
        AppMethodBeat.o(9890);
    }

    public final void ct(String str, String str2) {
        AppMethodBeat.i(9891);
        if (this.rcd != null) {
            this.rcd.ct(str, str2);
        }
        AppMethodBeat.o(9891);
    }

    public final void cu(String str, String str2) {
        AppMethodBeat.i(9892);
        if (this.rcd != null) {
            this.rcd.cu(str, str2);
        }
        AppMethodBeat.o(9892);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(9893);
        ab.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), bo.dpG());
        super.setKeepScreenOn(z);
        AppMethodBeat.o(9893);
    }

    public final void gp(long j) {
        AppMethodBeat.i(9894);
        com.tencent.mm.plugin.report.service.h.pYm.a(600, j, 1, false);
        AppMethodBeat.o(9894);
    }

    public final void wB(String str) {
        AppMethodBeat.i(9895);
        com.tencent.mm.plugin.report.service.h.pYm.X(14349, str);
        AppMethodBeat.o(9895);
    }
}
