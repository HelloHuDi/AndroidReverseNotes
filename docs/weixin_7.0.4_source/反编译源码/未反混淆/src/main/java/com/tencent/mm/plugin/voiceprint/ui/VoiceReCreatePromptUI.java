package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class VoiceReCreatePromptUI extends MMActivity implements OnClickListener {
    private View sMM = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26219);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sMM = findViewById(R.id.f27);
        this.sMM.setOnClickListener(this);
        AppMethodBeat.o(26219);
    }

    public void onDestroy() {
        AppMethodBeat.i(26220);
        super.onDestroy();
        AppMethodBeat.o(26220);
    }

    public final int getLayoutId() {
        return R.layout.b24;
    }

    public void onClick(View view) {
        AppMethodBeat.i(26221);
        startActivity(new Intent(this, VoiceCreateUI.class));
        finish();
        AppMethodBeat.o(26221);
    }
}
