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

/* renamed from: com.tencent.mm.boot.svg.a.a.tx */
public final class C32399tx extends C5163c {
    private final int height = 15;
    private final int width = 15;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 15;
            case 1:
                return 15;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-4868683);
                a2.setStrokeWidth(0.95454544f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(13.193269f, 0.4773343f);
                l.lineTo(13.193239f, 0.4773343f);
                l.lineTo(8.75f, 0.4773343f);
                l.cubicTo(8.665613f, 0.4773343f, 8.584682f, 0.5108569f, 8.525011f, 0.57052755f);
                l.lineTo(0.57046604f, 8.525073f);
                l.cubicTo(0.4462083f, 8.649331f, 0.4462083f, 8.850792f, 0.57046705f, 8.975051f);
                l.lineTo(5.0136914f, 13.4183035f);
                l.cubicTo(5.13795f, 13.542562f, 5.3394117f, 13.54256f, 5.4636736f, 13.418298f);
                l.lineTo(13.417828f, 5.463724f);
                l.cubicTo(13.477489f, 5.40406f, 13.511009f, 5.3231416f, 13.511016f, 5.2387595f);
                l.lineTo(13.511421f, 0.7954792f);
                l.cubicTo(13.511435f, 0.61975574f, 13.369009f, 0.47732326f, 13.193269f, 0.4773343f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-4868683);
                l = C5163c.m7884l(looper);
                l.moveTo(10.181818f, 2.8181818f);
                l.cubicTo(10.734103f, 2.8181818f, 11.181818f, 3.265897f, 11.181818f, 3.8181818f);
                l.cubicTo(11.181818f, 4.3704667f, 10.734103f, 4.818182f, 10.181818f, 4.818182f);
                l.cubicTo(9.629533f, 4.818182f, 9.181818f, 4.3704667f, 9.181818f, 3.8181818f);
                l.cubicTo(9.181818f, 3.265897f, 9.629533f, 2.8181818f, 10.181818f, 2.8181818f);
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
