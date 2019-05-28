package com.tencent.p177mm.plugin.fav.p410ui.gallery;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.GridLayoutManager.C8440b;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C20743e.C20744a;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C20743e.C20745b;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C39072f.C39068b;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C39072f.C39073c;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C45938g.C43080b;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C45938g.C45937a;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.gallery.h */
public final class C41277h implements C20745b, C45937a {
    ArrayList<C39073c> iPr = null;
    List<Long> idList = new ArrayList();
    private GridLayoutManager kvk;
    Context mContext;
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    int moA = 0;
    C43080b mow;
    C39072f mox;
    boolean moy = false;
    int moz = 0;

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.h$1 */
    class C412781 extends C8440b {
        C412781() {
        }

        /* renamed from: bU */
        public final int mo18459bU(int i) {
            AppMethodBeat.m2504i(74590);
            if (((C39073c) C41277h.this.iPr.get(i)).type == BaseClientBuilder.API_PRIORITY_OTHER) {
                AppMethodBeat.m2505o(74590);
                return 4;
            }
            AppMethodBeat.m2505o(74590);
            return 1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.h$3 */
    class C412793 implements C39068b {
        C412793() {
        }

        /* renamed from: a */
        public final void mo61980a(boolean z, C39073c c39073c, int i) {
            AppMethodBeat.m2504i(74592);
            C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", Boolean.valueOf(z), Integer.valueOf(i));
            if (!z || C20744a.moa.mnX.size() < 9) {
                C20743e bwv;
                C20742d c20742d;
                if (z) {
                    bwv = C20744a.moa;
                    c20742d = c39073c.mof;
                    if (c20742d != null) {
                        C4990ab.m7417i("MicroMsg.ImageGallerySelectedHandle", "add : %s", c20742d);
                        bwv.mnX.remove(c20742d);
                        bwv.mnX.remove(bwv.mo36047Mg(c20742d.cAJ.mnd));
                        bwv.mnX.add(c20742d);
                        bwv.bwu();
                    }
                } else {
                    bwv = C20744a.moa;
                    c20742d = c39073c.mof;
                    if (c20742d != null) {
                        C4990ab.m7417i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", c20742d.cAJ.mnd);
                        bwv.mnX.remove(c20742d);
                        bwv.mnX.remove(bwv.mo36047Mg(c20742d.cAJ.mnd));
                        bwv.bwu();
                    }
                }
                C41277h.this.mow.mo45954vF(C20744a.moa.mnX.size());
                AppMethodBeat.m2505o(74592);
                return;
            }
            Toast.makeText(C41277h.this.mContext, C41277h.this.mContext.getResources().getString(C25738R.string.bnb, new Object[]{Integer.valueOf(9)}), 1).show();
            C41277h.this.mox.mo66316cg(i);
            AppMethodBeat.m2505o(74592);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo65934a(C20741b c20741b) {
        AppMethodBeat.m2504i(74606);
        this.mow = (C43080b) c20741b;
        this.mow.mo36044a(this);
        C20743e bwv = C20744a.moa;
        bwv.mnZ.remove(this);
        bwv.mnZ.add(this);
        AppMethodBeat.m2505o(74606);
    }

    public C41277h(Context context) {
        AppMethodBeat.m2504i(74595);
        this.mContext = context;
        this.iPr = new ArrayList();
        AppMethodBeat.m2505o(74595);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(74596);
        if (this.mow != null) {
            this.mow.mo36044a(null);
            this.mow = null;
        }
        C20743e bwv = C20744a.moa;
        bwv.mnZ.clear();
        bwv.clear();
        bwv.mnY = false;
        AppMethodBeat.m2505o(74596);
    }

    public final <T extends C17480i> T bfC() {
        AppMethodBeat.m2504i(74597);
        if (this.kvk == null) {
            this.kvk = new GridLayoutManager(4);
            this.kvk.akZ = new C412781();
        }
        GridLayoutManager gridLayoutManager = this.kvk;
        AppMethodBeat.m2505o(74597);
        return gridLayoutManager;
    }

    /* renamed from: dN */
    public final C25373h mo65941dN(final Context context) {
        AppMethodBeat.m2504i(74598);
        C390772 c390772 = new C25373h() {
            /* renamed from: a */
            public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
                AppMethodBeat.m2504i(74591);
                int dimension = (int) context.getResources().getDimension(C25738R.dimen.f9981m7);
                rect.bottom = dimension;
                rect.top = dimension;
                rect.left = dimension;
                rect.right = dimension;
                AppMethodBeat.m2505o(74591);
            }
        };
        AppMethodBeat.m2505o(74598);
        return c390772;
    }

    public final C41523a bfB() {
        AppMethodBeat.m2504i(74599);
        this.mox = new C39072f(this.mContext, this.iPr, this.mow);
        this.mox.moc = new C412793();
        C39072f c39072f = this.mox;
        AppMethodBeat.m2505o(74599);
        return c39072f;
    }

    /* renamed from: vH */
    public final void mo65945vH(int i) {
        AppMethodBeat.m2504i(74600);
        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", Integer.valueOf(i));
        ArrayList arrayList = C20744a.moa.mnX;
        switch (i) {
            case 0:
                this.mow.mo45948bS(arrayList);
                this.mow.bwr();
                break;
        }
        AppMethodBeat.m2505o(74600);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(74604);
        if (this.moy && C20744a.moa.mnY) {
            this.mow.mo45954vF(C20744a.moa.mnX.size());
            this.mox.aop.notifyChanged();
        }
        AppMethodBeat.m2505o(74604);
    }

    public final void bww() {
        this.moy = true;
    }

    public final void bwq() {
        AppMethodBeat.m2504i(74601);
        this.mox.mod = true;
        C20744a.moa.mnY = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) bfC();
        int iQ = gridLayoutManager.mo1780iQ();
        this.mox.mo66315c(iQ, (gridLayoutManager.mo1782iS() - iQ) + 1, Integer.valueOf(0));
        AppMethodBeat.m2505o(74601);
    }

    public final void bwr() {
        AppMethodBeat.m2504i(74602);
        this.mox.mod = false;
        C20744a.moa.clear();
        C20744a.moa.mnY = false;
        this.mox.aop.notifyChanged();
        AppMethodBeat.m2505o(74602);
    }

    public final boolean bwy() {
        AppMethodBeat.m2504i(74603);
        boolean z = C20744a.moa.mnY;
        AppMethodBeat.m2505o(74603);
        return z;
    }

    /* renamed from: s */
    public final void mo65944s(final boolean z, final int i) {
        AppMethodBeat.m2504i(74605);
        this.mox.kuX = true;
        this.mow.mo45951fO(z);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                int i = 100;
                AppMethodBeat.m2504i(74594);
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(21));
                    C41277h.this.idList = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54689b(null, null, arrayList);
                    C41277h.this.moz = C41277h.this.idList.size();
                }
                if (i >= 0 && C41277h.this.moz - i > 100) {
                    i = C41277h.this.moz - i;
                }
                C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", Integer.valueOf(i), Integer.valueOf(i));
                LinkedList linkedList = new LinkedList();
                while (linkedList.size() < i && C41277h.this.moA < C41277h.this.idList.size()) {
                    int i2 = C41277h.this.moA;
                    int size = i2 + i > C41277h.this.idList.size() ? C41277h.this.idList.size() : i2 + i;
                    List<C27966g> bT = C41277h.m71896bT(C41277h.this.idList.subList(i2, size));
                    C41277h.this.moA = size;
                    for (C27966g G : bT) {
                        linkedList.addAll(C41277h.m71895G(G));
                    }
                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", Integer.valueOf(i2), Integer.valueOf(size), Integer.valueOf(C41277h.this.idList.size()), Integer.valueOf(i), Integer.valueOf(linkedList.size()));
                }
                final int size2 = linkedList.size();
                Collections.reverse(linkedList);
                C41277h.this.iPr.addAll(0, linkedList);
                linkedList.clear();
                C4990ab.m7417i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", Integer.valueOf(C41277h.this.iPr.size()));
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(74593);
                        C41277h.this.mox.kuX = false;
                        if (C41277h.this.mow != null) {
                            C41277h.this.mow.mo45952p(z, size2);
                        }
                        AppMethodBeat.m2505o(74593);
                    }
                });
                AppMethodBeat.m2505o(74594);
            }
        });
        AppMethodBeat.m2505o(74605);
    }

    public final /* bridge */ /* synthetic */ C41523a bwx() {
        return this.mox;
    }

    /* renamed from: bT */
    static /* synthetic */ List m71896bT(List list) {
        AppMethodBeat.m2504i(74607);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(74607);
            return arrayList;
        }
        int i = 0;
        while (true) {
            int size = i + 20 < list.size() ? i + 20 : list.size();
            C4990ab.m7419v("MicroMsg.MediaHistoryGalleryPresenter", "start:%d  end:%d listSize:%d", Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(list.size()));
            ArrayList a = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23676a(list.subList(i, size), null, null, null);
            if (a != null && a.size() > 0) {
                arrayList.addAll(a);
            }
            if (size >= list.size()) {
                AppMethodBeat.m2505o(74607);
                return arrayList;
            }
            i = size;
        }
    }

    /* renamed from: G */
    static /* synthetic */ List m71895G(C27966g c27966g) {
        AppMethodBeat.m2504i(74608);
        ArrayList arrayList = new ArrayList();
        if (!(c27966g == null || c27966g.field_favProto.wiv.size() == 0)) {
            for (int size = c27966g.field_favProto.wiv.size() - 1; size >= 0; size--) {
                aar aar = (aar) c27966g.field_favProto.wiv.get(size);
                if (aar.dataType == 2 || aar.dataType == 4 || aar.dataType == 15) {
                    arrayList.add(new C39073c(new C20742d(c27966g, aar)));
                }
            }
        }
        AppMethodBeat.m2505o(74608);
        return arrayList;
    }
}
