package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public class NearbyFriendsIntroUI extends MMActivity {
    private Button grC;
    private View oPR;
    private CheckBox oPS;
    private c oPU = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55437);
        super.onCreate(bundle);
        setMMTitle((int) R.string.d57);
        initView();
        AppMethodBeat.o(55437);
    }

    public final int getLayoutId() {
        return R.layout.aig;
    }

    public final void initView() {
        AppMethodBeat.i(55438);
        bVc();
        this.grC = (Button) findViewById(R.id.dgk);
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55435);
                if (NearbyFriendsIntroUI.this.oPU == null) {
                    NearbyFriendsIntroUI.this.oPU = h.a(NearbyFriendsIntroUI.this.mController.ylL, NearbyFriendsIntroUI.this.getString(R.string.tz), NearbyFriendsIntroUI.this.oPR, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(55434);
                            g.RP().Ry().set(4103, Boolean.TRUE);
                            g.RP().Ry().set(4104, Boolean.valueOf(!NearbyFriendsIntroUI.this.oPS.isChecked()));
                            bp aap = bp.aap();
                            if (aap == null) {
                                NearbyFriendsIntroUI.this.startActivity(new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class));
                            } else {
                                String nullAsNil = bo.nullAsNil(aap.getProvince());
                                bo.nullAsNil(aap.getCity());
                                int a = bo.a(Integer.valueOf(aap.dtS), 0);
                                if (nullAsNil.equals("") || a == 0) {
                                    NearbyFriendsIntroUI.this.startActivity(new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class));
                                } else {
                                    NearbyFriendsIntroUI.this.startActivity(new Intent(NearbyFriendsIntroUI.this, NearbyFriendsUI.class));
                                }
                            }
                            NearbyFriendsIntroUI.this.finish();
                            AppMethodBeat.o(55434);
                        }
                    }, null);
                    AppMethodBeat.o(55435);
                    return;
                }
                NearbyFriendsIntroUI.this.oPU.show();
                AppMethodBeat.o(55435);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55436);
                NearbyFriendsIntroUI.this.aqX();
                NearbyFriendsIntroUI.this.finish();
                AppMethodBeat.o(55436);
                return true;
            }
        });
        AppMethodBeat.o(55438);
    }

    private void bVc() {
        AppMethodBeat.i(55439);
        this.oPR = View.inflate(this, R.layout.a9s, null);
        this.oPS = (CheckBox) this.oPR.findViewById(R.id.cp8);
        this.oPS.setChecked(false);
        AppMethodBeat.o(55439);
    }
}
