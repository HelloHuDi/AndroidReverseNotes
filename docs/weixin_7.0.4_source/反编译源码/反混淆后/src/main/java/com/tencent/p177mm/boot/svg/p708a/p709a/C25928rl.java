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

/* renamed from: com.tencent.mm.boot.svg.a.a.rl */
public final class C25928rl extends C5163c {
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
                k2.setColor(-12206054);
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
                l2.moveTo(125.05173f, 106.30443f);
                l2.cubicTo(134.37202f, 117.3619f, 151.40338f, 137.34488f, 152.32759f, 139.00922f);
                l2.cubicTo(156.1268f, 140.24745f, 158.94827f, 137.81317f, 158.94827f, 135.69887f);
                l2.lineTo(158.94827f, 56.250595f);
                l2.cubicTo(158.94827f, 53.69053f, 155.8298f, 51.942085f, 152.32759f, 52.94025f);
                l2.cubicTo(150.75885f, 54.967968f, 134.14519f, 74.351326f, 125.05173f, 85.322044f);
                l2.lineTo(125.05173f, 106.30443f);
                l2.lineTo(125.05173f, 106.30443f);
                l2.close();
                l2.moveTo(33.051723f, 67.973175f);
                l2.cubicTo(33.051723f, 61.34662f, 38.431973f, 55.97473f, 45.052055f, 55.97473f);
                l2.lineTo(103.05139f, 55.97473f);
                l2.cubicTo(109.67899f, 55.97473f, 115.05173f, 61.34798f, 115.05173f, 67.973175f);
                l2.lineTo(115.05173f, 123.976295f);
                l2.cubicTo(115.05173f, 130.60284f, 109.67148f, 135.97473f, 103.05139f, 135.97473f);
                l2.lineTo(45.052055f, 135.97473f);
                l2.cubicTo(38.424454f, 135.97473f, 33.051723f, 130.60149f, 33.051723f, 123.976295f);
                l2.lineTo(33.051723f, 67.973175f);
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
