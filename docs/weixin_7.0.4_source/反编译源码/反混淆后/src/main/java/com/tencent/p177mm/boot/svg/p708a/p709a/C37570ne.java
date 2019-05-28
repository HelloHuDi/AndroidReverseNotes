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

/* renamed from: com.tencent.mm.boot.svg.a.a.ne */
public final class C37570ne extends C5163c {
    private final int height = 39;
    private final int width = 39;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 39;
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
                a.setColor(-1710619);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -322.0f, 0.0f, 1.0f, -941.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 323.0f, 0.0f, 1.0f, 942.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(18.5f, 0.0f);
                l.cubicTo(8.282732f, -6.256272E-16f, 1.2512544E-15f, 8.282732f, 0.0f, 18.5f);
                l.cubicTo(-1.2512544E-15f, 28.717268f, 8.282732f, 37.0f, 18.5f, 37.0f);
                l.cubicTo(28.717268f, 37.0f, 37.0f, 28.717268f, 37.0f, 18.5f);
                l.cubicTo(37.0f, 13.593495f, 35.0509f, 8.887947f, 31.581476f, 5.4185247f);
                l.cubicTo(28.112053f, 1.9491016f, 23.406506f, 3.004368E-16f, 18.5f, 0.0f);
                l.close();
                l.moveTo(18.470951f, 34.999973f);
                l.cubicTo(9.3658285f, 34.983944f, 1.9946595f, 27.595451f, 2.0000029f, 18.490316f);
                l.cubicTo(2.0053463f, 9.385182f, 9.385182f, 2.0053463f, 18.490316f, 2.0000029f);
                l.cubicTo(27.595451f, 1.9946595f, 34.983944f, 9.3658285f, 34.999973f, 18.470951f);
                l.cubicTo(35.007698f, 22.857082f, 33.26873f, 27.065794f, 30.167261f, 30.167261f);
                l.cubicTo(27.065794f, 33.26873f, 22.857082f, 35.007698f, 18.470951f, 34.999973f);
                l.lineTo(18.470951f, 34.999973f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(14.230769f, 27.508078f);
                l2.lineTo(9.961538f, 27.508078f);
                l2.lineTo(11.66923f, 9.961538f);
                l2.lineTo(16.066538f, 9.961538f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(21.150963f, 16.820768f);
                l.cubicTo(20.627676f, 17.163134f, 20.287874f, 17.724329f, 20.22702f, 18.346695f);
                l.cubicTo(20.166168f, 18.969063f, 20.390827f, 19.58545f, 20.837887f, 20.022692f);
                l.cubicTo(22.147118f, 21.801538f, 26.530195f, 27.508078f, 26.530195f, 27.508078f);
                l.lineTo(20.980194f, 27.508078f);
                l.cubicTo(19.115963f, 24.861155f, 18.247887f, 23.452307f, 16.525963f, 21.033077f);
                l.cubicTo(15.165143f, 19.326057f, 15.424838f, 16.843111f, 17.109425f, 15.454616f);
                l.cubicTo(17.820963f, 14.743077f, 20.254425f, 12.409231f, 22.801733f, 9.961538f);
                l.lineTo(28.10981f, 9.961538f);
                l.lineTo(21.150963f, 16.820768f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
