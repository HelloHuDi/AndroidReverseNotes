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

public final class aes extends c {
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
                a.setColor(-12206054);
                g = c.a(g, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 21.0f);
                l.cubicTo(6.57101f, 9.043519f, 19.245094f, 0.23467484f, 33.0f, 0.0f);
                l.cubicTo(47.52035f, -0.5352242f, 61.110394f, 8.483593f, 68.0f, 21.0f);
                l.cubicTo(61.57833f, 32.60043f, 49.461784f, 41.279293f, 36.0f, 42.0f);
                l.cubicTo(21.216398f, 42.959072f, 7.0190334f, 33.850266f, 0.0f, 21.0f);
                l.lineTo(0.0f, 21.0f);
                l.close();
                l.moveTo(30.0f, 10.0f);
                l.cubicTo(25.925423f, 10.998532f, 22.441738f, 15.190254f, 22.0f, 20.0f);
                l.cubicTo(21.223944f, 26.657608f, 27.203108f, 33.174736f, 34.0f, 33.0f);
                l.cubicTo(40.80845f, 33.204678f, 46.76765f, 26.667587f, 46.0f, 20.0f);
                l.cubicTo(45.479984f, 12.565438f, 37.35471f, 7.156121f, 30.0f, 10.0f);
                l.lineTo(30.0f, 10.0f);
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
