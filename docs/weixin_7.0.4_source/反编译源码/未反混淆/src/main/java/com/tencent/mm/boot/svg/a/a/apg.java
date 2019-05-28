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

public final class apg extends c {
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
                a.setColor(-15028967);
                g = c.a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(3.6f, 8.1f);
                l.lineTo(3.6f, 39.9f);
                l.lineTo(41.4f, 39.9f);
                l.lineTo(41.4f, 8.1f);
                l.lineTo(3.6f, 8.1f);
                l.close();
                l.moveTo(3.0f, 4.5f);
                l.lineTo(42.0f, 4.5f);
                l.cubicTo(43.656853f, 4.5f, 45.0f, 5.843146f, 45.0f, 7.5f);
                l.lineTo(45.0f, 40.5f);
                l.cubicTo(45.0f, 42.156853f, 43.656853f, 43.5f, 42.0f, 43.5f);
                l.lineTo(3.0f, 43.5f);
                l.cubicTo(1.3431457f, 43.5f, 0.0f, 42.156853f, 0.0f, 40.5f);
                l.lineTo(0.0f, 7.5f);
                l.cubicTo(0.0f, 5.843146f, 1.3431457f, 4.5f, 3.0f, 4.5f);
                l.close();
                l.moveTo(51.6f, 28.26975f);
                l.lineTo(59.4f, 34.50975f);
                l.lineTo(59.4f, 13.49025f);
                l.lineTo(51.6f, 19.73025f);
                l.lineTo(51.6f, 28.26975f);
                l.close();
                l.moveTo(48.0f, 18.0f);
                l.lineTo(58.125916f, 9.899268f);
                l.cubicTo(59.4197f, 8.86424f, 61.30758f, 9.074003f, 62.342606f, 10.367789f);
                l.cubicTo(62.768158f, 10.899729f, 63.0f, 11.56066f, 63.0f, 12.241875f);
                l.lineTo(63.0f, 35.758125f);
                l.cubicTo(63.0f, 37.414978f, 61.656853f, 38.758125f, 60.0f, 38.758125f);
                l.cubicTo(59.318787f, 38.758125f, 58.657852f, 38.526283f, 58.125916f, 38.10073f);
                l.lineTo(48.0f, 30.0f);
                l.lineTo(48.0f, 18.0f);
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
