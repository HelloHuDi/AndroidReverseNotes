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

/* renamed from: com.tencent.mm.boot.svg.a.a.aki */
public final class aki extends C5163c {
    private final int height = 210;
    private final int width = 210;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -335.0f, 0.0f, 1.0f, -284.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 335.0f, 0.0f, 1.0f, 284.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-2565928);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.lineTo(198.0f, 0.0f);
                l.cubicTo(204.62741f, 0.0f, 210.0f, 5.3725824f, 210.0f, 12.0f);
                l.lineTo(210.0f, 198.0f);
                l.cubicTo(210.0f, 204.62741f, 204.62741f, 210.0f, 198.0f, 210.0f);
                l.lineTo(12.0f, 210.0f);
                l.cubicTo(5.3725824f, 210.0f, 0.0f, 204.62741f, 0.0f, 198.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(157.64894f, 92.3088f);
                l.lineTo(144.74844f, 105.2093f);
                l.lineTo(138.95433f, 99.41519f);
                l.lineTo(151.85483f, 86.514694f);
                l.cubicTo(159.84056f, 78.52897f, 159.70537f, 65.69745f, 151.70346f, 57.695538f);
                l.cubicTo(143.70525f, 49.697327f, 130.86548f, 49.56299f, 122.88431f, 57.544167f);
                l.lineTo(97.083305f, 83.34517f);
                l.cubicTo(89.09758f, 91.33089f, 89.232765f, 104.162415f, 97.23468f, 112.16432f);
                l.lineTo(91.50112f, 117.89788f);
                l.cubicTo(80.298676f, 106.695435f, 80.20087f, 88.6394f, 91.2892f, 77.55106f);
                l.lineTo(117.0902f, 51.75006f);
                l.cubicTo(128.17189f, 40.668373f, 146.23703f, 40.761997f, 157.43701f, 51.961983f);
                l.cubicTo(168.63947f, 63.16443f, 168.73727f, 81.22047f, 157.64894f, 92.3088f);
                l.close();
                l.moveTo(51.753483f, 117.08678f);
                l.lineTo(64.653984f, 104.18628f);
                l.lineTo(70.44809f, 109.980385f);
                l.lineTo(57.54759f, 122.88088f);
                l.cubicTo(49.56187f, 130.86661f, 49.697052f, 143.69812f, 57.698963f, 151.70004f);
                l.cubicTo(65.697174f, 159.69824f, 78.53694f, 159.83258f, 86.51812f, 151.85141f);
                l.lineTo(112.31912f, 126.05041f);
                l.cubicTo(120.30484f, 118.06469f, 120.16966f, 105.23316f, 112.16775f, 97.231255f);
                l.lineTo(117.901306f, 91.497696f);
                l.cubicTo(129.10376f, 102.70014f, 129.20155f, 120.75618f, 118.11323f, 131.84451f);
                l.lineTo(92.312225f, 157.64552f);
                l.cubicTo(81.23054f, 168.7272f, 63.165394f, 168.63358f, 51.965405f, 157.4336f);
                l.cubicTo(40.76296f, 146.23114f, 40.665154f, 128.17511f, 51.753483f, 117.08678f);
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
