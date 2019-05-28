package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class rk extends c {
    private final int height = az.CTRL_INDEX;
    private final int width = az.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return az.CTRL_INDEX;
            case 1:
                return az.CTRL_INDEX;
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
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-12206054);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(192.0f, 0.0f);
                l.lineTo(192.0f, 192.0f);
                l.lineTo(0.0f, 192.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(119.15902f, 118.16251f);
                l2.cubicTo(120.66709f, 116.64901f, 126.05303f, 114.05444f, 128.20741f, 116.64901f);
                l2.cubicTo(130.36179f, 119.24358f, 145.01157f, 120.32465f, 150.61296f, 120.75708f);
                l2.cubicTo(156.21434f, 121.18951f, 155.9989f, 127.459724f, 155.9989f, 127.459724f);
                l2.lineTo(155.9989f, 147.56764f);
                l2.lineTo(155.9989f, 150.16222f);
                l2.cubicTo(154.70627f, 152.973f, 152.98277f, 155.35136f, 150.39752f, 155.56757f);
                l2.cubicTo(146.73508f, 156.0f, 141.13368f, 156.0f, 138.11755f, 156.0f);
                l2.cubicTo(111.83414f, 152.10814f, 88.3514f, 139.3515f, 70.6855f, 120.9733f);
                l2.cubicTo(52.37328f, 103.459946f, 39.87788f, 79.89259f, 36.0f, 53.73067f);
                l2.cubicTo(36.0f, 50.70367f, 36.0f, 45.0821f, 36.430878f, 41.40646f);
                l2.cubicTo(36.646313f, 38.81189f, 39.01613f, 37.082172f, 41.816822f, 36.001102f);
                l2.lineTo(44.402077f, 36.001102f);
                l2.lineTo(64.4378f, 36.001102f);
                l2.cubicTo(64.4378f, 36.001102f, 70.47006f, 35.78489f, 71.11637f, 41.40646f);
                l2.cubicTo(71.54725f, 47.02803f, 72.62444f, 61.51438f, 75.209694f, 63.676525f);
                l2.cubicTo(77.79495f, 66.05488f, 74.994255f, 71.244026f, 73.70163f, 72.75752f);
                l2.cubicTo(72.62444f, 73.83859f, 64.00693f, 83.1358f, 59.698166f, 87.6763f);
                l2.cubicTo(64.868675f, 96.97352f, 72.193565f, 104.97344f, 79.08758f, 112.973366f);
                l2.cubicTo(87.05878f, 119.67601f, 94.814545f, 126.81108f, 104.29381f, 132.21643f);
                l2.cubicTo(108.818f, 127.89215f, 118.08183f, 119.24358f, 119.15902f, 118.16251f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
