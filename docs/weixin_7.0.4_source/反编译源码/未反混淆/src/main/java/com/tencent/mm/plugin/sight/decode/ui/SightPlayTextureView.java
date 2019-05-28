package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class SightPlayTextureView extends MMTextureView implements com.tencent.mm.plugin.sight.decode.a.a {
    private Surface mSurface;
    private com.tencent.mm.plugin.sight.decode.a.b qyA;
    private int qyC;
    private boolean qyH;
    private int qyM;
    private int videoHeight;
    private int videoWidth;

    static final class b extends com.tencent.mm.plugin.sight.decode.a.b {
        private WeakReference<SightPlayTextureView> qyP;

        public final int ckZ() {
            return R.anim.d8;
        }

        public b(SightPlayTextureView sightPlayTextureView) {
            super(1, sightPlayTextureView);
            AppMethodBeat.i(24978);
            this.qyP = new WeakReference(sightPlayTextureView);
            AppMethodBeat.o(24978);
        }

        public final void dH(int i, int i2) {
            AppMethodBeat.i(24979);
            if (this.qyP.get() == null) {
                ab.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
                clear();
                AppMethodBeat.o(24979);
                return;
            }
            ((SightPlayTextureView) this.qyP.get()).videoWidth = i;
            ((SightPlayTextureView) this.qyP.get()).videoHeight = i2;
            ab.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(((SightPlayTextureView) this.qyP.get()).qyH));
            final LayoutParams layoutParams = ((SightPlayTextureView) this.qyP.get()).getLayoutParams();
            if (((SightPlayTextureView) this.qyP.get()).qyH && i > 0 && i2 > 0) {
                if (i >= i2) {
                    ((SightPlayTextureView) this.qyP.get()).qyC = com.tencent.mm.bz.a.fromDPToPix(((SightPlayTextureView) this.qyP.get()).getContext(), 150);
                } else {
                    ((SightPlayTextureView) this.qyP.get()).qyC = com.tencent.mm.bz.a.fromDPToPix(((SightPlayTextureView) this.qyP.get()).getContext(), 85);
                }
            }
            if (layoutParams.height != (((SightPlayTextureView) this.qyP.get()).qyC * i2) / i) {
                layoutParams.width = ((SightPlayTextureView) this.qyP.get()).qyC;
                layoutParams.height = (((SightPlayTextureView) this.qyP.get()).qyC * i2) / i;
                if (((SightPlayTextureView) this.qyP.get()).qyH && layoutParams.height < com.tencent.mm.bz.a.fromDPToPix(((SightPlayTextureView) this.qyP.get()).getContext(), 50)) {
                    layoutParams.height = com.tencent.mm.bz.a.fromDPToPix(((SightPlayTextureView) this.qyP.get()).getContext(), 50);
                }
                ab.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                if (al.isMainThread()) {
                    ((SightPlayTextureView) this.qyP.get()).setLayoutParams(layoutParams);
                } else {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(24977);
                            ((SightPlayTextureView) b.this.qyP.get()).setLayoutParams(layoutParams);
                            AppMethodBeat.o(24977);
                        }
                    });
                }
            }
            this.qxs = com.tencent.mm.plugin.sight.decode.a.b.b(((SightPlayTextureView) this.qyP.get()).getContext(), ((SightPlayTextureView) this.qyP.get()).qyM, ((SightPlayTextureView) this.qyP.get()).qyC, i, i2);
            AppMethodBeat.o(24979);
        }

        public final void U(Bitmap bitmap) {
        }
    }

    static final class a implements Runnable {
        Surface qyO;

        private a() {
            this.qyO = null;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(24976);
            if (this.qyO == null) {
                AppMethodBeat.o(24976);
                return;
            }
            this.qyO.release();
            AppMethodBeat.o(24976);
        }
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(24980);
        this.qyH = false;
        setOpaque(false);
        this.qyA = new b(this);
        setSurfaceTextureListener(new SurfaceTextureListener() {
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                AppMethodBeat.i(24971);
                ab.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + i + " height " + i2);
                AppMethodBeat.o(24971);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(24972);
                ab.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
                SightPlayTextureView.this.qyA.g(null);
                SightPlayTextureView.this.qyA.clear();
                a aVar = new a();
                aVar.qyO = SightPlayTextureView.this.mSurface;
                o.i(aVar, 0);
                SightPlayTextureView.this.mSurface = null;
                AppMethodBeat.o(24972);
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                AppMethodBeat.i(24973);
                ab.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", Integer.valueOf(i), Integer.valueOf(i2));
                a aVar = new a();
                aVar.qyO = SightPlayTextureView.this.mSurface;
                o.i(aVar, 0);
                SightPlayTextureView.this.mSurface = new Surface(surfaceTexture);
                SightPlayTextureView.this.qyA.g(SightPlayTextureView.this.mSurface);
                SightPlayTextureView.this.dAh();
                AppMethodBeat.o(24973);
            }
        });
        AppMethodBeat.o(24980);
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String getVideoPath() {
        return this.qyA.ien;
    }

    public final void clear() {
        AppMethodBeat.i(24981);
        this.qyA.clear();
        AppMethodBeat.o(24981);
    }

    public final void bf(String str, boolean z) {
        AppMethodBeat.i(24982);
        this.qyA.bf(str, z);
        AppMethodBeat.o(24982);
    }

    public final boolean ckY() {
        AppMethodBeat.i(24983);
        boolean clb = this.qyA.clb();
        AppMethodBeat.o(24983);
        return clb;
    }

    public void setPosition(int i) {
        this.qyA.position = i;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(24984);
        super.onDetachedFromWindow();
        ab.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.qyA.clear();
        com.tencent.mm.sdk.b.a.xxA.d(this.qyA.cld());
        AppMethodBeat.o(24984);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(24985);
        ab.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xxA.c(this.qyA.cld());
        AppMethodBeat.o(24985);
    }

    public void setDrawableWidth(int i) {
        AppMethodBeat.i(24986);
        this.qyC = i;
        A(0.75d);
        AppMethodBeat.o(24986);
    }

    private void A(double d) {
        AppMethodBeat.i(24987);
        final LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((double) this.qyC) * d))) {
            layoutParams.width = this.qyC;
            layoutParams.height = (int) (((double) this.qyC) * d);
            if (this.qyH && layoutParams.height < com.tencent.mm.bz.a.fromDPToPix(getContext(), 50)) {
                layoutParams.height = com.tencent.mm.bz.a.fromDPToPix(getContext(), 50);
            }
            ab.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
            if (al.isMainThread()) {
                setLayoutParams(layoutParams);
                AppMethodBeat.o(24987);
                return;
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24974);
                    SightPlayTextureView.this.setLayoutParams(layoutParams);
                    AppMethodBeat.o(24974);
                }
            });
        }
        AppMethodBeat.o(24987);
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.i(24988);
        String str = "MicroMsg.SightPlayTextureView";
        String str2 = "thumb is null? %B, surface is null? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bitmap == null);
        objArr[1] = Boolean.valueOf(this.mSurface == null);
        ab.d(str, str2, objArr);
        if (bitmap != null) {
            ab.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            if (this.qyH) {
                if (bitmap.getWidth() >= bitmap.getHeight()) {
                    this.qyC = com.tencent.mm.bz.a.fromDPToPix(getContext(), 150);
                } else {
                    this.qyC = com.tencent.mm.bz.a.fromDPToPix(getContext(), 85);
                }
            }
            Bitmap b = com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), this.qyM, this.qyC, bitmap.getWidth(), bitmap.getHeight());
            A(((double) bitmap.getHeight()) / ((double) bitmap.getWidth()));
            this.qyA.qxs = b;
            this.qyA.T(bitmap);
            AppMethodBeat.o(24988);
            return;
        }
        this.qyA.T(null);
        AppMethodBeat.o(24988);
    }

    public final void ckX() {
        AppMethodBeat.i(24989);
        SightVideoJNI.drawSurfaceThumb(this.mSurface, com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), R.drawable.ak_, this.qyC, 320, 240), com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), this.qyM, this.qyC, 320, 240));
        AppMethodBeat.o(24989);
    }

    public void setMaskID(int i) {
        this.qyM = i;
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.i(24990);
        setTag(obj);
        AppMethodBeat.o(24990);
    }

    public Object getTagObject() {
        AppMethodBeat.i(24991);
        Object tag = getTag();
        AppMethodBeat.o(24991);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.i(24992);
        Context context = getContext();
        AppMethodBeat.o(24992);
        return context;
    }

    public final void fi(int i, int i2) {
        AppMethodBeat.i(24993);
        final LayoutParams layoutParams = getLayoutParams();
        this.qyC = i;
        layoutParams.width = this.qyC;
        layoutParams.height = (this.qyC * i2) / i;
        ab.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        if (al.isMainThread()) {
            setLayoutParams(layoutParams);
            AppMethodBeat.o(24993);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(24975);
                SightPlayTextureView.this.setLayoutParams(layoutParams);
                AppMethodBeat.o(24975);
            }
        });
        AppMethodBeat.o(24993);
    }

    public void setCanPlay(boolean z) {
        this.qyA.qxI = z;
    }

    public void setOnCompletionListener(e eVar) {
        this.qyA.qxT = eVar;
    }

    public void setOnSightCompletionAction(g gVar) {
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.i(24994);
        this.qyA.setThumbBgView(view);
        AppMethodBeat.o(24994);
    }

    public void setIsWhatsNew(boolean z) {
        this.qyA.qxL = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.i(24995);
        this.qyA.setSightInfoView(textView);
        AppMethodBeat.o(24995);
    }

    public void setForceRecordState(boolean z) {
    }

    public void setOnDecodeDurationListener(f fVar) {
        this.qyA.qxU = fVar;
    }
}
