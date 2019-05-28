package com.tencent.p177mm.svg.p610a;

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
import com.tencent.p177mm.svg.p611b.C5157b;
import com.tencent.p177mm.svg.p611b.C5159c;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.view.C31128d;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.svg.a.b */
public abstract class C5148b extends Drawable {
    /* renamed from: Hx */
    protected final Rect f1295Hx = new Rect();
    public long mDuration = 0;
    /* renamed from: uN */
    protected ColorFilter f1296uN;
    protected int ycT = 0;
    protected boolean ycU = false;
    protected Paint ycV = new Paint();
    protected WeakReference<View> ycW;
    protected int ycX = 0;
    protected int ycY = 0;
    protected int ycZ = 0;
    protected int yda = 0;
    protected float ydb;

    public C5148b(int i, int i2, int i3) {
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
        this.f1295Hx.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
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
            Gravity.apply(C31128d.MIC_AVROUND_BLUR, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f1295Hx);
        }
        this.ycU = false;
    }

    private void dvG() {
        View w = C5147a.m7838w(this);
        mo10590eC(w);
        if (w != null) {
            if (this.f1296uN != null) {
                setColorFilter(this.f1296uN);
            }
            C5147a.m7832b(w, this.ycV);
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
    /* renamed from: eC */
    public final synchronized void mo10590eC(View view) {
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
                C5159c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
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
                C5159c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
            }
        } else if (dvH == null) {
            this.f1296uN = colorFilter;
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
    /* renamed from: m */
    public final void mo10594m(Canvas canvas) {
        if (C5157b.dvJ()) {
            int height = this.f1295Hx.height() / 3;
            canvas.save();
            Paint paint = new Paint();
            paint.setStyle(Style.FILL);
            paint.setColor(-12303292);
            paint.setAlpha(C31128d.MIC_SketchMark);
            paint.setTextSize((float) height);
            paint.setStrokeWidth(1.0f);
            canvas.translate(((float) this.f1295Hx.width()) - paint.measureText("SVG"), (float) ((this.f1295Hx.height() * 2) / 3));
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
