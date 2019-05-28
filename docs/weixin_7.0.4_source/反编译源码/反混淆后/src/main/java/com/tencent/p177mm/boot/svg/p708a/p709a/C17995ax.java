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

/* renamed from: com.tencent.mm.boot.svg.a.a.ax */
public final class C17995ax extends C5163c {
    private final int height = 35;
    private final int width = 38;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 35;
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
                Path l = C5163c.m7884l(looper);
                l.moveTo(2.0f, 0.0f);
                l.lineTo(36.0f, 0.0f);
                l.lineTo(36.0f, 34.0f);
                l.lineTo(2.0f, 34.0f);
                l.lineTo(2.0f, 0.0f);
                l.close();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-3552823);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(21.533342f, 1.5390043f);
                l2.cubicTo(18.496286f, 3.3171964f, 16.466658f, 6.4609146f, 16.466658f, 10.046336f);
                l2.lineTo(16.466658f, 24.953663f);
                l2.cubicTo(16.466658f, 27.638464f, 13.914593f, 29.814804f, 10.766671f, 29.814804f);
                l2.cubicTo(7.618604f, 29.814804f, 5.066686f, 27.638464f, 5.066686f, 24.953663f);
                l2.cubicTo(5.066686f, 23.043005f, 6.36239f, 21.394585f, 8.242542f, 20.600086f);
                l2.cubicTo(8.37827f, 20.542759f, 8.515754f, 20.488575f, 8.657331f, 20.440529f);
                l2.cubicTo(9.840709f, 19.954819f, 10.856035f, 19.041924f, 11.232944f, 17.982042f);
                l2.cubicTo(11.78931f, 16.417742f, 10.753362f, 15.149658f, 8.919134f, 15.149658f);
                l2.cubicTo(8.462077f, 15.149658f, 7.9984374f, 15.228689f, 7.5513253f, 15.371333f);
                l2.cubicTo(4.8933697f, 16.15236f, 2.6797478f, 17.860952f, 1.3511358f, 20.092672f);
                l2.cubicTo(0.49259856f, 21.534386f, 0.0f, 23.19059f, 0.0f, 24.953663f);
                l2.cubicTo(0.0f, 30.493301f, 4.8298936f, 35.0f, 10.766671f, 35.0f);
                l2.cubicTo(12.860947f, 35.0f, 14.811157f, 34.430172f, 16.466658f, 33.460995f);
                l2.cubicTo(19.503569f, 31.682804f, 21.533342f, 28.538937f, 21.533342f, 24.953663f);
                l2.lineTo(21.533342f, 10.046336f);
                l2.cubicTo(21.533342f, 7.361536f, 24.08526f, 5.1851964f, 27.233328f, 5.1851964f);
                l2.cubicTo(30.38125f, 5.1851964f, 32.933315f, 7.361536f, 32.933315f, 10.046336f);
                l2.cubicTo(32.933315f, 12.03872f, 31.52777f, 13.751053f, 29.51613f, 14.501845f);
                l2.cubicTo(28.218233f, 14.946692f, 27.154642f, 15.908084f, 26.749651f, 17.046844f);
                l2.cubicTo(26.19577f, 18.60411f, 27.22704f, 19.866358f, 29.05293f, 19.866358f);
                l2.cubicTo(29.466696f, 19.866358f, 29.884264f, 19.793913f, 30.291594f, 19.675516f);
                l2.cubicTo(30.358288f, 19.656956f, 30.423958f, 19.636002f, 30.490211f, 19.616243f);
                l2.cubicTo(33.125935f, 18.832373f, 35.326103f, 17.129019f, 36.64872f, 14.907476f);
                l2.cubicTo(37.507256f, 13.465614f, 38.0f, 11.809411f, 38.0f, 10.046336f);
                l2.cubicTo(38.0f, 4.506699f, 33.170105f, 0.0f, 27.233328f, 0.0f);
                l2.cubicTo(25.138906f, 0.0f, 23.188696f, 0.5696801f, 21.533342f, 1.5390043f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
