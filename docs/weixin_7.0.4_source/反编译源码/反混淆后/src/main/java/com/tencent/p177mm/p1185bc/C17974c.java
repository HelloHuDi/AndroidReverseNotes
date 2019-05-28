package com.tencent.p177mm.p1185bc;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.p1416v.C29476a;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.bc.c */
public final class C17974c {
    private static C17974c fNb;
    private C23498az fNc = null;

    /* renamed from: com.tencent.mm.bc.c$b */
    class C17975b implements C23499a {
        private String ePJ;
        private C17976a fNd;
        private String ffl;
        private boolean success = false;
        private String username;

        public C17975b(String str, String str2, C17976a c17976a) {
            this.username = str;
            this.ffl = str2;
            this.fNd = c17976a;
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
            AppMethodBeat.m2504i(136862);
            if (C5046bo.isNullOrNil(this.username)) {
                AppMethodBeat.m2505o(136862);
                return false;
            }
            this.ePJ = C17974c.m28282sW(this.username);
            String str = "";
            if (C1720g.m3534RN().mo5161QY()) {
                r3 = new Object[4];
                C1720g.m3534RN();
                r3[1] = C1183p.getString(C1668a.m3383QF());
                r3[2] = Integer.valueOf(C5023at.getNetTypeForStat(C4996ah.getContext()));
                r3[3] = Integer.valueOf(C5023at.getStrength(C4996ah.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r3);
            }
            C4990ab.m7411d("MicroMsg.RemarkImageStorage", "get remark image user: %s referer: %s  url:%s", this.username, str, this.ffl);
            this.success = false;
            C1936u a;
            InputStream inputStream;
            try {
                a = C1897b.m4020a(this.ffl, null);
                try {
                    a.setRequestMethod("GET");
                    a.setRequestProperty("referer", str);
                    a.setConnectTimeout(5000);
                    a.setReadTimeout(5000);
                    if (C1897b.m4017a(a) != 0) {
                        C4990ab.m7413e("MicroMsg.RemarkImageStorage", "checkHttpConnection failed! url:%s", this.ffl);
                        try {
                            a.connection.disconnect();
                        } catch (Exception e2) {
                            C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e2));
                        }
                        AppMethodBeat.m2505o(136862);
                        return true;
                    }
                    inputStream = a.getInputStream();
                    if (inputStream == null) {
                        try {
                            C4990ab.m7411d("MicroMsg.RemarkImageStorage", "getInputStream failed. url:%s", this.ffl);
                            try {
                                a.connection.disconnect();
                            } catch (Exception e22) {
                                C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e22));
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e222) {
                                    C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e222));
                                }
                            }
                            AppMethodBeat.m2505o(136862);
                            return true;
                        } catch (Exception e3) {
                            e = e3;
                            outputStream = null;
                            try {
                                C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e));
                                this.success = false;
                                if (a != null) {
                                    try {
                                        a.connection.disconnect();
                                    } catch (Exception e2222) {
                                        C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e2222));
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e22222) {
                                        C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e22222));
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception e222222) {
                                        C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e222222));
                                    }
                                }
                                AppMethodBeat.m2505o(136862);
                                return true;
                            } catch (Throwable th) {
                                e = th;
                                if (a != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (outputStream != null) {
                                }
                                AppMethodBeat.m2505o(136862);
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
                            AppMethodBeat.m2505o(136862);
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
                            C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e));
                            this.success = false;
                            if (a != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (outputStream != null) {
                            }
                            AppMethodBeat.m2505o(136862);
                            return true;
                        }
                    }
                    this.success = true;
                    try {
                        a.connection.disconnect();
                    } catch (Exception e2222222) {
                        C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e2222222));
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e22222222) {
                            C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e22222222));
                        }
                    }
                    try {
                        outputStream.close();
                    } catch (Exception e222222222) {
                        C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e222222222));
                    }
                    AppMethodBeat.m2505o(136862);
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
                    AppMethodBeat.m2505o(136862);
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
                        C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e7));
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e8) {
                        C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e8));
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e82) {
                        C4990ab.m7413e("MicroMsg.RemarkImageStorage", "exception:%s", C5046bo.m7574l(e82));
                    }
                }
                AppMethodBeat.m2505o(136862);
                throw e;
            }
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(136863);
            if (this.success) {
                C1173e.deleteFile(this.ePJ);
                new File(this.ePJ + ".tmp").renameTo(new File(this.ePJ));
                this.fNd.mo11072cP(true);
                AppMethodBeat.m2505o(136863);
                return true;
            }
            this.fNd.mo11072cP(false);
            AppMethodBeat.m2505o(136863);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.bc.c$a */
    public interface C17976a {
        /* renamed from: cP */
        void mo11072cP(boolean z);
    }

    public static C17974c aiB() {
        AppMethodBeat.m2504i(136864);
        if (fNb == null) {
            fNb = new C17974c();
        }
        C17974c c17974c = fNb;
        AppMethodBeat.m2505o(136864);
        return c17974c;
    }

    private C17974c() {
    }

    /* renamed from: sW */
    public static String m28282sW(String str) {
        AppMethodBeat.m2504i(136865);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(136865);
            return null;
        }
        String b = C15428j.m23709b(C29476a.ceV(), "remark_", C1178g.m2591x((str + "ZnVjaw==").getBytes()), ".png", 1);
        AppMethodBeat.m2505o(136865);
        return b;
    }

    /* renamed from: sX */
    public static boolean m28283sX(String str) {
        AppMethodBeat.m2504i(136866);
        C4990ab.m7411d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, C17974c.m28282sW(str));
        boolean exists = new File(r0).exists();
        AppMethodBeat.m2505o(136866);
        return exists;
    }

    /* renamed from: sY */
    public static boolean m28284sY(String str) {
        AppMethodBeat.m2504i(136867);
        C4990ab.m7411d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, C17974c.m28282sW(str));
        boolean deleteFile = C1173e.deleteFile(r0);
        AppMethodBeat.m2505o(136867);
        return deleteFile;
    }

    /* renamed from: a */
    public final void mo33525a(String str, String str2, C17976a c17976a) {
        AppMethodBeat.m2504i(136869);
        if (!(C5046bo.isNullOrNil(str2) || C17974c.m28283sX(str))) {
            if (this.fNc == null || this.fNc.dpg()) {
                this.fNc = new C23498az(1, "download-remark-img", 1);
            }
            this.fNc.mo39163e(new C17975b(str, str2, c17976a));
        }
        AppMethodBeat.m2505o(136869);
    }

    /* renamed from: sZ */
    public static Bitmap m28285sZ(String str) {
        int i = 0;
        AppMethodBeat.m2504i(136868);
        Bitmap ap = C5056d.m7642ap(C17974c.m28282sW(str), 0, 0);
        if (!(ap == null || ap.isRecycled())) {
            i = 1;
        }
        if (i != 0) {
            AppMethodBeat.m2505o(136868);
            return ap;
        }
        AppMethodBeat.m2505o(136868);
        return null;
    }
}
