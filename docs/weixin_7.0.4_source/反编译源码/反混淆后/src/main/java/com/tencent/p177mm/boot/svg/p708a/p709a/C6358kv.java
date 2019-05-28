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

/* renamed from: com.tencent.mm.boot.svg.a.a.kv */
public final class C6358kv extends C5163c {
    private final int height = 144;
    private final int width = 144;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                a.setColor(-9276814);
                Path l = C5163c.m7884l(looper);
                l.moveTo(18.0f, 118.0f);
                l.lineTo(18.0f, 48.0f);
                l.lineTo(37.602036f, 48.0f);
                l.cubicTo(40.250168f, 42.636612f, 43.392544f, 37.607285f, 46.872543f, 34.0f);
                l.lineTo(10.101695f, 34.0f);
                l.cubicTo(6.7315254f, 34.00932f, 4.0f, 36.740845f, 4.0f, 40.0f);
                l.lineTo(4.0f, 125.89831f);
                l.cubicTo(4.0f, 129.26848f, 6.7315254f, 132.0f, 10.101695f, 132.0f);
                l.lineTo(119.932205f, 132.0f);
                l.cubicTo(123.30034f, 132.0f, 126.0339f, 129.26848f, 126.0f, 125.89831f);
                l.lineTo(126.0f, 81.6f);
                l.lineTo(112.0f, 93.62034f);
                l.lineTo(112.0f, 118.0f);
                l.lineTo(18.0f, 118.0f);
                l.close();
                l.moveTo(95.0f, 34.411526f);
                l.cubicTo(92.118645f, 34.389153f, 88.57559f, 34.372883f, 85.355934f, 34.372883f);
                l.cubicTo(57.560677f, 34.372883f, 38.688137f, 61.49085f, 38.688137f, 97.42373f);
                l.cubicTo(48.178307f, 75.376274f, 57.458984f, 64.881355f, 95.0f, 64.881355f);
                l.lineTo(95.0f, 87.254234f);
                l.lineTo(140.27118f, 49.627117f);
                l.lineTo(95.0f, 12.0f);
                l.lineTo(95.0f, 34.411526f);
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
