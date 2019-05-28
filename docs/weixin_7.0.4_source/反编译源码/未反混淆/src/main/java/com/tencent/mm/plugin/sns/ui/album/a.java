package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a extends android.support.v7.widget.RecyclerView.a {
    String edV = "";
    private String mBP = null;
    Context mContext = null;
    private final int rFd = 0;
    private final int rFe = 1;
    private final int rFf = 2;
    List<b> rFg = new ArrayList();
    String rFh = "";
    String rFi = "";
    boolean rFj = false;
    private long rFk = 0;
    private long rFl = 0;
    int rFm = 0;
    boolean rFn = false;
    int rFo = 0;
    private b rFp = null;
    com.tencent.mm.plugin.sns.ui.album.c.a rFq = null;
    a rFr = null;
    private boolean rjn = false;

    public interface a {
        void du(List<b> list);
    }

    public static class b {
        public String label = "";
        public List<n> rFt = new ArrayList();

        public b() {
            AppMethodBeat.i(39960);
            AppMethodBeat.o(39960);
        }

        public final String toString() {
            AppMethodBeat.i(39961);
            StringBuilder stringBuilder = new StringBuilder();
            for (n nVar : this.rFt) {
                stringBuilder.append("\t[localId=").append(nVar.reX).append(", snsId=").append(nVar.field_snsId).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            String str = this.label + IOUtils.LINE_SEPARATOR_UNIX + stringBuilder.toString();
            AppMethodBeat.o(39961);
            return str;
        }
    }

    class e extends v {
        private TextView rFw = null;
        private WeImageView rFx = null;

        public e(View view) {
            super(view);
            AppMethodBeat.i(39964);
            this.rFw = (TextView) view.findViewById(R.id.egm);
            this.rFx = (WeImageView) view.findViewById(R.id.egn);
            this.rFw.setOnClickListener(new OnClickListener(a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(39963);
                    a aVar = a.this;
                    Intent intent = new Intent(aVar.mContext, SnsUserUI.class);
                    intent.putExtra("sns_userName", aVar.edV);
                    aVar.mContext.startActivity(intent);
                    AppMethodBeat.o(39963);
                }
            });
            AppMethodBeat.o(39964);
        }
    }

    class c extends v {
        LoadingMoreView rFu = null;

        public c(View view) {
            super(view);
            AppMethodBeat.i(39962);
            this.rFu = (LoadingMoreView) view.findViewById(R.id.egi);
            AppMethodBeat.o(39962);
        }
    }

    class f extends v {
        TextView gnf = null;
        GridLayoutManager iYH = null;
        c rFA = null;
        RecyclerView rFB = null;
        private LinearLayout rvN = null;
        TextView timeTv = null;

        public f(View view) {
            super(view);
            AppMethodBeat.i(39965);
            this.gnf = (TextView) view.findViewById(R.id.ege);
            this.timeTv = (TextView) view.findViewById(R.id.egg);
            this.rFB = (RecyclerView) view.findViewById(R.id.egh);
            this.iYH = new GridLayoutManager(3);
            this.rFA = new c();
            this.rFA.rFE = a.this.rFq;
            AppMethodBeat.o(39965);
        }
    }

    public static class d {
        public int cNE = 0;
        public bau rFv = null;
    }

    public a(Context context, String str, a aVar) {
        AppMethodBeat.i(39966);
        this.mContext = context;
        this.rFr = aVar;
        String g = aa.g(this.mContext.getSharedPreferences(ah.doA(), 0));
        ab.d("MicroMsg.SnsAlbumAdapter", "filterLan temp ".concat(String.valueOf(g)));
        if (!(g.equals("zh_CN") || g.equals("en") || g.equals("zh_TW"))) {
            g = g.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.mBP = g;
        this.edV = str;
        g.RQ();
        if (this.edV.equals((String) g.RP().Ry().get(2, null))) {
            this.rjn = true;
        }
        this.rFp = new b(new com.tencent.mm.plugin.sns.ui.album.b.a() {
            public final void dt(List<b> list) {
                int i = 0;
                AppMethodBeat.i(39959);
                String str = "MicroMsg.SnsAlbumAdapter";
                String str2 = "onLoadingFinish list.size=%s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
                ab.d(str, str2, objArr);
                a.this.rFg.clear();
                b bVar = new b();
                bVar.label = "my_timeline";
                a.this.rFg.add(bVar);
                a.this.rFg.addAll(list);
                a aVar = a.this;
                for (b bVar2 : a.this.rFg) {
                    i += bVar2.rFt.size();
                }
                aVar.rFo = i;
                if (!list.isEmpty()) {
                    bVar2 = new b();
                    bVar2.label = "loading";
                    a.this.rFg.add(bVar2);
                }
                a.this.aop.notifyChanged();
                if (a.this.rFr != null) {
                    a.this.rFr.du(list);
                }
                AppMethodBeat.o(39959);
            }
        }, this.edV, this.rjn);
        kJ(0);
        ab.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", this.rFi);
        ll(false);
        AppMethodBeat.o(39966);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(39967);
        int i2 = "loading".equals(((b) this.rFg.get(i)).label) ? 1 : "my_timeline".equals(((b) this.rFg.get(i)).label) ? 2 : 0;
        AppMethodBeat.o(39967);
        return i2;
    }

    public final v a(ViewGroup viewGroup, int i) {
        v cVar;
        AppMethodBeat.i(39968);
        ab.d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", Integer.valueOf(i));
        if (i == 1) {
            cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aun, viewGroup, false));
        } else if (i == 2) {
            cVar = new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aup, viewGroup, false));
        } else {
            cVar = new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aum, viewGroup, false));
        }
        AppMethodBeat.o(39968);
        return cVar;
    }

    public final void a(v vVar, int i) {
        AppMethodBeat.i(39969);
        ab.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", Integer.valueOf(i));
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            ab.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
            if (a.this.rFn) {
                cVar.rFu.setVisibility(0);
                cVar.rFu.lc(false);
                AppMethodBeat.o(39969);
                return;
            }
            int i2 = a.this.rFo;
            af.cnv();
            if (i2 >= 30) {
                cVar.rFu.setVisibility(0);
                AppMethodBeat.o(39969);
                return;
            }
            cVar.rFu.setVisibility(8);
            AppMethodBeat.o(39969);
            return;
        }
        if (vVar instanceof f) {
            b bVar;
            int i3;
            f fVar = (f) vVar;
            b bVar2 = (b) a.this.rFg.get(i);
            if (i > 1) {
                bVar = (b) a.this.rFg.get(i - 1);
            } else {
                bVar = null;
            }
            int i4 = ((n) bVar2.rFt.get(0)).field_head;
            if (bVar == null) {
                i3 = 0;
            } else {
                i3 = ((n) bVar.rFt.get(0)).field_head;
            }
            int i5 = i4 / Downloads.MIN_WAIT_FOR_NETWORK;
            int i6 = i3 / Downloads.MIN_WAIT_FOR_NETWORK;
            ab.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", Integer.valueOf(i3), Integer.valueOf(i4));
            LayoutParams layoutParams;
            MarginLayoutParams marginLayoutParams;
            if ((i3 != 0 || i5 == aw.getYear()) && (i3 == 0 || i5 == i6)) {
                fVar.gnf.setVisibility(8);
                layoutParams = fVar.apJ.getLayoutParams();
                if (layoutParams instanceof MarginLayoutParams) {
                    marginLayoutParams = (MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = com.tencent.mm.bz.a.am(fVar.gnf.getContext(), R.dimen.f15do);
                    fVar.apJ.setLayoutParams(marginLayoutParams);
                }
            } else {
                fVar.gnf.setText(String.format(a.this.mContext.getResources().getString(R.string.eqj), new Object[]{Integer.valueOf(i5)}));
                fVar.gnf.setVisibility(0);
                layoutParams = fVar.apJ.getLayoutParams();
                if (layoutParams instanceof MarginLayoutParams) {
                    marginLayoutParams = (MarginLayoutParams) layoutParams;
                    if (i3 != 0) {
                        marginLayoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(fVar.gnf.getContext(), 70);
                    } else {
                        marginLayoutParams.topMargin = com.tencent.mm.bz.a.am(fVar.gnf.getContext(), R.dimen.f15do);
                    }
                    fVar.apJ.setLayoutParams(marginLayoutParams);
                }
            }
            String str = bVar2.label;
            if (str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) != -1) {
                String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (split.length > 1) {
                    fVar.timeTv.setText(split[1]);
                }
            } else {
                fVar.timeTv.setText(str);
            }
            fVar.rFB.setLayoutManager(fVar.iYH);
            fVar.rFB.setAdapter(fVar.rFA);
            c cVar2 = fVar.rFA;
            List<n> list = bVar2.rFt;
            cVar2.rFD.clear();
            for (n nVar : list) {
                Iterator it = nVar.cqu().xfI.wbK.iterator();
                while (it.hasNext()) {
                    bau bau = (bau) it.next();
                    d dVar = new d();
                    dVar.cNE = nVar.reX;
                    dVar.rFv = bau;
                    cVar2.rFD.add(dVar);
                }
            }
            cVar2.aop.notifyChanged();
        }
        AppMethodBeat.o(39969);
    }

    public final int getItemCount() {
        AppMethodBeat.i(39970);
        int size = this.rFg.size();
        AppMethodBeat.o(39970);
        return size;
    }

    public final void cuS() {
        AppMethodBeat.i(39971);
        ab.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsAll ");
        this.rFn = true;
        AppMethodBeat.o(39971);
    }

    public final void ctK() {
        long j;
        AppMethodBeat.i(39972);
        ab.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
        if (this.rFg.size() > 1) {
            List list = ((b) this.rFg.get(this.rFg.size() - 2)).rFt;
            if (!list.isEmpty()) {
                j = ((n) list.get(list.size() - 1)).field_snsId;
                kJ(j);
                AppMethodBeat.o(39972);
            }
        }
        j = 0;
        kJ(j);
        AppMethodBeat.o(39972);
    }

    private void kJ(long j) {
        a aVar;
        AppMethodBeat.i(39973);
        af.cnv();
        String jW = i.jW(af.cnF().d(j, this.edV, this.rjn));
        if (this.rFh.equals("")) {
            aVar = this;
        } else if (jW.compareTo(this.rFh) < 0) {
            aVar = this;
        } else {
            jW = this.rFh;
            aVar = this;
        }
        aVar.rFi = jW;
        aao cqL = af.cnJ().YX(this.edV).cqL();
        if (cqL.wfM == 0) {
            AppMethodBeat.o(39973);
            return;
        }
        jW = i.jW(cqL.wfM);
        if (this.rFi.equals("")) {
            this.rFi = jW;
            AppMethodBeat.o(39973);
            return;
        }
        ab.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", Long.valueOf(j), this.rFi);
        if (jW.compareTo(this.rFi) <= 0) {
            jW = this.rFi;
        }
        this.rFi = jW;
        AppMethodBeat.o(39973);
    }

    public final void ll(boolean z) {
        AppMethodBeat.i(39974);
        ab.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.rFi);
        if (this.rFp != null) {
            this.rFp.g(this.rFi, this.rFj, z);
        }
        AppMethodBeat.o(39974);
    }

    public final void kI(long j) {
        if (0 == this.rFk) {
            this.rFk = j;
            this.rFl = 0;
        }
    }

    public final ArrayList<com.tencent.mm.plugin.sns.h.b> bh(int i, String str) {
        AppMethodBeat.i(39975);
        ab.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", Integer.valueOf(i));
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.rFg.size()) {
                for (n nVar : ((b) this.rFg.get(i3)).rFt) {
                    int i4 = nVar.reX;
                    if (nVar.cqu() != null && nVar.cqu().xfI != null && nVar.cqu().xfI.wbK.size() != 0) {
                        if (nVar.cqu().xfI.wbJ == 1 || nVar.cqu().xfI.wbJ == 15) {
                            if (i4 == i) {
                                ab.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", Integer.valueOf(this.rFm));
                                this.rFm = arrayList.size();
                            }
                            int i5 = 0;
                            Iterator it = nVar.cqu().xfI.wbK.iterator();
                            while (true) {
                                int i6 = i5;
                                if (!it.hasNext()) {
                                    break;
                                }
                                bau bau = (bau) it.next();
                                if (bo.isEqual(bau.Id, str)) {
                                    this.rFm += i6;
                                }
                                com.tencent.mm.plugin.sns.h.b bVar = new com.tencent.mm.plugin.sns.h.b();
                                bVar.cNr = bau;
                                bVar.qQd = com.tencent.mm.plugin.sns.storage.v.ap("sns_table_", (long) i4);
                                bVar.fDG = nVar.field_createTime;
                                i5 = i6 + 1;
                                bVar.qQe = i6;
                                arrayList.add(bVar);
                            }
                        }
                    }
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(39975);
                return arrayList;
            }
        }
    }
}
