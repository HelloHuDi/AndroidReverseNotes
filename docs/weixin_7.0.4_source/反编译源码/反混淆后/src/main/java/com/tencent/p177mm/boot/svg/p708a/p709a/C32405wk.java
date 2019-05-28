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

/* renamed from: com.tencent.mm.boot.svg.a.a.wk */
public final class C32405wk extends C5163c {
    private final int height = 36;
    private final int width = 33;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 33;
            case 1:
                return 36;
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
                k.setColor(-4547478);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(30.0f, 12.851442f);
                l.lineTo(30.0f, 33.0f);
                l.lineTo(3.0f, 33.0f);
                l.lineTo(3.0f, 13.013662f);
                l.cubicTo(5.0812554f, 14.928909f, 9.102742f, 16.658638f, 10.767557f, 17.279522f);
                l.cubicTo(10.767557f, 16.999113f, 10.605591f, 15.996458f, 10.828888f, 14.5339985f);
                l.cubicTo(6.8218164f, 12.432947f, 3.0067377f, 8.4492855f, 3.0172813f, 5.8101797f);
                l.cubicTo(3.016516f, 5.641232f, 3.0105f, 5.515129f, 3.0f, 5.427509f);
                l.lineTo(3.0f, 3.0f);
                l.lineTo(30.0f, 3.0f);
                l.lineTo(30.0f, 5.425335f);
                l.cubicTo(29.998358f, 5.479269f, 29.997364f, 5.5399776f, 29.997057f, 5.6077538f);
                l.cubicTo(30.007599f, 8.24686f, 26.007072f, 12.432947f, 22.0f, 14.5339985f);
                l.cubicTo(22.223297f, 15.996458f, 22.06133f, 16.999113f, 22.06133f, 17.279522f);
                l.cubicTo(23.773027f, 16.641155f, 27.97599f, 14.830612f, 30.0f, 12.851442f);
                l.close();
                l.moveTo(0.0f, 3.0074198f);
                l.cubicTo(0.0f, 1.3464677f, 1.3345109f, 0.0f, 3.0013576f, 0.0f);
                l.lineTo(29.998642f, 0.0f);
                l.cubicTo(31.656246f, 0.0f, 33.0f, 1.3455393f, 33.0f, 3.0074198f);
                l.lineTo(33.0f, 32.99258f);
                l.cubicTo(33.0f, 34.653534f, 31.66549f, 36.0f, 29.998642f, 36.0f);
                l.lineTo(3.0013576f, 36.0f);
                l.cubicTo(1.3437536f, 36.0f, 0.0f, 34.65446f, 0.0f, 32.99258f);
                l.lineTo(0.0f, 3.0074198f);
                l.close();
                l.moveTo(16.5f, 21.014084f);
                l.cubicTo(18.985281f, 21.014084f, 21.0f, 18.996214f, 21.0f, 16.507042f);
                l.cubicTo(21.0f, 14.017872f, 18.985281f, 12.0f, 16.5f, 12.0f);
                l.cubicTo(14.014719f, 12.0f, 12.0f, 14.017872f, 12.0f, 16.507042f);
                l.cubicTo(12.0f, 18.996214f, 14.014719f, 21.014084f, 16.5f, 21.014084f);
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
