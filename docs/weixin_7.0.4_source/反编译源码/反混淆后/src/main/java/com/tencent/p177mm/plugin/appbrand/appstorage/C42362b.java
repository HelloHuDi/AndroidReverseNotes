package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C10108n.C10107a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.b */
public final class C42362b extends C7563j<C45517a> implements C10108n {
    public static final String[] fnj = new String[]{C7563j.m13217a(C45517a.ccO, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;"};
    private C4927e gTC;
    private C17126b<String, String> gXb = new C267521();
    private C31591m<String, String, C37091y> gXc = new C190802();

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.b$2 */
    class C190802 implements C31591m<String, String, C37091y> {
        C190802() {
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(101762);
            String str = (String) obj;
            String str2 = (String) obj2;
            C45517a c45517a = new C45517a();
            c45517a.field_key = str;
            c45517a.field_data = str2;
            C42362b.m74920a(C42362b.this, c45517a);
            AppMethodBeat.m2505o(101762);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.b$1 */
    class C267521 implements C17126b<String, String> {
        C267521() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(101761);
            String str = (String) obj;
            C45517a c45517a = new C45517a();
            c45517a.field_key = str;
            if (C42362b.m74921a(C42362b.this, c45517a, new String[0])) {
                Object obj2 = c45517a.field_data;
                AppMethodBeat.m2505o(101761);
                return obj2;
            }
            AppMethodBeat.m2505o(101761);
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m74920a(C42362b c42362b, C4925c c4925c) {
        AppMethodBeat.m2504i(101778);
        boolean a = super.mo10099a(c4925c);
        AppMethodBeat.m2505o(101778);
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m74921a(C42362b c42362b, C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(101777);
        boolean b = super.mo10102b(c4925c, strArr);
        AppMethodBeat.m2505o(101777);
        return b;
    }

    static {
        AppMethodBeat.m2504i(101779);
        AppMethodBeat.m2505o(101779);
    }

    public C42362b(C4927e c4927e) {
        super(c4927e, C45517a.ccO, "AppBrandKVData", null);
        AppMethodBeat.m2504i(101763);
        this.gTC = c4927e;
        AppMethodBeat.m2505o(101763);
    }

    /* renamed from: k */
    public final Object[] mo67873k(int i, String str, String str2) {
        AppMethodBeat.m2504i(101764);
        Object[] objArr;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            objArr = new Object[]{C10107a.MISSING_PARAMS};
            AppMethodBeat.m2505o(101764);
            return objArr;
        }
        C4925c c45517a = new C45517a();
        c45517a.field_key = C38122r.m64501c(i, str, str2, "__");
        if (super.mo10102b(c45517a, new String[0])) {
            objArr = new Object[]{C10107a.NONE, c45517a.field_data, c45517a.field_dataType};
            AppMethodBeat.m2505o(101764);
            return objArr;
        }
        objArr = C38122r.gYb;
        AppMethodBeat.m2505o(101764);
        return objArr;
    }

    /* renamed from: b */
    public final C10107a mo67872b(int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(101765);
        C10107a c10107a;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            c10107a = C10107a.MISSING_PARAMS;
            AppMethodBeat.m2505o(101765);
            return c10107a;
        }
        Object obj;
        String c = C38122r.m64501c(i, str, str2, "__");
        int xU = m74925xU(c);
        int by = C38122r.m64499by(str2, str3);
        int i2 = by - xU;
        if (m74919H(i, str) + i2 >= C38122r.m64494I(i, str)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            c10107a = C10107a.QUOTA_REACHED;
            AppMethodBeat.m2505o(101765);
            return c10107a;
        }
        C45517a c45517a = new C45517a();
        c45517a.field_key = c;
        c45517a.field_data = str3;
        c45517a.field_dataType = str4;
        c45517a.field_size = by;
        if (super.mo10099a(c45517a)) {
            C38122r.m64495a(str, i, this.gXb, this.gXc);
            m74924f(i, str, i2);
            c10107a = C10107a.NONE;
            AppMethodBeat.m2505o(101765);
            return c10107a;
        }
        c10107a = C10107a.UNKNOWN;
        AppMethodBeat.m2505o(101765);
        return c10107a;
    }

    /* renamed from: l */
    public final C10107a mo67874l(int i, String str, String str2) {
        AppMethodBeat.m2504i(101766);
        C10107a c10107a;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            c10107a = C10107a.MISSING_PARAMS;
            AppMethodBeat.m2505o(101766);
            return c10107a;
        }
        String c = C38122r.m64501c(i, str, str2, "__");
        int f = m74924f(i, str, -m74925xU(c));
        C4925c c45517a = new C45517a();
        c45517a.field_key = c;
        super.mo16760a(c45517a, new String[0]);
        if (f <= 0) {
            m74922aA(str, i);
        }
        c10107a = C10107a.NONE;
        AppMethodBeat.m2505o(101766);
        return c10107a;
    }

    /* renamed from: F */
    public final void mo67870F(int i, String str) {
        String str2;
        AppMethodBeat.m2504i(101767);
        if (i == 0) {
            str2 = str + "__";
        } else {
            str2 = i + "__" + str + "__";
        }
        m74922aA(str, i);
        this.gTC.delete("AppBrandKVData", String.format("%s like ? escape ? OR %s=?", new Object[]{"key", "key"}), new String[]{str2.replace("_", "\\_") + "%", "\\", C38122r.m64502m(i, str, "@@@TOTAL@DATA@SIZE@@@")});
        AppMethodBeat.m2505o(101767);
    }

    /* renamed from: xR */
    public final void mo67875xR(String str) {
        AppMethodBeat.m2504i(101768);
        for (int i = 0; i <= 1; i++) {
            mo67870F(i, str);
        }
        AppMethodBeat.m2505o(101768);
    }

    /* renamed from: xS */
    public final int[] mo67876xS(String str) {
        AppMethodBeat.m2504i(101769);
        int[] a = C38122r.m64496a(str, this.gXb, this.gXc);
        AppMethodBeat.m2505o(101769);
        return a;
    }

    /* renamed from: aA */
    private void m74922aA(String str, int i) {
        AppMethodBeat.m2504i(101770);
        C38122r.m64497b(str, i, this.gXb, this.gXc);
        AppMethodBeat.m2505o(101770);
    }

    /* renamed from: G */
    public final Object[] mo67871G(int i, String str) {
        String str2;
        AppMethodBeat.m2504i(101771);
        if (i == 0) {
            str2 = str + "__";
        } else {
            str2 = i + "__" + str + "__";
        }
        Cursor a = this.gTC.mo10105a("AppBrandKVData", new String[]{"key"}, "key like ? escape ?", new String[]{str2.replace("_", "\\_") + "%", "\\"}, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0).replace(str2, ""));
        }
        a.close();
        int H = m74919H(i, str);
        int I = C38122r.m64494I(i, str);
        Object[] objArr = new Object[]{arrayList, Integer.valueOf(H), Integer.valueOf(I)};
        AppMethodBeat.m2505o(101771);
        return objArr;
    }

    /* renamed from: H */
    private int m74919H(int i, String str) {
        AppMethodBeat.m2504i(101772);
        C4925c c45517a = new C45517a();
        c45517a.field_key = C38122r.m64502m(i, str, "@@@TOTAL@DATA@SIZE@@@");
        if (super.mo10102b(c45517a, new String[0])) {
            int i2 = C5046bo.getInt(c45517a.field_data, 0);
            AppMethodBeat.m2505o(101772);
            return i2;
        }
        AppMethodBeat.m2505o(101772);
        return 0;
    }

    /* renamed from: xT */
    public final int mo67877xT(String str) {
        AppMethodBeat.m2504i(101773);
        int[] xS = mo67876xS(str);
        int i = 0;
        int i2 = 0;
        while (i < xS.length) {
            i++;
            i2 = m74919H(xS[i], str) + i2;
        }
        AppMethodBeat.m2505o(101773);
        return i2;
    }

    /* renamed from: e */
    private void m74923e(int i, String str, int i2) {
        AppMethodBeat.m2504i(101774);
        C45517a c45517a = new C45517a();
        c45517a.field_key = C38122r.m64502m(i, str, "@@@TOTAL@DATA@SIZE@@@");
        c45517a.field_data = String.valueOf(i2);
        super.mo10099a(c45517a);
        AppMethodBeat.m2505o(101774);
    }

    /* renamed from: f */
    private int m74924f(int i, String str, int i2) {
        AppMethodBeat.m2504i(101775);
        int max = Math.max(0, m74919H(i, str) + i2);
        m74923e(i, str, max);
        AppMethodBeat.m2505o(101775);
        return max;
    }

    /* renamed from: xU */
    private int m74925xU(String str) {
        AppMethodBeat.m2504i(101776);
        Cursor a = this.gTC.mo10105a("AppBrandKVData", new String[]{"size"}, "key = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            AppMethodBeat.m2505o(101776);
            return i;
        }
        a.close();
        AppMethodBeat.m2505o(101776);
        return 0;
    }
}
