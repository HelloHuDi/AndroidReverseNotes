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
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.yn */
public final class C25958yn extends C5163c {
    private final int height = 18;
    private final int width = 19;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 19;
            case 1:
                return 18;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Paint a2 = C5163c.m7876a(k2, looper);
                a.setColor(-15616);
                a2.setColor(-15616);
                a2.setStrokeWidth(1.2f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -321.0f, 0.0f, 1.0f, -308.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 227.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 49.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 16.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 60.0f, 0.0f, 1.0f, 13.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                a = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(245.3613f, 20.165895f);
                l.lineTo(250.31267f, 17.562805f);
                l.lineTo(255.26404f, 20.165895f);
                l.cubicTo(255.34189f, 20.206831f, 255.43108f, 20.220957f, 255.51779f, 20.206087f);
                l.cubicTo(255.73552f, 20.168741f, 255.88176f, 19.96196f, 255.8444f, 19.744225f);
                l.lineTo(254.89879f, 14.230793f);
                l.lineTo(258.90454f, 10.326159f);
                l.cubicTo(258.96753f, 10.264755f, 259.0085f, 10.1842985f, 259.02118f, 10.097244f);
                l.cubicTo(259.05292f, 9.878626f, 258.90146f, 9.675649f, 258.68283f, 9.643882f);
                l.lineTo(253.14703f, 8.839482f);
                l.lineTo(250.67136f, 3.8231966f);
                l.cubicTo(250.63242f, 3.7443118f, 250.56857f, 3.6804607f, 250.48969f, 3.6415286f);
                l.cubicTo(250.29158f, 3.5437596f, 250.05174f, 3.6250954f, 249.95396f, 3.8231966f);
                l.lineTo(247.47829f, 8.839482f);
                l.lineTo(241.94247f, 9.643882f);
                l.cubicTo(241.85542f, 9.656531f, 241.77496f, 9.697526f, 241.71356f, 9.76052f);
                l.cubicTo(241.55937f, 9.918714f, 241.5626f, 10.171959f, 241.7208f, 10.326159f);
                l.lineTo(245.72653f, 14.230793f);
                l.lineTo(244.78091f, 19.744225f);
                l.cubicTo(244.76604f, 19.830929f, 244.78017f, 19.920115f, 244.8211f, 19.99798f);
                l.cubicTo(244.9239f, 20.193518f, 245.16576f, 20.268696f, 245.3613f, 20.165895f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
