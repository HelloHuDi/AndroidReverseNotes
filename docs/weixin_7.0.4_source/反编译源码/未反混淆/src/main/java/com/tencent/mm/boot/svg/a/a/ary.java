package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ary extends c {
    private final int height = 144;
    private final int width = 144;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-1710619);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(144.0f, 0.0f);
                l.lineTo(144.0f, 146.0f);
                l.lineTo(0.0f, 146.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path l2 = c.l(looper);
                l2.moveTo(67.462845f, 72.00018f);
                l2.lineTo(49.3112f, 53.848534f);
                l2.cubicTo(48.899487f, 53.43682f, 48.89414f, 52.760975f, 49.30799f, 52.347126f);
                l2.lineTo(52.346096f, 49.30795f);
                l2.cubicTo(52.7546f, 48.899445f, 53.432587f, 48.896236f, 53.848576f, 49.312225f);
                l2.lineTo(72.00022f, 67.46281f);
                l2.lineTo(90.1508f, 49.312225f);
                l2.cubicTo(90.56358f, 48.899445f, 91.239426f, 48.89517f, 91.65435f, 49.30795f);
                l2.lineTo(94.69138f, 52.347126f);
                l2.cubicTo(95.09989f, 52.75456f, 95.104164f, 53.433613f, 94.68818f, 53.848534f);
                l2.lineTo(76.53653f, 72.00018f);
                l2.lineTo(94.68818f, 90.151825f);
                l2.cubicTo(95.09989f, 90.56354f, 95.10523f, 91.23939f, 94.69138f, 91.654305f);
                l2.lineTo(91.65435f, 94.69241f);
                l2.cubicTo(91.244774f, 95.100914f, 90.56679f, 95.104126f, 90.1508f, 94.68921f);
                l2.lineTo(72.00022f, 76.53649f);
                l2.lineTo(53.848576f, 94.68921f);
                l2.cubicTo(53.436863f, 95.100914f, 52.759945f, 95.105194f, 52.346096f, 94.69241f);
                l2.lineTo(49.30799f, 91.654305f);
                l2.cubicTo(48.899487f, 91.244736f, 48.89628f, 90.56675f, 49.3112f, 90.151825f);
                l2.lineTo(67.462845f, 72.00018f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
