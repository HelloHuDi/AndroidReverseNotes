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

/* renamed from: com.tencent.mm.boot.svg.a.a.yy */
public final class C32413yy extends C5163c {
    private final int height = 32;
    private final int width = 32;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                a.setColor(-436207616);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.24f, 0.0f, 1.0f, 2.24f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(11.76f, 23.52f);
                l.cubicTo(5.2651315f, 23.52f, 0.0f, 18.25487f, 0.0f, 11.76f);
                l.cubicTo(0.0f, 5.2651315f, 5.2651315f, 0.0f, 11.76f, 0.0f);
                l.cubicTo(18.25487f, 0.0f, 23.52f, 5.2651315f, 23.52f, 11.76f);
                l.cubicTo(23.52f, 18.25487f, 18.25487f, 23.52f, 11.76f, 23.52f);
                l.close();
                l.moveTo(11.76f, 18.816f);
                l.cubicTo(15.133969f, 18.816f, 17.904558f, 16.232622f, 18.201632f, 12.936f);
                l.lineTo(5.3183675f, 12.936f);
                l.cubicTo(5.6154423f, 16.232622f, 8.386031f, 18.816f, 11.76f, 18.816f);
                l.close();
                l.moveTo(7.644f, 9.996f);
                l.cubicTo(8.61823f, 9.996f, 9.408f, 9.20623f, 9.408f, 8.232f);
                l.cubicTo(9.408f, 7.2577696f, 8.61823f, 6.468f, 7.644f, 6.468f);
                l.cubicTo(6.66977f, 6.468f, 5.88f, 7.2577696f, 5.88f, 8.232f);
                l.cubicTo(5.88f, 9.20623f, 6.66977f, 9.996f, 7.644f, 9.996f);
                l.close();
                l.moveTo(15.876f, 9.996f);
                l.cubicTo(16.850231f, 9.996f, 17.64f, 9.20623f, 17.64f, 8.232f);
                l.cubicTo(17.64f, 7.2577696f, 16.850231f, 6.468f, 15.876f, 6.468f);
                l.cubicTo(14.90177f, 6.468f, 14.112f, 7.2577696f, 14.112f, 8.232f);
                l.cubicTo(14.112f, 9.20623f, 14.90177f, 9.996f, 15.876f, 9.996f);
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
