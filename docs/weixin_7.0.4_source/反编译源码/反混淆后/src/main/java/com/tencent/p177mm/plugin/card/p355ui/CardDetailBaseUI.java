package com.tencent.p177mm.plugin.card.p355ui;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.statusbar.C5540a;

/* renamed from: com.tencent.mm.plugin.card.ui.CardDetailBaseUI */
public abstract class CardDetailBaseUI extends MMActivity {
    private TextView iDT;
    private View iJO;
    private ImageView kiE;
    private TextView kiF;
    ImageView kiG;
    private View kiH;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iJO = C5616v.m8409hu(this.mController.ylL).inflate(2130968911, null);
        this.iJO.setBackgroundColor(getResources().getColor(C25738R.color.f11695dt));
        this.iDT = (TextView) this.iJO.findViewById(2131820965);
        this.kiF = (TextView) this.iJO.findViewById(2131820966);
        this.kiE = (ImageView) this.iJO.findViewById(2131820964);
        this.kiG = (ImageView) this.iJO.findViewById(2131822006);
        this.kiH = this.iJO.findViewById(2131821128);
        if (this.mController.contentView != null && ((ViewGroup) this.mController.contentView).getChildCount() > 0) {
            int dimensionPixelSize;
            View childAt = ((ViewGroup) this.mController.contentView).getChildAt(0);
            ((ViewGroup) this.mController.contentView).removeView(childAt);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
            }
            linearLayout.addView(this.iJO, new LinearLayout.LayoutParams(-1, dimensionPixelSize));
            linearLayout.addView(childAt);
            ((ViewGroup) this.mController.contentView).addView(linearLayout);
        }
    }

    public final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    public final void setBackBtn(final OnMenuItemClickListener onMenuItemClickListener) {
        this.kiE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(88255);
                if (onMenuItemClickListener != null) {
                    onMenuItemClickListener.onMenuItemClick(null);
                }
                AppMethodBeat.m2505o(88255);
            }
        });
    }

    public final void setMMTitle(String str) {
        this.iDT.setText(str);
    }

    /* renamed from: ta */
    public final void mo17443ta(int i) {
        this.iDT.setTextColor(i);
    }

    public final void setMMSubTitle(String str) {
        this.kiF.setText(str);
    }

    /* renamed from: O */
    public final void mo45443O(int i, boolean z) {
        this.iJO.setBackgroundColor(i);
        if (z) {
            this.iDT.setTextColor(getResources().getColor(C25738R.color.f11782h4));
            this.kiF.setTextColor(getResources().getColor(C25738R.color.f11782h4));
            this.kiE.setImageResource(C1318a.actionbar_icon_dark_back);
            this.kiG.setImageResource(C25738R.drawable.f6524h1);
            this.kiH.setBackgroundColor(getResources().getColor(C25738R.color.f11701dz));
        } else {
            this.iDT.setTextColor(getResources().getColor(C25738R.color.a69));
            this.kiF.setTextColor(getResources().getColor(C25738R.color.a69));
            this.kiE.setImageResource(C1318a.actionbar_icon_dark_back);
            this.kiG.setImageResource(C25738R.drawable.f6899uu);
            this.kiH.setBackgroundColor(getResources().getColor(C25738R.color.f12085rt));
        }
        C5540a.m8360d(this.mController.contentView, i, z);
    }

    /* renamed from: fH */
    public final void mo45444fH(boolean z) {
        this.kiG.setVisibility(z ? 0 : 8);
    }

    public final boolean noActionBar() {
        return false;
    }
}
