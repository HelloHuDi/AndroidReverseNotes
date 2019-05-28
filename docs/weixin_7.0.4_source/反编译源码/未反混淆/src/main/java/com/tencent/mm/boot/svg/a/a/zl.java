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

public final class zl extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-16726153);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(3.0f, 60.0f);
                l.lineTo(3.0f, 57.94639f);
                l.cubicTo(3.0f, 55.891125f, 4.494453f, 53.495724f, 6.342293f, 52.593998f);
                l.lineTo(23.323353f, 44.30743f);
                l.cubicTo(25.78613f, 43.10562f, 26.358778f, 40.443787f, 24.580336f, 38.33592f);
                l.lineTo(23.495739f, 37.050415f);
                l.cubicTo(21.288954f, 34.434856f, 19.5f, 29.548489f, 19.5f, 26.127872f);
                l.lineTo(19.5f, 20.998741f);
                l.cubicTo(19.5f, 14.37202f, 24.886068f, 9.0f, 31.5f, 9.0f);
                l.cubicTo(38.12742f, 9.0f, 43.5f, 14.378941f, 43.5f, 21.000622f);
                l.lineTo(43.5f, 26.130558f);
                l.cubicTo(43.5f, 29.547888f, 41.702797f, 34.44858f, 39.50426f, 37.054718f);
                l.lineTo(38.419662f, 38.340397f);
                l.cubicTo(36.651096f, 40.43685f, 37.203564f, 43.105194f, 39.676647f, 44.31153f);
                l.lineTo(56.657707f, 52.594673f);
                l.cubicTo(58.503605f, 53.49508f, 60.0f, 55.87551f, 60.0f, 57.94639f);
                l.lineTo(60.0f, 60.0f);
                l.cubicTo(60.0f, 61.656853f, 58.656853f, 63.0f, 57.0f, 63.0f);
                l.lineTo(6.0f, 63.0f);
                l.cubicTo(4.343146f, 63.0f, 3.0f, 61.656853f, 3.0f, 60.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(60.0f, 43.5f);
                l2.lineTo(69.0f, 43.5f);
                l2.lineTo(69.0f, 47.1f);
                l2.lineTo(60.0f, 47.1f);
                l2.lineTo(60.0f, 43.5f);
                l2.close();
                l2.moveTo(54.0f, 34.5f);
                l2.lineTo(69.0f, 34.5f);
                l2.lineTo(69.0f, 38.1f);
                l2.lineTo(54.0f, 38.1f);
                l2.lineTo(54.0f, 34.5f);
                l2.close();
                l2.moveTo(48.0f, 25.5f);
                l2.lineTo(69.0f, 25.5f);
                l2.lineTo(69.0f, 29.1f);
                l2.lineTo(48.0f, 29.1f);
                l2.lineTo(48.0f, 25.5f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
