package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import java.util.HashMap;
import java.util.Map;

public final class ai extends a {
    int alpha = 255;
    long mSd;
    boolean mSe = false;
    private Map<String, Boolean> qMq = new HashMap();

    public ai(String str, n nVar, long j) {
        super(str, nVar);
        AppMethodBeat.i(36535);
        if (j != 0) {
            this.mSd = j;
            this.qMq.put(str, Boolean.TRUE);
            this.mSe = true;
            AppMethodBeat.o(36535);
            return;
        }
        if (!this.qMq.containsKey(str)) {
            this.mSd = SystemClock.uptimeMillis();
            this.qMq.put(str, Boolean.TRUE);
            this.mSe = true;
        }
        AppMethodBeat.o(36535);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(36536);
        Rect bounds = getBounds();
        Bitmap Xi = this.feQ.Xi();
        if (i.B(Xi)) {
            if (this.mSe) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mSd)) / 150.0f;
                if (this.mSd == 0) {
                    uptimeMillis = 0.0f;
                }
                if (uptimeMillis >= 1.0f) {
                    this.mSe = false;
                } else {
                    this.feO.setAlpha((int) (uptimeMillis * ((float) this.alpha)));
                    canvas.drawBitmap(Xi, null, bounds, this.feO);
                    invalidateSelf();
                    AppMethodBeat.o(36536);
                    return;
                }
            }
            this.feO.setAlpha(this.alpha);
            canvas.drawBitmap(Xi, null, bounds, this.feO);
            AppMethodBeat.o(36536);
            return;
        }
        canvas.drawColor(-1118482);
        this.mSd = 0;
        AppMethodBeat.o(36536);
    }
}
