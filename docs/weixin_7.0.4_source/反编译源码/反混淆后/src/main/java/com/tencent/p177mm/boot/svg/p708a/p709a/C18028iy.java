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

/* renamed from: com.tencent.mm.boot.svg.a.a.iy */
public final class C18028iy extends C5163c {
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
                l.moveTo(90.0f, 38.572f);
                l.cubicTo(90.0f, 40.466f, 91.536f, 42.0f, 93.428f, 42.0f);
                l.lineTo(122.0f, 42.0f);
                l.lineTo(90.0f, 10.0f);
                l.lineTo(90.0f, 38.572f);
                l.lineTo(90.0f, 38.572f);
                l.close();
                l.moveTo(84.0f, 10.0f);
                l.lineTo(40.0f, 10.0f);
                l.cubicTo(36.686f, 10.0f, 34.0f, 12.686f, 34.0f, 16.0f);
                l.lineTo(34.0f, 116.0f);
                l.cubicTo(34.0f, 119.314f, 36.686f, 122.0f, 40.0f, 122.0f);
                l.lineTo(116.0f, 122.0f);
                l.cubicTo(119.314f, 122.0f, 122.0f, 119.314f, 122.0f, 116.0f);
                l.lineTo(122.0f, 48.0f);
                l.lineTo(90.0f, 48.0f);
                l.cubicTo(86.686f, 48.002f, 84.0f, 45.316f, 84.0f, 42.0f);
                l.lineTo(84.0f, 10.0f);
                l.close();
                l.moveTo(28.0f, 34.0f);
                l.cubicTo(24.686f, 34.0f, 22.0f, 36.686f, 22.0f, 40.0f);
                l.lineTo(22.0f, 128.0f);
                l.cubicTo(22.0f, 131.314f, 24.686f, 134.0f, 28.0f, 134.0f);
                l.lineTo(96.0f, 134.0f);
                l.cubicTo(99.314f, 134.0f, 102.0f, 131.314f, 102.0f, 128.0f);
                l.lineTo(34.0f, 128.0f);
                l.cubicTo(30.686f, 128.0f, 28.0f, 125.314f, 28.0f, 122.0f);
                l.lineTo(28.0f, 34.0f);
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
