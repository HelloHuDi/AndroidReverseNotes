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

public final class me extends c {
    private final int height = 69;
    private final int width = 69;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 69;
            case 1:
                return 69;
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
                g = c.a(g, 1.0f, 0.0f, -66.0f, 0.0f, 1.0f, -459.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 465.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(3.0f);
                Path l = c.l(looper);
                l.moveTo(28.5f, 1.5f);
                l.cubicTo(43.41169f, 1.5f, 55.5f, 13.588311f, 55.5f, 28.5f);
                l.cubicTo(55.5f, 43.41169f, 43.41169f, 55.5f, 28.5f, 55.5f);
                l.cubicTo(13.588311f, 55.5f, 1.5f, 43.41169f, 1.5f, 28.5f);
                l.cubicTo(1.5f, 13.588311f, 13.588311f, 1.5f, 28.5f, 1.5f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-1);
                l = c.l(looper);
                l.moveTo(39.81111f, 30.250793f);
                l.lineTo(23.24421f, 39.717594f);
                l.lineTo(23.24421f, 39.717594f);
                l.cubicTo(22.524933f, 40.12861f, 21.60865f, 39.878716f, 21.197636f, 39.15944f);
                l.cubicTo(21.068123f, 38.932793f, 21.0f, 38.67627f, 21.0f, 38.41523f);
                l.lineTo(21.0f, 18.692726f);
                l.lineTo(21.0f, 18.692726f);
                l.cubicTo(21.0f, 17.8643f, 21.671574f, 17.192726f, 22.5f, 17.192726f);
                l.cubicTo(22.778942f, 17.192726f, 23.052357f, 17.270508f, 23.289532f, 17.41733f);
                l.lineTo(39.856434f, 27.67303f);
                l.lineTo(39.856434f, 27.67303f);
                l.cubicTo(40.560818f, 28.109077f, 40.778347f, 29.033579f, 40.3423f, 29.73796f);
                l.cubicTo(40.21073f, 29.950493f, 40.028137f, 30.126778f, 39.81111f, 30.250793f);
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
