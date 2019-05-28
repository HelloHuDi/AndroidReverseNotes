package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.d;

public class BankCardSelectSortView extends BaseSortView {
    private ListView jMQ;

    public static class a {
        public String cIY;
        public String pcj;
        public String puh;
        public String tNi;
    }

    static class b {
        CdnImageView pMa;
        TextView pMc;
        TextView pOw;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public BankCardSelectSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View inflate() {
        AppMethodBeat.i(47867);
        View inflate = View.inflate(getContext(), R.layout.g6, this);
        AppMethodBeat.o(47867);
        return inflate;
    }

    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(47868);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(R.id.a47);
        AppMethodBeat.o(47868);
        return verticalScrollBar;
    }

    public ListView getListView() {
        AppMethodBeat.i(47869);
        this.jMQ = (ListView) findViewById(R.id.a46);
        ListView listView = this.jMQ;
        AppMethodBeat.o(47869);
        return listView;
    }

    public View getNoResultView() {
        AppMethodBeat.i(47870);
        View findViewById = findViewById(R.id.a48);
        AppMethodBeat.o(47870);
        return findViewById;
    }

    public com.tencent.mm.ui.base.sortview.c.a getItemViewCreator() {
        AppMethodBeat.i(47872);
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.ui.base.sortview.c.a() {
            public final View a(d dVar, View view, int i, boolean z, boolean z2) {
                AppMethodBeat.i(47866);
                Context context = BankCardSelectSortView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.g5, null);
                    b bVar = new b();
                    bVar.pOw = (TextView) view.findViewById(R.id.a42);
                    bVar.pMc = (TextView) view.findViewById(R.id.a45);
                    bVar.pMa = (CdnImageView) view.findViewById(R.id.a44);
                    view.setTag(bVar);
                }
                b bVar2 = (b) view.getTag();
                if (BankCardSelectSortView.this.yDy && z) {
                    bVar2.pOw.setText(dVar.yDG);
                    bVar2.pOw.setVisibility(0);
                } else {
                    bVar2.pOw.setVisibility(8);
                }
                a aVar = (a) dVar.data;
                bVar2.pMc.setText(aVar.pcj);
                if (bo.isNullOrNil(aVar.cIY)) {
                    bVar2.pMa.setImageBitmap(null);
                } else {
                    bVar2.pMa.setUseSdcardCache(true);
                    bVar2.pMa.hI(aVar.cIY, aVar.tNi);
                }
                AppMethodBeat.o(47866);
                return view;
            }
        };
        AppMethodBeat.o(47872);
        return anonymousClass1;
    }

    public final boolean a(String str, d dVar) {
        AppMethodBeat.i(47871);
        boolean contains = ((a) dVar.data).pcj.toUpperCase().contains(str.toUpperCase());
        AppMethodBeat.o(47871);
        return contains;
    }
}
