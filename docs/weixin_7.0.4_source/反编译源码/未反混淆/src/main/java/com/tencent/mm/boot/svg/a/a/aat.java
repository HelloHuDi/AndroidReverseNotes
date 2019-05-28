package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aat extends c {
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
                c.h(looper);
                c.g(looper);
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
                Path l = c.l(looper);
                l.moveTo(12.6f, 12.6f);
                l.lineTo(12.6f, 59.4f);
                l.lineTo(59.4f, 59.4f);
                l.lineTo(59.4f, 12.6f);
                l.lineTo(12.6f, 12.6f);
                l.close();
                l.moveTo(12.0f, 9.0f);
                l.lineTo(60.0f, 9.0f);
                l.cubicTo(61.656853f, 9.0f, 63.0f, 10.343145f, 63.0f, 12.0f);
                l.lineTo(63.0f, 60.0f);
                l.cubicTo(63.0f, 61.656853f, 61.656853f, 63.0f, 60.0f, 63.0f);
                l.lineTo(12.0f, 63.0f);
                l.cubicTo(10.343145f, 63.0f, 9.0f, 61.656853f, 9.0f, 60.0f);
                l.lineTo(9.0f, 12.0f);
                l.cubicTo(9.0f, 10.343145f, 10.343145f, 9.0f, 12.0f, 9.0f);
                l.close();
                l.moveTo(50.28695f, 50.4f);
                l.cubicTo(50.238693f, 50.314686f, 50.19275f, 50.238598f, 50.190292f, 50.23709f);
                l.lineTo(39.923733f, 44.741676f);
                l.cubicTo(36.319508f, 42.88591f, 35.44312f, 38.468994f, 37.965595f, 35.312737f);
                l.lineTo(38.650604f, 34.455616f);
                l.cubicTo(39.34484f, 33.58695f, 39.978947f, 31.234459f, 39.978947f, 29.420372f);
                l.lineTo(39.978947f, 26.000416f);
                l.cubicTo(39.978947f, 23.530258f, 38.151016f, 21.6f, 36.0f, 21.6f);
                l.cubicTo(33.852142f, 21.6f, 32.021053f, 23.531115f, 32.021053f, 25.99916f);
                l.lineTo(32.021053f, 29.418581f);
                l.cubicTo(32.021053f, 31.17479f, 32.689404f, 33.54674f, 33.41562f, 34.455296f);
                l.lineTo(34.100628f, 35.312298f);
                l.cubicTo(36.628113f, 38.47439f, 35.74206f, 42.887615f, 32.184887f, 44.719566f);
                l.lineTo(21.759434f, 50.263042f);
                l.cubicTo(21.781796f, 50.251522f, 21.750141f, 50.319286f, 21.7093f, 50.4f);
                l.lineTo(50.28695f, 50.4f);
                l.close();
                l.moveTo(18.0f, 50.630928f);
                l.cubicTo(18.0f, 49.26075f, 18.943865f, 47.663815f, 20.110922f, 47.062664f);
                l.lineTo(30.494669f, 41.54102f);
                l.cubicTo(32.050106f, 40.739815f, 32.411777f, 38.96526f, 31.288553f, 37.560013f);
                l.lineTo(30.603544f, 36.70301f);
                l.cubicTo(29.209784f, 34.959305f, 28.421053f, 31.698994f, 28.421053f, 29.418581f);
                l.lineTo(28.421053f, 25.99916f);
                l.cubicTo(28.421053f, 21.581347f, 31.82278f, 18.0f, 36.0f, 18.0f);
                l.cubicTo(40.185738f, 18.0f, 43.57895f, 21.58596f, 43.57895f, 26.000416f);
                l.lineTo(43.57895f, 29.420372f);
                l.cubicTo(43.57895f, 31.698591f, 42.85138f, 34.96572f, 41.46283f, 36.703148f);
                l.lineTo(40.77782f, 37.560265f);
                l.cubicTo(39.66083f, 38.9579f, 40.009758f, 40.736794f, 41.571705f, 41.54102f);
                l.lineTo(51.889076f, 47.063114f);
                l.cubicTo(53.05491f, 47.663383f, 54.0f, 49.25034f, 54.0f, 50.630928f);
                l.lineTo(54.0f, 52.105263f);
                l.cubicTo(54.0f, 53.1517f, 53.1517f, 54.0f, 52.105263f, 54.0f);
                l.lineTo(19.894737f, 54.0f);
                l.cubicTo(18.848303f, 54.0f, 18.0f, 53.1517f, 18.0f, 52.105263f);
                l.lineTo(18.0f, 50.630928f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
