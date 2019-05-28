package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.luggage.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.InputStream;

public final class d implements e {
    private long currentPosition;
    private String filePath;
    private String gSP;
    public a ikJ = null;

    public d(String str, String str2) {
        AppMethodBeat.i(137805);
        this.filePath = str;
        this.gSP = str2;
        this.ikJ = cA(str, str2);
        AppMethodBeat.o(137805);
    }

    public final boolean isOpen() {
        return this.ikJ != null;
    }

    public final void open() {
        AppMethodBeat.i(137806);
        ab.i("MicroMsg.WxaAudioDataSource", "open");
        if (this.ikJ == null) {
            this.ikJ = cA(this.filePath, this.gSP);
        }
        this.currentPosition = 0;
        if (this.ikJ != null) {
            this.ikJ.seek(0);
        }
        AppMethodBeat.o(137806);
    }

    private static a cA(String str, String str2) {
        AppMethodBeat.i(137807);
        long nanoTime = System.nanoTime();
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
            AppMethodBeat.o(137807);
            return null;
        }
        ao aoVar = new ao(new File(str2));
        if (!aoVar.gUe) {
            aoVar.close();
            ab.e("MicroMsg.WxaAudioDataSource", "pkg invalid");
            AppMethodBeat.o(137807);
            return null;
        } else if (aoVar.avW()) {
            InputStream xy = aoVar.xy(str);
            if (xy == null) {
                aoVar.close();
                ab.e("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", str);
                AppMethodBeat.o(137807);
                return null;
            }
            aoVar.close();
            ab.d("MicroMsg.WxaAudioDataSource", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
            a aVar = (a) xy;
            AppMethodBeat.o(137807);
            return aVar;
        } else {
            aoVar.close();
            ab.e("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
            AppMethodBeat.o(137807);
            return null;
        }
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        int i3 = -1;
        AppMethodBeat.i(137808);
        if (this.ikJ == null) {
            ab.e("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
            AppMethodBeat.o(137808);
        } else if (bArr == null || bArr.length <= 0) {
            ab.e("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
            AppMethodBeat.o(137808);
        } else if (j < 0 || i < 0 || i2 <= 0) {
            ab.e("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(137808);
        } else if (bArr == null || i + i2 <= bArr.length) {
            if (((long) i2) + j > getSize()) {
                ab.e("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(getSize()));
            }
            if (this.currentPosition != j) {
                this.ikJ.seek((int) j);
                this.currentPosition = j;
            }
            i3 = this.ikJ.read(bArr, i, i2);
            if (i3 >= 0) {
                this.currentPosition += (long) i3;
            }
            AppMethodBeat.o(137808);
        } else {
            ab.e("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
            AppMethodBeat.o(137808);
        }
        return i3;
    }

    public final long getSize() {
        AppMethodBeat.i(137809);
        if (this.ikJ == null) {
            ab.e("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
            AppMethodBeat.o(137809);
            return 0;
        }
        long length = this.ikJ.getLength();
        AppMethodBeat.o(137809);
        return length;
    }

    public final int acc() {
        AppMethodBeat.i(137810);
        if (this.ikJ == null) {
            this.ikJ = cA(this.filePath, this.gSP);
        }
        if (this.ikJ == null) {
            ab.e("MicroMsg.WxaAudioDataSource", "[getAudioType] inputStream is null");
            AppMethodBeat.o(137810);
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            ab.d("MicroMsg.WxaAudioDataSource", "[getAudioType] mp3");
            AppMethodBeat.o(137810);
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            ab.d("MicroMsg.WxaAudioDataSource", "[getAudioType] wav");
            AppMethodBeat.o(137810);
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            ab.d("MicroMsg.WxaAudioDataSource", "[getAudioType] ogg");
            AppMethodBeat.o(137810);
            return 4;
        } else {
            String str;
            try {
                byte[] bArr = new byte[64];
                this.ikJ.seek(0);
                this.ikJ.read(bArr);
                str = new String(bArr);
                this.ikJ.seek(0);
            } catch (Exception e) {
                ab.e("MicroMsg.WxaAudioDataSource", "getAudioType", e);
                this.ikJ.seek(0);
                str = null;
            } catch (Throwable th) {
                this.ikJ.seek(0);
                AppMethodBeat.o(137810);
            }
            if (str == null || !str.contains("ftyp")) {
                AppMethodBeat.o(137810);
                return 0;
            }
            ab.d("MicroMsg.WxaAudioDataSource", "[getAudioType] aac");
            AppMethodBeat.o(137810);
            return 1;
        }
    }

    public final void close() {
        AppMethodBeat.i(137811);
        a aVar = this.ikJ;
        if (aVar != null) {
            ab.i("MicroMsg.WxaAudioDataSource", "close");
            aVar.close();
            this.ikJ = null;
        }
        AppMethodBeat.o(137811);
    }
}
