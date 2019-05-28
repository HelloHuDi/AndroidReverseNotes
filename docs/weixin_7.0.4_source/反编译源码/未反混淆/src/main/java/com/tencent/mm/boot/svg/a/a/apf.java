package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class apf extends c {
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
                c.h(looper);
                c.g(looper);
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
                k = c.a(k, looper);
                k.setColor(-16384);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(47.824303f, 42.84195f);
                l.lineTo(59.648605f, 31.316103f);
                l.lineTo(43.30782f, 28.941648f);
                l.lineTo(36.0f, 14.134385f);
                l.lineTo(28.692179f, 28.941648f);
                l.lineTo(12.351395f, 31.316103f);
                l.lineTo(24.175697f, 42.84195f);
                l.lineTo(21.384357f, 59.116703f);
                l.lineTo(36.0f, 51.432808f);
                l.lineTo(50.615643f, 59.116703f);
                l.lineTo(47.824303f, 42.84195f);
                l.close();
                l.moveTo(36.0f, 55.5f);
                l.lineTo(21.983503f, 62.868908f);
                l.cubicTo(20.51697f, 63.63991f, 18.703089f, 63.076073f, 17.932085f, 61.60954f);
                l.cubicTo(17.625069f, 61.025555f, 17.519125f, 60.35665f, 17.630655f, 59.70638f);
                l.lineTo(20.307568f, 44.09878f);
                l.lineTo(8.967983f, 33.045418f);
                l.cubicTo(7.781533f, 31.888914f, 7.7572556f, 29.989574f, 8.913759f, 28.803123f);
                l.cubicTo(9.374285f, 28.330673f, 9.977713f, 28.02321f, 10.630624f, 27.928337f);
                l.lineTo(26.301544f, 25.65122f);
                l.lineTo(33.30979f, 11.450957f);
                l.cubicTo(34.04306f, 9.965197f, 35.841938f, 9.355179f, 37.327698f, 10.088447f);
                l.cubicTo(37.919334f, 10.380437f, 38.398216f, 10.85932f, 38.69021f, 11.450957f);
                l.lineTo(45.698456f, 25.65122f);
                l.lineTo(61.369377f, 27.928337f);
                l.cubicTo(63.00901f, 28.16659f, 64.14506f, 29.68892f, 63.906803f, 31.328554f);
                l.cubicTo(63.811928f, 31.981464f, 63.504467f, 32.584892f, 63.032017f, 33.045418f);
                l.lineTo(51.692432f, 44.09878f);
                l.lineTo(54.369347f, 59.70638f);
                l.cubicTo(54.64943f, 61.33939f, 53.552666f, 62.890255f, 51.919655f, 63.170338f);
                l.cubicTo(51.269382f, 63.281868f, 50.60048f, 63.175926f, 50.0165f, 62.868908f);
                l.lineTo(36.0f, 55.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
