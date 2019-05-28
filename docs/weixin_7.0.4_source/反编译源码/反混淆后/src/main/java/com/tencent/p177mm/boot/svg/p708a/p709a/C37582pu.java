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
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.boot.svg.a.a.pu */
public final class C37582pu extends C5163c {
    private final int height = 240;
    private final int width = C31128d.MIC_PTU_QINGCONG;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C31128d.MIC_PTU_QINGCONG;
            case 1:
                return 240;
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
                a.setColor(-564640);
                Path l = C5163c.m7884l(looper);
                l.moveTo(220.0f, 121.234566f);
                l.cubicTo(220.0f, 64.77037f, 175.22963f, 20.0f, 118.765434f, 20.0f);
                l.cubicTo(64.77037f, 20.0f, 20.0f, 64.77037f, 20.0f, 121.234566f);
                l.cubicTo(20.0f, 175.22963f, 64.77037f, 220.0f, 118.765434f, 220.0f);
                l.cubicTo(175.22963f, 220.0f, 220.0f, 175.22963f, 220.0f, 121.234566f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(114.11689f, 70.98039f);
                l.cubicTo(111.951485f, 70.98039f, 110.27686f, 72.72528f, 110.37761f, 74.90139f);
                l.lineTo(113.37151f, 139.56976f);
                l.cubicTo(113.42262f, 140.6737f, 114.36253f, 141.56863f, 115.46362f, 141.56863f);
                l.lineTo(124.53638f, 141.56863f);
                l.cubicTo(125.64071f, 141.56863f, 126.57727f, 140.67613f, 126.62849f, 139.56976f);
                l.lineTo(129.62239f, 74.90139f);
                l.cubicTo(129.72266f, 72.73588f, 128.0466f, 70.98039f, 125.88311f, 70.98039f);
                l.lineTo(114.11689f, 70.98039f);
                l.close();
                l.moveTo(120.0f, 172.94118f);
                l.cubicTo(125.41456f, 172.94118f, 129.80392f, 168.5518f, 129.80392f, 163.13725f);
                l.cubicTo(129.80392f, 157.7227f, 125.41456f, 153.33333f, 120.0f, 153.33333f);
                l.cubicTo(114.58544f, 153.33333f, 110.196075f, 157.7227f, 110.196075f, 163.13725f);
                l.cubicTo(110.196075f, 168.5518f, 114.58544f, 172.94118f, 120.0f, 172.94118f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
