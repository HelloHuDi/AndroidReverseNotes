package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
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
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C6546sd;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5259b;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5260d;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5261a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.exdevice.model.C38944ac;
import com.tencent.p177mm.plugin.exdevice.model.C38944ac.C27846a;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1545a.C38927b;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C11643e;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C34023j;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C34023j.C34024a;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C38934a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C11647f;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C27834d;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C27835e;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C42989c;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b.C45882d;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C11646a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34028c;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34029d;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI */
public class ExdeviceRankInfoUI extends MMActivity implements C34024a, C27835e, C11647f, C34068d {
    private static int lCl = 128;
    /* renamed from: UP */
    private boolean f3574UP;
    private String hZn;
    private String igi;
    private ImageView lBT;
    private View lBZ;
    private Map<String, String> lCE = new HashMap();
    private String lCb;
    private String lCc;
    private C38927b<C34023j> lDA = new C1675812();
    private int lDB;
    private ListView lDf;
    private C11737b lDg;
    private View lDh;
    private ExdeviceRankListHeaderView lDi;
    private ExdeviceRankChampionInfoView lDj;
    private View lDk;
    private String lDl;
    private String lDm;
    private String lDn;
    private String lDo;
    private C11646a lDp;
    private String lDq;
    private int lDr;
    private List<C45897e> lDs;
    private ArrayList<C34028c> lDt;
    private ArrayList<C34029d> lDu;
    private boolean lDv;
    private boolean lDw;
    private String lDx;
    private boolean lDy;
    private C34023j lDz;
    private boolean lvJ;
    public boolean lvV;
    public String lvW;
    private C44275p lzK = null;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$13 */
    class C1172113 implements C27846a {
        C1172113() {
        }

        /* renamed from: Kj */
        public final void mo23478Kj(String str) {
            AppMethodBeat.m2504i(20151);
            ExdeviceRankInfoUI.m25795c(ExdeviceRankInfoUI.this, str);
            AppMethodBeat.m2505o(20151);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$14 */
    class C1172214 implements Runnable {
        C1172214() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20152);
            if (ExdeviceRankInfoUI.this.lzK != null && ExdeviceRankInfoUI.this.lzK.isShowing()) {
                ExdeviceRankInfoUI.this.lzK.dismiss();
                ExdeviceRankInfoUI.this.lzK = null;
                C4990ab.m7410d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
            }
            AppMethodBeat.m2505o(20152);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$15 */
    class C1172315 implements Runnable {
        C1172315() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20153);
            ExdeviceRankInfoUI.this.lDg.lCD = ExdeviceRankInfoUI.this.lDs;
            ExdeviceRankInfoUI.this.lDg.notifyDataSetChanged();
            ExdeviceRankInfoUI.m25794c(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20153);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$16 */
    class C1172416 implements C36073c {
        C1172416() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(20154);
            if (ExdeviceRankInfoUI.this.lvJ) {
                c44273l.mo70068e(1, ExdeviceRankInfoUI.this.getString(C25738R.string.bh_));
                AppMethodBeat.m2505o(20154);
                return;
            }
            c44273l.mo70068e(0, ExdeviceRankInfoUI.this.getString(C25738R.string.bhf));
            AppMethodBeat.m2505o(20154);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$20 */
    class C1674020 implements C5279d {
        C1674020() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(20158);
            switch (menuItem.getItemId()) {
                case 0:
                    C22162d.m33785kT(15);
                    ExdeviceRankInfoUI.m25808n(ExdeviceRankInfoUI.this);
                    AppMethodBeat.m2505o(20158);
                    return;
                case 1:
                    C22162d.m33785kT(16);
                    ExdeviceRankInfoUI.m25807m(ExdeviceRankInfoUI.this);
                    AppMethodBeat.m2505o(20158);
                    return;
                case 2:
                    C22162d.m33785kT(7);
                    ExdeviceRankInfoUI.m25809o(ExdeviceRankInfoUI.this);
                    AppMethodBeat.m2505o(20158);
                    return;
                case 3:
                    C22162d.m33785kT(36);
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(null, "gh_1f9ebf140e39@app", null, 0, 0, null, appBrandStatObject);
                    break;
            }
            AppMethodBeat.m2505o(20158);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$21 */
    class C1674121 implements OnClickListener {
        C1674121() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20159);
            C11643e.m19459e(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20159);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$3 */
    class C167423 implements C5259b {
        C167423() {
        }

        public final void bpT() {
            AppMethodBeat.m2504i(20136);
            ExdeviceRankInfoUI.m25812r(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$5 */
    class C167435 implements OnScrollListener {
        C167435() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(20138);
            ExdeviceRankInfoUI.m25812r(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20138);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(20139);
            ExdeviceRankInfoUI.m25812r(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20139);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$4 */
    class C167444 implements C5260d {
        C167444() {
        }

        public final boolean bhl() {
            AppMethodBeat.m2504i(20137);
            int firstVisiblePosition = ExdeviceRankInfoUI.this.lDf.getFirstVisiblePosition();
            if (firstVisiblePosition == 0) {
                View childAt = ExdeviceRankInfoUI.this.lDf.getChildAt(firstVisiblePosition);
                if (childAt != null && childAt.getTop() >= 0) {
                    AppMethodBeat.m2505o(20137);
                    return true;
                }
            }
            AppMethodBeat.m2505o(20137);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$17 */
    class C1674517 implements C5279d {
        C1674517() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(20155);
            if (ExdeviceRankInfoUI.this.lDp == null) {
                AppMethodBeat.m2505o(20155);
                return;
            }
            switch (i) {
                case 0:
                    ExdeviceRankInfoUI.this.lvJ = true;
                    C22162d.m33785kT(10);
                    C45891ad.bpe();
                    C42989c.m76340d("", ExdeviceRankInfoUI.this.lDn, ExdeviceRankInfoUI.this.lDp.field_username, 3);
                    break;
            }
            AppMethodBeat.m2505o(20155);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$18 */
    class C1674618 implements OnMenuItemClickListener {
        C1674618() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20156);
            ExdeviceRankInfoUI.this.finish();
            AppMethodBeat.m2505o(20156);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$2 */
    class C167472 implements C5258c {
        C167472() {
        }

        public final boolean bhm() {
            AppMethodBeat.m2504i(20135);
            View childAt = ExdeviceRankInfoUI.this.lDf.getChildAt(ExdeviceRankInfoUI.this.lDf.getChildCount() - 1);
            int count = ExdeviceRankInfoUI.this.lDf.getCount();
            if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceRankInfoUI.this.lDf.getHeight() || ExdeviceRankInfoUI.this.lDf.getLastVisiblePosition() != count - 1) {
                AppMethodBeat.m2505o(20135);
                return false;
            }
            AppMethodBeat.m2505o(20135);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$19 */
    class C1674819 implements C36073c {
        C1674819() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            int i;
            AppMethodBeat.m2504i(20157);
            if (C4990ab.getLogLevel() == 0) {
                i = 2;
            } else {
                i = C26373g.m41964Nu().getInt("WeRunLaunchGroupRankWeAppSwitch", 0);
            }
            if (i == 2) {
                c44273l.mo70049a(3, ExdeviceRankInfoUI.this.getString(C25738R.string.bh4), (int) C1318a.bottomsheet_icon_transmit);
            }
            c44273l.mo70049a(0, ExdeviceRankInfoUI.this.getString(C25738R.string.bh2), (int) C1318a.bottomsheet_icon_transmit);
            c44273l.mo70049a(1, ExdeviceRankInfoUI.this.getString(C25738R.string.bh5), (int) C1318a.bottomsheet_icon_moment);
            c44273l.mo70049a(2, ExdeviceRankInfoUI.this.getString(C25738R.string.bh1), (int) C1318a.bottomsheet_icon_donate);
            AppMethodBeat.m2505o(20157);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$11 */
    class C1674911 implements C27846a {
        C1674911() {
        }

        /* renamed from: Kj */
        public final void mo23478Kj(String str) {
            AppMethodBeat.m2504i(20145);
            Intent intent = new Intent();
            intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
            intent.putExtra("Ksnsupload_appname", ExdeviceRankInfoUI.this.getString(C25738R.string.bij));
            intent.putExtra("Ksnsupload_source", 1);
            intent.putExtra("need_result", true);
            String nW = C37922v.m64078nW("wx_sport");
            C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", "wx_sport");
            intent.putExtra("reportSessionId", nW);
            intent.putExtra("Ksnsupload_type", 0);
            intent.putExtra("sns_kemdia_path", str);
            C25985d.m41468b(ExdeviceRankInfoUI.this, "sns", ".ui.SnsUploadUI", intent, 2);
            AppMethodBeat.m2505o(20145);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$1 */
    class C167501 implements Runnable {
        C167501() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20134);
            ExdeviceRankInfoUI.this.lDg.lCD = ExdeviceRankInfoUI.this.lDs;
            ExdeviceRankInfoUI.this.lDg.notifyDataSetChanged();
            ExdeviceRankInfoUI.m25794c(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20134);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$22 */
    class C1675122 implements OnClickListener {
        C1675122() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20160);
            ExdeviceRankInfoUI.m25810p(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20160);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$24 */
    class C1675224 implements C5261a {
        C1675224() {
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            boolean z;
            AppMethodBeat.m2504i(20162);
            ExdeviceRankInfoUI exdeviceRankInfoUI = ExdeviceRankInfoUI.this;
            if (ExdeviceRankInfoUI.this.lDs == null || ExdeviceRankInfoUI.this.lDs.size() == 0) {
                z = false;
            } else {
                z = true;
            }
            exdeviceRankInfoUI.lDy = z;
            AppMethodBeat.m2505o(20162);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$6 */
    class C167536 implements OnClickListener {
        C167536() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20140);
            C22162d.m33785kT(24);
            Intent intent = new Intent();
            intent.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
            intent.putExtra("Select_block_List", "gh_43f2581f6fd6");
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("Select_Send_Card", true);
            C25985d.m41466b(ExdeviceRankInfoUI.this, ".ui.transmit.SelectConversationUI", intent, 3);
            AppMethodBeat.m2505o(20140);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$7 */
    class C167547 implements OnCancelListener {
        C167547() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(20141);
            if (ExdeviceRankInfoUI.this.lzK != null) {
                ExdeviceRankInfoUI.this.lzK.dismiss();
                ExdeviceRankInfoUI.this.lzK = null;
            }
            ExdeviceRankInfoUI.this.finish();
            AppMethodBeat.m2505o(20141);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$8 */
    class C167558 implements Runnable {
        C167558() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20142);
            ExdeviceRankInfoUI.m25813s(ExdeviceRankInfoUI.this);
            ExdeviceRankInfoUI.m25814t(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20142);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$9 */
    class C167569 implements Runnable {
        C167569() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20143);
            ExdeviceRankInfoUI.m25815u(ExdeviceRankInfoUI.this);
            if (ExdeviceRankInfoUI.this.lDy) {
                ExdeviceRankInfoUI.this.lDg.notifyDataSetChanged();
                AppMethodBeat.m2505o(20143);
                return;
            }
            ExdeviceRankInfoUI.m25802h(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20143);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$10 */
    class C1675710 implements Runnable {
        C1675710() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20144);
            ExdeviceRankInfoUI.m25813s(ExdeviceRankInfoUI.this);
            ExdeviceRankInfoUI.m25814t(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20144);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$12 */
    class C1675812 implements C38927b<C34023j> {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$12$2 */
        class C117202 implements Runnable {
            C117202() {
            }

            public final void run() {
                AppMethodBeat.m2504i(20147);
                Toast.makeText(ExdeviceRankInfoUI.this, C25738R.string.bh0, 1).show();
                ExdeviceRankInfoUI.this.finish();
                AppMethodBeat.m2505o(20147);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$12$3 */
        class C167593 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$12$3$1 */
            class C167601 implements OnMenuItemClickListener {
                C167601() {
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.m2504i(20148);
                    C22162d.m33785kT(11);
                    ExdeviceRankInfoUI.m25804j(ExdeviceRankInfoUI.this);
                    AppMethodBeat.m2505o(20148);
                    return true;
                }
            }

            C167593() {
            }

            public final void run() {
                AppMethodBeat.m2504i(20149);
                ExdeviceRankInfoUI.m25802h(ExdeviceRankInfoUI.this);
                if (!C5046bo.isNullOrNil(ExdeviceRankInfoUI.this.lCb)) {
                    ExdeviceRankInfoUI.this.addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new C167601());
                }
                if (ExdeviceRankInfoUI.this.lDj != null) {
                    ExdeviceRankInfoUI.this.lDj.mo68561KF(ExdeviceRankInfoUI.this.lDq);
                }
                AppMethodBeat.m2505o(20149);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$12$1 */
        class C167611 implements Runnable {
            C167611() {
            }

            public final void run() {
                AppMethodBeat.m2504i(20146);
                if (ExdeviceRankInfoUI.this.lzK != null && ExdeviceRankInfoUI.this.lzK.isShowing()) {
                    ExdeviceRankInfoUI.this.lzK.dismiss();
                    ExdeviceRankInfoUI.this.lzK = null;
                    C4990ab.m7410d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                }
                AppMethodBeat.m2505o(20146);
            }
        }

        C1675812() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23473a(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20150);
            C34023j c34023j = (C34023j) c1207m;
            C4990ab.m7417i("MicroMsg.Sport.ExdeviceRankInfoUI", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (ExdeviceRankInfoUI.this.isFinishing() || ExdeviceRankInfoUI.this.f3574UP) {
                C4990ab.m7416i("MicroMsg.Sport.ExdeviceRankInfoUI", "ExdeviceRankInfoUI has been destroyed.");
                AppMethodBeat.m2505o(20150);
                return;
            }
            ExdeviceRankInfoUI.this.runOnUiThread(new C167611());
            if (i == 0 && i2 == 0) {
                ExdeviceRankInfoUI.this.lCb = c34023j.lvz;
                ExdeviceRankInfoUI.this.lCc = c34023j.lvA;
                ExdeviceRankInfoUI.this.lvW = c34023j.lvW;
                ExdeviceRankInfoUI.this.lvV = c34023j.lvV;
                ExdeviceRankInfoUI.this.lvJ = c34023j.lvJ;
                ExdeviceRankInfoUI.m25799g(ExdeviceRankInfoUI.this);
                ExdeviceRankInfoUI.this.runOnUiThread(new C167593());
                AppMethodBeat.m2505o(20150);
                return;
            }
            if (ExdeviceRankInfoUI.this.lDs == null || ExdeviceRankInfoUI.this.lDs.size() == 0) {
                ExdeviceRankInfoUI.this.runOnUiThread(new C117202());
            }
            AppMethodBeat.m2505o(20150);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI$23 */
    class C1676223 implements OnClickListener {
        C1676223() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20161);
            C4990ab.m7410d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
            C11643e.m19459e(ExdeviceRankInfoUI.this);
            AppMethodBeat.m2505o(20161);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ExdeviceRankInfoUI() {
        AppMethodBeat.m2504i(20163);
        AppMethodBeat.m2505o(20163);
    }

    /* renamed from: g */
    static /* synthetic */ void m25799g(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20190);
        exdeviceRankInfoUI.m25800gP(false);
        AppMethodBeat.m2505o(20190);
    }

    /* renamed from: h */
    static /* synthetic */ void m25802h(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20191);
        exdeviceRankInfoUI.bpV();
        AppMethodBeat.m2505o(20191);
    }

    /* renamed from: m */
    static /* synthetic */ void m25807m(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20193);
        exdeviceRankInfoUI.bqb();
        AppMethodBeat.m2505o(20193);
    }

    /* renamed from: r */
    static /* synthetic */ void m25812r(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20197);
        exdeviceRankInfoUI.bpY();
        AppMethodBeat.m2505o(20197);
    }

    /* renamed from: s */
    static /* synthetic */ void m25813s(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20198);
        exdeviceRankInfoUI.bpP();
        AppMethodBeat.m2505o(20198);
    }

    /* renamed from: t */
    static /* synthetic */ void m25814t(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20199);
        exdeviceRankInfoUI.bpZ();
        AppMethodBeat.m2505o(20199);
    }

    /* renamed from: u */
    static /* synthetic */ void m25815u(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20200);
        exdeviceRankInfoUI.m25801gQ(true);
        AppMethodBeat.m2505o(20200);
    }

    /* renamed from: gP */
    private void m25800gP(boolean z) {
        AppMethodBeat.m2504i(20164);
        if (!this.lDw || z) {
            C45891ad.bpe();
            this.lDu = C42989c.m76339Kn(this.lDo);
            this.lDt = C45891ad.boY().bpk();
            this.lDs = this.lDg.mo23494b(this.lDt, this.lDu, this.lvV);
            runOnUiThread(new C167501());
            AppMethodBeat.m2505o(20164);
            return;
        }
        AppMethodBeat.m2505o(20164);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20165);
        super.onCreate(bundle);
        this.f3574UP = false;
        this.igi = C1853r.m3846Yz();
        Intent intent = getIntent();
        this.lDl = intent.getStringExtra("key_rank_info");
        this.lDm = intent.getStringExtra("key_rank_semi");
        this.lDn = intent.getStringExtra("app_username");
        this.lDo = intent.getStringExtra("rank_id");
        this.lDv = intent.getBooleanExtra("key_is_latest", false);
        this.lDq = intent.getStringExtra("key_champioin_username");
        this.lDr = intent.getIntExtra("device_type", 0);
        this.lDx = intent.getStringExtra("locate_to_username");
        this.lDw = intent.getBooleanExtra("key_only_show_latest_rank", false);
        if (C5046bo.isNullOrNil(this.lDo) || "#".equals(this.lDo)) {
            if (!this.lDw) {
                C34029d c34029d;
                C45882d boX = C45891ad.boX();
                Cursor a = boX.bSd.mo10104a(String.format("select * from %s order by %s desc limit 1", new Object[]{"HardDeviceRankInfo", "rankID"}), null, 2);
                if (a == null) {
                    C4990ab.m7412e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    c34029d = null;
                } else {
                    if (a.moveToFirst()) {
                        c34029d = new C34029d();
                        c34029d.mo8995d(a);
                    } else {
                        C4990ab.m7410d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                        c34029d = null;
                    }
                    a.close();
                }
                if (c34029d != null) {
                    this.lDo = c34029d.field_rankID;
                    this.lDn = c34029d.field_appusername;
                }
            }
            this.lDq = null;
            this.lDv = true;
        }
        C45891ad.bpe();
        this.lDu = C42989c.m76339Kn(this.lDo);
        if (!this.lDw) {
            if (this.lDu == null || this.lDu.size() <= 0) {
                this.lDt = new ArrayList();
                this.lDu = C38934a.m66099a(this.lDo, this.lDn, this.lDl, this.lDm, this.lCE, this.lDt);
                C45891ad.bpe();
                C42989c.m76341f(this.lDo, this.lDu);
            } else {
                C38934a.m66100d(this.lDl, this.lDm, this.lCE);
            }
            this.lDt = C45891ad.boY().bpk();
        }
        this.lDg = new C11737b(this, this.lDn);
        this.lDg.lCE = this.lCE;
        this.lDs = this.lDg.mo23494b(this.lDt, this.lDu, this.lvV);
        this.lDg.lCD = this.lDs;
        if (C5046bo.isNullOrNil(this.lDq)) {
            bpW();
        }
        this.lDp = C45891ad.bpa().mo61824Kr(this.lDq);
        if (this.lDp == null && !C5046bo.isNullOrNil(this.lDq)) {
            this.lDp = new C11646a();
            this.lDp.field_username = this.lDq;
            this.lDp.field_championMotto = getIntent().getStringExtra("key_champion_info");
            this.lDp.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
            C45891ad.bpe();
            C45891ad.bpa().mo61825a(this.lDp);
        }
        initView();
        if (this.lDu != null && this.lDu.size() > 0) {
            this.lDj.mo68561KF(((C34029d) this.lDu.get(0)).field_username);
        }
        C45891ad.bpf().mo61821a(this);
        C45891ad.bpe().lwf = this;
        bpU();
        setBackBtn(new C1674618());
        setMMTitle((int) C25738R.string.bik);
        showOptionMenu(true);
        bpV();
        C4883b c6546sd = new C6546sd();
        c6546sd.cOe.action = 2;
        C4879a.xxA.mo10049a(c6546sd, C7305d.xDG.cin());
        AppMethodBeat.m2505o(20165);
    }

    private void bpU() {
        AppMethodBeat.m2504i(20166);
        C4990ab.m7416i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
        this.lDz = new C34023j(this.lDo, this.lDn, this.lDq, this.lDv, this.lDA);
        this.lDz.lvY = this;
        C9638aw.m17182Rg().mo14541a(this.lDz, 0);
        AppMethodBeat.m2505o(20166);
    }

    private void bpV() {
        AppMethodBeat.m2504i(20167);
        C4990ab.m7417i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", this.lDx, this.igi);
        if (C5046bo.isNullOrNil(this.lDx) || m25787KH(this.lDx) < 0) {
            C4990ab.m7410d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
            AppMethodBeat.m2505o(20167);
            return;
        }
        AppMethodBeat.m2505o(20167);
    }

    /* renamed from: KH */
    private int m25787KH(String str) {
        AppMethodBeat.m2504i(20168);
        C4990ab.m7417i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", str, this.igi);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(20168);
            return -1;
        } else if (this.lDs == null || this.lDs.size() == 0) {
            AppMethodBeat.m2505o(20168);
            return -2;
        } else {
            int i = 0;
            while (i < this.lDs.size()) {
                C34029d c34029d = ((C45897e) this.lDs.get(i)).lFy;
                int i2 = ((C45897e) this.lDs.get(i)).lFz;
                if (c34029d == null || !str.equalsIgnoreCase(c34029d.field_username) || str.equalsIgnoreCase(this.igi) || (i2 & 2) == 2) {
                    i++;
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    C4990ab.m7417i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", Integer.valueOf(i), Integer.valueOf(displayMetrics.heightPixels));
                    this.lDf.setSelectionFromTop(i, i2 / 4);
                    this.lDg.lCF = str;
                    this.lDg.notifyDataSetInvalidated();
                    bpY();
                    AppMethodBeat.m2505o(20168);
                    return i;
                }
            }
            this.lDg.lCF = null;
            AppMethodBeat.m2505o(20168);
            return -3;
        }
    }

    private void bpP() {
        AppMethodBeat.m2504i(20169);
        if (this.lDp == null || this.igi == null || !this.igi.equals(this.lDp.field_username) || !C5046bo.isNullOrNil(this.lDp.field_championUrl)) {
            if (this.lBZ != null) {
                this.lBZ.setVisibility(8);
            }
            if (!(this.lDp == null || C5046bo.m7532bc(this.lDp.field_username, "").equals(this.igi) || C5046bo.isNullOrNil(this.lDp.field_championUrl))) {
                this.lDi.setOnViewClickListener(new C1675122());
            }
        } else {
            if (this.lBZ != null) {
                this.lBZ.setVisibility(0);
            }
            if (this.lDi != null) {
                this.lDi.setOnViewClickListener(new C1674121());
                AppMethodBeat.m2505o(20169);
                return;
            }
        }
        AppMethodBeat.m2505o(20169);
    }

    private void bpW() {
        AppMethodBeat.m2504i(20170);
        String bpX = bpX();
        if (!C5046bo.isNullOrNil(bpX)) {
            this.lDq = bpX;
        }
        AppMethodBeat.m2505o(20170);
    }

    private String bpX() {
        AppMethodBeat.m2504i(20171);
        if (this.lDs != null) {
            for (C45897e c45897e : this.lDs) {
                C34029d c34029d = c45897e.lFy;
                if (c34029d != null && c34029d.field_ranknum == 1) {
                    String str = c34029d.field_username;
                    AppMethodBeat.m2505o(20171);
                    return str;
                }
            }
        }
        AppMethodBeat.m2505o(20171);
        return null;
    }

    public final void initView() {
        int dimensionPixelSize;
        int size;
        boolean z;
        AppMethodBeat.m2504i(20172);
        this.lDh = findViewById(2131823712);
        ExdeviceRankListHeaderView exdeviceRankListHeaderView = new ExdeviceRankListHeaderView(this);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            i = C42992b.m76345J(this, getResources().getDimensionPixelSize(C25738R.dimen.f9821gt));
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        i = ((defaultDisplay.getHeight() / 2) - i) - dimensionPixelSize;
        if (defaultDisplay.getHeight() <= 0 || i <= 0) {
            i = getResources().getDimensionPixelSize(C25738R.dimen.f9815gn);
        }
        exdeviceRankListHeaderView.setMinimumHeight(i);
        exdeviceRankListHeaderView.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceRankListHeaderView.setTag(Integer.valueOf(i));
        this.lDi = exdeviceRankListHeaderView;
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(2131823710);
        this.lDf = (ListView) findViewById(2131823711);
        this.lDj = (ExdeviceRankChampionInfoView) findViewById(2131823713);
        this.lBZ = findViewById(2131823701);
        this.lBZ.setOnClickListener(new C1676223());
        this.lDi.setIsShowTip(false);
        bpP();
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setTopViewVisible(false);
        mMPullDownView.setBottomViewVisible(false);
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setIsTopShowAll(false);
        mMPullDownView.setCanOverScrool(true);
        mMPullDownView.setOnInterceptTouchEventListener(new C1675224());
        mMPullDownView.setAtBottomCallBack(new C167472());
        mMPullDownView.setOnScrollChangedListener(new C167423());
        mMPullDownView.setAtTopCallBack(new C167444());
        this.lDf.setOnScrollListener(new C167435());
        this.lDf.addHeaderView(this.lDi, null, false);
        View inflate = getLayoutInflater().inflate(2130969440, null);
        this.lDk = inflate.findViewById(2131823707);
        inflate.findViewById(2131823708).setOnClickListener(new C167536());
        this.lDk.setVisibility(8);
        this.lDf.addFooterView(inflate);
        if (this.lDt != null) {
            dimensionPixelSize = this.lDt.size();
        } else {
            dimensionPixelSize = 0;
        }
        if (this.lDu != null) {
            size = this.lDu.size();
        } else {
            size = 0;
        }
        if (dimensionPixelSize + size == 0) {
            this.lDs = new ArrayList();
            this.lDg.lCD = this.lDs;
            getString(C25738R.string.f9238tz);
            this.lzK = C30379h.m48458b((Context) this, getString(C25738R.string.cn5), true, new C167547());
        }
        this.lDf.setAdapter(this.lDg);
        this.lDg.lCG = this;
        if (this.lDr == 1) {
            this.lDf.setVisibility(0);
            this.lDh.setVisibility(8);
            z = true;
        } else {
            this.lDf.setVisibility(8);
            this.lDh.setVisibility(0);
            z = false;
        }
        if (z) {
            this.lBT = (ImageView) findViewById(2131823700);
            mMPullDownView.setCanOverScrool(false);
            dimensionPixelSize = C1338a.m2868gd(this);
            i = ((Integer) this.lDi.getTag()).intValue();
            if (this.lvV) {
                i += (getResources().getDimensionPixelSize(C25738R.dimen.f9830h3) / 2) + getResources().getDimensionPixelSize(C25738R.dimen.f9829h2);
            }
            this.lBT.setLayoutParams(new LayoutParams(dimensionPixelSize, i));
            bpZ();
            m25801gQ(false);
            AppMethodBeat.m2505o(20172);
            return;
        }
        C4990ab.m7410d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
        finish();
        AppMethodBeat.m2505o(20172);
    }

    private void bpY() {
        AppMethodBeat.m2504i(20173);
        View childAt = this.lDf.getChildAt(0);
        int[] iArr = new int[2];
        if (childAt != null) {
            if (this.lDf.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (C5046bo.isNullOrNil(this.lDx) && lCl == 128) {
                    lCl = iArr[1];
                }
                int i = iArr[1];
                if (i > 0) {
                    float f;
                    if (i >= lCl) {
                        f = 1.0f;
                    } else {
                        f = ((float) i) / ((float) lCl);
                    }
                    C4990ab.m7411d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", Float.valueOf(f));
                    this.lDj.setAlpha(f);
                    this.lDj.setVisibility(0);
                    this.lBZ.setAlpha(f);
                    AppMethodBeat.m2505o(20173);
                    return;
                }
            }
            this.lDj.setAlpha(0.0f);
            this.lBZ.setAlpha(0.0f);
            this.lDj.setVisibility(8);
        }
        AppMethodBeat.m2505o(20173);
    }

    public void onResume() {
        AppMethodBeat.m2504i(20174);
        super.onResume();
        AppMethodBeat.m2505o(20174);
    }

    /* Access modifiers changed, original: protected */
    public void onRestart() {
        AppMethodBeat.m2504i(20175);
        super.onRestart();
        m25800gP(true);
        AppMethodBeat.m2505o(20175);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(20176);
        this.f3574UP = true;
        if (this.lDg != null) {
            C11737b.finish();
        }
        super.onDestroy();
        if (this.lDz != null) {
            this.lDz.lvY = null;
        }
        C45891ad.bpf().mo61823b(this);
        C45891ad.bpe().lwf = null;
        C45891ad.bpe().lwg = null;
        if (this.lDB > 0) {
            int i = this.lDB;
            C4990ab.m7419v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", Integer.valueOf(i));
            C7053e.pXa.mo8381e(13168, Integer.valueOf(0), Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(20176);
    }

    public void onPause() {
        AppMethodBeat.m2504i(20177);
        super.onPause();
        AppMethodBeat.m2505o(20177);
    }

    public final int getLayoutId() {
        return 2130969442;
    }

    private void bpZ() {
        AppMethodBeat.m2504i(20178);
        if (this.lDp == null) {
            this.lBT.setImageResource(C25738R.color.f11911le);
            this.hZn = null;
        } else if (this.hZn != this.lDp.field_championUrl && (this.hZn == null || !this.hZn.equals(this.lDp.field_championUrl))) {
            C11643e.m19456a(this, this.lBT, this.lDp.field_championUrl);
            this.hZn = this.lDp.field_championUrl;
            AppMethodBeat.m2505o(20178);
            return;
        }
        AppMethodBeat.m2505o(20178);
    }

    /* renamed from: gQ */
    private void m25801gQ(boolean z) {
        AppMethodBeat.m2504i(20179);
        if (z) {
            bpW();
        }
        if (C5046bo.isNullOrNil(this.lDn)) {
            this.lDj.setVisibility(8);
            AppMethodBeat.m2505o(20179);
            return;
        }
        this.lDj.mo68561KF(this.lDq);
        this.lDj.setVisibility(0);
        AppMethodBeat.m2505o(20179);
    }

    /* renamed from: b */
    public final void mo30744b(String str, C27834d c27834d) {
        AppMethodBeat.m2504i(20180);
        boolean z = (c27834d == null || C5046bo.isNullOrNil(str)) ? false : true;
        Assert.assertTrue(z);
        if ("HardDeviceRankInfo".equals(str)) {
            if (this.lDo != null && this.lDo.equals(c27834d.lvL)) {
                C4990ab.m7417i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", this.lDo);
                m25800gP(true);
                if (C5046bo.isNullOrNil(this.lDq) || !this.lDq.equals(bpX())) {
                    bpW();
                    this.lDp = C45891ad.bpa().mo61824Kr(this.lDq);
                    runOnUiThread(new C167558());
                }
                runOnUiThread(new C167569());
                AppMethodBeat.m2505o(20180);
                return;
            }
        } else if ("HardDeviceChampionInfo".equals(str) && !C5046bo.isNullOrNil(this.lDq) && this.lDq.equals(c27834d.username)) {
            this.lDp = C45891ad.bpa().mo61824Kr(this.lDq);
            runOnUiThread(new C1675710());
        }
        AppMethodBeat.m2505o(20180);
    }

    /* renamed from: Ko */
    public final void mo23403Ko(String str) {
        AppMethodBeat.m2504i(20181);
        C4990ab.m7411d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", str);
        this.lDo = str;
        AppMethodBeat.m2505o(20181);
    }

    /* renamed from: KI */
    public final void mo30741KI(String str) {
        AppMethodBeat.m2504i(20182);
        C22162d.m33785kT(6);
        Intent intent = new Intent(this, ExdeviceProfileUI.class);
        intent.putExtra("username", str);
        intent.putExtra("usernickname", (String) this.lCE.get(str));
        intent.putExtra("app_username", this.lDn);
        intent.putExtra("rank_id", this.lDo);
        startActivityForResult(intent, 4);
        AppMethodBeat.m2505o(20182);
    }

    public final void bqa() {
        AppMethodBeat.m2504i(20183);
        C22162d.m33785kT(31);
        bqb();
        AppMethodBeat.m2505o(20183);
    }

    /* renamed from: cd */
    public final void mo30746cd(String str, int i) {
        AppMethodBeat.m2504i(20184);
        C45891ad.bpe();
        String str2 = this.lDo;
        String str3 = this.lDn;
        C45882d boX = C45891ad.boX();
        boolean z = (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str) || (i != 1 && i != 0 && i != 2)) ? false : true;
        Assert.assertTrue(z);
        C34029d a = boX.mo73712a(new C27834d(str2, null, str));
        if (a == null) {
            C4990ab.m7420w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
        } else {
            a.field_selfLikeState = i;
            switch (a.field_selfLikeState) {
                case 0:
                    a.field_likecount--;
                    break;
                case 1:
                    a.field_likecount++;
                    break;
                default:
                    C4990ab.m7420w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
                    break;
            }
            boX.mo73713a(a, true);
        }
        C42989c.m76340d(str2, str3, str, i);
        this.lDB++;
        AppMethodBeat.m2505o(20184);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(20185);
        super.onActivityResult(i, i2, intent);
        if (C11643e.m19457a(this, i, i2, intent, this.lDn)) {
            AppMethodBeat.m2505o(20185);
            return;
        }
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent == null) {
                        C4990ab.m7413e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", Integer.valueOf(i));
                        AppMethodBeat.m2505o(20185);
                        return;
                    }
                    stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        C4990ab.m7412e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
                        AppMethodBeat.m2505o(20185);
                        return;
                    }
                    C38944ac.m66114a((Context) this, stringExtra, C38944ac.m66115dG(this), intent.getStringExtra("custom_send_text"), this.lCc);
                    C30379h.m48465bQ(this.mController.ylL, getResources().getString(C25738R.string.f9229to));
                    C4990ab.m7410d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
                    AppMethodBeat.m2505o(20185);
                    return;
                case 2:
                    C30379h.m48465bQ(this.mController.ylL, getResources().getString(C25738R.string.f9229to));
                    C4990ab.m7410d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
                    AppMethodBeat.m2505o(20185);
                    return;
                case 3:
                    if (intent != null) {
                        ArrayList<String> P = C5046bo.m7508P(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        for (String stringExtra3 : P) {
                            C12519g.bOk().mo46462q("gh_43f2581f6fd6", stringExtra3, C1855t.m3896kH(stringExtra3));
                            if (!C5046bo.isNullOrNil(stringExtra2)) {
                                C18372qb c18372qb = new C18372qb();
                                c18372qb.cMq.cMr = stringExtra3;
                                c18372qb.cMq.content = stringExtra2;
                                c18372qb.cMq.type = C1855t.m3925nK(stringExtra3);
                                c18372qb.cMq.flags = 0;
                                C4879a.xxA.mo10055m(c18372qb);
                            }
                        }
                        AppMethodBeat.m2505o(20185);
                        return;
                    }
                    break;
                case 4:
                    if (intent != null && intent.getBooleanExtra("KeyNeedUpdateRank", false)) {
                        bpU();
                        break;
                    }
            }
        }
        AppMethodBeat.m2505o(20185);
    }

    /* renamed from: KJ */
    public final boolean mo30742KJ(String str) {
        AppMethodBeat.m2504i(20186);
        if (C5046bo.isNullOrNil(this.lDo) || "#".equals(this.lDo)) {
            C4990ab.m7410d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
            Toast.makeText(this, getString(C25738R.string.bhm), 0).show();
            AppMethodBeat.m2505o(20186);
            return true;
        } else if (C1853r.m3846Yz().equals(str)) {
            C4990ab.m7410d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
            Intent intent = new Intent(this, ExdeviceLikeUI.class);
            intent.putExtra("app_username", this.lDn);
            intent.putExtra("rank_id", this.lDo);
            intent.putExtra("key_is_like_read_only", true);
            startActivity(intent);
            AppMethodBeat.m2505o(20186);
            return true;
        } else {
            AppMethodBeat.m2505o(20186);
            return false;
        }
    }

    private void bqb() {
        AppMethodBeat.m2504i(20187);
        if (C5046bo.isNullOrNil(this.lvW)) {
            C11646a Kr = C45891ad.bpa().mo61824Kr(this.igi);
            if (Kr != null) {
                this.lvW = Kr.field_championUrl;
            }
        }
        C34029d h = C11737b.m19538h(this.igi, this.lDu);
        String str = "--";
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (h != null) {
            str = String.valueOf(h.field_ranknum);
            str2 = String.valueOf(h.field_score);
        }
        new C38944ac().mo61828a((Context) this, str, str2, this.lvW, new C1674911());
        AppMethodBeat.m2505o(20187);
    }

    /* renamed from: a */
    public final void mo30743a(C34023j c34023j) {
        AppMethodBeat.m2504i(20188);
        runOnUiThread(new C1172214());
        this.lCb = c34023j.lvz;
        this.lCc = c34023j.lvA;
        this.lvW = c34023j.lvW;
        this.lvV = c34023j.lvV;
        this.lvJ = c34023j.lvJ;
        this.lDu = c34023j.lvO;
        this.lDt = c34023j.lvP;
        this.lDs = this.lDg.mo23494b(this.lDt, this.lDu, this.lvV);
        runOnUiThread(new C1172315());
        AppMethodBeat.m2505o(20188);
    }

    /* renamed from: c */
    static /* synthetic */ void m25794c(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20189);
        exdeviceRankInfoUI.lDk.setVisibility(0);
        AppMethodBeat.m2505o(20189);
    }

    /* renamed from: j */
    static /* synthetic */ void m25804j(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20192);
        C36356d c36356d = new C36356d(exdeviceRankInfoUI.mController.ylL, 1, false);
        c36356d.rBl = new C1674819();
        c36356d.rBm = new C1674020();
        c36356d.cpD();
        AppMethodBeat.m2505o(20192);
    }

    /* renamed from: n */
    static /* synthetic */ void m25808n(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20194);
        if (C5046bo.isNullOrNil(exdeviceRankInfoUI.lvW)) {
            C11646a Kr = C45891ad.bpa().mo61824Kr(exdeviceRankInfoUI.igi);
            if (Kr != null) {
                exdeviceRankInfoUI.lvW = Kr.field_championUrl;
            }
        }
        C34029d h = C11737b.m19538h(exdeviceRankInfoUI.igi, exdeviceRankInfoUI.lDu);
        String str = "--";
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (h != null) {
            str = String.valueOf(h.field_ranknum);
            str2 = String.valueOf(h.field_score);
        }
        new C38944ac().mo61828a((Context) exdeviceRankInfoUI, str, str2, exdeviceRankInfoUI.lvW, new C1172113());
        AppMethodBeat.m2505o(20194);
    }

    /* renamed from: o */
    static /* synthetic */ void m25809o(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20195);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
        ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(exdeviceRankInfoUI.mController.ylL, null, "wx3fca79fc5715b185", 0, 0, "", appBrandStatObject);
        AppMethodBeat.m2505o(20195);
    }

    /* renamed from: p */
    static /* synthetic */ void m25810p(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.m2504i(20196);
        C36356d c36356d = new C36356d(exdeviceRankInfoUI.mController.ylL, 1, false);
        c36356d.rBl = new C1172416();
        c36356d.rBm = new C1674517();
        c36356d.cpD();
        AppMethodBeat.m2505o(20196);
    }

    /* renamed from: c */
    static /* synthetic */ void m25795c(ExdeviceRankInfoUI exdeviceRankInfoUI, String str) {
        AppMethodBeat.m2504i(20201);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        C25985d.m41466b((Context) exdeviceRankInfoUI, ".ui.transmit.SelectConversationUI", intent, 1);
        AppMethodBeat.m2505o(20201);
    }
}
