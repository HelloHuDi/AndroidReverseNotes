package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* renamed from: com.tencent.xweb.xwalk.o */
public final class C41142o {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052 A:{SYNTHETIC, Splitter:B:18:0x0052} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d A:{SYNTHETIC, Splitter:B:31:0x006d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m71573a(File[] fileArr, String str) {
        Throwable th;
        boolean z = false;
        AppMethodBeat.m2504i(85414);
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            int i = 0;
            while (i <= 0) {
                try {
                    File file = fileArr[0];
                    if (file != null && file.exists()) {
                        if (file.isDirectory()) {
                            C41142o.m71572a(zipOutputStream, file, file.getName() + File.separator);
                        } else {
                            C41142o.m71572a(zipOutputStream, file, "");
                        }
                    }
                    i++;
                } catch (Exception e) {
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.closeEntry();
                            zipOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.m2505o(85414);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.closeEntry();
                            zipOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    AppMethodBeat.m2505o(85414);
                    throw th;
                }
            }
            z = true;
            zipOutputStream.flush();
            try {
                zipOutputStream.closeEntry();
                zipOutputStream.close();
            } catch (IOException e4) {
            }
        } catch (Exception e5) {
            zipOutputStream = null;
            if (zipOutputStream != null) {
            }
            AppMethodBeat.m2505o(85414);
            return z;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
            if (zipOutputStream != null) {
            }
            AppMethodBeat.m2505o(85414);
            throw th;
        }
        AppMethodBeat.m2505o(85414);
        return z;
    }

    /* renamed from: a */
    private static void m71572a(ZipOutputStream zipOutputStream, File file, String str) {
        int i = 0;
        AppMethodBeat.m2504i(85415);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        C41142o.m71572a(zipOutputStream, file2, file.getName() + File.separator + file2.getName() + File.separator);
                    } else {
                        C41142o.m71572a(zipOutputStream, file2, str);
                    }
                }
                i++;
            }
            AppMethodBeat.m2505o(85415);
            return;
        }
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                AppMethodBeat.m2505o(85415);
                return;
            }
        }
    }

    /* renamed from: iL */
    private static void m71575iL(String str, String str2) {
        AppMethodBeat.m2504i(85417);
        String[] split = str.split("/");
        if (split.length <= 1) {
            AppMethodBeat.m2505o(85417);
            return;
        }
        for (int i = 0; i < split.length - 1; i++) {
            str2 = str2 + split[i] + "/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        AppMethodBeat.m2505o(85417);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075 A:{SYNTHETIC, Splitter:B:24:0x0075} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A:{Catch:{ IOException -> 0x00f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de A:{SYNTHETIC, Splitter:B:50:0x00de} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e6 A:{Catch:{ IOException -> 0x00ed }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075 A:{SYNTHETIC, Splitter:B:24:0x0075} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A:{Catch:{ IOException -> 0x00f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de A:{SYNTHETIC, Splitter:B:50:0x00de} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e6 A:{Catch:{ IOException -> 0x00ed }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075 A:{SYNTHETIC, Splitter:B:24:0x0075} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A:{Catch:{ IOException -> 0x00f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de A:{SYNTHETIC, Splitter:B:50:0x00de} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e6 A:{Catch:{ IOException -> 0x00ed }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: iK */
    public static boolean m71574iK(String str, String str2) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream = null;
        boolean z = false;
        AppMethodBeat.m2504i(85416);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!str.endsWith("/")) {
            str = str + IOUtils.DIR_SEPARATOR_UNIX;
        }
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream2;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str2)));
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!(name.contains("../") || name.contains("..\\"))) {
                            C41142o.m71575iL(name, str);
                            if (nextEntry.isDirectory()) {
                                new File(str + name).mkdirs();
                            } else {
                                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str + name));
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    } catch (IOException e) {
                                        if (zipInputStream != null) {
                                        }
                                        if (bufferedOutputStream2 != null) {
                                        }
                                        AppMethodBeat.m2505o(85416);
                                        return z;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (zipInputStream != null) {
                                        }
                                        if (bufferedOutputStream2 != null) {
                                        }
                                        AppMethodBeat.m2505o(85416);
                                        throw th;
                                    }
                                }
                                bufferedOutputStream2.flush();
                                bufferedOutputStream2.close();
                                bufferedOutputStream = bufferedOutputStream2;
                            }
                        }
                    } catch (IOException e2) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.closeEntry();
                                zipInputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (bufferedOutputStream2 != null) {
                            bufferedOutputStream2.close();
                        }
                        AppMethodBeat.m2505o(85416);
                        return z;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream2 = bufferedOutputStream;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.closeEntry();
                                zipInputStream.close();
                            } catch (IOException e4) {
                                AppMethodBeat.m2505o(85416);
                                throw th;
                            }
                        }
                        if (bufferedOutputStream2 != null) {
                            bufferedOutputStream2.close();
                        }
                        AppMethodBeat.m2505o(85416);
                        throw th;
                    }
                }
                z = true;
                try {
                    zipInputStream.closeEntry();
                    zipInputStream.close();
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } catch (IOException e5) {
                }
            } catch (IOException e6) {
                bufferedOutputStream2 = null;
                if (zipInputStream != null) {
                }
                if (bufferedOutputStream2 != null) {
                }
                AppMethodBeat.m2505o(85416);
                return z;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream2 = null;
                if (zipInputStream != null) {
                }
                if (bufferedOutputStream2 != null) {
                }
                AppMethodBeat.m2505o(85416);
                throw th;
            }
        } catch (IOException e7) {
            zipInputStream = null;
            bufferedOutputStream2 = null;
            if (zipInputStream != null) {
            }
            if (bufferedOutputStream2 != null) {
            }
            AppMethodBeat.m2505o(85416);
            return z;
        } catch (Throwable th5) {
            th = th5;
            zipInputStream = null;
            bufferedOutputStream2 = null;
            if (zipInputStream != null) {
            }
            if (bufferedOutputStream2 != null) {
            }
            AppMethodBeat.m2505o(85416);
            throw th;
        }
        AppMethodBeat.m2505o(85416);
        return z;
    }
}
