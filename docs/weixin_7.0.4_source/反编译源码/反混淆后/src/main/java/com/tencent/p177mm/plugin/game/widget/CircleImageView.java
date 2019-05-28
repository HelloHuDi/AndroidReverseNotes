package com.tencent.p177mm.plugin.game.widget;

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
import com.tencent.p177mm.plugin.game.C20966f.C20967a;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.game.widget.CircleImageView */
public class CircleImageView extends ImageView {
    private static final Config fdG = Config.ARGB_8888;
    private static final ScaleType nof = ScaleType.CENTER_CROP;
    /* renamed from: HB */
    private int f15050HB;
    /* renamed from: HC */
    private int f15051HC;
    /* renamed from: Hv */
    private BitmapShader f15052Hv;
    /* renamed from: Hw */
    private final Matrix f15053Hw;
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
    /* renamed from: qc */
    private int f15054qc;
    /* renamed from: uN */
    private ColorFilter f15055uN;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112386);
        this.nog = new RectF();
        this.noh = new RectF();
        this.f15053Hw = new Matrix();
        this.noi = new Paint();
        this.hIY = new Paint();
        this.hIX = WebView.NIGHT_MODE_COLOR;
        this.f15054qc = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C20967a.CircleImageView, i, 0);
        this.f15054qc = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.hIX = obtainStyledAttributes.getColor(1, WebView.NIGHT_MODE_COLOR);
        this.nol = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        super.setScaleType(nof);
        this.jVl = true;
        if (this.nok) {
            setup();
            this.nok = false;
        }
        AppMethodBeat.m2505o(112386);
    }

    public ScaleType getScaleType() {
        return nof;
    }

    public void setScaleType(ScaleType scaleType) {
        AppMethodBeat.m2504i(112387);
        if (scaleType != nof) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
            AppMethodBeat.m2505o(112387);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(112387);
    }

    public void setAdjustViewBounds(boolean z) {
        AppMethodBeat.m2504i(112388);
        if (z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("adjustViewBounds not supported.");
            AppMethodBeat.m2505o(112388);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(112388);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(112389);
        if (getDrawable() == null) {
            AppMethodBeat.m2505o(112389);
            return;
        }
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.noj, this.noi);
        if (this.f15054qc != 0) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.hIW, this.hIY);
        }
        AppMethodBeat.m2505o(112389);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(112390);
        super.onSizeChanged(i, i2, i3, i4);
        setup();
        AppMethodBeat.m2505o(112390);
    }

    public int getBorderColor() {
        return this.hIX;
    }

    public void setBorderColor(int i) {
        AppMethodBeat.m2504i(112391);
        if (i == this.hIX) {
            AppMethodBeat.m2505o(112391);
            return;
        }
        this.hIX = i;
        this.hIY.setColor(this.hIX);
        invalidate();
        AppMethodBeat.m2505o(112391);
    }

    public void setBorderColorResource(int i) {
        AppMethodBeat.m2504i(112392);
        setBorderColor(getContext().getResources().getColor(i));
        AppMethodBeat.m2505o(112392);
    }

    public int getBorderWidth() {
        return this.f15054qc;
    }

    public void setBorderWidth(int i) {
        AppMethodBeat.m2504i(112393);
        if (i == this.f15054qc) {
            AppMethodBeat.m2505o(112393);
            return;
        }
        this.f15054qc = i;
        setup();
        AppMethodBeat.m2505o(112393);
    }

    public void setBorderOverlay(boolean z) {
        AppMethodBeat.m2504i(112394);
        if (z == this.nol) {
            AppMethodBeat.m2505o(112394);
            return;
        }
        this.nol = z;
        setup();
        AppMethodBeat.m2505o(112394);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(112395);
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
        AppMethodBeat.m2505o(112395);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(112396);
        super.setImageDrawable(drawable);
        this.mBitmap = CircleImageView.m56265s(drawable);
        setup();
        AppMethodBeat.m2505o(112396);
    }

    public void setImageResource(int i) {
        AppMethodBeat.m2504i(112397);
        super.setImageResource(i);
        this.mBitmap = CircleImageView.m56265s(getDrawable());
        setup();
        AppMethodBeat.m2505o(112397);
    }

    public void setImageURI(Uri uri) {
        AppMethodBeat.m2504i(112398);
        super.setImageURI(uri);
        this.mBitmap = CircleImageView.m56265s(getDrawable());
        setup();
        AppMethodBeat.m2505o(112398);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.m2504i(112399);
        if (colorFilter == this.f15055uN) {
            AppMethodBeat.m2505o(112399);
            return;
        }
        this.f15055uN = colorFilter;
        this.noi.setColorFilter(this.f15055uN);
        invalidate();
        AppMethodBeat.m2505o(112399);
    }

    /* renamed from: s */
    private static Bitmap m56265s(Drawable drawable) {
        AppMethodBeat.m2504i(112400);
        if (drawable == null) {
            AppMethodBeat.m2505o(112400);
            return null;
        } else if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            AppMethodBeat.m2505o(112400);
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
                AppMethodBeat.m2505o(112400);
                return createBitmap;
            } catch (OutOfMemoryError e) {
                AppMethodBeat.m2505o(112400);
                return null;
            }
        }
    }

    private void setup() {
        AppMethodBeat.m2504i(112401);
        if (!this.jVl) {
            this.nok = true;
            AppMethodBeat.m2505o(112401);
        } else if (this.mBitmap == null) {
            AppMethodBeat.m2505o(112401);
        } else {
            Bitmap bitmap = this.mBitmap;
            TileMode tileMode = TileMode.CLAMP;
            this.f15052Hv = new BitmapShader(bitmap, tileMode, tileMode);
            this.noi.setAntiAlias(true);
            this.noi.setShader(this.f15052Hv);
            this.hIY.setStyle(Style.STROKE);
            this.hIY.setAntiAlias(true);
            this.hIY.setColor(this.hIX);
            this.hIY.setStrokeWidth((float) this.f15054qc);
            this.f15051HC = this.mBitmap.getHeight();
            this.f15050HB = this.mBitmap.getWidth();
            this.noh.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.hIW = Math.min((this.noh.height() - ((float) this.f15054qc)) / 2.0f, (this.noh.width() - ((float) this.f15054qc)) / 2.0f);
            this.nog.set(this.noh);
            if (!this.nol) {
                this.nog.inset((float) this.f15054qc, (float) this.f15054qc);
            }
            this.noj = Math.min(this.nog.height() / 2.0f, this.nog.width() / 2.0f);
            bFL();
            invalidate();
            AppMethodBeat.m2505o(112401);
        }
    }

    private void bFL() {
        float height;
        float width;
        float f;
        AppMethodBeat.m2504i(112402);
        this.f15053Hw.set(null);
        if (((float) this.f15050HB) * this.nog.height() > this.nog.width() * ((float) this.f15051HC)) {
            height = this.nog.height() / ((float) this.f15051HC);
            width = (this.nog.width() - (((float) this.f15050HB) * height)) * 0.5f;
            f = 0.0f;
        } else {
            height = this.nog.width() / ((float) this.f15050HB);
            f = (this.nog.height() - (((float) this.f15051HC) * height)) * 0.5f;
            width = 0.0f;
        }
        this.f15053Hw.setScale(height, height);
        this.f15053Hw.postTranslate(((float) ((int) (width + 0.5f))) + this.nog.left, ((float) ((int) (f + 0.5f))) + this.nog.top);
        this.f15052Hv.setLocalMatrix(this.f15053Hw);
        AppMethodBeat.m2505o(112402);
    }
}
