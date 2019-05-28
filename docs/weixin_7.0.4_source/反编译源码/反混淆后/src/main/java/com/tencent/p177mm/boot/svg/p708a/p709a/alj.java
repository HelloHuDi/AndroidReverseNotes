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

/* renamed from: com.tencent.mm.boot.svg.a.a.alj */
public final class alj extends C5163c {
    private final int height = 36;
    private final int width = 36;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                k = C5163c.m7876a(k2, looper);
                k.setStrokeWidth(1.0f);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-15028967);
                a.setStrokeWidth(2.0f);
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2.0306435f, 11.052016f);
                l.cubicTo(0.7812371f, 9.886849f, 0.0f, 8.226148f, 0.0f, 6.382979f);
                l.cubicTo(0.0f, 2.8577569f, 2.8577569f, 0.0f, 6.382979f, 0.0f);
                l.cubicTo(8.40088f, 0.0f, 10.200077f, 0.93637973f, 11.3697605f, 2.3983283f);
                l.cubicTo(7.022729f, 3.5833154f, 3.5322874f, 6.84528f, 2.0306435f, 11.052016f);
                l.close();
                l.moveTo(18.629875f, 2.3987827f);
                l.cubicTo(19.799551f, 0.9365738f, 21.598911f, 0.0f, 23.617022f, 0.0f);
                l.cubicTo(27.142242f, 0.0f, 30.0f, 2.8577569f, 30.0f, 6.382979f);
                l.cubicTo(30.0f, 8.226897f, 29.218128f, 9.8882f, 27.967833f, 11.053436f);
                l.cubicTo(26.46666f, 6.8465524f, 22.976622f, 3.5842826f, 18.629875f, 2.3987827f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(15.0f, 1.9148932f);
                l.cubicTo(22.226706f, 1.9148932f, 28.085106f, 7.7732944f, 28.085106f, 15.0f);
                l.cubicTo(28.085106f, 22.226706f, 22.226706f, 28.085106f, 15.0f, 28.085106f);
                l.cubicTo(7.7732944f, 28.085106f, 1.9148932f, 22.226706f, 1.9148932f, 15.0f);
                l.cubicTo(1.9148932f, 7.7732944f, 7.7732944f, 1.9148932f, 15.0f, 1.9148932f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(23.0f, 26.0f);
                l2.lineTo(26.19149f, 29.19149f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                a3.setStrokeCap(Cap.SQUARE);
                g = C5163c.m7878a(a2, -1.0f, 0.0f, 10.553192f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(4.0f, 26.0f);
                l.lineTo(6.5531917f, 29.829786f);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(15.0f, 6.1363635f);
                l2.lineTo(15.0f, 15.0f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(15.0f, 15.0f);
                l2.lineTo(20.74468f, 18.40909f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
