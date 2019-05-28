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

public final class yo extends c {
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
                a.setColor(-1150121);
                Path l = c.l(looper);
                l.moveTo(23.357143f, 31.267857f);
                l.cubicTo(25.82522f, 35.67271f, 21.368435f, 37.603485f, 19.517857f, 38.94643f);
                l.cubicTo(11.49915f, 43.23181f, 8.0f, 44.938072f, 8.0f, 46.625f);
                l.lineTo(8.0f, 50.464287f);
                l.cubicTo(8.0f, 51.156628f, 8.728162f, 52.0f, 9.535714f, 52.0f);
                l.lineTo(49.464287f, 52.0f);
                l.cubicTo(50.27184f, 52.0f, 51.0f, 51.156628f, 51.0f, 50.464287f);
                l.lineTo(51.0f, 46.625f);
                l.cubicTo(51.0f, 44.938072f, 47.50085f, 43.23181f, 39.482143f, 38.94643f);
                l.cubicTo(37.631565f, 37.603485f, 33.17478f, 35.67271f, 35.642857f, 31.267857f);
                l.cubicTo(38.24307f, 27.868282f, 40.103214f, 26.426222f, 40.25f, 20.517857f);
                l.cubicTo(40.103214f, 14.887795f, 35.947693f, 9.0f, 29.5f, 9.0f);
                l.cubicTo(23.052307f, 9.0f, 18.896786f, 14.887795f, 18.75f, 20.517857f);
                l.cubicTo(18.896786f, 26.426222f, 20.756931f, 27.868282f, 23.357143f, 31.267857f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-1150121);
                l = c.l(looper);
                l.moveTo(43.0f, 35.0f);
                l.lineTo(43.0f, 24.87092f);
                l.lineTo(43.0f, 20.50185f);
                l.cubicTo(43.0f, 13.046129f, 36.955845f, 7.0f, 29.5f, 7.0f);
                l.cubicTo(24.75873f, 7.0f, 29.5f, 7.0f, 29.5f, 7.0f);
                l.cubicTo(22.040064f, 7.0f, 16.0f, 13.045625f, 16.0f, 20.50328f);
                l.cubicTo(16.0f, 20.50328f, 16.0f, 26.211f, 16.0f, 24.426191f);
                l.lineTo(16.0f, 35.0f);
                l.lineTo(43.0f, 35.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-1);
                l = c.l(looper);
                l.moveTo(22.200684f, 38.115723f);
                l.cubicTo(22.200684f, 38.115723f, 21.690918f, 42.961914f, 23.961914f, 45.899902f);
                l.cubicTo(26.230072f, 48.83422f, 29.463587f, 44.642944f, 29.58355f, 43.118626f);
                l.cubicTo(26.589844f, 42.558025f, 22.200684f, 38.115723f, 22.200684f, 38.115723f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                float[] a2 = c.a(g, -1.0f, 0.0f, 66.79199f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(29.706408f, 38.115723f);
                l.cubicTo(29.706408f, 38.115723f, 29.196642f, 42.961914f, 31.467638f, 45.899902f);
                l.cubicTo(33.738636f, 48.83789f, 37.022217f, 44.632446f, 37.13452f, 43.112915f);
                l.cubicTo(34.14038f, 42.558025f, 29.706408f, 38.115723f, 29.706408f, 38.115723f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
