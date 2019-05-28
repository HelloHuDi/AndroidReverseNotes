package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.ugc.TXRecordCommon;
import java.lang.reflect.Array;

public class c implements g {
    protected static long clg = 0;
    protected static long clh = 0;
    protected static Object cli = new Object();
    protected h ckU;
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
    protected h clk;

    public c() {
        AppMethodBeat.i(137013);
        AppMethodBeat.o(137013);
    }

    static {
        AppMethodBeat.i(137018);
        AppMethodBeat.o(137018);
    }

    public final void C(int i, int i2, int i3) {
        AppMethodBeat.i(137015);
        int i4 = this.ckV;
        this.ckV = i;
        this.ckW = i2;
        this.ckX = i3;
        if (this.ckY != this.ckV) {
            if (this.ckU == null) {
                this.ckU = Dr();
                this.ckU.g(this.clf, this.ckV, this.ckY);
            } else if (!(this.ckU == null || i4 == this.ckV)) {
                this.ckU.release();
                this.ckU = Dr();
                this.ckU.g(this.clf, this.ckV, this.ckY);
            }
            if (this.ckW == 2 && this.ckZ == 2) {
                if (this.clk == null) {
                    this.clk = Dr();
                    this.clk.g(this.clf + "RResample", this.ckV, this.ckY);
                } else if (!(this.clk == null || i4 == this.ckV)) {
                    this.clk.release();
                    this.clk = Dr();
                    this.clk.g(this.clf + "RResample", this.ckV, this.ckY);
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
        AppMethodBeat.o(137015);
    }

    /* JADX WARNING: Missing block: B:6:0x001b, code skipped:
            if (r0 != null) goto L_0x001d;
     */
    /* JADX WARNING: Missing block: B:50:0x00c4, code skipped:
            if (r0 != null) goto L_0x00c6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] F(byte[] bArr) {
        AppMethodBeat.i(137016);
        if (bArr == null) {
            AppMethodBeat.o(137016);
            return bArr;
        }
        byte[] b;
        byte[] bArr2;
        if (this.clc) {
            b = b.b(this.ckX, this.cla, bArr);
        }
        b = null;
        if (b == null) {
            bArr2 = bArr;
        } else {
            bArr2 = b;
        }
        if (this.ckW == 1 && this.ckZ == 2 && this.cld) {
            b = this.ckU.F(bArr2);
            if (b != null) {
                bArr2 = b;
            }
            b = b.c(this.ckW, this.ckZ, this.cla, bArr2);
            if (b != null) {
                bArr2 = b;
            }
            AppMethodBeat.o(137016);
            return bArr2;
        } else if (this.ckW == 2 && this.ckZ == 2 && this.cld) {
            if (!(this.ckU instanceof i)) {
                b = this.ckU.F(bArr2);
            } else if (this.ckZ == 2) {
                int length = bArr2.length / 2;
                if (this.clj == null || length != this.clj.length) {
                    this.clj = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{2, length});
                }
                b.a(this.cla, bArr2, this.clj);
                b = this.ckU.F(this.clj[0]);
                byte[] F = this.clk.F(this.clj[1]);
                if (b == null || F == null) {
                    b = bArr2;
                } else {
                    b = b.a(this.cla, b, F);
                }
            } else {
                b = this.ckU.F(bArr2);
            }
            if (b != null) {
                bArr2 = b;
            }
            AppMethodBeat.o(137016);
            return bArr2;
        } else {
            if (this.clb) {
                b = b.c(this.ckW, this.ckZ, this.cla, bArr2);
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
                            AppMethodBeat.o(137016);
                        }
                    }
                }
                System.nanoTime();
                b = this.ckU.F(bArr);
                if (b != null) {
                    bArr = b;
                }
                synchronized (cli) {
                    try {
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(137016);
                        }
                    }
                }
            }
            AppMethodBeat.o(137016);
            return bArr;
        }
    }

    public void Ds() {
    }

    public d Dt() {
        return null;
    }

    public void flushCache() {
    }

    public void release() {
        AppMethodBeat.i(137017);
        if (this.ckU != null) {
            this.ckU.release();
            this.ckU = null;
        }
        if (this.clk != null) {
            this.clk.release();
            this.clk = null;
        }
        AppMethodBeat.o(137017);
    }

    public h Dr() {
        AppMethodBeat.i(137014);
        i iVar = new i();
        AppMethodBeat.o(137014);
        return iVar;
    }
}
