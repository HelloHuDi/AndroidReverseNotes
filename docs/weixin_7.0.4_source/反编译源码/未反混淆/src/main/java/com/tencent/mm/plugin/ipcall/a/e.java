package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.Map;

public final class e {
    private static e nvv = null;
    c gyU = new c<bf>() {
        {
            AppMethodBeat.i(21734);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(21734);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(21735);
            bf bfVar = (bf) bVar;
            if (bfVar.cus.cut == 39) {
                ab.i("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener callback");
                byte[] f = com.tencent.mm.a.e.f(bfVar.cus.filePath, 0, -1);
                if (f != null) {
                    e.this.aX(f);
                } else {
                    ab.e("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener file not exist");
                }
            }
            AppMethodBeat.o(21735);
            return false;
        }
    };
    public ArrayList<f> nvw = null;

    private e() {
        AppMethodBeat.i(21736);
        AppMethodBeat.o(21736);
    }

    public static e bHj() {
        AppMethodBeat.i(21737);
        if (nvv == null) {
            nvv = new e();
        }
        e eVar = nvv;
        AppMethodBeat.o(21737);
        return eVar;
    }

    public final boolean aX(byte[] bArr) {
        AppMethodBeat.i(21738);
        try {
            try {
                Map z = br.z(new String(bArr), "feedbackconfig");
                if (z != null) {
                    String str = ".feedbackconfig.resourceslist.resources";
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        String str2 = str + (i == 0 ? "" : Integer.valueOf(i));
                        String str3 = (String) z.get(str2 + ".$langid");
                        if (str3 != null) {
                            int i2 = i + 1;
                            f fVar = new f();
                            fVar.nzA = str3;
                            fVar.nzB = new ArrayList();
                            String str4 = str2 + ".string";
                            int i3 = 0;
                            while (true) {
                                com.tencent.mm.plugin.ipcall.a.g.e eVar = new com.tencent.mm.plugin.ipcall.a.g.e();
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
                                eVar.Id = str5;
                                eVar.nzz = str3;
                                fVar.nzB.add(eVar);
                            }
                            ab.d("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse id:%s,wording count:%d", fVar.nzA, Integer.valueOf(fVar.nzB.size()));
                            arrayList.add(fVar);
                            i = i2;
                        } else {
                            ab.i("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse finished count:%d", Integer.valueOf(arrayList.size()));
                            this.nvw = arrayList;
                            AppMethodBeat.o(21738);
                            return true;
                        }
                    }
                }
                ab.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse xml feedbackconfig error");
                AppMethodBeat.o(21738);
                return false;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e, "", new Object[0]);
                ab.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config error: %s", e.getMessage());
                AppMethodBeat.o(21738);
                return false;
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e2, "", new Object[0]);
            ab.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config new string error: %s", e2.getMessage());
            AppMethodBeat.o(21738);
            return false;
        }
    }
}
