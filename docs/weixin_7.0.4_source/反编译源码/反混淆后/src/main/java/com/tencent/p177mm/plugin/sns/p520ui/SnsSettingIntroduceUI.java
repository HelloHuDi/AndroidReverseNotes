package com.tencent.p177mm.plugin.sns.p520ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C18221ar;
import com.tencent.p177mm.p612ui.C5510e.C5501h;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI */
public class SnsSettingIntroduceUI extends MMActivity {
    private Button rwH;
    private Button rwI;
    private Intent rwJ;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI$2 */
    class C135472 implements OnClickListener {
        C135472() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39243);
            C18221ar c18221ar = new C18221ar();
            c18221ar.ctN.index = 3;
            C4879a.xxA.mo10055m(c18221ar);
            C25985d.m41467b(SnsSettingIntroduceUI.this.mController.ylL, "setting", ".ui.setting.SettingsUI", new Intent());
            Intent intent = new Intent();
            intent.putExtra("enter_scene", C5501h.yga);
            C25985d.m41467b(SnsSettingIntroduceUI.this.mController.ylL, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            C7060h.pYm.mo8381e(14090, Integer.valueOf(2));
            SnsSettingIntroduceUI.this.finish();
            AppMethodBeat.m2505o(39243);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI$1 */
    class C291251 implements OnClickListener {
        C291251() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39242);
            C7060h.pYm.mo8381e(14090, Integer.valueOf(3));
            C25985d.m41467b(SnsSettingIntroduceUI.this, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.this.rwJ);
            SnsSettingIntroduceUI.this.finish();
            SnsSettingIntroduceUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(39242);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39244);
        super.onDestroy();
        AppMethodBeat.m2505o(39244);
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39245);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        this.rwJ = getIntent();
        this.rwH = (Button) findViewById(2131826267);
        this.rwH.setOnClickListener(new C291251());
        C7060h.pYm.mo8381e(14090, Integer.valueOf(1));
        this.rwI = (Button) findViewById(2131825914);
        this.rwI.setOnClickListener(new C135472());
        AppMethodBeat.m2505o(39245);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39246);
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            C7060h.pYm.mo8381e(14090, Integer.valueOf(3));
            AppMethodBeat.m2505o(39246);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(39246);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return 2130970796;
    }
}
