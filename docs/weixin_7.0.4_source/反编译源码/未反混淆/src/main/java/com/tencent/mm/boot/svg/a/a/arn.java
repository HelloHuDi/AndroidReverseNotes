package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class arn extends c {
    private final int height = 138;
    private final int width = 138;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 138;
            case 1:
                return 138;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -283.0f, 0.0f, 1.0f, -245.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                float[] a2 = c.a(g, 1.0f, 0.0f, 283.0f, 0.0f, 1.0f, 245.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                Paint a3 = c.a(k, looper);
                a3.setColor(-13917627);
                canvas.save();
                Paint a4 = c.a(a3, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 6.0f);
                l.cubicTo(0.0f, 2.6862912f, 2.6862912f, 0.0f, 6.0f, 0.0f);
                l.lineTo(132.0f, 0.0f);
                l.cubicTo(135.3137f, 0.0f, 138.0f, 2.6862912f, 138.0f, 6.0f);
                l.lineTo(138.0f, 132.0f);
                l.cubicTo(138.0f, 135.3137f, 135.3137f, 138.0f, 132.0f, 138.0f);
                l.lineTo(6.0f, 138.0f);
                l.cubicTo(2.6862912f, 138.0f, 0.0f, 135.3137f, 0.0f, 132.0f);
                l.lineTo(0.0f, 6.0f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                g = c.a(a2, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 36.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a5 = c.a(a, looper);
                a5.setColor(-1);
                a5.setStrokeWidth(6.0f);
                l = c.l(looper);
                l.moveTo(23.239437f, 34.394367f);
                l.cubicTo(27.35964f, 40.93951f, 20.518991f, 43.903023f, 17.661972f, 45.549297f);
                l.cubicTo(5.370789f, 52.541847f, 0.0f, 55.160763f, 0.0f, 58.56338f);
                l.lineTo(0.0f, 63.21127f);
                l.cubicTo(0.0f, 64.70552f, 1.1176436f, 66.0f, 2.7887323f, 66.0f);
                l.lineTo(63.21127f, 66.0f);
                l.cubicTo(64.882355f, 66.0f, 66.0f, 64.70552f, 66.0f, 63.21127f);
                l.lineTo(66.0f, 58.56338f);
                l.cubicTo(66.0f, 55.160763f, 60.62921f, 52.541847f, 48.338028f, 45.549297f);
                l.cubicTo(45.481007f, 43.903023f, 38.64036f, 40.93951f, 42.760563f, 34.394367f);
                l.cubicTo(46.419594f, 28.960619f, 49.2747f, 26.747225f, 49.267605f, 17.661972f);
                l.cubicTo(49.2747f, 9.037081f, 42.896458f, 0.0f, 33.46479f, 0.0f);
                l.cubicTo(23.103542f, 0.0f, 16.7253f, 9.037081f, 16.732395f, 17.661972f);
                l.cubicTo(16.7253f, 26.747225f, 19.580408f, 28.960619f, 23.239437f, 34.394367f);
                l.close();
                canvas.drawPath(l, a5);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                a3.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(69.0f, 30.0f);
                l2.lineTo(61.5f, 30.0f);
                l2.lineTo(61.5f, 34.5f);
                l2.lineTo(69.0f, 34.5f);
                l2.lineTo(69.0f, 42.0f);
                l2.lineTo(73.5f, 42.0f);
                l2.lineTo(73.5f, 34.5f);
                l2.lineTo(81.0f, 34.5f);
                l2.lineTo(81.0f, 30.0f);
                l2.lineTo(73.5f, 30.0f);
                l2.lineTo(73.5f, 22.5f);
                l2.lineTo(69.0f, 22.5f);
                l2.lineTo(69.0f, 30.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
