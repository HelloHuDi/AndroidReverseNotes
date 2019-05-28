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

/* renamed from: com.tencent.mm.boot.svg.a.a.acr */
public final class acr extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = C5163c.m7884l(looper);
                l.moveTo(36.0f, 66.0f);
                l.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                l.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                l.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                l.close();
                l.moveTo(36.0f, 62.4f);
                l.cubicTo(50.58032f, 62.4f, 62.4f, 50.58032f, 62.4f, 36.0f);
                l.cubicTo(62.4f, 21.419683f, 50.58032f, 9.6f, 36.0f, 9.6f);
                l.cubicTo(21.419683f, 9.6f, 9.6f, 21.419683f, 9.6f, 36.0f);
                l.cubicTo(9.6f, 50.58032f, 21.419683f, 62.4f, 36.0f, 62.4f);
                l.close();
                l.moveTo(36.92498f, 50.42498f);
                l.cubicTo(40.728367f, 46.62159f, 42.9f, 41.48727f, 42.9f, 36.0f);
                l.cubicTo(42.9f, 30.51273f, 40.728367f, 25.378408f, 36.92498f, 21.575022f);
                l.lineTo(39.470562f, 19.029438f);
                l.cubicTo(43.81371f, 23.372583f, 46.5f, 29.372583f, 46.5f, 36.0f);
                l.cubicTo(46.5f, 42.62742f, 43.81371f, 48.62742f, 39.470562f, 52.970562f);
                l.lineTo(36.92498f, 50.42498f);
                l.close();
                l.moveTo(30.985281f, 44.485283f);
                l.cubicTo(33.22353f, 42.247032f, 34.5f, 39.22912f, 34.5f, 36.0f);
                l.cubicTo(34.5f, 32.77088f, 33.22353f, 29.752968f, 30.985281f, 27.514719f);
                l.lineTo(33.530865f, 24.969133f);
                l.cubicTo(36.353912f, 27.79218f, 38.1f, 31.692179f, 38.1f, 36.0f);
                l.cubicTo(38.1f, 40.30782f, 36.353912f, 44.20782f, 33.530865f, 47.030865f);
                l.lineTo(30.985281f, 44.485283f);
                l.close();
                l.moveTo(27.59117f, 41.091167f);
                l.lineTo(22.5f, 36.0f);
                l.lineTo(27.59117f, 30.90883f);
                l.cubicTo(28.894112f, 32.211777f, 29.7f, 34.011776f, 29.7f, 36.0f);
                l.cubicTo(29.7f, 37.988224f, 28.894112f, 39.788223f, 27.59117f, 41.091167f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 22.5f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
