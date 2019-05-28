package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.d;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.List;

public final class a {
    private static ak feP = new ak(Looper.getMainLooper());

    public static class a {
        public ImageView ejo;
        public String iconUrl;
        public String username;
    }

    static {
        AppMethodBeat.i(13825);
        AppMethodBeat.o(13825);
    }

    public static d a(d dVar, uz uzVar) {
        if (uzVar != null) {
            dVar.field_brandFlag = uzVar.gvb;
            dVar.field_brandIconURL = uzVar.gve;
            dVar.field_brandInfo = uzVar.gvd;
            dVar.field_extInfo = uzVar.gvc;
        }
        return dVar;
    }

    public static Spanned b(Context context, String str, List<String> list) {
        AppMethodBeat.i(13822);
        Spanned spannableString;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(13822);
            return null;
        } else if (context == null || list == null) {
            spannableString = new SpannableString(str);
            AppMethodBeat.o(13822);
            return spannableString;
        } else {
            e a = f.a(com.tencent.mm.plugin.fts.a.a.d.a((CharSequence) str, (List) list));
            if (a.mDR instanceof Spannable) {
                Spannable spannable = (Spannable) a.mDR;
                AppMethodBeat.o(13822);
                return spannable;
            }
            spannableString = new SpannableString(a.mDR);
            AppMethodBeat.o(13822);
            return spannableString;
        }
    }

    public static boolean b(TextView textView, CharSequence charSequence) {
        AppMethodBeat.i(13823);
        if (textView == null) {
            AppMethodBeat.o(13823);
            return false;
        } else if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(13823);
            return false;
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence);
            AppMethodBeat.o(13823);
            return true;
        }
    }

    public static void a(ImageView imageView, ad adVar, String str, boolean z) {
        AppMethodBeat.i(13824);
        if (z || !com.tencent.mm.n.a.jh(adVar.field_type)) {
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePV = R.drawable.abh;
            aVar.ePG = true;
            aVar.eQf = true;
            o.ahp().a(str, imageView, aVar.ahG());
            AppMethodBeat.o(13824);
            return;
        }
        b.r(imageView, adVar.field_username);
        AppMethodBeat.o(13824);
    }
}
