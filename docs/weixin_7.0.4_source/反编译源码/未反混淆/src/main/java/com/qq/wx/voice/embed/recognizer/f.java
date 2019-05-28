package com.qq.wx.voice.embed.recognizer;

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

final class f {
    private boolean a = false;
    String b = null;

    f() {
    }

    private static boolean a(String str, String str2) {
        AppMethodBeat.i(123208);
        boolean exists = new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString()).exists();
        AppMethodBeat.o(123208);
        return exists;
    }

    private static boolean a(String str, String[] strArr) {
        AppMethodBeat.i(123206);
        for (String compareTo : strArr) {
            if (str.compareTo(compareTo) == 0) {
                AppMethodBeat.o(123206);
                return true;
            }
        }
        AppMethodBeat.o(123206);
        return false;
    }

    private static String b(String str, String str2) {
        String bigInteger;
        AppMethodBeat.i(123209);
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
            AppMethodBeat.o(123209);
        }
        AppMethodBeat.o(123209);
        return bigInteger;
    }

    private static void f(String str, String str2, String str3) {
        FileChannel channel;
        FileChannel channel2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        FileChannel fileChannel;
        AppMethodBeat.i(123207);
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
                            AppMethodBeat.o(123207);
                        } catch (IOException e2) {
                            AppMethodBeat.o(123207);
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
                        AppMethodBeat.o(123207);
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
                    AppMethodBeat.o(123207);
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
                AppMethodBeat.o(123207);
            } catch (Throwable th32) {
                th = th32;
                channel2 = null;
                fileChannel = null;
                fileOutputStream2 = null;
                fileInputStream2.close();
                fileChannel.close();
                fileOutputStream2.close();
                channel2.close();
                AppMethodBeat.o(123207);
                throw th;
            }
            try {
                channel.transferTo(0, channel.size(), channel2);
                try {
                    fileInputStream2.close();
                    channel.close();
                    fileOutputStream2.close();
                    channel2.close();
                    AppMethodBeat.o(123207);
                } catch (IOException e6) {
                    AppMethodBeat.o(123207);
                }
            } catch (IOException e7) {
                fileOutputStream = fileOutputStream2;
                fileInputStream = fileInputStream2;
                fileInputStream.close();
                channel.close();
                fileOutputStream.close();
                channel2.close();
                AppMethodBeat.o(123207);
            } catch (Throwable th4) {
                th = th4;
                fileChannel = channel;
                fileInputStream2.close();
                fileChannel.close();
                fileOutputStream2.close();
                channel2.close();
                AppMethodBeat.o(123207);
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
            AppMethodBeat.o(123207);
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
            AppMethodBeat.o(123207);
            throw th;
        }
    }

    public final int c(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(123204);
        if (this.a) {
            AppMethodBeat.o(123204);
            return 0;
        } else if (!a("libwxvoiceembed.so", str)) {
            AppMethodBeat.o(123204);
            return -201;
        } else if (a("libwxvoiceembed.bin", str)) {
            String stringBuilder = new StringBuilder(String.valueOf(context.getFilesDir().getAbsolutePath())).append("/NamesSearch/").toString();
            File file = new File(stringBuilder);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!a("libwxvoiceembed.so", stringBuilder)) {
                f("libwxvoiceembed.so", str, stringBuilder);
            }
            if (!a("libwxvoiceembed.bin", stringBuilder)) {
                f("libwxvoiceembed.bin", str, stringBuilder);
            }
            try {
                String b = b("libwxvoiceembed.so", stringBuilder);
                if (b.compareTo(b("libwxvoiceembed.so", str)) != 0) {
                    f("libwxvoiceembed.so", str, stringBuilder);
                }
                if (a(b, str2.split(";"))) {
                    try {
                        String b2 = b("libwxvoiceembed.bin", stringBuilder);
                        if (b2.compareTo(b("libwxvoiceembed.bin", str)) != 0) {
                            f("libwxvoiceembed.bin", str, stringBuilder);
                        }
                        if (a(b2, str3.split(";"))) {
                            this.b = stringBuilder;
                            this.a = true;
                            AppMethodBeat.o(123204);
                            return 0;
                        }
                        AppMethodBeat.o(123204);
                        return -204;
                    } catch (FileNotFoundException e) {
                        AppMethodBeat.o(123204);
                        return -204;
                    }
                }
                AppMethodBeat.o(123204);
                return -203;
            } catch (FileNotFoundException e2) {
                AppMethodBeat.o(123204);
                return -203;
            }
        } else {
            AppMethodBeat.o(123204);
            return -202;
        }
    }

    public final int e(String str, String str2, String str3) {
        AppMethodBeat.i(123205);
        if (this.a) {
            AppMethodBeat.o(123205);
            return 0;
        } else if (!a("libwxvoiceembed.so", str)) {
            AppMethodBeat.o(123205);
            return -201;
        } else if (a("libwxvoiceembed.bin", str)) {
            try {
                if (a(b("libwxvoiceembed.so", str), str2.split(";"))) {
                    try {
                        if (a(b("libwxvoiceembed.bin", str), str3.split(";"))) {
                            this.b = str;
                            this.a = true;
                            AppMethodBeat.o(123205);
                            return 0;
                        }
                        AppMethodBeat.o(123205);
                        return -204;
                    } catch (FileNotFoundException e) {
                        AppMethodBeat.o(123205);
                        return -204;
                    }
                }
                AppMethodBeat.o(123205);
                return -203;
            } catch (FileNotFoundException e2) {
                AppMethodBeat.o(123205);
                return -203;
            }
        } else {
            AppMethodBeat.o(123205);
            return -202;
        }
    }
}
