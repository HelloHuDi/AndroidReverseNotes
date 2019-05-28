package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceReCreatePromptUI */
public class VoiceReCreatePromptUI extends MMActivity implements OnClickListener {
    private View sMM = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26219);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sMM = findViewById(2131828468);
        this.sMM.setOnClickListener(this);
        AppMethodBeat.m2505o(26219);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26220);
        super.onDestroy();
        AppMethodBeat.m2505o(26220);
    }

    public final int getLayoutId() {
        return 2130971018;
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(26221);
        startActivity(new Intent(this, VoiceCreateUI.class));
        finish();
        AppMethodBeat.m2505o(26221);
    }
}
