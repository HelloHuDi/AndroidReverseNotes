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

public final class ajf extends c {
    private final int height = 180;
    private final int width = 180;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                canvas.saveLayerAlpha(null, 126, 4);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 30.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 30.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-855310);
                a2.setStrokeWidth(4.0f);
                Path l = c.l(looper);
                l.moveTo(6.0097566f, 12.0f);
                l.cubicTo(3.7951674f, 12.0f, 2.0f, 13.792681f, 2.0f, 16.000319f);
                l.lineTo(2.0f, 54.999683f);
                l.cubicTo(2.0f, 57.20863f, 3.789142f, 59.0f, 5.991014f, 59.0f);
                l.lineTo(72.00899f, 59.0f);
                l.cubicTo(74.21183f, 59.0f, 76.0f, 57.208717f, 76.0f, 54.999683f);
                l.lineTo(76.0f, 16.000319f);
                l.cubicTo(76.0f, 13.79181f, 74.205315f, 12.0f, 71.99024f, 12.0f);
                l.lineTo(57.5f, 12.0f);
                l.lineTo(51.196438f, 3.5952492f);
                l.cubicTo(50.5825f, 2.7766662f, 49.029545f, 2.0f, 48.00891f, 2.0f);
                l.lineTo(29.99109f, 2.0f);
                l.cubicTo(28.967781f, 2.0f, 27.419127f, 2.7744992f, 26.803562f, 3.5952492f);
                l.lineTo(20.5f, 12.0f);
                l.lineTo(6.0097566f, 12.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(k, looper);
                a3.setColor(-855310);
                Path l2 = c.l(looper);
                l2.moveTo(6.0f, 2.0f);
                l2.lineTo(16.0f, 2.0f);
                l2.lineTo(16.0f, 6.0f);
                l2.lineTo(6.0f, 6.0f);
                l2.lineTo(6.0f, 2.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-855310);
                l = c.l(looper);
                l.moveTo(21.0f, 33.0f);
                l.lineTo(15.0f, 33.0f);
                l.lineTo(23.25f, 24.75f);
                l.lineTo(31.5f, 33.0f);
                l.lineTo(25.0f, 33.0f);
                l.cubicTo(25.0f, 40.731987f, 31.268013f, 47.0f, 39.0f, 47.0f);
                l.cubicTo(42.931446f, 47.0f, 46.484406f, 45.379486f, 49.027344f, 42.769985f);
                l.lineTo(51.855957f, 45.598595f);
                l.cubicTo(48.588997f, 48.93187f, 44.03602f, 51.0f, 39.0f, 51.0f);
                l.cubicTo(29.058874f, 51.0f, 21.0f, 42.941124f, 21.0f, 33.0f);
                l.close();
                l.moveTo(57.0f, 33.0f);
                l.lineTo(63.0f, 33.0f);
                l.lineTo(54.75f, 41.25f);
                l.lineTo(46.5f, 33.0f);
                l.lineTo(53.0f, 33.0f);
                l.cubicTo(53.0f, 25.268013f, 46.731987f, 19.0f, 39.0f, 19.0f);
                l.cubicTo(35.068554f, 19.0f, 31.515596f, 20.620514f, 28.972656f, 23.230017f);
                l.lineTo(26.144045f, 20.401403f);
                l.cubicTo(29.411005f, 17.068129f, 33.96398f, 15.0f, 39.0f, 15.0f);
                l.cubicTo(48.941124f, 15.0f, 57.0f, 23.058874f, 57.0f, 33.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
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
