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

/* renamed from: com.tencent.mm.boot.svg.a.a.apz */
public final class apz extends C5163c {
    private final int height = 48;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(40.739872f, 0.951031f);
                l.cubicTo(42.90053f, -1.4607488f, 46.528423f, 1.1793065f, 46.95051f, 3.7101865f);
                l.cubicTo(47.27209f, 5.1890144f, 45.9556f, 6.2311416f, 45.05114f, 7.1938686f);
                l.cubicTo(36.941135f, 15.133884f, 28.891432f, 23.153301f, 20.801529f, 31.113167f);
                l.cubicTo(19.515184f, 32.60192f, 17.123386f, 32.065968f, 16.058132f, 30.616915f);
                l.cubicTo(11.405182f, 25.892607f, 6.5914383f, 21.327097f, 1.9485373f, 16.592863f);
                l.cubicTo(-1.2271264f, 13.724532f, 4.350384f, 8.295546f, 7.24466f, 11.362377f);
                l.cubicTo(11.103695f, 15.084259f, 14.862233f, 18.905392f, 18.701168f, 22.6372f);
                l.cubicTo(26.077553f, 15.44156f, 33.33334f, 8.116896f, 40.739872f, 0.951031f);
                l.lineTo(40.739872f, 0.951031f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
