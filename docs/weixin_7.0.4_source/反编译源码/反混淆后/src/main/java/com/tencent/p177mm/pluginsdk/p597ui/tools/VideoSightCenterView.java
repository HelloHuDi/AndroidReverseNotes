package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView */
public class VideoSightCenterView extends VideoSightView {
    private boolean cFy = false;
    private int rat = 0;
    private volatile boolean vvw = false;
    private MediaMetadataRetriever vvx;

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView$2 */
    class C233442 implements C13325f {
        C233442() {
        }

        /* renamed from: b */
        public final void mo8946b(C13303b c13303b, long j) {
            AppMethodBeat.m2504i(70398);
            if (VideoSightCenterView.this.duration == 0) {
                VideoSightCenterView.this.duration = VideoSightCenterView.this.getDuration();
            }
            if (VideoSightCenterView.this.llE != null) {
                C4990ab.m7419v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j), Integer.valueOf(VideoSightCenterView.this.duration));
                VideoSightCenterView.this.rat = (int) (1000 * j);
                VideoSightCenterView.this.llE.mo8554dG((int) j, VideoSightCenterView.this.duration);
            }
            AppMethodBeat.m2505o(70398);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView$1 */
    class C233451 implements C13304e {
        C233451() {
        }

        /* renamed from: c */
        public final void mo8940c(C13303b c13303b, int i) {
            AppMethodBeat.m2504i(70397);
            if (-1 == i) {
                C4990ab.m7417i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", Boolean.valueOf(VideoSightCenterView.this.vvw));
                if (!(VideoSightCenterView.this.llE == null || VideoSightCenterView.this.vvw)) {
                    VideoSightCenterView.this.llE.onError(0, 0);
                    AppMethodBeat.m2505o(70397);
                    return;
                }
            } else if (i == 0) {
                C4990ab.m7416i("MicroMsg.VideoSightCenterView", "normal stop");
                VideoSightCenterView.this.vvw = true;
                if (VideoSightCenterView.this.llE != null) {
                    VideoSightCenterView.this.llE.mo8553EA();
                }
            }
            AppMethodBeat.m2505o(70397);
        }
    }

    public VideoSightCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VideoSightCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setDrawableWidth(int i) {
        AppMethodBeat.m2504i(70399);
        super.setDrawableWidth(i);
        dlB();
        AppMethodBeat.m2505o(70399);
    }

    /* renamed from: fi */
    public final void mo8513fi(int i, int i2) {
        AppMethodBeat.m2504i(70400);
        super.mo8513fi(i, i2);
        dlB();
        AppMethodBeat.m2505o(70400);
    }

    private void dlB() {
        AppMethodBeat.m2504i(70401);
        if (getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(70401);
    }

    /* Access modifiers changed, original: protected|final */
    public final void init() {
        AppMethodBeat.m2504i(70402);
        if (C5046bo.m7532bc(C1427q.etn.esB, "").equals(FacebookRequestErrorClassification.KEY_OTHER)) {
            C4990ab.m7416i("MicroMsg.VideoSightCenterView", "init::use other player");
        } else {
            mo8538kA(true);
        }
        setOnCompletionListener(new C233451());
        AppMethodBeat.m2505o(70402);
    }

    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.m2504i(70403);
        if (z) {
            setOnDecodeDurationListener(new C233442());
            AppMethodBeat.m2505o(70403);
            return;
        }
        setOnDecodeDurationListener(null);
        AppMethodBeat.m2505o(70403);
    }

    public int getDuration() {
        AppMethodBeat.m2504i(70404);
        C4990ab.m7416i("MicroMsg.VideoSightCenterView", "getDuration");
        if (!C5046bo.isNullOrNil(this.ien)) {
            try {
                if (this.vvx == null) {
                    this.vvx = new MediaMetadataRetriever();
                    this.vvx.setDataSource(this.ien);
                }
                C4990ab.m7417i("MicroMsg.VideoSightCenterView", "getDuration: %s", Integer.valueOf(Integer.valueOf(this.vvx.extractMetadata(9)).intValue()));
                AppMethodBeat.m2505o(70404);
                return r0;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.VideoSightCenterView", "getDuration error: %s", e.getMessage());
            }
        }
        int duration = super.getDuration();
        AppMethodBeat.m2505o(70404);
        return duration;
    }

    public int getCurrentPosition() {
        AppMethodBeat.m2504i(70405);
        C4990ab.m7419v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", Integer.valueOf(this.rat));
        int i = this.rat;
        AppMethodBeat.m2505o(70405);
        return i;
    }

    public final boolean start() {
        AppMethodBeat.m2504i(70406);
        C4990ab.m7418v("MicroMsg.VideoSightCenterView", "start");
        this.cFy = true;
        boolean start = super.start();
        AppMethodBeat.m2505o(70406);
        return start;
    }

    public final void stop() {
        AppMethodBeat.m2504i(70407);
        C4990ab.m7418v("MicroMsg.VideoSightCenterView", "stop");
        super.stop();
        this.rat = 0;
        this.cFy = false;
        AppMethodBeat.m2505o(70407);
    }

    public final void pause() {
        AppMethodBeat.m2504i(70408);
        C4990ab.m7418v("MicroMsg.VideoSightCenterView", "pause");
        super.pause();
        AppMethodBeat.m2505o(70408);
    }

    public double getLastProgresstime() {
        AppMethodBeat.m2504i(70409);
        double lastProgresstime = super.getLastProgresstime();
        AppMethodBeat.m2505o(70409);
        return lastProgresstime;
    }

    /* renamed from: B */
    public final void mo9052B(double d) {
        AppMethodBeat.m2504i(70410);
        C4990ab.m7419v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", Double.valueOf(d), Boolean.valueOf(this.cFy), Integer.valueOf(this.rat), Double.valueOf(getLastProgresstime()));
        if (this.cFy && getLastProgresstime() > 0.0d) {
            super.mo9052B(d / 1000.0d);
        }
        AppMethodBeat.m2505o(70410);
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(70411);
        C4990ab.m7419v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", Boolean.valueOf(this.cFy), Integer.valueOf(this.rat));
        boolean z = this.cFy;
        AppMethodBeat.m2505o(70411);
        return z;
    }
}
