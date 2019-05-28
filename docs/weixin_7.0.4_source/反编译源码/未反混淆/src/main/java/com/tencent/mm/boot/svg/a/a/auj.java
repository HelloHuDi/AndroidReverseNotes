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

public final class auj extends c {
    private final int height = 60;
    private final int width = 60;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-12206054);
                g = c.a(g, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 7.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(17.423912f, 0.6996584f);
                l.cubicTo(25.590271f, -1.439277f, 34.747402f, 1.4392903f, 40.2717f, 7.7861314f);
                l.cubicTo(47.177082f, 15.362361f, 47.967697f, 27.696222f, 41.943005f, 36.01208f);
                l.cubicTo(38.270145f, 40.95962f, 29.072983f, 40.249973f, 26.981354f, 34.123024f);
                l.cubicTo(23.368542f, 35.812183f, 18.955105f, 36.791695f, 15.30226f, 34.65276f);
                l.cubicTo(10.628621f, 32.084038f, 9.357632f, 26.037048f, 10.458488f, 21.179464f);
                l.cubicTo(11.289135f, 16.721684f, 13.821107f, 11.594236f, 18.814995f, 10.914575f);
                l.cubicTo(21.547123f, 10.174942f, 24.129133f, 11.32437f, 26.130692f, 13.123475f);
                l.cubicTo(26.36087f, 12.603733f, 26.831238f, 11.564251f, 27.071424f, 11.054504f);
                l.cubicTo(29.283146f, 11.04451f, 31.49487f, 11.004529f, 33.706593f, 10.944559f);
                l.cubicTo(27.351643f, 5.4073153f, 16.833452f, 5.757141f, 11.219081f, 12.183943f);
                l.cubicTo(4.884148f, 18.700699f, 5.924958f, 30.424864f, 13.320717f, 35.71223f);
                l.cubicTo(16.863476f, 38.71074f, 21.60717f, 38.87066f, 25.980576f, 39.360416f);
                l.cubicTo(29.393232f, 39.600296f, 29.303162f, 45.77722f, 25.860481f, 45.85718f);
                l.cubicTo(19.415462f, 46.576824f, 12.670211f, 44.55783f, 7.8064237f, 40.229984f);
                l.cubicTo(1.4314594f, 34.73272f, -1.4507848f, 25.54729f, 0.7108984f, 17.401346f);
                l.cubicTo(2.6424024f, 9.315371f, 9.347624f, 2.6486883f, 17.423912f, 0.6996584f);
                l.lineTo(17.423912f, 0.6996584f);
                l.close();
                l.moveTo(34.088074f, 11.0f);
                l.cubicTo(33.97896f, 17.984352f, 33.959118f, 24.989065f, 34.097996f, 31.983599f);
                l.cubicTo(37.321896f, 32.278854f, 38.15515f, 28.521967f, 38.680897f, 26.027555f);
                l.cubicTo(39.8415f, 20.570395f, 37.728603f, 14.9706955f, 34.088074f, 11.0f);
                l.lineTo(34.088074f, 11.0f);
                l.close();
                l.moveTo(18.826458f, 28.112526f);
                l.cubicTo(21.167404f, 29.596699f, 24.000652f, 29.143202f, 26.0f, 27.318907f);
                l.cubicTo(25.89953f, 23.783693f, 25.92967f, 20.24848f, 25.959812f, 16.713264f);
                l.cubicTo(24.60347f, 16.434982f, 23.257175f, 16.043327f, 21.88074f, 16.0021f);
                l.cubicTo(16.153961f, 15.837192f, 13.632171f, 25.432774f, 18.826458f, 28.112526f);
                l.lineTo(18.826458f, 28.112526f);
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
