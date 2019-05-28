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

public final class aks extends c {
    private final int height = 84;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                Paint a = c.a(k, looper);
                a.setColor(-6710887);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(32.825f, 0.022f);
                l.cubicTo(37.638f, -0.146f, 42.488f, 0.711f, 46.94f, 2.551f);
                l.cubicTo(53.439f, 5.215f, 59.057f, 9.958f, 62.789f, 15.907f);
                l.cubicTo(64.892f, 19.242f, 66.407f, 22.948f, 67.235f, 26.804f);
                l.cubicTo(68.808f, 34.061f, 67.94f, 41.831f, 64.742f, 48.539f);
                l.cubicTo(61.982f, 54.384f, 57.512f, 59.404f, 52.03f, 62.829f);
                l.cubicTo(49.181f, 64.616f, 46.064f, 65.976f, 42.815f, 66.844f);
                l.cubicTo(34.941f, 68.967f, 26.307f, 68.146f, 18.998f, 64.518f);
                l.cubicTo(12.084f, 61.132f, 6.397f, 55.321f, 3.163f, 48.335f);
                l.cubicTo(-0.307f, 40.938f, -0.941f, 32.273f, 1.365f, 24.44f);
                l.cubicTo(3.44f, 17.282f, 7.97f, 10.878f, 14.0f, 6.504f);
                l.cubicTo(19.438f, 2.522f, 26.088f, 0.232f, 32.825f, 0.022f);
                l.lineTo(32.825f, 0.022f);
                l.close();
                l.moveTo(31.653f, 4.092f);
                l.cubicTo(27.312f, 4.422f, 23.049f, 5.72f, 19.262f, 7.865f);
                l.cubicTo(13.874f, 10.9f, 9.467f, 15.64f, 6.843f, 21.24f);
                l.cubicTo(4.258f, 26.698f, 3.415f, 32.948f, 4.4f, 38.902f);
                l.cubicTo(5.027f, 42.734f, 6.416f, 46.439f, 8.458f, 49.742f);
                l.cubicTo(11.772f, 55.127f, 16.829f, 59.419f, 22.691f, 61.794f);
                l.cubicTo(29.634f, 64.643f, 37.654f, 64.732f, 44.662f, 62.049f);
                l.cubicTo(47.883f, 60.825f, 50.887f, 59.036f, 53.504f, 56.794f);
                l.cubicTo(58.197f, 52.789f, 61.613f, 47.306f, 63.101f, 41.315f);
                l.cubicTo(64.164f, 37.071f, 64.283f, 32.594f, 63.457f, 28.297f);
                l.cubicTo(62.742f, 24.559f, 61.295f, 20.965f, 59.232f, 17.768f);
                l.cubicTo(55.947f, 12.656f, 51.076f, 8.58f, 45.456f, 6.267f);
                l.cubicTo(41.112f, 4.463f, 36.339f, 3.725f, 31.653f, 4.092f);
                l.lineTo(31.653f, 4.092f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(30.441f, 26.842f);
                l.cubicTo(37.66f, 23.196f, 44.88f, 19.55f, 52.1f, 15.906f);
                l.cubicTo(48.438f, 23.169f, 44.77f, 30.428f, 41.103f, 37.689f);
                l.cubicTo(40.307f, 39.233f, 38.989f, 40.497f, 37.421f, 41.24f);
                l.cubicTo(30.25f, 44.863f, 23.073f, 48.474f, 15.907f, 52.104f);
                l.cubicTo(19.564f, 44.858f, 23.221f, 37.612f, 26.878f, 30.367f);
                l.cubicTo(27.648f, 28.851f, 28.918f, 27.597f, 30.441f, 26.842f);
                l.lineTo(30.441f, 26.842f);
                l.close();
                l.moveTo(33.349f, 31.077f);
                l.cubicTo(31.868f, 31.377f, 30.79f, 32.916f, 31.031f, 34.411f);
                l.cubicTo(31.209f, 36.036f, 32.892f, 37.282f, 34.499f, 36.962f);
                l.cubicTo(36.126f, 36.734f, 37.317f, 35.001f, 36.939f, 33.4f);
                l.cubicTo(36.654f, 31.804f, 34.922f, 30.684f, 33.349f, 31.077f);
                l.lineTo(33.349f, 31.077f);
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
