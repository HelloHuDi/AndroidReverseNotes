package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;
import java.util.List;

public final class h {
    public static void a(Context context, List<Bankcard> list, Bankcard bankcard, String str, String str2, boolean z, String str3, d dVar) {
        AppMethodBeat.i(47158);
        final com.tencent.mm.ui.widget.a.d dVar2 = new com.tencent.mm.ui.widget.a.d(context, 2, true);
        final HashMap hashMap = new HashMap();
        final List<Bankcard> list2 = list;
        final Context context2 = context;
        final boolean z2 = z;
        final String str4 = str3;
        dVar2.rBl = new c() {
            final /* synthetic */ boolean tEj = false;

            public final void a(final l lVar) {
                AppMethodBeat.i(47157);
                int i = 0;
                for (final Bankcard bankcard : list2) {
                    String str;
                    CharSequence spannableString;
                    String str2;
                    e eVar = null;
                    if (bankcard.cPd()) {
                        Bankcard bankcard2 = r.cPI().tCZ;
                        if (bankcard2 != null) {
                            eVar = bankcard2.txc;
                        }
                    } else {
                        eVar = b.i(context2, bankcard.field_bankcardType, bankcard.cPb());
                    }
                    String str3 = "";
                    if (eVar != null) {
                        str = eVar.oRi;
                    } else {
                        str = str3;
                    }
                    ab.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", str);
                    Bitmap a = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str));
                    x.a(new a() {
                        public final void m(final String str, final Bitmap bitmap) {
                            AppMethodBeat.i(47155);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(47154);
                                    ab.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, str);
                                    if (hashMap.containsKey(str)) {
                                        int intValue = ((Integer) hashMap.get(str)).intValue();
                                        if (lVar.getItem(intValue) != null) {
                                            lVar.getItem(intValue).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(bitmap, ah.getResources().getDimensionPixelOffset(R.dimen.aaq), ah.getResources().getDimensionPixelOffset(R.dimen.aaq), true, false)));
                                            dVar2.dKX();
                                        }
                                    }
                                    AppMethodBeat.o(47154);
                                }
                            });
                            AppMethodBeat.o(47155);
                        }
                    });
                    CharSequence charSequence = "";
                    if (!bo.isNullOrNil(bankcard.field_forbidWord)) {
                        charSequence = bankcard.field_forbidWord;
                    }
                    if (bo.isNullOrNil(bankcard.field_forbid_title)) {
                        spannableString = new SpannableString(charSequence);
                        str2 = charSequence;
                    } else {
                        str2 = charSequence + " ";
                        charSequence = new SpannableString(str2 + bankcard.field_forbid_title);
                        AnonymousClass2 anonymousClass2 = new j(context2) {
                            public final void onClick(View view) {
                                AppMethodBeat.i(47156);
                                Intent intent = new Intent();
                                ab.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", bankcard.field_forbid_url);
                                intent.putExtra("rawUrl", r1);
                                intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
                                intent.putExtra("pay_channel", 1);
                                com.tencent.mm.bp.d.b(context2, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                AppMethodBeat.o(47156);
                            }
                        };
                        int length = str2.length();
                        int length2 = str2.length() + bankcard.field_forbid_title.length();
                        charSequence.setSpan(new ForegroundColorSpan(context2.getResources().getColor(R.color.a50)), length, length2, 33);
                        charSequence.setSpan(anonymousClass2, length, length2, 33);
                        spannableString = charSequence;
                    }
                    if (this.tEj && bo.ac(r3) && !bo.isNullOrNil(bankcard.field_fetchArriveTimeWording)) {
                        spannableString = new SpannableString(bankcard.field_fetchArriveTimeWording);
                    }
                    String str4 = bankcard.field_desc;
                    if (a != null) {
                        a = com.tencent.mm.sdk.platformtools.d.a(a, context2.getResources().getDimensionPixelOffset(R.dimen.aaq), context2.getResources().getDimensionPixelOffset(R.dimen.aaq), true, false);
                    } else {
                        a = null;
                    }
                    if (a == null) {
                        hashMap.put(str, Integer.valueOf(i));
                    }
                    ab.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", Integer.valueOf(i), str4, spannableString);
                    int i2;
                    if (bankcard.cPc()) {
                        boolean z;
                        i2 = i + 1;
                        Drawable drawable = context2.getResources().getDrawable(R.drawable.bki);
                        if (bo.isNullOrNil(str2)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        lVar.a(i, str4, spannableString, drawable, z);
                        i = i2;
                    } else {
                        i2 = i + 1;
                        lVar.a(i, str4, spannableString, a == null ? null : new BitmapDrawable(a), !bo.isNullOrNil(str2));
                        i = i2;
                    }
                }
                if (z2 && !bo.isNullOrNil(str4)) {
                    lVar.a(i, str4, "", ah.getResources().getDrawable(R.drawable.bkc), false);
                }
                AppMethodBeat.o(47157);
            }
        };
        dVar2.rBm = dVar;
        dVar2.zQy = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.b2u, null);
        if (!bo.isNullOrNil(str)) {
            ((TextView) inflate.findViewById(R.id.f5p)).setText(str);
        }
        if (bo.isNullOrNil(str2)) {
            inflate.findViewById(R.id.f5q).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(R.id.f5q)).setText(str2);
        }
        dVar2.F(inflate, false);
        if (bankcard != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (((Bankcard) list.get(i2)).field_bindSerial.equals(bankcard.field_bindSerial)) {
                    dVar2.zQA = i2;
                }
                i = i2 + 1;
            }
        }
        dVar2.cpD();
        AppMethodBeat.o(47158);
    }
}
