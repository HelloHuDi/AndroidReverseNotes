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

/* renamed from: com.tencent.mm.boot.svg.a.a.jn */
public final class C32375jn extends C5163c {
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
                l.moveTo(72.0f, 44.0f);
                l.lineTo(47.0f, 44.0f);
                l.lineTo(47.0f, 52.0f);
                l.lineTo(72.0f, 52.0f);
                l.lineTo(72.0f, 60.0f);
                l.lineTo(87.39076f, 48.0f);
                l.lineTo(72.0f, 36.0f);
                l.lineTo(72.0f, 44.0f);
                l.close();
                l.moveTo(80.0f, 26.0f);
                l.lineTo(80.0f, 23.990396f);
                l.cubicTo(80.0f, 17.382257f, 74.62726f, 12.0f, 67.99965f, 12.0f);
                l.lineTo(28.00035f, 12.0f);
                l.cubicTo(21.373957f, 12.0f, 16.0f, 17.368282f, 16.0f, 23.990396f);
                l.lineTo(16.0f, 72.009605f);
                l.cubicTo(16.0f, 78.617744f, 21.37274f, 84.0f, 28.00035f, 84.0f);
                l.lineTo(67.99965f, 84.0f);
                l.cubicTo(74.626045f, 84.0f, 80.0f, 78.631714f, 80.0f, 72.009605f);
                l.lineTo(80.0f, 70.0f);
                l.lineTo(72.0f, 70.0f);
                l.lineTo(72.0f, 71.995094f);
                l.cubicTo(72.0f, 74.20694f, 70.20595f, 76.0f, 67.990105f, 76.0f);
                l.lineTo(28.009893f, 76.0f);
                l.cubicTo(25.79529f, 76.0f, 24.0f, 74.2002f, 24.0f, 71.995094f);
                l.lineTo(24.0f, 24.004908f);
                l.cubicTo(24.0f, 21.793058f, 25.794052f, 20.0f, 28.009893f, 20.0f);
                l.lineTo(67.990105f, 20.0f);
                l.cubicTo(70.20471f, 20.0f, 72.0f, 21.799795f, 72.0f, 24.004908f);
                l.lineTo(72.0f, 26.0f);
                l.lineTo(80.0f, 26.0f);
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
