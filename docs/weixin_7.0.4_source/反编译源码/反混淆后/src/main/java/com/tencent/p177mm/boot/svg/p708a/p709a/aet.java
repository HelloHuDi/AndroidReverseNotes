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

/* renamed from: com.tencent.mm.boot.svg.a.a.aet */
public final class aet extends C5163c {
    private final int height = 1334;
    private final int width = 750;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 750;
            case 1:
                return 1334;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-870400);
                canvas.save();
                k2 = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(750.0f, 0.0f);
                l.lineTo(750.0f, 1334.0f);
                l.lineTo(0.0f, 1334.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-877312);
                l = C5163c.m7884l(looper);
                l.moveTo(68.52344f, 1334.0f);
                l.lineTo(849.0469f, 377.4297f);
                l.lineTo(5.891446E-14f, 199.80469f);
                l.lineTo(0.0f, 1334.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.saveLayerAlpha(null, 69, 4);
                k2 = C5163c.m7876a(k2, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-748799);
                l = C5163c.m7884l(looper);
                l.moveTo(801.0469f, 102.0f);
                l.lineTo(-62.109375f, 375.08594f);
                l.lineTo(-62.109375f, 657.77344f);
                l.lineTo(785.65625f, 1323.5469f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.saveLayerAlpha(null, 39, 4);
                k2 = C5163c.m7876a(k2, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                k = C5163c.m7876a(k, looper);
                k.setColor(-25344);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(-88.0f, 1217.8438f);
                l2.lineTo(903.0781f, 1441.7344f);
                l2.lineTo(855.39844f, 671.83594f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.saveLayerAlpha(null, 103, 4);
                k = C5163c.m7876a(k, looper);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
