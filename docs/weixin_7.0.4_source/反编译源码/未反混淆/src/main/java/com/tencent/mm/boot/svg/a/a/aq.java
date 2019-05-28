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

public final class aq extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(1.8112956f, 10.179302f);
                l.cubicTo(4.1568093f, 5.8457093f, 8.318849f, 2.8101974f, 12.401041f, 0.24399146f);
                l.cubicTo(14.297414f, -0.7745027f, 15.375352f, 1.65191f, 16.3435f, 2.8101974f);
                l.cubicTo(18.96848f, 6.844233f, 22.212275f, 10.468874f, 24.487923f, 14.702615f);
                l.cubicTo(24.34819f, 15.102024f, 24.068724f, 15.920814f, 23.91901f, 16.330208f);
                l.cubicTo(21.05449f, 18.586872f, 17.680943f, 20.064688f, 14.36728f, 21.522532f);
                l.cubicTo(15.724684f, 27.084309f, 19.487488f, 31.617607f, 23.36008f, 35.66163f);
                l.cubicTo(27.63191f, 39.965263f, 32.48263f, 44.08917f, 38.451214f, 45.706776f);
                l.cubicTo(40.13799f, 42.261868f, 41.445488f, 38.407566f, 44.240143f, 35.69158f);
                l.cubicTo(47.543823f, 35.581745f, 49.819473f, 38.9268f, 52.584183f, 40.4146f);
                l.cubicTo(54.96962f, 42.581398f, 58.80229f, 43.74967f, 60.0f, 46.795166f);
                l.cubicTo(58.423016f, 50.669437f, 55.338917f, 53.914642f, 52.23485f, 56.700523f);
                l.cubicTo(49.48012f, 59.23677f, 45.42787f, 59.61621f, 42.064304f, 58.12841f);
                l.cubicTo(24.398094f, 51.348434f, 9.915794f, 36.989666f, 2.5099592f, 19.61535f);
                l.cubicTo(1.3122501f, 16.669706f, 0.18440735f, 13.194844f, 1.8112956f, 10.179302f);
                l.lineTo(1.8112956f, 10.179302f);
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
