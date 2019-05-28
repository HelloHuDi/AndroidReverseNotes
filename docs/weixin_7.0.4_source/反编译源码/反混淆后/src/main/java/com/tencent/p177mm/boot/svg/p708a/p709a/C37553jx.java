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

/* renamed from: com.tencent.mm.boot.svg.a.a.jx */
public final class C37553jx extends C5163c {
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
                k.setColor(-8617851);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(87.0f, 26.0f);
                l.lineTo(81.0f, 32.0f);
                l.cubicTo(80.87885f, 32.277943f, 80.9f, 32.483356f, 81.0f, 33.0f);
                l.lineTo(81.0f, 65.0f);
                l.cubicTo(80.9f, 67.14137f, 79.08695f, 68.94447f, 77.0f, 69.0f);
                l.lineTo(20.0f, 69.0f);
                l.cubicTo(17.91305f, 68.94447f, 16.1f, 67.14137f, 16.0f, 65.0f);
                l.lineTo(16.0f, 33.0f);
                l.cubicTo(16.1f, 32.483356f, 16.12115f, 32.277943f, 16.0f, 32.0f);
                l.lineTo(10.0f, 26.0f);
                l.cubicTo(8.75645f, 27.917215f, 8.0f, 30.216175f, 8.0f, 33.0f);
                l.lineTo(8.0f, 65.0f);
                l.cubicTo(8.0f, 71.59026f, 13.4396f, 77.0f, 20.0f, 77.0f);
                l.lineTo(77.0f, 77.0f);
                l.cubicTo(83.5604f, 77.0f, 89.0f, 71.59026f, 89.0f, 65.0f);
                l.lineTo(89.0f, 33.0f);
                l.cubicTo(89.0f, 30.216175f, 88.24355f, 27.917215f, 87.0f, 26.0f);
                l.moveTo(17.0f, 22.0f);
                l.lineTo(24.0f, 29.0f);
                l.lineTo(24.0f, 29.0f);
                l.lineTo(49.0f, 53.0f);
                l.lineTo(73.0f, 29.0f);
                l.lineTo(73.0f, 29.0f);
                l.lineTo(80.0f, 22.0f);
                l.cubicTo(80.48633f, 21.519585f, 80.48227f, 21.517807f, 80.0f, 22.0f);
                l.lineTo(81.0f, 21.0f);
                l.lineTo(77.0f, 21.0f);
                l.cubicTo(77.00033f, 21.002222f, 76.96873f, 21.0f, 77.0f, 21.0f);
                l.lineTo(20.0f, 21.0f);
                l.cubicTo(20.031721f, 21.0f, 20.000126f, 21.002222f, 20.0f, 21.0f);
                l.lineTo(16.0f, 21.0f);
                l.lineTo(17.0f, 22.0f);
                l.cubicTo(16.517733f, 21.517807f, 16.514122f, 21.519585f, 17.0f, 22.0f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
