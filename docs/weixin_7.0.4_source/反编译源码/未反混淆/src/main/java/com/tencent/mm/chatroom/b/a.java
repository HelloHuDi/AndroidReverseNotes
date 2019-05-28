package com.tencent.mm.chatroom.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.SeeRoomManagerUI;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a implements b {
    public com.tencent.mm.chatroom.d.a ehc = new com.tencent.mm.chatroom.d.a();

    public a() {
        AppMethodBeat.i(103900);
        AppMethodBeat.o(103900);
    }

    public final CharSequence a(Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference) {
        AppMethodBeat.i(103901);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CharSequence charSequence = (String) map.get(str + ".title");
        if (bo.isNullOrNil(charSequence)) {
            String str2 = "";
            AppMethodBeat.o(103901);
            return str2;
        }
        SpannableString b = j.b(ah.getContext(), charSequence);
        b.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
            public final void onClickImp(View view) {
                AppMethodBeat.i(103899);
                if (!(weakReference == null || weakReference.get() == null)) {
                    String string = bundle.getString("conv_talker_username");
                    Context context = (Context) weakReference.get();
                    Intent intent = new Intent(context, SeeRoomManagerUI.class);
                    intent.setFlags(32768);
                    intent.putExtra("RoomInfo_Id", string);
                    context.startActivity(intent);
                }
                AppMethodBeat.o(103899);
            }
        }, 0, charSequence.length(), 33);
        spannableStringBuilder.append(b);
        AppMethodBeat.o(103901);
        return spannableStringBuilder;
    }
}
