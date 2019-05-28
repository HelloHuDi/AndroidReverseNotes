package com.google.android.exoplayer2.source.p112b;

import android.net.Uri;
import com.google.android.exoplayer2.p110h.C0867f;
import com.google.android.exoplayer2.p110h.C17665i;
import com.google.android.exoplayer2.p110h.C25540h;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.exoplayer2.source.b.a */
final class C37274a implements C0867f {
    private final byte[] aTc;
    private final C0867f bik;
    private final byte[] bil;
    private CipherInputStream bim;

    public C37274a(C0867f c0867f, byte[] bArr, byte[] bArr2) {
        this.bik = c0867f;
        this.aTc = bArr;
        this.bil = bArr2;
    }

    /* renamed from: a */
    public final long mo2583a(C17665i c17665i) {
        RuntimeException runtimeException;
        AppMethodBeat.m2504i(125894);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.aTc, "AES"), new IvParameterSpec(this.bil));
                this.bim = new CipherInputStream(new C25540h(this.bik, c17665i), instance);
                AppMethodBeat.m2505o(125894);
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                runtimeException = new RuntimeException(e);
                AppMethodBeat.m2505o(125894);
                throw runtimeException;
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            runtimeException = new RuntimeException(e2);
            AppMethodBeat.m2505o(125894);
            throw runtimeException;
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(125895);
        this.bim = null;
        this.bik.close();
        AppMethodBeat.m2505o(125895);
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(125896);
        C45039a.checkState(this.bim != null);
        int read = this.bim.read(bArr, i, i2);
        if (read < 0) {
            AppMethodBeat.m2505o(125896);
            return -1;
        }
        AppMethodBeat.m2505o(125896);
        return read;
    }

    public final Uri getUri() {
        AppMethodBeat.m2504i(125897);
        Uri uri = this.bik.getUri();
        AppMethodBeat.m2505o(125897);
        return uri;
    }
}
