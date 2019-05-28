package com.tencent.p177mm.plugin.messenger.p993a;

import android.view.View;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23322n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.messenger.a.a */
public abstract class C34529a extends C23322n {
    private long opR = -1;

    public abstract void onClickImp(View view);

    public C34529a() {
        super(1, null);
    }

    public void onClick(View view) {
        if (C5046bo.m7525az(this.opR) > 1000) {
            super.onClick(view);
            onClickImp(view);
        } else {
            C4990ab.m7420w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
            this.ozq = false;
        }
        this.opR = C5046bo.m7588yz();
    }
}
