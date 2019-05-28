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

public final class bm extends c {
    private final int height = 47;
    private final int width = 47;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 47;
            case 1:
                return 47;
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
                a.setColor(-11184811);
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(8.18948f, 4.4879947f);
                l.cubicTo(6.9855037f, 3.6185236f, 6.176108f, 1.2123127f, 8.401946f, 1.0f);
                l.cubicTo(11.35624f, 2.4962993f, 13.227967f, 5.438347f, 15.676389f, 7.5918045f);
                l.cubicTo(27.230513f, 4.1745806f, 41.273525f, 8.5118265f, 47.0f, 19.572308f);
                l.cubicTo(44.753925f, 23.6568f, 41.42529f, 26.972923f, 37.469368f, 29.399353f);
                l.cubicTo(39.300625f, 31.43149f, 41.910927f, 33.01878f, 42.96314f, 35.596863f);
                l.cubicTo(42.993492f, 37.770542f, 40.332603f, 37.06283f, 39.573795f, 35.859726f);
                l.cubicTo(29.122475f, 25.395742f, 18.650917f, 14.941869f, 8.18948f, 4.4879947f);
                l.lineTo(8.18948f, 4.4879947f);
                l.close();
                l.moveTo(20.0f, 12.398834f);
                l.cubicTo(20.580166f, 12.969742f, 21.730663f, 14.111557f, 22.310827f, 14.682465f);
                l.cubicTo(25.722986f, 14.721838f, 28.28948f, 17.28108f, 28.318981f, 20.696682f);
                l.cubicTo(28.889313f, 21.277433f, 30.029976f, 22.429092f, 30.610142f, 23.0f);
                l.cubicTo(31.357473f, 19.978127f, 31.180473f, 16.444405f, 28.741814f, 14.20999f);
                l.cubicTo(26.499819f, 11.798397f, 22.999159f, 11.650748f, 20.0f, 12.398834f);
                l.lineTo(20.0f, 12.398834f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(1.0f, 19.16008f);
                l.cubicTo(3.10299f, 15.428926f, 6.10299f, 12.309762f, 9.730897f, 10.0f);
                l.cubicTo(11.724253f, 11.974155f, 13.727574f, 13.938439f, 15.681063f, 15.942207f);
                l.cubicTo(14.953488f, 18.982407f, 15.10299f, 22.506273f, 17.564785f, 24.75681f);
                l.cubicTo(19.83721f, 27.18502f, 23.39535f, 27.313341f, 26.445183f, 26.602646f);
                l.cubicTo(27.990034f, 28.073391f, 29.504984f, 29.58362f, 31.0f, 31.11359f);
                l.cubicTo(19.797342f, 34.025467f, 6.4817276f, 29.692198f, 1.0f, 19.16008f);
                l.lineTo(1.0f, 19.16008f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(18.0f, 18.0f);
                l.cubicTo(20.119404f, 19.870647f, 22.129353f, 21.870647f, 24.0f, 24.0f);
                l.cubicTo(20.616915f, 23.910448f, 18.089552f, 21.383085f, 18.0f, 18.0f);
                l.lineTo(18.0f, 18.0f);
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
