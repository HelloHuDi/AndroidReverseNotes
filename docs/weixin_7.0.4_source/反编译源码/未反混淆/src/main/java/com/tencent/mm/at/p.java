package com.tencent.mm.at;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class p implements com.tencent.mm.at.c.c {
    c fGA = null;
    boolean fGB = false;
    List<c> fGz = new LinkedList();

    static class c {
        public a fGD;
        public String url;

        public c(String str, a aVar) {
            this.url = str;
            this.fGD = aVar;
        }
    }

    public interface a {
        void i(String str, Bitmap bitmap);
    }

    static class b {
        public Bitmap bitmap;
        public String path;

        public b(String str, Bitmap bitmap) {
            this.path = str;
            this.bitmap = bitmap;
        }
    }

    public p() {
        AppMethodBeat.i(78399);
        AppMethodBeat.o(78399);
    }

    public final void a(String str, a aVar) {
        AppMethodBeat.i(78400);
        if (bo.isNullOrNil(str) || aVar == null) {
            ab.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
            AppMethodBeat.o(78400);
        } else if (this.fGA != null && this.fGA.url.equals(str) && this.fGA.fGD == aVar) {
            ab.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
            AppMethodBeat.o(78400);
        } else {
            for (c cVar : this.fGz) {
                if (cVar.url.equals(str) && cVar.fGD == aVar) {
                    ab.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
                    AppMethodBeat.o(78400);
                    return;
                }
            }
            this.fGz.add(new c(str, aVar));
            ahr();
            AppMethodBeat.o(78400);
        }
    }

    public final void b(String str, a aVar) {
        AppMethodBeat.i(78401);
        if (bo.isNullOrNil(str) || aVar == null) {
            ab.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
            AppMethodBeat.o(78401);
        } else if (this.fGA != null && this.fGA.url.equals(str) && this.fGA.fGD == aVar) {
            this.fGB = true;
            ab.i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", str);
            AppMethodBeat.o(78401);
        } else {
            for (c cVar : this.fGz) {
                if (cVar.url.equals(str) && cVar.fGD == aVar) {
                    ab.i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", str);
                    this.fGz.remove(cVar);
                    AppMethodBeat.o(78401);
                    return;
                }
            }
            AppMethodBeat.o(78401);
        }
    }

    /* Access modifiers changed, original: final */
    public final void ahr() {
        AppMethodBeat.i(78402);
        while (this.fGA == null && this.fGz.size() != 0) {
            this.fGA = (c) this.fGz.get(0);
            this.fGz.remove(0);
            this.fGB = false;
            o.ahk();
            Bitmap kR = c.kR(this.fGA.url);
            if (kR != null) {
                ab.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.fGA.url);
                if (!this.fGB) {
                    this.fGA.fGD.i(this.fGA.url, kR);
                }
                this.fGA = null;
            } else {
                new AsyncTask<String, Integer, Bitmap>() {
                    /* Access modifiers changed, original: protected|final|synthetic */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        AppMethodBeat.i(78396);
                        String[] strArr = (String[]) objArr;
                        if (strArr.length <= 0) {
                            AppMethodBeat.o(78396);
                            return null;
                        }
                        String sw = p.sw(strArr[0]);
                        if (new File(sw).exists()) {
                            Object aml = d.aml(sw);
                            AppMethodBeat.o(78396);
                            return aml;
                        }
                        AppMethodBeat.o(78396);
                        return null;
                    }

                    /* Access modifiers changed, original: protected|final|synthetic */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        AppMethodBeat.i(78395);
                        Bitmap bitmap = (Bitmap) obj;
                        if (bitmap != null) {
                            ab.d("MicroMsg.UrlImageCacheService", "load from sdcard");
                            if (!p.this.fGB) {
                                o.ahk();
                                c.h(p.this.fGA.url, bitmap);
                                p.this.fGA.fGD.i(p.this.fGA.url, bitmap);
                            }
                            p.this.fGA = null;
                            p.this.ahr();
                            AppMethodBeat.o(78395);
                            return;
                        }
                        ab.i("MicroMsg.UrlImageCacheService", "try load from " + p.this.fGA.url);
                        o.ahk().a(p.this.fGA.url, p.this);
                        AppMethodBeat.o(78395);
                    }
                }.execute(new String[]{this.fGA.url});
                AppMethodBeat.o(78402);
                return;
            }
        }
        ab.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.o(78402);
    }

    static String sw(String str) {
        AppMethodBeat.i(78403);
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            if (bo.isNullOrNil(encode)) {
                ab.e("MicroMsg.UrlImageCacheService", "encode result is null: ".concat(String.valueOf(str)));
                AppMethodBeat.o(78403);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e.evi);
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
            AppMethodBeat.o(78403);
            return stringBuilder2;
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: ".concat(String.valueOf(str)));
            AppMethodBeat.o(78403);
            return null;
        }
    }

    public final void C(Bitmap bitmap) {
        AppMethodBeat.i(78404);
        if (bitmap == null) {
            ab.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.fGA.url);
            this.fGA = null;
            ahr();
            AppMethodBeat.o(78404);
            return;
        }
        ab.i("MicroMsg.UrlImageCacheService", "load from %s successed", this.fGA.url);
        new AsyncTask<b, Integer, Integer>() {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                AppMethodBeat.i(78398);
                Integer a = AnonymousClass2.a((b[]) objArr);
                AppMethodBeat.o(78398);
                return a;
            }

            private static Integer a(b... bVarArr) {
                AppMethodBeat.i(78397);
                if (bVarArr.length == 0 || bo.isNullOrNil(bVarArr[0].path) || bVarArr[0].bitmap == null) {
                    ab.e("MicroMsg.UrlImageCacheService", "nothing to save");
                    AppMethodBeat.o(78397);
                } else {
                    try {
                        d.a(bVarArr[0].bitmap, 100, CompressFormat.PNG, bVarArr[0].path, false);
                    } catch (IOException e) {
                        ab.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + e.toString());
                    }
                    AppMethodBeat.o(78397);
                }
                return null;
            }
        }.execute(new b[]{new b(sw(this.fGA.url), bitmap)});
        if (!this.fGB) {
            o.ahk();
            c.h(this.fGA.url, bitmap);
            this.fGA.fGD.i(this.fGA.url, bitmap);
        }
        this.fGA = null;
        ahr();
        AppMethodBeat.o(78404);
    }
}
