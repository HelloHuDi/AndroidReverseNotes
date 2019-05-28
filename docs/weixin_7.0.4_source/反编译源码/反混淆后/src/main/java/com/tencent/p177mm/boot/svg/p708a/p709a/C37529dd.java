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

/* renamed from: com.tencent.mm.boot.svg.a.a.dd */
public final class C37529dd extends C5163c {
    private final int height = 96;
    private final int width = 132;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 132;
            case 1:
                return 96;
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -659.0f, 0.0f, 1.0f, -950.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 532.0f, 0.0f, 1.0f, 950.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 170.0f, 0.0f, 1.0f, 22.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(26.0f, 52.0f);
                l.cubicTo(11.640596f, 52.0f, 0.0f, 40.3594f, 0.0f, 26.0f);
                l.cubicTo(0.0f, 11.640596f, 11.640596f, 0.0f, 26.0f, 0.0f);
                l.cubicTo(40.3594f, 0.0f, 52.0f, 11.640596f, 52.0f, 26.0f);
                l.cubicTo(52.0f, 40.3594f, 40.3594f, 52.0f, 26.0f, 52.0f);
                l.close();
                l.moveTo(26.0f, 45.882355f);
                l.cubicTo(36.98072f, 45.882355f, 45.882355f, 36.98072f, 45.882355f, 26.0f);
                l.cubicTo(45.882355f, 15.0192795f, 36.98072f, 6.117647f, 26.0f, 6.117647f);
                l.cubicTo(15.0192795f, 6.117647f, 6.117647f, 15.0192795f, 6.117647f, 26.0f);
                l.cubicTo(6.117647f, 36.98072f, 15.0192795f, 45.882355f, 26.0f, 45.882355f);
                l.close();
                l.moveTo(35.0f, 26.0f);
                l.cubicTo(35.0f, 30.9698f, 30.9698f, 35.0f, 26.0f, 35.0f);
                l.cubicTo(21.0302f, 35.0f, 17.0f, 30.9698f, 17.0f, 26.0f);
                l.cubicTo(17.0f, 21.0284f, 21.0302f, 17.0f, 26.0f, 17.0f);
                l.cubicTo(30.9698f, 17.0f, 35.0f, 21.0284f, 35.0f, 26.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
