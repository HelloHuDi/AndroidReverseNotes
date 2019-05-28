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

/* renamed from: com.tencent.mm.boot.svg.a.a.aav */
public final class aav extends C5163c {
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
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(43.073338f, 15.6f);
                l.lineTo(28.926662f, 15.6f);
                l.lineTo(22.926662f, 24.6f);
                l.lineTo(9.6f, 24.6f);
                l.lineTo(9.6f, 56.4f);
                l.lineTo(62.4f, 56.4f);
                l.lineTo(62.4f, 24.6f);
                l.lineTo(49.073338f, 24.6f);
                l.lineTo(43.073338f, 15.6f);
                l.close();
                l.moveTo(44.197224f, 12.0f);
                l.cubicTo(44.698753f, 12.0f, 45.167103f, 12.250651f, 45.4453f, 12.66795f);
                l.lineTo(51.0f, 21.0f);
                l.lineTo(63.0f, 21.0f);
                l.cubicTo(64.65685f, 21.0f, 66.0f, 22.343145f, 66.0f, 24.0f);
                l.lineTo(66.0f, 57.0f);
                l.cubicTo(66.0f, 58.656853f, 64.65685f, 60.0f, 63.0f, 60.0f);
                l.lineTo(9.0f, 60.0f);
                l.cubicTo(7.343146f, 60.0f, 6.0f, 58.656853f, 6.0f, 57.0f);
                l.lineTo(6.0f, 24.0f);
                l.cubicTo(6.0f, 22.343145f, 7.343146f, 21.0f, 9.0f, 21.0f);
                l.lineTo(21.0f, 21.0f);
                l.lineTo(26.5547f, 12.66795f);
                l.cubicTo(26.8329f, 12.250651f, 27.301247f, 12.0f, 27.802776f, 12.0f);
                l.lineTo(44.197224f, 12.0f);
                l.close();
                l.moveTo(36.0f, 47.4f);
                l.cubicTo(40.63919f, 47.4f, 44.4f, 43.63919f, 44.4f, 39.0f);
                l.cubicTo(44.4f, 34.36081f, 40.63919f, 30.6f, 36.0f, 30.6f);
                l.cubicTo(31.360807f, 30.6f, 27.6f, 34.36081f, 27.6f, 39.0f);
                l.cubicTo(27.6f, 43.63919f, 31.360807f, 47.4f, 36.0f, 47.4f);
                l.close();
                l.moveTo(36.0f, 51.0f);
                l.cubicTo(29.372583f, 51.0f, 24.0f, 45.62742f, 24.0f, 39.0f);
                l.cubicTo(24.0f, 32.37258f, 29.372583f, 27.0f, 36.0f, 27.0f);
                l.cubicTo(42.62742f, 27.0f, 48.0f, 32.37258f, 48.0f, 39.0f);
                l.cubicTo(48.0f, 45.62742f, 42.62742f, 51.0f, 36.0f, 51.0f);
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
