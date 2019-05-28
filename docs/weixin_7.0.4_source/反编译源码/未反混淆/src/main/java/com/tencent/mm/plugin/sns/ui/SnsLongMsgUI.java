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
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class SnsLongMsgUI extends MMActivity {
    private Button qZB;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onDestroy() {
        AppMethodBeat.i(39062);
        super.onDestroy();
        AppMethodBeat.o(39062);
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39063);
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.qZB = (Button) findViewById(R.id.cra);
        this.qZB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39061);
                Intent intent = new Intent();
                intent.setClass(SnsLongMsgUI.this, SnsUploadUI.class);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", bo.anT());
                intent.putExtra("sns_comment_type", 1);
                intent.putExtra("Ksnsupload_type", 9);
                SnsLongMsgUI.this.startActivity(intent);
                SnsLongMsgUI.this.finish();
                AppMethodBeat.o(39061);
            }
        });
        AppMethodBeat.o(39063);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(39064);
        if (i == 4 && keyEvent.getAction() == 0) {
            Intent intent = new Intent();
            intent.setClass(this, SnsUploadUI.class);
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", bo.anT());
            intent.putExtra("sns_comment_type", 1);
            intent.putExtra("Ksnsupload_type", 9);
            startActivity(intent);
            finish();
            AppMethodBeat.o(39064);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(39064);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return R.layout.a_g;
    }
}
