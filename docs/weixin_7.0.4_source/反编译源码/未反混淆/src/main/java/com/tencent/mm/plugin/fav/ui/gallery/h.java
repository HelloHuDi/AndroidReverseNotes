package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.ui.gallery.e.b;
import com.tencent.mm.plugin.fav.ui.gallery.f.c;
import com.tencent.mm.plugin.fav.ui.gallery.g.a;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class h implements b, a {
    ArrayList<c> iPr = null;
    List<Long> idList = new ArrayList();
    private GridLayoutManager kvk;
    Context mContext;
    private ak mHandler = new ak(Looper.getMainLooper());
    int moA = 0;
    g.b mow;
    f mox;
    boolean moy = false;
    int moz = 0;

    public final /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(74606);
        this.mow = (g.b) bVar;
        this.mow.a(this);
        e bwv = a.moa;
        bwv.mnZ.remove(this);
        bwv.mnZ.add(this);
        AppMethodBeat.o(74606);
    }

    public h(Context context) {
        AppMethodBeat.i(74595);
        this.mContext = context;
        this.iPr = new ArrayList();
        AppMethodBeat.o(74595);
    }

    public final void onDetach() {
        AppMethodBeat.i(74596);
        if (this.mow != null) {
            this.mow.a(null);
            this.mow = null;
        }
        e bwv = a.moa;
        bwv.mnZ.clear();
        bwv.clear();
        bwv.mnY = false;
        AppMethodBeat.o(74596);
    }

    public final <T extends i> T bfC() {
        AppMethodBeat.i(74597);
        if (this.kvk == null) {
            this.kvk = new GridLayoutManager(4);
            this.kvk.akZ = new GridLayoutManager.b() {
                public final int bU(int i) {
                    AppMethodBeat.i(74590);
                    if (((c) h.this.iPr.get(i)).type == BaseClientBuilder.API_PRIORITY_OTHER) {
                        AppMethodBeat.o(74590);
                        return 4;
                    }
                    AppMethodBeat.o(74590);
                    return 1;
                }
            };
        }
        GridLayoutManager gridLayoutManager = this.kvk;
        AppMethodBeat.o(74597);
        return gridLayoutManager;
    }

    public final android.support.v7.widget.RecyclerView.h dN(final Context context) {
        AppMethodBeat.i(74598);
        AnonymousClass2 anonymousClass2 = new android.support.v7.widget.RecyclerView.h() {
            public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
                AppMethodBeat.i(74591);
                int dimension = (int) context.getResources().getDimension(R.dimen.m7);
                rect.bottom = dimension;
                rect.top = dimension;
                rect.left = dimension;
                rect.right = dimension;
                AppMethodBeat.o(74591);
            }
        };
        AppMethodBeat.o(74598);
        return anonymousClass2;
    }

    public final RecyclerView.a bfB() {
        AppMethodBeat.i(74599);
        this.mox = new f(this.mContext, this.iPr, this.mow);
        this.mox.moc = new f.b() {
            public final void a(boolean z, c cVar, int i) {
                AppMethodBeat.i(74592);
                ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", Boolean.valueOf(z), Integer.valueOf(i));
                if (!z || a.moa.mnX.size() < 9) {
                    e bwv;
                    d dVar;
                    if (z) {
                        bwv = a.moa;
                        dVar = cVar.mof;
                        if (dVar != null) {
                            ab.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", dVar);
                            bwv.mnX.remove(dVar);
                            bwv.mnX.remove(bwv.Mg(dVar.cAJ.mnd));
                            bwv.mnX.add(dVar);
                            bwv.bwu();
                        }
                    } else {
                        bwv = a.moa;
                        dVar = cVar.mof;
                        if (dVar != null) {
                            ab.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", dVar.cAJ.mnd);
                            bwv.mnX.remove(dVar);
                            bwv.mnX.remove(bwv.Mg(dVar.cAJ.mnd));
                            bwv.bwu();
                        }
                    }
                    h.this.mow.vF(a.moa.mnX.size());
                    AppMethodBeat.o(74592);
                    return;
                }
                Toast.makeText(h.this.mContext, h.this.mContext.getResources().getString(R.string.bnb, new Object[]{Integer.valueOf(9)}), 1).show();
                h.this.mox.cg(i);
                AppMethodBeat.o(74592);
            }
        };
        f fVar = this.mox;
        AppMethodBeat.o(74599);
        return fVar;
    }

    public final void vH(int i) {
        AppMethodBeat.i(74600);
        ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", Integer.valueOf(i));
        ArrayList arrayList = a.moa.mnX;
        switch (i) {
            case 0:
                this.mow.bS(arrayList);
                this.mow.bwr();
                break;
        }
        AppMethodBeat.o(74600);
    }

    public final void onResume() {
        AppMethodBeat.i(74604);
        if (this.moy && a.moa.mnY) {
            this.mow.vF(a.moa.mnX.size());
            this.mox.aop.notifyChanged();
        }
        AppMethodBeat.o(74604);
    }

    public final void bww() {
        this.moy = true;
    }

    public final void bwq() {
        AppMethodBeat.i(74601);
        this.mox.mod = true;
        a.moa.mnY = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) bfC();
        int iQ = gridLayoutManager.iQ();
        this.mox.c(iQ, (gridLayoutManager.iS() - iQ) + 1, Integer.valueOf(0));
        AppMethodBeat.o(74601);
    }

    public final void bwr() {
        AppMethodBeat.i(74602);
        this.mox.mod = false;
        a.moa.clear();
        a.moa.mnY = false;
        this.mox.aop.notifyChanged();
        AppMethodBeat.o(74602);
    }

    public final boolean bwy() {
        AppMethodBeat.i(74603);
        boolean z = a.moa.mnY;
        AppMethodBeat.o(74603);
        return z;
    }

    public final void s(final boolean z, final int i) {
        AppMethodBeat.i(74605);
        this.mox.kuX = true;
        this.mow.fO(z);
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                int i = 100;
                AppMethodBeat.i(74594);
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(21));
                    h.this.idList = ((ae) g.M(ae.class)).getFavSearchStorage().b(null, null, arrayList);
                    h.this.moz = h.this.idList.size();
                }
                if (i >= 0 && h.this.moz - i > 100) {
                    i = h.this.moz - i;
                }
                ab.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", Integer.valueOf(i), Integer.valueOf(i));
                LinkedList linkedList = new LinkedList();
                while (linkedList.size() < i && h.this.moA < h.this.idList.size()) {
                    int i2 = h.this.moA;
                    int size = i2 + i > h.this.idList.size() ? h.this.idList.size() : i2 + i;
                    List<com.tencent.mm.plugin.fav.a.g> bT = h.bT(h.this.idList.subList(i2, size));
                    h.this.moA = size;
                    for (com.tencent.mm.plugin.fav.a.g G : bT) {
                        linkedList.addAll(h.G(G));
                    }
                    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", Integer.valueOf(i2), Integer.valueOf(size), Integer.valueOf(h.this.idList.size()), Integer.valueOf(i), Integer.valueOf(linkedList.size()));
                }
                final int size2 = linkedList.size();
                Collections.reverse(linkedList);
                h.this.iPr.addAll(0, linkedList);
                linkedList.clear();
                ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", Integer.valueOf(h.this.iPr.size()));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74593);
                        h.this.mox.kuX = false;
                        if (h.this.mow != null) {
                            h.this.mow.p(z, size2);
                        }
                        AppMethodBeat.o(74593);
                    }
                });
                AppMethodBeat.o(74594);
            }
        });
        AppMethodBeat.o(74605);
    }

    public final /* bridge */ /* synthetic */ RecyclerView.a bwx() {
        return this.mox;
    }

    static /* synthetic */ List bT(List list) {
        AppMethodBeat.i(74607);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(74607);
            return arrayList;
        }
        int i = 0;
        while (true) {
            int size = i + 20 < list.size() ? i + 20 : list.size();
            ab.v("MicroMsg.MediaHistoryGalleryPresenter", "start:%d  end:%d listSize:%d", Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(list.size()));
            ArrayList a = ((ae) g.M(ae.class)).getFavItemInfoStorage().a(list.subList(i, size), null, null, null);
            if (a != null && a.size() > 0) {
                arrayList.addAll(a);
            }
            if (size >= list.size()) {
                AppMethodBeat.o(74607);
                return arrayList;
            }
            i = size;
        }
    }

    static /* synthetic */ List G(com.tencent.mm.plugin.fav.a.g gVar) {
        AppMethodBeat.i(74608);
        ArrayList arrayList = new ArrayList();
        if (!(gVar == null || gVar.field_favProto.wiv.size() == 0)) {
            for (int size = gVar.field_favProto.wiv.size() - 1; size >= 0; size--) {
                aar aar = (aar) gVar.field_favProto.wiv.get(size);
                if (aar.dataType == 2 || aar.dataType == 4 || aar.dataType == 15) {
                    arrayList.add(new c(new d(gVar, aar)));
                }
            }
        }
        AppMethodBeat.o(74608);
        return arrayList;
    }
}
