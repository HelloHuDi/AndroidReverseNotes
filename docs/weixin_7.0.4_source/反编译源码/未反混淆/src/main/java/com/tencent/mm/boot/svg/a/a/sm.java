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

public final class sm extends c {
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
                a.setColor(-2565928);
                g = c.a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 13.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(18.11f, 25.83f);
                l.cubicTo(26.56f, 17.39f, 35.0f, 8.92f, 43.47f, 0.49f);
                l.cubicTo(44.61f, 1.63f, 45.83f, 2.71f, 46.84f, 3.98f);
                l.cubicTo(46.51f, 5.07f, 45.35f, 5.72f, 44.65f, 6.58f);
                l.cubicTo(35.76f, 15.37f, 26.97f, 24.25f, 18.11f, 33.07f);
                l.cubicTo(12.07f, 27.04f, 6.03f, 21.01f, 0.0f, 14.97f);
                l.cubicTo(1.21f, 13.76f, 2.42f, 12.56f, 3.62f, 11.35f);
                l.cubicTo(8.45f, 16.18f, 13.28f, 21.01f, 18.11f, 25.83f);
                l.lineTo(18.11f, 25.83f);
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
