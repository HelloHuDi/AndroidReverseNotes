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

public final class ga extends c {
    private final int height = 40;
    private final int width = 44;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 44;
            case 1:
                return 40;
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
                a.setColor(-9074981);
                g = c.a(g, 1.0f, 0.0f, -298.0f, 0.0f, 1.0f, -661.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(322.0f, 663.0f);
                l.cubicTo(320.0f, 664.0f, 316.5f, 668.1991f, 317.0f, 672.0f);
                l.lineTo(317.0f, 689.0f);
                l.cubicTo(316.5f, 691.797f, 313.4775f, 695.2222f, 310.0f, 695.0f);
                l.cubicTo(306.02176f, 695.2222f, 303.0f, 691.797f, 303.0f, 689.0f);
                l.cubicTo(303.0f, 686.67645f, 305.0f, 683.0f, 307.0f, 683.0f);
                l.cubicTo(309.0f, 683.0f, 311.0f, 681.0f, 310.0f, 679.0f);
                l.cubicTo(309.0f, 677.0f, 306.0f, 677.87036f, 305.0f, 678.0f);
                l.cubicTo(304.0f, 678.12964f, 300.0f, 681.0f, 299.0f, 683.0f);
                l.cubicTo(298.0f, 685.0f, 298.0f, 686.8411f, 298.0f, 689.0f);
                l.cubicTo(298.0f, 694.9784f, 302.7195f, 701.0f, 310.0f, 701.0f);
                l.cubicTo(312.23026f, 701.0f, 315.0f, 700.0f, 317.0f, 699.0f);
                l.cubicTo(319.0f, 698.0f, 322.5f, 692.8009f, 322.0f, 689.0f);
                l.lineTo(322.0f, 672.0f);
                l.cubicTo(322.5f, 669.203f, 325.52176f, 666.7778f, 329.0f, 667.0f);
                l.cubicTo(332.9775f, 666.7778f, 337.0f, 669.203f, 337.0f, 672.0f);
                l.cubicTo(337.0f, 674.41455f, 335.0f, 677.0f, 332.0f, 678.0f);
                l.cubicTo(329.0f, 679.0f, 328.0f, 680.0f, 329.0f, 682.0f);
                l.cubicTo(330.0f, 684.0f, 333.0f, 683.0f, 334.0f, 683.0f);
                l.cubicTo(335.0f, 683.0f, 339.0f, 680.0f, 340.0f, 678.0f);
                l.cubicTo(341.0f, 676.0f, 342.0f, 674.1589f, 342.0f, 672.0f);
                l.cubicTo(342.0f, 666.0216f, 336.2805f, 661.0f, 329.0f, 661.0f);
                l.cubicTo(326.76974f, 661.0f, 324.0f, 662.0f, 322.0f, 663.0f);
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
