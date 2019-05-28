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

public final class km extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Paint a = c.a(k, looper);
                a.setColor(-8617594);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 9.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(73.0f, 34.00018f);
                l.lineTo(73.0f, 57.00018f);
                l.cubicTo(72.9f, 59.03468f, 71.0865f, 60.857323f, 69.0f, 61.00018f);
                l.lineTo(12.0f, 61.00018f);
                l.cubicTo(9.91305f, 60.857323f, 8.1f, 59.03468f, 8.0f, 57.00018f);
                l.lineTo(8.0f, 24.000181f);
                l.cubicTo(8.1f, 21.966133f, 9.91305f, 20.143038f, 12.0f, 20.000181f);
                l.lineTo(19.0f, 20.000181f);
                l.cubicTo(19.35f, 20.13399f, 21.7467f, 16.067085f, 29.0f, 12.00018f);
                l.lineTo(12.0f, 12.00018f);
                l.cubicTo(5.4396f, 12.00018f, 0.0f, 17.468561f, 0.0f, 24.000181f);
                l.lineTo(0.0f, 57.00018f);
                l.cubicTo(0.0f, 63.5318f, 5.4396f, 69.00018f, 12.0f, 69.00018f);
                l.lineTo(69.0f, 69.00018f);
                l.cubicTo(75.5604f, 69.00018f, 81.0f, 63.5318f, 81.0f, 57.00018f);
                l.lineTo(81.0f, 28.000181f);
                l.lineTo(73.0f, 34.00018f);
                l.close();
                l.moveTo(53.0f, 29.000181f);
                l.lineTo(53.0f, 41.00018f);
                l.lineTo(77.0f, 20.000181f);
                l.lineTo(53.0f, 1.8039216E-4f);
                l.lineTo(53.0f, 12.00018f);
                l.cubicTo(32.732662f, 12.273722f, 16.57688f, 28.172049f, 16.0f, 48.00018f);
                l.cubicTo(24.49405f, 36.795803f, 37.67185f, 29.378492f, 53.0f, 29.000181f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
