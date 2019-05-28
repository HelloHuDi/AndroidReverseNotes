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

/* renamed from: com.tencent.mm.boot.svg.a.a.avb */
public final class avb extends C5163c {
    private final int height = 42;
    private final int width = 42;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 4.307692f, 0.0f, 1.0f, 2.076923f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-4210753);
                a2.setStrokeWidth(2.3f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 1.6488063f);
                l.cubicTo(0.0f, 0.7381957f, 0.7381957f, 0.0f, 1.6488063f, 0.0f);
                l.lineTo(30.658888f, 0.0f);
                l.cubicTo(31.569498f, 0.0f, 32.307693f, 0.7381957f, 32.307693f, 1.6488063f);
                l.lineTo(32.307693f, 36.351192f);
                l.cubicTo(32.307693f, 37.261803f, 31.569498f, 38.0f, 30.658888f, 38.0f);
                l.lineTo(1.6488063f, 38.0f);
                l.cubicTo(0.7381957f, 38.0f, 0.0f, 37.261803f, 0.0f, 36.351192f);
                l.lineTo(0.0f, 1.6488063f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                k2 = C5163c.m7876a(a, looper);
                a3.setColor(-4737097);
                k2.setColor(-4737097);
                k2.setStrokeWidth(0.6f);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(4.0384617f, 14.942307f);
                l2.lineTo(21.0f, 14.942307f);
                l2.lineTo(21.0f, 16.602564f);
                l2.lineTo(4.0384617f, 16.602564f);
                l2.lineTo(4.0384617f, 14.942307f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                k2 = C5163c.m7876a(a, looper);
                a3.setColor(-4737097);
                k2.setColor(-4737097);
                k2.setStrokeWidth(0.6f);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(4.0384617f, 19.923077f);
                l2.lineTo(12.923077f, 19.923077f);
                l2.lineTo(12.923077f, 21.583332f);
                l2.lineTo(4.0384617f, 21.583332f);
                l2.lineTo(4.0384617f, 19.923077f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                k2 = C5163c.m7876a(a, looper);
                a3.setColor(-4737097);
                k2.setColor(-4737097);
                k2.setStrokeWidth(0.6f);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(4.0384617f, 24.903847f);
                l2.lineTo(14.538462f, 24.903847f);
                l2.lineTo(14.538462f, 26.564102f);
                l2.lineTo(4.0384617f, 26.564102f);
                l2.lineTo(4.0384617f, 24.903847f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-4737097);
                l = C5163c.m7884l(looper);
                l.moveTo(6.3695426f, 6.0f);
                l.cubicTo(7.6569633f, 6.0f, 8.7006235f, 7.072651f, 8.7006235f, 8.395833f);
                l.cubicTo(8.7006235f, 9.719015f, 7.6569633f, 10.791666f, 6.3695426f, 10.791666f);
                l.cubicTo(5.082122f, 10.791666f, 4.0384617f, 9.719015f, 4.0384617f, 8.395833f);
                l.cubicTo(4.0384617f, 7.072651f, 5.082122f, 6.0f, 6.3695426f, 6.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
