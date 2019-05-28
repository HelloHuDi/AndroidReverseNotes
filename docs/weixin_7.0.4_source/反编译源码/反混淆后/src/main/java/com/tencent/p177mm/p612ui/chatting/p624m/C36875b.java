package com.tencent.p177mm.p612ui.chatting.p624m;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.chatting.p624m.C36199a.C30557b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.p993a.C34529a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.m.b */
public final class C36875b extends C36199a {
    public C36875b(C30557b c30557b) {
        super(c30557b);
    }

    /* Access modifiers changed, original: final */
    public final String dHh() {
        return "link_profile";
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final CharSequence mo10981b(Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference) {
        AppMethodBeat.m2504i(32742);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String bc = C5046bo.m7532bc((String) map.get(str + ".separator"), "、");
        int i = 0;
        while (true) {
            String str2 = str + ".memberlist.member" + (i != 0 ? Integer.valueOf(i) : "");
            if (map.get(str2) != null) {
                if (i != 0) {
                    spannableStringBuilder.append(bc);
                }
                final String str3 = (String) map.get(str2 + ".username");
                CharSequence charSequence = (String) map.get(str2 + ".nickname");
                if (C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(charSequence)) {
                    C4990ab.m7420w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
                } else {
                    SpannableString b = C44089j.m79292b(C4996ah.getContext(), charSequence);
                    b.setSpan(new C34529a() {
                        public final void onClickImp(View view) {
                            AppMethodBeat.m2504i(32741);
                            if (!(weakReference == null || weakReference.get() == null)) {
                                String string = bundle.getString("conv_talker_username", null);
                                if (C1855t.m3896kH(string)) {
                                    C36875b.m61376K((Context) weakReference.get(), str3, string);
                                    AppMethodBeat.m2505o(32741);
                                    return;
                                }
                                C36875b.m61376K((Context) weakReference.get(), str3, null);
                            }
                            AppMethodBeat.m2505o(32741);
                        }
                    }, 0, charSequence.length(), 33);
                    spannableStringBuilder.append(b);
                }
                i++;
            } else {
                AppMethodBeat.m2505o(32742);
                return spannableStringBuilder;
            }
        }
    }

    /* renamed from: K */
    static /* synthetic */ void m61376K(Context context, String str, String str2) {
        AppMethodBeat.m2504i(32743);
        if (!(context == null || C5046bo.isNullOrNil(str))) {
            C7060h.pYm.mo8381e(14516, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            Intent putExtra = new Intent().putExtra("Contact_User", str);
            putExtra.putExtra("Contact_ChatRoomId", str2);
            putExtra.putExtra("room_name", str2);
            putExtra.putExtra("Contact_Scene", 14);
            C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", putExtra);
        }
        AppMethodBeat.m2505o(32743);
    }
}
