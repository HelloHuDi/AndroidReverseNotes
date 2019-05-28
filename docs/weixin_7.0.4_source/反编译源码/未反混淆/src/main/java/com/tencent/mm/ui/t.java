package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class t implements OnMenuItemClickListener {
    private long qBy = -1;

    public abstract void Kp();

    public boolean onMenuItemClick(MenuItem menuItem) {
        ab.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
        if (this.qBy != -1) {
            if ((System.nanoTime() - this.qBy) / 1000000 < 500) {
                ab.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", Long.valueOf((System.nanoTime() - this.qBy) / 1000000), Long.valueOf(500));
                return false;
            }
        }
        this.qBy = System.nanoTime();
        Kp();
        return false;
    }
}
