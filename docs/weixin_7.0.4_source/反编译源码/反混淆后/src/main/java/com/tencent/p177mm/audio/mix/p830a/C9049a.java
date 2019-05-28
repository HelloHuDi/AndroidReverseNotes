package com.tencent.p177mm.audio.mix.p830a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C41782a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.audio.mix.a.a */
public final class C9049a {
    private String appId;
    private String fileName;
    private String mUrl;
    private RandomAccessFile randomAccessFile = null;

    public C9049a(String str, String str2) {
        AppMethodBeat.m2504i(136952);
        this.appId = str;
        this.mUrl = str2;
        this.fileName = C41782a.m73751F(str, this.mUrl);
        C45174b.m83210i("MicroMsg.Mix.AudioPcmCacheFile", "AudioPcmCacheFile mUrl:%s, fileName:%s,", this.mUrl, this.fileName);
        AppMethodBeat.m2505o(136952);
    }

    public final boolean open() {
        AppMethodBeat.m2504i(136953);
        C45174b.m83209i("MicroMsg.Mix.AudioPcmCacheFile", "open");
        try {
            File file = new File(this.fileName);
            if (file.exists()) {
                file.delete();
            } else {
                C45174b.m83210i("MicroMsg.Mix.AudioPcmCacheFile", "create file:%b", Boolean.valueOf(file.createNewFile()));
            }
            this.randomAccessFile = new RandomAccessFile(file, "rws");
            C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.m2505o(136953);
            return true;
        } catch (FileNotFoundException e) {
            C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "file not found", e);
            C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.m2505o(136953);
            return false;
        } catch (IOException e2) {
            C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "io ", e2);
            C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.m2505o(136953);
            return false;
        } catch (Throwable th) {
            C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.m2505o(136953);
        }
    }

    public final synchronized void close() {
        AppMethodBeat.m2504i(136954);
        C45174b.m83209i("MicroMsg.Mix.AudioPcmCacheFile", "close");
        if (this.randomAccessFile != null) {
            try {
                this.randomAccessFile.close();
                AppMethodBeat.m2505o(136954);
            } catch (IOException e) {
                C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "close RandomAccessFile error ", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(136954);
    }

    /* renamed from: b */
    public final synchronized int mo20495b(byte[] bArr, long j, int i) {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.m2504i(136955);
            if (i == 0) {
                C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", "read error, length == 0");
                AppMethodBeat.m2505o(136955);
            } else if (this.randomAccessFile == null) {
                C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", "read error, randomAccessFile is null");
                AppMethodBeat.m2505o(136955);
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    i2 = this.randomAccessFile.read(bArr, 0, i);
                    AppMethodBeat.m2505o(136955);
                } catch (IOException e) {
                    C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(getLength()), Integer.valueOf(bArr.length)}));
                    AppMethodBeat.m2505o(136955);
                }
            }
        }
        return i2;
    }

    /* renamed from: c */
    public final synchronized boolean mo20496c(byte[] bArr, long j, int i) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(136956);
            if (i == 0) {
                C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", "write error, length == 0");
                AppMethodBeat.m2505o(136956);
            } else if (this.randomAccessFile == null) {
                C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", "write error, randomAccessFile is null");
                AppMethodBeat.m2505o(136956);
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    this.randomAccessFile.write(bArr, 0, i);
                    AppMethodBeat.m2505o(136956);
                    z = true;
                } catch (IOException e) {
                    C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error writing %d bytes to from buffer with size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
                    AppMethodBeat.m2505o(136956);
                }
            }
        }
        return z;
    }

    public final synchronized int getLength() {
        int i = -1;
        synchronized (this) {
            AppMethodBeat.m2504i(136957);
            if (this.randomAccessFile == null) {
                C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", "getLength error, randomAccessFile is null");
                AppMethodBeat.m2505o(136957);
            } else {
                try {
                    i = (int) this.randomAccessFile.length();
                    AppMethodBeat.m2505o(136957);
                } catch (IOException e) {
                    C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "Error get length of file , err %s", e.getMessage());
                    AppMethodBeat.m2505o(136957);
                }
            }
        }
        return i;
    }

    public final synchronized void setLength(long j) {
        AppMethodBeat.m2504i(136958);
        if (this.randomAccessFile == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", "setLength error, randomAccessFile is null");
            AppMethodBeat.m2505o(136958);
        } else if (j <= 0) {
            C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", "setLength error, length is ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(136958);
        } else {
            C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "set file length %s ", String.valueOf(j));
            try {
                this.randomAccessFile.setLength(j);
                AppMethodBeat.m2505o(136958);
            } catch (IOException e) {
                C45174b.m83208e("MicroMsg.Mix.AudioPcmCacheFile", "Error set length of file, err %s", e.getMessage());
                AppMethodBeat.m2505o(136958);
            }
        }
    }

    /* renamed from: CZ */
    public final void mo20494CZ() {
        AppMethodBeat.m2504i(136959);
        C45174b.m83209i("MicroMsg.Mix.AudioPcmCacheFile", "deleteFile");
        String str = this.fileName;
        C45174b.m83209i("MicroMsg.Mix.AudioPcmCacheFile", "deleteFile, fileName:".concat(String.valueOf(str)));
        File file = new File(str);
        if (file.exists()) {
            C45174b.m83209i("MicroMsg.Mix.AudioPcmCacheFile", "delete the piece File");
            file.delete();
            AppMethodBeat.m2505o(136959);
            return;
        }
        C45174b.m83207e("MicroMsg.Mix.AudioPcmCacheFile", "file not exist, delete piece File fail");
        AppMethodBeat.m2505o(136959);
    }
}
