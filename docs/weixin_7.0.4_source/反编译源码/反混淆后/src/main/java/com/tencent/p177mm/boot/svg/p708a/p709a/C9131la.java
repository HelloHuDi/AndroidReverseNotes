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

/* renamed from: com.tencent.mm.boot.svg.a.a.la */
public final class C9131la extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -2644.0f, 0.0f, 1.0f, -2054.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2697.9246f, 2114.546f);
                l.lineTo(2690.5f, 2121.9705f);
                l.lineTo(2692.6213f, 2124.0918f);
                l.lineTo(2700.046f, 2116.6672f);
                l.lineTo(2707.4705f, 2124.0918f);
                l.lineTo(2709.5918f, 2121.9705f);
                l.lineTo(2702.1672f, 2114.546f);
                l.lineTo(2709.5918f, 2107.1213f);
                l.lineTo(2707.4705f, 2105.0f);
                l.lineTo(2700.046f, 2112.4246f);
                l.lineTo(2692.6213f, 2105.0f);
                l.lineTo(2690.5f, 2107.1213f);
                l.lineTo(2697.9246f, 2114.546f);
                l.close();
                l.moveTo(2695.0f, 2156.0f);
                l.cubicTo(2666.8335f, 2156.0f, 2644.0f, 2133.1665f, 2644.0f, 2105.0f);
                l.cubicTo(2644.0f, 2076.8335f, 2666.8335f, 2054.0f, 2695.0f, 2054.0f);
                l.cubicTo(2723.1665f, 2054.0f, 2746.0f, 2076.8335f, 2746.0f, 2105.0f);
                l.cubicTo(2746.0f, 2133.1665f, 2723.1665f, 2156.0f, 2695.0f, 2156.0f);
                l.close();
                l.moveTo(2695.0f, 2153.0f);
                l.cubicTo(2668.4902f, 2153.0f, 2647.0f, 2131.5098f, 2647.0f, 2105.0f);
                l.cubicTo(2647.0f, 2078.4902f, 2668.4902f, 2057.0f, 2695.0f, 2057.0f);
                l.cubicTo(2721.5098f, 2057.0f, 2743.0f, 2078.4902f, 2743.0f, 2105.0f);
                l.cubicTo(2743.0f, 2131.5098f, 2721.5098f, 2153.0f, 2695.0f, 2153.0f);
                l.close();
                l.moveTo(2674.0f, 2081.4993f);
                l.cubicTo(2674.0f, 2080.395f, 2674.8967f, 2079.5f, 2675.9976f, 2079.5f);
                l.lineTo(2714.0024f, 2079.5f);
                l.cubicTo(2715.1057f, 2079.5f, 2716.0f, 2080.396f, 2716.0f, 2081.4993f);
                l.lineTo(2716.0f, 2128.5007f);
                l.cubicTo(2716.0f, 2129.605f, 2715.1033f, 2130.5f, 2714.0024f, 2130.5f);
                l.lineTo(2675.9976f, 2130.5f);
                l.cubicTo(2674.8943f, 2130.5f, 2674.0f, 2129.604f, 2674.0f, 2128.5007f);
                l.lineTo(2674.0f, 2081.4993f);
                l.close();
                l.moveTo(2677.0f, 2082.5f);
                l.lineTo(2713.0f, 2082.5f);
                l.lineTo(2713.0f, 2127.5f);
                l.lineTo(2677.0f, 2127.5f);
                l.lineTo(2677.0f, 2082.5f);
                l.close();
                l.moveTo(2681.5f, 2087.0f);
                l.lineTo(2696.5f, 2087.0f);
                l.lineTo(2696.5f, 2090.0f);
                l.lineTo(2681.5f, 2090.0f);
                l.lineTo(2681.5f, 2087.0f);
                l.close();
                l.moveTo(2681.5f, 2094.5f);
                l.lineTo(2696.5f, 2094.5f);
                l.lineTo(2696.5f, 2097.5f);
                l.lineTo(2681.5f, 2097.5f);
                l.lineTo(2681.5f, 2094.5f);
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
