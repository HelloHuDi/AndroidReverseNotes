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

public final class alf extends c {
    private final int height = 38;
    private final int width = 24;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 38;
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
                k.setColor(-3684404);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(24.0f, 18.928122f);
                l.cubicTo(17.76f, 25.30391f, 11.27f, 31.564438f, 5.0f, 37.856243f);
                l.cubicTo(3.9782472f, 37.015377f, 0.34215337f, 33.172558f, 0.0f, 32.87516f);
                l.cubicTo(4.52f, 28.130583f, 10.31f, 23.60038f, 15.0f, 18.928122f);
                l.cubicTo(10.89f, 14.514881f, 0.0f, 3.9848678f, 0.0f, 3.9848678f);
                l.cubicTo(0.046293356f, 3.965954f, 3.7586608f, 0.9880148f, 5.0f, 0.0f);
                l.cubicTo(5.0f, 0.0f, 18.55f, 13.568475f, 24.0f, 18.928122f);
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
