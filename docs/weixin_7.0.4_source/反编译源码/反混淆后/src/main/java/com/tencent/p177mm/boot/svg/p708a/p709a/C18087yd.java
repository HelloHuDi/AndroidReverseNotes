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

/* renamed from: com.tencent.mm.boot.svg.a.a.yd */
public final class C18087yd extends C5163c {
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                Paint a3 = C5163c.m7876a(a, looper);
                a2.setColor(-3355444);
                a3.setColor(-3355444);
                a3.setStrokeWidth(7.2f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(92.369286f, 78.0f);
                l.cubicTo(93.36996f, 78.0f, 94.17655f, 78.0f, 94.74467f, 78.0f);
                l.cubicTo(100.38519f, 78.0f, 105.0f, 73.14446f, 105.0f, 67.20963f);
                l.lineTo(105.0f, 41.733364f);
                l.cubicTo(104.99974f, 21.032589f, 89.9217f, 17.842987f, 89.9217f, 17.842987f);
                l.cubicTo(77.42418f, 8.975469f, 60.47346f, 10.228277f, 49.229244f, 21.416538f);
                l.cubicTo(42.93049f, 27.68936f, 39.0f, 36.56798f, 39.0f, 46.414097f);
                l.cubicTo(39.0f, 53.15504f, 39.0f, 61.260597f, 39.0f, 67.20963f);
                l.cubicTo(39.0f, 73.14446f, 43.614807f, 78.0f, 49.25533f, 78.0f);
                l.cubicTo(49.82396f, 78.0f, 50.56814f, 78.0f, 51.45837f, 78.0f);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-3355444);
                a2.setStrokeWidth(4.8f);
                a2.setStrokeCap(Cap.ROUND);
                a2.setStrokeJoin(Join.MITER);
                l = C5163c.m7884l(looper);
                l.moveTo(121.4364f, 135.0f);
                l.cubicTo(120.62577f, 131.00125f, 119.10564f, 123.8438f, 116.2644f, 109.924065f);
                l.cubicTo(114.56845f, 101.70597f, 109.70799f, 101.61865f, 91.0715f, 96.25609f);
                l.lineTo(84.50926f, 91.92681f);
                l.cubicTo(84.50926f, 90.28905f, 84.50926f, 87.91856f, 84.50926f, 86.28571f);
                l.moveTo(60.516712f, 86.28571f);
                l.cubicTo(60.436764f, 88.272484f, 60.436764f, 89.957146f, 60.436764f, 91.92681f);
                l.lineTo(53.874256f, 96.25583f);
                l.cubicTo(38.58901f, 100.65403f, 65.34742f, 92.95492f, 37.80226f, 100.880226f);
                l.cubicTo(32.92215f, 102.690025f, 29.831207f, 104.25006f, 28.681366f, 109.923805f);
                l.cubicTo(28.677187f, 109.944f, 25.258446f, 126.16524f, 23.55f, 135.0f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-3355444);
                a2.setStrokeWidth(4.8f);
                a2.setStrokeCap(Cap.ROUND);
                a2.setStrokeJoin(Join.MITER);
                l = C5163c.m7884l(looper);
                l.moveTo(53.55265f, 96.52247f);
                l.cubicTo(51.427998f, 98.40346f, 50.553375f, 109.06194f, 57.91203f, 112.0068f);
                l.lineTo(72.0f, 114.85714f);
                l.lineTo(59.999092f, 92.0f);
                l.cubicTo(57.618565f, 93.31773f, 55.469753f, 94.825226f, 53.55265f, 96.52247f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-3355444);
                a2.setStrokeWidth(4.8f);
                a2.setStrokeCap(Cap.ROUND);
                a2.setStrokeJoin(Join.MITER);
                float[] a4 = C5163c.m7878a(g, -1.0f, 0.0f, 165.4158f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a4);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(73.502655f, 96.52247f);
                l.cubicTo(71.378f, 98.40346f, 70.50338f, 109.06194f, 77.86203f, 112.0068f);
                l.lineTo(93.415794f, 114.85714f);
                l.lineTo(79.94909f, 92.0f);
                l.cubicTo(77.568565f, 93.31773f, 75.419754f, 94.825226f, 73.502655f, 96.52247f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a5 = C5163c.m7876a(k, looper);
                Paint a6 = C5163c.m7876a(a, looper);
                a5.setColor(-1);
                a6.setColor(-3355444);
                a6.setStrokeWidth(4.8f);
                l = C5163c.m7884l(looper);
                l.moveTo(47.77502f, 46.752438f);
                l.cubicTo(47.77937f, 58.12536f, 47.762238f, 64.51261f, 47.80289f, 65.10938f);
                l.cubicTo(49.16201f, 83.59138f, 66.038765f, 93.15057f, 80.46189f, 87.54872f);
                l.cubicTo(89.74051f, 83.94656f, 96.20579f, 74.66034f, 96.20579f, 63.93846f);
                l.lineTo(96.20579f, 46.752438f);
                l.cubicTo(96.20579f, 46.752438f, 96.63275f, 39.90889f, 93.46121f, 34.02342f);
                l.cubicTo(92.40173f, 32.057518f, 89.9724f, 31.401417f, 88.139786f, 32.60267f);
                l.cubicTo(84.68677f, 34.86576f, 78.03971f, 37.801712f, 68.67314f, 35.638126f);
                l.cubicTo(54.432304f, 32.34832f, 47.77502f, 46.752438f, 47.77502f, 46.752438f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a5);
                canvas.drawPath(l, a6);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
