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

/* renamed from: com.tencent.mm.boot.svg.a.a.ew */
public final class C41813ew extends C5163c {
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -1250.0f, 0.0f, 1.0f, -215.0f);
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
                l.moveTo(34.0f, 51.0f);
                l.lineTo(34.0f, 64.0f);
                l.cubicTo(34.0f, 65.044205f, 35.50389f, 66.62656f, 37.0f, 66.0f);
                l.lineTo(61.0f, 66.0f);
                l.lineTo(72.0f, 76.0f);
                l.cubicTo(72.0921f, 76.41986f, 72.86207f, 76.09059f, 73.0f, 74.0f);
                l.lineTo(73.0f, 66.0f);
                l.lineTo(80.0f, 66.0f);
                l.cubicTo(81.48861f, 66.62656f, 83.0f, 65.03394f, 83.0f, 64.0f);
                l.lineTo(83.0f, 29.0f);
                l.cubicTo(83.0f, 27.582346f, 81.4798f, 26.0f, 80.0f, 26.0f);
                l.lineTo(59.0f, 26.0f);
                l.lineTo(59.0f, 46.0f);
                l.cubicTo(57.655174f, 48.362537f, 55.381588f, 50.729206f, 53.0f, 51.0f);
                l.lineTo(34.0f, 51.0f);
                l.close();
                l.moveTo(52.02346f, 4.0f);
                l.cubicTo(53.66736f, 4.0f, 55.0f, 5.334057f, 55.0f, 6.97253f);
                l.lineTo(55.0f, 44.02747f);
                l.cubicTo(55.0f, 45.66915f, 53.66797f, 47.0f, 52.027588f, 47.0f);
                l.lineTo(24.0f, 47.0f);
                l.lineTo(13.643388f, 55.630512f);
                l.cubicTo(12.735769f, 56.38686f, 12.0f, 56.041157f, 12.0f, 54.854748f);
                l.lineTo(12.0f, 47.0f);
                l.lineTo(2.9662929f, 47.0f);
                l.cubicTo(1.3280545f, 47.0f, 0.0f, 45.665943f, 0.0f, 44.02747f);
                l.lineTo(0.0f, 6.97253f);
                l.cubicTo(0.0f, 5.330847f, 1.332306f, 4.0f, 2.97654f, 4.0f);
                l.lineTo(52.02346f, 4.0f);
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
