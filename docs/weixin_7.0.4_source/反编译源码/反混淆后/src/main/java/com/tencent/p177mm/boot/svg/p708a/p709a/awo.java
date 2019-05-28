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

/* renamed from: com.tencent.mm.boot.svg.a.a.awo */
public final class awo extends C5163c {
    private final int height = 63;
    private final int width = 63;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                k.setColor(-14624737);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(35.0f, 20.0f);
                l.lineTo(50.492165f, 20.0f);
                l.cubicTo(51.322575f, 20.0f, 52.0f, 19.326305f, 52.0f, 18.495262f);
                l.lineTo(52.0f, 13.504739f);
                l.cubicTo(52.0f, 12.668316f, 51.324917f, 12.0f, 50.492165f, 12.0f);
                l.lineTo(12.507836f, 12.0f);
                l.cubicTo(11.677424f, 12.0f, 11.0f, 12.673695f, 11.0f, 13.504739f);
                l.lineTo(11.0f, 18.495262f);
                l.cubicTo(11.0f, 19.331684f, 11.675081f, 20.0f, 12.507836f, 20.0f);
                l.lineTo(27.0f, 20.0f);
                l.lineTo(27.0f, 52.5052f);
                l.cubicTo(27.0f, 53.32327f, 27.673695f, 54.0f, 28.504738f, 54.0f);
                l.lineTo(33.495262f, 54.0f);
                l.cubicTo(34.331684f, 54.0f, 35.0f, 53.330753f, 35.0f, 52.5052f);
                l.lineTo(35.0f, 20.0f);
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
