package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C42023mc;
import com.tencent.p177mm.p230g.p231a.C6546sd;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5257e;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5259b;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5260d;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5261a;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.model.C38944ac;
import com.tencent.p177mm.plugin.exdevice.model.C38944ac.C27846a;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1545a.C38927b;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C11643e;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C20473h;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C27833g;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C2969i;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C34025k;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C27834d;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C27835e;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C42989c;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C11646a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34028c;
import com.tencent.p177mm.plugin.sport.p1030ui.SportChartView;
import com.tencent.p177mm.plugin.sport.p1030ui.SportChartView.C29266a;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.plugin.sport.p1302a.C29259e;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.plugin.sport.p1302a.C46265c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C44146mq;
import com.tencent.p177mm.protocal.protobuf.ach;
import com.tencent.p177mm.protocal.protobuf.cdo;
import com.tencent.p177mm.protocal.protobuf.cyk;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI */
public class ExdeviceProfileUI extends MMActivity implements C27835e, C34067c {
    private static int lCl = 0;
    /* renamed from: UP */
    private boolean f4375UP = false;
    private int eOf = 0;
    private String hZn;
    private String igi;
    private String lBO;
    private C11646a lBP;
    private ArrayList<String> lBQ;
    private cyk lBR;
    private ExdeviceProfileAffectedUserView lBS;
    private ImageView lBT;
    private ListView lBU;
    private ExdeviceProfileListHeader lBV;
    private MMSwitchBtn lBW;
    private SportChartView lBX;
    private C11726a lBY;
    private View lBZ;
    private boolean lBt;
    private boolean lBu;
    private int lBv;
    private List<C44146mq> lBy;
    private volatile boolean lCa;
    private String lCb;
    private String lCc;
    private List<C29259e> lCd;
    private ArrayList<C34028c> lCe;
    private List<ach> lCf;
    private int lCg;
    private C38927b<C2969i> lCh = new C205631();
    private C5279d lCi = new C2057929();
    private C38927b<C20473h> lCj = new C1171631();
    private C38927b<C27833g> lCk = new C205812();
    private Runnable lCm = new C2056214();
    private C38927b<C27833g> lCn = new C2056815();
    private List<String> lCo;
    private C38927b<C34025k> lCp = new C2057317();
    private C34025k lCq;
    private C4884c<C42023mc> lCr = new C2058421();
    private GestureDetector lCs;
    private C5261a lCt = new C1171425();
    private boolean lvJ;
    private List<String> lvZ;
    private String lvw;
    private List<String> lwa;
    private C44275p lzK = null;
    private String mAppName;
    private Context mContext;
    /* renamed from: oz */
    private TextPaint f4376oz = new TextPaint(1);

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$12 */
    class C1171212 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$12$1 */
        class C117131 implements C36073c {
            C117131() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(20033);
                c44273l.mo70049a(0, ExdeviceProfileUI.this.getString(C25738R.string.bh2), (int) C1318a.bottomsheet_icon_transmit);
                c44273l.mo70049a(1, ExdeviceProfileUI.this.getString(C25738R.string.bh5), (int) C1318a.bottomsheet_icon_moment);
                AppMethodBeat.m2505o(20033);
            }
        }

        C1171212() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20034);
            C36356d c36356d = new C36356d(ExdeviceProfileUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C117131();
            c36356d.rBm = ExdeviceProfileUI.this.lCi;
            c36356d.cpD();
            AppMethodBeat.m2505o(20034);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$25 */
    class C1171425 implements C5261a {
        C1171425() {
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(20051);
            boolean onTouchEvent = ExdeviceProfileUI.this.lCs.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(20051);
            return onTouchEvent;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$27 */
    class C1171527 implements Runnable {
        C1171527() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20054);
            C11726a l = ExdeviceProfileUI.this.lBY;
            ArrayList p = ExdeviceProfileUI.this.lCe;
            List q = ExdeviceProfileUI.this.lBy;
            l.lBu = C45891ad.boY().mo54561Kp(l.igi);
            l.lBx = p;
            if (C5046bo.m7548ek(p)) {
                l.lBv = 0;
            } else {
                l.lBv = p.size();
            }
            l.lBy = q;
            if (!C5046bo.m7548ek(q)) {
                l.lBw = q.size();
            }
            C4990ab.m7411d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", Boolean.valueOf(l.lBu), Integer.valueOf(l.lBv), Integer.valueOf(l.lBw), l.igi);
            ExdeviceProfileUI.this.lBY.notifyDataSetChanged();
            AppMethodBeat.m2505o(20054);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$31 */
    class C1171631 implements C38927b<C20473h> {
        C1171631() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23473a(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20059);
            C4990ab.m7416i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneDelFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.finish();
            }
            AppMethodBeat.m2505o(20059);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$6 */
    class C117176 implements C5260d {
        C117176() {
        }

        public final boolean bhl() {
            AppMethodBeat.m2504i(20028);
            if (ExdeviceProfileUI.this.lBU.getFirstVisiblePosition() == 0) {
                View childAt = ExdeviceProfileUI.this.lBU.getChildAt(ExdeviceProfileUI.this.lBU.getFirstVisiblePosition());
                if (childAt != null && childAt.getTop() >= 0) {
                    AppMethodBeat.m2505o(20028);
                    return true;
                }
            }
            AppMethodBeat.m2505o(20028);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$9 */
    class C117189 implements OnScrollListener {
        C117189() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(20030);
            ExdeviceProfileUI.m31756A(ExdeviceProfileUI.this);
            AppMethodBeat.m2505o(20030);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$7 */
    class C167397 implements C5257e {
        C167397() {
        }

        public final boolean bhk() {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$14 */
    class C2056214 implements Runnable {
        C2056214() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20036);
            C4978c.m7375a(ExdeviceProfileUI.this.lBU);
            if (ExdeviceProfileUI.this.lBU.getCount() > 0) {
                C4978c.m7376b(ExdeviceProfileUI.this.lBU, ExdeviceProfileUI.this.lBU.getCount() - 1);
            }
            AppMethodBeat.m2505o(20036);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$1 */
    class C205631 implements C38927b<C2969i> {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$1$2 */
        class C29982 implements Runnable {
            C29982() {
            }

            public final void run() {
                AppMethodBeat.m2504i(20021);
                ExdeviceProfileUI.m31788g(ExdeviceProfileUI.this);
                AppMethodBeat.m2505o(20021);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$1$3 */
        class C117113 implements Runnable {
            C117113() {
            }

            public final void run() {
                AppMethodBeat.m2504i(20022);
                ExdeviceProfileUI.m31792k(ExdeviceProfileUI.this);
                ExdeviceProfileUI.this.lBY.notifyDataSetChanged();
                AppMethodBeat.m2505o(20022);
            }
        }

        C205631() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23473a(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20023);
            final C2969i c2969i = (C2969i) c1207m;
            if (ExdeviceProfileUI.this.isFinishing() || ExdeviceProfileUI.this.f4375UP) {
                ExdeviceProfileUI.m31775b(ExdeviceProfileUI.this);
                C4990ab.m7416i("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI has been destroyed.");
                AppMethodBeat.m2505o(20023);
                return;
            }
            ExdeviceProfileUI.this.lCa = true;
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(20020);
                        if (ExdeviceProfileUI.this.lzK != null) {
                            ExdeviceProfileUI.this.lzK.dismiss();
                        }
                        ExdeviceProfileUI.this.lBQ = c2969i.lvE;
                        ExdeviceProfileUI.this.lBS.setAffectedUserInfo(ExdeviceProfileUI.this.lBQ);
                        AppMethodBeat.m2505o(20020);
                    }
                });
                ExdeviceProfileUI.this.lBR = c2969i.lvD;
                ExdeviceProfileUI.this.lCb = c2969i.lvz;
                ExdeviceProfileUI.this.lCc = c2969i.lvA;
                ExdeviceProfileUI.this.lCd = ExdeviceProfileUI.m31777bz(c2969i.lvB);
                ExdeviceProfileUI.this.lBu = c2969i.lvH;
                ExdeviceProfileUI.this.lBy = c2969i.lvG;
                ExdeviceProfileUI.this.lCf = c2969i.lvF;
                ExdeviceProfileUI.this.lCg = c2969i.lvI;
                ExdeviceProfileUI.this.lvJ = c2969i.lvJ;
                ExdeviceProfileUI.this.lvw = c2969i.lvw;
                ExdeviceProfileUI.this.runOnUiThread(new C29982());
                if (!ExdeviceProfileUI.this.lBt) {
                    ExdeviceProfileUI exdeviceProfileUI = ExdeviceProfileUI.this;
                    ExdeviceProfileUI.this.lBu;
                    ExdeviceProfileUI.m31791j(exdeviceProfileUI);
                }
                ExdeviceProfileUI.this.runOnUiThread(new C117113());
                ExdeviceProfileUI.m31794m(ExdeviceProfileUI.this);
                ExdeviceProfileUI.m31775b(ExdeviceProfileUI.this);
                AppMethodBeat.m2505o(20023);
                return;
            }
            AppMethodBeat.m2505o(20023);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$20 */
    class C2056520 implements C27846a {
        C2056520() {
        }

        /* renamed from: Kj */
        public final void mo23478Kj(String str) {
            AppMethodBeat.m2504i(20044);
            ExdeviceProfileUI.m31783d(ExdeviceProfileUI.this, str);
            AppMethodBeat.m2505o(20044);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$13 */
    class C2056713 implements OnClickListener {
        C2056713() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20035);
            ExdeviceProfileUI.m31757B(ExdeviceProfileUI.this);
            AppMethodBeat.m2505o(20035);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$15 */
    class C2056815 implements C38927b<C27833g> {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$15$1 */
        class C205691 implements Runnable {
            C205691() {
            }

            public final void run() {
                AppMethodBeat.m2504i(20037);
                if (ExdeviceProfileUI.this.lzK != null) {
                    ExdeviceProfileUI.this.lzK.dismiss();
                }
                AppMethodBeat.m2505o(20037);
            }
        }

        C2056815() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23473a(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20038);
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.m31794m(ExdeviceProfileUI.this);
                ExdeviceProfileUI.m31775b(ExdeviceProfileUI.this);
                ExdeviceProfileUI.this.runOnUiThread(new C205691());
            }
            AppMethodBeat.m2505o(20038);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$28 */
    class C2057028 implements OnMenuItemClickListener {
        C2057028() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20055);
            ExdeviceProfileUI.this.finish();
            AppMethodBeat.m2505o(20055);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$30 */
    class C2057130 implements C36073c {
        C2057130() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(20058);
            if (ExdeviceProfileUI.this.lvJ) {
                c44273l.mo70068e(1, ExdeviceProfileUI.this.getString(C25738R.string.bh_));
                AppMethodBeat.m2505o(20058);
                return;
            }
            c44273l.mo70068e(4, ExdeviceProfileUI.this.getString(C25738R.string.bhf));
            AppMethodBeat.m2505o(20058);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$8 */
    class C205728 implements C5259b {
        C205728() {
        }

        public final void bpT() {
            AppMethodBeat.m2504i(20029);
            ExdeviceProfileUI.m31756A(ExdeviceProfileUI.this);
            AppMethodBeat.m2505o(20029);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$17 */
    class C2057317 implements C38927b<C34025k> {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$17$1 */
        class C205741 implements Runnable {
            C205741() {
            }

            public final void run() {
                AppMethodBeat.m2504i(20040);
                if (ExdeviceProfileUI.this.lzK != null) {
                    ExdeviceProfileUI.this.lzK.dismiss();
                }
                AppMethodBeat.m2505o(20040);
            }
        }

        C2057317() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23473a(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20041);
            C34025k c34025k = (C34025k) c1207m;
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.lCo = c34025k.lwb;
                ExdeviceProfileUI.this.lvZ = c34025k.lvZ;
                ExdeviceProfileUI.this.lwa = c34025k.lwa;
                ExdeviceProfileUI.this.runOnUiThread(new C205741());
                ExdeviceProfileUI.m31760E(ExdeviceProfileUI.this);
            }
            AppMethodBeat.m2505o(20041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$18 */
    class C2057518 implements Runnable {
        C2057518() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20042);
            if (ExdeviceProfileUI.this.lzK != null) {
                ExdeviceProfileUI.this.lzK.show();
            }
            AppMethodBeat.m2505o(20042);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$19 */
    class C2057619 implements C27846a {
        C2057619() {
        }

        /* renamed from: Kj */
        public final void mo23478Kj(String str) {
            AppMethodBeat.m2504i(20043);
            Intent intent = new Intent();
            intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
            intent.putExtra("Ksnsupload_appname", ExdeviceProfileUI.this.getString(C25738R.string.bij));
            intent.putExtra("Ksnsupload_source", 1);
            intent.putExtra("need_result", true);
            String nW = C37922v.m64078nW("wx_sport");
            C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", "wx_sport");
            intent.putExtra("reportSessionId", nW);
            intent.putExtra("Ksnsupload_type", 0);
            intent.putExtra("sns_kemdia_path", str);
            C25985d.m41468b(ExdeviceProfileUI.this, "sns", ".ui.SnsUploadUI", intent, 2);
            AppMethodBeat.m2505o(20043);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$26 */
    class C2057726 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$26$1 */
        class C205661 implements C36073c {
            C205661() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(20052);
                if (!C5046bo.isNullOrNil(ExdeviceProfileUI.this.lvw)) {
                    c44273l.mo70068e(5, ExdeviceProfileUI.this.getString(C25738R.string.bha));
                }
                c44273l.mo70068e(3, ExdeviceProfileUI.this.getString(C25738R.string.bh7));
                AppMethodBeat.m2505o(20052);
            }
        }

        C2057726() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20053);
            C36356d c36356d = new C36356d(ExdeviceProfileUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C205661();
            c36356d.rBm = ExdeviceProfileUI.this.lCi;
            c36356d.cpD();
            AppMethodBeat.m2505o(20053);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$16 */
    class C2057816 implements Runnable {
        C2057816() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20039);
            ExdeviceProfileUI.m31758C(ExdeviceProfileUI.this);
            ExdeviceProfileUI.this.lBY.notifyDataSetChanged();
            ExdeviceProfileUI.m31759D(ExdeviceProfileUI.this);
            AppMethodBeat.m2505o(20039);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$29 */
    class C2057929 implements C5279d {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$29$1 */
        class C29991 implements DialogInterface.OnClickListener {
            C29991() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(20056);
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(ExdeviceProfileUI.this.igi);
                C22162d.m33785kT(37);
                C1855t.m3891g(aoO);
                ExdeviceProfileUI.this.lCr.dnU();
                if (ExdeviceProfileUI.this.lzK != null) {
                    ExdeviceProfileUI.this.lzK.show();
                }
                AppMethodBeat.m2505o(20056);
            }
        }

        C2057929() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(20057);
            switch (menuItem.getItemId()) {
                case 0:
                    C22162d.m33785kT(26);
                    ExdeviceProfileUI.m31800s(ExdeviceProfileUI.this);
                    AppMethodBeat.m2505o(20057);
                    return;
                case 1:
                    C22162d.m33785kT(27);
                    ExdeviceProfileUI.m31799r(ExdeviceProfileUI.this);
                    AppMethodBeat.m2505o(20057);
                    return;
                case 2:
                    ExdeviceProfileUI.m31801t(ExdeviceProfileUI.this);
                    AppMethodBeat.m2505o(20057);
                    return;
                case 3:
                    C30379h.m48449a(ExdeviceProfileUI.this.mController.ylL, ExdeviceProfileUI.this.getString(C25738R.string.bih), null, true, new C29991(), null);
                    AppMethodBeat.m2505o(20057);
                    return;
                case 4:
                    ExdeviceProfileUI.this.lvJ = true;
                    C22162d.m33785kT(10);
                    C45891ad.bpe();
                    C42989c.m76340d("", ExdeviceProfileUI.this.mAppName, ExdeviceProfileUI.this.igi, 3);
                    AppMethodBeat.m2505o(20057);
                    return;
                case 5:
                    C22162d.m33785kT(41);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ExdeviceProfileUI.this.lvw);
                    C25985d.m41467b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    break;
            }
            AppMethodBeat.m2505o(20057);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$4 */
    class C205804 implements OnCancelListener {
        C205804() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(20026);
            if (ExdeviceProfileUI.this.lzK != null) {
                ExdeviceProfileUI.this.lzK.dismiss();
                ExdeviceProfileUI.this.lzK = null;
            }
            ExdeviceProfileUI.this.finish();
            AppMethodBeat.m2505o(20026);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$2 */
    class C205812 implements C38927b<C27833g> {
        C205812() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23473a(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20024);
            C4990ab.m7416i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneAddFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.finish();
            }
            AppMethodBeat.m2505o(20024);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$10 */
    class C2058210 implements OnClickListener {
        C2058210() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20031);
            C11643e.m19459e(ExdeviceProfileUI.this);
            AppMethodBeat.m2505o(20031);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$11 */
    class C2058311 implements OnClickListener {
        C2058311() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20032);
            C22162d.m33785kT(18);
            C11643e.m19459e(ExdeviceProfileUI.this);
            AppMethodBeat.m2505o(20032);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$21 */
    class C2058421 extends C4884c<C42023mc> {
        C2058421() {
            AppMethodBeat.m2504i(20045);
            this.xxI = C42023mc.class.getName().hashCode();
            AppMethodBeat.m2505o(20045);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20046);
            C42023mc c42023mc = (C42023mc) c4883b;
            C4990ab.m7417i("MicroMsg.Sport.ExdeviceProfileUI", "count: %d ret: %s title: %s content: %s", Integer.valueOf(c42023mc.cHU.count), Integer.valueOf(c42023mc.cHU.ret), c42023mc.cHU.cHV, c42023mc.cHU.cHW);
            if (ExdeviceProfileUI.this.lzK != null && ExdeviceProfileUI.this.lzK.isShowing()) {
                ExdeviceProfileUI.this.lzK.dismiss();
            }
            ExdeviceProfileUI.this.lCr.dead();
            Intent intent = new Intent();
            intent.putExtra("KeyNeedUpdateRank", true);
            ExdeviceProfileUI.this.setResult(-1, intent);
            ExdeviceProfileUI.this.finish();
            AppMethodBeat.m2505o(20046);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$22 */
    class C2058522 implements C30795a {
        C2058522() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(20047);
            if (ExdeviceProfileUI.this.lCd != null) {
                if (z) {
                    ExdeviceProfileUI.this.lBX.mo74386a(C29266a.MONTH);
                } else {
                    ExdeviceProfileUI.this.lBX.mo74386a(C29266a.WEEK);
                }
            }
            ExdeviceProfileUI.this.lBX.mo74387dD(ExdeviceProfileUI.this.lCd);
            AppMethodBeat.m2505o(20047);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$23 */
    class C2058623 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$23$1 */
        class C205871 implements C36073c {
            C205871() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(20048);
                c44273l.mo70068e(2, ExdeviceProfileUI.this.getString(C25738R.string.bhb));
                AppMethodBeat.m2505o(20048);
            }
        }

        C2058623() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20049);
            C36356d c36356d = new C36356d(ExdeviceProfileUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C205871();
            c36356d.rBm = ExdeviceProfileUI.this.lCi;
            c36356d.cpD();
            AppMethodBeat.m2505o(20049);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$3 */
    class C205883 implements Runnable {
        C205883() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20025);
            ExdeviceProfileUI.m31788g(ExdeviceProfileUI.this);
            ExdeviceProfileUI.this.lBY.notifyDataSetChanged();
            AppMethodBeat.m2505o(20025);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$5 */
    class C205895 implements C5258c {
        C205895() {
        }

        public final boolean bhm() {
            AppMethodBeat.m2504i(20027);
            View childAt = ExdeviceProfileUI.this.lBU.getChildAt(ExdeviceProfileUI.this.lBU.getChildCount() - 1);
            int count = ExdeviceProfileUI.this.lBU.getAdapter().getCount();
            if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceProfileUI.this.lBU.getHeight() || ExdeviceProfileUI.this.lBU.getLastVisiblePosition() < count - 1) {
                AppMethodBeat.m2505o(20027);
                return false;
            }
            AppMethodBeat.m2505o(20027);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI$a */
    class C20590a extends SimpleOnGestureListener {
        private C20590a() {
        }

        /* synthetic */ C20590a(ExdeviceProfileUI exdeviceProfileUI, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(20060);
            if (Math.abs(f2) < Math.abs(f)) {
                AppMethodBeat.m2505o(20060);
                return true;
            }
            AppMethodBeat.m2505o(20060);
            return false;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ExdeviceProfileUI() {
        AppMethodBeat.m2504i(20061);
        AppMethodBeat.m2505o(20061);
    }

    /* renamed from: C */
    static /* synthetic */ void m31758C(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20087);
        exdeviceProfileUI.bpP();
        AppMethodBeat.m2505o(20087);
    }

    /* renamed from: D */
    static /* synthetic */ void m31759D(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20088);
        exdeviceProfileUI.bpQ();
        AppMethodBeat.m2505o(20088);
    }

    /* renamed from: a */
    static /* synthetic */ void m31770a(ExdeviceProfileUI exdeviceProfileUI, long j, long j2) {
        AppMethodBeat.m2504i(20091);
        exdeviceProfileUI.m31764I(j, j2);
        AppMethodBeat.m2505o(20091);
    }

    /* renamed from: b */
    static /* synthetic */ void m31775b(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20076);
        exdeviceProfileUI.bpN();
        AppMethodBeat.m2505o(20076);
    }

    /* renamed from: j */
    static /* synthetic */ void m31791j(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20079);
        exdeviceProfileUI.bpO();
        AppMethodBeat.m2505o(20079);
    }

    /* renamed from: m */
    static /* synthetic */ void m31794m(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20081);
        exdeviceProfileUI.bpM();
        AppMethodBeat.m2505o(20081);
    }

    public void onCreate(Bundle bundle) {
        int dimensionPixelSize;
        CharSequence string;
        AppMethodBeat.m2504i(20062);
        super.onCreate(bundle);
        this.mContext = this.mController.ylL;
        Intent intent = getIntent();
        bpM();
        this.igi = intent.getStringExtra("username");
        this.lBO = intent.getStringExtra("usernickname");
        String Yz = C1853r.m3846Yz();
        if (Yz != null) {
            this.lBt = Yz.equals(this.igi);
        }
        this.mAppName = getIntent().getStringExtra("app_username");
        this.lBu = C45891ad.boY().mo54561Kp(this.igi);
        C4990ab.m7411d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", Boolean.valueOf(this.lBu));
        Assert.assertTrue(!C5046bo.isNullOrNil(this.igi));
        this.lBP = C45891ad.bpa().mo61824Kr(this.igi);
        this.lBQ = getIntent().getStringArrayListExtra("key_affected_semi");
        getString(C25738R.string.f9238tz);
        this.lzK = C30379h.m48457b(this, getString(C25738R.string.cn5), new C205804());
        this.lBS = (ExdeviceProfileAffectedUserView) findViewById(2131823703);
        this.lBT = (ImageView) findViewById(2131823700);
        this.lBU = (ListView) findViewById(2131823702);
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(2131823138);
        this.lBS.setAffectedUserInfo(this.lBQ);
        bpQ();
        this.lBZ = findViewById(2131823701);
        this.lCs = new GestureDetector(this.mController.ylL, new C20590a(this, (byte) 0));
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setTopViewVisible(false);
        mMPullDownView.setBottomViewVisible(false);
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setIsTopShowAll(false);
        mMPullDownView.setCanOverScrool(true);
        mMPullDownView.setOnInterceptTouchEventListener(this.lCt);
        mMPullDownView.setAtBottomCallBack(new C205895());
        mMPullDownView.setAtTopCallBack(new C117176());
        mMPullDownView.setOnBottomLoadDataListener(new C167397());
        mMPullDownView.setOnScrollChangedListener(new C205728());
        ExdeviceProfileListHeader exdeviceProfileListHeader = new ExdeviceProfileListHeader(this);
        int J = C42992b.m76345J(this, getResources().getDimensionPixelSize(C25738R.dimen.f9821gt));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C25738R.dimen.f9830h3);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(C25738R.dimen.f9829h2);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        dimensionPixelSize2 = ((((defaultDisplay.getHeight() / 2) - J) - dimensionPixelSize) - (dimensionPixelSize2 / 2)) - dimensionPixelSize3;
        if (defaultDisplay.getHeight() <= 0 || dimensionPixelSize2 <= 0) {
            dimensionPixelSize2 = getResources().getDimensionPixelSize(C25738R.dimen.f9815gn);
        }
        exdeviceProfileListHeader.setMinimumHeight(dimensionPixelSize2);
        exdeviceProfileListHeader.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceProfileListHeader.setTag(Integer.valueOf(((defaultDisplay.getHeight() / 2) - J) - dimensionPixelSize));
        this.lBV = exdeviceProfileListHeader;
        this.lBU.addHeaderView(this.lBV, null, false);
        this.lBY = new C11726a(this.mController.ylL, this.mAppName, this.lBt, this.igi);
        this.lBY.lBs = this;
        this.lBU.setAdapter(this.lBY);
        this.lBU.setOnScrollListener(new C117189());
        this.lBS.setUsername(this.igi);
        this.lBZ.setOnClickListener(new C2058210());
        mMPullDownView.setCanOverScrool(false);
        this.lBT.setLayoutParams(new LayoutParams(C1338a.m2868gd(this), ((Integer) this.lBV.getTag()).intValue()));
        bpP();
        C45891ad.bpf().mo61821a(this);
        C9638aw.m17182Rg().mo14541a(new C2969i(this.igi, C5046bo.nullAsNil(this.mAppName), this.lCh), 0);
        try {
            this.eOf = getResources().getDimensionPixelSize(C25738R.dimen.f9838hb);
            if (this.eOf <= 0) {
                this.eOf = 60;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", e, "", new Object[0]);
            if (this.eOf <= 0) {
                this.eOf = 60;
            }
        } catch (Throwable th) {
            if (this.eOf <= 0) {
                this.eOf = 60;
            }
            AppMethodBeat.m2505o(20062);
        }
        C4990ab.m7411d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", Integer.valueOf(this.eOf));
        if (this.lBt) {
            string = getString(C25738R.string.bhg);
        } else {
            Object[] objArr = new Object[1];
            Yz = this.igi;
            int i = this.eOf;
            CharSequence mJ = C1854s.m3866mJ(Yz);
            if (!Yz.equalsIgnoreCase(mJ) || C5046bo.isNullOrNil(this.lBO)) {
                string = C44089j.m79292b(this.mController.ylL, mJ);
            } else {
                string = C44089j.m79292b(this.mController.ylL, this.lBO);
            }
            C4990ab.m7411d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", Integer.valueOf(i), string, TextUtils.ellipsize(string, this.f4376oz, (float) i, TruncateAt.END));
            objArr[0] = mJ;
            string = C44089j.m79292b((Context) this, getString(C25738R.string.bhk, objArr));
        }
        mo17368M(string);
        setBackBtn(new C2057028());
        C4990ab.m7416i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.igi);
        if (C1853r.m3846Yz().equals(this.igi)) {
            C4883b c6546sd = new C6546sd();
            c6546sd.cOe.action = 3;
            C4879a.xxA.mo10049a(c6546sd, C7305d.xDG.cin());
        }
        AppMethodBeat.m2505o(20062);
    }

    private void bpM() {
        AppMethodBeat.m2504i(20063);
        this.lCe = C45891ad.boY().bpk();
        if (this.lCe != null) {
            C4990ab.m7411d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", Integer.valueOf(this.lCe.size()), this.lCe.toString());
        } else {
            C4990ab.m7410d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
        }
        if (C5046bo.m7548ek(this.lCe)) {
            this.lBv = 0;
            AppMethodBeat.m2505o(20063);
            return;
        }
        this.lBv = this.lCe.size();
        AppMethodBeat.m2505o(20063);
    }

    private void bpN() {
        AppMethodBeat.m2504i(20064);
        runOnUiThread(new C1171527());
        AppMethodBeat.m2505o(20064);
    }

    public void onPause() {
        AppMethodBeat.m2504i(20065);
        super.onPause();
        AppMethodBeat.m2505o(20065);
    }

    public void onResume() {
        AppMethodBeat.m2504i(20066);
        super.onResume();
        C4990ab.m7418v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
        bpM();
        bpN();
        if (!this.lBt) {
            C45891ad.boY().mo54561Kp(this.igi);
            bpO();
        }
        AppMethodBeat.m2505o(20066);
    }

    private void bpO() {
        AppMethodBeat.m2504i(20067);
        runOnUiThread(new C205883());
        AppMethodBeat.m2505o(20067);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(20068);
        if (this.lCq != null) {
            C9638aw.m17182Rg().mo14547c(this.lCq);
        }
        this.lCr.dead();
        this.f4375UP = true;
        super.onDestroy();
        C45891ad.bpf().mo61823b(this);
        AppMethodBeat.m2505o(20068);
    }

    private void bpP() {
        AppMethodBeat.m2504i(20069);
        String Yz = C1853r.m3846Yz();
        if (this.lBZ != null) {
            this.lBZ.setVisibility(8);
        }
        if (!C5046bo.isNullOrNil(Yz) && Yz.equals(this.igi)) {
            if (!(this.lBP == null || !C5046bo.isNullOrNil(this.lBP.field_championUrl) || this.lBZ == null)) {
                this.lBZ.setVisibility(0);
            }
            if (this.lBV != null) {
                this.lBV.setOnClickListener(new C2058311());
                AppMethodBeat.m2505o(20069);
                return;
            }
        } else if (!(this.lBP == null || C5046bo.isNullOrNil(this.lBP.field_championUrl) || this.lBV == null)) {
            this.lBV.setOnClickListener(new C2056713());
        }
        AppMethodBeat.m2505o(20069);
    }

    private void bpQ() {
        AppMethodBeat.m2504i(20070);
        if (this.lBP == null) {
            this.lBT.setImageResource(C25738R.color.f11911le);
            this.hZn = null;
        } else if (this.hZn != this.lBP.field_championUrl && (this.hZn == null || !this.hZn.equals(this.lBP.field_championUrl))) {
            C11643e.m19456a(this, this.lBT, this.lBP.field_championUrl);
            this.hZn = this.lBP.field_championUrl;
            AppMethodBeat.m2505o(20070);
            return;
        }
        AppMethodBeat.m2505o(20070);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(20071);
        super.onActivityResult(i, i2, intent);
        if (C11643e.m19457a(this, i, i2, intent, this.mAppName)) {
            AppMethodBeat.m2505o(20071);
            return;
        }
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String str;
                    if (intent == null) {
                        str = null;
                    } else {
                        str = intent.getStringExtra("Select_Conv_User");
                    }
                    String dG = C38944ac.m66115dG(this);
                    if (str == null || str.length() == 0) {
                        C4990ab.m7412e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
                        AppMethodBeat.m2505o(20071);
                        return;
                    }
                    C38944ac.m66114a((Context) this, str, dG, intent.getStringExtra("custom_send_text"), this.lCc);
                    C30379h.m48465bQ(this.mController.ylL, getResources().getString(C25738R.string.f9229to));
                    AppMethodBeat.m2505o(20071);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    Toast.makeText(this, C25738R.string.egv, 1).show();
                    AppMethodBeat.m2505o(20071);
                    return;
                }
                break;
            case 3:
                if (i2 == -1) {
                    ArrayList P = C5046bo.m7508P(intent.getStringExtra("Select_Contact").split(","));
                    if (P != null) {
                        if (this.lzK != null) {
                            this.lzK.show();
                        }
                        C9638aw.m17182Rg().mo14541a(new C27833g(P, this.lCn), 0);
                        break;
                    }
                    AppMethodBeat.m2505o(20071);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(20071);
    }

    public final int getLayoutId() {
        return 2130969433;
    }

    /* renamed from: b */
    public final void mo30744b(String str, C27834d c27834d) {
        AppMethodBeat.m2504i(20072);
        if ("HardDeviceChampionInfo".equals(str) && this.igi.equals(c27834d.username)) {
            C4990ab.m7410d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
            this.lBP = C45891ad.bpa().mo61824Kr(this.igi);
            runOnUiThread(new C2057816());
        }
        AppMethodBeat.m2505o(20072);
    }

    /* renamed from: I */
    private void m31764I(long j, long j2) {
        AppMethodBeat.m2504i(20075);
        List<C29259e> V = ((C39858b) C1720g.m3528K(C39858b.class)).mo63047V(j, j2);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        if (this.lCd != null) {
            for (C29259e c29259e : this.lCd) {
                if (hashSet.add(c29259e.field_date)) {
                    arrayList.add(c29259e);
                }
            }
        }
        for (C29259e c29259e2 : V) {
            if (hashSet.add(c29259e2.field_date)) {
                arrayList.add(c29259e2);
            }
        }
        Collections.sort(arrayList);
        this.lCd = arrayList;
        if (this.lBX != null) {
            this.lBX.mo74387dD(this.lCd);
        }
        AppMethodBeat.m2505o(20075);
    }

    public final void bpR() {
        AppMethodBeat.m2504i(20073);
        runOnUiThread(new C2057518());
        if (this.lCq != null) {
            C9638aw.m17182Rg().mo14547c(this.lCq);
        }
        this.lCq = new C34025k(this.lCp);
        C9638aw.m17182Rg().mo14541a(this.lCq, 0);
        AppMethodBeat.m2505o(20073);
    }

    public final void bpS() {
        AppMethodBeat.m2504i(20074);
        C22162d.m33785kT(17);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.igi);
        C9638aw.m17182Rg().mo14541a(new C27833g(arrayList, this.lCk), 0);
        AppMethodBeat.m2505o(20074);
    }

    /* renamed from: bz */
    static /* synthetic */ List m31777bz(List list) {
        AppMethodBeat.m2504i(20077);
        ArrayList arrayList = new ArrayList();
        for (cdo cdo : list) {
            C29259e c29259e = new C29259e();
            c29259e.field_step = cdo.hzv;
            c29259e.field_timestamp = ((long) cdo.timestamp) * 1000;
            c29259e.field_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(c29259e.field_timestamp));
            arrayList.add(c29259e);
        }
        AppMethodBeat.m2505o(20077);
        return arrayList;
    }

    /* renamed from: g */
    static /* synthetic */ void m31788g(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20078);
        exdeviceProfileUI.mController.removeAllOptionMenu();
        if (C1853r.m3846Yz().equals(exdeviceProfileUI.igi)) {
            exdeviceProfileUI.addIconOptionMenu(0, C25738R.drawable.f6899uu, new C1171212());
            AppMethodBeat.m2505o(20078);
            return;
        }
        C9638aw.m17190ZK();
        boolean aoJ = C18628c.m29078XM().aoJ(exdeviceProfileUI.igi);
        C9638aw.m17190ZK();
        boolean Ob = C18628c.m29078XM().aoO(exdeviceProfileUI.igi).mo16699Ob();
        if (exdeviceProfileUI.lBu && aoJ) {
            exdeviceProfileUI.addIconOptionMenu(0, C25738R.drawable.f6899uu, new C2058623());
            AppMethodBeat.m2505o(20078);
            return;
        }
        if (!Ob) {
            exdeviceProfileUI.addIconOptionMenu(0, C25738R.drawable.f6899uu, new C2057726());
        }
        AppMethodBeat.m2505o(20078);
    }

    /* renamed from: k */
    static /* synthetic */ void m31792k(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20080);
        if (exdeviceProfileUI.lBX == null) {
            exdeviceProfileUI.lBX = (SportChartView) exdeviceProfileUI.findViewById(2131823695);
        }
        if (exdeviceProfileUI.lBX != null) {
            if (exdeviceProfileUI.lBW == null) {
                exdeviceProfileUI.lBW = (MMSwitchBtn) exdeviceProfileUI.findViewById(2131823696);
            }
            if (exdeviceProfileUI.lCd == null || exdeviceProfileUI.lCd.size() <= 0) {
                exdeviceProfileUI.lBX.setHasSwitchBtn(false);
                exdeviceProfileUI.lBW.setVisibility(8);
                exdeviceProfileUI.lBX.mo74387dD(null);
            } else {
                if (exdeviceProfileUI.lBt) {
                    exdeviceProfileUI.lBX.setHasSwitchBtn(true);
                    exdeviceProfileUI.lBW.setVisibility(0);
                    exdeviceProfileUI.lBW.setSwitchListener(new C2058522());
                } else {
                    exdeviceProfileUI.lBX.setHasSwitchBtn(false);
                    exdeviceProfileUI.lBW.setVisibility(8);
                    exdeviceProfileUI.lBX.mo74386a(C29266a.WEEK);
                    exdeviceProfileUI.lBX.mo74387dD(exdeviceProfileUI.lCd);
                }
                exdeviceProfileUI.lBX.setTodayStep(((C29259e) exdeviceProfileUI.lCd.get(exdeviceProfileUI.lCd.size() - 1)).field_step);
                exdeviceProfileUI.lBX.mo74387dD(exdeviceProfileUI.lCd);
                C29259e cwb = ((C39858b) C1720g.m3528K(C39858b.class)).cwb();
                Calendar instance = Calendar.getInstance();
                instance.add(5, -1);
                instance.set(10, 23);
                instance.set(12, 59);
                instance.set(13, 59);
                final long timeInMillis = instance.getTimeInMillis();
                instance.add(5, -120);
                instance.set(10, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                final long timeInMillis2 = instance.getTimeInMillis();
                if (cwb != null) {
                    instance.setTimeInMillis(cwb.field_timestamp);
                    instance.add(5, 2);
                    if (instance.getTimeInMillis() > timeInMillis) {
                        exdeviceProfileUI.m31764I(timeInMillis2, timeInMillis);
                        AppMethodBeat.m2505o(20080);
                        return;
                    }
                }
                ((C39858b) C1720g.m3528K(C39858b.class)).mo63048a(timeInMillis2, timeInMillis, new C46265c() {
                    /* renamed from: wL */
                    public final void mo35855wL() {
                        AppMethodBeat.m2504i(20050);
                        ExdeviceProfileUI.m31770a(ExdeviceProfileUI.this, timeInMillis2, timeInMillis);
                        AppMethodBeat.m2505o(20050);
                    }
                });
                AppMethodBeat.m2505o(20080);
                return;
            }
        }
        AppMethodBeat.m2505o(20080);
    }

    /* renamed from: r */
    static /* synthetic */ void m31799r(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20082);
        C38944ac c38944ac = new C38944ac();
        String valueOf = String.valueOf(exdeviceProfileUI.lCg);
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (exdeviceProfileUI.lBR != null) {
            str = String.valueOf(exdeviceProfileUI.lBR.score);
        }
        c38944ac.mo61828a((Context) exdeviceProfileUI, valueOf, str, exdeviceProfileUI.hZn, new C2057619());
        AppMethodBeat.m2505o(20082);
    }

    /* renamed from: s */
    static /* synthetic */ void m31800s(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20083);
        String valueOf = String.valueOf(exdeviceProfileUI.lCg);
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (exdeviceProfileUI.lBR != null) {
            str = String.valueOf(exdeviceProfileUI.lBR.score);
        }
        new C38944ac().mo61828a((Context) exdeviceProfileUI, valueOf, str, exdeviceProfileUI.hZn, new C2056520());
        AppMethodBeat.m2505o(20083);
    }

    /* renamed from: t */
    static /* synthetic */ void m31801t(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20084);
        C4990ab.m7417i("MicroMsg.Sport.ExdeviceProfileUI", "ap: start to del: %s", exdeviceProfileUI.igi);
        C9638aw.m17182Rg().mo14541a(new C20473h(exdeviceProfileUI.igi, exdeviceProfileUI.lCj), 0);
        AppMethodBeat.m2505o(20084);
    }

    /* renamed from: A */
    static /* synthetic */ void m31756A(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20085);
        if (VERSION.SDK_INT >= 11) {
            View childAt = exdeviceProfileUI.lBU.getChildAt(0);
            int[] iArr = new int[2];
            if (childAt != null && exdeviceProfileUI.lBU.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (lCl == 0) {
                    lCl = iArr[1];
                }
                int i = iArr[1];
                if (i > (-lCl) / 2) {
                    float f;
                    if (i > 0) {
                        f = ((float) (i * 2)) / (((float) lCl) * 2.0f);
                    } else {
                        f = ((float) i) / ((float) lCl);
                    }
                    exdeviceProfileUI.lBS.setAlpha(f);
                    exdeviceProfileUI.lBS.setVisibility(0);
                    AppMethodBeat.m2505o(20085);
                    return;
                }
                exdeviceProfileUI.lBS.setAlpha(0.0f);
                exdeviceProfileUI.lBS.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(20085);
    }

    /* renamed from: B */
    static /* synthetic */ void m31757B(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20086);
        C36356d c36356d = new C36356d(exdeviceProfileUI.mController.ylL, 1, false);
        c36356d.rBl = new C2057130();
        c36356d.rBm = exdeviceProfileUI.lCi;
        c36356d.cpD();
        AppMethodBeat.m2505o(20086);
    }

    /* renamed from: E */
    static /* synthetic */ void m31760E(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.m2504i(20089);
        Intent intent = new Intent();
        String c = C5046bo.m7536c(exdeviceProfileUI.lCo, ",");
        intent.putExtra("wechat_sport_contact", C5046bo.m7536c(exdeviceProfileUI.lvZ, ","));
        intent.putExtra("wechat_sport_recent_like", c);
        c = C5046bo.m7536c(exdeviceProfileUI.lwa, ",");
        intent.putExtra("titile", exdeviceProfileUI.getString(C25738R.string.bei));
        intent.putExtra("list_type", 12);
        intent.putExtra("max_limit_num", 10);
        intent.putExtra("too_many_member_tip_string", exdeviceProfileUI.getString(C25738R.string.bel, new Object[]{Integer.valueOf(10)}));
        intent.putExtra("list_attr", C15830s.m24190C(2, 4, 1, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 128, 64, 16384));
        intent.putExtra("always_select_contact", c);
        C25985d.m41466b((Context) exdeviceProfileUI, ".ui.contact.SelectContactUI", intent, 3);
        AppMethodBeat.m2505o(20089);
    }
}
