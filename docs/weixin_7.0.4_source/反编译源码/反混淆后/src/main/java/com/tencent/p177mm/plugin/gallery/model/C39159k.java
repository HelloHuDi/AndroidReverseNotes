package com.tencent.p177mm.plugin.gallery.model;

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
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C35985ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.util.VideoFilterUtil;

/* renamed from: com.tencent.mm.plugin.gallery.model.k */
public final class C39159k {
    private static int fgJ = 0;
    private static final int mOo;
    private static final int mOp;

    static {
        int i = VideoFilterUtil.IMAGE_HEIGHT;
        AppMethodBeat.m2504i(21317);
        r2 = new int[2];
        Display defaultDisplay = ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay();
        r2[0] = defaultDisplay.getWidth();
        r2[1] = defaultDisplay.getHeight();
        mOo = r2[0] > 960 ? r2[0] : VideoFilterUtil.IMAGE_HEIGHT;
        if (r2[1] > VideoFilterUtil.IMAGE_HEIGHT) {
            i = r2[1];
        }
        mOp = i;
        AppMethodBeat.m2505o(21317);
    }

    /* renamed from: a */
    public static Bitmap m66637a(long j, int i, String str, String str2) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(21311);
        if (C34237e.bBZ() == null) {
            AppMethodBeat.m2505o(21311);
        } else {
            switch (i) {
                case 1:
                    bitmap = C39159k.m66639g(str, str2, j);
                    if (bitmap == null) {
                        C4990ab.m7413e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", str, str2);
                        break;
                    }
                    break;
                case 2:
                    bitmap = C39159k.m66641n(j, str2);
                    if (bitmap == null) {
                        bitmap = C39159k.m66639g(str, str2, j);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(21311);
        }
        return bitmap;
    }

    private static int bCs() {
        AppMethodBeat.m2504i(21312);
        int i;
        if (fgJ > 0) {
            i = fgJ;
            AppMethodBeat.m2505o(21312);
            return i;
        }
        i = C4977b.m7371b(C4996ah.getContext(), 150.0f);
        fgJ = i;
        AppMethodBeat.m2505o(21312);
        return i;
    }

    /* renamed from: g */
    private static Bitmap m66639g(String str, String str2, long j) {
        AppMethodBeat.m2504i(138610);
        Bitmap ew = C39159k.m66638ew(str, str2);
        if (ew == null) {
            boolean z;
            long uptimeMillis = SystemClock.uptimeMillis();
            Bitmap h = C39159k.m66640h(str, str2, j);
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
            C4990ab.m7421w(str3, str4, objArr);
            ew = h;
        }
        AppMethodBeat.m2505o(138610);
        return ew;
    }

    /* renamed from: h */
    private static Bitmap m66640h(String str, String str2, long j) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(138611);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.MediaManager", "filePath is null or nill");
            AppMethodBeat.m2505o(138611);
            return null;
        }
        try {
            int i;
            long currentTimeMillis = System.currentTimeMillis();
            bitmap = Thumbnails.getThumbnail(C4996ah.getContext().getContentResolver(), j, 1, null);
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
            C4990ab.m7419v(str3, str4, objArr);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s]", e.toString());
            C4990ab.printErrStackTrace("MicroMsg.MediaManager", e, "", new Object[0]);
        }
        bitmap = C39159k.m66642o(str2, bitmap);
        AppMethodBeat.m2505o(138611);
        return bitmap;
    }

    /* renamed from: ew */
    private static Bitmap m66638ew(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(21313);
        C4990ab.m7411d("MicroMsg.MediaManager", "current thread %s", Thread.currentThread().getName());
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.MediaManager", "filePath is null or nill");
            AppMethodBeat.m2505o(21313);
            return null;
        }
        int i2;
        Bitmap bitmap;
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap d = C5056d.m7659d(str, C39159k.bCs(), C39159k.bCs(), false);
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
        C4990ab.m7419v(str3, str4, objArr);
        if (d == null) {
            C4990ab.m7421w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", str2);
            if (C5046bo.isNullOrNil(str2)) {
                C4990ab.m7413e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", str2);
            } else {
                currentTimeMillis = System.currentTimeMillis();
                d = C5056d.m7659d(str2, C39159k.bCs(), C39159k.bCs(), false);
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
                C4990ab.m7419v(str3, str4, objArr);
                bitmap = d;
                bitmap = C39159k.m66642o(str2, bitmap);
                AppMethodBeat.m2505o(21313);
                return bitmap;
            }
        }
        bitmap = d;
        bitmap = C39159k.m66642o(str2, bitmap);
        AppMethodBeat.m2505o(21313);
        return bitmap;
    }

    /* renamed from: o */
    private static Bitmap m66642o(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(21314);
        if (bitmap != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap b = C5056d.m7648b(bitmap, (float) ExifHelper.m7368bJ(str));
            C4990ab.m7411d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(r1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (b != null) {
                AppMethodBeat.m2505o(21314);
                return b;
            }
        }
        AppMethodBeat.m2505o(21314);
        return null;
    }

    /* renamed from: NC */
    public static Bitmap m66636NC(String str) {
        Object obj = 1;
        AppMethodBeat.m2504i(21315);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.MediaManager", "filepath is null or nil");
            AppMethodBeat.m2505o(21315);
            return null;
        }
        try {
            if (C1173e.m2561ct(str)) {
                int i = mOo;
                int i2 = mOp;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    C4990ab.m7417i("MicroMsg.MediaManager", "bitmap recycle %s", decodeFile.toString());
                    decodeFile.recycle();
                }
                if (options.outWidth <= 0 || options.outHeight <= 0) {
                    C4990ab.m7410d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(21315);
                    return null;
                }
                int i3;
                int i4;
                Object obj2 = (!C35985ad.m59194cJ(options.outWidth, options.outHeight) || options.outWidth <= 480) ? null : 1;
                if (!C35985ad.m59193cI(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                    obj = null;
                }
                if (!(obj2 == null && obj == null)) {
                    i2 = options.outHeight;
                    i = options.outWidth;
                }
                int bJ = ExifHelper.m7368bJ(str);
                if (bJ == 90 || bJ == 270) {
                    i3 = i;
                    i4 = i2;
                } else {
                    i3 = i2;
                    i4 = i;
                }
                Bitmap d = C5056d.m7659d(str, i3, i4, false);
                if (d == null) {
                    C4990ab.m7412e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(21315);
                    return null;
                }
                d = C5056d.m7648b(d, (float) bJ);
                C4990ab.m7416i("MicroMsg.MediaManager", "bmp height = " + d.getHeight() + ",bmp width = " + d.getWidth());
                AppMethodBeat.m2505o(21315);
                return d;
            }
            C4990ab.m7412e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(21315);
            return null;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MediaManager", "decode bitmap err: " + e.getMessage());
            AppMethodBeat.m2505o(21315);
            return null;
        }
    }

    @TargetApi(8)
    /* renamed from: n */
    private static Bitmap m66641n(long j, String str) {
        Bitmap thumbnail;
        AppMethodBeat.m2504i(21316);
        try {
            thumbnail = Video.Thumbnails.getThumbnail(C4996ah.getContext().getContentResolver(), j, 1, null);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MediaManager", "exception: %s", C5046bo.m7574l(e));
            thumbnail = null;
        }
        if (thumbnail == null) {
            C4990ab.m7413e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", Long.valueOf(j), str);
            if (VERSION.SDK_INT >= 8) {
                thumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            }
            if (thumbnail == null && !C5046bo.isNullOrNil(str)) {
                C4990ab.m7413e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", Long.valueOf(j), str);
                C4996ah.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://".concat(String.valueOf(str)))));
            }
        }
        AppMethodBeat.m2505o(21316);
        return thumbnail;
    }
}
