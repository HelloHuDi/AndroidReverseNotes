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

public final class afi extends c {
    private final int height = 93;
    private final int width = 93;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 93;
            case 1:
                return 93;
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
                g = c.a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 11.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(5.2173915f, 0.0f);
                l.cubicTo(2.2700827f, 0.0f, -7.1054274E-15f, 2.4263568f, -7.1054274E-15f, 5.2173915f);
                l.lineTo(-7.1054274E-15f, 65.21739f);
                l.cubicTo(-7.1054274E-15f, 68.00842f, 2.2700827f, 70.434784f, 5.2173915f, 70.434784f);
                l.lineTo(86.08696f, 70.434784f);
                l.cubicTo(89.03313f, 70.434784f, 91.304344f, 68.00842f, 91.304344f, 65.21739f);
                l.lineTo(91.304344f, 5.2173915f);
                l.cubicTo(91.304344f, 2.4263568f, 89.03313f, 0.0f, 86.08696f, 0.0f);
                l.lineTo(5.2173915f, 0.0f);
                l.close();
                l.moveTo(67.82609f, 6.521739f);
                l.lineTo(80.933716f, 6.521739f);
                l.cubicTo(82.835846f, 6.521739f, 84.78261f, 8.498771f, 84.78261f, 11.73913f);
                l.lineTo(84.78261f, 24.782608f);
                l.lineTo(91.304344f, 24.782608f);
                l.lineTo(91.304344f, 44.347828f);
                l.lineTo(84.78261f, 44.347828f);
                l.lineTo(84.78261f, 58.695652f);
                l.cubicTo(84.78261f, 61.936012f, 82.835846f, 63.913044f, 80.933716f, 63.913044f);
                l.lineTo(67.82609f, 63.913044f);
                l.lineTo(67.82609f, 70.434784f);
                l.lineTo(24.782608f, 70.434784f);
                l.lineTo(24.782608f, 63.913044f);
                l.lineTo(10.370634f, 63.913044f);
                l.cubicTo(8.467525f, 63.913044f, 6.521739f, 61.936012f, 6.521739f, 58.695652f);
                l.lineTo(6.521739f, 44.347828f);
                l.lineTo(7.1054274E-15f, 44.347828f);
                l.lineTo(8.303451E-15f, 24.782608f);
                l.lineTo(6.521739f, 24.782608f);
                l.lineTo(6.521739f, 11.73913f);
                l.cubicTo(6.521739f, 8.498771f, 8.467525f, 6.521739f, 10.370634f, 6.521739f);
                l.lineTo(24.782608f, 6.521739f);
                l.lineTo(24.782608f, 0.0f);
                l.lineTo(67.82609f, 0.0f);
                l.lineTo(67.82609f, 6.521739f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(29.608696f, 34.347828f);
                l2.lineTo(27.0f, 39.565216f);
                l2.lineTo(38.739132f, 53.913044f);
                l2.lineTo(64.82609f, 22.608696f);
                l2.lineTo(62.217392f, 20.0f);
                l2.lineTo(38.739132f, 42.173912f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
