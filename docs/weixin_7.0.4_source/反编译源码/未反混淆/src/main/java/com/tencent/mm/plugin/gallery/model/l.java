package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.i.b;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.LinkedList;

public final class l {
    public int hOZ = 3;
    HashSet<a> mOq = new HashSet();
    public HashSet<c> mOr = new HashSet();
    public HashSet<b> mOs = new HashSet();
    public i mOt;
    public int mOu = 1;

    public l() {
        AppMethodBeat.i(21323);
        AppMethodBeat.o(21323);
    }

    public final void wq(int i) {
        AppMethodBeat.i(21324);
        this.mOu = i;
        bCt();
        AppMethodBeat.o(21324);
    }

    private void bCt() {
        AppMethodBeat.i(21325);
        ab.i("MicroMsg.MediaQueryService", "initQueryType: %d", Integer.valueOf(this.mOu));
        switch (this.mOu) {
            case 1:
                this.mOt = new j();
                AppMethodBeat.o(21325);
                return;
            case 2:
                this.mOt = new n();
                AppMethodBeat.o(21325);
                return;
            case 3:
                this.mOt = new a();
                AppMethodBeat.o(21325);
                return;
            default:
                this.mOt = new a();
                AppMethodBeat.o(21325);
                return;
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(21326);
        this.mOq.add(aVar);
        AppMethodBeat.o(21326);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(21327);
        this.mOq.remove(aVar);
        AppMethodBeat.o(21327);
    }

    public final void bCu() {
        AppMethodBeat.i(21328);
        if (this.mOt == null) {
            ab.f("MicroMsg.MediaQueryService", "media query not init, init again");
            bCt();
        }
        e.bCa().W(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21318);
                LinkedList bBS = l.this.mOt.bBS();
                l lVar = l.this;
                a[] aVarArr = new a[lVar.mOq.size()];
                lVar.mOq.toArray(aVarArr);
                for (a V : aVarArr) {
                    V.V(bBS);
                }
                AppMethodBeat.o(21318);
            }

            public final String toString() {
                AppMethodBeat.i(21319);
                String str = super.toString() + "|queryAlbums";
                AppMethodBeat.o(21319);
                return str;
            }
        });
        AppMethodBeat.o(21328);
    }

    public final void g(String str, int i, long j) {
        AppMethodBeat.i(21329);
        if (this.mOt == null) {
            ab.f("MicroMsg.MediaQueryService", "media query not init, init again");
            bCt();
        }
        e.bCa().bCn().removeCallbacksAndMessages(null);
        this.mOt.bBT();
        g bCa = e.bCa();
        final String str2 = str;
        final int i2 = i;
        final long j2 = j;
        bCa.bCn().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21321);
                try {
                    l.this.mOt.a(str2, i2, new d() {
                        public final void c(LinkedList<MediaItem> linkedList, long j) {
                            AppMethodBeat.i(21320);
                            l.a(l.this, linkedList, j);
                            AppMethodBeat.o(21320);
                        }
                    }, j2);
                    AppMethodBeat.o(21321);
                } catch (SecurityException e) {
                    ab.printErrStackTrace("MicroMsg.MediaQueryService", e, "", new Object[0]);
                    l.a(l.this, new LinkedList(), j2);
                    AppMethodBeat.o(21321);
                }
            }

            public final String toString() {
                AppMethodBeat.i(21322);
                String str = super.toString() + "|queryMediaInAlbums";
                AppMethodBeat.o(21322);
                return str;
            }
        });
        AppMethodBeat.o(21329);
    }

    static /* synthetic */ void a(l lVar, LinkedList linkedList, long j) {
        int i = 0;
        AppMethodBeat.i(138168);
        b[] bVarArr = new b[lVar.mOs.size()];
        lVar.mOs.toArray(bVarArr);
        for (b b : bVarArr) {
            b.b(linkedList, j);
        }
        c[] cVarArr = new c[lVar.mOr.size()];
        lVar.mOr.toArray(cVarArr);
        int length = cVarArr.length;
        while (i < length) {
            cVarArr[i].c(linkedList, j);
            i++;
        }
        AppMethodBeat.o(138168);
    }
}
