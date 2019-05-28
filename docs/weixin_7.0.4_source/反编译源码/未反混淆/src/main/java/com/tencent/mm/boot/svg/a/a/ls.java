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

public final class ls extends c {
    private final int height = 28;
    private final int width = 36;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 28;
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
                k = c.a(k2, looper);
                k.setStrokeWidth(1.0f);
                k.setStrokeCap(Cap.ROUND);
                k.setStrokeJoin(Join.MITER);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-10258787);
                a.setStrokeWidth(2.0f);
                g = c.a(g, 1.0f, 0.0f, -573.0f, 0.0f, 1.0f, -727.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 140.0f, 0.0f, 1.0f, 722.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                float[] a2 = c.a(g, 1.0f, 0.0f, 434.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(4.5945945f, 13.324325f);
                l.cubicTo(4.5945945f, 6.4324327f, 10.2f, 0.827027f, 17.091892f, 0.827027f);
                l.cubicTo(21.962162f, 0.827027f, 26.18919f, 3.5837839f, 28.302702f, 7.718919f);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(10.383783f, 9.372973f);
                l2.lineTo(4.5945945f, 13.324325f);
                l2.lineTo(0.64324325f, 7.5351353f);
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.save();
                g = c.a(a2, 1.0f, 0.0f, 5.513514f, 0.0f, 1.0f, 12.864865f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a5 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(24.075676f, 0.0f);
                l.cubicTo(24.075676f, 6.891892f, 18.47027f, 12.497297f, 11.578379f, 12.497297f);
                l.cubicTo(6.708108f, 12.497297f, 2.3891892f, 9.648648f, 0.36756757f, 5.5135136f);
                canvas.drawPath(l, a5);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                l2 = c.l(looper);
                l2.moveTo(18.194595f, 3.9513514f);
                l2.lineTo(24.075676f, 0.0f);
                l2.lineTo(28.027027f, 5.881081f);
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a4);
                canvas.restore();
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
