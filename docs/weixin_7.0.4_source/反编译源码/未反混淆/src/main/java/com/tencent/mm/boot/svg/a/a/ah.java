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

public final class ah extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g = c.a(g, 1.0f, 0.0f, -245.0f, 0.0f, 1.0f, -283.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 245.0f, 0.0f, 1.0f, 283.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(2113929216);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(90.0f, 0.0f);
                l.lineTo(90.0f, 90.0f);
                l.lineTo(0.0f, 90.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(45.0f, 27.0f);
                l2.cubicTo(47.761425f, 27.0f, 50.0f, 24.761423f, 50.0f, 22.0f);
                l2.cubicTo(50.0f, 19.238577f, 47.761425f, 17.0f, 45.0f, 17.0f);
                l2.cubicTo(42.238575f, 17.0f, 40.0f, 19.238577f, 40.0f, 22.0f);
                l2.cubicTo(40.0f, 24.761423f, 42.238575f, 27.0f, 45.0f, 27.0f);
                l2.close();
                l2.moveTo(45.0f, 50.0f);
                l2.cubicTo(47.761425f, 50.0f, 50.0f, 47.761425f, 50.0f, 45.0f);
                l2.cubicTo(50.0f, 42.238575f, 47.761425f, 40.0f, 45.0f, 40.0f);
                l2.cubicTo(42.238575f, 40.0f, 40.0f, 42.238575f, 40.0f, 45.0f);
                l2.cubicTo(40.0f, 47.761425f, 42.238575f, 50.0f, 45.0f, 50.0f);
                l2.close();
                l2.moveTo(45.0f, 73.0f);
                l2.cubicTo(47.761425f, 73.0f, 50.0f, 70.76142f, 50.0f, 68.0f);
                l2.cubicTo(50.0f, 65.23858f, 47.761425f, 63.0f, 45.0f, 63.0f);
                l2.cubicTo(42.238575f, 63.0f, 40.0f, 65.23858f, 40.0f, 68.0f);
                l2.cubicTo(40.0f, 70.76142f, 42.238575f, 73.0f, 45.0f, 73.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
