package com.bumptech.glide.b;

import android.util.Log;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.wav.WavFileHeader;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public final class d {
    public final byte[] ayl = new byte[256];
    public ByteBuffer aym;
    public c ayn;
    public int blockSize = 0;

    public d() {
        AppMethodBeat.i(123372);
        AppMethodBeat.o(123372);
    }

    public final void lY() {
        AppMethodBeat.i(123373);
        int i = 0;
        while (i == 0 && !md() && this.ayn.frameCount <= BaseClientBuilder.API_PRIORITY_OTHER) {
            int read;
            switch (read()) {
                case 33:
                    switch (read()) {
                        case 1:
                            mb();
                            break;
                        case 249:
                            boolean z;
                            this.ayn.aye = new b();
                            read();
                            read = read();
                            this.ayn.aye.axZ = (read & 28) >> 2;
                            if (this.ayn.aye.axZ == 0) {
                                this.ayn.aye.axZ = 1;
                            }
                            b bVar = this.ayn.aye;
                            if ((read & 1) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            bVar.axY = z;
                            read = this.aym.getShort();
                            if (read < 2) {
                                read = 10;
                            }
                            this.ayn.aye.delay = read * 10;
                            this.ayn.aye.aya = read();
                            read();
                            break;
                        case com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                            mb();
                            break;
                        case 255:
                            mc();
                            StringBuilder stringBuilder = new StringBuilder();
                            for (read = 0; read < 11; read++) {
                                stringBuilder.append((char) this.ayl[read]);
                            }
                            if (!stringBuilder.toString().equals("NETSCAPE2.0")) {
                                mb();
                                break;
                            } else {
                                lZ();
                                break;
                            }
                        default:
                            mb();
                            break;
                    }
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    boolean z2;
                    if (this.ayn.aye == null) {
                        this.ayn.aye = new b();
                    }
                    this.ayn.aye.axT = this.aym.getShort();
                    this.ayn.aye.axU = this.aym.getShort();
                    this.ayn.aye.axV = this.aym.getShort();
                    this.ayn.aye.axW = this.aym.getShort();
                    int read2 = read();
                    read = (read2 & 128) != 0 ? 1 : 0;
                    int pow = (int) Math.pow(2.0d, (double) ((read2 & 7) + 1));
                    b bVar2 = this.ayn.aye;
                    if ((read2 & 64) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    bVar2.axX = z2;
                    if (read != 0) {
                        this.ayn.aye.ayc = dc(pow);
                    } else {
                        this.ayn.aye.ayc = null;
                    }
                    this.ayn.aye.ayb = this.aym.position();
                    read();
                    mb();
                    if (!md()) {
                        c cVar = this.ayn;
                        cVar.frameCount++;
                        this.ayn.ayf.add(this.ayn.aye);
                        break;
                    }
                    break;
                case au.CTRL_INDEX /*59*/:
                    i = 1;
                    break;
                default:
                    this.ayn.status = 1;
                    break;
            }
        }
        AppMethodBeat.o(123373);
    }

    private void lZ() {
        AppMethodBeat.i(123374);
        do {
            mc();
            if (this.ayl[0] == (byte) 1) {
                this.ayn.ayk = (this.ayl[1] & 255) | ((this.ayl[2] & 255) << 8);
            }
            if (this.blockSize <= 0) {
                break;
            }
        } while (!md());
        AppMethodBeat.o(123374);
    }

    public final void ma() {
        int i;
        boolean z = true;
        AppMethodBeat.i(123375);
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < 6; i++) {
            stringBuilder.append((char) read());
        }
        if (stringBuilder.toString().startsWith("GIF")) {
            this.ayn.width = this.aym.getShort();
            this.ayn.height = this.aym.getShort();
            i = read();
            c cVar = this.ayn;
            if ((i & 128) == 0) {
                z = false;
            }
            cVar.ayg = z;
            this.ayn.ayh = (int) Math.pow(2.0d, (double) ((i & 7) + 1));
            this.ayn.ayi = read();
            this.ayn.ayj = read();
            if (this.ayn.ayg && !md()) {
                this.ayn.ayd = dc(this.ayn.ayh);
                this.ayn.bgColor = this.ayn.ayd[this.ayn.ayi];
            }
            AppMethodBeat.o(123375);
            return;
        }
        this.ayn.status = 1;
        AppMethodBeat.o(123375);
    }

    private int[] dc(int i) {
        AppMethodBeat.i(123376);
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
        AppMethodBeat.o(123376);
        return iArr;
    }

    private void mb() {
        AppMethodBeat.i(123377);
        int read;
        do {
            read = read();
            this.aym.position(Math.min(this.aym.position() + read, this.aym.limit()));
        } while (read > 0);
        AppMethodBeat.o(123377);
    }

    private void mc() {
        int i = 0;
        AppMethodBeat.i(123378);
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
                        AppMethodBeat.o(123378);
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
        AppMethodBeat.o(123378);
    }

    private int read() {
        AppMethodBeat.i(123379);
        int i = 0;
        try {
            i = this.aym.get() & 255;
        } catch (Exception e) {
            this.ayn.status = 1;
        }
        AppMethodBeat.o(123379);
        return i;
    }

    public final boolean md() {
        return this.ayn.status != 0;
    }
}
