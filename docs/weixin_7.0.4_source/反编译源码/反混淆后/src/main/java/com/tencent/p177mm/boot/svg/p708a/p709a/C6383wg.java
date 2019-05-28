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

/* renamed from: com.tencent.mm.boot.svg.a.a.wg */
public final class C6383wg extends C5163c {
    private final int height = 54;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 54;
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.0513232f, 4.9491887f);
                l.cubicTo(0.73179597f, 3.1712198f, 1.9300232f, 0.9937079f, 3.9270685f, 1.1035824f);
                l.cubicTo(19.633831f, 0.9837193f, 35.35058f, 1.0836052f, 51.05734f, 1.0536394f);
                l.cubicTo(52.844696f, 0.724016f, 54.961563f, 1.9426237f, 54.901653f, 3.9103754f);
                l.cubicTo(55.041443f, 14.298506f, 54.931606f, 24.696625f, 54.951576f, 35.084755f);
                l.cubicTo(55.26112f, 36.872715f, 54.062893f, 39.09018f, 52.035892f, 38.960327f);
                l.cubicTo(42.370193f, 39.080193f, 32.694508f, 38.970318f, 23.028807f, 39.010273f);
                l.cubicTo(18.685234f, 41.99686f, 14.36163f, 45.003426f, 10.028042f, 48.0f);
                l.lineTo(10.028042f, 39.010273f);
                l.cubicTo(7.152297f, 38.59075f, 2.8187084f, 40.328766f, 1.2011017f, 37.05251f);
                l.cubicTo(0.83164823f, 26.36472f, 1.1312051f, 15.646965f, 1.0513232f, 4.9491887f);
                l.lineTo(1.0513232f, 4.9491887f);
                l.close();
                l.moveTo(7.0f, 7.0f);
                l.lineTo(7.0f, 33.0f);
                l.lineTo(15.0f, 33.0f);
                l.lineTo(15.0f, 38.0f);
                l.cubicTo(17.34f, 36.33f, 19.68f, 34.66f, 22.02f, 32.99f);
                l.cubicTo(31.01f, 33.01f, 40.01f, 33.0f, 49.0f, 33.0f);
                l.lineTo(49.0f, 7.0f);
                l.lineTo(7.0f, 7.0f);
                l.lineTo(7.0f, 7.0f);
                l.close();
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
