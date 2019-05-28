package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.ao.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e implements com.tencent.mm.ag.e {
    private static ae<String, Integer> ikK = new ae(50);
    private static ae<String, Integer> ikL = new ae(50);
    private static ae<String, Integer> ikM = new ae(50);
    private long currentPosition;
    private String filePath;
    private String gSP;
    private int gUl = -1;
    private int ikN = -1;
    public RandomAccessFile randomAccessFile;

    static {
        AppMethodBeat.i(137819);
        AppMethodBeat.o(137819);
    }

    public e(String str, String str2) {
        AppMethodBeat.i(137812);
        this.filePath = str;
        this.gSP = str2;
        this.randomAccessFile = cB(str, str2);
        if (ikK.aj(str) && ikL.aj(str)) {
            this.ikN = ((Integer) ikK.get(str)).intValue();
            this.gUl = ((Integer) ikL.get(str)).intValue();
            AppMethodBeat.o(137812);
        } else if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
            AppMethodBeat.o(137812);
        } else {
            ao aoVar = new ao(str2);
            if (!aoVar.gUe) {
                aoVar.close();
                ab.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
                AppMethodBeat.o(137812);
            } else if (aoVar.avW()) {
                a xx = aoVar.xx(str);
                if (xx == null) {
                    aoVar.close();
                    ab.e("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
                    AppMethodBeat.o(137812);
                } else if (xx.gUm <= 0 || xx.gUl <= 0) {
                    aoVar.close();
                    ab.e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
                    AppMethodBeat.o(137812);
                } else {
                    this.ikN = xx.gUm;
                    this.gUl = xx.gUl;
                    ikK.put(str, Integer.valueOf(this.ikN));
                    ikL.put(str, Integer.valueOf(this.gUl));
                    aoVar.close();
                    AppMethodBeat.o(137812);
                }
            } else {
                aoVar.close();
                ab.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
                AppMethodBeat.o(137812);
            }
        }
    }

    public final boolean isOpen() {
        return this.randomAccessFile != null || this.ikN == -1 || this.gUl == -1;
    }

    public final void open() {
        AppMethodBeat.i(137813);
        ab.i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", Integer.valueOf(hashCode()));
        if (this.randomAccessFile == null) {
            this.randomAccessFile = cB(this.filePath, this.gSP);
        }
        this.currentPosition = 0;
        if (this.randomAccessFile != null) {
            this.randomAccessFile.seek((long) this.gUl);
        }
        AppMethodBeat.o(137813);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007a A:{Splitter:B:4:0x003b, ExcHandler: FileNotFoundException (r1_8 'e' java.io.FileNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009a A:{SYNTHETIC, Splitter:B:21:0x009a} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x007a, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:16:0x007b, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", r1, "", new java.lang.Object[0]);
            com.tencent.matrix.trace.core.AppMethodBeat.o(137814);
     */
    /* JADX WARNING: Missing block: B:17:0x008a, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:18:0x008b, code skipped:
            r2 = r1;
            r3 = null;
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private RandomAccessFile cB(String str, String str2) {
        AppMethodBeat.i(137814);
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
            AppMethodBeat.o(137814);
            return null;
        }
        ab.i("MicroMsg.WxaAudioDataSourceBelow19", "filePath:%s, resLength:%d, fileOffset:%d", str, Integer.valueOf(this.ikN), Integer.valueOf(this.gUl));
        RandomAccessFile ck;
        try {
            if (new b(str2).exists()) {
                ck = com.tencent.mm.vfs.e.ck(str2, false);
                ab.d("MicroMsg.WxaAudioDataSourceBelow19", "randomAccessFile.length:%d", Long.valueOf(ck.length()));
                AppMethodBeat.o(137814);
                return ck;
            }
            ab.e("MicroMsg.WxaAudioDataSourceBelow19", "file pkgPath:%s isn't exist ", str2);
            AppMethodBeat.o(137814);
            return null;
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
            Throwable e3 = e2;
            RandomAccessFile randomAccessFile = ck;
            ab.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", e3, "", new Object[0]);
            if (randomAccessFile != null) {
            }
            AppMethodBeat.o(137814);
            return null;
        }
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        int i3 = -1;
        AppMethodBeat.i(137815);
        if (this.randomAccessFile == null) {
            ab.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
            AppMethodBeat.o(137815);
        } else {
            if (this.currentPosition != j) {
                this.randomAccessFile.seek(((long) this.gUl) + j);
                this.currentPosition = j;
            }
            if (bArr == null || bArr.length <= 0) {
                ab.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
                AppMethodBeat.o(137815);
            } else if (j < 0 || i < 0 || i2 <= 0) {
                ab.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.o(137815);
            } else if (bArr != null && i + i2 > bArr.length) {
                ab.e("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
                AppMethodBeat.o(137815);
            } else if (j >= ((long) this.ikN)) {
                ab.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", Long.valueOf(j), Integer.valueOf(this.ikN));
                AppMethodBeat.o(137815);
            } else {
                if (((long) i2) + j >= ((long) this.ikN)) {
                    ab.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(this.ikN));
                    i2 = (int) (((long) this.ikN) - j);
                }
                i3 = this.randomAccessFile.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.currentPosition += (long) i3;
                } else {
                    ab.e("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", Integer.valueOf(i3));
                }
                AppMethodBeat.o(137815);
            }
        }
        return i3;
    }

    public final long getSize() {
        AppMethodBeat.i(137816);
        if (this.randomAccessFile == null) {
            ab.e("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
            AppMethodBeat.o(137816);
            return 0;
        }
        long j = (long) this.ikN;
        AppMethodBeat.o(137816);
        return j;
    }

    public final int acc() {
        AppMethodBeat.i(137817);
        if (this.randomAccessFile == null) {
            this.randomAccessFile = cB(this.filePath, this.gSP);
        }
        if (ikM.aj(this.filePath)) {
            int intValue = ((Integer) ikM.get(this.filePath)).intValue();
            AppMethodBeat.o(137817);
            return intValue;
        } else if (this.randomAccessFile == null) {
            ab.e("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
            AppMethodBeat.o(137817);
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            ab.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
            AppMethodBeat.o(137817);
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            ab.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
            AppMethodBeat.o(137817);
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            ab.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
            AppMethodBeat.o(137817);
            return 4;
        } else {
            String str;
            try {
                byte[] bArr = new byte[64];
                this.randomAccessFile.seek((long) this.gUl);
                this.randomAccessFile.read(bArr);
                str = new String(bArr);
                this.randomAccessFile.seek((long) this.gUl);
            } catch (Exception e) {
                ab.e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", e);
                this.randomAccessFile.seek((long) this.gUl);
                str = null;
            } catch (Throwable th) {
                this.randomAccessFile.seek((long) this.gUl);
                AppMethodBeat.o(137817);
            }
            if (str == null || !str.contains("ftyp")) {
                AppMethodBeat.o(137817);
                return 0;
            }
            ab.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
            ikM.put(this.filePath, Integer.valueOf(1));
            AppMethodBeat.o(137817);
            return 1;
        }
    }

    public final void close() {
        AppMethodBeat.i(137818);
        if (this.randomAccessFile != null) {
            ab.i("MicroMsg.WxaAudioDataSourceBelow19", "close %d", Integer.valueOf(hashCode()));
            this.randomAccessFile.close();
            this.randomAccessFile = null;
        }
        AppMethodBeat.o(137818);
    }
}
