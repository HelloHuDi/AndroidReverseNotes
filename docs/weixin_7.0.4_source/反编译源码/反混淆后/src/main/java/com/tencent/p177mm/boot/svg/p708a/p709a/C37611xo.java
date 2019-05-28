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

/* renamed from: com.tencent.mm.boot.svg.a.a.xo */
public final class C37611xo extends C5163c {
    private final int height = 216;
    private final int width = 216;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 216;
            case 1:
                return 216;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 40.0f);
                l.cubicTo(0.0f, 17.90861f, 17.90861f, 0.0f, 40.0f, 0.0f);
                l.lineTo(176.0f, 0.0f);
                l.cubicTo(198.09138f, 0.0f, 216.0f, 17.90861f, 216.0f, 40.0f);
                l.lineTo(216.0f, 176.0f);
                l.cubicTo(216.0f, 198.09138f, 198.09138f, 216.0f, 176.0f, 216.0f);
                l.lineTo(40.0f, 216.0f);
                l.cubicTo(17.90861f, 216.0f, 0.0f, 198.09138f, 0.0f, 176.0f);
                l.lineTo(0.0f, 40.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
