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

/* renamed from: com.tencent.mm.boot.svg.a.a.ayv */
public final class ayv extends C5163c {
    private final int height = 300;
    private final int width = 300;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 300;
            case 1:
                return 300;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 4.5f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                a3.setColor(-16139513);
                a3.setStrokeWidth(4.5f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(225.31592f, 264.80075f);
                l.cubicTo(202.24803f, 280.39413f, 174.43497f, 289.5f, 144.49512f, 289.5f);
                l.cubicTo(64.692665f, 289.5f, 0.0f, 224.80733f, 0.0f, 145.00488f);
                l.cubicTo(0.0f, 65.20243f, 64.692665f, 0.5097656f, 144.49512f, 0.5097656f);
                l.cubicTo(224.29756f, 0.5097656f, 288.99023f, 65.20243f, 288.99023f, 145.00488f);
                l.cubicTo(288.99023f, 172.66171f, 281.22012f, 198.50374f, 267.7438f, 220.46706f);
                l.cubicTo(264.5335f, 219.51198f, 261.12067f, 219.0f, 257.57407f, 219.0f);
                l.cubicTo(238.94579f, 219.0f, 223.5f, 234.44579f, 223.5f, 253.92592f);
                l.cubicTo(223.5f, 257.71713f, 224.13977f, 261.37653f, 225.31592f, 264.80075f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                a3.setColor(-16139513);
                a3.setStrokeWidth(4.5f);
                l = C5163c.m7884l(looper);
                l.moveTo(225.42502f, 265.11334f);
                l.cubicTo(202.44864f, 280.51575f, 174.8078f, 289.5f, 145.06857f, 289.5f);
                l.cubicTo(103.4674f, 289.5f, 65.97238f, 271.9194f, 39.6078f, 243.78242f);
                l.cubicTo(51.58996f, 235.5282f, 64.35446f, 233.1301f, 69.73765f, 231.88483f);
                l.cubicTo(81.02644f, 229.27345f, 111.87362f, 216.9068f, 118.01103f, 212.69315f);
                l.cubicTo(124.14844f, 208.47949f, 119.95141f, 198.55792f, 118.01103f, 188.25146f);
                l.cubicTo(110.53122f, 185.50029f, 104.98407f, 159.45934f, 104.98407f, 159.45934f);
                l.cubicTo(104.98407f, 159.45934f, 97.52433f, 159.45934f, 96.30792f, 144.55188f);
                l.cubicTo(95.091515f, 129.64441f, 95.4657f, 127.580124f, 101.04079f, 126.78066f);
                l.cubicTo(87.78057f, 67.689255f, 136.47884f, 61.38383f, 144.85443f, 62.1828f);
                l.cubicTo(150.505f, 60.587788f, 202.99605f, 66.09534f, 189.37816f, 126.78066f);
                l.cubicTo(194.95325f, 127.580124f, 195.32744f, 129.64441f, 194.11102f, 144.55188f);
                l.cubicTo(192.89462f, 159.45934f, 185.43488f, 159.45934f, 185.43488f, 159.45934f);
                l.cubicTo(185.43488f, 159.45934f, 179.88773f, 185.50029f, 172.40791f, 188.25146f);
                l.cubicTo(170.46753f, 198.55792f, 171.06592f, 203.13501f, 172.3352f, 207.7002f);
                l.cubicTo(173.60449f, 212.26538f, 209.3925f, 229.27345f, 220.6813f, 231.88483f);
                l.cubicTo(222.72247f, 232.35701f, 225.82489f, 232.99493f, 229.54349f, 234.055f);
                l.cubicTo(225.7403f, 239.67325f, 223.5f, 246.507f, 223.5f, 253.92592f);
                l.cubicTo(223.5f, 257.83276f, 224.17938f, 261.5996f, 225.42502f, 265.11334f);
                l.cubicTo(230.11873f, 278.35358f, 242.8526f, 288.0f, 257.57407f, 288.0f);
                l.cubicTo(277.05423f, 288.0f, 292.5f, 272.55423f, 292.5f, 253.92592f);
                l.cubicTo(292.5f, 234.44579f, 277.05423f, 219.0f, 257.57407f, 219.0f);
                l.cubicTo(238.94579f, 219.0f, 223.5f, 234.44579f, 223.5f, 253.92592f);
                l.cubicTo(223.5f, 257.83276f, 224.17938f, 261.5996f, 225.42502f, 265.11334f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(a2, 1.0f, 0.0f, 223.5f, 0.0f, 1.0f, 219.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                a4.setColor(-16139513);
                a4.setStrokeWidth(4.5f);
                l = C5163c.m7884l(looper);
                l.moveTo(69.0f, 34.925926f);
                l.cubicTo(69.0f, 15.445778f, 53.554222f, 0.0f, 34.074074f, 0.0f);
                l.cubicTo(15.445778f, 0.0f, 0.0f, 15.445778f, 0.0f, 34.925926f);
                l.cubicTo(0.0f, 53.554222f, 15.445778f, 69.0f, 34.074074f, 69.0f);
                l.cubicTo(53.554222f, 69.0f, 69.0f, 53.554222f, 69.0f, 34.925926f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(k, looper);
                a4.setColor(-15549168);
                l = C5163c.m7884l(looper);
                l.moveTo(17.539047f, 36.469982f);
                l.cubicTo(16.965199f, 35.876076f, 16.894337f, 34.85805f, 17.392899f, 34.179672f);
                l.lineTo(17.603064f, 33.893703f);
                l.cubicTo(18.096197f, 33.222706f, 19.024466f, 33.083824f, 19.681692f, 33.587547f);
                l.lineTo(27.140253f, 39.304108f);
                l.cubicTo(27.795115f, 39.806023f, 28.840012f, 39.784676f, 29.48546f, 39.246967f);
                l.lineTo(50.228977f, 21.965939f);
                l.cubicTo(50.86934f, 21.432465f, 51.87162f, 21.477173f, 52.456554f, 22.054852f);
                l.lineTo(52.31632f, 21.916353f);
                l.cubicTo(52.90621f, 22.498932f, 52.906204f, 23.441837f, 52.31567f, 24.023008f);
                l.lineTo(29.393995f, 46.581364f);
                l.cubicTo(28.803743f, 47.16226f, 27.861687f, 47.1534f, 27.286201f, 46.557804f);
                l.lineTo(17.539047f, 36.469982f);
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
