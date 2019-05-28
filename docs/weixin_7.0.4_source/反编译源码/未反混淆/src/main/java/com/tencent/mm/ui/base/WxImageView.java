package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.ui.WxBaseImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MultiTouchImageView.a;

public class WxImageView extends WxBaseImageView implements g {
    private final float[] Bn;
    private float aKB;
    protected Matrix aKo;
    private boolean iXv;
    private int iZn;
    private int iZo;
    private boolean isInited;
    protected ak mHandler;
    private int orientation;
    protected Bitmap rdJ;
    private a rsT;
    private boolean rsw;
    protected Matrix yyY;
    private final Matrix yyZ;
    int yza;
    int yzb;
    private float yzc;
    private float yzd;
    private float yze;
    private float yzf;
    private float yzg;
    private float yzh;
    private float yzi;
    private boolean yzj;
    private boolean yzk;
    private boolean yzl;
    private float yzm;
    private float yzn;
    private boolean yzp;
    private Drawable yzq;

    public WxImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107098);
        this.yyY = new Matrix();
        this.aKo = new Matrix();
        this.yyZ = new Matrix();
        this.Bn = new float[9];
        this.rdJ = null;
        this.yza = -1;
        this.yzb = -1;
        this.yzc = 0.0f;
        this.yzd = 0.0f;
        this.yze = 0.0f;
        this.isInited = false;
        this.iXv = false;
        this.yzg = 2.0f;
        this.yzh = 0.75f;
        this.yzi = 20.0f;
        this.yzj = false;
        this.yzk = false;
        this.yzl = false;
        this.rsw = true;
        this.yzp = false;
        this.mHandler = new ak();
        this.aKB = 1.0f;
        AppMethodBeat.o(107098);
    }

    public WxImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107099);
        this.yyY = new Matrix();
        this.aKo = new Matrix();
        this.yyZ = new Matrix();
        this.Bn = new float[9];
        this.rdJ = null;
        this.yza = -1;
        this.yzb = -1;
        this.yzc = 0.0f;
        this.yzd = 0.0f;
        this.yze = 0.0f;
        this.isInited = false;
        this.iXv = false;
        this.yzg = 2.0f;
        this.yzh = 0.75f;
        this.yzi = 20.0f;
        this.yzj = false;
        this.yzk = false;
        this.yzl = false;
        this.rsw = true;
        this.yzp = false;
        this.mHandler = new ak();
        this.aKB = 1.0f;
        AppMethodBeat.o(107099);
    }

    public final boolean dzy() {
        return this.yzk;
    }

    public final boolean dzz() {
        return this.yzl;
    }

    public float getScaleWidth() {
        return this.yzm;
    }

    public float getScaleHeight() {
        return this.yzn;
    }

    public float getMaxZoom() {
        return this.yzd;
    }

    public float getMinZoom() {
        return this.yze;
    }

    public void setMaxZoomLimit(float f) {
        AppMethodBeat.i(107100);
        if (Float.compare(f, 1.0f) < 0) {
            ab.w("MicroMsg.WxImageView", "max scale limit is less than 1.0, change nothing, return");
            AppMethodBeat.o(107100);
            return;
        }
        this.yzi = f;
        AppMethodBeat.o(107100);
    }

    public void setMinZoomLimit(float f) {
        AppMethodBeat.i(107101);
        if (Float.compare(f, 1.0f) > 0) {
            ab.w("MicroMsg.WxImageView", "min scale limit is greater than 1.0, change nothing, return");
            AppMethodBeat.o(107101);
        } else if (Float.compare(f, 0.0f) < 0) {
            ab.w("MicroMsg.WxImageView", "min scale limit is less than 0.0, change nothing, return");
            AppMethodBeat.o(107101);
        } else {
            this.yzh = f;
            AppMethodBeat.o(107101);
        }
    }

    public void setDoubleTabScaleLimit(float f) {
        AppMethodBeat.i(107102);
        if (Float.compare(f, 0.0f) < 0) {
            ab.w("MicroMsg.WxImageView", "double tab scale limit is less than 0.0, change nothing, return");
            AppMethodBeat.o(107102);
            return;
        }
        this.yzg = f;
        AppMethodBeat.o(107102);
    }

    public void setMaxZoomDoubleTab(boolean z) {
        this.yzj = z;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107103);
        super.onMeasure(i, i2);
        if (this.iZn == MeasureSpec.getSize(i) && this.iZo == MeasureSpec.getSize(i2)) {
            this.iXv = false;
        } else {
            this.iXv = true;
        }
        this.iZn = MeasureSpec.getSize(i);
        this.iZo = MeasureSpec.getSize(i2);
        ab.d("MicroMsg.WxImageView", "alvinluo onMeasure viewWidth: %d, viewHeight: %d", Integer.valueOf(this.iZn), Integer.valueOf(this.iZo));
        if (!this.isInited) {
            this.isInited = true;
            this.yzp = false;
            ab.d("MicroMsg.WxImageView", "init screenWidth:" + this.iZn + " screenHeight :" + this.iZo);
            float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
            if (f > 1.0f) {
                this.aKB = f;
            }
            dzA();
        }
        if (this.iXv) {
            dzA();
        }
        AppMethodBeat.o(107103);
    }

    public int getContentTop() {
        AppMethodBeat.i(107104);
        if (this.isInited) {
            int imageHeight = (int) ((((float) this.iZo) - (this.yzf * ((float) getImageHeight()))) / 2.0f);
            if (imageHeight < 0) {
                imageHeight = 0;
            }
            ab.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", Float.valueOf(this.yzf), Integer.valueOf(getImageHeight()), Integer.valueOf(this.iZo), Integer.valueOf(imageHeight));
            AppMethodBeat.o(107104);
            return imageHeight;
        }
        AppMethodBeat.o(107104);
        return 0;
    }

    public int getContentLeft() {
        AppMethodBeat.i(107105);
        if (this.isInited) {
            int i = (int) ((((float) this.iZn) - (this.yzf * ((float) this.imageWidth))) / 2.0f);
            if (i < 0) {
                i = 0;
            }
            ab.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", Float.valueOf(this.yzf), Integer.valueOf(this.imageWidth), Integer.valueOf(this.iZn), Integer.valueOf(i));
            AppMethodBeat.o(107105);
            return i;
        }
        AppMethodBeat.o(107105);
        return 0;
    }

    public final void dzA() {
        AppMethodBeat.i(107106);
        ab.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
        this.aKo.reset();
        dAo();
        PA();
        k(this.yzf, 0.0f, 0.0f);
        AppMethodBeat.o(107106);
    }

    public final void ah(float f, float f2) {
        AppMethodBeat.i(107107);
        dAo();
        l(this.yzf, f, f2);
        AppMethodBeat.o(107107);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            this.isInited = false;
        }
    }

    public void setOrientation(int i) {
        AppMethodBeat.i(107108);
        this.orientation = i;
        dAo();
        AppMethodBeat.o(107108);
    }

    private void dAo() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(107109);
        int imageWidth = getImageWidth();
        int imageHeight = getImageHeight();
        this.yzm = ((float) this.iZn) / ((float) imageWidth);
        this.yzn = ((float) this.iZo) / ((float) imageHeight);
        this.yzk = ((float) imageWidth) > ((float) imageHeight) * 2.2f;
        if (((float) imageHeight) > ((float) imageWidth) * 2.2f) {
            z = true;
        } else {
            z = false;
        }
        this.yzl = z;
        if (!this.yzk || imageWidth <= this.iZn) {
            z = false;
        } else {
            z = true;
        }
        this.yzk = z;
        if (!this.yzl || imageHeight <= this.iZo) {
            z2 = false;
        }
        this.yzl = z2;
        float f = ((float) imageHeight) / ((float) imageWidth);
        float f2 = 1.8f;
        if (!(this.iZn == 0 || this.iZo == 0)) {
            f2 = ((float) this.iZo) / ((float) this.iZn);
        }
        if (f <= f2 || ((double) f) > 2.2d) {
            this.yzf = this.yzm;
        } else {
            this.yzf = this.yzn;
        }
        setScaleRate(this.yzf);
        AppMethodBeat.o(107109);
    }

    public float getScaleRate() {
        return this.yzf;
    }

    public int getImageWidth() {
        if (this.orientation == 90 || this.orientation == 270) {
            return this.imageHeight;
        }
        return this.imageWidth;
    }

    public void setImageWidth(int i) {
        this.imageWidth = i;
    }

    public int getImageHeight() {
        if (this.orientation == 90 || this.orientation == 270) {
            return this.imageWidth;
        }
        return this.imageHeight;
    }

    public void setImageHeight(int i) {
        this.imageHeight = i;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(107110);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            f.c(keyEvent);
            AppMethodBeat.o(107110);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(107110);
        return onKeyDown;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(107111);
        if (i != 4 || !f.d(keyEvent) || f.e(keyEvent) || getScale() <= 1.0f) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.o(107111);
            return onKeyUp;
        }
        k(1.0f, ((float) this.iZn) / 2.0f, ((float) this.iZo) / 2.0f);
        AppMethodBeat.o(107111);
        return true;
    }

    private void ai(boolean z, boolean z2) {
        float f = 0.0f;
        AppMethodBeat.i(107112);
        if (this.yzq == null && this.yzp) {
            AppMethodBeat.o(107112);
            return;
        }
        RectF rectF;
        Matrix imageViewMatrix = getImageViewMatrix();
        if (this.yzp) {
            rectF = new RectF(0.0f, 0.0f, (float) this.yzq.getIntrinsicWidth(), (float) this.yzq.getIntrinsicHeight());
        } else {
            rectF = new RectF(0.0f, 0.0f, (float) this.imageWidth, (float) this.imageHeight);
        }
        imageViewMatrix.mapRect(rectF);
        float height = rectF.height();
        float width = rectF.width();
        if (z2) {
            if (height < ((float) this.iZo)) {
                height = ((((float) this.iZo) - height) / 2.0f) - rectF.top;
            } else if (rectF.top > 0.0f) {
                height = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.iZo)) {
                    height = ((float) this.iZo) - rectF.bottom;
                }
                height = 0.0f;
            }
        } else if (rectF.top > 0.0f) {
            height = -rectF.top;
        } else {
            if (rectF.bottom < ((float) this.iZo)) {
                height = ((float) this.iZo) - rectF.bottom;
            }
            height = 0.0f;
        }
        if (z) {
            if (width < ((float) this.iZn)) {
                f = ((((float) this.iZn) - width) / 2.0f) - rectF.left;
            } else if (rectF.left > 0.0f) {
                f = -rectF.left;
            } else if (rectF.right < ((float) this.iZn)) {
                f = ((float) this.iZn) - rectF.right;
            }
        } else if (rectF.left > 0.0f) {
            f = -rectF.left;
        } else if (rectF.right < ((float) this.iZn)) {
            f = ((float) this.iZn) - rectF.right;
        }
        aj(f, height);
        getImageViewMatrix().mapRect(rectF);
        AppMethodBeat.o(107112);
    }

    public float getScale() {
        AppMethodBeat.i(107113);
        float scale = super.getScale();
        AppMethodBeat.o(107113);
        return scale;
    }

    /* Access modifiers changed, original: protected */
    public Matrix getImageViewMatrix() {
        AppMethodBeat.i(107114);
        this.yyZ.set(this.yyY);
        this.yyZ.postConcat(this.aKo);
        Matrix matrix = this.yyZ;
        AppMethodBeat.o(107114);
        return matrix;
    }

    public final void dzB() {
        AppMethodBeat.i(107115);
        if (this.yzj && 0.0f == this.yzc) {
            this.yzc = getDoubleTabScale();
        }
        AppMethodBeat.o(107115);
    }

    public final void k(float f, float f2, float f3) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(107116);
        float scale = getScale();
        if (this.yzj) {
            this.yzd = 0.0f == this.yzc ? this.yzi * this.aKB : this.yzc;
        }
        if (f > this.yzd * 2.0f) {
            f = (this.yzd * 2.0f) + ((f - this.yzd) * 0.1f);
        } else if (f < this.yze) {
            f = this.yze;
        }
        float f4 = f / scale;
        ab.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", Float.valueOf(this.yzc), Float.valueOf(this.yzd), Float.valueOf(f), Float.valueOf(scale), Float.valueOf(f4));
        if (!this.yzp) {
            this.aKo.postScale(f4, f4, f2, f3);
        }
        if (this.rsw && this.yzk) {
            z = false;
        } else {
            z = true;
        }
        if (this.yzl) {
            z2 = false;
        }
        ai(z, z2);
        if (this.rsT != null) {
            if (f4 > 1.0f) {
                this.rsT.ctr();
                AppMethodBeat.o(107116);
                return;
            } else if (f4 < 1.0f) {
                this.rsT.ctq();
            }
        }
        AppMethodBeat.o(107116);
    }

    public float getDoubleTabScale() {
        AppMethodBeat.i(107117);
        float scaleRate = getScaleRate();
        if (getScaleWidth() * 0.7f > scaleRate) {
            scaleRate = getScaleWidth();
        } else if (getScaleHeight() * 0.7f > scaleRate) {
            scaleRate = getScaleHeight();
        } else {
            scaleRate = getScaleRate() * this.yzg;
        }
        if (((double) scaleRate) < 1.0d) {
            scaleRate = 1.0f;
        }
        if (scaleRate > getMaxZoom()) {
            scaleRate = getMaxZoom();
        }
        AppMethodBeat.o(107117);
        return scaleRate;
    }

    public final void ai(float f, float f2) {
        AppMethodBeat.i(107118);
        this.yzc = getDoubleTabScale();
        l(this.yzc, f, f2);
        AppMethodBeat.o(107118);
    }

    public void setEnableHorLongBmpMode(boolean z) {
        this.rsw = z;
    }

    private void l(float f, float f2, float f3) {
        AppMethodBeat.i(107119);
        final float scale = (f - getScale()) / 128.0f;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        final float f4 = f2;
        final float f5 = f3;
        this.mHandler.post(new Runnable() {
            final /* synthetic */ float yzr = 128.0f;

            public final void run() {
                AppMethodBeat.i(107097);
                float min = Math.min(this.yzr, (float) (System.currentTimeMillis() - currentTimeMillis));
                WxImageView.this.k(scale2 + (scale * min), f4, f5);
                if (min < this.yzr) {
                    WxImageView.this.mHandler.post(this);
                }
                AppMethodBeat.o(107097);
            }
        });
        AppMethodBeat.o(107119);
    }

    public final void aj(float f, float f2) {
        AppMethodBeat.i(107120);
        ab.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", Float.valueOf(f), Float.valueOf(f2));
        this.aKo.postTranslate(f, f2);
        AppMethodBeat.o(107120);
    }

    public final void translate(float f, float f2) {
        AppMethodBeat.i(107121);
        float translationX = getTranslationX();
        float translationY = getTranslationY();
        setTranslationX(translationX + f);
        setTranslationY(translationY + f2);
        ab.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", Float.valueOf(translationX), Float.valueOf(translationY), Float.valueOf(translationX + f), Float.valueOf(translationY + f2));
        AppMethodBeat.o(107121);
    }

    public Matrix getImageMatrix() {
        AppMethodBeat.i(107122);
        this.yyZ.set(this.yyY);
        this.yyZ.postConcat(this.aKo);
        Matrix matrix = this.yyZ;
        AppMethodBeat.o(107122);
        return matrix;
    }
}
