package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class f {
    public static ArrayList<c> iLD;
    private static String uPA;

    public static void c(Context context, ArrayList<c> arrayList) {
        AppMethodBeat.i(26770);
        if (iLD != null) {
            iLD.clear();
        }
        iLD = arrayList;
        HashSet hashSet = new HashSet();
        if (iLD != null) {
            Iterator it = iLD.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                String d = com.tencent.mm.plugin.wenote.b.c.d(cVar);
                if (!bo.isNullOrNil(d)) {
                    hashSet.add(d);
                }
                String e = com.tencent.mm.plugin.wenote.b.c.e(cVar);
                if (!bo.isNullOrNil(e)) {
                    hashSet.add(e);
                }
            }
        }
        an.mgy = hashSet;
        StringBuilder stringBuilder = new StringBuilder("");
        if (iLD != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iLD.size()) {
                    break;
                }
                if (i2 != iLD.size() - 1) {
                    stringBuilder.append(com.tencent.mm.plugin.wenote.b.c.a(context, (c) iLD.get(i2))).append("<br/>");
                } else {
                    stringBuilder.append(com.tencent.mm.plugin.wenote.b.c.a(context, (c) iLD.get(i2)));
                }
                i = i2 + 1;
            }
        }
        uPA = com.tencent.mm.plugin.wenote.b.c.aho(stringBuilder.toString());
        ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setText(a.ahb(uPA));
        }
        AppMethodBeat.o(26770);
    }

    public static ArrayList<c> deA() {
        AppMethodBeat.i(26771);
        ArrayList<c> arrayList = new ArrayList();
        if (iLD == null) {
            AppMethodBeat.o(26771);
            return arrayList;
        }
        Iterator it = iLD.iterator();
        while (it.hasNext()) {
            Object obj;
            c c = com.tencent.mm.plugin.wenote.b.c.c((c) it.next());
            if (c == null) {
                obj = null;
            } else {
                obj = 1;
                int type = c.getType();
                if (type == 2 || type == 6 || type == 4 || type == 5) {
                    String d = com.tencent.mm.plugin.wenote.b.c.d(c);
                    if (bo.isNullOrNil(d) || !e.ct(d)) {
                        obj = null;
                    }
                }
                if (type == 2 || type == 6) {
                    String e = com.tencent.mm.plugin.wenote.b.c.e(c);
                    if (bo.isNullOrNil(e) || !e.ct(e)) {
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                arrayList.add(c);
            }
        }
        AppMethodBeat.o(26771);
        return arrayList;
    }

    public static void clearData() {
        AppMethodBeat.i(26772);
        if (iLD != null) {
            iLD.clear();
        }
        uPA = "";
        an.mgy = null;
        AppMethodBeat.o(26772);
    }

    public static boolean deB() {
        AppMethodBeat.i(26773);
        ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        if (clipboardManager.getText().length() >= 16384) {
            AppMethodBeat.o(26773);
            return true;
        } else if (com.tencent.mm.plugin.wenote.b.c.ahm(clipboardManager.getText().toString()) >= 16384) {
            AppMethodBeat.o(26773);
            return true;
        } else {
            AppMethodBeat.o(26773);
            return false;
        }
    }

    public static int deC() {
        int i;
        AppMethodBeat.i(26774);
        ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        if (clipboardManager == null || clipboardManager.getText() == null || clipboardManager.getText().length() <= 0) {
            i = 1;
        } else {
            i = 0;
        }
        int i2;
        if (iLD == null || iLD.size() <= 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i != 0 && i2 != 0) {
            AppMethodBeat.o(26774);
            return 1;
        } else if (i == 0 && i2 != 0) {
            AppMethodBeat.o(26774);
            return 2;
        } else if (i != 0) {
            AppMethodBeat.o(26774);
            return 3;
        } else {
            String a;
            String str = "";
            try {
                CharSequence text = clipboardManager.getText();
                if (text instanceof Spanned) {
                    a = b.a((Spanned) text);
                } else {
                    a = text.toString();
                }
            } catch (Exception e) {
                ab.e("WNNoteClipboardManager", "get clipboard data error : ", e);
                a = str;
            }
            if (a.equals(uPA)) {
                AppMethodBeat.o(26774);
                return 3;
            }
            AppMethodBeat.o(26774);
            return 2;
        }
    }
}
