package com.tencent.p177mm.plugin.wallet_index.p564c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.b */
public final class C35525b {
    public int nqa;
    public String nqb;
    public int tQZ = 0;

    private C35525b(int i, String str) {
        this.nqa = i;
        this.nqb = str;
    }

    /* renamed from: bu */
    public static C35525b m58303bu(int i, String str) {
        C35525b c35525b;
        int i2 = 6;
        int i3 = C25738R.string.g43;
        AppMethodBeat.m2504i(48175);
        if (i > -15001) {
            switch (i) {
                case 0:
                    i3 = C25738R.string.g42;
                    i2 = i;
                    break;
                case 1:
                case 7:
                    i3 = C25738R.string.g44;
                    i2 = i;
                    break;
                case 3:
                case 105:
                    i2 = 3;
                    str = "Google Play not install";
                    break;
                case 6:
                    c35525b = new C35525b(6, str);
                    AppMethodBeat.m2505o(48175);
                    return c35525b;
                case 103:
                case 104:
                case 100000002:
                    i2 = 100000002;
                    i3 = C25738R.string.g41;
                    break;
                case 109:
                    i3 = C25738R.string.g45;
                    i2 = i;
                    break;
                case 110:
                    i3 = C25738R.string.g47;
                    i2 = i;
                    break;
                case 111:
                    i3 = C25738R.string.g48;
                    i2 = i;
                    break;
                case 112:
                    i3 = C25738R.string.g46;
                    i2 = i;
                    break;
                case 113:
                    i2 = i;
                    break;
            }
        }
        i2 = i;
        C4990ab.m7416i("MicroMsg.IapResult", "code : " + i + ", errMsg : " + str + ", convert to errCode : " + i2);
        if (C5046bo.isNullOrNil(str)) {
            C35525b c35525b2 = new C35525b(i2, C4996ah.getContext().getString(i3));
            AppMethodBeat.m2505o(48175);
            return c35525b2;
        }
        c35525b = new C35525b(i2, str);
        AppMethodBeat.m2505o(48175);
        return c35525b;
    }

    public final boolean cSU() {
        return this.nqa == 104 || this.nqa == 100000002;
    }

    public final String toString() {
        AppMethodBeat.m2504i(48177);
        String str = "IapResult: " + this.nqb;
        AppMethodBeat.m2505o(48177);
        return str;
    }

    public final boolean cSV() {
        boolean z;
        AppMethodBeat.m2504i(48176);
        if (this.nqa == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || cSU()) {
            AppMethodBeat.m2505o(48176);
            return false;
        }
        AppMethodBeat.m2505o(48176);
        return true;
    }
}
