package com.tencent.p177mm.booter.notification.p841a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* renamed from: com.tencent.mm.booter.notification.a.a */
public final class C37621a {
    public Bitmap eek;

    /* renamed from: a */
    public static Bitmap m63515a(Context context, Bitmap bitmap) {
        AppMethodBeat.m2504i(16004);
        if (context == null || bitmap == null) {
            AppMethodBeat.m2505o(16004);
            return null;
        } else if (VERSION.SDK_INT >= 11) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(17104902) - context.getResources().getDimensionPixelSize(C25738R.dimen.a61);
            bitmap = C5056d.m7616a(C5056d.m7615a(bitmap, dimensionPixelSize, dimensionPixelSize, false, false), false, (float) context.getResources().getDimensionPixelSize(C25738R.dimen.a60));
            AppMethodBeat.m2505o(16004);
            return bitmap;
        } else {
            AppMethodBeat.m2505o(16004);
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
    /* renamed from: H */
    public static Bitmap m63514H(String str, String str2) {
        Exception e;
        OutOfMemoryError e2;
        AppMethodBeat.m2504i(16005);
        if (C42252ah.isNullOrNil(str)) {
            AppMethodBeat.m2505o(16005);
            return null;
        }
        String str3 = C15428j.m23709b(str2, "user_", C1178g.m2591x(str.getBytes()), ".png", 1) + ".bm";
        boolean z = true;
        FileChannel fileChannel = null;
        FileInputStream fileInputStream;
        try {
            File file = new File(str3);
            if (file.exists()) {
                int length = (int) file.length();
                if (length <= 0 || !(length == 36864 || length == 36880)) {
                    C4990ab.m7413e("MicroMsg.NotificationAvatar", "SmallBM get bm invalid size:%d file:%s", Integer.valueOf(length), str3);
                    AppMethodBeat.m2505o(16005);
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
                            C4990ab.m7413e("MicroMsg.NotificationAvatar", "SmallBM get bm header invalid flag:%d size:%d file:%s", Long.valueOf(allocateDirect2.getLong(0)), Integer.valueOf(length), str3);
                            fileChannel.close();
                            fileInputStream.close();
                            AppMethodBeat.m2505o(16005);
                            return null;
                        }
                        z = false;
                    }
                    C4990ab.m7411d("MicroMsg.NotificationAvatar", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", Integer.valueOf(length), Boolean.valueOf(z), str3);
                    fileChannel.close();
                    try {
                        fileInputStream.close();
                        Bitmap createBitmap = Bitmap.createBitmap(96, 96, Config.ARGB_8888);
                        createBitmap.copyPixelsFromBuffer(allocateDirect);
                        if (z) {
                            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 9, 9, 78, 78);
                            C4990ab.m7417i("MicroMsg.NotificationAvatar", "recycle bitmap:%s", createBitmap.toString());
                            createBitmap.recycle();
                            AppMethodBeat.m2505o(16005);
                            return createBitmap2;
                        }
                        AppMethodBeat.m2505o(16005);
                        return createBitmap;
                    } catch (Exception e3) {
                        e = e3;
                        fileChannel = null;
                        C4990ab.m7413e("MicroMsg.NotificationAvatar", "SmallBM get exception e:%s file:%s", e.getMessage(), str3);
                        if (fileChannel != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(16005);
                        return null;
                    } catch (OutOfMemoryError e4) {
                        e2 = e4;
                        fileChannel = null;
                        C4990ab.m7413e("MicroMsg.NotificationAvatar", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str3);
                        if (fileChannel != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(16005);
                        return null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    C4990ab.m7413e("MicroMsg.NotificationAvatar", "SmallBM get exception e:%s file:%s", e.getMessage(), str3);
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (Exception e6) {
                            AppMethodBeat.m2505o(16005);
                            return null;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    AppMethodBeat.m2505o(16005);
                    return null;
                } catch (OutOfMemoryError e7) {
                    e2 = e7;
                    C4990ab.m7413e("MicroMsg.NotificationAvatar", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str3);
                    if (fileChannel != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(16005);
                    return null;
                }
            }
            C4990ab.m7421w("MicroMsg.NotificationAvatar", "SmallBM get bm file not exsit:%s", str3);
            AppMethodBeat.m2505o(16005);
            return null;
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
            C4990ab.m7413e("MicroMsg.NotificationAvatar", "SmallBM get exception e:%s file:%s", e.getMessage(), str3);
            if (fileChannel != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(16005);
            return null;
        } catch (OutOfMemoryError e9) {
            e2 = e9;
            fileInputStream = null;
            C4990ab.m7413e("MicroMsg.NotificationAvatar", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str3);
            if (fileChannel != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(16005);
            return null;
        }
    }
}
