package com.tencent.mm.bc;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class c {
    private static c fNb;
    private az fNc = null;

    class b implements com.tencent.mm.sdk.platformtools.az.a {
        private String ePJ;
        private a fNd;
        private String ffl;
        private boolean success = false;
        private String username;

        public b(String str, String str2, a aVar) {
            this.username = str;
            this.ffl = str2;
            this.fNd = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:79:0x0202 A:{SYNTHETIC, Splitter:B:79:0x0202} */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0209 A:{SYNTHETIC, Splitter:B:82:0x0209} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x020e A:{SYNTHETIC, Splitter:B:85:0x020e} */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0202 A:{SYNTHETIC, Splitter:B:79:0x0202} */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0209 A:{SYNTHETIC, Splitter:B:82:0x0209} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x020e A:{SYNTHETIC, Splitter:B:85:0x020e} */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0202 A:{SYNTHETIC, Splitter:B:79:0x0202} */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0209 A:{SYNTHETIC, Splitter:B:82:0x0209} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x020e A:{SYNTHETIC, Splitter:B:85:0x020e} */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0163 A:{SYNTHETIC, Splitter:B:45:0x0163} */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x016a A:{SYNTHETIC, Splitter:B:48:0x016a} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x016f A:{SYNTHETIC, Splitter:B:51:0x016f} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean acf() {
            Throwable e;
            OutputStream outputStream;
            AppMethodBeat.i(136862);
            if (bo.isNullOrNil(this.username)) {
                AppMethodBeat.o(136862);
                return false;
            }
            this.ePJ = c.sW(this.username);
            String str = "";
            if (g.RN().QY()) {
                r3 = new Object[4];
                g.RN();
                r3[1] = p.getString(com.tencent.mm.kernel.a.QF());
                r3[2] = Integer.valueOf(at.getNetTypeForStat(ah.getContext()));
                r3[3] = Integer.valueOf(at.getStrength(ah.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r3);
            }
            ab.d("MicroMsg.RemarkImageStorage", "get remark image user: %s referer: %s  url:%s", this.username, str, this.ffl);
            this.success = false;
            u a;
            InputStream inputStream;
            try {
                a = com.tencent.mm.network.b.a(this.ffl, null);
                try {
                    a.setRequestMethod("GET");
                    a.setRequestProperty("referer", str);
                    a.setConnectTimeout(5000);
                    a.setReadTimeout(5000);
                    if (com.tencent.mm.network.b.a(a) != 0) {
                        ab.e("MicroMsg.RemarkImageStorage", "checkHttpConnection failed! url:%s", this.ffl);
                        try {
                            a.connection.disconnect();
                        } catch (Exception e2) {
                            ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e2));
                        }
                        AppMethodBeat.o(136862);
                        return true;
                    }
                    inputStream = a.getInputStream();
                    if (inputStream == null) {
                        try {
                            ab.d("MicroMsg.RemarkImageStorage", "getInputStream failed. url:%s", this.ffl);
                            try {
                                a.connection.disconnect();
                            } catch (Exception e22) {
                                ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e22));
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e222) {
                                    ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e222));
                                }
                            }
                            AppMethodBeat.o(136862);
                            return true;
                        } catch (Exception e3) {
                            e = e3;
                            outputStream = null;
                            try {
                                ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e));
                                this.success = false;
                                if (a != null) {
                                    try {
                                        a.connection.disconnect();
                                    } catch (Exception e2222) {
                                        ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e2222));
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e22222) {
                                        ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e22222));
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception e222222) {
                                        ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e222222));
                                    }
                                }
                                AppMethodBeat.o(136862);
                                return true;
                            } catch (Throwable th) {
                                e = th;
                                if (a != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (outputStream != null) {
                                }
                                AppMethodBeat.o(136862);
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            outputStream = null;
                            if (a != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (outputStream != null) {
                            }
                            AppMethodBeat.o(136862);
                            throw e;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    outputStream = new FileOutputStream(this.ePJ + ".tmp");
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        } catch (Exception e4) {
                            e = e4;
                            ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e));
                            this.success = false;
                            if (a != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (outputStream != null) {
                            }
                            AppMethodBeat.o(136862);
                            return true;
                        }
                    }
                    this.success = true;
                    try {
                        a.connection.disconnect();
                    } catch (Exception e2222222) {
                        ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e2222222));
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e22222222) {
                            ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e22222222));
                        }
                    }
                    try {
                        outputStream.close();
                    } catch (Exception e222222222) {
                        ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e222222222));
                    }
                    AppMethodBeat.o(136862);
                    return true;
                } catch (Exception e5) {
                    e = e5;
                    inputStream = null;
                    outputStream = null;
                } catch (Throwable th3) {
                    e = th3;
                    inputStream = null;
                    outputStream = null;
                    if (a != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(136862);
                    throw e;
                }
            } catch (Exception e6) {
                e = e6;
                inputStream = null;
                outputStream = null;
                a = null;
            } catch (Throwable th4) {
                e = th4;
                inputStream = null;
                outputStream = null;
                a = null;
                if (a != null) {
                    try {
                        a.connection.disconnect();
                    } catch (Exception e7) {
                        ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e7));
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e8) {
                        ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e8));
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e82) {
                        ab.e("MicroMsg.RemarkImageStorage", "exception:%s", bo.l(e82));
                    }
                }
                AppMethodBeat.o(136862);
                throw e;
            }
        }

        public final boolean acg() {
            AppMethodBeat.i(136863);
            if (this.success) {
                e.deleteFile(this.ePJ);
                new File(this.ePJ + ".tmp").renameTo(new File(this.ePJ));
                this.fNd.cP(true);
                AppMethodBeat.o(136863);
                return true;
            }
            this.fNd.cP(false);
            AppMethodBeat.o(136863);
            return false;
        }
    }

    public interface a {
        void cP(boolean z);
    }

    public static c aiB() {
        AppMethodBeat.i(136864);
        if (fNb == null) {
            fNb = new c();
        }
        c cVar = fNb;
        AppMethodBeat.o(136864);
        return cVar;
    }

    private c() {
    }

    public static String sW(String str) {
        AppMethodBeat.i(136865);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(136865);
            return null;
        }
        String b = j.b(com.tencent.mm.plugin.v.a.ceV(), "remark_", com.tencent.mm.a.g.x((str + "ZnVjaw==").getBytes()), ".png", 1);
        AppMethodBeat.o(136865);
        return b;
    }

    public static boolean sX(String str) {
        AppMethodBeat.i(136866);
        ab.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, sW(str));
        boolean exists = new File(r0).exists();
        AppMethodBeat.o(136866);
        return exists;
    }

    public static boolean sY(String str) {
        AppMethodBeat.i(136867);
        ab.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, sW(str));
        boolean deleteFile = e.deleteFile(r0);
        AppMethodBeat.o(136867);
        return deleteFile;
    }

    public final void a(String str, String str2, a aVar) {
        AppMethodBeat.i(136869);
        if (!(bo.isNullOrNil(str2) || sX(str))) {
            if (this.fNc == null || this.fNc.dpg()) {
                this.fNc = new az(1, "download-remark-img", 1);
            }
            this.fNc.e(new b(str, str2, aVar));
        }
        AppMethodBeat.o(136869);
    }

    public static Bitmap sZ(String str) {
        int i = 0;
        AppMethodBeat.i(136868);
        Bitmap ap = d.ap(sW(str), 0, 0);
        if (!(ap == null || ap.isRecycled())) {
            i = 1;
        }
        if (i != 0) {
            AppMethodBeat.o(136868);
            return ap;
        }
        AppMethodBeat.o(136868);
        return null;
    }
}
