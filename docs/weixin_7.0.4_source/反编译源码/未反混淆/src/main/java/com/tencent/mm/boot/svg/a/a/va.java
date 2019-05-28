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

public final class va extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-11615450);
                g = c.a(g, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(2.1112194f, 10.565054f);
                l.cubicTo(4.587666f, 6.591597f, 8.452122f, 3.6065128f, 12.426419f, 1.2503928f);
                l.cubicTo(14.263783f, 0.21210259f, 15.3522215f, 2.6680582f, 16.330818f, 3.7762334f);
                l.cubicTo(18.937078f, 7.849526f, 22.262306f, 11.45359f, 24.48911f, 15.746521f);
                l.cubicTo(22.951319f, 19.690027f, 17.718826f, 20.53863f, 14.313711f, 22.535341f);
                l.cubicTo(15.721691f, 27.826628f, 19.156763f, 32.249344f, 22.871433f, 36.152916f);
                l.cubicTo(27.245157f, 40.69544f, 32.267952f, 44.898514f, 38.409138f, 46.75546f);
                l.cubicTo(40.096718f, 43.281178f, 41.464756f, 39.487427f, 44.190845f, 36.66208f);
                l.cubicTo(45.83848f, 36.172886f, 47.17656f, 37.660435f, 48.49467f, 38.419186f);
                l.cubicTo(52.08951f, 41.23455f, 56.06381f, 43.56072f, 59.52884f, 46.53582f);
                l.cubicTo(60.647232f, 47.71388f, 59.508865f, 49.14153f, 58.84981f, 50.199787f);
                l.cubicTo(56.333424f, 53.624146f, 53.677235f, 57.22821f, 49.81278f, 59.224922f);
                l.cubicTo(46.797104f, 60.81231f, 43.34206f, 59.654217f, 40.39629f, 58.48614f);
                l.cubicTo(23.520502f, 51.367863f, 9.690345f, 37.480732f, 2.520632f, 20.638466f);
                l.cubicTo(1.1725662f, 17.503628f, 0.10409919f, 13.679925f, 2.1112194f, 10.565054f);
                l.lineTo(2.1112194f, 10.565054f);
                l.lineTo(2.1112194f, 10.565054f);
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
