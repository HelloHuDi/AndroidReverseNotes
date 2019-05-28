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
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.fo */
public final class C6348fo extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -330.0f, 0.0f, 1.0f, -60.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 330.0f, 0.0f, 1.0f, 60.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(24.0f, 0.0f);
                l.lineTo(24.0f, 24.0f);
                l.lineTo(0.0f, 24.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(1.5f);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(12.0f, 0.0f);
                l2.lineTo(12.0f, 5.3816547f);
                l2.cubicTo(12.0f, 5.54734f, 12.134315f, 5.6816545f, 12.3f, 5.6816545f);
                l2.lineTo(17.964392f, 5.6816545f);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(a2, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 29.681654f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(12.0f, 12.0f);
                l2.lineTo(12.0f, 17.381655f);
                l2.cubicTo(12.0f, 17.54734f, 12.134315f, 17.681654f, 12.3f, 17.681654f);
                l2.lineTo(17.964392f, 17.681654f);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(5.964391f, 17.681654f);
                l2.lineTo(5.964391f, 12.3f);
                l2.cubicTo(5.964391f, 12.134315f, 5.8300767f, 12.0f, 5.6643915f, 12.0f);
                l2.lineTo(0.0f, 12.0f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(5.9643393f, 0.010877698f);
                l2.lineTo(5.9643393f, 5.3925323f);
                l2.cubicTo(5.9643393f, 5.558218f, 5.8300247f, 5.6925325f, 5.664339f, 5.6925325f);
                l2.lineTo(-5.2173913E-5f, 5.6925325f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
