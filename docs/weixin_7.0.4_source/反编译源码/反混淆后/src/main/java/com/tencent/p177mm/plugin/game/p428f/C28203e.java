package com.tencent.p177mm.plugin.game.p428f;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.support.p057v4.content.C0380b;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.File;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.game.f.e */
public class C28203e {
    private static final String nnA = (C1761b.eSn + "Game/Image/");
    private static C28203e nnB;
    private C1177f<String, Bitmap> neb = new C26399b(6, getClass());
    private C1177f<String, Bitmap> nkP = new C26399b(15, getClass());
    private ColorDrawable nnC = new ColorDrawable(C0380b.m652i(C4996ah.getContext(), C25738R.color.f12020pp));
    private Bitmap nnD;
    private Bitmap nnE;

    /* renamed from: com.tencent.mm.plugin.game.f.e$b */
    public static abstract class C20965b {
        /* renamed from: a */
        public abstract void mo36291a(View view, Bitmap bitmap);
    }

    /* renamed from: com.tencent.mm.plugin.game.f.e$1 */
    class C282021 implements C4931a {
        C282021() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(112326);
            if (C28203e.this.neb.mo4405aj(str)) {
                C28203e.this.neb.mo4412k(str, C46494g.m87732b(str, 1, C1338a.getDensity(null)));
            }
            AppMethodBeat.m2505o(112326);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.f.e$a */
    public static class C28207a {
        final boolean ePF;
        final boolean ePH;
        final boolean eQf;
        final int iPY;
        final boolean nnP;
        final boolean nnQ;
        final boolean nnR;
        final int nnS;

        /* renamed from: com.tencent.mm.plugin.game.f.e$a$a */
        public static class C12125a {
            public boolean ePF = true;
            public boolean ePH = true;
            public boolean eQf = false;
            int iPY = 0;
            public boolean nnP = false;
            boolean nnQ = true;
            boolean nnR = false;
            public int nnS = 0;

            public final C28207a bFI() {
                AppMethodBeat.m2504i(112334);
                C28207a c28207a = new C28207a(this, (byte) 0);
                AppMethodBeat.m2505o(112334);
                return c28207a;
            }
        }

        /* synthetic */ C28207a(C12125a c12125a, byte b) {
            this(c12125a);
        }

        private C28207a(C12125a c12125a) {
            this.ePF = c12125a.ePF;
            this.ePH = c12125a.ePH;
            this.eQf = c12125a.eQf;
            this.nnP = c12125a.nnP;
            this.nnQ = c12125a.nnQ;
            this.nnR = c12125a.nnR;
            this.nnS = c12125a.nnS;
            this.iPY = c12125a.iPY;
        }
    }

    /* renamed from: c */
    static /* synthetic */ Bitmap m44791c(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(112352);
        Bitmap b = C28203e.m44787b(bitmap, i, i2);
        AppMethodBeat.m2505o(112352);
        return b;
    }

    static {
        AppMethodBeat.m2504i(112353);
        AppMethodBeat.m2505o(112353);
    }

    public static C28203e bFH() {
        AppMethodBeat.m2504i(112335);
        if (nnB == null) {
            synchronized (C28203e.class) {
                try {
                    if (nnB == null) {
                        nnB = new C28203e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(112335);
                    }
                }
            }
        }
        C28203e c28203e = nnB;
        AppMethodBeat.m2505o(112335);
        return c28203e;
    }

    private C28203e() {
        AppMethodBeat.m2504i(112336);
        try {
            this.nnD = C4977b.m7372b(C4996ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null));
            if (!(this.nnD == null || this.nnD.isRecycled())) {
                this.nnE = C5056d.m7616a(this.nnD, false, 0.5f * ((float) this.nnD.getWidth()));
            }
        } catch (Exception e) {
            C4990ab.m7416i("MicroMsg.GameImageUtil", e.getMessage());
        }
        C34832a.bYJ().mo10116c(new C282021());
        AppMethodBeat.m2505o(112336);
    }

    /* renamed from: h */
    public final void mo46100h(ImageView imageView, String str) {
        AppMethodBeat.m2504i(112337);
        mo46099a(imageView, str, null, null);
        AppMethodBeat.m2505o(112337);
    }

    /* renamed from: a */
    public final void mo46098a(ImageView imageView, String str, C28207a c28207a) {
        AppMethodBeat.m2504i(112338);
        mo46099a(imageView, str, c28207a, null);
        AppMethodBeat.m2505o(112338);
    }

    /* renamed from: i */
    public final void mo46101i(ImageView imageView, String str) {
        AppMethodBeat.m2504i(112339);
        C12125a c12125a = new C12125a();
        c12125a.eQf = true;
        mo46099a(imageView, str, c12125a.bFI(), null);
        AppMethodBeat.m2505o(112339);
    }

    /* renamed from: a */
    public final void mo46099a(ImageView imageView, String str, C28207a c28207a, C20965b c20965b) {
        AppMethodBeat.m2504i(112340);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(112340);
            return;
        }
        if (c28207a == null) {
            c28207a = new C12125a().bFI();
        }
        if (m44790b(imageView, str, c28207a, c20965b)) {
            AppMethodBeat.m2505o(112340);
            return;
        }
        m44792c(imageView, str, c28207a, c20965b);
        AppMethodBeat.m2505o(112340);
    }

    /* renamed from: c */
    private void m44792c(final ImageView imageView, String str, final C28207a c28207a, final C20965b c20965b) {
        boolean z;
        AppMethodBeat.m2504i(112342);
        C17927a c17927a = new C17927a();
        if (c28207a.nnR) {
            z = false;
        } else {
            z = true;
        }
        c17927a.ePF = z;
        C28203e.m44783Ov(nnA);
        String str2 = nnA + C1178g.m2591x(str.getBytes());
        c17927a.ePH = c28207a.ePH;
        if (c28207a.nnR) {
            c17927a.ePH = false;
            C40433a.ajj(str2);
        } else {
            c17927a.ePJ = str2;
        }
        c17927a.eQf = c28207a.eQf;
        c17927a.ePZ = false;
        m44785a(imageView, c28207a);
        C32291o.ahp().mo43767a(str, null, c17927a.ahG(), new C9014g() {
            /* renamed from: sH */
            public final void mo7596sH(String str) {
                AppMethodBeat.m2504i(112328);
                C4990ab.m7410d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(112328);
            }

            /* renamed from: a */
            public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                return null;
            }

            /* renamed from: b */
            public final void mo7595b(String str, View view, C37477b c37477b) {
                AppMethodBeat.m2504i(112329);
                C4990ab.m7410d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(str)));
                if (!(c37477b == null || c37477b.bitmap == null)) {
                    Object obj = c37477b.bitmap;
                    if (c28207a.nnP) {
                        obj = C28203e.m44782N(obj);
                    }
                    if (c28207a.iPY != 0) {
                        obj = C5056d.m7616a((Bitmap) obj, true, (float) c28207a.iPY);
                    }
                    if (c28207a.ePF) {
                        C28203e.this.nkP.mo4412k(str, obj);
                    }
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(112327);
                            if (imageView != null) {
                                imageView.setImageBitmap(obj);
                            }
                            AppMethodBeat.m2505o(112327);
                        }
                    });
                    if (c20965b != null) {
                        c20965b.mo36291a(view, obj);
                    }
                }
                AppMethodBeat.m2505o(112329);
            }
        });
        AppMethodBeat.m2505o(112342);
    }

    /* renamed from: a */
    private void m44785a(ImageView imageView, C28207a c28207a) {
        AppMethodBeat.m2504i(112343);
        if (imageView != null && c28207a.nnQ) {
            if (c28207a.nnS == 0) {
                imageView.setImageDrawable(this.nnC);
                AppMethodBeat.m2505o(112343);
                return;
            }
            imageView.setImageResource(c28207a.nnS);
        }
        AppMethodBeat.m2505o(112343);
    }

    /* renamed from: a */
    public final void mo46097a(ImageView imageView, String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(112344);
        m44789b(imageView, str, i, i2, i3);
        AppMethodBeat.m2505o(112344);
    }

    /* renamed from: b */
    private void m44789b(ImageView imageView, String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(112345);
        final ImageView imageView2 = imageView;
        final int i4 = i2;
        final int i5 = i;
        final int i6 = i3;
        m44786a(str, i, i2, new C20965b() {
            /* renamed from: a */
            public final void mo36291a(View view, final Bitmap bitmap) {
                AppMethodBeat.m2504i(112331);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(112330);
                            imageView2.setImageBitmap(bitmap);
                            LayoutParams layoutParams = imageView2.getLayoutParams();
                            float f = ((float) i4) / ((float) i5);
                            layoutParams.width = i6;
                            layoutParams.height = (int) (f * ((float) i6));
                            imageView2.setLayoutParams(layoutParams);
                            imageView2.setScaleType(ScaleType.FIT_XY);
                            AppMethodBeat.m2505o(112330);
                        }
                    });
                }
                AppMethodBeat.m2505o(112331);
            }
        });
        AppMethodBeat.m2505o(112345);
    }

    /* renamed from: a */
    private void m44786a(String str, int i, int i2, C20965b c20965b) {
        AppMethodBeat.m2504i(112346);
        C4990ab.m7410d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
        Bitmap bitmap = (Bitmap) this.nkP.mo4404ai(str);
        if (bitmap == null || bitmap.isRecycled()) {
            final C20965b c20965b2 = c20965b;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            m44792c(null, str, new C12125a().bFI(), new C20965b() {
                final /* synthetic */ int nnN = 0;

                /* renamed from: a */
                public final void mo36291a(View view, Bitmap bitmap) {
                    AppMethodBeat.m2504i(112332);
                    C4990ab.m7410d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        Object c = C28203e.m44791c(bitmap, i3, i4);
                        C4990ab.m7410d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
                        if (this.nnN != 0) {
                            c = C5056d.m7616a((Bitmap) c, true, (float) this.nnN);
                        }
                        C28203e.this.nkP.mo4412k(str2, c);
                        if (c20965b2 != null) {
                            c20965b2.mo36291a(view, c);
                        }
                    }
                    AppMethodBeat.m2505o(112332);
                }
            });
            AppMethodBeat.m2505o(112346);
            return;
        }
        c20965b.mo36291a(null, bitmap);
        AppMethodBeat.m2505o(112346);
    }

    /* renamed from: b */
    private static Bitmap m44787b(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(112347);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i && height == i2) {
            AppMethodBeat.m2505o(112347);
            return bitmap;
        }
        int i3;
        Bitmap createBitmap;
        int i4;
        float f = ((float) height) / ((float) i2);
        float f2 = ((float) width) / ((float) i);
        if (f < f2) {
            i3 = (int) (f * ((float) i));
            try {
                createBitmap = Bitmap.createBitmap(bitmap, (width - i3) / 2, 0, i3, height);
                i4 = height;
            } catch (IllegalArgumentException e) {
                AppMethodBeat.m2505o(112347);
                return bitmap;
            }
        }
        i4 = (int) (((float) i2) * f2);
        createBitmap = Bitmap.createBitmap(bitmap, 0, (height - i4) / 2, width, i4);
        i3 = width;
        C4990ab.m7417i("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.m2505o(112347);
        return createBitmap;
    }

    /* renamed from: a */
    public final void mo46096a(ImageView imageView, final String str, final float f) {
        AppMethodBeat.m2504i(112349);
        if (imageView == null || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(112349);
            return;
        }
        Bitmap bitmap;
        if (this.neb.mo4405aj(str)) {
            bitmap = (Bitmap) this.neb.mo4404ai(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                imageView.setImageBitmap(bitmap);
                AppMethodBeat.m2505o(112349);
                return;
            }
        }
        bitmap = C46494g.m87732b(str, 1, f);
        if (bitmap == null || bitmap.isRecycled()) {
            imageView.setImageResource(C25738R.drawable.af7);
            final WeakReference weakReference = new WeakReference(imageView);
            C34832a.bYJ().mo10116c(new C4931a() {
                /* renamed from: a */
                public final void mo5248a(String str, C4935m c4935m) {
                    AppMethodBeat.m2504i(112333);
                    if (str.equals(str)) {
                        Bitmap b = C46494g.m87732b(str, 1, f);
                        if (b != null) {
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((ImageView) weakReference.get()).setImageBitmap(b);
                            }
                            C28203e.this.neb.put(str, b);
                            C34832a.bYJ().mo10117d(this);
                        }
                    }
                    AppMethodBeat.m2505o(112333);
                }
            });
            AppMethodBeat.m2505o(112349);
            return;
        }
        imageView.setImageBitmap(bitmap);
        this.neb.put(str, bitmap);
        AppMethodBeat.m2505o(112349);
    }

    /* renamed from: Ov */
    private static boolean m44783Ov(String str) {
        AppMethodBeat.m2504i(112350);
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdir()) {
                    file2.renameTo(parentFile);
                } else {
                    C4990ab.m7413e("MicroMsg.GameImageUtil", "mkdir error, %s", parentFile.getAbsolutePath());
                    AppMethodBeat.m2505o(112350);
                    return false;
                }
            }
            if (!(file.mkdir() && file.isDirectory())) {
                C4990ab.m7413e("MicroMsg.GameImageUtil", "mkdir error. %s", str);
                AppMethodBeat.m2505o(112350);
                return false;
            }
        }
        AppMethodBeat.m2505o(112350);
        return true;
    }

    /* renamed from: b */
    private boolean m44790b(ImageView imageView, String str, C28207a c28207a, C20965b c20965b) {
        AppMethodBeat.m2504i(112341);
        if (!c28207a.ePF || c28207a.nnR) {
            AppMethodBeat.m2505o(112341);
            return false;
        } else if (this.nkP.mo4405aj(str)) {
            Bitmap bitmap = (Bitmap) this.nkP.mo4404ai(str);
            if (bitmap == null || bitmap.isRecycled()) {
                AppMethodBeat.m2505o(112341);
                return false;
            }
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            if (c20965b != null) {
                c20965b.mo36291a(imageView, bitmap);
            }
            AppMethodBeat.m2505o(112341);
            return true;
        } else {
            AppMethodBeat.m2505o(112341);
            return false;
        }
    }

    /* renamed from: j */
    public final Bitmap mo46102j(ImageView imageView, String str) {
        AppMethodBeat.m2504i(112348);
        Bitmap a = C41730b.m73490a(str, false, -1);
        if (a == null || a.isRecycled()) {
            if (this.nnD == null || this.nnD.isRecycled()) {
                try {
                    this.nnD = C4977b.m7372b(C4996ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null));
                } catch (Exception e) {
                }
            }
            if (!(this.nnD == null || this.nnD.isRecycled() || imageView == null)) {
                imageView.setImageBitmap(this.nnD);
            }
            a = this.nnD;
            AppMethodBeat.m2505o(112348);
            return a;
        }
        if (imageView != null) {
            imageView.setImageBitmap(a);
        }
        AppMethodBeat.m2505o(112348);
        return a;
    }

    /* renamed from: N */
    static /* synthetic */ Bitmap m44782N(Bitmap bitmap) {
        AppMethodBeat.m2504i(112351);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(112351);
            return bitmap;
        }
        int width = bitmap.getHeight() > bitmap.getWidth() ? bitmap.getWidth() : bitmap.getHeight();
        bitmap = C5056d.m7649b(bitmap, width, width, false);
        AppMethodBeat.m2505o(112351);
        return bitmap;
    }
}
