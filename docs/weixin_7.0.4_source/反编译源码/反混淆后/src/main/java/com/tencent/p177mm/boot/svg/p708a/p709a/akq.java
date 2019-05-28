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

/* renamed from: com.tencent.mm.boot.svg.a.a.akq */
public final class akq extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(31.552f, 0.089f);
                l.cubicTo(36.477f, -0.264f, 41.481f, 0.453f, 46.096f, 2.217f);
                l.cubicTo(52.452f, 4.625f, 58.037f, 9.004f, 61.913f, 14.586f);
                l.cubicTo(63.992f, 17.566f, 65.588f, 20.883f, 66.615f, 24.369f);
                l.cubicTo(68.773f, 31.659f, 68.4f, 39.674f, 65.539f, 46.72f);
                l.cubicTo(63.273f, 52.354f, 59.455f, 57.347f, 54.627f, 61.029f);
                l.cubicTo(49.385f, 65.052f, 42.943f, 67.485f, 36.348f, 67.918f);
                l.cubicTo(31.984f, 68.218f, 27.561f, 67.681f, 23.404f, 66.314f);
                l.cubicTo(17.003f, 64.229f, 11.27f, 60.173f, 7.147f, 54.854f);
                l.cubicTo(4.738f, 51.759f, 2.868f, 48.244f, 1.658f, 44.512f);
                l.cubicTo(0.025f, 39.504f, -0.4f, 34.114f, 0.381f, 28.907f);
                l.cubicTo(1.448f, 21.662f, 4.972f, 14.819f, 10.213f, 9.709f);
                l.cubicTo(15.02f, 4.983f, 21.263f, 1.734f, 27.902f, 0.548f);
                l.cubicTo(29.109f, 0.329f, 30.328f, 0.176f, 31.552f, 0.089f);
                l.lineTo(31.552f, 0.089f);
                l.close();
                l.moveTo(30.439f, 26.843f);
                l.cubicTo(28.893f, 27.609f, 27.609f, 28.891f, 26.842f, 30.437f);
                l.cubicTo(23.199f, 37.657f, 19.553f, 44.875f, 15.911f, 52.096f);
                l.cubicTo(23.174f, 48.431f, 30.436f, 44.765f, 37.699f, 41.1f);
                l.cubicTo(39.147f, 40.347f, 40.354f, 39.139f, 41.103f, 37.688f);
                l.cubicTo(44.772f, 30.427f, 48.437f, 23.165f, 52.104f, 15.904f);
                l.cubicTo(44.882f, 19.55f, 37.66f, 23.195f, 30.439f, 26.843f);
                l.lineTo(30.439f, 26.843f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(33.346f, 31.079f);
                l.cubicTo(34.928f, 30.679f, 36.668f, 31.815f, 36.943f, 33.421f);
                l.cubicTo(37.306f, 35.014f, 36.122f, 36.729f, 34.507f, 36.961f);
                l.cubicTo(32.928f, 37.277f, 31.267f, 36.087f, 31.044f, 34.497f);
                l.cubicTo(30.753f, 32.98f, 31.835f, 31.384f, 33.346f, 31.079f);
                l.lineTo(33.346f, 31.079f);
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
