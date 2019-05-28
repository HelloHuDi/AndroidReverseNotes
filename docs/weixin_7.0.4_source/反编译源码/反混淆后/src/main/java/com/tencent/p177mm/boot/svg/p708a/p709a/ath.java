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

/* renamed from: com.tencent.mm.boot.svg.a.a.ath */
public final class ath extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 7.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.0f, 22.0f);
                l.cubicTo(-2.8734941f, 12.371129f, 4.898239f, 1.1049721f, 15.0f, 0.0f);
                l.cubicTo(23.440092f, -1.1542573f, 32.25474f, 5.2435603f, 34.0f, 14.0f);
                l.cubicTo(34.841976f, 18.579012f, 32.585667f, 23.21743f, 30.0f, 27.0f);
                l.cubicTo(26.478588f, 33.613884f, 21.885744f, 39.461887f, 17.0f, 45.0f);
                l.cubicTo(10.874953f, 37.892426f, 4.7478185f, 30.494947f, 1.0f, 22.0f);
                l.lineTo(1.0f, 22.0f);
                l.close();
                l.moveTo(13.0f, 7.0f);
                l.cubicTo(6.5172105f, 9.0244465f, 4.703988f, 19.022913f, 10.0f, 24.0f);
                l.cubicTo(15.73359f, 28.731422f, 25.8115f, 25.191965f, 27.0f, 18.0f);
                l.cubicTo(28.446182f, 10.514218f, 20.211548f, 3.7152615f, 13.0f, 7.0f);
                l.lineTo(13.0f, 7.0f);
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
