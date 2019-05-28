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

/* renamed from: com.tencent.mm.boot.svg.a.a.aym */
public final class aym extends C5163c {
    private final int height = 131;
    private final int width = 131;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 131;
            case 1:
                return 131;
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
                canvas.saveLayerAlpha(null, 128, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 34.0f, 0.0f, 1.0f, 28.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 45.69477f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = C5163c.m7884l(looper);
                l.moveTo(34.39553f, 7.9594493f);
                l.lineTo(34.39553f, 45.435207f);
                l.lineTo(29.60442f, 45.435207f);
                l.lineTo(29.60442f, 7.90054f);
                l.lineTo(21.149052f, 16.35591f);
                l.lineTo(17.761225f, 12.968081f);
                l.lineTo(31.33464f, -0.60533595f);
                l.cubicTo(31.769945f, -1.0406404f, 32.47571f, -1.0406404f, 32.91102f, -0.60533595f);
                l.lineTo(35.51066f, 1.994303f);
                l.lineTo(35.417305f, 2.0876534f);
                l.lineTo(46.145424f, 12.815773f);
                l.lineTo(42.69864f, 16.262558f);
                l.lineTo(34.39553f, 7.9594493f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(59.14963f, 19.84413f);
                l.lineTo(47.97037f, 19.84413f);
                l.lineTo(47.97037f, 14.96964f);
                l.lineTo(59.952312f, 14.96964f);
                l.cubicTo(62.147545f, 14.96964f, 63.940742f, 16.78067f, 63.940742f, 19.014688f);
                l.lineTo(63.940742f, 71.85572f);
                l.cubicTo(63.940742f, 74.077225f, 62.16069f, 75.90077f, 59.96488f, 75.90077f);
                l.lineTo(4.035117f, 75.90077f);
                l.cubicTo(1.8516147f, 75.90077f, 0.05925926f, 74.089745f, 0.05925926f, 71.85572f);
                l.lineTo(0.05925926f, 19.014688f);
                l.cubicTo(0.05925926f, 16.793188f, 1.8449386f, 14.96964f, 4.0476856f, 14.96964f);
                l.lineTo(16.029629f, 14.96964f);
                l.lineTo(16.029629f, 19.84413f);
                l.lineTo(4.8503704f, 19.84413f);
                l.lineTo(4.8503704f, 71.02628f);
                l.lineTo(59.14963f, 71.02628f);
                l.lineTo(59.14963f, 19.84413f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
