package com.tencent.mm.at;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.util.HashMap;

public final class c {
    private HashMap<String, c> fDl = new HashMap();

    static class a implements Runnable {
        private HashMap<String, c> fDl;
        private Bitmap fDm;
        private String url;

        public a(String str, Bitmap bitmap, HashMap<String, c> hashMap) {
            this.url = str;
            this.fDm = bitmap;
            this.fDl = hashMap;
        }

        public final void run() {
            AppMethodBeat.i(78165);
            o.ahk();
            c.h(this.url, this.fDm);
            if (this.fDl != null) {
                c cVar = (c) this.fDl.remove(this.url);
                if (cVar != null) {
                    cVar.C(this.fDm);
                }
            }
            String str = "MicroMsg.CdnImageService";
            String str2 = "finish download post job, url[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = this.url == null ? BuildConfig.COMMAND : this.url;
            ab.i(str, str2, objArr);
            AppMethodBeat.o(78165);
        }
    }

    public interface c {
        void C(Bitmap bitmap);
    }

    static class b implements Runnable {
        private HashMap<String, c> fDl;
        private String url;

        b(String str, HashMap<String, c> hashMap) {
            this.url = str;
            this.fDl = hashMap;
        }

        public final void run() {
            AppMethodBeat.i(78166);
            byte[] ano = bo.ano(this.url);
            if (ano == null) {
                ab.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", this.url);
                AppMethodBeat.o(78166);
                return;
            }
            Bitmap bQ;
            try {
                bQ = d.bQ(ano);
            } catch (Exception e) {
                ab.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", this.url, e.getLocalizedMessage());
                bQ = null;
            }
            ab.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", this.url);
            al.d(new a(this.url, bQ, this.fDl));
            AppMethodBeat.o(78166);
        }
    }

    public c() {
        AppMethodBeat.i(78167);
        AppMethodBeat.o(78167);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(78168);
        super.finalize();
        AppMethodBeat.o(78168);
    }

    public static void h(String str, Bitmap bitmap) {
        AppMethodBeat.i(78169);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.CdnImageService", "push fail, key is null");
            AppMethodBeat.o(78169);
            return;
        }
        com.tencent.mm.cache.e.a.a("local_cdn_img_cache", str, bitmap);
        AppMethodBeat.o(78169);
    }

    public static Bitmap kR(String str) {
        AppMethodBeat.i(78170);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.CdnImageService", "get fail, key is null");
            AppMethodBeat.o(78170);
            return null;
        }
        Bitmap bitmap = (Bitmap) com.tencent.mm.cache.e.a.J("local_cdn_img_cache", str);
        AppMethodBeat.o(78170);
        return bitmap;
    }

    public final void rZ(String str) {
        AppMethodBeat.i(78171);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
            AppMethodBeat.o(78171);
            return;
        }
        this.fDl.remove(str);
        AppMethodBeat.o(78171);
    }

    public final void a(String str, c cVar) {
        AppMethodBeat.i(78172);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.CdnImageService", "do load fail, url is empty");
            AppMethodBeat.o(78172);
            return;
        }
        Bitmap kR = kR(str);
        if (kR == null || kR.isRecycled()) {
            boolean z;
            String str2 = "MicroMsg.CdnImageService";
            String str3 = "try to download: url[%s], src bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (kR == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.w(str2, str3, objArr);
            if (this.fDl.containsKey(str)) {
                ab.w("MicroMsg.CdnImageService", "contains url[%s]", str);
                AppMethodBeat.o(78172);
                return;
            }
            this.fDl.put(str, cVar);
            com.tencent.mm.sdk.g.d.post(new b(str, this.fDl), "CdnImageService_download");
            AppMethodBeat.o(78172);
            return;
        }
        ab.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", str);
        if (cVar != null) {
            cVar.C(kR);
        }
        AppMethodBeat.o(78172);
    }
}
