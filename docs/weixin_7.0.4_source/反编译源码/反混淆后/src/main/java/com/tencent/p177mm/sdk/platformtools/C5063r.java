package com.tencent.p177mm.sdk.platformtools;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.vfs.C40922d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.sdk.platformtools.r */
public final class C5063r {
    public static boolean amn(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(93394);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.ImgUtil", "isImgFile, invalid argument");
            AppMethodBeat.m2505o(93394);
            return false;
        } else if (str.length() < 3) {
            AppMethodBeat.m2505o(93394);
            return false;
        } else if (C5730e.m8628ct(str)) {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            try {
                InputStream openRead = C5730e.openRead(str);
                MMBitmapFactory.decodeStream(openRead, null, options);
                if (options.outWidth <= 0 || options.outHeight <= 0) {
                    z = false;
                }
                C5046bo.m7527b(openRead);
                AppMethodBeat.m2505o(93394);
                return z;
            } catch (Throwable th) {
                C5046bo.m7527b(null);
                AppMethodBeat.m2505o(93394);
                throw th;
            }
        } else {
            AppMethodBeat.m2505o(93394);
            return false;
        }
    }

    /* renamed from: bS */
    public static boolean m7677bS(byte[] bArr) {
        AppMethodBeat.m2504i(93395);
        if (bArr == null) {
            AppMethodBeat.m2505o(93395);
            return false;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        String str = "";
        int i = 0;
        while (i < 6) {
            try {
                str = str + ((char) byteArrayInputStream.read());
                i++;
            } catch (IOException e) {
                AppMethodBeat.m2505o(93395);
                return false;
            }
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e2) {
        }
        if (str.startsWith("GIF")) {
            AppMethodBeat.m2505o(93395);
            return true;
        }
        AppMethodBeat.m2505o(93395);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d A:{SYNTHETIC, Splitter:B:19:0x004d} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058 A:{SYNTHETIC, Splitter:B:25:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean amo(String str) {
        Throwable th;
        AppMethodBeat.m2504i(93396);
        InputStream c40922d;
        try {
            c40922d = new C40922d(str);
            try {
                byte[] bArr = new byte[6];
                String str2 = "";
                c40922d.read(bArr);
                for (int i = 0; i < 6; i++) {
                    str2 = str2 + ((char) bArr[i]);
                }
                if (str2.startsWith("GIF")) {
                    try {
                        c40922d.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.m2505o(93396);
                    return true;
                }
                try {
                    c40922d.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.m2505o(93396);
                return false;
            } catch (Exception e3) {
                if (c40922d != null) {
                }
                AppMethodBeat.m2505o(93396);
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (c40922d != null) {
                }
                AppMethodBeat.m2505o(93396);
                throw th;
            }
        } catch (Exception e4) {
            c40922d = null;
            if (c40922d != null) {
                try {
                    c40922d.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.m2505o(93396);
            return false;
        } catch (Throwable th3) {
            th = th3;
            c40922d = null;
            if (c40922d != null) {
                try {
                    c40922d.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(93396);
            throw th;
        }
    }

    /* renamed from: bT */
    public static boolean m7678bT(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return false;
        }
        if (bArr[1] == (byte) 80 && bArr[2] == (byte) 78 && bArr[3] == (byte) 71) {
            return true;
        }
        if (bArr[0] == (byte) 71 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70) {
            return true;
        }
        if (bArr[6] == (byte) 74 && bArr[7] == (byte) 70 && bArr[8] == (byte) 73 && bArr[9] == (byte) 70) {
            return true;
        }
        if (bArr[0] == (byte) 119 && bArr[1] == (byte) 120 && bArr[2] == (byte) 103 && bArr[3] == (byte) 102) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A:{SYNTHETIC, Splitter:B:19:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a A:{SYNTHETIC, Splitter:B:25:0x005a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean amp(String str) {
        Throwable th;
        AppMethodBeat.m2504i(93397);
        InputStream c40922d;
        try {
            c40922d = new C40922d(str);
            try {
                byte[] bArr = new byte[8];
                String str2 = "";
                c40922d.read(bArr);
                for (int i = 0; i < 8; i++) {
                    str2 = str2 + ((char) bArr[i]);
                }
                if (str2.startsWith("wxgf")) {
                    try {
                        c40922d.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.m2505o(93397);
                    return true;
                }
                try {
                    c40922d.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.m2505o(93397);
                return false;
            } catch (Exception e3) {
                if (c40922d != null) {
                }
                AppMethodBeat.m2505o(93397);
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (c40922d != null) {
                }
                AppMethodBeat.m2505o(93397);
                throw th;
            }
        } catch (Exception e4) {
            c40922d = null;
            if (c40922d != null) {
                try {
                    c40922d.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.m2505o(93397);
            return false;
        } catch (Throwable th3) {
            th = th3;
            c40922d = null;
            if (c40922d != null) {
                try {
                    c40922d.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(93397);
            throw th;
        }
    }

    /* renamed from: bU */
    public static boolean m7679bU(byte[] bArr) {
        AppMethodBeat.m2504i(93398);
        if (bArr == null) {
            AppMethodBeat.m2505o(93398);
            return false;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        String str = "";
        int i = 0;
        while (i < 8) {
            try {
                str = str + ((char) byteArrayInputStream.read());
                i++;
            } catch (IOException e) {
                AppMethodBeat.m2505o(93398);
                return false;
            }
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e2) {
        }
        if (str.startsWith("wxgf")) {
            AppMethodBeat.m2505o(93398);
            return true;
        }
        AppMethodBeat.m2505o(93398);
        return false;
    }

    public static String amq(String str) {
        AppMethodBeat.m2504i(93399);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.m2505o(93399);
            return str2;
        }
        str2 = C5063r.m7680bV(C5730e.m8632e(str, 0, 2));
        AppMethodBeat.m2505o(93399);
        return str2;
    }

    /* renamed from: bV */
    private static String m7680bV(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return "";
        }
        String str = FileUtils.PIC_POSTFIX_JPEG;
        byte b = bArr[0];
        if (b < (byte) 0) {
            b += 256;
        }
        byte b2 = bArr[1];
        if (b2 < (byte) 0) {
            b2 += 256;
        }
        if (b == (byte) 66 && b2 == (byte) 77) {
            return ".bmp";
        }
        if (b == (byte) -1 && b2 == (byte) -40) {
            return FileUtils.PIC_POSTFIX_JPEG;
        }
        if (b == (byte) -119 && b2 == (byte) 80) {
            return ".png";
        }
        return (b == (byte) 71 && b2 == (byte) 73) ? ".gif" : str;
    }
}
