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

/* renamed from: com.tencent.mm.boot.svg.a.a.by */
public final class C9098by extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-14776843);
                Path l = C5163c.m7884l(looper);
                l.moveTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.lineTo(68.0f, 87.0f);
                l.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                l.lineTo(3.0f, 90.0f);
                l.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                l.lineTo(0.0f, 3.0f);
                l.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                l.lineTo(46.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-15177020);
                l = C5163c.m7884l(looper);
                l.moveTo(68.0f, 22.0f);
                l.lineTo(49.0f, 22.0f);
                l.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                l.lineTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(33.0f, 70.0f);
                l.lineTo(33.0f, 58.0f);
                l.lineTo(21.0f, 58.0f);
                l.cubicTo(19.343145f, 58.0f, 18.0f, 56.656853f, 18.0f, 55.0f);
                l.lineTo(50.0f, 55.0f);
                l.cubicTo(50.0f, 56.656853f, 48.656853f, 58.0f, 47.0f, 58.0f);
                l.lineTo(35.0f, 58.0f);
                l.lineTo(35.0f, 70.0f);
                l.lineTo(41.0f, 70.0f);
                l.cubicTo(41.552284f, 70.0f, 42.0f, 70.447716f, 42.0f, 71.0f);
                l.cubicTo(42.0f, 71.552284f, 41.552284f, 72.0f, 41.0f, 72.0f);
                l.lineTo(27.0f, 72.0f);
                l.cubicTo(26.447716f, 72.0f, 26.0f, 71.552284f, 26.0f, 71.0f);
                l.cubicTo(26.0f, 70.447716f, 26.447716f, 70.0f, 27.0f, 70.0f);
                l.lineTo(33.0f, 70.0f);
                l.close();
                l.moveTo(22.963263f, 40.0f);
                l.lineTo(45.03674f, 40.0f);
                l.cubicTo(45.75458f, 40.0f, 46.371803f, 40.508587f, 46.50906f, 41.213184f);
                l.lineTo(49.0f, 54.0f);
                l.lineTo(19.0f, 54.0f);
                l.lineTo(21.490938f, 41.213184f);
                l.cubicTo(21.628197f, 40.508587f, 22.245419f, 40.0f, 22.963263f, 40.0f);
                l.close();
                l.moveTo(27.941095f, 50.631794f);
                l.lineTo(31.59338f, 47.182507f);
                l.lineTo(34.927055f, 49.438576f);
                l.cubicTo(35.184135f, 49.606796f, 35.52287f, 49.573586f, 35.734356f, 49.359222f);
                l.lineTo(40.37784f, 44.271843f);
                l.lineTo(39.46163f, 43.371574f);
                l.lineTo(35.17892f, 48.090324f);
                l.lineTo(31.900051f, 45.83415f);
                l.cubicTo(31.664028f, 45.665886f, 31.341633f, 45.699165f, 31.127651f, 45.91366f);
                l.lineTo(27.10436f, 49.731842f);
                l.lineTo(27.941095f, 50.631794f);
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
