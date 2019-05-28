package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/FileUtils;", "", "()V", "TAG", "", "copyFileFromAssets", "", "context", "Landroid/content/Context;", "srcFileName", "dstFileName", "getSavedFileDirectory", "plugin-appbrand-integration_release"})
public final class e {
    private static final String TAG = TAG;
    public static final e iZE = new e();

    static {
        AppMethodBeat.i(135255);
        AppMethodBeat.o(135255);
    }

    private e() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af A:{SYNTHETIC, Splitter:B:36:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4 A:{Catch:{ Exception -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af A:{SYNTHETIC, Splitter:B:36:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4 A:{Catch:{ Exception -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066 A:{SYNTHETIC, Splitter:B:19:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A:{Catch:{ Exception -> 0x00a4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af A:{SYNTHETIC, Splitter:B:36:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4 A:{Catch:{ Exception -> 0x00bb }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void p(Context context, String str, String str2) {
        InputStream open;
        Exception e;
        OutputStream outputStream;
        Throwable th;
        AppMethodBeat.i(135253);
        j.p(context, "context");
        j.p(str, "srcFileName");
        j.p(str2, "dstFileName");
        ab.i(TAG, "alvinluo copyFileFromAssets src: %s, dst: %s", str, str2);
        try {
            OutputStream fileOutputStream;
            File file = new File(str2);
            open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
                e = e2;
                outputStream = null;
                try {
                    ab.printErrStackTrace(TAG, e, "alvinluo copyFileFromAssets exception", new Object[0]);
                    if (open != null) {
                    }
                    if (outputStream == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e3) {
                            AppMethodBeat.o(135253);
                            throw th;
                        }
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    AppMethodBeat.o(135253);
                    throw th;
                }
            } catch (Throwable th22) {
                th = th22;
                outputStream = null;
                if (open != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.o(135253);
                throw th;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    if (open == null) {
                        j.dWJ();
                    }
                    int read = open.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        ab.i(TAG, "alvinluo copyFileFromAssets %s successfully, file len: %d", str, Long.valueOf(file.length()));
                        try {
                            open.close();
                            fileOutputStream.close();
                            AppMethodBeat.o(135253);
                            return;
                        } catch (Exception e4) {
                            AppMethodBeat.o(135253);
                            return;
                        }
                    }
                }
            } catch (Exception e5) {
                e = e5;
                outputStream = fileOutputStream;
                ab.printErrStackTrace(TAG, e, "alvinluo copyFileFromAssets exception", new Object[0]);
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e6) {
                        AppMethodBeat.o(135253);
                        return;
                    }
                }
                if (outputStream == null) {
                    outputStream.close();
                    AppMethodBeat.o(135253);
                    return;
                }
                AppMethodBeat.o(135253);
            } catch (Throwable th3) {
                th = th3;
                outputStream = fileOutputStream;
                if (open != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.o(135253);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            outputStream = null;
            open = null;
        } catch (Throwable th222) {
            th = th222;
            outputStream = null;
            open = null;
            if (open != null) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.o(135253);
            throw th;
        }
    }

    public static String dn(Context context) {
        AppMethodBeat.i(135254);
        j.p(context, "context");
        StringBuilder stringBuilder = new StringBuilder();
        File filesDir = context.getFilesDir();
        j.o(filesDir, "context.filesDir");
        String stringBuilder2 = stringBuilder.append(filesDir.getParent()).append(File.separator).append("appbrand/glsl/").toString();
        AppMethodBeat.o(135254);
        return stringBuilder2;
    }
}
