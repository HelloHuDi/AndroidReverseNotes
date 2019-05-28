package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;

public class AccountInfoPreference extends Preference {
    private boolean pls;
    public String userName;
    public SpannableString vpW;
    public String vpX;
    private RelativeLayout vpY;
    private View vpZ;
    private boolean vqa;
    private int vqb;
    private NoMeasuredTextView vqc;
    public OnClickListener vqd;
    public OnClickListener vqe;
    private OnClickListener vqf;
    private OnClickListener vqg;

    public AccountInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(28016);
        this.pls = false;
        this.vqa = true;
        this.vqc = null;
        this.vqd = null;
        this.vqe = null;
        this.vqf = null;
        this.vqg = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(28015);
                d.b(AccountInfoPreference.this.mContext, "setting", ".ui.setting.SettingsPersonalInfoUI", new Intent());
                AppMethodBeat.o(28015);
            }
        };
        AppMethodBeat.o(28016);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(28017);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.qk);
        if (!(this.userName == null || imageView == null || !g.RK())) {
            b.b(imageView, this.userName);
        }
        imageView.setOnClickListener(this.vqg);
        this.vqc = (NoMeasuredTextView) view.findViewById(R.id.a76);
        if (!(this.userName == null || this.vqc == null)) {
            this.vqc.setShouldEllipsize(true);
            this.vqc.setTextSize(0, (float) a.al(this.mContext, R.dimen.ks));
            if (this.pls) {
                this.vqc.setTextColor(a.h(this.mContext, (int) R.color.a6a));
            } else {
                this.vqc.setTextColor(a.h(this.mContext, (int) R.color.w4));
            }
            this.vqc.setText(this.vpW == null ? this.userName : this.vpW);
            if (this.vqc.getPaint() != null) {
                this.vqc.getPaint().setFakeBoldText(true);
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.dcf);
        if (this.vpX != null && textView != null) {
            textView.setText(view.getResources().getString(R.string.fr, new Object[]{this.vpX}));
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        textView.setOnClickListener(this.vqg);
        textView = (TextView) view.findViewById(R.id.akv);
        if (textView != null) {
            if (this.vqb > 99) {
                textView.setText(this.mContext.getString(R.string.eu9));
                textView.setBackgroundResource(r.ik(this.mContext));
                textView.setVisibility(0);
            } else if (this.vqb > 0) {
                textView.setText(this.vqb);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        this.vpY = (RelativeLayout) view.findViewById(R.id.dci);
        this.vpY.setOnClickListener(this.vqg);
        this.vpZ = view.findViewById(R.id.b2k);
        if (this.vpZ != null) {
            int am;
            if (this.pls || !this.vqa) {
                am = a.am(this.mContext, R.dimen.a7h);
            } else {
                am = a.am(this.mContext, R.dimen.a7i);
            }
            this.vpZ.setPadding(this.vpZ.getPaddingLeft(), am, this.vpZ.getPaddingRight(), this.vpZ.getPaddingBottom());
            this.vpZ.setOnClickListener(this.vqe);
        }
        ad(this.pls, this.vqa);
        AppMethodBeat.o(28017);
    }

    public final void ad(boolean z, boolean z2) {
        AppMethodBeat.i(28018);
        ab.d("TEST", "updateAccountStoryStatus %s", Boolean.valueOf(z));
        this.pls = z;
        this.vqa = z2;
        if (this.vqc != null) {
            LayoutParams layoutParams;
            if (z) {
                this.vqc.setTextColor(a.h(this.mContext, (int) R.color.a6a));
                layoutParams = (LayoutParams) this.vpY.getLayoutParams();
                layoutParams.gravity = 8388693;
                this.vpY.setLayoutParams(layoutParams);
                this.vpY.setGravity(16);
            } else {
                this.vqc.setTextColor(a.h(this.mContext, (int) R.color.w4));
                layoutParams = (LayoutParams) this.vpY.getLayoutParams();
                layoutParams.gravity = 8388693;
                this.vpY.setGravity(16);
                this.vpY.setLayoutParams(layoutParams);
            }
        }
        if (this.vpZ != null) {
            int am;
            if (z || !z2) {
                am = a.am(this.mContext, R.dimen.a7h);
            } else {
                am = a.am(this.mContext, R.dimen.a7i);
            }
            this.vpZ.setPadding(this.vpZ.getPaddingLeft(), am, this.vpZ.getPaddingRight(), this.vpZ.getPaddingBottom());
        }
        AppMethodBeat.o(28018);
    }
}
