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

public final class aqe extends c {
    private final int height = 60;
    private final int width = 60;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, -218.0f, 0.0f, 1.0f, -141.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 218.0f, 0.0f, 1.0f, 141.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(60.0f, 0.0f);
                l.lineTo(60.0f, 60.0f);
                l.lineTo(0.0f, 60.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-15028967);
                l = c.l(looper);
                l.moveTo(30.0f, 16.0f);
                l.cubicTo(22.16f, 16.0f, 16.0f, 22.16f, 16.0f, 30.0f);
                l.cubicTo(16.0f, 37.84f, 22.16f, 44.0f, 30.0f, 44.0f);
                l.cubicTo(37.84f, 44.0f, 44.0f, 37.84f, 44.0f, 30.0f);
                l.cubicTo(44.0f, 22.16f, 37.84f, 16.0f, 30.0f, 16.0f);
                l.lineTo(30.0f, 16.0f);
                l.close();
                l.moveTo(30.0f, 6.0f);
                l.cubicTo(16.8f, 6.0f, 6.0f, 16.8f, 6.0f, 30.0f);
                l.cubicTo(6.0f, 43.2f, 16.8f, 54.0f, 30.0f, 54.0f);
                l.cubicTo(43.2f, 54.0f, 54.0f, 43.2f, 54.0f, 30.0f);
                l.cubicTo(54.0f, 16.8f, 43.2f, 6.0f, 30.0f, 6.0f);
                l.lineTo(30.0f, 6.0f);
                l.close();
                l.moveTo(10.0f, 30.0f);
                l.cubicTo(10.0f, 19.0f, 19.0f, 10.0f, 30.0f, 10.0f);
                l.cubicTo(41.0f, 10.0f, 50.0f, 19.0f, 50.0f, 30.0f);
                l.cubicTo(50.0f, 41.0f, 41.0f, 50.0f, 30.0f, 50.0f);
                l.cubicTo(19.0f, 50.0f, 10.0f, 41.0f, 10.0f, 30.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
