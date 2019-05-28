package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.p1026a.C39764c;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.a */
public final class C21940a extends View {
    private C39764c qYw;

    public C21940a(Context context, C39764c c39764c) {
        super(context);
        this.qYw = c39764c;
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(36964);
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int min = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        width = (int) (((float) width) / 2.0f);
        height = (int) (((float) height) / 2.0f);
        Bitmap bitmap = this.qYw.qYe;
        if (bitmap != null) {
            min = (int) (((float) (min * 2)) + (this.qYw.qYf * 2.0f));
            int width2 = (bitmap.getWidth() * min) / bitmap.getHeight();
            canvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, width2, min, false), (float) (width - (width2 >>> 1)), (float) (height - (min >>> 1)), null);
        }
        AppMethodBeat.m2505o(36964);
    }
}
