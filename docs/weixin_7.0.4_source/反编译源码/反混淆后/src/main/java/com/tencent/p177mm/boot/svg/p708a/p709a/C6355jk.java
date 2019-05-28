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

/* renamed from: com.tencent.mm.boot.svg.a.a.jk */
public final class C6355jk extends C5163c {
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
                l.moveTo(77.0f, 40.0f);
                l.lineTo(77.0f, 48.0f);
                l.cubicTo(79.00536f, 48.166668f, 80.833336f, 49.995094f, 81.0f, 52.0f);
                l.lineTo(81.0f, 77.0f);
                l.cubicTo(80.833336f, 79.00536f, 79.00536f, 80.833336f, 77.0f, 81.0f);
                l.lineTo(52.0f, 81.0f);
                l.cubicTo(49.99464f, 80.833336f, 48.166668f, 79.00536f, 48.0f, 77.0f);
                l.lineTo(40.0f, 77.0f);
                l.cubicTo(40.0f, 83.51563f, 45.48437f, 89.0f, 52.0f, 89.0f);
                l.lineTo(77.0f, 89.0f);
                l.cubicTo(83.51563f, 89.0f, 89.0f, 83.51563f, 89.0f, 77.0f);
                l.lineTo(89.0f, 52.0f);
                l.cubicTo(89.0f, 45.48437f, 83.51563f, 40.0f, 77.0f, 40.0f);
                l.moveTo(16.0f, 57.0f);
                l.lineTo(16.0f, 20.0f);
                l.cubicTo(16.0f, 17.831364f, 17.831364f, 16.0f, 20.0f, 16.0f);
                l.lineTo(57.0f, 16.0f);
                l.cubicTo(59.168636f, 16.0f, 61.0f, 17.831364f, 61.0f, 20.0f);
                l.lineTo(61.0f, 57.0f);
                l.cubicTo(61.0f, 59.168636f, 59.168636f, 61.0f, 57.0f, 61.0f);
                l.lineTo(20.0f, 61.0f);
                l.cubicTo(17.831364f, 61.0f, 16.0f, 59.168636f, 16.0f, 57.0f);
                l.moveTo(69.0f, 57.0f);
                l.lineTo(69.0f, 20.0f);
                l.cubicTo(69.0f, 13.462437f, 63.538013f, 8.0f, 57.0f, 8.0f);
                l.lineTo(20.0f, 8.0f);
                l.cubicTo(13.461986f, 8.0f, 8.0f, 13.462437f, 8.0f, 20.0f);
                l.lineTo(8.0f, 57.0f);
                l.cubicTo(8.0f, 63.538013f, 13.461986f, 69.0f, 20.0f, 69.0f);
                l.lineTo(57.0f, 69.0f);
                l.cubicTo(63.538013f, 69.0f, 69.0f, 63.538013f, 69.0f, 57.0f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
