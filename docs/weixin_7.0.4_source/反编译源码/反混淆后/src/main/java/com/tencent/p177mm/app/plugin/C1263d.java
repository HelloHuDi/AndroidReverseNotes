package com.tencent.p177mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.C46500q;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23314l;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C46505a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.tencent.mm.app.plugin.d */
public final class C1263d implements C46500q {

    /* renamed from: com.tencent.mm.app.plugin.d$1 */
    class C12641 implements Comparator<C14932m> {
        C12641() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C14932m c14932m = (C14932m) obj2;
            int i = ((C14932m) obj).start;
            int i2 = c14932m.start;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: x */
    public final String mo4550x(Context context, String str) {
        AppMethodBeat.m2504i(15619);
        ArrayList bB = C46505a.m87788bB(context, str);
        if (bB.size() == 0) {
            AppMethodBeat.m2505o(15619);
        } else {
            Collections.sort(bB, new C12641());
            Iterator it = bB.iterator();
            String str2 = str;
            while (it.hasNext()) {
                String format;
                C14932m c14932m = (C14932m) it.next();
                String str3 = null;
                int i = c14932m.start;
                int i2 = c14932m.end;
                switch (c14932m.type) {
                    case 1:
                        str3 = "<a href=\"%s\">%s</a>";
                        break;
                    case 24:
                        str3 = "<a href=\"%s@mailto@\">%s</a>";
                        break;
                    case 25:
                        str3 = "<a href=\"%s@tel@\">%s</a>";
                        break;
                }
                if (str3 != null) {
                    String str4 = c14932m.url;
                    if (c14932m.type != 1 || str4.startsWith("http://")) {
                        format = String.format(str3, new Object[]{str4.trim(), str4.trim()});
                    } else {
                        format = String.format(str3, new Object[]{"http://" + str4.trim(), str4.trim()});
                    }
                    format = C1263d.m2711a(str2, i, i2, format);
                    if (format.length() == 0) {
                        C4990ab.m7411d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", str);
                        AppMethodBeat.m2505o(15619);
                    }
                } else {
                    format = str2;
                }
                str2 = format;
            }
            str = str2;
            C4990ab.m7411d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", str);
            AppMethodBeat.m2505o(15619);
        }
        return str;
    }

    /* renamed from: a */
    private static String m2711a(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(15620);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || i >= i2) {
            AppMethodBeat.m2505o(15620);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(str.subSequence(0, i + 0));
            stringBuilder.append(str2);
            stringBuilder.append(str.subSequence(i2 + 0, str.length()));
            str2.length();
            str = stringBuilder.toString();
            AppMethodBeat.m2505o(15620);
            return str;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.QrCodeURLHelper", e.getMessage());
            str = "";
            AppMethodBeat.m2505o(15620);
            return str;
        }
    }

    /* renamed from: a */
    public final boolean mo4548a(Context context, String str, OnDismissListener onDismissListener) {
        AppMethodBeat.m2504i(15621);
        C4990ab.m7411d("MicroMsg.QrCodeURLHelper", "tryHandleEvents, url:%s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(15621);
            return false;
        }
        if (str.endsWith("@mailto@")) {
            C23314l.m35798b(context, str.substring(0, str.length() - 8), onDismissListener);
        } else if (str.endsWith("@tel@")) {
            String substring = str.substring(0, str.length() - 5);
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 3);
            C23314l.m35797a(context, substring, onDismissListener, bundle);
        } else {
            AppMethodBeat.m2505o(15621);
            return false;
        }
        AppMethodBeat.m2505o(15621);
        return true;
    }

    /* renamed from: dq */
    public final boolean mo4549dq(String str) {
        AppMethodBeat.m2504i(15622);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(15622);
            return false;
        } else if (str.endsWith("@mailto@") || str.endsWith("@tel@")) {
            AppMethodBeat.m2505o(15622);
            return true;
        } else {
            AppMethodBeat.m2505o(15622);
            return false;
        }
    }
}
