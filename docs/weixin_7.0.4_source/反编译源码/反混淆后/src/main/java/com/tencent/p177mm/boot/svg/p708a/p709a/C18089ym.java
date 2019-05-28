package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.ym */
public final class C18089ym extends C5163c {
    private final int height = 40;
    private final int width = 46;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 40;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
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
                a.setColor(-16896);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -149.0f, 0.0f, 1.0f, -661.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(151.0733f, 700.02264f);
                l.lineTo(151.0733f, 700.02264f);
                l.cubicTo(150.70924f, 700.02264f, 150.3521f, 699.9233f, 150.04036f, 699.7353f);
                l.cubicTo(149.09451f, 699.1648f, 148.7902f, 697.93555f, 149.36069f, 696.98975f);
                l.lineTo(149.36069f, 696.98975f);
                l.lineTo(170.08609f, 662.6272f);
                l.cubicTo(170.25401f, 662.34875f, 170.48732f, 662.1155f, 170.76575f, 661.9475f);
                l.cubicTo(171.7116f, 661.377f, 172.94083f, 661.68134f, 173.5113f, 662.6272f);
                l.lineTo(173.5113f, 662.6272f);
                l.lineTo(194.2367f, 696.98975f);
                l.cubicTo(194.42471f, 697.30145f, 194.52408f, 697.6586f, 194.52408f, 698.02264f);
                l.cubicTo(194.52408f, 699.12726f, 193.62866f, 700.02264f, 192.52408f, 700.02264f);
                l.lineTo(151.0733f, 700.02264f);
                l.close();
                l.moveTo(169.61902f, 675.9917f);
                l.lineTo(170.2866f, 687.9688f);
                l.lineTo(173.31001f, 687.9688f);
                l.lineTo(173.9776f, 675.9917f);
                l.cubicTo(174.0237f, 675.16455f, 173.39055f, 674.45667f, 172.5634f, 674.4105f);
                l.cubicTo(172.5356f, 674.409f, 172.50777f, 674.4082f, 172.47992f, 674.4082f);
                l.lineTo(171.1167f, 674.4082f);
                l.cubicTo(170.28827f, 674.4082f, 169.6167f, 675.0798f, 169.6167f, 675.9082f);
                l.cubicTo(169.6167f, 675.93604f, 169.61748f, 675.96387f, 169.61902f, 675.9917f);
                l.close();
                l.moveTo(171.79831f, 695.50244f);
                l.cubicTo(173.05064f, 695.50244f, 174.06586f, 694.4906f, 174.06586f, 693.2424f);
                l.cubicTo(174.06586f, 691.99414f, 173.05064f, 690.98224f, 171.79831f, 690.98224f);
                l.cubicTo(170.54597f, 690.98224f, 169.53076f, 691.99414f, 169.53076f, 693.2424f);
                l.cubicTo(169.53076f, 694.4906f, 170.54597f, 695.50244f, 171.79831f, 695.50244f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
