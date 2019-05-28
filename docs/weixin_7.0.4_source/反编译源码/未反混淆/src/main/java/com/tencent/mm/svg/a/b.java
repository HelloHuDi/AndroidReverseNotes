package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Gravity;
import android.view.View;
import com.tencent.mm.svg.b.c;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.view.d;
import java.lang.ref.WeakReference;

public abstract class b extends Drawable {
    protected final Rect Hx = new Rect();
    public long mDuration = 0;
    protected ColorFilter uN;
    protected int ycT = 0;
    protected boolean ycU = false;
    protected Paint ycV = new Paint();
    protected WeakReference<View> ycW;
    protected int ycX = 0;
    protected int ycY = 0;
    protected int ycZ = 0;
    protected int yda = 0;
    protected float ydb;

    public b(int i, int i2, int i3) {
        this.ycZ = i;
        this.yda = i2;
        this.ydb = 1.0f;
        this.ycX = this.ycZ;
        this.ycY = this.yda;
        setLevel(Downloads.MIN_WAIT_FOR_NETWORK);
        this.ycT = i3;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvE() {
        this.Hx.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.ycU = true;
    }

    /* Access modifiers changed, original: protected */
    public boolean onLevelChange(int i) {
        dvG();
        return super.onLevelChange(i);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvF() {
        if (this.ycU) {
            Gravity.apply(d.MIC_AVROUND_BLUR, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.Hx);
        }
        this.ycU = false;
    }

    private void dvG() {
        View w = a.w(this);
        eC(w);
        if (w != null) {
            if (this.uN != null) {
                setColorFilter(this.uN);
            }
            a.b(w, this.ycV);
        }
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized View dvH() {
        View view;
        if (this.ycW == null) {
            view = null;
        } else {
            view = (View) this.ycW.get();
        }
        return view;
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void eC(View view) {
        this.ycW = new WeakReference(view);
    }

    public boolean setVisible(boolean z, boolean z2) {
        dvG();
        return super.setVisible(z, z2);
    }

    @TargetApi(17)
    public void setAlpha(int i) {
        this.ycV.setAlpha(i);
        View dvH = dvH();
        if (dvH != null && VERSION.SDK_INT >= 17) {
            try {
                dvH.setLayerPaint(this.ycV);
            } catch (NoSuchMethodError e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
            }
        }
    }

    @TargetApi(17)
    public void setColorFilter(ColorFilter colorFilter) {
        this.ycV.setColorFilter(colorFilter);
        View dvH = dvH();
        if (dvH != null && VERSION.SDK_INT >= 17) {
            try {
                dvH.setLayerPaint(this.ycV);
            } catch (NoSuchMethodError e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
            }
        } else if (dvH == null) {
            this.uN = colorFilter;
        }
    }

    public int getOpacity() {
        View dvH = dvH();
        if (dvH != null && dvH.getAlpha() < 1.0f) {
            return -3;
        }
        if (this.ycV == null || this.ycV.getAlpha() >= 255) {
            return 0;
        }
        return -3;
    }

    /* Access modifiers changed, original: protected|final */
    public final void m(Canvas canvas) {
        if (com.tencent.mm.svg.b.b.dvJ()) {
            int height = this.Hx.height() / 3;
            canvas.save();
            Paint paint = new Paint();
            paint.setStyle(Style.FILL);
            paint.setColor(-12303292);
            paint.setAlpha(d.MIC_SketchMark);
            paint.setTextSize((float) height);
            paint.setStrokeWidth(1.0f);
            canvas.translate(((float) this.Hx.width()) - paint.measureText("SVG"), (float) ((this.Hx.height() * 2) / 3));
            canvas.drawText("SVG", 0.0f, (float) height, paint);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return this.ycX;
    }

    public int getIntrinsicHeight() {
        return this.ycY;
    }
}
