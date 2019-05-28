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
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aca */
public final class aca extends C5163c {
    private final int height = 40;
    private final int width = 40;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                a.setStrokeWidth(1.875f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(15.0f, 0.0f);
                l.cubicTo(23.284271f, 0.0f, 30.0f, 6.7157288f, 30.0f, 15.0f);
                l.cubicTo(30.0f, 23.284271f, 23.284271f, 30.0f, 15.0f, 30.0f);
                l.cubicTo(6.7157288f, 30.0f, 0.0f, 23.284271f, 0.0f, 15.0f);
                l.cubicTo(0.0f, 6.7157288f, 6.7157288f, 0.0f, 15.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(a2, 0.70710677f, -0.70710677f, 14.779029f, 0.70710677f, 0.70710677f, -6.3047323f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 13.75f);
                l.lineTo(30.0f, 13.75f);
                l.lineTo(30.0f, 15.625f);
                l.lineTo(0.0f, 15.625f);
                l.lineTo(0.0f, 13.75f);
                l.close();
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
