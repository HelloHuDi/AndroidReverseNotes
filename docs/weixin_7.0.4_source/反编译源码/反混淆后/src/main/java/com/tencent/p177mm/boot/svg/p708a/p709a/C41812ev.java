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

/* renamed from: com.tencent.mm.boot.svg.a.a.ev */
public final class C41812ev extends C5163c {
    private final int height = 80;
    private final int width = 84;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 80;
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
                a.setColor(-13882324);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -1347.0f, 0.0f, 1.0f, -215.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1250.0f, 0.0f, 1.0f, 215.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(131.0f, 51.0f);
                l.lineTo(131.0f, 64.0f);
                l.cubicTo(131.0f, 65.044205f, 132.50389f, 66.62656f, 134.0f, 66.0f);
                l.lineTo(158.0f, 66.0f);
                l.lineTo(169.0f, 76.0f);
                l.cubicTo(169.0921f, 76.41986f, 169.86208f, 76.09059f, 170.0f, 74.0f);
                l.lineTo(170.0f, 66.0f);
                l.lineTo(177.0f, 66.0f);
                l.cubicTo(178.48862f, 66.62656f, 180.0f, 65.03394f, 180.0f, 64.0f);
                l.lineTo(180.0f, 29.0f);
                l.cubicTo(180.0f, 27.582346f, 178.4798f, 26.0f, 177.0f, 26.0f);
                l.lineTo(156.0f, 26.0f);
                l.lineTo(156.0f, 46.0f);
                l.cubicTo(154.65517f, 48.362537f, 152.38159f, 50.729206f, 150.0f, 51.0f);
                l.lineTo(131.0f, 51.0f);
                l.close();
                l.moveTo(149.02345f, 4.0f);
                l.cubicTo(150.66736f, 4.0f, 152.0f, 5.334057f, 152.0f, 6.97253f);
                l.lineTo(152.0f, 44.02747f);
                l.cubicTo(152.0f, 45.66915f, 150.66797f, 47.0f, 149.02759f, 47.0f);
                l.lineTo(121.0f, 47.0f);
                l.lineTo(110.64339f, 55.630512f);
                l.cubicTo(109.73577f, 56.38686f, 109.0f, 56.041157f, 109.0f, 54.854748f);
                l.lineTo(109.0f, 47.0f);
                l.lineTo(99.96629f, 47.0f);
                l.cubicTo(98.32806f, 47.0f, 97.0f, 45.665943f, 97.0f, 44.02747f);
                l.lineTo(97.0f, 6.97253f);
                l.cubicTo(97.0f, 5.330847f, 98.332306f, 4.0f, 99.97654f, 4.0f);
                l.lineTo(149.02345f, 4.0f);
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
