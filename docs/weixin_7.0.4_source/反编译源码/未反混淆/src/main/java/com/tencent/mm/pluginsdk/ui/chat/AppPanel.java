package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel extends LinearLayout {
    private static int qgy = 215;
    private static int qgz = 158;
    private static boolean vmg = false;
    private boolean bZi = false;
    Context context;
    private SharedPreferences ehZ;
    private List<f> geU = new LinkedList();
    private boolean qgL = false;
    private int qgM;
    private int qgN;
    public MMFlipper qgO;
    private MMDotView qgP;
    private int vlA = 17;
    private final boolean[] vlJ = new boolean[17];
    private a vlK;
    private b vlL;
    private List<AppGrid> vlM;
    private int vlN = this.vlA;
    private int vlO;
    public a vlP;
    private int vlQ = 0;
    private int vlR = 0;
    private int vlS = 0;
    private boolean vlT = false;
    private boolean vlU = false;
    private boolean vlV = false;
    private boolean vlW = false;
    boolean vlX = false;
    boolean vlY = false;
    boolean vlZ = false;
    public boolean vma = false;
    private Map<String, f> vmb = null;
    private boolean vmc = true;
    private final int vmd = 2;
    private int vme = -1;
    private com.tencent.mm.pluginsdk.ui.chat.AppGrid.b vmf = new com.tencent.mm.pluginsdk.ui.chat.AppGrid.b() {
        public final int Lb(int i) {
            AppMethodBeat.i(27748);
            if (i < AppPanel.this.vlA) {
                int length = AppPanel.this.vlJ.length;
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (AppPanel.this.vlJ[i3]) {
                        if (i2 == i) {
                            AppMethodBeat.o(27748);
                            return i3;
                        }
                        i2++;
                    }
                }
            } else if (i >= AppPanel.this.vlA && i < AppPanel.this.vlN) {
                AppMethodBeat.o(27748);
                return j.INVALID_ID;
            }
            AppMethodBeat.o(27748);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        }

        public final void Lc(int i) {
            AppMethodBeat.i(27749);
            if (i != 0) {
                AppMethodBeat.o(27749);
            } else if (AppPanel.this.vlP.vmn.value) {
                AppPanel.a(AppPanel.this, true);
                AppMethodBeat.o(27749);
            } else {
                Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                AppMethodBeat.o(27749);
            }
        }

        public final void a(int i, f fVar) {
            int i2 = 1;
            int i3 = 0;
            AppMethodBeat.i(27750);
            String str = "MicroMsg.AppPanel";
            String str2 = "pos=%d, has appInfo = %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(fVar != null);
            ab.d(str, str2, objArr);
            if (fVar != null && g.l(fVar)) {
                HashMap hashMap = new HashMap();
                r.m(hashMap);
                hashMap.put(fVar.field_appId, "1");
                r.l(hashMap);
            }
            sz szVar;
            String str3;
            f fVar2;
            boolean a;
            List P;
            switch (i) {
                case j.INVALID_ID /*-2147483648*/:
                    if (!AppPanel.this.vlP.vmu.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                        AppMethodBeat.o(27750);
                        return;
                    } else if (fVar == null) {
                        ab.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
                        AppMethodBeat.o(27750);
                        return;
                    } else {
                        if (fVar.dhx() || fVar.dhA()) {
                            if (AppPanel.this.ehZ == null) {
                                AppPanel.this.ehZ = AppPanel.this.context.getSharedPreferences(ah.doA(), 0);
                            }
                            if (AppPanel.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                                AppPanel.this.ehZ.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, false).commit();
                            }
                            if (fVar.dhA()) {
                                h.pYm.e(10923, Integer.valueOf(16), fVar.field_appId, Integer.valueOf(0));
                            }
                            h.pYm.e(10923, Integer.valueOf(13), fVar.field_appId, Integer.valueOf(0));
                        } else {
                            h.pYm.e(10923, Integer.valueOf(11), fVar.field_appId);
                        }
                        AppPanel.this.vlK.b(fVar);
                        AppMethodBeat.o(27750);
                        return;
                    }
                case 0:
                    if (AppPanel.this.vlP.vmn.value) {
                        h.pYm.e(10923, Integer.valueOf(1));
                        AppPanel.a(AppPanel.this, false);
                        AppMethodBeat.o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                case 1:
                    h.pYm.e(10923, Integer.valueOf(14));
                    a k = AppPanel.this.vlK;
                    if (!AppPanel.this.vlP.vmD.value) {
                        i3 = 2;
                    }
                    k.yt(i3);
                    AppMethodBeat.o(27750);
                    return;
                case 2:
                    if (AppPanel.this.vlP.vmq.value) {
                        h.pYm.e(10923, Integer.valueOf(8));
                        aw.ZK();
                        c.Ry().set(54, Boolean.FALSE);
                        if (AppPanel.this.vlK != null) {
                            szVar = new sz();
                            szVar.cPf.cPh = true;
                            com.tencent.mm.sdk.b.a.xxA.m(szVar);
                            str3 = szVar.cPg.cPj;
                            if (bo.isNullOrNil(str3)) {
                                AppPanel.this.vlK.bNO();
                                AppMethodBeat.o(27750);
                                return;
                            }
                            ab.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(str3)));
                            com.tencent.mm.ui.base.h.d(AppPanel.this.context, AppPanel.this.context.getString(R.string.euf), "", AppPanel.this.context.getString(R.string.s6), AppPanel.this.context.getString(R.string.or), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(27744);
                                    sz szVar = new sz();
                                    szVar.cPf.cPi = true;
                                    com.tencent.mm.sdk.b.a.xxA.m(szVar);
                                    AppPanel.this.vlK.bNO();
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(27744);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(27745);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(27745);
                                }
                            });
                            AppMethodBeat.o(27750);
                            return;
                        }
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                    break;
                case 3:
                    if (AppPanel.this.vlK != null) {
                        AppPanel.this.vlK.bNY();
                        AppMethodBeat.o(27750);
                        return;
                    }
                    break;
                case 4:
                    if (AppPanel.this.vlP.vmw.value) {
                        h.pYm.e(10923, Integer.valueOf(7));
                        aw.ZK();
                        c.Ry().set(62, Boolean.FALSE);
                        szVar = new sz();
                        szVar.cPf.cPh = true;
                        com.tencent.mm.sdk.b.a.xxA.m(szVar);
                        str3 = szVar.cPg.cPj;
                        if (bo.isNullOrNil(str3)) {
                            AppPanel.this.vlK.bNP();
                            AppMethodBeat.o(27750);
                            return;
                        }
                        ab.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(str3)));
                        com.tencent.mm.ui.base.h.d(AppPanel.this.context, AppPanel.this.context.getString(R.string.euf), "", AppPanel.this.context.getString(R.string.s6), AppPanel.this.context.getString(R.string.or), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(27746);
                                sz szVar = new sz();
                                szVar.cPf.cPi = true;
                                com.tencent.mm.sdk.b.a.xxA.m(szVar);
                                AppPanel.this.vlK.bNP();
                                dialogInterface.dismiss();
                                AppMethodBeat.o(27746);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(27747);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(27747);
                            }
                        });
                        AppMethodBeat.o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                case 5:
                    if (AppPanel.this.vlK != null) {
                        h.pYm.e(10923, Integer.valueOf(6));
                        aw.ZK();
                        c.Ry().set(67, Boolean.FALSE);
                        AppPanel.this.vlK.bNQ();
                        AppMethodBeat.o(27750);
                        return;
                    }
                    break;
                case 6:
                    if (AppPanel.this.vlP.vmA.value && AppPanel.this.vlP.vmB.value) {
                        aw.ZK();
                        if (((Boolean) c.Ry().get(290817, Boolean.TRUE)).booleanValue()) {
                            aw.ZK();
                            c.Ry().set(290817, Boolean.FALSE);
                            AppPanel.this.refresh();
                        }
                        h.pYm.e(10923, Integer.valueOf(3));
                        AppPanel.this.vlK.bNR();
                        AppMethodBeat.o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                case 7:
                    if (AppPanel.this.vlP.vmE.value) {
                        if (fVar == null) {
                            fVar2 = (f) AppPanel.this.vmb.get(f.vbS);
                            if (fVar2 == null) {
                                AppMethodBeat.o(27750);
                                return;
                            }
                        }
                        fVar2 = fVar;
                        if (fVar2.dhx() || fVar2.dhA()) {
                            if (AppPanel.this.ehZ == null) {
                                AppPanel.this.ehZ = AppPanel.this.context.getSharedPreferences(ah.doA(), 0);
                            }
                            if (AppPanel.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                                AppPanel.this.ehZ.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                            }
                            h.pYm.e(10923, Integer.valueOf(13), fVar2.field_appId, Integer.valueOf(0));
                        } else {
                            h.pYm.e(10923, Integer.valueOf(11), fVar2.field_appId);
                        }
                        a = com.tencent.mm.x.c.PK().a(com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_APP_PANEL_STRING_SYNC);
                        if (a) {
                            com.tencent.mm.x.c.PK().c(com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_APP_PANEL_STRING_SYNC);
                        }
                        aw.ZK();
                        i3 = ((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                        aw.ZK();
                        P = bo.P(((String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, (Object) "")).split(";"));
                        if (P.contains(String.valueOf(i3))) {
                            boolean i22 = a;
                        } else {
                            P.add(String.valueOf(i3));
                            aw.ZK();
                            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, bo.c(P, ";"));
                        }
                        if (i22 != 0) {
                            AppPanel.this.refresh();
                        }
                        AppPanel.this.vlK.bNX();
                        AppMethodBeat.o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                case 8:
                    if (fVar == null) {
                        fVar = (f) AppPanel.this.vmb.get(f.vbQ);
                    }
                    aw.ZK();
                    i22 = ((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                    aw.ZK();
                    P = bo.P(((String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, (Object) "")).split(";"));
                    if (!P.contains(String.valueOf(i22))) {
                        P.add(String.valueOf(i22));
                        aw.ZK();
                        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, bo.c(P, ";"));
                        AppPanel.this.refresh();
                    }
                    aw.ZK();
                    c.Ry().set(80, Boolean.FALSE);
                    AppPanel.this.vlK.b(fVar);
                    AppMethodBeat.o(27750);
                    return;
                case 9:
                    if (AppPanel.this.vlK != null) {
                        if (fVar == null) {
                            fVar2 = (f) AppPanel.this.vmb.get(f.vbT);
                            if (fVar2 == null) {
                                ab.i("MicroMsg.AppPanel", "empty info");
                                AppMethodBeat.o(27750);
                                return;
                            }
                        }
                        fVar2 = fVar;
                        if (fVar2.dhx() || fVar2.dhA()) {
                            if (AppPanel.this.ehZ == null) {
                                AppPanel.this.ehZ = AppPanel.this.context.getSharedPreferences(ah.doA(), 0);
                            }
                            if (AppPanel.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                                AppPanel.this.ehZ.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                            }
                        }
                        AppPanel.this.vlK.bOa();
                        AppMethodBeat.o(27750);
                        return;
                    }
                    break;
                case 10:
                    h.pYm.e(10923, Integer.valueOf(9));
                    aw.ZK();
                    c.Ry().set(73, Boolean.FALSE);
                    AppPanel.this.vlL.djW();
                    AppMethodBeat.o(27750);
                    return;
                case 11:
                    if (AppPanel.this.vlP.vmp.value) {
                        h.pYm.e(10923, Integer.valueOf(5));
                        if (AppPanel.this.vlK != null) {
                            AppPanel.this.vlK.bNU();
                            AppMethodBeat.o(27750);
                            return;
                        }
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                    break;
                case 12:
                    if (AppPanel.this.vlP.vmo.value) {
                        h.pYm.e(10923, Integer.valueOf(4));
                        AppPanel.this.vlK.bNS();
                        AppMethodBeat.o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                case 13:
                    if (AppPanel.this.vlP.vmC.value) {
                        if (AppPanel.this.vlK != null) {
                            AppPanel.this.vlK.bNW();
                        }
                        h.pYm.e(10923, Integer.valueOf(15));
                        aw.ZK();
                        a = ((Boolean) c.Ry().get(208899, Boolean.FALSE)).booleanValue();
                        aw.ZK();
                        boolean booleanValue = ((Boolean) c.Ry().get(208913, Boolean.FALSE)).booleanValue();
                        if (a) {
                            h.pYm.e(11594, Integer.valueOf(3));
                            AppMethodBeat.o(27750);
                            return;
                        } else if (booleanValue) {
                            h.pYm.e(11594, Integer.valueOf(4));
                            AppMethodBeat.o(27750);
                            return;
                        }
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                    break;
                case 14:
                    if (AppPanel.this.vlP.vms.value) {
                        aw.ZK();
                        if (((Boolean) c.Ry().get(327744, Boolean.TRUE)).booleanValue()) {
                            aw.ZK();
                            c.Ry().set(327744, Boolean.FALSE);
                            AppPanel.this.refresh();
                        }
                        h.pYm.e(10923, Integer.valueOf(12));
                        AppPanel.this.vlK.bNV();
                        AppMethodBeat.o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                case 15:
                    if (AppPanel.this.vlP.vmG.value) {
                        AppPanel.this.vlK.bNZ();
                        AppMethodBeat.o(27750);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                case 16:
                    if (AppPanel.this.vlP.vmI.value) {
                        h.pYm.e(10923, Integer.valueOf(17));
                        if (AppPanel.this.vlK != null) {
                            AppPanel.this.vlK.bOb();
                            break;
                        }
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.an0), 0).show();
                    AppMethodBeat.o(27750);
                    return;
                    break;
                case BaseClientBuilder.API_PRIORITY_OTHER /*2147483647*/:
                    if (AppPanel.this.geU == null) {
                        ab.e("MicroMsg.AppPanel", "infoList == null");
                        AppMethodBeat.o(27750);
                        return;
                    }
                    h.pYm.X(10305, String.valueOf(AppPanel.this.geU.size()));
                    h.pYm.e(10923, Integer.valueOf(10));
                    com.tencent.mm.kernel.g.RP().Ry().set(69121, (Object) "");
                    AppPanel.this.vlK.bNT();
                    AppMethodBeat.o(27750);
                    return;
            }
            AppMethodBeat.o(27750);
        }
    };
    private boolean vmh = true;
    private int vmi = -1;

    public interface a {
        void b(f fVar);

        void bNO();

        void bNP();

        void bNQ();

        void bNR();

        void bNS();

        void bNT();

        void bNU();

        void bNV();

        void bNW();

        void bNX();

        void bNY();

        void bNZ();

        void bOa();

        void bOb();

        void ys(int i);

        void yt(int i);
    }

    public interface b {
        void djW();
    }

    static /* synthetic */ int b(AppPanel appPanel) {
        AppMethodBeat.i(27781);
        int screenOrientation = appPanel.getScreenOrientation();
        AppMethodBeat.o(27781);
        return screenOrientation;
    }

    static /* synthetic */ void d(AppPanel appPanel) {
        AppMethodBeat.i(27782);
        appPanel.chK();
        AppMethodBeat.o(27782);
    }

    public AppPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27752);
        this.context = context;
        AppMethodBeat.o(27752);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init(int i) {
        AppMethodBeat.i(27753);
        ab.i("MicroMsg.AppPanel", "init: %s", Integer.valueOf(i));
        this.vlP = new a();
        this.vlS = i;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            this.vlQ = defaultDisplay.getWidth();
            this.vlR = defaultDisplay.getHeight();
        } else {
            this.vlQ = defaultDisplay.getHeight();
            this.vlR = defaultDisplay.getWidth();
        }
        View.inflate(this.context, R.layout.e5, this);
        this.qgP = (MMDotView) findViewById(R.id.xx);
        this.qgO = (MMFlipper) findViewById(R.id.xw);
        try {
            String value = com.tencent.mm.m.g.Nu().getValue("ShowAPPSuggestion");
            if (bo.isNullOrNil(value) || Integer.valueOf(value).intValue() != 1) {
                this.geU = g.a(this.context, false, this.vlS);
                if (!djU()) {
                    eh(this.geU);
                }
                eg(this.geU);
                djR();
                djI();
                AppMethodBeat.o(27753);
            }
            this.geU = g.a(this.context, true, this.vlS);
            if (djU()) {
            }
            eg(this.geU);
            djR();
            djI();
            AppMethodBeat.o(27753);
        } catch (Exception e) {
            ab.e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.geU = g.a(this.context, false, this.vlS);
        }
    }

    public void setServiceShowFlag(int i) {
        AppMethodBeat.i(27754);
        ab.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", Integer.valueOf(i));
        this.vlS = i;
        AppMethodBeat.o(27754);
    }

    private void eg(List<f> list) {
        AppMethodBeat.i(27755);
        boolean z = this.vlT;
        this.vlT = false;
        boolean z2 = this.vlU;
        boolean z3 = this.vlV;
        boolean z4 = this.vlW;
        this.vlU = false;
        this.vlV = false;
        this.vlW = false;
        int Kw = g.Kw(this.vlS);
        String str = "MicroMsg.AppPanel";
        String str2 = "serviceCount, %d, %s, %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(Kw);
        objArr[1] = Integer.valueOf(this.vlS);
        objArr[2] = Integer.valueOf(list != null ? list.size() : -1);
        ab.i(str, str2, objArr);
        this.vmb = new HashMap();
        if (Kw > 0) {
            if (list != null && list.size() > 0) {
                int i = 0;
                while (true) {
                    Kw = i;
                    if (Kw >= list.size()) {
                        break;
                    }
                    f fVar = (f) list.get(Kw);
                    if (!(fVar == null || fVar.field_appId == null || !fVar.dhx())) {
                        int i2;
                        if (!fVar.dhz()) {
                            this.vlT = true;
                        }
                        if (f.vbQ.equals(fVar.field_appId)) {
                            this.vmb.put(f.vbQ, fVar);
                            ab.i("MicroMsg.AppPanel", "remittance: %s, %s", Boolean.valueOf(this.vlY), Boolean.valueOf(this.vlU));
                            if (!this.vlY) {
                                this.vlU = true;
                            }
                            i2 = Kw - 1;
                            list.remove(Kw);
                            Kw = i2;
                        }
                        if (f.vbS.equals(fVar.field_appId)) {
                            this.vmb.put(f.vbS, fVar);
                            ab.i("MicroMsg.AppPanel", "luckyMoney: %s, %s", Boolean.valueOf(this.vlX), Boolean.valueOf(this.vlV));
                            if (!this.vlX) {
                                this.vlV = true;
                            }
                            i2 = Kw - 1;
                            list.remove(Kw);
                            Kw = i2;
                        }
                        if (f.vbT.equals(fVar.field_appId)) {
                            this.vmb.put(f.vbT, fVar);
                            ab.i("MicroMsg.AppPanel", "aa: %s, %s", Boolean.valueOf(this.vlX), Boolean.valueOf(this.vlV));
                            if (!this.vlZ) {
                                this.vlW = true;
                            }
                            i = Kw - 1;
                            list.remove(Kw);
                            Kw = i;
                        }
                    }
                    i = Kw + 1;
                }
            } else {
                h.pYm.k(965, 36, 1);
            }
        }
        ab.i("MicroMsg.AppPanel", "hasService %b", Boolean.valueOf(this.vlT));
        if (!(z == this.vlT && z2 == this.vlU && z3 == this.vlV && z4 == this.vlW)) {
            this.vlP.oJ(this.vlT);
            this.vlP.oK(this.vlU);
            this.vlP.oN(this.vlV);
            this.vlP.oO(this.vlW);
            djQ();
        }
        AppMethodBeat.o(27755);
    }

    public final void djI() {
        AppMethodBeat.i(27756);
        this.vlP.djX();
        this.vlX = false;
        this.vlY = false;
        this.vlZ = false;
        this.vma = false;
        djJ();
        this.vlP.oJ(this.vlT);
        this.vlP.oK(this.vlU);
        this.vlP.oN(this.vlV);
        this.vlP.oO(this.vlW);
        djQ();
        AppMethodBeat.o(27756);
    }

    public final void djJ() {
        AppMethodBeat.i(27757);
        com.tencent.mm.m.g.Nv();
        boolean z = com.tencent.mm.m.c.Ng() == 2;
        this.vlP.djY();
        this.vlP.oL(z);
        this.vlP.oM(d.afj(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION));
        this.vlP.djZ();
        AppMethodBeat.o(27757);
    }

    public final void djK() {
        AppMethodBeat.i(27758);
        this.vlP.vmo.value = false;
        djQ();
        AppMethodBeat.o(27758);
    }

    public final void oF(boolean z) {
        AppMethodBeat.i(27759);
        boolean z2 = !z;
        this.vlP.vmq.value = z2;
        djQ();
        ab.d("MicroMsg.AppPanel", "enable " + z2 + " isVoipPluginEnable " + this.vlP.vmr.value);
        AppMethodBeat.o(27759);
    }

    public final void oG(boolean z) {
        AppMethodBeat.i(27760);
        boolean z2 = !z;
        this.vlP.vmw.value = z2;
        djQ();
        ab.d("MicroMsg.AppPanel", "enable " + this.vlP.vmx.value + " isVoipAudioEnable " + z2);
        AppMethodBeat.o(27760);
    }

    public final void oH(boolean z) {
        AppMethodBeat.i(27761);
        boolean z2 = !z;
        this.vlP.vmF.value = z2;
        djQ();
        ab.d("MicroMsg.AppPanel", "enable " + this.vlP.vmF.value + " isMultiTalkEnable " + z2);
        AppMethodBeat.o(27761);
    }

    public final void oI(boolean z) {
        AppMethodBeat.i(27762);
        this.vlP.vmy.value = !z;
        djQ();
        AppMethodBeat.o(27762);
    }

    public final void djL() {
        AppMethodBeat.i(27763);
        this.vlP.vmv.value = false;
        djQ();
        ab.d("MicroMsg.AppPanel", "disableTalkroom enable false");
        AppMethodBeat.o(27763);
    }

    public final void djM() {
        AppMethodBeat.i(27764);
        this.vlP.vmA.value = false;
        djQ();
        AppMethodBeat.o(27764);
    }

    public final void djN() {
        AppMethodBeat.i(27765);
        this.vlP.vmu.value = false;
        djQ();
        AppMethodBeat.o(27765);
    }

    public final void djO() {
        AppMethodBeat.i(27766);
        this.vlP.vmC.value = false;
        djQ();
        AppMethodBeat.o(27766);
    }

    public final void djP() {
        AppMethodBeat.i(27767);
        this.vlP.vmI.value = false;
        djQ();
        AppMethodBeat.o(27767);
    }

    public final void djQ() {
        int i;
        AppMethodBeat.i(27768);
        int length = this.vlJ.length;
        for (i = 0; i < length; i++) {
            this.vlJ[i] = true;
        }
        if (this.vlP.vmn.value) {
            i = 0;
        } else {
            this.vlJ[0] = false;
            i = 1;
        }
        if (!this.vlP.vmm.value) {
            this.vlJ[1] = false;
            i++;
        }
        if (!this.vlP.vmI.value) {
            this.vlJ[16] = false;
            i++;
        }
        if (!(this.vlP.vmA.value && this.vlP.vmB.value)) {
            this.vlJ[6] = false;
            i++;
        }
        if (!this.vlP.vms.value) {
            this.vlJ[14] = false;
            i++;
        }
        if (!this.vlP.vmt.value) {
            ab.i("MicroMsg.AppPanel", "disable remittance");
            this.vlJ[8] = false;
            i++;
        }
        if (!this.vlP.vmo.value) {
            this.vlJ[12] = false;
            i++;
        }
        if (!this.vlP.vmC.value) {
            this.vlJ[13] = false;
            i++;
        }
        if (!this.vlP.vmF.value) {
            this.vlJ[3] = false;
            i++;
        }
        if (!this.vlP.vmp.value) {
            this.vlJ[11] = false;
            i++;
        }
        if (!this.vlP.vmv.value) {
            this.vlJ[5] = false;
            i++;
        }
        if (!(this.vlP.vmx.value && this.vlP.vmw.value)) {
            this.vlJ[4] = false;
            i++;
        }
        if (!(this.vlP.vmr.value && this.vlP.vmq.value)) {
            this.vlJ[2] = false;
            i++;
        }
        if (!(this.vlP.vmz.value && this.vlP.vmy.value)) {
            this.vlJ[10] = false;
            i++;
        }
        if (!this.vlP.vmE.value) {
            ab.i("MicroMsg.AppPanel", "disable lucky money");
            this.vlJ[7] = false;
            i++;
        }
        if (!this.vlP.vmG.value) {
            this.vlJ[15] = false;
            i++;
        }
        this.vlJ[9] = false;
        this.vlA = 17 - (i + 1);
        AppMethodBeat.o(27768);
    }

    private int getScreenOrientation() {
        int i;
        AppMethodBeat.i(27769);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            i = 1;
        } else {
            i = 2;
        }
        AppMethodBeat.o(27769);
        return i;
    }

    private void djR() {
        AppMethodBeat.i(27770);
        ab.d("MicroMsg.AppPanel", "AppPanel initFlipper");
        this.vme = -1;
        this.qgO.removeAllViews();
        this.qgO.setOnMeasureListener(new com.tencent.mm.ui.base.MMFlipper.a() {
            public final void fe(int i, int i2) {
                AppMethodBeat.i(27741);
                ab.i("MicroMsg.AppPanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + AppPanel.this.qgL);
                if (AppPanel.this.qgL || i2 == 0 || i == 0) {
                    if (i2 == 0 || i == 0) {
                        ab.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
                    }
                    AppMethodBeat.o(27741);
                    return;
                }
                if (AppPanel.b(AppPanel.this) == 2) {
                    ab.d("MicroMsg.AppPanel", "landspace");
                } else {
                    ab.d("MicroMsg.AppPanel", "portrait");
                }
                AppPanel.this.qgL = true;
                AppPanel.this.qgN = i2;
                AppPanel.this.qgM = i;
                AppPanel.d(AppPanel.this);
                AppMethodBeat.o(27741);
            }
        });
        this.qgO.setOnScreenChangedListener(new com.tencent.mm.ui.base.MMFlipper.b() {
            public final void BZ(int i) {
                AppMethodBeat.i(27742);
                AppPanel.this.qgP.setSelectedDot(i);
                AppMethodBeat.o(27742);
            }
        });
        djT();
        AppMethodBeat.o(27770);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void refresh() {
        AppMethodBeat.i(27771);
        ab.i("MicroMsg.AppPanel", "app panel refleshed: %s", Integer.valueOf(this.vlS));
        try {
            String value = com.tencent.mm.m.g.Nu().getValue("ShowAPPSuggestion");
            int curScreen;
            if (bo.isNullOrNil(value) || Integer.valueOf(value).intValue() != 1) {
                this.geU = g.a(this.context, false, this.vlS);
                ab.i("MicroMsg.AppPanel", "jacks not show App Suggestion");
                if (!djU()) {
                    eh(this.geU);
                }
                eg(this.geU);
                if (this.vlP != null) {
                    this.vlP.oJ(this.vlT);
                    this.vlP.oK(this.vlU);
                    this.vlP.oN(this.vlV);
                    this.vlP.oO(this.vlW);
                }
                curScreen = this.qgO.getCurScreen();
                chK();
                this.qgO.setToScreen(curScreen);
                this.qgP.setSelectedDot(curScreen);
                AppMethodBeat.o(27771);
            }
            ab.i("MicroMsg.AppPanel", "jacks show App Suggestion");
            this.geU = g.a(this.context, true, this.vlS);
            if (djU()) {
            }
            eg(this.geU);
            if (this.vlP != null) {
            }
            curScreen = this.qgO.getCurScreen();
            chK();
            this.qgO.setToScreen(curScreen);
            this.qgP.setSelectedDot(curScreen);
            AppMethodBeat.o(27771);
        } catch (Exception e) {
            ab.e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.geU = g.a(this.context, false, this.vlS);
        }
    }

    private void chK() {
        AppMethodBeat.i(27772);
        ab.i("MicroMsg.AppPanel", "init app grid: %s, %s", Integer.valueOf(this.qgM), Integer.valueOf(this.qgN));
        if (this.qgM == 0 || this.qgN == 0) {
            AppMethodBeat.o(27772);
            return;
        }
        int i;
        Object obj;
        AppGrid appGrid;
        int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 82.0f);
        int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 90.0f);
        djQ();
        int i2 = 4;
        if (!this.vmc) {
            i2 = this.qgM / b;
        }
        b = this.qgN / b2;
        if (b > 2) {
            b = 2;
        }
        ab.d("MicroMsg.AppPanel", "jacks spacing2 = %d", Integer.valueOf((this.qgN - (b2 * b)) / (b + 1)));
        ab.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", Integer.valueOf(this.qgM), Integer.valueOf(this.qgN));
        if (i2 == 0) {
            i = 1;
        } else {
            i = i2;
        }
        if (b == 0) {
            b = 1;
        }
        this.vlO = b;
        int i3 = i * b;
        if (this.vlP.vmu.value) {
            this.vlN = this.vlA + this.geU.size();
        } else {
            this.vlN = this.vlA;
        }
        int ceil = (int) Math.ceil(((double) this.vlN) / ((double) i3));
        ab.i("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d visibleLocalAppCount = %d infoList = %d", Integer.valueOf(this.vlN), Integer.valueOf(i3), Integer.valueOf(ceil), Integer.valueOf(this.vlA), Integer.valueOf(this.geU.size()));
        if (this.vme == ceil) {
            ab.i("MicroMsg.AppPanel", "mLastPageCount == pageCount! [%s:%s]", Integer.valueOf(this.vme), Integer.valueOf(ceil));
            obj = null;
        } else {
            int obj2 = 1;
        }
        if (obj2 != null) {
            this.vlM = new ArrayList();
            this.qgO.removeAllViews();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (ceil > 10) {
            h.pYm.e(16776, Integer.valueOf(0), Integer.valueOf(1));
            h.pYm.k(999, 1, 1);
        }
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(27743);
                ab.e("MicroMsg.AppPanel", "initAppGrid ANR!");
                h.pYm.k(999, 2, 1);
                AppMethodBeat.o(27743);
            }
        };
        com.tencent.mm.sdk.g.d.xDG.p(anonymousClass3, 5000);
        b = 0;
        while (b < ceil) {
            if (b >= ceil) {
                ab.e("MicroMsg.AppPanel", "my god! you see a ghost! %s", Integer.valueOf(ceil));
                h.pYm.k(999, 0, 1);
                h.pYm.e(16776, Integer.valueOf(1), Integer.valueOf(0));
                break;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (obj2 != null || this.vlM.size() <= b || this.vlM.get(b) == null) {
                appGrid = (AppGrid) inflate(this.context, R.layout.e1, null);
            } else {
                appGrid = (AppGrid) this.vlM.get(b);
            }
            ab.i("MicroMsg.AppPanel", "[initAppGrid] i:%s cost:%sms", Integer.valueOf(b), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            j += System.currentTimeMillis() - currentTimeMillis2;
            appGrid.d(this.geU, this.vmb);
            appGrid.b(b, this.vlN, i3, ceil, i, this.vlA);
            appGrid.La(r14);
            if (obj2 != null) {
                this.qgO.addView(appGrid, new LayoutParams(-1, -2));
                this.vlM.add(appGrid);
            }
            b++;
        }
        com.tencent.mm.sdk.g.d.xDG.remove((Runnable) anonymousClass3);
        ab.i("MicroMsg.AppPanel", "[initAppGrid] cost:%sms inflateCost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(j));
        for (AppGrid appGrid2 : this.vlM) {
            appGrid2.setOnAppSelectedListener(this.vmf);
        }
        chL();
        this.vme = ceil;
        requestLayout();
        AppMethodBeat.o(27772);
    }

    public int getPageMaxRowCount() {
        if (this.vlO != 0) {
            return this.vlO;
        }
        int i = (this.vlN + 3) / 4;
        if (i > 2) {
            return 2;
        }
        return i;
    }

    private void chL() {
        AppMethodBeat.i(27773);
        if (this.vlM.size() <= 1) {
            this.qgP.setVisibility(4);
            AppMethodBeat.o(27773);
            return;
        }
        this.qgP.setVisibility(0);
        this.qgP.setDotCount(this.vlM.size());
        int curScreen = this.qgO.getCurScreen();
        this.qgO.setToScreen(curScreen);
        this.qgP.setSelectedDot(curScreen);
        AppMethodBeat.o(27773);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(27774);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            ab.d("MicroMsg.AppPanel", "onConfigChanged:" + configuration.orientation);
            if (configuration.orientation == 1) {
                this.vmc = true;
            } else {
                this.vmc = false;
            }
            setNeedRefreshHeight(true);
            djS();
        }
        AppMethodBeat.o(27774);
    }

    public final void djS() {
        AppMethodBeat.i(27775);
        ab.i("MicroMsg.AppPanel", "[dealOrientationChange]");
        this.qgL = false;
        this.qgO.setToScreen(0);
        djR();
        requestLayout();
        AppMethodBeat.o(27775);
    }

    public void setOnSwitchPanelListener(b bVar) {
        this.vlL = bVar;
    }

    public void setAppPanelListener(a aVar) {
        this.vlK = aVar;
    }

    public void setPortHeighDP(int i) {
        if (qgy != i) {
            qgy = i;
            this.vmh = true;
        }
    }

    public void setPortHeighPx(int i) {
        if (this.vmi != i) {
            this.vmi = i;
            this.vmh = true;
        }
    }

    public void setNeedRefreshHeight(boolean z) {
        this.vmh = z;
    }

    public final void AG() {
        AppMethodBeat.i(27776);
        ab.i("MicroMsg.AppPanel", "[forceRefreshSize]");
        djT();
        djS();
        AppMethodBeat.o(27776);
    }

    public final void djT() {
        AppMethodBeat.i(27777);
        if (this.vmh) {
            View findViewById;
            LayoutParams layoutParams;
            if (getScreenOrientation() == 2) {
                ab.d("MicroMsg.AppPanel", "initFlipper, landscape");
                findViewById = findViewById(R.id.xv);
                layoutParams = new LayoutParams(-1, 0);
                layoutParams.height = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, (float) qgz);
                findViewById.setLayoutParams(layoutParams);
            } else {
                ab.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", Integer.valueOf(qgy));
                findViewById = findViewById(R.id.xv);
                layoutParams = new LayoutParams(-1, 0);
                layoutParams.height = getPortHeightPX();
                findViewById.setLayoutParams(layoutParams);
            }
            this.vmh = false;
        }
        AppMethodBeat.o(27777);
    }

    private int getPortHeightPX() {
        AppMethodBeat.i(27778);
        int i;
        if (this.vmi > 0) {
            i = this.vmi;
            AppMethodBeat.o(27778);
            return i;
        }
        i = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, (float) qgy);
        AppMethodBeat.o(27778);
        return i;
    }

    private static void eh(List<f> list) {
        AppMethodBeat.i(27779);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(27779);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                f fVar = (f) list.get(i2);
                if (fVar == null || !f.vbR.equals(fVar.field_appId)) {
                    i = i2 + 1;
                } else {
                    list.remove(fVar);
                    ab.i("MicroMsg.AppPanel", "do remove card");
                    AppMethodBeat.o(27779);
                    return;
                }
            }
            AppMethodBeat.o(27779);
            return;
        }
    }

    private boolean djU() {
        AppMethodBeat.i(27780);
        if (this.vma) {
            AppMethodBeat.o(27780);
            return false;
        }
        com.tencent.mm.plugin.card.c.b bVar = (com.tencent.mm.plugin.card.c.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.card.c.b.class);
        if (bVar == null) {
            AppMethodBeat.o(27780);
            return false;
        } else if (!bVar.bbn() || bVar.bbq() <= 0) {
            AppMethodBeat.o(27780);
            return false;
        } else {
            AppMethodBeat.o(27780);
            return true;
        }
    }
}
