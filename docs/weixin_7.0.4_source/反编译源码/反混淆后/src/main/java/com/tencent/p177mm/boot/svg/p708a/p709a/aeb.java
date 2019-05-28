package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aeb */
public final class aeb extends C5163c {
    private final int height = 45;
    private final int width = 45;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                a.setColor(-1);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(43.153847f, 34.76923f);
                l.lineTo(34.46154f, 31.5f);
                l.cubicTo(34.0f, 31.346153f, 33.807693f, 31.423077f, 33.384617f, 31.653847f);
                l.cubicTo(32.0f, 32.423077f, 28.615385f, 34.26923f, 26.615385f, 35.307693f);
                l.lineTo(26.615385f, 35.307693f);
                l.cubicTo(26.115385f, 35.576923f, 25.576923f, 35.73077f, 24.961538f, 35.73077f);
                l.cubicTo(24.307692f, 35.73077f, 23.73077f, 35.53846f, 23.23077f, 35.23077f);
                l.cubicTo(20.423077f, 33.576923f, 17.76923f, 31.653847f, 15.5f, 29.346153f);
                l.lineTo(15.5f, 29.346153f);
                l.cubicTo(13.230769f, 27.076923f, 11.307693f, 24.423077f, 9.653846f, 21.615385f);
                l.cubicTo(9.346154f, 21.115385f, 9.153846f, 20.5f, 9.153846f, 19.884615f);
                l.cubicTo(9.153846f, 19.307692f, 9.307693f, 18.73077f, 9.576923f, 18.23077f);
                l.lineTo(9.576923f, 18.23077f);
                l.cubicTo(10.615385f, 16.192308f, 12.461538f, 12.807693f, 13.230769f, 11.461538f);
                l.cubicTo(13.461538f, 11.038462f, 13.538462f, 10.807693f, 13.384615f, 10.384615f);
                l.lineTo(10.115385f, 1.6923077f);
                l.cubicTo(9.692307f, 0.6923077f, 8.730769f, 0.03846154f, 7.576923f, 0.0f);
                l.cubicTo(7.1153846f, 0.0f, 6.576923f, 0.1923077f, 6.4615383f, 0.23076923f);
                l.cubicTo(2.6923077f, 1.6153846f, -2.1316282E-14f, 5.1923075f, -2.1316282E-14f, 9.423077f);
                l.cubicTo(-2.1316282E-14f, 10.615385f, 0.30769232f, 11.730769f, 0.34615386f, 12.0f);
                l.cubicTo(2.1923077f, 20.076923f, 6.3076925f, 27.26923f, 11.961538f, 32.923077f);
                l.lineTo(11.961538f, 32.923077f);
                l.lineTo(11.961538f, 32.923077f);
                l.lineTo(11.961538f, 32.923077f);
                l.lineTo(11.961538f, 32.923077f);
                l.lineTo(11.961538f, 32.923077f);
                l.cubicTo(17.615385f, 38.576923f, 24.807692f, 42.692307f, 32.884617f, 44.53846f);
                l.cubicTo(33.153847f, 44.615383f, 34.26923f, 44.884617f, 35.46154f, 44.884617f);
                l.cubicTo(39.692307f, 44.884617f, 43.26923f, 42.192307f, 44.653847f, 38.423077f);
                l.cubicTo(44.692307f, 38.307693f, 44.923077f, 37.76923f, 44.884617f, 37.307693f);
                l.cubicTo(44.807693f, 36.153847f, 44.153847f, 35.192307f, 43.153847f, 34.76923f);
                l.lineTo(43.153847f, 34.76923f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(24.638493f, 9.469288f);
                l.cubicTo(24.46589f, 6.9032474f, 25.258863f, 4.4039197f, 27.063414f, 2.5632863f);
                l.cubicTo(30.722916f, -1.1693913f, 37.15676f, -0.77969503f, 41.433807f, 3.4336972f);
                l.cubicTo(45.710857f, 7.6470895f, 46.211475f, 14.088652f, 42.55197f, 17.82133f);
                l.cubicTo(40.582294f, 19.830393f, 37.80889f, 20.64521f, 35.00066f, 20.312353f);
                l.cubicTo(34.71473f, 20.92221f, 34.3282f, 21.48763f, 33.839317f, 21.986317f);
                l.cubicTo(31.17852f, 24.700453f, 26.493263f, 24.409948f, 23.374504f, 21.337458f);
                l.cubicTo(20.255747f, 18.264965f, 19.884499f, 13.573975f, 22.545298f, 10.859838f);
                l.cubicTo(23.151972f, 10.241f, 23.863892f, 9.778364f, 24.638493f, 9.469288f);
                l.close();
                l.moveTo(24.638493f, 9.469288f);
                l.cubicTo(24.815912f, 12.107001f, 26.013597f, 14.815207f, 28.181576f, 16.950918f);
                l.cubicTo(30.156559f, 18.89651f, 32.591427f, 20.026789f, 35.00066f, 20.312353f);
                l.cubicTo(36.270943f, 17.60301f, 35.55584f, 14.016662f, 33.01011f, 11.508697f);
                l.cubicTo(30.602446f, 9.136748f, 27.261183f, 8.422798f, 24.638493f, 9.469288f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
