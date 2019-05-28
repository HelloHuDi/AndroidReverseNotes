package com.tencent.soter.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;

public final class b {
    int AvR;
    String AvS;
    boolean AvT;
    boolean AvU;
    private a AvV;
    private boolean AvW;

    public static class a {
        public int AvR = 0;
        private String AvS = "";
        public boolean AvT = false;
        private boolean AvU = false;
        public a AvV = null;

        public final a co(String str, boolean z) {
            this.AvS = str;
            this.AvU = z;
            this.AvR |= 2;
            return this;
        }

        public final b dRj() {
            AppMethodBeat.i(10474);
            b bVar = new b(this.AvR, this.AvS, this.AvT, this.AvU, this.AvV, (byte) 0);
            AppMethodBeat.o(10474);
            return bVar;
        }
    }

    /* synthetic */ b(int i, String str, boolean z, boolean z2, a aVar, byte b) {
        this(i, str, z, z2, aVar);
    }

    private b(int i, String str, boolean z, boolean z2, a aVar) {
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
        this.AvV = aVar;
    }

    public final void dRi() {
        AppMethodBeat.i(10475);
        g.dRq().R(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
            /* JADX WARNING: Removed duplicated region for block: B:9:0x0037  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                c cVar;
                AppMethodBeat.i(10473);
                b bVar = b.this;
                if ((bVar.AvR & 1) != 1) {
                    if ((bVar.AvR & 2) != 2) {
                        d.e("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
                        cVar = new c(7, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
                    } else if (com.tencent.soter.core.c.g.isNullOrNil(bVar.AvS)) {
                        d.e("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
                        cVar = new c(1, "auth key name not specified");
                    }
                    if (cVar.isSuccess()) {
                        b.a(b.this, cVar);
                        AppMethodBeat.o(10473);
                        return;
                    } else if (com.tencent.soter.core.a.dQN()) {
                        f dQP;
                        if ((b.this.AvR & 1) == 1) {
                            d.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                            if (b.this.AvT && com.tencent.soter.core.a.dQQ()) {
                                d.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                                dQP = com.tencent.soter.core.a.dQP();
                                if (!dQP.isSuccess()) {
                                    d.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", dQP.aIm);
                                    b.a(b.this, dQP);
                                    AppMethodBeat.o(10473);
                                    return;
                                }
                            }
                            dQP = com.tencent.soter.core.a.dQO();
                            if (dQP.isSuccess()) {
                                d.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                                b.a(b.this, dQP);
                            } else {
                                d.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", dQP.aIm);
                                com.tencent.soter.core.a.dQP();
                                b.a(b.this, dQP);
                                AppMethodBeat.o(10473);
                                return;
                            }
                        }
                        if ((b.this.AvR & 2) == 2) {
                            d.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", b.this.AvS);
                            if (com.tencent.soter.core.a.dQR()) {
                                if (b.this.AvU && com.tencent.soter.core.a.aua(b.this.AvS)) {
                                    d.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                                    dQP = com.tencent.soter.core.a.cn(b.this.AvS, false);
                                    if (!dQP.isSuccess()) {
                                        d.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", b.this.AvS, dQP.aIm);
                                        b.a(b.this, dQP);
                                        AppMethodBeat.o(10473);
                                        return;
                                    }
                                }
                                dQP = com.tencent.soter.core.a.atZ(b.this.AvS);
                                if (dQP.isSuccess()) {
                                    d.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                                    b.a(b.this, dQP);
                                } else {
                                    d.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", b.this.AvS, dQP.aIm);
                                    com.tencent.soter.core.a.cn(b.this.AvS, true);
                                    b.a(b.this, dQP);
                                    AppMethodBeat.o(10473);
                                    return;
                                }
                            }
                            d.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                            b.a(b.this, new c(3, "ASK not exists when generate auth key"));
                            AppMethodBeat.o(10473);
                            return;
                        }
                        AppMethodBeat.o(10473);
                        return;
                    } else {
                        d.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
                        b.a(b.this, new c(2));
                        AppMethodBeat.o(10473);
                        return;
                    }
                }
                cVar = new c(0);
                if (cVar.isSuccess()) {
                }
            }
        });
        AppMethodBeat.o(10475);
    }

    static /* synthetic */ void a(b bVar, f fVar) {
        AppMethodBeat.i(10476);
        if (!(bVar.AvV == null || bVar.AvW)) {
            if (fVar == null) {
                bVar.AvV.onError(-1, "unknown");
            } else if (fVar.isSuccess()) {
                bVar.AvV.onSuccess();
            } else {
                bVar.AvV.onError(fVar.errCode, fVar.aIm);
            }
        }
        bVar.AvW = true;
        AppMethodBeat.o(10476);
    }
}
