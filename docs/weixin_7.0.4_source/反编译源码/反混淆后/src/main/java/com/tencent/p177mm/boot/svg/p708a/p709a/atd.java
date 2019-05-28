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

/* renamed from: com.tencent.mm.boot.svg.a.a.atd */
public final class atd extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(26.0f, 1.0f);
                l.cubicTo(41.749996f, -2.7020142f, 58.451546f, 6.5304475f, 64.0f, 21.0f);
                l.cubicTo(69.30905f, 34.878006f, 64.155495f, 51.76251f, 52.0f, 60.0f);
                l.cubicTo(39.778633f, 68.93709f, 21.556034f, 67.74677f, 11.0f, 57.0f);
                l.cubicTo(-0.24904436f, 47.641407f, -3.2110927f, 30.486835f, 4.0f, 18.0f);
                l.cubicTo(8.276852f, 9.0211115f, 16.842775f, 2.5793939f, 26.0f, 1.0f);
                l.lineTo(26.0f, 1.0f);
                l.close();
                l.moveTo(27.0f, 4.0f);
                l.cubicTo(12.1093855f, 6.789598f, 1.3032824f, 21.511627f, 3.0f, 36.0f);
                l.cubicTo(4.5091596f, 51.64438f, 19.529842f, 64.36022f, 35.0f, 63.0f);
                l.cubicTo(51.368896f, 62.174374f, 64.971405f, 46.114883f, 63.0f, 30.0f);
                l.cubicTo(61.405987f, 12.758258f, 43.229362f, -0.47659707f, 27.0f, 4.0f);
                l.lineTo(27.0f, 4.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(19.0f, 19.0f);
                l.cubicTo(22.44149f, 17.715698f, 26.87168f, 21.241371f, 26.0f, 25.0f);
                l.cubicTo(25.251135f, 28.607508f, 20.48421f, 30.265413f, 18.0f, 28.0f);
                l.cubicTo(14.928059f, 25.732405f, 15.6331005f, 20.811155f, 19.0f, 19.0f);
                l.lineTo(19.0f, 19.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(45.0f, 19.0f);
                l.cubicTo(48.144283f, 18.20386f, 51.80879f, 21.377556f, 51.0f, 24.0f);
                l.cubicTo(50.233788f, 27.98074f, 44.67928f, 29.259693f, 42.0f, 27.0f);
                l.cubicTo(39.723274f, 24.219673f, 41.235275f, 19.795444f, 45.0f, 19.0f);
                l.lineTo(45.0f, 19.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(15.0f, 36.0f);
                l.cubicTo(27.003326f, 35.99499f, 38.996674f, 35.99499f, 51.0f, 36.0f);
                l.cubicTo(50.890244f, 43.420006f, 46.080933f, 50.524376f, 39.0f, 53.0f);
                l.cubicTo(31.752771f, 55.694836f, 22.90244f, 52.91922f, 18.0f, 46.0f);
                l.cubicTo(16.207317f, 43.470108f, 15.219512f, 39.732548f, 15.0f, 36.0f);
                l.lineTo(15.0f, 36.0f);
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
