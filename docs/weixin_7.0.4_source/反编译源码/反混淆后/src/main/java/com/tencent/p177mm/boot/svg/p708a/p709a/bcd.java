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

/* renamed from: com.tencent.mm.boot.svg.a.a.bcd */
public final class bcd extends C5163c {
    private final int height = 480;
    private final int width = 480;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                a.setColor(-2236963);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 98.0f, 0.0f, 1.0f, 78.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(138.88869f, 0.0f);
                l.cubicTo(166.80278f, 17.73124f, 194.74689f, 35.43248f, 222.65099f, 53.18372f);
                l.cubicTo(194.72688f, 69.47486f, 166.81279f, 85.796f, 138.88869f, 102.08714f);
                l.cubicTo(138.86868f, 86.73607f, 138.89868f, 71.384995f, 138.86868f, 56.03392f);
                l.cubicTo(110.20447f, 56.683964f, 81.89031f, 67.48472f, 60.167118f, 86.21603f);
                l.cubicTo(38.493935f, 104.63732f, 23.331707f, 130.59914f, 18.18095f, 158.58109f);
                l.cubicTo(12.960182f, 186.033f, 17.110792f, 215.22505f, 30.112703f, 239.98679f);
                l.cubicTo(43.114613f, 265.19855f, 64.907814f, 285.74f, 90.861626f, 297.1908f);
                l.cubicTo(113.865005f, 307.4815f, 140.00885f, 310.49173f, 164.78249f, 305.9414f);
                l.cubicTo(194.64687f, 300.601f, 222.26093f, 283.87985f, 240.95367f, 259.99817f);
                l.cubicTo(257.82614f, 238.84671f, 267.42755f, 212.05482f, 267.95764f, 185.01294f);
                l.cubicTo(273.30844f, 185.01294f, 278.6492f, 184.99294f, 284.0f, 185.03294f);
                l.cubicTo(283.45993f, 212.18484f, 274.92868f, 239.11673f, 259.64642f, 261.5783f);
                l.cubicTo(242.84395f, 286.43002f, 218.0003f, 305.78137f, 189.70615f, 315.79208f);
                l.cubicTo(160.39185f, 326.2828f, 127.58702f, 326.73285f, 98.00268f, 317.0522f);
                l.cubicTo(69.78853f, 307.96155f, 44.704845f, 289.63025f, 27.252283f, 265.69858f);
                l.cubicTo(10.199777f, 242.43695f, 0.4983519f, 213.85495f, 0.048285786f, 185.00294f);
                l.cubicTo(-0.86184794f, 151.04056f, 11.129913f, 116.96818f, 33.003128f, 90.98637f);
                l.cubicTo(58.796917f, 59.824184f, 98.39273f, 40.662846f, 138.87868f, 40.0328f);
                l.cubicTo(138.88869f, 26.691866f, 138.86868f, 13.350934f, 138.88869f, 0.0f);
                l.lineTo(138.88869f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
