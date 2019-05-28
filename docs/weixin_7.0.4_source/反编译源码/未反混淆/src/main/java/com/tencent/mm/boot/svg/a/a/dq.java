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

public final class dq extends c {
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l = c.l(looper);
                l.moveTo(36.0f, 0.0f);
                l.cubicTo(55.88225f, 0.0f, 72.0f, 16.117748f, 72.0f, 36.0f);
                l.cubicTo(72.0f, 55.88225f, 55.88225f, 72.0f, 36.0f, 72.0f);
                l.cubicTo(16.117748f, 72.0f, 0.0f, 55.88225f, 0.0f, 36.0f);
                l.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                k2 = c.a(k, looper);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                Path l2 = c.l(looper);
                l2.moveTo(33.0f, 33.0f);
                l2.lineTo(33.0f, 18.0f);
                l2.lineTo(39.0f, 18.0f);
                l2.lineTo(39.0f, 33.0f);
                l2.lineTo(54.0f, 33.0f);
                l2.lineTo(54.0f, 39.0f);
                l2.lineTo(39.0f, 39.0f);
                l2.lineTo(39.0f, 54.0f);
                l2.lineTo(33.0f, 54.0f);
                l2.lineTo(33.0f, 39.0f);
                l2.lineTo(18.0f, 39.0f);
                l2.lineTo(18.0f, 33.0f);
                l2.lineTo(33.0f, 33.0f);
                l2.close();
                canvas.saveLayerAlpha(null, 227, 4);
                k2 = c.a(k2, looper);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
