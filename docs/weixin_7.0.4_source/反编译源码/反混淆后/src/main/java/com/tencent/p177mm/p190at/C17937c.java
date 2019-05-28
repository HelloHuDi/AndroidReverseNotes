package com.tencent.p177mm.p190at;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.cache.C18129e.C18130a;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.HashMap;

/* renamed from: com.tencent.mm.at.c */
public final class C17937c {
    private HashMap<String, C17936c> fDl = new HashMap();

    /* renamed from: com.tencent.mm.at.c$a */
    static class C17935a implements Runnable {
        private HashMap<String, C17936c> fDl;
        private Bitmap fDm;
        private String url;

        public C17935a(String str, Bitmap bitmap, HashMap<String, C17936c> hashMap) {
            this.url = str;
            this.fDm = bitmap;
            this.fDl = hashMap;
        }

        public final void run() {
            AppMethodBeat.m2504i(78165);
            C32291o.ahk();
            C17937c.m28185h(this.url, this.fDm);
            if (this.fDl != null) {
                C17936c c17936c = (C17936c) this.fDl.remove(this.url);
                if (c17936c != null) {
                    c17936c.mo9733C(this.fDm);
                }
            }
            String str = "MicroMsg.CdnImageService";
            String str2 = "finish download post job, url[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = this.url == null ? BuildConfig.COMMAND : this.url;
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(78165);
        }
    }

    /* renamed from: com.tencent.mm.at.c$c */
    public interface C17936c {
        /* renamed from: C */
        void mo9733C(Bitmap bitmap);
    }

    /* renamed from: com.tencent.mm.at.c$b */
    static class C17938b implements Runnable {
        private HashMap<String, C17936c> fDl;
        private String url;

        C17938b(String str, HashMap<String, C17936c> hashMap) {
            this.url = str;
            this.fDl = hashMap;
        }

        public final void run() {
            AppMethodBeat.m2504i(78166);
            byte[] ano = C5046bo.ano(this.url);
            if (ano == null) {
                C4990ab.m7421w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", this.url);
                AppMethodBeat.m2505o(78166);
                return;
            }
            Bitmap bQ;
            try {
                bQ = C5056d.m7652bQ(ano);
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", this.url, e.getLocalizedMessage());
                bQ = null;
            }
            C4990ab.m7417i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", this.url);
            C5004al.m7441d(new C17935a(this.url, bQ, this.fDl));
            AppMethodBeat.m2505o(78166);
        }
    }

    public C17937c() {
        AppMethodBeat.m2504i(78167);
        AppMethodBeat.m2505o(78167);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(78168);
        super.finalize();
        AppMethodBeat.m2505o(78168);
    }

    /* renamed from: h */
    public static void m28185h(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(78169);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.CdnImageService", "push fail, key is null");
            AppMethodBeat.m2505o(78169);
            return;
        }
        C18130a.m28566a("local_cdn_img_cache", str, bitmap);
        AppMethodBeat.m2505o(78169);
    }

    /* renamed from: kR */
    public static Bitmap m28186kR(String str) {
        AppMethodBeat.m2504i(78170);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.CdnImageService", "get fail, key is null");
            AppMethodBeat.m2505o(78170);
            return null;
        }
        Bitmap bitmap = (Bitmap) C18130a.m28562J("local_cdn_img_cache", str);
        AppMethodBeat.m2505o(78170);
        return bitmap;
    }

    /* renamed from: rZ */
    public final void mo33460rZ(String str) {
        AppMethodBeat.m2504i(78171);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.CdnImageService", "stop load fail, url is empty");
            AppMethodBeat.m2505o(78171);
            return;
        }
        this.fDl.remove(str);
        AppMethodBeat.m2505o(78171);
    }

    /* renamed from: a */
    public final void mo33458a(String str, C17936c c17936c) {
        AppMethodBeat.m2504i(78172);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.CdnImageService", "do load fail, url is empty");
            AppMethodBeat.m2505o(78172);
            return;
        }
        Bitmap kR = C17937c.m28186kR(str);
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
            C4990ab.m7421w(str2, str3, objArr);
            if (this.fDl.containsKey(str)) {
                C4990ab.m7421w("MicroMsg.CdnImageService", "contains url[%s]", str);
                AppMethodBeat.m2505o(78172);
                return;
            }
            this.fDl.put(str, c17936c);
            C7305d.post(new C17938b(str, this.fDl), "CdnImageService_download");
            AppMethodBeat.m2505o(78172);
            return;
        }
        C4990ab.m7417i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", str);
        if (c17936c != null) {
            c17936c.mo9733C(kR);
        }
        AppMethodBeat.m2505o(78172);
    }
}
