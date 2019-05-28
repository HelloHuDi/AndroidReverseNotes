package com.tencent.p177mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p939a.C45826d;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.model.b */
public final class C28225b {
    LinkedList<String> mVh = new LinkedList();
    LinkedList<C40439f> mVi = new LinkedList();

    public C28225b() {
        AppMethodBeat.m2504i(111189);
        AppMethodBeat.m2505o(111189);
    }

    public final void init(Context context) {
        AppMethodBeat.m2504i(111190);
        if (this.mVi == null) {
            this.mVi = new LinkedList();
        } else {
            this.mVi.clear();
        }
        if (this.mVh == null) {
            this.mVh = new LinkedList();
        } else {
            this.mVh.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        m44815dW(context);
        long currentTimeMillis2 = System.currentTimeMillis();
        bDO();
        long currentTimeMillis3 = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis));
        AppMethodBeat.m2505o(111190);
    }

    /* renamed from: dW */
    private void m44815dW(Context context) {
        AppMethodBeat.m2504i(111191);
        Cursor dhE = C34832a.bYJ().dhE();
        if (dhE == null) {
            C4990ab.m7412e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
            AppMethodBeat.m2505o(111191);
            return;
        }
        if (dhE.moveToFirst()) {
            do {
                C40439f c40439f = new C40439f();
                c40439f.mo8995d(dhE);
                if (C46494g.m87726a(context, c40439f) && !this.mVh.contains(c40439f.field_appId)) {
                    C4990ab.m7417i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", c40439f.field_appName, c40439f.field_appId);
                    this.mVi.add(c40439f);
                    this.mVh.add(c40439f.field_appId);
                }
            } while (dhE.moveToNext());
        }
        dhE.close();
        AppMethodBeat.m2505o(111191);
    }

    public final void clearCache() {
        AppMethodBeat.m2504i(111193);
        C4990ab.m7416i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
        if (this.mVi != null) {
            this.mVi.clear();
        }
        if (this.mVh != null) {
            this.mVh.clear();
        }
        AppMethodBeat.m2505o(111193);
    }

    private void bDO() {
        AppMethodBeat.m2504i(111192);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = ((C45826d) C1720g.m3528K(C45826d.class)).mo7017XS().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
        if (rawQuery == null) {
            List list = arrayList;
        } else {
            while (rawQuery.moveToNext()) {
                C42911a c42911a = new C42911a();
                c42911a.mo8995d(rawQuery);
                if (!C5046bo.isNullOrNil(c42911a.field_appId) && c42911a.field_appId.startsWith("wx") && c42911a.field_status == 3 && C5730e.m8628ct(c42911a.field_filePath) && !arrayList.contains(c42911a.field_appId)) {
                    arrayList.add(c42911a.field_appId);
                }
            }
            rawQuery.close();
            Object list2 = arrayList;
        }
        if (!list2.isEmpty()) {
            for (String str : list2) {
                if (!(C5046bo.isNullOrNil(str) || this.mVh.contains(str))) {
                    C40439f bT = C46494g.m87739bT(str, false);
                    if (!(bT == null || this.mVi.contains(bT))) {
                        this.mVi.add(bT);
                        this.mVh.add(str);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(111192);
    }
}
