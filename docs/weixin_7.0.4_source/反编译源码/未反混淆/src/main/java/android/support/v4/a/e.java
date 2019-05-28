package android.support.v4.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.support.v4.d.b.b;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class e extends h {
    e() {
    }

    private static File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
            return null;
        } catch (ErrnoException e) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0056 A:{Catch:{ all -> 0x0056, all -> 0x0045 }, Splitter:B:5:0x0017, ExcHandler: all (r1_12 'th' java.lang.Throwable A:{Catch:{ all -> 0x0056, all -> 0x0045 }})} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:31:0x0045, code skipped:
            r2 = th;
     */
    /* JADX WARNING: Missing block: B:32:0x0046, code skipped:
            r3 = r1;
     */
    /* JADX WARNING: Missing block: B:43:0x0056, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:44:0x0057, code skipped:
            r2 = r1;
            r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Typeface a(Context context, b[] bVarArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        InputStream fileInputStream;
        Throwable th;
        Throwable th2;
        if (bVarArr.length <= 0) {
            return null;
        }
        b a = a(bVarArr, i);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(a.mUri, "r", null);
            try {
                File a2 = a(openFileDescriptor);
                Typeface a3;
                if (a2 == null || !a2.canRead()) {
                    fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                    try {
                        a3 = h.a(context, fileInputStream);
                        fileInputStream.close();
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                        }
                        return a3;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    a3 = Typeface.createFromFile(a2);
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return a3;
                }
            } catch (Throwable th4) {
            }
        } catch (IOException e) {
            return null;
        }
        throw th;
        if (openFileDescriptor != null) {
            if (th != null) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th5) {
                    th.addSuppressed(th5);
                }
            } else {
                openFileDescriptor.close();
            }
        }
        throw th2;
        if (th2 != null) {
            fileInputStream.close();
        } else {
            fileInputStream.close();
        }
        throw th5;
        throw th2;
    }
}
