package com.tencent.p177mm.plugin.fav.p410ui.p1260a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C11887h;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C11890j;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C11892k;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C20717c;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C24753b;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C24755c;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C28010i;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C3085q;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C34161l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C34163p;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C39057f;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C39059m;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C43067d;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C43068o;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C45933e;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C45934g;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C45935n;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.tencent.mm.plugin.fav.ui.a.b */
public final class C39056b extends C34148a {
    private C4884c hAA;
    public int jSW;
    private boolean mlc;
    public List<C27966g> mld;
    private List<C27966g> mle;
    private List<C27966g> mlf;
    public List<Long> mlg;
    public boolean mlh;
    private Map<Long, C27966g> mli;
    private List<Integer> mlj;
    private List<String> mlk;
    private List<String> mll;
    private SparseArray<C20714a> mlm;
    private boolean mln;
    public C20717c mlo;
    public boolean mlp;
    public boolean mlq;
    public ListView mlr;
    public String query;
    public int scene;

    /* renamed from: com.tencent.mm.plugin.fav.ui.a.b$1 */
    class C390551 extends C4884c<C37752ke> {
        C390551() {
            AppMethodBeat.m2504i(74292);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(74292);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(74293);
            C37752ke c37752ke = (C37752ke) c4883b;
            if (c37752ke instanceof C37752ke) {
                switch (c37752ke.cFH.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        C39056b.this.notifyDataSetChanged();
                        break;
                }
            }
            AppMethodBeat.m2505o(74293);
            return false;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(74316);
        C27966g vE = mo61974vE(i);
        AppMethodBeat.m2505o(74316);
        return vE;
    }

    public C39056b(C45939l c45939l, boolean z) {
        AppMethodBeat.m2504i(74294);
        this.mlc = false;
        this.mld = new ArrayList();
        this.mle = new ArrayList();
        this.mlf = new LinkedList();
        this.mlg = new ArrayList();
        this.mlh = false;
        this.mli = new TreeMap();
        this.mlj = new ArrayList();
        this.mlk = new LinkedList();
        this.mll = new LinkedList();
        this.mlm = new SparseArray();
        this.mln = false;
        this.mlp = false;
        this.mlq = false;
        this.query = "";
        this.hAA = new C390551();
        this.type = -1;
        this.mlm.put(1, new C39059m(c45939l));
        this.mlm.put(2, new C43067d(c45939l));
        this.mlm.put(3, new C3085q(c45939l));
        this.mlm.put(4, new C34163p(c45939l));
        this.mlm.put(5, new C43068o(c45939l));
        this.mlm.put(6, new C45933e(c45939l));
        this.mlm.put(7, new C45934g(c45939l));
        this.mlm.put(8, new C24755c(c45939l));
        this.mlm.put(10, new C28010i(c45939l));
        this.mlm.put(12, new C34161l(c45939l));
        this.mlm.put(15, new C34161l(c45939l));
        this.mlm.put(11, new C39057f(c45939l));
        this.mlm.put(14, new C11890j(c45939l));
        this.mlm.put(16, new C11892k(c45939l));
        this.mlm.put(17, new C24753b(c45939l));
        this.mlm.put(18, new C11887h(c45939l));
        this.mlm.put(-2, new C45935n(c45939l));
        if (z != this.mlp) {
            this.mlp = z;
            if (z) {
                this.mli.clear();
            }
        }
        if (!this.mlp) {
            bvX();
        }
        bvY();
        notifyDataSetChanged();
        C4879a.xxA.mo10053d(this.hAA);
        C4879a.xxA.mo10052c(this.hAA);
        AppMethodBeat.m2505o(74294);
    }

    public final void finish() {
        AppMethodBeat.m2504i(74295);
        C4879a.xxA.mo10053d(this.hAA);
        AppMethodBeat.m2505o(74295);
    }

    /* renamed from: lV */
    private void m66479lV(int i) {
        int i2 = this.jSW;
        if (i == 0) {
            this.jSW = 0;
        } else if (i2 == 0) {
            this.jSW = i;
        } else if (i2 != i) {
            this.jSW = 4;
        }
    }

    public final void bvX() {
        AppMethodBeat.m2504i(74296);
        if (bwa()) {
            C4990ab.m7418v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
            AppMethodBeat.m2505o(74296);
        } else if (C39037b.buo()) {
            C4990ab.m7420w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
            AppMethodBeat.m2505o(74296);
        } else if (this.mlp) {
            this.mle = C39056b.m66478g(this.mld, this.mlg);
            this.mlc = true;
            AppMethodBeat.m2505o(74296);
        } else {
            try {
                this.lastUpdateTime = C39037b.m66416q(this.lastUpdateTime, this.type);
                AppMethodBeat.m2505o(74296);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FavoriteAdapter", e, "", new Object[0]);
                AppMethodBeat.m2505o(74296);
            }
        }
    }

    /* renamed from: g */
    private static List<C27966g> m66478g(List<C27966g> list, List<Long> list2) {
        int i = 0;
        AppMethodBeat.m2504i(74297);
        ArrayList arrayList = new ArrayList();
        if (list2 == null) {
            AppMethodBeat.m2505o(74297);
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            Long valueOf = Long.valueOf(((C27966g) list.get(list.size() - 1)).field_localId);
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (valueOf.equals(list2.get(i2))) {
                    i = i2 + 1;
                    break;
                }
            }
        }
        int i3 = i;
        while (i3 < i + 20 && i3 < list2.size()) {
            C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(((Long) list2.get(i3)).longValue());
            if (iE != null) {
                arrayList.add(iE);
            }
            i3++;
        }
        AppMethodBeat.m2505o(74297);
        return arrayList;
    }

    private void bvZ() {
        AppMethodBeat.m2504i(74298);
        m66479lV(0);
        this.mlg = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buZ();
        AppMethodBeat.m2505o(74298);
    }

    /* renamed from: bP */
    private void m66477bP(List<C27966g> list) {
        AppMethodBeat.m2504i(74299);
        if (list == null) {
            AppMethodBeat.m2505o(74299);
            return;
        }
        C4990ab.m7411d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", Integer.valueOf(list.size()));
        C4990ab.m7411d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", Integer.valueOf(this.mlf.size()));
        list.clear();
        AppMethodBeat.m2505o(74299);
    }

    private boolean bwa() {
        AppMethodBeat.m2504i(74300);
        if (this.mlk.isEmpty() && this.mll.isEmpty() && this.mlj.isEmpty()) {
            AppMethodBeat.m2505o(74300);
            return false;
        }
        AppMethodBeat.m2505o(74300);
        return true;
    }

    /* renamed from: a */
    public final void mo61959a(boolean z, C27966g c27966g) {
        AppMethodBeat.m2504i(74301);
        if (z == this.mlh) {
            AppMethodBeat.m2505o(74301);
            return;
        }
        this.mlh = z;
        if (z) {
            this.mli.clear();
            if (c27966g != null) {
                C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c27966g.field_localId);
                if (iE != null) {
                    this.mli.put(Long.valueOf(iE.field_localId), iE);
                }
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(74301);
    }

    /* renamed from: hk */
    public final List<C27966g> mo61970hk(boolean z) {
        AppMethodBeat.m2504i(74302);
        LinkedList linkedList = new LinkedList();
        for (C27966g c27966g : this.mli.values()) {
            if (c27966g != null) {
                linkedList.add(c27966g);
            }
        }
        if (z) {
            this.mli.clear();
        }
        AppMethodBeat.m2505o(74302);
        return linkedList;
    }

    public final int bwb() {
        AppMethodBeat.m2504i(74303);
        int size = this.mli.size();
        AppMethodBeat.m2505o(74303);
        return size;
    }

    public final long bwc() {
        AppMethodBeat.m2504i(74304);
        long j = 0;
        Iterator it = this.mli.values().iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                C27966g c27966g = (C27966g) it.next();
                if (c27966g != null) {
                    j = c27966g.field_datatotalsize + j2;
                } else {
                    j = j2;
                }
            } else {
                AppMethodBeat.m2505o(74304);
                return j2;
            }
        }
    }

    /* renamed from: c */
    public final void mo61962c(List<Integer> list, List<String> list2, List<String> list3) {
        AppMethodBeat.m2504i(74305);
        m66479lV(0);
        this.mlj.clear();
        if (list != null) {
            this.mlj.addAll(list);
            if (!list.isEmpty()) {
                m66479lV(2);
            }
        }
        this.mlk.clear();
        if (list2 != null) {
            this.mlk.addAll(list2);
            if (!list2.isEmpty()) {
                m66479lV(3);
            }
        }
        this.mll.clear();
        if (list3 != null) {
            this.mll.addAll(list3);
            if (!list3.isEmpty()) {
                m66479lV(1);
            }
        }
        this.mln = true;
        bvY();
        this.mln = false;
        AppMethodBeat.m2505o(74305);
    }

    public final void bvY() {
        AppMethodBeat.m2504i(74306);
        C4990ab.m7418v("MicroMsg.FavoriteAdapter", "reset data list beg");
        this.mlc = false;
        m66477bP(this.mle);
        if (bwa()) {
            C4990ab.m7417i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", this.mlk, this.mll, this.mlj);
            this.mle = C39037b.m66349a(this.mlk, this.mll, this.mlj, this.mlf, this.mkZ, this.mla);
            int size = this.mle == null ? 0 : this.mle.size();
            C7060h.pYm.mo8381e(10649, Integer.valueOf(size));
        } else {
            C4990ab.m7417i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type));
            if (this.mlp) {
                bvZ();
                this.mle = C39056b.m66478g(null, this.mlg);
            } else {
                this.mle = C39037b.m66350a(this.lastUpdateTime, this.type, this.mkZ, this.mla);
                if (this.mle != null && this.lastUpdateTime == 0 && this.mle.size() > 0) {
                    this.lastUpdateTime = ((C27966g) this.mle.get(this.mle.size() - 1)).field_updateTime;
                }
            }
        }
        if (this.mle == null) {
            C4990ab.m7420w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
            this.mle = new ArrayList();
        }
        if (!(this.mlp || bwa() || this.mle.size() >= 20 || ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23695t(this.lastUpdateTime, this.type))) {
            C4990ab.m7418v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
            bvX();
        }
        this.mlc = true;
        C4990ab.m7418v("MicroMsg.FavoriteAdapter", "reset data list end");
        AppMethodBeat.m2505o(74306);
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(74307);
        boolean isEmpty = this.mld.isEmpty();
        AppMethodBeat.m2505o(74307);
        return isEmpty;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(74308);
        C4990ab.m7419v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", Boolean.valueOf(this.mlc));
        if (this.mlc) {
            if (this.mlp && this.mle != null && this.mld != null && this.mle.size() == this.mld.size()) {
                this.mlq = true;
            }
            List list = this.mld;
            this.mld = this.mle;
            this.mle = list;
            this.mlc = false;
        }
        C4990ab.m7418v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(74308);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(74309);
        if (i == 0) {
            AppMethodBeat.m2505o(74309);
            return 0;
        }
        C27966g vE = mo61974vE(i - 1);
        switch (vE.field_type) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                int i2 = vE.field_type;
                AppMethodBeat.m2505o(74309);
                return i2;
            default:
                C4990ab.m7421w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", Integer.valueOf(vE.field_type));
                AppMethodBeat.m2505o(74309);
                return -2;
        }
    }

    public final int getViewTypeCount() {
        AppMethodBeat.m2504i(74310);
        int size = this.mlm.size() + 4;
        AppMethodBeat.m2505o(74310);
        return size;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(74311);
        View view2;
        if (i == 0) {
            view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new LayoutParams(0, 0));
            view2.setBackgroundResource(C25738R.color.f11995ov);
            view2.setPadding(0, 0, 0, 0);
            view2.setEnabled(false);
            AppMethodBeat.m2505o(74311);
            return view2;
        }
        C27966g vE = mo61974vE(i - 1);
        C20714a c20714a = (C20714a) this.mlm.get(vE.field_type);
        if (c20714a == null) {
            C4990ab.m7421w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", Integer.valueOf(vE.field_type));
            c20714a = (C20714a) this.mlm.get(-2);
            bvW();
            view2 = c20714a.mo7336a(view, viewGroup, vE);
            AppMethodBeat.m2505o(74311);
            return view2;
        }
        c20714a.moE.jLC = bwa();
        c20714a.moE.lastUpdateTime = this.lastUpdateTime;
        c20714a.moE.mlh = this.mlh;
        c20714a.moE.mli = this.mli;
        c20714a.moE.moG = this.mlo;
        c20714a.moE.mlp = this.mlp;
        view2 = c20714a.mo7336a(view, viewGroup, vE);
        AppMethodBeat.m2505o(74311);
        return view2;
    }

    /* renamed from: vE */
    public final C27966g mo61974vE(int i) {
        AppMethodBeat.m2504i(74312);
        C27966g c27966g;
        if (i < 0 || i >= this.mld.size()) {
            C4990ab.m7412e("MicroMsg.FavoriteAdapter", "get item, but position error");
            c27966g = new C27966g();
            AppMethodBeat.m2505o(74312);
            return c27966g;
        }
        c27966g = (C27966g) this.mld.get(i);
        AppMethodBeat.m2505o(74312);
        return c27966g;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(74313);
        int size = this.mld.size() + 1;
        AppMethodBeat.m2505o(74313);
        return size;
    }

    /* renamed from: iK */
    public final int mo61971iK(long j) {
        int i = 0;
        AppMethodBeat.m2504i(74314);
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
        if (iE == null) {
            AppMethodBeat.m2505o(74314);
            return -1;
        } else if (this.mli.size() >= 30) {
            C4990ab.m7421w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", Integer.valueOf(30));
            C30379h.m48465bQ(C4996ah.getContext(), C4996ah.getContext().getResources().getString(C25738R.string.bpm, new Object[]{Integer.valueOf(30)}));
            AppMethodBeat.m2505o(74314);
            return -1;
        } else {
            this.mli.put(Long.valueOf(j), iE);
            if (iE.field_updateTime < this.lastUpdateTime) {
                this.lastUpdateTime = iE.field_updateTime;
                bvY();
                for (C27966g iE2 : this.mle) {
                    if (iE2.field_localId == j) {
                        notifyDataSetChanged();
                        AppMethodBeat.m2505o(74314);
                        return i;
                    }
                    i++;
                }
                notifyDataSetChanged();
            } else {
                for (C27966g iE22 : this.mld) {
                    if (iE22.field_localId == j) {
                        notifyDataSetChanged();
                        AppMethodBeat.m2505o(74314);
                        return i;
                    }
                    i++;
                }
            }
            AppMethodBeat.m2505o(74314);
            return -1;
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(74315);
        C3084b c3084b = (C3084b) view.getTag();
        if (c3084b == null) {
            C4990ab.m7420w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
            AppMethodBeat.m2505o(74315);
        } else if (c3084b.mgf == null) {
            C4990ab.m7420w("MicroMsg.FavoriteAdapter", "on item click, info is null");
            AppMethodBeat.m2505o(74315);
        } else if (!this.mlh && !this.mlp) {
            C20714a c20714a = (C20714a) this.mlm.get(c3084b.mgf.field_type);
            if (c20714a != null) {
                StringBuilder stringBuilder = new StringBuilder();
                C27966g c27966g = c3084b.mgf;
                String str = c27966g.field_id + "_" + (System.currentTimeMillis() / 1000);
                LinkedList<String> linkedList = c27966g.field_tagProto.wiJ;
                if (!C5046bo.m7548ek(linkedList)) {
                    for (String append : linkedList) {
                        stringBuilder.append(append).append(";");
                    }
                }
                abh abh = new abh();
                abh.scene = this.scene;
                abh.jSW = this.jSW;
                if (this.mlr != null) {
                    abh.index = i - this.mlr.getHeaderViewsCount();
                } else {
                    abh.index = i;
                }
                abh.query = this.query;
                abh.cvF = str;
                abh.mfg = stringBuilder.toString();
                c20714a.mo7337a(view, abh);
                C4990ab.m7411d("MicroMsg.FavoriteAdapter", "item click type %s", Integer.valueOf(c3084b.mgf.field_type));
            }
            AppMethodBeat.m2505o(74315);
        } else if (c3084b.gnD.isChecked() || this.mli.size() < 30) {
            c3084b.gnD.setChecked(!c3084b.gnD.isChecked());
            AppMethodBeat.m2505o(74315);
        } else {
            C4990ab.m7421w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", Integer.valueOf(30));
            C30379h.m48465bQ(C4996ah.getContext(), C4996ah.getContext().getResources().getString(C25738R.string.bpm, new Object[]{Integer.valueOf(30)}));
            AppMethodBeat.m2505o(74315);
        }
    }
}
