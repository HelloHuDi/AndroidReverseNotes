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

/* renamed from: com.tencent.mm.boot.svg.a.a.awj */
public final class awj extends C5163c {
    private final int height = 49;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 49;
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
                a.setColor(-6381921);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(26.0f, 0.0f);
                l.cubicTo(27.716187f, -0.38932037f, 29.024296f, 0.74794596f, 30.0f, 2.0f);
                l.cubicTo(35.235313f, 7.012887f, 40.407833f, 12.2004175f, 46.0f, 17.0f);
                l.cubicTo(46.718708f, 18.575094f, 48.416252f, 19.832073f, 48.0f, 22.0f);
                l.cubicTo(47.178043f, 23.263824f, 45.800037f, 24.361187f, 45.0f, 26.0f);
                l.cubicTo(37.232426f, 32.78095f, 30.132692f, 40.32282f, 23.0f, 47.0f);
                l.cubicTo(17.980267f, 48.602917f, 12.877645f, 47.56541f, 8.0f, 48.0f);
                l.cubicTo(5.478345f, 47.61529f, 1.5440342f, 48.99198f, 0.0f, 46.0f);
                l.cubicTo(-0.07362649f, 39.285313f, -0.06364093f, 32.591404f, 0.0f, 26.0f);
                l.cubicTo(5.857796f, 19.403105f, 12.418309f, 13.626988f, 18.0f, 7.0f);
                l.cubicTo(21.025862f, 4.9977307f, 23.172756f, 2.1046848f, 26.0f, 0.0f);
                l.lineTo(26.0f, 0.0f);
                l.close();
                l.moveTo(4.0f, 27.0f);
                l.cubicTo(4.0197816f, 32.796772f, 4.0098906f, 38.393444f, 4.0f, 44.0f);
                l.cubicTo(8.945341f, 43.990112f, 13.880792f, 43.980225f, 19.0f, 44.0f);
                l.cubicTo(26.560646f, 36.504814f, 34.285267f, 28.979963f, 42.0f, 21.0f);
                l.cubicTo(36.856846f, 16.30341f, 31.7038f, 11.151705f, 27.0f, 6.0f);
                l.cubicTo(19.033836f, 13.069998f, 11.507028f, 20.120218f, 4.0f, 27.0f);
                l.lineTo(4.0f, 27.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(12.0f, 31.0f);
                l.cubicTo(14.287206f, 29.916079f, 17.727032f, 32.54695f, 17.0f, 35.0f);
                l.cubicTo(16.355257f, 37.92308f, 12.759549f, 38.921356f, 11.0f, 37.0f);
                l.cubicTo(9.3509f, 35.43779f, 9.828942f, 32.505356f, 12.0f, 31.0f);
                l.lineTo(12.0f, 31.0f);
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
