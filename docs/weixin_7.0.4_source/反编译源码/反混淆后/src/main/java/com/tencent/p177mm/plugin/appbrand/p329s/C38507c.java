package com.tencent.p177mm.plugin.appbrand.p329s;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.p1589e.p1590a.C41710a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.memory.C37899l;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.p215cf.C37632b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5061l;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wxmm.v2helper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.s.c */
public enum C38507c {
    ;

    @Deprecated
    /* renamed from: e */
    public static boolean m65173e(Options options) {
        AppMethodBeat.m2504i(73191);
        boolean e = C41710a.m73389e(options);
        AppMethodBeat.m2505o(73191);
        return e;
    }

    /* renamed from: a */
    private static boolean m65170a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        AppMethodBeat.m2504i(73192);
        Options amj = C5056d.amj(str);
        if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
            AppMethodBeat.m2505o(73192);
            return false;
        }
        boolean a = C38507c.m65169a(str, amj.outWidth, amj.outHeight, i, i2, compressFormat, i3, str2);
        AppMethodBeat.m2505o(73192);
        return a;
    }

    /* renamed from: b */
    private static Bitmap m65171b(String str, Options options) {
        AppMethodBeat.m2504i(73193);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C4990ab.m7411d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), C37899l.m63997Xf().mo60650a(str, options));
            AppMethodBeat.m2505o(73193);
            return r0;
        } catch (OutOfMemoryError e) {
            C37632b.dvU();
            C4990ab.m7412e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + e.getMessage());
            AppMethodBeat.m2505o(73193);
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m65169a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2) {
        AppMethodBeat.m2504i(73194);
        OutputStream outputStream = null;
        try {
            Bitmap b;
            C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
            Options options = new Options();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                b = C38507c.m65171b(str, options);
            } else {
                options.inSampleSize = 1;
                if (i2 > i3 || i > i4) {
                    options.inSampleSize = (int) (d < d2 ? d2 : d);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", Integer.valueOf(options.inSampleSize));
                b = C38507c.m65171b(str, options);
            }
            C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", b);
            if (b == null) {
                AppMethodBeat.m2505o(73194);
                return false;
            }
            int ceil;
            int i6;
            int i7;
            int i8;
            C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()));
            if (d < d2) {
                ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i));
                i6 = i4;
            } else {
                i6 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i)) / ((double) i2));
                ceil = i3;
            }
            int bJ = ExifHelper.m7368bJ(str);
            if (bJ == 90 || bJ == 270) {
                b = C5056d.m7648b(b, (float) bJ);
                i7 = ceil;
                i8 = i6;
            } else {
                i7 = i6;
                i8 = ceil;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i7, i8, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = b;
            } else if (b != createScaledBitmap) {
                C37899l.m63997Xf().mo60652v(b);
            }
            C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", Integer.valueOf(bJ), Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()));
            outputStream = FileOp.m64140pH(str2);
            C5056d.m7624a(createScaledBitmap, i5, compressFormat, outputStream, false);
            C37899l.m63997Xf().mo60652v(createScaledBitmap);
            outputStream.close();
            AppMethodBeat.m2505o(73194);
            return true;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandImgUtil", e, "create thumbnail from orig failed: %s", str2);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(73194);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068 A:{SYNTHETIC, Splitter:B:18:0x0068} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0103 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068 A:{SYNTHETIC, Splitter:B:18:0x0068} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0103 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: cU */
    public static boolean m65172cU(String str, String str2) {
        AppMethodBeat.m2504i(73195);
        int i = 70;
        int td = (int) FileOp.m64145td(str2);
        Options amj = C5056d.amj(str2);
        if (amj == null) {
            C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "compressImage, get null bitmap.option from path %s", str2);
            AppMethodBeat.m2505o(73195);
            return false;
        }
        boolean z;
        boolean e;
        int i2;
        int i3;
        int i4;
        InputStream inputStream;
        Bitmap decodeStream;
        if (amj != null) {
            String str3 = amj.outMimeType;
            C4990ab.m7410d("MicroMsg.AppBrandImgUtil", "mimetype: ".concat(String.valueOf(str3)));
            if (str3 != null) {
                str3 = str3.toLowerCase();
                if (str3.indexOf("jpg") >= 0) {
                    z = true;
                } else if (str3.indexOf("jpeg") >= 0) {
                    z = true;
                } else if (str3.indexOf("png") >= 0) {
                    z = true;
                }
                e = C41710a.m73389e(amj);
                i2 = -1;
                if (e) {
                    i2 = MMNativeJpeg.queryQuality(str2);
                    if (i2 < 70 && i2 > 25) {
                        i3 = i2;
                        i = i2;
                        i2 = 0;
                        if (e) {
                            try {
                                Exif fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i2 = fromFile.getOrientationInDegree() % v2helper.VOIP_ENC_HEIGHT_LV1;
                                    C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", Integer.valueOf(fromFile.getOrientationInDegree()));
                                }
                                i4 = i2;
                            } catch (Exception e2) {
                                C4990ab.m7412e("MicroMsg.AppBrandImgUtil", "get degree error " + e2.getMessage());
                            }
                            C4990ab.m7416i("MicroMsg.AppBrandImgUtil", "option info " + amj.outWidth + " " + amj.outHeight + " " + z + " origQuality: " + i3 + " degree:" + i4 + " filelen " + td + " target 960 640");
                            boolean z2;
                            if ((amj.outWidth < amj.outHeight * 2 || amj.outHeight >= amj.outWidth * 2) && amj.outWidth * amj.outHeight <= 10240000) {
                                if (td >= 204800 && z && i4 == 0) {
                                    C4990ab.m7416i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeLong 204800");
                                    if (FileOp.m64149y(str2, str) >= 0) {
                                        AppMethodBeat.m2505o(73195);
                                        return true;
                                    }
                                    AppMethodBeat.m2505o(73195);
                                    return false;
                                }
                                amj = new Options();
                                C5056d.dnX();
                                inputStream = null;
                                inputStream = FileOp.openRead(str2);
                                if (!inputStream.markSupported() && (inputStream instanceof FileInputStream)) {
                                    inputStream = new C5061l((FileInputStream) inputStream);
                                }
                                inputStream.mark(1048576);
                                decodeStream = MMBitmapFactory.decodeStream(inputStream, null, amj);
                                inputStream.reset();
                                if (decodeStream != null) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    AppMethodBeat.m2505o(73195);
                                    return false;
                                }
                                C5056d.m7625a(C5056d.m7648b(decodeStream, (float) i4), i, CompressFormat.JPEG, str, true);
                                if (z && i4 == 0) {
                                    C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", Integer.valueOf(td), Long.valueOf(FileOp.m64145td(str)), Integer.valueOf(10));
                                    if ((((long) td) - FileOp.m64145td(str)) * 100 < ((long) (td * 10))) {
                                        FileOp.deleteFile(str);
                                        z2 = FileOp.m64149y(str2, str) >= 0;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e4) {
                                            }
                                        }
                                        AppMethodBeat.m2505o(73195);
                                        return z2;
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    AppMethodBeat.m2505o(73195);
                                    return true;
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                AppMethodBeat.m2505o(73195);
                                return true;
                            } else if (td < 102400 && z && i4 == 0) {
                                C4990ab.m7416i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeNormal 102400");
                                if (FileOp.m64149y(str2, str) >= 0) {
                                    AppMethodBeat.m2505o(73195);
                                    return true;
                                }
                                AppMethodBeat.m2505o(73195);
                                return false;
                            } else if ((amj.outWidth > VideoFilterUtil.IMAGE_HEIGHT || amj.outHeight > 640) && (amj.outHeight > VideoFilterUtil.IMAGE_HEIGHT || amj.outWidth > 640)) {
                                i2 = amj.outWidth >= amj.outHeight ? VideoFilterUtil.IMAGE_HEIGHT : 640;
                                int i5 = amj.outWidth >= amj.outHeight ? 640 : VideoFilterUtil.IMAGE_HEIGHT;
                                if (amj.outWidth >= amj.outHeight * 2 || amj.outHeight >= amj.outWidth * 2) {
                                    int i6;
                                    C4990ab.m7416i("MicroMsg.AppBrandImgUtil", "too max pic " + amj.outWidth + " " + amj.outHeight);
                                    if (amj.outHeight <= 0) {
                                        amj.outHeight = 1;
                                    }
                                    if (amj.outWidth <= 0) {
                                        amj.outWidth = 1;
                                    }
                                    if (amj.outWidth > amj.outHeight) {
                                        i2 = amj.outWidth / amj.outHeight;
                                    } else {
                                        i2 = amj.outHeight / amj.outWidth;
                                    }
                                    if (i2 == 0) {
                                        i2 = 1;
                                    }
                                    i3 = (int) Math.sqrt((double) (10240000 / i2));
                                    if (amj.outWidth > amj.outHeight) {
                                        i6 = i3 * i2;
                                        i5 = i3;
                                    } else {
                                        i5 = i3 * i2;
                                        i6 = i3;
                                    }
                                    C4990ab.m7416i("MicroMsg.AppBrandImgUtil", "new width height " + i6 + " " + i5 + " " + i2);
                                    i3 = i6;
                                } else {
                                    i3 = i2;
                                }
                                z2 = C38507c.m65170a(str2, i5, i3, CompressFormat.JPEG, i, str);
                                if (z && i4 == 0) {
                                    C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", Integer.valueOf(td), Long.valueOf(FileOp.m64145td(str)), Integer.valueOf(10));
                                    if ((((long) td) - FileOp.m64145td(str)) * 100 < ((long) (td * 10))) {
                                        FileOp.deleteFile(str);
                                        if (FileOp.m64149y(str2, str) >= 0) {
                                            AppMethodBeat.m2505o(73195);
                                            return true;
                                        }
                                        AppMethodBeat.m2505o(73195);
                                        return false;
                                    }
                                }
                                AppMethodBeat.m2505o(73195);
                                return z2;
                            } else {
                                C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "hello ieg this is little img  %d w: %d h: %d", Integer.valueOf(td), Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                                if (FileOp.m64145td(str2) < 71680) {
                                    if (z) {
                                        C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "isSysSupportedPic %s", str2);
                                        if (FileOp.m64149y(str2, str) >= 0) {
                                            AppMethodBeat.m2505o(73195);
                                            return true;
                                        }
                                        AppMethodBeat.m2505o(73195);
                                        return false;
                                    } else if (amj.outWidth < 150 && amj.outHeight < 150) {
                                        z2 = C38507c.m65170a(str2, amj.outHeight, amj.outWidth, CompressFormat.PNG, i, str);
                                        AppMethodBeat.m2505o(73195);
                                        return z2;
                                    }
                                }
                                z2 = C38507c.m65170a(str2, amj.outHeight, amj.outWidth, CompressFormat.JPEG, i, str);
                                if (z && i4 == 0) {
                                    C4990ab.m7417i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", Integer.valueOf(td), Long.valueOf(FileOp.m64145td(str)), Integer.valueOf(10));
                                    if ((((long) td) - FileOp.m64145td(str)) * 100 < ((long) (td * 10))) {
                                        FileOp.deleteFile(str);
                                        if (FileOp.m64149y(str2, str) >= 0) {
                                            AppMethodBeat.m2505o(73195);
                                            return true;
                                        }
                                        AppMethodBeat.m2505o(73195);
                                        return false;
                                    }
                                    AppMethodBeat.m2505o(73195);
                                    return z2;
                                }
                                AppMethodBeat.m2505o(73195);
                                return z2;
                            }
                        }
                        i4 = 0;
                        C4990ab.m7416i("MicroMsg.AppBrandImgUtil", "option info " + amj.outWidth + " " + amj.outHeight + " " + z + " origQuality: " + i3 + " degree:" + i4 + " filelen " + td + " target 960 640");
                        if (amj.outWidth < amj.outHeight * 2) {
                        }
                        if (td >= 204800) {
                        }
                        amj = new Options();
                        C5056d.dnX();
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        inputStream = new C5061l((FileInputStream) inputStream);
                        inputStream.mark(1048576);
                        decodeStream = MMBitmapFactory.decodeStream(inputStream, null, amj);
                        inputStream.reset();
                        if (decodeStream != null) {
                        }
                    }
                }
                i3 = i2;
                i2 = 0;
                if (e) {
                }
                i4 = 0;
                C4990ab.m7416i("MicroMsg.AppBrandImgUtil", "option info " + amj.outWidth + " " + amj.outHeight + " " + z + " origQuality: " + i3 + " degree:" + i4 + " filelen " + td + " target 960 640");
                if (amj.outWidth < amj.outHeight * 2) {
                }
                if (td >= 204800) {
                }
                amj = new Options();
                C5056d.dnX();
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                inputStream = new C5061l((FileInputStream) inputStream);
                inputStream.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(inputStream, null, amj);
                inputStream.reset();
                if (decodeStream != null) {
                }
            }
        }
        z = false;
        e = C41710a.m73389e(amj);
        i2 = -1;
        if (e) {
        }
        i3 = i2;
        i2 = 0;
        if (e) {
        }
        i4 = 0;
        C4990ab.m7416i("MicroMsg.AppBrandImgUtil", "option info " + amj.outWidth + " " + amj.outHeight + " " + z + " origQuality: " + i3 + " degree:" + i4 + " filelen " + td + " target 960 640");
        if (amj.outWidth < amj.outHeight * 2) {
        }
        if (td >= 204800) {
        }
        amj = new Options();
        C5056d.dnX();
        inputStream = null;
        try {
            inputStream = FileOp.openRead(str2);
            inputStream = new C5061l((FileInputStream) inputStream);
            inputStream.mark(1048576);
            decodeStream = MMBitmapFactory.decodeStream(inputStream, null, amj);
            inputStream.reset();
            if (decodeStream != null) {
            }
        } catch (IOException e7) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandImgUtil", e7, "Decode bitmap failed: ".concat(String.valueOf(str2)), new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
            AppMethodBeat.m2505o(73195);
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                }
            }
            AppMethodBeat.m2505o(73195);
        }
    }
}
