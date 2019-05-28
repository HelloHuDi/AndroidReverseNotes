package com.tencent.p177mm.pluginsdk.p597ui.tools;

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
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C133193;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;
import com.tencent.p177mm.plugin.sight.decode.p512ui.SightPlayImageView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14978d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14982c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14983b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSightView */
public class VideoSightView extends SightPlayImageView implements C14979e {
    protected int duration = 0;
    private boolean eif = false;
    protected String ien;
    private boolean rcC;
    private boolean rcD = true;

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSightView$1 */
    class C149721 implements C13304e {
        C149721() {
        }

        /* renamed from: c */
        public final void mo8940c(C13303b c13303b, int i) {
            AppMethodBeat.m2504i(70415);
            if (-1 == i) {
                if (VideoSightView.this.llE != null) {
                    VideoSightView.this.llE.onError(0, 0);
                    AppMethodBeat.m2505o(70415);
                    return;
                }
            } else if (i == 0 && VideoSightView.this.llE != null) {
                VideoSightView.this.llE.mo8553EA();
            }
            AppMethodBeat.m2505o(70415);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSightView$2 */
    class C301452 implements C13325f {
        C301452() {
        }

        /* renamed from: b */
        public final void mo8946b(C13303b c13303b, long j) {
            AppMethodBeat.m2504i(70416);
            if (VideoSightView.this.duration == 0) {
                VideoSightView.this.duration = VideoSightView.this.getDuration();
            }
            if (VideoSightView.this.llE != null) {
                C4990ab.m7419v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j), Integer.valueOf(VideoSightView.this.duration));
                VideoSightView.this.llE.mo8554dG((int) j, VideoSightView.this.duration);
            }
            AppMethodBeat.m2505o(70416);
        }
    }

    public VideoSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(70417);
        init();
        AppMethodBeat.m2505o(70417);
    }

    public VideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(70418);
        init();
        AppMethodBeat.m2505o(70418);
    }

    public VideoSightView(Context context) {
        super(context);
        AppMethodBeat.m2504i(70419);
        init();
        AppMethodBeat.m2505o(70419);
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        AppMethodBeat.m2504i(70420);
        if (C5046bo.m7532bc(C1427q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER)) {
            C4990ab.m7416i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            mo8538kA(true);
        }
        setOnCompletionListener(new C149721());
        AppMethodBeat.m2505o(70420);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(70421);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(70421);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(70422);
        super.onLayout(z, i, i2, i3, i4);
        C4990ab.m7419v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.qyG));
        if (this.qyG && i3 - i > 0) {
            setDrawableWidth(i3 - i);
        }
        AppMethodBeat.m2505o(70422);
    }

    public void setEnableConfigChanged(boolean z) {
        this.rcD = z;
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(70423);
        super.onConfigurationChanged(configuration);
        if (this.rcD) {
            setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
        }
        AppMethodBeat.m2505o(70423);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.m2504i(70425);
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
        AppMethodBeat.m2505o(70425);
    }

    public void pause() {
        AppMethodBeat.m2504i(70427);
        mo8509bf(this.ien, true);
        AppMethodBeat.m2505o(70427);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.m2504i(70428);
        setLoopImp(z);
        AppMethodBeat.m2505o(70428);
    }

    public void setVideoCallback(C14981a c14981a) {
        this.llE = c14981a;
    }

    public int getCurrentPosition() {
        AppMethodBeat.m2504i(70429);
        C4990ab.m7418v("MicroMsg.VideoSightView", "get current position");
        AppMethodBeat.m2505o(70429);
        return 0;
    }

    public int getDuration() {
        AppMethodBeat.m2504i(70430);
        int duration = super.getDuration();
        C4990ab.m7418v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(duration)));
        AppMethodBeat.m2505o(70430);
        return duration;
    }

    public boolean start() {
        AppMethodBeat.m2504i(70432);
        boolean w = mo27377w(getContext(), false);
        AppMethodBeat.m2505o(70432);
        return w;
    }

    /* renamed from: w */
    public final boolean mo27377w(Context context, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(70433);
        if (this.ien == null) {
            C4990ab.m7412e("MicroMsg.VideoSightView", "start::use path is null!");
            AppMethodBeat.m2505o(70433);
            return false;
        } else if (C5046bo.m7532bc(C1427q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER) || !C13303b.m21376WS(this.ien)) {
            C4990ab.m7417i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", this.ien, Boolean.valueOf(this.rcC));
            if (!this.rcC || z) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                C15429k.m23713a(context, intent, new File(this.ien), "video/*");
                try {
                    context.startActivity(Intent.createChooser(intent, context.getString(C25738R.string.f9254ue)));
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                    C30379h.m48465bQ(context, context.getResources().getString(C25738R.string.f1a));
                }
                this.rcC = true;
                AppMethodBeat.m2505o(70433);
                return false;
            }
            AppMethodBeat.m2505o(70433);
            return false;
        } else {
            mo8509bf(this.ien, false);
            if (!this.eif) {
                z2 = true;
            }
            mo8538kA(z2);
            AppMethodBeat.m2505o(70433);
            return true;
        }
    }

    public void setThumb(Bitmap bitmap) {
        AppMethodBeat.m2504i(70434);
        mo8535V(bitmap);
        AppMethodBeat.m2505o(70434);
    }

    public double getLastProgresstime() {
        AppMethodBeat.m2504i(70435);
        if (getController() != null) {
            C13303b controller = getController();
            double d;
            if (controller.qxP != -1.0d) {
                d = controller.qxP;
                AppMethodBeat.m2505o(70435);
                return d;
            }
            d = controller.qxM;
            AppMethodBeat.m2505o(70435);
            return d;
        }
        AppMethodBeat.m2505o(70435);
        return 0.0d;
    }

    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.m2504i(70437);
        if (z) {
            setOnDecodeDurationListener(new C301452());
            AppMethodBeat.m2505o(70437);
            return;
        }
        setOnDecodeDurationListener(null);
        AppMethodBeat.m2505o(70437);
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(70438);
        this.eif = z;
        mo8538kA(!this.eif);
        AppMethodBeat.m2505o(70438);
    }

    /* renamed from: d */
    public final void mo27356d(double d, boolean z) {
        AppMethodBeat.m2504i(70439);
        mo9052B(d);
        AppMethodBeat.m2505o(70439);
    }

    public void setOneTimeVideoTextureUpdateCallback(C14980e c14980e) {
    }

    public void setOnSeekCompleteCallback(C14982c c14982c) {
    }

    public void setOnInfoCallback(C14983b c14983b) {
    }

    public void setOnSurfaceCallback(C14978d c14978d) {
    }

    public boolean isPlaying() {
        AppMethodBeat.m2504i(70424);
        boolean cla = this.qyA.cla();
        AppMethodBeat.m2505o(70424);
        return cla;
    }

    public void stop() {
        AppMethodBeat.m2504i(70426);
        this.qyA.clear();
        AppMethodBeat.m2505o(70426);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(70431);
        C4879a.xxA.mo10053d(this.qyA.cld());
        AppMethodBeat.m2505o(70431);
    }

    /* renamed from: B */
    public void mo9052B(double d) {
        AppMethodBeat.m2504i(70436);
        if (this.qyA != null) {
            C13303b c13303b = this.qyA;
            C4990ab.m7419v("MicroMsg.SightPlayController", "seekToFrame now %f %s", Double.valueOf(d), C5046bo.dpG().toString());
            C37961o.m64222i(new C133193(d), 0);
        }
        AppMethodBeat.m2505o(70436);
    }
}
