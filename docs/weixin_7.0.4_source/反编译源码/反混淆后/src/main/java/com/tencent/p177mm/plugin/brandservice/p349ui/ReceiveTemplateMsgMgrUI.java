package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.brandservice.p926b.C42793d;
import com.tencent.p177mm.plugin.brandservice.p926b.C42795k;
import com.tencent.p177mm.protocal.protobuf.azo;
import com.tencent.p177mm.protocal.protobuf.azq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI */
public class ReceiveTemplateMsgMgrUI extends MMPreference implements C1202f {
    private static LinkedList<azo> jMt;
    private ProgressDialog ehJ;
    protected C15541f iFE;
    private String jMs;
    private boolean jMu = false;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI$1 */
    class C447221 implements OnMenuItemClickListener {
        C447221() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(14021);
            ReceiveTemplateMsgMgrUI.this.finish();
            AppMethodBeat.m2505o(14021);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI$3 */
    class C447233 implements Runnable {
        C447233() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14023);
            if (ReceiveTemplateMsgMgrUI.this.jMu) {
                ReceiveTemplateMsgMgrUI.this.jMu = false;
                C1720g.m3540Rg().mo14541a(new C42795k(ReceiveTemplateMsgMgrUI.this.jMs, ReceiveTemplateMsgMgrUI.jMt), 0);
            }
            AppMethodBeat.m2505o(14023);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970467;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8528bc;
    }

    public final int aWi() {
        return 2130970466;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(14024);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(1031, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1030, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(14024);
    }

    public void onPause() {
        AppMethodBeat.m2504i(14025);
        if (this.jMu) {
            C4990ab.m7410d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
            this.jMu = false;
            C1720g.m3540Rg().mo14541a(new C42795k(this.jMs, jMt), 0);
        }
        super.onPause();
        AppMethodBeat.m2505o(14025);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(14026);
        C1720g.m3540Rg().mo14546b(1031, (C1202f) this);
        C1720g.m3540Rg().mo14546b(1030, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(14026);
    }

    public final void initView() {
        AppMethodBeat.m2504i(14027);
        setMMTitle((int) C25738R.string.az_);
        this.iFE = this.yCw;
        this.jMs = getIntent().getStringExtra("enterprise_biz_name");
        if (C5046bo.isNullOrNil(this.jMs)) {
            C4990ab.m7412e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
            finish();
            AppMethodBeat.m2505o(14027);
            return;
        }
        setBackBtn(new C447221());
        final C1207m c42793d = new C42793d(this.jMs);
        C1720g.m3540Rg().mo14541a(c42793d, 0);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.diu), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(14022);
                C1720g.m3540Rg().mo14547c(c42793d);
                AppMethodBeat.m2505o(14022);
            }
        });
        AppMethodBeat.m2505o(14027);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(14028);
        if (jMt == null) {
            C4990ab.m7420w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
            AppMethodBeat.m2505o(14028);
        } else {
            String str = preference.mKey;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
                AppMethodBeat.m2505o(14028);
            } else {
                Iterator it = jMt.iterator();
                while (it.hasNext()) {
                    azo azo = (azo) it.next();
                    if (str.equals(C5046bo.nullAsNil(azo.wDw))) {
                        this.jMu = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            azo.vEq = 0;
                        } else {
                            azo.vEq = 1;
                        }
                        if (this.jMu) {
                            C4990ab.m7410d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                            C5004al.m7442n(new C447233(), 4000);
                        }
                        AppMethodBeat.m2505o(14028);
                    }
                }
                if (this.jMu) {
                }
                AppMethodBeat.m2505o(14028);
            }
        }
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(14029);
        if (c1207m == null) {
            C4990ab.m7413e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(14029);
            return;
        }
        C4990ab.m7417i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(c1207m.getType()));
        if (c1207m.getType() == 1031) {
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (i == 0 && i2 == 0) {
                azq azq;
                C42793d c42793d = (C42793d) c1207m;
                if (c42793d.ehh == null || c42793d.ehh.fsH.fsP == null) {
                    azq = null;
                } else {
                    azq = (azq) c42793d.ehh.fsH.fsP;
                }
                jMt = azq.wDx;
                LinkedList linkedList = jMt;
                this.iFE.removeAll();
                if (linkedList == null || linkedList.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
                    m81436eD(true);
                    AppMethodBeat.m2505o(14029);
                    return;
                }
                m81436eD(false);
                C4990ab.m7411d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", Integer.valueOf(linkedList.size()));
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    boolean z;
                    azo azo = (azo) it.next();
                    CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                    checkBoxPreference.yDf = false;
                    checkBoxPreference.setKey(azo.wDw);
                    checkBoxPreference.setTitle((CharSequence) azo.Title);
                    if (azo.vEq == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    checkBoxPreference.uOT = z;
                    this.iFE.mo27713b(checkBoxPreference);
                }
                this.iFE.notifyDataSetChanged();
                C4990ab.m7410d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
                AppMethodBeat.m2505o(14029);
                return;
            }
            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.dir), 1).show();
            m81436eD(true);
            AppMethodBeat.m2505o(14029);
        } else if (c1207m.getType() != 1030 || (i == 0 && i2 == 0)) {
            AppMethodBeat.m2505o(14029);
        } else {
            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.dis), 0).show();
            AppMethodBeat.m2505o(14029);
        }
    }

    /* renamed from: eD */
    private void m81436eD(boolean z) {
        AppMethodBeat.m2504i(14030);
        View findViewById = findViewById(2131826875);
        View findViewById2 = findViewById(2131826874);
        if (findViewById != null) {
            if (z) {
                ((TextView) findViewById).setVisibility(0);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                    AppMethodBeat.m2505o(14030);
                    return;
                }
            }
            ((TextView) findViewById).setVisibility(8);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(14030);
    }
}
