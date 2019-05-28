package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bt.b;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.protocal.protobuf.ju;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.d;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class p {

    public static class a {
        public static byte[] e(byte[] bArr, String str) {
            int i;
            int i2;
            int i3;
            AppMethodBeat.i(d.MIC_PTU_ZIPAI_GRADIENT_FASHION);
            byte[] bytes = str.getBytes();
            byte[] bArr2 = new byte[256];
            for (i = 0; i < 256; i++) {
                bArr2[i] = (byte) i;
            }
            if (bytes == null || bytes.length == 0) {
                bArr2 = null;
            } else {
                i2 = 0;
                i3 = 0;
                for (i = 0; i < 256; i++) {
                    i2 = (i2 + ((bytes[i3] & 255) + (bArr2[i] & 255))) & 255;
                    byte b = bArr2[i];
                    bArr2[i] = bArr2[i2];
                    bArr2[i2] = b;
                    i3 = (i3 + 1) % bytes.length;
                }
            }
            bytes = new byte[bArr.length];
            if (bArr2 != null) {
                i = 0;
                i2 = 0;
                i3 = 0;
                while (i < bArr.length) {
                    i3 = (i3 + 1) & 255;
                    int i4 = ((bArr2[i3] & 255) + i2) & 255;
                    byte b2 = bArr2[i3];
                    bArr2[i3] = bArr2[i4];
                    bArr2[i4] = b2;
                    i2 = ((bArr2[i3] & 255) + (bArr2[i4] & 255)) & 255;
                    bytes[i] = (byte) (bArr2[i2] ^ bArr[i]);
                    i++;
                    i2 = i4;
                }
            }
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_FASHION);
            return bytes;
        }
    }

    public static String a(FaceResult faceResult) {
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE);
        if (faceResult == null || faceResult.result != 0) {
            ab.e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE);
            return null;
        }
        try {
            String bsS = bsS();
            ju juVar = new ju();
            juVar.vMj = b.bI(faceResult.sidedata);
            juVar.vMk = b.bI(faceResult.data);
            d(juVar.toByteArray(), bsS);
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE);
            return bsS;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FaceUtils", e, "", new Object[0]);
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE);
            return null;
        }
    }

    public static Bitmap Lr(String str) {
        Bitmap bitmap = null;
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
        try {
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
                AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
            } else {
                String str2 = com.tencent.mm.plugin.facedetect.model.a.a.lTy + ag.ck(str);
                if (new com.tencent.mm.vfs.b(str2).exists()) {
                    byte[] e = e.e(str2, 0, -1);
                    if (e != null) {
                        e = a.e(e, Ls(str));
                        if (e.length <= 0) {
                            ab.w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
                            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
                        } else {
                            bitmap = com.tencent.mm.compatible.g.a.decodeByteArray(e, 0, e.length);
                            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
                        }
                    } else {
                        ab.w("MicroMsg.FaceUtils", "hy: nothing in file");
                        AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
                    }
                } else {
                    ab.w("MicroMsg.FaceUtils", "hy: no last file. return");
                    AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
                }
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.FaceUtils", e2, "hy: err in encrypt", new Object[0]);
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
        }
        return bitmap;
    }

    public static boolean b(Bitmap bitmap, String str) {
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
        if (bitmap == null) {
            try {
                ab.w("MicroMsg.FaceUtils", "hy: bm is null. abort");
                AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
                return false;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in encrypt", new Object[0]);
                AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
                return false;
            }
        } else if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
            return false;
        } else {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.facedetect.model.a.a.lTy);
            if (!bVar.exists()) {
                bVar.mkdirs();
            }
            String str2 = com.tencent.mm.plugin.facedetect.model.a.a.lTy + ag.ck(str);
            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str2);
            if (!bVar2.exists()) {
                ab.i("MicroMsg.FaceUtils", "hy: last file already exists. del");
                bVar2.createNewFile();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (toByteArray != null) {
                byte[] e2 = a.e(toByteArray, Ls(str));
                if (e2.length <= 0) {
                    ab.w("MicroMsg.FaceUtils", "hy: enc err. return null");
                    AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
                    return false;
                }
                e.b(str2, e2, e2.length);
                AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
                return true;
            }
            ab.w("MicroMsg.FaceUtils", "hy: nothing in stream");
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
            return false;
        }
    }

    private static String Ls(String str) {
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI);
        String encodeToString = Base64.encodeToString((str + str.hashCode()).getBytes(), 0);
        AppMethodBeat.o(d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI);
        return encodeToString;
    }

    public static boolean M(Activity activity) {
        AppMethodBeat.i(269);
        boolean o = com.tencent.mm.pluginsdk.permission.b.o(activity, "android.permission.CAMERA");
        boolean o2 = com.tencent.mm.pluginsdk.permission.b.o(activity, "android.permission.RECORD_AUDIO");
        ab.d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", Boolean.valueOf(o), Boolean.valueOf(o2), bo.dpG(), activity);
        ArrayList arrayList = new ArrayList();
        if (!o) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!o2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (o && o2) {
            AppMethodBeat.o(269);
            return true;
        }
        ab.i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
        android.support.v4.app.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 23);
        AppMethodBeat.o(269);
        return false;
    }

    public static void N(Activity activity) {
        AppMethodBeat.i(270);
        activity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.o(270);
    }

    private static void bsM() {
        AppMethodBeat.i(271);
        ab.i("MicroMsg.FaceUtils", "hy: trigger start download model file");
        g.Rg().a(new m(42), 0);
        AppMethodBeat.o(271);
    }

    public static boolean bsN() {
        boolean z = false;
        AppMethodBeat.i(272);
        String bsP = bsP();
        String bsQ = bsQ();
        if (bo.isNullOrNil(bsP) || bo.isNullOrNil(bsQ)) {
            ab.w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
        } else {
            boolean z2;
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(bsP);
            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(bsQ);
            if (bVar.exists() || vn(0)) {
                z2 = true;
            } else {
                ab.e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
                z2 = false;
            }
            if (bVar2.exists() || vn(1)) {
                z = z2;
            } else {
                ab.e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
            }
        }
        if (!z) {
            bsM();
        }
        AppMethodBeat.o(272);
        return z;
    }

    public static String bsO() {
        String str;
        AppMethodBeat.i(273);
        if (a.lTw) {
            str = h.getExternalStorageDirectory().getAbsolutePath() + "/face_detect";
        } else {
            str = ah.getContext().getFilesDir().getParent() + "/face_detect";
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (!bVar.exists()) {
            ab.i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
            bVar.mkdirs();
        }
        AppMethodBeat.o(273);
        return str;
    }

    public static String bsP() {
        AppMethodBeat.i(274);
        String str = bsO() + "/ufdmtcc.bin";
        AppMethodBeat.o(274);
        return str;
    }

    public static String bsQ() {
        AppMethodBeat.i(d.MIC_GPU_AUTOLEVEL);
        String str = bsO() + "/ufat.bin";
        AppMethodBeat.o(d.MIC_GPU_AUTOLEVEL);
        return str;
    }

    public static String bsR() {
        AppMethodBeat.i(276);
        String str = bsO() + "/PE.dat";
        AppMethodBeat.o(276);
        return str;
    }

    public static String bsS() {
        AppMethodBeat.i(277);
        String str = bsO() + "/release_out.fd";
        AppMethodBeat.o(277);
        return str;
    }

    public static boolean vn(int i) {
        AppMethodBeat.i(d.MIC_PTU_TRANS_XINGYE);
        String str = "";
        switch (i) {
            case 0:
                str = av.fly.T("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
                break;
            case 1:
                str = av.fly.T("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
                break;
        }
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.FaceUtils", "hy: no such path for type: %d", Integer.valueOf(i));
            AppMethodBeat.o(d.MIC_PTU_TRANS_XINGYE);
            return false;
        } else if (new com.tencent.mm.vfs.b(str).exists()) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(vo(i));
            if (bVar.exists()) {
                bVar.delete();
            }
            e.y(str, vo(i));
            AppMethodBeat.o(d.MIC_PTU_TRANS_XINGYE);
            return true;
        } else {
            ab.e("MicroMsg.FaceUtils", "originFile file not exist");
            AppMethodBeat.o(d.MIC_PTU_TRANS_XINGYE);
            return false;
        }
    }

    public static String vo(int i) {
        AppMethodBeat.i(d.MIC_PTU_TRANS_ROUHE);
        String bsP;
        switch (i) {
            case 0:
                bsP = bsP();
                AppMethodBeat.o(d.MIC_PTU_TRANS_ROUHE);
                return bsP;
            case 1:
                bsP = bsQ();
                AppMethodBeat.o(d.MIC_PTU_TRANS_ROUHE);
                return bsP;
            default:
                bsP = "";
                AppMethodBeat.o(d.MIC_PTU_TRANS_ROUHE);
                return bsP;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d A:{SYNTHETIC, Splitter:B:35:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092 A:{Catch:{ Exception -> 0x0099 }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A:{SYNTHETIC, Splitter:B:16:0x0049} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A:{Catch:{ Exception -> 0x0083 }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d A:{SYNTHETIC, Splitter:B:35:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092 A:{Catch:{ Exception -> 0x0099 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void p(Context context, String str, String str2) {
        Throwable e;
        AppMethodBeat.i(d.MIC_PTU_TRANS_XINXIAN);
        ab.i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets src: %s, dst: %s", str, str2);
        InputStream open;
        OutputStream fVar;
        try {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str2);
            open = context.getAssets().open(str);
            try {
                fVar = new f(bVar);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fVar.write(bArr, 0, read);
                    }
                    fVar.flush();
                    ab.i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets %s successfully, file len: %d", str, Long.valueOf(bVar.length()));
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e2) {
                            AppMethodBeat.o(d.MIC_PTU_TRANS_XINXIAN);
                            return;
                        }
                    }
                    fVar.close();
                    AppMethodBeat.o(d.MIC_PTU_TRANS_XINXIAN);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                        if (open != null) {
                        }
                        if (fVar != null) {
                        }
                        AppMethodBeat.o(d.MIC_PTU_TRANS_XINXIAN);
                    } catch (Throwable th) {
                        e = th;
                        if (open != null) {
                        }
                        if (fVar != null) {
                        }
                        AppMethodBeat.o(d.MIC_PTU_TRANS_XINXIAN);
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                fVar = null;
                ab.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e5) {
                        AppMethodBeat.o(d.MIC_PTU_TRANS_XINXIAN);
                        return;
                    }
                }
                if (fVar != null) {
                    fVar.close();
                }
                AppMethodBeat.o(d.MIC_PTU_TRANS_XINXIAN);
            } catch (Throwable th2) {
                e = th2;
                fVar = null;
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e6) {
                        AppMethodBeat.o(d.MIC_PTU_TRANS_XINXIAN);
                        throw e;
                    }
                }
                if (fVar != null) {
                    fVar.close();
                }
                AppMethodBeat.o(d.MIC_PTU_TRANS_XINXIAN);
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            fVar = null;
            open = null;
        } catch (Throwable th3) {
            e = th3;
            fVar = null;
            open = null;
            if (open != null) {
            }
            if (fVar != null) {
            }
            AppMethodBeat.o(d.MIC_PTU_TRANS_XINXIAN);
            throw e;
        }
    }

    public static Bitmap n(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        AppMethodBeat.i(d.MIC_PTU_TRANS_KONGCHENG);
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            bitmap2 = null;
        } else {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            long currentTimeMillis2 = System.currentTimeMillis();
            bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * 0.1f), Math.round(((float) bitmap.getHeight()) * 0.1f), false);
            bitmap2 = bitmap2.copy(bitmap2.getConfig(), true);
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            int[] iArr = new int[(width * height)];
            ab.e("pix", width + " " + height + " " + iArr.length);
            bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
            int i16 = width - 1;
            int i17 = height - 1;
            int i18 = width * height;
            int[] iArr2 = new int[i18];
            int[] iArr3 = new int[i18];
            int[] iArr4 = new int[i18];
            int[] iArr5 = new int[Math.max(width, height)];
            int[] iArr6 = new int[246016];
            for (int i19 = 0; i19 < 246016; i19++) {
                iArr6[i19] = i19 / 961;
            }
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{61, 3});
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            while (i20 < height) {
                if (b.ik(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                int i23 = 0;
                for (i9 = -30; i9 <= 30; i9++) {
                    i10 = iArr[Math.min(i16, Math.max(i9, 0)) + i22];
                    int[] iArr8 = iArr7[i9 + 30];
                    iArr8[0] = (16711680 & i10) >> 16;
                    iArr8[1] = (65280 & i10) >> 8;
                    iArr8[2] = i10 & 255;
                    i10 = 31 - Math.abs(i9);
                    i7 += iArr8[0] * i10;
                    i8 += iArr8[1] * i10;
                    i23 += i10 * iArr8[2];
                    if (i9 > 0) {
                        i += iArr8[0];
                        i2 += iArr8[1];
                        i3 += iArr8[2];
                    } else {
                        i4 += iArr8[0];
                        i5 += iArr8[1];
                        i6 += iArr8[2];
                    }
                }
                int i24 = 30;
                if (b.ik(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                i10 = 0;
                i9 = i;
                i11 = i2;
                i12 = i3;
                i13 = i4;
                i14 = i5;
                i15 = i6;
                while (i10 < width) {
                    iArr2[i22] = iArr6[i7];
                    iArr3[i22] = iArr6[i8];
                    iArr4[i22] = iArr6[i23];
                    i = i7 - i13;
                    i2 = i8 - i14;
                    i3 = i23 - i15;
                    int[] iArr9 = iArr7[((i24 - 30) + 61) % 61];
                    i5 = i13 - iArr9[0];
                    i6 = i14 - iArr9[1];
                    i13 = i15 - iArr9[2];
                    if (i20 == 0) {
                        iArr5[i10] = Math.min((i10 + 30) + 1, i16);
                    }
                    i14 = iArr[iArr5[i10] + i21];
                    iArr9[0] = (16711680 & i14) >> 16;
                    iArr9[1] = (65280 & i14) >> 8;
                    iArr9[2] = i14 & 255;
                    i9 += iArr9[0];
                    i11 += iArr9[1];
                    i4 = iArr9[2] + i12;
                    i7 = i + i9;
                    i8 = i2 + i11;
                    i23 = i3 + i4;
                    i24 = (i24 + 1) % 61;
                    int[] iArr10 = iArr7[i24 % 61];
                    i15 = i13 + iArr10[2];
                    i22++;
                    i10++;
                    i9 -= iArr10[0];
                    i11 -= iArr10[1];
                    i12 = i4 - iArr10[2];
                    i13 = i5 + iArr10[0];
                    i14 = i6 + iArr10[1];
                }
                i20++;
                i21 += width;
            }
            for (i15 = 0; i15 < width; i15++) {
                i = width * -30;
                if (b.ik(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i10 = 0;
                i9 = 0;
                i11 = 0;
                i12 = 0;
                for (i14 = -30; i14 <= 30; i14++) {
                    i13 = Math.max(0, i) + i15;
                    int[] iArr11 = iArr7[i14 + 30];
                    iArr11[0] = iArr2[i13];
                    iArr11[1] = iArr3[i13];
                    iArr11[2] = iArr4[i13];
                    i8 = 31 - Math.abs(i14);
                    i9 += iArr2[i13] * i8;
                    i11 += iArr3[i13] * i8;
                    i12 += iArr4[i13] * i8;
                    if (i14 > 0) {
                        i2 += iArr11[0];
                        i3 += iArr11[1];
                        i4 += iArr11[2];
                    } else {
                        i5 += iArr11[0];
                        i6 += iArr11[1];
                        i10 += iArr11[2];
                    }
                    if (i14 < i17) {
                        i += width;
                    }
                }
                i7 = 30;
                if (b.ik(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                i13 = 0;
                i = i2;
                i14 = i15;
                while (i13 < height) {
                    iArr[i14] = (((WebView.NIGHT_MODE_COLOR & iArr[i14]) | (iArr6[i9] << 16)) | (iArr6[i11] << 8)) | iArr6[i12];
                    i2 = i9 - i5;
                    i11 -= i6;
                    i12 -= i10;
                    int[] iArr12 = iArr7[((i7 - 30) + 61) % 61];
                    i5 -= iArr12[0];
                    i6 -= iArr12[1];
                    i10 -= iArr12[2];
                    if (i15 == 0) {
                        iArr5[i13] = Math.min(i13 + 31, i17) * width;
                    }
                    i8 = iArr5[i13] + i15;
                    iArr12[0] = iArr2[i8];
                    iArr12[1] = iArr3[i8];
                    iArr12[2] = iArr4[i8];
                    i += iArr12[0];
                    i3 += iArr12[1];
                    i4 += iArr12[2];
                    i9 = i2 + i;
                    i11 += i3;
                    i12 += i4;
                    i7 = (i7 + 1) % 61;
                    int[] iArr13 = iArr7[i7];
                    i5 += iArr13[0];
                    i6 += iArr13[1];
                    i10 += iArr13[2];
                    i -= iArr13[0];
                    i4 -= iArr13[2];
                    i14 += width;
                    i13++;
                    i3 -= iArr13[1];
                }
            }
            ab.e("pix", width + " " + height + " " + i18);
            bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
        }
        ab.i("MicroMsg.FaceUtils", "hy: blur using %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        Object obj = 1;
        if (bitmap2 == null) {
            ab.w("MicroMsg.FaceUtils", "hy: null on blur. use default");
            obj = null;
            bitmap2 = Lr(str);
            if (bitmap2 == null) {
                bitmap2 = com.tencent.mm.sdk.platformtools.d.LV(R.drawable.b30);
            }
        }
        if (obj != null) {
            final String str2 = str;
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
                    long yz = bo.yz();
                    p.b(bitmap2, str2);
                    ab.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", Long.valueOf(bo.az(yz)));
                    AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
                }
            }, "FaceUtils_SaveFile");
        }
        AppMethodBeat.o(d.MIC_PTU_TRANS_KONGCHENG);
        return bitmap2;
    }

    public static String Lt(String str) {
        AppMethodBeat.i(d.MIC_PTU_BAIXI);
        String x = com.tencent.mm.a.g.x((bo.yz() + ", " + str).getBytes());
        AppMethodBeat.o(d.MIC_PTU_BAIXI);
        return x;
    }

    public static void d(byte[] bArr, String str) {
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE);
        try {
            e.b(str, bArr, bArr.length);
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in save debug jpeg", new Object[0]);
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE);
        }
    }
}
