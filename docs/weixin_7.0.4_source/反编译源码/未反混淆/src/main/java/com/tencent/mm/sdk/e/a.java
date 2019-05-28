package com.tencent.mm.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class a {
    private String filePath;
    private Properties xCY;

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d A:{SYNTHETIC, Splitter:B:15:0x005d} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080 A:{SYNTHETIC, Splitter:B:23:0x0080} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(52485);
        this.xCY = null;
        this.filePath = null;
        this.xCY = new Properties();
        this.filePath = str;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                this.xCY.load(fileInputStream);
                try {
                    fileInputStream.close();
                    AppMethodBeat.o(52485);
                } catch (IOException e2) {
                    ab.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e2.getLocalizedMessage());
                    AppMethodBeat.o(52485);
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
                    if (fileInputStream == null) {
                        try {
                            fileInputStream.close();
                            AppMethodBeat.o(52485);
                            return;
                        } catch (IOException e22) {
                            ab.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e22.getLocalizedMessage());
                            AppMethodBeat.o(52485);
                            return;
                        }
                    }
                    AppMethodBeat.o(52485);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            ab.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e4.getLocalizedMessage());
                        }
                    }
                    AppMethodBeat.o(52485);
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            ab.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
            if (fileInputStream == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(52485);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A:{SYNTHETIC, Splitter:B:24:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058 A:{SYNTHETIC, Splitter:B:16:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hV(String str, String str2) {
        Exception e;
        Throwable th;
        boolean z = true;
        AppMethodBeat.i(52486);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(this.filePath);
            try {
                this.xCY.setProperty(str, str2);
                this.xCY.store(fileOutputStream, "");
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    ab.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e2.getLocalizedMessage());
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
                    if (fileOutputStream == null) {
                    }
                    AppMethodBeat.o(52486);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(52486);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            ab.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
            if (fileOutputStream == null) {
                try {
                    fileOutputStream.close();
                    z = false;
                } catch (IOException e22) {
                    ab.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e22.getLocalizedMessage());
                    z = false;
                }
            } else {
                z = false;
            }
            AppMethodBeat.o(52486);
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    ab.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e5.getLocalizedMessage());
                }
            }
            AppMethodBeat.o(52486);
            throw th;
        }
        AppMethodBeat.o(52486);
        return z;
    }

    public final boolean aK(String str, long j) {
        AppMethodBeat.i(52487);
        boolean hV = hV(str, String.valueOf(j));
        AppMethodBeat.o(52487);
        return hV;
    }

    public final boolean ej(String str, int i) {
        AppMethodBeat.i(52488);
        boolean hV = hV(str, String.valueOf(i));
        AppMethodBeat.o(52488);
        return hV;
    }

    public final String getValue(String str) {
        AppMethodBeat.i(52489);
        if (this.xCY == null || !this.xCY.containsKey(str)) {
            AppMethodBeat.o(52489);
            return null;
        }
        String property = this.xCY.getProperty(str);
        AppMethodBeat.o(52489);
        return property;
    }

    public final Long anD(String str) {
        Long l = null;
        AppMethodBeat.i(52490);
        String value = getValue(str);
        if (value == null) {
            AppMethodBeat.o(52490);
        } else {
            try {
                l = Long.valueOf(Long.parseLong(value));
                AppMethodBeat.o(52490);
            } catch (Exception e) {
                ab.e("MicroMsg.ReadConfig", "getLongValue ParseLong : %s Failed. [%s]", value, e.getLocalizedMessage());
                AppMethodBeat.o(52490);
            }
        }
        return l;
    }

    public final Integer anE(String str) {
        Integer num = null;
        AppMethodBeat.i(52491);
        String value = getValue(str);
        if (value == null) {
            AppMethodBeat.o(52491);
        } else {
            try {
                num = Integer.valueOf(Integer.parseInt(value));
                AppMethodBeat.o(52491);
            } catch (Exception e) {
                ab.e("MicroMsg.ReadConfig", "getIntegerValue ParseInteger : %s Failed. [%s]", value, e.getLocalizedMessage());
                AppMethodBeat.o(52491);
            }
        }
        return num;
    }

    public static String getValue(String str, String str2) {
        AppMethodBeat.i(52492);
        String value = new a(str).getValue(str2);
        AppMethodBeat.o(52492);
        return value;
    }

    public static Long hW(String str, String str2) {
        AppMethodBeat.i(52493);
        Long anD = new a(str).anD(str2);
        AppMethodBeat.o(52493);
        return anD;
    }

    public static boolean aB(String str, String str2, String str3) {
        AppMethodBeat.i(52494);
        boolean hV = new a(str).hV(str2, str3);
        AppMethodBeat.o(52494);
        return hV;
    }

    public static boolean p(String str, String str2, long j) {
        AppMethodBeat.i(52495);
        boolean aK = new a(str).aK(str2, j);
        AppMethodBeat.o(52495);
        return aK;
    }

    public static boolean hX(String str, String str2) {
        AppMethodBeat.i(52496);
        boolean ej = new a(str).ej(str2, 0);
        AppMethodBeat.o(52496);
        return ej;
    }
}
