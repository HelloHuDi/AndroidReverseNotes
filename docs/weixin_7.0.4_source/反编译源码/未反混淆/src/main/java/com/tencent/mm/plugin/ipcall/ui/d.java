package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public final class d {
    Context context;
    ae<String, WeakReference<Bitmap>> exy = new ae(50);
    private ak fbD = new ak(Looper.getMainLooper());
    az nAP = new az(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.d$2 */
    class AnonymousClass2 implements a {
        final /* synthetic */ String eiH;
        final /* synthetic */ ImageView mAX;
        final /* synthetic */ String val$key;

        AnonymousClass2(String str, ImageView imageView, String str2) {
            this.eiH = str;
            this.mAX = imageView;
            this.val$key = str2;
        }

        public final boolean acf() {
            AppMethodBeat.i(22017);
            Bitmap a = b.a(this.eiH, false, -1);
            if (a == null) {
                o.acd();
                a = com.tencent.mm.ah.d.qf(this.eiH);
            }
            d.a(d.this, this.mAX, this.val$key, a);
            AppMethodBeat.o(22017);
            return true;
        }

        public final boolean acg() {
            return false;
        }
    }

    public d(Context context) {
        AppMethodBeat.i(22021);
        this.context = context;
        AppMethodBeat.o(22021);
    }

    public final void a(String str, String str2, ImageView imageView) {
        AppMethodBeat.i(22022);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || imageView == null) {
            AppMethodBeat.o(22022);
            return;
        }
        final String eM = eM(str, str2);
        imageView.setTag(eM);
        if (!b(str, str2, imageView)) {
            final String str3 = str;
            final ImageView imageView2 = imageView;
            final String str4 = str2;
            this.nAP.e(new a() {
                private boolean eNb = false;

                public final boolean acf() {
                    AppMethodBeat.i(22015);
                    Bitmap aH = com.tencent.mm.plugin.ipcall.b.a.aH(d.this.context, str3);
                    if (aH != null) {
                        d.this.exy.put(eM, new WeakReference(aH));
                        this.eNb = true;
                        d.a(d.this, imageView2, eM, aH);
                    }
                    AppMethodBeat.o(22015);
                    return true;
                }

                public final boolean acg() {
                    AppMethodBeat.i(22016);
                    if (!this.eNb) {
                        d dVar = d.this;
                        String str = str3;
                        String str2 = str4;
                        dVar.nAP.e(new AnonymousClass2(str2, imageView2, d.eM(str, str2)));
                    }
                    AppMethodBeat.o(22016);
                    return true;
                }
            });
        }
        AppMethodBeat.o(22022);
    }

    public final void c(final String str, final ImageView imageView) {
        AppMethodBeat.i(22023);
        if (bo.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.o(22023);
            return;
        }
        final String Pe = Pe(str);
        imageView.setTag(Pe);
        if (!d(str, imageView)) {
            this.nAP.e(new a() {
                public final boolean acf() {
                    AppMethodBeat.i(22018);
                    d.a(d.this, imageView, Pe, com.tencent.mm.plugin.ipcall.b.a.aH(d.this.context, str));
                    AppMethodBeat.o(22018);
                    return true;
                }

                public final boolean acg() {
                    return true;
                }
            });
        }
        AppMethodBeat.o(22023);
    }

    private boolean d(String str, ImageView imageView) {
        AppMethodBeat.i(22024);
        boolean g = g(Pe(str), imageView);
        AppMethodBeat.o(22024);
        return g;
    }

    public final void e(final String str, final ImageView imageView) {
        AppMethodBeat.i(22025);
        if (bo.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.o(22025);
            return;
        }
        final String Pd = Pd(str);
        imageView.setTag(Pd);
        if (!f(str, imageView)) {
            this.nAP.e(new a() {
                public final boolean acf() {
                    AppMethodBeat.i(22019);
                    Bitmap a = b.a(str, false, -1);
                    if (a == null) {
                        o.acd();
                        a = com.tencent.mm.ah.d.qf(str);
                    }
                    d.a(d.this, imageView, Pd, a);
                    AppMethodBeat.o(22019);
                    return true;
                }

                public final boolean acg() {
                    return false;
                }
            });
        }
        AppMethodBeat.o(22025);
    }

    private boolean f(String str, ImageView imageView) {
        AppMethodBeat.i(22026);
        boolean g = g(Pd(str), imageView);
        AppMethodBeat.o(22026);
        return g;
    }

    private boolean b(String str, String str2, ImageView imageView) {
        AppMethodBeat.i(22027);
        boolean g = g(eM(str, str2), imageView);
        AppMethodBeat.o(22027);
        return g;
    }

    private boolean g(String str, ImageView imageView) {
        AppMethodBeat.i(22028);
        WeakReference weakReference = (WeakReference) this.exy.get(str);
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (!(bitmap == null || imageView.getTag() == null || !imageView.getTag().toString().equals(str))) {
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                }
                AppMethodBeat.o(22028);
                return true;
            }
        }
        AppMethodBeat.o(22028);
        return false;
    }

    private static String Pd(String str) {
        AppMethodBeat.i(22029);
        String str2 = str + "@username";
        AppMethodBeat.o(22029);
        return str2;
    }

    private static String Pe(String str) {
        AppMethodBeat.i(22030);
        String str2 = str + "@contactId";
        AppMethodBeat.o(22030);
        return str2;
    }

    public static String eM(String str, String str2) {
        AppMethodBeat.i(22031);
        String str3 = str + "@" + str2 + "@contactId@username";
        AppMethodBeat.o(22031);
        return str3;
    }

    static /* synthetic */ void a(d dVar, final ImageView imageView, final String str, final Bitmap bitmap) {
        AppMethodBeat.i(22032);
        if (bitmap != null) {
            dVar.exy.put(str, new WeakReference(bitmap));
            dVar.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22020);
                    if (!(imageView.getTag() == null || !imageView.getTag().equals(str) || bitmap == null || bitmap.isRecycled())) {
                        imageView.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.o(22020);
                }
            });
        }
        AppMethodBeat.o(22032);
    }
}
