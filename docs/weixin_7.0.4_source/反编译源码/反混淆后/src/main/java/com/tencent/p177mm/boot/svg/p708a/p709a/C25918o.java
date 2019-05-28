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

/* renamed from: com.tencent.mm.boot.svg.a.a.o */
public final class C25918o extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 20.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(14.987003f, 13.975044f);
                l.cubicTo(21.005089f, 9.323351f, 27.003181f, 4.6516933f, 33.021267f, 0.0f);
                l.lineTo(37.0f, 0.0f);
                l.lineTo(37.0f, 56.0f);
                l.cubicTo(35.340527f, 55.740463f, 33.401146f, 56.13975f, 32.03158f, 54.961853f);
                l.cubicTo(26.323397f, 50.619606f, 20.645203f, 46.247414f, 14.937019f, 41.91515f);
                l.cubicTo(10.648384f, 41.835293f, 6.339755f, 42.134758f, 2.0611162f, 41.78538f);
                l.cubicTo(0.22170141f, 41.605705f, -0.06820635f, 39.499466f, 0.01176821f, 38.032085f);
                l.cubicTo(0.00177139f, 31.314081f, 0.00177139f, 24.596079f, 0.01176821f, 17.878075f);
                l.cubicTo(-0.058209527f, 16.440641f, 0.2117046f, 14.274509f, 2.0511193f, 14.144741f);
                l.cubicTo(6.3497515f, 13.735473f, 10.678374f, 14.074866f, 14.987003f, 13.975044f);
                l.lineTo(14.987003f, 13.975044f);
                l.lineTo(14.987003f, 13.975044f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(52.339943f, 7.6842885f);
                l.cubicTo(49.13705f, 5.6012874f, 52.26988f, 0.3937841f, 55.58287f, 2.4867043f);
                l.cubicTo(67.53366f, 9.856561f, 72.35802f, 26.480894f, 66.53276f, 39.147526f);
                l.cubicTo(64.27071f, 44.42446f, 60.207047f, 48.66982f, 55.58287f, 51.9927f);
                l.cubicTo(52.500084f, 52.151405f, 49.997826f, 49.701397f, 51.39909f, 46.68601f);
                l.cubicTo(59.506413f, 42.37122f, 64.41084f, 32.83901f, 62.689285f, 23.80275f);
                l.cubicTo(61.758446f, 17.20658f, 57.504604f, 11.681667f, 52.339943f, 7.6842885f);
                l.lineTo(52.339943f, 7.6842885f);
                l.lineTo(52.339943f, 7.6842885f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(44.38676f, 13.448668f);
                l.cubicTo(47.04146f, 11.830107f, 48.88165f, 14.987299f, 50.44028f, 16.635832f);
                l.cubicTo(54.512833f, 20.991959f, 56.161964f, 27.55612f, 54.13072f, 33.21109f);
                l.cubicTo(52.984367f, 36.618057f, 50.44028f, 39.365616f, 47.57441f, 41.46375f);
                l.cubicTo(46.025837f, 42.682663f, 43.481747f, 41.693542f, 43.05941f, 39.805225f);
                l.cubicTo(42.808018f, 38.60629f, 43.421413f, 37.467304f, 43.652695f, 36.318325f);
                l.cubicTo(45.301826f, 35.149364f, 47.16213f, 34.02037f, 48.036972f, 32.11207f);
                l.cubicTo(50.239166f, 27.815887f, 48.348698f, 22.320776f, 44.47726f, 19.643158f);
                l.cubicTo(43.300747f, 17.834766f, 41.94323f, 14.857414f, 44.38676f, 13.448668f);
                l.lineTo(44.38676f, 13.448668f);
                l.lineTo(44.38676f, 13.448668f);
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
