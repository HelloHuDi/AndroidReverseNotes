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

/* renamed from: com.tencent.mm.boot.svg.a.a.ww */
public final class C9167ww extends C5163c {
    private final int height = 144;
    private final int width = 144;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-15028967);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(41.62317f, 65.78919f);
                l.lineTo(41.9778f, 65.99241f);
                l.cubicTo(51.303997f, 69.16349f, 62.08437f, 65.1643f, 67.361f, 56.093422f);
                l.lineTo(68.91121f, 53.428516f);
                l.lineTo(65.56606f, 51.511677f);
                l.lineTo(64.015854f, 54.176582f);
                l.cubicTo(59.03817f, 62.73355f, 48.512413f, 65.72372f, 40.710613f, 61.253113f);
                l.cubicTo(32.254654f, 56.407665f, 29.600893f, 45.86535f, 34.57858f, 37.30838f);
                l.lineTo(36.128788f, 34.643475f);
                l.lineTo(36.274845f, 34.194435f);
                l.lineTo(32.78364f, 32.726635f);
                l.lineTo(31.233435f, 35.39154f);
                l.cubicTo(26.03302f, 44.331394f, 27.804018f, 55.403114f, 34.96902f, 61.87707f);
                l.lineTo(29.981249f, 70.51614f);
                l.lineTo(30.39813f, 75.44433f);
                l.cubicTo(30.483181f, 76.449745f, 31.284433f, 76.90377f, 32.189484f, 76.47857f);
                l.lineTo(36.66586f, 74.3755f);
                l.lineTo(41.62317f, 65.78919f);
                l.close();
                l.moveTo(96.0f, 48.0f);
                l.cubicTo(96.0f, 74.51105f, 74.50971f, 96.0f, 48.0f, 96.0f);
                l.cubicTo(21.490286f, 96.0f, 0.0f, 74.51105f, 0.0f, 48.0f);
                l.cubicTo(0.0f, 21.488955f, 21.490286f, 0.0f, 48.0f, 0.0f);
                l.cubicTo(74.50971f, 0.0f, 96.0f, 21.488955f, 96.0f, 48.0f);
                l.close();
                l.moveTo(63.940453f, 21.10892f);
                l.cubicTo(58.015858f, 17.731424f, 50.43693f, 19.741205f, 47.023098f, 25.57968f);
                l.lineTo(38.81864f, 39.61127f);
                l.cubicTo(35.400043f, 45.457897f, 37.430252f, 52.934784f, 43.35615f, 56.31302f);
                l.cubicTo(49.280746f, 59.690514f, 56.859673f, 57.680733f, 60.273506f, 51.84226f);
                l.lineTo(68.47796f, 37.81067f);
                l.cubicTo(71.89656f, 31.96404f, 69.866356f, 24.487156f, 63.940453f, 21.10892f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
