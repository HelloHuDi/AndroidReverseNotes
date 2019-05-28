package com.tencent.p177mm.plugin.ipcall.p438a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21085e;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C43225f;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.ipcall.a.e */
public final class C43221e {
    private static C43221e nvv = null;
    C4884c gyU = new C432221();
    public ArrayList<C43225f> nvw = null;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.e$1 */
    class C432221 extends C4884c<C32519bf> {
        C432221() {
            AppMethodBeat.m2504i(21734);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(21734);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(21735);
            C32519bf c32519bf = (C32519bf) c4883b;
            if (c32519bf.cus.cut == 39) {
                C4990ab.m7416i("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener callback");
                byte[] f = C1173e.m2571f(c32519bf.cus.filePath, 0, -1);
                if (f != null) {
                    C43221e.this.mo68729aX(f);
                } else {
                    C4990ab.m7412e("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener file not exist");
                }
            }
            AppMethodBeat.m2505o(21735);
            return false;
        }
    }

    private C43221e() {
        AppMethodBeat.m2504i(21736);
        AppMethodBeat.m2505o(21736);
    }

    public static C43221e bHj() {
        AppMethodBeat.m2504i(21737);
        if (nvv == null) {
            nvv = new C43221e();
        }
        C43221e c43221e = nvv;
        AppMethodBeat.m2505o(21737);
        return c43221e;
    }

    /* renamed from: aX */
    public final boolean mo68729aX(byte[] bArr) {
        AppMethodBeat.m2504i(21738);
        try {
            try {
                Map z = C5049br.m7595z(new String(bArr), "feedbackconfig");
                if (z != null) {
                    String str = ".feedbackconfig.resourceslist.resources";
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        String str2 = str + (i == 0 ? "" : Integer.valueOf(i));
                        String str3 = (String) z.get(str2 + ".$langid");
                        if (str3 != null) {
                            int i2 = i + 1;
                            C43225f c43225f = new C43225f();
                            c43225f.nzA = str3;
                            c43225f.nzB = new ArrayList();
                            String str4 = str2 + ".string";
                            int i3 = 0;
                            while (true) {
                                C21085e c21085e = new C21085e();
                                String str5 = str4 + (i3 == 0 ? "" : Integer.valueOf(i3));
                                str3 = (String) z.get(str5);
                                if (str3 == null) {
                                    break;
                                }
                                str5 = (String) z.get(str5 + ".$id");
                                if (str5 == null) {
                                    break;
                                }
                                i3++;
                                c21085e.f4385Id = str5;
                                c21085e.nzz = str3;
                                c43225f.nzB.add(c21085e);
                            }
                            C4990ab.m7411d("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse id:%s,wording count:%d", c43225f.nzA, Integer.valueOf(c43225f.nzB.size()));
                            arrayList.add(c43225f);
                            i = i2;
                        } else {
                            C4990ab.m7417i("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse finished count:%d", Integer.valueOf(arrayList.size()));
                            this.nvw = arrayList;
                            AppMethodBeat.m2505o(21738);
                            return true;
                        }
                    }
                }
                C4990ab.m7412e("MicroMsg.IPCallFeedbackConfigUpdater", "parse xml feedbackconfig error");
                AppMethodBeat.m2505o(21738);
                return false;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config error: %s", e.getMessage());
                AppMethodBeat.m2505o(21738);
                return false;
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e2, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config new string error: %s", e2.getMessage());
            AppMethodBeat.m2505o(21738);
            return false;
        }
    }
}
