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

/* renamed from: com.tencent.mm.boot.svg.a.a.amj */
public final class amj extends C5163c {
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 20.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(23.0f, 1.0f);
                l.cubicTo(28.777954f, -1.1186252f, 35.400658f, 0.56103134f, 39.0f, 5.0f);
                l.cubicTo(41.067303f, 8.92932f, 40.778492f, 13.488388f, 41.0f, 18.0f);
                l.cubicTo(40.1212f, 22.556534f, 36.277046f, 26.055819f, 35.0f, 30.0f);
                l.cubicTo(33.618004f, 32.64447f, 35.0023f, 34.973995f, 37.0f, 36.0f);
                l.cubicTo(42.451595f, 39.88299f, 48.875122f, 42.39248f, 54.0f, 47.0f);
                l.cubicTo(56.603268f, 49.061115f, 57.0813f, 55.329834f, 53.0f, 56.0f);
                l.cubicTo(36.585773f, 56.069683f, 20.273008f, 55.959705f, 4.0f, 56.0f);
                l.cubicTo(-0.89972633f, 56.339626f, -0.93956214f, 49.261074f, 2.0f, 47.0f);
                l.cubicTo(7.226779f, 42.172523f, 14.028744f, 39.73302f, 20.0f, 36.0f);
                l.cubicTo(21.796728f, 34.26414f, 22.314592f, 31.33474f, 21.0f, 29.0f);
                l.cubicTo(18.45052f, 24.816072f, 14.805542f, 20.506954f, 15.0f, 15.0f);
                l.cubicTo(14.566527f, 9.139277f, 17.364994f, 2.430649f, 23.0f, 1.0f);
                l.lineTo(23.0f, 1.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(59.0f, 14.0f);
                l.cubicTo(59.550797f, 11.291986f, 64.49609f, 11.311896f, 65.0f, 14.0f);
                l.cubicTo(65.09821f, 17.404175f, 64.91067f, 20.709135f, 65.0f, 24.0f);
                l.cubicTo(68.60236f, 24.073826f, 72.244705f, 23.884686f, 76.0f, 24.0f);
                l.cubicTo(77.397285f, 25.348026f, 77.338066f, 28.59326f, 76.0f, 30.0f);
                l.cubicTo(72.26445f, 30.11633f, 68.612236f, 29.92719f, 65.0f, 30.0f);
                l.cubicTo(64.91067f, 33.321743f, 65.108086f, 36.65657f, 65.0f, 40.0f);
                l.cubicTo(64.357895f, 42.699074f, 59.540924f, 42.66921f, 59.0f, 40.0f);
                l.cubicTo(58.89932f, 36.606796f, 59.106606f, 33.291878f, 59.0f, 30.0f);
                l.cubicTo(55.40504f, 29.92719f, 51.762695f, 30.11633f, 48.0f, 30.0f);
                l.cubicTo(46.659466f, 28.662943f, 46.56076f, 25.20866f, 48.0f, 24.0f);
                l.cubicTo(51.81205f, 23.874731f, 55.43465f, 24.073826f, 59.0f, 24.0f);
                l.cubicTo(59.106606f, 20.709135f, 58.90919f, 17.39422f, 59.0f, 14.0f);
                l.lineTo(59.0f, 14.0f);
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
