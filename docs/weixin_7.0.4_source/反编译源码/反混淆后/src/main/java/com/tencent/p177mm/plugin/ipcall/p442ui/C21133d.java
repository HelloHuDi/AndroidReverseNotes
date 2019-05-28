package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.d */
public final class C21133d {
    Context context;
    C4993ae<String, WeakReference<Bitmap>> exy = new C4993ae(50);
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    C23498az nAP = new C23498az(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.d$2 */
    class C211342 implements C23499a {
        final /* synthetic */ String eiH;
        final /* synthetic */ ImageView mAX;
        final /* synthetic */ String val$key;

        C211342(String str, ImageView imageView, String str2) {
            this.eiH = str;
            this.mAX = imageView;
            this.val$key = str2;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(22017);
            Bitmap a = C41730b.m73490a(this.eiH, false, -1);
            if (a == null) {
                C17884o.acd();
                a = C41732d.m73525qf(this.eiH);
            }
            C21133d.m32468a(C21133d.this, this.mAX, this.val$key, a);
            AppMethodBeat.m2505o(22017);
            return true;
        }

        public final boolean acg() {
            return false;
        }
    }

    public C21133d(Context context) {
        AppMethodBeat.m2504i(22021);
        this.context = context;
        AppMethodBeat.m2505o(22021);
    }

    /* renamed from: a */
    public final void mo36453a(String str, String str2, ImageView imageView) {
        AppMethodBeat.m2504i(22022);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || imageView == null) {
            AppMethodBeat.m2505o(22022);
            return;
        }
        final String eM = C21133d.m32471eM(str, str2);
        imageView.setTag(eM);
        if (!m32469b(str, str2, imageView)) {
            final String str3 = str;
            final ImageView imageView2 = imageView;
            final String str4 = str2;
            this.nAP.mo39163e(new C23499a() {
                private boolean eNb = false;

                public final boolean acf() {
                    AppMethodBeat.m2504i(22015);
                    Bitmap aH = C46041a.m85643aH(C21133d.this.context, str3);
                    if (aH != null) {
                        C21133d.this.exy.put(eM, new WeakReference(aH));
                        this.eNb = true;
                        C21133d.m32468a(C21133d.this, imageView2, eM, aH);
                    }
                    AppMethodBeat.m2505o(22015);
                    return true;
                }

                public final boolean acg() {
                    AppMethodBeat.m2504i(22016);
                    if (!this.eNb) {
                        C21133d c21133d = C21133d.this;
                        String str = str3;
                        String str2 = str4;
                        c21133d.nAP.mo39163e(new C211342(str2, imageView2, C21133d.m32471eM(str, str2)));
                    }
                    AppMethodBeat.m2505o(22016);
                    return true;
                }
            });
        }
        AppMethodBeat.m2505o(22022);
    }

    /* renamed from: c */
    public final void mo36454c(final String str, final ImageView imageView) {
        AppMethodBeat.m2504i(22023);
        if (C5046bo.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.m2505o(22023);
            return;
        }
        final String Pe = C21133d.m32467Pe(str);
        imageView.setTag(Pe);
        if (!m32470d(str, imageView)) {
            this.nAP.mo39163e(new C23499a() {
                public final boolean acf() {
                    AppMethodBeat.m2504i(22018);
                    C21133d.m32468a(C21133d.this, imageView, Pe, C46041a.m85643aH(C21133d.this.context, str));
                    AppMethodBeat.m2505o(22018);
                    return true;
                }

                public final boolean acg() {
                    return true;
                }
            });
        }
        AppMethodBeat.m2505o(22023);
    }

    /* renamed from: d */
    private boolean m32470d(String str, ImageView imageView) {
        AppMethodBeat.m2504i(22024);
        boolean g = m32473g(C21133d.m32467Pe(str), imageView);
        AppMethodBeat.m2505o(22024);
        return g;
    }

    /* renamed from: e */
    public final void mo36455e(final String str, final ImageView imageView) {
        AppMethodBeat.m2504i(22025);
        if (C5046bo.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.m2505o(22025);
            return;
        }
        final String Pd = C21133d.m32466Pd(str);
        imageView.setTag(Pd);
        if (!m32472f(str, imageView)) {
            this.nAP.mo39163e(new C23499a() {
                public final boolean acf() {
                    AppMethodBeat.m2504i(22019);
                    Bitmap a = C41730b.m73490a(str, false, -1);
                    if (a == null) {
                        C17884o.acd();
                        a = C41732d.m73525qf(str);
                    }
                    C21133d.m32468a(C21133d.this, imageView, Pd, a);
                    AppMethodBeat.m2505o(22019);
                    return true;
                }

                public final boolean acg() {
                    return false;
                }
            });
        }
        AppMethodBeat.m2505o(22025);
    }

    /* renamed from: f */
    private boolean m32472f(String str, ImageView imageView) {
        AppMethodBeat.m2504i(22026);
        boolean g = m32473g(C21133d.m32466Pd(str), imageView);
        AppMethodBeat.m2505o(22026);
        return g;
    }

    /* renamed from: b */
    private boolean m32469b(String str, String str2, ImageView imageView) {
        AppMethodBeat.m2504i(22027);
        boolean g = m32473g(C21133d.m32471eM(str, str2), imageView);
        AppMethodBeat.m2505o(22027);
        return g;
    }

    /* renamed from: g */
    private boolean m32473g(String str, ImageView imageView) {
        AppMethodBeat.m2504i(22028);
        WeakReference weakReference = (WeakReference) this.exy.get(str);
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (!(bitmap == null || imageView.getTag() == null || !imageView.getTag().toString().equals(str))) {
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                }
                AppMethodBeat.m2505o(22028);
                return true;
            }
        }
        AppMethodBeat.m2505o(22028);
        return false;
    }

    /* renamed from: Pd */
    private static String m32466Pd(String str) {
        AppMethodBeat.m2504i(22029);
        String str2 = str + "@username";
        AppMethodBeat.m2505o(22029);
        return str2;
    }

    /* renamed from: Pe */
    private static String m32467Pe(String str) {
        AppMethodBeat.m2504i(22030);
        String str2 = str + "@contactId";
        AppMethodBeat.m2505o(22030);
        return str2;
    }

    /* renamed from: eM */
    public static String m32471eM(String str, String str2) {
        AppMethodBeat.m2504i(22031);
        String str3 = str + "@" + str2 + "@contactId@username";
        AppMethodBeat.m2505o(22031);
        return str3;
    }

    /* renamed from: a */
    static /* synthetic */ void m32468a(C21133d c21133d, final ImageView imageView, final String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(22032);
        if (bitmap != null) {
            c21133d.exy.put(str, new WeakReference(bitmap));
            c21133d.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(22020);
                    if (!(imageView.getTag() == null || !imageView.getTag().equals(str) || bitmap == null || bitmap.isRecycled())) {
                        imageView.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.m2505o(22020);
                }
            });
        }
        AppMethodBeat.m2505o(22032);
    }
}
