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

public final class ux extends c {
    private final int height = 108;
    private final int width = 108;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(96.0f, 0.0f);
                l.lineTo(96.0f, 96.0f);
                l.lineTo(0.0f, 96.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-15683841);
                Path l2 = c.l(looper);
                l2.moveTo(63.79504f, 76.03136f);
                l2.cubicTo(66.12399f, 72.529205f, 68.7792f, 68.3831f, 71.20018f, 64.23644f);
                l2.cubicTo(75.00407f, 57.72113f, 67.96337f, 50.764866f, 69.06122f, 48.884483f);
                l2.lineTo(75.6094f, 37.66875f);
                l2.lineTo(77.45893f, 38.724712f);
                l2.lineTo(79.198235f, 35.74563f);
                l2.lineTo(65.82298f, 28.109241f);
                l2.lineTo(64.08367f, 31.088326f);
                l2.lineTo(65.30881f, 31.787794f);
                l2.lineTo(65.30881f, 31.787794f);
                l2.cubicTo(63.367702f, 35.112526f, 59.602104f, 41.562244f, 58.760628f, 43.00353f);
                l2.cubicTo(57.614784f, 44.966133f, 48.31452f, 42.2731f, 44.418648f, 48.945957f);
                l2.cubicTo(41.398506f, 54.118862f, 34.140175f, 64.83309f, 31.555475f, 68.623924f);
                l2.cubicTo(36.904846f, 68.18801f, 44.777954f, 68.44738f, 52.00923f, 72.13616f);
                l2.cubicTo(56.16449f, 74.25582f, 60.120087f, 75.47306f, 63.79504f, 76.03136f);
                l2.lineTo(63.79504f, 76.03136f);
                l2.close();
                l2.moveTo(74.7789f, 22.0f);
                l2.lineTo(71.04058f, 28.949007f);
                l2.lineTo(76.47996f, 32.174023f);
                l2.lineTo(84.06177f, 26.508453f);
                l2.lineTo(74.7789f, 22.0f);
                l2.close();
                l2.moveTo(87.90909f, 75.08898f);
                l2.cubicTo(87.90909f, 75.08898f, 77.715836f, 85.38182f, 65.84715f, 85.38182f);
                l2.cubicTo(40.000687f, 85.38182f, 50.014915f, 73.98892f, 20.0f, 72.81588f);
                l2.cubicTo(19.998188f, 72.81866f, 36.395184f, 68.36936f, 50.49552f, 75.08898f);
                l2.cubicTo(71.97876f, 85.326965f, 87.90909f, 75.08898f, 87.90909f, 75.08898f);
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
