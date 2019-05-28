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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbm */
public final class bbm extends C5163c {
    private final int height = 16;
    private final int width = 12;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 12;
            case 1:
                return 16;
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
                a.setColor(-5066062);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -396.0f, 0.0f, 1.0f, -671.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 327.0f, 0.0f, 1.0f, 68.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 1.5f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.9f, 4.65f);
                l.lineTo(0.9f, 13.506087f);
                l.cubicTo(0.9f, 13.833202f, 1.1669413f, 14.1f, 1.4955453f, 14.1f);
                l.lineTo(10.504455f, 14.1f);
                l.cubicTo(10.832851f, 14.1f, 11.1f, 13.833303f, 11.1f, 13.506087f);
                l.lineTo(11.1f, 4.65f);
                l.lineTo(0.9f, 4.65f);
                l.close();
                l.moveTo(0.0f, 4.505613f);
                l.cubicTo(0.0f, 4.0882993f, 0.33347315f, 3.75f, 0.75065374f, 3.75f);
                l.lineTo(11.249347f, 3.75f);
                l.cubicTo(11.663921f, 3.75f, 12.0f, 4.08669f, 12.0f, 4.505613f);
                l.lineTo(12.0f, 13.506087f);
                l.cubicTo(12.0f, 14.331152f, 11.329115f, 15.0f, 10.504455f, 15.0f);
                l.lineTo(1.4955453f, 15.0f);
                l.cubicTo(0.6695784f, 15.0f, 0.0f, 14.329952f, 0.0f, 13.506087f);
                l.lineTo(0.0f, 4.505613f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(3.0f, 3.0f);
                l.cubicTo(3.0f, 1.3431457f, 4.343146f, 0.0f, 6.0f, 0.0f);
                l.cubicTo(7.656854f, 0.0f, 9.0f, 1.3431457f, 9.0f, 3.0f);
                l.lineTo(8.999999f, 6.75f);
                l.lineTo(8.099999f, 6.75f);
                l.lineTo(8.099999f, 3.0f);
                l.cubicTo(8.0999975f, 1.8401997f, 7.1597958f, 0.8999977f, 5.9999976f, 0.8999977f);
                l.cubicTo(4.8402f, 0.8999977f, 3.8999977f, 1.8401997f, 3.8999977f, 2.9999976f);
                l.lineTo(3.9f, 6.75f);
                l.lineTo(3.0f, 6.75f);
                l.lineTo(3.0f, 3.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
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
