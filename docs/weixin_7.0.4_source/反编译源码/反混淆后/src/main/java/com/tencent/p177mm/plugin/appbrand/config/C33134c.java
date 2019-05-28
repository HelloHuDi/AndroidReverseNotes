package com.tencent.p177mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.config.c */
public final class C33134c extends C7563j<C33133b> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C33133b.fjX, "AppBrandCommonKVData")};
    public final C4927e gTC;

    static {
        AppMethodBeat.m2504i(101788);
        AppMethodBeat.m2505o(101788);
    }

    public C33134c(C4927e c4927e) {
        super(c4927e, C33133b.fjX, "AppBrandCommonKVData", null);
        this.gTC = c4927e;
    }

    /* renamed from: bG */
    public final boolean mo53682bG(String str, String str2) {
        AppMethodBeat.m2504i(101784);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101784);
            return false;
        }
        C4925c c33133b = new C33133b();
        c33133b.field_key = str;
        c33133b.field_value = str2;
        if (!C5046bo.isNullOrNil(c33133b.field_value)) {
            boolean a = super.mo10099a(c33133b);
            AppMethodBeat.m2505o(101784);
            return a;
        } else if (super.mo16760a(c33133b, new String[0])) {
            AppMethodBeat.m2505o(101784);
            return false;
        } else {
            AppMethodBeat.m2505o(101784);
            return true;
        }
    }

    public final String get(String str, String str2) {
        AppMethodBeat.m2504i(101785);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101785);
            return str2;
        }
        C4925c c33133b = new C33133b();
        c33133b.field_key = str;
        if (super.mo10102b(c33133b, new String[0])) {
            str2 = c33133b.field_value;
            AppMethodBeat.m2505o(101785);
            return str2;
        }
        AppMethodBeat.m2505o(101785);
        return str2;
    }

    /* renamed from: pI */
    public final boolean mo53684pI(String str) {
        AppMethodBeat.m2504i(101786);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101786);
            return false;
        }
        C4925c c33133b = new C33133b();
        c33133b.field_key = str;
        c33133b.field_value = get(str, "");
        if (TextUtils.isEmpty(c33133b.field_value) || super.mo16760a(c33133b, new String[0])) {
            AppMethodBeat.m2505o(101786);
            return true;
        }
        AppMethodBeat.m2505o(101786);
        return false;
    }

    /* renamed from: yW */
    public final void mo53685yW(String str) {
        AppMethodBeat.m2504i(101787);
        super.mo16768hY("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandCommonKVData", "key", str}));
        AppMethodBeat.m2505o(101787);
    }
}
