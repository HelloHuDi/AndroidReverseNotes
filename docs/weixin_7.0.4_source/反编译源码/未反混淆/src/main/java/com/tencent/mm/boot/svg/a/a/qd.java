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

public final class qd extends c {
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
                a.setColor(-16384);
                float[] a2 = c.a(g, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 7.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(22.179684f, 20.160744f);
                l.cubicTo(25.258177f, 13.424428f, 28.385149f, 6.712214f, 31.48788f, 0.0f);
                l.cubicTo(34.69969f, 6.6881127f, 37.729702f, 13.4726305f, 40.893036f, 20.196896f);
                l.cubicTo(48.262024f, 20.67892f, 55.631012f, 21.160948f, 63.0f, 21.655024f);
                l.cubicTo(57.63082f, 26.53554f, 52.18892f, 31.34375f, 46.84398f, 36.248367f);
                l.cubicTo(48.552906f, 43.828228f, 50.24971f, 51.40809f, 51.946518f, 58.98795f);
                l.cubicTo(45.13505f, 55.228146f, 38.335705f, 51.44424f, 31.51212f, 47.708538f);
                l.cubicTo(24.688534f, 51.45629f, 17.889189f, 55.228146f, 11.077723f, 59.0f);
                l.cubicTo(12.7745285f, 51.40809f, 14.483455f, 43.828228f, 16.180262f, 36.248367f);
                l.cubicTo(11.041362f, 31.596813f, 5.963063f, 26.897058f, 0.7029627f, 22.390114f);
                l.cubicTo(0.53328204f, 22.390114f, 0.1818007f, 22.378063f, 0.0f, 22.366013f);
                l.lineTo(0.0f, 22.064747f);
                l.cubicTo(7.3083878f, 20.739176f, 14.798576f, 20.895834f, 22.179684f, 20.160744f);
                l.lineTo(22.179684f, 20.160744f);
                l.lineTo(22.179684f, 20.160744f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                g = c.a(a2, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 29.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(6.06f, 1.52f);
                l.cubicTo(13.81f, 1.24f, 21.54f, 0.83f, 29.28f, 0.5f);
                l.cubicTo(22.8f, 6.15f, 16.29f, 11.75f, 9.81f, 17.4f);
                l.lineTo(28.01f, 17.4f);
                l.cubicTo(28.01f, 17.72f, 28.0f, 18.38f, 28.0f, 18.71f);
                l.cubicTo(19.33f, 19.12f, 10.67f, 19.57f, 2.0f, 19.99f);
                l.cubicTo(8.51f, 14.35f, 15.02f, 8.71f, 21.53f, 3.07f);
                l.cubicTo(14.37f, 2.95f, 7.21f, 3.31f, 0.07f, 2.85f);
                l.cubicTo(1.78f, 1.46f, 4.0f, 1.65f, 6.06f, 1.52f);
                l.lineTo(6.06f, 1.52f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
