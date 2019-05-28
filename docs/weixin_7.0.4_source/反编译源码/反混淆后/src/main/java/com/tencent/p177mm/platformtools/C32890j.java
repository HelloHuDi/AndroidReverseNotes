package com.tencent.p177mm.platformtools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.platformtools.j */
public final class C32890j {
    public static C32890j ghe = new C32890j();
    private Map<String, String> ghf;

    static {
        AppMethodBeat.m2504i(124534);
        AppMethodBeat.m2505o(124534);
    }

    /* renamed from: cl */
    public final Map<String, String> mo53458cl(Context context) {
        AppMethodBeat.m2504i(124533);
        try {
            String I = C5046bo.m7504I(context.getAssets().open("config/EmailAddress.xml"));
            if (C5046bo.isNullOrNil(I)) {
                AppMethodBeat.m2505o(124533);
                return null;
            }
            Map z = C5049br.m7595z(I, "config");
            Map<String, String> map;
            if (z == null || z.isEmpty()) {
                C4990ab.m7410d("MicroMsg.EmailFormater", "values null");
                AppMethodBeat.m2505o(124533);
                return null;
            } else if (this.ghf == null) {
                this.ghf = new HashMap();
                int i = 0;
                while (true) {
                    I = ".config.format" + (i == 0 ? "" : Integer.valueOf(i));
                    if (z.get(I) != null) {
                        String str = I + ".emaildomain";
                        String str2 = I + ".loginpage";
                        I = (String) z.get(str);
                        str = (String) z.get(str2);
                        if (!(C5046bo.isNullOrNil(I) || C5046bo.isNullOrNil(str))) {
                            this.ghf.put(I, str);
                        }
                        i++;
                    } else {
                        map = this.ghf;
                        AppMethodBeat.m2505o(124533);
                        return map;
                    }
                }
            } else {
                map = this.ghf;
                AppMethodBeat.m2505o(124533);
                return map;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.EmailFormater", "parse email failed:[%s]", e.getMessage());
            AppMethodBeat.m2505o(124533);
            return null;
        }
    }
}
