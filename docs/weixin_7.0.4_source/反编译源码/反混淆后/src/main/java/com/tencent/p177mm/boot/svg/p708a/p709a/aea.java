package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.C2262b;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aea */
public final class aea extends C5163c {
    private final int height = C2262b.CTRL_INDEX;
    private final int width = 450;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 450;
            case 1:
                return C2262b.CTRL_INDEX;
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
                canvas.saveLayerAlpha(null, 7, 4);
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(70.67984f, 150.63449f);
                l.cubicTo(67.97303f, 110.35668f, 80.40884f, 71.12603f, 108.708755f, 42.23457f);
                l.cubicTo(166.09906f, -16.355326f, 266.9981f, -10.238467f, 334.07306f, 55.896957f);
                l.cubicTo(401.14804f, 122.03238f, 408.999f, 223.14223f, 351.6087f, 281.73212f);
                l.cubicTo(320.71915f, 313.26736f, 277.22516f, 326.05713f, 233.18497f, 320.83246f);
                l.cubicTo(228.70084f, 330.40506f, 222.63911f, 339.28018f, 214.97217f, 347.10776f);
                l.cubicTo(173.24408f, 389.71017f, 99.76736f, 385.15027f, 50.85731f, 336.92297f);
                l.cubicTo(1.947269f, 288.69565f, -3.8748572f, 215.06361f, 37.85323f, 172.46121f);
                l.cubicTo(47.367443f, 162.74765f, 58.53215f, 155.48589f, 70.67984f, 150.63449f);
                l.close();
                l.moveTo(70.67984f, 150.63449f);
                l.cubicTo(73.46225f, 192.0373f, 92.244995f, 234.54659f, 126.2444f, 268.06973f);
                l.cubicTo(157.21716f, 298.60867f, 195.40207f, 316.3501f, 233.18497f, 320.83246f);
                l.cubicTo(253.10619f, 278.3053f, 241.89159f, 222.01225f, 201.96808f, 182.64603f);
                l.cubicTo(164.20978f, 145.41478f, 111.81031f, 134.20828f, 70.67984f, 150.63449f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
