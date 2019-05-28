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

public final class cj extends c {
    private final int height = 80;
    private final int width = 80;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                k.setColor(-1);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(26.302921f, 41.794167f);
                l.lineTo(26.302921f, 19.211407f);
                l.lineTo(42.211685f, 19.211407f);
                l.cubicTo(45.428864f, 19.211407f, 48.29014f, 20.02573f, 49.282246f, 20.948542f);
                l.cubicTo(51.91206f, 23.283072f, 54.585167f, 22.735918f, 54.585167f, 29.634218f);
                l.cubicTo(54.585167f, 36.532516f, 51.91206f, 37.73257f, 49.282246f, 40.05703f);
                l.cubicTo(48.29014f, 41.03853f, 45.428864f, 41.8407f, 42.211685f, 41.794167f);
                l.lineTo(26.302921f, 41.794167f);
                l.close();
                l.moveTo(21.0f, 14.0f);
                l.lineTo(21.0f, 66.11406f);
                l.lineTo(26.302921f, 66.11406f);
                l.lineTo(26.302921f, 47.005573f);
                l.lineTo(43.979324f, 47.005573f);
                l.cubicTo(49.142723f, 47.14359f, 53.855812f, 44.454838f, 56.352806f, 41.794167f);
                l.cubicTo(58.849804f, 39.133495f, 59.88809f, 35.37987f, 59.88809f, 31.371353f);
                l.cubicTo(59.88809f, 25.94755f, 58.53579f, 22.28079f, 56.352806f, 19.211407f);
                l.cubicTo(53.8633f, 15.711034f, 49.142723f, 14.0f, 43.979324f, 14.0f);
                l.lineTo(21.0f, 14.0f);
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
