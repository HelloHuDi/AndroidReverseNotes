package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d extends a {
    private View ksr;
    private TextView kss;
    private TextView kst;
    private View ksu;
    private TextView ksv;
    private TextView ksw;
    private View ksx;
    private View ksy;
    private View ksz;

    public d(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.i(88976);
        this.ksr = this.ksf.findViewById(R.id.agj);
        this.kss = (TextView) this.ksf.findViewById(R.id.agk);
        this.kst = (TextView) this.ksf.findViewById(R.id.agl);
        this.ksu = this.ksf.findViewById(R.id.agm);
        this.ksv = (TextView) this.ksf.findViewById(R.id.agn);
        this.ksw = (TextView) this.ksf.findViewById(R.id.ago);
        this.ksy = this.ksf.findViewById(R.id.agr);
        this.ksz = this.ksf.findViewById(R.id.agq);
        AppMethodBeat.o(88976);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        tm tmVar;
        AppMethodBeat.i(88977);
        if (this.kaS.aZV().vTW == null || this.kaS.aZV().vTW.size() <= 0) {
            ab.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
        } else {
            LinkedList linkedList = this.kaS.aZV().vTW;
            tm tmVar2 = null;
            if (linkedList.size() == 1) {
                tmVar = (tm) linkedList.get(0);
            } else {
                tmVar = (tm) linkedList.get(0);
                tmVar2 = (tm) linkedList.get(1);
            }
            if (tmVar != null) {
                this.ksr.setVisibility(0);
                this.kss.setText(tmVar.title);
                this.kst.setText(tmVar.kbW);
                if (!TextUtils.isEmpty(tmVar.vUX)) {
                    this.kss.setTextColor(l.Hn(tmVar.vUX));
                }
                if (!TextUtils.isEmpty(tmVar.vUY)) {
                    this.kst.setTextColor(l.Hn(tmVar.vUY));
                }
            }
            if (tmVar2 != null) {
                this.ksu.setVisibility(0);
                this.ksv.setText(tmVar2.title);
                this.ksw.setText(tmVar2.kbW);
                if (!TextUtils.isEmpty(tmVar2.vUX)) {
                    this.ksv.setTextColor(l.Hn(tmVar2.vUX));
                }
                if (!TextUtils.isEmpty(tmVar2.vUY)) {
                    this.ksw.setTextColor(l.Hn(tmVar2.vUY));
                }
            }
        }
        if (this.kaS.aZB() && !this.kaS.aZH()) {
            ab.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        } else if (this.kaS.aZW().vSc == null || this.kaS.aZW().vSc.size() <= 0) {
            if (this.ksx != null) {
                this.ksx.setVisibility(8);
            }
            this.ksf.findViewById(R.id.agq).setVisibility(8);
        } else {
            if (this.ksx == null) {
                this.ksx = ((ViewStub) this.ksf.findViewById(R.id.agp)).inflate();
            }
            this.ksf.findViewById(R.id.agq).setVisibility(8);
            View view = this.ksx;
            b bVar = this.kaS;
            OnClickListener onClickListener = this.gKK;
            LinkedList linkedList2 = bVar.aZW().vSc;
            if (linkedList2.size() == 1) {
                view.findViewById(R.id.aiy).setVisibility(0);
                tmVar = (tm) linkedList2.get(0);
                ((TextView) view.findViewById(R.id.aiz)).setText(tmVar.title);
                ((TextView) view.findViewById(R.id.aj0)).setText(tmVar.kbW);
                view.findViewById(R.id.aiy).setOnClickListener(onClickListener);
                if (!TextUtils.isEmpty(tmVar.vUX)) {
                    ((TextView) view.findViewById(R.id.aiz)).setTextColor(l.Hn(tmVar.vUX));
                }
                if (!TextUtils.isEmpty(tmVar.vUY)) {
                    ((TextView) view.findViewById(R.id.aj0)).setTextColor(l.Hn(tmVar.vUY));
                }
                view.findViewById(R.id.aj1).setVisibility(8);
            } else if (linkedList2.size() >= 2) {
                tmVar = (tm) linkedList2.get(0);
                ((TextView) view.findViewById(R.id.aiz)).setText(tmVar.title);
                ((TextView) view.findViewById(R.id.aj0)).setText(tmVar.kbW);
                if (!TextUtils.isEmpty(tmVar.vUX)) {
                    ((TextView) view.findViewById(R.id.aiz)).setTextColor(l.Hn(tmVar.vUX));
                }
                if (!TextUtils.isEmpty(tmVar.vUY)) {
                    ((TextView) view.findViewById(R.id.aj0)).setTextColor(l.Hn(tmVar.vUY));
                }
                tmVar = (tm) linkedList2.get(1);
                ((TextView) view.findViewById(R.id.aj2)).setText(tmVar.title);
                ((TextView) view.findViewById(R.id.aj3)).setText(tmVar.kbW);
                if (!TextUtils.isEmpty(tmVar.vUX)) {
                    ((TextView) view.findViewById(R.id.aj2)).setTextColor(l.Hn(tmVar.vUX));
                }
                if (!TextUtils.isEmpty(tmVar.vUY)) {
                    ((TextView) view.findViewById(R.id.aj3)).setTextColor(l.Hn(tmVar.vUY));
                }
                view.findViewById(R.id.aiy).setOnClickListener(onClickListener);
                view.findViewById(R.id.aj1).setOnClickListener(onClickListener);
            }
        }
        if (this.kaS.isNormal()) {
            this.ksy.setVisibility(8);
        } else {
            this.ksy.setVisibility(0);
            TextView textView = (TextView) this.ksy.findViewById(R.id.ajz);
            if (TextUtils.isEmpty(this.kaS.aZV().vUu)) {
                m.c(textView, this.kaS.aZW().status);
            } else {
                textView.setText(this.kaS.aZV().vUu);
            }
        }
        if (this.kaS.aZW().vSl == null && this.kaS.isNormal()) {
            this.ksz.setVisibility(0);
            AppMethodBeat.o(88977);
            return;
        }
        this.ksz.setVisibility(8);
        AppMethodBeat.o(88977);
    }
}
