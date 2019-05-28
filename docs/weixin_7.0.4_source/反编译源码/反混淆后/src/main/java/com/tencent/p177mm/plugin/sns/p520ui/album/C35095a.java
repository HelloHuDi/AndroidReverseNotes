package com.tencent.p177mm.plugin.sns.p520ui.album;

import android.content.Context;
import android.content.Intent;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.imageview.WeImageView;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p1025h.C34937b;
import com.tencent.p177mm.plugin.sns.p520ui.C29198aw;
import com.tencent.p177mm.plugin.sns.p520ui.LoadingMoreView;
import com.tencent.p177mm.plugin.sns.p520ui.SnsUserUI;
import com.tencent.p177mm.plugin.sns.p520ui.album.C35101c.C35103a;
import com.tencent.p177mm.plugin.sns.p520ui.album.C36813b.C36814a;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.aao;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.album.a */
public final class C35095a extends C41523a {
    String edV = "";
    private String mBP = null;
    Context mContext = null;
    private final int rFd = 0;
    private final int rFe = 1;
    private final int rFf = 2;
    List<C29189b> rFg = new ArrayList();
    String rFh = "";
    String rFi = "";
    boolean rFj = false;
    private long rFk = 0;
    private long rFl = 0;
    int rFm = 0;
    boolean rFn = false;
    int rFo = 0;
    private C36813b rFp = null;
    C35103a rFq = null;
    C22059a rFr = null;
    private boolean rjn = false;

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.a$a */
    public interface C22059a {
        /* renamed from: du */
        void mo37614du(List<C29189b> list);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.a$b */
    public static class C29189b {
        public String label = "";
        public List<C46236n> rFt = new ArrayList();

        public C29189b() {
            AppMethodBeat.m2504i(39960);
            AppMethodBeat.m2505o(39960);
        }

        public final String toString() {
            AppMethodBeat.m2504i(39961);
            StringBuilder stringBuilder = new StringBuilder();
            for (C46236n c46236n : this.rFt) {
                stringBuilder.append("\t[localId=").append(c46236n.reX).append(", snsId=").append(c46236n.field_snsId).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            String str = this.label + IOUtils.LINE_SEPARATOR_UNIX + stringBuilder.toString();
            AppMethodBeat.m2505o(39961);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.a$e */
    class C35096e extends C41531v {
        private TextView rFw = null;
        private WeImageView rFx = null;

        public C35096e(View view) {
            super(view);
            AppMethodBeat.m2504i(39964);
            this.rFw = (TextView) view.findViewById(2131827670);
            this.rFx = (WeImageView) view.findViewById(2131827671);
            this.rFw.setOnClickListener(new OnClickListener(C35095a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(39963);
                    C35095a c35095a = C35095a.this;
                    Intent intent = new Intent(c35095a.mContext, SnsUserUI.class);
                    intent.putExtra("sns_userName", c35095a.edV);
                    c35095a.mContext.startActivity(intent);
                    AppMethodBeat.m2505o(39963);
                }
            });
            AppMethodBeat.m2505o(39964);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.a$c */
    class C35097c extends C41531v {
        LoadingMoreView rFu = null;

        public C35097c(View view) {
            super(view);
            AppMethodBeat.m2504i(39962);
            this.rFu = (LoadingMoreView) view.findViewById(2131827666);
            AppMethodBeat.m2505o(39962);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.a$f */
    class C35098f extends C41531v {
        TextView gnf = null;
        GridLayoutManager iYH = null;
        C35101c rFA = null;
        RecyclerView rFB = null;
        private LinearLayout rvN = null;
        TextView timeTv = null;

        public C35098f(View view) {
            super(view);
            AppMethodBeat.m2504i(39965);
            this.gnf = (TextView) view.findViewById(2131827662);
            this.timeTv = (TextView) view.findViewById(2131827664);
            this.rFB = (RecyclerView) view.findViewById(2131827665);
            this.iYH = new GridLayoutManager(3);
            this.rFA = new C35101c();
            this.rFA.rFE = C35095a.this.rFq;
            AppMethodBeat.m2505o(39965);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.a$1 */
    class C350991 implements C36814a {
        C350991() {
        }

        /* renamed from: dt */
        public final void mo55735dt(List<C29189b> list) {
            int i = 0;
            AppMethodBeat.m2504i(39959);
            String str = "MicroMsg.SnsAlbumAdapter";
            String str2 = "onLoadingFinish list.size=%s";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            C4990ab.m7411d(str, str2, objArr);
            C35095a.this.rFg.clear();
            C29189b c29189b = new C29189b();
            c29189b.label = "my_timeline";
            C35095a.this.rFg.add(c29189b);
            C35095a.this.rFg.addAll(list);
            C35095a c35095a = C35095a.this;
            for (C29189b c29189b2 : C35095a.this.rFg) {
                i += c29189b2.rFt.size();
            }
            c35095a.rFo = i;
            if (!list.isEmpty()) {
                c29189b2 = new C29189b();
                c29189b2.label = "loading";
                C35095a.this.rFg.add(c29189b2);
            }
            C35095a.this.aop.notifyChanged();
            if (C35095a.this.rFr != null) {
                C35095a.this.rFr.mo37614du(list);
            }
            AppMethodBeat.m2505o(39959);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.a$d */
    public static class C35100d {
        public int cNE = 0;
        public bau rFv = null;
    }

    public C35095a(Context context, String str, C22059a c22059a) {
        AppMethodBeat.m2504i(39966);
        this.mContext = context;
        this.rFr = c22059a;
        String g = C4988aa.m7402g(this.mContext.getSharedPreferences(C4996ah.doA(), 0));
        C4990ab.m7410d("MicroMsg.SnsAlbumAdapter", "filterLan temp ".concat(String.valueOf(g)));
        if (!(g.equals("zh_CN") || g.equals("en") || g.equals("zh_TW"))) {
            g = g.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.mBP = g;
        this.edV = str;
        C1720g.m3537RQ();
        if (this.edV.equals((String) C1720g.m3536RP().mo5239Ry().get(2, null))) {
            this.rjn = true;
        }
        this.rFp = new C36813b(new C350991(), this.edV, this.rjn);
        m57703kJ(0);
        C4990ab.m7411d("MicroMsg.SnsAlbumAdapter", "limitId=%s", this.rFi);
        mo55734ll(false);
        AppMethodBeat.m2505o(39966);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(39967);
        int i2 = "loading".equals(((C29189b) this.rFg.get(i)).label) ? 1 : "my_timeline".equals(((C29189b) this.rFg.get(i)).label) ? 2 : 0;
        AppMethodBeat.m2505o(39967);
        return i2;
    }

    /* renamed from: a */
    public final C41531v mo4976a(ViewGroup viewGroup, int i) {
        C41531v c35097c;
        AppMethodBeat.m2504i(39968);
        C4990ab.m7411d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", Integer.valueOf(i));
        if (i == 1) {
            c35097c = new C35097c(LayoutInflater.from(viewGroup.getContext()).inflate(2130970740, viewGroup, false));
        } else if (i == 2) {
            c35097c = new C35096e(LayoutInflater.from(viewGroup.getContext()).inflate(2130970742, viewGroup, false));
        } else {
            c35097c = new C35098f(LayoutInflater.from(viewGroup.getContext()).inflate(2130970739, viewGroup, false));
        }
        AppMethodBeat.m2505o(39968);
        return c35097c;
    }

    /* renamed from: a */
    public final void mo4977a(C41531v c41531v, int i) {
        AppMethodBeat.m2504i(39969);
        C4990ab.m7411d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", Integer.valueOf(i));
        if (c41531v instanceof C35097c) {
            C35097c c35097c = (C35097c) c41531v;
            C4990ab.m7410d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
            if (C35095a.this.rFn) {
                c35097c.rFu.setVisibility(0);
                c35097c.rFu.mo55600lc(false);
                AppMethodBeat.m2505o(39969);
                return;
            }
            int i2 = C35095a.this.rFo;
            C13373af.cnv();
            if (i2 >= 30) {
                c35097c.rFu.setVisibility(0);
                AppMethodBeat.m2505o(39969);
                return;
            }
            c35097c.rFu.setVisibility(8);
            AppMethodBeat.m2505o(39969);
            return;
        }
        if (c41531v instanceof C35098f) {
            C29189b c29189b;
            int i3;
            C35098f c35098f = (C35098f) c41531v;
            C29189b c29189b2 = (C29189b) C35095a.this.rFg.get(i);
            if (i > 1) {
                c29189b = (C29189b) C35095a.this.rFg.get(i - 1);
            } else {
                c29189b = null;
            }
            int i4 = ((C46236n) c29189b2.rFt.get(0)).field_head;
            if (c29189b == null) {
                i3 = 0;
            } else {
                i3 = ((C46236n) c29189b.rFt.get(0)).field_head;
            }
            int i5 = i4 / Downloads.MIN_WAIT_FOR_NETWORK;
            int i6 = i3 / Downloads.MIN_WAIT_FOR_NETWORK;
            C4990ab.m7411d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", Integer.valueOf(i3), Integer.valueOf(i4));
            LayoutParams layoutParams;
            MarginLayoutParams marginLayoutParams;
            if ((i3 != 0 || i5 == C29198aw.getYear()) && (i3 == 0 || i5 == i6)) {
                c35098f.gnf.setVisibility(8);
                layoutParams = c35098f.apJ.getLayoutParams();
                if (layoutParams instanceof MarginLayoutParams) {
                    marginLayoutParams = (MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = C1338a.m2857am(c35098f.gnf.getContext(), C25738R.dimen.f9723do);
                    c35098f.apJ.setLayoutParams(marginLayoutParams);
                }
            } else {
                c35098f.gnf.setText(String.format(C35095a.this.mContext.getResources().getString(C25738R.string.eqj), new Object[]{Integer.valueOf(i5)}));
                c35098f.gnf.setVisibility(0);
                layoutParams = c35098f.apJ.getLayoutParams();
                if (layoutParams instanceof MarginLayoutParams) {
                    marginLayoutParams = (MarginLayoutParams) layoutParams;
                    if (i3 != 0) {
                        marginLayoutParams.topMargin = C1338a.fromDPToPix(c35098f.gnf.getContext(), 70);
                    } else {
                        marginLayoutParams.topMargin = C1338a.m2857am(c35098f.gnf.getContext(), C25738R.dimen.f9723do);
                    }
                    c35098f.apJ.setLayoutParams(marginLayoutParams);
                }
            }
            String str = c29189b2.label;
            if (str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) != -1) {
                String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (split.length > 1) {
                    c35098f.timeTv.setText(split[1]);
                }
            } else {
                c35098f.timeTv.setText(str);
            }
            c35098f.rFB.setLayoutManager(c35098f.iYH);
            c35098f.rFB.setAdapter(c35098f.rFA);
            C35101c c35101c = c35098f.rFA;
            List<C46236n> list = c29189b2.rFt;
            c35101c.rFD.clear();
            for (C46236n c46236n : list) {
                Iterator it = c46236n.cqu().xfI.wbK.iterator();
                while (it.hasNext()) {
                    bau bau = (bau) it.next();
                    C35100d c35100d = new C35100d();
                    c35100d.cNE = c46236n.reX;
                    c35100d.rFv = bau;
                    c35101c.rFD.add(c35100d);
                }
            }
            c35101c.aop.notifyChanged();
        }
        AppMethodBeat.m2505o(39969);
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(39970);
        int size = this.rFg.size();
        AppMethodBeat.m2505o(39970);
        return size;
    }

    public final void cuS() {
        AppMethodBeat.m2504i(39971);
        C4990ab.m7410d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsAll ");
        this.rFn = true;
        AppMethodBeat.m2505o(39971);
    }

    public final void ctK() {
        long j;
        AppMethodBeat.m2504i(39972);
        C4990ab.m7410d("MicroMsg.SnsAlbumAdapter", "i addSize ");
        if (this.rFg.size() > 1) {
            List list = ((C29189b) this.rFg.get(this.rFg.size() - 2)).rFt;
            if (!list.isEmpty()) {
                j = ((C46236n) list.get(list.size() - 1)).field_snsId;
                m57703kJ(j);
                AppMethodBeat.m2505o(39972);
            }
        }
        j = 0;
        m57703kJ(j);
        AppMethodBeat.m2505o(39972);
    }

    /* renamed from: kJ */
    private void m57703kJ(long j) {
        C35095a c35095a;
        AppMethodBeat.m2504i(39973);
        C13373af.cnv();
        String jW = C29036i.m46118jW(C13373af.cnF().mo62934d(j, this.edV, this.rjn));
        if (this.rFh.equals("")) {
            c35095a = this;
        } else if (jW.compareTo(this.rFh) < 0) {
            c35095a = this;
        } else {
            jW = this.rFh;
            c35095a = this;
        }
        c35095a.rFi = jW;
        aao cqL = C13373af.cnJ().mo69179YX(this.edV).cqL();
        if (cqL.wfM == 0) {
            AppMethodBeat.m2505o(39973);
            return;
        }
        jW = C29036i.m46118jW(cqL.wfM);
        if (this.rFi.equals("")) {
            this.rFi = jW;
            AppMethodBeat.m2505o(39973);
            return;
        }
        C4990ab.m7411d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", Long.valueOf(j), this.rFi);
        if (jW.compareTo(this.rFi) <= 0) {
            jW = this.rFi;
        }
        this.rFi = jW;
        AppMethodBeat.m2505o(39973);
    }

    /* renamed from: ll */
    public final void mo55734ll(boolean z) {
        AppMethodBeat.m2504i(39974);
        C4990ab.m7410d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.rFi);
        if (this.rFp != null) {
            this.rFp.mo58677g(this.rFi, this.rFj, z);
        }
        AppMethodBeat.m2505o(39974);
    }

    /* renamed from: kI */
    public final void mo55733kI(long j) {
        if (0 == this.rFk) {
            this.rFk = j;
            this.rFl = 0;
        }
    }

    /* renamed from: bh */
    public final ArrayList<C34937b> mo55730bh(int i, String str) {
        AppMethodBeat.m2504i(39975);
        C4990ab.m7411d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", Integer.valueOf(i));
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.rFg.size()) {
                for (C46236n c46236n : ((C29189b) this.rFg.get(i3)).rFt) {
                    int i4 = c46236n.reX;
                    if (c46236n.cqu() != null && c46236n.cqu().xfI != null && c46236n.cqu().xfI.wbK.size() != 0) {
                        if (c46236n.cqu().xfI.wbJ == 1 || c46236n.cqu().xfI.wbJ == 15) {
                            if (i4 == i) {
                                C4990ab.m7411d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", Integer.valueOf(this.rFm));
                                this.rFm = arrayList.size();
                            }
                            int i5 = 0;
                            Iterator it = c46236n.cqu().xfI.wbK.iterator();
                            while (true) {
                                int i6 = i5;
                                if (!it.hasNext()) {
                                    break;
                                }
                                bau bau = (bau) it.next();
                                if (C5046bo.isEqual(bau.f17915Id, str)) {
                                    this.rFm += i6;
                                }
                                C34937b c34937b = new C34937b();
                                c34937b.cNr = bau;
                                c34937b.qQd = C35002v.m57490ap("sns_table_", (long) i4);
                                c34937b.fDG = c46236n.field_createTime;
                                i5 = i6 + 1;
                                c34937b.qQe = i6;
                                arrayList.add(c34937b);
                            }
                        }
                    }
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(39975);
                return arrayList;
            }
        }
    }
}
