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

/* renamed from: com.tencent.mm.boot.svg.a.a.qm */
public final class C41857qm extends C5163c {
    private final int height = 120;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                a.setColor(-16268960);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.cubicTo(114.62742f, 0.0f, 120.0f, 5.3725824f, 120.0f, 12.0f);
                l.lineTo(120.0f, 108.0f);
                l.cubicTo(120.0f, 114.62742f, 114.62742f, 120.0f, 108.0f, 120.0f);
                l.lineTo(12.0f, 120.0f);
                l.cubicTo(5.3725824f, 120.0f, 0.0f, 114.62742f, 0.0f, 108.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(44.260315f, 12.026479f);
                l.cubicTo(44.50461f, 12.008928f, 44.75127f, 12.0f, 45.0f, 12.0f);
                l.cubicTo(50.580982f, 12.0f, 55.105263f, 16.48245f, 55.105263f, 22.000519f);
                l.lineTo(55.105263f, 26.275465f);
                l.cubicTo(55.105263f, 29.12324f, 53.591827f, 33.20715f, 51.74043f, 35.378933f);
                l.lineTo(50.827084f, 36.450333f);
                l.cubicTo(49.337765f, 38.197376f, 49.803f, 40.420994f, 51.885597f, 41.426277f);
                l.lineTo(66.18544f, 48.328896f);
                l.cubicTo(67.739876f, 49.07923f, 69.0f, 51.062923f, 69.0f, 52.78866f);
                l.lineTo(69.0f, 54.503906f);
                l.cubicTo(69.0f, 55.88246f, 67.86082f, 57.0f, 66.47007f, 57.0f);
                l.lineTo(63.54414f, 57.0f);
                l.cubicTo(63.17732f, 53.856773f, 61.040966f, 50.727318f, 58.235985f, 49.359085f);
                l.lineTo(41.254925f, 41.075943f);
                l.cubicTo(40.895622f, 40.900677f, 40.910355f, 40.971035f, 41.171318f, 40.66169f);
                l.lineTo(42.255917f, 39.37601f);
                l.cubicTo(45.004707f, 36.1176f, 47.1f, 30.393791f, 47.1f, 26.130558f);
                l.lineTo(47.1f, 21.000622f);
                l.cubicTo(47.1f, 17.660835f, 46.04925f, 14.565118f, 44.260315f, 12.026479f);
                l.close();
                l.moveTo(23.495739f, 37.050415f);
                l.cubicTo(21.288954f, 34.434856f, 19.5f, 29.548489f, 19.5f, 26.127872f);
                l.lineTo(19.5f, 20.998741f);
                l.cubicTo(19.5f, 14.37202f, 24.886068f, 9.0f, 31.5f, 9.0f);
                l.cubicTo(38.12742f, 9.0f, 43.5f, 14.378941f, 43.5f, 21.000622f);
                l.lineTo(43.5f, 26.130558f);
                l.cubicTo(43.5f, 29.547888f, 41.702797f, 34.44858f, 39.50426f, 37.054718f);
                l.lineTo(38.419662f, 38.340397f);
                l.cubicTo(36.651096f, 40.43685f, 37.203564f, 43.105194f, 39.676647f, 44.31153f);
                l.lineTo(56.657707f, 52.594673f);
                l.cubicTo(58.503605f, 53.49508f, 60.0f, 55.87551f, 60.0f, 57.94639f);
                l.lineTo(60.0f, 60.004684f);
                l.cubicTo(60.0f, 61.65895f, 58.647224f, 63.0f, 56.995712f, 63.0f);
                l.lineTo(6.0042887f, 63.0f);
                l.cubicTo(4.345066f, 63.0f, 3.0f, 61.667267f, 3.0f, 60.004684f);
                l.lineTo(3.0f, 57.94639f);
                l.cubicTo(3.0f, 55.891125f, 4.494453f, 53.495724f, 6.342293f, 52.593998f);
                l.lineTo(23.323353f, 44.30743f);
                l.cubicTo(25.78613f, 43.10562f, 26.358778f, 40.443787f, 24.580336f, 38.33592f);
                l.lineTo(23.495739f, 37.050415f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
