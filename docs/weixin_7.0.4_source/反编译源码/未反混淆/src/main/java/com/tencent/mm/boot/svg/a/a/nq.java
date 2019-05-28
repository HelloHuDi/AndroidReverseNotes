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

public final class nq extends c {
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
                g = c.a(g, 1.0f, 0.0f, -1420.0f, 0.0f, 1.0f, -201.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-16139513);
                a2.setStrokeWidth(6.0f);
                Path l = c.l(looper);
                l.moveTo(1423.0f, 259.5f);
                l.cubicTo(1423.0f, 228.84819f, 1447.8481f, 204.0f, 1478.5f, 204.0f);
                l.lineTo(1478.5f, 204.0f);
                l.cubicTo(1509.1519f, 204.0f, 1534.0f, 228.84819f, 1534.0f, 259.5f);
                l.lineTo(1534.0f, 259.5f);
                l.cubicTo(1534.0f, 290.1518f, 1509.1519f, 315.0f, 1478.5f, 315.0f);
                l.lineTo(1478.5f, 315.0f);
                l.cubicTo(1447.8481f, 315.0f, 1423.0f, 290.1518f, 1423.0f, 259.5f);
                l.lineTo(1423.0f, 259.5f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-16139513);
                l = c.l(looper);
                l.moveTo(1475.762f, 276.99985f);
                l.cubicTo(1480.2301f, 272.53815f, 1483.0f, 266.33554f, 1483.0f, 259.47748f);
                l.cubicTo(1483.0f, 252.50348f, 1480.1356f, 246.20723f, 1475.5338f, 241.7303f);
                l.lineTo(1470.5934f, 246.6707f);
                l.cubicTo(1473.9595f, 249.87605f, 1476.0616f, 254.42805f, 1476.0616f, 259.47748f);
                l.cubicTo(1476.0616f, 264.41092f, 1474.0549f, 268.86954f, 1470.8234f, 272.06125f);
                l.lineTo(1475.762f, 276.99985f);
                l.close();
                l.moveTo(1464.6487f, 265.88657f);
                l.cubicTo(1466.3352f, 264.2836f, 1467.3888f, 262.0052f, 1467.3888f, 259.47748f);
                l.cubicTo(1467.3888f, 256.83368f, 1466.2362f, 254.46259f, 1464.4122f, 252.85182f);
                l.lineTo(1458.0131f, 259.251f);
                l.lineTo(1464.6487f, 265.88657f);
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
