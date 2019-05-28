package com.tencent.mm.plugin.messenger.a;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class a extends n {
    private long opR = -1;

    public abstract void onClickImp(View view);

    public a() {
        super(1, null);
    }

    public void onClick(View view) {
        if (bo.az(this.opR) > 1000) {
            super.onClick(view);
            onClickImp(view);
        } else {
            ab.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
            this.ozq = false;
        }
        this.opR = bo.yz();
    }
}
