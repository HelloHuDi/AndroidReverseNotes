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

/* renamed from: com.tencent.mm.boot.svg.a.a.aad */
public final class aad extends C5163c {
    private final int height = 32;
    private final int width = 32;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(28.0f, 0.0f);
                l.lineTo(28.0f, 28.0f);
                l.lineTo(0.0f, 28.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-436207616);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.866667f, 0.0f, 1.0f, 4.2f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(23.299828f, 10.403306f);
                l2.lineTo(10.333587f, 19.424025f);
                l2.cubicTo(10.104387f, 19.58348f, 9.789319f, 19.526941f, 9.629864f, 19.297743f);
                l2.cubicTo(9.57091f, 19.213003f, 9.53931f, 19.11225f, 9.53931f, 19.009022f);
                l2.lineTo(9.53931f, 0.96758646f);
                l2.cubicTo(9.53931f, 0.68837583f, 9.7656555f, 0.4620309f, 10.044866f, 0.4620309f);
                l2.cubicTo(10.148094f, 0.4620309f, 10.248848f, 0.49363106f, 10.333587f, 0.5525841f);
                l2.lineTo(23.299828f, 9.573301f);
                l2.cubicTo(23.529028f, 9.732758f, 23.585566f, 10.047825f, 23.42611f, 10.277024f);
                l2.cubicTo(23.391844f, 10.326279f, 23.349083f, 10.36904f, 23.299828f, 10.403306f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(10.894444f, 12.605559f);
                l2.lineTo(0.78885674f, 19.442877f);
                l2.cubicTo(0.55760384f, 19.59934f, 0.24329802f, 19.538712f, 0.08683508f, 19.307459f);
                l2.cubicTo(0.030244356f, 19.223816f, 4.564566E-16f, 19.125143f, 4.440892E-16f, 19.024157f);
                l2.lineTo(0.0f, 0.9634772f);
                l2.cubicTo(-3.419344E-17f, 0.68426657f, 0.22634493f, 0.45792165f, 0.50555557f, 0.45792165f);
                l2.cubicTo(0.6081804f, 0.45792165f, 0.70837504f, 0.48915398f, 0.7928226f, 0.5474675f);
                l2.lineTo(10.894444f, 7.522937f);
                l2.lineTo(10.894444f, 12.605559f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
