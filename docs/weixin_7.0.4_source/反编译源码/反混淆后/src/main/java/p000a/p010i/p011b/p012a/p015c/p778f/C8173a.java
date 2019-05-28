package p000a.p010i.p011b.p012a.p015c.p778f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import p000a.p051k.C31820v;

/* renamed from: a.i.b.a.c.f.a */
public final class C8173a {
    static final /* synthetic */ boolean $assertionsDisabled = (!C8173a.class.desiredAssertionStatus());
    public final C8174b BcW;
    public final C8174b ByN;
    public final boolean ByO;

    static {
        AppMethodBeat.m2504i(121362);
        AppMethodBeat.m2505o(121362);
    }

    /* renamed from: n */
    public static C8173a m14427n(C8174b c8174b) {
        AppMethodBeat.m2504i(121348);
        C8173a c8173a = new C8173a(c8174b.ehG(), c8174b.ByQ.ehK());
        AppMethodBeat.m2505o(121348);
        return c8173a;
    }

    public C8173a(C8174b c8174b, C8174b c8174b2, boolean z) {
        AppMethodBeat.m2504i(121349);
        this.BcW = c8174b;
        if ($assertionsDisabled || !c8174b2.ByQ.ByV.isEmpty()) {
            this.ByN = c8174b2;
            this.ByO = z;
            AppMethodBeat.m2505o(121349);
            return;
        }
        AssertionError assertionError = new AssertionError("Class name must not be root: " + c8174b + (z ? " (local)" : ""));
        AppMethodBeat.m2505o(121349);
        throw assertionError;
    }

    public C8173a(C8174b c8174b, C37022f c37022f) {
        this(c8174b, C8174b.m14430s(c37022f), false);
        AppMethodBeat.m2504i(121350);
        AppMethodBeat.m2505o(121350);
    }

    public final C37022f ehB() {
        AppMethodBeat.m2504i(139061);
        C37022f ehK = this.ByN.ByQ.ehK();
        AppMethodBeat.m2505o(139061);
        return ehK;
    }

    /* renamed from: p */
    public final C8173a mo17969p(C37022f c37022f) {
        AppMethodBeat.m2504i(121352);
        C8173a c8173a = new C8173a(this.BcW, this.ByN.mo17976q(c37022f), this.ByO);
        AppMethodBeat.m2505o(121352);
        return c8173a;
    }

    public final C8173a ehC() {
        AppMethodBeat.m2504i(121353);
        C8174b ehG = this.ByN.ehG();
        if (ehG.ByQ.ByV.isEmpty()) {
            AppMethodBeat.m2505o(121353);
            return null;
        }
        C8173a c8173a = new C8173a(this.BcW, ehG, this.ByO);
        AppMethodBeat.m2505o(121353);
        return c8173a;
    }

    public final boolean ehD() {
        AppMethodBeat.m2504i(121354);
        if (this.ByN.ehG().ByQ.ByV.isEmpty()) {
            AppMethodBeat.m2505o(121354);
            return false;
        }
        AppMethodBeat.m2505o(121354);
        return true;
    }

    public final C8174b ehE() {
        AppMethodBeat.m2504i(121355);
        C8174b c8174b;
        if (this.BcW.ByQ.ByV.isEmpty()) {
            c8174b = this.ByN;
            AppMethodBeat.m2505o(121355);
            return c8174b;
        }
        c8174b = new C8174b(this.BcW.ByQ.ByV + "." + this.ByN.ByQ.ByV);
        AppMethodBeat.m2505o(121355);
        return c8174b;
    }

    public static C8173a avW(String str) {
        AppMethodBeat.m2504i(121356);
        C8173a cv = C8173a.m14426cv(str, false);
        AppMethodBeat.m2505o(121356);
        return cv;
    }

    /* renamed from: cv */
    public static C8173a m14426cv(String str, boolean z) {
        AppMethodBeat.m2504i(121357);
        C8173a c8173a = new C8173a(new C8174b(C31820v.m51544jg(str, "").replace(IOUtils.DIR_SEPARATOR_UNIX, '.')), new C8174b(C31820v.m51523a(str, (char) IOUtils.DIR_SEPARATOR_UNIX, str)), z);
        AppMethodBeat.m2505o(121357);
        return c8173a;
    }

    /* renamed from: pq */
    public final String mo17970pq() {
        AppMethodBeat.m2504i(121358);
        String str;
        if (this.BcW.ByQ.ByV.isEmpty()) {
            str = this.ByN.ByQ.ByV;
            AppMethodBeat.m2505o(121358);
            return str;
        }
        str = this.BcW.ByQ.ByV.replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + this.ByN.ByQ.ByV;
        AppMethodBeat.m2505o(121358);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(121359);
        if (this == obj) {
            AppMethodBeat.m2505o(121359);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(121359);
            return false;
        } else {
            C8173a c8173a = (C8173a) obj;
            if (this.BcW.equals(c8173a.BcW) && this.ByN.equals(c8173a.ByN) && this.ByO == c8173a.ByO) {
                AppMethodBeat.m2505o(121359);
                return true;
            }
            AppMethodBeat.m2505o(121359);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(121360);
        int hashCode = (((this.BcW.hashCode() * 31) + this.ByN.hashCode()) * 31) + Boolean.valueOf(this.ByO).hashCode();
        AppMethodBeat.m2505o(121360);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(121361);
        String str;
        if (this.BcW.ByQ.ByV.isEmpty()) {
            str = "/" + mo17970pq();
            AppMethodBeat.m2505o(121361);
            return str;
        }
        str = mo17970pq();
        AppMethodBeat.m2505o(121361);
        return str;
    }
}
