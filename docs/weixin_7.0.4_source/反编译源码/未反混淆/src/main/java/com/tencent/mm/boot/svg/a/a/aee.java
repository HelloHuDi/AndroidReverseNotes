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

public final class aee extends c {
    private final int height = 55;
    private final int width = 55;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 55;
            case 1:
                return 55;
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
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(2.0f, -3.5527137E-15f);
                l.cubicTo(6.0666566f, -0.020621631f, 10.031018f, -0.17034677f, 14.0f, -3.5527137E-15f);
                l.cubicTo(16.641615f, 1.77608f, 15.303518f, 5.678915f, 16.0f, 8.0f);
                l.cubicTo(16.01251f, 10.619844f, 18.548903f, 12.885685f, 17.0f, 15.0f);
                l.cubicTo(15.363433f, 18.066174f, 12.717196f, 20.30207f, 10.0f, 23.0f);
                l.cubicTo(15.303518f, 30.902609f, 22.14379f, 37.620277f, 30.0f, 43.0f);
                l.cubicTo(32.63886f, 40.285385f, 34.845722f, 37.720093f, 38.0f, 36.0f);
                l.cubicTo(38.879982f, 34.635757f, 40.467724f, 35.633923f, 42.0f, 36.0f);
                l.cubicTo(44.901417f, 37.30086f, 48.286602f, 36.941525f, 51.0f, 38.0f);
                l.cubicTo(53.119728f, 38.40883f, 52.929996f, 40.495f, 53.0f, 42.0f);
                l.cubicTo(52.929996f, 44.936844f, 53.15967f, 47.891422f, 53.0f, 51.0f);
                l.cubicTo(51.422142f, 53.810555f, 47.587597f, 52.83235f, 45.0f, 53.0f);
                l.cubicTo(22.583164f, 49.648197f, 3.3704917f, 30.523306f, 3.5527137E-15f, 8.0f);
                l.cubicTo(0.19500868f, 5.509227f, -0.8734715f, 1.5465014f, 2.0f, -3.5527137E-15f);
                l.lineTo(2.0f, -3.5527137E-15f);
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
