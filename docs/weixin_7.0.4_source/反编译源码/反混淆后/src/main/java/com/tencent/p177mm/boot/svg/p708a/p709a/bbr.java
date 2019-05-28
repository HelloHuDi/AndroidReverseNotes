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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbr */
public final class bbr extends C5163c {
    private final int height = 16;
    private final int width = 16;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -394.0f, 0.0f, 1.0f, -603.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 327.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(-5066062);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.5f, 0.0f, 1.0f, 2.25f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(10.003614f, 7.676534f);
                l.cubicTo(9.463942f, 8.64106f, 8.048503f, 8.919226f, 6.8421645f, 8.298307f);
                l.cubicTo(5.6358266f, 7.677047f, 5.0950847f, 6.3916397f, 5.6345797f, 5.427114f);
                l.cubicTo(6.1742525f, 4.462589f, 7.5896916f, 4.1844225f, 8.79603f, 4.805512f);
                l.cubicTo(10.002546f, 5.4267726f, 10.543287f, 6.712009f, 10.003614f, 7.676534f);
                l.moveTo(10.079537f, 4.06439f);
                l.cubicTo(7.3818364f, 1.7038151f, 3.4686835f, 1.6194388f, 1.3390536f, 3.875688f);
                l.cubicTo(-0.7907462f, 6.1319375f, -0.33034536f, 9.874747f, 2.3671858f, 12.235322f);
                l.cubicTo(5.064887f, 14.595734f, 8.9782095f, 14.680437f, 11.10784f, 12.424025f);
                l.cubicTo(13.23747f, 10.167775f, 12.777239f, 6.4249654f, 10.079537f, 4.06439f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(12.304614f, 0.051767882f);
                l.cubicTo(13.397458f, -0.21129034f, 14.561358f, 0.554029f, 14.904305f, 1.7609161f);
                l.cubicTo(15.2472515f, 2.9679656f, 14.639293f, 4.1595984f, 13.54645f, 4.4226565f);
                l.cubicTo(12.453607f, 4.6857147f, 11.289882f, 3.9205577f, 10.946759f, 2.7135081f);
                l.cubicTo(10.603812f, 1.5064588f, 11.211771f, 0.3149884f, 12.304614f, 0.051767882f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                Paint a3 = C5163c.m7876a(k, looper);
                a3.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(0.0f, 0.0f);
                l2.lineTo(18.0f, 0.0f);
                l2.lineTo(18.0f, 18.0f);
                l2.lineTo(0.0f, 18.0f);
                l2.lineTo(0.0f, 0.0f);
                l2.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l2, C5163c.m7876a(a3, looper));
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
