package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar;
import com.tencent.p177mm.p612ui.base.sortview.BaseSortView;
import com.tencent.p177mm.p612ui.base.sortview.C36085c.C15543a;
import com.tencent.p177mm.p612ui.base.sortview.C36087d;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView */
public class BankCardSelectSortView extends BaseSortView {
    private ListView jMQ;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView$1 */
    class C169181 implements C15543a {
        C169181() {
        }

        /* renamed from: a */
        public final View mo22902a(C36087d c36087d, View view, int i, boolean z, boolean z2) {
            AppMethodBeat.m2504i(47866);
            Context context = BankCardSelectSortView.this.getContext();
            if (view == null) {
                view = LayoutInflater.from(context).inflate(2130968829, null);
                C35513b c35513b = new C35513b();
                c35513b.pOw = (TextView) view.findViewById(2131821694);
                c35513b.pMc = (TextView) view.findViewById(2131821697);
                c35513b.pMa = (CdnImageView) view.findViewById(2131821696);
                view.setTag(c35513b);
            }
            C35513b c35513b2 = (C35513b) view.getTag();
            if (BankCardSelectSortView.this.yDy && z) {
                c35513b2.pOw.setText(c36087d.yDG);
                c35513b2.pOw.setVisibility(0);
            } else {
                c35513b2.pOw.setVisibility(8);
            }
            C35512a c35512a = (C35512a) c36087d.data;
            c35513b2.pMc.setText(c35512a.pcj);
            if (C5046bo.isNullOrNil(c35512a.cIY)) {
                c35513b2.pMa.setImageBitmap(null);
            } else {
                c35513b2.pMa.setUseSdcardCache(true);
                c35513b2.pMa.mo38953hI(c35512a.cIY, c35512a.tNi);
            }
            AppMethodBeat.m2505o(47866);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView$a */
    public static class C35512a {
        public String cIY;
        public String pcj;
        public String puh;
        public String tNi;
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView$b */
    static class C35513b {
        CdnImageView pMa;
        TextView pMc;
        TextView pOw;

        private C35513b() {
        }

        /* synthetic */ C35513b(byte b) {
            this();
        }
    }

    public BankCardSelectSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View inflate() {
        AppMethodBeat.m2504i(47867);
        View inflate = View.inflate(getContext(), 2130968830, this);
        AppMethodBeat.m2505o(47867);
        return inflate;
    }

    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.m2504i(47868);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(2131821699);
        AppMethodBeat.m2505o(47868);
        return verticalScrollBar;
    }

    public ListView getListView() {
        AppMethodBeat.m2504i(47869);
        this.jMQ = (ListView) findViewById(2131821698);
        ListView listView = this.jMQ;
        AppMethodBeat.m2505o(47869);
        return listView;
    }

    public View getNoResultView() {
        AppMethodBeat.m2504i(47870);
        View findViewById = findViewById(2131821700);
        AppMethodBeat.m2505o(47870);
        return findViewById;
    }

    public C15543a getItemViewCreator() {
        AppMethodBeat.m2504i(47872);
        C169181 c169181 = new C169181();
        AppMethodBeat.m2505o(47872);
        return c169181;
    }

    /* renamed from: a */
    public final boolean mo22884a(String str, C36087d c36087d) {
        AppMethodBeat.m2504i(47871);
        boolean contains = ((C35512a) c36087d.data).pcj.toUpperCase().contains(str.toUpperCase());
        AppMethodBeat.m2505o(47871);
        return contains;
    }
}
