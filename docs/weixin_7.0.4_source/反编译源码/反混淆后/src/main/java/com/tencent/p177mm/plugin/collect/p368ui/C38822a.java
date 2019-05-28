package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.collect.model.C20263a;
import com.tencent.p177mm.plugin.collect.model.C38804e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.collect.ui.a */
public final class C38822a extends BaseAdapter {
    List<C20263a> kFl = new ArrayList();
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.collect.ui.a$a */
    static class C38823a {
        TextView kEq;
        WalletTextView kFm;
        TextView kvI;

        public C38823a(View view) {
            AppMethodBeat.m2504i(41168);
            this.kvI = (TextView) view.findViewById(2131822829);
            this.kFm = (WalletTextView) view.findViewById(2131822830);
            this.kEq = (TextView) view.findViewById(2131822831);
            AppMethodBeat.m2505o(41168);
        }
    }

    public C38822a(Context context) {
        AppMethodBeat.m2504i(41169);
        this.mContext = context;
        AppMethodBeat.m2505o(41169);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(41170);
        int size = this.kFl.size();
        AppMethodBeat.m2505o(41170);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(41171);
        Object obj = this.kFl.get(i);
        AppMethodBeat.m2505o(41171);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(41172);
        if (view == null) {
            view = C5616v.m8409hu(this.mContext).inflate(2130969153, viewGroup, false);
            view.setTag(new C38823a(view));
        }
        C20263a c20263a = (C20263a) this.kFl.get(i);
        C38823a c38823a = (C38823a) view.getTag();
        c38823a.kvI.setText(new SimpleDateFormat(this.mContext.getString(C25738R.string.ara)).format(new Date(c20263a.timestamp * 1000)));
        c38823a.kFm.setText(C38804e.m65844tG(c20263a.cuY));
        if (C5046bo.isNullOrNil(c20263a.desc)) {
            c38823a.kEq.setVisibility(8);
        } else {
            c38823a.kEq.setText(c20263a.desc);
            c38823a.kEq.setVisibility(0);
        }
        AppMethodBeat.m2505o(41172);
        return view;
    }
}
