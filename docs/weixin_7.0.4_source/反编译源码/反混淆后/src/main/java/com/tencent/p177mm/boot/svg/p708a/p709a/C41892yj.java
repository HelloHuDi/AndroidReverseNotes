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

/* renamed from: com.tencent.mm.boot.svg.a.a.yj */
public final class C41892yj extends C5163c {
    private final int height = 111;
    private final int width = 121;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 121;
            case 1:
                return 111;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1203649);
                float[] a3 = C5163c.m7878a(g, 0.89879405f, -0.43837115f, 30.552965f, 0.43837115f, 0.89879405f, -20.803411f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                Path l = C5163c.m7884l(looper);
                l.moveTo(31.45411f, 18.344019f);
                l.lineTo(106.61748f, 45.577366f);
                l.cubicTo(108.504364f, 46.26103f, 109.47725f, 48.337948f, 108.79048f, 50.216293f);
                l.lineTo(93.868355f, 91.02885f);
                l.cubicTo(93.18159f, 92.90719f, 91.09522f, 93.87567f, 89.20833f, 93.19201f);
                l.lineTo(14.044966f, 65.958664f);
                l.cubicTo(12.158075f, 65.275f, 11.185187f, 63.198082f, 11.871959f, 61.319736f);
                l.lineTo(26.794083f, 20.507185f);
                l.cubicTo(27.480854f, 18.62884f, 29.56722f, 17.660357f, 31.45411f, 18.344019f);
                l.close();
                canvas.saveLayerAlpha(null, 108, 4);
                k = C5163c.m7876a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(-1203649);
                a.setStrokeWidth(2.216448f);
                a.setStrokeCap(Cap.ROUND);
                a.setStrokeJoin(Join.MITER);
                g = C5163c.m7878a(a3, 0.9975641f, 0.06975647f, -3.4536302f, -0.06975647f, 0.9975641f, 4.806033f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(72.30296f, 21.229805f);
                l.cubicTo(78.113754f, 18.189999f, 84.32468f, 16.44265f, 90.93574f, 15.98776f);
                l.cubicTo(101.13679f, 15.921063f, 109.227806f, 19.061852f, 112.95436f, 25.4872f);
                l.cubicTo(120.7427f, 38.915913f, 106.51804f, 61.60616f, 81.18271f, 76.16729f);
                l.cubicTo(55.84737f, 90.72842f, 28.995327f, 91.64642f, 21.20699f, 78.21771f);
                l.cubicTo(20.278666f, 76.61709f, 19.663086f, 74.88489f, 19.341787f, 73.05055f);
                l.cubicTo(18.844284f, 69.116264f, 19.076675f, 65.80797f, 20.03896f, 63.125668f);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
