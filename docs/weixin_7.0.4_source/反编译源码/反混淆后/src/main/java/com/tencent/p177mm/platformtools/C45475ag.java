package com.tencent.p177mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.platformtools.ag */
public final class C45475ag {
    public final int action;
    public final String content;
    public final int cvG;
    public final int errorCode;
    public final int gjG;
    public final String title;
    public final int type;
    public final String url;

    public C45475ag(int i, int i2, String str) {
        int intValue;
        int intValue2;
        int intValue3;
        String str2;
        String str3;
        Exception e;
        AppMethodBeat.m2504i(124594);
        String str4 = "";
        int i3 = 5;
        String str5 = "";
        String str6 = "";
        try {
            Map z = C5049br.m7595z(str, "e");
            if (z == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("values == null");
                AppMethodBeat.m2505o(124594);
                throw illegalArgumentException;
            }
            intValue = Integer.valueOf((String) z.get(".e.ShowType")).intValue();
            try {
                intValue2 = Integer.valueOf((String) z.get(".e.Action")).intValue();
                try {
                    intValue3 = Integer.valueOf((String) z.get(".e.DispSec")).intValue();
                    try {
                        str2 = (String) z.get(".e.Title");
                        try {
                            str3 = (String) z.get(".e.Url");
                            try {
                                str4 = (String) z.get(".e.Content");
                            } catch (Exception e2) {
                                e = e2;
                                i3 = intValue3;
                                C4990ab.m7412e("MicroMsg.UnifyErrorProcessor", e.toString());
                                intValue3 = i3;
                                this.errorCode = i2;
                                this.cvG = i;
                                this.type = intValue;
                                this.action = intValue2;
                                this.content = str4;
                                this.gjG = intValue3;
                                this.title = str2;
                                this.url = str3;
                                AppMethodBeat.m2505o(124594);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str3 = str5;
                            i3 = intValue3;
                            C4990ab.m7412e("MicroMsg.UnifyErrorProcessor", e.toString());
                            intValue3 = i3;
                            this.errorCode = i2;
                            this.cvG = i;
                            this.type = intValue;
                            this.action = intValue2;
                            this.content = str4;
                            this.gjG = intValue3;
                            this.title = str2;
                            this.url = str3;
                            AppMethodBeat.m2505o(124594);
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str2 = str6;
                        str3 = str5;
                        i3 = intValue3;
                        C4990ab.m7412e("MicroMsg.UnifyErrorProcessor", e.toString());
                        intValue3 = i3;
                        this.errorCode = i2;
                        this.cvG = i;
                        this.type = intValue;
                        this.action = intValue2;
                        this.content = str4;
                        this.gjG = intValue3;
                        this.title = str2;
                        this.url = str3;
                        AppMethodBeat.m2505o(124594);
                    }
                } catch (Exception e5) {
                    e = e5;
                    str2 = str6;
                    str3 = str5;
                }
            } catch (Exception e52) {
                e = e52;
                str2 = str6;
                str3 = str5;
                intValue2 = 0;
            }
            this.errorCode = i2;
            this.cvG = i;
            this.type = intValue;
            this.action = intValue2;
            this.content = str4;
            this.gjG = intValue3;
            this.title = str2;
            this.url = str3;
            AppMethodBeat.m2505o(124594);
        } catch (Exception e522) {
            e = e522;
            str2 = str6;
            str3 = str5;
            intValue2 = 0;
            intValue = 0;
        }
    }
}
