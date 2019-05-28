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

/* renamed from: com.tencent.mm.boot.svg.a.a.aih */
public final class aih extends C5163c {
    private final int height = 63;
    private final int width = 63;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(k, looper);
                k2 = C5163c.m7876a(a, looper);
                a2.setColor(16777215);
                k2.setColor(-1);
                k2.setStrokeWidth(2.0f);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 1.5f);
                l.cubicTo(0.0f, 0.6715728f, 0.6715728f, 0.0f, 1.5f, 0.0f);
                l.lineTo(37.5f, 0.0f);
                l.cubicTo(38.328426f, 0.0f, 39.0f, 0.6715728f, 39.0f, 1.5f);
                l.lineTo(39.0f, 37.5f);
                l.cubicTo(39.0f, 38.328426f, 38.328426f, 39.0f, 37.5f, 39.0f);
                l.lineTo(1.5f, 39.0f);
                l.cubicTo(0.6715728f, 39.0f, 0.0f, 38.328426f, 0.0f, 37.5f);
                l.lineTo(0.0f, 1.5f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(0.0f, 0.0f);
                l2.lineTo(20.0f, 0.0f);
                l2.lineTo(20.0f, 20.0f);
                l2.lineTo(0.0f, 20.0f);
                l2.lineTo(0.0f, 0.0f);
                l2.close();
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(20.0f, 20.0f);
                l2.lineTo(39.5f, 20.0f);
                l2.lineTo(39.5f, 39.5f);
                l2.lineTo(20.0f, 39.5f);
                l2.lineTo(20.0f, 20.0f);
                l2.close();
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
