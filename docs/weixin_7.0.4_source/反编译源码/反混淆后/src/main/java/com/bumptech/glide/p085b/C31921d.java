package com.bumptech.glide.p085b;

import android.util.Log;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.b.d */
public final class C31921d {
    public final byte[] ayl = new byte[256];
    public ByteBuffer aym;
    public C0741c ayn;
    public int blockSize = 0;

    public C31921d() {
        AppMethodBeat.m2504i(123372);
        AppMethodBeat.m2505o(123372);
    }

    /* renamed from: lY */
    public final void mo52037lY() {
        AppMethodBeat.m2504i(123373);
        int i = 0;
        while (i == 0 && !mo52039md() && this.ayn.frameCount <= BaseClientBuilder.API_PRIORITY_OTHER) {
            int read;
            switch (read()) {
                case 33:
                    switch (read()) {
                        case 1:
                            m51830mb();
                            break;
                        case 249:
                            boolean z;
                            this.ayn.aye = new C17512b();
                            read();
                            read = read();
                            this.ayn.aye.axZ = (read & 28) >> 2;
                            if (this.ayn.aye.axZ == 0) {
                                this.ayn.aye.axZ = 1;
                            }
                            C17512b c17512b = this.ayn.aye;
                            if ((read & 1) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            c17512b.axY = z;
                            read = this.aym.getShort();
                            if (read < 2) {
                                read = 10;
                            }
                            this.ayn.aye.delay = read * 10;
                            this.ayn.aye.aya = read();
                            read();
                            break;
                        case C31128d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                            m51830mb();
                            break;
                        case 255:
                            m51831mc();
                            StringBuilder stringBuilder = new StringBuilder();
                            for (read = 0; read < 11; read++) {
                                stringBuilder.append((char) this.ayl[read]);
                            }
                            if (!stringBuilder.toString().equals("NETSCAPE2.0")) {
                                m51830mb();
                                break;
                            } else {
                                m51829lZ();
                                break;
                            }
                        default:
                            m51830mb();
                            break;
                    }
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    boolean z2;
                    if (this.ayn.aye == null) {
                        this.ayn.aye = new C17512b();
                    }
                    this.ayn.aye.axT = this.aym.getShort();
                    this.ayn.aye.axU = this.aym.getShort();
                    this.ayn.aye.axV = this.aym.getShort();
                    this.ayn.aye.axW = this.aym.getShort();
                    int read2 = read();
                    read = (read2 & 128) != 0 ? 1 : 0;
                    int pow = (int) Math.pow(2.0d, (double) ((read2 & 7) + 1));
                    C17512b c17512b2 = this.ayn.aye;
                    if ((read2 & 64) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    c17512b2.axX = z2;
                    if (read != 0) {
                        this.ayn.aye.ayc = m51828dc(pow);
                    } else {
                        this.ayn.aye.ayc = null;
                    }
                    this.ayn.aye.ayb = this.aym.position();
                    read();
                    m51830mb();
                    if (!mo52039md()) {
                        C0741c c0741c = this.ayn;
                        c0741c.frameCount++;
                        this.ayn.ayf.add(this.ayn.aye);
                        break;
                    }
                    break;
                case C2206au.CTRL_INDEX /*59*/:
                    i = 1;
                    break;
                default:
                    this.ayn.status = 1;
                    break;
            }
        }
        AppMethodBeat.m2505o(123373);
    }

    /* renamed from: lZ */
    private void m51829lZ() {
        AppMethodBeat.m2504i(123374);
        do {
            m51831mc();
            if (this.ayl[0] == (byte) 1) {
                this.ayn.ayk = (this.ayl[1] & 255) | ((this.ayl[2] & 255) << 8);
            }
            if (this.blockSize <= 0) {
                break;
            }
        } while (!mo52039md());
        AppMethodBeat.m2505o(123374);
    }

    /* renamed from: ma */
    public final void mo52038ma() {
        int i;
        boolean z = true;
        AppMethodBeat.m2504i(123375);
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < 6; i++) {
            stringBuilder.append((char) read());
        }
        if (stringBuilder.toString().startsWith("GIF")) {
            this.ayn.width = this.aym.getShort();
            this.ayn.height = this.aym.getShort();
            i = read();
            C0741c c0741c = this.ayn;
            if ((i & 128) == 0) {
                z = false;
            }
            c0741c.ayg = z;
            this.ayn.ayh = (int) Math.pow(2.0d, (double) ((i & 7) + 1));
            this.ayn.ayi = read();
            this.ayn.ayj = read();
            if (this.ayn.ayg && !mo52039md()) {
                this.ayn.ayd = m51828dc(this.ayn.ayh);
                this.ayn.bgColor = this.ayn.ayd[this.ayn.ayi];
            }
            AppMethodBeat.m2505o(123375);
            return;
        }
        this.ayn.status = 1;
        AppMethodBeat.m2505o(123375);
    }

    /* renamed from: dc */
    private int[] m51828dc(int i) {
        AppMethodBeat.m2504i(123376);
        int[] iArr = null;
        byte[] bArr = new byte[(i * 3)];
        try {
            this.aym.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & 255;
                i2 = i6 + 1;
                i4 = i3 + 1;
                iArr[i3] = (((i5 << 16) | WebView.NIGHT_MODE_COLOR) | (i7 << 8)) | (bArr[i6] & 255);
                i3 = i4;
            }
        } catch (BufferUnderflowException e) {
            Log.isLoggable("GifHeaderParser", 3);
            this.ayn.status = 1;
        }
        AppMethodBeat.m2505o(123376);
        return iArr;
    }

    /* renamed from: mb */
    private void m51830mb() {
        AppMethodBeat.m2504i(123377);
        int read;
        do {
            read = read();
            this.aym.position(Math.min(this.aym.position() + read, this.aym.limit()));
        } while (read > 0);
        AppMethodBeat.m2505o(123377);
    }

    /* renamed from: mc */
    private void m51831mc() {
        int i = 0;
        AppMethodBeat.m2504i(123378);
        this.blockSize = read();
        if (this.blockSize > 0) {
            int i2 = 0;
            while (true) {
                int i3;
                try {
                    i3 = i;
                    if (i3 < this.blockSize) {
                        i2 = this.blockSize - i3;
                        this.aym.get(this.ayl, i3, i2);
                        i = i3 + i2;
                    } else {
                        AppMethodBeat.m2505o(123378);
                        return;
                    }
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        new StringBuilder("Error Reading Block n: ").append(i3).append(" count: ").append(i2).append(" blockSize: ").append(this.blockSize);
                    }
                    this.ayn.status = 1;
                }
            }
        }
        AppMethodBeat.m2505o(123378);
    }

    private int read() {
        AppMethodBeat.m2504i(123379);
        int i = 0;
        try {
            i = this.aym.get() & 255;
        } catch (Exception e) {
            this.ayn.status = 1;
        }
        AppMethodBeat.m2505o(123379);
        return i;
    }

    /* renamed from: md */
    public final boolean mo52039md() {
        return this.ayn.status != 0;
    }
}
