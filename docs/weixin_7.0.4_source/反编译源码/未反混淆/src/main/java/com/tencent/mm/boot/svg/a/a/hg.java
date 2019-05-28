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

public final class hg extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(48.054966f, 24.0f);
                l.cubicTo(49.47408f, 25.437006f, 50.893192f, 26.874012f, 52.292316f, 28.320997f);
                l.cubicTo(46.73579f, 33.86944f, 41.179264f, 39.4079f, 35.63273f, 44.95634f);
                l.cubicTo(47.755154f, 44.96632f, 59.877575f, 44.95634f, 72.0f, 44.96632f);
                l.lineTo(72.0f, 51.01372f);
                l.lineTo(35.58276f, 51.01372f);
                l.cubicTo(41.129295f, 56.612057f, 46.725796f, 62.15052f, 52.292316f, 67.7289f);
                l.cubicTo(50.873203f, 69.15592f, 49.444096f, 70.572975f, 48.01499f, 72.0f);
                l.cubicTo(40.009995f, 64.00665f, 32.004997f, 56.013306f, 24.0f, 48.01996f);
                l.cubicTo(32.01499f, 40.016632f, 40.02998f, 32.003326f, 48.054966f, 24.0f);
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
