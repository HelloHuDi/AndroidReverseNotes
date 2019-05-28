package com.tencent.p177mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.widget.d */
public final class C38780d extends C2788a {
    private View ksr;
    private TextView kss;
    private TextView kst;
    private View ksu;
    private TextView ksv;
    private TextView ksw;
    private View ksx;
    private View ksy;
    private View ksz;

    public C38780d(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.m2504i(88976);
        this.ksr = this.ksf.findViewById(2131822193);
        this.kss = (TextView) this.ksf.findViewById(2131822194);
        this.kst = (TextView) this.ksf.findViewById(2131822195);
        this.ksu = this.ksf.findViewById(2131822196);
        this.ksv = (TextView) this.ksf.findViewById(2131822197);
        this.ksw = (TextView) this.ksf.findViewById(2131822198);
        this.ksy = this.ksf.findViewById(2131822201);
        this.ksz = this.ksf.findViewById(2131822200);
        AppMethodBeat.m2505o(88976);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        C23446tm c23446tm;
        AppMethodBeat.m2504i(88977);
        if (this.kaS.aZV().vTW == null || this.kaS.aZV().vTW.size() <= 0) {
            C4990ab.m7416i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
        } else {
            LinkedList linkedList = this.kaS.aZV().vTW;
            C23446tm c23446tm2 = null;
            if (linkedList.size() == 1) {
                c23446tm = (C23446tm) linkedList.get(0);
            } else {
                c23446tm = (C23446tm) linkedList.get(0);
                c23446tm2 = (C23446tm) linkedList.get(1);
            }
            if (c23446tm != null) {
                this.ksr.setVisibility(0);
                this.kss.setText(c23446tm.title);
                this.kst.setText(c23446tm.kbW);
                if (!TextUtils.isEmpty(c23446tm.vUX)) {
                    this.kss.setTextColor(C38736l.m65701Hn(c23446tm.vUX));
                }
                if (!TextUtils.isEmpty(c23446tm.vUY)) {
                    this.kst.setTextColor(C38736l.m65701Hn(c23446tm.vUY));
                }
            }
            if (c23446tm2 != null) {
                this.ksu.setVisibility(0);
                this.ksv.setText(c23446tm2.title);
                this.ksw.setText(c23446tm2.kbW);
                if (!TextUtils.isEmpty(c23446tm2.vUX)) {
                    this.ksv.setTextColor(C38736l.m65701Hn(c23446tm2.vUX));
                }
                if (!TextUtils.isEmpty(c23446tm2.vUY)) {
                    this.ksw.setTextColor(C38736l.m65701Hn(c23446tm2.vUY));
                }
            }
        }
        if (this.kaS.aZB() && !this.kaS.aZH()) {
            C4990ab.m7416i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        } else if (this.kaS.aZW().vSc == null || this.kaS.aZW().vSc.size() <= 0) {
            if (this.ksx != null) {
                this.ksx.setVisibility(8);
            }
            this.ksf.findViewById(2131822200).setVisibility(8);
        } else {
            if (this.ksx == null) {
                this.ksx = ((ViewStub) this.ksf.findViewById(2131822199)).inflate();
            }
            this.ksf.findViewById(2131822200).setVisibility(8);
            View view = this.ksx;
            C42837b c42837b = this.kaS;
            OnClickListener onClickListener = this.gKK;
            LinkedList linkedList2 = c42837b.aZW().vSc;
            if (linkedList2.size() == 1) {
                view.findViewById(2131822282).setVisibility(0);
                c23446tm = (C23446tm) linkedList2.get(0);
                ((TextView) view.findViewById(2131822283)).setText(c23446tm.title);
                ((TextView) view.findViewById(2131822284)).setText(c23446tm.kbW);
                view.findViewById(2131822282).setOnClickListener(onClickListener);
                if (!TextUtils.isEmpty(c23446tm.vUX)) {
                    ((TextView) view.findViewById(2131822283)).setTextColor(C38736l.m65701Hn(c23446tm.vUX));
                }
                if (!TextUtils.isEmpty(c23446tm.vUY)) {
                    ((TextView) view.findViewById(2131822284)).setTextColor(C38736l.m65701Hn(c23446tm.vUY));
                }
                view.findViewById(2131822285).setVisibility(8);
            } else if (linkedList2.size() >= 2) {
                c23446tm = (C23446tm) linkedList2.get(0);
                ((TextView) view.findViewById(2131822283)).setText(c23446tm.title);
                ((TextView) view.findViewById(2131822284)).setText(c23446tm.kbW);
                if (!TextUtils.isEmpty(c23446tm.vUX)) {
                    ((TextView) view.findViewById(2131822283)).setTextColor(C38736l.m65701Hn(c23446tm.vUX));
                }
                if (!TextUtils.isEmpty(c23446tm.vUY)) {
                    ((TextView) view.findViewById(2131822284)).setTextColor(C38736l.m65701Hn(c23446tm.vUY));
                }
                c23446tm = (C23446tm) linkedList2.get(1);
                ((TextView) view.findViewById(2131822286)).setText(c23446tm.title);
                ((TextView) view.findViewById(2131822287)).setText(c23446tm.kbW);
                if (!TextUtils.isEmpty(c23446tm.vUX)) {
                    ((TextView) view.findViewById(2131822286)).setTextColor(C38736l.m65701Hn(c23446tm.vUX));
                }
                if (!TextUtils.isEmpty(c23446tm.vUY)) {
                    ((TextView) view.findViewById(2131822287)).setTextColor(C38736l.m65701Hn(c23446tm.vUY));
                }
                view.findViewById(2131822282).setOnClickListener(onClickListener);
                view.findViewById(2131822285).setOnClickListener(onClickListener);
            }
        }
        if (this.kaS.isNormal()) {
            this.ksy.setVisibility(8);
        } else {
            this.ksy.setVisibility(0);
            TextView textView = (TextView) this.ksy.findViewById(2131822320);
            if (TextUtils.isEmpty(this.kaS.aZV().vUu)) {
                C45778m.m84646c(textView, this.kaS.aZW().status);
            } else {
                textView.setText(this.kaS.aZV().vUu);
            }
        }
        if (this.kaS.aZW().vSl == null && this.kaS.isNormal()) {
            this.ksz.setVisibility(0);
            AppMethodBeat.m2505o(88977);
            return;
        }
        this.ksz.setVisibility(8);
        AppMethodBeat.m2505o(88977);
    }
}
