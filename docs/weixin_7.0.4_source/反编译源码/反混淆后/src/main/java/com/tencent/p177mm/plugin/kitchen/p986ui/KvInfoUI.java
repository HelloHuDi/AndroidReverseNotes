package com.tencent.p177mm.plugin.kitchen.p986ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.picker.C40908b;
import com.tencent.p177mm.p612ui.widget.picker.C40908b.C40907a;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C3743d;
import com.tencent.p177mm.plugin.report.service.C3744e;
import com.tencent.p177mm.plugin.report.service.C7063j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.kitchen.ui.KvInfoUI */
public class KvInfoUI extends MMActivity {
    private C5653c gLj;
    private Button grC;
    private MMSwitchBtn ixT;
    private ArrayAdapter lOF;
    private EditText nHf;
    private Button nHg;
    private ListView nHh;
    private TextView nHi;
    private String nHj;

    /* renamed from: com.tencent.mm.plugin.kitchen.ui.KvInfoUI$2 */
    class C123312 implements OnClickListener {
        C123312() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(114442);
            HashMap hashMap = C7063j.cgu().pYD;
            if (hashMap != null && hashMap.size() > 0) {
                final ArrayList arrayList = new ArrayList(hashMap.keySet());
                final C40908b c40908b = new C40908b(KvInfoUI.this.mController.ylL, arrayList);
                c40908b.mo64522Qq(0);
                c40908b.zSq = new C40907a() {
                    /* renamed from: d */
                    public final void mo7219d(boolean z, Object obj) {
                        AppMethodBeat.m2504i(114441);
                        c40908b.hide();
                        KvInfoUI.m20253a(KvInfoUI.this, (String) arrayList.get(c40908b.dLl()));
                        AppMethodBeat.m2505o(114441);
                    }
                };
                c40908b.mo64521Qp(C1338a.fromDPToPix(KvInfoUI.this.mController.ylL, C31128d.MIC_PTU_YOUJIALI));
                c40908b.show();
            }
            AppMethodBeat.m2505o(114442);
        }
    }

    /* renamed from: com.tencent.mm.plugin.kitchen.ui.KvInfoUI$1 */
    class C123331 implements OnMenuItemClickListener {
        C123331() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(114440);
            KvInfoUI.this.finish();
            AppMethodBeat.m2505o(114440);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.kitchen.ui.KvInfoUI$3 */
    class C123343 implements C30795a {
        C123343() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(114443);
            C7063j cgu = C7063j.cgu();
            cgu.pWV = z;
            C3744e.m6062kh(cgu.pWV);
            C46180a.m86310kh(cgu.pWV);
            AppMethodBeat.m2505o(114443);
        }
    }

    /* renamed from: com.tencent.mm.plugin.kitchen.ui.KvInfoUI$4 */
    class C123354 implements OnClickListener {
        C123354() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(114444);
            KvInfoUI.m20253a(KvInfoUI.this, KvInfoUI.this.nHf.getText().toString().trim());
            AppMethodBeat.m2505o(114444);
        }
    }

    /* renamed from: com.tencent.mm.plugin.kitchen.ui.KvInfoUI$6 */
    class C123366 implements OnItemClickListener {

        /* renamed from: com.tencent.mm.plugin.kitchen.ui.KvInfoUI$6$1 */
        class C123381 implements DialogInterface.OnClickListener {
            C123381() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(114446);
                dialogInterface.cancel();
                AppMethodBeat.m2505o(114446);
            }
        }

        C123366() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(114448);
            C3743d c3743d = (C3743d) KvInfoUI.this.lOF.getItem(i);
            if (c3743d == null) {
                AppMethodBeat.m2505o(114448);
                return;
            }
            if (c3743d.cvZ == null || c3743d.cvZ.length() <= 0) {
                c3743d.cvZ = C4995ag.m7428ck(c3743d.value);
            }
            final String str = (String) C7063j.cgu().pYE.get(c3743d.cvZ);
            if (KvInfoUI.this.gLj != null) {
                KvInfoUI.this.gLj.dismiss();
            }
            if (!C5046bo.isNullOrNil(str)) {
                KvInfoUI.this.gLj = C30379h.m48446a(KvInfoUI.this, str, "", KvInfoUI.this.getString(C25738R.string.f9187s6), KvInfoUI.this.getString(C25738R.string.f9082oy), true, new C123381(), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(114447);
                        try {
                            ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("kv_info", str));
                            Toast.makeText(KvInfoUI.this.mController.ylL, KvInfoUI.this.mController.ylL.getString(C25738R.string.f9083oz), 0).show();
                            AppMethodBeat.m2505o(114447);
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.KvInfoUI", "copy error [%s]", e.toString());
                            Toast.makeText(KvInfoUI.this.mController.ylL, "copy failure", 0).show();
                            AppMethodBeat.m2505o(114447);
                        }
                    }
                }, -1);
            }
            AppMethodBeat.m2505o(114448);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(114449);
        super.onCreate(bundle);
        setMMTitle("Debug show kv log");
        setBackBtn(new C123331());
        this.nHf = (EditText) findViewById(2131825200);
        this.nHi = (TextView) findViewById(2131825203);
        this.nHg = (Button) findViewById(2131825201);
        this.nHg.setOnClickListener(new C123312());
        this.ixT = (MMSwitchBtn) findViewById(2131825202);
        this.ixT.setCheck(C7063j.cgu().pWV);
        this.ixT.setSwitchListener(new C123343());
        this.grC = (Button) findViewById(2131820999);
        this.grC.setOnClickListener(new C123354());
        this.nHh = (ListView) findViewById(2131825204);
        this.lOF = new ArrayAdapter(this) {
            public final View getView(int i, View view, ViewGroup viewGroup) {
                AppMethodBeat.m2504i(114445);
                View view2 = super.getView(i, view, viewGroup);
                C3743d c3743d = (C3743d) KvInfoUI.this.lOF.getItem(i);
                TextView textView = (TextView) view2.findViewById(2131825205);
                if (c3743d == null || !c3743d.pXS) {
                    textView.setBackgroundResource(C25738R.color.a3p);
                } else {
                    textView.setBackgroundResource(C25738R.color.a61);
                }
                AppMethodBeat.m2505o(114445);
                return view2;
            }
        };
        this.nHh.setAdapter(this.lOF);
        this.nHh.setOnItemClickListener(new C123366());
        AppMethodBeat.m2505o(114449);
    }

    public final int getLayoutId() {
        return 2130969914;
    }

    /* renamed from: PC */
    private void m20250PC(String str) {
        AppMethodBeat.m2504i(114450);
        C4990ab.m7417i("MicroMsg.KvInfoUI", "updateData new[%s] old[%s]", str, this.nHj);
        this.nHj = str;
        List list = (List) C7063j.cgu().pYD.get(this.nHj);
        if (list != null) {
            this.nHi.setText(this.nHj + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + list.size());
            this.lOF.setNotifyOnChange(false);
            this.lOF.clear();
            this.lOF.addAll(list);
            this.lOF.notifyDataSetChanged();
            AppMethodBeat.m2505o(114450);
            return;
        }
        this.nHi.setText(this.nHj + ":0");
        this.lOF.clear();
        AppMethodBeat.m2505o(114450);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(114451);
        if (this.lOF != null) {
            this.lOF.setNotifyOnChange(false);
            this.lOF.clear();
        }
        if (this.gLj != null) {
            this.gLj.dismiss();
        }
        aqX();
        super.onDestroy();
        AppMethodBeat.m2505o(114451);
    }

    public void onResume() {
        AppMethodBeat.m2504i(114452);
        if (!C5046bo.isNullOrNil(this.nHj)) {
            m20250PC(this.nHj);
        }
        super.onResume();
        AppMethodBeat.m2505o(114452);
    }
}
