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

/* renamed from: com.tencent.mm.boot.svg.a.a.ma */
public final class C37564ma extends C5163c {
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 43.0f, 0.0f, 1.0f, 20.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(5.0f, 10.0f);
                l.cubicTo(7.7614236f, 10.0f, 10.0f, 7.7614236f, 10.0f, 5.0f);
                l.cubicTo(10.0f, 2.2385762f, 7.7614236f, 0.0f, 5.0f, 0.0f);
                l.cubicTo(2.2385762f, 0.0f, 0.0f, 2.2385762f, 0.0f, 5.0f);
                l.cubicTo(0.0f, 7.7614236f, 2.2385762f, 10.0f, 5.0f, 10.0f);
                l.close();
                l.moveTo(5.0f, 33.0f);
                l.cubicTo(7.7614236f, 33.0f, 10.0f, 30.761423f, 10.0f, 28.0f);
                l.cubicTo(10.0f, 25.238577f, 7.7614236f, 23.0f, 5.0f, 23.0f);
                l.cubicTo(2.2385762f, 23.0f, 0.0f, 25.238577f, 0.0f, 28.0f);
                l.cubicTo(0.0f, 30.761423f, 2.2385762f, 33.0f, 5.0f, 33.0f);
                l.close();
                l.moveTo(5.0f, 56.0f);
                l.cubicTo(7.7614236f, 56.0f, 10.0f, 53.761425f, 10.0f, 51.0f);
                l.cubicTo(10.0f, 48.238575f, 7.7614236f, 46.0f, 5.0f, 46.0f);
                l.cubicTo(2.2385762f, 46.0f, 0.0f, 48.238575f, 0.0f, 51.0f);
                l.cubicTo(0.0f, 53.761425f, 2.2385762f, 56.0f, 5.0f, 56.0f);
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
