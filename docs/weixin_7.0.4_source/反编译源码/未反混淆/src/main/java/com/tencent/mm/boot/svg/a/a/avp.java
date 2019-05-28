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

public final class avp extends c {
    private final int height = 42;
    private final int width = 42;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-4210753);
                a2.setStrokeWidth(2.3841698f);
                Path l = c.l(looper);
                l.moveTo(13.255814f, 19.44186f);
                l.cubicTo(15.75252f, 23.571234f, 11.813965f, 25.277498f, 9.72093f, 26.511627f);
                l.cubicTo(3.0922725f, 30.251368f, 0.0f, 31.759228f, 0.0f, 33.581394f);
                l.lineTo(0.0f, 36.23256f);
                l.cubicTo(0.0f, 37.254696f, 0.64349174f, 38.0f, 1.7674419f, 38.0f);
                l.lineTo(36.23256f, 38.0f);
                l.cubicTo(37.356506f, 38.0f, 38.0f, 37.254696f, 38.0f, 36.23256f);
                l.lineTo(38.0f, 33.581394f);
                l.cubicTo(38.0f, 31.759228f, 34.907726f, 30.251368f, 28.27907f, 26.511627f);
                l.cubicTo(26.186035f, 25.277498f, 22.24748f, 23.571234f, 24.744186f, 19.44186f);
                l.cubicTo(26.726433f, 16.674295f, 28.370281f, 15.399918f, 28.27907f, 10.604651f);
                l.cubicTo(28.370281f, 5.2031674f, 24.697962f, 0.0f, 19.44186f, 0.0f);
                l.cubicTo(13.302039f, 0.0f, 9.629718f, 5.2031674f, 9.72093f, 10.604651f);
                l.cubicTo(9.629718f, 15.399918f, 11.273568f, 16.674295f, 13.255814f, 19.44186f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-4737097);
                l = c.l(looper);
                l.moveTo(16.347082f, 34.10343f);
                l.lineTo(18.393309f, 36.05255f);
                l.lineTo(18.393309f, 36.05255f);
                l.cubicTo(18.723711f, 36.36727f, 19.241936f, 36.370655f, 19.57642f, 36.060276f);
                l.lineTo(21.677546f, 34.110565f);
                l.lineTo(21.677546f, 34.110565f);
                l.cubicTo(22.181849f, 33.642605f, 22.36036f, 32.91999f, 22.131973f, 32.27103f);
                l.lineTo(18.981232f, 23.318182f);
                l.lineTo(15.904492f, 32.292583f);
                l.lineTo(15.904492f, 32.292583f);
                l.cubicTo(15.6856785f, 32.930836f, 15.858533f, 33.63807f, 16.347082f, 34.10343f);
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
