package com.tencent.mm.platformtools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Map;

public final class j {
    public static j ghe = new j();
    private Map<String, String> ghf;

    static {
        AppMethodBeat.i(124534);
        AppMethodBeat.o(124534);
    }

    public final Map<String, String> cl(Context context) {
        AppMethodBeat.i(124533);
        try {
            String I = bo.I(context.getAssets().open("config/EmailAddress.xml"));
            if (bo.isNullOrNil(I)) {
                AppMethodBeat.o(124533);
                return null;
            }
            Map z = br.z(I, "config");
            Map<String, String> map;
            if (z == null || z.isEmpty()) {
                ab.d("MicroMsg.EmailFormater", "values null");
                AppMethodBeat.o(124533);
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
                        if (!(bo.isNullOrNil(I) || bo.isNullOrNil(str))) {
                            this.ghf.put(I, str);
                        }
                        i++;
                    } else {
                        map = this.ghf;
                        AppMethodBeat.o(124533);
                        return map;
                    }
                }
            } else {
                map = this.ghf;
                AppMethodBeat.o(124533);
                return map;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.EmailFormater", "parse email failed:[%s]", e.getMessage());
            AppMethodBeat.o(124533);
            return null;
        }
    }
}
