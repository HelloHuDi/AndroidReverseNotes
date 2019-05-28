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
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aqr */
public final class aqr extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-372399);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(46.091885f, 13.908117f);
                l.cubicTo(50.97792f, 18.794155f, 54.0f, 25.544155f, 54.0f, 33.0f);
                l.cubicTo(54.0f, 47.91169f, 41.91169f, 60.0f, 27.0f, 60.0f);
                l.cubicTo(12.088312f, 60.0f, 0.0f, 47.91169f, 0.0f, 33.0f);
                l.cubicTo(0.0f, 18.088312f, 12.088312f, 6.0f, 27.0f, 6.0f);
                l.lineTo(27.0f, 9.6f);
                l.cubicTo(14.076537f, 9.6f, 3.6f, 20.076536f, 3.6f, 33.0f);
                l.cubicTo(3.6f, 45.923462f, 14.076537f, 56.4f, 27.0f, 56.4f);
                l.cubicTo(39.923462f, 56.4f, 50.4f, 45.923462f, 50.4f, 33.0f);
                l.cubicTo(50.4f, 26.706247f, 47.908665f, 20.816067f, 43.5463f, 16.453701f);
                l.lineTo(46.091885f, 13.908117f);
                l.close();
                l.moveTo(25.730843f, 9.633832f);
                l.cubicTo(13.397545f, 10.293022f, 3.6f, 20.502342f, 3.6f, 33.0f);
                l.cubicTo(3.6f, 45.923462f, 14.076537f, 56.4f, 27.0f, 56.4f);
                l.cubicTo(39.923462f, 56.4f, 50.4f, 45.923462f, 50.4f, 33.0f);
                l.cubicTo(50.4f, 26.706247f, 47.908665f, 20.816067f, 43.5463f, 16.453701f);
                l.lineTo(46.091885f, 13.908117f);
                l.cubicTo(50.97792f, 18.794155f, 54.0f, 25.544155f, 54.0f, 33.0f);
                l.cubicTo(54.0f, 47.91169f, 41.91169f, 60.0f, 27.0f, 60.0f);
                l.cubicTo(12.088312f, 60.0f, 0.0f, 47.91169f, 0.0f, 33.0f);
                l.cubicTo(0.0f, 18.928625f, 10.764283f, 7.3713818f, 24.507618f, 6.1135054f);
                l.lineTo(20.939697f, 2.5455844f);
                l.lineTo(23.485281f, 3.0375702E-13f);
                l.lineTo(30.909903f, 7.424621f);
                l.cubicTo(31.49569f, 8.010407f, 31.49569f, 8.9601555f, 30.909903f, 9.545941f);
                l.lineTo(29.424978f, 11.030866f);
                l.lineTo(23.485281f, 16.970562f);
                l.lineTo(20.939697f, 14.424978f);
                l.lineTo(25.730843f, 9.633832f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
