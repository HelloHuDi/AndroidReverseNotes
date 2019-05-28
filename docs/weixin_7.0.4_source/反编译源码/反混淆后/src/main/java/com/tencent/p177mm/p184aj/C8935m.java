package com.tencent.p177mm.p184aj;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.aj.m */
public final class C8935m {

    /* renamed from: com.tencent.mm.aj.m$b */
    static class C8937b implements C23499a {
        public byte[] frt = null;
        private final String fwM;
        private final String url;

        public C8937b(String str, String str2) {
            this.fwM = str;
            this.url = str2;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(11426);
            if (C5046bo.isNullOrNil(this.fwM) || C5046bo.isNullOrNil(this.url)) {
                AppMethodBeat.m2505o(11426);
                return false;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream p = C1897b.m4022p(this.url, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, 5000);
                if (p == null) {
                    AppMethodBeat.m2505o(11426);
                    return false;
                }
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = p.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                p.close();
                this.frt = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (C5046bo.m7540cb(this.frt)) {
                    C4990ab.m7412e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.fwM);
                    AppMethodBeat.m2505o(11426);
                    return false;
                }
                if (C1720g.m3534RN().mo5161QY()) {
                    C26417a.flv.mo44184cm(this.frt.length, 0);
                    C8938a afb = C41747z.afb();
                    String str = this.fwM;
                    String str2 = this.url;
                    byte[] bArr2 = this.frt;
                    try {
                        str2 = str + str2;
                        Bitmap bQ = C5056d.m7652bQ(bArr2);
                        C5056d.m7625a(bQ, 100, CompressFormat.PNG, C8938a.m16107rm(str2), false);
                        afb.mo20355g(str, bQ);
                        C4990ab.m7416i("MicroMsg.BrandLogic", "update brand icon for  " + str + ", done");
                        afb.fwJ.remove(str);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.BrandLogic", "exception:%s", C5046bo.m7574l(e));
                    }
                }
                AppMethodBeat.m2505o(11426);
                return true;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.BrandLogic", "exception:%s", C5046bo.m7574l(e2));
                C4990ab.m7412e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
                this.frt = null;
                AppMethodBeat.m2505o(11426);
                return false;
            }
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(11427);
            C8938a afb = C41747z.afb();
            int i = 0;
            while (i < afb.fwI.size()) {
                try {
                    afb.fwI.get(i);
                    i++;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.BrandLogic", "exception:%s", C5046bo.m7574l(e));
                }
            }
            AppMethodBeat.m2505o(11427);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.aj.m$a */
    public static final class C8938a {
        List<Object> fwI = new ArrayList();
        Map<String, Integer> fwJ = new HashMap();
        Map<String, WeakReference<Bitmap>> fwK = new HashMap();
        C23498az fwL = null;

        public C8938a() {
            AppMethodBeat.m2504i(11421);
            AppMethodBeat.m2505o(11421);
        }

        public final void aeL() {
            AppMethodBeat.m2504i(11422);
            this.fwI.clear();
            AppMethodBeat.m2505o(11422);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: rl */
        public final Bitmap mo20356rl(String str) {
            Bitmap bitmap;
            AppMethodBeat.m2504i(11423);
            String format = String.format("%s%f", new Object[]{str, Float.valueOf(1.5f)});
            if (this.fwK.containsKey(format)) {
                bitmap = (Bitmap) ((WeakReference) this.fwK.get(format)).get();
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = C4977b.m7374i(str, 1.5f);
                    this.fwK.remove(format);
                    this.fwK.put(format, new WeakReference(bitmap));
                }
            } else {
                bitmap = C4977b.m7374i(str, 1.5f);
                this.fwK.put(format, new WeakReference(bitmap));
            }
            AppMethodBeat.m2505o(11423);
            return bitmap;
        }

        /* renamed from: rm */
        public static String m16107rm(String str) {
            AppMethodBeat.m2504i(11424);
            String str2;
            if (C1720g.m3534RN().mo5161QY()) {
                str2 = ((C8939o) C1720g.m3528K(C8939o.class)).mo20359Yf() + "/brand_" + C1178g.m2591x(str.getBytes());
                AppMethodBeat.m2505o(11424);
                return str2;
            }
            str2 = "";
            AppMethodBeat.m2505o(11424);
            return str2;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: g */
        public final void mo20355g(String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(11425);
            Bitmap bitmap2 = this.fwK.containsKey(str) ? (Bitmap) ((WeakReference) this.fwK.get(str)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                try {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, 128, 128, true);
                    bitmap2 = C5056d.m7616a(bitmap2, true, (float) (bitmap2.getWidth() >> 1));
                } catch (OutOfMemoryError e) {
                    bitmap2 = bitmap;
                }
                this.fwK.remove(str);
                this.fwK.put(str, new WeakReference(bitmap2));
            }
            if (bitmap2 == bitmap) {
                AppMethodBeat.m2505o(11425);
                return;
            }
            C4990ab.m7417i("MicroMsg.BrandLogic", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
            AppMethodBeat.m2505o(11425);
        }
    }

    /* renamed from: rk */
    public static Bitmap m16106rk(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(11428);
        if (!C5046bo.isNullOrNil(str) && C1720g.m3536RP().isSDCardAvailable() && C1720g.m3534RN().mo5161QY()) {
            Bitmap rl = C41747z.afb().mo20356rl(str);
            String str2 = "MicroMsg.BrandLogic";
            String str3 = "get verify user icon = %s, is null ? %s";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (rl == null) {
                z = true;
            }
            objArr[1] = String.valueOf(z);
            C4990ab.m7417i(str2, str3, objArr);
            AppMethodBeat.m2505o(11428);
            return rl;
        }
        AppMethodBeat.m2505o(11428);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aA */
    public static Bitmap m16104aA(final String str, String str2) {
        AppMethodBeat.m2504i(11429);
        Bitmap aeK;
        if (!C1720g.m3536RP().isSDCardAvailable()) {
            aeK = C8935m.aeK();
            AppMethodBeat.m2505o(11429);
            return aeK;
        } else if (str == null || !C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(11429);
            return null;
        } else {
            if (str2 == null) {
                str2 = C8935m.m16105aB(str, null);
                if (str2 == null) {
                    AppMethodBeat.m2505o(11429);
                    return null;
                }
            }
            C8938a afb = C41747z.afb();
            WeakReference weakReference;
            if (afb.fwK.containsKey(str)) {
                aeK = (Bitmap) ((WeakReference) afb.fwK.get(str)).get();
                if (aeK == null || aeK.isRecycled()) {
                    aeK = C5056d.aml(C8938a.m16107rm(str + C8935m.m16105aB(str, str2)));
                    if (aeK == null) {
                        C4990ab.m7416i("MicroMsg.BrandLogic", "not found brand icon local");
                    } else {
                        afb.mo20355g(str, aeK);
                    }
                }
                weakReference = (WeakReference) afb.fwK.get(str);
                if (weakReference != null) {
                    aeK = (Bitmap) weakReference.get();
                    if (aeK == null) {
                        AppMethodBeat.m2505o(11429);
                        return aeK;
                    }
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(11420);
                            C8938a afb = C41747z.afb();
                            String str = str;
                            String str2 = str2;
                            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                                C4990ab.m7412e("MicroMsg.BrandLogic", "pushing for brand " + str + ", url " + str2);
                                AppMethodBeat.m2505o(11420);
                            } else if (C5046bo.m7549fp((long) C5046bo.m7567h((Integer) afb.fwJ.get(str))) < 300) {
                                C4990ab.m7416i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for ".concat(String.valueOf(str)));
                                AppMethodBeat.m2505o(11420);
                            } else {
                                afb.fwJ.put(str, Integer.valueOf((int) C5046bo.anT()));
                                if (afb.fwL == null || afb.fwL.dpg()) {
                                    afb.fwL = new C23498az(1, "brand-logic");
                                }
                                afb.fwL.mo39163e(new C8937b(str, C8935m.m16105aB(str, str2)));
                                AppMethodBeat.m2505o(11420);
                            }
                        }
                    });
                    AppMethodBeat.m2505o(11429);
                    return null;
                }
            }
            aeK = C5056d.aml(C8938a.m16107rm(str + C8935m.m16105aB(str, str2)));
            if (aeK == null) {
                C4990ab.m7416i("MicroMsg.BrandLogic", "not found brand icon local");
            } else {
                afb.mo20355g(str, aeK);
                weakReference = (WeakReference) afb.fwK.get(str);
                if (weakReference != null) {
                }
            }
            aeK = null;
            if (aeK == null) {
            }
        }
    }

    private static Bitmap aeK() {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(11430);
        Options options = new Options();
        C5056d.dnX();
        try {
            inputStream = C4996ah.getContext().getResources().openRawResource(C25738R.drawable.akb);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.BrandLogic", e, "", new Object[0]);
                }
            }
            if (decodeStream != null) {
                decodeStream = C5056d.m7616a(decodeStream, false, (float) (decodeStream.getWidth() >> 1));
            }
            AppMethodBeat.m2505o(11430);
            return decodeStream;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.BrandLogic", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(11430);
        }
    }

    /* renamed from: aB */
    static String m16105aB(String str, String str2) {
        AppMethodBeat.m2504i(11431);
        if (str == null || !C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(11431);
            return null;
        }
        C16527d qP = C41747z.aeR().mo43729qP(str);
        if (qP.field_brandIconURL != null) {
            str2 = qP.field_brandIconURL;
            AppMethodBeat.m2505o(11431);
            return str2;
        }
        AppMethodBeat.m2505o(11431);
        return str2;
    }
}
