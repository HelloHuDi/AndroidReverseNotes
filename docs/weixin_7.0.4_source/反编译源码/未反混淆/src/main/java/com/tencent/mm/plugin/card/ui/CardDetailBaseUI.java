package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.v;

public abstract class CardDetailBaseUI extends MMActivity {
    private TextView iDT;
    private View iJO;
    private ImageView kiE;
    private TextView kiF;
    ImageView kiG;
    private View kiH;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iJO = v.hu(this.mController.ylL).inflate(R.layout.ic, null);
        this.iJO.setBackgroundColor(getResources().getColor(R.color.dt));
        this.iDT = (TextView) this.iJO.findViewById(R.id.ko);
        this.kiF = (TextView) this.iJO.findViewById(R.id.kp);
        this.kiE = (ImageView) this.iJO.findViewById(R.id.kn);
        this.kiG = (ImageView) this.iJO.findViewById(R.id.abh);
        this.kiH = this.iJO.findViewById(R.id.p3);
        if (this.mController.contentView != null && ((ViewGroup) this.mController.contentView).getChildCount() > 0) {
            int dimensionPixelSize;
            View childAt = ((ViewGroup) this.mController.contentView).getChildAt(0);
            ((ViewGroup) this.mController.contentView).removeView(childAt);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fc);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fd);
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
                AppMethodBeat.i(88255);
                if (onMenuItemClickListener != null) {
                    onMenuItemClickListener.onMenuItemClick(null);
                }
                AppMethodBeat.o(88255);
            }
        });
    }

    public final void setMMTitle(String str) {
        this.iDT.setText(str);
    }

    public final void ta(int i) {
        this.iDT.setTextColor(i);
    }

    public final void setMMSubTitle(String str) {
        this.kiF.setText(str);
    }

    public final void O(int i, boolean z) {
        this.iJO.setBackgroundColor(i);
        if (z) {
            this.iDT.setTextColor(getResources().getColor(R.color.h4));
            this.kiF.setTextColor(getResources().getColor(R.color.h4));
            this.kiE.setImageResource(R.raw.actionbar_icon_dark_back);
            this.kiG.setImageResource(R.drawable.h1);
            this.kiH.setBackgroundColor(getResources().getColor(R.color.dz));
        } else {
            this.iDT.setTextColor(getResources().getColor(R.color.a69));
            this.kiF.setTextColor(getResources().getColor(R.color.a69));
            this.kiE.setImageResource(R.raw.actionbar_icon_dark_back);
            this.kiG.setImageResource(R.drawable.uu);
            this.kiH.setBackgroundColor(getResources().getColor(R.color.rt));
        }
        a.d(this.mController.contentView, i, z);
    }

    public final void fH(boolean z) {
        this.kiG.setVisibility(z ? 0 : 8);
    }

    public final boolean noActionBar() {
        return false;
    }
}
