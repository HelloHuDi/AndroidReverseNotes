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

/* renamed from: com.tencent.mm.boot.svg.a.a.jb */
public final class C25900jb extends C5163c {
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-8617851);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 10.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(20.0f, 65.0f);
                l.cubicTo(15.581831f, 65.0f, 12.0f, 61.418266f, 12.0f, 57.00022f);
                l.cubicTo(12.0f, 52.581734f, 15.581831f, 49.0f, 20.0f, 49.0f);
                l.cubicTo(24.418169f, 49.0f, 28.0f, 52.581734f, 28.0f, 57.00022f);
                l.cubicTo(28.0f, 61.418266f, 24.418169f, 65.0f, 20.0f, 65.0f);
                l.moveTo(75.81466f, 29.779163f);
                l.lineTo(47.19909f, 1.1844771f);
                l.cubicTo(45.618633f, -0.3948257f, 43.056522f, -0.3948257f, 41.476063f, 1.1844771f);
                l.lineTo(1.252038f, 41.379147f);
                l.cubicTo(0.3639593f, 42.26658f, -0.024743835f, 43.463757f, 0.08502881f, 44.62272f);
                l.lineTo(0.004948767f, 44.70319f);
                l.lineTo(0.0f, 76.91503f);
                l.lineTo(0.08502881f, 77.0f);
                l.cubicTo(5.8085027f, 77.0f, 23.96283f, 76.97392f, 32.275406f, 76.961334f);
                l.lineTo(32.376633f, 76.86018f);
                l.cubicTo(33.526546f, 76.95999f, 34.71065f, 76.57157f, 35.59063f, 75.69268f);
                l.lineTo(75.81466f, 35.49801f);
                l.cubicTo(77.39511f, 33.91871f, 77.39511f, 31.358015f, 75.81466f, 29.779163f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
