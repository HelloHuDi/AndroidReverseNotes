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

/* renamed from: com.tencent.mm.boot.svg.a.a.ace */
public final class ace extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(33.0f, 3.0f);
                l.lineTo(33.0f, 6.6f);
                l.lineTo(3.6f, 6.6f);
                l.lineTo(3.6f, 53.4f);
                l.lineTo(50.4f, 53.4f);
                l.lineTo(50.4f, 24.0f);
                l.lineTo(54.0f, 24.0f);
                l.lineTo(54.0f, 54.0f);
                l.cubicTo(54.0f, 55.656853f, 52.656853f, 57.0f, 51.0f, 57.0f);
                l.lineTo(3.0f, 57.0f);
                l.cubicTo(1.3431457f, 57.0f, 0.0f, 55.656853f, 0.0f, 54.0f);
                l.lineTo(0.0f, 6.0f);
                l.cubicTo(0.0f, 4.343146f, 1.3431457f, 3.0f, 3.0f, 3.0f);
                l.lineTo(33.0f, 3.0f);
                l.close();
                l.moveTo(50.582645f, 2.23824f);
                l.cubicTo(51.166965f, 1.6539196f, 52.114338f, 1.6539196f, 52.698658f, 2.23824f);
                l.lineTo(54.814667f, 4.354252f);
                l.cubicTo(55.39899f, 4.9385724f, 55.39899f, 5.8859434f, 54.814667f, 6.470264f);
                l.lineTo(26.285717f, 34.999214f);
                l.lineTo(19.335936f, 38.885635f);
                l.cubicTo(18.903196f, 39.12764f, 18.356207f, 38.97302f, 18.114202f, 38.54028f);
                l.cubicTo(17.960512f, 38.265457f, 17.962038f, 37.930202f, 18.118221f, 37.65679f);
                l.lineTo(22.054068f, 30.766817f);
                l.lineTo(50.582645f, 2.23824f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
