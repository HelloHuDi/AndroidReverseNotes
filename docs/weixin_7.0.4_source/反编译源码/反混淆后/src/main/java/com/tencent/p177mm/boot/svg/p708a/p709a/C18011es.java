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

/* renamed from: com.tencent.mm.boot.svg.a.a.es */
public final class C18011es extends C5163c {
    private final int height = 75;
    private final int width = 57;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 57;
            case 1:
                return 75;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-11184811);
                a.setStrokeWidth(3.0f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -1448.0f, 0.0f, 1.0f, -685.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1474.4348f, 755.2621f);
                l.cubicTo(1475.5754f, 756.4586f, 1477.4377f, 756.46204f, 1478.5652f, 755.2621f);
                l.cubicTo(1478.5652f, 755.2621f, 1502.0f, 731.94885f, 1502.0f, 712.67706f);
                l.cubicTo(1502.0f, 698.43427f, 1490.5833f, 687.0f, 1476.8696f, 687.0f);
                l.cubicTo(1462.4167f, 687.0f, 1451.0f, 698.43427f, 1451.0f, 712.67706f);
                l.cubicTo(1451.0f, 731.94885f, 1474.4348f, 755.2621f, 1474.4348f, 755.2621f);
                l.close();
                l.moveTo(1476.5f, 721.0f);
                l.cubicTo(1481.1945f, 721.0f, 1485.0f, 717.1944f, 1485.0f, 712.5f);
                l.cubicTo(1485.0f, 707.8056f, 1481.1945f, 704.0f, 1476.5f, 704.0f);
                l.cubicTo(1471.8055f, 704.0f, 1468.0f, 707.8056f, 1468.0f, 712.5f);
                l.cubicTo(1468.0f, 717.1944f, 1471.8055f, 721.0f, 1476.5f, 721.0f);
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
