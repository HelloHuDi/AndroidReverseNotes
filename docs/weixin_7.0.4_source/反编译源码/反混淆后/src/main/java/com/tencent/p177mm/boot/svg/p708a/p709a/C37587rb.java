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

/* renamed from: com.tencent.mm.boot.svg.a.a.rb */
public final class C37587rb extends C5163c {
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
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-15158035);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(192.0f, 0.0f);
                l.lineTo(192.0f, 192.0f);
                l.lineTo(0.0f, 192.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(142.54546f, 100.831314f);
                l2.cubicTo(139.21634f, 92.18106f, 135.36592f, 85.41221f, 136.1254f, 75.06431f);
                l2.cubicTo(134.93721f, 54.305878f, 117.50597f, 36.5975f, 97.60502f, 36.41379f);
                l2.cubicTo(74.49456f, 36.5975f, 57.06332f, 54.305878f, 55.874607f, 75.06431f);
                l2.cubicTo(56.631752f, 85.41221f, 52.78132f, 92.18106f, 49.454544f, 100.831314f);
                l2.cubicTo(40.531776f, 114.37079f, 42.792137f, 131.66068f, 46.244514f, 133.04007f);
                l2.cubicTo(48.937344f, 131.66068f, 53.50395f, 128.93271f, 59.08464f, 123.37745f);
                l2.cubicTo(59.046963f, 129.886f, 62.21491f, 134.8965f, 65.5047f, 139.48183f);
                l2.cubicTo(60.41336f, 140.68864f, 56.32277f, 143.90248f, 55.874607f, 145.92358f);
                l2.cubicTo(56.75219f, 152.38712f, 65.80511f, 156.04285f, 75.134796f, 155.58621f);
                l2.cubicTo(85.191315f, 155.14914f, 92.27135f, 152.36159f, 94.39498f, 149.14445f);
                l2.cubicTo(95.27298f, 148.79735f, 95.62354f, 148.81863f, 97.60502f, 149.14445f);
                l2.cubicTo(96.38775f, 148.81863f, 96.74691f, 148.79735f, 97.60502f, 149.14445f);
                l2.cubicTo(99.75284f, 152.36159f, 106.82212f, 155.14914f, 116.865204f, 155.58621f);
                l2.cubicTo(126.196144f, 156.04285f, 135.2462f, 152.38712f, 136.1254f, 145.92358f);
                l2.cubicTo(135.67705f, 143.90106f, 131.58717f, 140.68864f, 126.4953f, 139.48183f);
                l2.cubicTo(129.78922f, 134.8965f, 132.94926f, 129.89098f, 132.91536f, 123.37745f);
                l2.cubicTo(138.50232f, 128.93483f, 143.06104f, 131.66068f, 145.7555f, 133.04007f);
                l2.cubicTo(149.20982f, 131.66068f, 151.46875f, 114.37079f, 142.54546f, 100.831314f);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
