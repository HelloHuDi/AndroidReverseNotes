package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.gallery.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class d {
    private az fwL = new az(1, "album-image-gallery-lazy-loader");
    SparseArray<WeakReference<MultiTouchImageView>> mQG = new SparseArray();
    HashMap<String, Integer> mQH = new HashMap();
    SparseArray<String> mQI = new SparseArray();
    SparseArray<Bitmap> mQJ = new SparseArray();
    protected f<String, Bitmap> mQK = new b(5, new f.b<String, Bitmap>() {
        public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(21485);
            Bitmap bitmap = (Bitmap) obj2;
            if (!(bitmap == null || bitmap.isRecycled() || d.this.mQL.indexOfKey(bitmap.hashCode()) >= 0)) {
                ab.i("ImageAdapter", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.o(21485);
        }
    }, getClass());
    protected SparseIntArray mQL = new SparseIntArray();
    LinkedList<String> mQM = new LinkedList();
    c mQN;
    boolean mQO = false;
    private int mScrollState = 0;

    static /* synthetic */ void a(d dVar, int i, Bitmap bitmap) {
        AppMethodBeat.i(21495);
        dVar.a(i, bitmap);
        AppMethodBeat.o(21495);
    }

    public d(c cVar) {
        AppMethodBeat.i(21488);
        this.mQN = cVar;
        AppMethodBeat.o(21488);
    }

    public final void detach() {
        AppMethodBeat.i(21489);
        this.mQN = null;
        this.mQG.clear();
        this.mQJ.clear();
        this.mQI.clear();
        this.mQH.clear();
        bCH();
        AppMethodBeat.o(21489);
    }

    private void bCH() {
        AppMethodBeat.i(21490);
        this.mQK.a(new a<String, Bitmap>() {
        });
        AppMethodBeat.o(21490);
    }

    public final void onPageScrollStateChanged(int i) {
        int i2 = 0;
        AppMethodBeat.i(21491);
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
        AppMethodBeat.o(21491);
    }

    /* Access modifiers changed, original: final */
    public final boolean bCI() {
        return this.mScrollState == 0;
    }

    /* Access modifiers changed, original: final */
    public final void wA(int i) {
        AppMethodBeat.i(21492);
        if (this.mQI.get(i) != null) {
            String str = (String) this.mQI.get(i);
            this.mQG.remove(i);
            this.mQI.remove(i);
            this.mQH.remove(str);
            this.mQJ.remove(i);
        }
        AppMethodBeat.o(21492);
    }

    private void a(int i, Bitmap bitmap) {
        AppMethodBeat.i(21493);
        if (this.mQG.get(i) == null) {
            AppMethodBeat.o(21493);
            return;
        }
        MultiTouchImageView multiTouchImageView = (MultiTouchImageView) ((WeakReference) this.mQG.get(i)).get();
        String str = (String) this.mQI.get(i);
        if (!(bitmap == null || multiTouchImageView == null)) {
            int hashCode = bitmap.hashCode();
            int indexOfValue = this.mQL.indexOfValue(i);
            if (indexOfValue >= 0) {
                this.mQL.removeAt(indexOfValue);
            }
            this.mQL.put(hashCode, i);
        }
        this.mQN.a(multiTouchImageView, str, bitmap);
        wA(i);
        AppMethodBeat.o(21493);
    }

    /* Access modifiers changed, original: final */
    public final void Dp() {
        AppMethodBeat.i(21494);
        if (this.mQO) {
            AppMethodBeat.o(21494);
        } else if (this.mQM.size() == 0) {
            AppMethodBeat.o(21494);
        } else {
            final String str = (String) this.mQM.removeLast();
            if (this.mQH.containsKey(str)) {
                this.mQO = true;
                this.fwL.e(new az.a() {
                    private Bitmap mQQ = null;

                    public final boolean acg() {
                        AppMethodBeat.i(21486);
                        d.this.mQO = false;
                        if (d.this.mQH.containsKey(str)) {
                            int intValue = ((Integer) d.this.mQH.get(str)).intValue();
                            if (d.this.bCI()) {
                                d.a(d.this, intValue, this.mQQ);
                            } else {
                                d.this.mQJ.put(intValue, this.mQQ);
                            }
                        }
                        d.this.mQK.k(str, this.mQQ);
                        this.mQQ = null;
                        d.this.Dp();
                        AppMethodBeat.o(21486);
                        return false;
                    }

                    public final boolean acf() {
                        AppMethodBeat.i(21487);
                        if (d.this.mQN == null || TextUtils.isEmpty(str)) {
                            AppMethodBeat.o(21487);
                            return false;
                        }
                        String str = str;
                        long yz = bo.yz();
                        Bitmap NC = k.NC(str);
                        ab.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", Long.valueOf(bo.az(yz)), str);
                        this.mQQ = NC;
                        AppMethodBeat.o(21487);
                        return true;
                    }
                });
                AppMethodBeat.o(21494);
                return;
            }
            AppMethodBeat.o(21494);
        }
    }
}
