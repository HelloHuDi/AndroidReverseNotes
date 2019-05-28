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

/* renamed from: com.tencent.mm.boot.svg.a.a.afw */
public final class afw extends C5163c {
    private final int height = 120;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                l.moveTo(110.0f, 70.0f);
                l.lineTo(110.0f, 71.0f);
                l.cubicTo(110.0f, 71.34247f, 109.96557f, 71.67689f, 109.89998f, 72.0f);
                l.lineTo(110.0f, 72.0f);
                l.lineTo(110.0f, 95.0f);
                l.cubicTo(110.0f, 97.76142f, 107.76142f, 100.0f, 105.0f, 100.0f);
                l.lineTo(15.0f, 100.0f);
                l.cubicTo(12.238576f, 100.0f, 10.0f, 97.76142f, 10.0f, 95.0f);
                l.lineTo(10.0f, 25.0f);
                l.cubicTo(10.0f, 22.238577f, 12.238576f, 20.0f, 15.0f, 20.0f);
                l.lineTo(105.0f, 20.0f);
                l.cubicTo(107.76142f, 20.0f, 110.0f, 22.238577f, 110.0f, 25.0f);
                l.lineTo(110.0f, 48.0f);
                l.lineTo(109.89998f, 48.0f);
                l.cubicTo(109.96557f, 48.32311f, 110.0f, 48.657536f, 110.0f, 49.0f);
                l.lineTo(110.0f, 50.0f);
                l.lineTo(110.0f, 70.0f);
                l.close();
                l.moveTo(104.0f, 70.0f);
                l.lineTo(104.0f, 50.0f);
                l.lineTo(75.0f, 50.0f);
                l.cubicTo(69.47715f, 50.0f, 65.0f, 54.477154f, 65.0f, 60.0f);
                l.cubicTo(65.0f, 65.52285f, 69.47715f, 70.0f, 75.0f, 70.0f);
                l.lineTo(104.0f, 70.0f);
                l.close();
                l.moveTo(104.0f, 44.0f);
                l.lineTo(104.0f, 26.0f);
                l.lineTo(16.0f, 26.0f);
                l.lineTo(16.0f, 94.0f);
                l.lineTo(104.0f, 94.0f);
                l.lineTo(104.0f, 76.0f);
                l.lineTo(75.0f, 76.0f);
                l.cubicTo(66.163445f, 76.0f, 59.0f, 68.836555f, 59.0f, 60.0f);
                l.cubicTo(59.0f, 51.163445f, 66.163445f, 44.0f, 75.0f, 44.0f);
                l.lineTo(104.0f, 44.0f);
                l.close();
                l.moveTo(75.0f, 65.0f);
                l.cubicTo(72.23858f, 65.0f, 70.0f, 62.761425f, 70.0f, 60.0f);
                l.cubicTo(70.0f, 57.238575f, 72.23858f, 55.0f, 75.0f, 55.0f);
                l.cubicTo(77.76142f, 55.0f, 80.0f, 57.238575f, 80.0f, 60.0f);
                l.cubicTo(80.0f, 62.761425f, 77.76142f, 65.0f, 75.0f, 65.0f);
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
