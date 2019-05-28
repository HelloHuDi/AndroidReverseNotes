package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.p627e.p1346b.C24002c;
import com.tencent.p177mm.p612ui.p627e.p1346b.C44371a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ui.base.MultiTouchImageView */
public class MultiTouchImageView extends ImageView implements C44272g {
    /* renamed from: Bn */
    private final float[] f17560Bn;
    private float aKB;
    protected Matrix aKo;
    private boolean iXv;
    private int iZn;
    private int iZo;
    private int imageHeight;
    private int imageWidth;
    private boolean isInited;
    protected C7306ak mHandler;
    protected Bitmap rdJ;
    private C36063a rsT;
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
    public boolean yzk;
    public boolean yzl;
    private float yzm;
    private float yzn;
    float yzo;
    public boolean yzp;
    public Drawable yzq;

    /* renamed from: com.tencent.mm.ui.base.MultiTouchImageView$a */
    public interface C36063a {
        void ctq();

        void ctr();
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
        AppMethodBeat.m2504i(106974);
        if (Float.compare(f, 1.0f) < 0) {
            C4990ab.m7420w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
            AppMethodBeat.m2505o(106974);
            return;
        }
        this.yzi = f;
        AppMethodBeat.m2505o(106974);
    }

    public void setMinZoomLimit(float f) {
        AppMethodBeat.m2504i(106975);
        if (Float.compare(f, 1.0f) > 0) {
            C4990ab.m7420w("MicroMsg.MultiTouchImageView", "min scale limit is greater than 1.0, change nothing, return");
            AppMethodBeat.m2505o(106975);
        } else if (Float.compare(f, 0.0f) < 0) {
            C4990ab.m7420w("MicroMsg.MultiTouchImageView", "min scale limit is less than 0.0, change nothing, return");
            AppMethodBeat.m2505o(106975);
        } else {
            this.yzh = f;
            AppMethodBeat.m2505o(106975);
        }
    }

    public void setDoubleTabScaleLimit(float f) {
        AppMethodBeat.m2504i(106976);
        if (Float.compare(f, 0.0f) < 0) {
            C4990ab.m7420w("MicroMsg.MultiTouchImageView", "double tab scale limit is less than 0.0, change nothing, return");
            AppMethodBeat.m2505o(106976);
            return;
        }
        this.yzg = f;
        AppMethodBeat.m2505o(106976);
    }

    public void setMaxZoomDoubleTab(boolean z) {
        this.yzj = z;
    }

    public MultiTouchImageView(Context context, int i, int i2, C36063a c36063a) {
        super(context);
        AppMethodBeat.m2504i(106977);
        this.yyY = new Matrix();
        this.aKo = new Matrix();
        this.yyZ = new Matrix();
        this.f17560Bn = new float[9];
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
        this.mHandler = new C7306ak();
        this.aKB = 1.0f;
        this.yzo = 0.0f;
        this.yzp = false;
        this.imageHeight = i2;
        this.imageWidth = i;
        this.rsT = c36063a;
        init();
        AppMethodBeat.m2505o(106977);
    }

    public MultiTouchImageView(Context context, int i, int i2) {
        this(context, i, i2, null);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private MultiTouchImageView(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106978);
        this.yyY = new Matrix();
        this.aKo = new Matrix();
        this.yyZ = new Matrix();
        this.f17560Bn = new float[9];
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
        this.mHandler = new C7306ak();
        this.aKB = 1.0f;
        this.yzo = 0.0f;
        this.yzp = false;
        this.imageHeight = 0;
        this.imageWidth = 0;
        init();
        AppMethodBeat.m2505o(106978);
    }

    /* renamed from: bW */
    public final void mo71980bW(int i, int i2) {
        this.imageWidth = i;
        this.imageHeight = i2;
    }

    /* renamed from: hk */
    public final void mo71988hk(int i, int i2) {
        this.iZo = i2;
        this.iZn = i;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106979);
        super.onMeasure(i, i2);
        if (this.iZn == MeasureSpec.getSize(i) && this.iZo == MeasureSpec.getSize(i2)) {
            this.iXv = false;
        } else {
            this.iXv = true;
        }
        this.iZn = MeasureSpec.getSize(i);
        this.iZo = MeasureSpec.getSize(i2);
        if (!this.isInited) {
            this.isInited = true;
            init();
        }
        if (this.iXv) {
            dzA();
        }
        AppMethodBeat.m2505o(106979);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(106980);
        this.yzp = false;
        this.rdJ = bitmap;
        this.isInited = false;
        super.setImageBitmap(bitmap);
        AppMethodBeat.m2505o(106980);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(106981);
        if (this.yzp || this.rdJ == null || !this.rdJ.isRecycled()) {
            super.onDraw(canvas);
            AppMethodBeat.m2505o(106981);
            return;
        }
        C4990ab.m7412e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
        AppMethodBeat.m2505o(106981);
    }

    public final void dzA() {
        AppMethodBeat.m2504i(106982);
        this.aKo.reset();
        dAo();
        mo10861k(this.yzf, 0.0f, 0.0f);
        AppMethodBeat.m2505o(106982);
    }

    /* renamed from: ah */
    public final void mo10841ah(float f, float f2) {
        AppMethodBeat.m2504i(106983);
        dAo();
        m81890l(this.yzf, f, f2);
        AppMethodBeat.m2505o(106983);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            this.isInited = false;
        }
    }

    private void dAo() {
        boolean z;
        boolean z2 = true;
        this.yzm = ((float) this.iZn) / ((float) this.imageWidth);
        this.yzn = ((float) this.iZo) / ((float) this.imageHeight);
        this.yzk = ((float) this.imageWidth) > ((float) this.imageHeight) * 2.2f;
        if (((float) this.imageHeight) > ((float) this.imageWidth) * 2.2f) {
            z = true;
        } else {
            z = false;
        }
        this.yzl = z;
        if (!this.yzk || this.imageWidth <= this.iZn) {
            z = false;
        } else {
            z = true;
        }
        this.yzk = z;
        if (!this.yzl || this.imageHeight <= this.iZo) {
            z2 = false;
        }
        this.yzl = z2;
        float f = ((float) this.imageHeight) / ((float) this.imageWidth);
        float f2 = 1.8f;
        if (!(this.iZn == 0 || this.iZo == 0)) {
            f2 = ((float) this.iZo) / ((float) this.iZn);
        }
        if (f <= f2 || ((double) f) > 2.2d) {
            this.yzf = this.yzm;
        } else {
            this.yzf = this.yzn;
        }
    }

    public float getScaleRate() {
        return this.yzf;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(int i) {
        this.imageWidth = i;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public void setImageHeight(int i) {
        this.imageHeight = i;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(106984);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            C46631f.m88236c(keyEvent);
            AppMethodBeat.m2505o(106984);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(106984);
        return onKeyDown;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(106985);
        if (i != 4 || !C46631f.m88238d(keyEvent) || C46631f.m88239e(keyEvent) || getScale() <= 1.0f) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.m2505o(106985);
            return onKeyUp;
        }
        mo10861k(1.0f, ((float) this.iZn) / 2.0f, ((float) this.iZo) / 2.0f);
        AppMethodBeat.m2505o(106985);
        return true;
    }

    /* renamed from: ai */
    private void m81889ai(boolean z, boolean z2) {
        float f = 0.0f;
        AppMethodBeat.m2504i(106986);
        if (this.rdJ == null && !this.yzp) {
            AppMethodBeat.m2505o(106986);
        } else if (this.yzq == null && this.yzp) {
            AppMethodBeat.m2505o(106986);
        } else {
            RectF rectF;
            float f2;
            Matrix imageViewMatrix = getImageViewMatrix();
            if (this.yzp) {
                rectF = new RectF(0.0f, 0.0f, (float) this.yzq.getIntrinsicWidth(), (float) this.yzq.getIntrinsicHeight());
            } else {
                rectF = new RectF(0.0f, 0.0f, (float) this.rdJ.getWidth(), (float) this.rdJ.getHeight());
            }
            imageViewMatrix.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            if (!z2) {
                f2 = ((float) this.iZo) - rectF.bottom;
                height = (rectF.top + f2) / 2.0f;
                if (height < 0.0f) {
                    height = 0.0f;
                }
                if (rectF.top > 0.0f) {
                    f2 = height - rectF.top;
                } else {
                    if (rectF.bottom < ((float) this.iZo)) {
                        f2 -= height;
                    }
                    f2 = 0.0f;
                }
            } else if (height < ((float) this.iZo)) {
                f2 = ((((float) this.iZo) - height) / 2.0f) - rectF.top;
            } else if (rectF.top > 0.0f) {
                f2 = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.iZo)) {
                    f2 = ((float) this.iZo) - rectF.bottom;
                }
                f2 = 0.0f;
            }
            if (!z) {
                width = ((float) this.iZn) - rectF.right;
                height = (rectF.left + width) / 2.0f;
                if (height < 0.0f) {
                    height = 0.0f;
                }
                if (rectF.left > 0.0f) {
                    f = height - rectF.left;
                } else if (rectF.right < ((float) this.iZn)) {
                    f = width - height;
                }
            } else if (width < ((float) this.iZn)) {
                f = ((((float) this.iZn) - width) / 2.0f) - rectF.left;
            } else if (rectF.left > 0.0f) {
                f = -rectF.left;
            } else if (rectF.right < ((float) this.iZn)) {
                f = ((float) this.iZn) - rectF.right;
            }
            mo10843aj(f, f2);
            imageViewMatrix = getImageViewMatrix();
            setImageMatrix(imageViewMatrix);
            imageViewMatrix.mapRect(rectF);
            rectF.height();
            rectF.width();
            AppMethodBeat.m2505o(106986);
        }
    }

    private void init() {
        AppMethodBeat.m2504i(106987);
        C4990ab.m7410d("dktest", "init screenWidth:" + this.iZn + " screenHeight :" + this.iZo);
        setScaleType(ScaleType.MATRIX);
        float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f > 1.0f) {
            this.aKB = f;
        }
        dzA();
        AppMethodBeat.m2505o(106987);
    }

    public float getScale() {
        AppMethodBeat.m2504i(106988);
        this.aKo.getValues(this.f17560Bn);
        dAo();
        this.yzd = this.yzi * this.aKB;
        this.yze = this.yzf * this.yzh;
        if (this.yzd < 1.0f) {
            this.yzd = 1.0f;
        }
        if (this.yze > 1.0f) {
            this.yze = 1.0f;
        }
        float f = this.f17560Bn[0];
        AppMethodBeat.m2505o(106988);
        return f;
    }

    /* Access modifiers changed, original: protected */
    public Matrix getImageViewMatrix() {
        AppMethodBeat.m2504i(106989);
        this.yyZ.set(this.yyY);
        this.yyZ.postConcat(this.aKo);
        Matrix matrix = this.yyZ;
        AppMethodBeat.m2505o(106989);
        return matrix;
    }

    public final void dAp() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(106990);
        if (this.rsw && this.yzk) {
            z = false;
        } else {
            z = true;
        }
        if (this.yzl) {
            z2 = false;
        }
        m81889ai(z, z2);
        AppMethodBeat.m2505o(106990);
    }

    public final void dzB() {
        AppMethodBeat.m2504i(106991);
        if (this.yzj && 0.0f == this.yzc) {
            this.yzc = getDoubleTabScale();
        }
        AppMethodBeat.m2505o(106991);
    }

    /* renamed from: k */
    public final void mo10861k(float f, float f2, float f3) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(106992);
        float scale = getScale();
        if (this.yzj) {
            this.yzd = 0.0f == this.yzc ? this.yzi * this.aKB : this.yzc;
        }
        if (f > this.yzd * 2.0f) {
            f = (this.yzd * 2.0f) + ((f - this.yzd) * 0.1f);
        } else if (f < this.yze) {
            f = this.yze;
        }
        scale = f / scale;
        if (!this.yzp) {
            setImageMatrix(getImageViewMatrix());
            this.aKo.postScale(scale, scale, f2, f3);
        }
        if (this.rsw && this.yzk) {
            z = false;
        } else {
            z = true;
        }
        if (this.yzl) {
            z2 = false;
        }
        m81889ai(z, z2);
        if (this.rsT != null) {
            if (scale > 1.0f) {
                this.rsT.ctr();
                AppMethodBeat.m2505o(106992);
                return;
            } else if (scale < 1.0f) {
                this.rsT.ctq();
            }
        }
        AppMethodBeat.m2505o(106992);
    }

    public float getDoubleTabScale() {
        AppMethodBeat.m2504i(106993);
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
        AppMethodBeat.m2505o(106993);
        return scaleRate;
    }

    /* renamed from: ai */
    public final void mo10842ai(float f, float f2) {
        AppMethodBeat.m2504i(106994);
        this.yzc = getDoubleTabScale();
        m81890l(this.yzc, f, f2);
        AppMethodBeat.m2505o(106994);
    }

    public void setEnableHorLongBmpMode(boolean z) {
        this.rsw = z;
    }

    /* renamed from: l */
    private void m81890l(float f, float f2, float f3) {
        AppMethodBeat.m2504i(106995);
        final float scale = (f - getScale()) / 128.0f;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        final float f4 = f2;
        final float f5 = f3;
        this.mHandler.post(new Runnable() {
            final /* synthetic */ float yzr = 128.0f;

            public final void run() {
                AppMethodBeat.m2504i(106973);
                float min = Math.min(this.yzr, (float) (System.currentTimeMillis() - currentTimeMillis));
                MultiTouchImageView.this.mo10861k(scale2 + (scale * min), f4, f5);
                if (min < this.yzr) {
                    MultiTouchImageView.this.mHandler.post(this);
                }
                AppMethodBeat.m2505o(106973);
            }
        });
        AppMethodBeat.m2505o(106995);
    }

    public float getRealWidth() {
        AppMethodBeat.m2504i(106996);
        float scale = getScale() * ((float) getImageWidth());
        AppMethodBeat.m2505o(106996);
        return scale;
    }

    /* renamed from: aj */
    public final void mo10843aj(float f, float f2) {
        AppMethodBeat.m2504i(106997);
        this.aKo.postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
        AppMethodBeat.m2505o(106997);
    }

    public void setGifPath(String str) {
        AppMethodBeat.m2504i(106998);
        this.yzp = true;
        try {
            this.yzq = C24002c.m36988io(str, str);
            setImageDrawable(this.yzq);
            if (this.yzq != null) {
                mo71980bW(this.yzq.getIntrinsicWidth(), this.yzq.getIntrinsicHeight());
            }
            AppMethodBeat.m2505o(106998);
        } catch (Exception e) {
            this.yzp = false;
            AppMethodBeat.m2505o(106998);
        }
    }

    public void setGifDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(106999);
        this.yzp = true;
        this.yzq = drawable;
        setImageDrawable(this.yzq);
        AppMethodBeat.m2505o(106999);
    }

    public final void start() {
        AppMethodBeat.m2504i(107000);
        if (this.yzp && this.yzq != null) {
            ((C44371a) this.yzq).start();
        }
        AppMethodBeat.m2505o(107000);
    }
}
