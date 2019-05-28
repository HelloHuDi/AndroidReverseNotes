package android.support.v4.a.a;

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
import com.tencent.view.d;

public abstract class b extends Drawable {
    public boolean HA;
    private int HB;
    private int HC;
    private int Ht = 160;
    private int Hu = d.MIC_AVROUND_BLUR;
    public final BitmapShader Hv;
    private final Matrix Hw = new Matrix();
    final Rect Hx = new Rect();
    private final RectF Hy = new RectF();
    private boolean Hz = true;
    public final Bitmap mBitmap;
    public final Paint mPaint = new Paint(3);
    public float rf;

    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.mPaint.setDither(z);
        invalidateSelf();
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* Access modifiers changed, original: final */
    public final void dz() {
        if (this.Hz) {
            if (this.HA) {
                int min = Math.min(this.HB, this.HC);
                a(this.Hu, min, min, getBounds(), this.Hx);
                int min2 = Math.min(this.Hx.width(), this.Hx.height());
                this.Hx.inset(Math.max(0, (this.Hx.width() - min2) / 2), Math.max(0, (this.Hx.height() - min2) / 2));
                this.rf = ((float) min2) * 0.5f;
            } else {
                a(this.Hu, this.HB, this.HC, getBounds(), this.Hx);
            }
            this.Hy.set(this.Hx);
            if (this.Hv != null) {
                this.Hw.setTranslate(this.Hy.left, this.Hy.top);
                this.Hw.preScale(this.Hy.width() / ((float) this.mBitmap.getWidth()), this.Hy.height() / ((float) this.mBitmap.getHeight()));
                this.Hv.setLocalMatrix(this.Hw);
                this.mPaint.setShader(this.Hv);
            }
            this.Hz = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            dz();
            if (this.mPaint.getShader() == null) {
                canvas.drawBitmap(bitmap, null, this.Hx, this.mPaint);
            } else {
                canvas.drawRoundRect(this.Hy, this.rf, this.rf, this.mPaint);
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

    public final void dA() {
        this.HA = true;
        this.Hz = true;
        dB();
        this.mPaint.setShader(this.Hv);
        invalidateSelf();
    }

    private void dB() {
        this.rf = (float) (Math.min(this.HC, this.HB) / 2);
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.HA) {
            dB();
        }
        this.Hz = true;
    }

    public int getIntrinsicWidth() {
        return this.HB;
    }

    public int getIntrinsicHeight() {
        return this.HC;
    }

    public int getOpacity() {
        if (this.Hu != d.MIC_AVROUND_BLUR || this.HA) {
            return -3;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.hasAlpha() || this.mPaint.getAlpha() < 255 || s(this.rf)) {
            return -3;
        }
        return -1;
    }

    b(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.Ht = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            this.HB = this.mBitmap.getScaledWidth(this.Ht);
            this.HC = this.mBitmap.getScaledHeight(this.Ht);
            Bitmap bitmap2 = this.mBitmap;
            TileMode tileMode = TileMode.CLAMP;
            this.Hv = new BitmapShader(bitmap2, tileMode, tileMode);
            return;
        }
        this.HC = -1;
        this.HB = -1;
        this.Hv = null;
    }

    public static boolean s(float f) {
        return f > 0.05f;
    }
}
