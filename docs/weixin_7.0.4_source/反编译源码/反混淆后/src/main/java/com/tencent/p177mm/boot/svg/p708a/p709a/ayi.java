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

/* renamed from: com.tencent.mm.boot.svg.a.a.ayi */
public final class ayi extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(3.6f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 4.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.8f, 15.3f);
                l.lineTo(1.8f, 36.0f);
                l.lineTo(14.15169f, 36.0f);
                l.lineTo(27.9f, 47.456924f);
                l.lineTo(27.9f, 3.8430748f);
                l.lineTo(14.15169f, 15.3f);
                l.lineTo(1.8f, 15.3f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                a4.setColor(-1);
                a4.setStrokeWidth(3.6f);
                a4.setStrokeCap(Cap.SQUARE);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(45.0f, 17.0f);
                l2.cubicTo(50.4f, 19.571428f, 53.1f, 24.071428f, 53.1f, 30.5f);
                l2.cubicTo(53.1f, 36.92857f, 50.4f, 41.42857f, 45.0f, 44.0f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
