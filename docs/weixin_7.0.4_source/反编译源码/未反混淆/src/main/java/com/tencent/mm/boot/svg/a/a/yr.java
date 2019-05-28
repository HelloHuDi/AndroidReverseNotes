package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class yr extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k = c.a(k, looper);
                k.setColor(-15683841);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(53.062035f, 26.549711f);
                l.cubicTo(52.459232f, 25.463072f, 52.85146f, 24.09351f, 53.938095f, 23.490705f);
                l.cubicTo(55.024734f, 22.887901f, 56.3943f, 23.280127f, 56.997105f, 24.366766f);
                l.cubicTo(62.150024f, 33.65563f, 60.592953f, 45.350697f, 52.970562f, 52.97309f);
                l.cubicTo(43.59798f, 62.345673f, 28.40202f, 62.345673f, 19.029438f, 52.97309f);
                l.cubicTo(9.656855f, 43.600506f, 9.656855f, 28.404547f, 19.029438f, 19.031963f);
                l.cubicTo(26.651829f, 11.409573f, 38.346897f, 9.852504f, 47.63576f, 15.005424f);
                l.cubicTo(48.7224f, 15.608228f, 49.114624f, 16.97779f, 48.51182f, 18.06443f);
                l.cubicTo(47.90902f, 19.151068f, 46.539455f, 19.543295f, 45.452816f, 18.94049f);
                l.cubicTo(37.908688f, 14.755447f, 28.404543f, 16.02082f, 22.211418f, 22.213943f);
                l.cubicTo(14.596194f, 29.829168f, 14.596194f, 42.175884f, 22.211418f, 49.791107f);
                l.cubicTo(29.826641f, 57.406334f, 42.17336f, 57.406334f, 49.78858f, 49.791107f);
                l.cubicTo(55.98171f, 43.597984f, 57.247078f, 34.093838f, 53.062035f, 26.549711f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
