package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class w extends i {
    private View krg;
    private View krh;

    public final void initView() {
    }

    public final void bes() {
        AppMethodBeat.i(88783);
        if (this.krg != null) {
            this.krg.setVisibility(8);
        }
        if (this.krh != null) {
            this.krh.setVisibility(8);
        }
        AppMethodBeat.o(88783);
    }

    public final void update() {
        AppMethodBeat.i(88782);
        b bcv = this.kqK.bcv();
        g bcA = this.kqK.bcA();
        tm tmVar;
        if (bcv.aZW().vSc != null && bcv.aZW().vSc.size() > 1) {
            if (this.krg == null) {
                this.krg = ((ViewStub) findViewById(R.id.ac2)).inflate();
            }
            if (this.krh != null) {
                this.krh.setVisibility(8);
            }
            MMActivity bcy = this.kqK.bcy();
            View view = this.krg;
            OnClickListener bcz = this.kqK.bcz();
            LinkedList linkedList = bcv.aZW().vSc;
            int Hn = l.Hn(bcv.aZV().color);
            ((ViewGroup) view).removeAllViews();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                tmVar = (tm) it.next();
                View inflate = v.hu(bcy).inflate(R.layout.jw, (ViewGroup) view, false);
                inflate.setId(R.id.aiv);
                inflate.setTag(Integer.valueOf(linkedList.indexOf(tmVar)));
                inflate.setOnClickListener(bcz);
                if (TextUtils.isEmpty(tmVar.url)) {
                    inflate.setEnabled(false);
                }
                ((TextView) inflate.findViewById(R.id.aiw)).setText(tmVar.title);
                TextView textView = (TextView) inflate.findViewById(R.id.aix);
                textView.setText(tmVar.kbW);
                textView.setTextColor(Hn);
                ((ViewGroup) view).addView(inflate);
                if ((linkedList.indexOf(tmVar) + 1 != linkedList.size() ? 1 : null) != null) {
                    ((ViewGroup) view).addView(v.hu(bcy).inflate(R.layout.jx, (ViewGroup) view, false));
                }
            }
            if (!(!bcv.aZD() || bcv.aZW().vSj == null || TextUtils.isEmpty(bcv.aZW().vSj.title))) {
                this.krg.setBackgroundResource(R.drawable.uv);
            }
            if (!bcv.aZD() && bcA.bdS()) {
                this.krg.setBackgroundResource(R.drawable.uv);
                AppMethodBeat.o(88782);
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
                this.krh = ((ViewStub) findViewById(R.id.ac3)).inflate();
            }
            if (this.krg != null) {
                this.krg.setVisibility(8);
            }
            View view2 = this.krh;
            OnClickListener bcz2 = this.kqK.bcz();
            LinkedList linkedList2 = bcv.aZW().vSc;
            if (linkedList2.size() == 1) {
                view2.findViewById(R.id.aiy).setVisibility(0);
                tmVar = (tm) linkedList2.get(0);
                ((TextView) view2.findViewById(R.id.aiz)).setText(tmVar.title);
                ((TextView) view2.findViewById(R.id.aj0)).setText(tmVar.kbW);
                ((TextView) view2.findViewById(R.id.aj0)).setTextColor(l.Hn(bcv.aZV().color));
                view2.findViewById(R.id.aiy).setOnClickListener(bcz2);
                if (TextUtils.isEmpty(tmVar.url)) {
                    view2.findViewById(R.id.aiy).setEnabled(false);
                }
            }
            if (!(!bcv.aZD() || bcv.aZW().vSj == null || TextUtils.isEmpty(bcv.aZW().vSj.title))) {
                this.krh.setBackgroundResource(R.drawable.uv);
            }
            if (!bcv.aZD() && bcA.bdS()) {
                this.krh.setBackgroundResource(R.drawable.uv);
                AppMethodBeat.o(88782);
                return;
            }
        }
        AppMethodBeat.o(88782);
    }
}
