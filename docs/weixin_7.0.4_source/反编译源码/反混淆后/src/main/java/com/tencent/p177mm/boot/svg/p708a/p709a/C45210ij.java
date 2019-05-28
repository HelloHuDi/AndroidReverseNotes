package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.ij */
public final class C45210ij extends C5163c {
    private final int height = 120;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                a.setColor(-16139513);
                Path l = C5163c.m7884l(looper);
                l.moveTo(115.8f, 60.68889f);
                l.cubicTo(115.8f, 29.181868f, 90.81813f, 4.2f, 59.31111f, 4.2f);
                l.cubicTo(29.181868f, 4.2f, 4.2f, 29.181868f, 4.2f, 60.68889f);
                l.cubicTo(4.2f, 90.81813f, 29.181868f, 115.8f, 59.31111f, 115.8f);
                l.cubicTo(90.81813f, 115.8f, 115.8f, 90.81813f, 115.8f, 60.68889f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(32.582005f, 63.962925f);
                l.cubicTo(32.19982f, 63.567383f, 32.154182f, 62.887268f, 32.48211f, 62.44106f);
                l.lineTo(34.52614f, 59.65979f);
                l.cubicTo(34.853153f, 59.21483f, 35.480194f, 59.131527f, 35.906685f, 59.458405f);
                l.lineTo(50.22881f, 70.43549f);
                l.cubicTo(50.66425f, 70.76923f, 51.36269f, 70.752f, 51.77925f, 70.40497f);
                l.lineTo(87.55628f, 40.59981f);
                l.cubicTo(87.97712f, 40.249214f, 88.639626f, 40.282352f, 89.03474f, 40.672565f);
                l.lineTo(90.83008f, 42.44564f);
                l.cubicTo(91.22577f, 42.836422f, 91.23205f, 43.46271f, 90.83447f, 43.85398f);
                l.lineTo(51.728115f, 82.340485f);
                l.cubicTo(51.334854f, 82.72751f, 50.700047f, 82.714195f, 50.32405f, 82.325066f);
                l.lineTo(32.582005f, 63.962925f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
