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

/* renamed from: com.tencent.mm.boot.svg.a.a.lu */
public final class C37562lu extends C5163c {
    private final int height = 32;
    private final int width = 32;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                k.setColor(-352965);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(27.466667f, 17.8f);
                l.lineTo(27.466667f, 23.38f);
                l.cubicTo(27.466667f, 23.877056f, 27.063723f, 24.28f, 26.566668f, 24.28f);
                l.lineTo(4.9f, 24.28f);
                l.cubicTo(4.4029436f, 24.28f, 4.0f, 23.877056f, 4.0f, 23.38f);
                l.lineTo(4.0f, 17.8f);
                l.cubicTo(5.1782074f, 17.8f, 6.133333f, 16.832935f, 6.133333f, 15.64f);
                l.cubicTo(6.133333f, 14.447065f, 5.1782074f, 13.48f, 4.0f, 13.48f);
                l.lineTo(4.0f, 7.9f);
                l.cubicTo(4.0f, 7.4029436f, 4.4029436f, 7.0f, 4.9f, 7.0f);
                l.lineTo(26.566668f, 7.0f);
                l.cubicTo(27.063723f, 7.0f, 27.466667f, 7.4029436f, 27.466667f, 7.9f);
                l.lineTo(27.466667f, 13.48f);
                l.cubicTo(26.28846f, 13.48f, 25.333334f, 14.447065f, 25.333334f, 15.64f);
                l.cubicTo(25.333334f, 16.832935f, 26.28846f, 17.8f, 27.466667f, 17.8f);
                l.close();
                l.moveTo(9.783334f, 11.32f);
                l.cubicTo(9.534805f, 11.32f, 9.333333f, 11.521472f, 9.333333f, 11.77f);
                l.lineTo(9.333333f, 13.03f);
                l.cubicTo(9.333333f, 13.278528f, 9.534805f, 13.48f, 9.783334f, 13.48f);
                l.lineTo(18.483334f, 13.48f);
                l.cubicTo(18.731861f, 13.48f, 18.933332f, 13.278528f, 18.933332f, 13.03f);
                l.lineTo(18.933332f, 11.77f);
                l.cubicTo(18.933332f, 11.521472f, 18.731861f, 11.32f, 18.483334f, 11.32f);
                l.lineTo(9.783334f, 11.32f);
                l.close();
                l.moveTo(9.783334f, 15.64f);
                l.cubicTo(9.534805f, 15.64f, 9.333333f, 15.841472f, 9.333333f, 16.09f);
                l.lineTo(9.333333f, 17.35f);
                l.cubicTo(9.333333f, 17.598528f, 9.534805f, 17.8f, 9.783334f, 17.8f);
                l.lineTo(15.283333f, 17.8f);
                l.cubicTo(15.531861f, 17.8f, 15.733334f, 17.598528f, 15.733334f, 17.35f);
                l.lineTo(15.733334f, 16.09f);
                l.cubicTo(15.733334f, 15.841472f, 15.531861f, 15.64f, 15.283333f, 15.64f);
                l.lineTo(9.783334f, 15.64f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
