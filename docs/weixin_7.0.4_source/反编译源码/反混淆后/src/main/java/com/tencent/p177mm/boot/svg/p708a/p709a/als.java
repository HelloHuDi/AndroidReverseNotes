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

/* renamed from: com.tencent.mm.boot.svg.a.a.als */
public final class als extends C5163c {
    private final int height = 144;
    private final int width = 144;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-855638017);
                canvas.save();
                Paint a2 = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 28.8f);
                l.cubicTo(0.0f, 12.894198f, 12.894198f, 0.0f, 28.8f, 0.0f);
                l.lineTo(115.2f, 0.0f);
                l.cubicTo(131.1058f, 0.0f, 144.0f, 12.894198f, 144.0f, 28.8f);
                l.lineTo(144.0f, 115.2f);
                l.cubicTo(144.0f, 131.1058f, 131.1058f, 144.0f, 115.2f, 144.0f);
                l.lineTo(28.8f, 144.0f);
                l.cubicTo(12.894198f, 144.0f, 0.0f, 131.1058f, 0.0f, 115.2f);
                l.lineTo(0.0f, 28.8f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 40.8f, 0.0f, 1.0f, 45.6f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                k2 = C5163c.m7876a(a, looper);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(3.6f);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(17.28f, 4.4f);
                l2.lineTo(64.8f, 4.4f);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(a, looper);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(3.6f);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(17.28f, 26.4f);
                l2.lineTo(64.8f, 26.4f);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(a, looper);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(3.6f);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(17.28f, 48.4f);
                l2.lineTo(64.8f, 48.4f);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                a4.setColor(WebView.NIGHT_MODE_COLOR);
                l = C5163c.m7884l(looper);
                l.moveTo(3.456f, 0.0f);
                l.cubicTo(5.3646965f, 0.0f, 6.912f, 1.5446175f, 6.912f, 3.45f);
                l.cubicTo(6.912f, 5.3553824f, 5.3646965f, 6.9f, 3.456f, 6.9f);
                l.cubicTo(1.5473038f, 6.9f, 0.0f, 5.3553824f, 0.0f, 3.45f);
                l.cubicTo(0.0f, 1.5446175f, 1.5473038f, 0.0f, 3.456f, 0.0f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(k, looper);
                a4.setColor(WebView.NIGHT_MODE_COLOR);
                l = C5163c.m7884l(looper);
                l.moveTo(3.456f, 22.0f);
                l.cubicTo(5.3646965f, 22.0f, 6.912f, 23.575958f, 6.912f, 25.52f);
                l.cubicTo(6.912f, 27.464043f, 5.3646965f, 29.04f, 3.456f, 29.04f);
                l.cubicTo(1.5473038f, 29.04f, 0.0f, 27.464043f, 0.0f, 25.52f);
                l.cubicTo(0.0f, 23.575958f, 1.5473038f, 22.0f, 3.456f, 22.0f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(k, looper);
                a4.setColor(WebView.NIGHT_MODE_COLOR);
                l = C5163c.m7884l(looper);
                l.moveTo(3.456f, 44.0f);
                l.cubicTo(5.3646965f, 44.0f, 6.912f, 45.57596f, 6.912f, 47.52f);
                l.cubicTo(6.912f, 49.464043f, 5.3646965f, 51.04f, 3.456f, 51.04f);
                l.cubicTo(1.5473038f, 51.04f, 0.0f, 49.464043f, 0.0f, 47.52f);
                l.cubicTo(0.0f, 45.57596f, 1.5473038f, 44.0f, 3.456f, 44.0f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
