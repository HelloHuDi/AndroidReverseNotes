package com.p123qq.p803wx.voice.embed.recognizer;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;

/* renamed from: com.qq.wx.voice.embed.recognizer.f */
final class C41656f {
    /* renamed from: a */
    private boolean f16881a = false;
    /* renamed from: b */
    String f16882b = null;

    C41656f() {
    }

    /* renamed from: a */
    private static boolean m73046a(String str, String str2) {
        AppMethodBeat.m2504i(123208);
        boolean exists = new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString()).exists();
        AppMethodBeat.m2505o(123208);
        return exists;
    }

    /* renamed from: a */
    private static boolean m73047a(String str, String[] strArr) {
        AppMethodBeat.m2504i(123206);
        for (String compareTo : strArr) {
            if (str.compareTo(compareTo) == 0) {
                AppMethodBeat.m2505o(123206);
                return true;
            }
        }
        AppMethodBeat.m2505o(123206);
        return false;
    }

    /* renamed from: b */
    private static String m73048b(String str, String str2) {
        String bigInteger;
        AppMethodBeat.m2504i(123209);
        File file = new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString());
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            MappedByteBuffer map = fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, file.length());
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(map);
            bigInteger = new BigInteger(1, instance.digest()).toString(16);
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
        } catch (Exception e2) {
            try {
                fileInputStream.close();
                bigInteger = null;
            } catch (IOException e3) {
                bigInteger = null;
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (IOException e4) {
            }
            AppMethodBeat.m2505o(123209);
        }
        AppMethodBeat.m2505o(123209);
        return bigInteger;
    }

    /* renamed from: f */
    private static void m73049f(String str, String str2, String str3) {
        FileChannel channel;
        FileChannel channel2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        FileChannel fileChannel;
        AppMethodBeat.m2504i(123207);
        File file = new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString());
        File file2 = new File(new StringBuilder(String.valueOf(str3)).append("/").append(str).toString());
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    channel = fileInputStream2.getChannel();
                    try {
                        channel2 = fileOutputStream2.getChannel();
                    } catch (IOException e) {
                        channel2 = null;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        try {
                            fileInputStream.close();
                            channel.close();
                            fileOutputStream.close();
                            channel2.close();
                            AppMethodBeat.m2505o(123207);
                        } catch (IOException e2) {
                            AppMethodBeat.m2505o(123207);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        channel2 = null;
                        fileChannel = channel;
                        try {
                            fileInputStream2.close();
                            fileChannel.close();
                            fileOutputStream2.close();
                            channel2.close();
                        } catch (IOException e3) {
                        }
                        AppMethodBeat.m2505o(123207);
                        throw th;
                    }
                } catch (IOException e4) {
                    channel2 = null;
                    channel = null;
                    fileOutputStream = fileOutputStream2;
                    fileInputStream = fileInputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    channel2 = null;
                    fileChannel = null;
                    fileInputStream2.close();
                    fileChannel.close();
                    fileOutputStream2.close();
                    channel2.close();
                    AppMethodBeat.m2505o(123207);
                    throw th;
                }
            } catch (IOException e5) {
                channel2 = null;
                channel = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                fileInputStream.close();
                channel.close();
                fileOutputStream.close();
                channel2.close();
                AppMethodBeat.m2505o(123207);
            } catch (Throwable th32) {
                th = th32;
                channel2 = null;
                fileChannel = null;
                fileOutputStream2 = null;
                fileInputStream2.close();
                fileChannel.close();
                fileOutputStream2.close();
                channel2.close();
                AppMethodBeat.m2505o(123207);
                throw th;
            }
            try {
                channel.transferTo(0, channel.size(), channel2);
                try {
                    fileInputStream2.close();
                    channel.close();
                    fileOutputStream2.close();
                    channel2.close();
                    AppMethodBeat.m2505o(123207);
                } catch (IOException e6) {
                    AppMethodBeat.m2505o(123207);
                }
            } catch (IOException e7) {
                fileOutputStream = fileOutputStream2;
                fileInputStream = fileInputStream2;
                fileInputStream.close();
                channel.close();
                fileOutputStream.close();
                channel2.close();
                AppMethodBeat.m2505o(123207);
            } catch (Throwable th4) {
                th = th4;
                fileChannel = channel;
                fileInputStream2.close();
                fileChannel.close();
                fileOutputStream2.close();
                channel2.close();
                AppMethodBeat.m2505o(123207);
                throw th;
            }
        } catch (IOException e8) {
            channel2 = null;
            channel = null;
            fileOutputStream = null;
            fileInputStream = null;
            fileInputStream.close();
            channel.close();
            fileOutputStream.close();
            channel2.close();
            AppMethodBeat.m2505o(123207);
        } catch (Throwable th322) {
            th = th322;
            channel2 = null;
            fileChannel = null;
            fileOutputStream2 = null;
            fileInputStream2 = null;
            fileInputStream2.close();
            fileChannel.close();
            fileOutputStream2.close();
            channel2.close();
            AppMethodBeat.m2505o(123207);
            throw th;
        }
    }

    /* renamed from: c */
    public final int mo67127c(Context context, String str, String str2, String str3) {
        AppMethodBeat.m2504i(123204);
        if (this.f16881a) {
            AppMethodBeat.m2505o(123204);
            return 0;
        } else if (!C41656f.m73046a("libwxvoiceembed.so", str)) {
            AppMethodBeat.m2505o(123204);
            return -201;
        } else if (C41656f.m73046a("libwxvoiceembed.bin", str)) {
            String stringBuilder = new StringBuilder(String.valueOf(context.getFilesDir().getAbsolutePath())).append("/NamesSearch/").toString();
            File file = new File(stringBuilder);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!C41656f.m73046a("libwxvoiceembed.so", stringBuilder)) {
                C41656f.m73049f("libwxvoiceembed.so", str, stringBuilder);
            }
            if (!C41656f.m73046a("libwxvoiceembed.bin", stringBuilder)) {
                C41656f.m73049f("libwxvoiceembed.bin", str, stringBuilder);
            }
            try {
                String b = C41656f.m73048b("libwxvoiceembed.so", stringBuilder);
                if (b.compareTo(C41656f.m73048b("libwxvoiceembed.so", str)) != 0) {
                    C41656f.m73049f("libwxvoiceembed.so", str, stringBuilder);
                }
                if (C41656f.m73047a(b, str2.split(";"))) {
                    try {
                        String b2 = C41656f.m73048b("libwxvoiceembed.bin", stringBuilder);
                        if (b2.compareTo(C41656f.m73048b("libwxvoiceembed.bin", str)) != 0) {
                            C41656f.m73049f("libwxvoiceembed.bin", str, stringBuilder);
                        }
                        if (C41656f.m73047a(b2, str3.split(";"))) {
                            this.f16882b = stringBuilder;
                            this.f16881a = true;
                            AppMethodBeat.m2505o(123204);
                            return 0;
                        }
                        AppMethodBeat.m2505o(123204);
                        return -204;
                    } catch (FileNotFoundException e) {
                        AppMethodBeat.m2505o(123204);
                        return -204;
                    }
                }
                AppMethodBeat.m2505o(123204);
                return -203;
            } catch (FileNotFoundException e2) {
                AppMethodBeat.m2505o(123204);
                return -203;
            }
        } else {
            AppMethodBeat.m2505o(123204);
            return -202;
        }
    }

    /* renamed from: e */
    public final int mo67128e(String str, String str2, String str3) {
        AppMethodBeat.m2504i(123205);
        if (this.f16881a) {
            AppMethodBeat.m2505o(123205);
            return 0;
        } else if (!C41656f.m73046a("libwxvoiceembed.so", str)) {
            AppMethodBeat.m2505o(123205);
            return -201;
        } else if (C41656f.m73046a("libwxvoiceembed.bin", str)) {
            try {
                if (C41656f.m73047a(C41656f.m73048b("libwxvoiceembed.so", str), str2.split(";"))) {
                    try {
                        if (C41656f.m73047a(C41656f.m73048b("libwxvoiceembed.bin", str), str3.split(";"))) {
                            this.f16882b = str;
                            this.f16881a = true;
                            AppMethodBeat.m2505o(123205);
                            return 0;
                        }
                        AppMethodBeat.m2505o(123205);
                        return -204;
                    } catch (FileNotFoundException e) {
                        AppMethodBeat.m2505o(123205);
                        return -204;
                    }
                }
                AppMethodBeat.m2505o(123205);
                return -203;
            } catch (FileNotFoundException e2) {
                AppMethodBeat.m2505o(123205);
                return -203;
            }
        } else {
            AppMethodBeat.m2505o(123205);
            return -202;
        }
    }
}
