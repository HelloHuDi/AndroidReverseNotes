package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class bl extends c {
    private final int height = 45;
    private final int width = 45;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-11184811);
                g = c.a(g, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 4.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(14.634262f, 3.4369836f);
                l.cubicTo(15.279194f, 1.8675201f, 16.155897f, -0.3917077f, 18.31239f, 0.058138534f);
                l.cubicTo(20.186722f, 0.08812828f, 20.589804f, 2.1574209f, 21.315353f, 3.4469802f);
                l.cubicTo(24.09662f, 4.796519f, 26.817427f, 6.6258936f, 28.07706f, 9.564889f);
                l.cubicTo(31.13041f, 15.372904f, 29.185537f, 22.17058f, 31.251333f, 28.218513f);
                l.cubicTo(32.138115f, 30.637686f, 33.831062f, 32.656998f, 35.0f, 34.93622f);
                l.cubicTo(23.673386f, 35.026188f, 12.336693f, 35.01619f, 1.0f, 34.93622f);
                l.cubicTo(2.1487849f, 32.647f, 3.861885f, 30.657679f, 4.7486663f, 28.22851f);
                l.cubicTo(6.8144636f, 22.190573f, 4.8595138f, 15.372904f, 7.9229403f, 9.564889f);
                l.cubicTo(9.182572f, 6.6558833f, 11.873148f, 4.8065157f, 14.634262f, 3.4369836f);
                l.lineTo(14.634262f, 3.4369836f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
