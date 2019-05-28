package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.bat */
public final class bat extends C5163c {
    private final int height = 102;
    private final int width = 102;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-789517);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(102.0f, 0.0f);
                l.lineTo(102.0f, 102.0f);
                l.lineTo(0.0f, 102.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, C5163c.m7876a(a, looper));
                canvas.restore();
                canvas.save();
                Paint a2 = C5163c.m7876a(k2, looper);
                a2.setColor(-15616);
                a2.setStrokeWidth(6.0f);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(27.0f, 25.0f);
                l2.cubicTo(27.0f, 22.790861f, 28.790861f, 21.0f, 31.0f, 21.0f);
                l2.lineTo(71.0f, 21.0f);
                l2.cubicTo(73.20914f, 21.0f, 75.0f, 22.790861f, 75.0f, 25.0f);
                l2.lineTo(75.0f, 77.0f);
                l2.cubicTo(75.0f, 79.20914f, 73.20914f, 81.0f, 71.0f, 81.0f);
                l2.lineTo(31.0f, 81.0f);
                l2.cubicTo(28.790861f, 81.0f, 27.0f, 79.20914f, 27.0f, 77.0f);
                l2.lineTo(27.0f, 25.0f);
                l2.close();
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-15616);
                Path l3 = C5163c.m7884l(looper);
                l3.moveTo(36.0f, 33.0f);
                l3.lineTo(60.0f, 33.0f);
                l3.lineTo(60.0f, 39.0f);
                l3.lineTo(36.0f, 39.0f);
                l3.lineTo(36.0f, 33.0f);
                l3.close();
                canvas.drawPath(l3, k2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-15616);
                l3 = C5163c.m7884l(looper);
                l3.moveTo(36.0f, 45.0f);
                l3.lineTo(51.0f, 45.0f);
                l3.lineTo(51.0f, 51.0f);
                l3.lineTo(36.0f, 51.0f);
                l3.lineTo(36.0f, 45.0f);
                l3.close();
                canvas.drawPath(l3, k2);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
