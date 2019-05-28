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

/* renamed from: com.tencent.mm.boot.svg.a.a.ae */
public final class C32341ae extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-3355444);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 19.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, 204, 4);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(15.987003f, 13.975044f);
                l.cubicTo(22.005089f, 9.323351f, 28.003181f, 4.6516933f, 34.021267f, 0.0f);
                l.lineTo(38.0f, 0.0f);
                l.lineTo(38.0f, 56.0f);
                l.cubicTo(36.340527f, 55.740463f, 34.401146f, 56.13975f, 33.03158f, 54.961853f);
                l.cubicTo(27.323397f, 50.619606f, 21.645203f, 46.247414f, 15.937019f, 41.91515f);
                l.cubicTo(11.648384f, 41.835293f, 7.339755f, 42.134758f, 3.0611162f, 41.78538f);
                l.cubicTo(1.2217014f, 41.605705f, 0.93179363f, 39.499466f, 1.0117682f, 38.032085f);
                l.cubicTo(1.0017713f, 31.314081f, 1.0017713f, 24.596079f, 1.0117682f, 17.878075f);
                l.cubicTo(0.94179046f, 16.440641f, 1.2117046f, 14.274509f, 3.0511193f, 14.144741f);
                l.cubicTo(7.3497515f, 13.735473f, 11.678374f, 14.074866f, 15.987003f, 13.975044f);
                l.lineTo(15.987003f, 13.975044f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(53.339943f, 7.6842885f);
                l.cubicTo(50.13705f, 5.6012874f, 53.26988f, 0.3937841f, 56.58287f, 2.4867043f);
                l.cubicTo(68.53366f, 9.856561f, 73.35802f, 26.480894f, 67.53276f, 39.147526f);
                l.cubicTo(65.27071f, 44.42446f, 61.207047f, 48.66982f, 56.58287f, 51.9927f);
                l.cubicTo(53.500084f, 52.151405f, 50.997826f, 49.701397f, 52.39909f, 46.68601f);
                l.cubicTo(60.506413f, 42.37122f, 65.41084f, 32.83901f, 63.689285f, 23.80275f);
                l.cubicTo(62.758446f, 17.20658f, 58.504604f, 11.681667f, 53.339943f, 7.6842885f);
                l.lineTo(53.339943f, 7.6842885f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(45.38676f, 13.448668f);
                l.cubicTo(48.04146f, 11.830107f, 49.88165f, 14.987299f, 51.44028f, 16.635832f);
                l.cubicTo(55.512833f, 20.991959f, 57.161964f, 27.55612f, 55.13072f, 33.21109f);
                l.cubicTo(53.984367f, 36.618057f, 51.44028f, 39.365616f, 48.57441f, 41.46375f);
                l.cubicTo(47.025837f, 42.682663f, 44.481747f, 41.693542f, 44.05941f, 39.805225f);
                l.cubicTo(43.808018f, 38.60629f, 44.421413f, 37.467304f, 44.652695f, 36.318325f);
                l.cubicTo(46.301826f, 35.149364f, 48.16213f, 34.02037f, 49.036972f, 32.11207f);
                l.cubicTo(51.239166f, 27.815887f, 49.348698f, 22.320776f, 45.47726f, 19.643158f);
                l.cubicTo(44.300747f, 17.834766f, 42.94323f, 14.857414f, 45.38676f, 13.448668f);
                l.lineTo(45.38676f, 13.448668f);
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
