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

public final class nm extends c {
    private final int height = 42;
    private final int width = 42;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-5066062);
                a2.setStrokeWidth(3.1751997f);
                Path l = c.l(looper);
                l.moveTo(1.5875999f, 2.1751997f);
                l.cubicTo(1.5875999f, 1.2983925f, 2.2983925f, 0.5875999f, 3.1751997f, 0.5875999f);
                l.lineTo(38.8248f, 0.5875999f);
                l.cubicTo(39.701607f, 0.5875999f, 40.4124f, 1.2983925f, 40.4124f, 2.1751997f);
                l.lineTo(40.4124f, 27.8248f);
                l.cubicTo(40.4124f, 28.701607f, 39.701607f, 29.412401f, 38.8248f, 29.412401f);
                l.lineTo(3.1751997f, 29.412401f);
                l.cubicTo(2.2983925f, 29.412401f, 1.5875999f, 28.701607f, 1.5875999f, 27.8248f);
                l.lineTo(1.5875999f, 2.1751997f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(k, looper);
                a3.setColor(-5066062);
                Path l2 = c.l(looper);
                l2.moveTo(31.32f, 14.56f);
                l2.lineTo(26.1f, 19.735f);
                l2.lineTo(28.188f, 23.875f);
                l2.lineTo(13.572f, 10.42f);
                l2.lineTo(0.0f, 22.84f);
                l2.lineTo(0.0f, 29.05f);
                l2.lineTo(40.716f, 29.05f);
                l2.lineTo(40.716f, 22.84f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
