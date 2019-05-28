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

/* renamed from: com.tencent.mm.boot.svg.a.a.arf */
public final class arf extends C5163c {
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
                l.moveTo(59.16f, 77.16f);
                l.cubicTo(57.65f, 77.86f, 58.16f, 79.66f, 57.99f, 80.98f);
                l.cubicTo(58.01f, 114.71f, 58.0f, 148.43f, 57.99f, 182.16f);
                l.cubicTo(60.86f, 183.35f, 64.02f, 182.9f, 67.04f, 182.95f);
                l.cubicTo(108.35f, 182.93f, 149.67f, 182.95f, 190.98f, 182.94f);
                l.cubicTo(194.25f, 182.9f, 197.55f, 183.16f, 200.8f, 182.74f);
                l.cubicTo(202.32f, 182.12f, 201.85f, 180.36f, 202.01f, 179.08f);
                l.cubicTo(201.99f, 148.7f, 202.01f, 118.33f, 202.0f, 87.95f);
                l.cubicTo(201.97f, 84.68f, 202.2f, 81.39f, 201.81f, 78.14f);
                l.cubicTo(201.13f, 76.62f, 199.33f, 77.12f, 198.02f, 76.95f);
                l.cubicTo(155.01f, 76.98f, 112.0f, 76.96f, 68.99f, 76.96f);
                l.cubicTo(65.71f, 77.0f, 62.42f, 76.76f, 59.16f, 77.16f);
                l.lineTo(59.16f, 77.16f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(64.02f, 82.96f);
                l.cubicTo(108.01f, 82.93f, 152.0f, 82.93f, 195.99f, 82.96f);
                l.cubicTo(196.01f, 105.99f, 196.01f, 129.02f, 195.98f, 152.05f);
                l.cubicTo(185.97f, 142.73f, 176.02f, 133.34f, 165.99f, 124.03f);
                l.cubicTo(159.32f, 129.34f, 152.66f, 134.66f, 146.03f, 140.01f);
                l.cubicTo(148.31f, 145.33f, 150.69f, 150.6f, 152.95f, 155.93f);
                l.cubicTo(136.6f, 140.01f, 120.34f, 124.0f, 104.03f, 108.04f);
                l.cubicTo(90.62f, 121.57f, 77.42f, 135.3f, 64.02f, 148.84f);
                l.cubicTo(63.98f, 126.88f, 63.99f, 104.92f, 64.02f, 82.96f);
                l.lineTo(64.02f, 82.96f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-3552823);
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 57.0f, 0.0f, 1.0f, 76.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(2.1695907f, 1.2352467f);
                l.cubicTo(5.42845f, 0.8355052f, 8.7172985f, 1.07535f, 11.996151f, 1.035376f);
                l.cubicTo(54.991104f, 1.035376f, 97.98605f, 1.0553629f, 140.981f, 1.0253824f);
                l.cubicTo(142.29054f, 1.1952724f, 144.08992f, 0.6955957f, 144.76968f, 2.2146132f);
                l.cubicTo(145.15955f, 5.4625125f, 144.92963f, 8.750386f, 144.95961f, 12.018272f);
                l.cubicTo(144.9696f, 42.378635f, 144.94962f, 72.729004f, 144.9696f, 103.08937f);
                l.cubicTo(144.80966f, 104.368546f, 145.27951f, 106.1274f, 143.76004f, 106.747f);
                l.cubicTo(140.51117f, 107.16673f, 137.21233f, 106.9069f, 133.94347f, 106.94688f);
                l.cubicTo(92.64793f, 106.95687f, 51.34238f, 106.93688f, 10.046834f, 106.95687f);
                l.cubicTo(7.02789f, 106.9069f, 3.868996f, 107.35661f, 1.0f, 106.16738f);
                l.cubicTo(1.0099965f, 72.45918f, 1.019993f, 38.760975f, 1.0f, 5.052778f);
                l.cubicTo(1.1699405f, 3.7336307f, 0.66011894f, 1.9347942f, 2.1695907f, 1.2352467f);
                l.lineTo(2.1695907f, 1.2352467f);
                l.close();
                l.moveTo(7.0263805f, 7.0225024f);
                l.cubicTo(6.9963827f, 28.984758f, 6.9863834f, 50.947014f, 7.0263805f, 72.90927f);
                l.cubicTo(20.425333f, 59.36788f, 33.624302f, 45.63647f, 47.033253f, 32.10508f);
                l.cubicTo(63.341976f, 48.06672f, 79.60071f, 64.07836f, 95.949425f, 80.0f);
                l.cubicTo(93.689606f, 74.66945f, 91.30979f, 69.39891f, 89.02997f, 64.07836f);
                l.cubicTo(95.65945f, 58.727814f, 102.31893f, 53.40727f, 108.98841f, 48.09672f);
                l.cubicTo(119.017624f, 57.40768f, 128.96684f, 66.798645f, 138.97606f, 76.1196f);
                l.cubicTo(139.00606f, 53.087234f, 139.00606f, 30.054869f, 138.98607f, 7.0225024f);
                l.cubicTo(94.999504f, 6.9924994f, 51.01294f, 6.9924994f, 7.0263805f, 7.0225024f);
                l.lineTo(7.0263805f, 7.0225024f);
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
