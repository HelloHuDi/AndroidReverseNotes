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

/* renamed from: com.tencent.mm.boot.svg.a.a.xk */
public final class C25954xk extends C5163c {
    private final int height = 43;
    private final int width = 43;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 43;
            case 1:
                return 43;
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
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -57.0f, 0.0f, 1.0f, -1296.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(-6710887);
                a.setStrokeWidth(4.6f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 60.0f, 0.0f, 1.0f, 1299.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(15.0f, 0.0f);
                l.cubicTo(23.284271f, 0.0f, 30.0f, 6.7157288f, 30.0f, 15.0f);
                l.cubicTo(30.0f, 23.284271f, 23.284271f, 30.0f, 15.0f, 30.0f);
                l.cubicTo(6.7157288f, 30.0f, 0.0f, 23.284271f, 0.0f, 15.0f);
                l.cubicTo(0.0f, 6.7157288f, 6.7157288f, 0.0f, 15.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                a3.setStrokeCap(Cap.SQUARE);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(26.5f, 26.5f);
                l2.lineTo(36.0f, 36.0f);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
