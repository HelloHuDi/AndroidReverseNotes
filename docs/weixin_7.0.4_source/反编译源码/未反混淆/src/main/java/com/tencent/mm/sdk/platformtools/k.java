package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class k {
    public static void a(Context context, Intent intent, Uri uri, String str) {
        AppMethodBeat.i(93388);
        if (uri.getScheme().equals("file")) {
            a(context, intent, new File(uri.getPath()), str);
            AppMethodBeat.o(93388);
            return;
        }
        if (d.iW(24)) {
            intent.setDataAndType(uri, str);
            intent.addFlags(1);
        }
        AppMethodBeat.o(93388);
    }

    public static void a(Context context, Intent intent, File file, String str) {
        AppMethodBeat.i(93389);
        if (d.iW(24)) {
            intent.setDataAndType(d(context, file), str);
            intent.addFlags(1);
            AppMethodBeat.o(93389);
            return;
        }
        intent.setDataAndType(Uri.fromFile(file), str);
        AppMethodBeat.o(93389);
    }

    public static ArrayList<Uri> d(Context context, ArrayList<Uri> arrayList) {
        AppMethodBeat.i(93390);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(d(context, new File(((Uri) it.next()).getPath())));
        }
        AppMethodBeat.o(93390);
        return arrayList2;
    }

    public static Uri d(Context context, File file) {
        Uri e;
        AppMethodBeat.i(93391);
        if (d.iW(24)) {
            e = e(context, file);
        } else {
            e = Uri.fromFile(file);
        }
        AppMethodBeat.o(93391);
        return e;
    }

    private static Uri e(Context context, File file) {
        AppMethodBeat.i(93392);
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".external.fileprovider", file);
        AppMethodBeat.o(93392);
        return uriForFile;
    }
}
