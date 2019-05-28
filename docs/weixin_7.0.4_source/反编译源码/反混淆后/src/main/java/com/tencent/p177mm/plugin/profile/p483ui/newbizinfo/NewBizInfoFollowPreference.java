package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9430of;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.C43392b.C215013;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c.C34739c;
import com.tencent.p177mm.pluginsdk.C46490h;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.sdk.p600b.C4879a;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference */
public class NewBizInfoFollowPreference extends Preference {
    private MMActivity crP;
    private boolean lyb = false;
    C23233a plh;
    private TextView ppS;
    private TextView ppT;

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference$1 */
    class C128611 implements OnClickListener {
        C128611() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23849);
            if (NewBizInfoFollowPreference.this.plh != null && (NewBizInfoFollowPreference.this.plh instanceof C43392b)) {
                C43392b c43392b = (C43392b) NewBizInfoFollowPreference.this.plh;
                if (c43392b.pmI != null) {
                    C9430of c9430of = new C9430of();
                    c43392b.pmI.fPZ = 5;
                    c9430of.cKy.cKz = c43392b.pmI;
                    C4879a.xxA.mo10055m(c9430of);
                }
                Intent intent = new Intent();
                if (c43392b.ppM.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                    intent.setFlags(268435456);
                }
                intent.putExtra("chat_from_scene", c43392b.ppM.getIntent().getIntExtra("chat_from_scene", 0));
                intent.putExtra("KOpenArticleSceneFromScene", 126);
                intent.putExtra("specific_chat_from_scene", 5);
                if (c43392b.pli) {
                    intent.putExtra("Chat_User", c43392b.ehM.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    c43392b.ppM.setResult(-1, intent);
                } else {
                    intent.putExtra("Chat_User", c43392b.ehM.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    intent.putExtra("finish_direct", true);
                    C39503b.gkE.mo38915d(intent, c43392b.ppM);
                }
                c43392b.mo68939Bj(5);
                C34739c.m57055cP(c43392b.ehM.field_username, 300);
            }
            AppMethodBeat.m2505o(23849);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference$2 */
    class C128622 implements OnClickListener {
        C128622() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23850);
            if (NewBizInfoFollowPreference.this.plh != null && (NewBizInfoFollowPreference.this.plh instanceof C43392b)) {
                C43392b c43392b = (C43392b) NewBizInfoFollowPreference.this.plh;
                ((C46490h) C1720g.m3528K(C46490h.class)).mo41539a(c43392b.pkW, c43392b.ppM, c43392b.ehM, true, new C215013());
                C34739c.m57055cP(c43392b.ehM.field_username, 1000);
            }
            AppMethodBeat.m2505o(23850);
        }
    }

    public NewBizInfoFollowPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23851);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23851);
    }

    public NewBizInfoFollowPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23852);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23852);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23853);
        this.lyb = true;
        this.ppS = (TextView) view.findViewById(2131822976);
        if (this.ppS.getPaint() != null) {
            this.ppS.getPaint().setFakeBoldText(true);
        }
        this.ppT = (TextView) view.findViewById(2131822977);
        if (this.ppT.getPaint() != null) {
            this.ppT.getPaint().setFakeBoldText(true);
        }
        if (this.lyb) {
            this.ppS.setOnClickListener(new C128611());
            this.ppT.setOnClickListener(new C128622());
        }
        AppMethodBeat.m2505o(23853);
    }
}
