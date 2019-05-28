package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class je extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k = c.a(k, looper);
                k.setColor(-8683387);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(68.0f, 68.0f);
                l.lineTo(68.0f, 73.0f);
                l.cubicTo(62.75382f, 77.365776f, 55.755802f, 80.0f, 48.0f, 80.0f);
                l.cubicTo(43.030067f, 80.0f, 38.205288f, 78.816f, 34.0f, 77.0f);
                l.lineTo(48.0f, 52.0f);
                l.lineTo(44.0f, 48.0f);
                l.lineTo(36.0f, 48.0f);
                l.lineTo(28.0f, 40.0f);
                l.lineTo(44.0f, 24.0f);
                l.lineTo(38.0f, 18.0f);
                l.cubicTo(40.952587f, 16.616444f, 44.470387f, 16.0f, 48.0f, 16.0f);
                l.cubicTo(52.40803f, 16.0f, 56.485584f, 16.82889f, 60.0f, 18.0f);
                l.lineTo(60.0f, 24.0f);
                l.lineTo(64.0f, 28.0f);
                l.lineTo(73.0f, 28.0f);
                l.cubicTo(75.21601f, 30.406666f, 76.81651f, 33.097332f, 78.0f, 36.0f);
                l.lineTo(64.0f, 36.0f);
                l.lineTo(56.0f, 44.0f);
                l.lineTo(56.0f, 56.0f);
                l.lineTo(68.0f, 68.0f);
                l.close();
                l.moveTo(24.0f, 69.0f);
                l.cubicTo(19.024445f, 63.343204f, 16.0f, 55.91894f, 16.0f, 48.0f);
                l.cubicTo(16.0f, 46.501648f, 16.08311f, 45.241016f, 16.0f, 44.0f);
                l.lineTo(24.0f, 52.0f);
                l.lineTo(24.0f, 69.0f);
                l.close();
                l.moveTo(48.0f, 8.0f);
                l.cubicTo(25.908443f, 8.0f, 8.0f, 25.908443f, 8.0f, 48.0f);
                l.cubicTo(8.0f, 70.09155f, 25.908443f, 88.0f, 48.0f, 88.0f);
                l.cubicTo(70.09155f, 88.0f, 88.0f, 70.09155f, 88.0f, 48.0f);
                l.cubicTo(88.0f, 25.908443f, 70.09155f, 8.0f, 48.0f, 8.0f);
                l.lineTo(48.0f, 8.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
