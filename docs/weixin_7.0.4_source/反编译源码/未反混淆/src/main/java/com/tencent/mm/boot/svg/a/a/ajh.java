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

public final class ajh extends c {
    private final int height = 240;
    private final int width = 180;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                k = c.a(k, looper);
                k.setColor(-1);
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(90.0f, 180.0f);
                l.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                l.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                l.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                l.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                l.close();
                l.moveTo(62.0f, 100.0f);
                l.lineTo(84.0f, 115.0f);
                l.lineTo(84.0f, 65.0f);
                l.lineTo(62.0f, 80.0f);
                l.lineTo(48.0f, 80.0f);
                l.lineTo(48.0f, 100.0f);
                l.lineTo(62.0f, 100.0f);
                l.close();
                l.moveTo(123.00751f, 126.117966f);
                l.cubicTo(128.96204f, 115.445175f, 132.35507f, 103.14832f, 132.35507f, 90.05898f);
                l.cubicTo(132.35507f, 76.96964f, 128.96204f, 64.67279f, 123.00751f, 54.0f);
                l.lineTo(123.00751f, 54.0f);
                l.lineTo(119.0f, 56.9666f);
                l.cubicTo(124.36485f, 66.79643f, 127.413895f, 78.07163f, 127.413895f, 90.05898f);
                l.cubicTo(127.413895f, 102.04633f, 124.36485f, 113.32154f, 119.0f, 123.15137f);
                l.lineTo(123.00751f, 126.117966f);
                l.close();
                l.moveTo(110.93931f, 117.29133f);
                l.cubicTo(115.135056f, 109.15772f, 117.50414f, 99.92836f, 117.50414f, 90.14567f);
                l.cubicTo(117.50414f, 80.36297f, 115.135056f, 71.133606f, 110.93931f, 63.0f);
                l.lineTo(110.93931f, 63.0f);
                l.lineTo(107.0f, 65.916115f);
                l.cubicTo(110.71647f, 73.27225f, 112.81003f, 81.588f, 112.81003f, 90.39272f);
                l.cubicTo(112.81003f, 99.05392f, 110.78417f, 107.24194f, 107.180466f, 114.508804f);
                l.lineTo(110.93931f, 117.29133f);
                l.lineTo(110.93931f, 117.29133f);
                l.close();
                l.moveTo(99.07929f, 108.3367f);
                l.cubicTo(101.56525f, 102.78967f, 102.947845f, 96.64047f, 102.947845f, 90.16835f);
                l.cubicTo(102.947845f, 83.69623f, 101.56525f, 77.54703f, 99.07929f, 72.0f);
                l.lineTo(99.07929f, 72.0f);
                l.lineTo(95.0f, 75.01974f);
                l.cubicTo(96.93729f, 79.68519f, 98.00667f, 84.80189f, 98.00667f, 90.16835f);
                l.cubicTo(98.00667f, 95.53481f, 96.93729f, 100.65151f, 95.0f, 105.31697f);
                l.lineTo(99.07929f, 108.3367f);
                l.lineTo(99.07929f, 108.3367f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
