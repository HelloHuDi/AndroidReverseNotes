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

/* renamed from: com.tencent.mm.boot.svg.a.a.bc */
public final class C41798bc extends C5163c {
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
                k.setColor(-15028967);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2.5f, 20.0f);
                l.lineTo(2.5f, 19.315464f);
                l.cubicTo(2.5f, 18.630375f, 2.9981508f, 17.831907f, 3.6140976f, 17.531332f);
                l.lineTo(9.27445f, 14.769143f);
                l.cubicTo(10.095377f, 14.36854f, 10.286259f, 13.481262f, 9.693445f, 12.778639f);
                l.lineTo(9.331913f, 12.350138f);
                l.cubicTo(8.596317f, 11.478285f, 8.0f, 9.849497f, 8.0f, 8.7092905f);
                l.lineTo(8.0f, 6.9995804f);
                l.cubicTo(8.0f, 4.7906733f, 9.795356f, 3.0f, 12.0f, 3.0f);
                l.cubicTo(14.209139f, 3.0f, 16.0f, 4.79298f, 16.0f, 7.0002074f);
                l.lineTo(16.0f, 8.710186f);
                l.cubicTo(16.0f, 9.849296f, 15.400932f, 11.482861f, 14.668087f, 12.351573f);
                l.lineTo(14.306555f, 12.780132f);
                l.cubicTo(13.717032f, 13.4789505f, 13.901188f, 14.368398f, 14.725549f, 14.770511f);
                l.lineTo(20.385902f, 17.531557f);
                l.cubicTo(21.001202f, 17.831692f, 21.5f, 18.62517f, 21.5f, 19.315464f);
                l.lineTo(21.5f, 20.0f);
                l.cubicTo(21.5f, 20.552284f, 21.052284f, 21.0f, 20.5f, 21.0f);
                l.lineTo(3.5f, 21.0f);
                l.cubicTo(2.9477153f, 21.0f, 2.5f, 20.552284f, 2.5f, 20.0f);
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
