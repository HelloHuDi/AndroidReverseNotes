package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class e extends com.tencent.mm.plugin.appbrand.jsapi.a<q> {
    private static final int CTRL_INDEX = 120;
    private static final String NAME = "getImageInfo";
    private static final Collection<b> hQa;

    static final class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final com.tencent.mm.vending.j.a h(i iVar, String str) {
            AppMethodBeat.i(114359);
            File yg = iVar.asE().yg(str);
            if (yg == null) {
                AppMethodBeat.o(114359);
                return null;
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(yg.getAbsolutePath(), options);
            c cVar = new c();
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            cVar.type = com.tencent.luggage.e.a.a.f(options);
            cVar.hfh = com.tencent.luggage.e.a.a.e(options) ? com.tencent.luggage.e.a.a.fO(com.tencent.luggage.e.a.a.bJ(yg.getAbsolutePath())) : "up";
            com.tencent.mm.vending.j.a F = com.tencent.mm.vending.j.a.F(e.RESOLVED, cVar);
            AppMethodBeat.o(114359);
            return F;
        }
    }

    interface b {
        com.tencent.mm.vending.j.a h(i iVar, String str);
    }

    static final class c {
        public int height;
        public String hfh;
        public String type;
        public int width;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    enum e {
        FILE_NOT_FOUND,
        UNKNOWN_FAIL,
        RESOLVED;

        static {
            AppMethodBeat.o(114363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.e$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] hQd = new int[e.values().length];

        static {
            AppMethodBeat.i(114358);
            try {
                hQd[e.FILE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hQd[e.RESOLVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hQd[e.UNKNOWN_FAIL.ordinal()] = 3;
                AppMethodBeat.o(114358);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(114358);
            }
        }
    }

    static final class d implements b {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final com.tencent.mm.vending.j.a h(i iVar, String str) {
            AppMethodBeat.i(114360);
            InputStream d = aw.d(iVar, str);
            if (d != null) {
                d.mark(0);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(d, new Rect(), options);
                c cVar = new c();
                cVar.width = options.outWidth;
                cVar.height = options.outHeight;
                cVar.type = com.tencent.luggage.e.a.a.f(options);
                boolean e = com.tencent.luggage.e.a.a.e(options);
                try {
                    d.reset();
                } catch (IOException e2) {
                }
                cVar.hfh = e ? com.tencent.luggage.e.a.a.fO(com.tencent.luggage.e.a.a.j(d)) : "up";
                bo.b(d);
                com.tencent.mm.vending.j.c F = com.tencent.mm.vending.j.a.F(e.RESOLVED, cVar);
                AppMethodBeat.o(114360);
                return F;
            }
            com.tencent.mm.vending.j.a cW = com.tencent.mm.vending.j.a.cW(e.FILE_NOT_FOUND);
            AppMethodBeat.o(114360);
            return cW;
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(114364);
        final q qVar = (q) cVar;
        final String optString = jSONObject.optString("src");
        if (bo.isNullOrNil(optString)) {
            qVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(114364);
            return;
        }
        final WeakReference weakReference = new WeakReference(qVar);
        final int i2 = i;
        com.tencent.mm.sdk.g.d.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114357);
                com.tencent.mm.vending.j.a aVar = null;
                for (b h : e.hQa) {
                    aVar = h.h(qVar.getRuntime(), optString);
                    if (aVar != null) {
                        break;
                    }
                }
                com.tencent.mm.vending.j.a aVar2 = aVar;
                if (weakReference.get() != null && ((q) weakReference.get()).isRunning()) {
                    if (aVar2 != null) {
                        String j;
                        switch (AnonymousClass2.hQd[((e) aVar2.get(0)).ordinal()]) {
                            case 1:
                                j = e.this.j("fail:file not found", null);
                                break;
                            case 2:
                                HashMap hashMap = new HashMap(2);
                                hashMap.put("width", Integer.valueOf(((c) aVar2.get(1)).width));
                                hashMap.put("height", Integer.valueOf(((c) aVar2.get(1)).height));
                                hashMap.put("orientation", ((c) aVar2.get(1)).hfh);
                                hashMap.put("type", ((c) aVar2.get(1)).type);
                                j = e.this.j("ok", hashMap);
                                break;
                            default:
                                j = e.this.j("fail", null);
                                break;
                        }
                        ((q) weakReference.get()).M(i2, j);
                        AppMethodBeat.o(114357);
                        return;
                    }
                    ((q) weakReference.get()).M(i2, e.this.j("fail:file not found", null));
                }
                AppMethodBeat.o(114357);
            }
        }, String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", new Object[]{optString}));
        AppMethodBeat.o(114364);
    }

    static {
        AppMethodBeat.i(114365);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new a());
        linkedList.add(new d());
        hQa = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.o(114365);
    }
}
