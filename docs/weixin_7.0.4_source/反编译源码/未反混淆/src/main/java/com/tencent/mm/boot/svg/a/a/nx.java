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

public final class nx extends c {
    private final int height = 21;
    private final int width = 28;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 28;
            case 1:
                return 21;
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
                k.setColor(-2763307);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(9.740437f, 16.82034f);
                l.cubicTo(15.206292f, 11.2271185f, 20.54201f, 5.501695f, 26.097961f, 0.0f);
                l.cubicTo(26.568466f, 0.4881356f, 27.519485f, 1.4745762f, 28.0f, 1.9728813f);
                l.cubicTo(22.303898f, 8.583051f, 15.887022f, 14.532204f, 10.040758f, 21.0f);
                l.cubicTo(6.677154f, 18.21356f, 3.283518f, 15.488135f, 0.0f, 12.620339f);
                l.lineTo(0.0f, 10.932203f);
                l.cubicTo(0.41043976f, 10.718644f, 1.2313193f, 10.291526f, 1.641759f, 10.088136f);
                l.cubicTo(4.3346443f, 12.335593f, 7.0275297f, 14.593221f, 9.740437f, 16.82034f);
                l.lineTo(9.740437f, 16.82034f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
