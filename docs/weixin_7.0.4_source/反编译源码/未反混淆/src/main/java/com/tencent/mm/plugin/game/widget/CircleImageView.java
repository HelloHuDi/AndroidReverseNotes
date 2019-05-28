package com.tencent.mm.plugin.game.widget;

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
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.smtt.sdk.WebView;

public class CircleImageView extends ImageView {
    private static final Config fdG = Config.ARGB_8888;
    private static final ScaleType nof = ScaleType.CENTER_CROP;
    private int HB;
    private int HC;
    private BitmapShader Hv;
    private final Matrix Hw;
    private float hIW;
    private int hIX;
    private final Paint hIY;
    private boolean jVl;
    private Bitmap mBitmap;
    private final RectF nog;
    private final RectF noh;
    private final Paint noi;
    private float noj;
    private boolean nok;
    private boolean nol;
    private int qc;
    private ColorFilter uN;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112386);
        this.nog = new RectF();
        this.noh = new RectF();
        this.Hw = new Matrix();
        this.noi = new Paint();
        this.hIY = new Paint();
        this.hIX = WebView.NIGHT_MODE_COLOR;
        this.qc = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.CircleImageView, i, 0);
        this.qc = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.hIX = obtainStyledAttributes.getColor(1, WebView.NIGHT_MODE_COLOR);
        this.nol = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        super.setScaleType(nof);
        this.jVl = true;
        if (this.nok) {
            setup();
            this.nok = false;
        }
        AppMethodBeat.o(112386);
    }

    public ScaleType getScaleType() {
        return nof;
    }

    public void setScaleType(ScaleType scaleType) {
        AppMethodBeat.i(112387);
        if (scaleType != nof) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
            AppMethodBeat.o(112387);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(112387);
    }

    public void setAdjustViewBounds(boolean z) {
        AppMethodBeat.i(112388);
        if (z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("adjustViewBounds not supported.");
            AppMethodBeat.o(112388);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(112388);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(112389);
        if (getDrawable() == null) {
            AppMethodBeat.o(112389);
            return;
        }
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.noj, this.noi);
        if (this.qc != 0) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.hIW, this.hIY);
        }
        AppMethodBeat.o(112389);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(112390);
        super.onSizeChanged(i, i2, i3, i4);
        setup();
        AppMethodBeat.o(112390);
    }

    public int getBorderColor() {
        return this.hIX;
    }

    public void setBorderColor(int i) {
        AppMethodBeat.i(112391);
        if (i == this.hIX) {
            AppMethodBeat.o(112391);
            return;
        }
        this.hIX = i;
        this.hIY.setColor(this.hIX);
        invalidate();
        AppMethodBeat.o(112391);
    }

    public void setBorderColorResource(int i) {
        AppMethodBeat.i(112392);
        setBorderColor(getContext().getResources().getColor(i));
        AppMethodBeat.o(112392);
    }

    public int getBorderWidth() {
        return this.qc;
    }

    public void setBorderWidth(int i) {
        AppMethodBeat.i(112393);
        if (i == this.qc) {
            AppMethodBeat.o(112393);
            return;
        }
        this.qc = i;
        setup();
        AppMethodBeat.o(112393);
    }

    public void setBorderOverlay(boolean z) {
        AppMethodBeat.i(112394);
        if (z == this.nol) {
            AppMethodBeat.o(112394);
            return;
        }
        this.nol = z;
        setup();
        AppMethodBeat.o(112394);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(112395);
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
        AppMethodBeat.o(112395);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(112396);
        super.setImageDrawable(drawable);
        this.mBitmap = s(drawable);
        setup();
        AppMethodBeat.o(112396);
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(112397);
        super.setImageResource(i);
        this.mBitmap = s(getDrawable());
        setup();
        AppMethodBeat.o(112397);
    }

    public void setImageURI(Uri uri) {
        AppMethodBeat.i(112398);
        super.setImageURI(uri);
        this.mBitmap = s(getDrawable());
        setup();
        AppMethodBeat.o(112398);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(112399);
        if (colorFilter == this.uN) {
            AppMethodBeat.o(112399);
            return;
        }
        this.uN = colorFilter;
        this.noi.setColorFilter(this.uN);
        invalidate();
        AppMethodBeat.o(112399);
    }

    private static Bitmap s(Drawable drawable) {
        AppMethodBeat.i(112400);
        if (drawable == null) {
            AppMethodBeat.o(112400);
            return null;
        } else if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            AppMethodBeat.o(112400);
            return bitmap;
        } else {
            try {
                Bitmap createBitmap;
                if (drawable instanceof ColorDrawable) {
                    createBitmap = Bitmap.createBitmap(2, 2, fdG);
                } else {
                    createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), fdG);
                }
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                AppMethodBeat.o(112400);
                return createBitmap;
            } catch (OutOfMemoryError e) {
                AppMethodBeat.o(112400);
                return null;
            }
        }
    }

    private void setup() {
        AppMethodBeat.i(112401);
        if (!this.jVl) {
            this.nok = true;
            AppMethodBeat.o(112401);
        } else if (this.mBitmap == null) {
            AppMethodBeat.o(112401);
        } else {
            Bitmap bitmap = this.mBitmap;
            TileMode tileMode = TileMode.CLAMP;
            this.Hv = new BitmapShader(bitmap, tileMode, tileMode);
            this.noi.setAntiAlias(true);
            this.noi.setShader(this.Hv);
            this.hIY.setStyle(Style.STROKE);
            this.hIY.setAntiAlias(true);
            this.hIY.setColor(this.hIX);
            this.hIY.setStrokeWidth((float) this.qc);
            this.HC = this.mBitmap.getHeight();
            this.HB = this.mBitmap.getWidth();
            this.noh.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.hIW = Math.min((this.noh.height() - ((float) this.qc)) / 2.0f, (this.noh.width() - ((float) this.qc)) / 2.0f);
            this.nog.set(this.noh);
            if (!this.nol) {
                this.nog.inset((float) this.qc, (float) this.qc);
            }
            this.noj = Math.min(this.nog.height() / 2.0f, this.nog.width() / 2.0f);
            bFL();
            invalidate();
            AppMethodBeat.o(112401);
        }
    }

    private void bFL() {
        float height;
        float width;
        float f;
        AppMethodBeat.i(112402);
        this.Hw.set(null);
        if (((float) this.HB) * this.nog.height() > this.nog.width() * ((float) this.HC)) {
            height = this.nog.height() / ((float) this.HC);
            width = (this.nog.width() - (((float) this.HB) * height)) * 0.5f;
            f = 0.0f;
        } else {
            height = this.nog.width() / ((float) this.HB);
            f = (this.nog.height() - (((float) this.HC) * height)) * 0.5f;
            width = 0.0f;
        }
        this.Hw.setScale(height, height);
        this.Hw.postTranslate(((float) ((int) (width + 0.5f))) + this.nog.left, ((float) ((int) (f + 0.5f))) + this.nog.top);
        this.Hv.setLocalMatrix(this.Hw);
        AppMethodBeat.o(112402);
    }
}
