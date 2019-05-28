package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

public final class g implements d<d> {
    private Stack<d> efp;
    private Stack<d> efq;
    public int efs;
    private SparseArray<String> efx;
    private HashMap<String, Bitmap> efy;

    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.i(116262);
        a((d) obj);
        AppMethodBeat.o(116262);
    }

    public final void onCreate() {
        AppMethodBeat.i(116252);
        ab.i("MicroMsg.MosaicCache", "[onCreate]");
        this.efp = new Stack();
        this.efx = new SparseArray();
        this.efy = new HashMap();
        AppMethodBeat.o(116252);
    }

    public final void onDestroy() {
        Iterator it;
        AppMethodBeat.i(116253);
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
                ab.i("MicroMsg.MosaicCache", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
        }
        this.efy.clear();
        AppMethodBeat.o(116253);
    }

    public final void by(boolean z) {
        AppMethodBeat.i(116254);
        ab.i("MicroMsg.MosaicCache", "[onSave] size:%s", Integer.valueOf(this.efp.size()));
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efq = (Stack) this.efp.clone();
        if (z) {
            this.efp.clear();
        }
        AppMethodBeat.o(116254);
    }

    public final void Je() {
        AppMethodBeat.i(116255);
        ab.i("MicroMsg.MosaicCache", "[onRestore] size:%s", Integer.valueOf(this.efp.size()));
        this.efp.clear();
        if (this.efq != null) {
            ab.i("MicroMsg.MosaicCache", "[onRestore] %s", Integer.valueOf(this.efq.size()));
            this.efp.addAll(this.efq);
        }
        AppMethodBeat.o(116255);
    }

    public final void a(Canvas canvas, boolean z) {
        AppMethodBeat.i(116256);
        if (!z) {
            d dVar;
            if (this.efp == null || this.efp.size() <= 0) {
                dVar = null;
            } else {
                dVar = (d) this.efp.peek();
            }
            if (dVar != null && dVar.ckt == a.ONE) {
                dVar.draw(canvas);
            }
        }
        AppMethodBeat.o(116256);
    }

    public final void b(Canvas canvas) {
        AppMethodBeat.i(116257);
        Bitmap Jl = Jl();
        if (!(Jl == null || Jl.isRecycled())) {
            canvas.drawBitmap(Jl, 0.0f, 0.0f, null);
        }
        AppMethodBeat.o(116257);
    }

    public final void p(Bitmap bitmap) {
        AppMethodBeat.i(116258);
        final Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
        final String asQ = com.tencent.mm.ch.a.asQ(com.tencent.mm.e.a.MOSAIC.toString());
        ab.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", asQ, Integer.valueOf(ac(true)));
        String str = (String) this.efx.get(ac(true));
        if (!bo.isNullOrNil(str)) {
            e.deleteFile(str);
            this.efx.remove(ac(true));
        }
        this.efx.put(ac(true), asQ);
        this.efy.put(asQ, copy);
        com.tencent.mm.sdk.g.d.g(new Runnable() {
            public final void run() {
                AppMethodBeat.i(116251);
                try {
                    com.tencent.mm.sdk.platformtools.d.a(copy, 50, CompressFormat.PNG, asQ, true);
                    AppMethodBeat.o(116251);
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.MosaicCache", e, "", new Object[0]);
                    AppMethodBeat.o(116251);
                }
            }
        }, "[saveCacheToLocal] mosaic path:".concat(String.valueOf(asQ)));
        AppMethodBeat.o(116258);
    }

    public final Bitmap Jl() {
        AppMethodBeat.i(116259);
        String str = (String) this.efx.get(ac(true));
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
            AppMethodBeat.o(116259);
            return null;
        }
        Bitmap bitmap;
        ab.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", str, Integer.valueOf(ac(true)));
        if (this.efy.containsKey(str)) {
            bitmap = (Bitmap) this.efy.get(str);
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            ab.i("MicroMsg.MosaicCache", "");
            bitmap = com.tencent.mm.sdk.platformtools.d.aml(str);
            ab.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
        }
        if (bitmap == null) {
            ab.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", str);
            AppMethodBeat.o(116259);
            return null;
        }
        Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
        ab.i("MicroMsg.MosaicCache", "bitmap recycle %s", bitmap);
        bitmap.recycle();
        AppMethodBeat.o(116259);
        return copy;
    }

    public final void a(d dVar) {
        AppMethodBeat.i(116260);
        if (this.efp != null) {
            this.efp.push(dVar);
        }
        AppMethodBeat.o(116260);
    }

    public final int ac(boolean z) {
        AppMethodBeat.i(116261);
        int size;
        if (z) {
            if (this.efp != null) {
                size = this.efp.size();
                AppMethodBeat.o(116261);
                return size;
            }
            AppMethodBeat.o(116261);
            return 0;
        } else if (this.efq != null) {
            size = this.efq.size();
            AppMethodBeat.o(116261);
            return size;
        } else {
            AppMethodBeat.o(116261);
            return 0;
        }
    }

    public final void CO() {
        this.efs++;
    }

    public final /* synthetic */ Object pop() {
        AppMethodBeat.i(116263);
        if (this.efp.size() <= 0) {
            ab.e("MicroMsg.MosaicCache", "[pop]");
            AppMethodBeat.o(116263);
            return null;
        }
        d dVar = (d) this.efp.pop();
        AppMethodBeat.o(116263);
        return dVar;
    }
}
