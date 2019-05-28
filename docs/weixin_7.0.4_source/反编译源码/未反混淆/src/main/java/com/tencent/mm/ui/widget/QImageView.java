package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RemoteViews.RemoteView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@RemoteView
public class QImageView extends View {
    private static final a[] zNL = new a[]{a.MATRIX, a.FIT_XY, a.FIT_START, a.FIT_CENTER, a.FIT_END, a.CENTER, a.CENTER_CROP, a.CENTER_INSIDE};
    private static final ScaleToFit[] zNM = new ScaleToFit[]{ScaleToFit.FILL, ScaleToFit.START, ScaleToFit.CENTER, ScaleToFit.END};
    private boolean aln;
    private int di;
    private int dj;
    private int mAlpha;
    private Context mContext;
    private Drawable mDrawable;
    private Matrix mMatrix;
    private Uri mUri;
    private int[] ox;
    private ColorFilter uN;
    private boolean zNA;
    private int zNB;
    private boolean zNC;
    private boolean zND;
    private int zNE;
    private int zNF;
    private int zNG;
    private Matrix zNH;
    private final RectF zNI;
    private final RectF zNJ;
    private boolean zNK;
    private int zNx;
    private a zNy;
    private boolean zNz;

    public enum a {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        final int zNV;

        static {
            AppMethodBeat.o(115515);
        }

        private a(int i) {
            this.zNV = i;
        }
    }

    public QImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(115516);
        this.mContext = context;
        dKL();
        AppMethodBeat.o(115516);
    }

    public QImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(115517);
        this.zNx = 0;
        this.zNz = false;
        this.zNA = false;
        this.di = BaseClientBuilder.API_PRIORITY_OTHER;
        this.dj = BaseClientBuilder.API_PRIORITY_OTHER;
        this.mAlpha = 255;
        this.zNB = 256;
        this.zNC = false;
        this.mDrawable = null;
        this.ox = null;
        this.zND = false;
        this.zNE = 0;
        this.zNH = null;
        this.zNI = new RectF();
        this.zNJ = new RectF();
        this.aln = false;
        this.mContext = context;
        dKL();
        this.aln = false;
        setAdjustViewBounds(false);
        setMaxWidth(BaseClientBuilder.API_PRIORITY_OTHER);
        setMaxHeight(BaseClientBuilder.API_PRIORITY_OTHER);
        this.zNK = false;
        AppMethodBeat.o(115517);
    }

    private void dKL() {
        AppMethodBeat.i(115518);
        this.mMatrix = new Matrix();
        this.zNy = a.FIT_CENTER;
        AppMethodBeat.o(115518);
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.i(115519);
        if (this.mDrawable == drawable || super.verifyDrawable(drawable)) {
            AppMethodBeat.o(115519);
            return true;
        }
        AppMethodBeat.o(115519);
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        AppMethodBeat.i(115520);
        if (drawable == this.mDrawable) {
            invalidate();
            AppMethodBeat.o(115520);
            return;
        }
        super.invalidateDrawable(drawable);
        AppMethodBeat.o(115520);
    }

    /* Access modifiers changed, original: protected */
    public boolean onSetAlpha(int i) {
        AppMethodBeat.i(115521);
        if (getBackground() == null) {
            int i2 = (i >> 7) + i;
            if (this.zNB != i2) {
                this.zNB = i2;
                this.zNC = true;
                dKP();
            }
            AppMethodBeat.o(115521);
            return true;
        }
        AppMethodBeat.o(115521);
        return false;
    }

    public void setAdjustViewBounds(boolean z) {
        AppMethodBeat.i(115522);
        this.zNA = z;
        if (z) {
            setScaleType(a.FIT_CENTER);
        }
        AppMethodBeat.o(115522);
    }

    public void setMaxWidth(int i) {
        this.di = i;
    }

    public void setMaxHeight(int i) {
        this.dj = i;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(115523);
        if (!(this.mUri == null && this.zNx == i)) {
            y(null);
            this.zNx = i;
            this.mUri = null;
            dKM();
            invalidate();
        }
        AppMethodBeat.o(115523);
    }

    @TargetApi(11)
    public void setLayerType(int i, Paint paint) {
        AppMethodBeat.i(115524);
        if (!(getDrawable() instanceof PictureDrawable) || i == 1) {
            super.setLayerType(i, paint);
            AppMethodBeat.o(115524);
            return;
        }
        AppMethodBeat.o(115524);
    }

    public void setImageURI(Uri uri) {
        AppMethodBeat.i(115525);
        if (this.zNx != 0 || (this.mUri != uri && (uri == null || this.mUri == null || !uri.equals(this.mUri)))) {
            y(null);
            this.zNx = 0;
            this.mUri = uri;
            dKM();
            invalidate();
        }
        AppMethodBeat.o(115525);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(115526);
        if (this.mDrawable != drawable) {
            this.zNx = 0;
            this.mUri = null;
            y(drawable);
            invalidate();
        }
        AppMethodBeat.o(115526);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.i(115527);
        super.setBackgroundDrawable(drawable);
        AppMethodBeat.o(115527);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(115528);
        setImageDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap));
        AppMethodBeat.o(115528);
    }

    private void dKM() {
        Drawable drawable = null;
        AppMethodBeat.i(115529);
        if (this.mDrawable != null) {
            AppMethodBeat.o(115529);
            return;
        }
        Resources resources = getResources();
        if (resources == null) {
            AppMethodBeat.o(115529);
            return;
        }
        if (this.zNx != 0) {
            try {
                drawable = resources.getDrawable(this.zNx);
            } catch (Exception e) {
                ab.w("ImageView", "Unable to find resource: " + this.zNx, e);
                this.mUri = drawable;
            }
        } else if (this.mUri == null) {
            AppMethodBeat.o(115529);
            return;
        }
        y(drawable);
        AppMethodBeat.o(115529);
    }

    public void setSelected(boolean z) {
        AppMethodBeat.i(115530);
        super.setSelected(z);
        dKN();
        AppMethodBeat.o(115530);
    }

    public void setImageLevel(int i) {
        AppMethodBeat.i(115531);
        this.zNE = i;
        if (this.mDrawable != null) {
            this.mDrawable.setLevel(i);
            dKN();
        }
        AppMethodBeat.o(115531);
    }

    public void setScaleType(a aVar) {
        AppMethodBeat.i(115532);
        if (aVar == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(115532);
            throw nullPointerException;
        }
        if (this.zNy != aVar) {
            this.zNy = aVar;
            setWillNotCacheDrawing(this.zNy == a.CENTER);
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(115532);
    }

    public a getScaleType() {
        return this.zNy;
    }

    public Matrix getImageMatrix() {
        return this.mMatrix;
    }

    public void setImageMatrix(Matrix matrix) {
        Object matrix2;
        AppMethodBeat.i(115533);
        if (matrix2 != null && matrix2.isIdentity()) {
            matrix2 = null;
        }
        if ((matrix2 == null && !this.mMatrix.isIdentity()) || !(matrix2 == null || this.mMatrix.equals(matrix2))) {
            this.mMatrix.set(matrix2);
            dKO();
            invalidate();
        }
        AppMethodBeat.o(115533);
    }

    public int[] onCreateDrawableState(int i) {
        AppMethodBeat.i(115534);
        int[] onCreateDrawableState;
        if (this.ox == null) {
            onCreateDrawableState = super.onCreateDrawableState(i);
            AppMethodBeat.o(115534);
            return onCreateDrawableState;
        } else if (this.zND) {
            onCreateDrawableState = mergeDrawableStates(super.onCreateDrawableState(this.ox.length + i), this.ox);
            AppMethodBeat.o(115534);
            return onCreateDrawableState;
        } else {
            onCreateDrawableState = this.ox;
            AppMethodBeat.o(115534);
            return onCreateDrawableState;
        }
    }

    private void y(Drawable drawable) {
        AppMethodBeat.i(115535);
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            unscheduleDrawable(this.mDrawable);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setLevel(this.zNE);
            this.zNF = drawable.getIntrinsicWidth();
            this.zNG = drawable.getIntrinsicHeight();
            dKP();
            dKO();
        }
        AppMethodBeat.o(115535);
    }

    private void dKN() {
        AppMethodBeat.i(115536);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth < 0) {
                intrinsicWidth = this.zNF;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < 0) {
                intrinsicHeight = this.zNG;
            }
            if (!(intrinsicWidth == this.zNF && intrinsicHeight == this.zNG)) {
                this.zNF = intrinsicWidth;
                this.zNG = intrinsicHeight;
                requestLayout();
            }
        }
        AppMethodBeat.o(115536);
    }

    private static ScaleToFit a(a aVar) {
        return zNM[aVar.zNV - 1];
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int mode;
        AppMethodBeat.i(115537);
        dKM();
        float f = 0.0f;
        Object obj = null;
        Object obj2 = null;
        if (this.mDrawable == null) {
            this.zNF = -1;
            this.zNG = -1;
            i3 = 0;
            i4 = 0;
        } else {
            i3 = this.zNF;
            i5 = this.zNG;
            if (i3 <= 0) {
                i3 = 1;
            }
            if (i5 <= 0) {
                i5 = 1;
            }
            if (this.zNA) {
                mode = MeasureSpec.getMode(i);
                i4 = MeasureSpec.getMode(i2);
                obj = mode != ErrorDialogData.SUPPRESSED ? 1 : null;
                obj2 = i4 != ErrorDialogData.SUPPRESSED ? 1 : null;
                f = ((float) i3) / ((float) i5);
                i4 = i5;
            } else {
                i4 = i5;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (obj == null && obj2 == null) {
            mode = (paddingTop + paddingBottom) + i4;
            i5 = Math.max((paddingLeft + paddingRight) + i3, getSuggestedMinimumWidth());
            i3 = Math.max(mode, getSuggestedMinimumHeight());
            mode = resolveSize(i5, i);
            i5 = resolveSize(i3, i2);
        } else {
            int az = az((i3 + paddingLeft) + paddingRight, this.di, i);
            i3 = az((i4 + paddingTop) + paddingBottom, this.dj, i2);
            if (f == 0.0f || ((double) Math.abs((((float) ((az - paddingLeft) - paddingRight)) / ((float) ((i3 - paddingTop) - paddingBottom))) - f)) <= 1.0E-7d) {
                i5 = i3;
                mode = az;
            } else {
                Object obj3 = null;
                if (obj != null) {
                    i4 = (((int) (((float) ((i3 - paddingTop) - paddingBottom)) * f)) + paddingLeft) + paddingRight;
                    if (i4 <= az) {
                        obj3 = 1;
                        if (obj3 == null && obj2 != null) {
                            i5 = (((int) (((float) ((i4 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                            if (i5 <= i3) {
                                mode = i4;
                            }
                        }
                        i5 = i3;
                        mode = i4;
                    }
                }
                i4 = az;
                i5 = (((int) (((float) ((i4 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                if (i5 <= i3) {
                }
                i5 = i3;
                mode = i4;
            }
        }
        setMeasuredDimension(mode, i5);
        AppMethodBeat.o(115537);
    }

    private static int az(int i, int i2, int i3) {
        AppMethodBeat.i(115538);
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        switch (mode) {
            case j.INVALID_ID /*-2147483648*/:
                i = Math.min(Math.min(i, size), i2);
                break;
            case 0:
                i = Math.min(i, i2);
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                i = size;
                break;
        }
        AppMethodBeat.o(115538);
        return i;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(115539);
        this.zNz = true;
        dKO();
        AppMethodBeat.o(115539);
    }

    private void dKO() {
        AppMethodBeat.i(115540);
        if (this.mDrawable == null || !this.zNz) {
            AppMethodBeat.o(115540);
            return;
        }
        int i = this.zNF;
        int i2 = this.zNG;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i3 = ((i < 0 || width == i) && (i2 < 0 || height == i2)) ? 1 : 0;
        if (i <= 0 || i2 <= 0 || a.FIT_XY == this.zNy) {
            this.mDrawable.setBounds(0, 0, width, height);
            this.zNH = null;
            AppMethodBeat.o(115540);
            return;
        }
        this.mDrawable.setBounds(0, 0, i, i2);
        float f;
        float f2;
        if (a.MATRIX == this.zNy) {
            if (this.mMatrix.isIdentity()) {
                this.zNH = null;
                AppMethodBeat.o(115540);
                return;
            }
            this.zNH = this.mMatrix;
            AppMethodBeat.o(115540);
        } else if (i3 != 0) {
            this.zNH = null;
            AppMethodBeat.o(115540);
        } else if (a.CENTER == this.zNy) {
            this.zNH = this.mMatrix;
            this.zNH.setTranslate((float) ((int) ((((float) (width - i)) * 0.5f) + 0.5f)), (float) ((int) ((((float) (height - i2)) * 0.5f) + 0.5f)));
            AppMethodBeat.o(115540);
        } else if (a.CENTER_CROP == this.zNy) {
            float f3;
            this.zNH = this.mMatrix;
            if (i * height > width * i2) {
                f3 = ((float) height) / ((float) i2);
                f = (((float) width) - (((float) i) * f3)) * 0.5f;
                f2 = 0.0f;
            } else {
                f3 = ((float) width) / ((float) i);
                f2 = (((float) height) - (((float) i2) * f3)) * 0.5f;
                f = 0.0f;
            }
            this.zNH.setScale(f3, f3);
            this.zNH.postTranslate((float) ((int) (f + 0.5f)), (float) ((int) (f2 + 0.5f)));
            AppMethodBeat.o(115540);
        } else if (a.CENTER_INSIDE == this.zNy) {
            this.zNH = this.mMatrix;
            if (i > width || i2 > height) {
                f2 = Math.min(((float) width) / ((float) i), ((float) height) / ((float) i2));
            } else {
                f2 = 1.0f;
            }
            float f4 = (float) ((int) (((((float) width) - (((float) i) * f2)) * 0.5f) + 0.5f));
            f = (float) ((int) (((((float) height) - (((float) i2) * f2)) * 0.5f) + 0.5f));
            this.zNH.setScale(f2, f2);
            this.zNH.postTranslate(f4, f);
            AppMethodBeat.o(115540);
        } else {
            this.zNI.set(0.0f, 0.0f, (float) i, (float) i2);
            this.zNJ.set(0.0f, 0.0f, (float) width, (float) height);
            this.zNH = this.mMatrix;
            this.zNH.setRectToRect(this.zNI, this.zNJ, a(this.zNy));
            AppMethodBeat.o(115540);
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(115541);
        super.drawableStateChanged();
        Drawable drawable = this.mDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        AppMethodBeat.o(115541);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(115542);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.onDraw(canvas);
        if (this.mDrawable == null) {
            AppMethodBeat.o(115542);
        } else if (this.zNF == 0 || this.zNG == 0) {
            AppMethodBeat.o(115542);
        } else if (this.zNH == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
            this.mDrawable.draw(canvas);
            AppMethodBeat.o(115542);
        } else {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (this.zNK) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            }
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            if (this.zNH != null) {
                canvas.concat(this.zNH);
            }
            this.mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
            AppMethodBeat.o(115542);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(115543);
        if (this.aln) {
            int measuredHeight = getMeasuredHeight();
            AppMethodBeat.o(115543);
            return measuredHeight;
        }
        AppMethodBeat.o(115543);
        return -1;
    }

    public final void setColorFilter(int i) {
        AppMethodBeat.i(115544);
        setColorFilter(new PorterDuffColorFilter(i, Mode.SRC_ATOP));
        AppMethodBeat.o(115544);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(115545);
        if (this.uN != colorFilter) {
            this.uN = colorFilter;
            this.zNC = true;
            dKP();
            invalidate();
        }
        AppMethodBeat.o(115545);
    }

    public void setAlpha(int i) {
        AppMethodBeat.i(115546);
        int i2 = i & 255;
        if (this.mAlpha != i2) {
            this.mAlpha = i2;
            this.zNC = true;
            dKP();
            invalidate();
        }
        AppMethodBeat.o(115546);
    }

    private void dKP() {
        AppMethodBeat.i(115547);
        if (this.mDrawable != null && this.zNC) {
            this.mDrawable = this.mDrawable.mutate();
            this.mDrawable.setColorFilter(this.uN);
            this.mDrawable.setAlpha((this.mAlpha * this.zNB) >> 8);
        }
        AppMethodBeat.o(115547);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(115548);
        super.onDetachedFromWindow();
        AppMethodBeat.o(115548);
    }
}
