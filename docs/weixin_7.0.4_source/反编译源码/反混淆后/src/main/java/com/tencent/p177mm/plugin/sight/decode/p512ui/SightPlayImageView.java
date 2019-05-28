package com.tencent.p177mm.plugin.sight.decode.p512ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.memory.p1206ui.QPictureView;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13321g;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13323i;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView */
public class SightPlayImageView extends QPictureView implements C34915a {
    public C14981a llE;
    public C13303b qyA;
    private int qyC;
    private int qyD;
    private int qyE;
    private int qyF;
    public boolean qyG;
    private boolean qyH;
    public boolean qyI;

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView$a */
    static final class C3850a extends C13303b {
        private WeakReference<SightPlayImageView> qyB;

        public final int ckZ() {
            return C25738R.anim.f8397d8;
        }

        public C3850a(SightPlayImageView sightPlayImageView) {
            super(0, sightPlayImageView);
            AppMethodBeat.m2504i(70253);
            this.qyB = new WeakReference(sightPlayImageView);
            AppMethodBeat.m2505o(70253);
        }

        /* renamed from: dH */
        public final void mo8534dH(int i, int i2) {
            AppMethodBeat.m2504i(70254);
            final SightPlayImageView sightPlayImageView = (SightPlayImageView) this.qyB.get();
            if (sightPlayImageView == null) {
                C4990ab.m7412e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
                AppMethodBeat.m2505o(70254);
            } else if (sightPlayImageView.qyI) {
                AppMethodBeat.m2505o(70254);
            } else {
                sightPlayImageView.qyE = i;
                sightPlayImageView.qyF = i2;
                if (sightPlayImageView.llE != null) {
                    sightPlayImageView.llE.mo8555dH(i, i2);
                }
                if (sightPlayImageView.qyH) {
                    if (sightPlayImageView.qyE >= sightPlayImageView.qyF) {
                        sightPlayImageView.qyC = C1338a.fromDPToPix(sightPlayImageView.getContext(), 150);
                    } else {
                        sightPlayImageView.qyC = C1338a.fromDPToPix(sightPlayImageView.getContext(), 85);
                    }
                }
                if (sightPlayImageView.qyC > 0) {
                    final LayoutParams layoutParams = sightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == sightPlayImageView.qyC && layoutParams.height == (sightPlayImageView.qyC * i2) / i)) {
                        layoutParams.width = sightPlayImageView.qyC;
                        layoutParams.height = (sightPlayImageView.qyC * i2) / i;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(70252);
                                sightPlayImageView.setLayoutParams(layoutParams);
                                AppMethodBeat.m2505o(70252);
                            }
                        });
                        sightPlayImageView.postInvalidate();
                    }
                    C4990ab.m7417i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                C4990ab.m7417i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(sightPlayImageView.qyC), Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(70254);
            }
        }

        /* renamed from: U */
        public final void mo8532U(Bitmap bitmap) {
            AppMethodBeat.m2504i(70255);
            SightPlayImageView sightPlayImageView = (SightPlayImageView) this.qyB.get();
            if (sightPlayImageView == null) {
                C4990ab.m7412e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                AppMethodBeat.m2505o(70255);
                return;
            }
            sightPlayImageView.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(70255);
        }
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(70256);
        this.qyG = true;
        this.qyH = false;
        this.qyI = false;
        this.qyA = new C3850a(this);
        C4990ab.m7417i("MicroMsg.SightPlayImageView", "mController %s", C5046bo.dpG().toString());
        AppMethodBeat.m2505o(70256);
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SightPlayImageView(Context context) {
        this(context, null, 0);
    }

    public String getVideoPath() {
        return this.qyA.ien;
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(70257);
        super.setImageBitmap(bitmap);
        if (this.qyI) {
            AppMethodBeat.m2505o(70257);
            return;
        }
        int height = bitmap == null ? this.qyD == 0 ? 240 : this.qyD : bitmap.getHeight();
        int width = bitmap == null ? this.qyC == 0 ? 320 : this.qyC : bitmap.getWidth();
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((float) (this.qyC * height)) / ((float) width)))) {
            layoutParams.width = this.qyC;
            layoutParams.height = (int) ((((float) height) * ((float) this.qyC)) / ((float) width));
            setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(70257);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(70258);
        super.setImageDrawable(drawable);
        if (this.qyI) {
            AppMethodBeat.m2505o(70258);
            return;
        }
        int intrinsicHeight = drawable == null ? this.qyD == 0 ? 240 : this.qyD : drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable == null ? this.qyC == 0 ? 320 : this.qyC : drawable.getIntrinsicWidth();
        if (!(intrinsicHeight == 0 || intrinsicWidth == 0)) {
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.height != ((int) ((((float) this.qyC) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)))) {
                layoutParams.width = this.qyC;
                layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.qyC)) / ((float) intrinsicWidth));
                setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.m2505o(70258);
    }

    /* renamed from: V */
    public final void mo8535V(Bitmap bitmap) {
        AppMethodBeat.m2504i(70259);
        super.setImageBitmap(bitmap);
        AppMethodBeat.m2505o(70259);
    }

    public final void clear() {
        AppMethodBeat.m2504i(70260);
        this.qyA.clear();
        AppMethodBeat.m2505o(70260);
    }

    /* renamed from: bf */
    public final void mo8509bf(String str, boolean z) {
        AppMethodBeat.m2504i(70261);
        this.qyA.mo25372bf(str, z);
        AppMethodBeat.m2505o(70261);
    }

    public final boolean ckY() {
        AppMethodBeat.m2504i(70262);
        boolean clb = this.qyA.clb();
        AppMethodBeat.m2505o(70262);
        return clb;
    }

    public void setPosition(int i) {
        this.qyA.position = i;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(70263);
        super.onDetachedFromWindow();
        C4990ab.m7417i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.qyA.clear();
        C4879a.xxA.mo10053d(this.qyA.cld());
        AppMethodBeat.m2505o(70263);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(70264);
        C4990ab.m7411d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        C4879a.xxA.mo10052c(this.qyA.cld());
        AppMethodBeat.m2505o(70264);
    }

    public void setDrawableWidth(int i) {
        AppMethodBeat.m2504i(70265);
        this.qyG = false;
        this.qyC = i;
        if (this.qyE > 0 && this.qyF > 0) {
            LayoutParams layoutParams = getLayoutParams();
            this.qyD = (this.qyC * this.qyF) / this.qyE;
            if (!(layoutParams.width == this.qyC && layoutParams.height == this.qyD)) {
                layoutParams.width = this.qyC;
                layoutParams.height = this.qyD;
                setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.m2505o(70265);
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.m2504i(70266);
        setImageBitmap(bitmap);
        AppMethodBeat.m2505o(70266);
    }

    public final void ckX() {
        AppMethodBeat.m2504i(70267);
        setImageBitmap(null);
        setImageResource(C25738R.drawable.ak_);
        AppMethodBeat.m2505o(70267);
    }

    public void setMaskID(int i) {
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.m2504i(70268);
        setTag(obj);
        AppMethodBeat.m2505o(70268);
    }

    public Object getTagObject() {
        AppMethodBeat.m2504i(70269);
        Object tag = getTag();
        AppMethodBeat.m2505o(70269);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.m2504i(70270);
        Context context = getContext();
        AppMethodBeat.m2505o(70270);
        return context;
    }

    /* renamed from: fi */
    public void mo8513fi(int i, int i2) {
        AppMethodBeat.m2504i(70271);
        this.qyG = false;
        LayoutParams layoutParams = getLayoutParams();
        this.qyC = i;
        this.qyD = (this.qyC * i2) / i;
        layoutParams.width = this.qyC;
        layoutParams.height = this.qyD;
        setLayoutParams(layoutParams);
        postInvalidate();
        AppMethodBeat.m2505o(70271);
    }

    public void setCanPlay(boolean z) {
        this.qyA.qxI = z;
    }

    public void setOnCompletionListener(C13304e c13304e) {
        this.qyA.qxT = c13304e;
    }

    public void setOnSightCompletionAction(C13321g c13321g) {
        this.qyA.qxV = c13321g;
    }

    public void setOnDecodeDurationListener(C13325f c13325f) {
        this.qyA.qxU = c13325f;
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.m2504i(70272);
        this.qyA.setThumbBgView(view);
        AppMethodBeat.m2505o(70272);
    }

    public void setIsWhatsNew(boolean z) {
        this.qyA.qxL = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.m2504i(70273);
        this.qyA.setSightInfoView(textView);
        AppMethodBeat.m2505o(70273);
    }

    /* renamed from: kA */
    public final void mo8538kA(boolean z) {
        AppMethodBeat.m2504i(70274);
        C13303b c13303b = this.qyA;
        C4990ab.m7417i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (c13303b.qxC != null) {
                c13303b.qxC.type = 0;
                C37961o.m64222i(c13303b.qxC, 0);
            }
            c13303b.qxC = null;
        } else if (c13303b.qxC == null) {
            c13303b.qxC = new C13323i(c13303b, (byte) 0);
            AppMethodBeat.m2505o(70274);
            return;
        }
        AppMethodBeat.m2505o(70274);
    }

    public void setForceRecordState(boolean z) {
    }

    public C13303b getController() {
        return this.qyA;
    }

    public int getDuration() {
        AppMethodBeat.m2504i(70275);
        if (this.qyA == null) {
            AppMethodBeat.m2505o(70275);
            return 0;
        }
        int cle = (int) this.qyA.cle();
        AppMethodBeat.m2505o(70275);
        return cle;
    }

    public void setLoopImp(boolean z) {
        if (this.qyA != null) {
            this.qyA.fVc = z;
        }
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(70276);
        super.onDraw(canvas);
        AppMethodBeat.m2505o(70276);
    }
}
