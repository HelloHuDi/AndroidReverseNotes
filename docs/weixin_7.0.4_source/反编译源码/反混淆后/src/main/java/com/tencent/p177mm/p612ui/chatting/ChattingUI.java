package com.tencent.p177mm.p612ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.p230g.p231a.C37757lh;
import com.tencent.p177mm.p230g.p231a.C37779ot;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.p616c.C44812c;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
@C18524i
/* renamed from: com.tencent.mm.ui.chatting.ChattingUI */
public class ChattingUI extends MMFragmentActivity {
    public ChattingUIFragment yLg;
    public C7306ak yLh = new C7306ak();

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUI$1 */
    class C236801 implements Runnable {

        /* renamed from: com.tencent.mm.ui.chatting.ChattingUI$1$2 */
        class C236812 implements OnClickListener {
            C236812() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(30818);
                C4879a.xxA.mo10055m(new C37757lh());
                AppMethodBeat.m2505o(30818);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.ChattingUI$1$1 */
        class C236821 implements OnClickListener {
            C236821() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(30817);
                C4879a.xxA.mo10055m(new C37779ot());
                AppMethodBeat.m2505o(30817);
            }
        }

        C236801() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30819);
            C30379h.m48466d(ChattingUI.this, ChattingUI.this.getString(C25738R.string.d9p), "", ChattingUI.this.getString(C25738R.string.d9q), ChattingUI.this.getString(C25738R.string.f9076or), new C236821(), new C236812());
            AppMethodBeat.m2505o(30819);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUI$2 */
    class C236832 implements Runnable {
        C236832() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30820);
            if (ChattingUI.this.yLg != null) {
                C30036f.m47539a(ChattingUI.this, ChattingUI.this.yLg.getBodyView());
            }
            C37657b.m63683bE(ChattingUI.this.yLg.getContext());
            AppMethodBeat.m2505o(30820);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ChattingUI() {
        AppMethodBeat.m2504i(30821);
        AppMethodBeat.m2505o(30821);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30822);
        getWindow().setFormat(-2);
        C30036f.m47540ah(this);
        super.onCreate(null);
        if (C44812c.m81953aU(getIntent())) {
            finish();
            AppMethodBeat.m2505o(30822);
            return;
        }
        setContentView(2130969128);
        this.yLg = dBp();
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_CHATTING_ACTIVITY", true);
        this.yLg.setArguments(extras);
        getSupportFragmentManager().beginTransaction().mo552a(2131821892, this.yLg).commit();
        getSupportActionBar().show();
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            C5004al.m7442n(new C236801(), 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        initNavigationSwipeBack();
        this.yLh.post(new C236832());
        AppMethodBeat.m2505o(30822);
    }

    /* Access modifiers changed, original: protected */
    public ChattingUIFragment dBp() {
        AppMethodBeat.m2504i(30823);
        ChattingUIFragment chattingUIFragment = new ChattingUIFragment((byte) 0);
        AppMethodBeat.m2505o(30823);
        return chattingUIFragment;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(30824);
        C4990ab.m7411d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", keyEvent);
        if (this.yLg == null || !this.yLg.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.m2505o(30824);
            return dispatchKeyEvent;
        }
        AppMethodBeat.m2505o(30824);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(30825);
        C4990ab.m7410d("MicroMsg.ChattingUI", "chatting ui on key up");
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(30825);
        return onKeyUp;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(30826);
        C4990ab.m7411d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", Integer.valueOf(i), keyEvent);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(30826);
        return onKeyDown;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(30827);
        C4990ab.m7416i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
        this.yLg.onRequestPermissionsResult(i, strArr, iArr);
        AppMethodBeat.m2505o(30827);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(30828);
        super.onActivityResult(i, i2, intent);
        this.yLg.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(30828);
    }
}
