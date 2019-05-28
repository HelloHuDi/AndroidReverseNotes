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

/* renamed from: com.tencent.mm.boot.svg.a.a.gl */
public final class C37539gl extends C5163c {
    private final int height = 45;
    private final int width = 45;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-11048043);
                a2.setStrokeWidth(3.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.5f, 4.5f);
                l.cubicTo(1.5f, 2.8431456f, 2.8431456f, 1.5f, 4.5f, 1.5f);
                l.lineTo(40.5f, 1.5f);
                l.cubicTo(42.156853f, 1.5f, 43.5f, 2.8431456f, 43.5f, 4.5f);
                l.lineTo(43.5f, 28.5f);
                l.cubicTo(43.5f, 30.156855f, 42.156853f, 31.5f, 40.5f, 31.5f);
                l.lineTo(4.5f, 31.5f);
                l.cubicTo(2.8431456f, 31.5f, 1.5f, 30.156855f, 1.5f, 28.5f);
                l.lineTo(1.5f, 4.5f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-11048043);
                l = C5163c.m7884l(looper);
                l.moveTo(6.0f, 17.0f);
                l.cubicTo(6.0f, 16.447716f, 6.4477153f, 16.0f, 7.0f, 16.0f);
                l.lineTo(11.0f, 16.0f);
                l.cubicTo(11.552285f, 16.0f, 12.0f, 16.447716f, 12.0f, 17.0f);
                l.lineTo(12.0f, 21.0f);
                l.cubicTo(12.0f, 21.552284f, 11.552285f, 22.0f, 11.0f, 22.0f);
                l.lineTo(7.0f, 22.0f);
                l.cubicTo(6.4477153f, 22.0f, 6.0f, 21.552284f, 6.0f, 21.0f);
                l.lineTo(6.0f, 17.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                a3.setColor(-11048043);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(6.0f, 9.0f);
                l2.lineTo(39.0f, 9.0f);
                l2.lineTo(39.0f, 12.0f);
                l2.lineTo(6.0f, 12.0f);
                l2.lineTo(6.0f, 9.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
