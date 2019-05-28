package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.anx */
public final class anx extends C5163c {
    private final int height = C33250az.CTRL_INDEX;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return C33250az.CTRL_INDEX;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-13421773);
                Path l = C5163c.m7884l(looper);
                l.moveTo(64.663895f, 28.437271f);
                l.cubicTo(62.8161f, 26.772472f, 59.729828f, 26.66011f, 57.775352f, 28.182531f);
                l.lineTo(49.72013f, 34.45708f);
                l.lineTo(53.791866f, 42.888355f);
                l.lineTo(28.658388f, 19.66337f);
                l.cubicTo(26.833735f, 17.977272f, 23.881802f, 17.99533f, 22.078856f, 19.690735f);
                l.lineTo(0.0f, 40.45262f);
                l.lineTo(0.0f, 57.0f);
                l.lineTo(78.0f, 57.0f);
                l.lineTo(78.0f, 40.45262f);
                l.lineTo(64.663895f, 28.437271f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-13421773);
                a2.setStrokeWidth(6.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(3.0f, 6.0f);
                l.cubicTo(3.0f, 4.3431454f, 4.3431454f, 3.0f, 6.0f, 3.0f);
                l.lineTo(72.0f, 3.0f);
                l.cubicTo(73.65685f, 3.0f, 75.0f, 4.3431454f, 75.0f, 6.0f);
                l.lineTo(75.0f, 54.0f);
                l.cubicTo(75.0f, 55.656853f, 73.65685f, 57.0f, 72.0f, 57.0f);
                l.lineTo(6.0f, 57.0f);
                l.cubicTo(4.3431454f, 57.0f, 3.0f, 55.656853f, 3.0f, 54.0f);
                l.lineTo(3.0f, 6.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
