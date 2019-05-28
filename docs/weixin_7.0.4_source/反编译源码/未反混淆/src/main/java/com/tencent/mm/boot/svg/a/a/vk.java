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

public final class vk extends c {
    private final int height = 100;
    private final int width = 100;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                a.setColor(-16139513);
                Path l = c.l(looper);
                l.moveTo(100.0f, 50.346603f);
                l.cubicTo(100.0f, 22.265478f, 77.614815f, 0.0f, 49.382717f, 0.0f);
                l.cubicTo(22.385185f, 0.0f, 0.0f, 22.265478f, 0.0f, 50.346603f);
                l.cubicTo(0.0f, 77.19976f, 22.385185f, 99.46524f, 49.382717f, 99.46524f);
                l.cubicTo(77.614815f, 99.46524f, 100.0f, 77.19976f, 100.0f, 50.346603f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(26.066193f, 52.06067f);
                l.cubicTo(25.683428f, 51.666645f, 25.640087f, 50.985928f, 25.972504f, 50.536034f);
                l.lineTo(27.666462f, 48.243423f);
                l.cubicTo(27.997484f, 47.795414f, 28.617992f, 47.700703f, 29.062307f, 48.03942f);
                l.lineTo(41.715767f, 57.68571f);
                l.cubicTo(42.155647f, 58.021053f, 42.853935f, 58.00976f, 43.289238f, 57.64906f);
                l.lineTo(75.15912f, 31.240854f);
                l.cubicTo(75.58824f, 30.885271f, 76.25674f, 30.911966f, 76.65116f, 31.299417f);
                l.lineTo(78.11376f, 32.736153f);
                l.cubicTo(78.508675f, 33.12408f, 78.51484f, 33.745895f, 78.11964f, 34.132755f);
                l.lineTo(43.220352f, 68.2952f);
                l.cubicTo(42.828686f, 68.6786f, 42.199085f, 68.66812f, 41.81812f, 68.275955f);
                l.lineTo(26.066193f, 52.06067f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
