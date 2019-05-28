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

/* renamed from: com.tencent.mm.boot.svg.a.a.do */
public final class C18004do extends C5163c {
    private final int height = 150;
    private final int width = 150;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 150;
            case 1:
                return 150;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -239.0f, 0.0f, 1.0f, -739.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 239.0f, 0.0f, 1.0f, 739.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-16139513);
                Path l = C5163c.m7884l(looper);
                l.moveTo(75.0f, 0.0f);
                l.cubicTo(116.42136f, 0.0f, 150.0f, 33.57864f, 150.0f, 75.0f);
                l.cubicTo(150.0f, 116.42136f, 116.42136f, 150.0f, 75.0f, 150.0f);
                l.cubicTo(33.57864f, 150.0f, 0.0f, 116.42136f, 0.0f, 75.0f);
                l.cubicTo(0.0f, 33.57864f, 33.57864f, 0.0f, 75.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(40.333332f, 110.27027f);
                l.cubicTo(37.63287f, 110.70741f, 36.316177f, 109.3305f, 37.133335f, 107.076164f);
                l.lineTo(41.4f, 94.29975f);
                l.cubicTo(37.380486f, 88.30855f, 35.0f, 83.169525f, 35.0f, 76.19984f);
                l.cubicTo(35.0f, 56.08848f, 52.9088f, 40.0f, 75.53333f, 40.0f);
                l.cubicTo(97.0912f, 40.0f, 115.0f, 56.08848f, 115.0f, 76.19984f);
                l.cubicTo(115.0f, 95.78047f, 97.0912f, 110.27027f, 75.53333f, 110.27027f);
                l.cubicTo(67.61395f, 110.27027f, 60.69544f, 108.47199f, 55.266666f, 104.94676f);
                l.lineTo(40.333332f, 110.27027f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
