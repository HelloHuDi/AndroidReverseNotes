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
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.boot.svg.a.a.arj */
public final class arj extends C5163c {
    private final int height = C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW;
    private final int width = C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW;
            case 1:
                return C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(260.0f, 0.0f);
                l.lineTo(260.0f, 260.0f);
                l.lineTo(0.0f, 260.0f);
                l.lineTo(0.0f, 0.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                l.moveTo(98.02f, 72.03f);
                l.cubicTo(85.5f, 76.81f, 75.4f, 87.31f, 70.88f, 99.9f);
                l.cubicTo(66.49f, 111.86f, 67.2f, 125.65f, 73.08f, 136.99f);
                l.cubicTo(79.02f, 148.74f, 90.29f, 157.6f, 103.09f, 160.64f);
                l.cubicTo(115.81f, 163.78f, 129.85f, 161.26f, 140.54f, 153.65f);
                l.cubicTo(142.41f, 152.25f, 144.09f, 150.58f, 146.13f, 149.41f);
                l.cubicTo(147.9f, 150.37f, 149.1f, 152.06f, 150.51f, 153.45f);
                l.cubicTo(162.66f, 165.65f, 174.87f, 177.79f, 187.01f, 190.01f);
                l.cubicTo(188.23f, 191.37f, 190.48f, 192.71f, 191.99f, 190.93f);
                l.cubicTo(193.72f, 189.38f, 192.36f, 187.22f, 191.01f, 186.0f);
                l.cubicTo(177.32f, 172.33f, 163.64f, 158.63f, 149.95f, 144.95f);
                l.cubicTo(156.94f, 135.91f, 160.7f, 124.4f, 159.85f, 112.96f);
                l.cubicTo(158.95f, 96.64f, 148.92f, 81.17f, 134.28f, 73.86f);
                l.cubicTo(123.17f, 68.16f, 109.65f, 67.51f, 98.02f, 72.03f);
                l.lineTo(98.02f, 72.03f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(108.33f, 75.44f);
                l.cubicTo(117.0f, 74.15f, 126.1f, 75.84f, 133.67f, 80.27f);
                l.cubicTo(143.51f, 85.92f, 150.64f, 95.93f, 153.01f, 107.01f);
                l.cubicTo(155.37f, 117.63f, 153.42f, 129.23f, 147.35f, 138.32f);
                l.cubicTo(142.12f, 146.27f, 133.9f, 152.19f, 124.69f, 154.6f);
                l.cubicTo(114.09f, 157.45f, 102.33f, 155.86f, 92.97f, 150.09f);
                l.cubicTo(84.61f, 145.0f, 78.28f, 136.71f, 75.61f, 127.29f);
                l.cubicTo(72.13f, 115.35f, 74.47f, 101.89f, 81.78f, 91.83f);
                l.cubicTo(87.96f, 83.11f, 97.72f, 76.97f, 108.33f, 75.44f);
                l.lineTo(108.33f, 75.44f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-3552823);
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 68.0f, 0.0f, 1.0f, 69.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(30.02f, 3.03f);
                l.cubicTo(41.65f, -1.49f, 55.17f, -0.84f, 66.28f, 4.86f);
                l.cubicTo(80.92f, 12.17f, 90.95f, 27.64f, 91.85f, 43.96f);
                l.cubicTo(92.7f, 55.4f, 88.94f, 66.91f, 81.95f, 75.95f);
                l.cubicTo(95.64f, 89.63f, 109.32f, 103.33f, 123.01f, 117.0f);
                l.cubicTo(124.36f, 118.22f, 125.72f, 120.38f, 123.99f, 121.93f);
                l.cubicTo(122.48f, 123.71f, 120.23f, 122.37f, 119.01f, 121.01f);
                l.cubicTo(106.87f, 108.79f, 94.66f, 96.65f, 82.51f, 84.45f);
                l.cubicTo(81.1f, 83.06f, 79.9f, 81.37f, 78.13f, 80.41f);
                l.cubicTo(76.09f, 81.58f, 74.41f, 83.25f, 72.54f, 84.65f);
                l.cubicTo(61.85f, 92.26f, 47.81f, 94.78f, 35.09f, 91.64f);
                l.cubicTo(22.29f, 88.6f, 11.02f, 79.74f, 5.08f, 67.99f);
                l.cubicTo(-0.8f, 56.65f, -1.51f, 42.86f, 2.88f, 30.9f);
                l.cubicTo(7.4f, 18.31f, 17.5f, 7.81f, 30.02f, 3.03f);
                l.lineTo(30.02f, 3.03f);
                l.close();
                l.moveTo(40.33f, 6.44f);
                l.cubicTo(29.72f, 7.97f, 19.96f, 14.11f, 13.78f, 22.83f);
                l.cubicTo(6.47f, 32.89f, 4.13f, 46.35f, 7.61f, 58.29f);
                l.cubicTo(10.28f, 67.71f, 16.61f, 76.0f, 24.97f, 81.09f);
                l.cubicTo(34.33f, 86.86f, 46.09f, 88.45f, 56.69f, 85.6f);
                l.cubicTo(65.9f, 83.19f, 74.12f, 77.27f, 79.35f, 69.32f);
                l.cubicTo(85.42f, 60.23f, 87.37f, 48.63f, 85.01f, 38.01f);
                l.cubicTo(82.64f, 26.93f, 75.51f, 16.92f, 65.67f, 11.27f);
                l.cubicTo(58.1f, 6.84f, 49.0f, 5.15f, 40.33f, 6.44f);
                l.lineTo(40.33f, 6.44f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
