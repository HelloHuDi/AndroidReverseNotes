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

public final class afj extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                k2 = c.a(k, looper);
                k2.setColor(-7822636);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(34.407272f, 0.0f);
                l.lineTo(37.44f, 0.0f);
                l.cubicTo(46.914547f, 0.39818183f, 56.16f, 4.6472726f, 62.53636f, 11.683637f);
                l.cubicTo(68.23637f, 17.83091f, 71.56364f, 26.01818f, 72.0f, 34.374546f);
                l.lineTo(72.0f, 37.47818f);
                l.cubicTo(71.59637f, 46.407272f, 67.821815f, 55.145454f, 61.46182f, 61.44f);
                l.cubicTo(55.205456f, 67.78364f, 46.52182f, 71.55273f, 37.636364f, 72.0f);
                l.lineTo(34.52182f, 72.0f);
                l.cubicTo(25.052727f, 71.59091f, 15.818182f, 67.34182f, 9.458181f, 60.305454f);
                l.cubicTo(3.769091f, 54.174545f, 0.44727272f, 45.99818f, 0.0f, 37.663635f);
                l.lineTo(0.0f, 34.36909f);
                l.cubicTo(0.43636364f, 26.012728f, 3.769091f, 17.82f, 9.4745455f, 11.678182f);
                l.cubicTo(15.812727f, 4.6745453f, 24.992727f, 0.45818183f, 34.407272f, 0.0f);
                l.lineTo(34.407272f, 0.0f);
                l.close();
                l.moveTo(23.52f, 24.12f);
                l.cubicTo(21.58909f, 24.714546f, 21.212727f, 27.032728f, 22.052727f, 28.663637f);
                l.cubicTo(21.316364f, 29.350908f, 20.356363f, 30.021818f, 20.307272f, 31.134546f);
                l.cubicTo(20.116364f, 32.165455f, 20.83091f, 33.01091f, 21.256363f, 33.872726f);
                l.cubicTo(20.389091f, 34.723637f, 19.374546f, 35.727272f, 19.66909f, 37.074547f);
                l.cubicTo(19.75091f, 38.274544f, 20.792727f, 38.945454f, 21.703636f, 39.534546f);
                l.cubicTo(21.065454f, 40.265453f, 20.209091f, 40.96909f, 20.192728f, 42.02727f);
                l.cubicTo(19.99091f, 43.805454f, 21.632727f, 45.414547f, 23.4f, 45.256363f);
                l.cubicTo(27.196363f, 45.31091f, 30.987272f, 45.250908f, 34.783638f, 45.267273f);
                l.cubicTo(33.9f, 48.665455f, 34.03636f, 52.26f, 34.914547f, 55.64182f);
                l.cubicTo(35.258183f, 57.556362f, 37.36909f, 58.98f, 39.256363f, 58.625454f);
                l.cubicTo(40.2f, 58.18909f, 40.063637f, 57.04909f, 40.06909f, 56.203636f);
                l.cubicTo(39.872726f, 53.14909f, 40.14f, 49.925453f, 41.78182f, 47.263638f);
                l.cubicTo(43.18909f, 45.12f, 45.305454f, 42.965454f, 48.054546f, 42.987274f);
                l.cubicTo(49.085453f, 42.703636f, 50.61273f, 43.085453f, 51.174545f, 41.934544f);
                l.cubicTo(51.42f, 38.514545f, 51.196365f, 35.078182f, 51.272728f, 31.652727f);
                l.cubicTo(51.201817f, 29.803637f, 51.572727f, 27.867273f, 50.836365f, 26.110909f);
                l.cubicTo(45.894547f, 26.82f, 41.84182f, 23.209091f, 37.06909f, 22.827272f);
                l.cubicTo(32.541817f, 22.347273f, 27.856363f, 22.690908f, 23.52f, 24.12f);
                l.lineTo(23.52f, 24.12f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                float[] a2 = c.a(g, 1.0f, 0.0f, 19.090908f, 0.0f, 1.0f, 22.363636f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(4.429091f, 1.7563636f);
                l.cubicTo(8.765454f, 0.3272727f, 13.450909f, -0.016363636f, 17.978182f, 0.46363637f);
                l.cubicTo(22.75091f, 0.8454546f, 26.803637f, 4.4563637f, 31.745455f, 3.7472727f);
                l.cubicTo(32.48182f, 5.5036364f, 32.11091f, 7.44f, 32.18182f, 9.289091f);
                l.cubicTo(32.105453f, 12.714545f, 32.32909f, 16.15091f, 32.083637f, 19.57091f);
                l.cubicTo(31.521818f, 20.721819f, 29.994545f, 20.34f, 28.963636f, 20.623636f);
                l.cubicTo(26.214546f, 20.601818f, 24.098183f, 22.756363f, 22.690908f, 24.9f);
                l.cubicTo(21.049091f, 27.56182f, 20.781818f, 30.785454f, 20.978182f, 33.84f);
                l.cubicTo(20.972727f, 34.685455f, 21.10909f, 35.825455f, 20.165455f, 36.261818f);
                l.cubicTo(18.278181f, 36.616364f, 16.167273f, 35.192726f, 15.823636f, 33.278183f);
                l.cubicTo(14.945455f, 29.896364f, 14.809091f, 26.301819f, 15.692727f, 22.903637f);
                l.cubicTo(11.896363f, 22.887272f, 8.105454f, 22.947273f, 4.309091f, 22.892727f);
                l.cubicTo(2.5418181f, 23.050909f, 0.9f, 21.441818f, 1.1018182f, 19.663637f);
                l.cubicTo(1.1181818f, 18.605455f, 1.9745455f, 17.901817f, 2.6127272f, 17.17091f);
                l.cubicTo(1.7018182f, 16.581818f, 0.66f, 15.910909f, 0.5781818f, 14.710909f);
                l.cubicTo(0.28363636f, 13.363636f, 1.2981818f, 12.36f, 2.1654546f, 11.50909f);
                l.cubicTo(1.74f, 10.647273f, 1.0254545f, 9.801818f, 1.2163637f, 8.770909f);
                l.cubicTo(1.2654545f, 7.6581817f, 2.2254546f, 6.9872727f, 2.9618182f, 6.3f);
                l.cubicTo(2.121818f, 4.6690907f, 2.4981818f, 2.350909f, 4.429091f, 1.7563636f);
                l.lineTo(4.429091f, 1.7563636f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
