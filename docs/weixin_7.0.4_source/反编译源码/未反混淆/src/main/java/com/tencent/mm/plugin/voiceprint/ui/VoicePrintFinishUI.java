package com.tencent.mm.plugin.voiceprint.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI extends MMActivity {
    private TextView iDT;
    private TextView poi;
    private Button sMp;
    private ImageView sMq;
    private int sMr;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26207);
        ab.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sMr = getIntent().getIntExtra("kscene_type", 73);
        ab.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", Integer.valueOf(this.sMr));
        this.iDT = (TextView) findViewById(R.id.f1x);
        this.poi = (TextView) findViewById(R.id.bm_);
        this.sMp = (Button) findViewById(R.id.bma);
        this.sMq = (ImageView) findViewById(R.id.bm9);
        switch (this.sMr) {
            case c.CTRL_INDEX /*72*/:
                this.iDT.setText(R.string.f2x);
                this.poi.setText(R.string.f2y);
                this.sMq.setVisibility(0);
                this.sMp.setText(R.string.ecy);
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.share.c.CTRL_INDEX /*73*/:
                this.iDT.setVisibility(8);
                this.poi.setText(R.string.f3j);
                this.sMq.setVisibility(0);
                this.sMp.setText(R.string.ecz);
                break;
        }
        this.sMp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26205);
                if (VoicePrintFinishUI.this.sMr == 72) {
                    Intent intent = new Intent();
                    intent.setClass(VoicePrintFinishUI.this, VoiceUnLockUI.class);
                    intent.putExtra("kscene_type", 73);
                    VoicePrintFinishUI.this.startActivity(intent);
                }
                VoicePrintFinishUI.this.finish();
                AppMethodBeat.o(26205);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26206);
                VoicePrintFinishUI.this.finish();
                AppMethodBeat.o(26206);
                return true;
            }
        });
        AppMethodBeat.o(26207);
    }

    public void onDestroy() {
        AppMethodBeat.i(26208);
        super.onDestroy();
        AppMethodBeat.o(26208);
    }

    public final int getLayoutId() {
        return R.layout.b21;
    }
}
