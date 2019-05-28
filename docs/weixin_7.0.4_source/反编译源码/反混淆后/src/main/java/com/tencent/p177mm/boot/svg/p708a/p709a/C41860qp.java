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

/* renamed from: com.tencent.mm.boot.svg.a.a.qp */
public final class C41860qp extends C5163c {
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
                k2.setColor(-12953699);
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
                l2.moveTo(104.72727f, 192.0f);
                l2.lineTo(104.72727f, 117.818184f);
                l2.lineTo(80.0f, 117.818184f);
                l2.lineTo(80.0f, 87.27273f);
                l2.lineTo(104.72727f, 87.27273f);
                l2.lineTo(104.72727f, 61.090908f);
                l2.cubicTo(104.62603f, 44.320255f, 121.209656f, 29.09091f, 138.18182f, 29.09091f);
                l2.lineTo(164.36363f, 29.09091f);
                l2.lineTo(164.36363f, 58.18182f);
                l2.lineTo(148.36363f, 58.18182f);
                l2.cubicTo(137.98802f, 58.097572f, 133.74586f, 62.3439f, 133.81818f, 72.72727f);
                l2.lineTo(133.81818f, 87.27273f);
                l2.lineTo(164.36363f, 87.27273f);
                l2.lineTo(158.54546f, 117.818184f);
                l2.lineTo(133.81818f, 117.818184f);
                l2.lineTo(133.81818f, 192.0f);
                l2.lineTo(104.72727f, 192.0f);
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
