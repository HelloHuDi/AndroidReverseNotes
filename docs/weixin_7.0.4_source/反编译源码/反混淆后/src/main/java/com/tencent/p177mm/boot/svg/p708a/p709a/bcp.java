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

/* renamed from: com.tencent.mm.boot.svg.a.a.bcp */
public final class bcp extends C5163c {
    private final int height = 696;
    private final int width = 540;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 540;
            case 1:
                return 696;
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
                canvas.saveLayerAlpha(null, 51, 4);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                g = C5163c.m7878a(g, 0.70710677f, 0.70710677f, 0.10347748f, -0.70710677f, 0.70710677f, 314.05887f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(338.17682f, 421.62106f);
                l.lineTo(105.54254f, 421.62106f);
                l.cubicTo(69.57901f, 369.38614f, -1.5916157E-12f, 314.71432f, -1.5916157E-12f, 224.86458f);
                l.cubicTo(-1.5916157E-12f, 100.6753f, 99.32996f, 1.3195332E-12f, 221.85968f, 1.364242E-12f);
                l.cubicTo(344.3894f, 1.3704833E-12f, 443.71936f, 100.6753f, 443.71936f, 224.86458f);
                l.cubicTo(443.71936f, 314.71432f, 374.14035f, 369.38614f, 338.17682f, 421.62106f);
                l.close();
                l.moveTo(144.20879f, 451.20853f);
                l.lineTo(299.51056f, 451.20853f);
                l.cubicTo(305.63705f, 451.20853f, 310.60355f, 456.17606f, 310.60355f, 462.3038f);
                l.lineTo(310.60355f, 469.70065f);
                l.cubicTo(310.60355f, 475.82843f, 305.63705f, 480.79596f, 299.51056f, 480.79596f);
                l.lineTo(144.20879f, 480.79596f);
                l.cubicTo(138.0823f, 480.79596f, 133.11581f, 475.82843f, 133.11581f, 469.70065f);
                l.lineTo(133.11581f, 462.3038f);
                l.cubicTo(133.11581f, 456.17606f, 138.0823f, 451.20853f, 144.20879f, 451.20853f);
                l.close();
                l.moveTo(166.39476f, 510.3834f);
                l.lineTo(277.3246f, 510.3834f);
                l.cubicTo(283.45108f, 510.3834f, 288.41757f, 515.35095f, 288.41757f, 521.4787f);
                l.lineTo(288.41757f, 528.87555f);
                l.cubicTo(288.41757f, 535.0033f, 283.45108f, 539.9708f, 277.3246f, 539.9708f);
                l.lineTo(166.39476f, 539.9708f);
                l.cubicTo(160.26828f, 539.9708f, 155.30177f, 535.0033f, 155.30177f, 528.87555f);
                l.lineTo(155.30177f, 521.4787f);
                l.cubicTo(155.30177f, 515.35095f, 160.26828f, 510.3834f, 166.39476f, 510.3834f);
                l.close();
                l.moveTo(228.58931f, 274.01355f);
                l.cubicTo(234.95694f, 286.75146f, 253.13435f, 286.75146f, 259.50198f, 274.01355f);
                l.lineTo(288.41757f, 216.17035f);
                l.lineTo(317.33316f, 274.01355f);
                l.cubicTo(321.60043f, 282.54987f, 331.97977f, 286.0106f, 340.51608f, 281.74335f);
                l.cubicTo(349.0524f, 277.47607f, 352.51312f, 267.09674f, 348.24585f, 258.56042f);
                l.lineTo(303.87393f, 169.7981f);
                l.cubicTo(297.5063f, 157.06018f, 279.32886f, 157.06018f, 272.96124f, 169.7981f);
                l.lineTo(244.04565f, 227.64131f);
                l.lineTo(215.13005f, 169.7981f);
                l.cubicTo(208.76242f, 157.06018f, 190.58499f, 157.06018f, 184.21736f, 169.7981f);
                l.lineTo(155.30177f, 227.64131f);
                l.lineTo(126.386185f, 169.7981f);
                l.cubicTo(122.11892f, 161.2618f, 111.73958f, 157.80106f, 103.20328f, 162.06831f);
                l.cubicTo(94.66697f, 166.33559f, 91.20623f, 176.71492f, 95.473495f, 185.25122f);
                l.lineTo(139.84543f, 274.01355f);
                l.cubicTo(146.21306f, 286.75146f, 164.39049f, 286.75146f, 170.75812f, 274.01355f);
                l.lineTo(199.6737f, 216.17035f);
                l.lineTo(228.58931f, 274.01355f);
                l.close();
                canvas.saveLayerAlpha(null, C31128d.MIC_SketchMark, 4);
                k = C5163c.m7876a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
