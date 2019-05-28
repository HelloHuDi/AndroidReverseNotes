package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import org.apache.commons.a.a.a;
import org.apache.commons.a.a.b;

public final class c {
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final String LINE_SEPARATOR;

    /* JADX WARNING: Removed duplicated region for block: B:40:0x005a A:{Catch:{ Throwable -> 0x003f, all -> 0x0057, all -> 0x0047 }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A:{SYNTHETIC, Splitter:B:17:0x0035} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A:{SYNTHETIC, Splitter:B:31:0x004b} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0057 A:{Catch:{ Throwable -> 0x003f, all -> 0x0057, all -> 0x0047 }, Splitter:B:1:0x0011, ExcHandler: all (r0_9 'th' java.lang.Throwable A:{Catch:{ Throwable -> 0x003f, all -> 0x0057, all -> 0x0047 }})} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:23:0x003f, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(136501);
     */
    /* JADX WARNING: Missing block: B:28:0x0047, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:29:0x0048, code skipped:
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:30:0x0049, code skipped:
            if (r3 == null) goto L_0x0063;
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:33:0x004e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(136501);
     */
    /* JADX WARNING: Missing block: B:34:0x0051, code skipped:
            throw r1;
     */
    /* JADX WARNING: Missing block: B:38:0x0057, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:39:0x0058, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:41:0x005e, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:0x005f, code skipped:
            r3.addSuppressed(r0);
     */
    /* JADX WARNING: Missing block: B:43:0x0063, code skipped:
            r4.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        Throwable th;
        Throwable th2;
        Throwable th3 = null;
        AppMethodBeat.i(136501);
        b bVar = new b((byte) 0);
        try {
            PrintWriter printWriter = new PrintWriter(bVar);
            try {
                printWriter.println();
                LINE_SEPARATOR = bVar.toString();
                printWriter.close();
                bVar.close();
                AppMethodBeat.o(136501);
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                if (th2 == null) {
                }
                AppMethodBeat.o(136501);
                throw th;
            }
        } catch (Throwable th5) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028 A:{SYNTHETIC, Splitter:B:15:0x0028} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArray(InputStream inputStream) {
        Throwable th;
        AppMethodBeat.i(136500);
        a aVar = new a();
        Throwable th2 = null;
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 != read) {
                    aVar.write(bArr, 0, read);
                } else {
                    bArr = aVar.toByteArray();
                    aVar.close();
                    AppMethodBeat.o(136500);
                    return bArr;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            if (th2 == null) {
            }
            AppMethodBeat.o(136500);
            throw th;
        }
    }
}
