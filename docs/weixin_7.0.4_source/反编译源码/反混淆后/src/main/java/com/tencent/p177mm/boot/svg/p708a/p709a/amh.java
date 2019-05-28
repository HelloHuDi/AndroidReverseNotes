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

/* renamed from: com.tencent.mm.boot.svg.a.a.amh */
public final class amh extends C5163c {
    private final int height = 24;
    private final int width = 24;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                k = C5163c.m7876a(k, looper);
                k.setColor(-564640);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(12.0f, 3.0f);
                l.cubicTo(16.970562f, 3.0f, 21.0f, 7.029437f, 21.0f, 12.0f);
                l.cubicTo(21.0f, 16.970562f, 16.970562f, 21.0f, 12.0f, 21.0f);
                l.cubicTo(7.029437f, 21.0f, 3.0f, 16.970562f, 3.0f, 12.0f);
                l.cubicTo(3.0f, 7.029437f, 7.029437f, 3.0f, 12.0f, 3.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(3.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(12.0f, 1.5f);
                l.cubicTo(17.79899f, 1.5f, 22.5f, 6.2010098f, 22.5f, 12.0f);
                l.cubicTo(22.5f, 17.79899f, 17.79899f, 22.5f, 12.0f, 22.5f);
                l.cubicTo(6.2010098f, 22.5f, 1.5f, 17.79899f, 1.5f, 12.0f);
                l.cubicTo(1.5f, 6.2010098f, 6.2010098f, 1.5f, 12.0f, 1.5f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
