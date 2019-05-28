package com.tencent.p177mm.plugin.card.p355ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C42867g;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.ui.view.w */
public final class C20200w extends C45800i {
    private View krg;
    private View krh;

    public final void initView() {
    }

    public final void bes() {
        AppMethodBeat.m2504i(88783);
        if (this.krg != null) {
            this.krg.setVisibility(8);
        }
        if (this.krh != null) {
            this.krh.setVisibility(8);
        }
        AppMethodBeat.m2505o(88783);
    }

    public final void update() {
        AppMethodBeat.m2504i(88782);
        C42837b bcv = this.kqK.bcv();
        C42867g bcA = this.kqK.bcA();
        C23446tm c23446tm;
        if (bcv.aZW().vSc != null && bcv.aZW().vSc.size() > 1) {
            if (this.krg == null) {
                this.krg = ((ViewStub) findViewById(2131822027)).inflate();
            }
            if (this.krh != null) {
                this.krh.setVisibility(8);
            }
            MMActivity bcy = this.kqK.bcy();
            View view = this.krg;
            OnClickListener bcz = this.kqK.bcz();
            LinkedList linkedList = bcv.aZW().vSc;
            int Hn = C38736l.m65701Hn(bcv.aZV().color);
            ((ViewGroup) view).removeAllViews();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                c23446tm = (C23446tm) it.next();
                View inflate = C5616v.m8409hu(bcy).inflate(2130968968, (ViewGroup) view, false);
                inflate.setId(2131822279);
                inflate.setTag(Integer.valueOf(linkedList.indexOf(c23446tm)));
                inflate.setOnClickListener(bcz);
                if (TextUtils.isEmpty(c23446tm.url)) {
                    inflate.setEnabled(false);
                }
                ((TextView) inflate.findViewById(2131822280)).setText(c23446tm.title);
                TextView textView = (TextView) inflate.findViewById(2131822281);
                textView.setText(c23446tm.kbW);
                textView.setTextColor(Hn);
                ((ViewGroup) view).addView(inflate);
                if ((linkedList.indexOf(c23446tm) + 1 != linkedList.size() ? 1 : null) != null) {
                    ((ViewGroup) view).addView(C5616v.m8409hu(bcy).inflate(2130968969, (ViewGroup) view, false));
                }
            }
            if (!(!bcv.aZD() || bcv.aZW().vSj == null || TextUtils.isEmpty(bcv.aZW().vSj.title))) {
                this.krg.setBackgroundResource(C25738R.drawable.f6900uv);
            }
            if (!bcv.aZD() && bcA.bdS()) {
                this.krg.setBackgroundResource(C25738R.drawable.f6900uv);
                AppMethodBeat.m2505o(88782);
                return;
            }
        } else if (bcv.aZW().vSc == null || bcv.aZW().vSc.size() != 1) {
            if (this.krg != null) {
                this.krg.setVisibility(8);
            }
            if (this.krh != null) {
                this.krh.setVisibility(8);
            }
        } else {
            if (this.krh == null) {
                this.krh = ((ViewStub) findViewById(2131822028)).inflate();
            }
            if (this.krg != null) {
                this.krg.setVisibility(8);
            }
            View view2 = this.krh;
            OnClickListener bcz2 = this.kqK.bcz();
            LinkedList linkedList2 = bcv.aZW().vSc;
            if (linkedList2.size() == 1) {
                view2.findViewById(2131822282).setVisibility(0);
                c23446tm = (C23446tm) linkedList2.get(0);
                ((TextView) view2.findViewById(2131822283)).setText(c23446tm.title);
                ((TextView) view2.findViewById(2131822284)).setText(c23446tm.kbW);
                ((TextView) view2.findViewById(2131822284)).setTextColor(C38736l.m65701Hn(bcv.aZV().color));
                view2.findViewById(2131822282).setOnClickListener(bcz2);
                if (TextUtils.isEmpty(c23446tm.url)) {
                    view2.findViewById(2131822282).setEnabled(false);
                }
            }
            if (!(!bcv.aZD() || bcv.aZW().vSj == null || TextUtils.isEmpty(bcv.aZW().vSj.title))) {
                this.krh.setBackgroundResource(C25738R.drawable.f6900uv);
            }
            if (!bcv.aZD() && bcA.bdS()) {
                this.krh.setBackgroundResource(C25738R.drawable.f6900uv);
                AppMethodBeat.m2505o(88782);
                return;
            }
        }
        AppMethodBeat.m2505o(88782);
    }
}
