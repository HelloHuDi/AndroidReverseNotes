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

public final class bcj extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 4.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 31.994999f);
                l.cubicTo(10.501568f, 21.323332f, 21.023138f, 10.661666f, 31.534706f, 0.0f);
                l.cubicTo(33.36498f, 1.830286f, 35.185253f, 3.6805751f, 36.99552f, 5.5308642f);
                l.cubicTo(29.674429f, 13.022035f, 22.323332f, 20.493202f, 15.002239f, 27.994373f);
                l.lineTo(67.0f, 27.994373f);
                l.lineTo(67.0f, 35.995625f);
                l.cubicTo(49.66741f, 35.995625f, 32.334827f, 35.985622f, 15.002239f, 36.005627f);
                l.cubicTo(22.333334f, 43.486794f, 29.664427f, 50.967964f, 37.005524f, 58.44913f);
                l.cubicTo(35.185253f, 60.299423f, 33.36498f, 62.14971f, 31.534706f, 64.0f);
                l.cubicTo(21.023138f, 53.32833f, 10.501568f, 42.666668f, 0.0f, 31.994999f);
                l.lineTo(0.0f, 31.994999f);
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
