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

/* renamed from: com.tencent.mm.boot.svg.a.a.er */
public final class C32362er extends C5163c {
    private final int height = 41;
    private final int width = 47;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 47;
            case 1:
                return 41;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -126.0f, 0.0f, 1.0f, -1631.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 127.0f, 0.0f, 1.0f, 1631.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-10526881);
                a2.setStrokeWidth(6.0f);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.27375567f, 36.99819f);
                l.cubicTo(-0.9820049f, 39.20833f, 0.05327524f, 41.0f, 2.6142578f, 41.0f);
                l.lineTo(43.385742f, 41.0f);
                l.cubicTo(45.934128f, 41.0f, 46.981197f, 39.20691f, 45.726246f, 36.99819f);
                l.lineTo(25.273756f, 1.00181f);
                l.cubicTo(24.017996f, -1.2083286f, 21.981197f, -1.2069088f, 20.726244f, 1.00181f);
                l.lineTo(0.27375567f, 36.99819f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-10526881);
                l = C5163c.m7884l(looper);
                l.moveTo(22.22413f, 14.0f);
                l.cubicTo(21.548061f, 14.0f, 21.041523f, 14.548094f, 21.093502f, 15.234215f);
                l.lineTo(22.120932f, 28.7963f);
                l.cubicTo(22.14619f, 29.129715f, 22.437256f, 29.4f, 22.777334f, 29.4f);
                l.lineTo(22.722666f, 29.4f);
                l.cubicTo(23.059927f, 29.4f, 23.353582f, 29.132704f, 23.379068f, 28.7963f);
                l.lineTo(24.406498f, 15.234215f);
                l.cubicTo(24.458138f, 14.552577f, 23.953125f, 14.0f, 23.27587f, 14.0f);
                l.lineTo(22.22413f, 14.0f);
                l.close();
                l.moveTo(23.0f, 35.0f);
                l.cubicTo(24.10457f, 35.0f, 25.0f, 34.10457f, 25.0f, 33.0f);
                l.cubicTo(25.0f, 31.89543f, 24.10457f, 31.0f, 23.0f, 31.0f);
                l.cubicTo(21.89543f, 31.0f, 21.0f, 31.89543f, 21.0f, 33.0f);
                l.cubicTo(21.0f, 34.10457f, 21.89543f, 35.0f, 23.0f, 35.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
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
