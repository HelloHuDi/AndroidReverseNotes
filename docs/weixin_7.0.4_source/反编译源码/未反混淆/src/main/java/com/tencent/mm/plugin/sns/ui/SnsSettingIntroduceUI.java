package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;

public class SnsSettingIntroduceUI extends MMActivity {
    private Button rwH;
    private Button rwI;
    private Intent rwJ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onDestroy() {
        AppMethodBeat.i(39244);
        super.onDestroy();
        AppMethodBeat.o(39244);
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39245);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        this.rwJ = getIntent();
        this.rwH = (Button) findViewById(R.id.dfp);
        this.rwH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39242);
                h.pYm.e(14090, Integer.valueOf(3));
                d.b(SnsSettingIntroduceUI.this, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.this.rwJ);
                SnsSettingIntroduceUI.this.finish();
                SnsSettingIntroduceUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(39242);
            }
        });
        h.pYm.e(14090, Integer.valueOf(1));
        this.rwI = (Button) findViewById(R.id.d76);
        this.rwI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39243);
                ar arVar = new ar();
                arVar.ctN.index = 3;
                a.xxA.m(arVar);
                d.b(SnsSettingIntroduceUI.this.mController.ylL, "setting", ".ui.setting.SettingsUI", new Intent());
                Intent intent = new Intent();
                intent.putExtra("enter_scene", e.h.yga);
                d.b(SnsSettingIntroduceUI.this.mController.ylL, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                h.pYm.e(14090, Integer.valueOf(2));
                SnsSettingIntroduceUI.this.finish();
                AppMethodBeat.o(39243);
            }
        });
        AppMethodBeat.o(39245);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(39246);
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            h.pYm.e(14090, Integer.valueOf(3));
            AppMethodBeat.o(39246);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(39246);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return R.layout.aw7;
    }
}
