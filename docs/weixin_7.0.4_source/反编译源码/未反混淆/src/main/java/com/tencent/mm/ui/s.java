package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class s implements OnClickListener {
    private long qBy = -1;

    public abstract void bgW();

    public void onClick(View view) {
        ab.i("MicroMsg.MMCustomClickListener", "button onclick");
        if (this.qBy != -1) {
            if ((System.nanoTime() - this.qBy) / 1000000 < 3000) {
                ab.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", Long.valueOf((System.nanoTime() - this.qBy) / 1000000), Long.valueOf(3000));
                return;
            }
        }
        this.qBy = System.nanoTime();
        bgW();
    }
}
