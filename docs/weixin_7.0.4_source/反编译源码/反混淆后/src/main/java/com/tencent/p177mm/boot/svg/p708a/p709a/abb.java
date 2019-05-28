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

/* renamed from: com.tencent.mm.boot.svg.a.a.abb */
public final class abb extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                a.setColor(-15365900);
                Path l = C5163c.m7884l(looper);
                l.moveTo(62.108814f, 34.19998f);
                l.lineTo(37.8f, 9.891169f);
                l.lineTo(37.8f, 23.5276f);
                l.cubicTo(43.318237f, 24.316921f, 47.683064f, 28.681744f, 48.472397f, 34.199978f);
                l.lineTo(44.819965f, 34.19998f);
                l.cubicTo(43.98607f, 30.091959f, 40.35412f, 27.0f, 36.0f, 27.0f);
                l.cubicTo(35.38356f, 27.0f, 34.781597f, 27.061974f, 34.2f, 27.180033f);
                l.lineTo(34.2f, 5.7663255f);
                l.cubicTo(36.269375f, 5.1218004f, 38.62053f, 5.620529f, 40.246616f, 7.2466154f);
                l.lineTo(64.75339f, 31.753386f);
                l.cubicTo(65.46176f, 32.461758f, 65.95476f, 33.304485f, 66.23367f, 34.19998f);
                l.lineTo(62.108814f, 34.19998f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-16726153);
                l = C5163c.m7884l(looper);
                l.moveTo(37.80002f, 62.108814f);
                l.lineTo(62.10883f, 37.8f);
                l.lineTo(48.4724f, 37.8f);
                l.cubicTo(47.68308f, 43.318237f, 43.318256f, 47.683064f, 37.800022f, 48.472397f);
                l.lineTo(37.80002f, 44.819965f);
                l.cubicTo(41.908043f, 43.98607f, 45.0f, 40.35412f, 45.0f, 36.0f);
                l.cubicTo(45.0f, 35.38356f, 44.938026f, 34.781597f, 44.819965f, 34.2f);
                l.lineTo(66.23367f, 34.2f);
                l.cubicTo(66.8782f, 36.269375f, 66.37947f, 38.62053f, 64.75339f, 40.246616f);
                l.lineTo(40.246616f, 64.75339f);
                l.cubicTo(39.538242f, 65.46176f, 38.695515f, 65.95476f, 37.80002f, 66.23367f);
                l.lineTo(37.80002f, 62.108814f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-372399);
                l = C5163c.m7884l(looper);
                l.moveTo(9.891187f, 37.80002f);
                l.lineTo(34.2f, 62.10883f);
                l.lineTo(34.2f, 48.4724f);
                l.cubicTo(28.681765f, 47.68308f, 24.316935f, 43.318256f, 23.527603f, 37.800022f);
                l.lineTo(27.180037f, 37.80002f);
                l.cubicTo(28.01393f, 41.908043f, 31.645882f, 45.0f, 36.0f, 45.0f);
                l.cubicTo(36.61644f, 45.0f, 37.218403f, 44.938026f, 37.8f, 44.819965f);
                l.lineTo(37.8f, 66.23367f);
                l.cubicTo(35.730625f, 66.8782f, 33.37947f, 66.37947f, 31.753386f, 64.75339f);
                l.lineTo(7.2466154f, 40.246616f);
                l.cubicTo(6.5382414f, 39.538242f, 6.045243f, 38.695515f, 5.7663307f, 37.80002f);
                l.lineTo(9.891187f, 37.80002f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-352965);
                l = C5163c.m7884l(looper);
                l.moveTo(34.19998f, 9.891187f);
                l.lineTo(9.891169f, 34.2f);
                l.lineTo(23.5276f, 34.2f);
                l.cubicTo(24.316921f, 28.681765f, 28.681744f, 24.316935f, 34.199978f, 23.527603f);
                l.lineTo(34.19998f, 27.180037f);
                l.cubicTo(30.091959f, 28.01393f, 27.0f, 31.645882f, 27.0f, 36.0f);
                l.cubicTo(27.0f, 36.61644f, 27.061974f, 37.218403f, 27.180033f, 37.8f);
                l.lineTo(5.7663255f, 37.8f);
                l.cubicTo(5.1218004f, 35.730625f, 5.620529f, 33.37947f, 7.2466154f, 31.753386f);
                l.lineTo(31.753386f, 7.2466154f);
                l.cubicTo(32.461758f, 6.5382414f, 33.304485f, 6.045243f, 34.19998f, 5.7663307f);
                l.lineTo(34.19998f, 9.891187f);
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
