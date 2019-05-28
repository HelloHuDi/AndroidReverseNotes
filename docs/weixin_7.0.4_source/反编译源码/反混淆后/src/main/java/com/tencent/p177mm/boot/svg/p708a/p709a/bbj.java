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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbj */
public final class bbj extends C5163c {
    private final int height = 15;
    private final int width = 14;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 14;
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
                k = C5163c.m7876a(k2, looper);
                k.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-5066062);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -74.0f, 0.0f, 1.0f, -747.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 143.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(14.393222f, 10.420385f);
                l.lineTo(4.321909f, 15.7654f);
                l.cubicTo(3.882854f, 15.998414f, 3.3380342f, 15.831385f, 3.1050203f, 15.392329f);
                l.cubicTo(3.036059f, 15.262389f, 3.0f, 15.117526f, 3.0f, 14.970421f);
                l.lineTo(3.0f, 4.153231f);
                l.cubicTo(3.0f, 3.6009462f, 3.4477153f, 3.153231f, 4.0f, 3.153231f);
                l.cubicTo(4.171167f, 3.153231f, 4.3394685f, 3.1971664f, 4.4887943f, 3.2808318f);
                l.lineTo(14.411227f, 8.840247f);
                l.cubicTo(14.844859f, 9.083205f, 14.99943f, 9.631689f, 14.756472f, 10.065321f);
                l.cubicTo(14.671992f, 10.216099f, 14.545886f, 10.339364f, 14.393222f, 10.420385f);
                l.close();
                canvas.drawPath(l, a2);
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
