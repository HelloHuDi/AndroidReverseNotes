package com.tencent.p177mm.plugin.appbrand.media.p325a;

import com.tencent.luggage.p147g.C37399a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C45139e;
import com.tencent.p177mm.plugin.appbrand.appcache.C45512ao;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.media.a.d */
public final class C2390d implements C45139e {
    private long currentPosition;
    private String filePath;
    private String gSP;
    public C37399a ikJ = null;

    public C2390d(String str, String str2) {
        AppMethodBeat.m2504i(137805);
        this.filePath = str;
        this.gSP = str2;
        this.ikJ = C2390d.m4649cA(str, str2);
        AppMethodBeat.m2505o(137805);
    }

    public final boolean isOpen() {
        return this.ikJ != null;
    }

    public final void open() {
        AppMethodBeat.m2504i(137806);
        C4990ab.m7416i("MicroMsg.WxaAudioDataSource", "open");
        if (this.ikJ == null) {
            this.ikJ = C2390d.m4649cA(this.filePath, this.gSP);
        }
        this.currentPosition = 0;
        if (this.ikJ != null) {
            this.ikJ.seek(0);
        }
        AppMethodBeat.m2505o(137806);
    }

    /* renamed from: cA */
    private static C37399a m4649cA(String str, String str2) {
        AppMethodBeat.m2504i(137807);
        long nanoTime = System.nanoTime();
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
            AppMethodBeat.m2505o(137807);
            return null;
        }
        C45512ao c45512ao = new C45512ao(new File(str2));
        if (!c45512ao.gUe) {
            c45512ao.close();
            C4990ab.m7412e("MicroMsg.WxaAudioDataSource", "pkg invalid");
            AppMethodBeat.m2505o(137807);
            return null;
        } else if (c45512ao.avW()) {
            InputStream xy = c45512ao.mo73324xy(str);
            if (xy == null) {
                c45512ao.close();
                C4990ab.m7413e("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", str);
                AppMethodBeat.m2505o(137807);
                return null;
            }
            c45512ao.close();
            C4990ab.m7411d("MicroMsg.WxaAudioDataSource", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
            C37399a c37399a = (C37399a) xy;
            AppMethodBeat.m2505o(137807);
            return c37399a;
        } else {
            c45512ao.close();
            C4990ab.m7412e("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
            AppMethodBeat.m2505o(137807);
            return null;
        }
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        int i3 = -1;
        AppMethodBeat.m2504i(137808);
        if (this.ikJ == null) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
            AppMethodBeat.m2505o(137808);
        } else if (bArr == null || bArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
            AppMethodBeat.m2505o(137808);
        } else if (j < 0 || i < 0 || i2 <= 0) {
            C4990ab.m7413e("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(137808);
        } else if (bArr == null || i + i2 <= bArr.length) {
            if (((long) i2) + j > getSize()) {
                C4990ab.m7413e("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(getSize()));
            }
            if (this.currentPosition != j) {
                this.ikJ.seek((int) j);
                this.currentPosition = j;
            }
            i3 = this.ikJ.read(bArr, i, i2);
            if (i3 >= 0) {
                this.currentPosition += (long) i3;
            }
            AppMethodBeat.m2505o(137808);
        } else {
            C4990ab.m7413e("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
            AppMethodBeat.m2505o(137808);
        }
        return i3;
    }

    public final long getSize() {
        AppMethodBeat.m2504i(137809);
        if (this.ikJ == null) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
            AppMethodBeat.m2505o(137809);
            return 0;
        }
        long length = this.ikJ.getLength();
        AppMethodBeat.m2505o(137809);
        return length;
    }

    public final int acc() {
        AppMethodBeat.m2504i(137810);
        if (this.ikJ == null) {
            this.ikJ = C2390d.m4649cA(this.filePath, this.gSP);
        }
        if (this.ikJ == null) {
            C4990ab.m7412e("MicroMsg.WxaAudioDataSource", "[getAudioType] inputStream is null");
            AppMethodBeat.m2505o(137810);
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            C4990ab.m7410d("MicroMsg.WxaAudioDataSource", "[getAudioType] mp3");
            AppMethodBeat.m2505o(137810);
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            C4990ab.m7410d("MicroMsg.WxaAudioDataSource", "[getAudioType] wav");
            AppMethodBeat.m2505o(137810);
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            C4990ab.m7410d("MicroMsg.WxaAudioDataSource", "[getAudioType] ogg");
            AppMethodBeat.m2505o(137810);
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
                C4990ab.m7413e("MicroMsg.WxaAudioDataSource", "getAudioType", e);
                this.ikJ.seek(0);
                str = null;
            } catch (Throwable th) {
                this.ikJ.seek(0);
                AppMethodBeat.m2505o(137810);
            }
            if (str == null || !str.contains("ftyp")) {
                AppMethodBeat.m2505o(137810);
                return 0;
            }
            C4990ab.m7410d("MicroMsg.WxaAudioDataSource", "[getAudioType] aac");
            AppMethodBeat.m2505o(137810);
            return 1;
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(137811);
        C37399a c37399a = this.ikJ;
        if (c37399a != null) {
            C4990ab.m7416i("MicroMsg.WxaAudioDataSource", "close");
            c37399a.close();
            this.ikJ = null;
        }
        AppMethodBeat.m2505o(137811);
    }
}
