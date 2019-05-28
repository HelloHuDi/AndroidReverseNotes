package com.tencent.p177mm.plugin.appbrand.p329s;

import android.net.Uri;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.s.s */
public final class C38508s {
    /* renamed from: a */
    public static String m65176a(C41243o c41243o, String str, String str2) {
        AppMethodBeat.m2504i(133591);
        Uri parse = Uri.parse(str2);
        String path;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(C4996ah.getContext().getContentResolver().openInputStream(parse));
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
                C1173e.copyStream(bufferedInputStream, fileOutputStream);
                C19681j c19681j = new C19681j();
                c41243o.atG().mo5835a(new File(absolutePath), path, true, c19681j);
                C17675v.closeQuietly(bufferedInputStream);
                C17675v.closeQuietly(fileOutputStream);
                path = (String) c19681j.value;
                AppMethodBeat.m2505o(133591);
                return path;
            } catch (FileNotFoundException e) {
                C45124d.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", e, "", new Object[0]);
                path = "";
                AppMethodBeat.m2505o(133591);
                return path;
            }
        } catch (FileNotFoundException e2) {
            C45124d.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", e2, "", new Object[0]);
            path = "";
            AppMethodBeat.m2505o(133591);
            return path;
        } catch (Exception e3) {
            C45124d.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", e3, "", new Object[0]);
            path = "";
            AppMethodBeat.m2505o(133591);
            return path;
        }
    }

    /* renamed from: Ek */
    public static boolean m65174Ek(String str) {
        AppMethodBeat.m2504i(133592);
        if (str == null || !str.startsWith("content://")) {
            AppMethodBeat.m2505o(133592);
            return false;
        }
        AppMethodBeat.m2505o(133592);
        return true;
    }

    /* renamed from: El */
    public static boolean m65175El(String str) {
        AppMethodBeat.m2504i(133593);
        try {
            JSONArray jSONArray = new JSONArray(str);
            AppMethodBeat.m2505o(133593);
            return true;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(133593);
            return false;
        }
    }
}
