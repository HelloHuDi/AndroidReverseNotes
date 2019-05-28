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

public final class afu extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l = c.l(looper);
                l.moveTo(35.0f, 25.999985f);
                l.lineTo(16.000061f, 25.999985f);
                l.lineTo(16.000061f, 45.0f);
                l.lineTo(10.0f, 45.0f);
                l.lineTo(10.0f, 25.0f);
                l.cubicTo(10.0f, 22.238577f, 12.238576f, 20.0f, 15.0f, 20.0f);
                l.lineTo(35.0f, 20.0f);
                l.lineTo(35.0f, 25.999985f);
                l.close();
                l.moveTo(35.0f, 94.000015f);
                l.lineTo(35.0f, 100.0f);
                l.lineTo(15.0f, 100.0f);
                l.cubicTo(12.238576f, 100.0f, 10.0f, 97.76142f, 10.0f, 95.0f);
                l.lineTo(10.0f, 75.0f);
                l.lineTo(16.000061f, 75.0f);
                l.lineTo(16.000061f, 94.000015f);
                l.lineTo(35.0f, 94.000015f);
                l.close();
                l.moveTo(85.0f, 25.999985f);
                l.lineTo(85.0f, 20.0f);
                l.lineTo(105.0f, 20.0f);
                l.cubicTo(107.76142f, 20.0f, 110.0f, 22.238577f, 110.0f, 25.0f);
                l.lineTo(110.0f, 45.0f);
                l.lineTo(103.99994f, 45.0f);
                l.lineTo(103.99994f, 25.999985f);
                l.lineTo(85.0f, 25.999985f);
                l.close();
                l.moveTo(85.0f, 94.000015f);
                l.lineTo(103.99994f, 94.000015f);
                l.lineTo(103.99994f, 75.0f);
                l.lineTo(110.0f, 75.0f);
                l.lineTo(110.0f, 95.0f);
                l.cubicTo(110.0f, 97.76142f, 107.76142f, 100.0f, 105.0f, 100.0f);
                l.lineTo(85.0f, 100.0f);
                l.lineTo(85.0f, 94.000015f);
                l.close();
                l.moveTo(54.142136f, 72.79163f);
                l.lineTo(83.18377f, 43.75f);
                l.lineTo(87.42641f, 47.99264f);
                l.lineTo(57.67767f, 77.74138f);
                l.cubicTo(55.725048f, 79.694f, 52.559223f, 79.694f, 50.6066f, 77.74138f);
                l.lineTo(35.0f, 62.134777f);
                l.lineTo(39.24264f, 57.892136f);
                l.lineTo(54.142136f, 72.79163f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
