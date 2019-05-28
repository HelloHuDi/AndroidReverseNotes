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

/* renamed from: com.tencent.mm.boot.svg.a.a.oo */
public final class C37576oo extends C5163c {
    private final int height = 60;
    private final int width = 50;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 60;
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
                k.setColor(-12470760);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(23.0f, 0.0f);
                l.lineTo(27.0f, 0.0f);
                l.cubicTo(32.398567f, 0.61f, 37.560276f, 3.83f, 40.0f, 9.0f);
                l.cubicTo(42.712f, 13.29f, 42.053062f, 18.67f, 42.0f, 24.0f);
                l.cubicTo(45.008316f, 24.14f, 48.552624f, 25.55f, 49.0f, 29.0f);
                l.cubicTo(49.13169f, 37.37f, 48.961964f, 45.75f, 49.0f, 54.0f);
                l.cubicTo(49.031853f, 56.95f, 46.77548f, 59.0f, 44.0f, 60.0f);
                l.lineTo(6.0f, 60.0f);
                l.cubicTo(3.315282f, 59.17f, 0.97903454f, 57.02f, 1.0f, 54.0f);
                l.cubicTo(1.0389383f, 45.76f, 0.8692109f, 37.39f, 1.0f, 29.0f);
                l.cubicTo(1.4382969f, 25.58f, 4.982604f, 24.13f, 8.0f, 24.0f);
                l.cubicTo(7.947841f, 18.69f, 7.3088675f, 13.34f, 10.0f, 9.0f);
                l.cubicTo(12.370737f, 3.92f, 17.44259f, 0.73f, 23.0f, 0.0f);
                l.lineTo(23.0f, 0.0f);
                l.lineTo(23.0f, 0.0f);
                l.close();
                l.moveTo(16.0f, 9.0f);
                l.cubicTo(12.136461f, 13.47097f, 13.1924925f, 19.102543f, 13.0f, 24.0f);
                l.lineTo(37.0f, 24.0f);
                l.cubicTo(36.783848f, 19.30367f, 37.839878f, 14.003959f, 35.0f, 10.0f);
                l.cubicTo(30.587132f, 3.5754929f, 20.17625f, 3.3240833f, 16.0f, 9.0f);
                l.lineTo(16.0f, 9.0f);
                l.lineTo(16.0f, 9.0f);
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
