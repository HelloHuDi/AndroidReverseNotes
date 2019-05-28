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

public final class zx extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                l.moveTo(21.0f, 36.0f);
                l.cubicTo(21.0f, 39.3132f, 18.3132f, 42.0f, 15.0f, 42.0f);
                l.cubicTo(11.6868f, 42.0f, 9.0f, 39.3132f, 9.0f, 36.0f);
                l.cubicTo(9.0f, 32.6856f, 11.6868f, 30.0f, 15.0f, 30.0f);
                l.cubicTo(18.3132f, 30.0f, 21.0f, 32.6856f, 21.0f, 36.0f);
                l.close();
                l.moveTo(36.0f, 30.0f);
                l.cubicTo(39.3132f, 30.0f, 42.0f, 32.6856f, 42.0f, 36.0f);
                l.cubicTo(42.0f, 39.3132f, 39.3132f, 42.0f, 36.0f, 42.0f);
                l.cubicTo(32.6868f, 42.0f, 30.0f, 39.3132f, 30.0f, 36.0f);
                l.cubicTo(30.0f, 32.6856f, 32.6868f, 30.0f, 36.0f, 30.0f);
                l.close();
                l.moveTo(57.0f, 30.0f);
                l.cubicTo(60.3132f, 30.0f, 63.0f, 32.6856f, 63.0f, 36.0f);
                l.cubicTo(63.0f, 39.3132f, 60.3132f, 42.0f, 57.0f, 42.0f);
                l.cubicTo(53.6868f, 42.0f, 51.0f, 39.3132f, 51.0f, 36.0f);
                l.cubicTo(51.0f, 32.6856f, 53.6868f, 30.0f, 57.0f, 30.0f);
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
