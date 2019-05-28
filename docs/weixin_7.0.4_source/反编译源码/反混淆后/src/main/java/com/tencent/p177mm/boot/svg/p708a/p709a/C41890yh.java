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

/* renamed from: com.tencent.mm.boot.svg.a.a.yh */
public final class C41890yh extends C5163c {
    private final int height = 120;
    private final int width = 140;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 140;
            case 1:
                return 120;
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
                k.setStrokeCap(Cap.ROUND);
                k.setStrokeJoin(Join.MITER);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-25290);
                a.setStrokeWidth(2.0f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(24.0f, 42.220886f);
                l.cubicTo(37.25718f, 26.622805f, 49.25718f, 25.956137f, 60.0f, 40.220886f);
                l.cubicTo(70.74282f, 54.485634f, 82.74282f, 55.152298f, 96.0f, 42.220886f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(24.0f, 62.220886f);
                l.cubicTo(37.25718f, 46.622803f, 49.25718f, 45.95614f, 60.0f, 60.220886f);
                l.cubicTo(70.74282f, 74.485634f, 82.74282f, 75.1523f, 96.0f, 62.220886f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(24.0f, 82.22089f);
                l.cubicTo(37.25718f, 66.6228f, 49.25718f, 65.95614f, 60.0f, 80.22089f);
                l.cubicTo(70.74282f, 94.485634f, 82.74282f, 95.1523f, 96.0f, 82.22089f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
