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

/* renamed from: com.tencent.mm.boot.svg.a.a.py */
public final class C18055py extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-9538696);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 17.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(77.0f, 50.5601f);
                l.cubicTo(77.0f, 51.3551f, 76.36f, 52.0001f, 75.555f, 52.0001f);
                l.lineTo(49.0f, 52.0001f);
                l.lineTo(32.0f, 52.0001f);
                l.lineTo(4.445f, 52.0001f);
                l.cubicTo(3.647f, 52.0001f, 3.0f, 51.3621f, 3.0f, 50.5601f);
                l.lineTo(3.0f, 43.0001f);
                l.lineTo(77.0f, 43.0001f);
                l.lineTo(77.0f, 50.5601f);
                l.close();
                l.moveTo(33.232f, 60.0001f);
                l.lineTo(35.0f, 55.5781f);
                l.lineTo(35.0f, 55.0001f);
                l.lineTo(46.0f, 55.0001f);
                l.lineTo(46.0f, 55.5781f);
                l.lineTo(47.769f, 60.0001f);
                l.lineTo(33.232f, 60.0001f);
                l.close();
                l.moveTo(3.0f, 4.4401f);
                l.cubicTo(3.0f, 3.6451f, 3.64f, 3.0001f, 4.445f, 3.0001f);
                l.lineTo(75.555f, 3.0001f);
                l.cubicTo(76.353f, 3.0001f, 77.0f, 3.6371f, 77.0f, 4.4401f);
                l.lineTo(77.0f, 40.0001f);
                l.lineTo(3.0f, 40.0001f);
                l.lineTo(3.0f, 4.4401f);
                l.close();
                l.moveTo(75.685f, 1.0E-4f);
                l.lineTo(4.315f, 1.0E-4f);
                l.cubicTo(1.938f, 1.0E-4f, 0.0f, 1.9321f, 0.0f, 4.3161f);
                l.lineTo(0.0f, 50.6841f);
                l.cubicTo(0.0f, 53.0751f, 1.932f, 55.0001f, 4.315f, 55.0001f);
                l.lineTo(32.0f, 55.0001f);
                l.lineTo(30.0f, 60.0001f);
                l.lineTo(26.0f, 62.0001f);
                l.lineTo(26.0f, 63.0001f);
                l.lineTo(55.0f, 63.0001f);
                l.lineTo(55.0f, 62.0001f);
                l.lineTo(51.0f, 60.0001f);
                l.lineTo(49.0f, 55.0001f);
                l.lineTo(75.685f, 55.0001f);
                l.cubicTo(78.062f, 55.0001f, 80.0f, 53.0681f, 80.0f, 50.6841f);
                l.lineTo(80.0f, 4.3161f);
                l.cubicTo(80.0f, 1.9251f, 78.068f, 1.0E-4f, 75.685f, 1.0E-4f);
                l.lineTo(75.685f, 1.0E-4f);
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
