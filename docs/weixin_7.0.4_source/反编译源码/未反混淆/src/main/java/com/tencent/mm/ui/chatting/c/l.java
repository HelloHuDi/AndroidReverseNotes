package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.k;
import java.util.HashSet;
import java.util.Iterator;

public final class l extends k implements com.tencent.mm.ui.chatting.c.b.k {
    private HashSet<k> xHH = new HashSet();

    public l() {
        AppMethodBeat.i(31366);
        AppMethodBeat.o(31366);
    }

    public final void a(k kVar) {
        AppMethodBeat.i(31367);
        if (!this.xHH.contains(kVar)) {
            this.xHH.add(kVar);
        }
        AppMethodBeat.o(31367);
    }

    public final void b(k kVar) {
        AppMethodBeat.i(31368);
        this.xHH.remove(kVar);
        AppMethodBeat.o(31368);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31369);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((k) it.next()).onActivityResult(i, i2, intent);
        }
        AppMethodBeat.o(31369);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(31370);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            if (((k) it.next()).onKeyDown(i, keyEvent)) {
                AppMethodBeat.o(31370);
                return true;
            }
        }
        AppMethodBeat.o(31370);
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(31371);
        super.onRequestPermissionsResult(i, strArr, iArr);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((k) it.next()).onRequestPermissionsResult(i, strArr, iArr);
        }
        AppMethodBeat.o(31371);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(31372);
        super.onConfigurationChanged(configuration);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((k) it.next()).onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(31372);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(31373);
        super.onScroll(absListView, i, i2, i3);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((k) it.next()).onScroll(absListView, i, i2, i3);
        }
        AppMethodBeat.o(31373);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(31374);
        super.onScrollStateChanged(absListView, i);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((k) it.next()).onScrollStateChanged(absListView, i);
        }
        AppMethodBeat.o(31374);
    }
}
