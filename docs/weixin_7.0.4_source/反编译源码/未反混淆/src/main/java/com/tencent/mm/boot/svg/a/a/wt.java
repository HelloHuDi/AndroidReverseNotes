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

public final class wt extends c {
    private final int height = 40;
    private final int width = 40;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                a.setColor(-6710887);
                g = c.a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(1.3680619f, 0.51908463f);
                l.cubicTo(2.7361238f, -0.30945432f, 4.4736624f, 0.15971835f, 5.991512f, 1.7763568E-15f);
                l.cubicTo(13.011567f, 0.089841574f, 20.041607f, -0.079859175f, 27.061663f, 0.06987678f);
                l.cubicTo(28.55954f, -0.049911987f, 29.947575f, 1.407518f, 29.917616f, 2.864948f);
                l.cubicTo(30.027462f, 8.275407f, 30.027462f, 13.695848f, 29.917616f, 19.106308f);
                l.cubicTo(29.977531f, 20.543774f, 28.599483f, 22.021168f, 27.14155f, 21.921345f);
                l.cubicTo(19.053009f, 22.03115f, 10.964467f, 22.021168f, 2.8859117f, 21.921345f);
                l.cubicTo(1.3880336f, 22.021168f, -0.019971706f, 20.553755f, 0.069900975f, 19.066378f);
                l.cubicTo(-0.079886824f, 14.374652f, 0.069900975f, 9.672943f, -1.7763568E-15f, 4.971234f);
                l.cubicTo(0.04992927f, 3.4139798f, -0.19971706f, 1.45743f, 1.3680619f, 0.51908463f);
                l.lineTo(1.3680619f, 0.51908463f);
                l.close();
                l.moveTo(3.1310444f, 3.1222746f);
                l.cubicTo(2.9613454f, 8.367886f, 2.951363f, 13.633441f, 3.1310444f, 18.889025f);
                l.cubicTo(11.047008f, 19.02864f, 18.972954f, 19.048586f, 26.888916f, 18.879051f);
                l.cubicTo(27.03865f, 13.633441f, 27.03865f, 8.377858f, 26.878935f, 3.1322472f);
                l.cubicTo(18.96297f, 2.942767f, 11.047008f, 2.9726849f, 3.1310444f, 3.1222746f);
                l.lineTo(3.1310444f, 3.1222746f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(38.05922f, 3.7132812f);
                l.lineTo(38.05922f, 18.28f);
                l.cubicTo(35.911186f, 17.24404f, 33.821373f, 15.385892f, 32.0f, 13.894882f);
                l.cubicTo(32.0099f, 11.97787f, 32.0099f, 10.060858f, 32.0099f, 8.153527f);
                l.cubicTo(33.80158f, 6.6528354f, 36.020073f, 4.8944707f, 38.05922f, 3.7132812f);
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
