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

/* renamed from: com.tencent.mm.boot.svg.a.a.bo */
public final class C45191bo extends C5163c {
    private final int height = 46;
    private final int width = 46;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                a.setColor(-11184811);
                Path l = C5163c.m7884l(looper);
                l.moveTo(33.0f, 23.0f);
                l.lineTo(32.0f, 23.0f);
                l.lineTo(32.0f, 23.0f);
                l.lineTo(32.0f, 4.4975147f);
                l.cubicTo(32.0f, 3.1216204f, 30.880713f, 2.0f, 29.5f, 2.0f);
                l.cubicTo(28.109663f, 2.0f, 27.0f, 3.1181755f, 27.0f, 4.4975147f);
                l.lineTo(27.0f, 23.0f);
                l.lineTo(26.0f, 23.0f);
                l.lineTo(26.0f, 2.497515f);
                l.cubicTo(26.0f, 1.1216205f, 24.880713f, -3.5527137E-15f, 23.5f, -3.5527137E-15f);
                l.cubicTo(22.109663f, -3.5527137E-15f, 21.0f, 1.1181755f, 21.0f, 2.497515f);
                l.lineTo(21.0f, 23.0f);
                l.lineTo(21.0f, 23.0f);
                l.lineTo(20.0f, 23.0f);
                l.lineTo(20.0f, 23.0f);
                l.lineTo(20.0f, 4.4976234f);
                l.cubicTo(20.0f, 3.119065f, 18.880713f, 2.0f, 17.5f, 2.0f);
                l.cubicTo(16.109663f, 2.0f, 15.0f, 3.118224f, 15.0f, 4.4976234f);
                l.lineTo(15.0f, 23.0f);
                l.lineTo(14.0f, 23.0f);
                l.lineTo(14.0f, 7.492989f);
                l.cubicTo(14.0f, 6.1171875f, 12.880712f, 5.0f, 11.5f, 5.0f);
                l.cubicTo(10.109662f, 5.0f, 9.0f, 6.1161494f, 9.0f, 7.492989f);
                l.lineTo(9.0f, 25.753506f);
                l.lineTo(9.0f, 25.753506f);
                l.lineTo(9.0f, 33.0f);
                l.lineTo(9.07604f, 33.0f);
                l.cubicTo(9.823915f, 40.30732f, 15.996335f, 46.0f, 23.5f, 46.0f);
                l.cubicTo(31.008278f, 46.0f, 37.17619f, 40.30293f, 37.923923f, 33.0f);
                l.lineTo(37.923923f, 33.0f);
                l.lineTo(38.0f, 33.0f);
                l.lineTo(38.0f, 26.245796f);
                l.lineTo(38.0f, 17.508408f);
                l.cubicTo(38.0f, 16.115417f, 36.88071f, 15.0f, 35.5f, 15.0f);
                l.cubicTo(34.10966f, 15.0f, 33.0f, 16.123053f, 33.0f, 17.508408f);
                l.lineTo(33.0f, 23.0f);
                l.lineTo(33.0f, 23.0f);
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
