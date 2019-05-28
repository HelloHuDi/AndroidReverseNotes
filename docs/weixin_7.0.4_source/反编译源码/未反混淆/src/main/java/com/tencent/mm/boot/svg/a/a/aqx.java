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

public final class aqx extends c {
    private final int height = 100;
    private final int width = 100;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                g = c.a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-15028967);
                a2.setStrokeWidth(1.96f);
                Path l = c.l(looper);
                l.moveTo(49.0f, 0.97999954f);
                l.cubicTo(75.52071f, 0.97999954f, 97.020004f, 22.479284f, 97.020004f, 49.0f);
                l.cubicTo(97.020004f, 75.52071f, 75.52071f, 97.020004f, 49.0f, 97.020004f);
                l.cubicTo(22.479284f, 97.020004f, 0.97999954f, 75.52071f, 0.97999954f, 49.0f);
                l.cubicTo(0.97999954f, 22.479284f, 22.479284f, 0.97999954f, 49.0f, 0.97999954f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-15028967);
                l = c.l(looper);
                l.moveTo(45.596504f, 87.3795f);
                l.cubicTo(45.311245f, 88.29637f, 45.56067f, 89.657684f, 46.151157f, 90.41694f);
                l.lineTo(47.928844f, 92.7027f);
                l.cubicTo(48.520428f, 93.46336f, 49.480667f, 93.46195f, 50.071156f, 92.7027f);
                l.lineTo(51.848843f, 90.41694f);
                l.cubicTo(52.440426f, 89.65628f, 52.686527f, 88.28921f, 52.403496f, 87.3795f);
                l.lineTo(49.516502f, 78.100136f);
                l.cubicTo(49.231247f, 77.18327f, 48.766525f, 77.19043f, 48.483498f, 78.100136f);
                l.lineTo(45.596504f, 87.3795f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                a2.setColor(-15028967);
                a2.setStrokeWidth(1.96f);
                l = c.l(looper);
                l.moveTo(78.48931f, 86.901474f);
                l.cubicTo(78.21859f, 86.711105f, 77.946815f, 86.55085f, 77.6791f, 86.42441f);
                l.lineTo(58.566147f, 77.39736f);
                l.cubicTo(54.962547f, 75.69538f, 54.140015f, 71.74742f, 56.766563f, 68.75442f);
                l.lineTo(58.378567f, 66.91751f);
                l.cubicTo(60.96644f, 63.968586f, 63.106014f, 58.298977f, 63.106014f, 54.3906f);
                l.lineTo(63.106014f, 48.363018f);
                l.cubicTo(63.106014f, 40.597996f, 56.79056f, 34.3f, 49.000072f, 34.3f);
                l.cubicTo(41.207775f, 34.3f, 34.894135f, 40.596203f, 34.894135f, 48.363018f);
                l.lineTo(34.894135f, 54.3906f);
                l.cubicTo(34.894135f, 58.2991f, 37.033085f, 63.96649f, 39.621418f, 66.91444f);
                l.lineTo(41.23342f, 68.75041f);
                l.cubicTo(43.86102f, 71.74308f, 43.038033f, 75.68944f, 39.43416f, 77.39232f);
                l.lineTo(20.305996f, 86.43065f);
                l.cubicTo(20.043016f, 86.55491f, 19.775612f, 86.712585f, 19.508852f, 86.90005f);
                l.cubicTo(27.86791f, 93.41537f, 38.156105f, 97.02f, 49.0f, 97.02f);
                l.cubicTo(59.84309f, 97.02f, 70.13057f, 93.41591f, 78.48931f, 86.901474f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
