package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.C31856k;
import android.support.p057v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b */
public final class C29082b extends C31856k {
    public List<Fragment> rdA = new ArrayList();

    public C29082b(C0336i c0336i, List<Fragment> list) {
        super(c0336i);
        AppMethodBeat.m2504i(37650);
        this.rdA = list;
        AppMethodBeat.m2505o(37650);
    }

    public final Fragment getItem(int i) {
        AppMethodBeat.m2504i(37651);
        Fragment fragment = (Fragment) this.rdA.get(i);
        AppMethodBeat.m2505o(37651);
        return fragment;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(37652);
        int size = this.rdA.size();
        AppMethodBeat.m2505o(37652);
        return size;
    }

    public final CharSequence getPageTitle(int i) {
        return "";
    }

    /* renamed from: a */
    public final void mo47193a(Fragment fragment, int i) {
        AppMethodBeat.m2504i(37653);
        this.rdA.remove(fragment);
        if (i >= this.rdA.size()) {
            this.rdA.add(fragment);
            AppMethodBeat.m2505o(37653);
            return;
        }
        this.rdA.add(i, fragment);
        AppMethodBeat.m2505o(37653);
    }
}
