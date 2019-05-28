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

public final class ajw extends c {
    private final int height = 240;
    private final int width = 180;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                k.setColor(-1);
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(90.0f, 180.0f);
                l.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                l.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                l.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                l.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                l.close();
                l.moveTo(44.0f, 67.99653f);
                l.cubicTo(44.0f, 66.34159f, 45.34499f, 65.0f, 46.99624f, 65.0f);
                l.lineTo(104.00376f, 65.0f);
                l.cubicTo(105.65854f, 65.0f, 107.0f, 66.33738f, 107.0f, 67.99653f);
                l.lineTo(107.0f, 112.00347f);
                l.cubicTo(107.0f, 113.65841f, 105.65501f, 115.0f, 104.00376f, 115.0f);
                l.lineTo(46.99624f, 115.0f);
                l.cubicTo(45.34146f, 115.0f, 44.0f, 113.66262f, 44.0f, 112.00347f);
                l.lineTo(44.0f, 67.99653f);
                l.close();
                l.moveTo(131.5f, 116.79712f);
                l.cubicTo(133.91545f, 117.568535f, 136.0f, 116.05244f, 136.0f, 113.73276f);
                l.lineTo(136.0f, 66.235054f);
                l.cubicTo(136.0f, 63.63856f, 133.69482f, 62.548866f, 131.5f, 63.170685f);
                l.cubicTo(130.19809f, 64.306465f, 119.559074f, 74.1768f, 112.0f, 81.05712f);
                l.lineTo(112.0f, 98.72812f);
                l.cubicTo(119.74342f, 105.702545f, 130.61983f, 115.864586f, 131.5f, 116.79712f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
