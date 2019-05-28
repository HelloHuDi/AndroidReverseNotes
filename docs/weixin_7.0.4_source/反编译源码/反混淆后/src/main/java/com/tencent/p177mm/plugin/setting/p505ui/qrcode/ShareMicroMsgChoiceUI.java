package com.tencent.p177mm.plugin.setting.p505ui.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareMicroMsgChoiceUI */
public class ShareMicroMsgChoiceUI extends MMPreference {
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareMicroMsgChoiceUI$1 */
    class C37801 implements OnMenuItemClickListener {
        C37801() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126912);
            ShareMicroMsgChoiceUI.this.aqX();
            ShareMicroMsgChoiceUI.this.finish();
            AppMethodBeat.m2505o(126912);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final boolean aqT() {
        return false;
    }

    public final int getLayoutId() {
        return 2130970667;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126913);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(126913);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8564cc;
    }

    public final void initView() {
        AppMethodBeat.m2504i(126914);
        setMMTitle((int) C25738R.string.e3f);
        this.ehK = this.yCw;
        setBackBtn(new C37801());
        ((IconPreference) this.ehK.aqO("share_micromsg_to_sina")).drawable = C1338a.m2864g(this, C25738R.drawable.ao5);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com");
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("share_micromsg_qzone");
        if ((C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(9, null)) != 0 ? 1 : null) == null) {
            this.ehK.mo27716d(iconPreference);
        } else {
            iconPreference.drawable = C1338a.m2864g(this, C25738R.drawable.ann);
        }
        iconPreference = (IconPreference) this.ehK.aqO("share_micromsg_to_fuckbook");
        if (C1853r.m3842YX()) {
            iconPreference.drawable = C1338a.m2864g(this, C25738R.drawable.ao4);
            AppMethodBeat.m2505o(126914);
            return;
        }
        this.ehK.mo27716d(iconPreference);
        AppMethodBeat.m2505o(126914);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(126915);
        String str = preference.mKey;
        Intent intent;
        if (str.equals("share_micromsg_qzone")) {
            if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(9, null)) != 0) {
                intent = new Intent(this, ShowQRCodeStep1UI.class);
                intent.putExtra("show_to", 2);
                startActivity(intent);
            } else {
                C30379h.m48467g(this, C25738R.string.e2r, C25738R.string.f9238tz);
            }
        } else if (str.equals("share_micromsg_to_sina")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 3);
            startActivity(intent);
        } else if (str.equals("share_micromsg_to_fuckbook")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 4);
            startActivity(intent);
        }
        AppMethodBeat.m2505o(126915);
        return false;
    }
}
