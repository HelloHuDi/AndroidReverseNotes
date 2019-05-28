package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aoa */
public final class aoa extends C5163c {
    private final int height = C33250az.CTRL_INDEX;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return C33250az.CTRL_INDEX;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-13421773);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 9.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(57.0f, 42.0f);
                l.lineTo(71.83607f, 42.0f);
                l.cubicTo(73.49293f, 42.0f, 74.83607f, 43.343147f, 74.83607f, 45.0f);
                l.cubicTo(74.83607f, 45.95563f, 74.38078f, 46.85409f, 73.61016f, 47.419216f);
                l.lineTo(39.985905f, 72.077f);
                l.cubicTo(39.31786f, 72.5669f, 38.379154f, 72.422485f, 37.889256f, 71.75444f);
                l.cubicTo(37.593067f, 71.35055f, 37.51801f, 70.82548f, 37.68917f, 70.35478f);
                l.lineTo(44.727272f, 51.0f);
                l.lineTo(3.0f, 51.0f);
                l.cubicTo(1.3431457f, 51.0f, 2.0290612E-16f, 49.656853f, 0.0f, 48.0f);
                l.lineTo(0.0f, 45.0f);
                l.cubicTo(-2.0290612E-16f, 43.343147f, 1.3431457f, 42.0f, 3.0f, 42.0f);
                l.lineTo(57.0f, 42.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(30.272728f, 24.0f);
                l.lineTo(75.0f, 24.0f);
                l.cubicTo(76.65685f, 24.0f, 78.0f, 25.343145f, 78.0f, 27.0f);
                l.lineTo(78.0f, 30.0f);
                l.cubicTo(78.0f, 31.656855f, 76.65685f, 33.0f, 75.0f, 33.0f);
                l.lineTo(21.0f, 33.0f);
                l.lineTo(3.1639297f, 33.0f);
                l.cubicTo(1.5070753f, 33.0f, 0.16392961f, 31.656855f, 0.16392961f, 30.0f);
                l.cubicTo(0.16392961f, 29.044369f, 0.6192133f, 28.14591f, 1.3898386f, 27.580786f);
                l.lineTo(35.014095f, 2.9229982f);
                l.cubicTo(35.68214f, 2.4330964f, 36.620846f, 2.5775125f, 37.110744f, 3.2455602f);
                l.cubicTo(37.406933f, 3.6494505f, 37.48199f, 4.174522f, 37.31083f, 4.6452203f);
                l.lineTo(30.272728f, 24.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
