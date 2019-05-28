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

/* renamed from: com.tencent.mm.boot.svg.a.a.akk */
public final class akk extends C5163c {
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
                l.moveTo(25.547518f, 1.161f);
                l.cubicTo(28.447489f, -0.117f, 31.792843f, -0.355f, 34.835617f, 0.539f);
                l.cubicTo(38.583412f, 1.605f, 41.733036f, 4.275f, 43.799168f, 7.537f);
                l.cubicTo(47.82957f, 13.897f, 48.094204f, 22.41f, 44.610043f, 29.065f);
                l.cubicTo(43.556503f, 31.072f, 42.14846f, 32.898f, 40.436836f, 34.386f);
                l.cubicTo(39.878613f, 34.913f, 39.258472f, 35.477f, 39.083717f, 36.258f);
                l.cubicTo(39.007824f, 36.803f, 39.05975f, 37.358f, 39.04577f, 37.907f);
                l.cubicTo(39.0228f, 38.278f, 39.238503f, 38.604f, 39.481167f, 38.863f);
                l.cubicTo(39.943523f, 39.353f, 40.524715f, 39.706f, 41.103912f, 40.04f);
                l.cubicTo(46.27273f, 43.266f, 51.43057f, 46.512f, 56.603386f, 49.732f);
                l.cubicTo(58.01742f, 50.372f, 59.28666f, 51.347f, 60.21437f, 52.598f);
                l.cubicTo(61.355785f, 54.114f, 61.99889f, 55.999f, 62.01187f, 57.899f);
                l.cubicTo(62.016865f, 59.266f, 62.01187f, 60.633f, 62.01387f, 62.0f);
                l.lineTo(0.0998613f, 62.0f);
                l.cubicTo(0.0998613f, 60.634f, 0.09886269f, 59.268f, 0.10085992f, 57.903f);
                l.cubicTo(0.116837725f, 56.075f, 0.707018f, 54.26f, 1.770541f, 52.775f);
                l.cubicTo(2.7082386f, 51.443f, 4.027406f, 50.402f, 5.507351f, 49.734f);
                l.cubicTo(10.640222f, 46.538f, 15.760111f, 43.319f, 20.888987f, 40.115f);
                l.cubicTo(21.515118f, 39.728f, 22.132261f, 39.313f, 22.645548f, 38.78f);
                l.cubicTo(22.865242f, 38.541f, 23.090929f, 38.252f, 23.06796f, 37.907f);
                l.cubicTo(23.052982f, 37.357f, 23.10591f, 36.802f, 23.030014f, 36.256f);
                l.cubicTo(22.84627f, 35.454f, 22.201164f, 34.879f, 21.625963f, 34.34f);
                l.cubicTo(19.084494f, 32.121f, 17.246048f, 29.16f, 16.188517f, 25.967f);
                l.cubicTo(14.192288f, 19.915f, 14.880333f, 12.951f, 18.310568f, 7.544f);
                l.cubicTo(20.055145f, 4.792f, 22.548683f, 2.472f, 25.547518f, 1.161f);
                l.lineTo(25.547518f, 1.161f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(56.02219f, 17.0f);
                l2.lineTo(72.0f, 17.0f);
                l2.lineTo(72.0f, 21.0f);
                l2.lineTo(56.02219f, 21.0f);
                l2.lineTo(56.02219f, 17.0f);
                l2.lineTo(56.02219f, 17.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(52.02774f, 29.0f);
                l2.lineTo(72.0f, 29.0f);
                l2.lineTo(72.0f, 33.0f);
                l2.lineTo(52.02774f, 33.0f);
                l2.lineTo(52.02774f, 29.0f);
                l2.lineTo(52.02774f, 29.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(56.02219f, 41.0f);
                l2.lineTo(72.0f, 41.0f);
                l2.lineTo(72.0f, 45.0f);
                l2.lineTo(56.02219f, 45.0f);
                l2.lineTo(56.02219f, 41.0f);
                l2.lineTo(56.02219f, 41.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
