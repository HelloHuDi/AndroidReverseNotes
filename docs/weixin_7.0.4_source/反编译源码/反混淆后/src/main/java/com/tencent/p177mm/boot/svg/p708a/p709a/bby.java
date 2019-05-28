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

/* renamed from: com.tencent.mm.boot.svg.a.a.bby */
public final class bby extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-7829368);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(90.0f, 0.0f);
                l.lineTo(90.0f, 90.0f);
                l.lineTo(0.0f, 90.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 17.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(4.0f);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(40.0f, 50.0f);
                l2.cubicTo(40.0f, 51.162144f, 39.16621f, 52.0f, 38.0f, 52.0f);
                l2.lineTo(2.0f, 52.0f);
                l2.cubicTo(0.83545685f, 52.0f, 0.0f, 51.15074f, 0.0f, 50.0f);
                l2.lineTo(0.0f, 2.0f);
                l2.cubicTo(0.0f, 0.8378576f, 0.8337914f, 0.0f, 2.0f, 0.0f);
                l2.lineTo(27.0f, 0.0f);
                l2.lineTo(40.0f, 13.0f);
                l2.lineTo(40.0f, 50.0f);
                l2.close();
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                a3.setColor(-1);
                Path l3 = C5163c.m7884l(looper);
                l3.moveTo(23.0f, 0.0f);
                l3.lineTo(27.0f, 0.0f);
                l3.lineTo(27.0f, 16.0f);
                l3.lineTo(23.0f, 16.0f);
                l3.lineTo(23.0f, 0.0f);
                l3.close();
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-1);
                l3 = C5163c.m7884l(looper);
                l3.moveTo(23.0f, 13.0f);
                l3.lineTo(40.0f, 13.0f);
                l3.lineTo(40.0f, 17.0f);
                l3.lineTo(23.0f, 17.0f);
                l3.lineTo(23.0f, 13.0f);
                l3.close();
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
