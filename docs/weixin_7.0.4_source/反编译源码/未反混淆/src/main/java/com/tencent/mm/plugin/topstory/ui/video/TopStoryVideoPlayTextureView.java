package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class TopStoryVideoPlayTextureView extends VideoPlayerTextureView {
    private Object lock = new Object();

    static /* synthetic */ void b(TopStoryVideoPlayTextureView topStoryVideoPlayTextureView) {
        AppMethodBeat.i(1791);
        super.stop();
        AppMethodBeat.o(1791);
    }

    public TopStoryVideoPlayTextureView(Context context) {
        super(context);
        AppMethodBeat.i(1779);
        AppMethodBeat.o(1779);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(1780);
        AppMethodBeat.o(1780);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(1781);
        AppMethodBeat.o(1781);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.i(1782);
        super.setVideoPath(str);
        AppMethodBeat.o(1782);
    }

    public final void bnS() {
        AppMethodBeat.i(1783);
        ab.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        synchronized (this.lock) {
            try {
                if (this.llA != null) {
                    this.llA.orY = null;
                    this.llA.orX.stop();
                    this.llA.release();
                    this.llA = null;
                }
                if (bo.isNullOrNil(this.path)) {
                    ab.w("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video but path is null.", Integer.valueOf(hashCode()));
                } else {
                    this.VN = false;
                    this.llA = new i(Looper.getMainLooper());
                    this.llA.setPath(this.path);
                    this.llA.setIOnlineCache(this.orK);
                    this.llA.setNeedResetExtractor(this.llI);
                    this.llA.setIsOnlineVideoType(this.llJ);
                    this.llA.orY = this.llO;
                    this.llA.setSurface(this.mSurface);
                    this.llA.iU(this.llK);
                    if (this.mSurface != null) {
                        this.llA.prepare();
                    } else if (this.llD) {
                        this.llA.prepare();
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoPlayTextureView", e, "prepare async error %s", e.getMessage());
                if (this.llE != null) {
                    this.llE.onError(-1, -1);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(1783);
            }
        }
    }

    public final void stop() {
        AppMethodBeat.i(1784);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1778);
                synchronized (TopStoryVideoPlayTextureView.this.lock) {
                    try {
                        TopStoryVideoPlayTextureView.b(TopStoryVideoPlayTextureView.this);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(1778);
                    }
                }
            }
        }, "player-stop");
        AppMethodBeat.o(1784);
    }

    public final boolean start() {
        boolean start;
        AppMethodBeat.i(1785);
        synchronized (this.lock) {
            try {
                start = super.start();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(1785);
            }
        }
        return start;
    }

    public final void pause() {
        AppMethodBeat.i(1786);
        synchronized (this.lock) {
            try {
                super.pause();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(1786);
            }
        }
    }

    public final void B(double d) {
        AppMethodBeat.i(1787);
        synchronized (this.lock) {
            try {
                super.B(d);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(1787);
            }
        }
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(1788);
        synchronized (this.lock) {
            try {
                super.setMute(z);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(1788);
            }
        }
    }

    public final void b(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(1789);
        ab.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", Integer.valueOf(hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.llL));
        try {
            dAh();
            this.mSurface = new Surface(surfaceTexture);
            if (this.llA == null || !this.VN) {
                bnS();
            } else {
                this.llA.f(this.mSurface);
                if (com.tencent.mm.compatible.util.d.iW(23)) {
                    if (this.llL) {
                        this.llA.start();
                    } else {
                        this.llM = true;
                        this.llC = 0;
                        this.llA.setMute(true);
                        this.llA.start();
                    }
                } else if (this.llL) {
                    d((double) this.llA.bPb(), true);
                } else {
                    d((double) this.llA.bPb(), false);
                }
                this.llL = false;
            }
            dlB();
            if (this.llH != null) {
                this.llH.akY();
            }
            AppMethodBeat.o(1789);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoPlayTextureView", e, "onSurfaceTextureAvailable failed", new Object[0]);
            AppMethodBeat.o(1789);
        }
    }

    public final void i(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(1790);
        if (com.tencent.mm.compatible.util.d.iW(23) && this.llM && this.llC > 0) {
            if (this.llA != null) {
                this.llA.pause();
                this.llA.setMute(this.eif);
            }
            this.llM = false;
        }
        if (this.llC > 0 && this.vvr != null) {
            ab.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d notify surface update", Integer.valueOf(hashCode()));
            this.vvr.bQL();
            this.vvr = null;
        }
        this.llC = System.currentTimeMillis();
        AppMethodBeat.o(1790);
    }
}
