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

/* renamed from: com.tencent.mm.boot.svg.a.a.alv */
public final class alv extends C5163c {
    private final int height = 96;
    private final int width = 43;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 43;
            case 1:
                return 96;
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
                k = C5163c.m7876a(k, looper);
                k2 = C5163c.m7876a(k2, looper);
                k.setColor(-3355444);
                k2.setColor(832018327);
                k2.setStrokeWidth(1.44f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Paint a2 = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(21.5f, 31.0f);
                l.cubicTo(31.164984f, 31.0f, 39.0f, 38.835014f, 39.0f, 48.5f);
                l.cubicTo(39.0f, 58.164986f, 31.164984f, 66.0f, 21.5f, 66.0f);
                l.cubicTo(11.835016f, 66.0f, 4.0f, 58.164986f, 4.0f, 48.5f);
                l.cubicTo(4.0f, 38.835014f, 11.835016f, 31.0f, 21.5f, 31.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.drawPath(l, a2);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
