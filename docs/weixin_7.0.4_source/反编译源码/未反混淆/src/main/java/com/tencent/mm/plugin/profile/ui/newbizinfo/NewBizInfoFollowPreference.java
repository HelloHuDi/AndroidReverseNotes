package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.of;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoFollowPreference extends Preference {
    private MMActivity crP;
    private boolean lyb = false;
    a plh;
    private TextView ppS;
    private TextView ppT;

    public NewBizInfoFollowPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23851);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23851);
    }

    public NewBizInfoFollowPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23852);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23852);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23853);
        this.lyb = true;
        this.ppS = (TextView) view.findViewById(R.id.b1q);
        if (this.ppS.getPaint() != null) {
            this.ppS.getPaint().setFakeBoldText(true);
        }
        this.ppT = (TextView) view.findViewById(R.id.b1r);
        if (this.ppT.getPaint() != null) {
            this.ppT.getPaint().setFakeBoldText(true);
        }
        if (this.lyb) {
            this.ppS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23849);
                    if (NewBizInfoFollowPreference.this.plh != null && (NewBizInfoFollowPreference.this.plh instanceof b)) {
                        b bVar = (b) NewBizInfoFollowPreference.this.plh;
                        if (bVar.pmI != null) {
                            of ofVar = new of();
                            bVar.pmI.fPZ = 5;
                            ofVar.cKy.cKz = bVar.pmI;
                            com.tencent.mm.sdk.b.a.xxA.m(ofVar);
                        }
                        Intent intent = new Intent();
                        if (bVar.ppM.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                            intent.setFlags(268435456);
                        }
                        intent.putExtra("chat_from_scene", bVar.ppM.getIntent().getIntExtra("chat_from_scene", 0));
                        intent.putExtra("KOpenArticleSceneFromScene", 126);
                        intent.putExtra("specific_chat_from_scene", 5);
                        if (bVar.pli) {
                            intent.putExtra("Chat_User", bVar.ehM.field_username);
                            intent.putExtra("Chat_Mode", 1);
                            bVar.ppM.setResult(-1, intent);
                        } else {
                            intent.putExtra("Chat_User", bVar.ehM.field_username);
                            intent.putExtra("Chat_Mode", 1);
                            intent.putExtra("finish_direct", true);
                            b.gkE.d(intent, bVar.ppM);
                        }
                        bVar.Bj(5);
                        c.cP(bVar.ehM.field_username, 300);
                    }
                    AppMethodBeat.o(23849);
                }
            });
            this.ppT.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23850);
                    if (NewBizInfoFollowPreference.this.plh != null && (NewBizInfoFollowPreference.this.plh instanceof b)) {
                        b bVar = (b) NewBizInfoFollowPreference.this.plh;
                        ((h) g.K(h.class)).a(bVar.pkW, bVar.ppM, bVar.ehM, true, new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(23806);
                                b.this.Bj(4);
                                if (b.this.ppM.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                                    Intent intent = new Intent();
                                    intent.addFlags(67108864);
                                    d.b(b.this.ppM, "shake", ".ui.ShakeReportUI", intent);
                                }
                                AppMethodBeat.o(23806);
                            }
                        });
                        c.cP(bVar.ehM.field_username, 1000);
                    }
                    AppMethodBeat.o(23850);
                }
            });
        }
        AppMethodBeat.o(23853);
    }
}
