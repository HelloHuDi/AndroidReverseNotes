package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C43807e;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C4467c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.h */
public final class C40127h {
    /* renamed from: a */
    public static void m68793a(Context context, List<Bankcard> list, Bankcard bankcard, String str, String str2, boolean z, String str3, C5279d c5279d) {
        AppMethodBeat.m2504i(47158);
        final C36356d c36356d = new C36356d(context, 2, true);
        final HashMap hashMap = new HashMap();
        final List<Bankcard> list2 = list;
        final Context context2 = context;
        final boolean z2 = z;
        final String str4 = str3;
        c36356d.rBl = new C36073c() {
            final /* synthetic */ boolean tEj = false;

            /* renamed from: a */
            public final void mo5746a(final C44273l c44273l) {
                AppMethodBeat.m2504i(47157);
                int i = 0;
                for (final Bankcard bankcard : list2) {
                    String str;
                    CharSequence spannableString;
                    String str2;
                    C43807e c43807e = null;
                    if (bankcard.cPd()) {
                        Bankcard bankcard2 = C14241r.cPI().tCZ;
                        if (bankcard2 != null) {
                            c43807e = bankcard2.txc;
                        }
                    } else {
                        c43807e = C46362b.m87144i(context2, bankcard.field_bankcardType, bankcard.cPb());
                    }
                    String str3 = "";
                    if (c43807e != null) {
                        str = c43807e.oRi;
                    } else {
                        str = str3;
                    }
                    C4990ab.m7411d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", str);
                    Bitmap a = C18764x.m29325a(new C4467c(str));
                    C18764x.m29326a(new C18765a() {
                        /* renamed from: m */
                        public final void mo8136m(final String str, final Bitmap bitmap) {
                            AppMethodBeat.m2504i(47155);
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(47154);
                                    C4990ab.m7417i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, str);
                                    if (hashMap.containsKey(str)) {
                                        int intValue = ((Integer) hashMap.get(str)).intValue();
                                        if (c44273l.getItem(intValue) != null) {
                                            c44273l.getItem(intValue).setIcon(new BitmapDrawable(C5056d.m7615a(bitmap, C4996ah.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), C4996ah.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false)));
                                            c36356d.dKX();
                                        }
                                    }
                                    AppMethodBeat.m2505o(47154);
                                }
                            });
                            AppMethodBeat.m2505o(47155);
                        }
                    });
                    CharSequence charSequence = "";
                    if (!C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                        charSequence = bankcard.field_forbidWord;
                    }
                    if (C5046bo.isNullOrNil(bankcard.field_forbid_title)) {
                        spannableString = new SpannableString(charSequence);
                        str2 = charSequence;
                    } else {
                        str2 = charSequence + " ";
                        charSequence = new SpannableString(str2 + bankcard.field_forbid_title);
                        C296702 c296702 = new C46373j(context2) {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(47156);
                                Intent intent = new Intent();
                                C4990ab.m7417i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", bankcard.field_forbid_url);
                                intent.putExtra("rawUrl", r1);
                                intent.putExtra("geta8key_username", C1853r.m3846Yz());
                                intent.putExtra("pay_channel", 1);
                                C25985d.m41467b(context2, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                AppMethodBeat.m2505o(47156);
                            }
                        };
                        int length = str2.length();
                        int length2 = str2.length() + bankcard.field_forbid_title.length();
                        charSequence.setSpan(new ForegroundColorSpan(context2.getResources().getColor(C25738R.color.a50)), length, length2, 33);
                        charSequence.setSpan(c296702, length, length2, 33);
                        spannableString = charSequence;
                    }
                    if (this.tEj && C5046bo.m7519ac(r3) && !C5046bo.isNullOrNil(bankcard.field_fetchArriveTimeWording)) {
                        spannableString = new SpannableString(bankcard.field_fetchArriveTimeWording);
                    }
                    String str4 = bankcard.field_desc;
                    if (a != null) {
                        a = C5056d.m7615a(a, context2.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), context2.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false);
                    } else {
                        a = null;
                    }
                    if (a == null) {
                        hashMap.put(str, Integer.valueOf(i));
                    }
                    C4990ab.m7417i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", Integer.valueOf(i), str4, spannableString);
                    int i2;
                    if (bankcard.cPc()) {
                        boolean z;
                        i2 = i + 1;
                        Drawable drawable = context2.getResources().getDrawable(C25738R.drawable.bki);
                        if (C5046bo.isNullOrNil(str2)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        c44273l.mo70053a(i, str4, spannableString, drawable, z);
                        i = i2;
                    } else {
                        i2 = i + 1;
                        c44273l.mo70053a(i, str4, spannableString, a == null ? null : new BitmapDrawable(a), !C5046bo.isNullOrNil(str2));
                        i = i2;
                    }
                }
                if (z2 && !C5046bo.isNullOrNil(str4)) {
                    c44273l.mo70053a(i, str4, "", C4996ah.getResources().getDrawable(C25738R.drawable.bkc), false);
                }
                AppMethodBeat.m2505o(47157);
            }
        };
        c36356d.rBm = c5279d;
        c36356d.zQy = true;
        View inflate = LayoutInflater.from(context).inflate(2130971046, null);
        if (!C5046bo.isNullOrNil(str)) {
            ((TextView) inflate.findViewById(2131828598)).setText(str);
        }
        if (C5046bo.isNullOrNil(str2)) {
            inflate.findViewById(2131828599).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(2131828599)).setText(str2);
        }
        c36356d.mo57234F(inflate, false);
        if (bankcard != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (((Bankcard) list.get(i2)).field_bindSerial.equals(bankcard.field_bindSerial)) {
                    c36356d.zQA = i2;
                }
                i = i2 + 1;
            }
        }
        c36356d.cpD();
        AppMethodBeat.m2505o(47158);
    }
}
