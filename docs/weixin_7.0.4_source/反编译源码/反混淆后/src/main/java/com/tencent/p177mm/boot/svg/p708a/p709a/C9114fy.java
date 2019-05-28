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

/* renamed from: com.tencent.mm.boot.svg.a.a.fy */
public final class C9114fy extends C5163c {
    private final int height = 50;
    private final int width = 50;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 50;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -289.0f, 0.0f, 1.0f, -369.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 302.0f, 0.0f, 1.0f, 370.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 1.5f);
                l.cubicTo(0.0f, 0.6715728f, 0.6715728f, 0.0f, 1.5f, 0.0f);
                l.lineTo(2.5f, 0.0f);
                l.cubicTo(3.3284273f, 0.0f, 4.0f, 0.6715728f, 4.0f, 1.5f);
                l.lineTo(4.0f, 46.5f);
                l.cubicTo(4.0f, 47.328426f, 3.3284273f, 48.0f, 2.5f, 48.0f);
                l.lineTo(1.5f, 48.0f);
                l.cubicTo(0.6715728f, 48.0f, 0.0f, 47.328426f, 0.0f, 46.5f);
                l.lineTo(0.0f, 1.5f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(20.0f, 1.5f);
                l.cubicTo(20.0f, 0.6715728f, 20.671574f, 0.0f, 21.5f, 0.0f);
                l.lineTo(22.5f, 0.0f);
                l.cubicTo(23.328426f, 0.0f, 24.0f, 0.6715728f, 24.0f, 1.5f);
                l.lineTo(24.0f, 46.5f);
                l.cubicTo(24.0f, 47.328426f, 23.328426f, 48.0f, 22.5f, 48.0f);
                l.lineTo(21.5f, 48.0f);
                l.cubicTo(20.671574f, 48.0f, 20.0f, 47.328426f, 20.0f, 46.5f);
                l.lineTo(20.0f, 1.5f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
