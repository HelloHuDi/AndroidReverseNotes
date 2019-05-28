package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.c.a;
import com.tencent.mm.sdk.platformtools.ab;

public class b implements c {
    String ilX = "audio/mp4a-latm";
    String ilY = "audio/mpeg";
    a ilZ = null;
    int ima = 0;
    int imb = 0;
    byte[] imc;
    int imd = 0;

    public final void pl(int i) {
        AppMethodBeat.i(105649);
        ab.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", Integer.valueOf(this.ima));
        this.ima = i;
        AppMethodBeat.o(105649);
    }

    public final void a(a aVar) {
        this.ilZ = aVar;
    }

    public final void t(double d) {
        AppMethodBeat.i(105650);
        this.imb = (int) (1024.0d * d);
        ab.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", Double.valueOf(d), Integer.valueOf(this.imb));
        this.imc = new byte[this.imb];
        AppMethodBeat.o(105650);
    }

    public boolean h(String str, int i, int i2, int i3) {
        return false;
    }

    public boolean a(boolean z, byte[] bArr, int i) {
        return false;
    }

    public void flush() {
    }

    public void close() {
    }

    public final void e(byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(105651);
        if (this.ilZ == null) {
            ab.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
            AppMethodBeat.o(105651);
        } else if (((double) this.imb) == 0.0d) {
            ab.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
            AppMethodBeat.o(105651);
        } else {
            if (i > this.imb) {
                ab.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", Integer.valueOf(i), Integer.valueOf(this.imb));
            }
            ab.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", Integer.valueOf(this.imd), Integer.valueOf(i));
            int i2 = this.imd + i;
            if (i2 >= this.imb && bArr != null) {
                ab.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", Integer.valueOf(i2));
                if (i2 > this.imc.length) {
                    ab.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", Integer.valueOf(i2));
                    byte[] bArr2 = this.imc;
                    this.imc = new byte[i2];
                    System.arraycopy(bArr2, 0, this.imc, 0, this.imd);
                }
                System.arraycopy(bArr, 0, this.imc, this.imd, i);
                this.ilZ.d(this.imc, i2, false);
                this.imd = 0;
            } else if (bArr != null) {
                System.arraycopy(bArr, 0, this.imc, this.imd, i);
                this.imd = i2;
                ab.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", Integer.valueOf(this.imd));
            }
            if (z) {
                ab.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", Integer.valueOf(this.imd));
                this.ilZ.d(this.imc, this.imd, z);
                this.imd = 0;
            }
            AppMethodBeat.o(105651);
        }
    }
}
