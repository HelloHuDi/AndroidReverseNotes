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

public final class atr extends c {
    private final int height = 24;
    private final int width = 24;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                a.setColor(-2697514);
                Path l = c.l(looper);
                l.moveTo(12.0f, 0.0f);
                l.cubicTo(5.3716516f, 0.0f, 0.0f, 5.3716516f, 0.0f, 12.0f);
                l.cubicTo(0.0f, 18.628347f, 5.3716516f, 24.0f, 12.0f, 24.0f);
                l.cubicTo(18.628347f, 24.0f, 24.0f, 18.628347f, 24.0f, 12.0f);
                l.cubicTo(24.0f, 5.3716516f, 18.628347f, 0.0f, 12.0f, 0.0f);
                l.close();
                l.moveTo(12.148247f, 12.97082f);
                l.lineTo(18.91682f, 15.12273f);
                l.lineTo(18.506933f, 16.406258f);
                l.lineTo(10.797303f, 13.955056f);
                l.lineTo(10.797303f, 3.1551237f);
                l.lineTo(12.145618f, 3.1551237f);
                l.lineTo(12.145618f, 12.97082f);
                l.lineTo(12.148247f, 12.97082f);
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
