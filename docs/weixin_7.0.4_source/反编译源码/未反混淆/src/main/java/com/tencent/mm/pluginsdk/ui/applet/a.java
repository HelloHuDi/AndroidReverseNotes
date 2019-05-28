package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

public final class a implements f {
    private String chatroomName = "";
    private Context context;
    public String gyj = "";
    private String ijx;
    public int jSW = 0;
    public String mGZ = "";
    private LinkedList<String> pAS;
    private LinkedList<Integer> pAT;
    private p tipDialog;
    private a vjH;
    public b vjI;
    private LinkedList<String> vjJ;
    public String vjK;
    String vjL = "";
    private String vjM;
    public boolean vjN = true;
    public boolean vjO = true;
    public boolean vjP = false;
    public String vjQ = "";

    public interface a {
        void a(boolean z, boolean z2, String str, String str2);
    }

    public interface b {
        boolean vQ(String str);
    }

    public a(Context context, a aVar) {
        AppMethodBeat.i(79704);
        this.context = context;
        this.vjH = aVar;
        this.pAS = new LinkedList();
        this.vjJ = new LinkedList();
        this.tipDialog = null;
        AppMethodBeat.o(79704);
    }

    public final void c(String str, String str2, LinkedList<Integer> linkedList) {
        AppMethodBeat.i(79705);
        this.chatroomName = str2;
        a(str, (LinkedList) linkedList, false, "");
        AppMethodBeat.o(79705);
    }

    public final void e(String str, LinkedList<Integer> linkedList) {
        AppMethodBeat.i(79706);
        a(str, (LinkedList) linkedList, false, "");
        AppMethodBeat.o(79706);
    }

    public final void a(String str, LinkedList<Integer> linkedList, String str2) {
        AppMethodBeat.i(79707);
        a(str, (LinkedList) linkedList, false, str2);
        AppMethodBeat.o(79707);
    }

    public final void ajw(String str) {
        AppMethodBeat.i(79708);
        if (!TextUtils.isEmpty(str)) {
            this.vjJ.add(str);
        }
        AppMethodBeat.o(79708);
    }

    public final void b(String str, LinkedList<Integer> linkedList, boolean z) {
        AppMethodBeat.i(79709);
        a(str, (LinkedList) linkedList, z, "");
        AppMethodBeat.o(79709);
    }

    private void a(String str, LinkedList<Integer> linkedList, boolean z, String str2) {
        AppMethodBeat.i(79710);
        boolean z2 = str != null && str.length() > 0;
        Assert.assertTrue(z2);
        Assert.assertTrue(linkedList != null);
        this.vjN = z;
        onStart();
        if (this.vjO) {
            Context context = this.context;
            this.context.getString(R.string.tz);
            this.tipDialog = h.b(context, this.context.getString(R.string.atw), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(79700);
                    a.a(a.this, false, a.this.vjL, a.this.gyj);
                    AppMethodBeat.o(79700);
                }
            });
        }
        this.pAT = linkedList;
        this.pAS.add(str);
        this.vjL = str;
        if (ad.aox(str)) {
            g.RO().eJo.a(new com.tencent.mm.openim.b.b(str, this.vjJ.isEmpty() ? "" : (String) this.vjJ.getFirst()), 0);
            AppMethodBeat.o(79710);
            return;
        }
        m mVar = new com.tencent.mm.pluginsdk.model.m(1, this.pAS, linkedList, this.vjJ, "", this.mGZ, null, this.chatroomName, str2);
        if (!bo.isNullOrNil(this.ijx)) {
            mVar.hB(this.ijx, this.vjM);
        }
        mVar.tq(this.vjQ);
        mVar.lV(this.jSW);
        g.RO().eJo.a(mVar, 0);
        AppMethodBeat.o(79710);
    }

    public final void hH(String str, String str2) {
        this.ijx = str;
        this.vjM = str2;
    }

    private void c(boolean z, boolean z2, String str, String str2) {
        AppMethodBeat.i(79711);
        if (this.vjH != null) {
            this.vjH.a(z, z2, str, str2);
        }
        if (z) {
            jy jyVar = new jy();
            jyVar.cFk.username = str;
            com.tencent.mm.sdk.b.a.xxA.m(jyVar);
        }
        AppMethodBeat.o(79711);
    }

    private void onStart() {
        AppMethodBeat.i(79712);
        g.RO().eJo.a(30, (f) this);
        g.RO().eJo.a(667, (f) this);
        AppMethodBeat.o(79712);
    }

    public final void onSceneEnd(int i, int i2, String str, final m mVar) {
        AppMethodBeat.i(79713);
        ab.d("MicroMsg.AddContact", "onSceneEnd, errType = " + i + ", errCode = " + i2 + "," + str);
        if (mVar.getType() == 30 || mVar.getType() == 667) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            g.RO().eJo.b(30, (f) this);
            g.RO().eJo.b(667, (f) this);
            if (i == 0 && i2 == 0) {
                if (mVar.getType() == 30) {
                    this.vjL = ((com.tencent.mm.pluginsdk.model.m) mVar).dhl();
                } else if (mVar.getType() == 667) {
                    this.vjL = ((com.tencent.mm.openim.b.b) mVar).geZ;
                }
                c(true, false, this.vjL, this.gyj);
                AppMethodBeat.o(79713);
                return;
            } else if (i2 == -44) {
                String str2 = this.gyj;
                if (this.vjI != null) {
                    String str3;
                    b bVar = this.vjI;
                    if (this.vjJ.isEmpty()) {
                        str3 = "";
                    } else {
                        str3 = (String) this.vjJ.getFirst();
                    }
                    bVar.vQ(str3);
                    c(false, false, this.vjL, str2);
                    AppMethodBeat.o(79713);
                    return;
                }
                s sVar = new s(this.context, new com.tencent.mm.pluginsdk.ui.applet.s.a() {
                    public final void bD(boolean z) {
                        AppMethodBeat.i(79703);
                        String str = a.this.gyj;
                        a aVar = a.this;
                        a.a(aVar, z, aVar.vjL, str);
                        AppMethodBeat.o(79703);
                    }
                });
                if (this.vjK != null) {
                    sVar.vjK = this.vjK;
                }
                if (this.vjN) {
                    LinkedList linkedList = this.pAS;
                    LinkedList linkedList2 = this.pAT;
                    sVar.vlm = false;
                    sVar.onStart();
                    sVar.vll = linkedList;
                    sVar.pAT = linkedList2;
                    if (linkedList.size() == 1 && ad.aox((String) linkedList.getFirst())) {
                        sVar.djH();
                        AppMethodBeat.o(79713);
                        return;
                    }
                    g.RO().eJo.a(new com.tencent.mm.pluginsdk.model.m(2, linkedList, linkedList2, "", ""), 0);
                    AppMethodBeat.o(79713);
                    return;
                }
                sVar.a(this.pAS, this.pAT, this.vjJ);
                AppMethodBeat.o(79713);
                return;
            } else if (i2 == -87) {
                h.b(this.context, this.context.getString(R.string.aui), "", true);
                AppMethodBeat.o(79713);
                return;
            } else if (i2 == XWalkUpdater.ERROR_SET_VERNUM && !bo.isNullOrNil(str)) {
                ab.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", Integer.valueOf(i2), str);
                h.a(this.context, str, "", false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(79701);
                        a.a(a.this, false, a.this.vjL, a.this.gyj);
                        AppMethodBeat.o(79701);
                    }
                });
                AppMethodBeat.o(79713);
                return;
            } else if (i2 == -302) {
                if (mVar.getType() == 667) {
                    AppMethodBeat.o(79713);
                    return;
                }
                ab.d("MicroMsg.AddContact", "onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(((com.tencent.mm.pluginsdk.model.m) mVar).cAd));
                if (((com.tencent.mm.pluginsdk.model.m) mVar).cAd == 3) {
                    h.d(this.context, this.context.getString(R.string.b23), this.context.getString(R.string.tz), this.context.getString(R.string.fs), this.context.getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LinkedList linkedList;
                            AppMethodBeat.i(79702);
                            ab.d("MicroMsg.AddContact", "dealwith verify relation out of date");
                            com.tencent.mm.pluginsdk.model.m mVar = (com.tencent.mm.pluginsdk.model.m) mVar;
                            if (mVar.ehh == null || mVar.ehh.acF() == null) {
                                linkedList = null;
                            } else {
                                linkedList = ((cnh) mVar.ehh.fsG.fsP).xkP;
                            }
                            List list = ((com.tencent.mm.pluginsdk.model.m) mVar).vbm;
                            if (list != null && list.size() > 0) {
                                a.this.e((String) list.get(0), linkedList);
                            }
                            AppMethodBeat.o(79702);
                        }
                    }, null);
                }
                AppMethodBeat.o(79713);
                return;
            } else if (i2 != -2) {
                A(i, i2, str);
                AppMethodBeat.o(79713);
                return;
            } else if (bo.isNullOrNil(str)) {
                A(i, i2, null);
                AppMethodBeat.o(79713);
                return;
            } else {
                h.a(this.context, str, this.context.getString(R.string.tz), this.context.getString(R.string.s6), null);
                AppMethodBeat.o(79713);
                return;
            }
        }
        ab.w("MicroMsg.AddContact", "not expected scene,  type = " + mVar.getType());
        AppMethodBeat.o(79713);
    }

    private void A(int i, int i2, String str) {
        AppMethodBeat.i(79714);
        if (this.vjP && !bo.isNullOrNil(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else if (i == 4 && i2 == -22) {
            Toast.makeText(this.context, this.context.getString(R.string.da), 1).show();
        } else if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else {
            Toast.makeText(this.context, this.context.getString(R.string.d_), 1).show();
        }
        c(false, false, this.vjL, this.gyj);
        AppMethodBeat.o(79714);
    }
}
