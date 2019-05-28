package com.tencent.p177mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvoice.o */
public final class C32848o {
    /* renamed from: uK */
    public static int m53699uK(String str) {
        AppMethodBeat.m2504i(116605);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(116605);
            return -1;
        }
        C4990ab.m7410d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(str)));
        if (C32848o.m53697h(str, 0, false)) {
            AppMethodBeat.m2505o(116605);
            return 0;
        } else if (C32848o.m53698i(str, 0, false)) {
            AppMethodBeat.m2505o(116605);
            return 2;
        } else {
            AppMethodBeat.m2505o(116605);
            return 1;
        }
    }

    /* renamed from: g */
    public static int m53696g(String str, int i, boolean z) {
        AppMethodBeat.m2504i(116606);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(116606);
            return -1;
        }
        C4990ab.m7410d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(str)));
        if (C32848o.m53697h(str, i, z)) {
            AppMethodBeat.m2505o(116606);
            return 0;
        } else if (C32848o.m53698i(str, i, z)) {
            AppMethodBeat.m2505o(116606);
            return 2;
        } else {
            AppMethodBeat.m2505o(116606);
            return 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e6 A:{SYNTHETIC, Splitter:B:42:0x00e6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    private static boolean m53697h(String str, int i, boolean z) {
        Object str2;
        Throwable e;
        AppMethodBeat.m2504i(116607);
        if (!z) {
            if (i == 0) {
                str2 = C32850q.getFullPath(str2);
            } else {
                str2 = null;
            }
        }
        C4990ab.m7410d("MicroMsg.VoiceFile", "path ".concat(String.valueOf(str2)));
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str2, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    C4990ab.m7412e("MicroMsg.VoiceFile", "read amr file header failed!");
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e2));
                    }
                    AppMethodBeat.m2505o(116607);
                    return false;
                }
                C4990ab.m7417i("MicroMsg.VoiceFile", "isAmrHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", C5046bo.m7539ca(bArr), new String(bArr), "#!AMR\n");
                if (new String(bArr).endsWith("#!AMR\n")) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e22) {
                        C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e22));
                    }
                    AppMethodBeat.m2505o(116607);
                    return true;
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e222) {
                    C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e222));
                }
                AppMethodBeat.m2505o(116607);
                return false;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            try {
                C4990ab.printErrStackTrace("MicroMsg.VoiceFile", e, "", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2222) {
                        C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e2222));
                    }
                }
                AppMethodBeat.m2505o(116607);
                return false;
            } catch (Throwable e32) {
                e = e32;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e22222) {
                        C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e22222));
                    }
                }
                AppMethodBeat.m2505o(116607);
                throw e;
            }
        } catch (Throwable th) {
            e = th;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.m2505o(116607);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f5 A:{SYNTHETIC, Splitter:B:43:0x00f5} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f5 A:{SYNTHETIC, Splitter:B:43:0x00f5} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public static boolean m53698i(String str, int i, boolean z) {
        Object str2;
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        AppMethodBeat.m2504i(116608);
        if (!z) {
            if (i == 0) {
                str2 = C32850q.getFullPath(str2);
            } else if (i == 1) {
                C4990ab.m7413e("MicroMsg.VoiceFile", "isSilkHeader usertype error, TYPE_RECOGNIZER_BIZ fileName:%s", str2);
                AppMethodBeat.m2505o(116608);
                return false;
            } else {
                str2 = null;
            }
        }
        C4990ab.m7410d("MicroMsg.VoiceFile", "isSilkHeader path ".concat(String.valueOf(str2)));
        try {
            RandomAccessFile randomAccessFile3 = new RandomAccessFile(str2, "r");
            try {
                byte[] bArr = new byte[9];
                randomAccessFile3.seek(1);
                if (randomAccessFile3.read(bArr, 0, 9) == -1) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e));
                    }
                    AppMethodBeat.m2505o(116608);
                    return false;
                }
                C4990ab.m7417i("MicroMsg.VoiceFile", "isSilkHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", C5046bo.m7539ca(bArr), new String(bArr), "#!SILK_V3");
                if (new String(bArr).endsWith("#!SILK_V3")) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException e2) {
                        C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e2));
                    }
                    AppMethodBeat.m2505o(116608);
                    return true;
                }
                try {
                    randomAccessFile3.close();
                } catch (IOException e22) {
                    C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e22));
                }
                AppMethodBeat.m2505o(116608);
                return false;
            } catch (Exception e3) {
                randomAccessFile2 = randomAccessFile3;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile3;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.m2505o(116608);
                throw th;
            }
        } catch (Exception e4) {
            try {
                C4990ab.m7410d("MicroMsg.VoiceFile", "isSilkHeader file not found");
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e222) {
                        C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e222));
                    }
                }
                AppMethodBeat.m2505o(116608);
                return false;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2222) {
                        C4990ab.m7413e("MicroMsg.VoiceFile", "exception:%s", C5046bo.m7574l(e2222));
                    }
                }
                AppMethodBeat.m2505o(116608);
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.m2505o(116608);
            throw th;
        }
    }

    /* renamed from: uj */
    public static int m53701uj(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(116609);
        int uL;
        String fullPath;
        File file;
        int length;
        switch (C32848o.m53699uK(str)) {
            case 0:
                uL = C32848o.m53700uL(C32850q.getFullPath(str));
                AppMethodBeat.m2505o(116609);
                return uL;
            case 1:
                fullPath = C32850q.getFullPath(str);
                if (fullPath.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(fullPath);
                if (file.exists()) {
                    length = (int) file.length();
                    if (length <= 0) {
                        AppMethodBeat.m2505o(116609);
                        return 0;
                    }
                    AppMethodBeat.m2505o(116609);
                    return length;
                }
                AppMethodBeat.m2505o(116609);
                return 0;
            case 2:
                fullPath = C32850q.getFullPath(str);
                if (fullPath.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(fullPath);
                if (file.exists()) {
                    length = (int) file.length();
                    if (length <= 0) {
                        AppMethodBeat.m2505o(116609);
                        return 0;
                    }
                    AppMethodBeat.m2505o(116609);
                    return length;
                }
                AppMethodBeat.m2505o(116609);
                return 0;
            default:
                uL = C32848o.m53700uL(C32850q.getFullPath(str));
                AppMethodBeat.m2505o(116609);
                return uL;
        }
    }

    /* renamed from: uL */
    private static int m53700uL(String str) {
        AppMethodBeat.m2504i(116610);
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (file.exists()) {
            int length = ((int) file.length()) - 6;
            if (length <= 0) {
                AppMethodBeat.m2505o(116610);
                return 0;
            }
            AppMethodBeat.m2505o(116610);
            return length;
        }
        AppMethodBeat.m2505o(116610);
        return 0;
    }
}
