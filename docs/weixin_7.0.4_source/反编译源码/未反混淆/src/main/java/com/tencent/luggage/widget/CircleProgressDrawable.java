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
    private int uV;

    static class RingPathTransform {
        public float vb = 0.0f;
        public float vc = 0.0f;
        public float vd = 0.0f;

        private RingPathTransform() {
        }

        @Keep
        public void setTrimPathStart(float f) {
            this.vb = f;
        }

        @Keep
        public void setTrimPathEnd(float f) {
            this.vc = f;
        }

        @Keep
        public void setTrimPathOffset(float f) {
            this.vd = f;
        }
    }

    static class RingRotation {
        private float nR;

        private RingRotation() {
        }

        @Keep
        public void setRotation(float f) {
            this.nR = f;
        }
    }

    static {
        AppMethodBeat.i(90949);
        AppMethodBeat.o(90949);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(90948);
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            AppMethodBeat.o(90948);
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
        paint.setColor(this.uV);
        canvas.rotate(this.bRZ.nR);
        Canvas canvas2 = canvas;
        canvas2.drawArc(bRT, -90.0f + ((this.bRY.vd + this.bRY.vb) * 360.0f), 360.0f * (this.bRY.vc - this.bRY.vb), false, paint);
        canvas.restoreToCount(save);
        canvas.restoreToCount(save2);
        AppMethodBeat.o(90948);
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
