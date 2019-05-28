package com.tencent.luggage.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CircleProgressDrawable extends Drawable {
    private static final RectF bRS = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF bRT = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private int bRU;
    private int bRV;
    private boolean bRW;
    private int bRX;
    private RingPathTransform bRY;
    private RingRotation bRZ;
    private Paint mPaint;
    /* renamed from: uV */
    private int f14970uV;

    static class RingPathTransform {
        /* renamed from: vb */
        public float f2797vb = 0.0f;
        /* renamed from: vc */
        public float f2798vc = 0.0f;
        /* renamed from: vd */
        public float f2799vd = 0.0f;

        private RingPathTransform() {
        }

        @Keep
        public void setTrimPathStart(float f) {
            this.f2797vb = f;
        }

        @Keep
        public void setTrimPathEnd(float f) {
            this.f2798vc = f;
        }

        @Keep
        public void setTrimPathOffset(float f) {
            this.f2799vd = f;
        }
    }

    static class RingRotation {
        /* renamed from: nR */
        private float f5423nR;

        private RingRotation() {
        }

        @Keep
        public void setRotation(float f) {
            this.f5423nR = f;
        }
    }

    static {
        AppMethodBeat.m2504i(90949);
        AppMethodBeat.m2505o(90949);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(90948);
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            AppMethodBeat.m2505o(90948);
            return;
        }
        int save;
        if (this.mPaint == null) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Style.STROKE);
            this.mPaint.setStrokeWidth((float) this.bRV);
            this.mPaint.setStrokeCap(Cap.SQUARE);
            this.mPaint.setStrokeJoin(Join.MITER);
        }
        int save2 = canvas.save();
        canvas.translate((float) bounds.left, (float) bounds.top);
        int width = bounds.width();
        int height = bounds.height();
        Paint paint = this.mPaint;
        canvas.scale(((float) width) / bRS.width(), ((float) height) / bRS.height());
        canvas.translate(bRS.width() / 2.0f, bRS.height() / 2.0f);
        if (this.bRW) {
            save = canvas.save();
            paint.setColor(this.bRX);
            canvas.drawArc(bRT, 0.0f, 360.0f, false, paint);
            canvas.restoreToCount(save);
        }
        save = canvas.save();
        paint.setColor(this.f14970uV);
        canvas.rotate(this.bRZ.f5423nR);
        Canvas canvas2 = canvas;
        canvas2.drawArc(bRT, -90.0f + ((this.bRY.f2799vd + this.bRY.f2797vb) * 360.0f), 360.0f * (this.bRY.f2798vc - this.bRY.f2797vb), false, paint);
        canvas.restoreToCount(save);
        canvas.restoreToCount(save2);
        AppMethodBeat.m2505o(90948);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }

    public final int getIntrinsicWidth() {
        return this.bRU;
    }

    public final int getIntrinsicHeight() {
        return this.bRU;
    }
}
