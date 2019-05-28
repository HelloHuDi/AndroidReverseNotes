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
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.boot.svg.a.a.no */
public final class C25914no extends C5163c {
    private final int height = C31128d.MIC_ALPHA_ADJUST_REAL;
    private final int width = C31128d.MIC_ALPHA_ADJUST_REAL;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C31128d.MIC_ALPHA_ADJUST_REAL;
            case 1:
                return C31128d.MIC_ALPHA_ADJUST_REAL;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(6.0f);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-16139513);
                Path l = C5163c.m7884l(looper);
                l.moveTo(3.0f, 58.5f);
                l.cubicTo(3.0f, 27.848194f, 27.848194f, 3.0f, 58.5f, 3.0f);
                l.lineTo(58.5f, 3.0f);
                l.cubicTo(89.15181f, 3.0f, 114.0f, 27.848194f, 114.0f, 58.5f);
                l.lineTo(114.0f, 58.5f);
                l.cubicTo(114.0f, 89.15181f, 89.15181f, 114.0f, 58.5f, 114.0f);
                l.lineTo(58.5f, 114.0f);
                l.cubicTo(27.848194f, 114.0f, 3.0f, 89.15181f, 3.0f, 58.5f);
                l.lineTo(3.0f, 58.5f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(419430400);
                l = C5163c.m7884l(looper);
                l.moveTo(3.0f, 58.5f);
                l.cubicTo(3.0f, 27.848194f, 27.848194f, 3.0f, 58.5f, 3.0f);
                l.lineTo(58.5f, 3.0f);
                l.cubicTo(89.15181f, 3.0f, 114.0f, 27.848194f, 114.0f, 58.5f);
                l.lineTo(114.0f, 58.5f);
                l.cubicTo(114.0f, 89.15181f, 89.15181f, 114.0f, 58.5f, 114.0f);
                l.lineTo(58.5f, 114.0f);
                l.cubicTo(27.848194f, 114.0f, 3.0f, 89.15181f, 3.0f, 58.5f);
                l.lineTo(3.0f, 58.5f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-16139513);
                canvas.save();
                a = C5163c.m7876a(k2, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(66.90184f, 87.84637f);
                l.lineTo(61.993694f, 82.93822f);
                l.cubicTo(67.705605f, 76.6448f, 71.20168f, 68.19263f, 71.20168f, 58.899788f);
                l.cubicTo(71.20168f, 49.63003f, 67.722946f, 41.196777f, 62.03622f, 34.908302f);
                l.lineTo(66.94452f, 30.0f);
                l.cubicTo(73.8277f, 37.557686f, 78.04291f, 47.721935f, 78.04291f, 58.899788f);
                l.cubicTo(78.04291f, 70.10072f, 73.810265f, 80.28387f, 66.90184f, 87.84637f);
                l.close();
                l.moveTo(55.513187f, 76.45771f);
                l.lineTo(50.604183f, 71.548706f);
                l.cubicTo(53.81384f, 68.347855f, 55.808926f, 63.863693f, 55.808926f, 58.899788f);
                l.cubicTo(55.808926f, 53.958973f, 53.83236f, 49.49345f, 50.6489f, 46.295624f);
                l.lineTo(55.557533f, 41.386986f);
                l.cubicTo(59.93729f, 45.85434f, 62.65015f, 52.050896f, 62.65015f, 58.899788f);
                l.cubicTo(62.65015f, 65.77177f, 59.918972f, 71.98701f, 55.513187f, 76.45771f);
                l.close();
                l.moveTo(44.464256f, 65.40878f);
                l.cubicTo(46.18042f, 63.798565f, 47.25739f, 61.47866f, 47.25739f, 58.899788f);
                l.cubicTo(47.25739f, 56.34403f, 46.19964f, 54.04262f, 44.510254f, 52.43427f);
                l.lineTo(38.0f, 58.944523f);
                l.lineTo(44.464256f, 65.40878f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(419430400);
                canvas.save();
                k = C5163c.m7876a(k2, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(66.90184f, 87.84637f);
                l.lineTo(61.993694f, 82.93822f);
                l.cubicTo(67.705605f, 76.6448f, 71.20168f, 68.19263f, 71.20168f, 58.899788f);
                l.cubicTo(71.20168f, 49.63003f, 67.722946f, 41.196777f, 62.03622f, 34.908302f);
                l.lineTo(66.94452f, 30.0f);
                l.cubicTo(73.8277f, 37.557686f, 78.04291f, 47.721935f, 78.04291f, 58.899788f);
                l.cubicTo(78.04291f, 70.10072f, 73.810265f, 80.28387f, 66.90184f, 87.84637f);
                l.close();
                l.moveTo(55.513187f, 76.45771f);
                l.lineTo(50.604183f, 71.548706f);
                l.cubicTo(53.81384f, 68.347855f, 55.808926f, 63.863693f, 55.808926f, 58.899788f);
                l.cubicTo(55.808926f, 53.958973f, 53.83236f, 49.49345f, 50.6489f, 46.295624f);
                l.lineTo(55.557533f, 41.386986f);
                l.cubicTo(59.93729f, 45.85434f, 62.65015f, 52.050896f, 62.65015f, 58.899788f);
                l.cubicTo(62.65015f, 65.77177f, 59.918972f, 71.98701f, 55.513187f, 76.45771f);
                l.close();
                l.moveTo(44.464256f, 65.40878f);
                l.cubicTo(46.18042f, 63.798565f, 47.25739f, 61.47866f, 47.25739f, 58.899788f);
                l.cubicTo(47.25739f, 56.34403f, 46.19964f, 54.04262f, 44.510254f, 52.43427f);
                l.lineTo(38.0f, 58.944523f);
                l.lineTo(44.464256f, 65.40878f);
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
