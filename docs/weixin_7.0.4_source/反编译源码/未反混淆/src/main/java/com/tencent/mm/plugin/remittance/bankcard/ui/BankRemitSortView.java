package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView extends BaseSortView {
    private final String TAG = "MicroMsg.BankcardSortView";
    private ListView jMQ;

    class a {
        CdnImageView pMa;
        TextView pMc;
        TextView pOw;

        private a() {
        }

        /* synthetic */ a(BankRemitSortView bankRemitSortView, byte b) {
            this();
        }
    }

    public BankRemitSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View inflate() {
        AppMethodBeat.i(44699);
        View inflate = View.inflate(getContext(), R.layout.g6, this);
        AppMethodBeat.o(44699);
        return inflate;
    }

    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(44700);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(R.id.a47);
        AppMethodBeat.o(44700);
        return verticalScrollBar;
    }

    public ListView getListView() {
        AppMethodBeat.i(44701);
        this.jMQ = (ListView) findViewById(R.id.a46);
        ListView listView = this.jMQ;
        AppMethodBeat.o(44701);
        return listView;
    }

    public View getNoResultView() {
        return null;
    }

    public final boolean a(String str, d dVar) {
        return false;
    }

    public com.tencent.mm.ui.base.sortview.c.a getItemViewCreator() {
        AppMethodBeat.i(44702);
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.ui.base.sortview.c.a() {
            public final View a(d dVar, View view, int i, boolean z, boolean z2) {
                AppMethodBeat.i(44698);
                Context context = BankRemitSortView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.g5, null);
                    a aVar = new a(BankRemitSortView.this, (byte) 0);
                    aVar.pOw = (TextView) view.findViewById(R.id.a42);
                    aVar.pMc = (TextView) view.findViewById(R.id.a45);
                    aVar.pMa = (CdnImageView) view.findViewById(R.id.a44);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                hd hdVar = (hd) dVar.data;
                if (hdVar != null) {
                    if (BankRemitSortView.this.yDy && z) {
                        if (dVar.yDG.equals("☆")) {
                            aVar2.pOw.setText(R.string.a4y);
                        } else {
                            aVar2.pOw.setText(dVar.yDG);
                        }
                        aVar2.pOw.setVisibility(0);
                    } else {
                        aVar2.pOw.setVisibility(8);
                    }
                    aVar2.pMa.setUseSdcardCache(true);
                    aVar2.pMa.hI(hdVar.pLH, b.UK(hdVar.pLH));
                    aVar2.pMc.setText(hdVar.nuL);
                } else {
                    ab.w("MicroMsg.BankcardSortView", "elem is null: %s", Integer.valueOf(i));
                }
                AppMethodBeat.o(44698);
                return view;
            }
        };
        AppMethodBeat.o(44702);
        return anonymousClass1;
    }
}
