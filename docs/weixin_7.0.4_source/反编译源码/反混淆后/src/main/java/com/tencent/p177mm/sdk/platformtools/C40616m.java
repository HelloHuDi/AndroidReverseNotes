package com.tencent.p177mm.sdk.platformtools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.sdk.platformtools.m */
public final class C40616m {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A:{SYNTHETIC, Splitter:B:23:0x0056} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b A:{SYNTHETIC, Splitter:B:26:0x005b} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A:{SYNTHETIC, Splitter:B:23:0x0056} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b A:{SYNTHETIC, Splitter:B:26:0x005b} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a6 A:{SYNTHETIC, Splitter:B:45:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ab A:{SYNTHETIC, Splitter:B:48:0x00ab} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a6 A:{SYNTHETIC, Splitter:B:45:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ab A:{SYNTHETIC, Splitter:B:48:0x00ab} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(String str, String str2) {
        Throwable e;
        boolean z = true;
        AppMethodBeat.m2504i(51986);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.SDK.FilesCopy", "copy file but src path or dest path is null, return false.");
            AppMethodBeat.m2505o(51986);
            return false;
        } else if (str.equals(str2)) {
            AppMethodBeat.m2505o(51986);
            return true;
        } else {
            FileInputStream fileInputStream;
            FileOutputStream fileOutputStream;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e2) {
                                    C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e2, "", new Object[0]);
                                    z = false;
                                }
                            }
                        }
                        fileInputStream.close();
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e22, "", new Object[0]);
                            z = false;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e, "", new Object[0]);
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(51986);
                            return z;
                        } catch (Throwable th) {
                            e = th;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(51986);
                            throw e;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                    C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e, "", new Object[0]);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e222) {
                            C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e222, "", new Object[0]);
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            z = false;
                        } catch (IOException e2222) {
                            C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e2222, "", new Object[0]);
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    AppMethodBeat.m2505o(51986);
                    return z;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e5, "", new Object[0]);
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e6, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(51986);
                    throw e;
                }
            } catch (Exception e7) {
                e = e7;
                fileOutputStream = null;
                fileInputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e, "", new Object[0]);
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(51986);
                return z;
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(51986);
                throw e;
            }
            AppMethodBeat.m2505o(51986);
            return z;
        }
    }

    /* renamed from: C */
    public static boolean m70056C(String str, String str2, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(51987);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(51987);
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            File file2 = new File(str2);
            if (file.isFile()) {
                if (file2.isFile() || !file2.exists()) {
                    C40616m.copyFile(str, str2);
                    if (z) {
                        file.delete();
                    }
                } else {
                    AppMethodBeat.m2505o(51987);
                    return false;
                }
            } else if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                if (file2.isDirectory()) {
                    String[] list = file.list();
                    while (i < list.length) {
                        C40616m.m70056C(str + "/" + list[i], str2 + "/" + list[i], z);
                        i++;
                    }
                } else {
                    AppMethodBeat.m2505o(51987);
                    return false;
                }
            }
            AppMethodBeat.m2505o(51987);
            return true;
        }
        AppMethodBeat.m2505o(51987);
        return false;
    }

    public static boolean copyAssets(Context context, String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(51988);
        try {
            boolean a = C40616m.m70057a(context.getAssets().open(str), str2, false);
            AppMethodBeat.m2505o(51988);
            return a;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.SDK.FilesCopy", "copy assets file srcpath=%s to=%s failed, try pattern now", str, str2);
            while (true) {
                try {
                    if (!C40616m.m70057a(context.getAssets().open(str + "." + i), str2, true)) {
                        break;
                    }
                    C4990ab.m7411d("MicroMsg.SDK.FilesCopy", "copy pattern %s", str + "." + i);
                    i++;
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(51988);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A:{SYNTHETIC, Splitter:B:14:0x0031} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A:{SYNTHETIC, Splitter:B:17:0x0036} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098 A:{SYNTHETIC, Splitter:B:46:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009d A:{SYNTHETIC, Splitter:B:49:0x009d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m70057a(InputStream inputStream, String str, boolean z) {
        Throwable e;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.m2504i(51989);
        FileOutputStream fileOutputStream;
        try {
            int available = inputStream.available();
            fileOutputStream = new FileOutputStream(str, z);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (!z) {
                    File file = new File(str);
                    if (!(file.exists() && ((long) available) == file.length())) {
                        z2 = false;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e2, "", new Object[0]);
                        z2 = false;
                    }
                }
                try {
                    fileOutputStream.close();
                    z3 = z2;
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e22, "", new Object[0]);
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e, "", new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e222) {
                            C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e222, "", new Object[0]);
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2222) {
                            C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e2222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(51989);
                    return z3;
                } catch (Throwable th) {
                    e = th;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(51989);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e, "", new Object[0]);
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(51989);
            return z3;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e5, "", new Object[0]);
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    C4990ab.printErrStackTrace("MicroMsg.SDK.FilesCopy", e6, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(51989);
            throw e;
        }
        AppMethodBeat.m2505o(51989);
        return z3;
    }
}
