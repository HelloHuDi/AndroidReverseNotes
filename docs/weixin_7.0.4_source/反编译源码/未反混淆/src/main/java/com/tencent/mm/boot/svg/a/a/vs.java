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

public final class vs extends c {
    private final int height = 78;
    private final int width = 78;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                k.setColor(-1776412);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(39.0f, 78.0f);
                l.cubicTo(60.539104f, 78.0f, 78.0f, 60.539104f, 78.0f, 39.0f);
                l.cubicTo(78.0f, 17.460896f, 60.539104f, 0.0f, 39.0f, 0.0f);
                l.cubicTo(17.460896f, 0.0f, 0.0f, 17.460896f, 0.0f, 39.0f);
                l.cubicTo(0.0f, 60.539104f, 17.460896f, 78.0f, 39.0f, 78.0f);
                l.close();
                l.moveTo(39.0f, 73.0f);
                l.cubicTo(57.777683f, 73.0f, 73.0f, 57.777683f, 73.0f, 39.0f);
                l.cubicTo(73.0f, 20.222319f, 57.777683f, 5.0f, 39.0f, 5.0f);
                l.cubicTo(20.222319f, 5.0f, 5.0f, 20.222319f, 5.0f, 39.0f);
                l.cubicTo(5.0f, 57.777683f, 20.222319f, 73.0f, 39.0f, 73.0f);
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
