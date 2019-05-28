package com.tencent.mm.aj;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m {

    static class b implements com.tencent.mm.sdk.platformtools.az.a {
        public byte[] frt = null;
        private final String fwM;
        private final String url;

        public b(String str, String str2) {
            this.fwM = str;
            this.url = str2;
        }

        public final boolean acf() {
            AppMethodBeat.i(11426);
            if (bo.isNullOrNil(this.fwM) || bo.isNullOrNil(this.url)) {
                AppMethodBeat.o(11426);
                return false;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream p = com.tencent.mm.network.b.p(this.url, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, 5000);
                if (p == null) {
                    AppMethodBeat.o(11426);
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
                if (bo.cb(this.frt)) {
                    ab.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.fwM);
                    AppMethodBeat.o(11426);
                    return false;
                }
                if (g.RN().QY()) {
                    com.tencent.mm.model.ao.a.flv.cm(this.frt.length, 0);
                    a afb = z.afb();
                    String str = this.fwM;
                    String str2 = this.url;
                    byte[] bArr2 = this.frt;
                    try {
                        str2 = str + str2;
                        Bitmap bQ = d.bQ(bArr2);
                        d.a(bQ, 100, CompressFormat.PNG, a.rm(str2), false);
                        afb.g(str, bQ);
                        ab.i("MicroMsg.BrandLogic", "update brand icon for  " + str + ", done");
                        afb.fwJ.remove(str);
                    } catch (Exception e) {
                        ab.e("MicroMsg.BrandLogic", "exception:%s", bo.l(e));
                    }
                }
                AppMethodBeat.o(11426);
                return true;
            } catch (Exception e2) {
                ab.e("MicroMsg.BrandLogic", "exception:%s", bo.l(e2));
                ab.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
                this.frt = null;
                AppMethodBeat.o(11426);
                return false;
            }
        }

        public final boolean acg() {
            AppMethodBeat.i(11427);
            a afb = z.afb();
            int i = 0;
            while (i < afb.fwI.size()) {
                try {
                    afb.fwI.get(i);
                    i++;
                } catch (Exception e) {
                    ab.e("MicroMsg.BrandLogic", "exception:%s", bo.l(e));
                }
            }
            AppMethodBeat.o(11427);
            return false;
        }
    }

    public static final class a {
        List<Object> fwI = new ArrayList();
        Map<String, Integer> fwJ = new HashMap();
        Map<String, WeakReference<Bitmap>> fwK = new HashMap();
        az fwL = null;

        public a() {
            AppMethodBeat.i(11421);
            AppMethodBeat.o(11421);
        }

        public final void aeL() {
            AppMethodBeat.i(11422);
            this.fwI.clear();
            AppMethodBeat.o(11422);
        }

        /* Access modifiers changed, original: final */
        public final Bitmap rl(String str) {
            Bitmap bitmap;
            AppMethodBeat.i(11423);
            String format = String.format("%s%f", new Object[]{str, Float.valueOf(1.5f)});
            if (this.fwK.containsKey(format)) {
                bitmap = (Bitmap) ((WeakReference) this.fwK.get(format)).get();
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.i(str, 1.5f);
                    this.fwK.remove(format);
                    this.fwK.put(format, new WeakReference(bitmap));
                }
            } else {
                bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.i(str, 1.5f);
                this.fwK.put(format, new WeakReference(bitmap));
            }
            AppMethodBeat.o(11423);
            return bitmap;
        }

        public static String rm(String str) {
            AppMethodBeat.i(11424);
            String str2;
            if (g.RN().QY()) {
                str2 = ((o) g.K(o.class)).Yf() + "/brand_" + com.tencent.mm.a.g.x(str.getBytes());
                AppMethodBeat.o(11424);
                return str2;
            }
            str2 = "";
            AppMethodBeat.o(11424);
            return str2;
        }

        /* Access modifiers changed, original: final */
        public final void g(String str, Bitmap bitmap) {
            AppMethodBeat.i(11425);
            Bitmap bitmap2 = this.fwK.containsKey(str) ? (Bitmap) ((WeakReference) this.fwK.get(str)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                try {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, 128, 128, true);
                    bitmap2 = d.a(bitmap2, true, (float) (bitmap2.getWidth() >> 1));
                } catch (OutOfMemoryError e) {
                    bitmap2 = bitmap;
                }
                this.fwK.remove(str);
                this.fwK.put(str, new WeakReference(bitmap2));
            }
            if (bitmap2 == bitmap) {
                AppMethodBeat.o(11425);
                return;
            }
            ab.i("MicroMsg.BrandLogic", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
            AppMethodBeat.o(11425);
        }
    }

    public static Bitmap rk(String str) {
        boolean z = false;
        AppMethodBeat.i(11428);
        if (!bo.isNullOrNil(str) && g.RP().isSDCardAvailable() && g.RN().QY()) {
            Bitmap rl = z.afb().rl(str);
            String str2 = "MicroMsg.BrandLogic";
            String str3 = "get verify user icon = %s, is null ? %s";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (rl == null) {
                z = true;
            }
            objArr[1] = String.valueOf(z);
            ab.i(str2, str3, objArr);
            AppMethodBeat.o(11428);
            return rl;
        }
        AppMethodBeat.o(11428);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap aA(final String str, String str2) {
        AppMethodBeat.i(11429);
        Bitmap aeK;
        if (!g.RP().isSDCardAvailable()) {
            aeK = aeK();
            AppMethodBeat.o(11429);
            return aeK;
        } else if (str == null || !g.RN().QY()) {
            AppMethodBeat.o(11429);
            return null;
        } else {
            if (str2 == null) {
                str2 = aB(str, null);
                if (str2 == null) {
                    AppMethodBeat.o(11429);
                    return null;
                }
            }
            a afb = z.afb();
            WeakReference weakReference;
            if (afb.fwK.containsKey(str)) {
                aeK = (Bitmap) ((WeakReference) afb.fwK.get(str)).get();
                if (aeK == null || aeK.isRecycled()) {
                    aeK = d.aml(a.rm(str + aB(str, str2)));
                    if (aeK == null) {
                        ab.i("MicroMsg.BrandLogic", "not found brand icon local");
                    } else {
                        afb.g(str, aeK);
                    }
                }
                weakReference = (WeakReference) afb.fwK.get(str);
                if (weakReference != null) {
                    aeK = (Bitmap) weakReference.get();
                    if (aeK == null) {
                        AppMethodBeat.o(11429);
                        return aeK;
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(11420);
                            a afb = z.afb();
                            String str = str;
                            String str2 = str2;
                            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                                ab.e("MicroMsg.BrandLogic", "pushing for brand " + str + ", url " + str2);
                                AppMethodBeat.o(11420);
                            } else if (bo.fp((long) bo.h((Integer) afb.fwJ.get(str))) < 300) {
                                ab.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for ".concat(String.valueOf(str)));
                                AppMethodBeat.o(11420);
                            } else {
                                afb.fwJ.put(str, Integer.valueOf((int) bo.anT()));
                                if (afb.fwL == null || afb.fwL.dpg()) {
                                    afb.fwL = new az(1, "brand-logic");
                                }
                                afb.fwL.e(new b(str, m.aB(str, str2)));
                                AppMethodBeat.o(11420);
                            }
                        }
                    });
                    AppMethodBeat.o(11429);
                    return null;
                }
            }
            aeK = d.aml(a.rm(str + aB(str, str2)));
            if (aeK == null) {
                ab.i("MicroMsg.BrandLogic", "not found brand icon local");
            } else {
                afb.g(str, aeK);
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
        AppMethodBeat.i(11430);
        Options options = new Options();
        d.dnX();
        try {
            inputStream = ah.getContext().getResources().openRawResource(R.drawable.akb);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.BrandLogic", e, "", new Object[0]);
                }
            }
            if (decodeStream != null) {
                decodeStream = d.a(decodeStream, false, (float) (decodeStream.getWidth() >> 1));
            }
            AppMethodBeat.o(11430);
            return decodeStream;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.BrandLogic", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(11430);
        }
    }

    static String aB(String str, String str2) {
        AppMethodBeat.i(11431);
        if (str == null || !g.RN().QY()) {
            AppMethodBeat.o(11431);
            return null;
        }
        d qP = z.aeR().qP(str);
        if (qP.field_brandIconURL != null) {
            str2 = qP.field_brandIconURL;
            AppMethodBeat.o(11431);
            return str2;
        }
        AppMethodBeat.o(11431);
        return str2;
    }
}
