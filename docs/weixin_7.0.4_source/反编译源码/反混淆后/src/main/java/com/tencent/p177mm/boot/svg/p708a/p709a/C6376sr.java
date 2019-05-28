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

/* renamed from: com.tencent.mm.boot.svg.a.a.sr */
public final class C6376sr extends C5163c {
    private final int height = 405;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return 405;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Paint a2 = C5163c.m7876a(k2, looper);
                a.setColor(-1);
                a2.setColor(838860800);
                a2.setStrokeWidth(1.5f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(191.25f, 381.0f);
                l.lineTo(191.25f, 48.0f);
                l.cubicTo(191.25f, 21.904545f, 170.09546f, 0.75f, 144.0f, 0.75f);
                l.lineTo(48.0f, 0.75f);
                l.cubicTo(21.904545f, 0.75f, 0.75f, 21.904545f, 0.75f, 48.0f);
                l.lineTo(0.75f, 180.0f);
                l.cubicTo(0.75f, 194.87228f, 7.752174f, 208.87663f, 19.65f, 217.8f);
                l.lineTo(53.25f, 243.0f);
                l.cubicTo(65.525536f, 252.20665f, 72.75f, 266.65558f, 72.75f, 282.0f);
                l.lineTo(72.75f, 381.0f);
                l.cubicTo(72.75f, 393.8406f, 83.15938f, 404.25f, 96.0f, 404.25f);
                l.lineTo(168.0f, 404.25f);
                l.cubicTo(180.84062f, 404.25f, 191.25f, 393.8406f, 191.25f, 381.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.drawPath(l, a2);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
