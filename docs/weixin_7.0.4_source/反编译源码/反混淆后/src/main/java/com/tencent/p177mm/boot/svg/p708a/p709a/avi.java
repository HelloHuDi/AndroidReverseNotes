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

/* renamed from: com.tencent.mm.boot.svg.a.a.avi */
public final class avi extends C5163c {
    private final int height = 42;
    private final int width = 42;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                Paint a = C5163c.m7876a(k, looper);
                Paint a2 = C5163c.m7876a(k2, looper);
                a.setColor(-4210753);
                a2.setColor(-4210753);
                a2.setStrokeWidth(1.2f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Paint a4 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(20.06508f, 39.519398f);
                l.cubicTo(9.131414f, 39.519398f, 0.36045057f, 30.628284f, 0.36045057f, 19.814768f);
                l.cubicTo(0.36045057f, 8.881102f, 9.251564f, 0.11013767f, 20.06508f, 0.11013767f);
                l.cubicTo(30.998749f, 0.11013767f, 39.76971f, 9.001251f, 39.76971f, 19.814768f);
                l.cubicTo(39.76971f, 30.628284f, 30.998749f, 39.519398f, 20.06508f, 39.519398f);
                l.close();
                l.moveTo(20.06508f, 1.1914893f);
                l.cubicTo(9.852315f, 1.1914893f, 1.5619525f, 9.481853f, 1.5619525f, 19.694618f);
                l.cubicTo(1.5619525f, 29.907385f, 9.852315f, 38.197746f, 20.06508f, 38.197746f);
                l.cubicTo(30.277847f, 38.197746f, 38.56821f, 29.907385f, 38.56821f, 19.694618f);
                l.cubicTo(38.56821f, 9.481853f, 30.277847f, 1.1914893f, 20.06508f, 1.1914893f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                a = C5163c.m7876a(a2, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(25.83229f, 27.26408f);
                l.cubicTo(25.712141f, 27.26408f, 25.47184f, 27.14393f, 25.35169f, 27.023779f);
                l.lineTo(19.58448f, 20.055069f);
                l.cubicTo(19.46433f, 19.93492f, 19.46433f, 19.814768f, 19.46433f, 19.694618f);
                l.lineTo(19.46433f, 8.1602f);
                l.cubicTo(19.46433f, 7.79975f, 19.70463f, 7.559449f, 20.06508f, 7.559449f);
                l.cubicTo(20.425531f, 7.559449f, 20.665833f, 7.79975f, 20.665833f, 8.1602f);
                l.lineTo(20.665833f, 19.454317f);
                l.lineTo(26.312891f, 26.182728f);
                l.cubicTo(26.553192f, 26.423029f, 26.43304f, 26.78348f, 26.192741f, 27.023779f);
                l.cubicTo(26.07259f, 27.26408f, 25.95244f, 27.26408f, 25.83229f, 27.26408f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
