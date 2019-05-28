package com.tencent.p177mm.plugin.wallet_payu.create.p569ui;

import android.content.Context;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMAutoHeightViewPager;
import com.tencent.p177mm.p612ui.base.MMPageControlView;
import com.tencent.p177mm.plugin.wallet_payu.create.p1317a.C40158d;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView */
public class WalletPayUOpenIntroView extends LinearLayout {
    private ArrayList<View> asv;
    private Context mContext;
    private MMAutoHeightViewPager tTj;
    private MMPageControlView tTk;
    private C4496a tTl;
    private C40158d[] tTm;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView$1 */
    class C44951 implements OnPageChangeListener {
        C44951() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.m2504i(48389);
            if (WalletPayUOpenIntroView.this.tTj.getParent() != null) {
                WalletPayUOpenIntroView.this.tTj.getParent().requestDisallowInterceptTouchEvent(true);
            }
            WalletPayUOpenIntroView.this.tTk.setPage(i);
            AppMethodBeat.m2505o(48389);
        }

        public final void onPageScrollStateChanged(int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView$a */
    class C4496a extends C25365p {
        private C4496a() {
        }

        /* synthetic */ C4496a(WalletPayUOpenIntroView walletPayUOpenIntroView, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(48390);
            if (WalletPayUOpenIntroView.this.tTm == null) {
                AppMethodBeat.m2505o(48390);
                return 0;
            }
            int length = WalletPayUOpenIntroView.this.tTm.length;
            AppMethodBeat.m2505o(48390);
            return length;
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(48391);
            View view = (View) WalletPayUOpenIntroView.this.asv.get(i);
            viewGroup.addView(view);
            C40158d c40158d = WalletPayUOpenIntroView.this.tTm[i];
            TextView textView = (TextView) view.findViewById(2131825188);
            TextView textView2 = (TextView) view.findViewById(2131826518);
            ((ImageView) view.findViewById(2131822233)).setImageResource(c40158d.tTh);
            textView.setText(c40158d.titleRes);
            textView2.setText(c40158d.tTi);
            AppMethodBeat.m2505o(48391);
            return view;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(48392);
            viewGroup.removeView((View) WalletPayUOpenIntroView.this.asv.get(i));
            AppMethodBeat.m2505o(48392);
        }
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(48393);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(2130970357, this, true);
        this.tTj = (MMAutoHeightViewPager) inflate.findViewById(2131823829);
        this.tTk = (MMPageControlView) inflate.findViewById(2131826517);
        this.tTk.setVisibility(0);
        this.tTj.setOnPageChangeListener(new C44951());
        AppMethodBeat.m2505o(48393);
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setPagerData(C40158d[] c40158dArr) {
        AppMethodBeat.m2504i(48394);
        this.tTm = c40158dArr;
        this.asv = new ArrayList();
        if (this.tTm != null) {
            for (int i = 0; i < this.tTm.length; i++) {
                this.asv.add(LayoutInflater.from(this.mContext).inflate(2130970358, null));
            }
        }
        this.tTl = new C4496a(this, (byte) 0);
        this.tTj.setAdapter(this.tTl);
        this.tTk.mo69952hj(this.tTm == null ? 0 : this.tTm.length, 0);
        AppMethodBeat.m2505o(48394);
    }
}
