package com.tencent.p177mm.plugin.gallery.p427ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1174a;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.plugin.gallery.model.C39159k;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.gallery.ui.d */
final class C43148d {
    private C23498az fwL = new C23498az(1, "album-image-gallery-lazy-loader");
    SparseArray<WeakReference<MultiTouchImageView>> mQG = new SparseArray();
    HashMap<String, Integer> mQH = new HashMap();
    SparseArray<String> mQI = new SparseArray();
    SparseArray<Bitmap> mQJ = new SparseArray();
    protected C1177f<String, Bitmap> mQK = new C26399b(5, new C431491(), getClass());
    protected SparseIntArray mQL = new SparseIntArray();
    LinkedList<String> mQM = new LinkedList();
    C44743c mQN;
    boolean mQO = false;
    private int mScrollState = 0;

    /* renamed from: com.tencent.mm.plugin.gallery.ui.d$2 */
    class C391792 implements C1174a<String, Bitmap> {
        C391792() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.d$1 */
    class C431491 implements C1175b<String, Bitmap> {
        C431491() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(21485);
            Bitmap bitmap = (Bitmap) obj2;
            if (!(bitmap == null || bitmap.isRecycled() || C43148d.this.mQL.indexOfKey(bitmap.hashCode()) >= 0)) {
                C4990ab.m7417i("ImageAdapter", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.m2505o(21485);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m76714a(C43148d c43148d, int i, Bitmap bitmap) {
        AppMethodBeat.m2504i(21495);
        c43148d.m76713a(i, bitmap);
        AppMethodBeat.m2505o(21495);
    }

    public C43148d(C44743c c44743c) {
        AppMethodBeat.m2504i(21488);
        this.mQN = c44743c;
        AppMethodBeat.m2505o(21488);
    }

    public final void detach() {
        AppMethodBeat.m2504i(21489);
        this.mQN = null;
        this.mQG.clear();
        this.mQJ.clear();
        this.mQI.clear();
        this.mQH.clear();
        bCH();
        AppMethodBeat.m2505o(21489);
    }

    private void bCH() {
        AppMethodBeat.m2504i(21490);
        this.mQK.mo4403a(new C391792());
        AppMethodBeat.m2505o(21490);
    }

    public final void onPageScrollStateChanged(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(21491);
        this.mScrollState = i;
        if (bCI()) {
            int[] iArr = new int[this.mQJ.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.mQJ.keyAt(i3);
            }
            while (i2 < iArr.length) {
                int i4 = iArr[i2];
                m76713a(i4, (Bitmap) this.mQJ.get(i4));
                i2++;
            }
        }
        AppMethodBeat.m2505o(21491);
    }

    /* Access modifiers changed, original: final */
    public final boolean bCI() {
        return this.mScrollState == 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wA */
    public final void mo68671wA(int i) {
        AppMethodBeat.m2504i(21492);
        if (this.mQI.get(i) != null) {
            String str = (String) this.mQI.get(i);
            this.mQG.remove(i);
            this.mQI.remove(i);
            this.mQH.remove(str);
            this.mQJ.remove(i);
        }
        AppMethodBeat.m2505o(21492);
    }

    /* renamed from: a */
    private void m76713a(int i, Bitmap bitmap) {
        AppMethodBeat.m2504i(21493);
        if (this.mQG.get(i) == null) {
            AppMethodBeat.m2505o(21493);
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
        this.mQN.mo71814a(multiTouchImageView, str, bitmap);
        mo68671wA(i);
        AppMethodBeat.m2505o(21493);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Dp */
    public final void mo68667Dp() {
        AppMethodBeat.m2504i(21494);
        if (this.mQO) {
            AppMethodBeat.m2505o(21494);
        } else if (this.mQM.size() == 0) {
            AppMethodBeat.m2505o(21494);
        } else {
            final String str = (String) this.mQM.removeLast();
            if (this.mQH.containsKey(str)) {
                this.mQO = true;
                this.fwL.mo39163e(new C23499a() {
                    private Bitmap mQQ = null;

                    public final boolean acg() {
                        AppMethodBeat.m2504i(21486);
                        C43148d.this.mQO = false;
                        if (C43148d.this.mQH.containsKey(str)) {
                            int intValue = ((Integer) C43148d.this.mQH.get(str)).intValue();
                            if (C43148d.this.bCI()) {
                                C43148d.m76714a(C43148d.this, intValue, this.mQQ);
                            } else {
                                C43148d.this.mQJ.put(intValue, this.mQQ);
                            }
                        }
                        C43148d.this.mQK.mo4412k(str, this.mQQ);
                        this.mQQ = null;
                        C43148d.this.mo68667Dp();
                        AppMethodBeat.m2505o(21486);
                        return false;
                    }

                    public final boolean acf() {
                        AppMethodBeat.m2504i(21487);
                        if (C43148d.this.mQN == null || TextUtils.isEmpty(str)) {
                            AppMethodBeat.m2505o(21487);
                            return false;
                        }
                        String str = str;
                        long yz = C5046bo.m7588yz();
                        Bitmap NC = C39159k.m66636NC(str);
                        C4990ab.m7419v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", Long.valueOf(C5046bo.m7525az(yz)), str);
                        this.mQQ = NC;
                        AppMethodBeat.m2505o(21487);
                        return true;
                    }
                });
                AppMethodBeat.m2505o(21494);
                return;
            }
            AppMethodBeat.m2505o(21494);
        }
    }
}
