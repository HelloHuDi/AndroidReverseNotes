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

public final class agw extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                Paint a = c.a(k, looper);
                a.setColor(-855310);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 30.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(4.0f, 56.998116f);
                l.cubicTo(4.0f, 56.9978f, 73.99772f, 57.0f, 73.99772f, 57.0f);
                l.cubicTo(74.00232f, 57.0f, 74.0f, 14.001884f, 74.0f, 14.001884f);
                l.cubicTo(74.0f, 14.004772f, 56.5f, 14.0f, 56.5f, 14.0f);
                l.lineTo(49.0f, 4.0f);
                l.lineTo(29.0f, 4.0f);
                l.lineTo(21.5f, 14.0f);
                l.lineTo(3.999805f, 14.0f);
                l.cubicTo(3.9999309f, 14.00048f, 4.0f, 56.998116f, 4.0f, 56.998116f);
                l.close();
                l.moveTo(3.993171f, 10.0f);
                l.lineTo(19.5f, 10.0f);
                l.lineTo(27.0f, 0.0f);
                l.lineTo(51.0f, 0.0f);
                l.lineTo(58.5f, 10.0f);
                l.lineTo(74.00683f, 10.0f);
                l.cubicTo(76.20044f, 10.0f, 78.0f, 11.791705f, 78.0f, 14.001884f);
                l.lineTo(78.0f, 56.998116f);
                l.cubicTo(78.0f, 59.214787f, 76.20812f, 61.0f, 73.99772f, 61.0f);
                l.lineTo(4.002278f, 61.0f);
                l.cubicTo(1.7944237f, 61.0f, 0.0f, 59.208294f, 0.0f, 56.998116f);
                l.lineTo(0.0f, 14.001884f);
                l.cubicTo(0.0f, 11.785213f, 1.7878035f, 10.0f, 3.993171f, 10.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(21.0f, 33.0f);
                l.cubicTo(21.0f, 42.941124f, 29.058874f, 51.0f, 39.0f, 51.0f);
                l.cubicTo(44.03602f, 51.0f, 48.588997f, 48.93187f, 51.855957f, 45.598595f);
                l.lineTo(49.027344f, 42.769985f);
                l.cubicTo(46.484406f, 45.379486f, 42.931446f, 47.0f, 39.0f, 47.0f);
                l.cubicTo(31.268013f, 47.0f, 25.0f, 40.731987f, 25.0f, 33.0f);
                l.lineTo(30.5f, 33.0f);
                l.lineTo(22.5f, 25.0f);
                l.lineTo(14.5f, 33.0f);
                l.lineTo(21.0f, 33.0f);
                l.close();
                l.moveTo(57.0f, 33.0f);
                l.cubicTo(57.0f, 23.058874f, 48.941124f, 15.0f, 39.0f, 15.0f);
                l.cubicTo(33.96398f, 15.0f, 29.411005f, 17.068129f, 26.144045f, 20.401403f);
                l.lineTo(28.972656f, 23.230017f);
                l.cubicTo(31.515596f, 20.620514f, 35.068554f, 19.0f, 39.0f, 19.0f);
                l.cubicTo(46.731987f, 19.0f, 53.0f, 25.268013f, 53.0f, 33.0f);
                l.lineTo(47.5f, 33.0f);
                l.lineTo(55.5f, 41.0f);
                l.lineTo(63.5f, 33.0f);
                l.lineTo(57.0f, 33.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
