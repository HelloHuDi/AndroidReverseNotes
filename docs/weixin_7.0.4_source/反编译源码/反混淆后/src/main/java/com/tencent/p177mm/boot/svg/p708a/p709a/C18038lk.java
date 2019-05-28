package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.lk */
public final class C18038lk extends C5163c {
    private final int height = 102;
    private final int width = 102;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(51.0f, 102.0f);
                l.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                l.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                l.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                l.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                l.close();
                l.moveTo(51.0f, 98.0f);
                l.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                l.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                l.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                l.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(39.52522f, 40.28733f);
                l.lineTo(9.866667f, 40.28733f);
                l.lineTo(9.866667f, 44.853653f);
                l.cubicTo(9.866667f, 45.975304f, 10.76179f, 46.86199f, 11.865981f, 46.86199f);
                l.lineTo(37.883682f, 46.86199f);
                l.lineTo(36.885212f, 57.796623f);
                l.cubicTo(36.735928f, 59.43152f, 37.682396f, 59.961784f, 39.00135f, 58.95761f);
                l.lineTo(58.255604f, 44.29855f);
                l.cubicTo(61.15963f, 42.087593f, 60.55669f, 40.28733f, 56.896053f, 40.28733f);
                l.lineTo(39.52522f, 40.28733f);
                l.close();
                l.moveTo(32.008507f, 33.71267f);
                l.lineTo(61.99695f, 33.71267f);
                l.lineTo(61.99695f, 29.146349f);
                l.cubicTo(61.99695f, 28.024696f, 61.104416f, 27.138008f, 60.003418f, 27.138008f);
                l.lineTo(33.649654f, 27.138008f);
                l.lineTo(34.64812f, 16.203377f);
                l.cubicTo(34.797405f, 14.5684805f, 33.850937f, 14.038217f, 32.531982f, 15.04239f);
                l.lineTo(13.277731f, 29.701452f);
                l.cubicTo(10.373704f, 31.912409f, 10.9766445f, 33.71267f, 14.637279f, 33.71267f);
                l.lineTo(32.008507f, 33.71267f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
