package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.plugin.sight.decode.a.b.AnonymousClass3;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.c;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import java.io.File;

public class VideoSightView extends SightPlayImageView implements e {
    protected int duration = 0;
    private boolean eif = false;
    protected String ien;
    private boolean rcC;
    private boolean rcD = true;

    public VideoSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(70417);
        init();
        AppMethodBeat.o(70417);
    }

    public VideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(70418);
        init();
        AppMethodBeat.o(70418);
    }

    public VideoSightView(Context context) {
        super(context);
        AppMethodBeat.i(70419);
        init();
        AppMethodBeat.o(70419);
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        AppMethodBeat.i(70420);
        if (bo.bc(q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER)) {
            ab.i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            kA(true);
        }
        setOnCompletionListener(new e() {
            public final void c(b bVar, int i) {
                AppMethodBeat.i(70415);
                if (-1 == i) {
                    if (VideoSightView.this.llE != null) {
                        VideoSightView.this.llE.onError(0, 0);
                        AppMethodBeat.o(70415);
                        return;
                    }
                } else if (i == 0 && VideoSightView.this.llE != null) {
                    VideoSightView.this.llE.EA();
                }
                AppMethodBeat.o(70415);
            }
        });
        AppMethodBeat.o(70420);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(70421);
        super.onMeasure(i, i2);
        AppMethodBeat.o(70421);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(70422);
        super.onLayout(z, i, i2, i3, i4);
        ab.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.qyG));
        if (this.qyG && i3 - i > 0) {
            setDrawableWidth(i3 - i);
        }
        AppMethodBeat.o(70422);
    }

    public void setEnableConfigChanged(boolean z) {
        this.rcD = z;
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(70423);
        super.onConfigurationChanged(configuration);
        if (this.rcD) {
            setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
        }
        AppMethodBeat.o(70423);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.i(70425);
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
        AppMethodBeat.o(70425);
    }

    public void pause() {
        AppMethodBeat.i(70427);
        bf(this.ien, true);
        AppMethodBeat.o(70427);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(70428);
        setLoopImp(z);
        AppMethodBeat.o(70428);
    }

    public void setVideoCallback(a aVar) {
        this.llE = aVar;
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(70429);
        ab.v("MicroMsg.VideoSightView", "get current position");
        AppMethodBeat.o(70429);
        return 0;
    }

    public int getDuration() {
        AppMethodBeat.i(70430);
        int duration = super.getDuration();
        ab.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(duration)));
        AppMethodBeat.o(70430);
        return duration;
    }

    public boolean start() {
        AppMethodBeat.i(70432);
        boolean w = w(getContext(), false);
        AppMethodBeat.o(70432);
        return w;
    }

    public final boolean w(Context context, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(70433);
        if (this.ien == null) {
            ab.e("MicroMsg.VideoSightView", "start::use path is null!");
            AppMethodBeat.o(70433);
            return false;
        } else if (bo.bc(q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER) || !b.WS(this.ien)) {
            ab.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", this.ien, Boolean.valueOf(this.rcC));
            if (!this.rcC || z) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                k.a(context, intent, new File(this.ien), "video/*");
                try {
                    context.startActivity(Intent.createChooser(intent, context.getString(R.string.ue)));
                } catch (Exception e) {
                    ab.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                    h.bQ(context, context.getResources().getString(R.string.f1a));
                }
                this.rcC = true;
                AppMethodBeat.o(70433);
                return false;
            }
            AppMethodBeat.o(70433);
            return false;
        } else {
            bf(this.ien, false);
            if (!this.eif) {
                z2 = true;
            }
            kA(z2);
            AppMethodBeat.o(70433);
            return true;
        }
    }

    public void setThumb(Bitmap bitmap) {
        AppMethodBeat.i(70434);
        V(bitmap);
        AppMethodBeat.o(70434);
    }

    public double getLastProgresstime() {
        AppMethodBeat.i(70435);
        if (getController() != null) {
            b controller = getController();
            double d;
            if (controller.qxP != -1.0d) {
                d = controller.qxP;
                AppMethodBeat.o(70435);
                return d;
            }
            d = controller.qxM;
            AppMethodBeat.o(70435);
            return d;
        }
        AppMethodBeat.o(70435);
        return 0.0d;
    }

    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.i(70437);
        if (z) {
            setOnDecodeDurationListener(new f() {
                public final void b(b bVar, long j) {
                    AppMethodBeat.i(70416);
                    if (VideoSightView.this.duration == 0) {
                        VideoSightView.this.duration = VideoSightView.this.getDuration();
                    }
                    if (VideoSightView.this.llE != null) {
                        ab.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j), Integer.valueOf(VideoSightView.this.duration));
                        VideoSightView.this.llE.dG((int) j, VideoSightView.this.duration);
                    }
                    AppMethodBeat.o(70416);
                }
            });
            AppMethodBeat.o(70437);
            return;
        }
        setOnDecodeDurationListener(null);
        AppMethodBeat.o(70437);
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(70438);
        this.eif = z;
        kA(!this.eif);
        AppMethodBeat.o(70438);
    }

    public final void d(double d, boolean z) {
        AppMethodBeat.i(70439);
        B(d);
        AppMethodBeat.o(70439);
    }

    public void setOneTimeVideoTextureUpdateCallback(e.e eVar) {
    }

    public void setOnSeekCompleteCallback(c cVar) {
    }

    public void setOnInfoCallback(e.b bVar) {
    }

    public void setOnSurfaceCallback(d dVar) {
    }

    public boolean isPlaying() {
        AppMethodBeat.i(70424);
        boolean cla = this.qyA.cla();
        AppMethodBeat.o(70424);
        return cla;
    }

    public void stop() {
        AppMethodBeat.i(70426);
        this.qyA.clear();
        AppMethodBeat.o(70426);
    }

    public final void onDetach() {
        AppMethodBeat.i(70431);
        com.tencent.mm.sdk.b.a.xxA.d(this.qyA.cld());
        AppMethodBeat.o(70431);
    }

    public void B(double d) {
        AppMethodBeat.i(70436);
        if (this.qyA != null) {
            b bVar = this.qyA;
            ab.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", Double.valueOf(d), bo.dpG().toString());
            o.i(new AnonymousClass3(d), 0);
        }
        AppMethodBeat.o(70436);
    }
}
