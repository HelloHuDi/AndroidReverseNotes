package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.h;
import com.google.android.exoplayer2.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class a implements f {
    private final byte[] aTc;
    private final f bik;
    private final byte[] bil;
    private CipherInputStream bim;

    public a(f fVar, byte[] bArr, byte[] bArr2) {
        this.bik = fVar;
        this.aTc = bArr;
        this.bil = bArr2;
    }

    public final long a(i iVar) {
        RuntimeException runtimeException;
        AppMethodBeat.i(125894);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.aTc, "AES"), new IvParameterSpec(this.bil));
                this.bim = new CipherInputStream(new h(this.bik, iVar), instance);
                AppMethodBeat.o(125894);
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                runtimeException = new RuntimeException(e);
                AppMethodBeat.o(125894);
                throw runtimeException;
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(125894);
            throw runtimeException;
        }
    }

    public final void close() {
        AppMethodBeat.i(125895);
        this.bim = null;
        this.bik.close();
        AppMethodBeat.o(125895);
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(125896);
        com.google.android.exoplayer2.i.a.checkState(this.bim != null);
        int read = this.bim.read(bArr, i, i2);
        if (read < 0) {
            AppMethodBeat.o(125896);
            return -1;
        }
        AppMethodBeat.o(125896);
        return read;
    }

    public final Uri getUri() {
        AppMethodBeat.i(125897);
        Uri uri = this.bik.getUri();
        AppMethodBeat.o(125897);
        return uri;
    }
}
