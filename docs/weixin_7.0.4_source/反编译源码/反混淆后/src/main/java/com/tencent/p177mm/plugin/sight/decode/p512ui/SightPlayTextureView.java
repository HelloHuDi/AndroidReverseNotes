package com.tencent.p177mm.plugin.sight.decode.p512ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13321g;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.lang.ref.WeakReference;

@TargetApi(14)
/* renamed from: com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView */
public class SightPlayTextureView extends MMTextureView implements C34915a {
    private Surface mSurface;
    private C13303b qyA;
    private int qyC;
    private boolean qyH;
    private int qyM;
    private int videoHeight;
    private int videoWidth;

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView$b */
    static final class C3853b extends C13303b {
        private WeakReference<SightPlayTextureView> qyP;

        public final int ckZ() {
            return C25738R.anim.f8397d8;
        }

        public C3853b(SightPlayTextureView sightPlayTextureView) {
            super(1, sightPlayTextureView);
            AppMethodBeat.m2504i(24978);
            this.qyP = new WeakReference(sightPlayTextureView);
            AppMethodBeat.m2505o(24978);
        }

        /* renamed from: dH */
        public final void mo8534dH(int i, int i2) {
            AppMethodBeat.m2504i(24979);
            if (this.qyP.get() == null) {
                C4990ab.m7412e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
                clear();
                AppMethodBeat.m2505o(24979);
                return;
            }
            ((SightPlayTextureView) this.qyP.get()).videoWidth = i;
            ((SightPlayTextureView) this.qyP.get()).videoHeight = i2;
            C4990ab.m7411d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(((SightPlayTextureView) this.qyP.get()).qyH));
            final LayoutParams layoutParams = ((SightPlayTextureView) this.qyP.get()).getLayoutParams();
            if (((SightPlayTextureView) this.qyP.get()).qyH && i > 0 && i2 > 0) {
                if (i >= i2) {
                    ((SightPlayTextureView) this.qyP.get()).qyC = C1338a.fromDPToPix(((SightPlayTextureView) this.qyP.get()).getContext(), 150);
                } else {
                    ((SightPlayTextureView) this.qyP.get()).qyC = C1338a.fromDPToPix(((SightPlayTextureView) this.qyP.get()).getContext(), 85);
                }
            }
            if (layoutParams.height != (((SightPlayTextureView) this.qyP.get()).qyC * i2) / i) {
                layoutParams.width = ((SightPlayTextureView) this.qyP.get()).qyC;
                layoutParams.height = (((SightPlayTextureView) this.qyP.get()).qyC * i2) / i;
                if (((SightPlayTextureView) this.qyP.get()).qyH && layoutParams.height < C1338a.fromDPToPix(((SightPlayTextureView) this.qyP.get()).getContext(), 50)) {
                    layoutParams.height = C1338a.fromDPToPix(((SightPlayTextureView) this.qyP.get()).getContext(), 50);
                }
                C4990ab.m7417i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                if (C5004al.isMainThread()) {
                    ((SightPlayTextureView) this.qyP.get()).setLayoutParams(layoutParams);
                } else {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(24977);
                            ((SightPlayTextureView) C3853b.this.qyP.get()).setLayoutParams(layoutParams);
                            AppMethodBeat.m2505o(24977);
                        }
                    });
                }
            }
            this.qxs = C13303b.m21393b(((SightPlayTextureView) this.qyP.get()).getContext(), ((SightPlayTextureView) this.qyP.get()).qyM, ((SightPlayTextureView) this.qyP.get()).qyC, i, i2);
            AppMethodBeat.m2505o(24979);
        }

        /* renamed from: U */
        public final void mo8532U(Bitmap bitmap) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView$1 */
    class C290161 implements SurfaceTextureListener {
        C290161() {
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(24971);
            C4990ab.m7416i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + i + " height " + i2);
            AppMethodBeat.m2505o(24971);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(24972);
            C4990ab.m7416i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
            SightPlayTextureView.this.qyA.mo25379g(null);
            SightPlayTextureView.this.qyA.clear();
            C34917a c34917a = new C34917a();
            c34917a.qyO = SightPlayTextureView.this.mSurface;
            C37961o.m64222i(c34917a, 0);
            SightPlayTextureView.this.mSurface = null;
            AppMethodBeat.m2505o(24972);
            return false;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(24973);
            C4990ab.m7417i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", Integer.valueOf(i), Integer.valueOf(i2));
            C34917a c34917a = new C34917a();
            c34917a.qyO = SightPlayTextureView.this.mSurface;
            C37961o.m64222i(c34917a, 0);
            SightPlayTextureView.this.mSurface = new Surface(surfaceTexture);
            SightPlayTextureView.this.qyA.mo25379g(SightPlayTextureView.this.mSurface);
            SightPlayTextureView.this.dAh();
            AppMethodBeat.m2505o(24973);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView$a */
    static final class C34917a implements Runnable {
        Surface qyO;

        private C34917a() {
            this.qyO = null;
        }

        /* synthetic */ C34917a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(24976);
            if (this.qyO == null) {
                AppMethodBeat.m2505o(24976);
                return;
            }
            this.qyO.release();
            AppMethodBeat.m2505o(24976);
        }
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(24980);
        this.qyH = false;
        setOpaque(false);
        this.qyA = new C3853b(this);
        setSurfaceTextureListener(new C290161());
        AppMethodBeat.m2505o(24980);
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String getVideoPath() {
        return this.qyA.ien;
    }

    public final void clear() {
        AppMethodBeat.m2504i(24981);
        this.qyA.clear();
        AppMethodBeat.m2505o(24981);
    }

    /* renamed from: bf */
    public final void mo8509bf(String str, boolean z) {
        AppMethodBeat.m2504i(24982);
        this.qyA.mo25372bf(str, z);
        AppMethodBeat.m2505o(24982);
    }

    public final boolean ckY() {
        AppMethodBeat.m2504i(24983);
        boolean clb = this.qyA.clb();
        AppMethodBeat.m2505o(24983);
        return clb;
    }

    public void setPosition(int i) {
        this.qyA.position = i;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(24984);
        super.onDetachedFromWindow();
        C4990ab.m7417i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.qyA.clear();
        C4879a.xxA.mo10053d(this.qyA.cld());
        AppMethodBeat.m2505o(24984);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(24985);
        C4990ab.m7411d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        C4879a.xxA.mo10052c(this.qyA.cld());
        AppMethodBeat.m2505o(24985);
    }

    public void setDrawableWidth(int i) {
        AppMethodBeat.m2504i(24986);
        this.qyC = i;
        m61150A(0.75d);
        AppMethodBeat.m2505o(24986);
    }

    /* renamed from: A */
    private void m61150A(double d) {
        AppMethodBeat.m2504i(24987);
        final LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((double) this.qyC) * d))) {
            layoutParams.width = this.qyC;
            layoutParams.height = (int) (((double) this.qyC) * d);
            if (this.qyH && layoutParams.height < C1338a.fromDPToPix(getContext(), 50)) {
                layoutParams.height = C1338a.fromDPToPix(getContext(), 50);
            }
            C4990ab.m7417i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
            if (C5004al.isMainThread()) {
                setLayoutParams(layoutParams);
                AppMethodBeat.m2505o(24987);
                return;
            }
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24974);
                    SightPlayTextureView.this.setLayoutParams(layoutParams);
                    AppMethodBeat.m2505o(24974);
                }
            });
        }
        AppMethodBeat.m2505o(24987);
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.m2504i(24988);
        String str = "MicroMsg.SightPlayTextureView";
        String str2 = "thumb is null? %B, surface is null? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bitmap == null);
        objArr[1] = Boolean.valueOf(this.mSurface == null);
        C4990ab.m7411d(str, str2, objArr);
        if (bitmap != null) {
            C4990ab.m7411d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            if (this.qyH) {
                if (bitmap.getWidth() >= bitmap.getHeight()) {
                    this.qyC = C1338a.fromDPToPix(getContext(), 150);
                } else {
                    this.qyC = C1338a.fromDPToPix(getContext(), 85);
                }
            }
            Bitmap b = C13303b.m21393b(getContext(), this.qyM, this.qyC, bitmap.getWidth(), bitmap.getHeight());
            m61150A(((double) bitmap.getHeight()) / ((double) bitmap.getWidth()));
            this.qyA.qxs = b;
            this.qyA.mo25371T(bitmap);
            AppMethodBeat.m2505o(24988);
            return;
        }
        this.qyA.mo25371T(null);
        AppMethodBeat.m2505o(24988);
    }

    public final void ckX() {
        AppMethodBeat.m2504i(24989);
        SightVideoJNI.drawSurfaceThumb(this.mSurface, C13303b.m21393b(getContext(), C25738R.drawable.ak_, this.qyC, 320, 240), C13303b.m21393b(getContext(), this.qyM, this.qyC, 320, 240));
        AppMethodBeat.m2505o(24989);
    }

    public void setMaskID(int i) {
        this.qyM = i;
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.m2504i(24990);
        setTag(obj);
        AppMethodBeat.m2505o(24990);
    }

    public Object getTagObject() {
        AppMethodBeat.m2504i(24991);
        Object tag = getTag();
        AppMethodBeat.m2505o(24991);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.m2504i(24992);
        Context context = getContext();
        AppMethodBeat.m2505o(24992);
        return context;
    }

    /* renamed from: fi */
    public final void mo8513fi(int i, int i2) {
        AppMethodBeat.m2504i(24993);
        final LayoutParams layoutParams = getLayoutParams();
        this.qyC = i;
        layoutParams.width = this.qyC;
        layoutParams.height = (this.qyC * i2) / i;
        C4990ab.m7417i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        if (C5004al.isMainThread()) {
            setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(24993);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(24975);
                SightPlayTextureView.this.setLayoutParams(layoutParams);
                AppMethodBeat.m2505o(24975);
            }
        });
        AppMethodBeat.m2505o(24993);
    }

    public void setCanPlay(boolean z) {
        this.qyA.qxI = z;
    }

    public void setOnCompletionListener(C13304e c13304e) {
        this.qyA.qxT = c13304e;
    }

    public void setOnSightCompletionAction(C13321g c13321g) {
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.m2504i(24994);
        this.qyA.setThumbBgView(view);
        AppMethodBeat.m2505o(24994);
    }

    public void setIsWhatsNew(boolean z) {
        this.qyA.qxL = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.m2504i(24995);
        this.qyA.setSightInfoView(textView);
        AppMethodBeat.m2505o(24995);
    }

    public void setForceRecordState(boolean z) {
    }

    public void setOnDecodeDurationListener(C13325f c13325f) {
        this.qyA.qxU = c13325f;
    }
}
