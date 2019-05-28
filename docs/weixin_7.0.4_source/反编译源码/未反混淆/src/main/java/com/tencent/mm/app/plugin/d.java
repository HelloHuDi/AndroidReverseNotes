package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.e.a;
import com.tencent.mm.pluginsdk.ui.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class d implements q {
    public final String x(Context context, String str) {
        AppMethodBeat.i(15619);
        ArrayList bB = a.bB(context, str);
        if (bB.size() == 0) {
            AppMethodBeat.o(15619);
        } else {
            Collections.sort(bB, new Comparator<m>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    m mVar = (m) obj2;
                    int i = ((m) obj).start;
                    int i2 = mVar.start;
                    if (i < i2) {
                        return -1;
                    }
                    if (i > i2) {
                        return 1;
                    }
                    return 0;
                }
            });
            Iterator it = bB.iterator();
            String str2 = str;
            while (it.hasNext()) {
                String format;
                m mVar = (m) it.next();
                String str3 = null;
                int i = mVar.start;
                int i2 = mVar.end;
                switch (mVar.type) {
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
                    String str4 = mVar.url;
                    if (mVar.type != 1 || str4.startsWith("http://")) {
                        format = String.format(str3, new Object[]{str4.trim(), str4.trim()});
                    } else {
                        format = String.format(str3, new Object[]{"http://" + str4.trim(), str4.trim()});
                    }
                    format = a(str2, i, i2, format);
                    if (format.length() == 0) {
                        ab.d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", str);
                        AppMethodBeat.o(15619);
                    }
                } else {
                    format = str2;
                }
                str2 = format;
            }
            str = str2;
            ab.d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", str);
            AppMethodBeat.o(15619);
        }
        return str;
    }

    private static String a(String str, int i, int i2, String str2) {
        AppMethodBeat.i(15620);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || i >= i2) {
            AppMethodBeat.o(15620);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(str.subSequence(0, i + 0));
            stringBuilder.append(str2);
            stringBuilder.append(str.subSequence(i2 + 0, str.length()));
            str2.length();
            str = stringBuilder.toString();
            AppMethodBeat.o(15620);
            return str;
        } catch (Exception e) {
            ab.e("MicroMsg.QrCodeURLHelper", e.getMessage());
            str = "";
            AppMethodBeat.o(15620);
            return str;
        }
    }

    public final boolean a(Context context, String str, OnDismissListener onDismissListener) {
        AppMethodBeat.i(15621);
        ab.d("MicroMsg.QrCodeURLHelper", "tryHandleEvents, url:%s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(15621);
            return false;
        }
        if (str.endsWith("@mailto@")) {
            l.b(context, str.substring(0, str.length() - 8), onDismissListener);
        } else if (str.endsWith("@tel@")) {
            String substring = str.substring(0, str.length() - 5);
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 3);
            l.a(context, substring, onDismissListener, bundle);
        } else {
            AppMethodBeat.o(15621);
            return false;
        }
        AppMethodBeat.o(15621);
        return true;
    }

    public final boolean dq(String str) {
        AppMethodBeat.i(15622);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(15622);
            return false;
        } else if (str.endsWith("@mailto@") || str.endsWith("@tel@")) {
            AppMethodBeat.o(15622);
            return true;
        } else {
            AppMethodBeat.o(15622);
            return false;
        }
    }
}
