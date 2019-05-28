package com.tencent.p177mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C32636th;
import com.tencent.p177mm.p230g.p231a.C37802ti;
import com.tencent.p177mm.p230g.p231a.C45372tj;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.translate.p1308a.C36832c;
import com.tencent.p177mm.plugin.translate.p1308a.C36832c.C22444a;
import com.tencent.p177mm.plugin.translate.p1308a.C36832c.C29474b;
import com.tencent.p177mm.plugin.translate.p1308a.C36832c.C36833c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.translate.a */
public final class C43713a implements C1816at {
    C7306ak handler = new C7306ak(Looper.getMainLooper());
    C36832c sKl = C29474b.sKz;
    C23498az sKm = new C23498az(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    private C22444a sKn = new C437141();
    private C4884c sKo = new C400142();
    private C4884c sKp = new C437153();

    /* renamed from: com.tencent.mm.plugin.translate.a$2 */
    class C400142 extends C4884c<C32636th> {
        C400142() {
            AppMethodBeat.m2504i(26051);
            this.xxI = C32636th.class.getName().hashCode();
            AppMethodBeat.m2505o(26051);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26052);
            final C32636th c32636th = (C32636th) c4883b;
            C4990ab.m7410d("MicroMsg.SubCoreTranslate", "recieve one translate request");
            C43713a.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(26050);
                    C36832c c36832c = C43713a.this.sKl;
                    String str = c32636th.cPy.cPz;
                    String str2 = c32636th.cPy.f15020id;
                    int i = c32636th.cPy.type;
                    String str3 = c32636th.cPy.source;
                    boolean z = c32636th.cPy.cPA;
                    byte[] bArr = c32636th.cPy.cPB;
                    C4990ab.m7411d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", str2, Integer.valueOf(i));
                    if (c36832c.abQ(str2)) {
                        C4990ab.m7411d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", str2);
                        AppMethodBeat.m2505o(26050);
                        return;
                    }
                    C36833c c36833c = new C36833c(str, str2, i, str3, bArr);
                    if (z) {
                        ((LinkedList) c36832c.sKx).add(0, c36833c);
                    } else {
                        c36832c.sKx.add(c36833c);
                    }
                    c36832c.sKy.put(c36833c.f15476id, Integer.valueOf(c36833c.sKB));
                    C4990ab.m7411d("MicroMsg.TranslateServiceManager", "requestCount : %s", Integer.valueOf(c36832c.exv));
                    c36832c.cHI();
                    AppMethodBeat.m2505o(26050);
                }
            });
            AppMethodBeat.m2505o(26052);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.translate.a$1 */
    class C437141 implements C22444a {
        C437141() {
        }

        /* renamed from: a */
        public final void mo37993a(final int i, SparseArray<C36833c> sparseArray) {
            AppMethodBeat.m2504i(26049);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < sparseArray.size()) {
                    final C36833c c36833c = (C36833c) sparseArray.valueAt(i3);
                    if (c36833c != null) {
                        C43713a.this.sKm.mo39163e(new C23499a() {
                            public final boolean acg() {
                                AppMethodBeat.m2504i(26047);
                                int i = i != 0 ? i : c36833c.ret;
                                C45372tj c45372tj = new C45372tj();
                                c45372tj.cPF.ret = i;
                                c45372tj.cPF.cPz = c36833c.cPz;
                                c45372tj.cPF.f17878id = c36833c.f15476id;
                                c45372tj.cPF.cPG = c36833c.cPG;
                                c45372tj.cPF.type = c36833c.type;
                                c45372tj.cPF.source = c36833c.source;
                                c45372tj.cPF.cNS = c36833c.cNS;
                                C4879a.xxA.mo10055m(c45372tj);
                                AppMethodBeat.m2505o(26047);
                                return false;
                            }

                            public final boolean acf() {
                                AppMethodBeat.m2504i(26048);
                                C4990ab.m7411d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", c36833c.f15476id);
                                if (i != 0) {
                                    C4990ab.m7412e("MicroMsg.SubCoreTranslate", "translate error");
                                    AppMethodBeat.m2505o(26048);
                                } else if (c36833c.ret != 0) {
                                    C4990ab.m7413e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", Integer.valueOf(c36833c.ret));
                                    AppMethodBeat.m2505o(26048);
                                } else if (C5046bo.isNullOrNil(c36833c.cPG)) {
                                    C4990ab.m7412e("MicroMsg.SubCoreTranslate", "translate return null");
                                    AppMethodBeat.m2505o(26048);
                                } else {
                                    if (c36833c.type == 0 || c36833c.type == 1) {
                                        C4990ab.m7410d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                                        C36833c c36833c = c36833c;
                                        C9638aw.m17190ZK();
                                        C7620bi jf = C18628c.m29080XO().mo15340jf(C5046bo.anl(c36833c.f15476id));
                                        jf.mo14797jx(C5046bo.m7586vA(c36833c.cPG));
                                        jf.field_transBrandWording = C5046bo.m7586vA(C5046bo.nullAsNil(c36833c.cNS));
                                        jf.dJm = true;
                                        jf.dJG = c36833c.dJG;
                                        jf.dqp = true;
                                        if (c36833c.sKA == 1) {
                                            if (jf.dtF()) {
                                                jf.mo14785ht(jf.dqI | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                                            }
                                        } else if (jf.dtF()) {
                                            jf.mo14785ht(jf.dqI & -1025);
                                        }
                                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(jf.field_msgId, jf);
                                    }
                                    AppMethodBeat.m2505o(26048);
                                }
                                return true;
                            }
                        });
                    }
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.m2505o(26049);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.translate.a$3 */
    class C437153 extends C4884c<C37802ti> {
        C437153() {
            AppMethodBeat.m2504i(26053);
            this.xxI = C37802ti.class.getName().hashCode();
            AppMethodBeat.m2505o(26053);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26054);
            C37802ti c37802ti = (C37802ti) c4883b;
            c37802ti.cPD.cPE = C43713a.this.sKl.abQ(c37802ti.cPC.f15021id);
            AppMethodBeat.m2505o(26054);
            return true;
        }
    }

    public C43713a() {
        AppMethodBeat.m2504i(26055);
        AppMethodBeat.m2505o(26055);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(26056);
        C36832c c36832c = this.sKl;
        C22444a c22444a = this.sKn;
        if (!(c22444a == null || c36832c.eES.contains(c22444a))) {
            c36832c.eES.add(c22444a);
        }
        C4879a.xxA.mo10052c(this.sKo);
        C4879a.xxA.mo10052c(this.sKp);
        AppMethodBeat.m2505o(26056);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(26057);
        C4879a.xxA.mo10053d(this.sKo);
        C4879a.xxA.mo10053d(this.sKp);
        C36832c c36832c = this.sKl;
        C22444a c22444a = this.sKn;
        if (c22444a != null && c36832c.eES.contains(c22444a)) {
            c36832c.eES.remove(c22444a);
        }
        C36832c c36832c2 = this.sKl;
        if (c36832c2.sKw != null) {
            for (C1202f c1202f : c36832c2.sKw) {
                if (c1202f != null) {
                    C9638aw.m17182Rg().mo14546b(631, c1202f);
                    if (c1202f.sKG != null) {
                        c1202f.sKI.stopTimer();
                        C9638aw.m17182Rg().mo14547c(c1202f.sKG);
                    }
                    c1202f.cHJ();
                    c1202f.sKE = null;
                }
            }
        }
        c36832c2.sKy.clear();
        c36832c2.sKx.clear();
        c36832c2.eES.clear();
        c36832c2.exv = 0;
        AppMethodBeat.m2505o(26057);
    }
}
