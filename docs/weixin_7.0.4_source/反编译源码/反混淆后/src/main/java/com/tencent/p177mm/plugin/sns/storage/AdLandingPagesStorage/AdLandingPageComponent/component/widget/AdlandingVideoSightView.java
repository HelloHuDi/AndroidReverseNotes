package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3919b.C3926e;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3919b.C3927f;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3919b.C39332;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14978d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14982c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14983b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView */
public class AdlandingVideoSightView extends AdlandingSightPlayImageView implements C14979e {
    protected int duration = 0;
    private boolean eif = false;
    protected String ien;
    private boolean rcC;
    private boolean rcD = true;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView$1 */
    class C39091 implements C3926e {
        C39091() {
        }

        /* renamed from: Ds */
        public final void mo8653Ds(int i) {
            AppMethodBeat.m2504i(37456);
            if (-1 == i) {
                if (AdlandingVideoSightView.this.llE != null) {
                    AdlandingVideoSightView.this.llE.onError(0, 0);
                    AppMethodBeat.m2505o(37456);
                    return;
                }
            } else if (i == 0 && AdlandingVideoSightView.this.llE != null) {
                AdlandingVideoSightView.this.llE.mo8553EA();
            }
            AppMethodBeat.m2505o(37456);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView$2 */
    class C290802 implements C3927f {
        C290802() {
        }

        /* renamed from: ks */
        public final void mo8681ks(long j) {
            AppMethodBeat.m2504i(37457);
            if (AdlandingVideoSightView.this.duration == 0) {
                AdlandingVideoSightView.this.duration = AdlandingVideoSightView.this.getDuration();
            }
            if (AdlandingVideoSightView.this.llE != null) {
                C4990ab.m7419v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j), Integer.valueOf(AdlandingVideoSightView.this.duration));
                AdlandingVideoSightView.this.llE.mo8554dG((int) j, AdlandingVideoSightView.this.duration);
            }
            AppMethodBeat.m2505o(37457);
        }
    }

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(37458);
        init();
        AppMethodBeat.m2505o(37458);
    }

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(37459);
        init();
        AppMethodBeat.m2505o(37459);
    }

    private void init() {
        AppMethodBeat.m2504i(37460);
        if (C5046bo.m7532bc(C1427q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER)) {
            C4990ab.m7416i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            mo62876kA(true);
        }
        setOnCompletionListener(new C39091());
        AppMethodBeat.m2505o(37460);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(37461);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(37461);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(37462);
        super.onLayout(z, i, i2, i3, i4);
        C4990ab.m7419v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.qyG));
        if (this.qyG && i3 - i > 0) {
            setDrawableWidth(i3 - i);
        }
        AppMethodBeat.m2505o(37462);
    }

    public void setEnableConfigChanged(boolean z) {
        this.rcD = z;
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(37463);
        super.onConfigurationChanged(configuration);
        if (this.rcD) {
            setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
        }
        AppMethodBeat.m2505o(37463);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.m2504i(37465);
        String str2 = "MicroMsg.VideoSightView";
        String str3 = "set sight path %s, callback null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.llE == null);
        C4990ab.m7417i(str2, str3, objArr);
        this.duration = 0;
        this.ien = str;
        if (this.llE != null) {
            this.llE.mo8557pL();
        }
        AppMethodBeat.m2505o(37465);
    }

    public final void pause() {
        AppMethodBeat.m2504i(37467);
        mo62871bf(this.ien, true);
        AppMethodBeat.m2505o(37467);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.m2504i(37468);
        setLoopImp(z);
        AppMethodBeat.m2505o(37468);
    }

    public void setVideoCallback(C14981a c14981a) {
        this.llE = c14981a;
    }

    public int getCurrentPosition() {
        AppMethodBeat.m2504i(37469);
        C4990ab.m7418v("MicroMsg.VideoSightView", "get current position");
        AppMethodBeat.m2505o(37469);
        return 0;
    }

    public int getDuration() {
        AppMethodBeat.m2504i(37470);
        int duration = super.getDuration();
        C4990ab.m7418v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(duration)));
        AppMethodBeat.m2505o(37470);
        return duration;
    }

    public final boolean start() {
        AppMethodBeat.m2504i(37472);
        boolean w = mo27377w(getContext(), false);
        AppMethodBeat.m2505o(37472);
        return w;
    }

    /* renamed from: w */
    public final boolean mo27377w(Context context, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(37473);
        if (this.ien == null) {
            C4990ab.m7412e("MicroMsg.VideoSightView", "start::use path is null!");
            AppMethodBeat.m2505o(37473);
            return false;
        } else if (C5046bo.m7532bc(C1427q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER) || !C13303b.m21376WS(this.ien)) {
            C4990ab.m7417i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", this.ien, Boolean.valueOf(this.rcC));
            if (!this.rcC || z) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                C15429k.m23712a(context, intent, C5730e.asY(this.ien), "video/*");
                try {
                    context.startActivity(Intent.createChooser(intent, context.getString(C25738R.string.bs9)));
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                    C30379h.m48465bQ(context, context.getResources().getString(C25738R.string.f1a));
                }
                this.rcC = true;
                AppMethodBeat.m2505o(37473);
                return false;
            }
            AppMethodBeat.m2505o(37473);
            return false;
        } else {
            mo62871bf(this.ien, false);
            if (!this.eif) {
                z2 = true;
            }
            mo62876kA(z2);
            AppMethodBeat.m2505o(37473);
            return true;
        }
    }

    public void setThumb(Bitmap bitmap) {
        AppMethodBeat.m2504i(37474);
        mo62870V(bitmap);
        AppMethodBeat.m2505o(37474);
    }

    public double getLastProgresstime() {
        AppMethodBeat.m2504i(37475);
        if (getController() != null) {
            C3919b controller = getController();
            double d;
            if (controller.qxP != -1.0d) {
                d = controller.qxP;
                AppMethodBeat.m2505o(37475);
                return d;
            }
            d = controller.qxM;
            AppMethodBeat.m2505o(37475);
            return d;
        }
        AppMethodBeat.m2505o(37475);
        return 0.0d;
    }

    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.m2504i(37477);
        if (z) {
            setOnDecodeDurationListener(new C290802());
            AppMethodBeat.m2505o(37477);
            return;
        }
        setOnDecodeDurationListener(null);
        AppMethodBeat.m2505o(37477);
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(37478);
        this.eif = z;
        mo62876kA(!this.eif);
        AppMethodBeat.m2505o(37478);
    }

    /* renamed from: d */
    public final void mo27356d(double d, boolean z) {
        AppMethodBeat.m2504i(37479);
        mo9052B(d);
        AppMethodBeat.m2505o(37479);
    }

    public void setOneTimeVideoTextureUpdateCallback(C14980e c14980e) {
    }

    public void setOnSeekCompleteCallback(C14982c c14982c) {
    }

    public void setOnInfoCallback(C14983b c14983b) {
    }

    public void setOnSurfaceCallback(C14978d c14978d) {
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(37464);
        boolean cla = this.rcz.cla();
        AppMethodBeat.m2505o(37464);
        return cla;
    }

    public final void stop() {
        AppMethodBeat.m2504i(37466);
        this.rcz.clear();
        AppMethodBeat.m2505o(37466);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(37471);
        C4879a.xxA.mo10053d(this.rcz.cld());
        AppMethodBeat.m2505o(37471);
    }

    /* renamed from: B */
    public final void mo9052B(double d) {
        AppMethodBeat.m2504i(37476);
        if (this.rcz != null) {
            C3919b c3919b = this.rcz;
            C4990ab.m7419v("MicroMsg.SightPlayController", "seekToFrame now %f %s", Double.valueOf(d), C5046bo.dpG().toString());
            C37961o.m64222i(new C39332(d), 0);
        }
        AppMethodBeat.m2505o(37476);
    }
}
