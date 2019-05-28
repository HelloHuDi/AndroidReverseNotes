package com.tencent.mm.wallet_core.d;

import android.content.Intent;
import com.tencent.mm.ai.m;
import com.tencent.mm.ui.MMActivity;

public abstract class g {
    public i Agm;
    public MMActivity hwd;

    public abstract boolean c(int i, int i2, String str, m mVar);

    public abstract boolean p(Object... objArr);

    public g(MMActivity mMActivity, i iVar) {
        this.hwd = mMActivity;
        this.Agm = iVar;
    }

    public CharSequence Au(int i) {
        return null;
    }

    public boolean w(Object... objArr) {
        return false;
    }

    public boolean x(Object... objArr) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }
}
