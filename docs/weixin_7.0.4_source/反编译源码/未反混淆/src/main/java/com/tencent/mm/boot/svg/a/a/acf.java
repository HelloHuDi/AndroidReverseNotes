package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class acf extends c {
    private final int height = 32;
    private final int width = 32;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 32;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(28.0f, 0.0f);
                l.lineTo(28.0f, 28.0f);
                l.lineTo(0.0f, 28.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                a = c.a(a, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                a.setStrokeWidth(1.4f);
                g = c.a(g, 1.0f, 0.0f, 1.866667f, 0.0f, 1.0f, 4.2f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(22.670631f, 9.988304f);
                l.lineTo(10.23931f, 1.339735f);
                l.lineTo(10.23931f, 18.636873f);
                l.lineTo(22.670631f, 9.988304f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(10.194444f, 12.234003f);
                l.lineTo(10.194444f, 7.8902407f);
                l.lineTo(0.7f, 1.3340454f);
                l.lineTo(0.7f, 18.65783f);
                l.lineTo(10.194444f, 12.234003f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
