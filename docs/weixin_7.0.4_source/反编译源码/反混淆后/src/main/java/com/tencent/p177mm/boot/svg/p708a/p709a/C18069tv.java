package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.tv */
public final class C18069tv extends C5163c {
    private final int height = 210;
    private final int width = 285;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 285;
            case 1:
                return 210;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 25, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(228.0f, 94.73752f);
                l.lineTo(228.0f, 12.0f);
                l.lineTo(12.0f, 12.0f);
                l.lineTo(12.0f, 119.51874f);
                l.lineTo(80.73831f, 55.335876f);
                l.lineTo(162.56027f, 130.40851f);
                l.lineTo(150.84477f, 106.321465f);
                l.lineTo(184.2155f, 80.51195f);
                l.lineTo(206.87204f, 100.85361f);
                l.cubicTo(187.48631f, 110.75349f, 174.0f, 131.23582f, 174.0f, 155.24074f);
                l.cubicTo(174.0f, 166.45111f, 177.2164f, 176.99875f, 182.76556f, 186.00002f);
                l.lineTo(5.9924946f, 186.0f);
                l.cubicTo(2.6953125f, 186.0f, 0.0f, 183.3119f, 0.0f, 179.99596f);
                l.lineTo(0.0f, 6.004041f);
                l.cubicTo(0.0f, 2.6830428f, 2.6829312f, 1.364242E-12f, 5.9924946f, 1.364242E-12f);
                l.lineTo(234.0075f, 1.364242E-12f);
                l.cubicTo(237.30469f, 1.364242E-12f, 240.0f, 2.6881008f, 240.0f, 6.004041f);
                l.lineTo(240.0f, 94.85917f);
                l.cubicTo(237.78893f, 94.62174f, 235.54f, 94.5f, 233.25926f, 94.5f);
                l.cubicTo(231.48848f, 94.5f, 229.73422f, 94.58025f, 228.0f, 94.73752f);
                l.lineTo(228.0f, 94.73752f);
                l.close();
                l.moveTo(283.0f, 155.11111f);
                l.cubicTo(283.0f, 127.16133f, 260.83865f, 105.0f, 232.88889f, 105.0f);
                l.cubicTo(206.16133f, 105.0f, 184.0f, 127.16133f, 184.0f, 155.11111f);
                l.cubicTo(184.0f, 181.83867f, 206.16133f, 204.0f, 232.88889f, 204.0f);
                l.cubicTo(260.83865f, 204.0f, 283.0f, 181.83867f, 283.0f, 155.11111f);
                l.close();
                l.moveTo(233.5f, 178.58653f);
                l.cubicTo(235.98528f, 178.58653f, 238.0f, 176.55244f, 238.0f, 174.04327f);
                l.cubicTo(238.0f, 171.53409f, 235.98528f, 169.5f, 233.5f, 169.5f);
                l.cubicTo(231.01472f, 169.5f, 229.0f, 171.53409f, 229.0f, 174.04327f);
                l.cubicTo(229.0f, 176.55244f, 231.01472f, 178.58653f, 233.5f, 178.58653f);
                l.close();
                l.moveTo(230.34857f, 129.0f);
                l.cubicTo(229.52448f, 129.0f, 228.88528f, 129.6712f, 228.92096f, 130.50104f);
                l.lineTo(230.32753f, 163.21475f);
                l.cubicTo(230.36992f, 164.20071f, 231.20103f, 165.0f, 232.19511f, 165.0f);
                l.lineTo(234.80493f, 165.0f);
                l.cubicTo(235.79398f, 165.0f, 236.63025f, 164.19762f, 236.67252f, 163.21475f);
                l.lineTo(238.07909f, 130.50104f);
                l.cubicTo(238.11473f, 129.67204f, 237.47571f, 129.0f, 236.65147f, 129.0f);
                l.lineTo(230.34857f, 129.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
