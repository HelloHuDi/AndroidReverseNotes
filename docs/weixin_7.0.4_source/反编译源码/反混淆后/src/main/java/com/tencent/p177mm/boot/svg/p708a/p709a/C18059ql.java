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

/* renamed from: com.tencent.mm.boot.svg.a.a.ql */
public final class C18059ql extends C5163c {
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
                k2.setColor(-14187817);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(192.0f, 0.0f);
                l.lineTo(192.0f, 192.0f);
                l.lineTo(0.0f, 192.0f);
                l.lineTo(0.0f, 0.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(56.891357f, 44.8f);
                l2.cubicTo(54.926315f, 44.8f, 53.333332f, 46.40846f, 53.333332f, 48.354576f);
                l2.lineTo(53.333332f, 143.64542f);
                l2.cubicTo(53.333332f, 145.60857f, 54.924335f, 147.2f, 56.891357f, 147.2f);
                l2.lineTo(135.10864f, 147.2f);
                l2.cubicTo(137.07368f, 147.2f, 138.66667f, 145.59154f, 138.66667f, 143.64542f);
                l2.lineTo(138.66667f, 48.354576f);
                l2.cubicTo(138.66667f, 46.391438f, 137.07567f, 44.8f, 135.10864f, 44.8f);
                l2.lineTo(56.891357f, 44.8f);
                l2.lineTo(56.891357f, 44.8f);
                l2.close();
                l2.moveTo(64.0f, 76.8f);
                l2.lineTo(64.0f, 83.2f);
                l2.lineTo(108.8f, 83.2f);
                l2.lineTo(108.8f, 76.8f);
                l2.lineTo(64.0f, 76.8f);
                l2.lineTo(64.0f, 76.8f);
                l2.close();
                l2.moveTo(64.0f, 89.6f);
                l2.lineTo(64.0f, 96.0f);
                l2.lineTo(87.46667f, 96.0f);
                l2.lineTo(87.46667f, 89.6f);
                l2.lineTo(64.0f, 89.6f);
                l2.lineTo(64.0f, 89.6f);
                l2.close();
                l2.moveTo(64.0f, 102.4f);
                l2.lineTo(64.0f, 108.8f);
                l2.lineTo(91.73333f, 108.8f);
                l2.lineTo(91.73333f, 102.4f);
                l2.lineTo(64.0f, 102.4f);
                l2.lineTo(64.0f, 102.4f);
                l2.close();
                l2.moveTo(70.4f, 55.466667f);
                l2.cubicTo(73.93463f, 55.466667f, 76.8f, 58.33163f, 76.8f, 61.865753f);
                l2.cubicTo(76.8f, 65.39988f, 73.93463f, 68.26667f, 70.4f, 68.26667f);
                l2.cubicTo(66.86537f, 68.26667f, 64.0f, 65.39988f, 64.0f, 61.865753f);
                l2.cubicTo(64.0f, 58.33163f, 66.86537f, 55.466667f, 70.4f, 55.466667f);
                l2.lineTo(70.4f, 55.466667f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
