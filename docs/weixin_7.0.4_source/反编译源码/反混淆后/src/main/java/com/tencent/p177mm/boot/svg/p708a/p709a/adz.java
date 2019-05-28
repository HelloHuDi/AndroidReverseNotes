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

/* renamed from: com.tencent.mm.boot.svg.a.a.adz */
public final class adz extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                k.setColor(-350642);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(44.999012f, 71.646385f);
                l.lineTo(18.06173f, 87.246506f);
                l.cubicTo(16.15247f, 88.35221f, 15.124873f, 87.53144f, 15.765567f, 85.41645f);
                l.lineTo(24.811031f, 55.55646f);
                l.lineTo(1.0043138f, 34.66419f);
                l.cubicTo(-0.6587564f, 33.204716f, -0.20764746f, 32.021576f, 1.9966353f, 32.021576f);
                l.lineTo(31.459358f, 32.021576f);
                l.lineTo(43.445843f, 3.5297964f);
                l.cubicTo(44.303635f, 1.4908304f, 45.69375f, 1.4893055f, 46.552185f, 3.5297964f);
                l.lineTo(58.538666f, 32.021576f);
                l.lineTo(88.00139f, 32.021576f);
                l.cubicTo(90.2125f, 32.021576f, 90.65668f, 33.204803f, 88.99371f, 34.66419f);
                l.lineTo(65.187f, 55.55646f);
                l.lineTo(74.23246f, 85.41645f);
                l.cubicTo(74.87358f, 87.53287f, 73.84428f, 88.35146f, 71.936295f, 87.246506f);
                l.lineTo(44.999012f, 71.646385f);
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
