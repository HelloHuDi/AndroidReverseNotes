package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.p707ba.C9067n;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p520ui.C36817g.C29214a;
import com.tencent.p177mm.protocal.protobuf.C35917fq;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.ui.f */
public final class C39842f extends BaseAdapter {
    private final Activity czX;
    private final C7306ak handler = new C7306ak();
    final List<bau> list = new ArrayList();
    private String nJy = "";
    final Map<Integer, Integer> rgf = new HashMap();
    final Map<Integer, Integer> rgg = new HashMap();
    int rgh = 0;
    int rgi = 0;
    private final C39843b rgj;
    private final C36817g rgk;
    final C39841a rgl;
    C35917fq rgm;

    /* renamed from: com.tencent.mm.plugin.sns.ui.f$c */
    class C13678c {
        TextView gsf;
        TextView rgt;
        ImageView rgu;
        ImageView rgv;
        ImageView rgw;
        LinearLayout rgx;
        View rgy;

        C13678c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.f$1 */
    class C221221 implements C29214a {
        C221221() {
        }

        /* renamed from: a */
        public final void mo37673a(List<bau> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, C35917fq c35917fq) {
            AppMethodBeat.m2504i(38081);
            C4990ab.m7410d("MicroMsg.ArtistAdapter", "onFinishFixPos");
            C39842f c39842f = C39842f.this;
            if (list == null || list.size() <= 0) {
                AppMethodBeat.m2505o(38081);
                return;
            }
            int intValue;
            try {
                c39842f.rgm = (C35917fq) new C35917fq().parseFrom(c35917fq.toByteArray());
                c39842f.rgl.mo37536a(c39842f.rgm);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ArtistAdapter", e, "", new Object[0]);
            }
            C4990ab.m7410d("MicroMsg.ArtistAdapter", "copy list info");
            int size = list.size();
            c39842f.list.clear();
            c39842f.rgf.clear();
            c39842f.rgg.clear();
            for (int i3 = 0; i3 < size; i3++) {
                bau bau = (bau) list.get(i3);
                c39842f.list.add(C37953e.m64185a(bau.f17915Id, bau.jCt, bau.Url, bau.wEH, bau.wEG, bau.wEI, bau.Desc));
            }
            for (Integer intValue2 : map.keySet()) {
                intValue = intValue2.intValue();
                c39842f.rgf.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map.get(Integer.valueOf(intValue))).intValue()));
            }
            for (Integer intValue22 : map2.keySet()) {
                intValue = intValue22.intValue();
                c39842f.rgg.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map2.get(Integer.valueOf(intValue))).intValue()));
            }
            list.clear();
            map.clear();
            map2.clear();
            c39842f.rgi = i;
            c39842f.rgh = i2;
            C4990ab.m7410d("MicroMsg.ArtistAdapter", "reallyCount " + i + " icount " + i2);
            c39842f.notifyDataSetChanged();
            AppMethodBeat.m2505o(38081);
        }

        public final void crw() {
            AppMethodBeat.m2504i(38082);
            C39842f c39842f = C39842f.this;
            if (c39842f.rgl != null) {
                c39842f.rgl.crx();
            }
            AppMethodBeat.m2505o(38082);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.f$a */
    public interface C39841a {
        /* renamed from: a */
        void mo37536a(C35917fq c35917fq);

        /* renamed from: b */
        void mo37537b(C35917fq c35917fq);

        void crx();
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.f$b */
    static abstract class C39843b {
        OnClickListener rgo = new C292131();
        OnClickListener rgp = new C136772();
        OnClickListener rgq = new C398443();
        public C39845a rgr = new C39845a();

        /* renamed from: com.tencent.mm.plugin.sns.ui.f$b$2 */
        class C136772 implements OnClickListener {
            C136772() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(38084);
                C39843b.this.rgr = (C39845a) view.getTag();
                C39843b.this.mo37535DM(C39843b.this.rgr.position);
                AppMethodBeat.m2505o(38084);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.f$b$1 */
        class C292131 implements OnClickListener {
            C292131() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(38083);
                C39843b.this.rgr = (C39845a) view.getTag();
                C39843b.this.mo37535DM(C39843b.this.rgr.position);
                AppMethodBeat.m2505o(38083);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.f$b$3 */
        class C398443 implements OnClickListener {
            C398443() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(38085);
                C39843b.this.rgr = (C39845a) view.getTag();
                C39843b.this.mo37535DM(C39843b.this.rgr.position);
                AppMethodBeat.m2505o(38085);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.f$b$a */
        public static class C39845a {
            public String cFc;
            public int position;
        }

        /* renamed from: DM */
        public abstract void mo37535DM(int i);
    }

    public C39842f(Activity activity, String str, C39843b c39843b, C39841a c39841a) {
        AppMethodBeat.m2504i(38086);
        this.czX = activity;
        this.nJy = str;
        this.rgj = c39843b;
        this.rgl = c39841a;
        this.rgk = new C36817g(new C221221());
        mo63031KC();
        AppMethodBeat.m2505o(38086);
    }

    /* renamed from: KC */
    public final void mo63031KC() {
        AppMethodBeat.m2504i(38087);
        if (this.rgk != null) {
            C41787r.aix();
            String aiu = C9067n.aiu();
            C4990ab.m7410d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(aiu)));
            this.rgk.mo58678gs(this.nJy, aiu);
        }
        AppMethodBeat.m2505o(38087);
    }

    public final int getCount() {
        return this.rgh;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(38088);
        Object obj = this.list.get(i);
        AppMethodBeat.m2505o(38088);
        return obj;
    }

    public final long getItemId(int i) {
        return 0;
    }

    /* renamed from: a */
    private void m68234a(int i, ImageView imageView) {
        AppMethodBeat.m2504i(38090);
        bau bau = (bau) getItem(i);
        imageView.setVisibility(0);
        C39845a c39845a = new C39845a();
        c39845a.cFc = "";
        c39845a.position = i;
        imageView.setTag(c39845a);
        C13373af.cnC().mo37455b(bau, imageView, this.czX.hashCode(), C44222az.xYU);
        AppMethodBeat.m2505o(38090);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C13678c c13678c;
        int intValue;
        AppMethodBeat.m2504i(38089);
        if (view == null) {
            c13678c = new C13678c();
            view = View.inflate(this.czX, 2130970746, null);
            c13678c.gsf = (TextView) view.findViewById(2131827684);
            c13678c.rgt = (TextView) view.findViewById(2131827685);
            c13678c.rgu = (ImageView) view.findViewById(2131827686);
            c13678c.rgv = (ImageView) view.findViewById(2131827687);
            c13678c.rgw = (ImageView) view.findViewById(2131827688);
            c13678c.rgx = (LinearLayout) view.findViewById(2131827683);
            c13678c.rgy = view.findViewById(2131827682);
            c13678c.rgu.setOnClickListener(this.rgj.rgo);
            c13678c.rgv.setOnClickListener(this.rgj.rgp);
            c13678c.rgw.setOnClickListener(this.rgj.rgq);
            view.setTag(c13678c);
        } else {
            c13678c = (C13678c) view.getTag();
        }
        if (this.rgf.get(Integer.valueOf(i)) != null) {
            intValue = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        c13678c.rgu.setVisibility(8);
        c13678c.rgv.setVisibility(8);
        c13678c.rgw.setVisibility(8);
        c13678c.rgy.setVisibility(8);
        if (C39842f.this.nJy.equals("en")) {
            c13678c.gsf.setVisibility(8);
            c13678c.rgt.setVisibility(4);
        } else {
            c13678c.gsf.setVisibility(4);
            c13678c.rgt.setVisibility(8);
        }
        if (intValue >= this.rgi || intValue == -1) {
            view.setLayoutParams(new LayoutParams(-1, 1));
            view.setVisibility(8);
        } else {
            int intValue2;
            String str = "";
            if (intValue - 1 >= 0) {
                Object obj = ((bau) getItem(intValue - 1)).Desc;
            } else {
                String obj2 = str;
            }
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setVisibility(0);
            if (this.rgg.get(Integer.valueOf(i)) != null) {
                intValue2 = ((Integer) this.rgg.get(Integer.valueOf(i))).intValue();
            } else {
                intValue2 = 1;
            }
            bau bau = (bau) getItem(intValue);
            if (bau.Desc.equals("") || !bau.Desc.equals(obj2)) {
                if (this.nJy.equals("en")) {
                    c13678c.rgt.setVisibility(0);
                    c13678c.rgt.setText(bau.Desc);
                    c13678c.rgy.setVisibility(0);
                } else {
                    c13678c.gsf.setVisibility(0);
                    c13678c.gsf.setText(bau.Desc);
                    c13678c.rgy.setVisibility(0);
                }
            }
            if (intValue2 > 0) {
                m68234a(intValue, c13678c.rgu);
            }
            if (intValue2 >= 2) {
                m68234a(intValue + 1, c13678c.rgv);
            }
            if (intValue2 >= 3) {
                m68234a(intValue + 2, c13678c.rgw);
            }
            if (this.rgl != null) {
                this.rgl.mo37537b(this.rgm);
            }
        }
        AppMethodBeat.m2505o(38089);
        return view;
    }
}
