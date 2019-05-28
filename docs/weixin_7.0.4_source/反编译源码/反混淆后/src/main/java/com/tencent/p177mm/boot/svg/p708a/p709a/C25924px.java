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

/* renamed from: com.tencent.mm.boot.svg.a.a.px */
public final class C25924px extends C5163c {
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
                a.setColor(-9538696);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 17.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(50.83f, 1.1693f);
                l.cubicTo(50.65f, 0.9883f, 50.452f, 0.8253f, 50.239f, 0.6813f);
                l.cubicTo(49.814f, 0.3943f, 49.331f, 0.1873f, 48.811f, 0.0813f);
                l.cubicTo(48.551f, 0.0283f, 48.282f, 3.0E-4f, 48.006f, 3.0E-4f);
                l.lineTo(3.994f, 3.0E-4f);
                l.cubicTo(3.443f, 3.0E-4f, 2.918f, 0.1123f, 2.44f, 0.3143f);
                l.cubicTo(1.007f, 0.9213f, 0.0f, 2.3433f, 0.0f, 4.0003f);
                l.lineTo(0.0f, 58.9993f);
                l.cubicTo(0.0f, 61.2163f, 1.788f, 63.0003f, 3.994f, 63.0003f);
                l.lineTo(48.006f, 63.0003f);
                l.cubicTo(50.21f, 63.0003f, 52.0f, 61.2093f, 52.0f, 58.9993f);
                l.lineTo(52.0f, 4.0003f);
                l.cubicTo(52.0f, 2.8923f, 51.553f, 1.8923f, 50.83f, 1.1693f);
                l.close();
                l.moveTo(49.0f, 58.9993f);
                l.cubicTo(49.0f, 59.5513f, 48.554f, 60.0003f, 48.006f, 60.0003f);
                l.lineTo(3.994f, 60.0003f);
                l.cubicTo(3.446f, 60.0003f, 3.0f, 59.5513f, 3.0f, 58.9993f);
                l.lineTo(3.0f, 4.0003f);
                l.cubicTo(3.0f, 3.5093f, 3.329f, 3.1963f, 3.611f, 3.0763f);
                l.cubicTo(3.731f, 3.0253f, 3.86f, 3.0003f, 3.994f, 3.0003f);
                l.lineTo(48.006f, 3.0003f);
                l.cubicTo(48.076f, 3.0003f, 48.145f, 3.0073f, 48.211f, 3.0203f);
                l.cubicTo(48.336f, 3.0463f, 48.453f, 3.0953f, 48.56f, 3.1673f);
                l.cubicTo(48.613f, 3.2033f, 48.663f, 3.2443f, 48.708f, 3.2903f);
                l.cubicTo(48.841f, 3.4233f, 49.0f, 3.6543f, 49.0f, 4.0003f);
                l.lineTo(49.0f, 58.9993f);
                l.close();
                l.moveTo(6.0f, 52.0f);
                l.lineTo(46.0f, 52.0f);
                l.lineTo(46.0f, 10.0f);
                l.lineTo(6.0f, 10.0f);
                l.lineTo(6.0f, 52.0f);
                l.close();
                l.moveTo(9.0f, 49.0f);
                l.lineTo(43.0f, 49.0f);
                l.lineTo(43.0f, 13.0f);
                l.lineTo(9.0f, 13.0f);
                l.lineTo(9.0f, 49.0f);
                l.close();
                l.moveTo(26.0f, 54.0f);
                l.cubicTo(24.895f, 54.0f, 24.0f, 54.895f, 24.0f, 56.0f);
                l.cubicTo(24.0f, 57.105f, 24.895f, 58.0f, 26.0f, 58.0f);
                l.cubicTo(27.105f, 58.0f, 28.0f, 57.105f, 28.0f, 56.0f);
                l.cubicTo(28.0f, 54.895f, 27.105f, 54.0f, 26.0f, 54.0f);
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
