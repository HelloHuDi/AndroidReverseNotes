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

public final class aor extends c {
    private final int height = 79;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 79;
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
                k.setColor(-1);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(10.536117f, 55.789783f);
                l.cubicTo(4.649229f, 49.98656f, 1.0f, 41.91944f, 1.0f, 33.0f);
                l.cubicTo(1.0f, 15.326888f, 15.326888f, 1.0f, 33.0f, 1.0f);
                l.cubicTo(50.67311f, 1.0f, 65.0f, 15.326888f, 65.0f, 33.0f);
                l.cubicTo(65.0f, 41.959976f, 61.317528f, 50.059868f, 55.383484f, 55.868763f);
                l.lineTo(55.435028f, 55.92031f);
                l.lineTo(32.92031f, 78.43503f);
                l.lineTo(10.405592f, 55.92031f);
                l.lineTo(10.536117f, 55.789783f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
