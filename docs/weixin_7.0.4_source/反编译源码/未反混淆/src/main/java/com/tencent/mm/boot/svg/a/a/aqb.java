package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aqb extends c {
    private final int height = 74;
    private final int width = 74;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 74;
            case 1:
                return 74;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k2 = c.a(k, looper);
                k2.setColor(-16335356);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(34.948597f, 0.0f);
                l.lineTo(38.70567f, 0.0f);
                l.cubicTo(48.546585f, 0.5134044f, 58.08532f, 5.0333767f, 64.62243f, 12.412307f);
                l.cubicTo(70.253f, 18.613426f, 73.45608f, 26.797697f, 74.0f, 35.122902f);
                l.lineTo(74.0f, 38.646267f);
                l.cubicTo(73.50645f, 56.816757f, 57.88387f, 72.943695f, 39.692783f, 73.869835f);
                l.cubicTo(25.923563f, 75.08791f, 11.942819f, 67.658646f, 5.08339f, 55.70941f);
                l.cubicTo(-2.0681434f, 43.90111f, -1.6148771f, 28.106375f, 6.070503f, 16.660477f);
                l.cubicTo(12.37594f, 6.966193f, 23.425564f, 0.69460595f, 34.948597f, 0.0f);
                l.lineTo(34.948597f, 0.0f);
                l.close();
                l.moveTo(55.60017f, 22.880356f);
                l.cubicTo(48.029774f, 30.035088f, 40.68324f, 37.42798f, 33.16372f, 44.652172f);
                l.cubicTo(29.073265f, 40.782066f, 25.227016f, 36.66388f, 21.004284f, 32.942627f);
                l.cubicTo(18.725027f, 31.414433f, 16.232088f, 33.66703f, 15.285789f, 35.62193f);
                l.cubicTo(14.817726f, 37.55698f, 16.496645f, 38.896633f, 17.7075f, 40.12713f);
                l.cubicTo(22.215141f, 44.423935f, 26.590502f, 48.85967f, 31.108318f, 53.146553f);
                l.cubicTo(32.41075f, 54.59536f, 34.761234f, 54.04958f, 35.82964f, 52.63054f);
                l.cubicTo(43.81722f, 44.80102f, 51.825146f, 36.981426f, 59.853428f, 29.201527f);
                l.cubicTo(60.952354f, 28.149652f, 62.33619f, 26.760384f, 61.65445f, 25.103186f);
                l.cubicTo(60.7692f, 22.959743f, 57.665745f, 20.717068f, 55.60017f, 22.880356f);
                l.lineTo(55.60017f, 22.880356f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                float[] a2 = c.a(g, 1.0f, 0.0f, 14.191781f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(41.408386f, 0.8803564f);
                l.cubicTo(43.473965f, -1.2829324f, 46.57742f, 0.95974314f, 47.462666f, 3.1031854f);
                l.cubicTo(48.14441f, 4.7603836f, 46.760574f, 6.1496515f, 45.661648f, 7.201526f);
                l.cubicTo(37.633366f, 14.981427f, 29.625437f, 22.801022f, 21.637857f, 30.630539f);
                l.cubicTo(20.569456f, 32.04958f, 18.21897f, 32.59536f, 16.916536f, 31.146553f);
                l.cubicTo(12.398722f, 26.859669f, 8.023359f, 22.423935f, 3.5157194f, 18.127127f);
                l.cubicTo(2.3048635f, 16.896633f, 0.62594557f, 15.556981f, 1.0940075f, 13.621929f);
                l.cubicTo(2.0403068f, 11.66703f, 4.5332456f, 9.414432f, 6.812504f, 10.942627f);
                l.cubicTo(11.035236f, 14.66388f, 14.881485f, 18.782068f, 18.97194f, 22.652172f);
                l.cubicTo(26.491457f, 15.427978f, 33.837994f, 8.035087f, 41.408386f, 0.8803564f);
                l.lineTo(41.408386f, 0.8803564f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
