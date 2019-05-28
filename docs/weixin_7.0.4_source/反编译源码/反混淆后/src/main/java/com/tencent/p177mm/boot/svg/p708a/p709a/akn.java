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

/* renamed from: com.tencent.mm.boot.svg.a.a.akn */
public final class akn extends C5163c {
    private final int height = 84;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-12206054);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(14.949f, 5.8425765f);
                l.cubicTo(21.649f, 1.6792915f, 29.638f, -0.2605797f, 37.503f, 0.0289533f);
                l.cubicTo(45.468f, 0.29652175f, 53.408f, 2.8893397f, 59.778f, 7.714557f);
                l.cubicTo(62.781f, 9.984896f, 65.423f, 12.749436f, 67.47f, 15.911337f);
                l.cubicTo(69.411f, 18.899517f, 70.805f, 22.249115f, 71.491f, 25.74747f);
                l.cubicTo(72.316f, 29.922737f, 72.131f, 34.29269f, 70.953f, 38.38309f);
                l.cubicTo(69.294f, 44.209694f, 65.656f, 49.37037f, 61.004f, 53.215168f);
                l.cubicTo(55.825f, 57.515232f, 49.43f, 60.2638f, 42.799f, 61.347054f);
                l.cubicTo(33.676f, 62.845634f, 24.002f, 61.304123f, 15.968f, 56.670597f);
                l.cubicTo(10.646f, 58.412785f, 5.323f, 60.15697f, 0.0f, 61.90016f);
                l.cubicTo(2.104f, 57.420387f, 4.21f, 52.942608f, 6.312f, 48.461834f);
                l.cubicTo(3.922f, 45.468662f, 2.079f, 42.02522f, 1.034f, 38.337166f);
                l.cubicTo(-0.644f, 32.51755f, -0.26f, 26.141836f, 2.082f, 20.557842f);
                l.cubicTo(4.618f, 14.419743f, 9.327f, 9.31897f, 14.949f, 5.8425765f);
                l.lineTo(14.949f, 5.8425765f);
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
