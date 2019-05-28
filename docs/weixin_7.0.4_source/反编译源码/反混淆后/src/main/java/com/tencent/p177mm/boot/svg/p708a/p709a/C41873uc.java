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

/* renamed from: com.tencent.mm.boot.svg.a.a.uc */
public final class C41873uc extends C5163c {
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(36.19557f, 63.7295f);
                l.cubicTo(36.18903f, 63.723602f, 36.182568f, 63.717976f, 36.176186f, 63.712605f);
                l.lineTo(36.19557f, 63.7295f);
                l.close();
                l.moveTo(36.74051f, 62.90582f);
                l.cubicTo(37.4488f, 62.267334f, 38.24197f, 61.523434f, 39.098534f, 60.683678f);
                l.cubicTo(41.551903f, 58.278442f, 44.006676f, 55.60057f, 46.290497f, 52.73064f);
                l.cubicTo(52.408028f, 45.04313f, 56.13418f, 37.461308f, 56.38646f, 30.719046f);
                l.cubicTo(56.39548f, 30.477993f, 56.4f, 30.23831f, 56.4f, 30.0f);
                l.cubicTo(56.4f, 18.73339f, 47.26661f, 9.6f, 36.0f, 9.6f);
                l.cubicTo(24.73339f, 9.6f, 15.6f, 18.73339f, 15.6f, 30.0f);
                l.cubicTo(15.6f, 30.23831f, 15.604521f, 30.477993f, 15.61354f, 30.719046f);
                l.cubicTo(15.865823f, 37.461308f, 19.59197f, 45.04313f, 25.709501f, 52.73064f);
                l.cubicTo(27.993324f, 55.60057f, 30.4481f, 58.278442f, 32.901466f, 60.683678f);
                l.cubicTo(33.75803f, 61.523434f, 34.5512f, 62.267334f, 35.25949f, 62.90582f);
                l.cubicTo(35.590477f, 63.20419f, 35.840916f, 63.424175f, 36.0f, 63.561043f);
                l.cubicTo(36.159084f, 63.424175f, 36.409523f, 63.20419f, 36.74051f, 62.90582f);
                l.close();
                l.moveTo(33.785156f, 66.40343f);
                l.cubicTo(33.785156f, 66.40343f, 12.0f, 48.054832f, 12.0f, 30.0f);
                l.cubicTo(12.0f, 16.745167f, 22.745167f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(49.254833f, 6.0f, 60.0f, 16.745167f, 60.0f, 30.0f);
                l.cubicTo(60.0f, 48.054832f, 38.214844f, 66.40343f, 38.214844f, 66.40343f);
                l.cubicTo(37.000694f, 67.51806f, 35.00838f, 67.5061f, 33.785156f, 66.40343f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(36.0f, 38.4f);
                l.cubicTo(40.63919f, 38.4f, 44.4f, 34.63919f, 44.4f, 30.0f);
                l.cubicTo(44.4f, 25.360807f, 40.63919f, 21.6f, 36.0f, 21.6f);
                l.cubicTo(31.360807f, 21.6f, 27.6f, 25.360807f, 27.6f, 30.0f);
                l.cubicTo(27.6f, 34.63919f, 31.360807f, 38.4f, 36.0f, 38.4f);
                l.close();
                l.moveTo(36.0f, 42.0f);
                l.cubicTo(29.372583f, 42.0f, 24.0f, 36.62742f, 24.0f, 30.0f);
                l.cubicTo(24.0f, 23.372583f, 29.372583f, 18.0f, 36.0f, 18.0f);
                l.cubicTo(42.62742f, 18.0f, 48.0f, 23.372583f, 48.0f, 30.0f);
                l.cubicTo(48.0f, 36.62742f, 42.62742f, 42.0f, 36.0f, 42.0f);
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
