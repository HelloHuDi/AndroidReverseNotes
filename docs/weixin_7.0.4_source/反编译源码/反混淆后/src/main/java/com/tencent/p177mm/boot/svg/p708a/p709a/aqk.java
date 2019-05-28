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

/* renamed from: com.tencent.mm.boot.svg.a.a.aqk */
public final class aqk extends C5163c {
    private final int height = 36;
    private final int width = 46;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 36;
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
                a.setColor(-9205837);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(5.990267f, 0.0f);
                l.lineTo(37.95505f, 0.0f);
                l.cubicTo(40.559513f, 1.7584368f, 40.86003f, 5.144684f, 42.122192f, 7.797411f);
                l.cubicTo(43.063805f, 10.480284f, 45.127342f, 13.555036f, 43.214066f, 16.308245f);
                l.cubicTo(40.839996f, 20.166758f, 35.06009f, 19.654299f, 32.565815f, 16.187666f);
                l.cubicTo(30.011436f, 19.634203f, 25.123058f, 19.86531f, 22.03777f, 17.021667f);
                l.cubicTo(18.942465f, 19.87536f, 14.074121f, 19.614107f, 11.52976f, 16.187666f);
                l.cubicTo(8.604748f, 20.4883f, 1.3122491f, 19.734684f, 0.0f, 14.459374f);
                l.lineTo(0.0f, 12.891853f);
                l.cubicTo(2.093588f, 8.671605f, 2.5744123f, 3.4264398f, 5.990267f, 0.0f);
                l.lineTo(5.990267f, 0.0f);
                l.close();
                l.moveTo(7.0525346f, 3.0f);
                l.cubicTo(5.7748885f, 6.6838603f, 4.008143f, 10.197542f, 3.0f, 13.971498f);
                l.cubicTo(4.3075914f, 17.214895f, 8.759391f, 16.0737f, 9.617809f, 13.100585f);
                l.cubicTo(10.8355665f, 13.080564f, 12.053323f, 13.020501f, 13.27108f, 12.910385f);
                l.cubicTo(14.119516f, 14.65221f, 15.756501f, 16.48413f, 17.912529f, 15.883501f);
                l.cubicTo(19.848963f, 15.112693f, 20.777252f, 13.00048f, 22.004992f, 11.4488535f);
                l.cubicTo(23.402416f, 13.110595f, 24.47045f, 16.013638f, 27.025742f, 15.933554f);
                l.cubicTo(28.902285f, 16.153784f, 29.750723f, 14.251791f, 30.698977f, 13.030511f);
                l.lineTo(34.272392f, 13.030511f);
                l.cubicTo(35.260574f, 15.923543f, 39.592594f, 17.315f, 41.0f, 13.981508f);
                l.cubicTo(40.0218f, 10.207553f, 38.235092f, 6.6838603f, 36.96743f, 3.0f);
                l.lineTo(7.0525346f, 3.0f);
                l.lineTo(7.0525346f, 3.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(4.0f, 21.0f);
                l.lineTo(7.0f, 21.0f);
                l.cubicTo(6.99f, 25.0f, 7.01f, 29.0f, 7.0f, 33.0f);
                l.cubicTo(17.0f, 32.99f, 27.0f, 32.99f, 37.0f, 33.0f);
                l.cubicTo(36.99f, 29.0f, 37.01f, 25.0f, 37.0f, 21.0f);
                l.lineTo(40.0f, 21.0f);
                l.lineTo(40.0f, 36.0f);
                l.lineTo(4.0f, 36.0f);
                l.lineTo(4.0f, 21.0f);
                l.lineTo(4.0f, 21.0f);
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
