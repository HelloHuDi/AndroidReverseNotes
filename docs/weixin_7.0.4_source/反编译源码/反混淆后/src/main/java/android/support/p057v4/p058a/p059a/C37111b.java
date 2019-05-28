package android.support.p057v4.p058a.p059a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.tencent.view.C31128d;

/* renamed from: android.support.v4.a.a.b */
public abstract class C37111b extends Drawable {
    /* renamed from: HA */
    public boolean f15748HA;
    /* renamed from: HB */
    private int f15749HB;
    /* renamed from: HC */
    private int f15750HC;
    /* renamed from: Ht */
    private int f15751Ht = 160;
    /* renamed from: Hu */
    private int f15752Hu = C31128d.MIC_AVROUND_BLUR;
    /* renamed from: Hv */
    public final BitmapShader f15753Hv;
    /* renamed from: Hw */
    private final Matrix f15754Hw = new Matrix();
    /* renamed from: Hx */
    final Rect f15755Hx = new Rect();
    /* renamed from: Hy */
    private final RectF f15756Hy = new RectF();
    /* renamed from: Hz */
    private boolean f15757Hz = true;
    public final Bitmap mBitmap;
    public final Paint mPaint = new Paint(3);
    /* renamed from: rf */
    public float f15758rf;

    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.mPaint.setDither(z);
        invalidateSelf();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo59156a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dz */
    public final void mo59159dz() {
        if (this.f15757Hz) {
            if (this.f15748HA) {
                int min = Math.min(this.f15749HB, this.f15750HC);
                mo59156a(this.f15752Hu, min, min, getBounds(), this.f15755Hx);
                int min2 = Math.min(this.f15755Hx.width(), this.f15755Hx.height());
                this.f15755Hx.inset(Math.max(0, (this.f15755Hx.width() - min2) / 2), Math.max(0, (this.f15755Hx.height() - min2) / 2));
                this.f15758rf = ((float) min2) * 0.5f;
            } else {
                mo59156a(this.f15752Hu, this.f15749HB, this.f15750HC, getBounds(), this.f15755Hx);
            }
            this.f15756Hy.set(this.f15755Hx);
            if (this.f15753Hv != null) {
                this.f15754Hw.setTranslate(this.f15756Hy.left, this.f15756Hy.top);
                this.f15754Hw.preScale(this.f15756Hy.width() / ((float) this.mBitmap.getWidth()), this.f15756Hy.height() / ((float) this.mBitmap.getHeight()));
                this.f15753Hv.setLocalMatrix(this.f15754Hw);
                this.mPaint.setShader(this.f15753Hv);
            }
            this.f15757Hz = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            mo59159dz();
            if (this.mPaint.getShader() == null) {
                canvas.drawBitmap(bitmap, null, this.f15755Hx, this.mPaint);
            } else {
                canvas.drawRoundRect(this.f15756Hy, this.f15758rf, this.f15758rf, this.mPaint);
            }
        }
    }

    public void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    /* renamed from: dA */
    public final void mo59157dA() {
        this.f15748HA = true;
        this.f15757Hz = true;
        m62118dB();
        this.mPaint.setShader(this.f15753Hv);
        invalidateSelf();
    }

    /* renamed from: dB */
    private void m62118dB() {
        this.f15758rf = (float) (Math.min(this.f15750HC, this.f15749HB) / 2);
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f15748HA) {
            m62118dB();
        }
        this.f15757Hz = true;
    }

    public int getIntrinsicWidth() {
        return this.f15749HB;
    }

    public int getIntrinsicHeight() {
        return this.f15750HC;
    }

    public int getOpacity() {
        if (this.f15752Hu != C31128d.MIC_AVROUND_BLUR || this.f15748HA) {
            return -3;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.hasAlpha() || this.mPaint.getAlpha() < 255 || C37111b.m62119s(this.f15758rf)) {
            return -3;
        }
        return -1;
    }

    C37111b(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.f15751Ht = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            this.f15749HB = this.mBitmap.getScaledWidth(this.f15751Ht);
            this.f15750HC = this.mBitmap.getScaledHeight(this.f15751Ht);
            Bitmap bitmap2 = this.mBitmap;
            TileMode tileMode = TileMode.CLAMP;
            this.f15753Hv = new BitmapShader(bitmap2, tileMode, tileMode);
            return;
        }
        this.f15750HC = -1;
        this.f15749HB = -1;
        this.f15753Hv = null;
    }

    /* renamed from: s */
    public static boolean m62119s(float f) {
        return f > 0.05f;
    }
}
