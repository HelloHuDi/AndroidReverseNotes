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

/* renamed from: com.tencent.mm.boot.svg.a.a.akv */
public final class akv extends C5163c {
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
                a.setColor(-6710887);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 16.9f, 0.0f, 1.0f, 11.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(24.496f, 1.694f);
                l.cubicTo(27.29f, 0.163f, 30.624f, -0.37f, 33.751f, 0.264f);
                l.cubicTo(36.855f, 0.865f, 39.674f, 2.588f, 41.815f, 4.89f);
                l.cubicTo(44.433f, 7.703f, 46.105f, 11.33f, 46.761f, 15.102f);
                l.cubicTo(47.716f, 20.528f, 46.661f, 26.362f, 43.544f, 30.943f);
                l.cubicTo(42.692f, 32.194f, 41.686f, 33.342f, 40.546f, 34.339f);
                l.cubicTo(40.051f, 34.793f, 39.54f, 35.269f, 39.254f, 35.889f);
                l.cubicTo(39.036f, 36.362f, 39.113f, 36.896f, 39.1f, 37.401f);
                l.cubicTo(39.108f, 37.778f, 39.039f, 38.197f, 39.274f, 38.525f);
                l.cubicTo(39.747f, 39.23f, 40.511f, 39.656f, 41.225f, 40.079f);
                l.cubicTo(46.19f, 43.181f, 51.155f, 46.285f, 56.12f, 49.388f);
                l.cubicTo(56.386f, 49.557f, 56.652f, 49.73f, 56.941f, 49.862f);
                l.cubicTo(58.565f, 50.625f, 59.95f, 51.889f, 60.857f, 53.438f);
                l.cubicTo(61.652f, 54.781f, 62.084f, 56.336f, 62.098f, 57.897f);
                l.cubicTo(62.103f, 59.264f, 62.098f, 60.632f, 62.1f, 62.0f);
                l.lineTo(0.1f, 62.0f);
                l.cubicTo(0.101f, 60.632f, 0.098f, 59.265f, 0.101f, 57.898f);
                l.cubicTo(0.118f, 56.073f, 0.708f, 54.26f, 1.772f, 52.777f);
                l.cubicTo(2.712f, 51.443f, 4.034f, 50.401f, 5.517f, 49.733f);
                l.cubicTo(10.635f, 46.55f, 15.741f, 43.345f, 20.855f, 40.154f);
                l.cubicTo(21.542f, 39.728f, 22.232f, 39.279f, 22.774f, 38.671f);
                l.cubicTo(22.988f, 38.436f, 23.139f, 38.131f, 23.102f, 37.805f);
                l.cubicTo(23.061f, 37.112f, 23.229f, 36.357f, 22.865f, 35.725f);
                l.cubicTo(22.432f, 34.954f, 21.711f, 34.416f, 21.083f, 33.815f);
                l.cubicTo(18.607f, 31.451f, 16.873f, 28.367f, 15.939f, 25.086f);
                l.cubicTo(14.334f, 19.407f, 15.024f, 13.05f, 18.073f, 7.967f);
                l.cubicTo(19.632f, 5.377f, 21.82f, 3.129f, 24.496f, 1.694f);
                l.lineTo(24.496f, 1.694f);
                l.close();
                l.moveTo(25.701f, 5.603f);
                l.cubicTo(23.46f, 7.016f, 21.765f, 9.183f, 20.671f, 11.576f);
                l.cubicTo(19.128f, 14.973f, 18.74f, 18.853f, 19.431f, 22.509f);
                l.cubicTo(20.011f, 25.53f, 21.374f, 28.444f, 23.543f, 30.649f);
                l.cubicTo(24.104f, 31.232f, 24.744f, 31.729f, 25.386f, 32.219f);
                l.cubicTo(26.474f, 33.064f, 27.114f, 34.433f, 27.105f, 35.807f);
                l.cubicTo(27.092f, 36.906f, 27.108f, 38.006f, 27.096f, 39.106f);
                l.cubicTo(27.088f, 39.932f, 26.799f, 40.747f, 26.302f, 41.405f);
                l.cubicTo(25.54f, 42.434f, 24.384f, 43.041f, 23.333f, 43.725f);
                l.cubicTo(18.229f, 46.961f, 13.133f, 50.211f, 7.997f, 53.397f);
                l.cubicTo(7.212f, 53.905f, 6.348f, 54.315f, 5.687f, 54.991f);
                l.cubicTo(4.887f, 55.77f, 4.364f, 56.868f, 4.424f, 57.998f);
                l.cubicTo(22.208f, 58.0f, 39.993f, 58.003f, 57.777f, 57.997f);
                l.cubicTo(57.797f, 56.211f, 56.486f, 54.729f, 55.008f, 53.892f);
                l.cubicTo(49.227f, 50.324f, 43.506f, 46.663f, 37.768f, 43.027f);
                l.cubicTo(36.747f, 42.387f, 35.761f, 41.552f, 35.341f, 40.386f);
                l.cubicTo(35.055f, 39.659f, 35.099f, 38.867f, 35.1f, 38.102f);
                l.cubicTo(35.098f, 37.333f, 35.104f, 36.565f, 35.095f, 35.796f);
                l.cubicTo(35.094f, 34.665f, 35.523f, 33.534f, 36.292f, 32.702f);
                l.cubicTo(36.728f, 32.226f, 37.282f, 31.886f, 37.769f, 31.469f);
                l.cubicTo(39.748f, 29.809f, 41.181f, 27.561f, 42.051f, 25.142f);
                l.cubicTo(43.416f, 21.301f, 43.449f, 17.001f, 42.148f, 13.139f);
                l.cubicTo(41.223f, 10.411f, 39.583f, 7.874f, 37.266f, 6.13f);
                l.cubicTo(35.61f, 4.881f, 33.59f, 4.089f, 31.509f, 4.012f);
                l.cubicTo(29.467f, 3.916f, 27.42f, 4.509f, 25.701f, 5.603f);
                l.lineTo(25.701f, 5.603f);
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
