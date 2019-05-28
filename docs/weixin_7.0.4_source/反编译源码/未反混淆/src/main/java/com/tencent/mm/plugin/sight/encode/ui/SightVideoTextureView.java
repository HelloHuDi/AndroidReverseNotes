package com.tencent.mm.plugin.sight.encode.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;

@TargetApi(14)
public class SightVideoTextureView extends SightCameraView {
    private MediaPlayer ieC;
    private String ien;
    private boolean mMute;
    private TextureView qBN;
    private SurfaceTexture qBO;
    private Surface qBP;
    private boolean qBQ;

    public SightVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(25124);
        this.qBN = null;
        this.qBO = null;
        this.qBP = null;
        this.qBN = (TextureView) findViewById(R.id.ed9);
        this.qBN.setSurfaceTextureListener(new SurfaceTextureListener() {
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                AppMethodBeat.i(25115);
                ab.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                SightVideoTextureView.this.qBz = b.CREATE;
                SightVideoTextureView.this.qBO = surfaceTexture;
                ((MMTextureView) SightVideoTextureView.this.qBN).dAh();
                ab.i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", surfaceTexture, Boolean.valueOf(SightVideoTextureView.this.qBQ));
                if (SightVideoTextureView.this.qBQ) {
                    SightVideoTextureView.this.bg(SightVideoTextureView.this.ien, SightVideoTextureView.this.mMute);
                }
                AppMethodBeat.o(25115);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                AppMethodBeat.i(25116);
                ab.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                SightVideoTextureView.this.qBz = b.CHANGED;
                ab.i("MicroMsg.SightVideoTextureView", "changed texture %s", surfaceTexture);
                AppMethodBeat.o(25116);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(25117);
                ab.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
                SightVideoTextureView.this.qBz = b.DESTORY;
                SightVideoTextureView.this.qBO = null;
                SightVideoTextureView.this.qBB = false;
                ab.i("MicroMsg.SightVideoTextureView", "destroyed texture %s", surfaceTexture);
                AppMethodBeat.o(25117);
                return true;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        AppMethodBeat.o(25124);
    }

    public SightVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* Access modifiers changed, original: protected */
    public void setIsMute(boolean z) {
        AppMethodBeat.i(25125);
        if (this.ieC == null) {
            AppMethodBeat.o(25125);
            return;
        }
        try {
            if (!this.ieC.isPlaying()) {
                AppMethodBeat.o(25125);
            } else if (z) {
                try {
                    this.ieC.setVolume(0.0f, 0.0f);
                    AppMethodBeat.o(25125);
                } catch (Exception e) {
                    ab.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", e.getMessage());
                    AppMethodBeat.o(25125);
                }
            } else {
                clU();
                try {
                    this.ieC.setVolume(1.0f, 1.0f);
                    AppMethodBeat.o(25125);
                } catch (Exception e2) {
                    ab.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", e2.getMessage());
                    AppMethodBeat.o(25125);
                }
            }
        } catch (Exception e22) {
            ab.w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", Boolean.valueOf(z), e22.getMessage());
            AppMethodBeat.o(25125);
        }
    }

    public final void bg(final String str, final boolean z) {
        AppMethodBeat.i(25126);
        ab.i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", str, Boolean.valueOf(z), Boolean.valueOf(this.qBQ));
        this.ien = str;
        this.mMute = z;
        if (this.qBO == null) {
            ab.w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
            this.qBQ = true;
            AppMethodBeat.o(25126);
            return;
        }
        this.qBQ = false;
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(25120);
                if (SightVideoTextureView.this.ieC != null) {
                    try {
                        SightVideoTextureView.this.ieC.stop();
                        SightVideoTextureView.this.ieC.release();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
                        ab.w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
                    }
                }
                try {
                    SightVideoTextureView.this.ieC = new k();
                    SightVideoTextureView.this.ieC.setOnCompletionListener(new OnCompletionListener() {
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            AppMethodBeat.i(25118);
                            ab.i("MicroMsg.SightVideoTextureView", "complete playing %s ", str);
                            SightVideoTextureView.this.clV();
                            AppMethodBeat.o(25118);
                        }
                    });
                    SightVideoTextureView.this.ieC.setOnErrorListener(new OnErrorListener() {
                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            AppMethodBeat.i(25119);
                            ab.i("MicroMsg.SightVideoTextureView", "play %s error", str);
                            AppMethodBeat.o(25119);
                            return false;
                        }
                    });
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
                    AppMethodBeat.o(25120);
                } catch (Exception e2) {
                    ab.e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", str, e2.getMessage(), bo.l(e2));
                    AppMethodBeat.o(25120);
                }
            }

            public final String toString() {
                AppMethodBeat.i(25121);
                String str = super.toString() + "|playVideo";
                AppMethodBeat.o(25121);
                return str;
            }
        });
        AppMethodBeat.o(25126);
    }

    public final boolean isPlaying() {
        boolean z = false;
        AppMethodBeat.i(25127);
        try {
            if (this.ieC == null) {
                AppMethodBeat.o(25127);
            } else {
                z = this.ieC.isPlaying();
                AppMethodBeat.o(25127);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
            AppMethodBeat.o(25127);
        }
        return z;
    }

    public final void clS() {
        AppMethodBeat.i(25128);
        ab.i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", Boolean.valueOf(this.qBQ));
        if (this.ieC != null || this.qBQ) {
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(25122);
                    try {
                        SightVideoTextureView.this.clV();
                        SightVideoTextureView.this.ieC.stop();
                        SightVideoTextureView.this.ieC.release();
                        if (SightVideoTextureView.this.qBP != null && SightVideoTextureView.this.qBP.isValid()) {
                            SightVideoTextureView.this.qBP.release();
                            SightVideoTextureView.this.qBP = null;
                        }
                    } catch (Exception e) {
                        ab.w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", e.getMessage(), bo.l(e));
                    }
                    SightVideoTextureView.this.ieC = null;
                    AppMethodBeat.o(25122);
                }

                public final String toString() {
                    AppMethodBeat.i(25123);
                    String str = super.toString() + "|stopPlayVideo";
                    AppMethodBeat.o(25123);
                    return str;
                }
            });
            AppMethodBeat.o(25128);
            return;
        }
        ab.w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
        AppMethodBeat.o(25128);
    }

    /* Access modifiers changed, original: protected */
    public int getSurfaceWidth() {
        AppMethodBeat.i(25129);
        if (this.qBN != null) {
            int width = this.qBN.getWidth();
            AppMethodBeat.o(25129);
            return width;
        }
        AppMethodBeat.o(25129);
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public int getSurfaceHeight() {
        AppMethodBeat.i(25130);
        if (this.qBN != null) {
            int height = this.qBN.getHeight();
            AppMethodBeat.o(25130);
            return height;
        }
        AppMethodBeat.o(25130);
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public Surface getPreviewSurface() {
        AppMethodBeat.i(25131);
        if (this.qBO != null) {
            Surface surface = new Surface(this.qBO);
            AppMethodBeat.o(25131);
            return surface;
        }
        AppMethodBeat.o(25131);
        return null;
    }

    public void setFixPreviewRate(float f) {
        AppMethodBeat.i(25132);
        LayoutParams layoutParams = this.qBN.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        ab.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", Float.valueOf(f), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        ab.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        this.qBN.setLayoutParams(layoutParams);
        super.setPreviewRate(f);
        AppMethodBeat.o(25132);
    }
}
