package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class b extends a {
    public b(com.tencent.mm.ui.chatting.m.a.b bVar) {
        super(bVar);
    }

    /* Access modifiers changed, original: final */
    public final String dHh() {
        return "link_profile";
    }

    /* Access modifiers changed, original: final */
    public final CharSequence b(Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference) {
        AppMethodBeat.i(32742);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String bc = bo.bc((String) map.get(str + ".separator"), "、");
        int i = 0;
        while (true) {
            String str2 = str + ".memberlist.member" + (i != 0 ? Integer.valueOf(i) : "");
            if (map.get(str2) != null) {
                if (i != 0) {
                    spannableStringBuilder.append(bc);
                }
                final String str3 = (String) map.get(str2 + ".username");
                CharSequence charSequence = (String) map.get(str2 + ".nickname");
                if (bo.isNullOrNil(str3) || bo.isNullOrNil(charSequence)) {
                    ab.w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
                } else {
                    SpannableString b = j.b(ah.getContext(), charSequence);
                    b.setSpan(new a() {
                        public final void onClickImp(View view) {
                            AppMethodBeat.i(32741);
                            if (!(weakReference == null || weakReference.get() == null)) {
                                String string = bundle.getString("conv_talker_username", null);
                                if (t.kH(string)) {
                                    b.K((Context) weakReference.get(), str3, string);
                                    AppMethodBeat.o(32741);
                                    return;
                                }
                                b.K((Context) weakReference.get(), str3, null);
                            }
                            AppMethodBeat.o(32741);
                        }
                    }, 0, charSequence.length(), 33);
                    spannableStringBuilder.append(b);
                }
                i++;
            } else {
                AppMethodBeat.o(32742);
                return spannableStringBuilder;
            }
        }
    }

    static /* synthetic */ void K(Context context, String str, String str2) {
        AppMethodBeat.i(32743);
        if (!(context == null || bo.isNullOrNil(str))) {
            h.pYm.e(14516, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            Intent putExtra = new Intent().putExtra("Contact_User", str);
            putExtra.putExtra("Contact_ChatRoomId", str2);
            putExtra.putExtra("room_name", str2);
            putExtra.putExtra("Contact_Scene", 14);
            d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", putExtra);
        }
        AppMethodBeat.o(32743);
    }
}
