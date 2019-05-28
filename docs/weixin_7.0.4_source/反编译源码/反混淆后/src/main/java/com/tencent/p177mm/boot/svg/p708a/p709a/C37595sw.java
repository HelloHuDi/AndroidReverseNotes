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

/* renamed from: com.tencent.mm.boot.svg.a.a.sw */
public final class C37595sw extends C5163c {
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                a.setStrokeWidth(3.6f);
                float[] a2 = C5163c.m7878a(g, 0.94551855f, 0.32556817f, -10.369054f, -0.32556817f, 0.94551855f, 13.085754f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                Path l = C5163c.m7884l(looper);
                l.moveTo(36.109615f, 51.832035f);
                l.cubicTo(36.478947f, 50.021828f, 36.61918f, 49.59024f, 37.10293f, 48.37378f);
                l.cubicTo(37.617302f, 47.08031f, 38.36604f, 45.48333f, 39.349148f, 43.58284f);
                l.lineTo(35.89752f, 43.68798f);
                l.cubicTo(34.03586f, 43.65715f, 32.764465f, 43.080475f, 31.923151f, 42.54983f);
                l.moveTo(15.645319f, 47.33276f);
                l.cubicTo(14.195042f, 44.7577f, 14.170011f, 43.34008f, 17.084476f, 40.53985f);
                l.cubicTo(19.027452f, 38.673027f, 21.28408f, 36.735832f, 23.854359f, 34.728264f);
                l.cubicTo(24.246042f, 34.41258f, 24.686108f, 34.170578f, 25.152336f, 34.00258f);
                l.cubicTo(26.48819f, 33.52123f, 27.450783f, 34.054688f, 27.943132f, 35.135555f);
                l.cubicTo(27.49523f, 33.24668f, 31.003172f, 32.77779f, 33.043427f, 32.451065f);
                l.cubicTo(34.511005f, 32.21605f, 35.256187f, 32.098164f, 39.643166f, 32.16007f);
                l.cubicTo(44.030144f, 32.221977f, 52.396873f, 32.85147f, 53.08276f, 42.162327f);
                l.cubicTo(53.334805f, 45.583813f, 52.80872f, 50.06321f, 51.504498f, 55.600517f);
                l.cubicTo(49.4391f, 63.581837f, 42.106003f, 69.94804f, 31.248415f, 66.42019f);
                l.cubicTo(27.61513f, 65.23966f, 22.837711f, 59.587795f, 16.916162f, 49.46458f);
                l.cubicTo(16.743603f, 49.21144f, 15.805292f, 47.616802f, 15.645319f, 47.33276f);
                l.close();
                l.moveTo(28.117203f, 34.050526f);
                l.cubicTo(27.943542f, 34.585f, 27.907475f, 35.209015f, 28.048918f, 35.81476f);
                l.lineTo(28.442316f, 37.49951f);
                l.cubicTo(28.952667f, 39.685127f, 30.270315f, 41.509167f, 32.035316f, 42.622417f);
                l.moveTo(31.690058f, 43.151917f);
                l.lineTo(22.775629f, 49.957634f);
                l.cubicTo(19.907536f, 51.69366f, 18.071772f, 50.685135f, 16.16978f, 48.138805f);
                l.moveTo(26.226873f, 33.055264f);
                l.lineTo(19.194607f, 18.60711f);
                l.cubicTo(18.382626f, 16.222755f, 19.55927f, 13.596453f, 21.822718f, 12.741097f);
                l.cubicTo(24.107006f, 11.8828945f, 26.174154f, 13.016047f, 27.450985f, 15.504925f);
                l.lineTo(32.419773f, 24.335133f);
                l.cubicTo(33.146152f, 25.473629f, 34.188427f, 26.598293f, 35.928833f, 26.32376f);
                l.cubicTo(37.66924f, 26.049223f, 38.702583f, 25.042978f, 38.702583f, 23.456533f);
                l.lineTo(38.4871f, 12.351198f);
                l.cubicTo(38.4871f, 10.094774f, 39.539852f, 8.173945f, 41.852806f, 7.715035f);
                l.cubicTo(41.938004f, 7.698131f, 42.02367f, 7.6839695f, 42.10969f, 7.67257f);
                l.cubicTo(44.642258f, 7.3369603f, 46.99055f, 9.119869f, 47.489254f, 11.756927f);
                l.lineTo(49.095047f, 34.196342f);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(a2, 0.70710677f, -0.70710677f, 24.052986f, 0.70710677f, 0.70710677f, -35.269047f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(54.600002f, 14.228428f);
                l.lineTo(50.775883f, 16.24984f);
                l.cubicTo(50.405285f, 16.445734f, 49.946056f, 16.304111f, 49.75016f, 15.9335165f);
                l.cubicTo(49.63286f, 15.711599f, 49.63286f, 15.446037f, 49.75016f, 15.224119f);
                l.lineTo(51.771572f, 11.400001f);
                l.lineTo(49.75016f, 7.5758815f);
                l.cubicTo(49.554268f, 7.2052865f, 49.69589f, 6.746056f, 50.066483f, 6.5501614f);
                l.cubicTo(50.288403f, 6.4328566f, 50.553963f, 6.4328566f, 50.775883f, 6.5501614f);
                l.lineTo(54.600002f, 8.571573f);
                l.lineTo(58.424118f, 6.5501614f);
                l.cubicTo(58.794716f, 6.3542666f, 59.253944f, 6.495889f, 59.44984f, 6.8664837f);
                l.cubicTo(59.567142f, 7.088402f, 59.567142f, 7.353964f, 59.44984f, 7.5758815f);
                l.lineTo(57.42843f, 11.400001f);
                l.lineTo(59.44984f, 15.224119f);
                l.cubicTo(59.645733f, 15.594714f, 59.504112f, 16.053946f, 59.13352f, 16.24984f);
                l.cubicTo(58.9116f, 16.367144f, 58.646038f, 16.367144f, 58.424118f, 16.24984f);
                l.lineTo(54.600002f, 14.228428f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
