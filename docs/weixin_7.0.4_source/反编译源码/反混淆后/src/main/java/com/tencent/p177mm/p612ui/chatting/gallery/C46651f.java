package com.tencent.p177mm.p612ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.davemorrissey.labs.subscaleview.view.C31985a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1174a;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p612ui.base.WxImageView;
import com.tencent.p177mm.p612ui.chatting.gallery.C15656g.C5340a;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.gallery.f */
final class C46651f implements OnPageChangeListener {
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    private static long yVq = 0;
    private int aaF = -1;
    private C7306ak fbD = new C7306ak();
    private C23498az fwL = new C23498az(1, "chatting-image-gallery-lazy-loader");
    SparseArray<WeakReference<View>> mQG = new SparseArray();
    HashMap<String, Integer> mQH = new HashMap();
    SparseArray<String> mQI = new SparseArray();
    SparseArray<Bitmap> mQJ = new SparseArray();
    protected C1177f<String, Bitmap> mQK = new C26399b(5, new C361752(), getClass());
    protected SparseIntArray mQL = new SparseIntArray();
    private LinkedList<String> mQM = new LinkedList();
    private boolean mQO = false;
    private int mScrollState = 0;
    SparseArray<String> yVn = new SparseArray();
    C30516a yVo;
    protected C1177f<String, Bitmap> yVp = new C26399b(400, new C361741(), getClass());
    private LinkedList<Integer> yVr = new LinkedList();
    private LinkedList<Integer> yVs = new LinkedList();
    Bitmap yVt;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.f$a */
    public interface C30516a {
        /* renamed from: OY */
        Bitmap mo48936OY(int i);

        /* renamed from: a */
        void mo48937a(WxImageView wxImageView, String str, C31985a c31985a);

        /* renamed from: b */
        void mo48938b(View view, Bitmap bitmap);

        Bitmap loadImage(String str);
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.f$1 */
    class C361741 implements C1175b<String, Bitmap> {
        C361741() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(32136);
            Bitmap bitmap = (Bitmap) obj2;
            if (!(bitmap == null || bitmap.isRecycled())) {
                C4990ab.m7417i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.m2505o(32136);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.f$2 */
    class C361752 implements C1175b<String, Bitmap> {
        C361752() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(32137);
            Bitmap bitmap = (Bitmap) obj2;
            C4990ab.m7417i("MicroMsg.ImageGalleryLazyLoader", "preRemoveCallback %s", (String) obj);
            if (!(bitmap == null || bitmap.isRecycled() || C46651f.this.mQL.indexOfKey(bitmap.hashCode()) >= 0)) {
                if (C46651f.this.yVr.contains(Integer.valueOf(bitmap.hashCode()))) {
                    C46651f.this.yVr.remove(Integer.valueOf(bitmap.hashCode()));
                    AppMethodBeat.m2505o(32137);
                    return;
                }
                C4990ab.m7417i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.m2505o(32137);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.f$3 */
    class C361763 implements C1174a<String, Bitmap> {
        C361763() {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.f$4 */
    class C361774 implements C1174a<String, Bitmap> {
        C361774() {
        }
    }

    /* renamed from: f */
    static /* synthetic */ boolean m88322f(C46651f c46651f) {
        AppMethodBeat.m2504i(32158);
        boolean bCI = c46651f.bCI();
        AppMethodBeat.m2505o(32158);
        return bCI;
    }

    /* renamed from: h */
    static /* synthetic */ void m88324h(C46651f c46651f) {
        AppMethodBeat.m2504i(32160);
        c46651f.m88313Dp();
        AppMethodBeat.m2505o(32160);
    }

    /* renamed from: aW */
    public final void mo74888aW(Map<String, Bitmap> map) {
        AppMethodBeat.m2504i(32144);
        for (String str : map.keySet()) {
            Bitmap bitmap = (Bitmap) map.get(str);
            if (bitmap != null) {
                this.mQK.put(str, bitmap);
                this.yVr.push(Integer.valueOf(bitmap.hashCode()));
                C4990ab.m7417i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", str, Integer.valueOf(bitmap.hashCode()));
            } else {
                C4990ab.m7412e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
            }
        }
        AppMethodBeat.m2505o(32144);
    }

    public C46651f(C30516a c30516a) {
        AppMethodBeat.m2504i(32145);
        this.yVo = c30516a;
        AppMethodBeat.m2505o(32145);
    }

    /* Access modifiers changed, original: final */
    public final void bCH() {
        AppMethodBeat.m2504i(32146);
        this.yVp.mo4403a(new C361763());
        this.mQK.mo4403a(new C361774());
        AppMethodBeat.m2505o(32146);
    }

    public final void onPageScrollStateChanged(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(32147);
        this.mScrollState = i;
        if (bCI()) {
            int[] iArr = new int[this.mQJ.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.mQJ.keyAt(i3);
            }
            while (i2 < iArr.length) {
                int i4 = iArr[i2];
                m88315a(i4, (Bitmap) this.mQJ.get(i4));
                i2++;
            }
        }
        AppMethodBeat.m2505o(32147);
    }

    public final void onPageSelected(int i) {
        AppMethodBeat.m2504i(32148);
        if (((C40780e) this.yVo).yTG.yTJ.prepared) {
            if (this.aaF == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 != 0) {
                        if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                            break;
                        }
                        if (i + i2 <= i + 3) {
                            m88330wB(i + i2);
                        }
                        if (i - i2 >= Math.max(i - 3, 0)) {
                            m88330wB(i - i2);
                        }
                    } else {
                        m88330wB(i);
                    }
                    i2++;
                }
            } else if (this.aaF > i) {
                m88330wB(Math.max(i - 3, 0));
            } else if (this.aaF < i) {
                m88330wB(i + 3);
            }
            this.aaF = i;
            C40780e c40780e = (C40780e) this.yVo;
            if (c40780e != null) {
                if (c40780e.yTG.mo64332wx(this.aaF) != null) {
                    this.yVt = null;
                    AppMethodBeat.m2505o(32148);
                    return;
                }
                WxImageView wy = c40780e.yTG.mo64333wy(this.aaF);
                if (wy != null) {
                    this.yVt = wy.getFullImageBitmap();
                }
            }
            AppMethodBeat.m2505o(32148);
            return;
        }
        AppMethodBeat.m2505o(32148);
    }

    /* renamed from: wB */
    private void m88330wB(final int i) {
        AppMethodBeat.m2504i(32149);
        if (this.yVp.mo4405aj(String.valueOf(i))) {
            AppMethodBeat.m2505o(32149);
            return;
        }
        C9638aw.m17180RS().mo10310m(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(32139);
                if (C46651f.this.yVo == null) {
                    C4990ab.m7412e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
                    AppMethodBeat.m2505o(32139);
                    return;
                }
                final Bitmap OY = C46651f.this.yVo.mo48936OY(i);
                if (OY == null) {
                    AppMethodBeat.m2505o(32139);
                    return;
                }
                C46651f.this.fbD.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(32138);
                        C46651f.this.yVp.put(i, OY);
                        AppMethodBeat.m2505o(32138);
                    }
                });
                AppMethodBeat.m2505o(32139);
            }
        }, 300);
        AppMethodBeat.m2505o(32149);
    }

    private boolean bCI() {
        return this.mScrollState == 0;
    }

    /* renamed from: wA */
    private void m88329wA(int i) {
        AppMethodBeat.m2504i(32150);
        if (this.mQI.get(i) != null) {
            String str = (String) this.mQI.get(i);
            this.mQG.remove(i);
            this.mQI.remove(i);
            this.mQH.remove(str);
            this.mQJ.remove(i);
        }
        AppMethodBeat.m2505o(32150);
    }

    /* renamed from: a */
    private void m88316a(int i, View view, String str) {
        AppMethodBeat.m2504i(32151);
        this.mQH.put(str, Integer.valueOf(i));
        this.mQI.put(i, str);
        this.mQG.put(i, new WeakReference(view));
        AppMethodBeat.m2505o(32151);
    }

    /* renamed from: a */
    private void m88315a(int i, Bitmap bitmap) {
        AppMethodBeat.m2504i(32152);
        if (this.mQG.get(i) == null) {
            AppMethodBeat.m2505o(32152);
            return;
        }
        View view = (View) ((WeakReference) this.mQG.get(i)).get();
        this.mQI.get(i);
        this.yVo.mo48938b(view, bitmap);
        m88329wA(i);
        AppMethodBeat.m2505o(32152);
    }

    /* renamed from: c */
    public final boolean mo74892c(ImageView imageView, int i) {
        AppMethodBeat.m2504i(32153);
        C4990ab.m7417i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", Integer.valueOf(i));
        Bitmap bitmap = (Bitmap) this.yVp.mo4404ai(String.valueOf(i));
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(32153);
            return false;
        }
        this.yVo.mo48938b(imageView, bitmap);
        AppMethodBeat.m2505o(32153);
        return true;
    }

    /* renamed from: b */
    public final void mo74889b(View view, String str, String str2, int i) {
        AppMethodBeat.m2504i(32154);
        if (this.mQM.contains(str)) {
            AppMethodBeat.m2505o(32154);
            return;
        }
        int hashCode = view.hashCode();
        m88329wA(hashCode);
        m88316a(hashCode, view, str);
        if (view instanceof WxImageView) {
            this.yVn.remove(hashCode);
            this.yVn.put(hashCode, str2);
        }
        this.mQM.add(str);
        this.yVs.add(Integer.valueOf(i));
        m88313Dp();
        AppMethodBeat.m2505o(32154);
    }

    /* renamed from: g */
    public final void mo74893g(ImageView imageView, String str, int i) {
        AppMethodBeat.m2504i(32155);
        if (this.mQM.contains(str)) {
            AppMethodBeat.m2505o(32155);
            return;
        }
        int hashCode = imageView.hashCode();
        m88329wA(hashCode);
        m88316a(hashCode, (View) imageView, str);
        this.mQM.add(str);
        this.yVs.add(Integer.valueOf(i));
        m88313Dp();
        AppMethodBeat.m2505o(32155);
    }

    /* renamed from: Dp */
    private void m88313Dp() {
        AppMethodBeat.m2504i(32156);
        if (this.mQO) {
            AppMethodBeat.m2505o(32156);
        } else if (this.mQM.size() == 0) {
            AppMethodBeat.m2505o(32156);
        } else {
            final String str = (String) this.mQM.removeLast();
            final int intValue = ((Integer) this.yVs.removeLast()).intValue();
            if (this.mQH.containsKey(str)) {
                this.mQO = true;
                this.fwL.mo39163e(new C23499a() {
                    private Bitmap mQQ = null;
                    private boolean yVx = false;

                    public final boolean acg() {
                        AppMethodBeat.m2504i(32141);
                        C46651f.this.mQO = false;
                        if (!this.yVx) {
                            int intValue;
                            if (C46651f.this.mQH.containsKey(str)) {
                                intValue = ((Integer) C46651f.this.mQH.get(str)).intValue();
                                if (C46651f.m88322f(C46651f.this)) {
                                    C46651f.m88317a(C46651f.this, intValue, this.mQQ);
                                } else {
                                    C46651f.this.mQJ.put(intValue, this.mQQ);
                                }
                            }
                            C46651f.this.mo74894u(str, this.mQQ);
                            C46651f.this.mo74891c(intValue, this.mQQ);
                            String str = "MicroMsg.ImageGalleryLazyLoader";
                            String str2 = "bmp size : %s";
                            Object[] objArr = new Object[1];
                            Bitmap bitmap = this.mQQ;
                            if (bitmap == null || bitmap.isRecycled()) {
                                intValue = 0;
                            } else {
                                if (VERSION.SDK_INT >= 12) {
                                    intValue = bitmap.getByteCount();
                                } else {
                                    intValue = bitmap.getRowBytes() * bitmap.getHeight();
                                }
                                if (intValue < 0) {
                                    IllegalStateException illegalStateException = new IllegalStateException("Negative size: ".concat(String.valueOf(bitmap)));
                                    AppMethodBeat.m2505o(32141);
                                    throw illegalStateException;
                                }
                            }
                            objArr[0] = Integer.valueOf(intValue);
                            C4990ab.m7417i(str, str2, objArr);
                            this.mQQ = null;
                        }
                        C46651f.m88324h(C46651f.this);
                        AppMethodBeat.m2505o(32141);
                        return false;
                    }

                    public final boolean acf() {
                        AppMethodBeat.m2504i(32142);
                        if (C46651f.this.yVo == null || TextUtils.isEmpty(str)) {
                            AppMethodBeat.m2505o(32142);
                            return false;
                        }
                        try {
                            if (C46651f.this.mQH.containsKey(str)) {
                                int intValue = ((Integer) C46651f.this.mQH.get(str)).intValue();
                                WeakReference weakReference = (WeakReference) C46651f.this.mQG.get(intValue);
                                if (weakReference != null) {
                                    final View view = (View) weakReference.get();
                                    if (view != null && (view instanceof WxImageView)) {
                                        final String str = (String) C46651f.this.yVn.get(intValue);
                                        this.yVx = true;
                                        C46651f.this.fbD.post(new Runnable() {
                                            public final void run() {
                                                boolean z = true;
                                                AppMethodBeat.m2504i(32140);
                                                C156546 c156546 = C156546.this;
                                                WxImageView wxImageView = (WxImageView) view;
                                                String str = str;
                                                String str2 = str;
                                                int i = intValue;
                                                if (!(C46651f.this.yVo == null || wxImageView == null || C5046bo.isNullOrNil(str))) {
                                                    C31985a af;
                                                    String str3 = "MicroMsg.ImageGalleryLazyLoader";
                                                    String str4 = "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b";
                                                    Object[] objArr = new Object[4];
                                                    objArr[0] = Integer.valueOf(i);
                                                    objArr[1] = Integer.valueOf(C46651f.this.aaF);
                                                    objArr[2] = Boolean.valueOf(C46651f.this.yVt == null);
                                                    if (C46651f.this.yVt == null || !C46651f.this.yVt.isRecycled()) {
                                                        z = false;
                                                    }
                                                    objArr[3] = Boolean.valueOf(z);
                                                    C4990ab.m7417i(str3, str4, objArr);
                                                    if (i != C46651f.this.aaF || C46651f.this.yVt == null || C46651f.this.yVt.isRecycled()) {
                                                        af = !C5046bo.isNullOrNil(str2) ? C31985a.m51974af(str2) : null;
                                                    } else {
                                                        Bitmap l = C46651f.this.yVt;
                                                        if (l == null) {
                                                            NullPointerException nullPointerException = new NullPointerException("Bitmap must not be null");
                                                            AppMethodBeat.m2505o(32140);
                                                            throw nullPointerException;
                                                        }
                                                        af = new C31985a(l);
                                                    }
                                                    C46651f.this.yVo.mo48937a(wxImageView, str, af);
                                                }
                                                AppMethodBeat.m2505o(32140);
                                            }
                                        });
                                        AppMethodBeat.m2505o(32142);
                                        return true;
                                    }
                                }
                            }
                            this.mQQ = C46651f.this.yVo.loadImage(str);
                            AppMethodBeat.m2505o(32142);
                            return true;
                        } catch (Exception e) {
                            C4990ab.m7421w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", e.getMessage());
                            this.mQQ = null;
                            AppMethodBeat.m2505o(32142);
                            return false;
                        }
                    }
                });
                AppMethodBeat.m2505o(32156);
                return;
            }
            AppMethodBeat.m2505o(32156);
        }
    }

    /* renamed from: c */
    public final void mo74891c(int i, Bitmap bitmap) {
        AppMethodBeat.m2504i(32157);
        if (i == this.aaF || this.aaF == -1) {
            C4990ab.m7417i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", Integer.valueOf(i));
            this.yVt = bitmap;
        }
        AppMethodBeat.m2505o(32157);
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: u */
    public final void mo74894u(String str, Bitmap bitmap) {
        int i;
        AppMethodBeat.m2504i(32143);
        if (bitmap != null) {
            long width = ((long) bitmap.getWidth()) * ((long) bitmap.getHeight());
            if (mScreenHeight == 0 || mScreenWidth == 0) {
                mScreenWidth = C4996ah.getContext().getResources().getDisplayMetrics().widthPixels;
                mScreenHeight = C4996ah.getContext().getResources().getDisplayMetrics().heightPixels;
                yVq = ((long) mScreenWidth) * yVq;
            }
            if (width > yVq * 2) {
                i = 1;
                if (i == 0) {
                    C4990ab.m7416i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
                    AppMethodBeat.m2505o(32143);
                    return;
                }
                this.mQK.mo4412k(str, bitmap);
                if (C5340a.yVD.mQK.mo4405aj(str)) {
                    C4990ab.m7416i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                    try {
                        C5340a.yVD.mQK.mo4412k(str, bitmap);
                        AppMethodBeat.m2505o(32143);
                        return;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", e, "update preload cache failed", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(32143);
                return;
            }
        }
        i = 0;
        if (i == 0) {
        }
    }
}
