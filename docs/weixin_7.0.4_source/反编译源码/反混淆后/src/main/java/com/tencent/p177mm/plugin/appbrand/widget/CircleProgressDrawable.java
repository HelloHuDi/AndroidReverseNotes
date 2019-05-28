package com.tencent.p177mm.plugin.appbrand.widget;

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
import android.support.p057v4.view.p068b.C41516f;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable */
public final class CircleProgressDrawable extends Drawable {
    private static final RectF bRS = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF bRT = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private int bRU = Math.round(C4996ah.getResources().getDisplayMetrics().density * 48.0f);
    private int bRV = 4;
    private boolean bRW = false;
    private int bRX = 0;
    public RingPathTransform iTZ = new RingPathTransform();
    public RingRotation jbC = new RingRotation();
    private Paint mPaint;
    /* renamed from: uC */
    public ArrayList<Animator> f1251uC = new ArrayList();
    /* renamed from: uV */
    private int f1252uV = WebView.NIGHT_MODE_COLOR;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable$b */
    public static class C2510b {
        public static final Interpolator iUa = C41516f.m72499c(iUb);
        private static final Path iUb;

        static {
            AppMethodBeat.m2504i(77386);
            Path path = new Path();
            iUb = path;
            path.cubicTo(0.2f, 0.0f, 0.1f, 1.0f, 0.5f, 1.0f);
            iUb.lineTo(1.0f, 1.0f);
            AppMethodBeat.m2505o(77386);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable$c */
    public static class C2511c {
        public static final Interpolator iUa = C41516f.m72499c(iUc);
        private static final Path iUc;

        static {
            AppMethodBeat.m2504i(77387);
            Path path = new Path();
            iUc = path;
            path.lineTo(0.5f, 0.0f);
            iUc.cubicTo(0.7f, 0.0f, 0.6f, 1.0f, 1.0f, 1.0f);
            AppMethodBeat.m2505o(77387);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable$a */
    public static class C2512a {
        public static final Interpolator iUa = new LinearInterpolator();

        static {
            AppMethodBeat.m2504i(77385);
            AppMethodBeat.m2505o(77385);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable$RingRotation */
    static class RingRotation {
        /* renamed from: nR */
        private float f1253nR;

        private RingRotation() {
        }

        /* synthetic */ RingRotation(byte b) {
            this();
        }

        @Keep
        public void setRotation(float f) {
            this.f1253nR = f;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable$RingPathTransform */
    static class RingPathTransform {
        /* renamed from: vb */
        public float f1254vb;
        /* renamed from: vc */
        public float f1255vc;
        /* renamed from: vd */
        public float f1256vd;

        private RingPathTransform() {
            this.f1254vb = 0.0f;
            this.f1255vc = 0.0f;
            this.f1256vd = 0.0f;
        }

        /* synthetic */ RingPathTransform(byte b) {
            this();
        }

        @Keep
        public void setTrimPathStart(float f) {
            this.f1254vb = f;
        }

        @Keep
        public void setTrimPathEnd(float f) {
            this.f1255vc = f;
        }

        @Keep
        public void setTrimPathOffset(float f) {
            this.f1256vd = f;
        }
    }

    static {
        AppMethodBeat.m2504i(77393);
        AppMethodBeat.m2505o(77393);
    }

    public CircleProgressDrawable() {
        AppMethodBeat.m2504i(77388);
        AppMethodBeat.m2505o(77388);
    }

    public final void setStrokeColor(int i) {
        AppMethodBeat.m2504i(77389);
        this.f1252uV = i;
        invalidateSelf();
        AppMethodBeat.m2505o(77389);
    }

    public final void stop() {
        AppMethodBeat.m2504i(77391);
        Iterator it = this.f1251uC.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).end();
        }
        AppMethodBeat.m2505o(77391);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(77392);
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            AppMethodBeat.m2505o(77392);
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
        paint.setColor(this.f1252uV);
        canvas.rotate(this.jbC.f1253nR);
        Canvas canvas2 = canvas;
        canvas2.drawArc(bRT, -90.0f + ((this.iTZ.f1256vd + this.iTZ.f1254vb) * 360.0f), 360.0f * (this.iTZ.f1255vc - this.iTZ.f1254vb), false, paint);
        canvas.restoreToCount(save);
        canvas.restoreToCount(save2);
        AppMethodBeat.m2505o(77392);
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
        AppMethodBeat.m2504i(77390);
        Iterator it = this.f1251uC.iterator();
        while (it.hasNext()) {
            if (((Animator) it.next()).isStarted()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            AppMethodBeat.m2505o(77390);
            return;
        }
        it = this.f1251uC.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).start();
        }
        invalidateSelf();
        AppMethodBeat.m2505o(77390);
    }

    public final int getIntrinsicWidth() {
        return this.bRU;
    }

    public final int getIntrinsicHeight() {
        return this.bRU;
    }
}
