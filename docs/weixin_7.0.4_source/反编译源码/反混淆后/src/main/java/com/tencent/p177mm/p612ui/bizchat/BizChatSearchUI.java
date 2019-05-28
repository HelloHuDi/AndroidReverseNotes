package com.tencent.p177mm.p612ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b.C9756a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C32232a;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p184aj.p185a.C45144l;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.bizchat.BizChatSearchListView.C5296a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C23408ki;
import com.tencent.p177mm.protocal.protobuf.C35932kh;
import com.tencent.p177mm.protocal.protobuf.C44134kj;
import com.tencent.p177mm.protocal.protobuf.C44135kk;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI */
public class BizChatSearchUI extends MMActivity implements C9756a, C5296a {
    C42239b jLK;
    String jMp;
    private OnScrollListener nfn = new C442781();
    private int scene;
    private C30405a yEA;
    private String yEw;
    private C5298c yEx;
    private BizChatSearchListView yEy;
    private TextView yEz;

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$b */
    static class C5297b {
        public View contentView;
        public TextView kxr;
        public View mKk;

        private C5297b() {
        }

        /* synthetic */ C5297b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$c */
    static class C5298c {
        private View jLA;
        private View jLB;
        private View jLz;

        private C5298c() {
        }

        /* synthetic */ C5298c(byte b) {
            this();
        }

        /* renamed from: hQ */
        public final View mo10898hQ(Context context) {
            AppMethodBeat.m2504i(30156);
            View inflate = View.inflate(context, 2130969940, null);
            this.jLz = inflate.findViewById(2131825264);
            this.jLA = inflate.findViewById(2131822252);
            this.jLB = inflate.findViewById(2131825265);
            this.jLz.setVisibility(8);
            this.jLA.setVisibility(8);
            this.jLB.setVisibility(8);
            AppMethodBeat.m2505o(30156);
            return inflate;
        }

        /* renamed from: sd */
        public final void mo10899sd(int i) {
            AppMethodBeat.m2504i(30157);
            switch (i) {
                case 1:
                    m8065w(true, false);
                    AppMethodBeat.m2505o(30157);
                    return;
                case 2:
                    m8065w(false, true);
                    AppMethodBeat.m2505o(30157);
                    return;
                default:
                    m8065w(false, false);
                    AppMethodBeat.m2505o(30157);
                    return;
            }
        }

        /* renamed from: w */
        private void m8065w(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            AppMethodBeat.m2504i(30158);
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
            AppMethodBeat.m2505o(30158);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$a */
    static class C30405a extends BaseAdapter implements C1202f {
        public static int yEC = 3;
        private int afg = 0;
        private Context context;
        String ema;
        private C25814c fGS;
        String jMp;
        private int scene;
        private int yED;
        boolean yEE;
        boolean yEF;
        private ArrayList<C45142c> yEG = new ArrayList();
        private ArrayList<Object> yEH = new ArrayList();
        private ArrayList<C45142c> yEI = new ArrayList();
        private C40681g yEJ;
        private ArrayList<C40681g> yEK = new ArrayList();
        private C40681g yEL;
        private C40681g yEM;
        private ArrayList<C40681g> yEN = new ArrayList();
        private C40681g yEO;
        public boolean yEP = true;
        public boolean yEQ = false;
        public boolean yER = false;
        private boolean yES = true;
        private int yET = 0;
        public boolean yEU = false;
        int yEV = 0;

        /* renamed from: b */
        static /* synthetic */ boolean m48493b(C30405a c30405a) {
            AppMethodBeat.m2504i(30153);
            boolean dAS = c30405a.dAS();
            AppMethodBeat.m2505o(30153);
            return dAS;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m48494c(C30405a c30405a) {
            AppMethodBeat.m2504i(30154);
            boolean dAR = c30405a.dAR();
            AppMethodBeat.m2505o(30154);
            return dAR;
        }

        /* renamed from: e */
        static /* synthetic */ boolean m48496e(C30405a c30405a) {
            AppMethodBeat.m2504i(30155);
            boolean dAT = c30405a.dAT();
            AppMethodBeat.m2505o(30155);
            return dAT;
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(30152);
            C40681g NZ = mo48792NZ(i);
            AppMethodBeat.m2505o(30152);
            return NZ;
        }

        public C30405a(Context context, String str, int i) {
            boolean z = false;
            AppMethodBeat.m2504i(30138);
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
            C17927a c17927a = new C17927a();
            c17927a.ePK = C25754e.m40894cC(this.jMp);
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.ePT = C1318a.default_avatar;
            this.fGS = c17927a.ahG();
            if (this.yEE) {
                C9638aw.m17182Rg().mo14539a(1364, (C1202f) this);
            }
            AppMethodBeat.m2505o(30138);
        }

        public final int getCount() {
            return this.afg;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(30139);
            C40681g NZ = mo48792NZ(i);
            int i2;
            if (NZ != null) {
                i2 = NZ.klY;
                AppMethodBeat.m2505o(30139);
                return i2;
            }
            i2 = C40681g.yEY;
            AppMethodBeat.m2505o(30139);
            return i2;
        }

        public final int getViewTypeCount() {
            return C40681g.yFe;
        }

        /* renamed from: NZ */
        public final C40681g mo48792NZ(int i) {
            C40681g c40681g;
            AppMethodBeat.m2504i(30140);
            int i2;
            if (i < this.yET) {
                if (i == 0) {
                    if (this.yEJ == null) {
                        this.yEJ = new C40681g(C40681g.yFd, Integer.valueOf(C40681g.yFf));
                    }
                    c40681g = this.yEJ;
                    AppMethodBeat.m2505o(30140);
                    return c40681g;
                } else if (i == this.yET - 1 && this.yEQ && dAR()) {
                    if (this.yEL == null) {
                        this.yEL = new C40681g();
                    }
                    this.yEL.klY = C40681g.yFc;
                    this.yEL.data = Integer.valueOf(C40681g.yFf);
                    c40681g = this.yEL;
                    AppMethodBeat.m2505o(30140);
                    return c40681g;
                } else if (i == this.yET - 1 && this.yEP && dAR()) {
                    if (this.yEL == null) {
                        this.yEL = new C40681g();
                    }
                    this.yEL.klY = C40681g.yFb;
                    this.yEL.data = Integer.valueOf(C40681g.yFf);
                    c40681g = this.yEL;
                    AppMethodBeat.m2505o(30140);
                    return c40681g;
                } else {
                    i2 = i - 1;
                    if (i2 >= 0 && i2 < this.yEK.size()) {
                        c40681g = (C40681g) this.yEK.get(i2);
                        AppMethodBeat.m2505o(30140);
                        return c40681g;
                    }
                }
            } else if (i == this.yET) {
                if (this.yEM == null) {
                    this.yEM = new C40681g(C40681g.yFd, Integer.valueOf(C40681g.yFg));
                }
                c40681g = this.yEM;
                AppMethodBeat.m2505o(30140);
                return c40681g;
            } else if (i == this.afg - 1 && this.yES && dAR()) {
                if (this.yEO == null) {
                    this.yEO = new C40681g(C40681g.yFb, Integer.valueOf(C40681g.yFg));
                }
                c40681g = this.yEO;
                AppMethodBeat.m2505o(30140);
                return c40681g;
            } else {
                i2 = (i - this.yET) - 1;
                if (i2 >= 0 && i2 < this.yEN.size()) {
                    c40681g = (C40681g) this.yEN.get(i2);
                    AppMethodBeat.m2505o(30140);
                    return c40681g;
                }
            }
            c40681g = new C40681g();
            AppMethodBeat.m2505o(30140);
            return c40681g;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(30141);
            C40681g NZ = mo48792NZ(i);
            String str;
            String str2;
            Object obj;
            boolean z;
            if (NZ.klY == C40681g.yEZ || NZ.klY == C40681g.yFa) {
                Object obj2;
                String str3;
                CharSequence charSequence;
                CharSequence a;
                CharSequence concat;
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(2130969613, viewGroup, false);
                    view.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), ErrorDialogData.SUPPRESSED), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, ErrorDialogData.SUPPRESSED));
                    C44279f c44279f = new C44279f();
                    c44279f.ejo = (ImageView) view.findViewById(2131821183);
                    c44279f.gnB = (TextView) view.findViewById(2131821185);
                    c44279f.gnC = (TextView) view.findViewById(2131820991);
                    c44279f.contentView = view.findViewById(2131821182);
                    view.setTag(c44279f);
                }
                C44279f c44279f2 = (C44279f) view.getTag();
                String str4 = "";
                str = "";
                boolean z2 = false;
                CharSequence charSequence2 = "";
                if (NZ.data instanceof C45142c) {
                    C45142c c45142c = (C45142c) NZ.data;
                    if (c45142c != null) {
                        if (!c45142c.isGroup()) {
                            C45143j cH = C41747z.aeV().mo60356cH(c45142c.field_bizChatServId);
                            if (cH != null) {
                                str = cH.field_userName;
                                str2 = cH.field_headImageUrl;
                                str4 = str;
                            }
                        }
                        str = c45142c.field_chatName;
                        str2 = c45142c.field_headImageUrl;
                        str4 = str;
                    } else {
                        str2 = str;
                    }
                    z2 = false;
                    obj2 = 1;
                    str3 = str2;
                    charSequence = str4;
                } else if (NZ.data instanceof C35932kh) {
                    C35932kh c35932kh = (C35932kh) NZ.data;
                    C44135kk c44135kk = c35932kh.vNe;
                    charSequence = c44135kk.kfT;
                    str3 = c44135kk.vMW;
                    boolean equals = "userid".equals(c35932kh.vNf);
                    obj = !equals ? 1 : null;
                    Object charSequence22 = c35932kh.vNg;
                    obj2 = obj;
                    z2 = equals;
                } else {
                    obj2 = null;
                    str3 = str;
                    Object charSequence3 = str4;
                }
                if (obj2 != null) {
                    a = C30405a.m48492a(this.context, C34204f.m56084a(charSequence3, this.ema), C3197c.mHw);
                } else {
                    a = C30405a.m48492a(this.context, new SpannableString(charSequence3), C3197c.mHw);
                }
                if (z2) {
                    str2 = this.context.getString(C25738R.string.aa0);
                    SpannableString a2 = C30405a.m48492a(this.context, C34204f.m56084a(charSequence22, this.ema), C3197c.mHw);
                    concat = TextUtils.concat(new CharSequence[]{str2, a2});
                } else {
                    concat = "";
                }
                boolean z3 = true;
                if (NZ.klY == C40681g.yEZ && i == this.yET - 1 && this.yET != this.afg) {
                    z3 = false;
                }
                C3201m.m5503p(c44279f2.contentView, z3);
                C32291o.ahp().mo43766a(str3, c44279f2.ejo, this.fGS);
                C3201m.m5501a(a, c44279f2.gnB);
                C3201m.m5501a(concat, c44279f2.gnC);
                AppMethodBeat.m2505o(30141);
                return view;
            } else if (NZ.klY == C40681g.yFd) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(2130969624, viewGroup, false);
                    C5297b c5297b = new C5297b();
                    c5297b.kxr = (TextView) view.findViewById(2131822768);
                    c5297b.mKk = view.findViewById(2131820896);
                    c5297b.contentView = view.findViewById(2131821182);
                    view.setTag(c5297b);
                }
                C5297b c5297b2 = (C5297b) view.getTag();
                str = "";
                if (((Integer) NZ.data).intValue() == C40681g.yFf) {
                    str2 = this.context.getResources().getString(C25738R.string.a_y);
                } else if (((Integer) NZ.data).intValue() == C40681g.yFg) {
                    str2 = this.context.getResources().getString(C25738R.string.a_r);
                } else {
                    str2 = str;
                }
                C3201m.m5502b(str2, c5297b2.kxr);
                if (i == 0) {
                    c5297b2.mKk.setVisibility(8);
                } else {
                    c5297b2.mKk.setVisibility(0);
                }
                c5297b2.contentView.setBackgroundResource(C25738R.drawable.a_r);
                AppMethodBeat.m2505o(30141);
                return view;
            } else if (NZ.klY == C40681g.yFb) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(2130969636, viewGroup, false);
                    C36107e c36107e = new C36107e();
                    c36107e.mJS = (TextView) view.findViewById(2131821051);
                    c36107e.iqT = (ImageView) view.findViewById(2131821226);
                    c36107e.contentView = view.findViewById(2131821182);
                    view.setTag(c36107e);
                }
                C36107e c36107e2 = (C36107e) view.getTag();
                CharSequence charSequence4 = "";
                if (((Integer) NZ.data).intValue() == C40681g.yFf) {
                    charSequence4 = this.context.getResources().getString(C25738R.string.a_x);
                } else if (((Integer) NZ.data).intValue() == C40681g.yFg) {
                    obj = this.context.getResources().getString(C25738R.string.a_w);
                }
                if (((Integer) NZ.data).intValue() != C40681g.yFf || this.yET == this.afg) {
                    z = true;
                } else {
                    z = false;
                }
                C3201m.m5503p(c36107e2.contentView, z);
                c36107e2.mJS.setText(charSequence4);
                c36107e2.iqT.setImageResource(C1318a.fts_more_button_icon);
                AppMethodBeat.m2505o(30141);
                return view;
            } else if (NZ.klY == C40681g.yFc) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(2130969627, viewGroup, false);
                    C40680d c40680d = new C40680d();
                    c40680d.mJS = (TextView) view.findViewById(2131821051);
                    c40680d.contentView = view.findViewById(2131821182);
                    view.setTag(c40680d);
                }
                C40680d c40680d2 = (C40680d) view.getTag();
                if (((Integer) NZ.data).intValue() != C40681g.yFf || this.yET == this.afg) {
                    z = true;
                } else {
                    z = false;
                }
                C3201m.m5503p(c40680d2.contentView, z);
                c40680d2.mJS.setText(this.context.getResources().getString(C25738R.string.a_t));
                AppMethodBeat.m2505o(30141);
                return view;
            } else {
                AppMethodBeat.m2505o(30141);
                return null;
            }
        }

        /* JADX WARNING: Missing block: B:42:0x00c2, code skipped:
            if (r9.yEH.size() <= r9.yEG.size()) goto L_0x00c4;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(30142);
            if (this.yEE && c1207m.getType() == 1364 && (c1207m instanceof C45144l)) {
                C23408ki c23408ki;
                this.yER = false;
                C45144l c45144l = (C45144l) c1207m;
                if (c45144l.ehh == null || c45144l.ehh.fsG.fsP == null) {
                    c23408ki = null;
                } else {
                    c23408ki = (C23408ki) c45144l.ehh.fsG.fsP;
                }
                String str2 = c23408ki.ctj;
                String str3 = c23408ki.vNb;
                if (!str2.equals(this.ema) || !str3.equals(this.jMp) || this.yEV != c23408ki.offset) {
                    AppMethodBeat.m2505o(30142);
                    return;
                } else if (i == 0 && i2 == 0) {
                    C44134kj c44134kj;
                    if (c45144l.ehh == null || c45144l.ehh.fsH.fsP == null) {
                        c44134kj = null;
                    } else {
                        c44134kj = (C44134kj) c45144l.ehh.fsH.fsP;
                    }
                    if (c44134kj == null || c44134kj.vNh == null || c44134kj.vNh.ret != 0) {
                        dAQ();
                        AppMethodBeat.m2505o(30142);
                        return;
                    }
                    LinkedList<C35932kh> linkedList = c44134kj.vNi;
                    boolean z = c44134kj.vNj;
                    if (str2.equals(this.ema)) {
                        this.yEQ = false;
                        this.yEV += linkedList.size();
                        if (dAR()) {
                            if (this.yEH.size() < this.yEG.size()) {
                                mo48794cf(str2, true);
                                AppMethodBeat.m2505o(30142);
                                return;
                            }
                        }
                        if (dAS()) {
                            this.yEP = z;
                        }
                        if (!dAT()) {
                            for (C35932kh c35932kh : linkedList) {
                                C44135kk c44135kk = c35932kh.vNe;
                                if (!C5046bo.isNullOrNil(c44135kk.vNc)) {
                                    Iterator it = this.yEG.iterator();
                                    while (it.hasNext()) {
                                        if (c44135kk.vNc.equals(((C45142c) it.next()).field_bizChatServId)) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                    if (!z) {
                                        this.yEH.add(c35932kh);
                                    }
                                }
                            }
                            mo48804qm(true);
                        }
                    }
                } else {
                    dAQ();
                    AppMethodBeat.m2505o(30142);
                    return;
                }
            }
            AppMethodBeat.m2505o(30142);
        }

        private void dAQ() {
            AppMethodBeat.m2504i(30143);
            if (dAS()) {
                this.yEQ = false;
                this.yEU = true;
                dAW();
            }
            AppMethodBeat.m2505o(30143);
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

        /* renamed from: a */
        private static SpannableString m48492a(Context context, Spannable spannable, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(30144);
            SpannableString b = C44089j.m79294b(context, (CharSequence) spannable, i);
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
            if (foregroundColorSpanArr != null) {
                int length = foregroundColorSpanArr.length;
                while (i2 < length) {
                    Object obj = foregroundColorSpanArr[i2];
                    b.setSpan(obj, spannable.getSpanStart(obj), spannable.getSpanEnd(obj), spannable.getSpanFlags(obj));
                    i2++;
                }
            }
            AppMethodBeat.m2505o(30144);
            return b;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cf */
        public final void mo48794cf(String str, boolean z) {
            AppMethodBeat.m2504i(30145);
            List<C45142c> aC = C41747z.aeU().mo60336aC(this.jMp, str);
            clearData();
            for (C45142c c45142c : aC) {
                boolean isGroup = c45142c.isGroup();
                if (isGroup && this.yEF) {
                    this.yEI.add(c45142c);
                } else if (!isGroup && this.yEE) {
                    this.yEH.add(c45142c);
                    this.yEG.add(c45142c);
                }
            }
            if (this.yEE) {
                this.yEQ = this.yEH.size() <= this.yED;
            }
            mo48804qm(z);
            AppMethodBeat.m2505o(30145);
        }

        /* Access modifiers changed, original: final */
        public final void aqW(final String str) {
            AppMethodBeat.m2504i(30146);
            if (this.yEE) {
                C5004al.m7442n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(30137);
                        if (str.equals(C30405a.this.ema)) {
                            C9638aw.m17182Rg().mo14541a(new C45144l(C30405a.this.jMp, str, 0), 0);
                            AppMethodBeat.m2505o(30137);
                            return;
                        }
                        AppMethodBeat.m2505o(30137);
                    }
                }, 200);
                AppMethodBeat.m2505o(30146);
                return;
            }
            AppMethodBeat.m2505o(30146);
        }

        private void dAU() {
            boolean z;
            int i;
            int i2 = 1;
            AppMethodBeat.m2504i(30147);
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
            AppMethodBeat.m2505o(30147);
        }

        /* Access modifiers changed, original: final */
        public final void clearData() {
            AppMethodBeat.m2504i(30148);
            this.yEV = 0;
            this.yEH.clear();
            this.yEG.clear();
            this.yEI.clear();
            AppMethodBeat.m2505o(30148);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: qm */
        public final void mo48804qm(boolean z) {
            AppMethodBeat.m2504i(30149);
            dAV();
            dAU();
            if (z) {
                notifyDataSetChanged();
                dAW();
            }
            AppMethodBeat.m2505o(30149);
        }

        private void dAV() {
            int i = 0;
            AppMethodBeat.m2504i(30150);
            this.yEK.clear();
            this.yEN.clear();
            for (int i2 = 0; i2 < Math.min(this.yED, this.yEH.size()); i2++) {
                this.yEK.add(new C40681g(C40681g.yEZ, this.yEH.get(i2)));
            }
            while (i < Math.min(this.yED, this.yEI.size())) {
                this.yEN.add(new C40681g(C40681g.yFa, this.yEI.get(i)));
                i++;
            }
            AppMethodBeat.m2505o(30150);
        }

        /* Access modifiers changed, original: final */
        public final void dAW() {
            AppMethodBeat.m2504i(30151);
            ((BizChatSearchUI) this.context).mo70157a(this);
            AppMethodBeat.m2505o(30151);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$2 */
    class C361062 implements OnItemClickListener {
        C361062() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            long j2 = -1;
            AppMethodBeat.m2504i(30136);
            C40681g NZ = BizChatSearchUI.this.yEA.mo48792NZ(i);
            BizChatSearchUI bizChatSearchUI = BizChatSearchUI.this;
            Intent intent;
            if (NZ.klY == C40681g.yEZ || NZ.klY == C40681g.yFa) {
                C45142c c45142c;
                if (NZ.data instanceof C45142c) {
                    long j3;
                    c45142c = (C45142c) NZ.data;
                    if (c45142c != null) {
                        j3 = c45142c.field_bizChatLocalId;
                    } else {
                        j3 = -1;
                    }
                    j2 = j3;
                } else if (NZ.data instanceof C35932kh) {
                    boolean z;
                    C44135kk c44135kk = ((C35932kh) NZ.data).vNe;
                    String str = bizChatSearchUI.jMp;
                    C45143j c45143j = new C45143j();
                    c45143j.field_userId = c44135kk.vNc;
                    c45143j.field_userName = c44135kk.kfT;
                    c45143j.field_brandUserName = str;
                    c45143j.field_headImageUrl = c44135kk.vMW;
                    c45143j.field_profileUrl = c44135kk.vNk;
                    c45143j.field_UserVersion = c44135kk.ver;
                    c45143j.field_addMemberUrl = c44135kk.vNa;
                    if (C41747z.aeV().mo60354b(c45143j)) {
                        z = true;
                    } else {
                        z = C41747z.aeV().mo60353a(c45143j);
                    }
                    if (z) {
                        c45142c = new C45142c();
                        c45142c.field_bizChatServId = c45143j.field_userId;
                        c45142c.field_brandUserName = c45143j.field_brandUserName;
                        c45142c.field_chatName = c45143j.field_userName;
                        c45142c.field_chatType = 1;
                        c45142c = C25754e.m40896e(c45142c);
                        if (c45142c != null) {
                            C32232a fv = C41747z.aeU().mo60340fv(c45142c.field_bizChatLocalId);
                            fv.field_bizChatId = c45142c.field_bizChatLocalId;
                            fv.field_unReadCount = 0;
                            if (C5046bo.isNullOrNil(fv.field_brandUserName)) {
                                fv.field_brandUserName = c45142c.field_brandUserName;
                                fv.field_lastMsgTime = System.currentTimeMillis();
                                fv.field_flag = fv.field_lastMsgTime;
                            }
                            if (!C41747z.aeU().mo60337b(fv)) {
                                C41747z.aeU().mo60335a(fv);
                            }
                            j2 = c45142c.field_bizChatLocalId;
                        }
                    }
                }
                if (C5046bo.isNullOrNil(bizChatSearchUI.jMp) || j2 < 0) {
                    AppMethodBeat.m2505o(30136);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Chat_User", bizChatSearchUI.jMp);
                intent.putExtra("key_biz_chat_id", j2);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                intent.putExtra("key_is_biz_chat", true);
                C25985d.m41473f(bizChatSearchUI.mController.ylL, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.m2505o(30136);
                return;
            }
            if (NZ.klY == C40681g.yFb) {
                if (((Integer) NZ.data).intValue() == C40681g.yFf) {
                    intent = new Intent(bizChatSearchUI.mController.ylL, BizChatSearchUI.class);
                    intent.putExtra("enterprise_biz_name", bizChatSearchUI.jMp);
                    intent.putExtra("biz_chat_search_scene", 2);
                    intent.putExtra("biz_chat_search_text", bizChatSearchUI.jLK.getSearchContent());
                    bizChatSearchUI.startActivity(intent);
                    AppMethodBeat.m2505o(30136);
                    return;
                } else if (((Integer) NZ.data).intValue() == C40681g.yFg) {
                    intent = new Intent(bizChatSearchUI.mController.ylL, BizChatSearchUI.class);
                    intent.putExtra("enterprise_biz_name", bizChatSearchUI.jMp);
                    intent.putExtra("biz_chat_search_scene", 3);
                    intent.putExtra("biz_chat_search_text", bizChatSearchUI.jLK.getSearchContent());
                    bizChatSearchUI.startActivity(intent);
                }
            }
            AppMethodBeat.m2505o(30136);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$e */
    static class C36107e {
        public View contentView;
        public ImageView iqT;
        public TextView mJS;

        private C36107e() {
        }

        /* synthetic */ C36107e(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$d */
    static class C40680d {
        public View contentView;
        public TextView mJS;

        private C40680d() {
        }

        /* synthetic */ C40680d(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$g */
    static class C40681g {
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

        public C40681g() {
            this.klY = yEY;
            this.data = null;
        }

        public C40681g(int i, Object obj) {
            this.klY = i;
            this.data = obj;
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$1 */
    class C442781 implements OnScrollListener {
        boolean jLx = false;

        C442781() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(30135);
            if (i == 0 && this.jLx && BizChatSearchUI.this.yEA.yEP) {
                C30405a a = BizChatSearchUI.this.yEA;
                if (a.dAS() && !a.yER) {
                    a.yER = true;
                    C9638aw.m17182Rg().mo14541a(new C45144l(a.jMp, a.ema, a.yEV), 0);
                    a.dAW();
                }
            }
            AppMethodBeat.m2505o(30135);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 == i3) {
                this.jLx = true;
            } else {
                this.jLx = false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchUI$f */
    static class C44279f {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;

        private C44279f() {
        }

        /* synthetic */ C44279f(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BizChatSearchUI() {
        AppMethodBeat.m2504i(30159);
        AppMethodBeat.m2505o(30159);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30160);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(30160);
    }

    private void aWh() {
        AppMethodBeat.m2504i(30161);
        if (C5046bo.isNullOrNil(this.jMp)) {
            this.jMp = getIntent().getStringExtra("enterprise_biz_name");
            this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
            this.yEw = getIntent().getStringExtra("biz_chat_search_text");
            if (C5046bo.isNullOrNil(this.jMp)) {
                finish();
            }
        }
        AppMethodBeat.m2505o(30161);
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public final void initView() {
        AppMethodBeat.m2504i(30162);
        aWh();
        this.yEy = (BizChatSearchListView) findViewById(2131823621);
        this.yEz = (TextView) findViewById(2131820904);
        this.yEA = new C30405a(this.mController.ylL, this.jMp, this.scene);
        if (C30405a.m48493b(this.yEA)) {
            this.yEx = new C5298c();
            this.yEy.addFooterView(this.yEx.mo10898hQ(this.mController.ylL));
            m79999NY(0);
        }
        this.yEy.setAdapter(this.yEA);
        this.yEy.setOnItemClickListener(new C361062());
        this.yEy.setOnTouchListener(this);
        if (C30405a.m48493b(this.yEA)) {
            this.yEy.setOnScrollListener(this.nfn);
        }
        this.jLK = new C42239b();
        this.jLK.mo11371qQ(C30405a.m48494c(this.yEA));
        this.jLK.mo67775a(this);
        this.jLK.gcl = false;
        AppMethodBeat.m2505o(30162);
    }

    /* renamed from: a */
    public final void mo70157a(C30405a c30405a) {
        AppMethodBeat.m2504i(30163);
        if (!C30405a.m48494c(c30405a)) {
            if (C5046bo.isNullOrNil(c30405a.ema)) {
                this.yEz.setVisibility(0);
                this.yEz.setText("");
                this.yEy.setVisibility(8);
            } else if (C30405a.m48493b(c30405a) && c30405a.yEQ) {
                this.yEz.setVisibility(0);
                this.yEz.setText(C25738R.string.a_t);
                this.yEy.setVisibility(8);
            } else if (C30405a.m48493b(c30405a) && c30405a.yEU) {
                this.yEz.setVisibility(0);
                this.yEz.setText(C25738R.string.a_u);
                this.yEy.setVisibility(8);
            } else if (c30405a.getCount() <= 0) {
                this.yEz.setVisibility(0);
                this.yEz.setText(C34204f.m56087a(getString(C25738R.string.dzw), getString(C25738R.string.dzv), C39127d.m66573b(c30405a.ema, c30405a.ema)).mDR);
                this.yEy.setVisibility(8);
            } else {
                this.yEz.setVisibility(8);
                this.yEy.setVisibility(0);
            }
            if (C30405a.m48493b(c30405a)) {
                if (c30405a.yER) {
                    m79999NY(1);
                    AppMethodBeat.m2505o(30163);
                    return;
                } else if (c30405a.yEP) {
                    m79999NY(2);
                    AppMethodBeat.m2505o(30163);
                    return;
                } else {
                    m79999NY(0);
                }
            }
            AppMethodBeat.m2505o(30163);
        } else if (C5046bo.isNullOrNil(c30405a.ema)) {
            this.yEz.setVisibility(8);
            this.yEy.setVisibility(8);
            AppMethodBeat.m2505o(30163);
        } else if (c30405a.getCount() <= 0) {
            this.yEz.setVisibility(0);
            this.yEy.setVisibility(8);
            AppMethodBeat.m2505o(30163);
        } else {
            this.yEz.setVisibility(8);
            this.yEy.setVisibility(0);
            AppMethodBeat.m2505o(30163);
        }
    }

    public final void app() {
    }

    public final void apo() {
        AppMethodBeat.m2504i(30164);
        finish();
        AppMethodBeat.m2505o(30164);
    }

    /* renamed from: vO */
    public final void mo7460vO(String str) {
        CharSequence charSequence = null;
        AppMethodBeat.m2504i(30165);
        if (!C5046bo.isNullOrNil(str) || this.yEw == null) {
            C30405a c30405a = this.yEA;
            c30405a.ema = str;
            if (C5046bo.isNullOrNil(str)) {
                c30405a.clearData();
                c30405a.yEQ = false;
                c30405a.yEU = false;
                c30405a.mo48804qm(true);
                AppMethodBeat.m2505o(30165);
                return;
            } else if (c30405a.dAS()) {
                c30405a.yEQ = true;
                c30405a.yEU = false;
                c30405a.dAW();
                c30405a.mo48794cf(str, false);
                c30405a.aqW(str);
                AppMethodBeat.m2505o(30165);
                return;
            } else {
                c30405a.mo48794cf(str, true);
                if (c30405a.yEE && c30405a.yEQ) {
                    c30405a.aqW(str);
                }
                AppMethodBeat.m2505o(30165);
                return;
            }
        }
        String str2 = this.yEw;
        this.yEw = null;
        if (!str2.equals("")) {
            this.jLK.setSearchContent(str2);
        }
        C42239b c42239b = this.jLK;
        if (C30405a.m48494c(this.yEA)) {
            charSequence = this.mController.ylL.getResources().getString(C25738R.string.a_v);
        } else if (C30405a.m48493b(this.yEA)) {
            charSequence = this.mController.ylL.getResources().getString(C25738R.string.a_z);
        } else if (C30405a.m48496e(this.yEA)) {
            charSequence = this.mController.ylL.getResources().getString(C25738R.string.a_s);
        }
        c42239b.setHint(charSequence);
        this.jLK.clearFocus();
        AppMethodBeat.m2505o(30165);
    }

    /* renamed from: vN */
    public final boolean mo7459vN(String str) {
        AppMethodBeat.m2504i(30166);
        aqX();
        AppMethodBeat.m2505o(30166);
        return true;
    }

    public final void amJ() {
        AppMethodBeat.m2504i(30167);
        aqX();
        AppMethodBeat.m2505o(30167);
    }

    public void onPause() {
        AppMethodBeat.m2504i(30168);
        super.onPause();
        this.jLK.cancel();
        this.jLK.clearFocus();
        AppMethodBeat.m2505o(30168);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30169);
        super.onDestroy();
        AppMethodBeat.m2505o(30169);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(30170);
        this.jLK.mo11359a((FragmentActivity) this, menu);
        AppMethodBeat.m2505o(30170);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(30171);
        this.jLK.mo11358a(this, menu);
        AppMethodBeat.m2505o(30171);
        return true;
    }

    /* renamed from: a */
    public final void mo21125a(boolean z, String[] strArr, long j, int i) {
    }

    public final int getLayoutId() {
        return 2130969402;
    }

    public final boolean aWe() {
        AppMethodBeat.m2504i(30172);
        aqX();
        AppMethodBeat.m2505o(30172);
        return false;
    }

    /* renamed from: NY */
    private void m79999NY(int i) {
        AppMethodBeat.m2504i(30173);
        if (this.yEx != null) {
            this.yEx.mo10899sd(i);
        }
        AppMethodBeat.m2505o(30173);
    }
}
