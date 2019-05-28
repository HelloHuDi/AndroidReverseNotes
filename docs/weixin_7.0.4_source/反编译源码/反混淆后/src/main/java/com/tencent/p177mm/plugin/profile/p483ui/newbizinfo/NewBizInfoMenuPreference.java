package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C12866c;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C39530e;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C46140d;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c.C34738b;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c.C34739c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference */
public class NewBizInfoMenuPreference extends Preference {
    private MMActivity crP;
    private C7616ad ehM;
    private int lineHeight = 0;
    private boolean lyb = false;
    private C46140d ppN;
    private LinearLayout pqa;
    private List<C39530e> pqb;
    private int state = 0;

    public NewBizInfoMenuPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23873);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23873);
    }

    public NewBizInfoMenuPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23874);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23874);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23875);
        super.onBindView(view);
        this.pqa = (LinearLayout) view.findViewById(2131822972);
        this.lyb = true;
        initView();
        AppMethodBeat.m2505o(23875);
    }

    private void initView() {
        AppMethodBeat.m2504i(23876);
        if (!this.lyb) {
            AppMethodBeat.m2505o(23876);
        } else if (this.state == 1 || this.state == 2 || this.state != 3) {
            this.pqa.setVisibility(8);
            AppMethodBeat.m2505o(23876);
        } else {
            this.pqa.setVisibility(0);
            bKH();
            AppMethodBeat.m2505o(23876);
        }
    }

    private void bKH() {
        AppMethodBeat.m2504i(23877);
        this.pqa.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pqb.size()) {
                final C39530e c39530e = (C39530e) this.pqb.get(i2);
                View a = m77431a(c39530e);
                a.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(23870);
                        if (c39530e == null) {
                            C4990ab.m7420w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
                            AppMethodBeat.m2505o(23870);
                            return;
                        }
                        C34739c.m57055cP(NewBizInfoMenuPreference.this.ehM.field_username, FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA);
                        C4990ab.m7417i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", Integer.valueOf(c39530e.type));
                        switch (c39530e.type) {
                            case 0:
                                NewBizInfoMenuPreference.m77433a(NewBizInfoMenuPreference.this, c39530e);
                                AppMethodBeat.m2505o(23870);
                                return;
                            case 2:
                                C12866c.m20859a(c39530e, NewBizInfoMenuPreference.this.crP, NewBizInfoMenuPreference.this.ehM.field_username);
                                C34738b.m57053b(NewBizInfoMenuPreference.this.ehM.field_username, c39530e.f16178id, c39530e.key, C34738b.pqI, c39530e.name, C34738b.m57054fa(NewBizInfoMenuPreference.this.pqb.indexOf(c39530e), -1), c39530e.cRS);
                                AppMethodBeat.m2505o(23870);
                                return;
                            case 5:
                                C12866c.m20861b(c39530e, NewBizInfoMenuPreference.this.crP, NewBizInfoMenuPreference.this.ehM.field_username);
                                C34738b.m57053b(NewBizInfoMenuPreference.this.ehM.field_username, c39530e.f16178id, c39530e.key, C34738b.pqI, c39530e.name, C34738b.m57054fa(NewBizInfoMenuPreference.this.pqb.indexOf(c39530e), -1), c39530e.value);
                                break;
                        }
                        AppMethodBeat.m2505o(23870);
                    }
                });
                this.pqa.addView(a);
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -1;
                layoutParams.weight = 1.0f;
                layoutParams.gravity = 16;
                a.setLayoutParams(layoutParams);
                if (i2 != this.pqb.size() - 1) {
                    ImageView imageView = new ImageView(this.crP);
                    imageView.setBackgroundColor(this.crP.getResources().getColor(C25738R.color.f12122t6));
                    this.pqa.addView(imageView);
                    layoutParams = (LayoutParams) imageView.getLayoutParams();
                    layoutParams.height = this.lineHeight;
                    layoutParams.width = C1338a.fromDPToPix(this.crP, 1);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(23877);
                return;
            }
        }
    }

    /* renamed from: a */
    private View m77431a(C39530e c39530e) {
        AppMethodBeat.m2504i(23878);
        View inflate = View.inflate(this.crP, 2130969200, null);
        TextView textView = (TextView) inflate.findViewById(2131822970);
        ImageView imageView = (ImageView) inflate.findViewById(2131822971);
        this.lineHeight = (int) textView.getTextSize();
        NewBizInfoMenuPreference.m77430X(imageView, (((int) textView.getTextSize()) * 3) / 4);
        switch (c39530e.type) {
            case 0:
                imageView.setVisibility(0);
                imageView.setImageResource(C25738R.drawable.axi);
                break;
            case 2:
                imageView.setVisibility(8);
                break;
            case 5:
                imageView.setVisibility(0);
                imageView.setImageResource(C25738R.drawable.axh);
                break;
        }
        textView.setText(C44089j.m79292b(this.crP, c39530e.name));
        AppMethodBeat.m2505o(23878);
        return inflate;
    }

    /* renamed from: X */
    private static void m77430X(View view, int i) {
        AppMethodBeat.m2504i(23879);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(23879);
    }

    /* renamed from: a */
    public final void mo68938a(C46140d c46140d, C7616ad c7616ad) {
        AppMethodBeat.m2504i(23880);
        if (c46140d == null) {
            AppMethodBeat.m2505o(23880);
            return;
        }
        this.ehM = c7616ad;
        this.ppN = c46140d;
        this.pqb = C12866c.m20862cD(c46140d.cbM());
        cbv();
        initView();
        AppMethodBeat.m2505o(23880);
    }

    private void cbv() {
        AppMethodBeat.m2504i(23881);
        if (this.ppN == null || this.ppN.isNormal()) {
            if (this.ppN == null || !this.ppN.cbR()) {
                this.state = 0;
            } else if (this.ppN != null && this.pqb != null && this.pqb.size() <= 0) {
                this.state = 2;
                AppMethodBeat.m2505o(23881);
                return;
            } else if (!(this.ppN == null || this.pqb == null || this.ppN.cbM().size() <= 0)) {
                this.state = 3;
                AppMethodBeat.m2505o(23881);
                return;
            }
            AppMethodBeat.m2505o(23881);
            return;
        }
        this.state = 4;
        AppMethodBeat.m2505o(23881);
    }
}
