package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.scanner.util.C43498q;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.scanner.ui.d */
public final class C46918d extends Preference implements C18765a {
    private C15541f ehK;
    private TextView iDT = null;
    private ImageView kEn = null;
    String kux;
    private View mView = null;
    String mXp;
    private TextView qcc = null;
    String qcd;

    public C46918d(Context context) {
        super(context);
        AppMethodBeat.m2504i(81006);
        setLayoutResource(2130970379);
        C18764x.m29326a((C18765a) this);
        AppMethodBeat.m2505o(81006);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(81007);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(81007);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(81008);
        super.onBindView(view);
        this.kEn = (ImageView) view.findViewById(2131826572);
        this.iDT = (TextView) view.findViewById(2131826573);
        this.qcc = (TextView) view.findViewById(2131826574);
        if (C5046bo.isNullOrNil(this.qcd)) {
            this.kEn.setVisibility(8);
        } else {
            Bitmap a = C18764x.m29325a(new C43498q(this.qcd));
            if (a == null || a.isRecycled()) {
                try {
                    this.kEn.setImageBitmap(C4977b.m7372b(C4996ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null)));
                } catch (IOException e) {
                    this.kEn.setImageBitmap(null);
                }
            } else {
                this.kEn.setImageBitmap(a);
                this.kEn.setBackgroundColor(0);
            }
        }
        if (C5046bo.isNullOrNil(this.kux)) {
            this.iDT.setVisibility(8);
        } else {
            this.iDT.setText(C44089j.m79293b(this.mContext, this.kux, this.iDT.getTextSize()));
        }
        if (C5046bo.isNullOrNil(this.mXp)) {
            this.qcc.setVisibility(8);
        } else {
            this.qcc.setText(this.mXp);
        }
        if (C5046bo.isNullOrNil(this.kux) && C5046bo.isNullOrNil(this.qcd)) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(2131826571);
            LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.a7b);
            linearLayout.setPadding(C4977b.m7371b(this.mContext, 9.0f), 0, 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(81008);
    }

    /* renamed from: m */
    public final void mo8136m(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(81009);
        if (!(C5046bo.isNullOrNil(str) || !str.equals(this.qcd) || bitmap == null || bitmap.isRecycled())) {
            this.kEn.setImageBitmap(bitmap);
            this.kEn.setBackgroundColor(0);
            if (this.ehK != null) {
                this.ehK.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(81009);
    }
}
