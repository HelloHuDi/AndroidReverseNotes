package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView extends LinearLayout {
    private ArrayList<View> asv;
    private Context mContext;
    private MMAutoHeightViewPager tTj;
    private MMPageControlView tTk;
    private a tTl;
    private d[] tTm;

    class a extends p {
        private a() {
        }

        /* synthetic */ a(WalletPayUOpenIntroView walletPayUOpenIntroView, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(48390);
            if (WalletPayUOpenIntroView.this.tTm == null) {
                AppMethodBeat.o(48390);
                return 0;
            }
            int length = WalletPayUOpenIntroView.this.tTm.length;
            AppMethodBeat.o(48390);
            return length;
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(48391);
            View view = (View) WalletPayUOpenIntroView.this.asv.get(i);
            viewGroup.addView(view);
            d dVar = WalletPayUOpenIntroView.this.tTm[i];
            TextView textView = (TextView) view.findViewById(R.id.cni);
            TextView textView2 = (TextView) view.findViewById(R.id.dmh);
            ((ImageView) view.findViewById(R.id.ahm)).setImageResource(dVar.tTh);
            textView.setText(dVar.titleRes);
            textView2.setText(dVar.tTi);
            AppMethodBeat.o(48391);
            return view;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.i(48392);
            viewGroup.removeView((View) WalletPayUOpenIntroView.this.asv.get(i));
            AppMethodBeat.o(48392);
        }
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(48393);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.aka, this, true);
        this.tTj = (MMAutoHeightViewPager) inflate.findViewById(R.id.bns);
        this.tTk = (MMPageControlView) inflate.findViewById(R.id.dmg);
        this.tTk.setVisibility(0);
        this.tTj.setOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                AppMethodBeat.i(48389);
                if (WalletPayUOpenIntroView.this.tTj.getParent() != null) {
                    WalletPayUOpenIntroView.this.tTj.getParent().requestDisallowInterceptTouchEvent(true);
                }
                WalletPayUOpenIntroView.this.tTk.setPage(i);
                AppMethodBeat.o(48389);
            }

            public final void onPageScrollStateChanged(int i) {
            }
        });
        AppMethodBeat.o(48393);
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setPagerData(d[] dVarArr) {
        AppMethodBeat.i(48394);
        this.tTm = dVarArr;
        this.asv = new ArrayList();
        if (this.tTm != null) {
            for (int i = 0; i < this.tTm.length; i++) {
                this.asv.add(LayoutInflater.from(this.mContext).inflate(R.layout.akb, null));
            }
        }
        this.tTl = new a(this, (byte) 0);
        this.tTj.setAdapter(this.tTl);
        this.tTk.hj(this.tTm == null ? 0 : this.tTm.length, 0);
        AppMethodBeat.o(48394);
    }
}
