package com.tencent.p177mm.plugin.clean.p364ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.clean.p362c.C33821f;
import com.tencent.p177mm.plugin.clean.p362c.C33824h;
import com.tencent.p177mm.plugin.clean.p362c.C6826j;
import com.tencent.p177mm.plugin.clean.p364ui.PieView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI */
public class CleanMsgUI extends MMActivity {
    private ProgressDialog ehJ;
    private View kxP;
    private PieView kxQ;
    private TextView kxR;
    private Button kxS;
    private Button kxT;
    private TextView kxU;
    private TextView kxV;
    private TextView kxW;
    private TextView kxX;
    private View kxY;
    private TextView kxZ;
    private TextView kya;
    private TextView kyb;
    private TextView kyc;
    private TextView kyd;
    private TextView kye;
    private LinearLayout kyf;

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI$3 */
    class C202403 implements OnClickListener {
        C202403() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18800);
            CleanMsgUI.this.startActivityForResult(new Intent(CleanMsgUI.this, CleanChattingUI.class), 0);
            C7060h.pYm.mo8378a(714, 12, 1, false);
            AppMethodBeat.m2505o(18800);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI$4 */
    class C202414 implements OnCancelListener {
        C202414() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI$5 */
    class C202435 implements C33824h {
        C202435() {
        }

        /* renamed from: dP */
        public final void mo23158dP(int i, int i2) {
            AppMethodBeat.m2504i(18802);
            CleanMsgUI.this.ehJ.setMessage(CleanMsgUI.this.getString(C25738R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
            AppMethodBeat.m2505o(18802);
        }

        /* renamed from: hi */
        public final void mo23159hi(final long j) {
            AppMethodBeat.m2504i(18803);
            C4990ab.m7417i("MicroMsg.CleanMsgUI", "onDeleteEnd %d ", Long.valueOf(j));
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    long j = 0;
                    AppMethodBeat.m2504i(18801);
                    if (CleanMsgUI.this.ehJ != null) {
                        CleanMsgUI.this.ehJ.dismiss();
                    }
                    long j2 = C6826j.bgd().kvX;
                    long j3 = C6826j.bgd().kvX - j;
                    if (j3 < 0) {
                        j2 = C6826j.bgd().kvV - j2;
                    } else {
                        j2 = C6826j.bgd().kvV - j;
                        j = j3;
                    }
                    C6826j.bgd().kvX = j;
                    C6826j.bgd().kvV = j2;
                    CleanMsgUI.m43924a(CleanMsgUI.this, C6826j.bgd().kvV, C6826j.bgd().kvW, C6826j.bgd().kvX);
                    AppMethodBeat.m2505o(18801);
                }
            });
            C7060h.pYm.mo8378a(714, 13, 1, false);
            AppMethodBeat.m2505o(18803);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI$1 */
    class C276451 implements OnMenuItemClickListener {
        C276451() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18797);
            CleanMsgUI.this.finish();
            AppMethodBeat.m2505o(18797);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI$2 */
    class C276462 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI$2$1 */
        class C28101 implements DialogInterface.OnClickListener {
            C28101() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18798);
                CleanMsgUI.m43925a(CleanMsgUI.this, C6826j.bgd().kww);
                AppMethodBeat.m2505o(18798);
            }
        }

        C276462() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18799);
            C30379h.m48444a(CleanMsgUI.this, CleanMsgUI.this.getString(C25738R.string.aqf, new Object[]{C5046bo.m7580my(C6826j.bgd().kvX)}), "", CleanMsgUI.this.getString(C25738R.string.f9187s6), CleanMsgUI.this.getString(C25738R.string.f9076or), new C28101(), null, (int) C25738R.color.f12266xy);
            AppMethodBeat.m2505o(18799);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m43924a(CleanMsgUI cleanMsgUI, long j, long j2, long j3) {
        AppMethodBeat.m2504i(18810);
        cleanMsgUI.m43926h(j, j2, j3);
        AppMethodBeat.m2505o(18810);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18804);
        super.onCreate(bundle);
        C7060h.pYm.mo8378a(714, 10, 1, false);
        this.kxR = (TextView) findViewById(2131822776);
        this.kxQ = (PieView) findViewById(2131822775);
        this.kxS = (Button) findViewById(2131822797);
        this.kxT = (Button) findViewById(2131822798);
        this.kxP = findViewById(2131822777);
        this.kxU = (TextView) findViewById(2131822781);
        this.kxU.setTextSize(1, 16.0f);
        this.kxV = (TextView) findViewById(2131822786);
        this.kxV.setTextSize(1, 16.0f);
        this.kxW = (TextView) findViewById(2131822790);
        this.kxW.setTextSize(1, 16.0f);
        this.kxX = (TextView) findViewById(2131822794);
        this.kxX.setTextSize(1, 16.0f);
        this.kxZ = (TextView) findViewById(2131822795);
        this.kya = (TextView) findViewById(2131822796);
        this.kye = (TextView) findViewById(2131822800);
        this.kyf = (LinearLayout) findViewById(2131822799);
        this.kyb = (TextView) findViewById(2131822780);
        this.kyc = (TextView) findViewById(2131822785);
        this.kyd = (TextView) findViewById(2131822789);
        this.kxY = findViewById(2131822782);
        setMMTitle((int) C25738R.string.aqb);
        setBackBtn(new C276451());
        this.kxT.setOnClickListener(new C276462());
        this.kxS.setEnabled(true);
        this.kxS.setOnClickListener(new C202403());
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.apz), false, new C202414());
        this.ehJ.dismiss();
        m43926h(C6826j.bgd().kvV, C6826j.bgd().kvW, C6826j.bgd().kvX);
        AppMethodBeat.m2505o(18804);
    }

    public final int getLayoutId() {
        return 2130969146;
    }

    /* renamed from: h */
    private void m43926h(long j, long j2, long j3) {
        int i;
        AppMethodBeat.m2504i(18805);
        if (j <= 0) {
            j = 1;
            C7060h.pYm.mo8378a(714, 61, 1, false);
        }
        int i2 = (int) ((360 * j2) / j);
        if (j2 <= 0 || i2 >= 5) {
            i = i2;
        } else {
            i = 5;
        }
        i2 = 0;
        if (j3 > 0) {
            i2 = (int) ((360 * j3) / j);
            if (i2 < 5) {
                i2 = 5;
            }
        }
        long j4 = (j - j2) - j3;
        int i3 = (int) ((100 * j2) / j);
        int i4 = (int) ((100 * j3) / j);
        int i5 = (int) ((100 * j4) / j);
        C4990ab.m7417i("MicroMsg.CleanMsgUI", "update acc[%d %d] otherAcc[%d %d] other[%d %d] wechat[%d] stack[%s]", Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j), C5046bo.dpG());
        this.kxQ.setGreenTargetAngle(i);
        this.kxQ.setOtherAccTargetAngle(i2);
        this.kxQ.setStage(1);
        this.kxP.setVisibility(0);
        this.kxU.setText(C5046bo.m7565ga(j2));
        this.kxV.setText(C5046bo.m7565ga(j3));
        this.kxW.setText(C5046bo.m7565ga(j4));
        if (j3 > 0) {
            this.kxY.setVisibility(0);
            this.kxT.setEnabled(true);
        } else {
            this.kxT.setEnabled(false);
            this.kxY.setVisibility(0);
        }
        this.kyb.setText(getString(C25738R.string.aps));
        this.kyc.setText(getString(C25738R.string.aqe));
        this.kyd.setText(getString(C25738R.string.aqh));
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, Integer.valueOf(0))).intValue() > 0) {
            this.kyf.setVisibility(0);
            this.kye.setVisibility(0);
            this.kye.setText(CleanMsgUI.m43927l(C6826j.bgd().kwI));
        }
        AppMethodBeat.m2505o(18805);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(18806);
        super.onDestroy();
        AppMethodBeat.m2505o(18806);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(18807);
        super.onActivityResult(i, i2, intent);
        m43926h(C6826j.bgd().kvV, C6826j.bgd().kvW, C6826j.bgd().kvX);
        AppMethodBeat.m2505o(18807);
    }

    /* renamed from: l */
    private static String m43927l(HashMap<String, Long> hashMap) {
        AppMethodBeat.m2504i(18808);
        StringBuffer stringBuffer = new StringBuffer();
        if (!hashMap.isEmpty()) {
            for (String str : hashMap.keySet()) {
                stringBuffer.append(str).append(" : ").append(C5046bo.m7565ga(((Long) hashMap.get(str)).longValue())).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        String str2 = stringBuffer.toString();
        AppMethodBeat.m2505o(18808);
        return str2;
    }

    /* renamed from: a */
    static /* synthetic */ void m43925a(CleanMsgUI cleanMsgUI, HashSet hashSet) {
        AppMethodBeat.m2504i(18809);
        C4990ab.m7417i("MicroMsg.CleanMsgUI", "%d begin deleteOtherAcc", Integer.valueOf(cleanMsgUI.hashCode()));
        C7060h.pYm.mo8378a(714, 11, 1, false);
        new C33821f(hashSet, new C202435()).start();
        cleanMsgUI.ehJ.show();
        AppMethodBeat.m2505o(18809);
    }
}
