package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.openim.p716b.C45464b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42017jy;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23275s.C23280a;
import com.tencent.p177mm.protocal.protobuf.cnh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.a */
public final class C14916a implements C1202f {
    private String chatroomName = "";
    private Context context;
    public String gyj = "";
    private String ijx;
    public int jSW = 0;
    public String mGZ = "";
    private LinkedList<String> pAS;
    private LinkedList<Integer> pAT;
    private C44275p tipDialog;
    private C14917a vjH;
    public C14918b vjI;
    private LinkedList<String> vjJ;
    public String vjK;
    String vjL = "";
    private String vjM;
    public boolean vjN = true;
    public boolean vjO = true;
    public boolean vjP = false;
    public String vjQ = "";

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.a$1 */
    class C149151 implements OnCancelListener {
        C149151() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(79700);
            C14916a.m23190a(C14916a.this, false, C14916a.this.vjL, C14916a.this.gyj);
            AppMethodBeat.m2505o(79700);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.a$a */
    public interface C14917a {
        /* renamed from: a */
        void mo5739a(boolean z, boolean z2, String str, String str2);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.a$b */
    public interface C14918b {
        /* renamed from: vQ */
        boolean mo8211vQ(String str);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.a$2 */
    class C149192 implements OnClickListener {
        C149192() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(79701);
            C14916a.m23190a(C14916a.this, false, C14916a.this.vjL, C14916a.this.gyj);
            AppMethodBeat.m2505o(79701);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.a$4 */
    class C149214 implements C23280a {
        C149214() {
        }

        /* renamed from: bD */
        public final void mo27248bD(boolean z) {
            AppMethodBeat.m2504i(79703);
            String str = C14916a.this.gyj;
            C14916a c14916a = C14916a.this;
            C14916a.m23190a(c14916a, z, c14916a.vjL, str);
            AppMethodBeat.m2505o(79703);
        }
    }

    public C14916a(Context context, C14917a c14917a) {
        AppMethodBeat.m2504i(79704);
        this.context = context;
        this.vjH = c14917a;
        this.pAS = new LinkedList();
        this.vjJ = new LinkedList();
        this.tipDialog = null;
        AppMethodBeat.m2505o(79704);
    }

    /* renamed from: c */
    public final void mo27243c(String str, String str2, LinkedList<Integer> linkedList) {
        AppMethodBeat.m2504i(79705);
        this.chatroomName = str2;
        m23191a(str, (LinkedList) linkedList, false, "");
        AppMethodBeat.m2505o(79705);
    }

    /* renamed from: e */
    public final void mo27244e(String str, LinkedList<Integer> linkedList) {
        AppMethodBeat.m2504i(79706);
        m23191a(str, (LinkedList) linkedList, false, "");
        AppMethodBeat.m2505o(79706);
    }

    /* renamed from: a */
    public final void mo27240a(String str, LinkedList<Integer> linkedList, String str2) {
        AppMethodBeat.m2504i(79707);
        m23191a(str, (LinkedList) linkedList, false, str2);
        AppMethodBeat.m2505o(79707);
    }

    public final void ajw(String str) {
        AppMethodBeat.m2504i(79708);
        if (!TextUtils.isEmpty(str)) {
            this.vjJ.add(str);
        }
        AppMethodBeat.m2505o(79708);
    }

    /* renamed from: b */
    public final void mo27242b(String str, LinkedList<Integer> linkedList, boolean z) {
        AppMethodBeat.m2504i(79709);
        m23191a(str, (LinkedList) linkedList, z, "");
        AppMethodBeat.m2505o(79709);
    }

    /* renamed from: a */
    private void m23191a(String str, LinkedList<Integer> linkedList, boolean z, String str2) {
        AppMethodBeat.m2504i(79710);
        boolean z2 = str != null && str.length() > 0;
        Assert.assertTrue(z2);
        Assert.assertTrue(linkedList != null);
        this.vjN = z;
        onStart();
        if (this.vjO) {
            Context context = this.context;
            this.context.getString(C25738R.string.f9238tz);
            this.tipDialog = C30379h.m48458b(context, this.context.getString(C25738R.string.atw), true, new C149151());
        }
        this.pAT = linkedList;
        this.pAS.add(str);
        this.vjL = str;
        if (C7616ad.aox(str)) {
            C1720g.m3535RO().eJo.mo14541a(new C45464b(str, this.vjJ.isEmpty() ? "" : (String) this.vjJ.getFirst()), 0);
            AppMethodBeat.m2505o(79710);
            return;
        }
        C1207m c46498m = new C46498m(1, this.pAS, linkedList, this.vjJ, "", this.mGZ, null, this.chatroomName, str2);
        if (!C5046bo.isNullOrNil(this.ijx)) {
            c46498m.mo74715hB(this.ijx, this.vjM);
        }
        c46498m.mo74717tq(this.vjQ);
        c46498m.mo74716lV(this.jSW);
        C1720g.m3535RO().eJo.mo14541a(c46498m, 0);
        AppMethodBeat.m2505o(79710);
    }

    /* renamed from: hH */
    public final void mo27245hH(String str, String str2) {
        this.ijx = str;
        this.vjM = str2;
    }

    /* renamed from: c */
    private void m23192c(boolean z, boolean z2, String str, String str2) {
        AppMethodBeat.m2504i(79711);
        if (this.vjH != null) {
            this.vjH.mo5739a(z, z2, str, str2);
        }
        if (z) {
            C42017jy c42017jy = new C42017jy();
            c42017jy.cFk.username = str;
            C4879a.xxA.mo10055m(c42017jy);
        }
        AppMethodBeat.m2505o(79711);
    }

    private void onStart() {
        AppMethodBeat.m2504i(79712);
        C1720g.m3535RO().eJo.mo14539a(30, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(667, (C1202f) this);
        AppMethodBeat.m2505o(79712);
    }

    public final void onSceneEnd(int i, int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(79713);
        C4990ab.m7410d("MicroMsg.AddContact", "onSceneEnd, errType = " + i + ", errCode = " + i2 + "," + str);
        if (c1207m.getType() == 30 || c1207m.getType() == 667) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            C1720g.m3535RO().eJo.mo14546b(30, (C1202f) this);
            C1720g.m3535RO().eJo.mo14546b(667, (C1202f) this);
            if (i == 0 && i2 == 0) {
                if (c1207m.getType() == 30) {
                    this.vjL = ((C46498m) c1207m).dhl();
                } else if (c1207m.getType() == 667) {
                    this.vjL = ((C45464b) c1207m).geZ;
                }
                m23192c(true, false, this.vjL, this.gyj);
                AppMethodBeat.m2505o(79713);
                return;
            } else if (i2 == -44) {
                String str2 = this.gyj;
                if (this.vjI != null) {
                    String str3;
                    C14918b c14918b = this.vjI;
                    if (this.vjJ.isEmpty()) {
                        str3 = "";
                    } else {
                        str3 = (String) this.vjJ.getFirst();
                    }
                    c14918b.mo8211vQ(str3);
                    m23192c(false, false, this.vjL, str2);
                    AppMethodBeat.m2505o(79713);
                    return;
                }
                C23275s c23275s = new C23275s(this.context, new C149214());
                if (this.vjK != null) {
                    c23275s.vjK = this.vjK;
                }
                if (this.vjN) {
                    LinkedList linkedList = this.pAS;
                    LinkedList linkedList2 = this.pAT;
                    c23275s.vlm = false;
                    c23275s.onStart();
                    c23275s.vll = linkedList;
                    c23275s.pAT = linkedList2;
                    if (linkedList.size() == 1 && C7616ad.aox((String) linkedList.getFirst())) {
                        c23275s.djH();
                        AppMethodBeat.m2505o(79713);
                        return;
                    }
                    C1720g.m3535RO().eJo.mo14541a(new C46498m(2, linkedList, linkedList2, "", ""), 0);
                    AppMethodBeat.m2505o(79713);
                    return;
                }
                c23275s.mo38979a(this.pAS, this.pAT, this.vjJ);
                AppMethodBeat.m2505o(79713);
                return;
            } else if (i2 == -87) {
                C30379h.m48461b(this.context, this.context.getString(C25738R.string.aui), "", true);
                AppMethodBeat.m2505o(79713);
                return;
            } else if (i2 == XWalkUpdater.ERROR_SET_VERNUM && !C5046bo.isNullOrNil(str)) {
                C4990ab.m7411d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", Integer.valueOf(i2), str);
                C30379h.m48448a(this.context, str, "", false, new C149192());
                AppMethodBeat.m2505o(79713);
                return;
            } else if (i2 == -302) {
                if (c1207m.getType() == 667) {
                    AppMethodBeat.m2505o(79713);
                    return;
                }
                C4990ab.m7411d("MicroMsg.AddContact", "onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(((C46498m) c1207m).cAd));
                if (((C46498m) c1207m).cAd == 3) {
                    C30379h.m48466d(this.context, this.context.getString(C25738R.string.b23), this.context.getString(C25738R.string.f9238tz), this.context.getString(C25738R.string.f8814fs), this.context.getString(C25738R.string.f9076or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LinkedList linkedList;
                            AppMethodBeat.m2504i(79702);
                            C4990ab.m7410d("MicroMsg.AddContact", "dealwith verify relation out of date");
                            C46498m c46498m = (C46498m) c1207m;
                            if (c46498m.ehh == null || c46498m.ehh.acF() == null) {
                                linkedList = null;
                            } else {
                                linkedList = ((cnh) c46498m.ehh.fsG.fsP).xkP;
                            }
                            List list = ((C46498m) c1207m).vbm;
                            if (list != null && list.size() > 0) {
                                C14916a.this.mo27244e((String) list.get(0), linkedList);
                            }
                            AppMethodBeat.m2505o(79702);
                        }
                    }, null);
                }
                AppMethodBeat.m2505o(79713);
                return;
            } else if (i2 != -2) {
                m23189A(i, i2, str);
                AppMethodBeat.m2505o(79713);
                return;
            } else if (C5046bo.isNullOrNil(str)) {
                m23189A(i, i2, null);
                AppMethodBeat.m2505o(79713);
                return;
            } else {
                C30379h.m48443a(this.context, str, this.context.getString(C25738R.string.f9238tz), this.context.getString(C25738R.string.f9187s6), null);
                AppMethodBeat.m2505o(79713);
                return;
            }
        }
        C4990ab.m7420w("MicroMsg.AddContact", "not expected scene,  type = " + c1207m.getType());
        AppMethodBeat.m2505o(79713);
    }

    /* renamed from: A */
    private void m23189A(int i, int i2, String str) {
        AppMethodBeat.m2504i(79714);
        if (this.vjP && !C5046bo.isNullOrNil(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else if (i == 4 && i2 == -22) {
            Toast.makeText(this.context, this.context.getString(C25738R.string.f8727da), 1).show();
        } else if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else {
            Toast.makeText(this.context, this.context.getString(C25738R.string.f8726d_), 1).show();
        }
        m23192c(false, false, this.vjL, this.gyj);
        AppMethodBeat.m2505o(79714);
    }
}
