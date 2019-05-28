package com.tencent.p177mm.chatroom.p216ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.chatroom.ui.SeeMemberRecordUI */
public class SeeMemberRecordUI extends SelectMemberUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo17467a(View view, int i, long j) {
        AppMethodBeat.m2504i(104281);
        super.mo17467a(view, i, j);
        String str = this.emB.mo17474iH(i).ehM.field_username;
        aqX();
        Intent intent = new Intent(this, SelectedMemberChattingRecordUI.class);
        intent.putExtra("RoomInfo_Id", this.ejD);
        intent.putExtra("room_member", str);
        intent.putExtra("title", getString(C25738R.string.e15));
        startActivity(intent);
        AppMethodBeat.m2505o(104281);
    }

    /* renamed from: Kl */
    public final boolean mo17458Kl() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104282);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(2131820940), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        AppMethodBeat.m2505o(104282);
    }
}
