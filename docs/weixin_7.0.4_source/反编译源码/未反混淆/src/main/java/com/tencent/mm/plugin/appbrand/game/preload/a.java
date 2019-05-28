package com.tencent.mm.plugin.appbrand.game.preload;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public final class a {
    public static final String fqf = b.aBv();

    public interface a {
        void a(Bitmap bitmap, long j);
    }

    static final class b {
        static final a htj = new a();

        static {
            AppMethodBeat.i(130284);
            AppMethodBeat.o(130284);
        }
    }

    static {
        AppMethodBeat.i(130286);
        AppMethodBeat.o(130286);
    }

    public static a aBu() {
        return b.htj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e5 A:{SYNTHETIC, Splitter:B:46:0x00e5} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ea A:{SYNTHETIC, Splitter:B:49:0x00ea} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f A:{SYNTHETIC, Splitter:B:18:0x005f} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A:{SYNTHETIC, Splitter:B:21:0x0064} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void bW(String str, String str2) {
        InputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Throwable e;
        AppMethodBeat.i(130285);
        String str3 = str + "tmp";
        ab.i("MicroMsg.WAGameLoadingImgManager", "downloadLoadingUrl path:%s", str3);
        try {
            bufferedInputStream = new BufferedInputStream(new URL(str2).openStream());
        } catch (Exception e2) {
            ab.e("MicroMsg.WAGameLoadingImgManager", "fetch error failed. path = [%s], error = [%s]", str2, e2.toString());
            bufferedInputStream = null;
        }
        if (bufferedInputStream != null) {
            try {
                fileOutputStream = new FileOutputStream(str3);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                } catch (IOException e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        new File(str3).renameTo(new File(str));
                        AppMethodBeat.o(130285);
                        return;
                    } catch (Throwable e32) {
                        e = e32;
                        if (fileOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        new File(str3).renameTo(new File(str));
                        AppMethodBeat.o(130285);
                        throw e;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                fileOutputStream = null;
                ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e5, "", new Object[0]);
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e6) {
                        ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e6, "", new Object[0]);
                    }
                }
                new File(str3).renameTo(new File(str));
                AppMethodBeat.o(130285);
                return;
            } catch (Throwable th) {
                e = th;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e52) {
                        ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e52, "", new Object[0]);
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e62) {
                        ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e62, "", new Object[0]);
                    }
                }
                new File(str3).renameTo(new File(str));
                AppMethodBeat.o(130285);
                throw e;
            }
        }
        fileOutputStream = null;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e522) {
                ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e522, "", new Object[0]);
            }
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e622) {
                ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e622, "", new Object[0]);
            }
        }
        new File(str3).renameTo(new File(str));
        AppMethodBeat.o(130285);
    }
}
