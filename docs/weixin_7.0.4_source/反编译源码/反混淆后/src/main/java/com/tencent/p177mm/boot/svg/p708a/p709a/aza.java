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

/* renamed from: com.tencent.mm.boot.svg.a.a.aza */
public final class aza extends C5163c {
    private final int height = 63;
    private final int width = 63;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-14624737);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(21.0f, 21.0f);
                l.lineTo(43.5f, 21.0f);
                l.lineTo(43.5f, 21.127842f);
                l.cubicTo(51.115696f, 22.108934f, 57.0f, 28.61729f, 57.0f, 36.5f);
                l.cubicTo(57.0f, 44.209316f, 51.37172f, 50.604076f, 44.0f, 51.79944f);
                l.lineTo(44.0f, 52.0f);
                l.lineTo(20.0f, 52.0f);
                l.lineTo(20.0f, 46.0f);
                l.lineTo(44.0f, 46.0f);
                l.lineTo(44.0f, 46.16791f);
                l.cubicTo(47.53181f, 44.624798f, 50.0f, 41.10064f, 50.0f, 37.0f);
                l.cubicTo(50.0f, 32.07876f, 46.445118f, 27.987804f, 41.763157f, 27.15494f);
                l.lineTo(41.763157f, 27.0f);
                l.lineTo(21.0f, 27.0f);
                l.lineTo(21.0f, 32.99984f);
                l.cubicTo(21.0f, 34.664913f, 19.933712f, 35.176052f, 18.61838f, 34.159657f);
                l.lineTo(6.88162f, 25.090343f);
                l.cubicTo(5.5572495f, 24.066965f, 5.5662875f, 22.42605f, 6.88162f, 21.409657f);
                l.lineTo(18.61838f, 12.3403425f);
                l.cubicTo(19.94275f, 11.316965f, 21.0f, 11.843217f, 21.0f, 13.500159f);
                l.lineTo(21.0f, 21.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
