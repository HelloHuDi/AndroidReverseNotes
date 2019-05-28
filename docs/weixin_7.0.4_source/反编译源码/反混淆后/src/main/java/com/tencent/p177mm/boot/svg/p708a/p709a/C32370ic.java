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

/* renamed from: com.tencent.mm.boot.svg.a.a.ic */
public final class C32370ic extends C5163c {
    private final int height = 17;
    private final int width = 17;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 17;
            case 1:
                return 17;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-11048043);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.37097725f, 3.9374971f);
                l.lineTo(3.945679f, 3.9374971f);
                l.lineTo(8.5f, 15.0f);
                l.lineTo(0.22602811f, 4.231666f);
                l.cubicTo(0.16451833f, 4.1516128f, 0.17955074f, 4.0368533f, 0.25960392f, 3.9753437f);
                l.cubicTo(0.2915445f, 3.9508018f, 0.33069694f, 3.9374971f, 0.37097725f, 3.9374971f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(16.629023f, 3.9374971f);
                l.lineTo(13.138271f, 3.9374971f);
                l.lineTo(8.5f, 15.0f);
                l.lineTo(16.773972f, 4.231666f);
                l.cubicTo(16.835482f, 4.1516128f, 16.82045f, 4.0368533f, 16.740396f, 3.9753437f);
                l.cubicTo(16.708456f, 3.9508018f, 16.669304f, 3.9374971f, 16.629023f, 3.9374971f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(5.1944447f, 3.9374971f);
                l2.lineTo(11.805555f, 3.9374971f);
                l2.lineTo(8.5f, 15.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(4.0353537f, 2.8125f);
                l.lineTo(6.611111f, 0.0f);
                l.lineTo(3.9231226f, 5.828671E-16f);
                l.cubicTo(3.8844628f, 6.929792E-16f, 3.8467984f, 0.012256962f, 3.815543f, 0.035009228f);
                l.lineTo(0.4541331f, 2.4819179f);
                l.cubicTo(0.37251288f, 2.5413325f, 0.35451177f, 2.655664f, 0.41392648f, 2.7372842f);
                l.cubicTo(0.4483286f, 2.7845438f, 0.50325805f, 2.8125f, 0.5617129f, 2.8125f);
                l.lineTo(4.0353537f, 2.8125f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(7.5555553f, 0.0f);
                l2.lineTo(9.444445f, 0.0f);
                l2.lineTo(11.805555f, 2.8125f);
                l2.lineTo(5.1944447f, 2.8125f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(13.150493f, 2.8125f);
                l.lineTo(10.388889f, 0.0f);
                l.lineTo(13.17345f, -2.7755576E-17f);
                l.cubicTo(13.212875f, -2.0513277E-17f, 13.251245f, 0.012746517f, 13.282832f, 0.036337905f);
                l.lineTo(16.559143f, 2.4832466f);
                l.cubicTo(16.64003f, 2.5436563f, 16.65663f, 2.6581998f, 16.596218f, 2.7390862f);
                l.cubicTo(16.561712f, 2.7852888f, 16.507427f, 2.8125f, 16.44976f, 2.8125f);
                l.lineTo(13.150493f, 2.8125f);
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
