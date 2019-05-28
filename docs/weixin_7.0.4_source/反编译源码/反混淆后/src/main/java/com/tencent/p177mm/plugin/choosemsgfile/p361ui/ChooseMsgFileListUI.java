package com.tencent.p177mm.plugin.choosemsgfile.p361ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.choosemsgfile.compat.C9236a.C9237a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42886a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C45809e;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C45809e.C28003;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI */
public class ChooseMsgFileListUI extends MMActivity implements C42890a {
    private RecyclerView aiB;
    private String edV;
    private TextView emq;
    private String kux;
    private ProgressDialog kvA;
    private String kvv;
    private C45809e kvw;
    private C42886a kvx = new C42886a();
    private RelativeLayout kvy;
    private Button kvz;
    private int mCount;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI$1 */
    class C202151 implements OnMenuItemClickListener {
        C202151() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(54411);
            ChooseMsgFileListUI.this.finish();
            AppMethodBeat.m2505o(54411);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI$2 */
    class C202162 implements OnMenuItemClickListener {
        C202162() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(54412);
            Intent intent = new Intent();
            intent.putExtra("ERRMSG", "cancel");
            ChooseMsgFileListUI.this.setResult(1, intent);
            ChooseMsgFileListUI.this.finish();
            ChooseMsgFileListUI.this.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8373ce);
            AppMethodBeat.m2505o(54412);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI$3 */
    class C202173 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI$3$1 */
        class C202181 implements C5662c {
            C202181() {
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(54413);
                C4990ab.m7417i("MicroMsg.ChooseMsgFileListUI", "bOk:%b", Boolean.valueOf(z));
                if (z) {
                    ChooseMsgFileListUI.m81466b(ChooseMsgFileListUI.this);
                }
                AppMethodBeat.m2505o(54413);
            }
        }

        C202173() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(54414);
            if (ChooseMsgFileListUI.this.kvx.bfF()) {
                C5659a c5659a = new C5659a(ChooseMsgFileListUI.this);
                c5659a.asL(ChooseMsgFileListUI.this.getString(C25738R.string.apg)).mo11526re(true);
                c5659a.mo11523c(new C202181()).show();
                AppMethodBeat.m2505o(54414);
                return;
            }
            ChooseMsgFileListUI.m81466b(ChooseMsgFileListUI.this);
            AppMethodBeat.m2505o(54414);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI$4 */
    class C202194 implements Runnable {
        C202194() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54415);
            ChooseMsgFileListUI.this.kvz.setEnabled(ChooseMsgFileListUI.this.kvx.getSelectCount() > 0);
            AppMethodBeat.m2505o(54415);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ChooseMsgFileListUI() {
        AppMethodBeat.m2504i(54417);
        AppMethodBeat.m2505o(54417);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(54418);
        C30036f.m47544m(this);
        super.onCreate(bundle);
        overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8373ce);
        this.edV = getIntent().getStringExtra("USERNAME");
        this.kux = C42887b.m76167mI(this.edV);
        this.mCount = getIntent().getIntExtra("COUNT", 9);
        this.kvv = getIntent().getStringExtra("EXTENSION");
        C4990ab.m7417i("MicroMsg.ChooseMsgFileListUI", "onCreate mCount:%d mExtension:%s", Integer.valueOf(this.mCount), this.kvv);
        this.kvw = new C45809e(this);
        initView();
        findViewById(2131821476).setBackgroundColor(-1);
        this.aiB.setBackgroundColor(-1);
        RecyclerView recyclerView = this.aiB;
        C45809e c45809e = this.kvw;
        if (c45809e.jop == null) {
            c45809e.jop = new LinearLayoutManager();
        }
        recyclerView.setLayoutManager(c45809e.jop);
        this.aiB.mo66330a(new C28003());
        this.aiB.setAdapter(this.kvw.bfB());
        this.aiB.setHasFixedSize(true);
        setMMTitle(this.kux);
        setBackBtn(new C202151());
        addTextOptionMenu(0, getString(C25738R.string.f9076or), new C202162());
        this.kvz.setOnClickListener(new C202173());
        this.kvw.mo35455dx("file", this.kvv);
        C30036f.m47545n(this);
        this.kvx.init(this.mCount);
        AppMethodBeat.m2505o(54418);
    }

    public final C42886a bfn() {
        return this.kvx;
    }

    public final String getUserName() {
        return this.edV;
    }

    public final void initView() {
        AppMethodBeat.m2504i(54419);
        this.emq = (TextView) findViewById(2131822748);
        this.aiB = (RecyclerView) findViewById(2131822749);
        this.kvy = (RelativeLayout) findViewById(2131822750);
        this.kvz = (Button) findViewById(2131822751);
        AppMethodBeat.m2505o(54419);
    }

    public void onResume() {
        AppMethodBeat.m2504i(54420);
        super.onResume();
        this.kvw.onResume();
        AppMethodBeat.m2505o(54420);
    }

    public void onPause() {
        AppMethodBeat.m2504i(54421);
        super.onPause();
        this.kvw.onPause();
        AppMethodBeat.m2505o(54421);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(54422);
        super.onDestroy();
        this.kvw.onDestroy();
        this.kvx.uninit();
        AppMethodBeat.m2505o(54422);
    }

    public void finish() {
        AppMethodBeat.m2504i(54423);
        super.finish();
        overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8373ce);
        AppMethodBeat.m2505o(54423);
    }

    public final int getLayoutId() {
        return 2130969136;
    }

    /* renamed from: fO */
    public final void mo61660fO(boolean z) {
        AppMethodBeat.m2504i(54424);
        m81469fE(true);
        AppMethodBeat.m2505o(54424);
    }

    /* renamed from: p */
    public final void mo61664p(boolean z, int i) {
        AppMethodBeat.m2504i(54425);
        m81469fE(false);
        C4990ab.m7417i("MicroMsg.ChooseMsgFileListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
        if (i <= 0) {
            this.emq.setVisibility(0);
            this.aiB.setVisibility(8);
            this.emq.setText(getString(C25738R.string.apk));
            AppMethodBeat.m2505o(54425);
            return;
        }
        this.emq.setVisibility(8);
        this.aiB.setVisibility(0);
        this.aiB.getAdapter().aop.notifyChanged();
        AppMethodBeat.m2505o(54425);
    }

    public final View getChildAt(int i) {
        AppMethodBeat.m2504i(54426);
        View childAt = this.aiB.getChildAt(i);
        AppMethodBeat.m2505o(54426);
        return childAt;
    }

    /* renamed from: fE */
    private void m81469fE(boolean z) {
        AppMethodBeat.m2504i(54427);
        C4990ab.m7417i("MicroMsg.ChooseMsgFileListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = C44275p.m79966b(this, getString(C25738R.string.cn5), true, null);
            AppMethodBeat.m2505o(54427);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.m2505o(54427);
    }

    public final void bfG() {
        AppMethodBeat.m2504i(54428);
        C5004al.m7441d(new C202194());
        AppMethodBeat.m2505o(54428);
    }

    /* renamed from: b */
    public static void m81467b(MMActivity mMActivity, String str, int i, String str2, final C9237a c9237a) {
        AppMethodBeat.m2504i(54429);
        Intent intent = new Intent(mMActivity, ChooseMsgFileListUI.class);
        intent.putExtra("USERNAME", str);
        intent.putExtra("COUNT", i);
        intent.putExtra("EXTENSION", str2);
        mMActivity.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(54416);
                C4990ab.m7417i("MicroMsg.ChooseMsgFileListUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                C4990ab.m7411d("MicroMsg.ChooseMsgFileListUI", "data:%s", intent);
                C42887b.m76157a(i, i2, intent, c9237a);
                AppMethodBeat.m2505o(54416);
            }
        };
        mMActivity.startActivityForResult(intent, 291);
        AppMethodBeat.m2505o(54429);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.ylL;
    }

    /* renamed from: b */
    static /* synthetic */ void m81466b(ChooseMsgFileListUI chooseMsgFileListUI) {
        AppMethodBeat.m2504i(54430);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("FILEPATHS", chooseMsgFileListUI.kvx.bfE());
        chooseMsgFileListUI.setResult(-1, intent);
        chooseMsgFileListUI.finish();
        AppMethodBeat.m2505o(54430);
    }
}
