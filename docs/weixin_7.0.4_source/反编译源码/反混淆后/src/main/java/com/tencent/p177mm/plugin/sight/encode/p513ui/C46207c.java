package com.tencent.p177mm.plugin.sight.encode.p513ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.contact.C36251l;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e.C15815a;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e.C40844b;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sight.encode.ui.c */
public final class C46207c extends C40845o {
    public static boolean qAQ = true;
    public static boolean qAR = false;
    List<String> qAO;
    boolean qAP;

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.c$a */
    public class C46206a extends C40843e {

        /* renamed from: com.tencent.mm.plugin.sight.encode.ui.c$a$a */
        public class C21855a extends C15815a {
            public View qAT;
            public View qzN;

            public C21855a() {
                super();
            }
        }

        /* renamed from: com.tencent.mm.plugin.sight.encode.ui.c$a$b */
        public class C29026b extends C40844b {
            public C29026b() {
                super();
            }

            /* renamed from: a */
            public final View mo11086a(Context context, ViewGroup viewGroup) {
                AppMethodBeat.m2504i(25060);
                View inflate = LayoutInflater.from(context).inflate(2130970695, viewGroup, false);
                C21855a c21855a = (C21855a) C46206a.this.clJ();
                c21855a.ejo = (ImageView) inflate.findViewById(2131821183);
                c21855a.gnB = (TextView) inflate.findViewById(2131821185);
                c21855a.gnC = (TextView) inflate.findViewById(2131820991);
                c21855a.contentView = inflate.findViewById(2131826213);
                c21855a.gnD = (CheckBox) inflate.findViewById(2131821593);
                c21855a.qzN = inflate.findViewById(2131827574);
                c21855a.qAT = inflate.findViewById(2131823137);
                inflate.setTag(c21855a);
                c21855a.gnB.setTextColor(-1);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.width = -1;
                inflate.setLayoutParams(layoutParams);
                inflate.setBackgroundResource(C25738R.color.f11782h4);
                AppMethodBeat.m2505o(25060);
                return inflate;
            }

            /* renamed from: a */
            public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
                AppMethodBeat.m2504i(25061);
                C7616ad c7616ad = c5445a.ehM;
                C21855a c21855a = (C21855a) c5446a;
                c21855a.contentView.setVisibility(0);
                c21855a.qAT.setVisibility(8);
                c21855a.qzN.setVisibility(8);
                ViewGroup.LayoutParams layoutParams;
                LinearLayout.LayoutParams layoutParams2;
                if (C46207c.m86404WV(c7616ad.field_username)) {
                    c21855a.ejo.setImageResource(C1318a.sight_icon_draft_item);
                    c21855a.gnB.setText(C25738R.string.ei9);
                    c21855a.gnC.setText(C25738R.string.ei7);
                    c21855a.gnC.setVisibility(0);
                    c21855a.gnD.setEnabled(false);
                    if (C46207c.qAR) {
                        c21855a.contentView.setBackgroundResource(C25738R.drawable.aob);
                        c21855a.gnD.setVisibility(0);
                        c21855a.gnD.setBackgroundResource(C1318a.sight_list_checkbox_selected);
                        c21855a.qzN.setVisibility(0);
                    } else {
                        c21855a.contentView.setBackgroundResource(C25738R.drawable.a0c);
                        c21855a.gnD.setVisibility(8);
                        c21855a.gnD.setBackgroundResource(C1318a.sight_list_checkbox_unselected);
                        c21855a.qzN.setVisibility(8);
                    }
                    C46207c.m86405e(context, c21855a.contentView);
                    layoutParams = c21855a.ejo.getLayoutParams();
                    layoutParams.width = C1338a.m2856al(context, C25738R.dimen.a8c);
                    layoutParams.height = C1338a.m2856al(context, C25738R.dimen.a8c);
                    c21855a.ejo.setLayoutParams(layoutParams);
                    layoutParams2 = (LinearLayout.LayoutParams) c21855a.gnD.getLayoutParams();
                    layoutParams2.height = C1338a.m2856al(context, C25738R.dimen.a8i);
                    layoutParams2.width = C1338a.m2856al(context, C25738R.dimen.a8i);
                    layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                    c21855a.gnD.setLayoutParams(layoutParams2);
                    AppMethodBeat.m2505o(25061);
                    return;
                }
                if (C46207c.m86402WT(c7616ad.field_username)) {
                    c21855a.ejo.setImageResource(C1318a.sight_item_sns_icon);
                    c21855a.gnD.setVisibility(8);
                    c21855a.gnB.setText(context.getString(C25738R.string.eii));
                    c21855a.gnC.setVisibility(8);
                    if (C46207c.qAQ) {
                        c21855a.contentView.setBackgroundResource(C25738R.drawable.a0c);
                        c21855a.qzN.setVisibility(8);
                    } else {
                        c21855a.contentView.setBackgroundResource(C25738R.drawable.aob);
                        c21855a.qzN.setVisibility(0);
                    }
                    C46207c.m86405e(context, c21855a.contentView);
                } else if (C46207c.m86403WU(c7616ad.field_username)) {
                    c21855a.contentView.setVisibility(8);
                    c21855a.qAT.setVisibility(0);
                    AppMethodBeat.m2505o(25061);
                    return;
                } else {
                    super.mo11087a(context, c5446a, c5445a, z, z2);
                    c21855a.contentView.setBackgroundResource(C25738R.drawable.a0c);
                    C46207c.m86405e(context, c21855a.contentView);
                }
                layoutParams = c21855a.ejo.getLayoutParams();
                layoutParams.width = C1338a.m2856al(context, C25738R.dimen.a8c);
                layoutParams.height = C1338a.m2856al(context, C25738R.dimen.a8c);
                c21855a.ejo.setLayoutParams(layoutParams);
                layoutParams2 = (LinearLayout.LayoutParams) c21855a.gnD.getLayoutParams();
                layoutParams2.height = C1338a.m2856al(context, C25738R.dimen.a8i);
                layoutParams2.width = C1338a.m2856al(context, C25738R.dimen.a8i);
                layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                c21855a.gnD.setLayoutParams(layoutParams2);
                c21855a.gnD.setBackgroundResource(C25738R.drawable.a09);
                AppMethodBeat.m2505o(25061);
            }
        }

        public C46206a(int i) {
            super(i);
        }

        public final C5447b aou() {
            AppMethodBeat.m2504i(25062);
            C29026b c29026b = new C29026b();
            AppMethodBeat.m2505o(25062);
            return c29026b;
        }

        public final C5446a clJ() {
            AppMethodBeat.m2504i(25063);
            C21855a c21855a = new C21855a();
            AppMethodBeat.m2505o(25063);
            return c21855a;
        }
    }

    public C46207c(C36251l c36251l) {
        super(c36251l, new ArrayList(), true, true);
        AppMethodBeat.m2504i(25064);
        this.qAP = true;
        this.qAP = true;
        this.qAO = null;
        AppMethodBeat.m2505o(25064);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(25065);
        if (this.qAO == null) {
            AppMethodBeat.m2505o(25065);
            return 0;
        }
        int size = this.qAO.size();
        AppMethodBeat.m2505o(25065);
        return size;
    }

    /* renamed from: aZ */
    public final void mo74228aZ(List<String> list) {
        AppMethodBeat.m2504i(25066);
        clearCache();
        this.qAO = list;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(25066);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(25067);
        if (this.qAO == null) {
            AppMethodBeat.m2505o(25067);
            return null;
        } else if (i < 0 || i >= getCount()) {
            C4990ab.m7413e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(25067);
            return null;
        } else {
            C7616ad c7616ad;
            C5445a c46206a = new C46206a(i);
            String str = (String) this.qAO.get(i);
            if (C46207c.m86402WT(str)) {
                c7616ad = new C7616ad("@sns.tencent");
            } else if (C46207c.m86403WU(str)) {
                c7616ad = new C7616ad("@search.tencent");
            } else if (C46207c.m86404WV(str)) {
                c7616ad = new C7616ad("@draft.tencent");
            } else {
                C9638aw.m17190ZK();
                c7616ad = C18628c.m29078XM().aoO((String) this.qAO.get(i));
            }
            c46206a.ehM = c7616ad;
            c46206a.zmW = this.qAP;
            AppMethodBeat.m2505o(25067);
            return c46206a;
        }
    }

    /* renamed from: WT */
    public static boolean m86402WT(String str) {
        AppMethodBeat.m2504i(25068);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(25068);
            return false;
        }
        boolean endsWith = str.endsWith("@sns.tencent");
        AppMethodBeat.m2505o(25068);
        return endsWith;
    }

    /* renamed from: WU */
    public static boolean m86403WU(String str) {
        AppMethodBeat.m2504i(25069);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(25069);
            return false;
        }
        boolean endsWith = str.endsWith("@search.tencent");
        AppMethodBeat.m2505o(25069);
        return endsWith;
    }

    /* renamed from: WV */
    public static boolean m86404WV(String str) {
        AppMethodBeat.m2504i(25070);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(25070);
            return false;
        }
        boolean endsWith = str.endsWith("@draft.tencent");
        AppMethodBeat.m2505o(25070);
        return endsWith;
    }

    public final boolean clI() {
        return this.qAP;
    }

    /* renamed from: e */
    static /* synthetic */ void m86405e(Context context, View view) {
        AppMethodBeat.m2504i(25071);
        if (view == null || context == null) {
            AppMethodBeat.m2505o(25071);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = C1338a.m2856al(context, C25738R.dimen.a8k);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        view.setLayoutParams(layoutParams);
        view.setPadding(C1338a.fromDPToPix(context, 10), view.getPaddingTop(), C1338a.fromDPToPix(context, 10), view.getPaddingTop());
        AppMethodBeat.m2505o(25071);
    }
}
