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

/* renamed from: com.tencent.mm.boot.svg.a.a.apn */
public final class apn extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-6250336);
                g = C5163c.m7878a(g, 0.70710677f, -0.70710677f, 48.0f, 0.70710677f, 0.70710677f, -19.882248f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = C5163c.m7884l(looper);
                l.moveTo(62.0f, 28.517904f);
                l.lineTo(62.0f, 66.0f);
                l.lineTo(67.0f, 66.0f);
                l.lineTo(67.0f, 28.517904f);
                l.cubicTo(66.99998f, 28.51194f, 67.0f, 28.505972f, 67.0f, 28.5f);
                l.cubicTo(67.0f, 27.119287f, 65.880714f, 26.0f, 64.5f, 26.0f);
                l.cubicTo(63.11929f, 26.0f, 62.0f, 27.119287f, 62.0f, 28.5f);
                l.cubicTo(62.0f, 28.505972f, 62.00002f, 28.51194f, 62.00006f, 28.517904f);
                l.close();
                l.moveTo(40.0f, 39.482143f);
                l.lineTo(40.0f, 66.0f);
                l.lineTo(45.0f, 66.0f);
                l.lineTo(45.0f, 39.482143f);
                l.cubicTo(44.990337f, 38.10965f, 43.874756f, 37.0f, 42.5f, 37.0f);
                l.cubicTo(41.125244f, 37.0f, 40.009663f, 38.10965f, 40.00006f, 39.482143f);
                l.lineTo(40.0f, 39.482143f);
                l.close();
                l.moveTo(55.99748f, 24.0f);
                l.cubicTo(55.857f, 16.7968f, 49.867767f, 11.0f, 42.5f, 11.0f);
                l.cubicTo(35.132233f, 11.0f, 29.143f, 16.7968f, 29.002523f, 24.0f);
                l.lineTo(34.01446f, 24.0f);
                l.cubicTo(34.27327f, 19.538311f, 37.973427f, 16.0f, 42.5f, 16.0f);
                l.cubicTo(47.026573f, 16.0f, 50.72673f, 19.538311f, 50.98554f, 24.0f);
                l.lineTo(55.99748f, 24.0f);
                l.close();
                l.moveTo(67.0f, 66.0f);
                l.cubicTo(67.0f, 76.49341f, 58.493412f, 85.0f, 48.0f, 85.0f);
                l.cubicTo(37.506588f, 85.0f, 29.0f, 76.49341f, 29.0f, 66.0f);
                l.lineTo(34.0f, 66.0f);
                l.cubicTo(34.0f, 73.73199f, 40.268013f, 80.0f, 48.0f, 80.0f);
                l.cubicTo(55.731987f, 80.0f, 62.0f, 73.73199f, 62.0f, 66.0f);
                l.lineTo(67.0f, 66.0f);
                l.lineTo(67.0f, 66.0f);
                l.close();
                l.moveTo(56.0f, 66.0f);
                l.cubicTo(56.0f, 70.41828f, 52.418278f, 74.0f, 48.0f, 74.0f);
                l.cubicTo(43.581722f, 74.0f, 40.0f, 70.41828f, 40.0f, 66.0f);
                l.lineTo(45.0f, 66.0f);
                l.cubicTo(45.0f, 67.65685f, 46.343147f, 69.0f, 48.0f, 69.0f);
                l.cubicTo(49.656853f, 69.0f, 51.0f, 67.65685f, 51.0f, 66.0f);
                l.lineTo(56.0f, 66.0f);
                l.lineTo(56.0f, 66.0f);
                l.close();
                l.moveTo(29.0f, 24.0f);
                l.lineTo(34.0f, 24.0f);
                l.lineTo(34.0f, 66.0f);
                l.lineTo(29.0f, 66.0f);
                l.lineTo(29.0f, 24.0f);
                l.close();
                l.moveTo(51.0f, 24.0f);
                l.lineTo(56.0f, 24.0f);
                l.lineTo(56.0f, 66.0f);
                l.lineTo(51.0f, 66.0f);
                l.lineTo(51.0f, 24.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
