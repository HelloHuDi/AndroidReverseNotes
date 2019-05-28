package com.tencent.p177mm.plugin.clean.p364ui.newui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.plugin.clean.p362c.C11389a;
import com.tencent.p177mm.plugin.clean.p362c.C20227c;
import com.tencent.p177mm.plugin.clean.p362c.C27641b;
import com.tencent.p177mm.plugin.clean.p362c.C27642d;
import com.tencent.p177mm.plugin.clean.p362c.C33823g;
import com.tencent.p177mm.plugin.clean.p362c.C33824h;
import com.tencent.p177mm.plugin.clean.p362c.C41261e;
import com.tencent.p177mm.plugin.clean.p362c.p363a.C11387b;
import com.tencent.p177mm.plugin.clean.p364ui.PieView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI */
public class CleanMsgUI extends MMActivity implements C33823g, C33824h {
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
    private C41261e kyL;
    private C20227c kyR;
    private TextView kya;
    private TextView kyb;
    private TextView kyc;
    private TextView kyd;

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI$5 */
    class C28135 implements OnCancelListener {
        C28135() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI$6 */
    class C28146 implements C30382d {

        /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI$6$1 */
        class C28151 implements OnClickListener {
            C28151() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18892);
                CleanMsgUI.this.kyL = new C41261e(C27642d.bfQ(), CleanMsgUI.this, CleanMsgUI.bgn());
                CleanMsgUI.this.kyL.start();
                CleanMsgUI.this.ehJ.show();
                AppMethodBeat.m2505o(18892);
            }
        }

        C28146() {
        }

        /* renamed from: bV */
        public final void mo4975bV(int i, int i2) {
            AppMethodBeat.m2504i(18893);
            switch (i2) {
                case 0:
                    if (CleanMsgUI.bgm() <= 0) {
                        Toast.makeText(CleanMsgUI.this, C25738R.string.d7r, 0).show();
                        break;
                    }
                    C30379h.m48466d(CleanMsgUI.this, CleanMsgUI.this.getString(C25738R.string.aqn, new Object[]{C5046bo.m7565ga(r2)}), "", CleanMsgUI.this.getString(C25738R.string.b53), CleanMsgUI.this.getString(C25738R.string.abx), new C28151(), null);
                    AppMethodBeat.m2505o(18893);
                    return;
            }
            AppMethodBeat.m2505o(18893);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI$7 */
    class C114077 implements C33824h {
        C114077() {
        }

        /* renamed from: dP */
        public final void mo23158dP(int i, int i2) {
            AppMethodBeat.m2504i(18895);
            CleanMsgUI.this.ehJ.setMessage(CleanMsgUI.this.getString(C25738R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
            AppMethodBeat.m2505o(18895);
        }

        /* renamed from: hi */
        public final void mo23159hi(final long j) {
            AppMethodBeat.m2504i(18896);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(18894);
                    if (CleanMsgUI.this.ehJ != null) {
                        CleanMsgUI.this.ehJ.dismiss();
                    }
                    C27642d.m43921hg(C27642d.bfW() + j);
                    C27642d.m43920hf(C27642d.bfV() - j);
                    CleanMsgUI cleanMsgUI = CleanMsgUI.this;
                    C27642d.bfW();
                    CleanMsgUI.m84742a(cleanMsgUI, C27642d.bfT(), C27642d.bfV(), C27642d.bfU());
                    AppMethodBeat.m2505o(18894);
                }
            });
            C7060h.pYm.mo8378a(282, 12, 1, false);
            C7060h.pYm.mo8378a(282, 13, j / 1024, false);
            AppMethodBeat.m2505o(18896);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI$4 */
    class C338284 implements OnMenuItemClickListener {
        C338284() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18891);
            CleanMsgUI.m84741a(CleanMsgUI.this);
            AppMethodBeat.m2505o(18891);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI$1 */
    class C388001 implements OnMenuItemClickListener {
        C388001() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18887);
            CleanMsgUI.this.finish();
            AppMethodBeat.m2505o(18887);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI$3 */
    class C388013 implements View.OnClickListener {
        C388013() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18890);
            CleanMsgUI.this.startActivityForResult(new Intent(CleanMsgUI.this, CleanChattingUI.class), 0);
            C7060h.pYm.mo8378a(282, 4, 1, false);
            AppMethodBeat.m2505o(18890);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI$2 */
    class C458122 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI$2$1 */
        class C114061 implements OnClickListener {
            C114061() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18888);
                CleanMsgUI.m84743a(CleanMsgUI.this, C27642d.bfR());
                AppMethodBeat.m2505o(18888);
            }
        }

        C458122() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18889);
            C30379h.m48466d(CleanMsgUI.this, CleanMsgUI.this.getString(C25738R.string.aqf, new Object[]{C5046bo.m7580my(C27642d.bfV())}), "", CleanMsgUI.this.getString(C25738R.string.f9187s6), CleanMsgUI.this.getString(C25738R.string.f9076or), new C114061(), null);
            AppMethodBeat.m2505o(18889);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m84742a(CleanMsgUI cleanMsgUI, long j, long j2, long j3) {
        AppMethodBeat.m2504i(18910);
        cleanMsgUI.m84747i(j, j2, j3);
        AppMethodBeat.m2505o(18910);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18897);
        super.onCreate(bundle);
        C7060h.pYm.mo8378a(282, 3, 1, false);
        C27642d.bfZ();
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
        this.kyb = (TextView) findViewById(2131822780);
        this.kyc = (TextView) findViewById(2131822785);
        this.kyd = (TextView) findViewById(2131822789);
        this.kxY = findViewById(2131822782);
        setMMTitle((int) C25738R.string.aqq);
        C27642d.m43916a(new C11387b());
        setBackBtn(new C388001());
        this.kxT.setOnClickListener(new C458122());
        this.kxS.setOnClickListener(new C388013());
        addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new C338284());
        enableOptionMenu(0, false);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.apz), false, new C28135());
        this.ehJ.dismiss();
        if (C27642d.bfS() != null) {
            this.kxR.setVisibility(8);
            this.kxS.setEnabled(true);
            enableOptionMenu(0, true);
            C27642d.bfW();
            m84747i(C27642d.bfT(), C27642d.bfV(), C27642d.bfU());
            AppMethodBeat.m2505o(18897);
            return;
        }
        C11387b bfQ = C27642d.bfQ();
        if (bfQ != null) {
            this.kyR = new C20227c(bfQ, this);
            C7305d.post(this.kyR, "CleanUI_clean");
            this.kxR.setText(getString(C25738R.string.f8811fp, new Object[]{"0%"}));
        }
        AppMethodBeat.m2505o(18897);
    }

    public final int getLayoutId() {
        return 2130969146;
    }

    /* renamed from: h */
    private void m84746h(long j, long j2, long j3) {
        int i;
        AppMethodBeat.m2504i(18898);
        int i2 = (int) ((360 * j2) / j);
        if (i2 < 5) {
            i = 5;
        } else {
            i = i2;
        }
        i2 = 0;
        if (j3 > 0) {
            i2 = (int) ((360 * j3) / j);
            if (i2 < 5) {
                i2 = 5;
            }
        }
        long j4 = (j - j2) - j3;
        int i3 = (int) ((360 * j4) / j);
        C4990ab.m7417i("MicroMsg.CleanMsgUI", "update [%d %d] [%d %d] [%d %d] wechatSize[%d]", Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), Integer.valueOf(i3), Long.valueOf(j));
        this.kxQ.setGreenTargetAngle(i);
        this.kxQ.setOtherAccTargetAngle(i2);
        this.kxQ.setStage(1);
        this.kxP.setVisibility(0);
        this.kxU.setText(C5046bo.m7565ga(j2));
        this.kxV.setText(C5046bo.m7565ga(j3));
        this.kxW.setText(C5046bo.m7565ga(j4));
        if (j3 > 0) {
            this.kxY.setVisibility(0);
            this.kxT.setVisibility(0);
        } else {
            this.kxT.setVisibility(8);
            this.kxY.setVisibility(8);
        }
        i2 = (int) ((100 * j2) / j);
        this.kyb.setText(getString(C25738R.string.aps, new Object[]{i2 + "%"}));
        i2 = (int) ((100 * j3) / j);
        this.kyc.setText(getString(C25738R.string.aqe, new Object[]{i2 + "%"}));
        i2 = (int) ((100 * j4) / j);
        this.kyd.setText(getString(C25738R.string.aqh, new Object[]{i2 + "%"}));
        AppMethodBeat.m2505o(18898);
    }

    /* renamed from: i */
    private void m84747i(long j, long j2, long j3) {
        AppMethodBeat.m2504i(18899);
        m84746h(j, j3, j2);
        AppMethodBeat.m2505o(18899);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(18900);
        if (this.kyR != null) {
            Runnable runnable = this.kyR;
            C4990ab.m7417i("MicroMsg.CleanController", "stop CleanController [%d]", Integer.valueOf(runnable.hashCode()));
            runnable.isStop = true;
            C7305d.xDG.remove(runnable);
        }
        if (this.kyL != null) {
            this.kyL.bgb();
        }
        if (C27642d.bfQ() != null) {
            C11387b bfQ = C27642d.bfQ();
            for (C7306ak removeCallbacksAndMessages : bfQ.kwM.values()) {
                removeCallbacksAndMessages.removeCallbacksAndMessages(null);
            }
            for (C7306ak removeCallbacksAndMessages2 : bfQ.kwM.values()) {
                removeCallbacksAndMessages2.getLooper().getThread().interrupt();
                removeCallbacksAndMessages2.getLooper().quit();
            }
            C4990ab.m7417i("MicroMsg.ThreadController", "finish thread controller [%d]", Integer.valueOf(bfQ.hashCode()));
        }
        C27642d.bga();
        C27642d.bfY();
        super.onDestroy();
        AppMethodBeat.m2505o(18900);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(18901);
        super.onActivityResult(i, i2, intent);
        C27642d.bfW();
        m84747i(C27642d.bfT(), C27642d.bfV(), C27642d.bfU());
        AppMethodBeat.m2505o(18901);
    }

    /* renamed from: dO */
    public final void mo45501dO(int i, int i2) {
        AppMethodBeat.m2504i(18902);
        this.kxR.setText(getString(C25738R.string.f8811fp, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.m2505o(18902);
    }

    /* renamed from: a */
    public final void mo45500a(long j, long j2, long j3, ArrayList<C27641b> arrayList, long j4, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(18903);
        C4990ab.m7417i("MicroMsg.CleanMsgUI", "%d on clean result cleanDataSize[%d] wechatSize[%d] otherAccSize[%d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j4));
        this.kxR.setVisibility(8);
        this.kxS.setEnabled(true);
        enableOptionMenu(0, true);
        m84747i(j2, j4, j3);
        if (j > 0) {
            this.kxZ.setVisibility(0);
            this.kxZ.setText(getString(C25738R.string.aq1, new Object[]{C5046bo.m7565ga(j)}));
        } else {
            this.kxZ.setVisibility(8);
            this.kxZ.setText("");
        }
        C27642d.m43921hg(j);
        C27642d.m43918hd(j2);
        C27642d.m43920hf(j4);
        C27642d.m43917b(hashSet);
        C27642d.m43919he(j3);
        C27642d.m43922u(arrayList);
        if (j4 > 0) {
            C7060h.pYm.mo8378a(282, 9, 1, false);
            AppMethodBeat.m2505o(18903);
            return;
        }
        C7060h.pYm.mo8378a(282, 10, 1, false);
        AppMethodBeat.m2505o(18903);
    }

    /* renamed from: dP */
    public final void mo23158dP(int i, int i2) {
        AppMethodBeat.m2504i(18904);
        this.ehJ.setMessage(getString(C25738R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.m2505o(18904);
    }

    /* renamed from: hi */
    public final void mo23159hi(long j) {
        AppMethodBeat.m2504i(18905);
        this.ehJ.dismiss();
        C27642d.m43918hd(C27642d.bfT() - j);
        C27642d.m43921hg(C27642d.bfW() + j);
        C27642d.bfW();
        m84747i(C27642d.bfT(), C27642d.bfV(), C27642d.bfU());
        AppMethodBeat.m2505o(18905);
    }

    /* renamed from: a */
    static /* synthetic */ void m84741a(CleanMsgUI cleanMsgUI) {
        AppMethodBeat.m2504i(18907);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(cleanMsgUI.getString(C25738R.string.dgs));
        arrayList2.add(Integer.valueOf(0));
        C30379h.m48420a((Context) cleanMsgUI, null, arrayList, arrayList2, null, false, new C28146());
        AppMethodBeat.m2505o(18907);
    }

    static /* synthetic */ long bgm() {
        long j;
        AppMethodBeat.m2504i(18908);
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        long j2 = 0;
        if (C27642d.bfS() != null) {
            Iterator it = C27642d.bfS().iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                C27641b c27641b = (C27641b) it.next();
                if (c27641b.kwf != null) {
                    Iterator it2 = c27641b.kwf.iterator();
                    while (it2.hasNext()) {
                        C11389a c11389a = (C11389a) it2.next();
                        if (c11389a.fXb < timeInMillis) {
                            j += c11389a.size;
                        }
                    }
                }
                j2 = j;
            }
        } else {
            j = 0;
        }
        AppMethodBeat.m2505o(18908);
        return j;
    }

    static /* synthetic */ ArrayList bgn() {
        AppMethodBeat.m2504i(18909);
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        for (int size = C27642d.bfS().size() - 1; size >= 0; size--) {
            C27641b c27641b = (C27641b) C27642d.bfS().get(size);
            for (int size2 = c27641b.kwf.size() - 1; size2 >= 0; size2--) {
                if (((C11389a) c27641b.kwf.get(size2)).fXb < timeInMillis) {
                    arrayList.add(c27641b.kwf.get(size2));
                    c27641b.kwf.remove(size2);
                }
            }
            if (!c27641b.bfI()) {
                C27642d.bfS().remove(size);
            }
        }
        AppMethodBeat.m2505o(18909);
        return arrayList;
    }
}
