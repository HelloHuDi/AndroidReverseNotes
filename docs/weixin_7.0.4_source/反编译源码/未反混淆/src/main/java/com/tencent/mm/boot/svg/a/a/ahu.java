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

public final class ahu extends c {
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
                k = c.a(k, looper);
                k.setColor(-15683841);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(86.0f, 81.0f);
                l.lineTo(23.0f, 81.0f);
                l.cubicTo(21.344f, 81.0f, 20.0f, 79.657f, 20.0f, 78.0f);
                l.lineTo(20.0f, 31.0f);
                l.cubicTo(20.0f, 29.343f, 21.344f, 28.0f, 23.0f, 28.0f);
                l.lineTo(86.0f, 28.0f);
                l.cubicTo(87.656f, 28.0f, 89.0f, 29.343f, 89.0f, 31.0f);
                l.lineTo(89.0f, 78.0f);
                l.cubicTo(89.0f, 79.657f, 87.656f, 81.0f, 86.0f, 81.0f);
                l.lineTo(86.0f, 81.0f);
                l.close();
                l.moveTo(24.0f, 32.0f);
                l.lineTo(24.0f, 68.031f);
                l.lineTo(43.951f, 48.001f);
                l.lineTo(68.0f, 68.706f);
                l.lineTo(64.273f, 61.914f);
                l.lineTo(71.0f, 54.0f);
                l.lineTo(85.0f, 70.471f);
                l.lineTo(85.0f, 32.0f);
                l.lineTo(24.0f, 32.0f);
                l.lineTo(24.0f, 32.0f);
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
