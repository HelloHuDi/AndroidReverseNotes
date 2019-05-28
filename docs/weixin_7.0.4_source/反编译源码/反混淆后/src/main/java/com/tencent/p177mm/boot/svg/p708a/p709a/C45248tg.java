package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.tg */
public final class C45248tg extends C5163c {
    private final int height = 53;
    private final int width = 53;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 53;
            case 1:
                return 53;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.434783f, 0.0f, 1.0f, 0.391304f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-16896);
                Path l = C5163c.m7884l(looper);
                l.moveTo(52.173912f, 26.27763f);
                l.cubicTo(52.173912f, 11.621121f, 40.494686f, 0.0f, 25.764894f, 0.0f);
                l.cubicTo(11.679227f, 0.0f, 0.0f, 11.621121f, 0.0f, 26.27763f);
                l.cubicTo(0.0f, 40.29322f, 11.679227f, 51.91434f, 25.764894f, 51.91434f);
                l.cubicTo(40.494686f, 51.91434f, 52.173912f, 40.29322f, 52.173912f, 26.27763f);
                l.lineTo(52.173912f, 26.27763f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(23.805798f, 13.323138f);
                l.lineTo(23.805798f, 13.323138f);
                l.cubicTo(23.804459f, 13.294402f, 23.80379f, 13.265638f, 23.80379f, 13.23687f);
                l.cubicTo(23.80379f, 12.213226f, 24.633615f, 11.383399f, 25.657259f, 11.383399f);
                l.lineTo(25.657259f, 11.383399f);
                l.lineTo(27.465271f, 11.383399f);
                l.cubicTo(27.494038f, 11.383399f, 27.522802f, 11.384069f, 27.551538f, 11.385408f);
                l.cubicTo(28.574074f, 11.433053f, 29.364378f, 12.300605f, 29.316732f, 13.323138f);
                l.lineTo(29.316732f, 13.323138f);
                l.lineTo(28.500492f, 30.840899f);
                l.cubicTo(28.47699f, 31.345303f, 28.0612f, 31.74217f, 27.556248f, 31.74217f);
                l.lineTo(27.556248f, 31.74217f);
                l.lineTo(25.566282f, 31.74217f);
                l.cubicTo(25.06133f, 31.74217f, 24.64554f, 31.345303f, 24.622036f, 30.840899f);
                l.lineTo(23.805798f, 13.323138f);
                l.lineTo(23.805798f, 13.323138f);
                l.close();
                l.moveTo(26.561264f, 40.790512f);
                l.cubicTo(24.989546f, 40.790512f, 23.715414f, 39.52455f, 23.715414f, 37.962906f);
                l.cubicTo(23.715414f, 36.401264f, 24.989546f, 35.1353f, 26.561264f, 35.1353f);
                l.cubicTo(28.132984f, 35.1353f, 29.407114f, 36.401264f, 29.407114f, 37.962906f);
                l.cubicTo(29.407114f, 39.52455f, 28.132984f, 40.790512f, 26.561264f, 40.790512f);
                l.lineTo(26.561264f, 40.790512f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
