package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a {
    private String appId;
    private String fileName;
    private String mUrl;
    private RandomAccessFile randomAccessFile = null;

    public a(String str, String str2) {
        AppMethodBeat.i(136952);
        this.appId = str;
        this.mUrl = str2;
        this.fileName = com.tencent.mm.audio.mix.h.a.F(str, this.mUrl);
        b.i("MicroMsg.Mix.AudioPcmCacheFile", "AudioPcmCacheFile mUrl:%s, fileName:%s,", this.mUrl, this.fileName);
        AppMethodBeat.o(136952);
    }

    public final boolean open() {
        AppMethodBeat.i(136953);
        b.i("MicroMsg.Mix.AudioPcmCacheFile", "open");
        try {
            File file = new File(this.fileName);
            if (file.exists()) {
                file.delete();
            } else {
                b.i("MicroMsg.Mix.AudioPcmCacheFile", "create file:%b", Boolean.valueOf(file.createNewFile()));
            }
            this.randomAccessFile = new RandomAccessFile(file, "rws");
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.o(136953);
            return true;
        } catch (FileNotFoundException e) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "file not found", e);
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.o(136953);
            return false;
        } catch (IOException e2) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "io ", e2);
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.o(136953);
            return false;
        } catch (Throwable th) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.o(136953);
        }
    }

    public final synchronized void close() {
        AppMethodBeat.i(136954);
        b.i("MicroMsg.Mix.AudioPcmCacheFile", "close");
        if (this.randomAccessFile != null) {
            try {
                this.randomAccessFile.close();
                AppMethodBeat.o(136954);
            } catch (IOException e) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "close RandomAccessFile error ", e.getMessage());
            }
        }
        AppMethodBeat.o(136954);
    }

    public final synchronized int b(byte[] bArr, long j, int i) {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.i(136955);
            if (i == 0) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "read error, length == 0");
                AppMethodBeat.o(136955);
            } else if (this.randomAccessFile == null) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "read error, randomAccessFile is null");
                AppMethodBeat.o(136955);
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    i2 = this.randomAccessFile.read(bArr, 0, i);
                    AppMethodBeat.o(136955);
                } catch (IOException e) {
                    b.e("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(getLength()), Integer.valueOf(bArr.length)}));
                    AppMethodBeat.o(136955);
                }
            }
        }
        return i2;
    }

    public final synchronized boolean c(byte[] bArr, long j, int i) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(136956);
            if (i == 0) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "write error, length == 0");
                AppMethodBeat.o(136956);
            } else if (this.randomAccessFile == null) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "write error, randomAccessFile is null");
                AppMethodBeat.o(136956);
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    this.randomAccessFile.write(bArr, 0, i);
                    AppMethodBeat.o(136956);
                    z = true;
                } catch (IOException e) {
                    b.e("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error writing %d bytes to from buffer with size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
                    AppMethodBeat.o(136956);
                }
            }
        }
        return z;
    }

    public final synchronized int getLength() {
        int i = -1;
        synchronized (this) {
            AppMethodBeat.i(136957);
            if (this.randomAccessFile == null) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "getLength error, randomAccessFile is null");
                AppMethodBeat.o(136957);
            } else {
                try {
                    i = (int) this.randomAccessFile.length();
                    AppMethodBeat.o(136957);
                } catch (IOException e) {
                    b.e("MicroMsg.Mix.AudioPcmCacheFile", "Error get length of file , err %s", e.getMessage());
                    AppMethodBeat.o(136957);
                }
            }
        }
        return i;
    }

    public final synchronized void setLength(long j) {
        AppMethodBeat.i(136958);
        if (this.randomAccessFile == null) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "setLength error, randomAccessFile is null");
            AppMethodBeat.o(136958);
        } else if (j <= 0) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "setLength error, length is ".concat(String.valueOf(j)));
            AppMethodBeat.o(136958);
        } else {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "set file length %s ", String.valueOf(j));
            try {
                this.randomAccessFile.setLength(j);
                AppMethodBeat.o(136958);
            } catch (IOException e) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "Error set length of file, err %s", e.getMessage());
                AppMethodBeat.o(136958);
            }
        }
    }

    public final void CZ() {
        AppMethodBeat.i(136959);
        b.i("MicroMsg.Mix.AudioPcmCacheFile", "deleteFile");
        String str = this.fileName;
        b.i("MicroMsg.Mix.AudioPcmCacheFile", "deleteFile, fileName:".concat(String.valueOf(str)));
        File file = new File(str);
        if (file.exists()) {
            b.i("MicroMsg.Mix.AudioPcmCacheFile", "delete the piece File");
            file.delete();
            AppMethodBeat.o(136959);
            return;
        }
        b.e("MicroMsg.Mix.AudioPcmCacheFile", "file not exist, delete piece File fail");
        AppMethodBeat.o(136959);
    }
}
