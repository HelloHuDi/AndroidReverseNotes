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

/* renamed from: com.tencent.mm.boot.svg.a.a.atp */
public final class atp extends C5163c {
    private final int height = 144;
    private final int width = 144;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-2565928);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(6.0f, 51.08541f);
                l.cubicTo(5.843611f, 51.030075f, 5.675318f, 51.0f, 5.5f, 51.0f);
                l.cubicTo(4.665797f, 51.0f, 4.0f, 51.674454f, 4.0f, 52.50644f);
                l.lineTo(4.0f, 60.49356f);
                l.cubicTo(4.0f, 61.32846f, 4.6715727f, 62.0f, 5.5f, 62.0f);
                l.cubicTo(5.6756845f, 62.0f, 5.8439f, 61.970085f, 6.0f, 61.915085f);
                l.lineTo(6.0f, 62.0f);
                l.lineTo(9.0f, 62.0f);
                l.lineTo(9.0f, 51.0f);
                l.lineTo(6.0f, 51.0f);
                l.lineTo(6.0f, 51.08541f);
                l.close();
                l.moveTo(103.0f, 62.0f);
                l.lineTo(132.0f, 44.0f);
                l.lineTo(132.0f, 101.0f);
                l.lineTo(103.0f, 84.0f);
                l.lineTo(103.0f, 62.0f);
                l.close();
                l.moveTo(11.0f, 42.00439f);
                l.cubicTo(11.0f, 37.583687f, 14.586183f, 34.0f, 19.00362f, 34.0f);
                l.lineTo(90.99638f, 34.0f);
                l.cubicTo(95.41666f, 34.0f, 99.0f, 37.584976f, 99.0f, 42.00439f);
                l.lineTo(99.0f, 102.995605f);
                l.cubicTo(99.0f, 107.41631f, 95.41382f, 111.0f, 90.99638f, 111.0f);
                l.lineTo(19.00362f, 111.0f);
                l.cubicTo(14.583343f, 111.0f, 11.0f, 107.41502f, 11.0f, 102.995605f);
                l.lineTo(11.0f, 42.00439f);
                l.close();
                l.moveTo(134.0f, 43.0f);
                l.lineTo(139.0f, 43.0f);
                l.lineTo(139.0f, 103.0f);
                l.lineTo(134.0f, 103.0f);
                l.lineTo(134.0f, 43.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(6.0f, 51.08541f);
                l.cubicTo(5.843611f, 51.030075f, 5.675318f, 51.0f, 5.5f, 51.0f);
                l.cubicTo(4.665797f, 51.0f, 4.0f, 51.674454f, 4.0f, 52.50644f);
                l.lineTo(4.0f, 60.49356f);
                l.cubicTo(4.0f, 61.32846f, 4.6715727f, 62.0f, 5.5f, 62.0f);
                l.cubicTo(5.6756845f, 62.0f, 5.8439f, 61.970085f, 6.0f, 61.915085f);
                l.lineTo(6.0f, 62.0f);
                l.lineTo(9.0f, 62.0f);
                l.lineTo(9.0f, 51.0f);
                l.lineTo(6.0f, 51.0f);
                l.lineTo(6.0f, 51.08541f);
                l.close();
                l.moveTo(103.0f, 62.0f);
                l.lineTo(132.0f, 44.0f);
                l.lineTo(132.0f, 101.0f);
                l.lineTo(103.0f, 84.0f);
                l.lineTo(103.0f, 62.0f);
                l.close();
                l.moveTo(11.0f, 42.00439f);
                l.cubicTo(11.0f, 37.583687f, 14.586183f, 34.0f, 19.00362f, 34.0f);
                l.lineTo(90.99638f, 34.0f);
                l.cubicTo(95.41666f, 34.0f, 99.0f, 37.584976f, 99.0f, 42.00439f);
                l.lineTo(99.0f, 102.995605f);
                l.cubicTo(99.0f, 107.41631f, 95.41382f, 111.0f, 90.99638f, 111.0f);
                l.lineTo(19.00362f, 111.0f);
                l.cubicTo(14.583343f, 111.0f, 11.0f, 107.41502f, 11.0f, 102.995605f);
                l.lineTo(11.0f, 42.00439f);
                l.close();
                l.moveTo(134.0f, 43.0f);
                l.lineTo(139.0f, 43.0f);
                l.lineTo(139.0f, 103.0f);
                l.lineTo(134.0f, 103.0f);
                l.lineTo(134.0f, 43.0f);
                l.close();
                Paint k3 = C5163c.m7883k(looper);
                k3.setFlags(385);
                k3.setStyle(Style.FILL);
                Paint k4 = C5163c.m7883k(looper);
                k4.setFlags(385);
                k4.setStyle(Style.STROKE);
                k3.setColor(WebView.NIGHT_MODE_COLOR);
                k4.setStrokeWidth(1.0f);
                k4.setStrokeCap(Cap.BUTT);
                k4.setStrokeJoin(Join.MITER);
                k4.setStrokeMiter(4.0f);
                k4.setPathEffect(null);
                float[] a2 = C5163c.m7878a(g, 139.0f, 0.0f, 4.0f, 0.0f, 111.0f, 34.0f);
                h.reset();
                h.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-9772465, -6687207}, new float[]{0.0f, 1.0f}, h, 0);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
