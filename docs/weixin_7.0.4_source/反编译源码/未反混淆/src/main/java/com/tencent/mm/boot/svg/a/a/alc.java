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

public final class alc extends c {
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -166.0f, 0.0f, 1.0f, -265.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 166.0f, 0.0f, 1.0f, 265.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a2 = c.a(k, looper);
                a2.setColor(838860800);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(45.0f, 0.0f);
                l.cubicTo(69.85281f, 0.0f, 90.0f, 20.147184f, 90.0f, 45.0f);
                l.cubicTo(90.0f, 69.85281f, 69.85281f, 90.0f, 45.0f, 90.0f);
                l.cubicTo(20.147184f, 90.0f, 0.0f, 69.85281f, 0.0f, 45.0f);
                l.cubicTo(0.0f, 20.147184f, 20.147184f, 0.0f, 45.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-1);
                a3.setStrokeWidth(6.0f);
                l = c.l(looper);
                l.moveTo(45.0f, 3.0f);
                l.cubicTo(68.19596f, 3.0f, 87.0f, 21.804039f, 87.0f, 45.0f);
                l.cubicTo(87.0f, 68.19596f, 68.19596f, 87.0f, 45.0f, 87.0f);
                l.cubicTo(21.804039f, 87.0f, 3.0f, 68.19596f, 3.0f, 45.0f);
                l.cubicTo(3.0f, 21.804039f, 21.804039f, 3.0f, 45.0f, 3.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                a3.setColor(-1);
                l = c.l(looper);
                l.moveTo(57.0f, 42.0f);
                l.lineTo(63.43934f, 35.56066f);
                l.cubicTo(64.02512f, 34.974873f, 64.97488f, 34.974873f, 65.56066f, 35.56066f);
                l.cubicTo(65.841965f, 35.841965f, 66.0f, 36.223495f, 66.0f, 36.62132f);
                l.lineTo(66.0f, 53.37868f);
                l.cubicTo(66.0f, 54.207108f, 65.32843f, 54.87868f, 64.5f, 54.87868f);
                l.cubicTo(64.10217f, 54.87868f, 63.720646f, 54.720646f, 63.43934f, 54.43934f);
                l.lineTo(57.0f, 48.0f);
                l.lineTo(57.0f, 42.0f);
                l.close();
                l.moveTo(26.208f, 33.0f);
                l.lineTo(51.792f, 33.0f);
                l.cubicTo(53.011444f, 33.0f, 54.0f, 33.988556f, 54.0f, 35.208f);
                l.lineTo(54.0f, 54.792f);
                l.cubicTo(54.0f, 56.011444f, 53.011444f, 57.0f, 51.792f, 57.0f);
                l.lineTo(26.208f, 57.0f);
                l.cubicTo(24.988556f, 57.0f, 24.0f, 56.011444f, 24.0f, 54.792f);
                l.lineTo(24.0f, 35.208f);
                l.cubicTo(24.0f, 33.988556f, 24.988556f, 33.0f, 26.208f, 33.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
