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

public final class ari extends c {
    private final int height = 108;
    private final int width = 108;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                a.setColor(-12470759);
                g = c.a(g, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 9.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(34.16953f, 37.009228f);
                l.lineTo(35.931976f, 41.59285f);
                l.lineTo(38.864815f, 41.59285f);
                l.lineTo(32.066803f, 23.913153f);
                l.lineTo(31.717865f, 23.913153f);
                l.lineTo(28.785027f, 23.913153f);
                l.lineTo(21.987013f, 41.59285f);
                l.lineTo(24.919851f, 41.59285f);
                l.lineTo(26.682299f, 37.009228f);
                l.lineTo(34.16953f, 37.009228f);
                l.close();
                l.moveTo(33.162415f, 34.39001f);
                l.lineTo(27.689413f, 34.39001f);
                l.lineTo(30.425915f, 27.273148f);
                l.lineTo(33.162415f, 34.39001f);
                l.close();
                l.moveTo(13.695652f, 9.0f);
                l.lineTo(70.53812f, 9.0f);
                l.cubicTo(73.131454f, 9.0f, 75.233765f, 11.102315f, 75.233765f, 13.695652f);
                l.lineTo(75.233765f, 84.99253f);
                l.cubicTo(75.233765f, 87.58586f, 73.131454f, 89.68818f, 70.53812f, 89.68818f);
                l.lineTo(13.695652f, 89.68818f);
                l.cubicTo(11.102315f, 89.68818f, 9.0f, 87.58586f, 9.0f, 84.99253f);
                l.lineTo(9.0f, 13.695652f);
                l.cubicTo(9.0f, 11.102315f, 11.102315f, 9.0f, 13.695652f, 9.0f);
                l.close();
                l.moveTo(21.042503f, 53.150135f);
                l.lineTo(21.042503f, 57.717392f);
                l.lineTo(63.191265f, 57.717392f);
                l.lineTo(63.191265f, 53.150135f);
                l.lineTo(21.042503f, 53.150135f);
                l.close();
                l.moveTo(21.042503f, 63.807064f);
                l.lineTo(21.042503f, 68.37432f);
                l.lineTo(63.191265f, 68.37432f);
                l.lineTo(63.191265f, 63.807064f);
                l.lineTo(21.042503f, 63.807064f);
                l.close();
                l.moveTo(21.042503f, 72.941574f);
                l.lineTo(21.042503f, 77.508835f);
                l.lineTo(63.191265f, 77.508835f);
                l.lineTo(63.191265f, 72.941574f);
                l.lineTo(21.042503f, 72.941574f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(67.70934f, 6.0869565f);
                l.lineTo(8.366434f, 6.0869565f);
                l.cubicTo(7.0697656f, 6.0869565f, 6.018608f, 7.138114f, 6.018608f, 8.434783f);
                l.lineTo(6.018608f, 82.17391f);
                l.lineTo(4.695652f, 82.17391f);
                l.cubicTo(2.1023152f, 82.17391f, -5.705862E-16f, 80.071594f, -8.881784E-16f, 77.478264f);
                l.lineTo(0.0f, 4.695652f);
                l.cubicTo(-3.175922E-16f, 2.1023152f, 2.1023152f, 2.2527451E-15f, 4.695652f, 1.7763568E-15f);
                l.lineTo(63.01369f, 0.0f);
                l.cubicTo(65.607025f, -5.0830803E-15f, 67.70934f, 2.1023152f, 67.70934f, 4.695652f);
                l.lineTo(67.70934f, 6.0869565f);
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
