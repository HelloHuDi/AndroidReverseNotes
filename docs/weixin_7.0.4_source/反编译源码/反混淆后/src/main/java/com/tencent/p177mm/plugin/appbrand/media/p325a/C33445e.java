package com.tencent.p177mm.plugin.appbrand.media.p325a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C45139e;
import com.tencent.p177mm.plugin.appbrand.appcache.C45512ao;
import com.tencent.p177mm.plugin.appbrand.appcache.C45512ao.C26739a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.plugin.appbrand.media.a.e */
public final class C33445e implements C45139e {
    private static C4993ae<String, Integer> ikK = new C4993ae(50);
    private static C4993ae<String, Integer> ikL = new C4993ae(50);
    private static C4993ae<String, Integer> ikM = new C4993ae(50);
    private long currentPosition;
    private String filePath;
    private String gSP;
    private int gUl = -1;
    private int ikN = -1;
    public RandomAccessFile randomAccessFile;

    static {
        AppMethodBeat.m2504i(137819);
        AppMethodBeat.m2505o(137819);
    }

    public C33445e(String str, String str2) {
        AppMethodBeat.m2504i(137812);
        this.filePath = str;
        this.gSP = str2;
        this.randomAccessFile = m54655cB(str, str2);
        if (ikK.mo10274aj(str) && ikL.mo10274aj(str)) {
            this.ikN = ((Integer) ikK.get(str)).intValue();
            this.gUl = ((Integer) ikL.get(str)).intValue();
            AppMethodBeat.m2505o(137812);
        } else if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
            AppMethodBeat.m2505o(137812);
        } else {
            C45512ao c45512ao = new C45512ao(str2);
            if (!c45512ao.gUe) {
                c45512ao.close();
                C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
                AppMethodBeat.m2505o(137812);
            } else if (c45512ao.avW()) {
                C26739a xx = c45512ao.mo73323xx(str);
                if (xx == null) {
                    c45512ao.close();
                    C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
                    AppMethodBeat.m2505o(137812);
                } else if (xx.gUm <= 0 || xx.gUl <= 0) {
                    c45512ao.close();
                    C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
                    AppMethodBeat.m2505o(137812);
                } else {
                    this.ikN = xx.gUm;
                    this.gUl = xx.gUl;
                    ikK.put(str, Integer.valueOf(this.ikN));
                    ikL.put(str, Integer.valueOf(this.gUl));
                    c45512ao.close();
                    AppMethodBeat.m2505o(137812);
                }
            } else {
                c45512ao.close();
                C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
                AppMethodBeat.m2505o(137812);
            }
        }
    }

    public final boolean isOpen() {
        return this.randomAccessFile != null || this.ikN == -1 || this.gUl == -1;
    }

    public final void open() {
        AppMethodBeat.m2504i(137813);
        C4990ab.m7417i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", Integer.valueOf(hashCode()));
        if (this.randomAccessFile == null) {
            this.randomAccessFile = m54655cB(this.filePath, this.gSP);
        }
        this.currentPosition = 0;
        if (this.randomAccessFile != null) {
            this.randomAccessFile.seek((long) this.gUl);
        }
        AppMethodBeat.m2505o(137813);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007a A:{Splitter:B:4:0x003b, ExcHandler: FileNotFoundException (r1_8 'e' java.io.FileNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009a A:{SYNTHETIC, Splitter:B:21:0x009a} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x007a, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:16:0x007b, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", r1, "", new java.lang.Object[0]);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(137814);
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
    /* renamed from: cB */
    private RandomAccessFile m54655cB(String str, String str2) {
        AppMethodBeat.m2504i(137814);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
            AppMethodBeat.m2505o(137814);
            return null;
        }
        C4990ab.m7417i("MicroMsg.WxaAudioDataSourceBelow19", "filePath:%s, resLength:%d, fileOffset:%d", str, Integer.valueOf(this.ikN), Integer.valueOf(this.gUl));
        RandomAccessFile ck;
        try {
            if (new C5728b(str2).exists()) {
                ck = C5730e.m8626ck(str2, false);
                C4990ab.m7411d("MicroMsg.WxaAudioDataSourceBelow19", "randomAccessFile.length:%d", Long.valueOf(ck.length()));
                AppMethodBeat.m2505o(137814);
                return ck;
            }
            C4990ab.m7413e("MicroMsg.WxaAudioDataSourceBelow19", "file pkgPath:%s isn't exist ", str2);
            AppMethodBeat.m2505o(137814);
            return null;
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
            Throwable e3 = e2;
            RandomAccessFile randomAccessFile = ck;
            C4990ab.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", e3, "", new Object[0]);
            if (randomAccessFile != null) {
            }
            AppMethodBeat.m2505o(137814);
            return null;
        }
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        int i3 = -1;
        AppMethodBeat.m2504i(137815);
        if (this.randomAccessFile == null) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
            AppMethodBeat.m2505o(137815);
        } else {
            if (this.currentPosition != j) {
                this.randomAccessFile.seek(((long) this.gUl) + j);
                this.currentPosition = j;
            }
            if (bArr == null || bArr.length <= 0) {
                C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
                AppMethodBeat.m2505o(137815);
            } else if (j < 0 || i < 0 || i2 <= 0) {
                C4990ab.m7413e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(137815);
            } else if (bArr != null && i + i2 > bArr.length) {
                C4990ab.m7413e("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
                AppMethodBeat.m2505o(137815);
            } else if (j >= ((long) this.ikN)) {
                C4990ab.m7413e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", Long.valueOf(j), Integer.valueOf(this.ikN));
                AppMethodBeat.m2505o(137815);
            } else {
                if (((long) i2) + j >= ((long) this.ikN)) {
                    C4990ab.m7413e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(this.ikN));
                    i2 = (int) (((long) this.ikN) - j);
                }
                i3 = this.randomAccessFile.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.currentPosition += (long) i3;
                } else {
                    C4990ab.m7413e("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", Integer.valueOf(i3));
                }
                AppMethodBeat.m2505o(137815);
            }
        }
        return i3;
    }

    public final long getSize() {
        AppMethodBeat.m2504i(137816);
        if (this.randomAccessFile == null) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
            AppMethodBeat.m2505o(137816);
            return 0;
        }
        long j = (long) this.ikN;
        AppMethodBeat.m2505o(137816);
        return j;
    }

    public final int acc() {
        AppMethodBeat.m2504i(137817);
        if (this.randomAccessFile == null) {
            this.randomAccessFile = m54655cB(this.filePath, this.gSP);
        }
        if (ikM.mo10274aj(this.filePath)) {
            int intValue = ((Integer) ikM.get(this.filePath)).intValue();
            AppMethodBeat.m2505o(137817);
            return intValue;
        } else if (this.randomAccessFile == null) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
            AppMethodBeat.m2505o(137817);
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            C4990ab.m7410d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
            AppMethodBeat.m2505o(137817);
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            C4990ab.m7410d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
            AppMethodBeat.m2505o(137817);
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            C4990ab.m7410d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
            AppMethodBeat.m2505o(137817);
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
                C4990ab.m7413e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", e);
                this.randomAccessFile.seek((long) this.gUl);
                str = null;
            } catch (Throwable th) {
                this.randomAccessFile.seek((long) this.gUl);
                AppMethodBeat.m2505o(137817);
            }
            if (str == null || !str.contains("ftyp")) {
                AppMethodBeat.m2505o(137817);
                return 0;
            }
            C4990ab.m7410d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
            ikM.put(this.filePath, Integer.valueOf(1));
            AppMethodBeat.m2505o(137817);
            return 1;
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(137818);
        if (this.randomAccessFile != null) {
            C4990ab.m7417i("MicroMsg.WxaAudioDataSourceBelow19", "close %d", Integer.valueOf(hashCode()));
            this.randomAccessFile.close();
            this.randomAccessFile = null;
        }
        AppMethodBeat.m2505o(137818);
    }
}
