package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.xt */
public final class C6389xt extends C5163c {
    private final int height = 30;
    private final int width = 55;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 55;
            case 1:
                return 30;
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
                a.setColor(-1);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 4.0f);
                l.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                l.lineTo(30.0f, 0.0f);
                l.cubicTo(32.20914f, 0.0f, 34.0f, 1.7908609f, 34.0f, 4.0f);
                l.lineTo(34.0f, 26.0f);
                l.cubicTo(34.0f, 28.209139f, 32.20914f, 30.0f, 30.0f, 30.0f);
                l.lineTo(4.0f, 30.0f);
                l.cubicTo(1.7908609f, 30.0f, 0.0f, 28.209139f, 0.0f, 26.0f);
                l.lineTo(0.0f, 4.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(38.71698f, 13.0f);
                l.cubicTo(43.57647f, 8.820671f, 48.100197f, 4.1560574f, 54.0f, 1.0f);
                l.cubicTo(54.131836f, 10.646817f, 54.07152f, 20.353184f, 54.0f, 30.0f);
                l.lineTo(52.981133f, 30.0f);
                l.cubicTo(47.165295f, 25.652977f, 41.495552f, 21.266256f, 35.660378f, 17.0f);
                l.cubicTo(34.679802f, 14.844969f, 37.29351f, 13.584531f, 38.71698f, 13.0f);
                l.lineTo(38.71698f, 13.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
