package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.j */
public final class C12254j extends C7563j<C46039i> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46039i.ccO, "IPCallPopularCountry")};
    private C4927e bSd;
    public C7298n gvC = new C122551();

    /* renamed from: com.tencent.mm.plugin.ipcall.a.g.j$1 */
    class C122551 extends C7298n {
        C122551() {
        }

        public final boolean apK() {
            AppMethodBeat.m2504i(21937);
            if (C12254j.this.bSd == null || C12254j.this.bSd.dpU()) {
                String str = "MicroMsg.IPCallPopularCountryStorage";
                String str2 = "shouldProcessEvent db is close :%s";
                Object[] objArr = new Object[1];
                objArr[0] = C12254j.this.bSd == null ? BuildConfig.COMMAND : Boolean.valueOf(C12254j.this.bSd.dpU());
                C4990ab.m7421w(str, str2, objArr);
                AppMethodBeat.m2505o(21937);
                return false;
            }
            AppMethodBeat.m2505o(21937);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(21941);
        AppMethodBeat.m2505o(21941);
    }

    public C12254j(C4927e c4927e) {
        super(c4927e, C46039i.ccO, "IPCallPopularCountry", null);
        AppMethodBeat.m2504i(21938);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(21938);
    }

    public final String getTableName() {
        return "IPCallPopularCountry";
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* renamed from: O */
    public final void mo24093O(int i, long j) {
        boolean a;
        AppMethodBeat.m2504i(21939);
        C46039i c46039i = new C46039i();
        Cursor a2 = this.bSd.mo10105a("IPCallPopularCountry", null, "countryCode=?", new String[]{Integer.toString(i)}, null, null, null, 2);
        if (a2.moveToFirst()) {
            c46039i.mo8995d(a2);
            c46039i.field_callTimeCount++;
            c46039i.field_lastCallTime = j;
            a = super.mo10099a(c46039i);
            a2.close();
        } else {
            C4990ab.m7416i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:".concat(String.valueOf(i)));
            a2.close();
            c46039i.field_countryCode = i;
            c46039i.field_lastCallTime = j;
            c46039i.field_callTimeCount = 1;
            a = mo10101b((C4925c) c46039i);
        }
        C4990ab.m7416i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:".concat(String.valueOf(a)));
        AppMethodBeat.m2505o(21939);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<Integer> bIa() {
        AppMethodBeat.m2504i(21940);
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ORDER BY IPCallPopularCountry.callTimeCount DESC,IPCallPopularCountry.lastCallTime DESC");
        Cursor a = this.bSd.mo10104a("SELECT IPCallPopularCountry.countryCode,IPCallPopularCountry.callTimeCount,IPCallPopularCountry.lastCallTime FROM IPCallPopularCountry  " + stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(21940);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        do {
            C46039i c46039i = new C46039i();
            c46039i.mo8995d(a);
            arrayList.add(Integer.valueOf(c46039i.field_countryCode));
        } while (a.moveToNext());
        if (a != null) {
        }
        AppMethodBeat.m2505o(21940);
        return arrayList;
    }
}
