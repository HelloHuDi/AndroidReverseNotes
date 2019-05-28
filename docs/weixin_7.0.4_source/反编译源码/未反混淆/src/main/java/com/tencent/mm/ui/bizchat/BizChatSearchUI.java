package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.a.l;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.protocal.protobuf.ki;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.protocal.protobuf.kk;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class BizChatSearchUI extends MMActivity implements com.tencent.mm.modelvoiceaddr.ui.b.a, com.tencent.mm.ui.bizchat.BizChatSearchListView.a {
    com.tencent.mm.modelvoiceaddr.ui.b jLK;
    String jMp;
    private OnScrollListener nfn = new OnScrollListener() {
        boolean jLx = false;

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(30135);
            if (i == 0 && this.jLx && BizChatSearchUI.this.yEA.yEP) {
                a a = BizChatSearchUI.this.yEA;
                if (a.dAS() && !a.yER) {
                    a.yER = true;
                    aw.Rg().a(new l(a.jMp, a.ema, a.yEV), 0);
                    a.dAW();
                }
            }
            AppMethodBeat.o(30135);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 == i3) {
                this.jLx = true;
            } else {
                this.jLx = false;
            }
        }
    };
    private int scene;
    private a yEA;
    private String yEw;
    private c yEx;
    private BizChatSearchListView yEy;
    private TextView yEz;

    static class b {
        public View contentView;
        public TextView kxr;
        public View mKk;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static class c {
        private View jLA;
        private View jLB;
        private View jLz;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final View hQ(Context context) {
            AppMethodBeat.i(30156);
            View inflate = View.inflate(context, R.layout.a_2, null);
            this.jLz = inflate.findViewById(R.id.cpl);
            this.jLA = inflate.findViewById(R.id.ai5);
            this.jLB = inflate.findViewById(R.id.cpm);
            this.jLz.setVisibility(8);
            this.jLA.setVisibility(8);
            this.jLB.setVisibility(8);
            AppMethodBeat.o(30156);
            return inflate;
        }

        public final void sd(int i) {
            AppMethodBeat.i(30157);
            switch (i) {
                case 1:
                    w(true, false);
                    AppMethodBeat.o(30157);
                    return;
                case 2:
                    w(false, true);
                    AppMethodBeat.o(30157);
                    return;
                default:
                    w(false, false);
                    AppMethodBeat.o(30157);
                    return;
            }
        }

        private void w(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            AppMethodBeat.i(30158);
            View view = this.jLz;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            this.jLA.setVisibility(8);
            View view2 = this.jLB;
            if (!z2) {
                i2 = 8;
            }
            view2.setVisibility(i2);
            AppMethodBeat.o(30158);
        }
    }

    static class a extends BaseAdapter implements com.tencent.mm.ai.f {
        public static int yEC = 3;
        private int afg = 0;
        private Context context;
        String ema;
        private com.tencent.mm.at.a.a.c fGS;
        String jMp;
        private int scene;
        private int yED;
        boolean yEE;
        boolean yEF;
        private ArrayList<com.tencent.mm.aj.a.c> yEG = new ArrayList();
        private ArrayList<Object> yEH = new ArrayList();
        private ArrayList<com.tencent.mm.aj.a.c> yEI = new ArrayList();
        private g yEJ;
        private ArrayList<g> yEK = new ArrayList();
        private g yEL;
        private g yEM;
        private ArrayList<g> yEN = new ArrayList();
        private g yEO;
        public boolean yEP = true;
        public boolean yEQ = false;
        public boolean yER = false;
        private boolean yES = true;
        private int yET = 0;
        public boolean yEU = false;
        int yEV = 0;

        static /* synthetic */ boolean b(a aVar) {
            AppMethodBeat.i(30153);
            boolean dAS = aVar.dAS();
            AppMethodBeat.o(30153);
            return dAS;
        }

        static /* synthetic */ boolean c(a aVar) {
            AppMethodBeat.i(30154);
            boolean dAR = aVar.dAR();
            AppMethodBeat.o(30154);
            return dAR;
        }

        static /* synthetic */ boolean e(a aVar) {
            AppMethodBeat.i(30155);
            boolean dAT = aVar.dAT();
            AppMethodBeat.o(30155);
            return dAT;
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(30152);
            g NZ = NZ(i);
            AppMethodBeat.o(30152);
            return NZ;
        }

        public a(Context context, String str, int i) {
            boolean z = false;
            AppMethodBeat.i(30138);
            this.context = context;
            this.jMp = str;
            this.scene = i;
            boolean z2 = this.scene == 1 || this.scene == 2;
            this.yEE = z2;
            if (this.scene == 1 || this.scene == 3) {
                z = true;
            }
            this.yEF = z;
            this.yED = this.scene == 1 ? yEC : BaseClientBuilder.API_PRIORITY_OTHER;
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePK = com.tencent.mm.aj.a.e.cC(this.jMp);
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.ePT = R.raw.default_avatar;
            this.fGS = aVar.ahG();
            if (this.yEE) {
                aw.Rg().a(1364, (com.tencent.mm.ai.f) this);
            }
            AppMethodBeat.o(30138);
        }

        public final int getCount() {
            return this.afg;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(30139);
            g NZ = NZ(i);
            int i2;
            if (NZ != null) {
                i2 = NZ.klY;
                AppMethodBeat.o(30139);
                return i2;
            }
            i2 = g.yEY;
            AppMethodBeat.o(30139);
            return i2;
        }

        public final int getViewTypeCount() {
            return g.yFe;
        }

        public final g NZ(int i) {
            g gVar;
            AppMethodBeat.i(30140);
            int i2;
            if (i < this.yET) {
                if (i == 0) {
                    if (this.yEJ == null) {
                        this.yEJ = new g(g.yFd, Integer.valueOf(g.yFf));
                    }
                    gVar = this.yEJ;
                    AppMethodBeat.o(30140);
                    return gVar;
                } else if (i == this.yET - 1 && this.yEQ && dAR()) {
                    if (this.yEL == null) {
                        this.yEL = new g();
                    }
                    this.yEL.klY = g.yFc;
                    this.yEL.data = Integer.valueOf(g.yFf);
                    gVar = this.yEL;
                    AppMethodBeat.o(30140);
                    return gVar;
                } else if (i == this.yET - 1 && this.yEP && dAR()) {
                    if (this.yEL == null) {
                        this.yEL = new g();
                    }
                    this.yEL.klY = g.yFb;
                    this.yEL.data = Integer.valueOf(g.yFf);
                    gVar = this.yEL;
                    AppMethodBeat.o(30140);
                    return gVar;
                } else {
                    i2 = i - 1;
                    if (i2 >= 0 && i2 < this.yEK.size()) {
                        gVar = (g) this.yEK.get(i2);
                        AppMethodBeat.o(30140);
                        return gVar;
                    }
                }
            } else if (i == this.yET) {
                if (this.yEM == null) {
                    this.yEM = new g(g.yFd, Integer.valueOf(g.yFg));
                }
                gVar = this.yEM;
                AppMethodBeat.o(30140);
                return gVar;
            } else if (i == this.afg - 1 && this.yES && dAR()) {
                if (this.yEO == null) {
                    this.yEO = new g(g.yFb, Integer.valueOf(g.yFg));
                }
                gVar = this.yEO;
                AppMethodBeat.o(30140);
                return gVar;
            } else {
                i2 = (i - this.yET) - 1;
                if (i2 >= 0 && i2 < this.yEN.size()) {
                    gVar = (g) this.yEN.get(i2);
                    AppMethodBeat.o(30140);
                    return gVar;
                }
            }
            gVar = new g();
            AppMethodBeat.o(30140);
            return gVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(30141);
            g NZ = NZ(i);
            String str;
            String str2;
            Object obj;
            boolean z;
            if (NZ.klY == g.yEZ || NZ.klY == g.yFa) {
                Object obj2;
                String str3;
                CharSequence charSequence;
                CharSequence a;
                CharSequence concat;
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.layout.a18, viewGroup, false);
                    view.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), ErrorDialogData.SUPPRESSED), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, ErrorDialogData.SUPPRESSED));
                    f fVar = new f();
                    fVar.ejo = (ImageView) view.findViewById(R.id.qk);
                    fVar.gnB = (TextView) view.findViewById(R.id.qm);
                    fVar.gnC = (TextView) view.findViewById(R.id.ld);
                    fVar.contentView = view.findViewById(R.id.qj);
                    view.setTag(fVar);
                }
                f fVar2 = (f) view.getTag();
                String str4 = "";
                str = "";
                boolean z2 = false;
                CharSequence charSequence2 = "";
                if (NZ.data instanceof com.tencent.mm.aj.a.c) {
                    com.tencent.mm.aj.a.c cVar = (com.tencent.mm.aj.a.c) NZ.data;
                    if (cVar != null) {
                        if (!cVar.isGroup()) {
                            j cH = z.aeV().cH(cVar.field_bizChatServId);
                            if (cH != null) {
                                str = cH.field_userName;
                                str2 = cH.field_headImageUrl;
                                str4 = str;
                            }
                        }
                        str = cVar.field_chatName;
                        str2 = cVar.field_headImageUrl;
                        str4 = str;
                    } else {
                        str2 = str;
                    }
                    z2 = false;
                    obj2 = 1;
                    str3 = str2;
                    charSequence = str4;
                } else if (NZ.data instanceof kh) {
                    kh khVar = (kh) NZ.data;
                    kk kkVar = khVar.vNe;
                    charSequence = kkVar.kfT;
                    str3 = kkVar.vMW;
                    boolean equals = "userid".equals(khVar.vNf);
                    obj = !equals ? 1 : null;
                    Object charSequence22 = khVar.vNg;
                    obj2 = obj;
                    z2 = equals;
                } else {
                    obj2 = null;
                    str3 = str;
                    Object charSequence3 = str4;
                }
                if (obj2 != null) {
                    a = a(this.context, com.tencent.mm.plugin.fts.a.f.a(charSequence3, this.ema), com.tencent.mm.plugin.fts.ui.b.c.mHw);
                } else {
                    a = a(this.context, new SpannableString(charSequence3), com.tencent.mm.plugin.fts.ui.b.c.mHw);
                }
                if (z2) {
                    str2 = this.context.getString(R.string.aa0);
                    SpannableString a2 = a(this.context, com.tencent.mm.plugin.fts.a.f.a(charSequence22, this.ema), com.tencent.mm.plugin.fts.ui.b.c.mHw);
                    concat = TextUtils.concat(new CharSequence[]{str2, a2});
                } else {
                    concat = "";
                }
                boolean z3 = true;
                if (NZ.klY == g.yEZ && i == this.yET - 1 && this.yET != this.afg) {
                    z3 = false;
                }
                m.p(fVar2.contentView, z3);
                o.ahp().a(str3, fVar2.ejo, this.fGS);
                m.a(a, fVar2.gnB);
                m.a(concat, fVar2.gnC);
                AppMethodBeat.o(30141);
                return view;
            } else if (NZ.klY == g.yFd) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.layout.a1i, viewGroup, false);
                    b bVar = new b();
                    bVar.kxr = (TextView) view.findViewById(R.id.aw4);
                    bVar.mKk = view.findViewById(R.id.it);
                    bVar.contentView = view.findViewById(R.id.qj);
                    view.setTag(bVar);
                }
                b bVar2 = (b) view.getTag();
                str = "";
                if (((Integer) NZ.data).intValue() == g.yFf) {
                    str2 = this.context.getResources().getString(R.string.a_y);
                } else if (((Integer) NZ.data).intValue() == g.yFg) {
                    str2 = this.context.getResources().getString(R.string.a_r);
                } else {
                    str2 = str;
                }
                m.b(str2, bVar2.kxr);
                if (i == 0) {
                    bVar2.mKk.setVisibility(8);
                } else {
                    bVar2.mKk.setVisibility(0);
                }
                bVar2.contentView.setBackgroundResource(R.drawable.a_r);
                AppMethodBeat.o(30141);
                return view;
            } else if (NZ.klY == g.yFb) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.layout.a1u, viewGroup, false);
                    e eVar = new e();
                    eVar.mJS = (TextView) view.findViewById(R.id.n0);
                    eVar.iqT = (ImageView) view.findViewById(R.id.rq);
                    eVar.contentView = view.findViewById(R.id.qj);
                    view.setTag(eVar);
                }
                e eVar2 = (e) view.getTag();
                CharSequence charSequence4 = "";
                if (((Integer) NZ.data).intValue() == g.yFf) {
                    charSequence4 = this.context.getResources().getString(R.string.a_x);
                } else if (((Integer) NZ.data).intValue() == g.yFg) {
                    obj = this.context.getResources().getString(R.string.a_w);
                }
                if (((Integer) NZ.data).intValue() != g.yFf || this.yET == this.afg) {
                    z = true;
                } else {
                    z = false;
                }
                m.p(eVar2.contentView, z);
                eVar2.mJS.setText(charSequence4);
                eVar2.iqT.setImageResource(R.raw.fts_more_button_icon);
                AppMethodBeat.o(30141);
                return view;
            } else if (NZ.klY == g.yFc) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.layout.a1l, viewGroup, false);
                    d dVar = new d();
                    dVar.mJS = (TextView) view.findViewById(R.id.n0);
                    dVar.contentView = view.findViewById(R.id.qj);
                    view.setTag(dVar);
                }
                d dVar2 = (d) view.getTag();
                if (((Integer) NZ.data).intValue() != g.yFf || this.yET == this.afg) {
                    z = true;
                } else {
                    z = false;
                }
                m.p(dVar2.contentView, z);
                dVar2.mJS.setText(this.context.getResources().getString(R.string.a_t));
                AppMethodBeat.o(30141);
                return view;
            } else {
                AppMethodBeat.o(30141);
                return null;
            }
        }

        /* JADX WARNING: Missing block: B:42:0x00c2, code skipped:
            if (r9.yEH.size() <= r9.yEG.size()) goto L_0x00c4;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
            AppMethodBeat.i(30142);
            if (this.yEE && mVar.getType() == 1364 && (mVar instanceof l)) {
                ki kiVar;
                this.yER = false;
                l lVar = (l) mVar;
                if (lVar.ehh == null || lVar.ehh.fsG.fsP == null) {
                    kiVar = null;
                } else {
                    kiVar = (ki) lVar.ehh.fsG.fsP;
                }
                String str2 = kiVar.ctj;
                String str3 = kiVar.vNb;
                if (!str2.equals(this.ema) || !str3.equals(this.jMp) || this.yEV != kiVar.offset) {
                    AppMethodBeat.o(30142);
                    return;
                } else if (i == 0 && i2 == 0) {
                    kj kjVar;
                    if (lVar.ehh == null || lVar.ehh.fsH.fsP == null) {
                        kjVar = null;
                    } else {
                        kjVar = (kj) lVar.ehh.fsH.fsP;
                    }
                    if (kjVar == null || kjVar.vNh == null || kjVar.vNh.ret != 0) {
                        dAQ();
                        AppMethodBeat.o(30142);
                        return;
                    }
                    LinkedList<kh> linkedList = kjVar.vNi;
                    boolean z = kjVar.vNj;
                    if (str2.equals(this.ema)) {
                        this.yEQ = false;
                        this.yEV += linkedList.size();
                        if (dAR()) {
                            if (this.yEH.size() < this.yEG.size()) {
                                cf(str2, true);
                                AppMethodBeat.o(30142);
                                return;
                            }
                        }
                        if (dAS()) {
                            this.yEP = z;
                        }
                        if (!dAT()) {
                            for (kh khVar : linkedList) {
                                kk kkVar = khVar.vNe;
                                if (!bo.isNullOrNil(kkVar.vNc)) {
                                    Iterator it = this.yEG.iterator();
                                    while (it.hasNext()) {
                                        if (kkVar.vNc.equals(((com.tencent.mm.aj.a.c) it.next()).field_bizChatServId)) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                    if (!z) {
                                        this.yEH.add(khVar);
                                    }
                                }
                            }
                            qm(true);
                        }
                    }
                } else {
                    dAQ();
                    AppMethodBeat.o(30142);
                    return;
                }
            }
            AppMethodBeat.o(30142);
        }

        private void dAQ() {
            AppMethodBeat.i(30143);
            if (dAS()) {
                this.yEQ = false;
                this.yEU = true;
                dAW();
            }
            AppMethodBeat.o(30143);
        }

        private boolean dAR() {
            return this.scene == 1;
        }

        /* Access modifiers changed, original: final */
        public final boolean dAS() {
            return this.scene == 2;
        }

        private boolean dAT() {
            return this.scene == 3;
        }

        private static SpannableString a(Context context, Spannable spannable, int i) {
            int i2 = 0;
            AppMethodBeat.i(30144);
            SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b(context, (CharSequence) spannable, i);
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
            if (foregroundColorSpanArr != null) {
                int length = foregroundColorSpanArr.length;
                while (i2 < length) {
                    Object obj = foregroundColorSpanArr[i2];
                    b.setSpan(obj, spannable.getSpanStart(obj), spannable.getSpanEnd(obj), spannable.getSpanFlags(obj));
                    i2++;
                }
            }
            AppMethodBeat.o(30144);
            return b;
        }

        /* Access modifiers changed, original: final */
        public final void cf(String str, boolean z) {
            AppMethodBeat.i(30145);
            List<com.tencent.mm.aj.a.c> aC = z.aeU().aC(this.jMp, str);
            clearData();
            for (com.tencent.mm.aj.a.c cVar : aC) {
                boolean isGroup = cVar.isGroup();
                if (isGroup && this.yEF) {
                    this.yEI.add(cVar);
                } else if (!isGroup && this.yEE) {
                    this.yEH.add(cVar);
                    this.yEG.add(cVar);
                }
            }
            if (this.yEE) {
                this.yEQ = this.yEH.size() <= this.yED;
            }
            qm(z);
            AppMethodBeat.o(30145);
        }

        /* Access modifiers changed, original: final */
        public final void aqW(final String str) {
            AppMethodBeat.i(30146);
            if (this.yEE) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(30137);
                        if (str.equals(a.this.ema)) {
                            aw.Rg().a(new l(a.this.jMp, str, 0), 0);
                            AppMethodBeat.o(30137);
                            return;
                        }
                        AppMethodBeat.o(30137);
                    }
                }, 200);
                AppMethodBeat.o(30146);
                return;
            }
            AppMethodBeat.o(30146);
        }

        private void dAU() {
            boolean z;
            int i;
            int i2 = 1;
            AppMethodBeat.i(30147);
            int size = this.yEH.size();
            int size2 = this.yEI.size();
            if (this.scene != 2) {
                this.yEP = this.yEH.size() > this.yED;
            }
            if (this.yEI.size() > this.yED) {
                z = true;
            } else {
                z = false;
            }
            this.yES = z;
            if (size > 0 || this.yEQ) {
                size = Math.min(size, this.yED) + 1;
                if (dAR()) {
                    if (this.yEQ || this.yEP) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    i += size;
                } else {
                    i = size;
                }
            } else {
                i = 0;
            }
            this.yET = i;
            if (size2 > 0) {
                i = (i + 1) + Math.min(size2, this.yED);
                if (dAR()) {
                    if (!this.yES) {
                        i2 = 0;
                    }
                    i += i2;
                }
            }
            this.afg = i;
            AppMethodBeat.o(30147);
        }

        /* Access modifiers changed, original: final */
        public final void clearData() {
            AppMethodBeat.i(30148);
            this.yEV = 0;
            this.yEH.clear();
            this.yEG.clear();
            this.yEI.clear();
            AppMethodBeat.o(30148);
        }

        /* Access modifiers changed, original: final */
        public final void qm(boolean z) {
            AppMethodBeat.i(30149);
            dAV();
            dAU();
            if (z) {
                notifyDataSetChanged();
                dAW();
            }
            AppMethodBeat.o(30149);
        }

        private void dAV() {
            int i = 0;
            AppMethodBeat.i(30150);
            this.yEK.clear();
            this.yEN.clear();
            for (int i2 = 0; i2 < Math.min(this.yED, this.yEH.size()); i2++) {
                this.yEK.add(new g(g.yEZ, this.yEH.get(i2)));
            }
            while (i < Math.min(this.yED, this.yEI.size())) {
                this.yEN.add(new g(g.yFa, this.yEI.get(i)));
                i++;
            }
            AppMethodBeat.o(30150);
        }

        /* Access modifiers changed, original: final */
        public final void dAW() {
            AppMethodBeat.i(30151);
            ((BizChatSearchUI) this.context).a(this);
            AppMethodBeat.o(30151);
        }
    }

    static class e {
        public View contentView;
        public ImageView iqT;
        public TextView mJS;

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    static class d {
        public View contentView;
        public TextView mJS;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    static class g {
        public static int yEY = 0;
        public static int yEZ = 1;
        public static int yFa = 2;
        public static int yFb = 3;
        public static int yFc = 4;
        public static int yFd = 5;
        public static int yFe = 6;
        public static int yFf = 1;
        public static int yFg = 2;
        public Object data;
        public int klY;

        public g() {
            this.klY = yEY;
            this.data = null;
        }

        public g(int i, Object obj) {
            this.klY = i;
            this.data = obj;
        }
    }

    static class f {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizChatSearchUI() {
        AppMethodBeat.i(30159);
        AppMethodBeat.o(30159);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30160);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(30160);
    }

    private void aWh() {
        AppMethodBeat.i(30161);
        if (bo.isNullOrNil(this.jMp)) {
            this.jMp = getIntent().getStringExtra("enterprise_biz_name");
            this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
            this.yEw = getIntent().getStringExtra("biz_chat_search_text");
            if (bo.isNullOrNil(this.jMp)) {
                finish();
            }
        }
        AppMethodBeat.o(30161);
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public final void initView() {
        AppMethodBeat.i(30162);
        aWh();
        this.yEy = (BizChatSearchListView) findViewById(R.id.bi6);
        this.yEz = (TextView) findViewById(R.id.j1);
        this.yEA = new a(this.mController.ylL, this.jMp, this.scene);
        if (a.b(this.yEA)) {
            this.yEx = new c();
            this.yEy.addFooterView(this.yEx.hQ(this.mController.ylL));
            NY(0);
        }
        this.yEy.setAdapter(this.yEA);
        this.yEy.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                long j2 = -1;
                AppMethodBeat.i(30136);
                g NZ = BizChatSearchUI.this.yEA.NZ(i);
                BizChatSearchUI bizChatSearchUI = BizChatSearchUI.this;
                Intent intent;
                if (NZ.klY == g.yEZ || NZ.klY == g.yFa) {
                    com.tencent.mm.aj.a.c cVar;
                    if (NZ.data instanceof com.tencent.mm.aj.a.c) {
                        long j3;
                        cVar = (com.tencent.mm.aj.a.c) NZ.data;
                        if (cVar != null) {
                            j3 = cVar.field_bizChatLocalId;
                        } else {
                            j3 = -1;
                        }
                        j2 = j3;
                    } else if (NZ.data instanceof kh) {
                        boolean z;
                        kk kkVar = ((kh) NZ.data).vNe;
                        String str = bizChatSearchUI.jMp;
                        j jVar = new j();
                        jVar.field_userId = kkVar.vNc;
                        jVar.field_userName = kkVar.kfT;
                        jVar.field_brandUserName = str;
                        jVar.field_headImageUrl = kkVar.vMW;
                        jVar.field_profileUrl = kkVar.vNk;
                        jVar.field_UserVersion = kkVar.ver;
                        jVar.field_addMemberUrl = kkVar.vNa;
                        if (z.aeV().b(jVar)) {
                            z = true;
                        } else {
                            z = z.aeV().a(jVar);
                        }
                        if (z) {
                            cVar = new com.tencent.mm.aj.a.c();
                            cVar.field_bizChatServId = jVar.field_userId;
                            cVar.field_brandUserName = jVar.field_brandUserName;
                            cVar.field_chatName = jVar.field_userName;
                            cVar.field_chatType = 1;
                            cVar = com.tencent.mm.aj.a.e.e(cVar);
                            if (cVar != null) {
                                com.tencent.mm.aj.a.a fv = z.aeU().fv(cVar.field_bizChatLocalId);
                                fv.field_bizChatId = cVar.field_bizChatLocalId;
                                fv.field_unReadCount = 0;
                                if (bo.isNullOrNil(fv.field_brandUserName)) {
                                    fv.field_brandUserName = cVar.field_brandUserName;
                                    fv.field_lastMsgTime = System.currentTimeMillis();
                                    fv.field_flag = fv.field_lastMsgTime;
                                }
                                if (!z.aeU().b(fv)) {
                                    z.aeU().a(fv);
                                }
                                j2 = cVar.field_bizChatLocalId;
                            }
                        }
                    }
                    if (bo.isNullOrNil(bizChatSearchUI.jMp) || j2 < 0) {
                        AppMethodBeat.o(30136);
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("Chat_User", bizChatSearchUI.jMp);
                    intent.putExtra("key_biz_chat_id", j2);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("key_need_send_video", false);
                    intent.putExtra("key_is_biz_chat", true);
                    com.tencent.mm.bp.d.f(bizChatSearchUI.mController.ylL, ".ui.chatting.ChattingUI", intent);
                    AppMethodBeat.o(30136);
                    return;
                }
                if (NZ.klY == g.yFb) {
                    if (((Integer) NZ.data).intValue() == g.yFf) {
                        intent = new Intent(bizChatSearchUI.mController.ylL, BizChatSearchUI.class);
                        intent.putExtra("enterprise_biz_name", bizChatSearchUI.jMp);
                        intent.putExtra("biz_chat_search_scene", 2);
                        intent.putExtra("biz_chat_search_text", bizChatSearchUI.jLK.getSearchContent());
                        bizChatSearchUI.startActivity(intent);
                        AppMethodBeat.o(30136);
                        return;
                    } else if (((Integer) NZ.data).intValue() == g.yFg) {
                        intent = new Intent(bizChatSearchUI.mController.ylL, BizChatSearchUI.class);
                        intent.putExtra("enterprise_biz_name", bizChatSearchUI.jMp);
                        intent.putExtra("biz_chat_search_scene", 3);
                        intent.putExtra("biz_chat_search_text", bizChatSearchUI.jLK.getSearchContent());
                        bizChatSearchUI.startActivity(intent);
                    }
                }
                AppMethodBeat.o(30136);
            }
        });
        this.yEy.setOnTouchListener(this);
        if (a.b(this.yEA)) {
            this.yEy.setOnScrollListener(this.nfn);
        }
        this.jLK = new com.tencent.mm.modelvoiceaddr.ui.b();
        this.jLK.qQ(a.c(this.yEA));
        this.jLK.a(this);
        this.jLK.gcl = false;
        AppMethodBeat.o(30162);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(30163);
        if (!a.c(aVar)) {
            if (bo.isNullOrNil(aVar.ema)) {
                this.yEz.setVisibility(0);
                this.yEz.setText("");
                this.yEy.setVisibility(8);
            } else if (a.b(aVar) && aVar.yEQ) {
                this.yEz.setVisibility(0);
                this.yEz.setText(R.string.a_t);
                this.yEy.setVisibility(8);
            } else if (a.b(aVar) && aVar.yEU) {
                this.yEz.setVisibility(0);
                this.yEz.setText(R.string.a_u);
                this.yEy.setVisibility(8);
            } else if (aVar.getCount() <= 0) {
                this.yEz.setVisibility(0);
                this.yEz.setText(com.tencent.mm.plugin.fts.a.f.a(getString(R.string.dzw), getString(R.string.dzv), com.tencent.mm.plugin.fts.a.a.d.b(aVar.ema, aVar.ema)).mDR);
                this.yEy.setVisibility(8);
            } else {
                this.yEz.setVisibility(8);
                this.yEy.setVisibility(0);
            }
            if (a.b(aVar)) {
                if (aVar.yER) {
                    NY(1);
                    AppMethodBeat.o(30163);
                    return;
                } else if (aVar.yEP) {
                    NY(2);
                    AppMethodBeat.o(30163);
                    return;
                } else {
                    NY(0);
                }
            }
            AppMethodBeat.o(30163);
        } else if (bo.isNullOrNil(aVar.ema)) {
            this.yEz.setVisibility(8);
            this.yEy.setVisibility(8);
            AppMethodBeat.o(30163);
        } else if (aVar.getCount() <= 0) {
            this.yEz.setVisibility(0);
            this.yEy.setVisibility(8);
            AppMethodBeat.o(30163);
        } else {
            this.yEz.setVisibility(8);
            this.yEy.setVisibility(0);
            AppMethodBeat.o(30163);
        }
    }

    public final void app() {
    }

    public final void apo() {
        AppMethodBeat.i(30164);
        finish();
        AppMethodBeat.o(30164);
    }

    public final void vO(String str) {
        CharSequence charSequence = null;
        AppMethodBeat.i(30165);
        if (!bo.isNullOrNil(str) || this.yEw == null) {
            a aVar = this.yEA;
            aVar.ema = str;
            if (bo.isNullOrNil(str)) {
                aVar.clearData();
                aVar.yEQ = false;
                aVar.yEU = false;
                aVar.qm(true);
                AppMethodBeat.o(30165);
                return;
            } else if (aVar.dAS()) {
                aVar.yEQ = true;
                aVar.yEU = false;
                aVar.dAW();
                aVar.cf(str, false);
                aVar.aqW(str);
                AppMethodBeat.o(30165);
                return;
            } else {
                aVar.cf(str, true);
                if (aVar.yEE && aVar.yEQ) {
                    aVar.aqW(str);
                }
                AppMethodBeat.o(30165);
                return;
            }
        }
        String str2 = this.yEw;
        this.yEw = null;
        if (!str2.equals("")) {
            this.jLK.setSearchContent(str2);
        }
        com.tencent.mm.modelvoiceaddr.ui.b bVar = this.jLK;
        if (a.c(this.yEA)) {
            charSequence = this.mController.ylL.getResources().getString(R.string.a_v);
        } else if (a.b(this.yEA)) {
            charSequence = this.mController.ylL.getResources().getString(R.string.a_z);
        } else if (a.e(this.yEA)) {
            charSequence = this.mController.ylL.getResources().getString(R.string.a_s);
        }
        bVar.setHint(charSequence);
        this.jLK.clearFocus();
        AppMethodBeat.o(30165);
    }

    public final boolean vN(String str) {
        AppMethodBeat.i(30166);
        aqX();
        AppMethodBeat.o(30166);
        return true;
    }

    public final void amJ() {
        AppMethodBeat.i(30167);
        aqX();
        AppMethodBeat.o(30167);
    }

    public void onPause() {
        AppMethodBeat.i(30168);
        super.onPause();
        this.jLK.cancel();
        this.jLK.clearFocus();
        AppMethodBeat.o(30168);
    }

    public void onDestroy() {
        AppMethodBeat.i(30169);
        super.onDestroy();
        AppMethodBeat.o(30169);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(30170);
        this.jLK.a((FragmentActivity) this, menu);
        AppMethodBeat.o(30170);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(30171);
        this.jLK.a(this, menu);
        AppMethodBeat.o(30171);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    public final int getLayoutId() {
        return R.layout.vk;
    }

    public final boolean aWe() {
        AppMethodBeat.i(30172);
        aqX();
        AppMethodBeat.o(30172);
        return false;
    }

    private void NY(int i) {
        AppMethodBeat.i(30173);
        if (this.yEx != null) {
            this.yEx.sd(i);
        }
        AppMethodBeat.o(30173);
    }
}
