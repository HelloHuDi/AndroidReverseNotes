package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.collect.model.C38804e;
import com.tencent.p177mm.plugin.collect.model.C38805h;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.collect.ui.b */
public final class C33883b extends BaseAdapter {
    List<C38805h> kFl = new ArrayList();
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.collect.ui.b$a */
    static class C33884a {
        TextView kEq;
        WalletTextView kFm;
        TextView kFn;
        TextView kvI;

        public C33884a(View view) {
            AppMethodBeat.m2504i(41178);
            this.kvI = (TextView) view.findViewById(2131822836);
            this.kFn = (TextView) view.findViewById(2131822837);
            this.kFm = (WalletTextView) view.findViewById(2131822838);
            this.kEq = (TextView) view.findViewById(2131822839);
            AppMethodBeat.m2505o(41178);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(41185);
        C38805h tI = mo54435tI(i);
        AppMethodBeat.m2505o(41185);
        return tI;
    }

    public C33883b(Context context) {
        AppMethodBeat.m2504i(41179);
        this.mContext = context;
        AppMethodBeat.m2505o(41179);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(41180);
        int size = this.kFl.size();
        AppMethodBeat.m2505o(41180);
        return size;
    }

    /* renamed from: tI */
    public final C38805h mo54435tI(int i) {
        AppMethodBeat.m2504i(41181);
        C38805h c38805h = (C38805h) this.kFl.get(i);
        AppMethodBeat.m2505o(41181);
        return c38805h;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(41182);
        if (view == null) {
            view = C5616v.m8409hu(this.mContext).inflate(2130969155, viewGroup, false);
            view.setTag(new C33884a(view));
        }
        C33884a c33884a = (C33884a) view.getTag();
        C38805h tI = mo54435tI(i);
        c33884a.kvI.setText(C38804e.m65843a(this.mContext, tI.kCc, tI.type));
        c33884a.kFm.setText(C38804e.m65844tG(tI.kCe));
        c33884a.kEq.setText(this.mContext.getString(C25738R.string.arm, new Object[]{Integer.valueOf(tI.kCd)}));
        AppMethodBeat.m2505o(41182);
        return view;
    }

    public final void setData(List<C38805h> list) {
        AppMethodBeat.m2504i(41183);
        this.kFl.clear();
        this.kFl.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(41183);
    }

    /* renamed from: bp */
    public final void mo54429bp(List<C38805h> list) {
        AppMethodBeat.m2504i(41184);
        this.kFl.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(41184);
    }
}
