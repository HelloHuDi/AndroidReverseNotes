package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.chatroom.c.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI extends MMPreference implements f {
    private ProgressDialog ehJ = null;
    private com.tencent.mm.ui.base.preference.f ehK;
    private String ekC = "";
    private int ekD = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.bd;
    }

    private void Ke() {
        AppMethodBeat.i(104208);
        int a = bo.a((Integer) g.RP().Ry().get(135175, null), 0);
        Preference aqO = this.ehK.aqO("settings_room_size");
        if (aqO != null && a > 0) {
            aqO.setSummary(getResources().getQuantityString(R.plurals.a0, a, new Object[]{Integer.valueOf(a)}));
            aqO.setEnabled(false);
        } else if (aqO != null) {
            this.ehK.d(aqO);
        }
        this.ehK.aqO("room_right_max_tip").setTitle(getString(R.string.dua, new Object[]{Integer.valueOf(a)}));
        int a2 = bo.a((Integer) g.RP().Ry().get(135176, null), 0);
        RoomGrantPreference roomGrantPreference = (RoomGrantPreference) this.ehK.aqO("settings_room_grant");
        if (roomGrantPreference != null && a2 <= 0) {
            this.ehK.d(roomGrantPreference);
        } else if (roomGrantPreference != null) {
            roomGrantPreference.setEnabled(false);
            String str = getString(R.string.dud, new Object[]{Integer.valueOf(a2)});
            roomGrantPreference.ekv = str;
            if (roomGrantPreference.eku != null) {
                roomGrantPreference.eku.setText(str);
            }
        }
        Preference aqO2 = this.ehK.aqO("room_right_tip");
        Preference aqO3 = this.ehK.aqO("room_right_grant_tip");
        if (a2 <= 0) {
            if (aqO2 != null) {
                this.ehK.d(aqO2);
            }
            if (aqO3 != null) {
                this.ehK.d(aqO3);
            }
            Preference aqO4 = this.ehK.aqO("room_grant_to_friend");
            if (aqO4 != null) {
                this.ehK.d(aqO4);
            }
            if (roomGrantPreference != null) {
                this.ehK.d(roomGrantPreference);
            }
            AppMethodBeat.o(104208);
            return;
        }
        CharSequence string = getString(R.string.due, new Object[]{Integer.valueOf(a2), Integer.valueOf(a)});
        if (aqO2 != null) {
            aqO2.setTitle(string);
        }
        string = getString(R.string.du8, new Object[]{Integer.valueOf(this.ekD)});
        if (aqO3 != null) {
            aqO3.setTitle(string);
        }
        AppMethodBeat.o(104208);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104209);
        super.onCreate(bundle);
        this.ekD = bo.a((Integer) g.RP().Ry().get(135177, null), 0);
        g.RO().eJo.a(339, (f) this);
        g.RO().eJo.a(30, (f) this);
        g.RP().Ry().set(135184, Boolean.FALSE);
        initView();
        AppMethodBeat.o(104209);
    }

    public void onResume() {
        AppMethodBeat.i(104210);
        super.onResume();
        Ke();
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(104210);
    }

    public void onDestroy() {
        AppMethodBeat.i(104212);
        super.onDestroy();
        g.RO().eJo.b(339, (f) this);
        g.RO().eJo.b(30, (f) this);
        AppMethodBeat.o(104212);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(104214);
        ab.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", Integer.valueOf(i));
        if (i2 != -1 || intent == null) {
            AppMethodBeat.o(104214);
            return;
        }
        switch (i) {
            case 1:
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                ab.d("MicroMsg.RoomRightUI", "pick user %s", stringExtra);
                if (!bo.isNullOrNil(stringExtra)) {
                    this.ekC = stringExtra;
                    final String str = this.ekC;
                    h.a(this.mController.ylL, getString(R.string.dsi, new Object[]{((j) g.K(j.class)).XM().aoO(str).Oj(), Integer.valueOf(this.ekD)}), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(104206);
                            final m lVar = new l(str);
                            RoomRightUI roomRightUI = RoomRightUI.this;
                            Context context = RoomRightUI.this;
                            RoomRightUI.this.getString(R.string.tz);
                            roomRightUI.ehJ = h.b(context, "", true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(104205);
                                    g.RO().eJo.c(lVar);
                                    AppMethodBeat.o(104205);
                                }
                            });
                            g.RO().eJo.a(lVar, 0);
                            AppMethodBeat.o(104206);
                        }
                    }, null);
                    break;
                }
                AppMethodBeat.o(104214);
                return;
        }
        AppMethodBeat.o(104214);
    }

    private void a(final LinkedList<String> linkedList) {
        AppMethodBeat.i(104215);
        Assert.assertTrue(linkedList.size() > 0);
        String string = ah.getContext().getString(R.string.ajw);
        linkedList.size();
        Object[] objArr = new Object[1];
        List linkedList2 = new LinkedList();
        if (g.RK()) {
            for (String mJ : linkedList) {
                linkedList2.add(s.mJ(mJ));
            }
        }
        objArr[0] = bo.c(linkedList2, string);
        h.a((Context) this, getString(R.string.dub, objArr), getString(R.string.tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(104207);
                RoomRightUI.a(RoomRightUI.this, linkedList);
                AppMethodBeat.o(104207);
            }
        });
        AppMethodBeat.o(104215);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(104216);
        ab.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        if (mVar.getType() != 339) {
            AppMethodBeat.o(104216);
            return;
        }
        String str2;
        ad aoO = ((j) g.K(j.class)).XM().aoO(this.ekC);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            str2 = this.ekC;
        } else {
            str2 = aoO.Oj();
        }
        if (i == 0 && i2 == 0) {
            h.b((Context) this, getString(R.string.dsl, new Object[]{str2}), getString(R.string.tz), true);
            if (this.ehK != null) {
                Ke();
                this.ehK.notifyDataSetChanged();
            }
            AppMethodBeat.o(104216);
        } else if (i2 == -251) {
            h.b((Context) this, getString(R.string.dsj, new Object[]{str2, Integer.valueOf(this.ekD)}), getString(R.string.tz), true);
            AppMethodBeat.o(104216);
        } else if (i2 == -44) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.ekC);
            a(linkedList);
            AppMethodBeat.o(104216);
        } else if (i2 == -22) {
            h.b((Context) this, getString(R.string.dsk, new Object[]{str2}), getString(R.string.tz), true);
            AppMethodBeat.o(104216);
        } else {
            Toast.makeText(this, "err :" + i + " ," + i2, 0).show();
            AppMethodBeat.o(104216);
        }
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(104211);
        if (preference.mKey.equals("room_grant_to_friend")) {
            Intent intent = new Intent();
            intent.setClassName(ah.getPackageName(), ah.getPackageName() + ".ui.contact.SelectContactUI");
            intent.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
            intent.putExtra("List_Type", 4);
            intent.putExtra("select_contact_pick_result", true);
            List linkedList = new LinkedList();
            linkedList.add("officialaccounts");
            intent.putExtra("Block_list", bo.c(linkedList, ","));
            intent.putExtra("Add_SendCard", true);
            intent.putExtra("is_multi_select", false);
            startActivityForResult(intent, 1);
        }
        AppMethodBeat.o(104211);
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(104213);
        this.ehK = this.yCw;
        setMMTitle((int) R.string.ea3);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104204);
                RoomRightUI.this.aqX();
                RoomRightUI.this.finish();
                AppMethodBeat.o(104204);
                return true;
            }
        });
        AppMethodBeat.o(104213);
    }
}
