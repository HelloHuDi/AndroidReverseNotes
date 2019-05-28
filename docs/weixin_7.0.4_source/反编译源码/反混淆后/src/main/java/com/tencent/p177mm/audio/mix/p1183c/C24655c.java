package com.tencent.p177mm.audio.mix.p1183c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import com.tencent.ugc.TXRecordCommon;
import java.lang.reflect.Array;

/* renamed from: com.tencent.mm.audio.mix.c.c */
public class C24655c implements C17956g {
    protected static long clg = 0;
    protected static long clh = 0;
    protected static Object cli = new Object();
    protected C41775h ckU;
    protected int ckV = 0;
    protected int ckW = 0;
    protected int ckX = 0;
    protected int ckY = TXRecordCommon.AUDIO_SAMPLERATE_44100;
    protected int ckZ = 2;
    protected int cla = 2;
    protected boolean clb = false;
    protected boolean clc = false;
    protected boolean cld = false;
    protected String cle;
    protected String clf;
    protected byte[][] clj = new byte[2][];
    protected C41775h clk;

    public C24655c() {
        AppMethodBeat.m2504i(137013);
        AppMethodBeat.m2505o(137013);
    }

    static {
        AppMethodBeat.m2504i(137018);
        AppMethodBeat.m2505o(137018);
    }

    /* renamed from: C */
    public final void mo33486C(int i, int i2, int i3) {
        AppMethodBeat.m2504i(137015);
        int i4 = this.ckV;
        this.ckV = i;
        this.ckW = i2;
        this.ckX = i3;
        if (this.ckY != this.ckV) {
            if (this.ckU == null) {
                this.ckU = mo41540Dr();
                this.ckU.mo67529g(this.clf, this.ckV, this.ckY);
            } else if (!(this.ckU == null || i4 == this.ckV)) {
                this.ckU.release();
                this.ckU = mo41540Dr();
                this.ckU.mo67529g(this.clf, this.ckV, this.ckY);
            }
            if (this.ckW == 2 && this.ckZ == 2) {
                if (this.clk == null) {
                    this.clk = mo41540Dr();
                    this.clk.mo67529g(this.clf + "RResample", this.ckV, this.ckY);
                } else if (!(this.clk == null || i4 == this.ckV)) {
                    this.clk.release();
                    this.clk = mo41540Dr();
                    this.clk.mo67529g(this.clf + "RResample", this.ckV, this.ckY);
                }
            }
            this.cld = true;
        } else {
            this.cld = false;
            if (this.ckU != null) {
                this.ckU.release();
                this.ckU = null;
            }
        }
        if (this.cla != this.ckX) {
            this.clc = true;
        }
        if (this.ckZ != this.ckW) {
            this.clb = true;
        }
        AppMethodBeat.m2505o(137015);
    }

    /* JADX WARNING: Missing block: B:6:0x001b, code skipped:
            if (r0 != null) goto L_0x001d;
     */
    /* JADX WARNING: Missing block: B:50:0x00c4, code skipped:
            if (r0 != null) goto L_0x00c6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: F */
    public byte[] mo33489F(byte[] bArr) {
        AppMethodBeat.m2504i(137016);
        if (bArr == null) {
            AppMethodBeat.m2505o(137016);
            return bArr;
        }
        byte[] b;
        byte[] bArr2;
        if (this.clc) {
            b = C41774b.m73741b(this.ckX, this.cla, bArr);
        }
        b = null;
        if (b == null) {
            bArr2 = bArr;
        } else {
            bArr2 = b;
        }
        if (this.ckW == 1 && this.ckZ == 2 && this.cld) {
            b = this.ckU.mo67528F(bArr2);
            if (b != null) {
                bArr2 = b;
            }
            b = C41774b.m73742c(this.ckW, this.ckZ, this.cla, bArr2);
            if (b != null) {
                bArr2 = b;
            }
            AppMethodBeat.m2505o(137016);
            return bArr2;
        } else if (this.ckW == 2 && this.ckZ == 2 && this.cld) {
            if (!(this.ckU instanceof C44681i)) {
                b = this.ckU.mo67528F(bArr2);
            } else if (this.ckZ == 2) {
                int length = bArr2.length / 2;
                if (this.clj == null || length != this.clj.length) {
                    this.clj = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{2, length});
                }
                C41774b.m73739a(this.cla, bArr2, this.clj);
                b = this.ckU.mo67528F(this.clj[0]);
                byte[] F = this.clk.mo67528F(this.clj[1]);
                if (b == null || F == null) {
                    b = bArr2;
                } else {
                    b = C41774b.m73740a(this.cla, b, F);
                }
            } else {
                b = this.ckU.mo67528F(bArr2);
            }
            if (b != null) {
                bArr2 = b;
            }
            AppMethodBeat.m2505o(137016);
            return bArr2;
        } else {
            if (this.clb) {
                b = C41774b.m73742c(this.ckW, this.ckZ, this.cla, bArr2);
            }
            b = bArr2;
            if (b != null) {
                bArr = b;
            }
            if (this.cld) {
                synchronized (cli) {
                    try {
                        clg++;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(137016);
                        }
                    }
                }
                System.nanoTime();
                b = this.ckU.mo67528F(bArr);
                if (b != null) {
                    bArr = b;
                }
                synchronized (cli) {
                    try {
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(137016);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(137016);
            return bArr;
        }
    }

    /* renamed from: Ds */
    public void mo33487Ds() {
    }

    /* renamed from: Dt */
    public C45164d mo33488Dt() {
        return null;
    }

    public void flushCache() {
    }

    public void release() {
        AppMethodBeat.m2504i(137017);
        if (this.ckU != null) {
            this.ckU.release();
            this.ckU = null;
        }
        if (this.clk != null) {
            this.clk.release();
            this.clk = null;
        }
        AppMethodBeat.m2505o(137017);
    }

    /* renamed from: Dr */
    public C41775h mo41540Dr() {
        AppMethodBeat.m2504i(137014);
        C44681i c44681i = new C44681i();
        AppMethodBeat.m2505o(137014);
        return c44681i;
    }
}
