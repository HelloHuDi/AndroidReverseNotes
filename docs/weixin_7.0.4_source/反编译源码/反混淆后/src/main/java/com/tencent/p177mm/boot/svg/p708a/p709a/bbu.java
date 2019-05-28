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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbu */
public final class bbu extends C5163c {
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
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(30.698973f, 20.516636f);
                l.cubicTo(42.005985f, 11.434257f, 56.368374f, 6.0f, 72.0f, 6.0f);
                l.cubicTo(108.45079f, 6.0f, 138.0f, 35.549206f, 138.0f, 72.0f);
                l.cubicTo(138.0f, 87.63162f, 132.56575f, 101.99401f, 123.48336f, 113.301025f);
                l.lineTo(128.00285f, 117.82052f);
                l.lineTo(122.91169f, 122.91169f);
                l.lineTo(21.08831f, 21.088312f);
                l.lineTo(26.17948f, 15.997144f);
                l.lineTo(30.698973f, 20.516636f);
                l.close();
                l.moveTo(118.35804f, 108.1757f);
                l.cubicTo(126.15405f, 98.19952f, 130.8f, 85.64232f, 130.8f, 72.0f);
                l.cubicTo(130.8f, 39.525658f, 104.47434f, 13.200001f, 72.0f, 13.200001f);
                l.cubicTo(58.357685f, 13.200001f, 45.80049f, 17.845951f, 35.824303f, 25.641966f);
                l.lineTo(47.82981f, 37.647472f);
                l.cubicTo(54.664818f, 32.82958f, 63.00197f, 30.0f, 72.0f, 30.0f);
                l.cubicTo(95.19596f, 30.0f, 114.0f, 48.80404f, 114.0f, 72.0f);
                l.cubicTo(114.0f, 80.99803f, 111.170425f, 89.33518f, 106.35253f, 96.17018f);
                l.lineTo(118.35804f, 108.1757f);
                l.close();
                l.moveTo(101.16897f, 90.98663f);
                l.cubicTo(104.73026f, 85.52662f, 106.8f, 79.00501f, 106.8f, 72.0f);
                l.cubicTo(106.8f, 52.78049f, 91.21951f, 37.2f, 72.0f, 37.2f);
                l.cubicTo(64.99499f, 37.2f, 58.47338f, 39.269733f, 53.013367f, 42.83103f);
                l.lineTo(101.16897f, 90.98663f);
                l.close();
                l.moveTo(20.516634f, 30.698975f);
                l.lineTo(25.641964f, 35.824303f);
                l.cubicTo(17.845951f, 45.80049f, 13.200001f, 58.357685f, 13.200001f, 72.0f);
                l.cubicTo(13.200001f, 104.47434f, 39.525658f, 130.8f, 72.0f, 130.8f);
                l.cubicTo(85.64232f, 130.8f, 98.19951f, 126.15405f, 108.1757f, 118.35804f);
                l.lineTo(113.301025f, 123.48337f);
                l.cubicTo(101.99401f, 132.56575f, 87.63162f, 138.0f, 72.0f, 138.0f);
                l.cubicTo(35.549206f, 138.0f, 6.0f, 108.45079f, 6.0f, 72.0f);
                l.cubicTo(6.0f, 56.368374f, 11.434257f, 42.00599f, 20.516634f, 30.698975f);
                l.close();
                l.moveTo(37.647472f, 47.82981f);
                l.lineTo(42.831028f, 53.01337f);
                l.cubicTo(39.269733f, 58.473385f, 37.2f, 64.99499f, 37.2f, 72.0f);
                l.cubicTo(37.2f, 91.21951f, 52.78049f, 106.8f, 72.0f, 106.8f);
                l.cubicTo(79.00501f, 106.8f, 85.52662f, 104.73026f, 90.98663f, 101.16897f);
                l.lineTo(96.17019f, 106.35253f);
                l.cubicTo(89.33519f, 111.17042f, 80.99804f, 114.0f, 72.0f, 114.0f);
                l.cubicTo(48.80404f, 114.0f, 30.0f, 95.19596f, 30.0f, 72.0f);
                l.cubicTo(30.0f, 63.001965f, 32.82958f, 54.664814f, 37.647472f, 47.82981f);
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
