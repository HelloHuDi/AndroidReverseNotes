package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class eu extends c {
    private final int height = 30;
    private final int width = 30;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 30;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-9074981);
                g = c.a(g, 1.0f, 0.0f, -350.0f, 0.0f, 1.0f, -661.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(372.0f, 661.0f);
                l.cubicTo(369.8465f, 661.0f, 368.307f, 661.45575f, 367.0f, 662.0f);
                l.cubicTo(364.6025f, 663.65375f, 363.0f, 666.1686f, 363.0f, 669.0f);
                l.lineTo(363.0f, 681.0f);
                l.cubicTo(363.0f, 683.11066f, 360.985f, 684.85187f, 359.0f, 685.0f);
                l.cubicTo(356.0145f, 684.85187f, 354.0f, 683.11066f, 354.0f, 681.0f);
                l.cubicTo(354.0f, 679.4344f, 355.023f, 678.1158f, 357.0f, 677.0f);
                l.cubicTo(356.6145f, 677.43445f, 356.723f, 677.39087f, 357.0f, 677.0f);
                l.cubicTo(357.769f, 676.9636f, 358.5705f, 676.2336f, 359.0f, 675.0f);
                l.cubicTo(359.3075f, 674.1341f, 358.4895f, 673.1199f, 357.0f, 673.0f);
                l.cubicTo(356.6805f, 673.1199f, 356.3145f, 673.1831f, 356.0f, 673.0f);
                l.cubicTo(355.96f, 673.2977f, 355.9585f, 673.2982f, 356.0f, 673.0f);
                l.cubicTo(353.863f, 673.922f, 352.1155f, 675.2888f, 351.0f, 677.0f);
                l.cubicTo(350.389f, 678.2278f, 350.0f, 679.5526f, 350.0f, 681.0f);
                l.cubicTo(350.0f, 685.3947f, 353.813f, 689.0f, 359.0f, 689.0f);
                l.cubicTo(360.1535f, 689.0f, 361.693f, 688.54425f, 363.0f, 688.0f);
                l.cubicTo(365.3975f, 686.34625f, 367.0f, 683.8314f, 367.0f, 681.0f);
                l.lineTo(367.0f, 669.0f);
                l.cubicTo(367.0f, 666.88934f, 369.0145f, 665.14813f, 372.0f, 665.0f);
                l.cubicTo(373.985f, 665.14813f, 376.0f, 666.88934f, 376.0f, 669.0f);
                l.cubicTo(376.0f, 670.631f, 374.8905f, 672.0009f, 373.0f, 673.0f);
                l.cubicTo(372.2775f, 672.9576f, 371.438f, 673.7265f, 371.0f, 675.0f);
                l.cubicTo(370.681f, 675.88306f, 371.495f, 676.8931f, 373.0f, 677.0f);
                l.cubicTo(373.263f, 676.8931f, 373.593f, 676.835f, 374.0f, 677.0f);
                l.cubicTo(373.967f, 676.72565f, 374.019f, 676.70905f, 374.0f, 677.0f);
                l.cubicTo(376.152f, 676.0661f, 377.889f, 674.7034f, 379.0f, 673.0f);
                l.cubicTo(379.611f, 671.77277f, 380.0f, 670.4474f, 380.0f, 669.0f);
                l.cubicTo(380.0f, 664.6053f, 376.187f, 661.0f, 372.0f, 661.0f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
