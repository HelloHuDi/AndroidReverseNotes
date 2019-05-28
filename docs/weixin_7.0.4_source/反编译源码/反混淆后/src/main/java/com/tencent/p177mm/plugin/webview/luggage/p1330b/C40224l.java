package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.FavUrlTask;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.l */
public class C40224l {
    protected Map<Integer, C43884a> mUk = new HashMap();
    protected List<C46416m> ukU = new LinkedList();

    public C40224l() {
        AppMethodBeat.m2504i(6446);
        bDs();
        bDt();
        AppMethodBeat.m2505o(6446);
    }

    /* Access modifiers changed, original: protected */
    public void bDs() {
        AppMethodBeat.m2504i(6447);
        m68993a(new C29779f());
        m68993a(new C46415j());
        m68993a(new C44785k());
        m68993a(new C22814g());
        m68993a(new C44784d());
        m68993a(new C44782b());
        m68993a(new C44783c());
        m68993a(new C22813e());
        m68993a(new C29780h());
        m68993a(new C40223i());
        AppMethodBeat.m2505o(6447);
    }

    /* renamed from: a */
    private void m68993a(C43884a c43884a) {
        AppMethodBeat.m2504i(6448);
        this.mUk.put(Integer.valueOf(c43884a.f17231id), c43884a);
        AppMethodBeat.m2505o(6448);
    }

    /* Access modifiers changed, original: protected */
    public void bDt() {
        AppMethodBeat.m2504i(6449);
        this.ukU = new LinkedList();
        m68994h(35, "menuItem:minimize", true);
        m68994h(1, "menuItem:share:appMessage", false);
        m68994h(2, "menuItem:share:timeline", false);
        MainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 3;
        AppBrandMainProcessService.m54355b(favUrlTask);
        if (favUrlTask.uhK) {
            m68994h(3, "menuItem:favorite", false);
            m68994h(12, "menuItem:editTag", false);
        }
        m68994h(31, "menuItem:search", true);
        m68994h(6, "menuItem:copyUrl", false);
        m68994h(7, "menuItem:openWithSafari", false);
        m68994h(27, "menuItem:finish", true);
        m68994h(28, "menuItem:refresh", true);
        AppMethodBeat.m2505o(6449);
    }

    /* renamed from: h */
    private void m68994h(int i, String str, boolean z) {
        AppMethodBeat.m2504i(6450);
        this.ukU.add(new C46416m(i, str, z));
        AppMethodBeat.m2505o(6450);
    }

    /* renamed from: b */
    public final void mo63578b(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6451);
        for (C46416m c46416m : this.ukU) {
            if (!c46416m.imK) {
                C43884a c43884a = (C43884a) this.mUk.get(Integer.valueOf(c46416m.f17910id));
                if (c43884a != null) {
                    c43884a.mo38418a(context, c24905d, c44273l);
                }
            }
        }
        AppMethodBeat.m2505o(6451);
    }

    /* renamed from: a */
    public final void mo63575a(Context context, C24905d c24905d, MenuItem menuItem) {
        AppMethodBeat.m2504i(6452);
        if (menuItem == null) {
            AppMethodBeat.m2505o(6452);
            return;
        }
        int itemId = menuItem.getItemId();
        for (C46416m c46416m : this.ukU) {
            if (c46416m != null && c46416m.f17910id == itemId) {
                break;
            }
        }
        C46416m c46416m2 = null;
        C43884a c43884a = (C43884a) this.mUk.get(Integer.valueOf(c46416m2.f17910id));
        if (c43884a == null) {
            AppMethodBeat.m2505o(6452);
            return;
        }
        c43884a.mo38417a(context, c24905d);
        AppMethodBeat.m2505o(6452);
    }

    public final void cXc() {
        AppMethodBeat.m2504i(6453);
        for (C46416m c46416m : this.ukU) {
            if (!c46416m.ukV) {
                c46416m.imK = true;
            }
        }
        AppMethodBeat.m2505o(6453);
    }

    public final void cXd() {
        AppMethodBeat.m2504i(6454);
        for (C46416m c46416m : this.ukU) {
            if (!c46416m.ukV) {
                c46416m.imK = false;
            }
        }
        AppMethodBeat.m2505o(6454);
    }

    public final void aeg(String str) {
        AppMethodBeat.m2504i(6455);
        for (C46416m c46416m : this.ukU) {
            if (c46416m.name.equals(str)) {
                if (!c46416m.ukV) {
                    c46416m.imK = true;
                    AppMethodBeat.m2505o(6455);
                    return;
                }
                AppMethodBeat.m2505o(6455);
            }
        }
        AppMethodBeat.m2505o(6455);
    }

    public final void aeh(String str) {
        AppMethodBeat.m2504i(6456);
        for (C46416m c46416m : this.ukU) {
            if (c46416m.name.equals(str)) {
                c46416m.imK = false;
                AppMethodBeat.m2505o(6456);
                return;
            }
        }
        AppMethodBeat.m2505o(6456);
    }
}
