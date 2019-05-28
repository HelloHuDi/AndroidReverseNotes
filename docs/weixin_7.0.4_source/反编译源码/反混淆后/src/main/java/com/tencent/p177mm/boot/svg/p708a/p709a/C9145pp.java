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

/* renamed from: com.tencent.mm.boot.svg.a.a.pp */
public final class C9145pp extends C5163c {
    private final int height = 292;
    private final int width = 378;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 378;
            case 1:
                return 292;
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
                a.setColor(-13158344);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(14.0f, 226.0f);
                l.lineTo(360.0f, 226.0f);
                l.lineTo(360.0f, 14.0f);
                l.lineTo(14.0f, 14.0f);
                l.lineTo(14.0f, 226.0f);
                l.close();
                l.moveTo(13.0f, 227.0f);
                l.lineTo(361.0f, 227.0f);
                l.lineTo(361.0f, 13.0f);
                l.lineTo(13.0f, 13.0f);
                l.lineTo(13.0f, 227.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(371.0002f, 225.9932f);
                l2.cubicTo(371.0002f, 232.0622f, 366.0632f, 237.0002f, 359.9932f, 237.0002f);
                l2.lineTo(206.0002f, 237.0002f);
                l2.lineTo(206.0002f, 237.0002f);
                l2.lineTo(168.0002f, 237.0002f);
                l2.lineTo(168.0002f, 237.0002f);
                l2.lineTo(14.0062f, 237.0002f);
                l2.cubicTo(7.9382f, 237.0002f, 3.0002f, 232.0622f, 3.0002f, 225.9932f);
                l2.lineTo(3.0002f, 14.0072f);
                l2.cubicTo(3.0002f, 7.9372f, 7.9382f, 3.0002f, 14.0062f, 3.0002f);
                l2.lineTo(359.9932f, 3.0002f);
                l2.cubicTo(366.0632f, 3.0002f, 371.0002f, 7.9372f, 371.0002f, 14.0072f);
                l2.lineTo(371.0002f, 225.9932f);
                l2.close();
                l2.moveTo(256.0002f, 278.7302f);
                l2.lineTo(256.0002f, 284.0002f);
                l2.lineTo(118.0002f, 284.0002f);
                l2.lineTo(118.0002f, 278.7302f);
                l2.lineTo(171.0002f, 273.7302f);
                l2.lineTo(171.0002f, 240.0002f);
                l2.lineTo(203.0002f, 240.0002f);
                l2.lineTo(203.0002f, 273.7302f);
                l2.lineTo(256.0002f, 278.7302f);
                l2.close();
                l2.moveTo(359.9932f, 2.0E-4f);
                l2.lineTo(14.0072f, 2.0E-4f);
                l2.cubicTo(6.2762f, 2.0E-4f, 2.0E-4f, 6.2712f, 2.0E-4f, 14.0072f);
                l2.lineTo(2.0E-4f, 225.9932f);
                l2.cubicTo(2.0E-4f, 233.7342f, 6.2712f, 240.0002f, 14.0072f, 240.0002f);
                l2.lineTo(168.0002f, 240.0002f);
                l2.lineTo(168.0002f, 271.0002f);
                l2.lineTo(115.0002f, 276.0002f);
                l2.lineTo(115.0002f, 287.0002f);
                l2.lineTo(259.0002f, 287.0002f);
                l2.lineTo(259.0002f, 276.0002f);
                l2.lineTo(206.0002f, 271.0002f);
                l2.lineTo(206.0002f, 240.0002f);
                l2.lineTo(359.9932f, 240.0002f);
                l2.cubicTo(367.7242f, 240.0002f, 374.0002f, 233.7292f, 374.0002f, 225.9932f);
                l2.lineTo(374.0002f, 14.0072f);
                l2.cubicTo(374.0002f, 6.2652f, 367.7292f, 2.0E-4f, 359.9932f, 2.0E-4f);
                l2.lineTo(359.9932f, 2.0E-4f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
