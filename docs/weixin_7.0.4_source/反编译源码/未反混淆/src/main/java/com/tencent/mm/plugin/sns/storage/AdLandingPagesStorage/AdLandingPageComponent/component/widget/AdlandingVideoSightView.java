package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.f;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.c;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;

public class AdlandingVideoSightView extends AdlandingSightPlayImageView implements e {
    protected int duration = 0;
    private boolean eif = false;
    protected String ien;
    private boolean rcC;
    private boolean rcD = true;

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(37458);
        init();
        AppMethodBeat.o(37458);
    }

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(37459);
        init();
        AppMethodBeat.o(37459);
    }

    private void init() {
        AppMethodBeat.i(37460);
        if (bo.bc(q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER)) {
            ab.i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            kA(true);
        }
        setOnCompletionListener(new b.e() {
            public final void Ds(int i) {
                AppMethodBeat.i(37456);
                if (-1 == i) {
                    if (AdlandingVideoSightView.this.llE != null) {
                        AdlandingVideoSightView.this.llE.onError(0, 0);
                        AppMethodBeat.o(37456);
                        return;
                    }
                } else if (i == 0 && AdlandingVideoSightView.this.llE != null) {
                    AdlandingVideoSightView.this.llE.EA();
                }
                AppMethodBeat.o(37456);
            }
        });
        AppMethodBeat.o(37460);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(37461);
        super.onMeasure(i, i2);
        AppMethodBeat.o(37461);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(37462);
        super.onLayout(z, i, i2, i3, i4);
        ab.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.qyG));
        if (this.qyG && i3 - i > 0) {
            setDrawableWidth(i3 - i);
        }
        AppMethodBeat.o(37462);
    }

    public void setEnableConfigChanged(boolean z) {
        this.rcD = z;
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(37463);
        super.onConfigurationChanged(configuration);
        if (this.rcD) {
            setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
        }
        AppMethodBeat.o(37463);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.i(37465);
        String str2 = "MicroMsg.VideoSightView";
        String str3 = "set sight path %s, callback null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.llE == null);
        ab.i(str2, str3, objArr);
        this.duration = 0;
        this.ien = str;
        if (this.llE != null) {
            this.llE.pL();
        }
        AppMethodBeat.o(37465);
    }

    public final void pause() {
        AppMethodBeat.i(37467);
        bf(this.ien, true);
        AppMethodBeat.o(37467);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(37468);
        setLoopImp(z);
        AppMethodBeat.o(37468);
    }

    public void setVideoCallback(a aVar) {
        this.llE = aVar;
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(37469);
        ab.v("MicroMsg.VideoSightView", "get current position");
        AppMethodBeat.o(37469);
        return 0;
    }

    public int getDuration() {
        AppMethodBeat.i(37470);
        int duration = super.getDuration();
        ab.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(duration)));
        AppMethodBeat.o(37470);
        return duration;
    }

    public final boolean start() {
        AppMethodBeat.i(37472);
        boolean w = w(getContext(), false);
        AppMethodBeat.o(37472);
        return w;
    }

    public final boolean w(Context context, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(37473);
        if (this.ien == null) {
            ab.e("MicroMsg.VideoSightView", "start::use path is null!");
            AppMethodBeat.o(37473);
            return false;
        } else if (bo.bc(q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER) || !b.WS(this.ien)) {
            ab.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", this.ien, Boolean.valueOf(this.rcC));
            if (!this.rcC || z) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                k.a(context, intent, com.tencent.mm.vfs.e.asY(this.ien), "video/*");
                try {
                    context.startActivity(Intent.createChooser(intent, context.getString(R.string.bs9)));
                } catch (Exception e) {
                    ab.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                    h.bQ(context, context.getResources().getString(R.string.f1a));
                }
                this.rcC = true;
                AppMethodBeat.o(37473);
                return false;
            }
            AppMethodBeat.o(37473);
            return false;
        } else {
            bf(this.ien, false);
            if (!this.eif) {
                z2 = true;
            }
            kA(z2);
            AppMethodBeat.o(37473);
            return true;
        }
    }

    public void setThumb(Bitmap bitmap) {
        AppMethodBeat.i(37474);
        V(bitmap);
        AppMethodBeat.o(37474);
    }

    public double getLastProgresstime() {
        AppMethodBeat.i(37475);
        if (getController() != null) {
            b controller = getController();
            double d;
            if (controller.qxP != -1.0d) {
                d = controller.qxP;
                AppMethodBeat.o(37475);
                return d;
            }
            d = controller.qxM;
            AppMethodBeat.o(37475);
            return d;
        }
        AppMethodBeat.o(37475);
        return 0.0d;
    }

    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.i(37477);
        if (z) {
            setOnDecodeDurationListener(new f() {
                public final void ks(long j) {
                    AppMethodBeat.i(37457);
                    if (AdlandingVideoSightView.this.duration == 0) {
                        AdlandingVideoSightView.this.duration = AdlandingVideoSightView.this.getDuration();
                    }
                    if (AdlandingVideoSightView.this.llE != null) {
                        ab.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j), Integer.valueOf(AdlandingVideoSightView.this.duration));
                        AdlandingVideoSightView.this.llE.dG((int) j, AdlandingVideoSightView.this.duration);
                    }
                    AppMethodBeat.o(37457);
                }
            });
            AppMethodBeat.o(37477);
            return;
        }
        setOnDecodeDurationListener(null);
        AppMethodBeat.o(37477);
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(37478);
        this.eif = z;
        kA(!this.eif);
        AppMethodBeat.o(37478);
    }

    public final void d(double d, boolean z) {
        AppMethodBeat.i(37479);
        B(d);
        AppMethodBeat.o(37479);
    }

    public void setOneTimeVideoTextureUpdateCallback(e.e eVar) {
    }

    public void setOnSeekCompleteCallback(c cVar) {
    }

    public void setOnInfoCallback(e.b bVar) {
    }

    public void setOnSurfaceCallback(d dVar) {
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(37464);
        boolean cla = this.rcz.cla();
        AppMethodBeat.o(37464);
        return cla;
    }

    public final void stop() {
        AppMethodBeat.i(37466);
        this.rcz.clear();
        AppMethodBeat.o(37466);
    }

    public final void onDetach() {
        AppMethodBeat.i(37471);
        com.tencent.mm.sdk.b.a.xxA.d(this.rcz.cld());
        AppMethodBeat.o(37471);
    }

    public final void B(double d) {
        AppMethodBeat.i(37476);
        if (this.rcz != null) {
            b bVar = this.rcz;
            ab.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", Double.valueOf(d), bo.dpG().toString());
            o.i(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.AnonymousClass2(d), 0);
        }
        AppMethodBeat.o(37476);
    }
}
