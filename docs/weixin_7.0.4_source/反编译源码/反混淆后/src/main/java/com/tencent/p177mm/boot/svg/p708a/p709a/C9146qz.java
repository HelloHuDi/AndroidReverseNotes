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

/* renamed from: com.tencent.mm.boot.svg.a.a.qz */
public final class C9146qz extends C5163c {
    private final int height = 191;
    private final int width = 191;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 191;
            case 1:
                return 191;
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
                k.setColor(-686547);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(71.7024f, 113.94841f);
                l.lineTo(70.50466f, 117.91833f);
                l.cubicTo(68.771225f, 123.66382f, 71.968994f, 129.74753f, 77.638115f, 131.50388f);
                l.lineTo(96.88131f, 137.46565f);
                l.cubicTo(102.55444f, 139.22325f, 108.55855f, 135.99077f, 110.29208f, 130.24493f);
                l.lineTo(111.371895f, 126.665886f);
                l.lineTo(143.50204f, 136.96637f);
                l.cubicTo(146.29303f, 137.86111f, 148.55556f, 136.22597f, 148.55556f, 133.26476f);
                l.lineTo(148.55556f, 55.65808f);
                l.cubicTo(148.55556f, 52.718987f, 146.2936f, 51.04703f, 143.50204f, 51.92406f);
                l.lineTo(55.177776f, 79.67322f);
                l.lineTo(55.177776f, 108.65085f);
                l.lineTo(71.7024f, 113.94841f);
                l.lineTo(71.7024f, 113.94841f);
                l.close();
                l.moveTo(105.589226f, 124.81204f);
                l.lineTo(104.67921f, 127.869804f);
                l.cubicTo(103.85574f, 130.63673f, 101.00234f, 132.19417f, 98.304535f, 131.34686f);
                l.lineTo(80.01574f, 125.60284f);
                l.cubicTo(77.32027f, 124.756256f, 75.80068f, 121.823364f, 76.6236f, 119.05828f);
                l.lineTo(77.58325f, 115.833725f);
                l.lineTo(105.589226f, 124.81204f);
                l.lineTo(105.589226f, 124.81204f);
                l.close();
                l.moveTo(0.0f, 0.0f);
                l.lineTo(191.0f, 0.0f);
                l.lineTo(191.0f, 191.0f);
                l.lineTo(0.0f, 191.0f);
                l.lineTo(0.0f, 0.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                l.moveTo(47.03692f, 77.76699f);
                l.cubicTo(44.500565f, 76.31182f, 42.444443f, 77.51847f, 42.444443f, 80.42022f);
                l.lineTo(42.444443f, 108.45738f);
                l.cubicTo(42.444443f, 111.37789f, 44.49037f, 112.57163f, 47.03692f, 111.11062f);
                l.lineTo(53.055557f, 107.65758f);
                l.lineTo(53.055557f, 81.22003f);
                l.lineTo(47.03692f, 77.76699f);
                l.lineTo(47.03692f, 77.76699f);
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
