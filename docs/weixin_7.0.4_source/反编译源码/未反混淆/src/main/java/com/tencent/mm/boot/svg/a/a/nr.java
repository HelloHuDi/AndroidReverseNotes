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
import com.tencent.view.d;

public final class nr extends c {
    private final int height = d.MIC_ALPHA_ADJUST_REAL;
    private final int width = d.MIC_ALPHA_ADJUST_REAL;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return d.MIC_ALPHA_ADJUST_REAL;
            case 1:
                return d.MIC_ALPHA_ADJUST_REAL;
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
                g = c.a(g, 1.0f, 0.0f, -1580.0f, 0.0f, 1.0f, -201.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-16139513);
                a2.setStrokeWidth(6.0f);
                Path l = c.l(looper);
                l.moveTo(1583.0f, 259.5f);
                l.cubicTo(1583.0f, 228.84819f, 1607.8481f, 204.0f, 1638.5f, 204.0f);
                l.lineTo(1638.5f, 204.0f);
                l.cubicTo(1669.1519f, 204.0f, 1694.0f, 228.84819f, 1694.0f, 259.5f);
                l.lineTo(1694.0f, 259.5f);
                l.cubicTo(1694.0f, 290.1518f, 1669.1519f, 315.0f, 1638.5f, 315.0f);
                l.lineTo(1638.5f, 315.0f);
                l.cubicTo(1607.8481f, 315.0f, 1583.0f, 290.1518f, 1583.0f, 259.5f);
                l.lineTo(1583.0f, 259.5f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-16139513);
                l = c.l(looper);
                l.moveTo(1646.8911f, 288.9778f);
                l.lineTo(1641.9794f, 284.06616f);
                l.cubicTo(1647.6785f, 277.75735f, 1651.1661f, 269.28784f, 1651.1661f, 259.97653f);
                l.cubicTo(1651.1661f, 250.72066f, 1647.7198f, 242.29657f, 1642.0809f, 235.9998f);
                l.lineTo(1646.9929f, 231.0878f);
                l.cubicTo(1653.8218f, 238.65639f, 1658.0f, 248.81223f, 1658.0f, 259.97653f);
                l.cubicTo(1658.0f, 271.1963f, 1653.7802f, 281.3975f, 1646.8911f, 288.9778f);
                l.close();
                l.moveTo(1635.4944f, 277.58115f);
                l.lineTo(1630.5815f, 272.66824f);
                l.cubicTo(1633.7931f, 269.45828f, 1635.7898f, 264.95837f, 1635.7898f, 259.97653f);
                l.cubicTo(1635.7898f, 255.05014f, 1633.8373f, 250.595f, 1630.6882f, 247.39249f);
                l.lineTo(1635.6002f, 242.48047f);
                l.cubicTo(1639.9392f, 246.95483f, 1642.6238f, 253.14172f, 1642.6238f, 259.97653f);
                l.cubicTo(1642.6238f, 266.8668f, 1639.8955f, 273.09854f, 1635.4944f, 277.58115f);
                l.close();
                l.moveTo(1624.436f, 266.5228f);
                l.cubicTo(1626.1627f, 264.90756f, 1627.2474f, 262.57294f, 1627.2474f, 259.97653f);
                l.cubicTo(1627.2474f, 257.43564f, 1626.2086f, 255.14546f, 1624.5459f, 253.53485f);
                l.lineTo(1617.997f, 260.08374f);
                l.lineTo(1624.436f, 266.5228f);
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
