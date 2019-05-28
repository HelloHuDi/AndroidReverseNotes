package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C27077c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoicePrintFinishUI */
public class VoicePrintFinishUI extends MMActivity {
    private TextView iDT;
    private TextView poi;
    private Button sMp;
    private ImageView sMq;
    private int sMr;

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoicePrintFinishUI$2 */
    class C78982 implements OnMenuItemClickListener {
        C78982() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(26206);
            VoicePrintFinishUI.this.finish();
            AppMethodBeat.m2505o(26206);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoicePrintFinishUI$1 */
    class C78991 implements OnClickListener {
        C78991() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26205);
            if (VoicePrintFinishUI.this.sMr == 72) {
                Intent intent = new Intent();
                intent.setClass(VoicePrintFinishUI.this, VoiceUnLockUI.class);
                intent.putExtra("kscene_type", 73);
                VoicePrintFinishUI.this.startActivity(intent);
            }
            VoicePrintFinishUI.this.finish();
            AppMethodBeat.m2505o(26205);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26207);
        C4990ab.m7416i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sMr = getIntent().getIntExtra("kscene_type", 73);
        C4990ab.m7411d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", Integer.valueOf(this.sMr));
        this.iDT = (TextView) findViewById(2131828458);
        this.poi = (TextView) findViewById(2131823773);
        this.sMp = (Button) findViewById(2131823774);
        this.sMq = (ImageView) findViewById(2131823772);
        switch (this.sMr) {
            case C33279c.CTRL_INDEX /*72*/:
                this.iDT.setText(C25738R.string.f2x);
                this.poi.setText(C25738R.string.f2y);
                this.sMq.setVisibility(0);
                this.sMp.setText(C25738R.string.ecy);
                break;
            case C27077c.CTRL_INDEX /*73*/:
                this.iDT.setVisibility(8);
                this.poi.setText(C25738R.string.f3j);
                this.sMq.setVisibility(0);
                this.sMp.setText(C25738R.string.ecz);
                break;
        }
        this.sMp.setOnClickListener(new C78991());
        setBackBtn(new C78982());
        AppMethodBeat.m2505o(26207);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26208);
        super.onDestroy();
        AppMethodBeat.m2505o(26208);
    }

    public final int getLayoutId() {
        return 2130971014;
    }
}
