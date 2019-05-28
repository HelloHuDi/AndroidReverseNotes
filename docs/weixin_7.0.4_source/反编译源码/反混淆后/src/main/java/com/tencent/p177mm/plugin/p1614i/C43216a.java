package com.tencent.p177mm.plugin.p1614i;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.UnsupportedEncodingException;

/* renamed from: com.tencent.mm.plugin.i.a */
public final class C43216a {
    public String cvZ;
    public int nuA;
    public int nuB;
    public int nuC;
    public int nuD;
    public String nuw;
    public String nux;
    public int nuy;
    public int nuz;

    /* renamed from: cv */
    public static String m76861cv(String str) {
        AppMethodBeat.m2504i(79092);
        byte[] e = C5730e.m8632e(str, 0, 6);
        String str2;
        if (e == null || e.length != 6) {
            str2 = "";
            AppMethodBeat.m2505o(79092);
            return str2;
        }
        String str3 = "";
        try {
            str2 = new String(e, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C4990ab.m7412e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:".concat(String.valueOf(e2)));
            str2 = str3;
        }
        AppMethodBeat.m2505o(79092);
        return str2;
    }

    /* renamed from: OK */
    public static String m76860OK(String str) {
        AppMethodBeat.m2504i(79093);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(79093);
            return str2;
        }
        str2 = str.replace(",", ";");
        AppMethodBeat.m2505o(79093);
        return str2;
    }

    /* renamed from: tF */
    public static int m76862tF(String str) {
        AppMethodBeat.m2504i(79094);
        try {
            Options amj = C5056d.amj(str);
            if (amj == null) {
                AppMethodBeat.m2505o(79094);
                return 0;
            }
            String str2 = amj.outMimeType;
            if (str2 == null) {
                AppMethodBeat.m2505o(79094);
                return 0;
            }
            str2 = str2.toLowerCase();
            if (str2.indexOf("png") >= 0) {
                AppMethodBeat.m2505o(79094);
                return 1;
            } else if (str2.indexOf("jpg") >= 0) {
                AppMethodBeat.m2505o(79094);
                return 2;
            } else if (str2.indexOf("jpeg") >= 0) {
                AppMethodBeat.m2505o(79094);
                return 2;
            } else {
                AppMethodBeat.m2505o(79094);
                return 0;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(79094);
            return 0;
        }
    }
}
