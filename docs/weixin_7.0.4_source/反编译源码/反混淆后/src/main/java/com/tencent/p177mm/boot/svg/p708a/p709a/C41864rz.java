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

/* renamed from: com.tencent.mm.boot.svg.a.a.rz */
public final class C41864rz extends C5163c {
    private final int height = 270;
    private final int width = 270;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 270;
            case 1:
                return 270;
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
                k2.setColor(14211288);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(270.0f, 0.0f);
                l.lineTo(270.0f, 270.0f);
                l.lineTo(0.0f, 270.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-15028967);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(63.314346f, 140.34763f);
                l2.cubicTo(62.933258f, 139.95532f, 62.89317f, 139.27344f, 63.224213f, 138.8254f);
                l2.lineTo(69.83471f, 129.87872f);
                l2.cubicTo(70.16602f, 129.43033f, 70.79083f, 129.3384f, 71.22918f, 129.67256f);
                l2.lineTo(108.10534f, 157.78488f);
                l2.cubicTo(108.54417f, 158.11943f, 109.244865f, 158.1048f, 109.66647f, 157.75543f);
                l2.lineTo(198.3778f, 84.246925f);
                l2.cubicTo(198.80116f, 83.89612f, 199.4602f, 83.922f, 199.85126f, 84.30612f);
                l2.lineTo(206.24776f, 90.58951f);
                l2.cubicTo(206.63817f, 90.97301f, 206.63751f, 91.59433f, 206.23552f, 91.98784f);
                l2.lineTo(109.616165f, 186.56723f);
                l2.cubicTo(109.219f, 186.956f, 108.58932f, 186.95439f, 108.20701f, 186.56084f);
                l2.lineTo(63.314346f, 140.34763f);
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
