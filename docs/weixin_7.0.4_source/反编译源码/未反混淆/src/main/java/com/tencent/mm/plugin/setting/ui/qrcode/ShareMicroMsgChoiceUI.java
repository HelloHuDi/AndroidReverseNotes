package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShareMicroMsgChoiceUI extends MMPreference {
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final boolean aqT() {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.aso;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126913);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(126913);
    }

    public final int JC() {
        return R.xml.cc;
    }

    public final void initView() {
        AppMethodBeat.i(126914);
        setMMTitle((int) R.string.e3f);
        this.ehK = this.yCw;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126912);
                ShareMicroMsgChoiceUI.this.aqX();
                ShareMicroMsgChoiceUI.this.finish();
                AppMethodBeat.o(126912);
                return true;
            }
        });
        ((IconPreference) this.ehK.aqO("share_micromsg_to_sina")).drawable = a.g(this, R.drawable.ao5);
        ((j) g.K(j.class)).XU().RA("@t.qq.com");
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("share_micromsg_qzone");
        if ((bo.h((Integer) g.RP().Ry().get(9, null)) != 0 ? 1 : null) == null) {
            this.ehK.d(iconPreference);
        } else {
            iconPreference.drawable = a.g(this, R.drawable.ann);
        }
        iconPreference = (IconPreference) this.ehK.aqO("share_micromsg_to_fuckbook");
        if (r.YX()) {
            iconPreference.drawable = a.g(this, R.drawable.ao4);
            AppMethodBeat.o(126914);
            return;
        }
        this.ehK.d(iconPreference);
        AppMethodBeat.o(126914);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(126915);
        String str = preference.mKey;
        Intent intent;
        if (str.equals("share_micromsg_qzone")) {
            if (bo.h((Integer) g.RP().Ry().get(9, null)) != 0) {
                intent = new Intent(this, ShowQRCodeStep1UI.class);
                intent.putExtra("show_to", 2);
                startActivity(intent);
            } else {
                h.g(this, R.string.e2r, R.string.tz);
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
        AppMethodBeat.o(126915);
        return false;
    }
}
