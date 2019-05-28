package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar;
import com.tencent.p177mm.p612ui.base.sortview.BaseSortView;
import com.tencent.p177mm.p612ui.base.sortview.C36085c.C15543a;
import com.tencent.p177mm.p612ui.base.sortview.C36087d;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.C23396hd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView */
public class BankRemitSortView extends BaseSortView {
    private final String TAG = "MicroMsg.BankcardSortView";
    private ListView jMQ;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView$a */
    class C13046a {
        CdnImageView pMa;
        TextView pMc;
        TextView pOw;

        private C13046a() {
        }

        /* synthetic */ C13046a(BankRemitSortView bankRemitSortView, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView$1 */
    class C216411 implements C15543a {
        C216411() {
        }

        /* renamed from: a */
        public final View mo22902a(C36087d c36087d, View view, int i, boolean z, boolean z2) {
            AppMethodBeat.m2504i(44698);
            Context context = BankRemitSortView.this.getContext();
            if (view == null) {
                view = LayoutInflater.from(context).inflate(2130968829, null);
                C13046a c13046a = new C13046a(BankRemitSortView.this, (byte) 0);
                c13046a.pOw = (TextView) view.findViewById(2131821694);
                c13046a.pMc = (TextView) view.findViewById(2131821697);
                c13046a.pMa = (CdnImageView) view.findViewById(2131821696);
                view.setTag(c13046a);
            }
            C13046a c13046a2 = (C13046a) view.getTag();
            C23396hd c23396hd = (C23396hd) c36087d.data;
            if (c23396hd != null) {
                if (BankRemitSortView.this.yDy && z) {
                    if (c36087d.yDG.equals("☆")) {
                        c13046a2.pOw.setText(C25738R.string.a4y);
                    } else {
                        c13046a2.pOw.setText(c36087d.yDG);
                    }
                    c13046a2.pOw.setVisibility(0);
                } else {
                    c13046a2.pOw.setVisibility(8);
                }
                c13046a2.pMa.setUseSdcardCache(true);
                c13046a2.pMa.mo38953hI(c23396hd.pLH, C46362b.m87140UK(c23396hd.pLH));
                c13046a2.pMc.setText(c23396hd.nuL);
            } else {
                C4990ab.m7421w("MicroMsg.BankcardSortView", "elem is null: %s", Integer.valueOf(i));
            }
            AppMethodBeat.m2505o(44698);
            return view;
        }
    }

    public BankRemitSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View inflate() {
        AppMethodBeat.m2504i(44699);
        View inflate = View.inflate(getContext(), 2130968830, this);
        AppMethodBeat.m2505o(44699);
        return inflate;
    }

    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.m2504i(44700);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(2131821699);
        AppMethodBeat.m2505o(44700);
        return verticalScrollBar;
    }

    public ListView getListView() {
        AppMethodBeat.m2504i(44701);
        this.jMQ = (ListView) findViewById(2131821698);
        ListView listView = this.jMQ;
        AppMethodBeat.m2505o(44701);
        return listView;
    }

    public View getNoResultView() {
        return null;
    }

    /* renamed from: a */
    public final boolean mo22884a(String str, C36087d c36087d) {
        return false;
    }

    public C15543a getItemViewCreator() {
        AppMethodBeat.m2504i(44702);
        C216411 c216411 = new C216411();
        AppMethodBeat.m2505o(44702);
        return c216411;
    }
}
