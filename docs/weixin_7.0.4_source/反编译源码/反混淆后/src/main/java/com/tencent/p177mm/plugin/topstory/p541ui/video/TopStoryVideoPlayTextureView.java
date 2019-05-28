package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.p468n.C34602i;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryVideoPlayTextureView */
public class TopStoryVideoPlayTextureView extends VideoPlayerTextureView {
    private Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryVideoPlayTextureView$1 */
    class C399741 implements Runnable {
        C399741() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1778);
            synchronized (TopStoryVideoPlayTextureView.this.lock) {
                try {
                    TopStoryVideoPlayTextureView.m68445b(TopStoryVideoPlayTextureView.this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(1778);
                }
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m68445b(TopStoryVideoPlayTextureView topStoryVideoPlayTextureView) {
        AppMethodBeat.m2504i(1791);
        super.stop();
        AppMethodBeat.m2505o(1791);
    }

    public TopStoryVideoPlayTextureView(Context context) {
        super(context);
        AppMethodBeat.m2504i(1779);
        AppMethodBeat.m2505o(1779);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(1780);
        AppMethodBeat.m2505o(1780);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(1781);
        AppMethodBeat.m2505o(1781);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.m2504i(1782);
        super.setVideoPath(str);
        AppMethodBeat.m2505o(1782);
    }

    public final void bnS() {
        AppMethodBeat.m2504i(1783);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        synchronized (this.lock) {
            try {
                if (this.llA != null) {
                    this.llA.orY = null;
                    this.llA.orX.stop();
                    this.llA.release();
                    this.llA = null;
                }
                if (C5046bo.isNullOrNil(this.path)) {
                    C4990ab.m7421w("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video but path is null.", Integer.valueOf(hashCode()));
                } else {
                    this.f17239VN = false;
                    this.llA = new C34602i(Looper.getMainLooper());
                    this.llA.setPath(this.path);
                    this.llA.setIOnlineCache(this.orK);
                    this.llA.setNeedResetExtractor(this.llI);
                    this.llA.setIsOnlineVideoType(this.llJ);
                    this.llA.orY = this.llO;
                    this.llA.setSurface(this.mSurface);
                    this.llA.mo55172iU(this.llK);
                    if (this.mSurface != null) {
                        this.llA.prepare();
                    } else if (this.llD) {
                        this.llA.prepare();
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoPlayTextureView", e, "prepare async error %s", e.getMessage());
                if (this.llE != null) {
                    this.llE.onError(-1, -1);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(1783);
            }
        }
    }

    public final void stop() {
        AppMethodBeat.m2504i(1784);
        C7305d.post(new C399741(), "player-stop");
        AppMethodBeat.m2505o(1784);
    }

    public final boolean start() {
        boolean start;
        AppMethodBeat.m2504i(1785);
        synchronized (this.lock) {
            try {
                start = super.start();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(1785);
            }
        }
        return start;
    }

    public final void pause() {
        AppMethodBeat.m2504i(1786);
        synchronized (this.lock) {
            try {
                super.pause();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(1786);
            }
        }
    }

    /* renamed from: B */
    public final void mo9052B(double d) {
        AppMethodBeat.m2504i(1787);
        synchronized (this.lock) {
            try {
                super.mo9052B(d);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(1787);
            }
        }
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(1788);
        synchronized (this.lock) {
            try {
                super.setMute(z);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(1788);
            }
        }
    }

    /* renamed from: b */
    public final void mo63189b(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(1789);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", Integer.valueOf(hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.llL));
        try {
            dAh();
            this.mSurface = new Surface(surfaceTexture);
            if (this.llA == null || !this.f17239VN) {
                bnS();
            } else {
                this.llA.mo55170f(this.mSurface);
                if (C1443d.m3068iW(23)) {
                    if (this.llL) {
                        this.llA.start();
                    } else {
                        this.llM = true;
                        this.llC = 0;
                        this.llA.setMute(true);
                        this.llA.start();
                    }
                } else if (this.llL) {
                    mo27356d((double) this.llA.bPb(), true);
                } else {
                    mo27356d((double) this.llA.bPb(), false);
                }
                this.llL = false;
            }
            dlB();
            if (this.llH != null) {
                this.llH.akY();
            }
            AppMethodBeat.m2505o(1789);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoPlayTextureView", e, "onSurfaceTextureAvailable failed", new Object[0]);
            AppMethodBeat.m2505o(1789);
        }
    }

    /* renamed from: i */
    public final void mo9053i(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(1790);
        if (C1443d.m3068iW(23) && this.llM && this.llC > 0) {
            if (this.llA != null) {
                this.llA.pause();
                this.llA.setMute(this.eif);
            }
            this.llM = false;
        }
        if (this.llC > 0 && this.vvr != null) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d notify surface update", Integer.valueOf(hashCode()));
            this.vvr.bQL();
            this.vvr = null;
        }
        this.llC = System.currentTimeMillis();
        AppMethodBeat.m2505o(1790);
    }
}
