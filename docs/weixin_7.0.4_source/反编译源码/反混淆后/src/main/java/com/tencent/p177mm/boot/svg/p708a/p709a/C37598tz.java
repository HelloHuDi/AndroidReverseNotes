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

/* renamed from: com.tencent.mm.boot.svg.a.a.tz */
public final class C37598tz extends C5163c {
    private final int height = 30;
    private final int width = 30;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-5066062);
                a.setStrokeWidth(2.0f);
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.7598912f, 9.578414f);
                l.cubicTo(0.67707217f, 8.5686035f, 0.0f, 7.1293283f, 0.0f, 5.5319147f);
                l.cubicTo(0.0f, 2.4767227f, 2.4767227f, 0.0f, 5.5319147f, 0.0f);
                l.cubicTo(7.280762f, 0.0f, 8.840067f, 0.8115291f, 9.853792f, 2.078551f);
                l.cubicTo(6.0863647f, 3.10554f, 3.0613158f, 5.932576f, 1.7598912f, 9.578414f);
                l.close();
                l.moveTo(16.145893f, 2.078945f);
                l.cubicTo(17.15961f, 0.8116973f, 18.719057f, 0.0f, 20.468084f, 0.0f);
                l.cubicTo(23.523277f, 0.0f, 26.0f, 2.4767227f, 26.0f, 5.5319147f);
                l.cubicTo(26.0f, 7.1299777f, 25.322378f, 8.569773f, 24.238789f, 9.579644f);
                l.cubicTo(22.937773f, 5.9336786f, 19.913073f, 3.1063783f, 16.145893f, 2.078945f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(13.0f, 1.6595745f);
                l.cubicTo(19.263145f, 1.6595745f, 24.340425f, 6.7368555f, 24.340425f, 13.0f);
                l.cubicTo(24.340425f, 19.263145f, 19.263145f, 24.340425f, 13.0f, 24.340425f);
                l.cubicTo(6.7368555f, 24.340425f, 1.6595745f, 19.263145f, 1.6595745f, 13.0f);
                l.cubicTo(1.6595745f, 6.7368555f, 6.7368555f, 1.6595745f, 13.0f, 1.6595745f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(20.265247f, 22.957447f);
                l2.lineTo(23.031206f, 25.723404f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                a3.setStrokeCap(Cap.SQUARE);
                g = C5163c.m7878a(a2, -1.0f, 0.0f, 8.777304f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(3.2822695f, 22.404255f);
                l.lineTo(5.4950356f, 25.723404f);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(13.0f, 5.318182f);
                l2.lineTo(13.0f, 13.0f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(13.0f, 13.0f);
                l2.lineTo(17.978724f, 15.954546f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
