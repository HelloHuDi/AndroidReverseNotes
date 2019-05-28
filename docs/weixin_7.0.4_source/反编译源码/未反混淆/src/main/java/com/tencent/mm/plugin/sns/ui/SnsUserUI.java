package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Process;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.d.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.b.a.ah;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.ActUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsUserUI extends MMActivity implements com.tencent.mm.plugin.sns.b.h.a {
    private long eEO = 0;
    private int ehv;
    private long fAq = 0;
    private c hAA = new c<ke>() {
        {
            AppMethodBeat.i(39793);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(39793);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(39794);
            ke keVar = (ke) bVar;
            if (keVar instanceof ke) {
                switch (keVar.cFH.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        SnsUserUI.this.rCS.notifyDataSetChanged();
                        break;
                }
            }
            AppMethodBeat.o(39794);
            return false;
        }
    };
    private String igi;
    private com.tencent.matrix.trace.e.b mnM = new com.tencent.matrix.trace.e.b() {
        public final void a(String str, long j, int i) {
            AppMethodBeat.i(39805);
            super.a(str, j, i);
            if (i > 0 && !bo.isNullOrNil(str) && str.endsWith(SnsUserUI.this.getClass().getSimpleName())) {
                SnsUserUI.this.eEO = SnsUserUI.this.eEO + ((long) i);
            }
            AppMethodBeat.o(39805);
        }
    };
    private View plv;
    private com.tencent.mm.ui.statusbar.c.a plx;
    private as rCS;
    private SnsUIAction rCT;
    private com.tencent.mm.plugin.sns.model.am.a rCU;
    private com.tencent.mm.plugin.sns.ui.SnsUIAction.a rCV;
    private RelativeLayout rCW = null;
    private TextView rCX = null;
    private int rCY = 0;
    private Runnable rCZ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(39785);
            SnsUserUI.this.rCS.ctK();
            SnsUserUI.this.rCS.crP();
            AppMethodBeat.o(39785);
        }
    };
    private boolean rjn;
    private String ryC;
    private boolean ryD;
    private int ryE;
    private boolean ryx = false;
    private OnMenuItemClickListener rzm = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(39790);
            SnsUserUI.this.finish();
            AppMethodBeat.o(39790);
            return true;
        }
    };

    class a extends f {
        private ax rzp = null;

        a() {
        }

        public void fw(int i, int i2) {
            AppMethodBeat.i(39810);
            ab.i("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId:%d, pos:%d，mIsSelf:%b ", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(SnsUserUI.this.rjn));
            Intent intent;
            if (SnsUserUI.this.rjn && i2 == -1) {
                g.RQ();
                String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, null);
                if (!bo.isNullOrNil(str)) {
                    g.RQ();
                    String str2 = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, (Object) "");
                    new ah().Fs().fk(str2).ajK();
                    byte[] atV = e.atV(str);
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(atV, 0, atV.length);
                    obtain.setDataPosition(0);
                    try {
                        intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                        intent.addFlags(268435456);
                        intent.setClass(SnsUserUI.this, SnsUploadUI.class);
                        intent.putExtra("KSessionID", str2);
                        SnsUserUI.this.startActivity(intent);
                        AppMethodBeat.o(39810);
                        return;
                    } catch (Exception e) {
                        g.RQ();
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
                        g.RQ();
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, (Object) "");
                    }
                }
                this.rzp = new ax(SnsUserUI.this);
                this.rzp.rBl = new n.c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(39808);
                        lVar.e(0, SnsUserUI.this.getString(R.string.q4));
                        lVar.e(1, SnsUserUI.this.getString(R.string.qa));
                        AppMethodBeat.o(39808);
                    }
                };
                this.rzp.c(0, SnsUserUI.this.mController.ylL.getString(R.string.q9));
                this.rzp.rBm = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(39809);
                        switch (menuItem.getItemId()) {
                            case 0:
                                h.pYm.e(13822, Integer.valueOf(1), Integer.valueOf(2));
                                SnsUserUI.o(SnsUserUI.this);
                                AppMethodBeat.o(39809);
                                return;
                            case 1:
                                h.pYm.e(13822, Integer.valueOf(2), Integer.valueOf(2));
                                SnsUserUI.this.rCT.Em(1);
                                break;
                        }
                        AppMethodBeat.o(39809);
                    }
                };
                this.rzp.cuu();
                AppMethodBeat.o(39810);
                return;
            }
            intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
            intent.putExtra("sns_gallery_userName", SnsUserUI.this.igi);
            intent.putExtra("sns_gallery_is_self", SnsUserUI.this.rjn);
            intent.putExtra("sns_gallery_localId", i);
            intent.putExtra("sns_source", SnsUserUI.this.ryE);
            intent.putExtra("sns_gallery_st_time", SnsUserUI.this.rCS.rvy);
            intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.rCS.rvz);
            if (SnsUserUI.this.rCS != null) {
                intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.rCS.lQD);
                SnsUserUI.this.rCU.j(SnsUserUI.this.igi, SnsUserUI.this.rCS.fv(i, i2));
                intent.putExtra("sns_gallery_position", SnsUserUI.this.rCS.rvC);
            }
            SnsUserUI.this.startActivityForResult(intent, 8);
            AppMethodBeat.o(39810);
        }

        public final void fx(int i, int i2) {
            AppMethodBeat.i(39811);
            com.tencent.mm.plugin.sns.storage.n DK = af.cnF().DK(i);
            if (DK == null) {
                AppMethodBeat.o(39811);
            } else if (DK.field_type == 15) {
                Intent intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
                intent.putExtra("sns_gallery_userName", SnsUserUI.this.igi);
                intent.putExtra("sns_gallery_is_self", SnsUserUI.this.rjn);
                intent.putExtra("sns_gallery_localId", i);
                intent.putExtra("sns_source", SnsUserUI.this.ryE);
                intent.putExtra("sns_gallery_st_time", SnsUserUI.this.rCS.rvy);
                intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.rCS.rvz);
                if (SnsUserUI.this.rCS != null) {
                    intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.rCS.lQD);
                    SnsUserUI.this.rCU.j(SnsUserUI.this.igi, SnsUserUI.this.rCS.fv(i, i2));
                    intent.putExtra("sns_gallery_position", SnsUserUI.this.rCS.rvC);
                }
                SnsUserUI.this.startActivityForResult(intent, 8);
                AppMethodBeat.o(39811);
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
                intent2.putExtra("INTENT_TALKER", DK.field_userName);
                intent2.putExtra("INTENT_SNS_LOCAL_ID", v.ap("sns_table_", (long) i));
                SnsUserUI.this.startActivityForResult(intent2, 12);
                AppMethodBeat.o(39811);
            }
        }

        public final void Ed(int i) {
            AppMethodBeat.i(39812);
            com.tencent.mm.plugin.sns.storage.n DK = af.cnF().DK(i);
            if (DK == null) {
                AppMethodBeat.o(39812);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", DK.field_userName);
            intent.putExtra("INTENT_SNS_LOCAL_ID", v.ap("sns_table_", (long) i));
            SnsUserUI.this.startActivityForResult(intent, 12);
            AppMethodBeat.o(39812);
        }

        public final void fy(int i, int i2) {
            AppMethodBeat.i(39813);
            ab.d("MicroMsg.SnsUserUI", "onFailLongClick localId:%s position:%s", Integer.valueOf(i), Integer.valueOf(i2));
            com.tencent.mm.plugin.sns.storage.n DK = af.cnF().DK(i);
            if (DK != null && DK.cnn() && DK.cqW()) {
                SnsUserUI.b(SnsUserUI.this, i);
            }
            AppMethodBeat.o(39813);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsUserUI() {
        AppMethodBeat.i(39814);
        AppMethodBeat.o(39814);
    }

    static /* synthetic */ void o(SnsUserUI snsUserUI) {
        AppMethodBeat.i(39831);
        snsUserUI.cuG();
        AppMethodBeat.o(39831);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39815);
        if (this.mController != null) {
            this.mController.aC(2, false);
        }
        this.ylm = true;
        super.onCreate(bundle);
        if (g.RN().QY()) {
            com.tencent.mm.n.a aoO;
            this.plv = findViewById(R.id.k0);
            if (this.plv != null && com.tencent.mm.ui.statusbar.c.zzP) {
                com.tencent.mm.ui.statusbar.c az = com.tencent.mm.ui.statusbar.c.az(this);
                AnonymousClass4 anonymousClass4 = new com.tencent.mm.ui.statusbar.c.a() {
                    public final void pO(int i) {
                        AppMethodBeat.i(39788);
                        SnsUserUI.this.plv.setPadding(0, i, 0, 0);
                        com.tencent.mm.ui.statusbar.d.a(SnsUserUI.this.getWindow());
                        AppMethodBeat.o(39788);
                    }
                };
                this.plx = anonymousClass4;
                az.a(anonymousClass4);
                getWindow().getDecorView().requestApplyInsets();
                com.tencent.mm.ui.statusbar.d.a(getWindow());
            }
            getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
            xE(this.mController.ylL.getResources().getColor(R.color.a3p));
            b(new Runnable() {
                public final void run() {
                }
            }, new Runnable() {
                public final void run() {
                }
            });
            this.rCU = af.cnv();
            this.ryE = getIntent().getIntExtra("sns_source", 0);
            this.igi = getIntent().getStringExtra("sns_userName");
            if (this.igi == null) {
                this.igi = "";
            }
            g.RQ();
            this.ryD = ((j) g.K(j.class)).XM().aoJ(this.igi);
            this.ryC = r.Yz();
            this.rjn = this.ryC.equals(this.igi);
            bd cnt = af.cnt();
            String bc = bo.bc(getIntent().getStringExtra("sns_signature"), "");
            String bc2 = bo.bc(getIntent().getStringExtra("sns_nickName"), "");
            if (this.igi == null || this.igi.equals("")) {
                aoO = cnt.aoO(this.ryC);
            } else {
                aoO = cnt.aoO(this.igi);
            }
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                bc = aoO.signature;
                bc2 = aoO.Oi();
                ab.i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", aoO.field_username, Integer.valueOf((int) aoO.ewQ), bc2);
            }
            this.rCT = new SnsUIAction(this);
            this.rCT.a(this.ryC, this.igi, bc2, bc, this.ryD, this.rjn, this.ryE);
            SnsUIAction snsUIAction = this.rCT;
            AnonymousClass13 anonymousClass13 = new com.tencent.mm.plugin.sns.ui.SnsUIAction.a() {
                public final void cuh() {
                    AppMethodBeat.i(39795);
                    if (SnsUserUI.this.rCU == null) {
                        SnsUserUI.this.rCU = af.cnv();
                    }
                    com.tencent.mm.plugin.sns.model.am.a b = SnsUserUI.this.rCU;
                    String c = SnsUserUI.this.igi;
                    SnsUserUI.this.ryD;
                    b.b(2, c, SnsUserUI.this.rjn, SnsUserUI.this.ryE);
                    af.bCo().postDelayed(SnsUserUI.this.rCZ, 3000);
                    AppMethodBeat.o(39795);
                }

                public final ListView getSnsListView() {
                    AppMethodBeat.i(39796);
                    ListView listView = (ListView) SnsUserUI.this.findViewById(R.id.eii);
                    AppMethodBeat.o(39796);
                    return listView;
                }

                public final View cui() {
                    AppMethodBeat.i(39797);
                    View findViewById = SnsUserUI.this.findViewById(R.id.um);
                    AppMethodBeat.o(39797);
                    return findViewById;
                }

                public final View getMaskView() {
                    AppMethodBeat.i(39798);
                    View findViewById = SnsUserUI.this.findViewById(R.id.el6);
                    AppMethodBeat.o(39798);
                    return findViewById;
                }

                public final MMPullDownView cuj() {
                    AppMethodBeat.i(39799);
                    MMPullDownView mMPullDownView = (MMPullDownView) SnsUserUI.this.findViewById(R.id.avx);
                    AppMethodBeat.o(39799);
                    return mMPullDownView;
                }

                public final int getType() {
                    return 2;
                }

                public final void b(int i, List<Integer> list, List<Integer> list2) {
                    as a;
                    AppMethodBeat.i(39800);
                    if (!(i == -1 || SnsUserUI.this.rCS == null)) {
                        a = SnsUserUI.this.rCS;
                        if (a.rvw != null) {
                            at atVar = a.rvw;
                            com.tencent.mm.plugin.sns.storage.n DK = af.cnF().DK(i);
                            if (!(DK == null || DK.cqu().xfI == null || atVar.list.size() <= 0)) {
                                atVar.list.add(1, DK);
                                atVar.ctM();
                                atVar.ctN();
                            }
                        }
                    }
                    if (!(SnsUserUI.this.rCS == null || list == null || list2 == null)) {
                        a = SnsUserUI.this.rCS;
                        if (a.rvw != null) {
                            if (list == null || list2 == null || list.size() + list2.size() == 0) {
                                AppMethodBeat.o(39800);
                                return;
                            }
                            int i2;
                            com.tencent.mm.plugin.sns.storage.n nVar;
                            at atVar2 = a.rvw;
                            if (!(list == null || list.size() == 0)) {
                                ab.d("MicroMsg.SnsSelfHelper", "remove Items");
                                for (Integer intValue : list) {
                                    int intValue2 = intValue.intValue();
                                    int size = atVar2.list.size();
                                    for (i2 = 1; i2 < size; i2++) {
                                        nVar = (com.tencent.mm.plugin.sns.storage.n) atVar2.list.get(i2);
                                        if (nVar != null && nVar.reX == intValue2) {
                                            atVar2.list.remove(i2);
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!(list2 == null || list2.size() == 0)) {
                                ab.d("MicroMsg.SnsSelfHelper", "change Items");
                                LinkedList linkedList = new LinkedList();
                                i2 = 1;
                                while (i2 < atVar2.list.size()) {
                                    nVar = (com.tencent.mm.plugin.sns.storage.n) atVar2.list.get(i2);
                                    if (nVar != null) {
                                        for (Integer intValue3 : list2) {
                                            int intValue4 = intValue3.intValue();
                                            if (nVar.reX == intValue4) {
                                                ab.d("MicroMsg.SnsSelfHelper", "update list localId ".concat(String.valueOf(intValue4)));
                                                atVar2.list.remove(i2);
                                                linkedList.add(af.cnF().DK(intValue4));
                                                i2--;
                                                break;
                                            }
                                        }
                                    }
                                    i2++;
                                }
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    atVar2.list.add((com.tencent.mm.plugin.sns.storage.n) it.next());
                                }
                            }
                            atVar2.ctM();
                            atVar2.ctN();
                        }
                    }
                    AppMethodBeat.o(39800);
                }

                public final boolean cuk() {
                    return false;
                }

                public final void cul() {
                    AppMethodBeat.i(39801);
                    com.tencent.mm.plugin.sns.model.am.a b = SnsUserUI.this.rCU;
                    String c = SnsUserUI.this.igi;
                    SnsUserUI.this.ryD;
                    b.a(2, c, SnsUserUI.this.rjn, SnsUserUI.this.ryE);
                    AppMethodBeat.o(39801);
                }

                public final void cum() {
                }

                public final void Eh(int i) {
                    AppMethodBeat.i(39802);
                    ab.i("MicroMsg.SnsUserUI", "onListViewScoll %s", Integer.valueOf(i));
                    if (i == 2) {
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, SnsUserUI.this.ehv);
                        SnsUserUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, WXHardCoderJNI.hcSNSUserScrollDelay, WXHardCoderJNI.hcSNSUserScrollCPU, WXHardCoderJNI.hcSNSUserScrollIO, WXHardCoderJNI.hcSNSUserScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcSNSUserScrollTimeout, 704, WXHardCoderJNI.hcSNSUserScrollAction, "MicroMsg.SnsUserUI");
                        ab.i("MicroMsg.SnsUserUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsUserUI.this.ehv));
                    }
                    AppMethodBeat.o(39802);
                }

                public final void ad(int i, boolean z) {
                    Object obj = null;
                    AppMethodBeat.i(39803);
                    if (SnsUserUI.this.rCS != null) {
                        as a = SnsUserUI.this.rCS;
                        if (a.rvw != null) {
                            at atVar = a.rvw;
                            com.tencent.mm.plugin.sns.storage.n DK = af.cnF().DK(i);
                            if (DK == null || DK.cqu().xfI == null || atVar.list.size() <= 0) {
                                AppMethodBeat.o(39803);
                                return;
                            }
                            for (int i2 = 0; i2 < atVar.list.size(); i2++) {
                                if (((com.tencent.mm.plugin.sns.storage.n) atVar.list.get(i2)).cqU() == DK.cqU()) {
                                    obj = 1;
                                    atVar.list.remove(i2);
                                    break;
                                }
                            }
                            if (obj != null) {
                                atVar.list.add(DK);
                                atVar.ctM();
                                atVar.ctN();
                            }
                        }
                    }
                    AppMethodBeat.o(39803);
                }

                public final void ln(boolean z) {
                }

                public final void fA(int i, int i2) {
                    AppMethodBeat.i(39804);
                    if (i2 <= 0) {
                        SnsUserUI.i(SnsUserUI.this);
                        AppMethodBeat.o(39804);
                        return;
                    }
                    SnsUserUI.a(SnsUserUI.this, i, i2);
                    AppMethodBeat.o(39804);
                }
            };
            this.rCV = anonymousClass13;
            snsUIAction.rBP = anonymousClass13;
            this.rCT.onCreate();
            getIntent().setExtrasClassLoader(getClass().getClassLoader());
            initView();
            com.tencent.mm.sdk.b.a.xxA.c(this.hAA);
            AppMethodBeat.o(39815);
            return;
        }
        finish();
        AppMethodBeat.o(39815);
    }

    public void onDestroy() {
        AppMethodBeat.i(39816);
        af.bCo().removeCallbacks(this.rCZ);
        this.ryx = true;
        com.tencent.mm.sdk.b.a.xxA.d(this.hAA);
        com.tencent.mm.modelsns.b u = com.tencent.mm.modelsns.b.u(getIntent());
        if (u != null) {
            u.update();
            u.ajK();
        }
        if (!(this.rCT == null || this.rCT.tipDialog == null)) {
            this.rCT.tipDialog.dismiss();
            this.rCT.tipDialog = null;
        }
        g.RQ();
        if (g.RN().QY() && this.rCU != null) {
            this.rCU.a(this, this.rCV.getType());
        }
        if (this.rCT != null) {
            this.rCT.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(39816);
    }

    public void onDrag() {
        AppMethodBeat.i(39817);
        super.onDrag();
        AppMethodBeat.o(39817);
    }

    public final int getLayoutId() {
        return R.layout.aw6;
    }

    public void onResume() {
        AppMethodBeat.i(39818);
        this.fAq = bo.anT();
        if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
            com.tencent.matrix.trace.f.c cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
            if (cVar != null) {
                cVar.a(this.mnM);
            }
        }
        if (this.rCS != null) {
            this.rCS.notifyDataSetChanged();
        }
        setRequestedOrientation(-1);
        if (this.rjn) {
            b(getString(R.string.emv), (int) R.raw.actionbar_list_icon, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(39787);
                    Intent intent = new Intent();
                    intent.setClass(SnsUserUI.this, SnsMsgUI.class);
                    intent.putExtra("sns_msg_force_show_all", true);
                    SnsUserUI.this.startActivityForResult(intent, 8);
                    AppMethodBeat.o(39787);
                    return true;
                }
            });
        } else {
            enableOptionMenu(false);
        }
        setBackBtn(this.rzm, R.raw.actionbar_icon_dark_back);
        if (this.rjn) {
            setMMTitle((int) R.string.enj);
        } else {
            CharSequence Oj;
            ab.d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", this.igi, this.rCT.title);
            ad aoO = af.cnt().aoO(this.igi);
            if (aoO != null) {
                ab.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
                Oj = aoO.Oj();
            } else {
                ab.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", this.rCT.title);
                Oj = this.rCT.title;
            }
            setMMTitle(i.K(Oj));
        }
        this.rCT.onResume();
        super.onResume();
        AppMethodBeat.o(39818);
    }

    public void onPause() {
        AppMethodBeat.i(39819);
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, this.ehv);
        this.ehv = 0;
        this.rCT.onPause();
        super.onPause();
        if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
            com.tencent.matrix.trace.f.c cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
            if (cVar != null) {
                cVar.b(this.mnM);
            }
        }
        this.fAq = bo.anT() > this.fAq ? bo.anT() - this.fAq : 1;
        WXHardCoderJNI.reportFPS(704, WXHardCoderJNI.hcSNSUserScrollAction, 1, this.eEO, this.fAq);
        this.eEO = 0;
        this.fAq = 0;
        AppMethodBeat.o(39819);
    }

    public final void initView() {
        AppMethodBeat.i(39820);
        this.rCW = (RelativeLayout) findViewById(R.id.el7);
        this.rCX = (TextView) findViewById(R.id.el8);
        this.rCW.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39806);
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                layoutParams.topMargin = x.al(SnsUserUI.this) + SnsUserUI.this.getResources().getDimensionPixelSize(R.dimen.di);
                SnsUserUI.this.rCW.setLayoutParams(layoutParams);
                AppMethodBeat.o(39806);
            }
        });
        this.rCS = new as(this, new a() {
            public final void fw(int i, int i2) {
                AppMethodBeat.i(39807);
                super.fw(i, i2);
                AppMethodBeat.o(39807);
            }
        }, this.igi, new as.c() {
        });
        this.rCT.nDp.setAdapter(this.rCS);
        this.rCT.nDp.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.rCT.nDp.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39786);
                if (SnsUserUI.this.ryx) {
                    ab.w("MicroMsg.SnsUserUI", "too fast that it finish");
                    AppMethodBeat.o(39786);
                    return;
                }
                SnsUserUI.this.rCU.a(SnsUserUI.this.rCV.getType(), SnsUserUI.this.igi, SnsUserUI.this);
                if (SnsUserUI.this.rCV.getType() == 1 && SnsUserUI.this.rCV.cuk()) {
                    af.cnv().B(af.cnM().qMB, -1);
                }
                if (!SnsUserUI.this.rCV.cuk()) {
                    com.tencent.mm.plugin.sns.model.am.a b = SnsUserUI.this.rCU;
                    int type = SnsUserUI.this.rCV.getType();
                    String c = SnsUserUI.this.igi;
                    SnsUserUI.this.ryD;
                    b.a(type, c, SnsUserUI.this.rjn, SnsUserUI.this.ryE);
                }
                AppMethodBeat.o(39786);
            }
        }, 500);
        setBackBtn(this.rzm, R.raw.actionbar_icon_dark_back);
        AppMethodBeat.o(39820);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.i(39821);
        if (this.rCS != null) {
            this.rCS.rmL = str;
            if (str.compareTo(this.rCS.lQD) < 0) {
                ab.i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", str, this.rCS.lQD, Boolean.valueOf(z));
                this.rCS.ctK();
            } else {
                ab.i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", str, this.rCS.lQD, Boolean.valueOf(z));
            }
            this.rCS.crP();
        }
        if ((z4 || !bo.isNullOrNil(str2)) && !this.ryC.equals(this.igi)) {
            this.rCT.koC = true;
            this.rCT.bf(i, str2);
        } else {
            if (this.ryC.equals(this.igi) && j != 0) {
                g.RQ();
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
                this.rCS.kI(j);
            }
            this.rCT.koC = z2;
            if (z2) {
                this.rCT.lc(false);
            } else if (z) {
                this.rCU.b(this.rCV.getType(), this.igi, this.rjn, this.ryE);
            }
        }
        if (z3) {
            this.rCT.qQt.cti();
        }
        AppMethodBeat.o(39821);
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
        AppMethodBeat.i(39822);
        af.bCo().removeCallbacks(this.rCZ);
        if (this.rCS != null) {
            this.rCS.rvv = z2;
            this.rCS.rmL = str;
            if (str.compareTo(this.rCS.lQD) < 0) {
                ab.i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", str, this.rCS.lQD);
                this.rCS.ctK();
            } else {
                ab.i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", str, this.rCS.lQD);
            }
            this.rCS.crP();
        }
        if (!z3 || this.ryC.equals(this.igi)) {
            if (this.ryC.equals(this.igi) && j != 0) {
                g.RQ();
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
                this.rCS.kI(j);
            }
            this.rCT.koC = z;
            if (z) {
                this.rCT.lc(false);
            }
            AppMethodBeat.o(39822);
            return;
        }
        this.rCT.koC = true;
        this.rCT.bf(i, str2);
        AppMethodBeat.o(39822);
    }

    public final void xE(int i) {
        AppMethodBeat.i(39823);
        super.xE(i);
        if (VERSION.SDK_INT >= 21 && this.plv != null) {
            this.plv.setBackgroundColor(getWindow().getStatusBarColor());
            com.tencent.mm.ui.statusbar.d.a(getWindow());
        }
        AppMethodBeat.o(39823);
    }

    private void cuG() {
        AppMethodBeat.i(39824);
        if (com.tencent.mm.r.a.bH(this)) {
            AppMethodBeat.o(39824);
            return;
        }
        ab.d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "")), bo.dpG(), this);
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "")) {
            ab.d("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bo.dpG(), this);
            if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                com.tencent.mm.pluginsdk.ui.tools.n.G(this.mController.ylL, new Intent());
                AppMethodBeat.o(39824);
                return;
            }
            AppMethodBeat.o(39824);
            return;
        }
        AppMethodBeat.o(39824);
    }

    public void onBackPressed() {
        AppMethodBeat.i(39825);
        finish();
        AppMethodBeat.o(39825);
    }

    public boolean supportNavigationSwipeBack() {
        AppMethodBeat.i(39826);
        boolean supportNavigationSwipeBack = super.supportNavigationSwipeBack();
        AppMethodBeat.o(39826);
        return supportNavigationSwipeBack;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39827);
        ab.i("MicroMsg.SnsUserUI", "on activity result, %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (5985 == i && i2 == -1) {
            finish();
            AppMethodBeat.o(39827);
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.rCT.onActivityResult(i, i2, intent);
        AppMethodBeat.o(39827);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(39828);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.SnsUserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(39828);
            return;
        }
        ab.i("MicroMsg.SnsUserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 18:
                if (iArr[0] != 0) {
                    int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.dbs : R.string.dc0;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a((Context) this, getString(i2), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(39791);
                                dialogInterface.dismiss();
                                SnsUserUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                AppMethodBeat.o(39791);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(39792);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(39792);
                            }
                        });
                        break;
                    }
                }
                cuG();
                AppMethodBeat.o(39828);
                return;
                break;
        }
        AppMethodBeat.o(39828);
    }

    static /* synthetic */ void i(SnsUserUI snsUserUI) {
        AppMethodBeat.i(39829);
        snsUserUI.rCW.setVisibility(8);
        AppMethodBeat.o(39829);
    }

    static /* synthetic */ void a(SnsUserUI snsUserUI, int i, int i2) {
        int i3;
        AppMethodBeat.i(39830);
        as asVar = snsUserUI.rCS;
        if (asVar.rgf.get(Integer.valueOf(i)) == null) {
            i3 = -1;
        } else {
            i3 = ((Integer) asVar.rgf.get(Integer.valueOf(i))).intValue();
        }
        ab.d("MicroMsg.SnsUserUI", "displayYearTip position:%d alpha:%d realPos:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            Object item = snsUserUI.rCS.getItem(i3);
            if (item != null && (item instanceof com.tencent.mm.plugin.sns.storage.n)) {
                float f = ((float) i2) / 100.0f;
                if (f != snsUserUI.rCW.getAlpha()) {
                    snsUserUI.rCW.setAlpha(f);
                }
                snsUserUI.rCW.setVisibility(0);
                com.tencent.mm.plugin.sns.storage.n nVar = (com.tencent.mm.plugin.sns.storage.n) item;
                if (snsUserUI.rCY != nVar.field_head / Downloads.MIN_WAIT_FOR_NETWORK) {
                    snsUserUI.rCY = nVar.field_head / Downloads.MIN_WAIT_FOR_NETWORK;
                    snsUserUI.rCX.setText(String.format(snsUserUI.getResources().getString(R.string.eqj), new Object[]{Integer.valueOf(snsUserUI.rCY)}));
                }
            }
        }
        AppMethodBeat.o(39830);
    }

    static /* synthetic */ void b(SnsUserUI snsUserUI, final int i) {
        AppMethodBeat.i(39832);
        com.tencent.mm.ui.base.h.a((Context) snsUserUI, (int) R.string.p5, (int) R.string.tz, (int) R.string.s6, (int) R.string.or, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(39789);
                af.cnF().DL(i);
                SnsUserUI.this.rCS.crP();
                AppMethodBeat.o(39789);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(39832);
    }
}
