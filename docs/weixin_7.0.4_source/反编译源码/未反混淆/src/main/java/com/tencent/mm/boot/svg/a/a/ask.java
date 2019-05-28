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

public final class ask extends c {
    private final int height = 128;
    private final int width = 128;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 128;
            case 1:
                return 128;
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
                a.setColor(-5658199);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 17.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(8.006973f, 18.0f);
                l.cubicTo(3.584844f, 18.0f, 0.0f, 21.589066f, 0.0f, 26.007586f);
                l.lineTo(0.0f, 85.99242f);
                l.cubicTo(0.0f, 90.41488f, 3.5907528f, 94.0f, 8.006973f, 94.0f);
                l.lineTo(119.99303f, 94.0f);
                l.cubicTo(124.41515f, 94.0f, 128.0f, 90.410934f, 128.0f, 85.99242f);
                l.lineTo(128.0f, 26.007586f);
                l.cubicTo(128.0f, 21.58512f, 124.40925f, 18.0f, 119.99303f, 18.0f);
                l.lineTo(8.006973f, 18.0f);
                l.close();
                l.moveTo(51.428135f, 0.0f);
                l.lineTo(64.0f, 0.0f);
                l.lineTo(64.0f, 18.0f);
                l.lineTo(26.375288f, 18.0f);
                l.cubicTo(36.35272f, 18.0f, 41.71253f, 0.0f, 51.428135f, 0.0f);
                l.close();
                l.moveTo(76.5697f, 0.0f);
                l.lineTo(64.0f, 0.0f);
                l.lineTo(64.0f, 18.0f);
                l.lineTo(101.62471f, 18.0f);
                l.cubicTo(91.647285f, 18.0f, 86.28747f, 0.0f, 76.5697f, 0.0f);
                l.close();
                l.moveTo(93.0f, 53.0f);
                l.cubicTo(93.0f, 69.01692f, 80.01692f, 82.0f, 64.0f, 82.0f);
                l.cubicTo(47.983078f, 82.0f, 35.0f, 69.01692f, 35.0f, 53.0f);
                l.cubicTo(35.0f, 36.983078f, 47.983078f, 24.0f, 64.0f, 24.0f);
                l.cubicTo(80.01692f, 24.0f, 93.0f, 36.983078f, 93.0f, 53.0f);
                l.close();
                l.moveTo(84.0f, 53.0f);
                l.cubicTo(84.0f, 64.046f, 75.046f, 73.0f, 64.0f, 73.0f);
                l.cubicTo(52.954f, 73.0f, 44.0f, 64.046f, 44.0f, 53.0f);
                l.cubicTo(44.0f, 41.954f, 52.954f, 33.0f, 64.0f, 33.0f);
                l.cubicTo(75.046f, 33.0f, 84.0f, 41.954f, 84.0f, 53.0f);
                l.close();
                l.moveTo(6.4545455f, 6.4315085f);
                l.lineTo(24.454546f, 6.4315085f);
                l.lineTo(24.454546f, 12.431508f);
                l.lineTo(6.4545455f, 12.431508f);
                l.lineTo(6.4545455f, 6.4315085f);
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
