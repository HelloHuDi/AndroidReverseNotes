package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.smtt.sdk.WebView;

public class CircularImageView extends ImageView {
    private static final String TAG = CircularImageView.class.getSimpleName();
    private Paint aFY;
    private int borderWidth;
    private boolean gBF;
    private boolean rdC;
    private boolean rdD;
    private int rdE;
    private int rdF;
    private boolean rdG;
    private float rdH;
    private BitmapShader rdI;
    private Bitmap rdJ;
    private Paint rdK;
    private Paint rdL;
    private ColorFilter rdM;
    private int shadowColor;
    private float shadowDx;
    private float shadowDy;

    static {
        AppMethodBeat.i(37681);
        AppMethodBeat.o(37681);
    }

    public CircularImageView(Context context) {
        this(context, null, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(37665);
        this.aFY = new Paint();
        this.aFY.setAntiAlias(true);
        this.rdK = new Paint();
        this.rdK.setAntiAlias(true);
        this.rdK.setStyle(Style.STROKE);
        this.rdL = new Paint();
        this.rdL.setAntiAlias(true);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.CircularImageView, i, 0);
        this.rdC = obtainStyledAttributes.getBoolean(0, false);
        this.rdD = obtainStyledAttributes.getBoolean(3, false);
        this.rdG = obtainStyledAttributes.getBoolean(7, false);
        if (this.rdC) {
            setBorderWidth(obtainStyledAttributes.getDimensionPixelOffset(2, (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f)));
            setBorderColor(obtainStyledAttributes.getColor(1, -1));
        }
        if (this.rdD) {
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
            setSelectorColor(obtainStyledAttributes.getColor(4, 0));
            setSelectorStrokeWidth(obtainStyledAttributes.getDimensionPixelOffset(6, i2));
            setSelectorStrokeColor(obtainStyledAttributes.getColor(5, -16776961));
        }
        if (this.rdG) {
            this.rdH = obtainStyledAttributes.getFloat(8, 4.0f);
            this.shadowDx = obtainStyledAttributes.getFloat(9, 0.0f);
            this.shadowDy = obtainStyledAttributes.getFloat(10, 2.0f);
            this.shadowColor = obtainStyledAttributes.getColor(11, WebView.NIGHT_MODE_COLOR);
            setShadowEnabled(true);
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(37665);
    }

    public void setBorderWidth(int i) {
        AppMethodBeat.i(37666);
        this.borderWidth = i;
        if (this.rdK != null) {
            this.rdK.setStrokeWidth((float) i);
        }
        requestLayout();
        invalidate();
        AppMethodBeat.o(37666);
    }

    public void setBorderColor(int i) {
        AppMethodBeat.i(37667);
        if (this.rdK != null) {
            this.rdK.setColor(i);
        }
        invalidate();
        AppMethodBeat.o(37667);
    }

    public void setSelectorColor(int i) {
        AppMethodBeat.i(37668);
        this.rdM = new PorterDuffColorFilter(i, Mode.SRC_ATOP);
        invalidate();
        AppMethodBeat.o(37668);
    }

    public void setSelectorStrokeWidth(int i) {
        AppMethodBeat.i(37669);
        this.rdF = i;
        requestLayout();
        invalidate();
        AppMethodBeat.o(37669);
    }

    public void setSelectorStrokeColor(int i) {
        AppMethodBeat.i(37670);
        if (this.rdL != null) {
            this.rdL.setColor(i);
        }
        invalidate();
        AppMethodBeat.o(37670);
    }

    public void setShadowEnabled(boolean z) {
        AppMethodBeat.i(37671);
        this.rdG = z;
        float f = this.rdG ? this.rdH : 0.0f;
        this.rdK.setShadowLayer(f, this.shadowDx, this.shadowDy, this.shadowColor);
        this.rdL.setShadowLayer(f, this.shadowDx, this.shadowDy, this.shadowColor);
        AppMethodBeat.o(37671);
    }

    public void onDraw(Canvas canvas) {
        int i = 0;
        AppMethodBeat.i(37672);
        if (this.rdJ == null) {
            AppMethodBeat.o(37672);
        } else if (this.rdJ.getHeight() == 0 || this.rdJ.getWidth() == 0) {
            AppMethodBeat.o(37672);
        } else {
            int i2 = this.rdE;
            this.rdE = getWidth() < getHeight() ? getWidth() : getHeight();
            if (i2 != this.rdE) {
                cqg();
            }
            this.aFY.setShader(this.rdI);
            int i3 = this.rdE / 2;
            if (this.rdD && this.gBF) {
                i = this.rdF;
                i3 = (this.rdE - (i * 2)) / 2;
                this.aFY.setColorFilter(this.rdM);
                canvas.drawCircle((float) (i3 + i), (float) (i3 + i), ((float) (((this.rdE - (i * 2)) / 2) + i)) - 4.0f, this.rdL);
            } else if (this.rdC) {
                int i4 = this.borderWidth;
                int i5 = (this.rdE - (i4 * 2)) / 2;
                this.aFY.setColorFilter(null);
                canvas.drawArc(new RectF((float) ((i4 / 2) + 0), (float) ((i4 / 2) + 0), (float) (this.rdE - (i4 / 2)), (float) (this.rdE - (i4 / 2))), 360.0f, 360.0f, false, this.rdK);
                i3 = i5;
                i = i4;
            } else {
                this.aFY.setColorFilter(null);
            }
            canvas.drawCircle((float) (i3 + i), (float) (i3 + i), (float) ((this.rdE - (i * 2)) / 2), this.aFY);
            AppMethodBeat.o(37672);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(37673);
        boolean dispatchTouchEvent;
        if (isClickable()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.gBF = true;
                    break;
                case 1:
                case 3:
                case 4:
                case 8:
                    this.gBF = false;
                    break;
            }
            invalidate();
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(37673);
            return dispatchTouchEvent;
        }
        this.gBF = false;
        dispatchTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(37673);
        return dispatchTouchEvent;
    }

    public void setImageURI(Uri uri) {
        AppMethodBeat.i(37674);
        super.setImageURI(uri);
        this.rdJ = drawableToBitmap(getDrawable());
        if (this.rdE > 0) {
            cqg();
        }
        AppMethodBeat.o(37674);
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(37675);
        super.setImageResource(i);
        this.rdJ = drawableToBitmap(getDrawable());
        if (this.rdE > 0) {
            cqg();
        }
        AppMethodBeat.o(37675);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(37676);
        super.setImageDrawable(drawable);
        this.rdJ = drawableToBitmap(getDrawable());
        if (this.rdE > 0) {
            cqg();
        }
        AppMethodBeat.o(37676);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(37677);
        super.setImageBitmap(bitmap);
        this.rdJ = bitmap;
        if (this.rdE > 0) {
            cqg();
        }
        AppMethodBeat.o(37677);
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        AppMethodBeat.i(37679);
        if (drawable == null) {
            AppMethodBeat.o(37679);
            return null;
        } else if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            AppMethodBeat.o(37679);
            return bitmap;
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                AppMethodBeat.o(37679);
                return null;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                AppMethodBeat.o(37679);
                return createBitmap;
            } catch (OutOfMemoryError e) {
                AppMethodBeat.o(37679);
                return null;
            }
        }
    }

    public void setIconModeEnabled(boolean z) {
    }

    private void cqg() {
        AppMethodBeat.i(37680);
        if (this.rdJ == null) {
            AppMethodBeat.o(37680);
            return;
        }
        Bitmap bitmap = this.rdJ;
        TileMode tileMode = TileMode.CLAMP;
        this.rdI = new BitmapShader(bitmap, tileMode, tileMode);
        if (!(this.rdE == this.rdJ.getWidth() && this.rdE == this.rdJ.getHeight())) {
            Matrix matrix = new Matrix();
            float width = ((float) this.rdE) / ((float) this.rdJ.getWidth());
            matrix.setScale(width, width);
            this.rdI.setLocalMatrix(matrix);
        }
        AppMethodBeat.o(37680);
    }

    public boolean isSelected() {
        return this.gBF;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(37678);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (!(mode == ErrorDialogData.SUPPRESSED || mode == j.INVALID_ID)) {
            size = this.rdE;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        if (!(mode2 == ErrorDialogData.SUPPRESSED || mode2 == j.INVALID_ID)) {
            mode = this.rdE;
        }
        setMeasuredDimension(size, mode + 2);
        AppMethodBeat.o(37678);
    }
}
