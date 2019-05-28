package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ann extends c {
    private final int height = 80;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 80;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-8617594);
                g = c.a(g, 1.0f, 0.0f, -416.0f, 0.0f, 1.0f, -1269.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(482.0f, 1311.7202f);
                l.lineTo(482.0f, 1271.9901f);
                l.cubicTo(482.0f, 1270.3384f, 480.65353f, 1269.0f, 478.9926f, 1269.0f);
                l.lineTo(419.0074f, 1269.0f);
                l.cubicTo(417.3483f, 1269.0f, 416.0f, 1270.3387f, 416.0f, 1271.9901f);
                l.lineTo(416.0f, 1346.0099f);
                l.cubicTo(416.0f, 1347.6616f, 417.34647f, 1349.0f, 419.0074f, 1349.0f);
                l.lineTo(478.9926f, 1349.0f);
                l.cubicTo(480.6517f, 1349.0f, 482.0f, 1347.6613f, 482.0f, 1346.0099f);
                l.lineTo(482.0f, 1316.9371f);
                l.lineTo(449.52548f, 1336.6007f);
                l.lineTo(449.2816f, 1336.748f);
                l.cubicTo(448.97964f, 1336.9077f, 448.63965f, 1337.0f, 448.2788f, 1337.0f);
                l.cubicTo(447.44376f, 1337.0f, 446.71753f, 1336.517f, 446.33582f, 1335.8048f);
                l.lineTo(446.18982f, 1335.4691f);
                l.lineTo(440.107f, 1321.471f);
                l.cubicTo(440.0408f, 1321.3179f, 440.0f, 1321.1458f, 440.0f, 1320.9784f);
                l.cubicTo(440.0f, 1320.3337f, 440.49866f, 1319.8098f, 441.1143f, 1319.8098f);
                l.cubicTo(441.36453f, 1319.8098f, 441.59482f, 1319.8964f, 441.7807f, 1320.0417f);
                l.lineTo(448.9588f, 1325.4017f);
                l.cubicTo(449.48376f, 1325.7621f, 450.11026f, 1325.9731f, 450.78394f, 1325.9731f);
                l.cubicTo(451.18558f, 1325.9731f, 451.5691f, 1325.8942f, 451.92633f, 1325.7583f);
                l.lineTo(482.0f, 1311.7202f);
                l.close();
                l.moveTo(428.0f, 1294.5f);
                l.lineTo(452.0f, 1294.5f);
                l.lineTo(452.0f, 1299.0f);
                l.lineTo(428.0f, 1299.0f);
                l.lineTo(428.0f, 1294.5f);
                l.close();
                l.moveTo(428.0f, 1281.0f);
                l.lineTo(452.0f, 1281.0f);
                l.lineTo(452.0f, 1285.5f);
                l.lineTo(428.0f, 1285.5f);
                l.lineTo(428.0f, 1281.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
