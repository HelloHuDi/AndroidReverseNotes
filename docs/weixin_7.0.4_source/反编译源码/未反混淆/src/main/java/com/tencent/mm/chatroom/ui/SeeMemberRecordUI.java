package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class SeeMemberRecordUI extends SelectMemberUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(View view, int i, long j) {
        AppMethodBeat.i(104281);
        super.a(view, i, j);
        String str = this.emB.iH(i).ehM.field_username;
        aqX();
        Intent intent = new Intent(this, SelectedMemberChattingRecordUI.class);
        intent.putExtra("RoomInfo_Id", this.ejD);
        intent.putExtra("room_member", str);
        intent.putExtra("title", getString(R.string.e15));
        startActivity(intent);
        AppMethodBeat.o(104281);
    }

    public final boolean Kl() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104282);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.k0), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        AppMethodBeat.o(104282);
    }
}
