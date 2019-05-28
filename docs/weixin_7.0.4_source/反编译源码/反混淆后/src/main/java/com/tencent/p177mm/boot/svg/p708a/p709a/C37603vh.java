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

/* renamed from: com.tencent.mm.boot.svg.a.a.vh */
public final class C37603vh extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-9074981);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(61.0f, 21.0f);
                l.cubicTo(57.693f, 21.0f, 54.614f, 21.879f, 52.0f, 23.374f);
                l.cubicTo(47.205f, 26.118f, 44.0f, 30.968f, 44.0f, 36.5f);
                l.lineTo(44.0f, 59.5f);
                l.cubicTo(44.0f, 63.642f, 39.97f, 67.0f, 35.0f, 67.0f);
                l.cubicTo(30.029f, 67.0f, 26.0f, 63.642f, 26.0f, 59.5f);
                l.cubicTo(26.0f, 56.552f, 28.046f, 54.009f, 31.015f, 52.783f);
                l.cubicTo(31.229f, 52.695f, 31.446f, 52.611f, 31.669f, 52.537f);
                l.cubicTo(33.538f, 51.787f, 35.141f, 50.379f, 35.736f, 48.744f);
                l.cubicTo(36.615f, 46.33f, 34.979f, 44.374f, 32.083f, 44.374f);
                l.cubicTo(31.361f, 44.374f, 30.629f, 44.496f, 29.923f, 44.716f);
                l.cubicTo(29.92f, 44.717f, 29.917f, 44.718f, 29.913f, 44.719f);
                l.cubicTo(25.726f, 45.921f, 22.231f, 48.557f, 20.133f, 52.0f);
                l.cubicTo(18.778f, 54.225f, 18.0f, 56.78f, 18.0f, 59.5f);
                l.cubicTo(18.0f, 68.047f, 25.626f, 75.0f, 35.0f, 75.0f);
                l.cubicTo(38.307f, 75.0f, 41.386f, 74.121f, 44.0f, 72.626f);
                l.cubicTo(48.795f, 69.882f, 52.0f, 65.032f, 52.0f, 59.5f);
                l.lineTo(52.0f, 36.5f);
                l.cubicTo(52.0f, 32.358f, 56.029f, 29.0f, 61.0f, 29.0f);
                l.cubicTo(65.97f, 29.0f, 70.0f, 32.358f, 70.0f, 36.5f);
                l.cubicTo(70.0f, 39.574f, 67.781f, 42.216f, 64.604f, 43.374f);
                l.cubicTo(62.555f, 44.061f, 60.876f, 45.544f, 60.236f, 47.301f);
                l.cubicTo(59.362f, 49.703f, 60.99f, 51.651f, 63.873f, 51.651f);
                l.cubicTo(64.526f, 51.651f, 65.186f, 51.539f, 65.829f, 51.357f);
                l.cubicTo(65.934f, 51.328f, 66.038f, 51.296f, 66.142f, 51.265f);
                l.cubicTo(70.304f, 50.056f, 73.778f, 47.428f, 75.866f, 44.0f);
                l.cubicTo(77.222f, 41.776f, 78.0f, 39.22f, 78.0f, 36.5f);
                l.cubicTo(78.0f, 27.953f, 70.374f, 21.0f, 61.0f, 21.0f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
