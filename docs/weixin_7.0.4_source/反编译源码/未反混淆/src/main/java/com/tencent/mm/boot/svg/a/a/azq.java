package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class azq extends c {
    private final int height = 24;
    private final int width = 24;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                k2 = c.a(k, looper);
                k2.setColor(-1);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.lineTo(12.0f, 0.0f);
                l.cubicTo(18.627419f, 0.0f, 24.0f, 5.3725824f, 24.0f, 12.0f);
                l.lineTo(24.0f, 12.0f);
                l.cubicTo(24.0f, 18.627419f, 18.627419f, 24.0f, 12.0f, 24.0f);
                l.lineTo(12.0f, 24.0f);
                l.cubicTo(5.3725824f, 24.0f, 0.0f, 18.627419f, 0.0f, 12.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-5796769);
                l = c.l(looper);
                l.moveTo(8.897905f, 8.756343f);
                l.lineTo(8.093485f, 8.282515f);
                l.lineTo(7.7207007f, 8.941259f);
                l.cubicTo(6.4518085f, 11.183511f, 6.9088583f, 13.968303f, 8.6956f, 15.557907f);
                l.lineTo(7.811896f, 17.119495f);
                l.lineTo(9.420736f, 18.067152f);
                l.lineTo(10.3044405f, 16.505564f);
                l.lineTo(10.3044405f, 16.505564f);
                l.cubicTo(12.547149f, 17.289433f, 15.139547f, 16.300861f, 16.40844f, 14.05861f);
                l.lineTo(16.781223f, 13.399865f);
                l.lineTo(15.976804f, 12.926036f);
                l.lineTo(15.604019f, 13.584781f);
                l.cubicTo(14.407016f, 15.7f, 11.875845f, 16.439146f, 9.999716f, 15.334046f);
                l.cubicTo(7.966277f, 14.136288f, 7.328117f, 11.530307f, 8.525121f, 9.415088f);
                l.lineTo(8.897905f, 8.756343f);
                l.lineTo(8.897905f, 8.756343f);
                l.lineTo(8.897905f, 8.756343f);
                l.close();
                l.moveTo(7.6466455f, 17.675043f);
                l.cubicTo(7.634969f, 17.550129f, 7.7120023f, 17.499817f, 7.8195677f, 17.563177f);
                l.lineTo(9.04028f, 18.282215f);
                l.cubicTo(9.147459f, 18.345346f, 9.143215f, 18.438997f, 9.031784f, 18.490932f);
                l.lineTo(7.9801126f, 18.98109f);
                l.cubicTo(7.8682413f, 19.033232f, 7.7680407f, 18.973745f, 7.75641f, 18.849323f);
                l.lineTo(7.6466455f, 17.675043f);
                l.close();
                l.moveTo(11.453351f, 6.515008f);
                l.cubicTo(12.2725315f, 5.06744f, 14.091164f, 4.5691423f, 15.512824f, 5.406545f);
                l.cubicTo(16.934797f, 6.2441325f, 17.421965f, 8.097922f, 16.60164f, 9.547512f);
                l.lineTo(14.632907f, 13.026451f);
                l.cubicTo(13.813726f, 14.474019f, 11.995094f, 14.972317f, 10.573434f, 14.134913f);
                l.cubicTo(9.15146f, 13.297326f, 8.664292f, 11.443537f, 9.484617f, 9.993947f);
                l.lineTo(11.453351f, 6.515008f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
