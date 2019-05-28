package com.tencent.p177mm.audio.mix.p1183c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C37486c;
import com.tencent.p177mm.audio.mix.p197h.C41782a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* renamed from: com.tencent.mm.audio.mix.c.d */
public final class C32314d extends C24655c {
    private C37484c cll;
    private FileInputStream clm;
    private FileOutputStream outputStream;

    public C32314d(C37484c c37484c, int i, int i2, int i3, String str) {
        AppMethodBeat.m2504i(137019);
        C45174b.m83210i("MicroMsg.Mix.AudioFixedConvertProcess", "AudioFixedConvertProcess src:%s, sample:%d, channels:%d, encodeBit:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        C41774b.m73738Dq();
        this.cll = c37484c;
        this.clf = C41782a.m73753eh(str);
        C45174b.m83210i("MicroMsg.Mix.AudioFixedConvertProcess", "outFile:%s", this.clf);
        new File(this.clf).delete();
        try {
            this.outputStream = new FileOutputStream(C41782a.m73754ei(this.clf));
        } catch (FileNotFoundException e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "new FileOutputStream", new Object[0]);
        } catch (Exception e2) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "new FileOutputStream", new Object[0]);
        }
        try {
            this.clm = new FileInputStream(C41782a.m73754ei(this.clf));
        } catch (FileNotFoundException e3) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e3, "new FileInputStream", new Object[0]);
        } catch (Exception e22) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e22, "new FileInputStream", new Object[0]);
        }
        this.cle = str;
        this.ckY = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        this.ckZ = 2;
        this.cla = 2;
        mo33486C(i, i2, i3);
        AppMethodBeat.m2505o(137019);
    }

    /* renamed from: F */
    public final byte[] mo33489F(byte[] bArr) {
        AppMethodBeat.m2504i(137020);
        if (bArr == null) {
            AppMethodBeat.m2505o(137020);
            return bArr;
        }
        bArr = super.mo33489F(bArr);
        if (this.outputStream == null) {
            AppMethodBeat.m2505o(137020);
            return bArr;
        } else if (bArr != null) {
            try {
                this.outputStream.write(bArr, 0, bArr.length);
            } catch (Exception e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "write", new Object[0]);
            }
            AppMethodBeat.m2505o(137020);
            return bArr;
        } else {
            C45174b.m83207e("MicroMsg.Mix.AudioFixedConvertProcess", "desdata is null");
            AppMethodBeat.m2505o(137020);
            return null;
        }
    }

    /* renamed from: Ds */
    public final void mo33487Ds() {
        AppMethodBeat.m2504i(137021);
        C45174b.m83209i("MicroMsg.Mix.AudioFixedConvertProcess", "finishProcess");
        try {
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
                this.outputStream = null;
            }
        } catch (Exception e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "finishProcess", new Object[0]);
        }
        Runtime.getRuntime().gc();
        AppMethodBeat.m2505o(137021);
    }

    /* renamed from: Dt */
    public final C45164d mo33488Dt() {
        AppMethodBeat.m2504i(137022);
        if (this.clm == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack, inputStream is null");
            AppMethodBeat.m2505o(137022);
            return null;
        }
        byte[] bArr = new byte[3536];
        try {
            if (this.clm.read(bArr, 0, 3536) > 0) {
                C45164d Dj = C37486c.m63255Dk().mo60403Dj();
                Dj.ckv = bArr;
                AppMethodBeat.m2505o(137022);
                return Dj;
            }
            C45174b.m83207e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack readSize is 0");
            AppMethodBeat.m2505o(137022);
            return null;
        } catch (Exception e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "readPcmDataTrack", new Object[0]);
            AppMethodBeat.m2505o(137022);
            return null;
        }
    }

    public final void flushCache() {
        AppMethodBeat.m2504i(137023);
        C45174b.m83209i("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache");
        if (this.clm == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, inputStream is null");
            AppMethodBeat.m2505o(137023);
        } else if (this.cll.cky) {
            C45174b.m83207e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, cache is complete");
            AppMethodBeat.m2505o(137023);
        } else {
            int i = 0;
            while (i != -1) {
                int read;
                byte[] bArr = new byte[3536];
                try {
                    read = this.clm.read(bArr, 0, 3536);
                } catch (Exception e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "readPcmDataTrack", new Object[0]);
                    read = i;
                }
                if (read > 0) {
                    C45164d Dj = C37486c.m63255Dk().mo60403Dj();
                    Dj.ckv = bArr;
                    this.cll.mo60396a(Dj);
                }
                i = read;
            }
            this.cll.complete();
            AppMethodBeat.m2505o(137023);
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(137024);
        C45174b.m83209i("MicroMsg.Mix.AudioFixedConvertProcess", "release");
        super.release();
        try {
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
                this.outputStream = null;
            }
        } catch (Exception e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e, "outputStream close", new Object[0]);
        }
        try {
            if (this.clm != null) {
                this.clm.close();
                this.clm = null;
            }
            AppMethodBeat.m2505o(137024);
        } catch (Exception e2) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "inputStream close", new Object[0]);
            AppMethodBeat.m2505o(137024);
        }
    }

    /* renamed from: Dr */
    public final C41775h mo41540Dr() {
        AppMethodBeat.m2504i(137025);
        C44681i c44681i = new C44681i();
        AppMethodBeat.m2505o(137025);
        return c44681i;
    }
}
