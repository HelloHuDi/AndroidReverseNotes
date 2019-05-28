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

public final class ln extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(37.073338f, 3.6f);
                l.lineTo(22.926662f, 3.6f);
                l.lineTo(16.926662f, 12.6f);
                l.lineTo(3.6f, 12.6f);
                l.lineTo(3.6f, 44.4f);
                l.lineTo(56.4f, 44.4f);
                l.lineTo(56.4f, 12.6f);
                l.lineTo(43.073338f, 12.6f);
                l.lineTo(37.073338f, 3.6f);
                l.close();
                l.moveTo(38.197224f, 0.0f);
                l.cubicTo(38.698753f, 1.3322676E-15f, 39.167103f, 0.25065172f, 39.4453f, 0.6679497f);
                l.lineTo(45.0f, 9.0f);
                l.lineTo(57.0f, 9.0f);
                l.cubicTo(58.656853f, 9.0f, 60.0f, 10.343145f, 60.0f, 12.0f);
                l.lineTo(60.0f, 45.0f);
                l.cubicTo(60.0f, 46.656853f, 58.656853f, 48.0f, 57.0f, 48.0f);
                l.lineTo(3.0f, 48.0f);
                l.cubicTo(1.3431457f, 48.0f, 0.0f, 46.656853f, 0.0f, 45.0f);
                l.lineTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 10.343145f, 1.3431457f, 9.0f, 3.0f, 9.0f);
                l.lineTo(15.0f, 9.0f);
                l.lineTo(20.5547f, 0.6679497f);
                l.cubicTo(20.8329f, 0.25065172f, 21.301247f, 2.6645353E-15f, 21.802776f, 2.6645353E-15f);
                l.lineTo(38.197224f, 0.0f);
                l.close();
                l.moveTo(30.0f, 35.4f);
                l.cubicTo(34.63919f, 35.4f, 38.4f, 31.639193f, 38.4f, 27.0f);
                l.cubicTo(38.4f, 22.360807f, 34.63919f, 18.6f, 30.0f, 18.6f);
                l.cubicTo(25.360807f, 18.6f, 21.6f, 22.360807f, 21.6f, 27.0f);
                l.cubicTo(21.6f, 31.639193f, 25.360807f, 35.4f, 30.0f, 35.4f);
                l.close();
                l.moveTo(30.0f, 39.0f);
                l.cubicTo(23.372583f, 39.0f, 18.0f, 33.62742f, 18.0f, 27.0f);
                l.cubicTo(18.0f, 20.372583f, 23.372583f, 15.0f, 30.0f, 15.0f);
                l.cubicTo(36.62742f, 15.0f, 42.0f, 20.372583f, 42.0f, 27.0f);
                l.cubicTo(42.0f, 33.62742f, 36.62742f, 39.0f, 30.0f, 39.0f);
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
