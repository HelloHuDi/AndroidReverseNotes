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

/* renamed from: com.tencent.mm.boot.svg.a.a.ac */
public final class C45187ac extends C5163c {
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
                k.setColor(-1);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(51.487274f, 48.305294f);
                l.lineTo(62.849243f, 59.667263f);
                l.lineTo(59.667263f, 62.849243f);
                l.lineTo(48.305294f, 51.487274f);
                l.cubicTo(44.15103f, 54.930374f, 38.817215f, 57.0f, 33.0f, 57.0f);
                l.cubicTo(19.745142f, 57.0f, 9.0f, 46.254856f, 9.0f, 33.0f);
                l.cubicTo(9.0f, 19.745142f, 19.745142f, 9.0f, 33.0f, 9.0f);
                l.cubicTo(46.254856f, 9.0f, 57.0f, 19.745142f, 57.0f, 33.0f);
                l.cubicTo(57.0f, 38.817215f, 54.930374f, 44.15103f, 51.487274f, 48.305294f);
                l.close();
                l.moveTo(52.54228f, 33.006664f);
                l.cubicTo(52.54228f, 22.237095f, 43.81185f, 13.506665f, 33.04228f, 13.506665f);
                l.cubicTo(22.272707f, 13.506665f, 13.542279f, 22.237095f, 13.542279f, 33.006664f);
                l.cubicTo(13.542279f, 43.776237f, 22.272707f, 52.506664f, 33.04228f, 52.506664f);
                l.cubicTo(43.81185f, 52.506664f, 52.54228f, 43.776237f, 52.54228f, 33.006664f);
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
