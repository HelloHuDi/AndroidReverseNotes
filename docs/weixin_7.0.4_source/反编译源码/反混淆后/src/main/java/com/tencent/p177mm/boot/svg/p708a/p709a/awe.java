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

/* renamed from: com.tencent.mm.boot.svg.a.a.awe */
public final class awe extends C5163c {
    private final int height = 480;
    private final int width = 480;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                float[] a = C5163c.m7878a(g, 1.0f, 0.0f, 90.0f, 0.0f, 1.0f, 90.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-11286451);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(141.2704f, 0.26394463f);
                l.cubicTo(172.25175f, -1.596309f, 203.76312f, 6.414783f, 229.95427f, 23.087057f);
                l.cubicTo(255.80539f, 39.299267f, 276.4263f, 63.632584f, 288.2668f, 91.746414f);
                l.cubicTo(300.64734f, 120.9704f, 303.29745f, 154.15492f, 295.89716f, 185.00912f);
                l.cubicTo(288.77682f, 214.99323f, 272.0561f, 242.57698f, 248.82509f, 262.82974f);
                l.cubicTo(228.12419f, 281.05222f, 202.29306f, 293.39392f, 175.07187f, 297.9045f);
                l.cubicTo(145.15056f, 302.97522f, 113.699196f, 298.80466f, 86.24799f, 285.81287f);
                l.cubicTo(55.996677f, 271.65094f, 30.745575f, 247.05759f, 15.854925f, 217.15352f);
                l.cubicTo(0.8442703f, 187.46947f, -3.6459255f, 152.71472f, 2.9743633f, 120.15029f);
                l.cubicTo(9.454646f, 87.74587f, 27.115416f, 57.74178f, 52.226513f, 36.268852f);
                l.cubicTo(76.867584f, 14.905941f, 108.698975f, 2.034186f, 141.2704f, 0.26394463f);
                l.lineTo(141.2704f, 0.26394463f);
                l.close();
                l.moveTo(215.60826f, 93.22582f);
                l.cubicTo(185.5484f, 123.492424f, 155.53864f, 153.80917f, 125.4888f, 184.0858f);
                l.cubicTo(112.05204f, 170.58717f, 98.685425f, 157.00833f, 85.22863f, 143.52975f);
                l.cubicTo(82.7036f, 140.73175f, 77.964165f, 140.75182f, 75.429115f, 143.52975f);
                l.cubicTo(70.55942f, 148.38365f, 65.69974f, 153.24756f, 60.910202f, 158.18169f);
                l.cubicTo(58.33507f, 160.72897f, 58.375153f, 165.2519f, 60.9603f, 167.77914f);
                l.cubicTo(80.74971f, 187.80646f, 100.58922f, 207.77359f, 120.4187f, 227.77081f);
                l.cubicTo(122.963776f, 230.69919f, 127.88357f, 230.75935f, 130.46872f, 227.85103f);
                l.cubicTo(165.9594f, 192.11879f, 201.37993f, 156.31635f, 236.86058f, 120.5841f);
                l.cubicTo(239.075f, 118.25745f, 242.1912f, 115.96088f, 241.9908f, 112.3706f);
                l.cubicTo(242.06094f, 109.64279f, 240.06697f, 107.617f, 238.26338f, 105.86198f);
                l.cubicTo(233.83456f, 101.54964f, 229.62617f, 97.01666f, 225.14726f, 92.75447f);
                l.cubicTo(222.53204f, 90.17709f, 218.00304f, 90.5281f, 215.60826f, 93.22582f);
                l.lineTo(215.60826f, 93.22582f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                g = C5163c.m7878a(a, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 90.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(157.60826f, 3.225819f);
                l.cubicTo(160.00304f, 0.5280999f, 164.53204f, 0.17709555f, 167.14726f, 2.7544703f);
                l.cubicTo(171.62617f, 7.0166664f, 175.83456f, 11.549637f, 180.26338f, 15.861977f);
                l.cubicTo(182.06697f, 17.616999f, 184.06094f, 19.642794f, 183.9908f, 22.3706f);
                l.cubicTo(184.1912f, 25.960873f, 181.075f, 28.257444f, 178.86058f, 30.584103f);
                l.cubicTo(143.37993f, 66.316345f, 107.95939f, 102.11879f, 72.46872f, 137.85103f);
                l.cubicTo(69.88357f, 140.75935f, 64.963776f, 140.69919f, 62.418705f, 137.77081f);
                l.cubicTo(42.58922f, 117.77358f, 22.749708f, 97.80645f, 2.9603012f, 77.779144f);
                l.cubicTo(0.37515315f, 75.251915f, 0.33507332f, 70.72897f, 2.9102013f, 68.18169f);
                l.cubicTo(7.699739f, 63.247566f, 12.559417f, 58.383648f, 17.429113f, 53.52976f);
                l.cubicTo(19.964163f, 50.75181f, 24.7036f, 50.731754f, 27.228628f, 53.52976f);
                l.cubicTo(40.685425f, 67.00832f, 54.052044f, 80.58718f, 67.4888f, 94.08581f);
                l.cubicTo(97.53864f, 63.809174f, 127.5484f, 33.492424f, 157.60826f, 3.225819f);
                l.lineTo(157.60826f, 3.225819f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
