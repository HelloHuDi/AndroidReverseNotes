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

/* renamed from: com.tencent.mm.boot.svg.a.a.ek */
public final class C25882ek extends C5163c {
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
                a.setColor(-11048043);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -131.0f, 0.0f, 1.0f, -206.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(161.0f, 261.92117f);
                l.cubicTo(148.12799f, 260.90228f, 138.0f, 250.13391f, 138.0f, 237.0f);
                l.cubicTo(138.0f, 230.57487f, 140.42381f, 224.71585f, 144.40697f, 220.28743f);
                l.lineTo(148.24004f, 223.50375f);
                l.cubicTo(144.98555f, 227.06102f, 143.0f, 231.79863f, 143.0f, 237.0f);
                l.cubicTo(143.0f, 247.27452f, 150.74763f, 255.7395f, 160.71942f, 256.8714f);
                l.lineTo(161.0f, 257.10684f);
                l.lineTo(161.0f, 253.35852f);
                l.cubicTo(161.0f, 253.00606f, 161.22818f, 252.89862f, 161.50964f, 253.09564f);
                l.lineTo(170.49036f, 259.38214f);
                l.cubicTo(170.77235f, 259.57953f, 170.77182f, 259.89862f, 170.49036f, 260.09564f);
                l.lineTo(161.50964f, 266.38214f);
                l.cubicTo(161.22765f, 266.57953f, 161.0f, 266.4615f, 161.0f, 266.11926f);
                l.lineTo(161.0f, 261.92117f);
                l.close();
                l.moveTo(161.0f, 212.07884f);
                l.cubicTo(161.65979f, 212.02661f, 162.32678f, 212.0f, 163.0f, 212.0f);
                l.cubicTo(176.80711f, 212.0f, 188.0f, 223.19289f, 188.0f, 237.0f);
                l.cubicTo(188.0f, 244.6545f, 184.55992f, 251.50551f, 179.14146f, 256.09134f);
                l.lineTo(175.24045f, 252.81801f);
                l.cubicTo(179.96123f, 249.15959f, 183.0f, 243.43468f, 183.0f, 237.0f);
                l.cubicTo(183.0f, 225.9543f, 174.0457f, 217.0f, 163.0f, 217.0f);
                l.cubicTo(162.325f, 217.0f, 161.6578f, 217.03343f, 161.0f, 217.09875f);
                l.lineTo(161.0f, 221.11926f);
                l.cubicTo(161.0f, 221.47173f, 160.77182f, 221.57916f, 160.49036f, 221.38214f);
                l.lineTo(151.50964f, 215.09564f);
                l.cubicTo(151.22765f, 214.89825f, 151.22818f, 214.57916f, 151.50964f, 214.38214f);
                l.lineTo(160.49036f, 208.09564f);
                l.cubicTo(160.77235f, 207.89825f, 161.0f, 208.01631f, 161.0f, 208.35852f);
                l.lineTo(161.0f, 212.07884f);
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
