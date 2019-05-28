package com.tencent.p177mm.pluginsdk.p597ui.preference;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference */
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

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference$1 */
    class C149501 implements OnClickListener {
        C149501() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(28015);
            C25985d.m41467b(AccountInfoPreference.this.mContext, "setting", ".ui.setting.SettingsPersonalInfoUI", new Intent());
            AppMethodBeat.m2505o(28015);
        }
    }

    public AccountInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(28016);
        this.pls = false;
        this.vqa = true;
        this.vqc = null;
        this.vqd = null;
        this.vqe = null;
        this.vqf = null;
        this.vqg = new C149501();
        AppMethodBeat.m2505o(28016);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(28017);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131821183);
        if (!(this.userName == null || imageView == null || !C1720g.m3531RK())) {
            C40460b.m69434b(imageView, this.userName);
        }
        imageView.setOnClickListener(this.vqg);
        this.vqc = (NoMeasuredTextView) view.findViewById(2131821809);
        if (!(this.userName == null || this.vqc == null)) {
            this.vqc.setShouldEllipsize(true);
            this.vqc.setTextSize(0, (float) C1338a.m2856al(this.mContext, C25738R.dimen.f9937ks));
            if (this.pls) {
                this.vqc.setTextColor(C1338a.m2870h(this.mContext, (int) C25738R.color.a6a));
            } else {
                this.vqc.setTextColor(C1338a.m2870h(this.mContext, (int) C25738R.color.f12212w4));
            }
            this.vqc.setText(this.vpW == null ? this.userName : this.vpW);
            if (this.vqc.getPaint() != null) {
                this.vqc.getPaint().setFakeBoldText(true);
            }
        }
        TextView textView = (TextView) view.findViewById(2131826146);
        if (this.vpX != null && textView != null) {
            textView.setText(view.getResources().getString(C25738R.string.f8813fr, new Object[]{this.vpX}));
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        textView.setOnClickListener(this.vqg);
        textView = (TextView) view.findViewById(2131822353);
        if (textView != null) {
            if (this.vqb > 99) {
                textView.setText(this.mContext.getString(C25738R.string.eu9));
                textView.setBackgroundResource(C44385r.m80243ik(this.mContext));
                textView.setVisibility(0);
            } else if (this.vqb > 0) {
                textView.setText(this.vqb);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        this.vpY = (RelativeLayout) view.findViewById(2131826149);
        this.vpY.setOnClickListener(this.vqg);
        this.vpZ = view.findViewById(2131823007);
        if (this.vpZ != null) {
            int am;
            if (this.pls || !this.vqa) {
                am = C1338a.m2857am(this.mContext, C25738R.dimen.a7h);
            } else {
                am = C1338a.m2857am(this.mContext, C25738R.dimen.a7i);
            }
            this.vpZ.setPadding(this.vpZ.getPaddingLeft(), am, this.vpZ.getPaddingRight(), this.vpZ.getPaddingBottom());
            this.vpZ.setOnClickListener(this.vqe);
        }
        mo27300ad(this.pls, this.vqa);
        AppMethodBeat.m2505o(28017);
    }

    /* renamed from: ad */
    public final void mo27300ad(boolean z, boolean z2) {
        AppMethodBeat.m2504i(28018);
        C4990ab.m7411d("TEST", "updateAccountStoryStatus %s", Boolean.valueOf(z));
        this.pls = z;
        this.vqa = z2;
        if (this.vqc != null) {
            LayoutParams layoutParams;
            if (z) {
                this.vqc.setTextColor(C1338a.m2870h(this.mContext, (int) C25738R.color.a6a));
                layoutParams = (LayoutParams) this.vpY.getLayoutParams();
                layoutParams.gravity = 8388693;
                this.vpY.setLayoutParams(layoutParams);
                this.vpY.setGravity(16);
            } else {
                this.vqc.setTextColor(C1338a.m2870h(this.mContext, (int) C25738R.color.f12212w4));
                layoutParams = (LayoutParams) this.vpY.getLayoutParams();
                layoutParams.gravity = 8388693;
                this.vpY.setGravity(16);
                this.vpY.setLayoutParams(layoutParams);
            }
        }
        if (this.vpZ != null) {
            int am;
            if (z || !z2) {
                am = C1338a.m2857am(this.mContext, C25738R.dimen.a7h);
            } else {
                am = C1338a.m2857am(this.mContext, C25738R.dimen.a7i);
            }
            this.vpZ.setPadding(this.vpZ.getPaddingLeft(), am, this.vpZ.getPaddingRight(), this.vpZ.getPaddingBottom());
        }
        AppMethodBeat.m2505o(28018);
    }
}
