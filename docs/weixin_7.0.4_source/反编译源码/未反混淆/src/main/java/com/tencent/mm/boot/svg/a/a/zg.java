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

public final class zg extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                g = c.a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(38.197224f, 5.551115E-15f);
                l.cubicTo(38.698753f, 5.4589855E-15f, 39.167103f, 0.25065172f, 39.4453f, 0.6679497f);
                l.lineTo(45.0f, 9.0f);
                l.lineTo(57.0f, 9.0f);
                l.cubicTo(58.656853f, 9.0f, 60.0f, 10.343145f, 60.0f, 12.0f);
                l.lineTo(60.0f, 45.0f);
                l.cubicTo(60.0f, 46.656853f, 58.656853f, 48.0f, 57.0f, 48.0f);
                l.lineTo(3.0f, 48.0f);
                l.cubicTo(1.3431457f, 48.0f, 6.8642445E-15f, 46.656853f, 6.661338E-15f, 45.0f);
                l.lineTo(7.1054274E-15f, 12.0f);
                l.cubicTo(6.902521E-15f, 10.343145f, 1.3431457f, 9.0f, 3.0f, 9.0f);
                l.lineTo(15.0f, 9.0f);
                l.lineTo(20.5547f, 0.6679497f);
                l.cubicTo(20.8329f, 0.25065172f, 21.301247f, -3.4646604E-15f, 21.802776f, -2.220446E-15f);
                l.lineTo(38.197224f, 0.0f);
                l.close();
                l.moveTo(23.1f, 36.819073f);
                l.cubicTo(25.051779f, 38.19314f, 27.431664f, 39.0f, 30.0f, 39.0f);
                l.cubicTo(36.62742f, 39.0f, 42.0f, 33.62742f, 42.0f, 27.0f);
                l.lineTo(38.4f, 27.0f);
                l.cubicTo(38.4f, 31.639193f, 34.63919f, 35.4f, 30.0f, 35.4f);
                l.cubicTo(28.070463f, 35.4f, 26.254343f, 34.746292f, 24.801285f, 33.6f);
                l.lineTo(28.5f, 33.6f);
                l.lineTo(28.5f, 30.0f);
                l.lineTo(21.0f, 30.0f);
                l.cubicTo(20.171574f, 30.0f, 19.5f, 30.671574f, 19.5f, 31.5f);
                l.lineTo(19.5f, 33.6f);
                l.lineTo(19.5f, 39.0f);
                l.lineTo(23.1f, 39.0f);
                l.lineTo(23.1f, 36.819073f);
                l.close();
                l.moveTo(36.9f, 17.18093f);
                l.cubicTo(34.94822f, 15.806861f, 32.568336f, 15.0f, 30.0f, 15.0f);
                l.cubicTo(23.372583f, 15.0f, 18.0f, 20.372583f, 18.0f, 27.0f);
                l.lineTo(21.6f, 27.0f);
                l.cubicTo(21.6f, 22.360807f, 25.360807f, 18.6f, 30.0f, 18.6f);
                l.cubicTo(31.931503f, 18.6f, 33.747807f, 19.255857f, 35.198837f, 20.4f);
                l.lineTo(31.5f, 20.4f);
                l.lineTo(31.5f, 24.0f);
                l.lineTo(36.9f, 24.0f);
                l.lineTo(39.0f, 24.0f);
                l.cubicTo(39.828426f, 24.0f, 40.5f, 23.328426f, 40.5f, 22.5f);
                l.lineTo(40.5f, 15.0f);
                l.lineTo(36.9f, 15.0f);
                l.lineTo(36.9f, 17.18093f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
