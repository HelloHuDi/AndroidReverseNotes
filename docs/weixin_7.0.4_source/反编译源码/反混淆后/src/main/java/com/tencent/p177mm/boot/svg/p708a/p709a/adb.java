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

/* renamed from: com.tencent.mm.boot.svg.a.a.adb */
public final class adb extends C5163c {
    private final int height = 55;
    private final int width = 35;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 35;
            case 1:
                return 55;
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
                a.setColor(-5066062);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 4.0f);
                l.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                l.lineTo(5.0f, 0.0f);
                l.cubicTo(7.209139f, 0.0f, 9.0f, 1.7908609f, 9.0f, 4.0f);
                l.lineTo(9.0f, 51.0f);
                l.cubicTo(9.0f, 53.20914f, 7.209139f, 55.0f, 5.0f, 55.0f);
                l.lineTo(4.0f, 55.0f);
                l.cubicTo(1.7908609f, 55.0f, 0.0f, 53.20914f, 0.0f, 51.0f);
                l.lineTo(0.0f, 4.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(26.0f, 4.0f);
                l.cubicTo(26.0f, 1.7908609f, 27.790861f, 0.0f, 30.0f, 0.0f);
                l.lineTo(31.0f, 0.0f);
                l.cubicTo(33.20914f, 0.0f, 35.0f, 1.7908609f, 35.0f, 4.0f);
                l.lineTo(35.0f, 51.0f);
                l.cubicTo(35.0f, 53.20914f, 33.20914f, 55.0f, 31.0f, 55.0f);
                l.lineTo(30.0f, 55.0f);
                l.cubicTo(27.790861f, 55.0f, 26.0f, 53.20914f, 26.0f, 51.0f);
                l.lineTo(26.0f, 4.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
