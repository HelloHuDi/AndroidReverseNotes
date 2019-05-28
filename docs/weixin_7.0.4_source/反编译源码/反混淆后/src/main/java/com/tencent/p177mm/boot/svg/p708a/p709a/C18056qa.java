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

/* renamed from: com.tencent.mm.boot.svg.a.a.qa */
public final class C18056qa extends C5163c {
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
                a.setColor(-9473160);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 17.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(77.0f, 49.0f);
                l.lineTo(46.0f, 49.0f);
                l.lineTo(35.0f, 49.0f);
                l.lineTo(3.0f, 49.0f);
                l.lineTo(3.0f, 3.0f);
                l.lineTo(77.0f, 3.0f);
                l.lineTo(77.0f, 49.0f);
                l.close();
                l.moveTo(48.513f, 60.0f);
                l.lineTo(32.487f, 60.0f);
                l.lineTo(38.0f, 58.162f);
                l.lineTo(38.0f, 52.0f);
                l.lineTo(43.0f, 52.0f);
                l.lineTo(43.0f, 58.162f);
                l.lineTo(48.513f, 60.0f);
                l.close();
                l.moveTo(77.129f, 0.0f);
                l.lineTo(2.871f, 0.0f);
                l.cubicTo(1.289f, 0.0f, 0.0f, 1.285f, 0.0f, 2.87f);
                l.lineTo(0.0f, 49.13f);
                l.cubicTo(0.0f, 50.715f, 1.285f, 52.0f, 2.871f, 52.0f);
                l.lineTo(35.0f, 52.0f);
                l.lineTo(35.0f, 56.0f);
                l.lineTo(23.0f, 60.0f);
                l.lineTo(23.0f, 63.0f);
                l.lineTo(58.0f, 63.0f);
                l.lineTo(58.0f, 60.0f);
                l.lineTo(46.0f, 56.0f);
                l.lineTo(46.0f, 52.0f);
                l.lineTo(77.129f, 52.0f);
                l.cubicTo(78.711f, 52.0f, 80.0f, 50.715f, 80.0f, 49.13f);
                l.lineTo(80.0f, 2.87f);
                l.cubicTo(80.0f, 1.285f, 78.715f, 0.0f, 77.129f, 0.0f);
                l.lineTo(77.129f, 0.0f);
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
