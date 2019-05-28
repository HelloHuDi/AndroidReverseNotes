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
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.th */
public final class C41869th extends C5163c {
    private final int height = 70;
    private final int width = 70;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 70;
            case 1:
                return 70;
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
                canvas.saveLayerAlpha(null, ErrorCode.NEEDDOWNLOAD_FALSE_2, 4);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, -145.0f, 0.0f, 1.0f, -231.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 144.0f, 0.0f, 1.0f, 230.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-5526613);
                a2.setStrokeWidth(3.6f);
                a2.setStrokeCap(Cap.ROUND);
                a2.setStrokeJoin(Join.MITER);
                Path l = C5163c.m7884l(looper);
                l.moveTo(33.0f, 27.0f);
                l.lineTo(33.0f, 36.0f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                a3.setColor(-5526613);
                a3.setStrokeWidth(3.0f);
                a3.setStrokeCap(Cap.ROUND);
                a3.setStrokeJoin(Join.MITER);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(24.0f, 42.0f);
                l2.cubicTo(26.185297f, 43.986816f, 29.185297f, 44.980225f, 33.0f, 44.980225f);
                l2.cubicTo(36.8147f, 44.980225f, 39.8147f, 43.986816f, 42.0f, 42.0f);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-5526613);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(21.0f, 21.0f);
                l2.cubicTo(22.656855f, 21.0f, 24.0f, 22.343145f, 24.0f, 24.0f);
                l2.cubicTo(24.0f, 25.656855f, 22.656855f, 27.0f, 21.0f, 27.0f);
                l2.cubicTo(19.343145f, 27.0f, 18.0f, 25.656855f, 18.0f, 24.0f);
                l2.cubicTo(18.0f, 22.343145f, 19.343145f, 21.0f, 21.0f, 21.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-5526613);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(45.0f, 21.0f);
                l2.cubicTo(46.656853f, 21.0f, 48.0f, 22.343145f, 48.0f, 24.0f);
                l2.cubicTo(48.0f, 25.656855f, 46.656853f, 27.0f, 45.0f, 27.0f);
                l2.cubicTo(43.343147f, 27.0f, 42.0f, 25.656855f, 42.0f, 24.0f);
                l2.cubicTo(42.0f, 22.343145f, 43.343147f, 21.0f, 45.0f, 21.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                a3.setColor(-5526613);
                a3.setStrokeWidth(3.6f);
                a3.setStrokeCap(Cap.ROUND);
                a3.setStrokeJoin(Join.MITER);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(0.0f, 18.0f);
                l2.lineTo(0.0f, 9.0f);
                l2.cubicTo(-6.661338E-16f, 4.029437f, 4.029437f, 6.661338E-16f, 9.0f, 0.0f);
                l2.cubicTo(13.0476885f, 0.0f, 15.976155f, 0.0f, 18.0f, 0.0f);
                l2.moveTo(48.0f, 0.0f);
                l2.cubicTo(49.891644f, 0.0f, 52.935345f, 0.0f, 57.0f, 0.0f);
                l2.cubicTo(61.970562f, -9.992007E-16f, 66.0f, 4.029437f, 66.0f, 9.0f);
                l2.cubicTo(66.0f, 13.024577f, 66.0f, 15.987712f, 66.0f, 18.0f);
                l2.moveTo(66.0f, 48.0f);
                l2.cubicTo(66.0f, 49.88775f, 66.0f, 52.944878f, 66.0f, 57.0f);
                l2.cubicTo(66.0f, 61.970562f, 61.970562f, 66.0f, 57.0f, 66.0f);
                l2.cubicTo(52.98454f, 66.0f, 50.007732f, 66.0f, 48.0f, 66.0f);
                l2.moveTo(18.0f, 66.0f);
                l2.cubicTo(16.081131f, 66.0f, 13.127518f, 66.0f, 9.0f, 66.0f);
                l2.cubicTo(4.029437f, 66.0f, 6.661338E-16f, 61.970562f, 0.0f, 57.0f);
                l2.lineTo(0.0f, 48.0f);
                canvas.drawPath(l2, a3);
                canvas.restore();
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
