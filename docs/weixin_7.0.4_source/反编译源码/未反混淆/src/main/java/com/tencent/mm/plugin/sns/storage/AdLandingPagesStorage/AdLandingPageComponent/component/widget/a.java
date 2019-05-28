package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public abstract class a extends h {
    public abstract void cps();

    public abstract List<h> cpt();

    public a(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
    }

    public final boolean cpx() {
        ab.i("MicroMsg.AdLandingPageContainerComponent", "inScreenHeight %d", Integer.valueOf(cpw()));
        if (cpw() > 0) {
            return true;
        }
        return false;
    }
}
