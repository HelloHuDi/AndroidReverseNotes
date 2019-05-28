package com.tencent.p177mm.plugin.fav.p410ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavTagPanel.C20749a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView */
public class FavSearchActionView extends LinearLayout {
    private ImageView lnh;
    public FavTagPanel mjS;
    public List<Integer> mlj = new LinkedList();
    private ImageButton mpR;
    public List<String> mpS = new LinkedList();
    public List<String> mpT = new LinkedList();
    public C28034a mpU;

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView$a */
    public interface C28034a {
        /* renamed from: a */
        void mo7324a(String str, List<Integer> list, List<String> list2, List<String> list3);

        /* renamed from: a */
        void mo7325a(List<Integer> list, List<String> list2, List<String> list3, boolean z);

        void app();
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView$1 */
    class C341751 implements C20749a {
        C341751() {
        }

        /* renamed from: JR */
        public final void mo23722JR(String str) {
            AppMethodBeat.m2504i(74682);
            C4990ab.m7411d("MicroMsg.FavSearchActionView", "unselected tag %s", str);
            FavSearchActionView.this.mjS.removeTag(str);
            mo23724JT(str);
            AppMethodBeat.m2505o(74682);
        }

        /* renamed from: JS */
        public final void mo23723JS(String str) {
        }

        /* renamed from: JT */
        public final void mo23724JT(String str) {
            AppMethodBeat.m2504i(74683);
            FavSearchActionView.m85291a(FavSearchActionView.this, FavSearchActionView.this.mjS.getEditText());
            FavSearchActionView.this.mpS.remove(str);
            FavSearchActionView.m85294c(FavSearchActionView.this);
            if (FavSearchActionView.this.mpU == null) {
                AppMethodBeat.m2505o(74683);
                return;
            }
            FavSearchActionView.this.mpU.mo7325a(FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS, true);
            AppMethodBeat.m2505o(74683);
        }

        /* renamed from: JU */
        public final void mo23725JU(String str) {
            AppMethodBeat.m2504i(74684);
            FavSearchActionView.m85291a(FavSearchActionView.this, FavSearchActionView.this.mjS.getEditText());
            FavSearchActionView.m85294c(FavSearchActionView.this);
            if (FavSearchActionView.this.mpU == null) {
                AppMethodBeat.m2505o(74684);
                return;
            }
            FavSearchActionView.this.mpU.mo7324a(str, FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS);
            AppMethodBeat.m2505o(74684);
        }

        /* renamed from: JV */
        public final void mo23726JV(String str) {
            AppMethodBeat.m2504i(74685);
            FavSearchActionView.m85291a(FavSearchActionView.this, str);
            FavSearchActionView.this.mpU.mo7325a(FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS, false);
            AppMethodBeat.m2505o(74685);
        }

        public final void bmm() {
            AppMethodBeat.m2504i(74686);
            if (FavSearchActionView.this.mpU == null) {
                AppMethodBeat.m2505o(74686);
                return;
            }
            FavSearchActionView.this.mpU.app();
            AppMethodBeat.m2505o(74686);
        }

        /* renamed from: Mi */
        public final void mo36054Mi(String str) {
            AppMethodBeat.m2504i(74687);
            C4990ab.m7411d("MicroMsg.FavSearchActionView", "unselected type %s", str);
            FavSearchActionView.this.mjS;
            FavSearchActionView.m85291a(FavSearchActionView.this, FavSearchActionView.this.mjS.getEditText());
            FavSearchActionView.this.mlj.remove(FavSearchActionView.m85292ap(FavSearchActionView.this.getContext(), str));
            FavSearchActionView.m85294c(FavSearchActionView.this);
            if (FavSearchActionView.this.mpU != null) {
                FavSearchActionView.this.mpU.mo7325a(FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS, true);
            }
            AppMethodBeat.m2505o(74687);
        }

        /* renamed from: q */
        public final void mo23728q(boolean z, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView$2 */
    class C341762 implements OnClickListener {
        C341762() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74688);
            if (FavSearchActionView.this.mpU == null) {
                AppMethodBeat.m2505o(74688);
                return;
            }
            FavSearchActionView.this.mjS.dAg();
            FavSearchActionView.this.mjS.dAb();
            FavSearchActionView.this.mpT.clear();
            FavSearchActionView.this.mpS.clear();
            FavSearchActionView.this.mpU.mo7325a(FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS, true);
            FavSearchActionView.m85294c(FavSearchActionView.this);
            AppMethodBeat.m2505o(74688);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m85291a(FavSearchActionView favSearchActionView, String str) {
        AppMethodBeat.m2504i(74697);
        favSearchActionView.mo73790Mh(str);
        AppMethodBeat.m2505o(74697);
    }

    /* renamed from: c */
    static /* synthetic */ void m85294c(FavSearchActionView favSearchActionView) {
        AppMethodBeat.m2504i(74698);
        favSearchActionView.bwB();
        AppMethodBeat.m2505o(74698);
    }

    public FavSearchActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(74689);
        AppMethodBeat.m2505o(74689);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(74690);
        super.onFinishInflate();
        this.mpR = (ImageButton) findViewById(2131823967);
        this.mjS = (FavTagPanel) findViewById(2131823966);
        this.lnh = (ImageView) findViewById(2131820978);
        if (this.mjS != null) {
            this.mjS.setEditTextColor(getResources().getColor(C25738R.color.f11785h7));
            this.mjS.setTagTipsDrawable(0);
            this.mjS.setTagHighlineBG(0);
            this.mjS.setTagSelectedBG(0);
            this.mjS.setTagSelectedTextColorRes(C25738R.color.f11795hi);
            this.mjS.setTagNormalBG(0);
            this.mjS.setTagNormalTextColorRes(C25738R.color.a69);
            this.mjS.setEditHint(getResources().getString(C25738R.string.f9220te));
            this.mjS.mo71963qe(true);
            this.mjS.yxn = false;
            this.mjS.yxo = true;
            this.mjS.setCallBack(new C341751());
        }
        if (this.mpR != null) {
            this.mpR.setOnClickListener(new C341762());
        }
        AppMethodBeat.m2505o(74690);
    }

    /* renamed from: Mh */
    public final void mo73790Mh(String str) {
        AppMethodBeat.m2504i(74691);
        this.mpT.clear();
        for (String str2 : C5046bo.m7532bc(str, "").split(" ")) {
            if (!C5046bo.isNullOrNil(str2)) {
                this.mpT.add(str2);
            }
        }
        AppMethodBeat.m2505o(74691);
    }

    public void setOnSearchChangedListener(C28034a c28034a) {
        this.mpU = c28034a;
    }

    public List<String> getSearchKeys() {
        AppMethodBeat.m2504i(74692);
        if (this.mjS != null) {
            mo73790Mh(this.mjS.getEditText());
        }
        List list = this.mpT;
        AppMethodBeat.m2505o(74692);
        return list;
    }

    public List<String> getSearchTags() {
        return this.mpS;
    }

    private void bwB() {
        AppMethodBeat.m2504i(74693);
        if (this.mlj.isEmpty() && this.mpS.isEmpty()) {
            this.mjS.setEditHint(getResources().getString(C25738R.string.f9220te));
            AppMethodBeat.m2505o(74693);
            return;
        }
        this.mjS.setEditHint("");
        AppMethodBeat.m2505o(74693);
    }

    /* renamed from: S */
    public final void mo73791S(int i, boolean z) {
        AppMethodBeat.m2504i(74694);
        this.mlj.clear();
        this.mlj.add(Integer.valueOf(i));
        if (this.mjS == null) {
            AppMethodBeat.m2505o(74694);
            return;
        }
        bwB();
        this.mjS.setType(FavSearchActionView.m85289M(getContext(), i));
        if (this.mpU == null) {
            AppMethodBeat.m2505o(74694);
            return;
        }
        mo73790Mh(this.mjS.getEditText());
        if (z) {
            this.mpU.mo7325a(this.mlj, this.mpT, this.mpS, false);
        }
        C7060h.pYm.mo8381e(11126, Integer.valueOf(1));
        AppMethodBeat.m2505o(74694);
    }

    /* renamed from: M */
    private static String m85289M(Context context, int i) {
        AppMethodBeat.m2504i(74695);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(74695);
            return str;
        }
        switch (i) {
            case 3:
                str = context.getString(C25738R.string.brw);
                AppMethodBeat.m2505o(74695);
                return str;
            case 5:
                str = context.getString(C25738R.string.bru);
                AppMethodBeat.m2505o(74695);
                return str;
            case 6:
                str = context.getString(C25738R.string.brq);
                AppMethodBeat.m2505o(74695);
                return str;
            case 7:
                str = context.getString(C25738R.string.brr);
                AppMethodBeat.m2505o(74695);
                return str;
            case 8:
                str = context.getString(C25738R.string.brn);
                AppMethodBeat.m2505o(74695);
                return str;
            case 17:
                str = context.getString(C25738R.string.brt);
                AppMethodBeat.m2505o(74695);
                return str;
            case 18:
                str = context.getString(C25738R.string.brs);
                AppMethodBeat.m2505o(74695);
                return str;
            case 21:
                str = context.getString(C25738R.string.brp);
                AppMethodBeat.m2505o(74695);
                return str;
            default:
                str = "";
                AppMethodBeat.m2505o(74695);
                return str;
        }
    }

    /* renamed from: ap */
    public static Integer m85292ap(Context context, String str) {
        AppMethodBeat.m2504i(74696);
        Integer valueOf;
        if (context == null) {
            valueOf = Integer.valueOf(-1);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        } else if (context.getString(C25738R.string.brp).equals(str)) {
            valueOf = Integer.valueOf(21);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        } else if (context.getString(C25738R.string.bru).equals(str)) {
            valueOf = Integer.valueOf(5);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        } else if (context.getString(C25738R.string.brn).equals(str)) {
            valueOf = Integer.valueOf(8);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        } else if (context.getString(C25738R.string.brr).equals(str)) {
            valueOf = Integer.valueOf(7);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        } else if (context.getString(C25738R.string.brt).equals(str)) {
            valueOf = Integer.valueOf(17);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        } else if (context.getString(C25738R.string.brw).equals(str)) {
            valueOf = Integer.valueOf(3);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        } else if (context.getString(C25738R.string.brs).equals(str)) {
            valueOf = Integer.valueOf(18);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        } else if (context.getString(C25738R.string.brq).equals(str)) {
            valueOf = Integer.valueOf(6);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        } else {
            valueOf = Integer.valueOf(-1);
            AppMethodBeat.m2505o(74696);
            return valueOf;
        }
    }
}
