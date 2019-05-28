package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b extends k {
    public List<Fragment> rdA = new ArrayList();

    public b(i iVar, List<Fragment> list) {
        super(iVar);
        AppMethodBeat.i(37650);
        this.rdA = list;
        AppMethodBeat.o(37650);
    }

    public final Fragment getItem(int i) {
        AppMethodBeat.i(37651);
        Fragment fragment = (Fragment) this.rdA.get(i);
        AppMethodBeat.o(37651);
        return fragment;
    }

    public final int getCount() {
        AppMethodBeat.i(37652);
        int size = this.rdA.size();
        AppMethodBeat.o(37652);
        return size;
    }

    public final CharSequence getPageTitle(int i) {
        return "";
    }

    public final void a(Fragment fragment, int i) {
        AppMethodBeat.i(37653);
        this.rdA.remove(fragment);
        if (i >= this.rdA.size()) {
            this.rdA.add(fragment);
            AppMethodBeat.o(37653);
            return;
        }
        this.rdA.add(i, fragment);
        AppMethodBeat.o(37653);
    }
}
