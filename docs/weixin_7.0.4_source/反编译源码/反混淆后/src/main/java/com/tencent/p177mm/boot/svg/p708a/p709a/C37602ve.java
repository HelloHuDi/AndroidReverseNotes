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

/* renamed from: com.tencent.mm.boot.svg.a.a.ve */
public final class C37602ve extends C5163c {
    private final int height = 108;
    private final int width = 108;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                k.setColor(-15683841);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(83.536f, 51.622f);
                l.cubicTo(83.706f, 50.222f, 82.506f, 49.728f, 81.518f, 49.842f);
                l.cubicTo(77.568f, 50.3f, 75.446f, 56.019f, 76.0f, 57.999f);
                l.cubicTo(76.771f, 60.757f, 74.209f, 64.999f, 72.0f, 64.999f);
                l.lineTo(43.992f, 64.999f);
                l.cubicTo(42.34f, 64.999f, 41.0f, 66.339f, 41.0f, 67.992f);
                l.lineTo(41.0f, 68.992f);
                l.cubicTo(41.0f, 70.653f, 42.346f, 71.999f, 44.007f, 71.999f);
                l.lineTo(55.412f, 71.999f);
                l.cubicTo(59.928f, 82.978f, 64.233f, 85.999f, 68.0f, 85.999f);
                l.lineTo(75.0f, 85.999f);
                l.cubicTo(82.11f, 85.999f, 86.0f, 80.155f, 86.0f, 74.999f);
                l.cubicTo(86.0f, 63.905f, 82.28f, 61.959f, 83.536f, 51.622f);
                l.lineTo(83.536f, 51.622f);
                l.close();
                l.moveTo(68.0f, 39.006f);
                l.cubicTo(68.0f, 37.345f, 66.654f, 35.999f, 64.993f, 35.999f);
                l.lineTo(52.962f, 35.999f);
                l.cubicTo(51.374f, 31.975f, 49.0f, 26.999f, 49.0f, 26.999f);
                l.cubicTo(47.568f, 23.262f, 43.749f, 22.312f, 40.952f, 22.077f);
                l.cubicTo(40.83f, 22.067f, 40.734f, 22.058f, 40.64f, 22.052f);
                l.cubicTo(40.429f, 22.029f, 40.219f, 22.0f, 40.0f, 22.0f);
                l.lineTo(34.0f, 22.0f);
                l.cubicTo(25.557f, 22.0f, 22.0f, 27.843f, 22.0f, 33.0f);
                l.cubicTo(22.0f, 44.094f, 25.721f, 46.039f, 24.465f, 56.377f);
                l.cubicTo(24.295f, 57.776f, 25.495f, 58.271f, 26.483f, 58.156f);
                l.cubicTo(30.433f, 57.698f, 32.555f, 51.98f, 32.001f, 49.999f);
                l.cubicTo(31.23f, 47.241f, 32.200043f, 45.572628f, 32.54726f, 44.979992f);
                l.cubicTo(33.241585f, 43.794914f, 34.52841f, 42.999f, 36.001f, 42.999f);
                l.lineTo(65.008f, 42.999f);
                l.cubicTo(66.661f, 42.998f, 68.0f, 41.659f, 68.0f, 40.006f);
                l.lineTo(68.0f, 39.006f);
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
