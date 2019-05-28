package com.tencent.p177mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.support.p057v4.app.C6184a;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.p177mm.plugin.facedetect.model.C34096a.C11809a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C44796m;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.C7268ju;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5731f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.C31128d;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.facedetect.model.p */
public final class C43036p {

    /* renamed from: com.tencent.mm.plugin.facedetect.model.p$a */
    public static class C34098a {
        /* renamed from: e */
        public static byte[] m55893e(byte[] bArr, String str) {
            int i;
            int i2;
            int i3;
            AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION);
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
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION);
            return bytes;
        }
    }

    /* renamed from: a */
    public static String m76430a(FaceResult faceResult) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE);
        if (faceResult == null || faceResult.result != 0) {
            C4990ab.m7412e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE);
            return null;
        }
        try {
            String bsS = C43036p.bsS();
            C7268ju c7268ju = new C7268ju();
            c7268ju.vMj = C1332b.m2847bI(faceResult.sidedata);
            c7268ju.vMk = C1332b.m2847bI(faceResult.data);
            C43036p.m76432d(c7268ju.toByteArray(), bsS);
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE);
            return bsS;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FaceUtils", e, "", new Object[0]);
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE);
            return null;
        }
    }

    /* renamed from: Lr */
    public static Bitmap m76425Lr(String str) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
        try {
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
                AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
            } else {
                String str2 = C11809a.lTy + C4995ag.m7428ck(str);
                if (new C5728b(str2).exists()) {
                    byte[] e = C5730e.m8632e(str2, 0, -1);
                    if (e != null) {
                        e = C34098a.m55893e(e, C43036p.m76426Ls(str));
                        if (e.length <= 0) {
                            C4990ab.m7420w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
                            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
                        } else {
                            bitmap = C1434a.decodeByteArray(e, 0, e.length);
                            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
                        }
                    } else {
                        C4990ab.m7420w("MicroMsg.FaceUtils", "hy: nothing in file");
                        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.FaceUtils", "hy: no last file. return");
                    AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
                }
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.FaceUtils", e2, "hy: err in encrypt", new Object[0]);
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY);
        }
        return bitmap;
    }

    /* renamed from: b */
    public static boolean m76431b(Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
        if (bitmap == null) {
            try {
                C4990ab.m7420w("MicroMsg.FaceUtils", "hy: bm is null. abort");
                AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
                return false;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in encrypt", new Object[0]);
                AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
                return false;
            }
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
            return false;
        } else {
            C5728b c5728b = new C5728b(C11809a.lTy);
            if (!c5728b.exists()) {
                c5728b.mkdirs();
            }
            String str2 = C11809a.lTy + C4995ag.m7428ck(str);
            C5728b c5728b2 = new C5728b(str2);
            if (!c5728b2.exists()) {
                C4990ab.m7416i("MicroMsg.FaceUtils", "hy: last file already exists. del");
                c5728b2.createNewFile();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (toByteArray != null) {
                byte[] e2 = C34098a.m55893e(toByteArray, C43036p.m76426Ls(str));
                if (e2.length <= 0) {
                    C4990ab.m7420w("MicroMsg.FaceUtils", "hy: enc err. return null");
                    AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
                    return false;
                }
                C5730e.m8624b(str2, e2, e2.length);
                AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
                return true;
            }
            C4990ab.m7420w("MicroMsg.FaceUtils", "hy: nothing in stream");
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW);
            return false;
        }
    }

    /* renamed from: Ls */
    private static String m76426Ls(String str) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI);
        String encodeToString = Base64.encodeToString((str + str.hashCode()).getBytes(), 0);
        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI);
        return encodeToString;
    }

    /* renamed from: M */
    public static boolean m76428M(Activity activity) {
        AppMethodBeat.m2504i(269);
        boolean o = C35805b.m58714o(activity, "android.permission.CAMERA");
        boolean o2 = C35805b.m58714o(activity, "android.permission.RECORD_AUDIO");
        C4990ab.m7411d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", Boolean.valueOf(o), Boolean.valueOf(o2), C5046bo.dpG(), activity);
        ArrayList arrayList = new ArrayList();
        if (!o) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!o2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (o && o2) {
            AppMethodBeat.m2505o(269);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
        C6184a.m9880a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 23);
        AppMethodBeat.m2505o(269);
        return false;
    }

    /* renamed from: N */
    public static void m76429N(Activity activity) {
        AppMethodBeat.m2504i(270);
        activity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.m2505o(270);
    }

    private static void bsM() {
        AppMethodBeat.m2504i(271);
        C4990ab.m7416i("MicroMsg.FaceUtils", "hy: trigger start download model file");
        C1720g.m3540Rg().mo14541a(new C44796m(42), 0);
        AppMethodBeat.m2505o(271);
    }

    public static boolean bsN() {
        boolean z = false;
        AppMethodBeat.m2504i(272);
        String bsP = C43036p.bsP();
        String bsQ = C43036p.bsQ();
        if (C5046bo.isNullOrNil(bsP) || C5046bo.isNullOrNil(bsQ)) {
            C4990ab.m7420w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
        } else {
            boolean z2;
            C5728b c5728b = new C5728b(bsP);
            C5728b c5728b2 = new C5728b(bsQ);
            if (c5728b.exists() || C43036p.m76435vn(0)) {
                z2 = true;
            } else {
                C4990ab.m7412e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
                z2 = false;
            }
            if (c5728b2.exists() || C43036p.m76435vn(1)) {
                z = z2;
            } else {
                C4990ab.m7412e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
            }
        }
        if (!z) {
            C43036p.bsM();
        }
        AppMethodBeat.m2505o(272);
        return z;
    }

    public static String bsO() {
        String str;
        AppMethodBeat.m2504i(273);
        if (C34096a.lTw) {
            str = C1448h.getExternalStorageDirectory().getAbsolutePath() + "/face_detect";
        } else {
            str = C4996ah.getContext().getFilesDir().getParent() + "/face_detect";
        }
        C5728b c5728b = new C5728b(str);
        if (!c5728b.exists()) {
            C4990ab.m7416i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
            c5728b.mkdirs();
        }
        AppMethodBeat.m2505o(273);
        return str;
    }

    public static String bsP() {
        AppMethodBeat.m2504i(274);
        String str = C43036p.bsO() + "/ufdmtcc.bin";
        AppMethodBeat.m2505o(274);
        return str;
    }

    public static String bsQ() {
        AppMethodBeat.m2504i(C31128d.MIC_GPU_AUTOLEVEL);
        String str = C43036p.bsO() + "/ufat.bin";
        AppMethodBeat.m2505o(C31128d.MIC_GPU_AUTOLEVEL);
        return str;
    }

    public static String bsR() {
        AppMethodBeat.m2504i(276);
        String str = C43036p.bsO() + "/PE.dat";
        AppMethodBeat.m2505o(276);
        return str;
    }

    public static String bsS() {
        AppMethodBeat.m2504i(277);
        String str = C43036p.bsO() + "/release_out.fd";
        AppMethodBeat.m2505o(277);
        return str;
    }

    /* renamed from: vn */
    public static boolean m76435vn(int i) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_TRANS_XINGYE);
        String str = "";
        switch (i) {
            case 0:
                str = C6665av.fly.mo5292T("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
                break;
            case 1:
                str = C6665av.fly.mo5292T("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
                break;
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7421w("MicroMsg.FaceUtils", "hy: no such path for type: %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINGYE);
            return false;
        } else if (new C5728b(str).exists()) {
            C5728b c5728b = new C5728b(C43036p.m76436vo(i));
            if (c5728b.exists()) {
                c5728b.delete();
            }
            C5730e.m8644y(str, C43036p.m76436vo(i));
            AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINGYE);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.FaceUtils", "originFile file not exist");
            AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINGYE);
            return false;
        }
    }

    /* renamed from: vo */
    public static String m76436vo(int i) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_TRANS_ROUHE);
        String bsP;
        switch (i) {
            case 0:
                bsP = C43036p.bsP();
                AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_ROUHE);
                return bsP;
            case 1:
                bsP = C43036p.bsQ();
                AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_ROUHE);
                return bsP;
            default:
                bsP = "";
                AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_ROUHE);
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
    /* renamed from: p */
    public static void m76434p(Context context, String str, String str2) {
        Throwable e;
        AppMethodBeat.m2504i(C31128d.MIC_PTU_TRANS_XINXIAN);
        C4990ab.m7417i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets src: %s, dst: %s", str, str2);
        InputStream open;
        OutputStream c5731f;
        try {
            C5728b c5728b = new C5728b(str2);
            open = context.getAssets().open(str);
            try {
                c5731f = new C5731f(c5728b);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        c5731f.write(bArr, 0, read);
                    }
                    c5731f.flush();
                    C4990ab.m7417i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets %s successfully, file len: %d", str, Long.valueOf(c5728b.length()));
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e2) {
                            AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINXIAN);
                            return;
                        }
                    }
                    c5731f.close();
                    AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINXIAN);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                        if (open != null) {
                        }
                        if (c5731f != null) {
                        }
                        AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINXIAN);
                    } catch (Throwable th) {
                        e = th;
                        if (open != null) {
                        }
                        if (c5731f != null) {
                        }
                        AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINXIAN);
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                c5731f = null;
                C4990ab.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e5) {
                        AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINXIAN);
                        return;
                    }
                }
                if (c5731f != null) {
                    c5731f.close();
                }
                AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINXIAN);
            } catch (Throwable th2) {
                e = th2;
                c5731f = null;
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e6) {
                        AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINXIAN);
                        throw e;
                    }
                }
                if (c5731f != null) {
                    c5731f.close();
                }
                AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINXIAN);
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            c5731f = null;
            open = null;
        } catch (Throwable th3) {
            e = th3;
            c5731f = null;
            open = null;
            if (open != null) {
            }
            if (c5731f != null) {
            }
            AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_XINXIAN);
            throw e;
        }
    }

    /* renamed from: n */
    public static Bitmap m76433n(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        AppMethodBeat.m2504i(C31128d.MIC_PTU_TRANS_KONGCHENG);
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
            C4990ab.m7412e("pix", width + " " + height + " " + iArr.length);
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
                if (C39011b.m66285ik(currentTimeMillis2)) {
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
                if (C39011b.m66285ik(currentTimeMillis2)) {
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
                if (C39011b.m66285ik(currentTimeMillis2)) {
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
                if (C39011b.m66285ik(currentTimeMillis2)) {
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
            C4990ab.m7412e("pix", width + " " + height + " " + i18);
            bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
        }
        C4990ab.m7417i("MicroMsg.FaceUtils", "hy: blur using %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        Object obj = 1;
        if (bitmap2 == null) {
            C4990ab.m7420w("MicroMsg.FaceUtils", "hy: null on blur. use default");
            obj = null;
            bitmap2 = C43036p.m76425Lr(str);
            if (bitmap2 == null) {
                bitmap2 = C5056d.m7610LV(C25738R.drawable.b30);
            }
        }
        if (obj != null) {
            final String str2 = str;
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
                    long yz = C5046bo.m7588yz();
                    C43036p.m76431b(bitmap2, str2);
                    C4990ab.m7417i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", Long.valueOf(C5046bo.m7525az(yz)));
                    AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM);
                }
            }, "FaceUtils_SaveFile");
        }
        AppMethodBeat.m2505o(C31128d.MIC_PTU_TRANS_KONGCHENG);
        return bitmap2;
    }

    /* renamed from: Lt */
    public static String m76427Lt(String str) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_BAIXI);
        String x = C1178g.m2591x((C5046bo.m7588yz() + ", " + str).getBytes());
        AppMethodBeat.m2505o(C31128d.MIC_PTU_BAIXI);
        return x;
    }

    /* renamed from: d */
    public static void m76432d(byte[] bArr, String str) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE);
        try {
            C5730e.m8624b(str, bArr, bArr.length);
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in save debug jpeg", new Object[0]);
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE);
        }
    }
}
