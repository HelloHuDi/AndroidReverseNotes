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

/* renamed from: com.tencent.mm.boot.svg.a.a.ao */
public final class C9092ao extends C5163c {
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
                k.setColor(-2130706433);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(46.0f, 73.0f);
                l.lineTo(46.0f, 69.99739f);
                l.cubicTo(46.0f, 69.96348f, 46.00085f, 69.929756f, 46.002525f, 69.896255f);
                l.cubicTo(36.447983f, 68.898026f, 29.0f, 60.818798f, 29.0f, 51.0f);
                l.cubicTo(29.0f, 49.89543f, 29.89543f, 49.0f, 31.0f, 49.0f);
                l.cubicTo(32.10457f, 49.0f, 33.0f, 49.89543f, 33.0f, 51.0f);
                l.cubicTo(33.0f, 59.28427f, 39.71573f, 66.0f, 48.0f, 66.0f);
                l.cubicTo(56.28427f, 66.0f, 63.0f, 59.28427f, 63.0f, 51.0f);
                l.cubicTo(63.0f, 49.89543f, 63.89543f, 49.0f, 65.0f, 49.0f);
                l.cubicTo(66.10457f, 49.0f, 67.0f, 49.89543f, 67.0f, 51.0f);
                l.cubicTo(67.0f, 60.818787f, 59.552032f, 68.89801f, 49.9975f, 69.896255f);
                l.lineTo(49.9975f, 69.896255f);
                l.cubicTo(49.99916f, 69.929756f, 50.0f, 69.96348f, 50.0f, 69.99739f);
                l.lineTo(50.0f, 73.0f);
                l.lineTo(57.008846f, 73.0f);
                l.cubicTo(58.110325f, 73.0f, 59.0f, 73.89543f, 59.0f, 75.0f);
                l.cubicTo(59.0f, 76.112274f, 58.10853f, 77.0f, 57.008846f, 77.0f);
                l.lineTo(38.991154f, 77.0f);
                l.cubicTo(37.889675f, 77.0f, 37.0f, 76.10457f, 37.0f, 75.0f);
                l.cubicTo(37.0f, 73.887726f, 37.89147f, 73.0f, 38.991154f, 73.0f);
                l.lineTo(46.0f, 73.0f);
                l.close();
                l.moveTo(48.0f, 20.0f);
                l.cubicTo(41.92487f, 20.0f, 37.0f, 24.920769f, 37.0f, 31.007566f);
                l.lineTo(37.0f, 50.992435f);
                l.cubicTo(37.0f, 57.071747f, 41.92353f, 62.0f, 48.0f, 62.0f);
                l.cubicTo(54.07513f, 62.0f, 59.0f, 57.07923f, 59.0f, 50.992435f);
                l.lineTo(59.0f, 31.007566f);
                l.cubicTo(59.0f, 24.928255f, 54.07647f, 20.0f, 48.0f, 20.0f);
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
