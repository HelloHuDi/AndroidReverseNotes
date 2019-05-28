package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p230g.p231a.C32636th;
import com.tencent.p177mm.p230g.p231a.C37802ti;
import com.tencent.p177mm.p230g.p231a.C45372tj;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44297ah;
import com.tencent.p177mm.p612ui.chatting.viewitems.ChattingItemTranslate.C5371b;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;

@C15590a(dFp = C44297ah.class)
/* renamed from: com.tencent.mm.ui.chatting.c.ap */
public class C23725ap extends C44291a implements C44297ah {
    private C23498az ySV = new C23498az(5, "msg-translate-update-worker");
    private HashMap<Long, C5371b> ySW = new HashMap();
    private C4884c ySX = new C237232();

    /* renamed from: com.tencent.mm.ui.chatting.c.ap$2 */
    class C237232 extends C4884c<C45372tj> {
        C237232() {
            AppMethodBeat.m2504i(31826);
            this.xxI = C45372tj.class.getName().hashCode();
            AppMethodBeat.m2505o(31826);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(31827);
            C45372tj c45372tj = (C45372tj) c4883b;
            if (c45372tj instanceof C45372tj) {
                final String str = c45372tj.cPF.f17878id;
                final int i = c45372tj.cPF.ret;
                new C7306ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(31825);
                        if (i == 0) {
                            C23725ap.this.mo39564a(C5046bo.anl(str), C5371b.Transformed);
                            C23725ap.m36592a(C23725ap.this, C5046bo.anl(str));
                            AppMethodBeat.m2505o(31825);
                            return;
                        }
                        if (i == 3) {
                            C30379h.m48465bQ(C23725ap.this.cgL.yTx.getContext(), C23725ap.this.cgL.yTx.getMMResources().getString(C25738R.string.ap1));
                        } else if (i != 5) {
                            C30379h.m48465bQ(C23725ap.this.cgL.yTx.getContext(), C23725ap.this.cgL.yTx.getMMResources().getString(C25738R.string.aow));
                        }
                        C23725ap.this.mo39564a(C5046bo.anl(str), C5371b.NoTransform);
                        C23725ap.this.cgL.aWv();
                        AppMethodBeat.m2505o(31825);
                    }
                }, (long) (i == 5 ? 2000 : 0));
            }
            AppMethodBeat.m2505o(31827);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m36593a(C23725ap c23725ap, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(31839);
        c23725ap.m36594d(c7620bi, z);
        AppMethodBeat.m2505o(31839);
    }

    public C23725ap() {
        AppMethodBeat.m2504i(31829);
        AppMethodBeat.m2505o(31829);
    }

    private void dDi() {
        AppMethodBeat.m2504i(31830);
        C4879a.xxA.mo10053d(this.ySX);
        AppMethodBeat.m2505o(31830);
    }

    /* renamed from: a */
    public final void mo39564a(long j, C5371b c5371b) {
        AppMethodBeat.m2504i(31831);
        this.ySW.put(Long.valueOf(j), c5371b);
        AppMethodBeat.m2505o(31831);
    }

    /* renamed from: bl */
    public final C5371b mo39566bl(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31832);
        C5371b c5371b = (C5371b) this.ySW.get(Long.valueOf(c7620bi.field_msgId));
        if (c5371b == null) {
            if (!c7620bi.dtF()) {
                C37802ti c37802ti = new C37802ti();
                c37802ti.cPC.f15021id = c7620bi.field_msgId;
                C4879a.xxA.mo10055m(c37802ti);
                if (c37802ti.cPD.cPE) {
                    c5371b = C5371b.Transforming;
                    mo39564a(c7620bi.field_msgId, c5371b);
                } else {
                    c5371b = C5371b.NoTransform;
                }
            } else if (c7620bi.dtM()) {
                c5371b = C5371b.Transformed;
            } else {
                c5371b = C5371b.NoTransform;
            }
        }
        AppMethodBeat.m2505o(31832);
        return c5371b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final boolean mo39565b(final MenuItem menuItem, final C7620bi c7620bi) {
        AppMethodBeat.m2504i(31833);
        final int itemId = menuItem.getItemId();
        switch (itemId) {
            case 124:
            case 125:
                int i;
                C4990ab.m7411d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", Integer.valueOf(c7620bi.getType()), Boolean.valueOf(c7620bi.dtM()));
                if (itemId == 124) {
                    C9638aw.m17190ZK();
                    if (!((Boolean) C18628c.m29072Ry().get(327712, Boolean.FALSE)).booleanValue()) {
                        i = C25738R.string.aoz;
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(327712, Boolean.TRUE);
                        if (i != 0) {
                            C5652a c5652a = new C5652a(this.cgL.yTx.getContext());
                            c5652a.asE(this.cgL.yTx.getMMResources().getString(i));
                            c5652a.asD(this.cgL.yTx.getMMResources().getString(C25738R.string.ap0));
                            c5652a.mo11453Qc(C25738R.string.cd_).mo11457a(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(31828);
                                    C23725ap c23725ap = C23725ap.this;
                                    C7620bi c7620bi = c7620bi;
                                    menuItem.getGroupId();
                                    C23725ap.m36593a(c23725ap, c7620bi, itemId == 125);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.m2505o(31828);
                                }
                            });
                            c5652a.aMb().show();
                        } else {
                            menuItem.getGroupId();
                            m36594d(c7620bi, itemId == 125);
                        }
                        AppMethodBeat.m2505o(31833);
                        return true;
                    }
                }
                if (itemId == 125) {
                    C9638aw.m17190ZK();
                    if (!((Boolean) C18628c.m29072Ry().get(327713, Boolean.FALSE)).booleanValue()) {
                        i = C25738R.string.anw;
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(327713, Boolean.TRUE);
                        if (i != 0) {
                        }
                        AppMethodBeat.m2505o(31833);
                        return true;
                    }
                }
                i = 0;
                if (i != 0) {
                }
                AppMethodBeat.m2505o(31833);
                return true;
            default:
                AppMethodBeat.m2505o(31833);
                return false;
        }
    }

    /* renamed from: d */
    private void m36594d(C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(31835);
        if (c7620bi.dtF() && !z) {
            if (c7620bi.dtM()) {
                c7620bi.dtO();
                mo39564a(c7620bi.field_msgId, C5371b.NoTransform);
                C45457b.fRa.mo73258a(c7620bi, false);
            } else {
                c7620bi.dtN();
                mo39564a(c7620bi.field_msgId, C5371b.Transformed);
                C45457b.fRa.mo73258a(c7620bi, true);
            }
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
        } else if (mo39566bl(c7620bi) == C5371b.Transforming) {
            AppMethodBeat.m2505o(31835);
            return;
        } else {
            C32636th c32636th = new C32636th();
            c32636th.cPy.cPA = false;
            c32636th.cPy.f15020id = c7620bi.field_msgId;
            c32636th.cPy.cPz = c7620bi.field_content;
            c32636th.cPy.cPB = c7620bi.dJG;
            if (!this.cgL.dFx() || c7620bi.field_isSend == 1) {
                c32636th.cPy.type = 0;
            } else {
                c32636th.cPy.type = 1;
            }
            c32636th.cPy.source = this.cgL.getTalkerUserName();
            C4879a.xxA.mo10055m(c32636th);
            mo39564a(c7620bi.field_msgId, C5371b.Transforming);
        }
        this.cgL.aWv();
        AppMethodBeat.m2505o(31835);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31837);
        dDi();
        AppMethodBeat.m2505o(31837);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31838);
        super.dDh();
        dDi();
        AppMethodBeat.m2505o(31838);
    }

    /* renamed from: bm */
    public final String mo39567bm(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31834);
        String str = c7620bi.field_content;
        int i = c7620bi.field_isSend;
        if (this.cgL.dFw() && str != null && i == 0) {
            str = C1829bf.m3763oz(str);
        }
        AppMethodBeat.m2505o(31834);
        return str;
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31836);
        this.ySW.clear();
        C4879a.xxA.mo10052c(this.ySX);
        AppMethodBeat.m2505o(31836);
    }
}
