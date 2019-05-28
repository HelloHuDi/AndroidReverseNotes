package com.tencent.p177mm.p612ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.t */
public abstract class C24020t implements OnMenuItemClickListener {
    private long qBy = -1;

    /* renamed from: Kp */
    public abstract void mo39830Kp();

    public boolean onMenuItemClick(MenuItem menuItem) {
        C4990ab.m7416i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
        if (this.qBy != -1) {
            if ((System.nanoTime() - this.qBy) / 1000000 < 500) {
                C4990ab.m7417i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", Long.valueOf((System.nanoTime() - this.qBy) / 1000000), Long.valueOf(500));
                return false;
            }
        }
        this.qBy = System.nanoTime();
        mo39830Kp();
        return false;
    }
}
