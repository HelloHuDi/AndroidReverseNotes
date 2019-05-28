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

/* renamed from: com.tencent.mm.boot.svg.a.a.sp */
public final class C6375sp extends C5163c {
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
                l.moveTo(155.25f, 272.53323f);
                l.cubicTo(155.25f, 262.90875f, 158.09885f, 253.49963f, 163.43755f, 245.4916f);
                l.lineTo(183.31438f, 215.67636f);
                l.cubicTo(188.4888f, 207.91472f, 191.25f, 198.7951f, 191.25f, 189.46677f);
                l.lineTo(191.25f, 48.0f);
                l.cubicTo(191.25f, 21.904545f, 170.09546f, 0.75f, 144.0f, 0.75f);
                l.lineTo(48.0f, 0.75f);
                l.cubicTo(21.904545f, 0.75f, 0.75f, 21.904545f, 0.75f, 48.0f);
                l.lineTo(0.75f, 189.46677f);
                l.cubicTo(0.75f, 198.7951f, 3.5111969f, 207.91472f, 8.685623f, 215.67636f);
                l.lineTo(28.562452f, 245.4916f);
                l.cubicTo(33.901146f, 253.49963f, 36.75f, 262.90875f, 36.75f, 272.53323f);
                l.lineTo(36.75f, 381.0f);
                l.cubicTo(36.75f, 393.8406f, 47.159378f, 404.25f, 60.0f, 404.25f);
                l.lineTo(132.0f, 404.25f);
                l.cubicTo(144.84062f, 404.25f, 155.25f, 393.8406f, 155.25f, 381.0f);
                l.lineTo(155.25f, 272.53323f);
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
