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

/* renamed from: com.tencent.mm.boot.svg.a.a.kx */
public final class C6359kx extends C5163c {
    private final int height = 144;
    private final int width = 144;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                a.setColor(-9276814);
                Path l = C5163c.m7884l(looper);
                l.moveTo(136.0f, 32.3276f);
                l.cubicTo(131.26967f, 34.436882f, 126.21149f, 35.84307f, 120.919136f, 36.452423f);
                l.cubicTo(126.352f, 33.218185f, 130.52031f, 28.062155f, 132.48738f, 21.921793f);
                l.cubicTo(127.4292f, 24.921665f, 121.809f, 27.124695f, 115.814125f, 28.29652f);
                l.cubicTo(111.03696f, 23.187365f, 104.19905f, 20.0f, 96.658615f, 20.0f);
                l.cubicTo(82.13977f, 20.0f, 70.38419f, 31.765121f, 70.38419f, 46.29575f);
                l.cubicTo(70.38419f, 48.358162f, 70.61837f, 50.3737f, 71.086716f, 52.295494f);
                l.cubicTo(49.261616f, 51.217415f, 29.91877f, 40.717865f, 16.94548f, 24.827919f);
                l.cubicTo(14.697402f, 28.718376f, 13.386023f, 33.218185f, 13.386023f, 38.046104f);
                l.cubicTo(13.386023f, 47.186337f, 18.022686f, 55.20162f, 25.094769f, 59.93579f);
                l.cubicTo(20.78595f, 59.795174f, 16.75814f, 58.62335f, 13.198683f, 56.654682f);
                l.lineTo(13.198683f, 56.98279f);
                l.cubicTo(13.198683f, 69.73225f, 22.237833f, 80.32555f, 34.274426f, 82.76294f);
                l.cubicTo(32.07318f, 83.37229f, 29.73143f, 83.7004f, 27.342846f, 83.7004f);
                l.cubicTo(25.656788f, 83.7004f, 24.017563f, 83.51291f, 22.378338f, 83.231674f);
                l.cubicTo(25.703623f, 93.68435f, 35.445297f, 101.27777f, 46.91987f, 101.51214f);
                l.cubicTo(37.92755f, 108.54309f, 26.593487f, 112.76166f, 14.2758875f, 112.76166f);
                l.cubicTo(12.168313f, 112.76166f, 10.0607395f, 112.62104f, 8.0f, 112.38667f);
                l.cubicTo(19.615074f, 119.83948f, 33.431393f, 124.19867f, 48.278084f, 124.19867f);
                l.cubicTo(96.61178f, 124.19867f, 123.02671f, 84.12226f, 123.02671f, 49.389366f);
                l.cubicTo(123.02671f, 48.264416f, 122.97987f, 47.09259f, 122.933044f, 45.96764f);
                l.cubicTo(128.03806f, 42.26467f, 132.48738f, 37.624245f, 136.0f, 32.3276f);
                l.lineTo(136.0f, 32.3276f);
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
