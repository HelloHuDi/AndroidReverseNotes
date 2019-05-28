package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fav.p407a.C11851an;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C14724a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C44005b;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.f */
public final class C29989f {
    public static ArrayList<C44001c> iLD;
    private static String uPA;

    /* renamed from: c */
    public static void m47465c(Context context, ArrayList<C44001c> arrayList) {
        AppMethodBeat.m2504i(26770);
        if (iLD != null) {
            iLD.clear();
        }
        iLD = arrayList;
        HashSet hashSet = new HashSet();
        if (iLD != null) {
            Iterator it = iLD.iterator();
            while (it.hasNext()) {
                C44001c c44001c = (C44001c) it.next();
                String d = C29977c.m47429d(c44001c);
                if (!C5046bo.isNullOrNil(d)) {
                    hashSet.add(d);
                }
                String e = C29977c.m47430e(c44001c);
                if (!C5046bo.isNullOrNil(e)) {
                    hashSet.add(e);
                }
            }
        }
        C11851an.mgy = hashSet;
        StringBuilder stringBuilder = new StringBuilder("");
        if (iLD != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iLD.size()) {
                    break;
                }
                if (i2 != iLD.size() - 1) {
                    stringBuilder.append(C29977c.m47426a(context, (C44001c) iLD.get(i2))).append("<br/>");
                } else {
                    stringBuilder.append(C29977c.m47426a(context, (C44001c) iLD.get(i2)));
                }
                i = i2 + 1;
            }
        }
        uPA = C29977c.aho(stringBuilder.toString());
        ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setText(C14724a.ahb(uPA));
        }
        AppMethodBeat.m2505o(26770);
    }

    public static ArrayList<C44001c> deA() {
        AppMethodBeat.m2504i(26771);
        ArrayList<C44001c> arrayList = new ArrayList();
        if (iLD == null) {
            AppMethodBeat.m2505o(26771);
            return arrayList;
        }
        Iterator it = iLD.iterator();
        while (it.hasNext()) {
            Object obj;
            C44001c c = C29977c.m47428c((C44001c) it.next());
            if (c == null) {
                obj = null;
            } else {
                obj = 1;
                int type = c.getType();
                if (type == 2 || type == 6 || type == 4 || type == 5) {
                    String d = C29977c.m47429d(c);
                    if (C5046bo.isNullOrNil(d) || !C5730e.m8628ct(d)) {
                        obj = null;
                    }
                }
                if (type == 2 || type == 6) {
                    String e = C29977c.m47430e(c);
                    if (C5046bo.isNullOrNil(e) || !C5730e.m8628ct(e)) {
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                arrayList.add(c);
            }
        }
        AppMethodBeat.m2505o(26771);
        return arrayList;
    }

    public static void clearData() {
        AppMethodBeat.m2504i(26772);
        if (iLD != null) {
            iLD.clear();
        }
        uPA = "";
        C11851an.mgy = null;
        AppMethodBeat.m2505o(26772);
    }

    public static boolean deB() {
        AppMethodBeat.m2504i(26773);
        ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        if (clipboardManager.getText().length() >= 16384) {
            AppMethodBeat.m2505o(26773);
            return true;
        } else if (C29977c.ahm(clipboardManager.getText().toString()) >= 16384) {
            AppMethodBeat.m2505o(26773);
            return true;
        } else {
            AppMethodBeat.m2505o(26773);
            return false;
        }
    }

    public static int deC() {
        int i;
        AppMethodBeat.m2504i(26774);
        ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
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
            AppMethodBeat.m2505o(26774);
            return 1;
        } else if (i == 0 && i2 != 0) {
            AppMethodBeat.m2505o(26774);
            return 2;
        } else if (i != 0) {
            AppMethodBeat.m2505o(26774);
            return 3;
        } else {
            String a;
            String str = "";
            try {
                CharSequence text = clipboardManager.getText();
                if (text instanceof Spanned) {
                    a = C44005b.m78993a((Spanned) text);
                } else {
                    a = text.toString();
                }
            } catch (Exception e) {
                C4990ab.m7413e("WNNoteClipboardManager", "get clipboard data error : ", e);
                a = str;
            }
            if (a.equals(uPA)) {
                AppMethodBeat.m2505o(26774);
                return 3;
            }
            AppMethodBeat.m2505o(26774);
            return 2;
        }
    }
}
