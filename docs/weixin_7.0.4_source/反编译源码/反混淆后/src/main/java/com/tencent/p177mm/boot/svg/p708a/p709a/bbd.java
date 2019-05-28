package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.bbd */
public final class bbd extends C5163c {
    private final int height = C33250az.CTRL_INDEX;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return C33250az.CTRL_INDEX;
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
                k.setColor(-16268960);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(160.0f, 74.91667f);
                l.cubicTo(160.0f, 74.91667f, 160.0f, 74.91667f, 160.0f, 74.91667f);
                l.lineTo(160.0f, 90.03031f);
                l.cubicTo(160.0f, 128.80115f, 133.61324f, 162.5967f, 96.0f, 172.0f);
                l.cubicTo(58.38676f, 162.5967f, 32.0f, 128.80115f, 32.0f, 90.03031f);
                l.lineTo(32.0f, 44.0f);
                l.lineTo(96.0f, 20.0f);
                l.lineTo(160.0f, 44.0f);
                l.lineTo(160.0f, 74.91667f);
                l.close();
                l.moveTo(150.4f, 74.05694f);
                l.lineTo(150.4f, 51.495453f);
                l.lineTo(96.0f, 29.895454f);
                l.lineTo(41.6f, 51.495453f);
                l.lineTo(41.6f, 90.03031f);
                l.cubicTo(41.6f, 123.590324f, 63.904877f, 152.94469f, 96.0f, 162.06497f);
                l.cubicTo(128.09512f, 152.94469f, 150.4f, 123.590324f, 150.4f, 90.03031f);
                l.lineTo(150.4f, 82.61542f);
                l.lineTo(82.631294f, 119.29995f);
                l.lineTo(82.153336f, 119.55992f);
                l.cubicTo(81.563126f, 119.83688f, 80.8987f, 120.0f, 80.194435f, 120.0f);
                l.cubicTo(78.5596f, 120.0f, 77.1384f, 119.15552f, 76.392494f, 117.90834f);
                l.lineTo(76.10826f, 117.32383f);
                l.lineTo(64.2082f, 92.81863f);
                l.cubicTo(64.07966f, 92.551865f, 64.0f, 92.24941f, 64.0f, 91.95546f);
                l.cubicTo(64.0f, 90.82722f, 64.97583f, 89.91308f, 66.17796f, 89.91308f);
                l.cubicTo(66.67041f, 89.91308f, 67.117584f, 90.0643f, 67.4833f, 90.319176f);
                l.lineTo(81.5233f, 99.7002f);
                l.cubicTo(82.5462f, 100.32889f, 83.77549f, 100.69931f, 85.0935f, 100.69931f);
                l.cubicTo(85.87742f, 100.69931f, 86.62875f, 100.56338f, 87.325775f, 100.32379f);
                l.cubicTo(87.325775f, 100.32379f, 132.81609f, 81.36927f, 150.4f, 74.05694f);
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
