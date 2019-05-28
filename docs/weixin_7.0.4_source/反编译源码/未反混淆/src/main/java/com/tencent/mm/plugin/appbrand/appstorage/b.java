package com.tencent.mm.plugin.appbrand.appstorage;

import a.f.a.m;
import a.y;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class b extends j<a> implements n {
    public static final String[] fnj = new String[]{j.a(a.ccO, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;"};
    private e gTC;
    private a.f.a.b<String, String> gXb = new a.f.a.b<String, String>() {
        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(101761);
            String str = (String) obj;
            a aVar = new a();
            aVar.field_key = str;
            if (b.a(b.this, aVar, new String[0])) {
                Object obj2 = aVar.field_data;
                AppMethodBeat.o(101761);
                return obj2;
            }
            AppMethodBeat.o(101761);
            return null;
        }
    };
    private m<String, String, y> gXc = new m<String, String, y>() {
        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(101762);
            String str = (String) obj;
            String str2 = (String) obj2;
            a aVar = new a();
            aVar.field_key = str;
            aVar.field_data = str2;
            b.a(b.this, aVar);
            AppMethodBeat.o(101762);
            return null;
        }
    };

    static /* synthetic */ boolean a(b bVar, c cVar) {
        AppMethodBeat.i(101778);
        boolean a = super.a(cVar);
        AppMethodBeat.o(101778);
        return a;
    }

    static /* synthetic */ boolean a(b bVar, c cVar, String[] strArr) {
        AppMethodBeat.i(101777);
        boolean b = super.b(cVar, strArr);
        AppMethodBeat.o(101777);
        return b;
    }

    static {
        AppMethodBeat.i(101779);
        AppMethodBeat.o(101779);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "AppBrandKVData", null);
        AppMethodBeat.i(101763);
        this.gTC = eVar;
        AppMethodBeat.o(101763);
    }

    public final Object[] k(int i, String str, String str2) {
        AppMethodBeat.i(101764);
        Object[] objArr;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            objArr = new Object[]{a.MISSING_PARAMS};
            AppMethodBeat.o(101764);
            return objArr;
        }
        c aVar = new a();
        aVar.field_key = r.c(i, str, str2, "__");
        if (super.b(aVar, new String[0])) {
            objArr = new Object[]{a.NONE, aVar.field_data, aVar.field_dataType};
            AppMethodBeat.o(101764);
            return objArr;
        }
        objArr = r.gYb;
        AppMethodBeat.o(101764);
        return objArr;
    }

    public final a b(int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(101765);
        a aVar;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            aVar = a.MISSING_PARAMS;
            AppMethodBeat.o(101765);
            return aVar;
        }
        Object obj;
        String c = r.c(i, str, str2, "__");
        int xU = xU(c);
        int by = r.by(str2, str3);
        int i2 = by - xU;
        if (H(i, str) + i2 >= r.I(i, str)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            aVar = a.QUOTA_REACHED;
            AppMethodBeat.o(101765);
            return aVar;
        }
        a aVar2 = new a();
        aVar2.field_key = c;
        aVar2.field_data = str3;
        aVar2.field_dataType = str4;
        aVar2.field_size = by;
        if (super.a(aVar2)) {
            r.a(str, i, this.gXb, this.gXc);
            f(i, str, i2);
            aVar = a.NONE;
            AppMethodBeat.o(101765);
            return aVar;
        }
        aVar = a.UNKNOWN;
        AppMethodBeat.o(101765);
        return aVar;
    }

    public final a l(int i, String str, String str2) {
        AppMethodBeat.i(101766);
        a aVar;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            aVar = a.MISSING_PARAMS;
            AppMethodBeat.o(101766);
            return aVar;
        }
        String c = r.c(i, str, str2, "__");
        int f = f(i, str, -xU(c));
        c aVar2 = new a();
        aVar2.field_key = c;
        super.a(aVar2, new String[0]);
        if (f <= 0) {
            aA(str, i);
        }
        aVar = a.NONE;
        AppMethodBeat.o(101766);
        return aVar;
    }

    public final void F(int i, String str) {
        String str2;
        AppMethodBeat.i(101767);
        if (i == 0) {
            str2 = str + "__";
        } else {
            str2 = i + "__" + str + "__";
        }
        aA(str, i);
        this.gTC.delete("AppBrandKVData", String.format("%s like ? escape ? OR %s=?", new Object[]{"key", "key"}), new String[]{str2.replace("_", "\\_") + "%", "\\", r.m(i, str, "@@@TOTAL@DATA@SIZE@@@")});
        AppMethodBeat.o(101767);
    }

    public final void xR(String str) {
        AppMethodBeat.i(101768);
        for (int i = 0; i <= 1; i++) {
            F(i, str);
        }
        AppMethodBeat.o(101768);
    }

    public final int[] xS(String str) {
        AppMethodBeat.i(101769);
        int[] a = r.a(str, this.gXb, this.gXc);
        AppMethodBeat.o(101769);
        return a;
    }

    private void aA(String str, int i) {
        AppMethodBeat.i(101770);
        r.b(str, i, this.gXb, this.gXc);
        AppMethodBeat.o(101770);
    }

    public final Object[] G(int i, String str) {
        String str2;
        AppMethodBeat.i(101771);
        if (i == 0) {
            str2 = str + "__";
        } else {
            str2 = i + "__" + str + "__";
        }
        Cursor a = this.gTC.a("AppBrandKVData", new String[]{"key"}, "key like ? escape ?", new String[]{str2.replace("_", "\\_") + "%", "\\"}, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0).replace(str2, ""));
        }
        a.close();
        int H = H(i, str);
        int I = r.I(i, str);
        Object[] objArr = new Object[]{arrayList, Integer.valueOf(H), Integer.valueOf(I)};
        AppMethodBeat.o(101771);
        return objArr;
    }

    private int H(int i, String str) {
        AppMethodBeat.i(101772);
        c aVar = new a();
        aVar.field_key = r.m(i, str, "@@@TOTAL@DATA@SIZE@@@");
        if (super.b(aVar, new String[0])) {
            int i2 = bo.getInt(aVar.field_data, 0);
            AppMethodBeat.o(101772);
            return i2;
        }
        AppMethodBeat.o(101772);
        return 0;
    }

    public final int xT(String str) {
        AppMethodBeat.i(101773);
        int[] xS = xS(str);
        int i = 0;
        int i2 = 0;
        while (i < xS.length) {
            i++;
            i2 = H(xS[i], str) + i2;
        }
        AppMethodBeat.o(101773);
        return i2;
    }

    private void e(int i, String str, int i2) {
        AppMethodBeat.i(101774);
        a aVar = new a();
        aVar.field_key = r.m(i, str, "@@@TOTAL@DATA@SIZE@@@");
        aVar.field_data = String.valueOf(i2);
        super.a(aVar);
        AppMethodBeat.o(101774);
    }

    private int f(int i, String str, int i2) {
        AppMethodBeat.i(101775);
        int max = Math.max(0, H(i, str) + i2);
        e(i, str, max);
        AppMethodBeat.o(101775);
        return max;
    }

    private int xU(String str) {
        AppMethodBeat.i(101776);
        Cursor a = this.gTC.a("AppBrandKVData", new String[]{"size"}, "key = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            AppMethodBeat.o(101776);
            return i;
        }
        a.close();
        AppMethodBeat.o(101776);
        return 0;
    }
}
