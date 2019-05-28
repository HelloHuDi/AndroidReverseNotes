package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public class SightPlayImageView extends QPictureView implements com.tencent.mm.plugin.sight.decode.a.a {
    public com.tencent.mm.pluginsdk.ui.tools.e.a llE;
    public b qyA;
    private int qyC;
    private int qyD;
    private int qyE;
    private int qyF;
    public boolean qyG;
    private boolean qyH;
    public boolean qyI;

    static final class a extends b {
        private WeakReference<SightPlayImageView> qyB;

        public final int ckZ() {
            return R.anim.d8;
        }

        public a(SightPlayImageView sightPlayImageView) {
            super(0, sightPlayImageView);
            AppMethodBeat.i(70253);
            this.qyB = new WeakReference(sightPlayImageView);
            AppMethodBeat.o(70253);
        }

        public final void dH(int i, int i2) {
            AppMethodBeat.i(70254);
            final SightPlayImageView sightPlayImageView = (SightPlayImageView) this.qyB.get();
            if (sightPlayImageView == null) {
                ab.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
                AppMethodBeat.o(70254);
            } else if (sightPlayImageView.qyI) {
                AppMethodBeat.o(70254);
            } else {
                sightPlayImageView.qyE = i;
                sightPlayImageView.qyF = i2;
                if (sightPlayImageView.llE != null) {
                    sightPlayImageView.llE.dH(i, i2);
                }
                if (sightPlayImageView.qyH) {
                    if (sightPlayImageView.qyE >= sightPlayImageView.qyF) {
                        sightPlayImageView.qyC = com.tencent.mm.bz.a.fromDPToPix(sightPlayImageView.getContext(), 150);
                    } else {
                        sightPlayImageView.qyC = com.tencent.mm.bz.a.fromDPToPix(sightPlayImageView.getContext(), 85);
                    }
                }
                if (sightPlayImageView.qyC > 0) {
                    final LayoutParams layoutParams = sightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == sightPlayImageView.qyC && layoutParams.height == (sightPlayImageView.qyC * i2) / i)) {
                        layoutParams.width = sightPlayImageView.qyC;
                        layoutParams.height = (sightPlayImageView.qyC * i2) / i;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(70252);
                                sightPlayImageView.setLayoutParams(layoutParams);
                                AppMethodBeat.o(70252);
                            }
                        });
                        sightPlayImageView.postInvalidate();
                    }
                    ab.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                ab.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(sightPlayImageView.qyC), Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.o(70254);
            }
        }

        public final void U(Bitmap bitmap) {
            AppMethodBeat.i(70255);
            SightPlayImageView sightPlayImageView = (SightPlayImageView) this.qyB.get();
            if (sightPlayImageView == null) {
                ab.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                AppMethodBeat.o(70255);
                return;
            }
            sightPlayImageView.setImageBitmap(bitmap);
            AppMethodBeat.o(70255);
        }
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(70256);
        this.qyG = true;
        this.qyH = false;
        this.qyI = false;
        this.qyA = new a(this);
        ab.i("MicroMsg.SightPlayImageView", "mController %s", bo.dpG().toString());
        AppMethodBeat.o(70256);
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
        AppMethodBeat.i(70257);
        super.setImageBitmap(bitmap);
        if (this.qyI) {
            AppMethodBeat.o(70257);
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
        AppMethodBeat.o(70257);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(70258);
        super.setImageDrawable(drawable);
        if (this.qyI) {
            AppMethodBeat.o(70258);
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
        AppMethodBeat.o(70258);
    }

    public final void V(Bitmap bitmap) {
        AppMethodBeat.i(70259);
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(70259);
    }

    public final void clear() {
        AppMethodBeat.i(70260);
        this.qyA.clear();
        AppMethodBeat.o(70260);
    }

    public final void bf(String str, boolean z) {
        AppMethodBeat.i(70261);
        this.qyA.bf(str, z);
        AppMethodBeat.o(70261);
    }

    public final boolean ckY() {
        AppMethodBeat.i(70262);
        boolean clb = this.qyA.clb();
        AppMethodBeat.o(70262);
        return clb;
    }

    public void setPosition(int i) {
        this.qyA.position = i;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(70263);
        super.onDetachedFromWindow();
        ab.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.qyA.clear();
        com.tencent.mm.sdk.b.a.xxA.d(this.qyA.cld());
        AppMethodBeat.o(70263);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(70264);
        ab.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xxA.c(this.qyA.cld());
        AppMethodBeat.o(70264);
    }

    public void setDrawableWidth(int i) {
        AppMethodBeat.i(70265);
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
        AppMethodBeat.o(70265);
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.i(70266);
        setImageBitmap(bitmap);
        AppMethodBeat.o(70266);
    }

    public final void ckX() {
        AppMethodBeat.i(70267);
        setImageBitmap(null);
        setImageResource(R.drawable.ak_);
        AppMethodBeat.o(70267);
    }

    public void setMaskID(int i) {
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.i(70268);
        setTag(obj);
        AppMethodBeat.o(70268);
    }

    public Object getTagObject() {
        AppMethodBeat.i(70269);
        Object tag = getTag();
        AppMethodBeat.o(70269);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.i(70270);
        Context context = getContext();
        AppMethodBeat.o(70270);
        return context;
    }

    public void fi(int i, int i2) {
        AppMethodBeat.i(70271);
        this.qyG = false;
        LayoutParams layoutParams = getLayoutParams();
        this.qyC = i;
        this.qyD = (this.qyC * i2) / i;
        layoutParams.width = this.qyC;
        layoutParams.height = this.qyD;
        setLayoutParams(layoutParams);
        postInvalidate();
        AppMethodBeat.o(70271);
    }

    public void setCanPlay(boolean z) {
        this.qyA.qxI = z;
    }

    public void setOnCompletionListener(e eVar) {
        this.qyA.qxT = eVar;
    }

    public void setOnSightCompletionAction(g gVar) {
        this.qyA.qxV = gVar;
    }

    public void setOnDecodeDurationListener(f fVar) {
        this.qyA.qxU = fVar;
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.i(70272);
        this.qyA.setThumbBgView(view);
        AppMethodBeat.o(70272);
    }

    public void setIsWhatsNew(boolean z) {
        this.qyA.qxL = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.i(70273);
        this.qyA.setSightInfoView(textView);
        AppMethodBeat.o(70273);
    }

    public final void kA(boolean z) {
        AppMethodBeat.i(70274);
        b bVar = this.qyA;
        ab.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (bVar.qxC != null) {
                bVar.qxC.type = 0;
                o.i(bVar.qxC, 0);
            }
            bVar.qxC = null;
        } else if (bVar.qxC == null) {
            bVar.qxC = new i(bVar, (byte) 0);
            AppMethodBeat.o(70274);
            return;
        }
        AppMethodBeat.o(70274);
    }

    public void setForceRecordState(boolean z) {
    }

    public b getController() {
        return this.qyA;
    }

    public int getDuration() {
        AppMethodBeat.i(70275);
        if (this.qyA == null) {
            AppMethodBeat.o(70275);
            return 0;
        }
        int cle = (int) this.qyA.cle();
        AppMethodBeat.o(70275);
        return cle;
    }

    public void setLoopImp(boolean z) {
        if (this.qyA != null) {
            this.qyA.fVc = z;
        }
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(70276);
        super.onDraw(canvas);
        AppMethodBeat.o(70276);
    }
}
