package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.order.ui.a.j */
public final class C24802j extends Preference {
    OnClickListener mOnClickListener = null;
    private View mView = null;
    List<HelpCenter> pbM = new LinkedList();
    String peR;
    OnClickListener peS = null;

    public C24802j(Context context) {
        super(context);
        AppMethodBeat.m2504i(43924);
        setLayoutResource(2130970055);
        AppMethodBeat.m2505o(43924);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43925);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(43925);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(43926);
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131825842);
        linearLayout.removeAllViews();
        if (this.pbM == null) {
            AppMethodBeat.m2505o(43926);
            return;
        }
        int size;
        int i;
        if (C5046bo.isNullOrNil(this.peR) || this.peS == null) {
            size = this.pbM.size() - 1;
        } else {
            size = this.pbM.size();
        }
        if (size == 0) {
            i = -1;
        } else {
            i = size;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.pbM.size(); i3++) {
            HelpCenter helpCenter = (HelpCenter) this.pbM.get(i3);
            TextView textView = new TextView(this.mContext);
            textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11782h4));
            textView.setTextSize(0, (float) C1338a.m2856al(this.mContext, C25738R.dimen.f9980m5));
            textView.setIncludeFontPadding(false);
            textView.setText(helpCenter.name);
            textView.setTag(helpCenter);
            textView.setGravity(17);
            textView.setOnClickListener(this.mOnClickListener);
            if (i2 == i) {
                textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12069r8));
            }
            linearLayout.addView(textView, new LayoutParams(0, -2, 1.0f));
            if (i2 < i) {
                View view2 = new View(this.mContext);
                view2.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.a04));
                linearLayout.addView(view2, new LayoutParams(C1338a.m2856al(this.mContext, C25738R.dimen.f9795fv), -1));
            }
            i2++;
        }
        if (!(C5046bo.isNullOrNil(this.peR) || this.peS == null)) {
            TextView textView2 = new TextView(this.mContext);
            textView2.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11782h4));
            textView2.setTextSize(0, (float) C1338a.m2856al(this.mContext, C25738R.dimen.f9980m5));
            textView2.setIncludeFontPadding(false);
            textView2.setText(this.peR);
            textView2.setGravity(17);
            textView2.setOnClickListener(this.peS);
            if (i2 == i) {
                textView2.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12069r8));
            }
            linearLayout.addView(textView2, new LayoutParams(0, -2, 1.0f));
        }
        AppMethodBeat.m2505o(43926);
    }
}
