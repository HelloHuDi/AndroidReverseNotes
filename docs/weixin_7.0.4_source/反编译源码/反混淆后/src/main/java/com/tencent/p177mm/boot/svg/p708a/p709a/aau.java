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

/* renamed from: com.tencent.mm.boot.svg.a.a.aau */
public final class aau extends C5163c {
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 9.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(43.08889f, 34.5f);
                l.lineTo(44.74044f, 32.84845f);
                l.cubicTo(45.865658f, 31.72323f, 46.4978f, 30.197107f, 46.4978f, 28.605808f);
                l.lineTo(46.4978f, 20.484488f);
                l.lineTo(53.92242f, 13.059866f);
                l.lineTo(56.043743f, 15.181187f);
                l.lineTo(57.1044f, 14.120526f);
                l.cubicTo(57.69019f, 13.5347395f, 57.69019f, 12.584992f, 57.1044f, 11.999206f);
                l.lineTo(46.4978f, 1.3926041f);
                l.cubicTo(45.912014f, 0.80681765f, 44.962265f, 0.80681765f, 44.37648f, 1.3926041f);
                l.lineTo(43.31582f, 2.4532642f);
                l.lineTo(45.43714f, 4.5745845f);
                l.lineTo(38.01252f, 11.999206f);
                l.lineTo(29.8912f, 11.999206f);
                l.cubicTo(28.2999f, 11.999206f, 26.773777f, 12.631347f, 25.648558f, 13.756565f);
                l.lineTo(5.132054f, 34.27307f);
                l.cubicTo(5.0582805f, 34.346844f, 4.987604f, 34.42254f, 4.9200253f, 34.5f);
                l.lineTo(9.996292f, 34.5f);
                l.lineTo(28.194143f, 16.302149f);
                l.cubicTo(28.64423f, 15.852062f, 29.254679f, 15.599206f, 29.8912f, 15.599206f);
                l.lineTo(39.50369f, 15.599206f);
                l.lineTo(47.982723f, 7.120169f);
                l.lineTo(51.37684f, 10.514281f);
                l.lineTo(42.8978f, 18.993319f);
                l.lineTo(42.8978f, 28.605808f);
                l.cubicTo(42.8978f, 29.242327f, 42.644943f, 29.852776f, 42.19486f, 30.302864f);
                l.lineTo(37.99772f, 34.5f);
                l.lineTo(43.08889f, 34.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(31.5f, 34.5f);
                l2.lineTo(49.5f, 34.5f);
                l2.lineTo(49.5f, 38.09999f);
                l2.lineTo(31.5f, 38.09999f);
                l2.lineTo(31.5f, 34.5f);
                l2.close();
                l2.moveTo(0.0f, 34.5f);
                l2.lineTo(22.5f, 34.5f);
                l2.lineTo(22.5f, 38.09999f);
                l2.lineTo(0.0f, 38.09999f);
                l2.lineTo(0.0f, 34.5f);
                l2.close();
                l2.moveTo(34.5f, 49.5f);
                l2.lineTo(48.0f, 49.5f);
                l2.lineTo(48.0f, 53.09999f);
                l2.lineTo(34.5f, 53.09999f);
                l2.lineTo(34.5f, 49.5f);
                l2.close();
                l2.moveTo(25.5f, 42.0f);
                l2.lineTo(37.5f, 42.0f);
                l2.lineTo(37.5f, 45.59999f);
                l2.lineTo(25.5f, 45.59999f);
                l2.lineTo(25.5f, 42.0f);
                l2.close();
                l2.moveTo(12.0f, 42.0f);
                l2.lineTo(18.0f, 42.0f);
                l2.lineTo(18.0f, 45.59999f);
                l2.lineTo(12.0f, 45.59999f);
                l2.lineTo(12.0f, 42.0f);
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
