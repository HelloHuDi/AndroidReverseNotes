package com.tencent.xweb.util;

import android.content.res.AssetFileDescriptor;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.util.b */
public final class C41131b {
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b A:{SYNTHETIC, Splitter:B:43:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090 A:{SYNTHETIC, Splitter:B:46:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0095 A:{SYNTHETIC, Splitter:B:49:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009a A:{SYNTHETIC, Splitter:B:52:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c A:{SYNTHETIC, Splitter:B:28:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071 A:{SYNTHETIC, Splitter:B:31:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076 A:{SYNTHETIC, Splitter:B:34:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007b A:{SYNTHETIC, Splitter:B:37:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b A:{SYNTHETIC, Splitter:B:43:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090 A:{SYNTHETIC, Splitter:B:46:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0095 A:{SYNTHETIC, Splitter:B:49:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009a A:{SYNTHETIC, Splitter:B:52:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b A:{SYNTHETIC, Splitter:B:43:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090 A:{SYNTHETIC, Splitter:B:46:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0095 A:{SYNTHETIC, Splitter:B:49:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009a A:{SYNTHETIC, Splitter:B:52:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c A:{SYNTHETIC, Splitter:B:28:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071 A:{SYNTHETIC, Splitter:B:31:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076 A:{SYNTHETIC, Splitter:B:34:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007b A:{SYNTHETIC, Splitter:B:37:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b A:{SYNTHETIC, Splitter:B:43:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090 A:{SYNTHETIC, Splitter:B:46:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0095 A:{SYNTHETIC, Splitter:B:49:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009a A:{SYNTHETIC, Splitter:B:52:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c A:{SYNTHETIC, Splitter:B:28:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071 A:{SYNTHETIC, Splitter:B:31:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076 A:{SYNTHETIC, Splitter:B:34:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007b A:{SYNTHETIC, Splitter:B:37:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b A:{SYNTHETIC, Splitter:B:43:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090 A:{SYNTHETIC, Splitter:B:46:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0095 A:{SYNTHETIC, Splitter:B:49:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009a A:{SYNTHETIC, Splitter:B:52:0x009a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(String str, String str2) {
        Object e;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        Throwable th;
        Exception e2;
        AppMethodBeat.m2504i(WearableStatusCodes.DUPLICATE_LISTENER);
        FileChannel channel;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                channel = fileInputStream2.getChannel();
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                    try {
                        FileChannel channel2 = fileOutputStream2.getChannel();
                        try {
                            channel2.transferFrom(channel, 0, channel.size());
                            channel2.force(true);
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e4) {
                            }
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (IOException e5) {
                                }
                            }
                            if (channel2 != null) {
                                try {
                                    channel2.close();
                                } catch (IOException e6) {
                                }
                            }
                            AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
                            return true;
                        } catch (Exception e7) {
                            e2 = e7;
                            fileOutputStream = fileOutputStream2;
                            fileInputStream = fileInputStream2;
                            fileChannel = channel2;
                            try {
                                Log.m81046e("FileUtils", String.format("file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", new Object[]{e2.getClass().getSimpleName(), e2.getMessage(), str, str2}));
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (channel != null) {
                                }
                                if (fileChannel != null) {
                                }
                                AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (channel != null) {
                                }
                                if (fileChannel != null) {
                                }
                                AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            fileInputStream = fileInputStream2;
                            fileChannel = channel2;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (channel != null) {
                            }
                            if (fileChannel != null) {
                            }
                            AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
                            throw th;
                        }
                    } catch (Exception e8) {
                        e2 = e8;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        fileChannel = null;
                        Log.m81046e("FileUtils", String.format("file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", new Object[]{e2.getClass().getSimpleName(), e2.getMessage(), str, str2}));
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (channel != null) {
                        }
                        if (fileChannel != null) {
                        }
                        AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
                        return false;
                    } catch (Throwable th22) {
                        th = th22;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        fileChannel = null;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (channel != null) {
                        }
                        if (fileChannel != null) {
                        }
                        AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
                        throw th;
                    }
                } catch (Exception e82) {
                    e2 = e82;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    fileChannel = null;
                    Log.m81046e("FileUtils", String.format("file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", new Object[]{e2.getClass().getSimpleName(), e2.getMessage(), str, str2}));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e9) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e10) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e11) {
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e12) {
                        }
                    }
                    AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
                    return false;
                } catch (Throwable th222) {
                    th = th222;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    fileChannel = null;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    if (channel != null) {
                    }
                    if (fileChannel != null) {
                    }
                    AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
                    throw th;
                }
            } catch (Exception e822) {
                e2 = e822;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                fileChannel = null;
                channel = null;
            } catch (Throwable th2222) {
                th = th2222;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                fileChannel = null;
                channel = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e13) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e14) {
                    }
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e15) {
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e16) {
                    }
                }
                AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
                throw th;
            }
        } catch (Exception e8222) {
            e2 = e8222;
            fileOutputStream = null;
            fileInputStream = null;
            fileChannel = null;
            channel = null;
            Log.m81046e("FileUtils", String.format("file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", new Object[]{e2.getClass().getSimpleName(), e2.getMessage(), str, str2}));
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (channel != null) {
            }
            if (fileChannel != null) {
            }
            AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
            return false;
        } catch (Throwable th22222) {
            th = th22222;
            fileOutputStream = null;
            fileInputStream = null;
            fileChannel = null;
            channel = null;
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (channel != null) {
            }
            if (fileChannel != null) {
            }
            AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_LISTENER);
            throw th;
        }
    }

    /* renamed from: m */
    public static boolean m71563m(File file, File file2) {
        Closeable bufferedInputStream;
        Exception e;
        Closeable closeable;
        Closeable closeable2;
        Throwable th;
        AppMethodBeat.m2504i(WearableStatusCodes.UNKNOWN_LISTENER);
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                closeable = null;
                closeable2 = null;
                bufferedInputStream = null;
                try {
                    Log.m81046e("FileUtils", "copyFile error:" + e.getMessage());
                    C41131b.tryClose(bufferedInputStream);
                    C41131b.tryClose(closeable);
                    C41131b.tryClose(fileInputStream);
                    C41131b.tryClose(closeable2);
                    AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    C41131b.tryClose(bufferedInputStream);
                    C41131b.tryClose(closeable);
                    C41131b.tryClose(fileInputStream);
                    C41131b.tryClose(closeable2);
                    AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                closeable2 = null;
                bufferedInputStream = null;
                C41131b.tryClose(bufferedInputStream);
                C41131b.tryClose(closeable);
                C41131b.tryClose(fileInputStream);
                C41131b.tryClose(closeable2);
                AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
                throw th;
            }
            try {
                closeable2 = new FileOutputStream(file2);
                try {
                    closeable = new BufferedOutputStream(closeable2);
                } catch (Exception e3) {
                    e = e3;
                    closeable = null;
                    Log.m81046e("FileUtils", "copyFile error:" + e.getMessage());
                    C41131b.tryClose(bufferedInputStream);
                    C41131b.tryClose(closeable);
                    C41131b.tryClose(fileInputStream);
                    C41131b.tryClose(closeable2);
                    AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    closeable = null;
                    C41131b.tryClose(bufferedInputStream);
                    C41131b.tryClose(closeable);
                    C41131b.tryClose(fileInputStream);
                    C41131b.tryClose(closeable2);
                    AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            closeable.write(bArr, 0, read);
                        } else {
                            closeable.flush();
                            C41131b.tryClose(bufferedInputStream);
                            C41131b.tryClose(closeable);
                            C41131b.tryClose(fileInputStream);
                            C41131b.tryClose(closeable2);
                            AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
                            return true;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.m81046e("FileUtils", "copyFile error:" + e.getMessage());
                    C41131b.tryClose(bufferedInputStream);
                    C41131b.tryClose(closeable);
                    C41131b.tryClose(fileInputStream);
                    C41131b.tryClose(closeable2);
                    AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
                    return false;
                }
            } catch (Exception e5) {
                e = e5;
                closeable = null;
                closeable2 = null;
                Log.m81046e("FileUtils", "copyFile error:" + e.getMessage());
                C41131b.tryClose(bufferedInputStream);
                C41131b.tryClose(closeable);
                C41131b.tryClose(fileInputStream);
                C41131b.tryClose(closeable2);
                AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
                return false;
            } catch (Throwable th5) {
                th = th5;
                closeable = null;
                closeable2 = null;
                C41131b.tryClose(bufferedInputStream);
                C41131b.tryClose(closeable);
                C41131b.tryClose(fileInputStream);
                C41131b.tryClose(closeable2);
                AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            closeable = null;
            closeable2 = null;
            bufferedInputStream = null;
            fileInputStream = null;
            Log.m81046e("FileUtils", "copyFile error:" + e.getMessage());
            C41131b.tryClose(bufferedInputStream);
            C41131b.tryClose(closeable);
            C41131b.tryClose(fileInputStream);
            C41131b.tryClose(closeable2);
            AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
            return false;
        } catch (Throwable th6) {
            th = th6;
            closeable = null;
            closeable2 = null;
            bufferedInputStream = null;
            fileInputStream = null;
            C41131b.tryClose(bufferedInputStream);
            C41131b.tryClose(closeable);
            C41131b.tryClose(fileInputStream);
            C41131b.tryClose(closeable2);
            AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_LISTENER);
            throw th;
        }
    }

    /* renamed from: iI */
    public static boolean m71562iI(String str, String str2) {
        AppMethodBeat.m2504i(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
        File file = new File(str2);
        if (!(file.isDirectory() && file.exists())) {
            file.mkdirs();
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            AppMethodBeat.m2505o(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
            return false;
        }
        int i = 0;
        while (i < listFiles.length) {
            if (listFiles[i].isFile() && !C41131b.m71563m(listFiles[i], new File(new File(str2).getAbsolutePath() + File.separator + listFiles[i].getName()))) {
                AppMethodBeat.m2505o(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
                return false;
            } else if (listFiles[i].isDirectory() && C41131b.m71562iI(str + "/" + listFiles[i].getName(), str2 + "/" + listFiles[i].getName())) {
                AppMethodBeat.m2505o(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
                return false;
            } else {
                i++;
            }
        }
        AppMethodBeat.m2505o(WearableStatusCodes.DATA_ITEM_TOO_LARGE);
        return true;
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.m2504i(WearableStatusCodes.INVALID_TARGET_NODE);
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
            AppMethodBeat.m2505o(WearableStatusCodes.INVALID_TARGET_NODE);
            return true;
        }
        AppMethodBeat.m2505o(WearableStatusCodes.INVALID_TARGET_NODE);
        return false;
    }

    public static boolean avl(String str) {
        AppMethodBeat.m2504i(WearableStatusCodes.ASSET_UNAVAILABLE);
        try {
            C41131b.deleteAll(new File(str));
            AppMethodBeat.m2505o(WearableStatusCodes.ASSET_UNAVAILABLE);
            return true;
        } catch (Exception e) {
            Log.m81049i("FileUtils", String.format("delete all files.(%s)", new Object[]{str}));
            AppMethodBeat.m2505o(WearableStatusCodes.ASSET_UNAVAILABLE);
            return false;
        }
    }

    private static void deleteAll(File file) {
        AppMethodBeat.m2504i(WearableStatusCodes.DUPLICATE_CAPABILITY);
        if (file == null || !file.exists()) {
            AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_CAPABILITY);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_CAPABILITY);
        } else {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.exists()) {
                            if (file2.isFile()) {
                                file2.delete();
                            } else {
                                C41131b.deleteAll(file2);
                            }
                        }
                    }
                }
                file.delete();
            }
            AppMethodBeat.m2505o(WearableStatusCodes.DUPLICATE_CAPABILITY);
        }
    }

    public static void tryClose(Closeable closeable) {
        AppMethodBeat.m2504i(WearableStatusCodes.UNKNOWN_CAPABILITY);
        if (closeable == null) {
            AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_CAPABILITY);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_CAPABILITY);
        } catch (Exception e) {
            Log.m81046e("FileUtils", "closeable close  failed " + e.getMessage());
            AppMethodBeat.m2505o(WearableStatusCodes.UNKNOWN_CAPABILITY);
        }
    }

    /* renamed from: a */
    public static void m71559a(AssetFileDescriptor assetFileDescriptor) {
        AppMethodBeat.m2504i(WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED);
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
                AppMethodBeat.m2505o(WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED);
                return;
            } catch (Exception e) {
                Log.m81046e("FileUtils", "tryClose AssetFileDescriptor error: " + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED);
    }

    /* renamed from: a */
    public static boolean m71560a(AssetFileDescriptor assetFileDescriptor, File file) {
        Closeable fileOutputStream;
        Closeable createInputStream;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(4009);
        if (assetFileDescriptor == null) {
            Log.m81046e("FileUtils", "copyFileFromDescriptorAndClose wrong param");
            AppMethodBeat.m2505o(4009);
            return false;
        }
        try {
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                createInputStream = assetFileDescriptor.createInputStream();
            } catch (Exception e2) {
                e = e2;
                createInputStream = null;
                try {
                    Log.m81046e("FileUtils", "copyFileFromDescriptorAndClose error: " + e.getMessage());
                    C41131b.tryClose(fileOutputStream);
                    C41131b.tryClose(createInputStream);
                    C41131b.m71559a(assetFileDescriptor);
                    AppMethodBeat.m2505o(4009);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    C41131b.tryClose(fileOutputStream);
                    C41131b.tryClose(createInputStream);
                    C41131b.m71559a(assetFileDescriptor);
                    AppMethodBeat.m2505o(4009);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                createInputStream = null;
                C41131b.tryClose(fileOutputStream);
                C41131b.tryClose(createInputStream);
                C41131b.m71559a(assetFileDescriptor);
                AppMethodBeat.m2505o(4009);
                throw th;
            }
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = createInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        C41131b.tryClose(fileOutputStream);
                        C41131b.tryClose(createInputStream);
                        C41131b.m71559a(assetFileDescriptor);
                        AppMethodBeat.m2505o(4009);
                        return true;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                Log.m81046e("FileUtils", "copyFileFromDescriptorAndClose error: " + e.getMessage());
                C41131b.tryClose(fileOutputStream);
                C41131b.tryClose(createInputStream);
                C41131b.m71559a(assetFileDescriptor);
                AppMethodBeat.m2505o(4009);
                return false;
            }
        } catch (Exception e4) {
            e = e4;
            createInputStream = null;
            fileOutputStream = null;
            Log.m81046e("FileUtils", "copyFileFromDescriptorAndClose error: " + e.getMessage());
            C41131b.tryClose(fileOutputStream);
            C41131b.tryClose(createInputStream);
            C41131b.m71559a(assetFileDescriptor);
            AppMethodBeat.m2505o(4009);
            return false;
        } catch (Throwable th4) {
            th = th4;
            createInputStream = null;
            fileOutputStream = null;
            C41131b.tryClose(fileOutputStream);
            C41131b.tryClose(createInputStream);
            C41131b.m71559a(assetFileDescriptor);
            AppMethodBeat.m2505o(4009);
            throw th;
        }
    }

    /* renamed from: b */
    public static boolean m71561b(InputStream inputStream, File file) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(4010);
        if (inputStream == null) {
            Log.m81046e("FileUtils", "copyFileFromStreamAndClose wrong param");
            AppMethodBeat.m2505o(4010);
            return false;
        }
        Closeable closeable = null;
        try {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        C41131b.tryClose(fileOutputStream);
                        C41131b.tryClose(inputStream);
                        AppMethodBeat.m2505o(4010);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                closeable = fileOutputStream;
                try {
                    Log.m81046e("FileUtils", "copyFileFromStreamAndClose error: " + e.getMessage());
                    C41131b.tryClose(closeable);
                    C41131b.tryClose(inputStream);
                    AppMethodBeat.m2505o(4010);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    C41131b.tryClose(closeable);
                    C41131b.tryClose(inputStream);
                    AppMethodBeat.m2505o(4010);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                Object obj = fileOutputStream;
                C41131b.tryClose(closeable);
                C41131b.tryClose(inputStream);
                AppMethodBeat.m2505o(4010);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            Log.m81046e("FileUtils", "copyFileFromStreamAndClose error: " + e.getMessage());
            C41131b.tryClose(closeable);
            C41131b.tryClose(inputStream);
            AppMethodBeat.m2505o(4010);
            return false;
        }
    }
}
