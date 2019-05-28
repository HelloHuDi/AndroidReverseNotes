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

public final class zu extends c {
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
                k = c.a(k, looper);
                k.setColor(-16726153);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(7.5f, 60.0f);
                l.lineTo(7.5f, 57.94639f);
                l.cubicTo(7.5f, 55.891125f, 8.994452f, 53.495724f, 10.842293f, 52.593998f);
                l.lineTo(27.823353f, 44.30743f);
                l.cubicTo(30.28613f, 43.10562f, 30.858778f, 40.443787f, 29.080336f, 38.33592f);
                l.lineTo(27.995739f, 37.050415f);
                l.cubicTo(25.788954f, 34.434856f, 24.0f, 29.548489f, 24.0f, 26.127872f);
                l.lineTo(24.0f, 20.998741f);
                l.cubicTo(24.0f, 14.37202f, 29.386068f, 9.0f, 36.0f, 9.0f);
                l.cubicTo(42.62742f, 9.0f, 48.0f, 14.378941f, 48.0f, 21.000622f);
                l.lineTo(48.0f, 26.130558f);
                l.cubicTo(48.0f, 29.547888f, 46.202797f, 34.44858f, 44.00426f, 37.054718f);
                l.lineTo(42.919662f, 38.340397f);
                l.cubicTo(41.151096f, 40.43685f, 41.703564f, 43.105194f, 44.176647f, 44.31153f);
                l.lineTo(61.157707f, 52.594673f);
                l.cubicTo(63.003605f, 53.49508f, 64.5f, 55.87551f, 64.5f, 57.94639f);
                l.lineTo(64.5f, 60.0f);
                l.cubicTo(64.5f, 61.656853f, 63.156853f, 63.0f, 61.5f, 63.0f);
                l.lineTo(10.5f, 63.0f);
                l.cubicTo(8.843145f, 63.0f, 7.5f, 61.656853f, 7.5f, 60.0f);
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
