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

/* renamed from: com.tencent.mm.boot.svg.a.a.wx */
public final class C25952wx extends C5163c {
    private final int height = 58;
    private final int width = 58;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 58;
            case 1:
                return 58;
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
                k = C5163c.m7876a(k2, looper);
                k.setStrokeWidth(1.0f);
                k.setStrokeCap(Cap.SQUARE);
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                a.setStrokeWidth(4.32f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -2167.0f, 0.0f, 1.0f, -920.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2168.64f, 0.0f, 1.0f, 921.6f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(33.12f, 33.12f);
                l.lineTo(33.12f, 53.28f);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(g, 6.123234E-17f, -1.0f, 77.759995f, 1.0f, 6.123234E-17f, -11.52f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(44.64f, 24.48f);
                l2.lineTo(44.64f, 41.76f);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(g, -1.0f, 0.0f, 25.92f, 0.0f, -1.0f, 25.92f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(4.32f, 4.32f);
                l.lineTo(4.32f, 24.48f);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(g, 6.123234E-17f, -1.0f, 20.16f, 1.0f, 6.123234E-17f, -11.52f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l3 = C5163c.m7884l(looper);
                l3.moveTo(15.84f, -4.32f);
                l3.lineTo(15.84f, 12.96f);
                canvas.drawPath(l3, a);
                canvas.restore();
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
