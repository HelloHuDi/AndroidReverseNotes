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

/* renamed from: com.tencent.mm.boot.svg.a.a.jq */
public final class C41833jq extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-8683387);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(79.0f, 66.0f);
                l.cubicTo(79.0f, 69.816f, 77.14933f, 73.0f, 73.0f, 73.0f);
                l.lineTo(71.0f, 73.0f);
                l.cubicTo(68.790665f, 73.0f, 67.0f, 71.209335f, 67.0f, 69.0f);
                l.cubicTo(67.0f, 66.790665f, 68.790665f, 65.0f, 71.0f, 65.0f);
                l.lineTo(79.0f, 65.0f);
                l.lineTo(79.0f, 66.0f);
                l.close();
                l.moveTo(88.0f, 63.0f);
                l.lineTo(88.0f, 56.0f);
                l.lineTo(88.0f, 56.0f);
                l.lineTo(88.0f, 56.0f);
                l.lineTo(88.0f, 53.0f);
                l.cubicTo(87.62795f, 46.030872f, 82.82739f, 40.0f, 74.0f, 40.0f);
                l.cubicTo(65.76251f, 40.0f, 60.369316f, 44.77833f, 60.0f, 52.0f);
                l.lineTo(60.0f, 52.0f);
                l.lineTo(69.0f, 52.0f);
                l.cubicTo(69.03787f, 49.75115f, 70.876205f, 48.206196f, 74.0f, 48.0f);
                l.cubicTo(77.81914f, 48.206196f, 79.44887f, 50.382885f, 79.0f, 53.0f);
                l.lineTo(79.0f, 56.0f);
                l.lineTo(79.0f, 56.0f);
                l.lineTo(79.0f, 56.0f);
                l.lineTo(71.0f, 56.0f);
                l.cubicTo(64.02007f, 56.401913f, 59.0f, 61.49816f, 59.0f, 69.0f);
                l.lineTo(59.0f, 69.0f);
                l.cubicTo(59.0f, 75.9452f, 64.09324f, 80.99727f, 71.0f, 81.0f);
                l.lineTo(72.0f, 81.0f);
                l.cubicTo(75.0855f, 80.99727f, 77.94593f, 80.10591f, 80.0f, 79.0f);
                l.cubicTo(80.66957f, 80.370995f, 80.938614f, 81.0f, 81.0f, 81.0f);
                l.lineTo(89.0f, 81.0f);
                l.cubicTo(89.0f, 81.0f, 87.63159f, 77.32937f, 88.0f, 63.0f);
                l.lineTo(88.0f, 63.0f);
                l.close();
                l.moveTo(22.0f, 56.0f);
                l.lineTo(28.0f, 32.0f);
                l.lineTo(34.0f, 56.0f);
                l.lineTo(22.0f, 56.0f);
                l.close();
                l.moveTo(36.0f, 16.0f);
                l.lineTo(32.0f, 16.0f);
                l.lineTo(24.0f, 16.0f);
                l.lineTo(24.0f, 16.0f);
                l.lineTo(10.0f, 73.0f);
                l.lineTo(6.0f, 73.0f);
                l.lineTo(6.0f, 81.0f);
                l.lineTo(22.0f, 81.0f);
                l.lineTo(22.0f, 73.0f);
                l.lineTo(18.0f, 73.0f);
                l.lineTo(20.0f, 65.0f);
                l.lineTo(37.0f, 65.0f);
                l.lineTo(39.0f, 73.0f);
                l.lineTo(35.0f, 73.0f);
                l.lineTo(35.0f, 81.0f);
                l.lineTo(55.0f, 81.0f);
                l.lineTo(55.0f, 73.0f);
                l.lineTo(51.0f, 73.0f);
                l.lineTo(36.0f, 16.0f);
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
