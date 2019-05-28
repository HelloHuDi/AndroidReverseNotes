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

public final class di extends c {
    private final int height = 18;
    private final int width = 56;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 56;
            case 1:
                return 18;
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
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, -507.0f, 0.0f, 1.0f, -423.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                g = c.a(g, 6.123234E-17f, -1.0f, 967.0f, 1.0f, 6.123234E-17f, -103.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(535.0f, 404.0f);
                l.cubicTo(537.7558f, 404.0f, 540.0f, 406.2386f, 540.0f, 409.0f);
                l.cubicTo(540.0f, 411.7558f, 537.7614f, 414.0f, 535.0f, 414.0f);
                l.cubicTo(532.2442f, 414.0f, 530.0f, 411.7614f, 530.0f, 409.0f);
                l.cubicTo(530.0f, 406.2442f, 532.2386f, 404.0f, 535.0f, 404.0f);
                l.close();
                l.moveTo(535.0f, 423.0f);
                l.cubicTo(539.9717f, 423.0f, 544.0f, 427.02945f, 544.0f, 432.0f);
                l.cubicTo(544.0f, 436.97165f, 539.9706f, 441.0f, 535.0f, 441.0f);
                l.cubicTo(530.0283f, 441.0f, 526.0f, 436.97055f, 526.0f, 432.0f);
                l.cubicTo(526.0f, 427.02835f, 530.0294f, 423.0f, 535.0f, 423.0f);
                l.close();
                l.moveTo(535.0f, 450.0f);
                l.cubicTo(537.7558f, 450.0f, 540.0f, 452.2386f, 540.0f, 455.0f);
                l.cubicTo(540.0f, 457.7558f, 537.7614f, 460.0f, 535.0f, 460.0f);
                l.cubicTo(532.2442f, 460.0f, 530.0f, 457.7614f, 530.0f, 455.0f);
                l.cubicTo(530.0f, 452.2442f, 532.2386f, 450.0f, 535.0f, 450.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
