package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import android.support.v4.view.b.f;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public final class CircleProgressDrawable extends Drawable {
    private static final RectF bRS = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF bRT = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private int bRU = Math.round(ah.getResources().getDisplayMetrics().density * 48.0f);
    private int bRV = 4;
    private boolean bRW = false;
    private int bRX = 0;
    public RingPathTransform iTZ = new RingPathTransform();
    public RingRotation jbC = new RingRotation();
    private Paint mPaint;
    public ArrayList<Animator> uC = new ArrayList();
    private int uV = WebView.NIGHT_MODE_COLOR;

    public static class b {
        public static final Interpolator iUa = f.c(iUb);
        private static final Path iUb;

        static {
            AppMethodBeat.i(77386);
            Path path = new Path();
            iUb = path;
            path.cubicTo(0.2f, 0.0f, 0.1f, 1.0f, 0.5f, 1.0f);
            iUb.lineTo(1.0f, 1.0f);
            AppMethodBeat.o(77386);
        }
    }

    public static class c {
        public static final Interpolator iUa = f.c(iUc);
        private static final Path iUc;

        static {
            AppMethodBeat.i(77387);
            Path path = new Path();
            iUc = path;
            path.lineTo(0.5f, 0.0f);
            iUc.cubicTo(0.7f, 0.0f, 0.6f, 1.0f, 1.0f, 1.0f);
            AppMethodBeat.o(77387);
        }
    }

    public static class a {
        public static final Interpolator iUa = new LinearInterpolator();

        static {
            AppMethodBeat.i(77385);
            AppMethodBeat.o(77385);
        }
    }

    static class RingRotation {
        private float nR;

        private RingRotation() {
        }

        /* synthetic */ RingRotation(byte b) {
            this();
        }

        @Keep
        public void setRotation(float f) {
            this.nR = f;
        }
    }

    static class RingPathTransform {
        public float vb;
        public float vc;
        public float vd;

        private RingPathTransform() {
            this.vb = 0.0f;
            this.vc = 0.0f;
            this.vd = 0.0f;
        }

        /* synthetic */ RingPathTransform(byte b) {
            this();
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

    static {
        AppMethodBeat.i(77393);
        AppMethodBeat.o(77393);
    }

    public CircleProgressDrawable() {
        AppMethodBeat.i(77388);
        AppMethodBeat.o(77388);
    }

    public final void setStrokeColor(int i) {
        AppMethodBeat.i(77389);
        this.uV = i;
        invalidateSelf();
        AppMethodBeat.o(77389);
    }

    public final void stop() {
        AppMethodBeat.i(77391);
        Iterator it = this.uC.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).end();
        }
        AppMethodBeat.o(77391);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(77392);
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            AppMethodBeat.o(77392);
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
        canvas.rotate(this.jbC.nR);
        Canvas canvas2 = canvas;
        canvas2.drawArc(bRT, -90.0f + ((this.iTZ.vd + this.iTZ.vb) * 360.0f), 360.0f * (this.iTZ.vc - this.iTZ.vb), false, paint);
        canvas.restoreToCount(save);
        canvas.restoreToCount(save2);
        AppMethodBeat.o(77392);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }

    public final void start() {
        Object obj;
        AppMethodBeat.i(77390);
        Iterator it = this.uC.iterator();
        while (it.hasNext()) {
            if (((Animator) it.next()).isStarted()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            AppMethodBeat.o(77390);
            return;
        }
        it = this.uC.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).start();
        }
        invalidateSelf();
        AppMethodBeat.o(77390);
    }

    public final int getIntrinsicWidth() {
        return this.bRU;
    }

    public final int getIntrinsicHeight() {
        return this.bRU;
    }
}
