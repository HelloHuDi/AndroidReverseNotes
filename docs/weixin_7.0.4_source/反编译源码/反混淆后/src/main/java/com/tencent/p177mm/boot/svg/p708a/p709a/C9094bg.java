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

/* renamed from: com.tencent.mm.boot.svg.a.a.bg */
public final class C9094bg extends C5163c {
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
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(11.269531f, 8.1875f);
                l.cubicTo(9.5703125f, 8.1875f, 8.46875f, 9.628906f, 8.46875f, 11.84375f);
                l.cubicTo(8.46875f, 14.046875f, 9.558594f, 15.4765625f, 11.2578125f, 15.4765625f);
                l.cubicTo(12.9921875f, 15.4765625f, 14.105469f, 14.0234375f, 14.105469f, 11.785156f);
                l.cubicTo(14.105469f, 9.582031f, 13.015625f, 8.1875f, 11.269531f, 8.1875f);
                l.close();
                l.moveTo(11.644531f, 2.0f);
                l.cubicTo(16.779823f, 2.0f, 21.019531f, 5.5273438f, 21.019531f, 10.71875f);
                l.cubicTo(21.019531f, 14.4453125f, 19.472656f, 16.835938f, 16.894531f, 16.835938f);
                l.cubicTo(15.5f, 16.835938f, 14.3984375f, 15.9921875f, 14.222656f, 14.6796875f);
                l.lineTo(14.140625f, 14.6796875f);
                l.cubicTo(13.613281f, 16.015625f, 12.5234375f, 16.753906f, 11.0703125f, 16.753906f);
                l.cubicTo(8.65625f, 16.753906f, 7.015625f, 14.761719f, 7.015625f, 11.808594f);
                l.cubicTo(7.015625f, 8.925781f, 8.6796875f, 6.9335938f, 11.0703125f, 6.9335938f);
                l.cubicTo(12.4296875f, 6.9335938f, 13.613281f, 7.671875f, 14.046875f, 8.8203125f);
                l.lineTo(14.128906f, 8.8203125f);
                l.lineTo(14.128906f, 7.1679688f);
                l.lineTo(15.488281f, 7.1679688f);
                l.lineTo(15.488281f, 13.871094f);
                l.cubicTo(15.488281f, 14.9375f, 16.050781f, 15.640625f, 17.117188f, 15.640625f);
                l.cubicTo(18.675781f, 15.640625f, 19.742188f, 13.847656f, 19.742188f, 10.6953125f);
                l.cubicTo(19.742188f, 6.21875f, 16.238195f, 3.1757047f, 11.644531f, 3.1757047f);
                l.cubicTo(7.0508666f, 3.1757047f, 3.2890625f, 6.5256376f, 3.2890625f, 11.7734375f);
                l.cubicTo(3.2890625f, 16.648184f, 7.303185f, 20.363281f, 11.7734375f, 20.363281f);
                l.cubicTo(13.355469f, 20.363281f, 14.8671875f, 20.164062f, 15.6640625f, 19.847656f);
                l.lineTo(15.6640625f, 21.007812f);
                l.cubicTo(14.714844f, 21.335938f, 13.332031f, 21.523438f, 11.761719f, 21.523438f);
                l.cubicTo(6.1979494f, 21.523438f, 2.0f, 17.325605f, 2.0f, 11.7265625f);
                l.cubicTo(2.0f, 6.127519f, 6.5092382f, 2.0f, 11.644531f, 2.0f);
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
