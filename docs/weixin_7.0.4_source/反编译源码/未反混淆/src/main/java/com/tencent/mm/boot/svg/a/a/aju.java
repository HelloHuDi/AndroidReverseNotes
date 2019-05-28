package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aju extends c {
    private final int height = 210;
    private final int width = 210;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                k2 = c.a(k, looper);
                k2.setColor(-13327053);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(105.0f, 0.0f);
                l.cubicTo(162.9899f, 0.0f, 210.0f, 47.010098f, 210.0f, 105.0f);
                l.cubicTo(210.0f, 162.9899f, 162.9899f, 210.0f, 105.0f, 210.0f);
                l.cubicTo(47.010098f, 210.0f, 0.0f, 162.9899f, 0.0f, 105.0f);
                l.cubicTo(0.0f, 47.010098f, 47.010098f, 0.0f, 105.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                k2 = c.a(k, looper);
                k2.setColor(1275068416);
                canvas.save();
                a = c.a(k2, looper);
                l = c.l(looper);
                l.moveTo(105.0f, 0.0f);
                l.cubicTo(162.9899f, 0.0f, 210.0f, 47.010098f, 210.0f, 105.0f);
                l.cubicTo(210.0f, 162.9899f, 162.9899f, 210.0f, 105.0f, 210.0f);
                l.cubicTo(47.010098f, 210.0f, 0.0f, 162.9899f, 0.0f, 105.0f);
                l.cubicTo(0.0f, 47.010098f, 47.010098f, 0.0f, 105.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(96.494316f, 113.505684f);
                l.cubicTo(104.60257f, 121.61394f, 112.285225f, 125.41699f, 115.126305f, 125.19428f);
                l.cubicTo(117.967384f, 124.97158f, 125.04247f, 120.106026f, 128.38249f, 120.17079f);
                l.cubicTo(129.98773f, 120.20192f, 140.47748f, 127.296135f, 141.74727f, 128.11635f);
                l.cubicTo(143.01704f, 128.93655f, 144.19443f, 129.89465f, 143.97304f, 131.10704f);
                l.cubicTo(143.75165f, 132.31943f, 139.14153f, 145.67386f, 127.37189f, 143.82458f);
                l.cubicTo(115.60224f, 141.9753f, 99.19372f, 129.28743f, 89.84374f, 120.15626f);
                l.lineTo(96.494316f, 113.505684f);
                l.lineTo(96.494316f, 113.505684f);
                l.close();
                l.moveTo(96.494316f, 113.505684f);
                l.cubicTo(88.38606f, 105.39743f, 84.58301f, 97.714775f, 84.80572f, 94.873695f);
                l.cubicTo(85.02842f, 92.03261f, 89.893974f, 84.95753f, 89.82921f, 81.617516f);
                l.cubicTo(89.79808f, 80.01227f, 82.703865f, 69.52252f, 81.88366f, 68.25274f);
                l.cubicTo(81.063446f, 66.98295f, 80.10535f, 65.80558f, 78.89296f, 66.02696f);
                l.cubicTo(77.680565f, 66.24835f, 64.32614f, 70.858475f, 66.17542f, 82.62811f);
                l.cubicTo(68.024704f, 94.39776f, 80.71257f, 110.80628f, 89.84374f, 120.15626f);
                l.lineTo(96.494316f, 113.505684f);
                l.lineTo(96.494316f, 113.505684f);
                l.close();
                canvas.saveLayerAlpha(null, 179, 4);
                Paint a2 = c.a(k, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
