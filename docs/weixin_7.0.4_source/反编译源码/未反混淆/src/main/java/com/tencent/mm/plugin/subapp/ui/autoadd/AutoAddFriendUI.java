package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class AutoAddFriendUI extends MMActivity {
    private int status;
    private MMSwitchBtn str = null;
    private TextView sts = null;
    private MMSwitchBtn stt = null;
    private SparseIntArray stu = new SparseIntArray();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AutoAddFriendUI() {
        AppMethodBeat.i(25332);
        AppMethodBeat.o(25332);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25333);
        super.onCreate(bundle);
        setMMTitle((int) R.string.x7);
        this.status = r.YD();
        initView();
        AppMethodBeat.o(25333);
    }

    private boolean cDG() {
        AppMethodBeat.i(25334);
        aw.ZK();
        c.Ry().set(7, Integer.valueOf(this.status));
        for (int i = 0; i < this.stu.size(); i++) {
            int keyAt = this.stu.keyAt(i);
            int valueAt = this.stu.valueAt(i);
            act act = new act();
            act.wkw = keyAt;
            act.pvD = valueAt;
            aw.ZK();
            c.XL().c(new a(23, act));
            ab.d("MicroMsg.AutoAddFriendUI", "switch  " + keyAt + " " + valueAt);
        }
        this.stu.clear();
        AppMethodBeat.o(25334);
        return true;
    }

    private boolean Be(int i) {
        return (this.status & i) != 0;
    }

    public final int getLayoutId() {
        return R.layout.f1;
    }

    public final void initView() {
        AppMethodBeat.i(25335);
        this.str = (MMSwitchBtn) findViewById(R.id.a07);
        this.sts = (TextView) findViewById(R.id.a08);
        this.stt = (MMSwitchBtn) findViewById(R.id.a09);
        this.str.setCheck(Be(32));
        if (cDH() == 1) {
            this.stt.setCheck(Be(2097152));
            this.stt.setSwitchListener(new MMSwitchBtn.a() {
                public final void di(boolean z) {
                    AppMethodBeat.i(25329);
                    AutoAddFriendUI.a(AutoAddFriendUI.this, z, 2097152, 32);
                    AppMethodBeat.o(25329);
                }
            });
        } else {
            this.sts.setVisibility(8);
            this.stt.setVisibility(8);
        }
        this.str.setSwitchListener(new MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(25330);
                AutoAddFriendUI.a(AutoAddFriendUI.this, z, 32, 4);
                AppMethodBeat.o(25330);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25331);
                AutoAddFriendUI.this.finish();
                AppMethodBeat.o(25331);
                return true;
            }
        });
        AppMethodBeat.o(25335);
    }

    private static int cDH() {
        int i;
        AppMethodBeat.i(25336);
        String value = g.Nu().getValue("AutoAddFriendShow");
        if (bo.isNullOrNil(value)) {
            value = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        try {
            i = bo.getInt(value, 0);
        } catch (Exception e) {
            i = 0;
        }
        ab.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", Integer.valueOf(i));
        AppMethodBeat.o(25336);
        return i;
    }

    public void onResume() {
        AppMethodBeat.i(25337);
        super.onResume();
        AppMethodBeat.o(25337);
    }

    public void onPause() {
        AppMethodBeat.i(25338);
        super.onPause();
        cDG();
        AppMethodBeat.o(25338);
    }

    public void onDestroy() {
        AppMethodBeat.i(25339);
        super.onDestroy();
        AppMethodBeat.o(25339);
    }

    static /* synthetic */ boolean a(AutoAddFriendUI autoAddFriendUI, boolean z, int i, int i2) {
        AppMethodBeat.i(25340);
        ab.d("MicroMsg.AutoAddFriendUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            autoAddFriendUI.status |= i;
        } else {
            autoAddFriendUI.status &= i ^ -1;
        }
        autoAddFriendUI.stu.put(i2, z ? 1 : 2);
        AppMethodBeat.o(25340);
        return true;
    }
}
