package com.tencent.p177mm.plugin.nearby.p469ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI */
public class NearbyFriendsIntroUI extends MMActivity {
    private Button grC;
    private View oPR;
    private CheckBox oPS;
    private C5653c oPU = null;

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI$1 */
    class C394571 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI$1$1 */
        class C394581 implements DialogInterface.OnClickListener {
            C394581() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(55434);
                C1720g.m3536RP().mo5239Ry().set(4103, Boolean.TRUE);
                C1720g.m3536RP().mo5239Ry().set(4104, Boolean.valueOf(!NearbyFriendsIntroUI.this.oPS.isChecked()));
                C32782bp aap = C32782bp.aap();
                if (aap == null) {
                    NearbyFriendsIntroUI.this.startActivity(new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class));
                } else {
                    String nullAsNil = C5046bo.nullAsNil(aap.getProvince());
                    C5046bo.nullAsNil(aap.getCity());
                    int a = C5046bo.m7512a(Integer.valueOf(aap.dtS), 0);
                    if (nullAsNil.equals("") || a == 0) {
                        NearbyFriendsIntroUI.this.startActivity(new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class));
                    } else {
                        NearbyFriendsIntroUI.this.startActivity(new Intent(NearbyFriendsIntroUI.this, NearbyFriendsUI.class));
                    }
                }
                NearbyFriendsIntroUI.this.finish();
                AppMethodBeat.m2505o(55434);
            }
        }

        C394571() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55435);
            if (NearbyFriendsIntroUI.this.oPU == null) {
                NearbyFriendsIntroUI.this.oPU = C30379h.m48436a(NearbyFriendsIntroUI.this.mController.ylL, NearbyFriendsIntroUI.this.getString(C25738R.string.f9238tz), NearbyFriendsIntroUI.this.oPR, new C394581(), null);
                AppMethodBeat.m2505o(55435);
                return;
            }
            NearbyFriendsIntroUI.this.oPU.show();
            AppMethodBeat.m2505o(55435);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI$2 */
    class C394592 implements OnMenuItemClickListener {
        C394592() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55436);
            NearbyFriendsIntroUI.this.aqX();
            NearbyFriendsIntroUI.this.finish();
            AppMethodBeat.m2505o(55436);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(55437);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.d57);
        initView();
        AppMethodBeat.m2505o(55437);
    }

    public final int getLayoutId() {
        return 2130970288;
    }

    public final void initView() {
        AppMethodBeat.m2504i(55438);
        bVc();
        this.grC = (Button) findViewById(2131826299);
        this.grC.setOnClickListener(new C394571());
        setBackBtn(new C394592());
        AppMethodBeat.m2505o(55438);
    }

    private void bVc() {
        AppMethodBeat.m2504i(55439);
        this.oPR = View.inflate(this, 2130969930, null);
        this.oPS = (CheckBox) this.oPR.findViewById(2131825250);
        this.oPS.setChecked(false);
        AppMethodBeat.m2505o(55439);
    }
}
