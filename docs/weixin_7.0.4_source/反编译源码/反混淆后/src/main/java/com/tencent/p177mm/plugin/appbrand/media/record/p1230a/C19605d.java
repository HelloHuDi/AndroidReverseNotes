package com.tencent.p177mm.plugin.appbrand.media.record.p1230a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import com.tencent.p177mm.plugin.appbrand.media.record.C27202h;
import com.tencent.p177mm.plugin.appbrand.media.record.C27203j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.a.d */
public final class C19605d extends C27198b {
    private int fQw = 2;
    private byte[] ime;
    private FileOutputStream mFileOutputStream;
    private String mFilePath = "";

    /* renamed from: h */
    public final boolean mo34814h(String str, int i, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.m2504i(105652);
        C4990ab.m7417i("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.mFilePath = str;
        this.fQw = i2;
        C4990ab.m7417i("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", Integer.valueOf(Mp3EncodeJni.init(i, i2, i, i3 / 1000, 5)));
        if (Mp3EncodeJni.init(i, i2, i, i3 / 1000, 5) == -1) {
            C27203j.m43227pk(17);
            AppMethodBeat.m2505o(105652);
            return false;
        }
        C4990ab.m7417i("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", Integer.valueOf(Mp3EncodeJni.getVersion()));
        try {
            this.mFileOutputStream = new FileOutputStream(str);
        } catch (FileNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "init", new Object[0]);
            C27203j.m43227pk(18);
            z = false;
        }
        AppMethodBeat.m2505o(105652);
        return z;
    }

    /* renamed from: a */
    public final boolean mo34811a(boolean z, byte[] bArr, int i) {
        boolean z2 = true;
        AppMethodBeat.m2504i(105653);
        if (this.ima <= 0) {
            C4990ab.m7413e("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", Integer.valueOf(this.ima));
            AppMethodBeat.m2505o(105653);
            return false;
        } else if (this.mFileOutputStream == null) {
            C4990ab.m7412e("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
            AppMethodBeat.m2505o(105653);
            return false;
        } else {
            if (this.ime == null) {
                C4990ab.m7417i("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", Integer.valueOf(this.fQw), Integer.valueOf(this.ima), Integer.valueOf((int) (7200.0d + (((double) (this.ima * this.fQw)) * 1.25d))));
                this.ime = new byte[r2];
            }
            short[] D = C27202h.m43224D(bArr, i);
            int encode = Mp3EncodeJni.encode(D, D, i / 2, this.ime);
            C4990ab.m7411d("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", Integer.valueOf(i), Integer.valueOf(D.length), Integer.valueOf(encode));
            if (encode > 0) {
                C4990ab.m7411d("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", Integer.valueOf(encode), Integer.valueOf(i));
                try {
                    this.mFileOutputStream.write(this.ime, 0, encode);
                    mo44864e(this.ime, encode, false);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "encode write", new Object[0]);
                    C27203j.m43227pk(20);
                    z2 = false;
                }
            } else {
                C4990ab.m7413e("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", Integer.valueOf(encode));
                z2 = false;
            }
            AppMethodBeat.m2505o(105653);
            return z2;
        }
    }

    public final void flush() {
        AppMethodBeat.m2504i(105654);
        C4990ab.m7416i("MicroMsg.Record.MP3AudioEncoder", "flush");
        if (this.mFileOutputStream == null || this.ime == null) {
            C4990ab.m7412e("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
            AppMethodBeat.m2505o(105654);
            return;
        }
        int flush = Mp3EncodeJni.flush(this.ime);
        if (flush > 0) {
            try {
                this.mFileOutputStream.write(this.ime, 0, flush);
                mo44864e(this.ime, flush, true);
                AppMethodBeat.m2505o(105654);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "flush write", new Object[0]);
                C27203j.m43227pk(20);
                AppMethodBeat.m2505o(105654);
                return;
            }
        }
        C4990ab.m7413e("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", Integer.valueOf(flush));
        AppMethodBeat.m2505o(105654);
    }

    public final void close() {
        AppMethodBeat.m2504i(105655);
        C4990ab.m7416i("MicroMsg.Record.MP3AudioEncoder", "close");
        Mp3EncodeJni.close();
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "close", new Object[0]);
                C27203j.m43227pk(20);
            }
            this.mFileOutputStream = null;
        }
        AppMethodBeat.m2505o(105655);
    }
}
