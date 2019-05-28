package com.tencent.p177mm.plugin.brandservice.p926b;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45965e;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.C23452uz;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.b.a */
public final class C11188a {
    private static C7306ak feP = new C7306ak(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.brandservice.b.a$a */
    public static class C11189a {
        public ImageView ejo;
        public String iconUrl;
        public String username;
    }

    static {
        AppMethodBeat.m2504i(13825);
        AppMethodBeat.m2505o(13825);
    }

    /* renamed from: a */
    public static C16527d m18893a(C16527d c16527d, C23452uz c23452uz) {
        if (c23452uz != null) {
            c16527d.field_brandFlag = c23452uz.gvb;
            c16527d.field_brandIconURL = c23452uz.gve;
            c16527d.field_brandInfo = c23452uz.gvd;
            c16527d.field_extInfo = c23452uz.gvc;
        }
        return c16527d;
    }

    /* renamed from: b */
    public static Spanned m18895b(Context context, String str, List<String> list) {
        AppMethodBeat.m2504i(13822);
        Spanned spannableString;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(13822);
            return null;
        } else if (context == null || list == null) {
            spannableString = new SpannableString(str);
            AppMethodBeat.m2505o(13822);
            return spannableString;
        } else {
            C45965e a = C34204f.m56086a(C39127d.m66571a((CharSequence) str, (List) list));
            if (a.mDR instanceof Spannable) {
                Spannable spannable = (Spannable) a.mDR;
                AppMethodBeat.m2505o(13822);
                return spannable;
            }
            spannableString = new SpannableString(a.mDR);
            AppMethodBeat.m2505o(13822);
            return spannableString;
        }
    }

    /* renamed from: b */
    public static boolean m18896b(TextView textView, CharSequence charSequence) {
        AppMethodBeat.m2504i(13823);
        if (textView == null) {
            AppMethodBeat.m2505o(13823);
            return false;
        } else if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            AppMethodBeat.m2505o(13823);
            return false;
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence);
            AppMethodBeat.m2505o(13823);
            return true;
        }
    }

    /* renamed from: a */
    public static void m18894a(ImageView imageView, C7616ad c7616ad, String str, boolean z) {
        AppMethodBeat.m2504i(13824);
        if (z || !C7486a.m12942jh(c7616ad.field_type)) {
            C17927a c17927a = new C17927a();
            c17927a.ePV = C25738R.drawable.abh;
            c17927a.ePG = true;
            c17927a.eQf = true;
            C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
            AppMethodBeat.m2505o(13824);
            return;
        }
        C40460b.m69437r(imageView, c7616ad.field_username);
        AppMethodBeat.m2505o(13824);
    }
}
