package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public int aRX;
    public int aRY;
    public final CryptoInfo aRZ;
    private final a aSa;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;

    @TargetApi(24)
    static final class a {
        final CryptoInfo aRZ;
        final Pattern aSb;

        /* synthetic */ a(CryptoInfo cryptoInfo, byte b) {
            this(cryptoInfo);
        }

        private a(CryptoInfo cryptoInfo) {
            AppMethodBeat.i(94736);
            this.aRZ = cryptoInfo;
            this.aSb = new Pattern(0, 0);
            AppMethodBeat.o(94736);
        }
    }

    public b() {
        CryptoInfo cryptoInfo;
        a aVar = null;
        AppMethodBeat.i(94737);
        if (v.SDK_INT >= 16) {
            cryptoInfo = new CryptoInfo();
        } else {
            cryptoInfo = null;
        }
        this.aRZ = cryptoInfo;
        if (v.SDK_INT >= 24) {
            aVar = new a(this.aRZ, (byte) 0);
        }
        this.aSa = aVar;
        AppMethodBeat.o(94737);
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        AppMethodBeat.i(94738);
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.aRX = i3;
        this.aRY = i4;
        if (v.SDK_INT >= 16) {
            this.aRZ.numSubSamples = this.numSubSamples;
            this.aRZ.numBytesOfClearData = this.numBytesOfClearData;
            this.aRZ.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            this.aRZ.key = this.key;
            this.aRZ.iv = this.iv;
            this.aRZ.mode = this.mode;
            if (v.SDK_INT >= 24) {
                a aVar = this.aSa;
                aVar.aSb.set(this.aRX, this.aRY);
                aVar.aRZ.setPattern(aVar.aSb);
            }
        }
        AppMethodBeat.o(94738);
    }
}
