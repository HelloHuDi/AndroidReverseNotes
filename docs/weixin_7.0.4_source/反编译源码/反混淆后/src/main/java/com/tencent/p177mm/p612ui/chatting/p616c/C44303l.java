package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C15911k;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40724k;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.chatting.c.l */
public final class C44303l extends C15911k implements C40724k {
    private HashSet<C15911k> xHH = new HashSet();

    public C44303l() {
        AppMethodBeat.m2504i(31366);
        AppMethodBeat.m2505o(31366);
    }

    /* renamed from: a */
    public final void mo64240a(C15911k c15911k) {
        AppMethodBeat.m2504i(31367);
        if (!this.xHH.contains(c15911k)) {
            this.xHH.add(c15911k);
        }
        AppMethodBeat.m2505o(31367);
    }

    /* renamed from: b */
    public final void mo64241b(C15911k c15911k) {
        AppMethodBeat.m2504i(31368);
        this.xHH.remove(c15911k);
        AppMethodBeat.m2505o(31368);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31369);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((C15911k) it.next()).onActivityResult(i, i2, intent);
        }
        AppMethodBeat.m2505o(31369);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(31370);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            if (((C15911k) it.next()).onKeyDown(i, keyEvent)) {
                AppMethodBeat.m2505o(31370);
                return true;
            }
        }
        AppMethodBeat.m2505o(31370);
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(31371);
        super.onRequestPermissionsResult(i, strArr, iArr);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((C15911k) it.next()).onRequestPermissionsResult(i, strArr, iArr);
        }
        AppMethodBeat.m2505o(31371);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(31372);
        super.onConfigurationChanged(configuration);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((C15911k) it.next()).onConfigurationChanged(configuration);
        }
        AppMethodBeat.m2505o(31372);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(31373);
        super.onScroll(absListView, i, i2, i3);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((C15911k) it.next()).onScroll(absListView, i, i2, i3);
        }
        AppMethodBeat.m2505o(31373);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(31374);
        super.onScrollStateChanged(absListView, i);
        Iterator it = this.xHH.iterator();
        while (it.hasNext()) {
            ((C15911k) it.next()).onScrollStateChanged(absListView, i);
        }
        AppMethodBeat.m2505o(31374);
    }
}
