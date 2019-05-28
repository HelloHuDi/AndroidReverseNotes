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

/* renamed from: com.tencent.mm.boot.svg.a.a.wf */
public final class C9164wf extends C5163c {
    private final int height = 48;
    private final int width = 54;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 48;
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-7503);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(21.993774f, 38.0f);
                l.lineTo(51.00044f, 38.0f);
                l.cubicTo(52.66516f, 38.0f, 54.0f, 36.6579f, 54.0f, 35.00234f);
                l.lineTo(54.0f, 2.99766f);
                l.cubicTo(54.0f, 1.3524401f, 52.65705f, 0.0f, 51.00044f, 0.0f);
                l.lineTo(2.9995608f, 0.0f);
                l.cubicTo(1.3348389f, 0.0f, 0.0f, 1.342098f, 0.0f, 2.99766f);
                l.lineTo(0.0f, 35.00234f);
                l.cubicTo(0.0f, 36.64756f, 1.3429492f, 38.0f, 2.9995608f, 38.0f);
                l.lineTo(9.0f, 38.0f);
                l.lineTo(9.0f, 47.950085f);
                l.lineTo(21.993774f, 38.0f);
                l.close();
                l.moveTo(19.0f, 32.0f);
                l.lineTo(48.0f, 32.0f);
                l.lineTo(48.0f, 6.0f);
                l.lineTo(6.0f, 6.0f);
                l.lineTo(6.0f, 32.0f);
                l.lineTo(15.0f, 32.0f);
                l.lineTo(15.0f, 36.0f);
                l.lineTo(19.0f, 32.0f);
                l.lineTo(19.0f, 32.0f);
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
