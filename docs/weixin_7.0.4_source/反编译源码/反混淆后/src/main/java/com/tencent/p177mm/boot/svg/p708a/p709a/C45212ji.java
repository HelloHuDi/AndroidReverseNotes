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

/* renamed from: com.tencent.mm.boot.svg.a.a.ji */
public final class C45212ji extends C5163c {
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
                k.setColor(-8617851);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(81.0f, 60.0f);
                l.lineTo(72.0f, 60.0f);
                l.lineTo(72.0f, 68.0f);
                l.lineTo(64.0f, 68.0f);
                l.lineTo(64.0f, 77.0f);
                l.lineTo(72.0f, 77.0f);
                l.lineTo(72.0f, 85.0f);
                l.lineTo(81.0f, 85.0f);
                l.lineTo(81.0f, 77.0f);
                l.lineTo(89.0f, 77.0f);
                l.lineTo(89.0f, 68.0f);
                l.lineTo(81.0f, 68.0f);
                l.lineTo(81.0f, 60.0f);
                l.close();
                l.moveTo(33.0f, 66.0f);
                l.lineTo(27.0f, 69.0f);
                l.lineTo(28.0f, 64.0f);
                l.cubicTo(20.127745f, 59.652744f, 15.2f, 52.282616f, 15.0f, 44.0f);
                l.cubicTo(15.2f, 30.296667f, 28.315445f, 19.235294f, 48.0f, 19.0f);
                l.cubicTo(67.684555f, 19.235294f, 80.8f, 30.296667f, 81.0f, 44.0f);
                l.cubicTo(80.8f, 46.829475f, 80.203674f, 49.600197f, 79.0f, 52.0f);
                l.lineTo(88.0f, 52.0f);
                l.cubicTo(88.59775f, 49.54438f, 89.0f, 46.78464f, 89.0f, 44.0f);
                l.cubicTo(89.0f, 25.74804f, 72.60592f, 11.0f, 48.0f, 11.0f);
                l.cubicTo(23.394077f, 11.0f, 7.0f, 25.74804f, 7.0f, 44.0f);
                l.cubicTo(7.0f, 53.683987f, 11.725022f, 62.435818f, 20.0f, 68.0f);
                l.lineTo(15.0f, 81.0f);
                l.lineTo(31.0f, 74.0f);
                l.cubicTo(36.047134f, 75.924774f, 41.76071f, 76.882355f, 48.0f, 77.0f);
                l.cubicTo(50.683678f, 76.882355f, 53.264854f, 76.696144f, 56.0f, 76.0f);
                l.lineTo(56.0f, 68.0f);
                l.cubicTo(53.296288f, 68.428825f, 50.71238f, 68.64706f, 48.0f, 69.0f);
                l.cubicTo(42.51602f, 68.64706f, 37.537712f, 67.78236f, 33.0f, 66.0f);
                l.lineTo(33.0f, 66.0f);
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
