package com.tencent.p177mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.memory.p1205b.C18602a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.model.ai */
public final class C34954ai extends C18602a {
    int alpha = 255;
    long mSd;
    boolean mSe = false;
    private Map<String, Boolean> qMq = new HashMap();

    public C34954ai(String str, C45434n c45434n, long j) {
        super(str, c45434n);
        AppMethodBeat.m2504i(36535);
        if (j != 0) {
            this.mSd = j;
            this.qMq.put(str, Boolean.TRUE);
            this.mSe = true;
            AppMethodBeat.m2505o(36535);
            return;
        }
        if (!this.qMq.containsKey(str)) {
            this.mSd = SystemClock.uptimeMillis();
            this.qMq.put(str, Boolean.TRUE);
            this.mSe = true;
        }
        AppMethodBeat.m2505o(36535);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(36536);
        Rect bounds = getBounds();
        Bitmap Xi = this.feQ.mo73230Xi();
        if (C29036i.m46072B(Xi)) {
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
                    AppMethodBeat.m2505o(36536);
                    return;
                }
            }
            this.feO.setAlpha(this.alpha);
            canvas.drawBitmap(Xi, null, bounds, this.feO);
            AppMethodBeat.m2505o(36536);
            return;
        }
        canvas.drawColor(-1118482);
        this.mSd = 0;
        AppMethodBeat.m2505o(36536);
    }
}
