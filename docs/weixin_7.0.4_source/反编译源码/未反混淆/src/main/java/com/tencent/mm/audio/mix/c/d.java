package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.c;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class d extends c {
    private c cll;
    private FileInputStream clm;
    private FileOutputStream outputStream;

    public d(c cVar, int i, int i2, int i3, String str) {
        AppMethodBeat.i(137019);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "AudioFixedConvertProcess src:%s, sample:%d, channels:%d, encodeBit:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        b.Dq();
        this.cll = cVar;
        this.clf = a.eh(str);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "outFile:%s", this.clf);
        new File(this.clf).delete();
        try {
            this.outputStream = new FileOutputStream(a.ei(this.clf));
        } catch (FileNotFoundException e) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "new FileOutputStream", new Object[0]);
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "new FileOutputStream", new Object[0]);
        }
        try {
            this.clm = new FileInputStream(a.ei(this.clf));
        } catch (FileNotFoundException e3) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e3, "new FileInputStream", new Object[0]);
        } catch (Exception e22) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e22, "new FileInputStream", new Object[0]);
        }
        this.cle = str;
        this.ckY = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        this.ckZ = 2;
        this.cla = 2;
        C(i, i2, i3);
        AppMethodBeat.o(137019);
    }

    public final byte[] F(byte[] bArr) {
        AppMethodBeat.i(137020);
        if (bArr == null) {
            AppMethodBeat.o(137020);
            return bArr;
        }
        bArr = super.F(bArr);
        if (this.outputStream == null) {
            AppMethodBeat.o(137020);
            return bArr;
        } else if (bArr != null) {
            try {
                this.outputStream.write(bArr, 0, bArr.length);
            } catch (Exception e) {
                b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "write", new Object[0]);
            }
            AppMethodBeat.o(137020);
            return bArr;
        } else {
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "desdata is null");
            AppMethodBeat.o(137020);
            return null;
        }
    }

    public final void Ds() {
        AppMethodBeat.i(137021);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "finishProcess");
        try {
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
                this.outputStream = null;
            }
        } catch (Exception e) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "finishProcess", new Object[0]);
        }
        Runtime.getRuntime().gc();
        AppMethodBeat.o(137021);
    }

    public final com.tencent.mm.audio.mix.a.d Dt() {
        AppMethodBeat.i(137022);
        if (this.clm == null) {
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack, inputStream is null");
            AppMethodBeat.o(137022);
            return null;
        }
        byte[] bArr = new byte[3536];
        try {
            if (this.clm.read(bArr, 0, 3536) > 0) {
                com.tencent.mm.audio.mix.a.d Dj = com.tencent.mm.audio.mix.b.c.Dk().Dj();
                Dj.ckv = bArr;
                AppMethodBeat.o(137022);
                return Dj;
            }
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack readSize is 0");
            AppMethodBeat.o(137022);
            return null;
        } catch (Exception e) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "readPcmDataTrack", new Object[0]);
            AppMethodBeat.o(137022);
            return null;
        }
    }

    public final void flushCache() {
        AppMethodBeat.i(137023);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache");
        if (this.clm == null) {
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, inputStream is null");
            AppMethodBeat.o(137023);
        } else if (this.cll.cky) {
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, cache is complete");
            AppMethodBeat.o(137023);
        } else {
            int i = 0;
            while (i != -1) {
                int read;
                byte[] bArr = new byte[3536];
                try {
                    read = this.clm.read(bArr, 0, 3536);
                } catch (Exception e) {
                    b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "readPcmDataTrack", new Object[0]);
                    read = i;
                }
                if (read > 0) {
                    com.tencent.mm.audio.mix.a.d Dj = com.tencent.mm.audio.mix.b.c.Dk().Dj();
                    Dj.ckv = bArr;
                    this.cll.a(Dj);
                }
                i = read;
            }
            this.cll.complete();
            AppMethodBeat.o(137023);
        }
    }

    public final void release() {
        AppMethodBeat.i(137024);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "release");
        super.release();
        try {
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
                this.outputStream = null;
            }
        } catch (Exception e) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "outputStream close", new Object[0]);
        }
        try {
            if (this.clm != null) {
                this.clm.close();
                this.clm = null;
            }
            AppMethodBeat.o(137024);
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "inputStream close", new Object[0]);
            AppMethodBeat.o(137024);
        }
    }

    public final h Dr() {
        AppMethodBeat.i(137025);
        i iVar = new i();
        AppMethodBeat.o(137025);
        return iVar;
    }
}
