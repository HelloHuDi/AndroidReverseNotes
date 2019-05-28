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

public final class cr extends c {
    private final int height = 71;
    private final int width = 80;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 71;
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
                a.setColor(-1);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 27.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                float[] a2 = c.a(g, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(19.357758f, 25.260746f);
                l.lineTo(28.45082f, 25.260746f);
                l.cubicTo(34.51505f, 25.260746f, 39.44799f, 20.333082f, 39.44799f, 14.254499f);
                l.lineTo(39.44799f, 11.0062475f);
                l.cubicTo(39.44799f, 4.930493f, 34.52439f, 1.2726757E-7f, 28.45082f, 1.046543E-7f);
                l.lineTo(11.339516f, 4.0945043E-8f);
                l.cubicTo(5.2752895f, 1.8366562E-8f, 0.34234652f, 4.9276648f, 0.34234652f, 11.006247f);
                l.lineTo(0.34234652f, 14.160372f);
                l.lineTo(4.420356f, 14.160372f);
                l.cubicTo(4.3753934f, 13.817222f, 4.3521967f, 13.467262f, 4.3521967f, 13.111929f);
                l.lineTo(4.352197f, 12.010028f);
                l.cubicTo(4.352197f, 7.5904274f, 7.9322853f, 4.0076337f, 12.355284f, 4.0076337f);
                l.lineTo(27.42606f, 4.0076337f);
                l.cubicTo(31.846043f, 4.0076337f, 35.429146f, 7.593756f, 35.429146f, 12.010028f);
                l.lineTo(35.429146f, 13.111929f);
                l.cubicTo(35.429146f, 17.531528f, 31.849058f, 21.114323f, 27.42606f, 21.114323f);
                l.lineTo(19.357758f, 21.114323f);
                l.lineTo(19.357758f, 25.260746f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                g = c.a(a2, -1.0f, 0.0f, 40.0f, 0.0f, -1.0f, 26.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(19.357758f, 25.260746f);
                l.lineTo(28.45082f, 25.260746f);
                l.cubicTo(34.51505f, 25.260746f, 39.44799f, 20.333082f, 39.44799f, 14.254499f);
                l.lineTo(39.44799f, 11.0062475f);
                l.cubicTo(39.44799f, 4.930493f, 34.52439f, 1.2726757E-7f, 28.45082f, 1.046543E-7f);
                l.lineTo(11.339516f, 4.0945043E-8f);
                l.cubicTo(5.2752895f, 1.8366562E-8f, 0.34234652f, 4.9276648f, 0.34234652f, 11.006247f);
                l.lineTo(0.34234652f, 14.160372f);
                l.lineTo(4.420356f, 14.160372f);
                l.cubicTo(4.3753934f, 13.817222f, 4.3521967f, 13.467262f, 4.3521967f, 13.111929f);
                l.lineTo(4.352197f, 12.010028f);
                l.cubicTo(4.352197f, 7.5904274f, 7.9322853f, 4.0076337f, 12.355284f, 4.0076337f);
                l.lineTo(27.42606f, 4.0076337f);
                l.cubicTo(31.846043f, 4.0076337f, 35.429146f, 7.593756f, 35.429146f, 12.010028f);
                l.lineTo(35.429146f, 13.111929f);
                l.cubicTo(35.429146f, 17.531528f, 31.849058f, 21.114323f, 27.42606f, 21.114323f);
                l.lineTo(19.357758f, 21.114323f);
                l.lineTo(19.357758f, 25.260746f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
