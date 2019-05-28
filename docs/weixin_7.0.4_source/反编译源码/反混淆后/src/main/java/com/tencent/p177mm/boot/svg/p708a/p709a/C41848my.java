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

/* renamed from: com.tencent.mm.boot.svg.a.a.my */
public final class C41848my extends C5163c {
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
                a.setColor(-15819547);
                Path l = C5163c.m7884l(looper);
                l.moveTo(19.426306f, 8.069898f);
                l.cubicTo(18.960836f, 7.191491f, 19.295588f, 6.1020646f, 20.173994f, 5.6365957f);
                l.cubicTo(21.0524f, 5.1711264f, 22.141829f, 5.5058784f, 22.607296f, 6.384285f);
                l.cubicTo(25.054684f, 11.002852f, 24.237564f, 16.734251f, 20.485281f, 20.486532f);
                l.cubicTo(15.79899f, 25.172825f, 8.20101f, 25.172825f, 3.5147185f, 20.486532f);
                l.cubicTo(-1.1715729f, 15.800241f, -1.1715729f, 8.202262f, 3.5147185f, 3.5159702f);
                l.cubicTo(7.2670016f, -0.23631252f, 12.998399f, -1.053432f, 17.616966f, 1.3939549f);
                l.cubicTo(18.495373f, 1.8594241f, 18.830126f, 2.9488506f, 18.364656f, 3.8272574f);
                l.cubicTo(17.899187f, 4.705664f, 16.809761f, 5.040416f, 15.931354f, 4.574947f);
                l.cubicTo(12.700203f, 2.8627546f, 8.686935f, 3.4349222f, 6.060303f, 6.061555f);
                l.cubicTo(2.779899f, 9.341959f, 2.779899f, 14.660544f, 6.060303f, 17.940948f);
                l.cubicTo(9.340707f, 21.221354f, 14.659293f, 21.221354f, 17.939697f, 17.940948f);
                l.cubicTo(20.56633f, 15.314316f, 21.138496f, 11.301048f, 19.426306f, 8.069898f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
