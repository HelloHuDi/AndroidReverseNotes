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

/* renamed from: com.tencent.mm.boot.svg.a.a.ajy */
public final class ajy extends C5163c {
    private final int height = 54;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 54;
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
                a.setColor(-8421505);
                Path l = C5163c.m7884l(looper);
                l.moveTo(43.0f, 0.0f);
                l.cubicTo(39.693f, 0.0f, 36.614f, 0.879f, 34.0f, 2.374f);
                l.cubicTo(29.205f, 5.118f, 26.0f, 9.968f, 26.0f, 15.5f);
                l.lineTo(26.0f, 38.5f);
                l.cubicTo(26.0f, 42.642f, 21.97f, 46.0f, 17.0f, 46.0f);
                l.cubicTo(12.029f, 46.0f, 8.0f, 42.642f, 8.0f, 38.5f);
                l.cubicTo(8.0f, 35.552f, 10.046f, 33.009f, 13.015f, 31.783f);
                l.cubicTo(13.229f, 31.695f, 13.446f, 31.611f, 13.669f, 31.537f);
                l.cubicTo(15.538f, 30.787f, 17.141f, 29.379f, 17.736f, 27.744f);
                l.cubicTo(18.615f, 25.33f, 16.979f, 23.374f, 14.083f, 23.374f);
                l.cubicTo(13.361f, 23.374f, 12.629f, 23.496f, 11.923f, 23.716f);
                l.cubicTo(11.92f, 23.717f, 11.917f, 23.718f, 11.913f, 23.719f);
                l.cubicTo(7.726f, 24.921f, 4.231f, 27.557f, 2.133f, 31.0f);
                l.cubicTo(0.778f, 33.225f, 0.0f, 35.78f, 0.0f, 38.5f);
                l.cubicTo(0.0f, 47.047f, 7.626f, 54.0f, 17.0f, 54.0f);
                l.cubicTo(20.307f, 54.0f, 23.386f, 53.121f, 26.0f, 51.626f);
                l.cubicTo(30.795f, 48.882f, 34.0f, 44.032f, 34.0f, 38.5f);
                l.lineTo(34.0f, 15.5f);
                l.cubicTo(34.0f, 11.358f, 38.029f, 8.0f, 43.0f, 8.0f);
                l.cubicTo(47.97f, 8.0f, 52.0f, 11.358f, 52.0f, 15.5f);
                l.cubicTo(52.0f, 18.574f, 49.781f, 21.216f, 46.604f, 22.374f);
                l.cubicTo(44.555f, 23.061f, 42.876f, 24.544f, 42.236f, 26.301f);
                l.cubicTo(41.362f, 28.703f, 42.99f, 30.651f, 45.873f, 30.651f);
                l.cubicTo(46.526f, 30.651f, 47.186f, 30.539f, 47.829f, 30.357f);
                l.cubicTo(47.934f, 30.328f, 48.038f, 30.296f, 48.142f, 30.265f);
                l.cubicTo(52.304f, 29.056f, 55.778f, 26.428f, 57.866f, 23.0f);
                l.cubicTo(59.222f, 20.776f, 60.0f, 18.22f, 60.0f, 15.5f);
                l.cubicTo(60.0f, 6.953f, 52.374f, 0.0f, 43.0f, 0.0f);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
