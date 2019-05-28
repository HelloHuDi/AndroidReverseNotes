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

public final class adq extends c {
    private final int height = 156;
    private final int width = 156;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 156;
            case 1:
                return 156;
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
                k = c.a(k, looper);
                k2 = c.a(k2, looper);
                k.setColor(-16139513);
                k2.setStrokeWidth(1.0f);
                k2 = c.a(k2, looper);
                k2.setColor(-16139513);
                k2.setStrokeWidth(3.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                Paint a2 = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(108.804146f, 97.68627f);
                l.cubicTo(107.96773f, 97.08867f, 99.06952f, 91.14659f, 97.824875f, 91.09063f);
                l.cubicTo(94.858475f, 91.06664f, 88.83385f, 95.10098f, 86.8456f, 95.487724f);
                l.cubicTo(83.99598f, 95.469734f, 77.45433f, 92.31682f, 70.376686f, 85.59425f);
                l.cubicTo(63.662365f, 78.50793f, 60.51331f, 71.95825f, 60.495342f, 69.10513f);
                l.cubicTo(60.881615f, 67.11444f, 64.911f, 61.083424f, 64.887054f, 58.112385f);
                l.cubicTo(64.831154f, 56.867207f, 58.957245f, 47.924107f, 58.299488f, 47.119637f);
                l.cubicTo(57.319336f, 45.788513f, 56.33819f, 44.814156f, 55.664463f, 45.030014f);
                l.cubicTo(54.35793f, 45.241875f, 43.738976f, 49.063354f, 45.12436f, 59.21166f);
                l.cubicTo(46.801193f, 69.13111f, 57.308357f, 83.11889f, 64.887054f, 91.09063f);
                l.cubicTo(72.84902f, 98.67962f, 86.82065f, 109.19868f, 96.726944f, 110.87757f);
                l.cubicTo(106.86381f, 112.264656f, 110.7894f, 101.4348f, 111.0f, 100.12666f);
                l.cubicTo(111.001f, 99.37716f, 109.640564f, 98.28388f, 108.804146f, 97.68627f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.drawPath(l, a2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
