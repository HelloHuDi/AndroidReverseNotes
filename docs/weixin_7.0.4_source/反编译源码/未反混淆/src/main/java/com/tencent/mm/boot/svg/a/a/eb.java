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

public final class eb extends c {
    private final int height = 58;
    private final int width = 58;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 58;
            case 1:
                return 58;
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
                g = c.a(g, 1.0f, 0.0f, -58.0f, 0.0f, 1.0f, -148.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 148.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(29.0f, 58.0f);
                l.cubicTo(45.01626f, 58.0f, 58.0f, 45.01626f, 58.0f, 29.0f);
                l.cubicTo(58.0f, 12.983743f, 45.01626f, 0.0f, 29.0f, 0.0f);
                l.cubicTo(12.983743f, 0.0f, 0.0f, 12.983743f, 0.0f, 29.0f);
                l.cubicTo(0.0f, 45.01626f, 12.983743f, 58.0f, 29.0f, 58.0f);
                l.close();
                l.moveTo(29.0f, 52.0f);
                l.cubicTo(41.70255f, 52.0f, 52.0f, 41.70255f, 52.0f, 29.0f);
                l.cubicTo(52.0f, 16.297451f, 41.70255f, 6.0f, 29.0f, 6.0f);
                l.cubicTo(16.297451f, 6.0f, 6.0f, 16.297451f, 6.0f, 29.0f);
                l.cubicTo(6.0f, 41.70255f, 16.297451f, 52.0f, 29.0f, 52.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(29.974895f, 27.246653f);
                l.lineTo(29.217737f, 14.251846f);
                l.cubicTo(29.19401f, 13.844625f, 28.835377f, 13.5f, 28.417751f, 13.5f);
                l.lineTo(27.1628f, 13.5f);
                l.cubicTo(26.745947f, 13.5f, 26.387007f, 13.836613f, 26.362814f, 14.251846f);
                l.lineTo(25.53224f, 28.506634f);
                l.cubicTo(25.501184f, 29.039612f, 25.755342f, 29.50647f, 26.163542f, 29.770678f);
                l.cubicTo(26.252584f, 30.036236f, 26.42348f, 30.280165f, 26.672367f, 30.466492f);
                l.lineTo(39.0047f, 39.69901f);
                l.cubicTo(39.340405f, 39.950333f, 39.827724f, 39.897633f, 40.089073f, 39.58617f);
                l.lineTo(40.949707f, 38.56051f);
                l.cubicTo(41.212883f, 38.24687f, 41.180317f, 37.76185f, 40.872528f, 37.47302f);
                l.lineTo(29.974895f, 27.246653f);
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
