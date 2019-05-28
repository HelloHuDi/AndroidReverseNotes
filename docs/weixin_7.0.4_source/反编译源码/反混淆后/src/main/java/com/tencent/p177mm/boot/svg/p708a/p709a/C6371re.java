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

/* renamed from: com.tencent.mm.boot.svg.a.a.re */
public final class C6371re extends C5163c {
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
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(31.0f, 60.0f);
                l2.lineTo(31.0f, 136.9996f);
                l2.cubicTo(31.0f, 138.65668f, 32.350418f, 140.0f, 33.990707f, 140.0f);
                l2.lineTo(158.0093f, 140.0f);
                l2.cubicTo(159.66101f, 140.0f, 161.0f, 138.65442f, 161.0f, 136.9996f);
                l2.lineTo(161.0f, 60.0f);
                l2.lineTo(103.2854f, 107.40642f);
                l2.cubicTo(99.16379f, 110.791885f, 92.83887f, 110.79407f, 88.7146f, 107.40642f);
                l2.lineTo(31.0f, 60.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(32.66113f, 52.0f);
                l2.cubicTo(31.001602f, 52.0f, 30.711802f, 52.82119f, 32.017536f, 53.837048f);
                l2.lineTo(93.63985f, 101.779144f);
                l2.cubicTo(94.94393f, 102.79372f, 97.05661f, 102.795f, 98.36234f, 101.779144f);
                l2.lineTo(159.98466f, 53.837048f);
                l2.cubicTo(161.28874f, 52.822475f, 161.01111f, 52.0f, 159.34106f, 52.0f);
                l2.lineTo(32.66113f, 52.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
