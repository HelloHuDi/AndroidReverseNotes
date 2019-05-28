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

/* renamed from: com.tencent.mm.boot.svg.a.a.lt */
public final class C25909lt extends C5163c {
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, -449.0f, 0.0f, 1.0f, -309.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 459.0f, 0.0f, 1.0f, 319.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(10.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(240.0f, 121.48148f);
                l.cubicTo(240.0f, 53.724445f, 186.27556f, 0.0f, 118.51852f, 0.0f);
                l.cubicTo(53.724445f, 0.0f, 0.0f, 53.724445f, 0.0f, 121.48148f);
                l.cubicTo(0.0f, 186.27556f, 53.724445f, 240.0f, 118.51852f, 240.0f);
                l.cubicTo(186.27556f, 240.0f, 240.0f, 186.27556f, 240.0f, 121.48148f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(62.89717f, 128.89716f);
                l.cubicTo(62.320534f, 128.30037f, 62.253185f, 127.272156f, 62.745144f, 126.60276f);
                l.lineTo(67.678764f, 119.88967f);
                l.cubicTo(68.17144f, 119.2193f, 69.10391f, 119.084435f, 69.767876f, 119.59332f);
                l.lineTo(100.458435f, 143.11588f);
                l.cubicTo(101.119545f, 143.62259f, 102.17168f, 143.60332f, 102.81298f, 143.06906f);
                l.lineTo(178.11874f, 80.33327f);
                l.cubicTo(178.75801f, 79.800705f, 179.75937f, 79.846115f, 180.34068f, 80.42023f);
                l.lineTo(184.92955f, 84.95216f);
                l.cubicTo(185.51743f, 85.53275f, 185.51967f, 86.470215f, 184.92761f, 87.05289f);
                l.lineTo(102.71939f, 167.95805f);
                l.cubicTo(102.13045f, 168.53767f, 101.192276f, 168.5307f, 100.60892f, 167.92696f);
                l.lineTo(62.89717f, 128.89716f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
