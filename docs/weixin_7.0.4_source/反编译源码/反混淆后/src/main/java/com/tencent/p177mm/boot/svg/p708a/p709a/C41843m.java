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

/* renamed from: com.tencent.mm.boot.svg.a.a.m */
public final class C41843m extends C5163c {
    private final int height = 30;
    private final int width = 30;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -30.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(48.870228f, 11.038835f);
                l.lineTo(46.0f, 13.9090605f);
                l.lineTo(47.16861f, 15.077669f);
                l.lineTo(50.038834f, 12.207443f);
                l.lineTo(52.90906f, 15.077669f);
                l.lineTo(54.07767f, 13.9090605f);
                l.lineTo(51.207443f, 11.038835f);
                l.lineTo(54.07767f, 8.168609f);
                l.lineTo(52.90906f, 7.0f);
                l.lineTo(50.038834f, 9.870226f);
                l.lineTo(47.16861f, 7.0f);
                l.lineTo(46.0f, 8.168609f);
                l.lineTo(48.870228f, 11.038835f);
                l.close();
                l.moveTo(37.99703f, 7.0f);
                l.cubicTo(37.446384f, 7.0f, 37.0f, 7.4530363f, 37.0f, 7.9970303f);
                l.lineTo(37.0f, 14.00297f);
                l.cubicTo(37.0f, 14.553615f, 37.453037f, 15.0f, 37.99703f, 15.0f);
                l.lineTo(44.00297f, 15.0f);
                l.cubicTo(44.553616f, 15.0f, 45.0f, 14.546964f, 45.0f, 14.00297f);
                l.lineTo(45.0f, 7.9970303f);
                l.cubicTo(45.0f, 7.4463854f, 44.546963f, 7.0f, 44.00297f, 7.0f);
                l.lineTo(37.99703f, 7.0f);
                l.close();
                l.moveTo(37.99703f, 16.0f);
                l.cubicTo(37.446384f, 16.0f, 37.0f, 16.453035f, 37.0f, 16.99703f);
                l.lineTo(37.0f, 23.00297f);
                l.cubicTo(37.0f, 23.553614f, 37.453037f, 24.0f, 37.99703f, 24.0f);
                l.lineTo(44.00297f, 24.0f);
                l.cubicTo(44.553616f, 24.0f, 45.0f, 23.546965f, 45.0f, 23.00297f);
                l.lineTo(45.0f, 16.99703f);
                l.cubicTo(45.0f, 16.446386f, 44.546963f, 16.0f, 44.00297f, 16.0f);
                l.lineTo(37.99703f, 16.0f);
                l.close();
                l.moveTo(46.99703f, 16.0f);
                l.cubicTo(46.446384f, 16.0f, 46.0f, 16.453035f, 46.0f, 16.99703f);
                l.lineTo(46.0f, 23.00297f);
                l.cubicTo(46.0f, 23.553614f, 46.453037f, 24.0f, 46.99703f, 24.0f);
                l.lineTo(53.00297f, 24.0f);
                l.cubicTo(53.553616f, 24.0f, 54.0f, 23.546965f, 54.0f, 23.00297f);
                l.lineTo(54.0f, 16.99703f);
                l.cubicTo(54.0f, 16.446386f, 53.546963f, 16.0f, 53.00297f, 16.0f);
                l.lineTo(46.99703f, 16.0f);
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
