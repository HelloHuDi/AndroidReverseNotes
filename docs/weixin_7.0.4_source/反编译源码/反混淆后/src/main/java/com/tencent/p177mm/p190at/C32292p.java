package com.tencent.p177mm.p190at;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p190at.C17937c.C17936c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.at.p */
public final class C32292p implements C17936c {
    C9033c fGA = null;
    boolean fGB = false;
    List<C9033c> fGz = new LinkedList();

    /* renamed from: com.tencent.mm.at.p$c */
    static class C9033c {
        public C32293a fGD;
        public String url;

        public C9033c(String str, C32293a c32293a) {
            this.url = str;
            this.fGD = c32293a;
        }
    }

    /* renamed from: com.tencent.mm.at.p$2 */
    class C179482 extends AsyncTask<C32294b, Integer, Integer> {
        C179482() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(78398);
            Integer a = C179482.m28207a((C32294b[]) objArr);
            AppMethodBeat.m2505o(78398);
            return a;
        }

        /* renamed from: a */
        private static Integer m28207a(C32294b... c32294bArr) {
            AppMethodBeat.m2504i(78397);
            if (c32294bArr.length == 0 || C5046bo.isNullOrNil(c32294bArr[0].path) || c32294bArr[0].bitmap == null) {
                C4990ab.m7412e("MicroMsg.UrlImageCacheService", "nothing to save");
                AppMethodBeat.m2505o(78397);
            } else {
                try {
                    C5056d.m7625a(c32294bArr[0].bitmap, 100, CompressFormat.PNG, c32294bArr[0].path, false);
                } catch (IOException e) {
                    C4990ab.m7412e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + e.toString());
                }
                AppMethodBeat.m2505o(78397);
            }
            return null;
        }
    }

    /* renamed from: com.tencent.mm.at.p$1 */
    class C258281 extends AsyncTask<String, Integer, Bitmap> {
        C258281() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(78396);
            String[] strArr = (String[]) objArr;
            if (strArr.length <= 0) {
                AppMethodBeat.m2505o(78396);
                return null;
            }
            String sw = C32292p.m52736sw(strArr[0]);
            if (new File(sw).exists()) {
                Object aml = C5056d.aml(sw);
                AppMethodBeat.m2505o(78396);
                return aml;
            }
            AppMethodBeat.m2505o(78396);
            return null;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(78395);
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap != null) {
                C4990ab.m7410d("MicroMsg.UrlImageCacheService", "load from sdcard");
                if (!C32292p.this.fGB) {
                    C32291o.ahk();
                    C17937c.m28185h(C32292p.this.fGA.url, bitmap);
                    C32292p.this.fGA.fGD.mo11044i(C32292p.this.fGA.url, bitmap);
                }
                C32292p.this.fGA = null;
                C32292p.this.ahr();
                AppMethodBeat.m2505o(78395);
                return;
            }
            C4990ab.m7416i("MicroMsg.UrlImageCacheService", "try load from " + C32292p.this.fGA.url);
            C32291o.ahk().mo33458a(C32292p.this.fGA.url, C32292p.this);
            AppMethodBeat.m2505o(78395);
        }
    }

    /* renamed from: com.tencent.mm.at.p$a */
    public interface C32293a {
        /* renamed from: i */
        void mo11044i(String str, Bitmap bitmap);
    }

    /* renamed from: com.tencent.mm.at.p$b */
    static class C32294b {
        public Bitmap bitmap;
        public String path;

        public C32294b(String str, Bitmap bitmap) {
            this.path = str;
            this.bitmap = bitmap;
        }
    }

    public C32292p() {
        AppMethodBeat.m2504i(78399);
        AppMethodBeat.m2505o(78399);
    }

    /* renamed from: a */
    public final void mo53003a(String str, C32293a c32293a) {
        AppMethodBeat.m2504i(78400);
        if (C5046bo.isNullOrNil(str) || c32293a == null) {
            C4990ab.m7412e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
            AppMethodBeat.m2505o(78400);
        } else if (this.fGA != null && this.fGA.url.equals(str) && this.fGA.fGD == c32293a) {
            C4990ab.m7412e("MicroMsg.UrlImageCacheService", "url and callback is loading");
            AppMethodBeat.m2505o(78400);
        } else {
            for (C9033c c9033c : this.fGz) {
                if (c9033c.url.equals(str) && c9033c.fGD == c32293a) {
                    C4990ab.m7412e("MicroMsg.UrlImageCacheService", "url and callback is loading");
                    AppMethodBeat.m2505o(78400);
                    return;
                }
            }
            this.fGz.add(new C9033c(str, c32293a));
            ahr();
            AppMethodBeat.m2505o(78400);
        }
    }

    /* renamed from: b */
    public final void mo53005b(String str, C32293a c32293a) {
        AppMethodBeat.m2504i(78401);
        if (C5046bo.isNullOrNil(str) || c32293a == null) {
            C4990ab.m7412e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
            AppMethodBeat.m2505o(78401);
        } else if (this.fGA != null && this.fGA.url.equals(str) && this.fGA.fGD == c32293a) {
            this.fGB = true;
            C4990ab.m7417i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", str);
            AppMethodBeat.m2505o(78401);
        } else {
            for (C9033c c9033c : this.fGz) {
                if (c9033c.url.equals(str) && c9033c.fGD == c32293a) {
                    C4990ab.m7417i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", str);
                    this.fGz.remove(c9033c);
                    AppMethodBeat.m2505o(78401);
                    return;
                }
            }
            AppMethodBeat.m2505o(78401);
        }
    }

    /* Access modifiers changed, original: final */
    public final void ahr() {
        AppMethodBeat.m2504i(78402);
        while (this.fGA == null && this.fGz.size() != 0) {
            this.fGA = (C9033c) this.fGz.get(0);
            this.fGz.remove(0);
            this.fGB = false;
            C32291o.ahk();
            Bitmap kR = C17937c.m28186kR(this.fGA.url);
            if (kR != null) {
                C4990ab.m7410d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.fGA.url);
                if (!this.fGB) {
                    this.fGA.fGD.mo11044i(this.fGA.url, kR);
                }
                this.fGA = null;
            } else {
                new C258281().execute(new String[]{this.fGA.url});
                AppMethodBeat.m2505o(78402);
                return;
            }
        }
        C4990ab.m7410d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.m2505o(78402);
    }

    /* renamed from: sw */
    static String m52736sw(String str) {
        AppMethodBeat.m2504i(78403);
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            if (C5046bo.isNullOrNil(encode)) {
                C4990ab.m7412e("MicroMsg.UrlImageCacheService", "encode result is null: ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(78403);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C6457e.evi);
            int length = encode.length();
            int i = 0;
            while (i < length) {
                stringBuilder.append(IOUtils.DIR_SEPARATOR_UNIX);
                if (i + 20 < length) {
                    stringBuilder.append(encode.substring(i, i + 20));
                    i += 20;
                } else {
                    stringBuilder.append(encode.substring(i, length));
                    i = length;
                }
            }
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(78403);
            return stringBuilder2;
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.UrlImageCacheService", "try encode unsupport character: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(78403);
            return null;
        }
    }

    /* renamed from: C */
    public final void mo9733C(Bitmap bitmap) {
        AppMethodBeat.m2504i(78404);
        if (bitmap == null) {
            C4990ab.m7412e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.fGA.url);
            this.fGA = null;
            ahr();
            AppMethodBeat.m2505o(78404);
            return;
        }
        C4990ab.m7417i("MicroMsg.UrlImageCacheService", "load from %s successed", this.fGA.url);
        new C179482().execute(new C32294b[]{new C32294b(C32292p.m52736sw(this.fGA.url), bitmap)});
        if (!this.fGB) {
            C32291o.ahk();
            C17937c.m28185h(this.fGA.url, bitmap);
            this.fGA.fGD.mo11044i(this.fGA.url, bitmap);
        }
        this.fGA = null;
        ahr();
        AppMethodBeat.m2505o(78404);
    }
}
