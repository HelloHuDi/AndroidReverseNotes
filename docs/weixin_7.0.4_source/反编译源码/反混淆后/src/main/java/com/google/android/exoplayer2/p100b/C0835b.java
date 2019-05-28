package com.google.android.exoplayer2.p100b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.b.b */
public final class C0835b {
    public int aRX;
    public int aRY;
    public final CryptoInfo aRZ;
    private final C0836a aSa;
    /* renamed from: iv */
    public byte[] f1032iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;

    @TargetApi(24)
    /* renamed from: com.google.android.exoplayer2.b.b$a */
    static final class C0836a {
        final CryptoInfo aRZ;
        final Pattern aSb;

        /* synthetic */ C0836a(CryptoInfo cryptoInfo, byte b) {
            this(cryptoInfo);
        }

        private C0836a(CryptoInfo cryptoInfo) {
            AppMethodBeat.m2504i(94736);
            this.aRZ = cryptoInfo;
            this.aSb = new Pattern(0, 0);
            AppMethodBeat.m2505o(94736);
        }
    }

    public C0835b() {
        CryptoInfo cryptoInfo;
        C0836a c0836a = null;
        AppMethodBeat.m2504i(94737);
        if (C17675v.SDK_INT >= 16) {
            cryptoInfo = new CryptoInfo();
        } else {
            cryptoInfo = null;
        }
        this.aRZ = cryptoInfo;
        if (C17675v.SDK_INT >= 24) {
            c0836a = new C0836a(this.aRZ, (byte) 0);
        }
        this.aSa = c0836a;
        AppMethodBeat.m2505o(94737);
    }

    /* renamed from: a */
    public final void mo2543a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(94738);
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f1032iv = bArr2;
        this.mode = i2;
        this.aRX = i3;
        this.aRY = i4;
        if (C17675v.SDK_INT >= 16) {
            this.aRZ.numSubSamples = this.numSubSamples;
            this.aRZ.numBytesOfClearData = this.numBytesOfClearData;
            this.aRZ.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            this.aRZ.key = this.key;
            this.aRZ.iv = this.f1032iv;
            this.aRZ.mode = this.mode;
            if (C17675v.SDK_INT >= 24) {
                C0836a c0836a = this.aSa;
                c0836a.aSb.set(this.aRX, this.aRY);
                c0836a.aRZ.setPattern(c0836a.aSb);
            }
        }
        AppMethodBeat.m2505o(94738);
    }
}
