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

public final class zn extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(46.235294f, 13.500007f);
                l.lineTo(43.832214f, 54.352333f);
                l.cubicTo(43.645664f, 57.52371f, 41.01943f, 60.0f, 37.84257f, 60.0f);
                l.lineTo(16.15743f, 60.0f);
                l.cubicTo(12.980573f, 60.0f, 10.354336f, 57.52371f, 10.167784f, 54.352333f);
                l.lineTo(7.764706f, 13.500007f);
                l.lineTo(1.5f, 13.500007f);
                l.lineTo(1.5f, 10.5f);
                l.cubicTo(1.5f, 9.671573f, 2.171573f, 9.0f, 3.0f, 9.0f);
                l.lineTo(51.0f, 9.0f);
                l.cubicTo(51.828426f, 9.0f, 52.5f, 9.671573f, 52.5f, 10.5f);
                l.lineTo(52.5f, 13.500007f);
                l.lineTo(46.235294f, 13.500007f);
                l.close();
                l.moveTo(21.0f, 1.5001023f);
                l.lineTo(33.0f, 1.5001023f);
                l.cubicTo(33.828426f, 1.5001023f, 34.5f, 2.1716752f, 34.5f, 3.0001023f);
                l.lineTo(34.5f, 6.0f);
                l.lineTo(19.5f, 6.0f);
                l.lineTo(19.5f, 3.0001023f);
                l.cubicTo(19.5f, 2.1716752f, 20.171574f, 1.5001023f, 21.0f, 1.5001023f);
                l.close();
                l.moveTo(18.0f, 20.999945f);
                l.lineTo(19.5f, 47.99998f);
                l.lineTo(24.0f, 47.99998f);
                l.lineTo(22.800001f, 20.999945f);
                l.lineTo(18.0f, 20.999945f);
                l.close();
                l.moveTo(31.5f, 20.999945f);
                l.lineTo(30.0f, 47.99998f);
                l.lineTo(34.5f, 47.99998f);
                l.lineTo(36.0f, 20.999945f);
                l.lineTo(31.5f, 20.999945f);
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
