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

public final class ub extends c {
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
                l.moveTo(3.6f, 3.6f);
                l.lineTo(3.6f, 44.4f);
                l.lineTo(56.4f, 44.4f);
                l.lineTo(56.4f, 8.1f);
                l.lineTo(24.612188f, 8.1f);
                l.lineTo(18.987188f, 3.6f);
                l.lineTo(3.6f, 3.6f);
                l.close();
                l.moveTo(3.0f, 0.0f);
                l.lineTo(20.25f, 0.0f);
                l.lineTo(25.875f, 4.5f);
                l.lineTo(57.0f, 4.5f);
                l.cubicTo(58.656853f, 4.5f, 60.0f, 5.843146f, 60.0f, 7.5f);
                l.lineTo(60.0f, 45.0f);
                l.cubicTo(60.0f, 46.656853f, 58.656853f, 48.0f, 57.0f, 48.0f);
                l.lineTo(3.0f, 48.0f);
                l.cubicTo(1.3431457f, 48.0f, 2.0290612E-16f, 46.656853f, 0.0f, 45.0f);
                l.lineTo(0.0f, 3.0f);
                l.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(0.0f, 12.0f);
                l2.lineTo(60.0f, 12.0f);
                l2.lineTo(60.0f, 15.6f);
                l2.lineTo(0.0f, 15.6f);
                l2.lineTo(0.0f, 12.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
