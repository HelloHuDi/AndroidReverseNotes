package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class ShareFileLockHelper implements Closeable {
    private final FileLock AEH;
    private final FileOutputStream outputStream;

    private ShareFileLockHelper(File file) {
        this.outputStream = new FileOutputStream(file);
        Throwable th = null;
        FileLock fileLock = null;
        int i = 0;
        while (i < 3) {
            i++;
            try {
                fileLock = this.outputStream.getChannel().lock();
                if ((fileLock != null ? 1 : null) != null) {
                    break;
                }
                Thread.sleep(10);
            } catch (Exception e) {
                th = e;
            }
        }
        if (fileLock == null) {
            throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + file.getAbsolutePath(), th);
        }
        this.AEH = fileLock;
    }

    /* renamed from: ao */
    public static ShareFileLockHelper m9351ao(File file) {
        return new ShareFileLockHelper(file);
    }

    public void close() {
        try {
            if (this.AEH != null) {
                this.AEH.release();
            }
            if (this.outputStream != null) {
                this.outputStream.close();
            }
        } catch (Throwable th) {
            if (this.outputStream != null) {
                this.outputStream.close();
            }
        }
    }
}
