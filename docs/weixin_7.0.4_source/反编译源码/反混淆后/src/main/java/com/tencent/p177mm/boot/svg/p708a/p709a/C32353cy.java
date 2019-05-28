package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.cy */
public final class C32353cy extends C5163c {
    private final int height = C19392d.CTRL_INDEX;
    private final int width = C19392d.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C19392d.CTRL_INDEX;
            case 1:
                return C19392d.CTRL_INDEX;
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
                a.setColor(-4605512);
                Path l = C5163c.m7884l(looper);
                l.moveTo(67.0f, 134.0f);
                l.cubicTo(104.003075f, 134.0f, 134.0f, 104.003075f, 134.0f, 67.0f);
                l.cubicTo(134.0f, 29.996922f, 104.003075f, 0.0f, 67.0f, 0.0f);
                l.cubicTo(29.996922f, 0.0f, 0.0f, 29.996922f, 0.0f, 67.0f);
                l.cubicTo(0.0f, 104.003075f, 29.996922f, 134.0f, 67.0f, 134.0f);
                l.close();
                l.moveTo(67.0f, 133.0f);
                l.cubicTo(103.45079f, 133.0f, 133.0f, 103.45079f, 133.0f, 67.0f);
                l.cubicTo(133.0f, 30.549206f, 103.45079f, 1.0f, 67.0f, 1.0f);
                l.cubicTo(30.549206f, 1.0f, 1.0f, 30.549206f, 1.0f, 67.0f);
                l.cubicTo(1.0f, 103.45079f, 30.549206f, 133.0f, 67.0f, 133.0f);
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
