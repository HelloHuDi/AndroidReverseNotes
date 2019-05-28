package com.tencent.p177mm.plugin.sight.encode.p513ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.sight.encode.p513ui.SightCameraView.C43532b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@TargetApi(14)
/* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView */
public class SightVideoTextureView extends SightCameraView {
    private MediaPlayer ieC;
    private String ien;
    private boolean mMute;
    private TextureView qBN;
    private SurfaceTexture qBO;
    private Surface qBP;
    private boolean qBQ;

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView$3 */
    class C38623 implements Runnable {
        C38623() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25122);
            try {
                SightVideoTextureView.this.clV();
                SightVideoTextureView.this.ieC.stop();
                SightVideoTextureView.this.ieC.release();
                if (SightVideoTextureView.this.qBP != null && SightVideoTextureView.this.qBP.isValid()) {
                    SightVideoTextureView.this.qBP.release();
                    SightVideoTextureView.this.qBP = null;
                }
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", e.getMessage(), C5046bo.m7574l(e));
            }
            SightVideoTextureView.this.ieC = null;
            AppMethodBeat.m2505o(25122);
        }

        public final String toString() {
            AppMethodBeat.m2504i(25123);
            String str = super.toString() + "|stopPlayVideo";
            AppMethodBeat.m2505o(25123);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView$1 */
    class C218541 implements SurfaceTextureListener {
        C218541() {
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(25115);
            C4990ab.m7417i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
            SightVideoTextureView.this.qBz = C43532b.CREATE;
            SightVideoTextureView.this.qBO = surfaceTexture;
            ((MMTextureView) SightVideoTextureView.this.qBN).dAh();
            C4990ab.m7417i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", surfaceTexture, Boolean.valueOf(SightVideoTextureView.this.qBQ));
            if (SightVideoTextureView.this.qBQ) {
                SightVideoTextureView.this.mo74207bg(SightVideoTextureView.this.ien, SightVideoTextureView.this.mMute);
            }
            AppMethodBeat.m2505o(25115);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(25116);
            C4990ab.m7417i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
            SightVideoTextureView.this.qBz = C43532b.CHANGED;
            C4990ab.m7417i("MicroMsg.SightVideoTextureView", "changed texture %s", surfaceTexture);
            AppMethodBeat.m2505o(25116);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(25117);
            C4990ab.m7416i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
            SightVideoTextureView.this.qBz = C43532b.DESTORY;
            SightVideoTextureView.this.qBO = null;
            SightVideoTextureView.this.qBB = false;
            C4990ab.m7417i("MicroMsg.SightVideoTextureView", "destroyed texture %s", surfaceTexture);
            AppMethodBeat.m2505o(25117);
            return true;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public SightVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(25124);
        this.qBN = null;
        this.qBO = null;
        this.qBP = null;
        this.qBN = (TextureView) findViewById(2131827545);
        this.qBN.setSurfaceTextureListener(new C218541());
        AppMethodBeat.m2505o(25124);
    }

    public SightVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* Access modifiers changed, original: protected */
    public void setIsMute(boolean z) {
        AppMethodBeat.m2504i(25125);
        if (this.ieC == null) {
            AppMethodBeat.m2505o(25125);
            return;
        }
        try {
            if (!this.ieC.isPlaying()) {
                AppMethodBeat.m2505o(25125);
            } else if (z) {
                try {
                    this.ieC.setVolume(0.0f, 0.0f);
                    AppMethodBeat.m2505o(25125);
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", e.getMessage());
                    AppMethodBeat.m2505o(25125);
                }
            } else {
                clU();
                try {
                    this.ieC.setVolume(1.0f, 1.0f);
                    AppMethodBeat.m2505o(25125);
                } catch (Exception e2) {
                    C4990ab.m7421w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", e2.getMessage());
                    AppMethodBeat.m2505o(25125);
                }
            }
        } catch (Exception e22) {
            C4990ab.m7421w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", Boolean.valueOf(z), e22.getMessage());
            AppMethodBeat.m2505o(25125);
        }
    }

    /* renamed from: bg */
    public final void mo74207bg(final String str, final boolean z) {
        AppMethodBeat.m2504i(25126);
        C4990ab.m7417i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", str, Boolean.valueOf(z), Boolean.valueOf(this.qBQ));
        this.ien = str;
        this.mMute = z;
        if (this.qBO == null) {
            C4990ab.m7420w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
            this.qBQ = true;
            AppMethodBeat.m2505o(25126);
            return;
        }
        this.qBQ = false;
        C9638aw.m17180RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView$2$1 */
            class C38601 implements OnCompletionListener {
                C38601() {
                }

                public final void onCompletion(MediaPlayer mediaPlayer) {
                    AppMethodBeat.m2504i(25118);
                    C4990ab.m7417i("MicroMsg.SightVideoTextureView", "complete playing %s ", str);
                    SightVideoTextureView.this.clV();
                    AppMethodBeat.m2505o(25118);
                }
            }

            /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView$2$2 */
            class C38612 implements OnErrorListener {
                C38612() {
                }

                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    AppMethodBeat.m2504i(25119);
                    C4990ab.m7417i("MicroMsg.SightVideoTextureView", "play %s error", str);
                    AppMethodBeat.m2505o(25119);
                    return false;
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(25120);
                if (SightVideoTextureView.this.ieC != null) {
                    try {
                        SightVideoTextureView.this.ieC.stop();
                        SightVideoTextureView.this.ieC.release();
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
                        C4990ab.m7420w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
                    }
                }
                try {
                    SightVideoTextureView.this.ieC = new C45289k();
                    SightVideoTextureView.this.ieC.setOnCompletionListener(new C38601());
                    SightVideoTextureView.this.ieC.setOnErrorListener(new C38612());
                    SightVideoTextureView.this.ieC.setDataSource(str);
                    SightVideoTextureView.this.qBP = SightVideoTextureView.this.getPreviewSurface();
                    SightVideoTextureView.this.ieC.setSurface(SightVideoTextureView.this.qBP);
                    SightVideoTextureView.this.ieC.setAudioStreamType(3);
                    if (z) {
                        SightVideoTextureView.this.ieC.setVolume(0.0f, 0.0f);
                    } else {
                        SightVideoTextureView.this.clU();
                    }
                    SightVideoTextureView.this.ieC.setScreenOnWhilePlaying(true);
                    SightVideoTextureView.this.ieC.setLooping(true);
                    SightVideoTextureView.this.ieC.prepare();
                    SightVideoTextureView.this.ieC.start();
                    AppMethodBeat.m2505o(25120);
                } catch (Exception e2) {
                    C4990ab.m7413e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", str, e2.getMessage(), C5046bo.m7574l(e2));
                    AppMethodBeat.m2505o(25120);
                }
            }

            public final String toString() {
                AppMethodBeat.m2504i(25121);
                String str = super.toString() + "|playVideo";
                AppMethodBeat.m2505o(25121);
                return str;
            }
        });
        AppMethodBeat.m2505o(25126);
    }

    public final boolean isPlaying() {
        boolean z = false;
        AppMethodBeat.m2504i(25127);
        try {
            if (this.ieC == null) {
                AppMethodBeat.m2505o(25127);
            } else {
                z = this.ieC.isPlaying();
                AppMethodBeat.m2505o(25127);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
            AppMethodBeat.m2505o(25127);
        }
        return z;
    }

    public final void clS() {
        AppMethodBeat.m2504i(25128);
        C4990ab.m7417i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", Boolean.valueOf(this.qBQ));
        if (this.ieC != null || this.qBQ) {
            C9638aw.m17180RS().mo10302aa(new C38623());
            AppMethodBeat.m2505o(25128);
            return;
        }
        C4990ab.m7420w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
        AppMethodBeat.m2505o(25128);
    }

    /* Access modifiers changed, original: protected */
    public int getSurfaceWidth() {
        AppMethodBeat.m2504i(25129);
        if (this.qBN != null) {
            int width = this.qBN.getWidth();
            AppMethodBeat.m2505o(25129);
            return width;
        }
        AppMethodBeat.m2505o(25129);
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public int getSurfaceHeight() {
        AppMethodBeat.m2504i(25130);
        if (this.qBN != null) {
            int height = this.qBN.getHeight();
            AppMethodBeat.m2505o(25130);
            return height;
        }
        AppMethodBeat.m2505o(25130);
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public Surface getPreviewSurface() {
        AppMethodBeat.m2504i(25131);
        if (this.qBO != null) {
            Surface surface = new Surface(this.qBO);
            AppMethodBeat.m2505o(25131);
            return surface;
        }
        AppMethodBeat.m2505o(25131);
        return null;
    }

    public void setFixPreviewRate(float f) {
        AppMethodBeat.m2504i(25132);
        LayoutParams layoutParams = this.qBN.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        C4990ab.m7417i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", Float.valueOf(f), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        C4990ab.m7417i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        this.qBN.setLayoutParams(layoutParams);
        super.setPreviewRate(f);
        AppMethodBeat.m2505o(25132);
    }
}
