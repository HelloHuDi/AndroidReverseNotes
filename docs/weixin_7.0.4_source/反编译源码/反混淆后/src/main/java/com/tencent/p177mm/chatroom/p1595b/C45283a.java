package com.tencent.p177mm.chatroom.p1595b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.chatroom.p1379d.C26016a;
import com.tencent.p177mm.chatroom.p216ui.SeeRoomManagerUI;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12517b;
import com.tencent.p177mm.plugin.messenger.p993a.C34529a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.tencent.mm.chatroom.b.a */
public final class C45283a implements C12517b {
    public C26016a ehc = new C26016a();

    public C45283a() {
        AppMethodBeat.m2504i(103900);
        AppMethodBeat.m2505o(103900);
    }

    /* renamed from: a */
    public final CharSequence mo7904a(Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference) {
        AppMethodBeat.m2504i(103901);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CharSequence charSequence = (String) map.get(str + ".title");
        if (C5046bo.isNullOrNil(charSequence)) {
            String str2 = "";
            AppMethodBeat.m2505o(103901);
            return str2;
        }
        SpannableString b = C44089j.m79292b(C4996ah.getContext(), charSequence);
        b.setSpan(new C34529a() {
            public final void onClickImp(View view) {
                AppMethodBeat.m2504i(103899);
                if (!(weakReference == null || weakReference.get() == null)) {
                    String string = bundle.getString("conv_talker_username");
                    Context context = (Context) weakReference.get();
                    Intent intent = new Intent(context, SeeRoomManagerUI.class);
                    intent.setFlags(32768);
                    intent.putExtra("RoomInfo_Id", string);
                    context.startActivity(intent);
                }
                AppMethodBeat.m2505o(103899);
            }
        }, 0, charSequence.length(), 33);
        spannableStringBuilder.append(b);
        AppMethodBeat.m2505o(103901);
        return spannableStringBuilder;
    }
}
