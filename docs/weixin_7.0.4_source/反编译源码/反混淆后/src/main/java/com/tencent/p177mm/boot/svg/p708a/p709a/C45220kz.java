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

/* renamed from: com.tencent.mm.boot.svg.a.a.kz */
public final class C45220kz extends C5163c {
    private final int height = 102;
    private final int width = 102;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -2644.0f, 0.0f, 1.0f, -1910.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2695.0f, 2012.0f);
                l.cubicTo(2666.8335f, 2012.0f, 2644.0f, 1989.1665f, 2644.0f, 1961.0f);
                l.cubicTo(2644.0f, 1932.8335f, 2666.8335f, 1910.0f, 2695.0f, 1910.0f);
                l.cubicTo(2723.1665f, 1910.0f, 2746.0f, 1932.8335f, 2746.0f, 1961.0f);
                l.cubicTo(2746.0f, 1989.1665f, 2723.1665f, 2012.0f, 2695.0f, 2012.0f);
                l.close();
                l.moveTo(2695.0f, 2009.0f);
                l.cubicTo(2668.4902f, 2009.0f, 2647.0f, 1987.5096f, 2647.0f, 1961.0f);
                l.cubicTo(2647.0f, 1934.4904f, 2668.4902f, 1913.0f, 2695.0f, 1913.0f);
                l.cubicTo(2721.5098f, 1913.0f, 2743.0f, 1934.4904f, 2743.0f, 1961.0f);
                l.cubicTo(2743.0f, 1987.5096f, 2721.5098f, 2009.0f, 2695.0f, 2009.0f);
                l.close();
                l.moveTo(2670.963f, 1965.1285f);
                l.cubicTo(2670.7703f, 1964.9377f, 2670.7505f, 1964.6127f, 2670.9253f, 1964.3942f);
                l.lineTo(2672.8416f, 1961.9998f);
                l.cubicTo(2673.0134f, 1961.785f, 2673.332f, 1961.7294f, 2673.5615f, 1961.8812f);
                l.lineTo(2686.488f, 1970.4324f);
                l.cubicTo(2686.9482f, 1970.7368f, 2687.674f, 1970.7001f, 2688.0981f, 1970.3591f);
                l.lineTo(2720.3496f, 1944.4258f);
                l.cubicTo(2720.5632f, 1944.254f, 2720.9004f, 1944.2769f, 2721.0906f, 1944.4653f);
                l.lineTo(2722.4705f, 1945.8309f);
                l.cubicTo(2722.6663f, 1946.0247f, 2722.6665f, 1946.3383f, 2722.4734f, 1946.5293f);
                l.lineTo(2688.0308f, 1980.6161f);
                l.cubicTo(2687.639f, 1981.0037f, 2687.0027f, 1981.0023f, 2686.6143f, 1980.618f);
                l.lineTo(2670.963f, 1965.1285f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
