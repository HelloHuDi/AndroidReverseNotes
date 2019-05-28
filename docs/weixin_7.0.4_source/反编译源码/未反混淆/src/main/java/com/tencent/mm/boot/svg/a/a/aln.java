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

public final class aln extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                k2 = c.a(k, looper);
                k2.setColor(-1);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 4.0f);
                l.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                l.lineTo(86.0f, 0.0f);
                l.cubicTo(88.20914f, 0.0f, 90.0f, 1.7908609f, 90.0f, 4.0f);
                l.lineTo(90.0f, 86.0f);
                l.cubicTo(90.0f, 88.20914f, 88.20914f, 90.0f, 86.0f, 90.0f);
                l.lineTo(4.0f, 90.0f);
                l.cubicTo(1.7908609f, 90.0f, 0.0f, 88.20914f, 0.0f, 86.0f);
                l.lineTo(0.0f, 4.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                float[] a2 = c.a(g, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 23.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                a3.setColor(-16731650);
                l = c.l(looper);
                l.moveTo(1.330489f, 10.218908f);
                l.lineTo(18.69964f, 20.085167f);
                l.cubicTo(19.419216f, 20.49391f, 20.589544f, 20.491829f, 21.305456f, 20.085167f);
                l.lineTo(38.674606f, 10.218908f);
                l.cubicTo(39.394184f, 9.810165f, 39.379704f, 9.183529f, 38.635887f, 8.816125f);
                l.lineTo(21.34418f, 0.27502382f);
                l.cubicTo(20.603216f, -0.09096857f, 19.404737f, -0.09237996f, 18.660917f, 0.27502382f);
                l.lineTo(1.3692116f, 8.816125f);
                l.cubicTo(0.6282494f, 9.182117f, 0.6145759f, 9.812246f, 1.330489f, 10.218908f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                a3.setColor(-371630);
                l = c.l(looper);
                l.moveTo(22.305946f, 22.062408f);
                l.cubicTo(21.584692f, 22.468164f, 21.0f, 23.469671f, 21.0f, 24.294716f);
                l.lineTo(21.0f, 42.597317f);
                l.cubicTo(21.0f, 43.42443f, 21.579006f, 43.74706f, 22.28357f, 43.32374f);
                l.lineTo(38.71643f, 33.450405f);
                l.cubicTo(39.425327f, 33.024483f, 40.0f, 32.006466f, 40.0f, 31.183224f);
                l.lineTo(40.0f, 13.604286f);
                l.cubicTo(40.0f, 12.77808f, 39.410534f, 12.439923f, 38.694054f, 12.842992f);
                l.lineTo(22.305946f, 22.062408f);
                l.lineTo(22.305946f, 22.062408f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                a3.setColor(-14313);
                l = c.l(looper);
                l.moveTo(17.694054f, 22.062408f);
                l.cubicTo(18.415308f, 22.468164f, 19.0f, 23.469671f, 19.0f, 24.294716f);
                l.lineTo(19.0f, 42.597317f);
                l.cubicTo(19.0f, 43.42443f, 18.420994f, 43.74706f, 17.71643f, 43.32374f);
                l.lineTo(1.2835687f, 33.450405f);
                l.cubicTo(0.5746733f, 33.024483f, 0.0f, 32.006466f, 0.0f, 31.183224f);
                l.lineTo(0.0f, 13.604286f);
                l.cubicTo(0.0f, 12.77808f, 0.5894669f, 12.439923f, 1.305947f, 12.842992f);
                l.lineTo(17.694054f, 22.062408f);
                l.lineTo(17.694054f, 22.062408f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
