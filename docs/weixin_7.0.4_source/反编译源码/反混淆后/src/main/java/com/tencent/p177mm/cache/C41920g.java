package com.tencent.p177mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1639ch.C45281a;
import com.tencent.p177mm.p226e.C1493a;
import com.tencent.p177mm.p651y.C36401d;
import com.tencent.p177mm.p651y.C36401d.C24187a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

/* renamed from: com.tencent.mm.cache.g */
public final class C41920g implements C18128d<C36401d> {
    private Stack<C36401d> efp;
    private Stack<C36401d> efq;
    public int efs;
    private SparseArray<String> efx;
    private HashMap<String, Bitmap> efy;

    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.m2504i(116262);
        mo67568a((C36401d) obj);
        AppMethodBeat.m2505o(116262);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(116252);
        C4990ab.m7416i("MicroMsg.MosaicCache", "[onCreate]");
        this.efp = new Stack();
        this.efx = new SparseArray();
        this.efy = new HashMap();
        AppMethodBeat.m2505o(116252);
    }

    public final void onDestroy() {
        Iterator it;
        AppMethodBeat.m2504i(116253);
        if (this.efp != null) {
            it = this.efp.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.efp.clear();
        }
        if (this.efq != null) {
            it = this.efq.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.efq.clear();
        }
        this.efx.clear();
        for (Entry value : this.efy.entrySet()) {
            Bitmap bitmap = (Bitmap) value.getValue();
            if (!(bitmap == null || bitmap.isRecycled())) {
                C4990ab.m7417i("MicroMsg.MosaicCache", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
        }
        this.efy.clear();
        AppMethodBeat.m2505o(116253);
    }

    /* renamed from: by */
    public final void mo33619by(boolean z) {
        AppMethodBeat.m2504i(116254);
        C4990ab.m7417i("MicroMsg.MosaicCache", "[onSave] size:%s", Integer.valueOf(this.efp.size()));
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efq = (Stack) this.efp.clone();
        if (z) {
            this.efp.clear();
        }
        AppMethodBeat.m2505o(116254);
    }

    /* renamed from: Je */
    public final void mo33614Je() {
        AppMethodBeat.m2504i(116255);
        C4990ab.m7417i("MicroMsg.MosaicCache", "[onRestore] size:%s", Integer.valueOf(this.efp.size()));
        this.efp.clear();
        if (this.efq != null) {
            C4990ab.m7417i("MicroMsg.MosaicCache", "[onRestore] %s", Integer.valueOf(this.efq.size()));
            this.efp.addAll(this.efq);
        }
        AppMethodBeat.m2505o(116255);
    }

    /* renamed from: a */
    public final void mo33615a(Canvas canvas, boolean z) {
        AppMethodBeat.m2504i(116256);
        if (!z) {
            C36401d c36401d;
            if (this.efp == null || this.efp.size() <= 0) {
                c36401d = null;
            } else {
                c36401d = (C36401d) this.efp.peek();
            }
            if (c36401d != null && c36401d.ckt == C24187a.ONE) {
                c36401d.draw(canvas);
            }
        }
        AppMethodBeat.m2505o(116256);
    }

    /* renamed from: b */
    public final void mo33618b(Canvas canvas) {
        AppMethodBeat.m2504i(116257);
        Bitmap Jl = mo67567Jl();
        if (!(Jl == null || Jl.isRecycled())) {
            canvas.drawBitmap(Jl, 0.0f, 0.0f, null);
        }
        AppMethodBeat.m2505o(116257);
    }

    /* renamed from: p */
    public final void mo67569p(Bitmap bitmap) {
        AppMethodBeat.m2504i(116258);
        final Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
        final String asQ = C45281a.asQ(C1493a.MOSAIC.toString());
        C4990ab.m7417i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", asQ, Integer.valueOf(mo33616ac(true)));
        String str = (String) this.efx.get(mo33616ac(true));
        if (!C5046bo.isNullOrNil(str)) {
            C5730e.deleteFile(str);
            this.efx.remove(mo33616ac(true));
        }
        this.efx.put(mo33616ac(true), asQ);
        this.efy.put(asQ, copy);
        C7305d.m12299g(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(116251);
                try {
                    C5056d.m7625a(copy, 50, CompressFormat.PNG, asQ, true);
                    AppMethodBeat.m2505o(116251);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.MosaicCache", e, "", new Object[0]);
                    AppMethodBeat.m2505o(116251);
                }
            }
        }, "[saveCacheToLocal] mosaic path:".concat(String.valueOf(asQ)));
        AppMethodBeat.m2505o(116258);
    }

    /* renamed from: Jl */
    public final Bitmap mo67567Jl() {
        AppMethodBeat.m2504i(116259);
        String str = (String) this.efx.get(mo33616ac(true));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
            AppMethodBeat.m2505o(116259);
            return null;
        }
        Bitmap bitmap;
        C4990ab.m7417i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", str, Integer.valueOf(mo33616ac(true)));
        if (this.efy.containsKey(str)) {
            bitmap = (Bitmap) this.efy.get(str);
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            C4990ab.m7416i("MicroMsg.MosaicCache", "");
            bitmap = C5056d.aml(str);
            C4990ab.m7416i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
        }
        if (bitmap == null) {
            C4990ab.m7413e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", str);
            AppMethodBeat.m2505o(116259);
            return null;
        }
        Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
        C4990ab.m7417i("MicroMsg.MosaicCache", "bitmap recycle %s", bitmap);
        bitmap.recycle();
        AppMethodBeat.m2505o(116259);
        return copy;
    }

    /* renamed from: a */
    public final void mo67568a(C36401d c36401d) {
        AppMethodBeat.m2504i(116260);
        if (this.efp != null) {
            this.efp.push(c36401d);
        }
        AppMethodBeat.m2505o(116260);
    }

    /* renamed from: ac */
    public final int mo33616ac(boolean z) {
        AppMethodBeat.m2504i(116261);
        int size;
        if (z) {
            if (this.efp != null) {
                size = this.efp.size();
                AppMethodBeat.m2505o(116261);
                return size;
            }
            AppMethodBeat.m2505o(116261);
            return 0;
        } else if (this.efq != null) {
            size = this.efq.size();
            AppMethodBeat.m2505o(116261);
            return size;
        } else {
            AppMethodBeat.m2505o(116261);
            return 0;
        }
    }

    /* renamed from: CO */
    public final void mo33613CO() {
        this.efs++;
    }

    public final /* synthetic */ Object pop() {
        AppMethodBeat.m2504i(116263);
        if (this.efp.size() <= 0) {
            C4990ab.m7412e("MicroMsg.MosaicCache", "[pop]");
            AppMethodBeat.m2505o(116263);
            return null;
        }
        C36401d c36401d = (C36401d) this.efp.pop();
        AppMethodBeat.m2505o(116263);
        return c36401d;
    }
}
