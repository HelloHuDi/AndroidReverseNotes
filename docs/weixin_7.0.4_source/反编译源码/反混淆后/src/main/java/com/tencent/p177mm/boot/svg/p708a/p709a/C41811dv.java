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

/* renamed from: com.tencent.mm.boot.svg.a.a.dv */
public final class C41811dv extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                canvas.saveLayerAlpha(null, 230, 4);
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(49.0f, 9.0f);
                l.cubicTo(45.693f, 9.0f, 42.614f, 9.879f, 40.0f, 11.374f);
                l.cubicTo(35.205f, 14.118f, 32.0f, 18.968f, 32.0f, 24.5f);
                l.lineTo(32.0f, 47.5f);
                l.cubicTo(32.0f, 51.642f, 27.97f, 55.0f, 23.0f, 55.0f);
                l.cubicTo(18.029f, 55.0f, 14.0f, 51.642f, 14.0f, 47.5f);
                l.cubicTo(14.0f, 44.552f, 16.046f, 42.009f, 19.015f, 40.783f);
                l.cubicTo(19.229f, 40.695f, 19.446f, 40.611f, 19.669f, 40.537f);
                l.cubicTo(21.538f, 39.787f, 23.141f, 38.379f, 23.736f, 36.744f);
                l.cubicTo(24.615f, 34.33f, 22.979f, 32.374f, 20.083f, 32.374f);
                l.cubicTo(19.361f, 32.374f, 18.629f, 32.496f, 17.923f, 32.716f);
                l.cubicTo(17.92f, 32.717f, 17.917f, 32.718f, 17.913f, 32.719f);
                l.cubicTo(13.726f, 33.921f, 10.231f, 36.557f, 8.133f, 40.0f);
                l.cubicTo(6.778f, 42.225f, 6.0f, 44.78f, 6.0f, 47.5f);
                l.cubicTo(6.0f, 56.047f, 13.626f, 63.0f, 23.0f, 63.0f);
                l.cubicTo(26.307f, 63.0f, 29.386f, 62.121f, 32.0f, 60.626f);
                l.cubicTo(36.795f, 57.882f, 40.0f, 53.032f, 40.0f, 47.5f);
                l.lineTo(40.0f, 24.5f);
                l.cubicTo(40.0f, 20.358f, 44.029f, 17.0f, 49.0f, 17.0f);
                l.cubicTo(53.97f, 17.0f, 58.0f, 20.358f, 58.0f, 24.5f);
                l.cubicTo(58.0f, 27.574f, 55.781f, 30.216f, 52.604f, 31.374f);
                l.cubicTo(50.555f, 32.061f, 48.876f, 33.544f, 48.236f, 35.301f);
                l.cubicTo(47.362f, 37.703f, 48.99f, 39.651f, 51.873f, 39.651f);
                l.cubicTo(52.526f, 39.651f, 53.186f, 39.539f, 53.829f, 39.357f);
                l.cubicTo(53.934f, 39.328f, 54.038f, 39.296f, 54.142f, 39.265f);
                l.cubicTo(58.304f, 38.056f, 61.778f, 35.428f, 63.866f, 32.0f);
                l.cubicTo(65.222f, 29.776f, 66.0f, 27.22f, 66.0f, 24.5f);
                l.cubicTo(66.0f, 15.953f, 58.374f, 9.0f, 49.0f, 9.0f);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
