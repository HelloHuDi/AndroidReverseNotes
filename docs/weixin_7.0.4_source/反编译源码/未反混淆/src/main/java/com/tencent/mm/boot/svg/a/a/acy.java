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

public final class acy extends c {
    private final int height = 48;
    private final int width = 48;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-65794);
                g = c.a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 9.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(38.485332f, 0.0f);
                l.cubicTo(39.240726f, 0.101668164f, 39.99612f, 0.20333633f, 40.751514f, 0.30500448f);
                l.cubicTo(40.83103f, 1.0878494f, 40.920486f, 1.8706942f, 41.0f, 2.653539f);
                l.cubicTo(39.270546f, 3.4770513f, 38.048f, 4.98174f, 36.736f, 6.3339267f);
                l.cubicTo(29.221819f, 14.182709f, 21.498909f, 21.817987f, 14.094061f, 29.768438f);
                l.cubicTo(11.698667f, 30.886787f, 10.595394f, 27.65374f, 9.02497f, 26.47439f);
                l.cubicTo(5.953697f, 23.678514f, 3.4986668f, 20.130297f, 0.0f, 17.88343f);
                l.cubicTo(0.09939394f, 17.141253f, 0.20872727f, 16.40924f, 0.3180606f, 15.677231f);
                l.cubicTo(1.0635152f, 15.58573f, 1.7990303f, 15.494228f, 2.5345454f, 15.402727f);
                l.cubicTo(4.6317577f, 18.666275f, 8.011151f, 20.76064f, 10.158061f, 23.973352f);
                l.cubicTo(11.002909f, 26.037216f, 14.004606f, 26.545557f, 15.266909f, 24.634195f);
                l.cubicTo(20.554667f, 18.564606f, 26.438787f, 13.074526f, 31.965092f, 7.2387733f);
                l.cubicTo(34.131878f, 4.819071f, 36.875153f, 2.8873758f, 38.485332f, 0.0f);
                l.lineTo(38.485332f, 0.0f);
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
