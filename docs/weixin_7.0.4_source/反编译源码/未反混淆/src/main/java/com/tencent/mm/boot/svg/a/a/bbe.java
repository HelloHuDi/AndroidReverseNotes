package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class bbe extends c {
    private final int height = 14;
    private final int width = 16;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 16;
            case 1:
                return 14;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-5066062);
                g = c.a(g, 1.0f, 0.0f, -265.0f, 0.0f, 1.0f, -604.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 198.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(15.225f, 14.85f);
                l.lineTo(15.225f, 14.486597f);
                l.cubicTo(15.225f, 14.314545f, 15.04851f, 14.032515f, 14.894857f, 13.957565f);
                l.lineTo(10.649592f, 11.88678f);
                l.cubicTo(9.504656f, 11.328295f, 9.22168f, 9.977185f, 10.042003f, 9.004776f);
                l.lineTo(10.313152f, 8.683356f);
                l.cubicTo(10.726646f, 8.193201f, 11.1f, 7.173293f, 11.1f, 6.532639f);
                l.lineTo(11.1f, 5.2501554f);
                l.cubicTo(11.1f, 4.0911856f, 10.159192f, 3.15f, 9.0f, 3.15f);
                l.cubicTo(7.8422318f, 3.15f, 6.9f, 4.091402f, 6.9f, 5.2496853f);
                l.lineTo(6.9f, 6.531968f);
                l.cubicTo(6.9f, 7.1742477f, 7.27181f, 8.190363f, 7.6868086f, 8.682234f);
                l.lineTo(7.957958f, 9.00361f);
                l.cubicTo(8.779977f, 9.977895f, 8.493911f, 11.327738f, 7.3505397f, 11.88569f);
                l.lineTo(3.1052747f, 13.957333f);
                l.cubicTo(2.9527628f, 14.031756f, 2.775f, 14.316507f, 2.775f, 14.486597f);
                l.lineTo(2.775f, 14.85f);
                l.lineTo(15.225f, 14.85f);
                l.close();
                l.moveTo(1.875f, 15.0f);
                l.lineTo(1.875f, 14.486597f);
                l.cubicTo(1.875f, 13.972781f, 2.248613f, 13.373931f, 2.7105732f, 13.1484995f);
                l.lineTo(6.955838f, 11.076858f);
                l.cubicTo(7.5715327f, 10.776405f, 7.7146945f, 10.110947f, 7.270084f, 9.58398f);
                l.lineTo(6.9989347f, 9.262604f);
                l.cubicTo(6.4472384f, 8.608714f, 6.0f, 7.387122f, 6.0f, 6.531968f);
                l.lineTo(6.0f, 5.2496853f);
                l.cubicTo(6.0f, 3.593005f, 7.346517f, 2.25f, 9.0f, 2.25f);
                l.cubicTo(10.656855f, 2.25f, 12.0f, 3.5947351f, 12.0f, 5.2501554f);
                l.lineTo(12.0f, 6.532639f);
                l.cubicTo(12.0f, 7.386972f, 11.550699f, 8.612145f, 11.001065f, 9.2636795f);
                l.lineTo(10.729916f, 9.585099f);
                l.cubicTo(10.287774f, 10.109213f, 10.425891f, 10.7762985f, 11.044162f, 11.077883f);
                l.lineTo(15.289427f, 13.148668f);
                l.cubicTo(15.750901f, 13.37377f, 16.125f, 13.968878f, 16.125f, 14.486597f);
                l.lineTo(16.125f, 15.0f);
                l.cubicTo(16.125f, 15.414213f, 15.789213f, 15.75f, 15.375f, 15.75f);
                l.lineTo(2.625f, 15.75f);
                l.cubicTo(2.2107863f, 15.75f, 1.875f, 15.414213f, 1.875f, 15.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(8.25f, 13.5f);
                l2.lineTo(9.0f, 11.25f);
                l2.lineTo(9.75f, 13.5f);
                l2.lineTo(9.0f, 14.25f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
