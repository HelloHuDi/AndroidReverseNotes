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

/* renamed from: com.tencent.mm.boot.svg.a.a.jz */
public final class C37554jz extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 40.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-8617851);
                Path l = C5163c.m7884l(looper);
                l.moveTo(8.0f, 65.0f);
                l.cubicTo(3.5817778f, 65.0f, 0.0f, 68.58178f, 0.0f, 73.0f);
                l.cubicTo(0.0f, 77.41822f, 3.5817778f, 81.0f, 8.0f, 81.0f);
                l.cubicTo(12.418222f, 81.0f, 16.0f, 77.41822f, 16.0f, 73.0f);
                l.cubicTo(16.0f, 68.58178f, 12.418222f, 65.0f, 8.0f, 65.0f);
                l.moveTo(8.0f, 32.0f);
                l.cubicTo(3.5817778f, 32.0f, 0.0f, 35.58178f, 0.0f, 40.0f);
                l.cubicTo(0.0f, 44.41822f, 3.5817778f, 48.0f, 8.0f, 48.0f);
                l.cubicTo(12.418222f, 48.0f, 16.0f, 44.41822f, 16.0f, 40.0f);
                l.cubicTo(16.0f, 35.58178f, 12.418222f, 32.0f, 8.0f, 32.0f);
                l.moveTo(16.0f, 8.0f);
                l.cubicTo(16.0f, 3.5817778f, 12.418222f, 0.0f, 8.0f, 0.0f);
                l.cubicTo(3.5817778f, 0.0f, 0.0f, 3.5817778f, 0.0f, 8.0f);
                l.cubicTo(0.0f, 12.418222f, 3.5817778f, 16.0f, 8.0f, 16.0f);
                l.cubicTo(12.418222f, 16.0f, 16.0f, 12.418222f, 16.0f, 8.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
