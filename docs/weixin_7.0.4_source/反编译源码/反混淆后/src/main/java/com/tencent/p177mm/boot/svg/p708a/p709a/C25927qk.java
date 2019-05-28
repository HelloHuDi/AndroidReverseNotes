package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.qk */
public final class C25927qk extends C5163c {
    private final int height = C33250az.CTRL_INDEX;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return C33250az.CTRL_INDEX;
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
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-14187817);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(192.0f, 0.0f);
                l.lineTo(192.0f, 192.0f);
                l.lineTo(0.0f, 192.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(110.90694f, 140.57062f);
                l2.cubicTo(115.39648f, 133.81949f, 120.514946f, 125.826996f, 125.18189f, 117.83344f);
                l2.cubicTo(132.5147f, 105.2738f, 118.942276f, 91.864136f, 121.05859f, 88.2393f);
                l2.lineTo(133.6816f, 66.618614f);
                l2.lineTo(137.24696f, 68.6542f);
                l2.lineTo(140.59984f, 62.91139f);
                l2.lineTo(114.816216f, 48.190643f);
                l2.lineTo(111.46334f, 53.933456f);
                l2.lineTo(113.825035f, 55.28183f);
                l2.lineTo(113.825035f, 55.28183f);
                l2.cubicTo(110.083145f, 61.69095f, 102.824165f, 74.12414f, 101.20204f, 76.90253f);
                l2.cubicTo(98.99318f, 80.68586f, 81.064964f, 75.49447f, 73.554855f, 88.35781f);
                l2.cubicTo(67.73289f, 98.32967f, 53.740925f, 118.98361f, 48.758373f, 126.291245f);
                l2.cubicTo(59.07041f, 125.45091f, 74.24749f, 125.95091f, 88.1873f, 133.06181f);
                l2.cubicTo(96.19743f, 137.1479f, 103.822685f, 139.4944f, 110.90694f, 140.57062f);
                l2.lineTo(110.90694f, 140.57062f);
                l2.close();
                l2.moveTo(132.08064f, 36.41379f);
                l2.lineTo(124.87423f, 49.809467f);
                l2.lineTo(135.35979f, 56.026367f);
                l2.lineTo(149.97533f, 45.104786f);
                l2.lineTo(132.08064f, 36.41379f);
                l2.close();
                l2.moveTo(157.39185f, 138.754f);
                l2.cubicTo(157.39185f, 138.754f, 137.7422f, 158.59561f, 114.86281f, 158.59561f);
                l2.cubicTo(65.0383f, 158.59561f, 84.342834f, 136.6334f, 26.48276f, 134.37212f);
                l2.cubicTo(26.479265f, 134.37747f, 58.087933f, 125.80052f, 85.2693f, 138.754f);
                l2.cubicTo(126.68277f, 158.48987f, 157.39185f, 138.754f, 157.39185f, 138.754f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
