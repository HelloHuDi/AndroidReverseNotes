package com.tencent.p177mm.plugin.choosemsgfile.p361ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.choosemsgfile.compat.C9236a.C9237a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42886a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C20211f;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C20211f.C202124;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI */
public class ChooseMsgFileUI extends MMActivity implements C42890a {
    private String edV;
    private TextView emq;
    private String kux;
    private ProgressDialog kvA;
    private C20211f kvH;
    private TextView kvI;
    private RecyclerView kvJ;
    private TextView kvK;
    private TextView kvL;
    private ImageButton kvM;
    private TextView kvN;
    private boolean kvO = true;
    private int kvP;
    private String kvv;
    private C42886a kvx = new C42886a();
    private RelativeLayout kvy;
    private Button kvz;
    private int mCount;
    private String mType;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$10 */
    class C1138510 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$10$1 */
        class C113861 implements C5662c {
            C113861() {
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(54453);
                C4990ab.m7417i("MicroMsg.ChooseMsgFileUI", "bOk:%b", Boolean.valueOf(z));
                if (z) {
                    ChooseMsgFileUI.m65822d(ChooseMsgFileUI.this);
                }
                AppMethodBeat.m2505o(54453);
            }
        }

        C1138510() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(54454);
            if (ChooseMsgFileUI.this.kvx.bfF()) {
                C5659a c5659a = new C5659a(ChooseMsgFileUI.this);
                c5659a.asL(ChooseMsgFileUI.this.getString(C25738R.string.apg)).mo11526re(true);
                c5659a.mo11523c(new C113861()).show();
                AppMethodBeat.m2505o(54454);
                return;
            }
            ChooseMsgFileUI.m65822d(ChooseMsgFileUI.this);
            AppMethodBeat.m2505o(54454);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$5 */
    class C202235 implements OnMenuItemClickListener {
        C202235() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(54448);
            Intent intent = new Intent();
            intent.putExtra("ERRMSG", "cancel");
            ChooseMsgFileUI.this.setResult(1, intent);
            ChooseMsgFileUI.this.finish();
            AppMethodBeat.m2505o(54448);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$6 */
    class C202246 implements OnClickListener {
        C202246() {
        }

        @SuppressLint({"ResourceType"})
        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.m2504i(54449);
            C42886a a = ChooseMsgFileUI.this.kvx;
            if (a.kvs) {
                z = false;
            } else {
                z = true;
            }
            a.kvs = z;
            if (ChooseMsgFileUI.this.kvx.kvs) {
                ChooseMsgFileUI.this.kvM.setImageResource(C1318a.radio_on);
                AppMethodBeat.m2505o(54449);
                return;
            }
            ChooseMsgFileUI.this.kvM.setImageResource(C1318a.radio_off);
            AppMethodBeat.m2505o(54449);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$7 */
    class C202257 implements OnClickListener {
        C202257() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(54450);
            ChooseMsgFileUI.this.kvM.performClick();
            AppMethodBeat.m2505o(54450);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$12 */
    class C3878912 implements C5279d {
        C3878912() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            String str;
            AppMethodBeat.m2504i(54456);
            ChooseMsgFileUI.this.mType;
            switch (i) {
                case 0:
                    str = "all";
                    break;
                case 1:
                    str = "image";
                    break;
                case 2:
                    str = "video";
                    break;
                case 3:
                    str = "file";
                    break;
                default:
                    str = "all";
                    break;
            }
            ChooseMsgFileUI.this.kvH.mo6921b(true, str, ChooseMsgFileUI.this.kvv);
            ChooseMsgFileUI.m65818a(ChooseMsgFileUI.this, str);
            AppMethodBeat.m2505o(54456);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$8 */
    class C387908 implements OnClickListener {
        C387908() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(54451);
            ChooseMsgFileUI.m65821c(ChooseMsgFileUI.this);
            AppMethodBeat.m2505o(54451);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$1 */
    class C387911 implements OnMenuItemClickListener {
        C387911() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(54440);
            ChooseMsgFileUI.this.finish();
            AppMethodBeat.m2505o(54440);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$3 */
    class C387923 implements Runnable {
        C387923() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54446);
            ChooseMsgFileUI.this.kvz.setEnabled(ChooseMsgFileUI.this.kvx.getSelectCount() > 0);
            AppMethodBeat.m2505o(54446);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$11 */
    class C3879311 implements C36073c {
        C3879311() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(54455);
            c44273l.mo70068e(0, ChooseMsgFileUI.this.getString(C25738R.string.apm));
            c44273l.mo70068e(1, ChooseMsgFileUI.this.getString(C25738R.string.apo));
            c44273l.mo70068e(2, ChooseMsgFileUI.this.getString(C25738R.string.app));
            c44273l.mo70068e(3, ChooseMsgFileUI.this.getString(C25738R.string.apn));
            AppMethodBeat.m2505o(54455);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$9 */
    class C387949 implements OnClickListener {
        C387949() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(54452);
            ChooseMsgFileUI.m65821c(ChooseMsgFileUI.this);
            AppMethodBeat.m2505o(54452);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$2 */
    class C387952 extends C41530m {
        private Runnable kvR = new C28041();

        /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI$2$1 */
        class C28041 implements Runnable {
            C28041() {
            }

            public final void run() {
                AppMethodBeat.m2504i(54441);
                ChooseMsgFileUI.this.kvI.startAnimation(AnimationUtils.loadAnimation(ChooseMsgFileUI.this.mController.ylL, C25738R.anim.f8333b6));
                ChooseMsgFileUI.this.kvI.setVisibility(8);
                AppMethodBeat.m2505o(54441);
            }
        }

        C387952() {
            AppMethodBeat.m2504i(54442);
            AppMethodBeat.m2505o(54442);
        }

        /* renamed from: fQ */
        private void m65834fQ(boolean z) {
            AppMethodBeat.m2504i(54443);
            if (z) {
                ChooseMsgFileUI.this.kvI.removeCallbacks(this.kvR);
                if (ChooseMsgFileUI.this.kvI.getVisibility() != 0) {
                    ChooseMsgFileUI.this.kvI.clearAnimation();
                    Animation loadAnimation = AnimationUtils.loadAnimation(ChooseMsgFileUI.this.mController.ylL, C25738R.anim.f8332b5);
                    ChooseMsgFileUI.this.kvI.setVisibility(0);
                    ChooseMsgFileUI.this.kvI.startAnimation(loadAnimation);
                    AppMethodBeat.m2505o(54443);
                    return;
                }
            }
            ChooseMsgFileUI.this.kvI.removeCallbacks(this.kvR);
            ChooseMsgFileUI.this.kvI.postDelayed(this.kvR, 256);
            AppMethodBeat.m2505o(54443);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(54444);
            super.mo6642a(recyclerView, i, i2);
            C11376a ts = ChooseMsgFileUI.this.kvH.kvi.mo54375ts(((LinearLayoutManager) ChooseMsgFileUI.this.kvH.bfC()).mo1780iQ());
            if (ts == null) {
                AppMethodBeat.m2505o(54444);
                return;
            }
            ChooseMsgFileUI.this.kvI.setText(C5046bo.m7532bc(C42887b.m76165ha(ts.getTimeStamp()), ""));
            AppMethodBeat.m2505o(54444);
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(54445);
            if (1 == i) {
                m65834fQ(true);
            } else if (i == 0) {
                m65834fQ(false);
            }
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                if (((LinearLayoutManager) recyclerView.getLayoutManager()).mo1780iQ() == 0 && !ChooseMsgFileUI.this.kvO) {
                    ChooseMsgFileUI.this.kvH.mo6921b(false, ChooseMsgFileUI.this.mType, ChooseMsgFileUI.this.kvv);
                }
                ChooseMsgFileUI.this.kvO = false;
                C32291o.ahp().mo43773cm(i);
            }
            AppMethodBeat.m2505o(54445);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ChooseMsgFileUI() {
        AppMethodBeat.m2504i(54457);
        AppMethodBeat.m2505o(54457);
    }

    /* renamed from: a */
    static /* synthetic */ void m65818a(ChooseMsgFileUI chooseMsgFileUI, String str) {
        AppMethodBeat.m2504i(54473);
        chooseMsgFileUI.m65815HM(str);
        AppMethodBeat.m2505o(54473);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(54458);
        C30036f.m47544m(this);
        super.onCreate(bundle);
        this.edV = getIntent().getStringExtra("USERNAME");
        this.kux = C42887b.m76167mI(this.edV);
        this.mType = C42887b.m76151HK(getIntent().getStringExtra("TYPE"));
        this.mCount = getIntent().getIntExtra("COUNT", 9);
        this.kvv = getIntent().getStringExtra("EXTENSION");
        C4990ab.m7417i("MicroMsg.ChooseMsgFileUI", "select msg file from username:%s nickname:%s, type:%s, count:%d", this.edV, this.kux, this.mType, Integer.valueOf(this.mCount));
        C4990ab.m7417i("MicroMsg.ChooseMsgFileUI", "select msg file from extension:%s", this.kvv);
        this.kvx.init(this.mCount);
        this.kvH = new C20211f(this);
        initView();
        this.kvJ.setLayoutManager(this.kvH.bfC());
        this.kvJ.mo66330a(new C202124(this));
        this.kvJ.setAdapter(this.kvH.bfB());
        this.kvJ.setHasFixedSize(true);
        this.kvJ.mo66332a(new C387952());
        setMMTitle(this.kux);
        setBackBtn(new C387911());
        addTextOptionMenu(0, getString(C25738R.string.f9076or), new C202235());
        this.kvM.setOnClickListener(new C202246());
        this.kvN.setOnClickListener(new C202257());
        this.kvK.setOnClickListener(new C387908());
        this.kvL.setOnClickListener(new C387949());
        this.kvz.setOnClickListener(new C1138510());
        this.kvH.mo35455dx(this.mType, this.kvv);
        m65815HM(this.mType);
        C30036f.m47545n(this);
        AppMethodBeat.m2505o(54458);
    }

    public final C42886a bfn() {
        return this.kvx;
    }

    public final String getUserName() {
        return this.edV;
    }

    public void onResume() {
        AppMethodBeat.m2504i(54459);
        super.onResume();
        this.kvH.onResume();
        AppMethodBeat.m2505o(54459);
    }

    public void onPause() {
        AppMethodBeat.m2504i(54460);
        super.onPause();
        C4990ab.m7416i("MicroMsg.ChooseMsgFileUIController", "onPause");
        AppMethodBeat.m2505o(54460);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(54461);
        super.onDestroy();
        this.kvH.onDestroy();
        this.kvx.uninit();
        AppMethodBeat.m2505o(54461);
    }

    public final void initView() {
        AppMethodBeat.m2504i(54462);
        this.emq = (TextView) findViewById(2131822748);
        this.kvI = (TextView) findViewById(2131820787);
        this.kvJ = (RecyclerView) findViewById(2131822749);
        this.kvy = (RelativeLayout) findViewById(2131822750);
        this.kvK = (TextView) findViewById(2131822753);
        this.kvL = (TextView) findViewById(2131822754);
        this.kvM = (ImageButton) findViewById(2131822755);
        this.kvN = (TextView) findViewById(2131822756);
        this.kvz = (Button) findViewById(2131822751);
        AppMethodBeat.m2505o(54462);
    }

    /* renamed from: HM */
    private void m65815HM(String str) {
        AppMethodBeat.m2504i(54463);
        if ("image".equals(str) || "all".equals(str)) {
            this.kvM.setVisibility(0);
            this.kvN.setVisibility(0);
        } else {
            this.kvM.setVisibility(4);
            this.kvN.setVisibility(4);
        }
        if ("all".equals(this.mType)) {
            this.kvK.setVisibility(0);
            this.kvL.setVisibility(0);
            m65816HN(str);
            AppMethodBeat.m2505o(54463);
            return;
        }
        this.kvK.setVisibility(4);
        this.kvL.setVisibility(4);
        AppMethodBeat.m2505o(54463);
    }

    /* renamed from: HN */
    private void m65816HN(String str) {
        AppMethodBeat.m2504i(54464);
        if ("all".equals(str)) {
            this.kvL.setText("");
            AppMethodBeat.m2505o(54464);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        if ("image".equals(str)) {
            stringBuilder.append(getString(C25738R.string.apo));
        } else if ("video".equals(str)) {
            stringBuilder.append(getString(C25738R.string.app));
        } else if ("file".equals(str)) {
            stringBuilder.append(getString(C25738R.string.apn));
        }
        stringBuilder.append(")");
        this.kvL.setText(stringBuilder.toString());
        AppMethodBeat.m2505o(54464);
    }

    /* renamed from: fO */
    public final void mo61660fO(boolean z) {
        AppMethodBeat.m2504i(54465);
        if (z) {
            m65825fP(true);
            AppMethodBeat.m2505o(54465);
            return;
        }
        this.kvP = ((GridLayoutManager) this.kvJ.getLayoutManager()).mo1782iS();
        AppMethodBeat.m2505o(54465);
    }

    /* renamed from: fP */
    private void m65825fP(boolean z) {
        AppMethodBeat.m2504i(54466);
        C4990ab.m7417i("MicroMsg.ChooseMsgFileUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = C44275p.m79966b(this, getString(C25738R.string.cn5), true, null);
            AppMethodBeat.m2505o(54466);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.m2505o(54466);
    }

    /* renamed from: p */
    public final void mo61664p(boolean z, int i) {
        AppMethodBeat.m2504i(54467);
        C4990ab.m7417i("MicroMsg.ChooseMsgFileUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            m65825fP(false);
            this.kvJ.getAdapter().aop.notifyChanged();
            this.kvJ.mo61465bY(this.kvJ.getAdapter().getItemCount() - 1);
            if (i <= 0) {
                this.emq.setVisibility(0);
                this.kvJ.setVisibility(8);
                this.emq.setText(getString(C25738R.string.apk));
                AppMethodBeat.m2505o(54467);
                return;
            }
            this.emq.setVisibility(8);
            this.kvJ.setVisibility(0);
            AppMethodBeat.m2505o(54467);
        } else if (i > 0) {
            this.kvJ.getAdapter().mo66310at(0, i);
            this.kvJ.getAdapter().mo66308ar(i, this.kvP + i);
            AppMethodBeat.m2505o(54467);
        } else {
            this.kvJ.getAdapter().mo66316cg(0);
            AppMethodBeat.m2505o(54467);
        }
    }

    public final void bfG() {
        AppMethodBeat.m2504i(54468);
        C5004al.m7441d(new C387923());
        AppMethodBeat.m2505o(54468);
    }

    public final View getChildAt(int i) {
        AppMethodBeat.m2504i(54469);
        View childAt = this.kvJ.getChildAt(i);
        AppMethodBeat.m2505o(54469);
        return childAt;
    }

    public final int getLayoutId() {
        return 2130969137;
    }

    /* renamed from: a */
    public static void m65819a(MMActivity mMActivity, String str, String str2, int i, String str3, final C9237a c9237a) {
        AppMethodBeat.m2504i(54470);
        Intent intent = new Intent(mMActivity, ChooseMsgFileUI.class);
        intent.putExtra("USERNAME", str);
        intent.putExtra("TYPE", str2);
        intent.putExtra("COUNT", i);
        intent.putExtra("EXTENSION", str3);
        mMActivity.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(54447);
                C4990ab.m7417i("MicroMsg.ChooseMsgFileUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                C4990ab.m7411d("MicroMsg.ChooseMsgFileUI", "data:%s", intent);
                C42887b.m76157a(i, i2, intent, c9237a);
                AppMethodBeat.m2505o(54447);
            }
        };
        mMActivity.startActivityForResult(intent, 291);
        AppMethodBeat.m2505o(54470);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.ylL;
    }

    /* renamed from: c */
    static /* synthetic */ void m65821c(ChooseMsgFileUI chooseMsgFileUI) {
        AppMethodBeat.m2504i(54471);
        C36356d c36356d = new C36356d(chooseMsgFileUI.mController.ylL, 1, false);
        c36356d.rBl = new C3879311();
        c36356d.rBm = new C3878912();
        c36356d.cpD();
        AppMethodBeat.m2505o(54471);
    }

    /* renamed from: d */
    static /* synthetic */ void m65822d(ChooseMsgFileUI chooseMsgFileUI) {
        AppMethodBeat.m2504i(54472);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("FILEPATHS", chooseMsgFileUI.kvx.bfE());
        chooseMsgFileUI.setResult(-1, intent);
        chooseMsgFileUI.finish();
        AppMethodBeat.m2505o(54472);
    }
}
