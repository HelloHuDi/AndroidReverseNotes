package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aro */
public final class aro extends C5163c {
    private final int height = 78;
    private final int width = 78;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 78;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, -223.0f, 0.0f, 1.0f, -237.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 223.0f, 0.0f, 1.0f, 237.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-11184811);
                a2.setStrokeWidth(3.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2.9959373f, 0.0f);
                l.cubicTo(1.3413268f, 0.0f, 0.0f, 1.3424077f, 0.0f, 3.002084f);
                l.lineTo(0.0f, 68.99792f);
                l.cubicTo(0.0f, 70.65592f, 1.3373097f, 72.0f, 2.9959373f, 72.0f);
                l.lineTo(57.004063f, 72.0f);
                l.cubicTo(58.658672f, 72.0f, 60.0f, 70.65759f, 60.0f, 68.99792f);
                l.lineTo(60.0f, 3.002084f);
                l.cubicTo(60.0f, 1.3440788f, 58.66269f, 0.0f, 57.004063f, 0.0f);
                l.lineTo(2.9959373f, 0.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                a3.setColor(-11184811);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(8.0f, 27.0f);
                l2.lineTo(40.0f, 27.0f);
                l2.lineTo(40.0f, 30.0f);
                l2.lineTo(8.0f, 30.0f);
                l2.lineTo(8.0f, 27.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-11184811);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(8.0f, 36.0f);
                l2.lineTo(25.0f, 36.0f);
                l2.lineTo(25.0f, 39.0f);
                l2.lineTo(8.0f, 39.0f);
                l2.lineTo(8.0f, 36.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-11184811);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(8.0f, 45.0f);
                l2.lineTo(28.0f, 45.0f);
                l2.lineTo(28.0f, 48.0f);
                l2.lineTo(8.0f, 48.0f);
                l2.lineTo(8.0f, 45.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-11184811);
                a2.setStrokeWidth(3.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(14.0f, 8.0f);
                l.cubicTo(17.31371f, 8.0f, 20.0f, 10.686291f, 20.0f, 14.0f);
                l.cubicTo(20.0f, 17.31371f, 17.31371f, 20.0f, 14.0f, 20.0f);
                l.cubicTo(10.686291f, 20.0f, 8.0f, 17.31371f, 8.0f, 14.0f);
                l.cubicTo(8.0f, 10.686291f, 10.686291f, 8.0f, 14.0f, 8.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
