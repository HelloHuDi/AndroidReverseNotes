package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.luggage.p1589e.p1590a.C41710a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7583c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.e */
public final class C42544e extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 120;
    private static final String NAME = "getImageInfo";
    private static final Collection<C33373b> hQa;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.e$a */
    static final class C2317a implements C33373b {
        private C2317a() {
        }

        /* synthetic */ C2317a(byte b) {
            this();
        }

        /* renamed from: h */
        public final C5710a mo6192h(C6750i c6750i, String str) {
            AppMethodBeat.m2504i(114359);
            File yg = c6750i.asE().mo34314yg(str);
            if (yg == null) {
                AppMethodBeat.m2505o(114359);
                return null;
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(yg.getAbsolutePath(), options);
            C38350c c38350c = new C38350c();
            c38350c.width = options.outWidth;
            c38350c.height = options.outHeight;
            c38350c.type = C41710a.m73390f(options);
            c38350c.hfh = C41710a.m73389e(options) ? C41710a.m73391fO(C41710a.m73388bJ(yg.getAbsolutePath())) : "up";
            C5710a F = C5710a.m8574F(C38351e.RESOLVED, c38350c);
            AppMethodBeat.m2505o(114359);
            return F;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.e$b */
    interface C33373b {
        /* renamed from: h */
        C5710a mo6192h(C6750i c6750i, String str);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.e$c */
    static final class C38350c {
        public int height;
        public String hfh;
        public String type;
        public int width;

        private C38350c() {
        }

        /* synthetic */ C38350c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.e$e */
    enum C38351e {
        FILE_NOT_FOUND,
        UNKNOWN_FAIL,
        RESOLVED;

        static {
            AppMethodBeat.m2505o(114363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.e$2 */
    static /* synthetic */ class C425452 {
        static final /* synthetic */ int[] hQd = new int[C38351e.values().length];

        static {
            AppMethodBeat.m2504i(114358);
            try {
                hQd[C38351e.FILE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hQd[C38351e.RESOLVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hQd[C38351e.UNKNOWN_FAIL.ordinal()] = 3;
                AppMethodBeat.m2505o(114358);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.m2505o(114358);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.e$d */
    static final class C42546d implements C33373b {
        private C42546d() {
        }

        /* synthetic */ C42546d(byte b) {
            this();
        }

        /* renamed from: h */
        public final C5710a mo6192h(C6750i c6750i, String str) {
            AppMethodBeat.m2504i(114360);
            InputStream d = C33082aw.m54073d(c6750i, str);
            if (d != null) {
                d.mark(0);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(d, new Rect(), options);
                C38350c c38350c = new C38350c();
                c38350c.width = options.outWidth;
                c38350c.height = options.outHeight;
                c38350c.type = C41710a.m73390f(options);
                boolean e = C41710a.m73389e(options);
                try {
                    d.reset();
                } catch (IOException e2) {
                }
                c38350c.hfh = e ? C41710a.m73391fO(C41710a.m73392j(d)) : "up";
                C5046bo.m7527b(d);
                C7583c F = C5710a.m8574F(C38351e.RESOLVED, c38350c);
                AppMethodBeat.m2505o(114360);
                return F;
            }
            C5710a cW = C5710a.m8576cW(C38351e.FILE_NOT_FOUND);
            AppMethodBeat.m2505o(114360);
            return cW;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(114364);
        final C38492q c38492q = (C38492q) c2241c;
        final String optString = jSONObject.optString("src");
        if (C5046bo.isNullOrNil(optString)) {
            c38492q.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(114364);
            return;
        }
        final WeakReference weakReference = new WeakReference(c38492q);
        final int i2 = i;
        C7305d.m12298f(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(114357);
                C5710a c5710a = null;
                for (C33373b h : C42544e.hQa) {
                    c5710a = h.mo6192h(c38492q.getRuntime(), optString);
                    if (c5710a != null) {
                        break;
                    }
                }
                C5710a c5710a2 = c5710a;
                if (weakReference.get() != null && ((C38492q) weakReference.get()).isRunning()) {
                    if (c5710a2 != null) {
                        String j;
                        switch (C425452.hQd[((C38351e) c5710a2.get(0)).ordinal()]) {
                            case 1:
                                j = C42544e.this.mo73394j("fail:file not found", null);
                                break;
                            case 2:
                                HashMap hashMap = new HashMap(2);
                                hashMap.put("width", Integer.valueOf(((C38350c) c5710a2.get(1)).width));
                                hashMap.put("height", Integer.valueOf(((C38350c) c5710a2.get(1)).height));
                                hashMap.put("orientation", ((C38350c) c5710a2.get(1)).hfh);
                                hashMap.put("type", ((C38350c) c5710a2.get(1)).type);
                                j = C42544e.this.mo73394j("ok", hashMap);
                                break;
                            default:
                                j = C42544e.this.mo73394j("fail", null);
                                break;
                        }
                        ((C38492q) weakReference.get()).mo6107M(i2, j);
                        AppMethodBeat.m2505o(114357);
                        return;
                    }
                    ((C38492q) weakReference.get()).mo6107M(i2, C42544e.this.mo73394j("fail:file not found", null));
                }
                AppMethodBeat.m2505o(114357);
            }
        }, String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", new Object[]{optString}));
        AppMethodBeat.m2505o(114364);
    }

    static {
        AppMethodBeat.m2504i(114365);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new C2317a());
        linkedList.add(new C42546d());
        hQa = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.m2505o(114365);
    }
}
