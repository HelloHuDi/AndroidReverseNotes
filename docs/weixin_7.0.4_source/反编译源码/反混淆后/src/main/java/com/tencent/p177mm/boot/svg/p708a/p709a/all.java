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

/* renamed from: com.tencent.mm.boot.svg.a.a.all */
public final class all extends C5163c {
    private final int height = 206;
    private final int width = 888;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 888;
            case 1:
                return 206;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                Paint a = C5163c.m7876a(k, looper);
                Paint a2 = C5163c.m7876a(k2, looper);
                a.setColor(-855638017);
                a2.setColor(419430400);
                a2.setStrokeWidth(2.0f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                a = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(487.3696f, 158.0f);
                l.lineTo(865.59595f, 158.0f);
                l.cubicTo(873.5463f, 158.0f, 880.0f, 151.55057f, 880.0f, 143.5948f);
                l.lineTo(880.0f, 14.405201f);
                l.cubicTo(880.0f, 6.4388275f, 873.5511f, 0.0f, 865.59595f, 0.0f);
                l.lineTo(14.404071f, 0.0f);
                l.cubicTo(6.4536805f, 0.0f, 0.0f, 6.449428f, 0.0f, 14.405201f);
                l.lineTo(0.0f, 143.5948f);
                l.cubicTo(0.0f, 151.56117f, 6.448922f, 158.0f, 14.404071f, 158.0f);
                l.lineTo(391.99994f, 158.0f);
                l.cubicTo(401.8239f, 158.0f, 416.78622f, 166.02438f, 429.78192f, 186.76418f);
                l.cubicTo(442.77762f, 207.50397f, 454.39465f, 186.99791f, 454.39465f, 186.99791f);
                l.cubicTo(454.39465f, 186.99791f, 474.19223f, 158.00002f, 487.3696f, 158.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
