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

/* renamed from: com.tencent.mm.boot.svg.a.a.aui */
public final class aui extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-2105120);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(18.423912f, 1.6996584f);
                l.cubicTo(26.590271f, -0.43927705f, 35.747402f, 2.4392903f, 41.2717f, 8.786131f);
                l.cubicTo(48.177082f, 16.36236f, 48.967697f, 28.696222f, 42.943005f, 37.01208f);
                l.cubicTo(39.270145f, 41.95962f, 30.072983f, 41.249973f, 27.981354f, 35.123024f);
                l.cubicTo(24.368542f, 36.812183f, 19.955105f, 37.791695f, 16.30226f, 35.65276f);
                l.cubicTo(11.628621f, 33.084038f, 10.357632f, 27.037048f, 11.458488f, 22.179464f);
                l.cubicTo(12.289135f, 17.721684f, 14.821107f, 12.594236f, 19.814995f, 11.914575f);
                l.cubicTo(22.547123f, 11.174942f, 25.129133f, 12.32437f, 27.130692f, 14.123475f);
                l.cubicTo(27.36087f, 13.603733f, 27.831238f, 12.564251f, 28.071424f, 12.054504f);
                l.cubicTo(30.283146f, 12.04451f, 32.49487f, 12.004529f, 34.706593f, 11.944559f);
                l.cubicTo(28.351643f, 6.4073153f, 17.833452f, 6.757141f, 12.219081f, 13.183943f);
                l.cubicTo(5.884148f, 19.700699f, 6.924958f, 31.424864f, 14.320717f, 36.71223f);
                l.cubicTo(17.863476f, 39.71074f, 22.60717f, 39.87066f, 26.980576f, 40.360416f);
                l.cubicTo(30.393232f, 40.600296f, 30.303162f, 46.77722f, 26.860481f, 46.85718f);
                l.cubicTo(20.415462f, 47.576824f, 13.670211f, 45.55783f, 8.806423f, 41.229984f);
                l.cubicTo(2.4314594f, 35.73272f, -0.45078483f, 26.54729f, 1.7108984f, 18.401346f);
                l.cubicTo(3.6424024f, 10.315371f, 10.347624f, 3.6486883f, 18.423912f, 1.6996584f);
                l.lineTo(18.423912f, 1.6996584f);
                l.close();
                l.moveTo(35.088074f, 12.0f);
                l.cubicTo(34.97896f, 18.984352f, 34.959118f, 25.989065f, 35.097996f, 32.983597f);
                l.cubicTo(38.321896f, 33.278854f, 39.15515f, 29.521967f, 39.680897f, 27.027555f);
                l.cubicTo(40.8415f, 21.570395f, 38.728603f, 15.9706955f, 35.088074f, 12.0f);
                l.lineTo(35.088074f, 12.0f);
                l.close();
                l.moveTo(19.826458f, 29.112526f);
                l.cubicTo(22.167404f, 30.596699f, 25.000652f, 30.143202f, 27.0f, 28.318907f);
                l.cubicTo(26.89953f, 24.783693f, 26.92967f, 21.24848f, 26.959812f, 17.713264f);
                l.cubicTo(25.60347f, 17.434982f, 24.257175f, 17.043327f, 22.88074f, 17.0021f);
                l.cubicTo(17.153961f, 16.837193f, 14.632171f, 26.432774f, 19.826458f, 29.112526f);
                l.lineTo(19.826458f, 29.112526f);
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
