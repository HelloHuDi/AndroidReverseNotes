package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ho */
public final class C41061ho extends C46803m {
    /* renamed from: g */
    static ArrayList<C44522hp> f16500g = new ArrayList();
    /* renamed from: a */
    public ArrayList<C44522hp> f16501a = null;
    /* renamed from: b */
    public String f16502b = "";
    /* renamed from: c */
    public String f16503c = "";
    /* renamed from: d */
    public String f16504d = "";
    /* renamed from: e */
    public String f16505e = "";
    /* renamed from: f */
    public String f16506f = "";

    public C41061ho(ArrayList<C44522hp> arrayList, String str, String str2, String str3, String str4, String str5) {
        this.f16501a = arrayList;
        this.f16502b = str;
        this.f16503c = str2;
        this.f16504d = str3;
        this.f16505e = str4;
        this.f16506f = str5;
    }

    public final void writeTo(C24398l c24398l) {
        AppMethodBeat.m2504i(99562);
        c24398l.mo40673a(this.f16501a, 0);
        if (this.f16502b != null) {
            c24398l.mo40672a(this.f16502b, 1);
        }
        if (this.f16503c != null) {
            c24398l.mo40672a(this.f16503c, 2);
        }
        if (this.f16504d != null) {
            c24398l.mo40672a(this.f16504d, 3);
        }
        if (this.f16505e != null) {
            c24398l.mo40672a(this.f16505e, 4);
        }
        if (this.f16506f != null) {
            c24398l.mo40672a(this.f16506f, 5);
        }
        AppMethodBeat.m2505o(99562);
    }

    static {
        AppMethodBeat.m2504i(99564);
        f16500g.add(new C44522hp());
        AppMethodBeat.m2505o(99564);
    }

    public final void readFrom(C31070k c31070k) {
        AppMethodBeat.m2504i(99563);
        this.f16501a = (ArrayList) c31070k.mo50507a(f16500g, 0, true);
        this.f16502b = c31070k.mo50508a(1, false);
        this.f16503c = c31070k.mo50508a(2, false);
        this.f16504d = c31070k.mo50508a(3, false);
        this.f16505e = c31070k.mo50508a(4, false);
        this.f16506f = c31070k.mo50508a(5, false);
        AppMethodBeat.m2505o(99563);
    }
}
