package com.tencent.mm.plugin.appbrand.s;

import android.net.Uri;
import com.google.android.exoplayer2.i.v;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.json.JSONArray;
import org.json.JSONException;

public final class s {
    public static String a(o oVar, String str, String str2) {
        AppMethodBeat.i(133591);
        Uri parse = Uri.parse(str2);
        String path;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(ah.getContext().getContentResolver().openInputStream(parse));
            path = parse.getPath();
            int indexOf = path.indexOf(46);
            if (indexOf != -1) {
                path = path.substring(indexOf);
            } else {
                path = "";
            }
            String absolutePath = new File(str, "opensdkfile_" + System.currentTimeMillis() + "." + path).getAbsolutePath();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(absolutePath));
                e.copyStream(bufferedInputStream, fileOutputStream);
                j jVar = new j();
                oVar.atG().a(new File(absolutePath), path, true, jVar);
                v.closeQuietly(bufferedInputStream);
                v.closeQuietly(fileOutputStream);
                path = (String) jVar.value;
                AppMethodBeat.o(133591);
                return path;
            } catch (FileNotFoundException e) {
                d.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", e, "", new Object[0]);
                path = "";
                AppMethodBeat.o(133591);
                return path;
            }
        } catch (FileNotFoundException e2) {
            d.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", e2, "", new Object[0]);
            path = "";
            AppMethodBeat.o(133591);
            return path;
        } catch (Exception e3) {
            d.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", e3, "", new Object[0]);
            path = "";
            AppMethodBeat.o(133591);
            return path;
        }
    }

    public static boolean Ek(String str) {
        AppMethodBeat.i(133592);
        if (str == null || !str.startsWith("content://")) {
            AppMethodBeat.o(133592);
            return false;
        }
        AppMethodBeat.o(133592);
        return true;
    }

    public static boolean El(String str) {
        AppMethodBeat.i(133593);
        try {
            JSONArray jSONArray = new JSONArray(str);
            AppMethodBeat.o(133593);
            return true;
        } catch (JSONException e) {
            AppMethodBeat.o(133593);
            return false;
        }
    }
}
