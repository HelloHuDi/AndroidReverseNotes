package com.tencent.soter.p663a.p1424e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p1351c.C44478f;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p664g.C44472g;

/* renamed from: com.tencent.soter.a.e.b */
public final class C44466b {
    int AvR;
    String AvS;
    boolean AvT;
    boolean AvU;
    private C44465a AvV;
    private boolean AvW;

    /* renamed from: com.tencent.soter.a.e.b$a */
    public static class C30957a {
        public int AvR = 0;
        private String AvS = "";
        public boolean AvT = false;
        private boolean AvU = false;
        public C44465a AvV = null;

        /* renamed from: co */
        public final C30957a mo50075co(String str, boolean z) {
            this.AvS = str;
            this.AvU = z;
            this.AvR |= 2;
            return this;
        }

        public final C44466b dRj() {
            AppMethodBeat.m2504i(10474);
            C44466b c44466b = new C44466b(this.AvR, this.AvS, this.AvT, this.AvU, this.AvV, (byte) 0);
            AppMethodBeat.m2505o(10474);
            return c44466b;
        }
    }

    /* renamed from: com.tencent.soter.a.e.b$1 */
    class C444671 implements Runnable {
        C444671() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0037  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            C16165c c16165c;
            AppMethodBeat.m2504i(10473);
            C44466b c44466b = C44466b.this;
            if ((c44466b.AvR & 1) != 1) {
                if ((c44466b.AvR & 2) != 2) {
                    C44476d.m80483e("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
                    c16165c = new C16165c(7, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
                } else if (C24321g.isNullOrNil(c44466b.AvS)) {
                    C44476d.m80483e("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
                    c16165c = new C16165c(1, "auth key name not specified");
                }
                if (c16165c.isSuccess()) {
                    C44466b.m80464a(C44466b.this, c16165c);
                    AppMethodBeat.m2505o(10473);
                    return;
                } else if (C40997a.dQN()) {
                    C44478f dQP;
                    if ((C44466b.this.AvR & 1) == 1) {
                        C44476d.m80482d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                        if (C44466b.this.AvT && C40997a.dQQ()) {
                            C44476d.m80482d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                            dQP = C40997a.dQP();
                            if (!dQP.isSuccess()) {
                                C44476d.m80486w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", dQP.aIm);
                                C44466b.m80464a(C44466b.this, dQP);
                                AppMethodBeat.m2505o(10473);
                                return;
                            }
                        }
                        dQP = C40997a.dQO();
                        if (dQP.isSuccess()) {
                            C44476d.m80484i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                            C44466b.m80464a(C44466b.this, dQP);
                        } else {
                            C44476d.m80486w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", dQP.aIm);
                            C40997a.dQP();
                            C44466b.m80464a(C44466b.this, dQP);
                            AppMethodBeat.m2505o(10473);
                            return;
                        }
                    }
                    if ((C44466b.this.AvR & 2) == 2) {
                        C44476d.m80482d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", C44466b.this.AvS);
                        if (C40997a.dQR()) {
                            if (C44466b.this.AvU && C40997a.aua(C44466b.this.AvS)) {
                                C44476d.m80482d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                                dQP = C40997a.m71093cn(C44466b.this.AvS, false);
                                if (!dQP.isSuccess()) {
                                    C44476d.m80486w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", C44466b.this.AvS, dQP.aIm);
                                    C44466b.m80464a(C44466b.this, dQP);
                                    AppMethodBeat.m2505o(10473);
                                    return;
                                }
                            }
                            dQP = C40997a.atZ(C44466b.this.AvS);
                            if (dQP.isSuccess()) {
                                C44476d.m80484i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                                C44466b.m80464a(C44466b.this, dQP);
                            } else {
                                C44476d.m80486w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", C44466b.this.AvS, dQP.aIm);
                                C40997a.m71093cn(C44466b.this.AvS, true);
                                C44466b.m80464a(C44466b.this, dQP);
                                AppMethodBeat.m2505o(10473);
                                return;
                            }
                        }
                        C44476d.m80486w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                        C44466b.m80464a(C44466b.this, new C16165c(3, "ASK not exists when generate auth key"));
                        AppMethodBeat.m2505o(10473);
                        return;
                    }
                    AppMethodBeat.m2505o(10473);
                    return;
                } else {
                    C44476d.m80486w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
                    C44466b.m80464a(C44466b.this, new C16165c(2));
                    AppMethodBeat.m2505o(10473);
                    return;
                }
            }
            c16165c = new C16165c(0);
            if (c16165c.isSuccess()) {
            }
        }
    }

    /* synthetic */ C44466b(int i, String str, boolean z, boolean z2, C44465a c44465a, byte b) {
        this(i, str, z, z2, c44465a);
    }

    private C44466b(int i, String str, boolean z, boolean z2, C44465a c44465a) {
        this.AvR = 0;
        this.AvS = "";
        this.AvT = false;
        this.AvU = false;
        this.AvV = null;
        this.AvW = false;
        this.AvR = i;
        this.AvS = str;
        this.AvT = z;
        this.AvU = z2;
        this.AvV = c44465a;
    }

    public final void dRi() {
        AppMethodBeat.m2504i(10475);
        C44472g.dRq().mo70644R(new C444671());
        AppMethodBeat.m2505o(10475);
    }

    /* renamed from: a */
    static /* synthetic */ void m80464a(C44466b c44466b, C44478f c44478f) {
        AppMethodBeat.m2504i(10476);
        if (!(c44466b.AvV == null || c44466b.AvW)) {
            if (c44478f == null) {
                c44466b.AvV.onError(-1, "unknown");
            } else if (c44478f.isSuccess()) {
                c44466b.AvV.onSuccess();
            } else {
                c44466b.AvV.onError(c44478f.errCode, c44478f.aIm);
            }
        }
        c44466b.AvW = true;
        AppMethodBeat.m2505o(10476);
    }
}
