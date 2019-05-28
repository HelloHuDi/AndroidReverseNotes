package com.tencent.p177mm.p612ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.s */
public abstract class C24019s implements OnClickListener {
    private long qBy = -1;

    public abstract void bgW();

    public void onClick(View view) {
        C4990ab.m7416i("MicroMsg.MMCustomClickListener", "button onclick");
        if (this.qBy != -1) {
            if ((System.nanoTime() - this.qBy) / 1000000 < 3000) {
                C4990ab.m7417i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", Long.valueOf((System.nanoTime() - this.qBy) / 1000000), Long.valueOf(3000));
                return;
            }
        }
        this.qBy = System.nanoTime();
        bgW();
    }
}
