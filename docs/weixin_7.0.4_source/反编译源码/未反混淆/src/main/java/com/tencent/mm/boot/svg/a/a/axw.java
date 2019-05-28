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

public final class axw extends c {
    private final int height = 66;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                float[] a2 = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(3.6f);
                Path l = c.l(looper);
                l.moveTo(1.8f, 27.0f);
                l.cubicTo(1.8f, 13.082423f, 13.082423f, 1.8f, 27.0f, 1.8f);
                l.lineTo(39.000004f, 1.8f);
                l.cubicTo(52.91758f, 1.8f, 64.200005f, 13.082423f, 64.200005f, 27.0f);
                l.lineTo(64.200005f, 27.0f);
                l.cubicTo(64.200005f, 40.917576f, 52.91758f, 52.2f, 39.000004f, 52.2f);
                l.lineTo(27.0f, 52.2f);
                l.cubicTo(13.082423f, 52.2f, 1.8f, 40.917576f, 1.8f, 27.0f);
                l.lineTo(1.8f, 27.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                g = c.a(a2, 0.70710677f, -0.70710677f, 28.757359f, 0.70710677f, 0.70710677f, -15.426407f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(31.0f, 25.0f);
                l.lineTo(31.0f, 15.0f);
                l.lineTo(35.0f, 15.0f);
                l.lineTo(35.0f, 25.0f);
                l.lineTo(45.0f, 25.0f);
                l.lineTo(45.0f, 29.0f);
                l.lineTo(35.0f, 29.0f);
                l.lineTo(35.0f, 39.0f);
                l.lineTo(31.0f, 39.0f);
                l.lineTo(31.0f, 29.0f);
                l.lineTo(21.0f, 29.0f);
                l.lineTo(21.0f, 25.0f);
                l.lineTo(31.0f, 25.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
