package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class l {
    protected Map<Integer, a> mUk = new HashMap();
    protected List<m> ukU = new LinkedList();

    public l() {
        AppMethodBeat.i(6446);
        bDs();
        bDt();
        AppMethodBeat.o(6446);
    }

    /* Access modifiers changed, original: protected */
    public void bDs() {
        AppMethodBeat.i(6447);
        a(new f());
        a(new j());
        a(new k());
        a(new g());
        a(new d());
        a(new b());
        a(new c());
        a(new e());
        a(new h());
        a(new i());
        AppMethodBeat.o(6447);
    }

    private void a(a aVar) {
        AppMethodBeat.i(6448);
        this.mUk.put(Integer.valueOf(aVar.id), aVar);
        AppMethodBeat.o(6448);
    }

    /* Access modifiers changed, original: protected */
    public void bDt() {
        AppMethodBeat.i(6449);
        this.ukU = new LinkedList();
        h(35, "menuItem:minimize", true);
        h(1, "menuItem:share:appMessage", false);
        h(2, "menuItem:share:timeline", false);
        MainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 3;
        AppBrandMainProcessService.b(favUrlTask);
        if (favUrlTask.uhK) {
            h(3, "menuItem:favorite", false);
            h(12, "menuItem:editTag", false);
        }
        h(31, "menuItem:search", true);
        h(6, "menuItem:copyUrl", false);
        h(7, "menuItem:openWithSafari", false);
        h(27, "menuItem:finish", true);
        h(28, "menuItem:refresh", true);
        AppMethodBeat.o(6449);
    }

    private void h(int i, String str, boolean z) {
        AppMethodBeat.i(6450);
        this.ukU.add(new m(i, str, z));
        AppMethodBeat.o(6450);
    }

    public final void b(Context context, d dVar, com.tencent.mm.ui.base.l lVar) {
        AppMethodBeat.i(6451);
        for (m mVar : this.ukU) {
            if (!mVar.imK) {
                a aVar = (a) this.mUk.get(Integer.valueOf(mVar.id));
                if (aVar != null) {
                    aVar.a(context, dVar, lVar);
                }
            }
        }
        AppMethodBeat.o(6451);
    }

    public final void a(Context context, d dVar, MenuItem menuItem) {
        AppMethodBeat.i(6452);
        if (menuItem == null) {
            AppMethodBeat.o(6452);
            return;
        }
        int itemId = menuItem.getItemId();
        for (m mVar : this.ukU) {
            if (mVar != null && mVar.id == itemId) {
                break;
            }
        }
        m mVar2 = null;
        a aVar = (a) this.mUk.get(Integer.valueOf(mVar2.id));
        if (aVar == null) {
            AppMethodBeat.o(6452);
            return;
        }
        aVar.a(context, dVar);
        AppMethodBeat.o(6452);
    }

    public final void cXc() {
        AppMethodBeat.i(6453);
        for (m mVar : this.ukU) {
            if (!mVar.ukV) {
                mVar.imK = true;
            }
        }
        AppMethodBeat.o(6453);
    }

    public final void cXd() {
        AppMethodBeat.i(6454);
        for (m mVar : this.ukU) {
            if (!mVar.ukV) {
                mVar.imK = false;
            }
        }
        AppMethodBeat.o(6454);
    }

    public final void aeg(String str) {
        AppMethodBeat.i(6455);
        for (m mVar : this.ukU) {
            if (mVar.name.equals(str)) {
                if (!mVar.ukV) {
                    mVar.imK = true;
                    AppMethodBeat.o(6455);
                    return;
                }
                AppMethodBeat.o(6455);
            }
        }
        AppMethodBeat.o(6455);
    }

    public final void aeh(String str) {
        AppMethodBeat.i(6456);
        for (m mVar : this.ukU) {
            if (mVar.name.equals(str)) {
                mVar.imK = false;
                AppMethodBeat.o(6456);
                return;
            }
        }
        AppMethodBeat.o(6456);
    }
}
