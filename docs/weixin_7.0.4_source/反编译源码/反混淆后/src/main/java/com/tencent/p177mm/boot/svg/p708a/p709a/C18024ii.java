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

/* renamed from: com.tencent.mm.boot.svg.a.a.ii */
public final class C18024ii extends C5163c {
    private final int height = 48;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
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
                k.setColor(-16139513);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(26.0f, 23.171574f);
                l.lineTo(33.899494f, 31.071068f);
                l.cubicTo(34.680542f, 31.852116f, 34.680542f, 33.118446f, 33.899494f, 33.899494f);
                l.cubicTo(33.118446f, 34.680542f, 31.852116f, 34.680542f, 31.071068f, 33.899494f);
                l.lineTo(22.585787f, 25.414213f);
                l.cubicTo(22.390524f, 25.218952f, 22.244078f, 24.993359f, 22.146446f, 24.752602f);
                l.cubicTo(22.055964f, 24.539213f, 22.0f, 24.276142f, 22.0f, 24.0f);
                l.lineTo(22.0f, 16.0f);
                l.cubicTo(22.0f, 14.895431f, 22.89543f, 14.0f, 24.0f, 14.0f);
                l.cubicTo(25.10457f, 14.0f, 26.0f, 14.895431f, 26.0f, 16.0f);
                l.lineTo(26.0f, 23.171574f);
                l.close();
                l.moveTo(24.727272f, 48.0f);
                l.cubicTo(10.745166f, 48.0f, 0.0f, 37.254833f, 0.0f, 24.727272f);
                l.cubicTo(0.0f, 10.745166f, 10.745166f, 0.0f, 24.727272f, 0.0f);
                l.cubicTo(37.254833f, 0.0f, 48.0f, 10.745166f, 48.0f, 24.727272f);
                l.cubicTo(48.0f, 37.254833f, 37.254833f, 48.0f, 24.727272f, 48.0f);
                l.close();
                l.moveTo(24.0f, 44.0f);
                l.cubicTo(35.045696f, 44.0f, 44.0f, 35.045696f, 44.0f, 24.0f);
                l.cubicTo(44.0f, 12.954305f, 35.045696f, 4.0f, 24.0f, 4.0f);
                l.cubicTo(12.954305f, 4.0f, 4.0f, 12.954305f, 4.0f, 24.0f);
                l.cubicTo(4.0f, 35.045696f, 12.954305f, 44.0f, 24.0f, 44.0f);
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
