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

public final class sg extends c {
    private final int height = 100;
    private final int width = 100;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                k.setColor(-4210753);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(47.0f, 0.0f);
                l.lineTo(53.0f, 0.0f);
                l.lineTo(53.0f, 47.0f);
                l.lineTo(100.0f, 47.0f);
                l.lineTo(100.0f, 53.0f);
                l.lineTo(53.0f, 53.0f);
                l.lineTo(53.0f, 100.0f);
                l.lineTo(47.0f, 100.0f);
                l.lineTo(47.0f, 53.0f);
                l.lineTo(0.0f, 53.0f);
                l.lineTo(0.0f, 47.0f);
                l.lineTo(47.0f, 47.0f);
                l.cubicTo(47.01f, 31.33f, 47.0f, 15.67f, 47.0f, 0.0f);
                l.lineTo(47.0f, 0.0f);
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
