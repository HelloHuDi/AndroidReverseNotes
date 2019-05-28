package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.ttpic.util.VideoFilterUtil;

public final class k {
    private static int fgJ = 0;
    private static final int mOo;
    private static final int mOp;

    static {
        int i = VideoFilterUtil.IMAGE_HEIGHT;
        AppMethodBeat.i(21317);
        r2 = new int[2];
        Display defaultDisplay = ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay();
        r2[0] = defaultDisplay.getWidth();
        r2[1] = defaultDisplay.getHeight();
        mOo = r2[0] > 960 ? r2[0] : VideoFilterUtil.IMAGE_HEIGHT;
        if (r2[1] > VideoFilterUtil.IMAGE_HEIGHT) {
            i = r2[1];
        }
        mOp = i;
        AppMethodBeat.o(21317);
    }

    public static Bitmap a(long j, int i, String str, String str2) {
        Bitmap bitmap = null;
        AppMethodBeat.i(21311);
        if (e.bBZ() == null) {
            AppMethodBeat.o(21311);
        } else {
            switch (i) {
                case 1:
                    bitmap = g(str, str2, j);
                    if (bitmap == null) {
                        ab.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", str, str2);
                        break;
                    }
                    break;
                case 2:
                    bitmap = n(j, str2);
                    if (bitmap == null) {
                        bitmap = g(str, str2, j);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(21311);
        }
        return bitmap;
    }

    private static int bCs() {
        AppMethodBeat.i(21312);
        int i;
        if (fgJ > 0) {
            i = fgJ;
            AppMethodBeat.o(21312);
            return i;
        }
        i = b.b(ah.getContext(), 150.0f);
        fgJ = i;
        AppMethodBeat.o(21312);
        return i;
    }

    private static Bitmap g(String str, String str2, long j) {
        AppMethodBeat.i(138610);
        Bitmap ew = ew(str, str2);
        if (ew == null) {
            boolean z;
            long uptimeMillis = SystemClock.uptimeMillis();
            Bitmap h = h(str, str2, j);
            String str3 = "MicroMsg.MediaManager";
            String str4 = "null == bitmap by getImageThumbFromFile! use media system decode bitmap is null?%s cost:%s";
            Object[] objArr = new Object[2];
            if (h == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
            ab.w(str3, str4, objArr);
            ew = h;
        }
        AppMethodBeat.o(138610);
        return ew;
    }

    private static Bitmap h(String str, String str2, long j) {
        Bitmap bitmap = null;
        AppMethodBeat.i(138611);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MediaManager", "filePath is null or nill");
            AppMethodBeat.o(138611);
            return null;
        }
        try {
            int i;
            long currentTimeMillis = System.currentTimeMillis();
            bitmap = Thumbnails.getThumbnail(ah.getContext().getContentResolver(), j, 1, null);
            String str3 = "MicroMsg.MediaManager";
            String str4 = "getImageThumb[%s]FromContentResolver type[%s], bmp size[%d, %d]: total time:[%dms]";
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = "MINI_KIND";
            objArr[2] = Integer.valueOf(bitmap == null ? 0 : bitmap.getWidth());
            if (bitmap == null) {
                i = 0;
            } else {
                i = bitmap.getHeight();
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            ab.v(str3, str4, objArr);
        } catch (Exception e) {
            ab.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s]", e.toString());
            ab.printErrStackTrace("MicroMsg.MediaManager", e, "", new Object[0]);
        }
        bitmap = o(str2, bitmap);
        AppMethodBeat.o(138611);
        return bitmap;
    }

    private static Bitmap ew(String str, String str2) {
        int i = 0;
        AppMethodBeat.i(21313);
        ab.d("MicroMsg.MediaManager", "current thread %s", Thread.currentThread().getName());
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MediaManager", "filePath is null or nill");
            AppMethodBeat.o(21313);
            return null;
        }
        int i2;
        Bitmap bitmap;
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap d = d.d(str, bCs(), bCs(), false);
        String str3 = "MicroMsg.MediaManager";
        String str4 = "getImageThumb[%s]FromThumbFilePath, bmp size[%d, %d]: total time:[%dms]";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        if (d == null) {
            i2 = 0;
        } else {
            i2 = d.getWidth();
        }
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(d == null ? 0 : d.getHeight());
        objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        ab.v(str3, str4, objArr);
        if (d == null) {
            ab.w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", str2);
            if (bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", str2);
            } else {
                currentTimeMillis = System.currentTimeMillis();
                d = d.d(str2, bCs(), bCs(), false);
                str3 = "MicroMsg.MediaManager";
                str4 = "getImageThumb[%s]FromOrigFilePath[%s], bmp size[%d, %d]:total time:[%dms]";
                objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                if (d == null) {
                    i2 = 0;
                } else {
                    i2 = d.getWidth();
                }
                objArr[2] = Integer.valueOf(i2);
                if (d != null) {
                    i = d.getHeight();
                }
                objArr[3] = Integer.valueOf(i);
                objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                ab.v(str3, str4, objArr);
                bitmap = d;
                bitmap = o(str2, bitmap);
                AppMethodBeat.o(21313);
                return bitmap;
            }
        }
        bitmap = d;
        bitmap = o(str2, bitmap);
        AppMethodBeat.o(21313);
        return bitmap;
    }

    private static Bitmap o(String str, Bitmap bitmap) {
        AppMethodBeat.i(21314);
        if (bitmap != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap b = d.b(bitmap, (float) ExifHelper.bJ(str));
            ab.d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(r1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (b != null) {
                AppMethodBeat.o(21314);
                return b;
            }
        }
        AppMethodBeat.o(21314);
        return null;
    }

    public static Bitmap NC(String str) {
        Object obj = 1;
        AppMethodBeat.i(21315);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MediaManager", "filepath is null or nil");
            AppMethodBeat.o(21315);
            return null;
        }
        try {
            if (e.ct(str)) {
                int i = mOo;
                int i2 = mOp;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    ab.i("MicroMsg.MediaManager", "bitmap recycle %s", decodeFile.toString());
                    decodeFile.recycle();
                }
                if (options.outWidth <= 0 || options.outHeight <= 0) {
                    ab.d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = ".concat(String.valueOf(str)));
                    AppMethodBeat.o(21315);
                    return null;
                }
                int i3;
                int i4;
                Object obj2 = (!ad.cJ(options.outWidth, options.outHeight) || options.outWidth <= 480) ? null : 1;
                if (!ad.cI(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                    obj = null;
                }
                if (!(obj2 == null && obj == null)) {
                    i2 = options.outHeight;
                    i = options.outWidth;
                }
                int bJ = ExifHelper.bJ(str);
                if (bJ == 90 || bJ == 270) {
                    i3 = i;
                    i4 = i2;
                } else {
                    i3 = i2;
                    i4 = i;
                }
                Bitmap d = d.d(str, i3, i4, false);
                if (d == null) {
                    ab.e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
                    AppMethodBeat.o(21315);
                    return null;
                }
                d = d.b(d, (float) bJ);
                ab.i("MicroMsg.MediaManager", "bmp height = " + d.getHeight() + ",bmp width = " + d.getWidth());
                AppMethodBeat.o(21315);
                return d;
            }
            ab.e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = ".concat(String.valueOf(str)));
            AppMethodBeat.o(21315);
            return null;
        } catch (Exception e) {
            ab.e("MicroMsg.MediaManager", "decode bitmap err: " + e.getMessage());
            AppMethodBeat.o(21315);
            return null;
        }
    }

    @TargetApi(8)
    private static Bitmap n(long j, String str) {
        Bitmap thumbnail;
        AppMethodBeat.i(21316);
        try {
            thumbnail = Video.Thumbnails.getThumbnail(ah.getContext().getContentResolver(), j, 1, null);
        } catch (Exception e) {
            ab.e("MicroMsg.MediaManager", "exception: %s", bo.l(e));
            thumbnail = null;
        }
        if (thumbnail == null) {
            ab.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", Long.valueOf(j), str);
            if (VERSION.SDK_INT >= 8) {
                thumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            }
            if (thumbnail == null && !bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", Long.valueOf(j), str);
                ah.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://".concat(String.valueOf(str)))));
            }
        }
        AppMethodBeat.o(21316);
        return thumbnail;
    }
}
