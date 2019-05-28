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

/* renamed from: com.tencent.mm.boot.svg.a.a.avj */
public final class avj extends C5163c {
    private final int height = 24;
    private final int width = 14;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 14;
            case 1:
                return 24;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-7039852);
                a.setStrokeWidth(1.3333334f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -297.0f, 0.0f, 1.0f, -1097.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(309.1949f, 1109.0f);
                l.lineTo(309.33334f, 1108.8616f);
                l.lineTo(309.09744f, 1108.6256f);
                l.lineTo(298.70767f, 1098.2358f);
                l.lineTo(298.47177f, 1098.0f);
                l.lineTo(298.0f, 1098.4718f);
                l.lineTo(298.2359f, 1098.7076f);
                l.lineTo(308.52823f, 1109.0f);
                l.lineTo(298.2359f, 1119.2924f);
                l.lineTo(298.0f, 1119.5282f);
                l.lineTo(298.47177f, 1120.0f);
                l.lineTo(298.70767f, 1119.7642f);
                l.lineTo(309.09744f, 1109.3744f);
                l.lineTo(309.33334f, 1109.1384f);
                l.lineTo(309.1949f, 1109.0f);
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
