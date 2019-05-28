package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class VideoSightCenterView extends VideoSightView {
    private boolean cFy = false;
    private int rat = 0;
    private volatile boolean vvw = false;
    private MediaMetadataRetriever vvx;

    public VideoSightCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VideoSightCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setDrawableWidth(int i) {
        AppMethodBeat.i(70399);
        super.setDrawableWidth(i);
        dlB();
        AppMethodBeat.o(70399);
    }

    public final void fi(int i, int i2) {
        AppMethodBeat.i(70400);
        super.fi(i, i2);
        dlB();
        AppMethodBeat.o(70400);
    }

    private void dlB() {
        AppMethodBeat.i(70401);
        if (getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(70401);
    }

    /* Access modifiers changed, original: protected|final */
    public final void init() {
        AppMethodBeat.i(70402);
        if (bo.bc(q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER)) {
            ab.i("MicroMsg.VideoSightCenterView", "init::use other player");
        } else {
            kA(true);
        }
        setOnCompletionListener(new e() {
            public final void c(b bVar, int i) {
                AppMethodBeat.i(70397);
                if (-1 == i) {
                    ab.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", Boolean.valueOf(VideoSightCenterView.this.vvw));
                    if (!(VideoSightCenterView.this.llE == null || VideoSightCenterView.this.vvw)) {
                        VideoSightCenterView.this.llE.onError(0, 0);
                        AppMethodBeat.o(70397);
                        return;
                    }
                } else if (i == 0) {
                    ab.i("MicroMsg.VideoSightCenterView", "normal stop");
                    VideoSightCenterView.this.vvw = true;
                    if (VideoSightCenterView.this.llE != null) {
                        VideoSightCenterView.this.llE.EA();
                    }
                }
                AppMethodBeat.o(70397);
            }
        });
        AppMethodBeat.o(70402);
    }

    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.i(70403);
        if (z) {
            setOnDecodeDurationListener(new f() {
                public final void b(b bVar, long j) {
                    AppMethodBeat.i(70398);
                    if (VideoSightCenterView.this.duration == 0) {
                        VideoSightCenterView.this.duration = VideoSightCenterView.this.getDuration();
                    }
                    if (VideoSightCenterView.this.llE != null) {
                        ab.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j), Integer.valueOf(VideoSightCenterView.this.duration));
                        VideoSightCenterView.this.rat = (int) (1000 * j);
                        VideoSightCenterView.this.llE.dG((int) j, VideoSightCenterView.this.duration);
                    }
                    AppMethodBeat.o(70398);
                }
            });
            AppMethodBeat.o(70403);
            return;
        }
        setOnDecodeDurationListener(null);
        AppMethodBeat.o(70403);
    }

    public int getDuration() {
        AppMethodBeat.i(70404);
        ab.i("MicroMsg.VideoSightCenterView", "getDuration");
        if (!bo.isNullOrNil(this.ien)) {
            try {
                if (this.vvx == null) {
                    this.vvx = new MediaMetadataRetriever();
                    this.vvx.setDataSource(this.ien);
                }
                ab.i("MicroMsg.VideoSightCenterView", "getDuration: %s", Integer.valueOf(Integer.valueOf(this.vvx.extractMetadata(9)).intValue()));
                AppMethodBeat.o(70404);
                return r0;
            } catch (Exception e) {
                ab.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", e.getMessage());
            }
        }
        int duration = super.getDuration();
        AppMethodBeat.o(70404);
        return duration;
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(70405);
        ab.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", Integer.valueOf(this.rat));
        int i = this.rat;
        AppMethodBeat.o(70405);
        return i;
    }

    public final boolean start() {
        AppMethodBeat.i(70406);
        ab.v("MicroMsg.VideoSightCenterView", "start");
        this.cFy = true;
        boolean start = super.start();
        AppMethodBeat.o(70406);
        return start;
    }

    public final void stop() {
        AppMethodBeat.i(70407);
        ab.v("MicroMsg.VideoSightCenterView", "stop");
        super.stop();
        this.rat = 0;
        this.cFy = false;
        AppMethodBeat.o(70407);
    }

    public final void pause() {
        AppMethodBeat.i(70408);
        ab.v("MicroMsg.VideoSightCenterView", "pause");
        super.pause();
        AppMethodBeat.o(70408);
    }

    public double getLastProgresstime() {
        AppMethodBeat.i(70409);
        double lastProgresstime = super.getLastProgresstime();
        AppMethodBeat.o(70409);
        return lastProgresstime;
    }

    public final void B(double d) {
        AppMethodBeat.i(70410);
        ab.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", Double.valueOf(d), Boolean.valueOf(this.cFy), Integer.valueOf(this.rat), Double.valueOf(getLastProgresstime()));
        if (this.cFy && getLastProgresstime() > 0.0d) {
            super.B(d / 1000.0d);
        }
        AppMethodBeat.o(70410);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(70411);
        ab.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", Boolean.valueOf(this.cFy), Integer.valueOf(this.rat));
        boolean z = this.cFy;
        AppMethodBeat.o(70411);
        return z;
    }
}
