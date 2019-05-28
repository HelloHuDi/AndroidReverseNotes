package com.tencent.p177mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.p057v4.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.sdk.platformtools.k */
public final class C15429k {
    /* renamed from: a */
    public static void m23712a(Context context, Intent intent, Uri uri, String str) {
        AppMethodBeat.m2504i(93388);
        if (uri.getScheme().equals("file")) {
            C15429k.m23713a(context, intent, new File(uri.getPath()), str);
            AppMethodBeat.m2505o(93388);
            return;
        }
        if (C1443d.m3068iW(24)) {
            intent.setDataAndType(uri, str);
            intent.addFlags(1);
        }
        AppMethodBeat.m2505o(93388);
    }

    /* renamed from: a */
    public static void m23713a(Context context, Intent intent, File file, String str) {
        AppMethodBeat.m2504i(93389);
        if (C1443d.m3068iW(24)) {
            intent.setDataAndType(C15429k.m23714d(context, file), str);
            intent.addFlags(1);
            AppMethodBeat.m2505o(93389);
            return;
        }
        intent.setDataAndType(Uri.fromFile(file), str);
        AppMethodBeat.m2505o(93389);
    }

    /* renamed from: d */
    public static ArrayList<Uri> m23715d(Context context, ArrayList<Uri> arrayList) {
        AppMethodBeat.m2504i(93390);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(C15429k.m23714d(context, new File(((Uri) it.next()).getPath())));
        }
        AppMethodBeat.m2505o(93390);
        return arrayList2;
    }

    /* renamed from: d */
    public static Uri m23714d(Context context, File file) {
        Uri e;
        AppMethodBeat.m2504i(93391);
        if (C1443d.m3068iW(24)) {
            e = C15429k.m23716e(context, file);
        } else {
            e = Uri.fromFile(file);
        }
        AppMethodBeat.m2505o(93391);
        return e;
    }

    /* renamed from: e */
    private static Uri m23716e(Context context, File file) {
        AppMethodBeat.m2504i(93392);
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".external.fileprovider", file);
        AppMethodBeat.m2505o(93392);
        return uriForFile;
    }
}
