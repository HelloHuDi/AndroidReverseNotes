package com.tencent.p177mm.plugin.subapp.p537ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI */
public class AutoAddFriendUI extends MMActivity {
    private int status;
    private MMSwitchBtn str = null;
    private TextView sts = null;
    private MMSwitchBtn stt = null;
    private SparseIntArray stu = new SparseIntArray();

    /* renamed from: com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI$2 */
    class C223392 implements C30795a {
        C223392() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(25330);
            AutoAddFriendUI.m34046a(AutoAddFriendUI.this, z, 32, 4);
            AppMethodBeat.m2505o(25330);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI$1 */
    class C223401 implements C30795a {
        C223401() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(25329);
            AutoAddFriendUI.m34046a(AutoAddFriendUI.this, z, 2097152, 32);
            AppMethodBeat.m2505o(25329);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI$3 */
    class C223413 implements OnMenuItemClickListener {
        C223413() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25331);
            AutoAddFriendUI.this.finish();
            AppMethodBeat.m2505o(25331);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AutoAddFriendUI() {
        AppMethodBeat.m2504i(25332);
        AppMethodBeat.m2505o(25332);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25333);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.f9340x7);
        this.status = C1853r.m3822YD();
        initView();
        AppMethodBeat.m2505o(25333);
    }

    private boolean cDG() {
        AppMethodBeat.m2504i(25334);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(7, Integer.valueOf(this.status));
        for (int i = 0; i < this.stu.size(); i++) {
            int keyAt = this.stu.keyAt(i);
            int valueAt = this.stu.valueAt(i);
            act act = new act();
            act.wkw = keyAt;
            act.pvD = valueAt;
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C3465a(23, act));
            C4990ab.m7410d("MicroMsg.AutoAddFriendUI", "switch  " + keyAt + " " + valueAt);
        }
        this.stu.clear();
        AppMethodBeat.m2505o(25334);
        return true;
    }

    /* renamed from: Be */
    private boolean m34045Be(int i) {
        return (this.status & i) != 0;
    }

    public final int getLayoutId() {
        return 2130968788;
    }

    public final void initView() {
        AppMethodBeat.m2504i(25335);
        this.str = (MMSwitchBtn) findViewById(2131821551);
        this.sts = (TextView) findViewById(2131821552);
        this.stt = (MMSwitchBtn) findViewById(2131821553);
        this.str.setCheck(m34045Be(32));
        if (AutoAddFriendUI.cDH() == 1) {
            this.stt.setCheck(m34045Be(2097152));
            this.stt.setSwitchListener(new C223401());
        } else {
            this.sts.setVisibility(8);
            this.stt.setVisibility(8);
        }
        this.str.setSwitchListener(new C223392());
        setBackBtn(new C223413());
        AppMethodBeat.m2505o(25335);
    }

    private static int cDH() {
        int i;
        AppMethodBeat.m2504i(25336);
        String value = C26373g.m41964Nu().getValue("AutoAddFriendShow");
        if (C5046bo.isNullOrNil(value)) {
            value = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        try {
            i = C5046bo.getInt(value, 0);
        } catch (Exception e) {
            i = 0;
        }
        C4990ab.m7411d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(25336);
        return i;
    }

    public void onResume() {
        AppMethodBeat.m2504i(25337);
        super.onResume();
        AppMethodBeat.m2505o(25337);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25338);
        super.onPause();
        cDG();
        AppMethodBeat.m2505o(25338);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25339);
        super.onDestroy();
        AppMethodBeat.m2505o(25339);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m34046a(AutoAddFriendUI autoAddFriendUI, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(25340);
        C4990ab.m7410d("MicroMsg.AutoAddFriendUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            autoAddFriendUI.status |= i;
        } else {
            autoAddFriendUI.status &= i ^ -1;
        }
        autoAddFriendUI.stu.put(i2, z ? 1 : 2);
        AppMethodBeat.m2505o(25340);
        return true;
    }
}
