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

/* renamed from: com.tencent.mm.boot.svg.a.a.ns */
public final class C9139ns extends C5163c {
    private final int height = 56;
    private final int width = 10;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 10;
            case 1:
                return 56;
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
                a.setColor(-3684404);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -273.0f, 0.0f, 1.0f, -165.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(278.0f, 175.0f);
                l.cubicTo(280.7614f, 175.0f, 283.0f, 172.76143f, 283.0f, 170.0f);
                l.cubicTo(283.0f, 167.23857f, 280.7614f, 165.0f, 278.0f, 165.0f);
                l.cubicTo(275.2386f, 165.0f, 273.0f, 167.23857f, 273.0f, 170.0f);
                l.cubicTo(273.0f, 172.76143f, 275.2386f, 175.0f, 278.0f, 175.0f);
                l.close();
                l.moveTo(278.0f, 198.0f);
                l.cubicTo(280.7614f, 198.0f, 283.0f, 195.76143f, 283.0f, 193.0f);
                l.cubicTo(283.0f, 190.23857f, 280.7614f, 188.0f, 278.0f, 188.0f);
                l.cubicTo(275.2386f, 188.0f, 273.0f, 190.23857f, 273.0f, 193.0f);
                l.cubicTo(273.0f, 195.76143f, 275.2386f, 198.0f, 278.0f, 198.0f);
                l.close();
                l.moveTo(278.0f, 221.0f);
                l.cubicTo(280.7614f, 221.0f, 283.0f, 218.76143f, 283.0f, 216.0f);
                l.cubicTo(283.0f, 213.23857f, 280.7614f, 211.0f, 278.0f, 211.0f);
                l.cubicTo(275.2386f, 211.0f, 273.0f, 213.23857f, 273.0f, 216.0f);
                l.cubicTo(273.0f, 218.76143f, 275.2386f, 221.0f, 278.0f, 221.0f);
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
