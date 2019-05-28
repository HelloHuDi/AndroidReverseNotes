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

/* renamed from: com.tencent.mm.boot.svg.a.a.azy */
public final class azy extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                a.setColor(-15028967);
                a.setStrokeWidth(3.6f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(36.0f, 1.7999992f);
                l.cubicTo(54.888138f, 1.7999992f, 70.2f, 17.11186f, 70.2f, 36.0f);
                l.cubicTo(70.2f, 54.888138f, 54.888138f, 70.2f, 36.0f, 70.2f);
                l.cubicTo(17.11186f, 70.2f, 1.7999992f, 54.888138f, 1.7999992f, 36.0f);
                l.cubicTo(1.7999992f, 17.11186f, 17.11186f, 1.7999992f, 36.0f, 1.7999992f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-15028967);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(24.0f, 19.5f);
                l2.lineTo(29.4f, 19.5f);
                l2.lineTo(29.4f, 52.5f);
                l2.lineTo(24.0f, 52.5f);
                l2.lineTo(24.0f, 19.5f);
                l2.close();
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-15028967);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(42.59999f, 19.5f);
                l2.lineTo(47.999992f, 19.5f);
                l2.lineTo(47.999992f, 52.5f);
                l2.lineTo(42.59999f, 52.5f);
                l2.lineTo(42.59999f, 19.5f);
                l2.close();
                canvas.drawPath(l2, k2);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
