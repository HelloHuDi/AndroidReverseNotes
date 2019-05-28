package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C13437h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a */
public abstract class C3910a extends C13437h {
    public abstract void cps();

    public abstract List<C13437h> cpt();

    public C3910a(Context context, C29086r c29086r, ViewGroup viewGroup) {
        super(context, c29086r, viewGroup);
    }

    public final boolean cpx() {
        C4990ab.m7417i("MicroMsg.AdLandingPageContainerComponent", "inScreenHeight %d", Integer.valueOf(cpw()));
        if (cpw() > 0) {
            return true;
        }
        return false;
    }
}
