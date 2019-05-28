package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.WxImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class f implements OnPageChangeListener {
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    private static long yVq = 0;
    private int aaF = -1;
    private ak fbD = new ak();
    private az fwL = new az(1, "chatting-image-gallery-lazy-loader");
    SparseArray<WeakReference<View>> mQG = new SparseArray();
    HashMap<String, Integer> mQH = new HashMap();
    SparseArray<String> mQI = new SparseArray();
    SparseArray<Bitmap> mQJ = new SparseArray();
    protected com.tencent.mm.a.f<String, Bitmap> mQK = new b(5, new com.tencent.mm.a.f.b<String, Bitmap>() {
        public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(32137);
            Bitmap bitmap = (Bitmap) obj2;
            ab.i("MicroMsg.ImageGalleryLazyLoader", "preRemoveCallback %s", (String) obj);
            if (!(bitmap == null || bitmap.isRecycled() || f.this.mQL.indexOfKey(bitmap.hashCode()) >= 0)) {
                if (f.this.yVr.contains(Integer.valueOf(bitmap.hashCode()))) {
                    f.this.yVr.remove(Integer.valueOf(bitmap.hashCode()));
                    AppMethodBeat.o(32137);
                    return;
                }
                ab.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.o(32137);
        }
    }, getClass());
    protected SparseIntArray mQL = new SparseIntArray();
    private LinkedList<String> mQM = new LinkedList();
    private boolean mQO = false;
    private int mScrollState = 0;
    SparseArray<String> yVn = new SparseArray();
    a yVo;
    protected com.tencent.mm.a.f<String, Bitmap> yVp = new b(400, new com.tencent.mm.a.f.b<String, Bitmap>() {
        public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(32136);
            Bitmap bitmap = (Bitmap) obj2;
            if (!(bitmap == null || bitmap.isRecycled())) {
                ab.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.o(32136);
        }
    }, getClass());
    private LinkedList<Integer> yVr = new LinkedList();
    private LinkedList<Integer> yVs = new LinkedList();
    Bitmap yVt;

    public interface a {
        Bitmap OY(int i);

        void a(WxImageView wxImageView, String str, com.davemorrissey.labs.subscaleview.view.a aVar);

        void b(View view, Bitmap bitmap);

        Bitmap loadImage(String str);
    }

    static /* synthetic */ boolean f(f fVar) {
        AppMethodBeat.i(32158);
        boolean bCI = fVar.bCI();
        AppMethodBeat.o(32158);
        return bCI;
    }

    static /* synthetic */ void h(f fVar) {
        AppMethodBeat.i(32160);
        fVar.Dp();
        AppMethodBeat.o(32160);
    }

    public final void aW(Map<String, Bitmap> map) {
        AppMethodBeat.i(32144);
        for (String str : map.keySet()) {
            Bitmap bitmap = (Bitmap) map.get(str);
            if (bitmap != null) {
                this.mQK.put(str, bitmap);
                this.yVr.push(Integer.valueOf(bitmap.hashCode()));
                ab.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", str, Integer.valueOf(bitmap.hashCode()));
            } else {
                ab.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
            }
        }
        AppMethodBeat.o(32144);
    }

    public f(a aVar) {
        AppMethodBeat.i(32145);
        this.yVo = aVar;
        AppMethodBeat.o(32145);
    }

    /* Access modifiers changed, original: final */
    public final void bCH() {
        AppMethodBeat.i(32146);
        this.yVp.a(new com.tencent.mm.a.f.a<String, Bitmap>() {
        });
        this.mQK.a(new com.tencent.mm.a.f.a<String, Bitmap>() {
        });
        AppMethodBeat.o(32146);
    }

    public final void onPageScrollStateChanged(int i) {
        int i2 = 0;
        AppMethodBeat.i(32147);
        this.mScrollState = i;
        if (bCI()) {
            int[] iArr = new int[this.mQJ.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.mQJ.keyAt(i3);
            }
            while (i2 < iArr.length) {
                int i4 = iArr[i2];
                a(i4, (Bitmap) this.mQJ.get(i4));
                i2++;
            }
        }
        AppMethodBeat.o(32147);
    }

    public final void onPageSelected(int i) {
        AppMethodBeat.i(32148);
        if (((e) this.yVo).yTG.yTJ.prepared) {
            if (this.aaF == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 != 0) {
                        if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                            break;
                        }
                        if (i + i2 <= i + 3) {
                            wB(i + i2);
                        }
                        if (i - i2 >= Math.max(i - 3, 0)) {
                            wB(i - i2);
                        }
                    } else {
                        wB(i);
                    }
                    i2++;
                }
            } else if (this.aaF > i) {
                wB(Math.max(i - 3, 0));
            } else if (this.aaF < i) {
                wB(i + 3);
            }
            this.aaF = i;
            e eVar = (e) this.yVo;
            if (eVar != null) {
                if (eVar.yTG.wx(this.aaF) != null) {
                    this.yVt = null;
                    AppMethodBeat.o(32148);
                    return;
                }
                WxImageView wy = eVar.yTG.wy(this.aaF);
                if (wy != null) {
                    this.yVt = wy.getFullImageBitmap();
                }
            }
            AppMethodBeat.o(32148);
            return;
        }
        AppMethodBeat.o(32148);
    }

    private void wB(final int i) {
        AppMethodBeat.i(32149);
        if (this.yVp.aj(String.valueOf(i))) {
            AppMethodBeat.o(32149);
            return;
        }
        aw.RS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32139);
                if (f.this.yVo == null) {
                    ab.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
                    AppMethodBeat.o(32139);
                    return;
                }
                final Bitmap OY = f.this.yVo.OY(i);
                if (OY == null) {
                    AppMethodBeat.o(32139);
                    return;
                }
                f.this.fbD.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32138);
                        f.this.yVp.put(i, OY);
                        AppMethodBeat.o(32138);
                    }
                });
                AppMethodBeat.o(32139);
            }
        }, 300);
        AppMethodBeat.o(32149);
    }

    private boolean bCI() {
        return this.mScrollState == 0;
    }

    private void wA(int i) {
        AppMethodBeat.i(32150);
        if (this.mQI.get(i) != null) {
            String str = (String) this.mQI.get(i);
            this.mQG.remove(i);
            this.mQI.remove(i);
            this.mQH.remove(str);
            this.mQJ.remove(i);
        }
        AppMethodBeat.o(32150);
    }

    private void a(int i, View view, String str) {
        AppMethodBeat.i(32151);
        this.mQH.put(str, Integer.valueOf(i));
        this.mQI.put(i, str);
        this.mQG.put(i, new WeakReference(view));
        AppMethodBeat.o(32151);
    }

    private void a(int i, Bitmap bitmap) {
        AppMethodBeat.i(32152);
        if (this.mQG.get(i) == null) {
            AppMethodBeat.o(32152);
            return;
        }
        View view = (View) ((WeakReference) this.mQG.get(i)).get();
        this.mQI.get(i);
        this.yVo.b(view, bitmap);
        wA(i);
        AppMethodBeat.o(32152);
    }

    public final boolean c(ImageView imageView, int i) {
        AppMethodBeat.i(32153);
        ab.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", Integer.valueOf(i));
        Bitmap bitmap = (Bitmap) this.yVp.ai(String.valueOf(i));
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(32153);
            return false;
        }
        this.yVo.b(imageView, bitmap);
        AppMethodBeat.o(32153);
        return true;
    }

    public final void b(View view, String str, String str2, int i) {
        AppMethodBeat.i(32154);
        if (this.mQM.contains(str)) {
            AppMethodBeat.o(32154);
            return;
        }
        int hashCode = view.hashCode();
        wA(hashCode);
        a(hashCode, view, str);
        if (view instanceof WxImageView) {
            this.yVn.remove(hashCode);
            this.yVn.put(hashCode, str2);
        }
        this.mQM.add(str);
        this.yVs.add(Integer.valueOf(i));
        Dp();
        AppMethodBeat.o(32154);
    }

    public final void g(ImageView imageView, String str, int i) {
        AppMethodBeat.i(32155);
        if (this.mQM.contains(str)) {
            AppMethodBeat.o(32155);
            return;
        }
        int hashCode = imageView.hashCode();
        wA(hashCode);
        a(hashCode, (View) imageView, str);
        this.mQM.add(str);
        this.yVs.add(Integer.valueOf(i));
        Dp();
        AppMethodBeat.o(32155);
    }

    private void Dp() {
        AppMethodBeat.i(32156);
        if (this.mQO) {
            AppMethodBeat.o(32156);
        } else if (this.mQM.size() == 0) {
            AppMethodBeat.o(32156);
        } else {
            final String str = (String) this.mQM.removeLast();
            final int intValue = ((Integer) this.yVs.removeLast()).intValue();
            if (this.mQH.containsKey(str)) {
                this.mQO = true;
                this.fwL.e(new com.tencent.mm.sdk.platformtools.az.a() {
                    private Bitmap mQQ = null;
                    private boolean yVx = false;

                    public final boolean acg() {
                        AppMethodBeat.i(32141);
                        f.this.mQO = false;
                        if (!this.yVx) {
                            int intValue;
                            if (f.this.mQH.containsKey(str)) {
                                intValue = ((Integer) f.this.mQH.get(str)).intValue();
                                if (f.f(f.this)) {
                                    f.a(f.this, intValue, this.mQQ);
                                } else {
                                    f.this.mQJ.put(intValue, this.mQQ);
                                }
                            }
                            f.this.u(str, this.mQQ);
                            f.this.c(intValue, this.mQQ);
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
                                    AppMethodBeat.o(32141);
                                    throw illegalStateException;
                                }
                            }
                            objArr[0] = Integer.valueOf(intValue);
                            ab.i(str, str2, objArr);
                            this.mQQ = null;
                        }
                        f.h(f.this);
                        AppMethodBeat.o(32141);
                        return false;
                    }

                    public final boolean acf() {
                        AppMethodBeat.i(32142);
                        if (f.this.yVo == null || TextUtils.isEmpty(str)) {
                            AppMethodBeat.o(32142);
                            return false;
                        }
                        try {
                            if (f.this.mQH.containsKey(str)) {
                                int intValue = ((Integer) f.this.mQH.get(str)).intValue();
                                WeakReference weakReference = (WeakReference) f.this.mQG.get(intValue);
                                if (weakReference != null) {
                                    final View view = (View) weakReference.get();
                                    if (view != null && (view instanceof WxImageView)) {
                                        final String str = (String) f.this.yVn.get(intValue);
                                        this.yVx = true;
                                        f.this.fbD.post(new Runnable() {
                                            public final void run() {
                                                boolean z = true;
                                                AppMethodBeat.i(32140);
                                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                                WxImageView wxImageView = (WxImageView) view;
                                                String str = str;
                                                String str2 = str;
                                                int i = intValue;
                                                if (!(f.this.yVo == null || wxImageView == null || bo.isNullOrNil(str))) {
                                                    com.davemorrissey.labs.subscaleview.view.a af;
                                                    String str3 = "MicroMsg.ImageGalleryLazyLoader";
                                                    String str4 = "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b";
                                                    Object[] objArr = new Object[4];
                                                    objArr[0] = Integer.valueOf(i);
                                                    objArr[1] = Integer.valueOf(f.this.aaF);
                                                    objArr[2] = Boolean.valueOf(f.this.yVt == null);
                                                    if (f.this.yVt == null || !f.this.yVt.isRecycled()) {
                                                        z = false;
                                                    }
                                                    objArr[3] = Boolean.valueOf(z);
                                                    ab.i(str3, str4, objArr);
                                                    if (i != f.this.aaF || f.this.yVt == null || f.this.yVt.isRecycled()) {
                                                        af = !bo.isNullOrNil(str2) ? com.davemorrissey.labs.subscaleview.view.a.af(str2) : null;
                                                    } else {
                                                        Bitmap l = f.this.yVt;
                                                        if (l == null) {
                                                            NullPointerException nullPointerException = new NullPointerException("Bitmap must not be null");
                                                            AppMethodBeat.o(32140);
                                                            throw nullPointerException;
                                                        }
                                                        af = new com.davemorrissey.labs.subscaleview.view.a(l);
                                                    }
                                                    f.this.yVo.a(wxImageView, str, af);
                                                }
                                                AppMethodBeat.o(32140);
                                            }
                                        });
                                        AppMethodBeat.o(32142);
                                        return true;
                                    }
                                }
                            }
                            this.mQQ = f.this.yVo.loadImage(str);
                            AppMethodBeat.o(32142);
                            return true;
                        } catch (Exception e) {
                            ab.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", e.getMessage());
                            this.mQQ = null;
                            AppMethodBeat.o(32142);
                            return false;
                        }
                    }
                });
                AppMethodBeat.o(32156);
                return;
            }
            AppMethodBeat.o(32156);
        }
    }

    public final void c(int i, Bitmap bitmap) {
        AppMethodBeat.i(32157);
        if (i == this.aaF || this.aaF == -1) {
            ab.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", Integer.valueOf(i));
            this.yVt = bitmap;
        }
        AppMethodBeat.o(32157);
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u(String str, Bitmap bitmap) {
        int i;
        AppMethodBeat.i(32143);
        if (bitmap != null) {
            long width = ((long) bitmap.getWidth()) * ((long) bitmap.getHeight());
            if (mScreenHeight == 0 || mScreenWidth == 0) {
                mScreenWidth = ah.getContext().getResources().getDisplayMetrics().widthPixels;
                mScreenHeight = ah.getContext().getResources().getDisplayMetrics().heightPixels;
                yVq = ((long) mScreenWidth) * yVq;
            }
            if (width > yVq * 2) {
                i = 1;
                if (i == 0) {
                    ab.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
                    AppMethodBeat.o(32143);
                    return;
                }
                this.mQK.k(str, bitmap);
                if (com.tencent.mm.ui.chatting.gallery.g.a.yVD.mQK.aj(str)) {
                    ab.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                    try {
                        com.tencent.mm.ui.chatting.gallery.g.a.yVD.mQK.k(str, bitmap);
                        AppMethodBeat.o(32143);
                        return;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", e, "update preload cache failed", new Object[0]);
                    }
                }
                AppMethodBeat.o(32143);
                return;
            }
        }
        i = 0;
        if (i == 0) {
        }
    }
}
