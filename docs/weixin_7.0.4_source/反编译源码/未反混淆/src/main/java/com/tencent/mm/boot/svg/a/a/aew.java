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

public final class aew extends c {
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
                k.setColor(-8421505);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(36.0f, 61.0f);
                l.cubicTo(22.19288f, 61.0f, 11.0f, 49.807117f, 11.0f, 36.0f);
                l.cubicTo(11.0f, 22.19288f, 22.19288f, 11.0f, 36.0f, 11.0f);
                l.cubicTo(49.807117f, 11.0f, 61.0f, 22.19288f, 61.0f, 36.0f);
                l.cubicTo(61.0f, 49.807117f, 49.807117f, 61.0f, 36.0f, 61.0f);
                l.close();
                l.moveTo(36.0f, 58.0f);
                l.cubicTo(48.150265f, 58.0f, 58.0f, 48.150265f, 58.0f, 36.0f);
                l.cubicTo(58.0f, 23.849735f, 48.150265f, 14.0f, 36.0f, 14.0f);
                l.cubicTo(23.849735f, 14.0f, 14.0f, 23.849735f, 14.0f, 36.0f);
                l.cubicTo(14.0f, 48.150265f, 23.849735f, 58.0f, 36.0f, 58.0f);
                l.close();
                l.moveTo(34.5f, 31.0f);
                l.lineTo(37.5f, 31.0f);
                l.lineTo(37.5f, 48.5f);
                l.lineTo(34.5f, 48.5f);
                l.lineTo(34.5f, 31.0f);
                l.close();
                l.moveTo(36.0f, 28.5f);
                l.cubicTo(34.61929f, 28.5f, 33.5f, 27.380713f, 33.5f, 26.0f);
                l.cubicTo(33.5f, 24.619287f, 34.61929f, 23.5f, 36.0f, 23.5f);
                l.cubicTo(37.38071f, 23.5f, 38.5f, 24.619287f, 38.5f, 26.0f);
                l.cubicTo(38.5f, 27.380713f, 37.38071f, 28.5f, 36.0f, 28.5f);
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
