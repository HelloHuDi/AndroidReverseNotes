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

/* renamed from: com.tencent.mm.boot.svg.a.a.avu */
public final class avu extends C5163c {
    private final int height = 40;
    private final int width = 40;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                a.setColor(-4210753);
                a.setStrokeWidth(2.5333333f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.2666667f, 8.866667f);
                l.cubicTo(1.2666667f, 4.6693025f, 4.6693025f, 1.2666667f, 8.866667f, 1.2666667f);
                l.lineTo(29.133333f, 1.2666667f);
                l.cubicTo(33.330696f, 1.2666667f, 36.733334f, 4.6693025f, 36.733334f, 8.866667f);
                l.lineTo(36.733334f, 29.133333f);
                l.cubicTo(36.733334f, 33.330696f, 33.330696f, 36.733334f, 29.133333f, 36.733334f);
                l.lineTo(8.866667f, 36.733334f);
                l.cubicTo(4.6693025f, 36.733334f, 1.2666667f, 33.330696f, 1.2666667f, 29.133333f);
                l.lineTo(1.2666667f, 8.866667f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                a3.setStrokeCap(Cap.ROUND);
                a3.setStrokeJoin(Join.MITER);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(15.2f, 27.866667f);
                l2.lineTo(15.2f, 10.133333f);
                l2.lineTo(25.333334f, 19.05872f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
