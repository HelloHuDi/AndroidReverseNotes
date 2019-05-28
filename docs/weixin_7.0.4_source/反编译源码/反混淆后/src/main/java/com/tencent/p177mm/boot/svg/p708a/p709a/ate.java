package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.ate */
public final class ate extends C5163c {
    private final int height = 80;
    private final int width = 80;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                k = C5163c.m7876a(k2, looper);
                k.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                a.setStrokeWidth(4.0f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 16.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(36.925568f, 47.054665f);
                l.cubicTo(56.11064f, 47.054665f, 71.45919f, 26.668798f, 71.45919f, 26.668798f);
                l.cubicTo(72.148895f, 25.817219f, 72.17743f, 24.403841f, 71.5037f, 23.523014f);
                l.cubicTo(71.5037f, 23.523014f, 55.69043f, 0.96764195f, 36.505352f, 0.96764195f);
                l.cubicTo(17.320274f, 0.96764195f, 1.4598377f, 23.541723f, 1.4598377f, 23.541723f);
                l.cubicTo(0.8014887f, 24.417181f, 0.84271175f, 25.819351f, 1.5628284f, 26.651388f);
                l.cubicTo(1.5628284f, 26.651388f, 17.740492f, 47.054665f, 36.925568f, 47.054665f);
                l.lineTo(36.925568f, 47.054665f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(22.42774f, 20.499218f);
                l.cubicTo(22.148413f, 21.58994f, 22.0f, 22.732264f, 22.0f, 23.908884f);
                l.cubicTo(22.0f, 31.55521f, 28.267693f, 37.75321f, 36.0f, 37.75321f);
                l.cubicTo(43.732307f, 37.75321f, 50.0f, 31.55521f, 50.0f, 23.908884f);
                l.cubicTo(50.0f, 16.262556f, 43.732307f, 10.064558f, 36.0f, 10.064558f);
                l.cubicTo(34.347454f, 10.064558f, 32.76181f, 10.347658f, 31.289946f, 10.867492f);
                l.lineTo(34.60256f, 20.195063f);
                l.lineTo(31.98528f, 23.138868f);
                l.lineTo(22.42774f, 20.499218f);
                l.lineTo(22.42774f, 20.499218f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
