package com.tencent.p177mm.plugin.sns.p520ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsLongMsgUI */
public class SnsLongMsgUI extends MMActivity {
    private Button qZB;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLongMsgUI$1 */
    class C398051 implements OnClickListener {
        C398051() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39061);
            Intent intent = new Intent();
            intent.setClass(SnsLongMsgUI.this, SnsUploadUI.class);
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", C5046bo.anT());
            intent.putExtra("sns_comment_type", 1);
            intent.putExtra("Ksnsupload_type", 9);
            SnsLongMsgUI.this.startActivity(intent);
            SnsLongMsgUI.this.finish();
            AppMethodBeat.m2505o(39061);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39062);
        super.onDestroy();
        AppMethodBeat.m2505o(39062);
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39063);
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.qZB = (Button) findViewById(2131825327);
        this.qZB.setOnClickListener(new C398051());
        AppMethodBeat.m2505o(39063);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39064);
        if (i == 4 && keyEvent.getAction() == 0) {
            Intent intent = new Intent();
            intent.setClass(this, SnsUploadUI.class);
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", C5046bo.anT());
            intent.putExtra("sns_comment_type", 1);
            intent.putExtra("Ksnsupload_type", 9);
            startActivity(intent);
            finish();
            AppMethodBeat.m2505o(39064);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(39064);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return 2130969955;
    }
}
