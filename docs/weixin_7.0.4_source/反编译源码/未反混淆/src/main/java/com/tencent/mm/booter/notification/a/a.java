package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class a {
    public Bitmap eek;

    public static Bitmap a(Context context, Bitmap bitmap) {
        AppMethodBeat.i(16004);
        if (context == null || bitmap == null) {
            AppMethodBeat.o(16004);
            return null;
        } else if (VERSION.SDK_INT >= 11) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(17104902) - context.getResources().getDimensionPixelSize(R.dimen.a61);
            bitmap = d.a(d.a(bitmap, dimensionPixelSize, dimensionPixelSize, false, false), false, (float) context.getResources().getDimensionPixelSize(R.dimen.a60));
            AppMethodBeat.o(16004);
            return bitmap;
        } else {
            AppMethodBeat.o(16004);
            return bitmap;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0166 A:{SYNTHETIC, Splitter:B:41:0x0166} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x016b A:{Catch:{ Exception -> 0x018f }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0166 A:{SYNTHETIC, Splitter:B:41:0x0166} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x016b A:{Catch:{ Exception -> 0x018f }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0166 A:{SYNTHETIC, Splitter:B:41:0x0166} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x016b A:{Catch:{ Exception -> 0x018f }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0166 A:{SYNTHETIC, Splitter:B:41:0x0166} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x016b A:{Catch:{ Exception -> 0x018f }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0166 A:{SYNTHETIC, Splitter:B:41:0x0166} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x016b A:{Catch:{ Exception -> 0x018f }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap H(String str, String str2) {
        Exception e;
        OutOfMemoryError e2;
        AppMethodBeat.i(16005);
        if (ah.isNullOrNil(str)) {
            AppMethodBeat.o(16005);
            return null;
        }
        String str3 = j.b(str2, "user_", g.x(str.getBytes()), ".png", 1) + ".bm";
        boolean z = true;
        FileChannel fileChannel = null;
        FileInputStream fileInputStream;
        try {
            File file = new File(str3);
            if (file.exists()) {
                int length = (int) file.length();
                if (length <= 0 || !(length == 36864 || length == 36880)) {
                    ab.e("MicroMsg.NotificationAvatar", "SmallBM get bm invalid size:%d file:%s", Integer.valueOf(length), str3);
                    AppMethodBeat.o(16005);
                    return null;
                }
                fileInputStream = new FileInputStream(str3);
                try {
                    fileChannel = fileInputStream.getChannel();
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(36864);
                    fileChannel.read(allocateDirect);
                    allocateDirect.position(0);
                    if (length == 36880) {
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(16);
                        fileChannel.read(allocateDirect2);
                        if (allocateDirect2.getLong(0) != 1) {
                            ab.e("MicroMsg.NotificationAvatar", "SmallBM get bm header invalid flag:%d size:%d file:%s", Long.valueOf(allocateDirect2.getLong(0)), Integer.valueOf(length), str3);
                            fileChannel.close();
                            fileInputStream.close();
                            AppMethodBeat.o(16005);
                            return null;
                        }
                        z = false;
                    }
                    ab.d("MicroMsg.NotificationAvatar", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", Integer.valueOf(length), Boolean.valueOf(z), str3);
                    fileChannel.close();
                    try {
                        fileInputStream.close();
                        Bitmap createBitmap = Bitmap.createBitmap(96, 96, Config.ARGB_8888);
                        createBitmap.copyPixelsFromBuffer(allocateDirect);
                        if (z) {
                            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 9, 9, 78, 78);
                            ab.i("MicroMsg.NotificationAvatar", "recycle bitmap:%s", createBitmap.toString());
                            createBitmap.recycle();
                            AppMethodBeat.o(16005);
                            return createBitmap2;
                        }
                        AppMethodBeat.o(16005);
                        return createBitmap;
                    } catch (Exception e3) {
                        e = e3;
                        fileChannel = null;
                        ab.e("MicroMsg.NotificationAvatar", "SmallBM get exception e:%s file:%s", e.getMessage(), str3);
                        if (fileChannel != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(16005);
                        return null;
                    } catch (OutOfMemoryError e4) {
                        e2 = e4;
                        fileChannel = null;
                        ab.e("MicroMsg.NotificationAvatar", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str3);
                        if (fileChannel != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(16005);
                        return null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    ab.e("MicroMsg.NotificationAvatar", "SmallBM get exception e:%s file:%s", e.getMessage(), str3);
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (Exception e6) {
                            AppMethodBeat.o(16005);
                            return null;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    AppMethodBeat.o(16005);
                    return null;
                } catch (OutOfMemoryError e7) {
                    e2 = e7;
                    ab.e("MicroMsg.NotificationAvatar", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str3);
                    if (fileChannel != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(16005);
                    return null;
                }
            }
            ab.w("MicroMsg.NotificationAvatar", "SmallBM get bm file not exsit:%s", str3);
            AppMethodBeat.o(16005);
            return null;
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
            ab.e("MicroMsg.NotificationAvatar", "SmallBM get exception e:%s file:%s", e.getMessage(), str3);
            if (fileChannel != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(16005);
            return null;
        } catch (OutOfMemoryError e9) {
            e2 = e9;
            fileInputStream = null;
            ab.e("MicroMsg.NotificationAvatar", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str3);
            if (fileChannel != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(16005);
            return null;
        }
    }
}
