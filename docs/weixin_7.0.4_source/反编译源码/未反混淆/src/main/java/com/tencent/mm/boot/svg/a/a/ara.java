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

public final class ara extends c {
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
                a.setColor(-1);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 10.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(50.0f, 100.0f);
                l.cubicTo(22.385763f, 100.0f, 0.0f, 77.614235f, 0.0f, 50.0f);
                l.cubicTo(0.0f, 22.385763f, 22.385763f, 0.0f, 50.0f, 0.0f);
                l.cubicTo(77.614235f, 0.0f, 100.0f, 22.385763f, 100.0f, 50.0f);
                l.cubicTo(100.0f, 77.614235f, 77.614235f, 100.0f, 50.0f, 100.0f);
                l.close();
                l.moveTo(50.0f, 94.0f);
                l.cubicTo(74.30053f, 94.0f, 94.0f, 74.30053f, 94.0f, 50.0f);
                l.cubicTo(94.0f, 25.69947f, 74.30053f, 6.0f, 50.0f, 6.0f);
                l.cubicTo(25.69947f, 6.0f, 6.0f, 25.69947f, 6.0f, 50.0f);
                l.cubicTo(6.0f, 74.30053f, 25.69947f, 94.0f, 50.0f, 94.0f);
                l.close();
                l.moveTo(54.24264f, 49.999996f);
                l.lineTo(69.79899f, 65.55635f);
                l.lineTo(65.55635f, 69.79899f);
                l.lineTo(50.0f, 54.242638f);
                l.lineTo(34.44365f, 69.79899f);
                l.lineTo(30.20101f, 65.55635f);
                l.lineTo(45.75736f, 49.999996f);
                l.lineTo(30.201012f, 34.44365f);
                l.lineTo(34.443653f, 30.20101f);
                l.lineTo(50.0f, 45.757355f);
                l.lineTo(65.55635f, 30.20101f);
                l.lineTo(69.79899f, 34.44365f);
                l.lineTo(54.24264f, 49.999996f);
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
