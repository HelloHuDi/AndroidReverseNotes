package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.kernel.i;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.c;

@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
@i
public class ChattingUI extends MMFragmentActivity {
    public ChattingUIFragment yLg;
    public ak yLh = new ak();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChattingUI() {
        AppMethodBeat.i(30821);
        AppMethodBeat.o(30821);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30822);
        getWindow().setFormat(-2);
        f.ah(this);
        super.onCreate(null);
        if (c.aU(getIntent())) {
            finish();
            AppMethodBeat.o(30822);
            return;
        }
        setContentView((int) R.layout.o6);
        this.yLg = dBp();
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_CHATTING_ACTIVITY", true);
        this.yLg.setArguments(extras);
        getSupportFragmentManager().beginTransaction().a((int) R.id.a9e, this.yLg).commit();
        getSupportActionBar().show();
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(30819);
                    h.d(ChattingUI.this, ChattingUI.this.getString(R.string.d9p), "", ChattingUI.this.getString(R.string.d9q), ChattingUI.this.getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(30817);
                            a.xxA.m(new ot());
                            AppMethodBeat.o(30817);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(30818);
                            a.xxA.m(new lh());
                            AppMethodBeat.o(30818);
                        }
                    });
                    AppMethodBeat.o(30819);
                }
            }, 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        initNavigationSwipeBack();
        this.yLh.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(30820);
                if (ChattingUI.this.yLg != null) {
                    f.a(ChattingUI.this, ChattingUI.this.yLg.getBodyView());
                }
                b.bE(ChattingUI.this.yLg.getContext());
                AppMethodBeat.o(30820);
            }
        });
        AppMethodBeat.o(30822);
    }

    /* Access modifiers changed, original: protected */
    public ChattingUIFragment dBp() {
        AppMethodBeat.i(30823);
        ChattingUIFragment chattingUIFragment = new ChattingUIFragment((byte) 0);
        AppMethodBeat.o(30823);
        return chattingUIFragment;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(30824);
        ab.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", keyEvent);
        if (this.yLg == null || !this.yLg.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(30824);
            return dispatchKeyEvent;
        }
        AppMethodBeat.o(30824);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(30825);
        ab.d("MicroMsg.ChattingUI", "chatting ui on key up");
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(30825);
        return onKeyUp;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(30826);
        ab.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", Integer.valueOf(i), keyEvent);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(30826);
        return onKeyDown;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(30827);
        ab.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
        this.yLg.onRequestPermissionsResult(i, strArr, iArr);
        AppMethodBeat.o(30827);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(30828);
        super.onActivityResult(i, i2, intent);
        this.yLg.onActivityResult(i, i2, intent);
        AppMethodBeat.o(30828);
    }
}
