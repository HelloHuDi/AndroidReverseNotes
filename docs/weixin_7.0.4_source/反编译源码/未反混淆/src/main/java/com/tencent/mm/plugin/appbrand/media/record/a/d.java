package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class d extends b {
    private int fQw = 2;
    private byte[] ime;
    private FileOutputStream mFileOutputStream;
    private String mFilePath = "";

    public final boolean h(String str, int i, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(105652);
        ab.i("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.mFilePath = str;
        this.fQw = i2;
        ab.i("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", Integer.valueOf(Mp3EncodeJni.init(i, i2, i, i3 / 1000, 5)));
        if (Mp3EncodeJni.init(i, i2, i, i3 / 1000, 5) == -1) {
            j.pk(17);
            AppMethodBeat.o(105652);
            return false;
        }
        ab.i("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", Integer.valueOf(Mp3EncodeJni.getVersion()));
        try {
            this.mFileOutputStream = new FileOutputStream(str);
        } catch (FileNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "init", new Object[0]);
            j.pk(18);
            z = false;
        }
        AppMethodBeat.o(105652);
        return z;
    }

    public final boolean a(boolean z, byte[] bArr, int i) {
        boolean z2 = true;
        AppMethodBeat.i(105653);
        if (this.ima <= 0) {
            ab.e("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", Integer.valueOf(this.ima));
            AppMethodBeat.o(105653);
            return false;
        } else if (this.mFileOutputStream == null) {
            ab.e("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
            AppMethodBeat.o(105653);
            return false;
        } else {
            if (this.ime == null) {
                ab.i("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", Integer.valueOf(this.fQw), Integer.valueOf(this.ima), Integer.valueOf((int) (7200.0d + (((double) (this.ima * this.fQw)) * 1.25d))));
                this.ime = new byte[r2];
            }
            short[] D = h.D(bArr, i);
            int encode = Mp3EncodeJni.encode(D, D, i / 2, this.ime);
            ab.d("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", Integer.valueOf(i), Integer.valueOf(D.length), Integer.valueOf(encode));
            if (encode > 0) {
                ab.d("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", Integer.valueOf(encode), Integer.valueOf(i));
                try {
                    this.mFileOutputStream.write(this.ime, 0, encode);
                    e(this.ime, encode, false);
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "encode write", new Object[0]);
                    j.pk(20);
                    z2 = false;
                }
            } else {
                ab.e("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", Integer.valueOf(encode));
                z2 = false;
            }
            AppMethodBeat.o(105653);
            return z2;
        }
    }

    public final void flush() {
        AppMethodBeat.i(105654);
        ab.i("MicroMsg.Record.MP3AudioEncoder", "flush");
        if (this.mFileOutputStream == null || this.ime == null) {
            ab.e("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
            AppMethodBeat.o(105654);
            return;
        }
        int flush = Mp3EncodeJni.flush(this.ime);
        if (flush > 0) {
            try {
                this.mFileOutputStream.write(this.ime, 0, flush);
                e(this.ime, flush, true);
                AppMethodBeat.o(105654);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "flush write", new Object[0]);
                j.pk(20);
                AppMethodBeat.o(105654);
                return;
            }
        }
        ab.e("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", Integer.valueOf(flush));
        AppMethodBeat.o(105654);
    }

    public final void close() {
        AppMethodBeat.i(105655);
        ab.i("MicroMsg.Record.MP3AudioEncoder", "close");
        Mp3EncodeJni.close();
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "close", new Object[0]);
                j.pk(20);
            }
            this.mFileOutputStream = null;
        }
        AppMethodBeat.o(105655);
    }
}
