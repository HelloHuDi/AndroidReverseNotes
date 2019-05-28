package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class tb extends c {
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
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
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
                k2 = c.a(k, looper);
                k2.setColor(-2565928);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(35.5f, 14.333468f);
                l.cubicTo(34.08226f, 12.584894f, 29.636719f, 8.0f, 22.0f, 8.0f);
                l.cubicTo(12.603008f, 8.0f, 4.999999f, 15.031532f, 5.0f, 24.0f);
                l.cubicTo(5.000001f, 34.14707f, 12.338594f, 50.355007f, 36.0f, 63.0f);
                l.cubicTo(58.78113f, 50.364376f, 66.0f, 34.127697f, 66.0f, 24.0f);
                l.cubicTo(66.0f, 15.026322f, 58.39699f, 8.0f, 49.0f, 8.0f);
                l.cubicTo(41.36328f, 8.0f, 36.91774f, 12.584894f, 35.5f, 14.333468f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(35.5f, 14.333468f);
                l.cubicTo(34.08226f, 12.584894f, 29.636719f, 8.0f, 22.0f, 8.0f);
                l.cubicTo(12.603008f, 8.0f, 4.999999f, 15.031532f, 5.0f, 24.0f);
                l.cubicTo(5.000001f, 34.14707f, 12.338594f, 50.355007f, 36.0f, 63.0f);
                l.cubicTo(58.78113f, 50.364376f, 66.0f, 34.127697f, 66.0f, 24.0f);
                l.cubicTo(66.0f, 15.026322f, 58.39699f, 8.0f, 49.0f, 8.0f);
                l.cubicTo(41.36328f, 8.0f, 36.91774f, 12.584894f, 35.5f, 14.333468f);
                l.close();
                Paint k3 = c.k(looper);
                k3.setFlags(385);
                k3.setStyle(Style.FILL);
                Paint k4 = c.k(looper);
                k4.setFlags(385);
                k4.setStyle(Style.STROKE);
                k3.setColor(WebView.NIGHT_MODE_COLOR);
                k4.setStrokeWidth(1.0f);
                k4.setStrokeCap(Cap.BUTT);
                k4.setStrokeJoin(Join.MITER);
                k4.setStrokeMiter(4.0f);
                k4.setPathEffect(null);
                float[] a2 = c.a(g, 66.0f, 0.0f, 4.999999f, 0.0f, 63.0f, 8.0f);
                h.reset();
                h.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-33702, -44260}, new float[]{0.0f, 1.0f}, h, 0);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
