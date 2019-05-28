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

/* renamed from: com.tencent.mm.boot.svg.a.a.azs */
public final class azs extends C5163c {
    private final int height = 36;
    private final int width = 36;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                a.setColor(-3552823);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -259.0f, 0.0f, 1.0f, -131.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 259.0f, 0.0f, 1.0f, 131.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(17.67213f, 35.34426f);
                l.cubicTo(7.912082f, 35.34426f, 0.0f, 27.432177f, 0.0f, 17.67213f);
                l.cubicTo(0.0f, 7.912082f, 7.912082f, 0.0f, 17.67213f, 0.0f);
                l.cubicTo(27.432177f, 0.0f, 35.34426f, 7.912082f, 35.34426f, 17.67213f);
                l.cubicTo(35.34426f, 27.432177f, 27.432177f, 35.34426f, 17.67213f, 35.34426f);
                l.close();
                l.moveTo(7.0619354f, 18.702524f);
                l.cubicTo(7.0080047f, 18.810345f, 7.0291414f, 18.94058f, 7.1144037f, 19.02581f);
                l.lineTo(7.1144037f, 19.02581f);
                l.lineTo(13.854528f, 25.76321f);
                l.cubicTo(13.963866f, 25.872507f, 14.141094f, 25.872507f, 14.250432f, 25.76321f);
                l.lineTo(14.250508f, 25.763287f);
                l.lineTo(28.901352f, 11.118186f);
                l.cubicTo(28.901379f, 11.118161f, 28.901403f, 11.118136f, 28.901428f, 11.118111f);
                l.cubicTo(29.010754f, 11.008743f, 29.01072f, 10.831457f, 28.901352f, 10.722131f);
                l.lineTo(28.901278f, 10.722207f);
                l.lineTo(28.675867f, 10.496883f);
                l.lineTo(28.392729f, 10.213852f);
                l.cubicTo(28.291279f, 10.112441f, 28.129597f, 10.104101f, 28.018251f, 10.194535f);
                l.lineTo(28.018251f, 10.194535f);
                l.lineTo(14.218084f, 21.40289f);
                l.cubicTo(14.120261f, 21.48234f, 13.981415f, 21.48665f, 13.878853f, 21.41342f);
                l.lineTo(8.123317f, 17.303892f);
                l.cubicTo(8.111442f, 17.295412f, 8.098921f, 17.287874f, 8.08587f, 17.281345f);
                l.cubicTo(7.9475665f, 17.212168f, 7.7793694f, 17.268206f, 7.7101912f, 17.40651f);
                l.lineTo(7.7101912f, 17.40651f);
                l.lineTo(7.0619354f, 18.702524f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
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
