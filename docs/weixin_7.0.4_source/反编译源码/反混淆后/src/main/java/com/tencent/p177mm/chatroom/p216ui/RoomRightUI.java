package com.tencent.p177mm.chatroom.p216ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p710c.C6405l;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23275s.C23280a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.chatroom.ui.RoomRightUI */
public class RoomRightUI extends MMPreference implements C1202f {
    private ProgressDialog ehJ = null;
    private C15541f ehK;
    private String ekC = "";
    private int ekD = 0;

    /* renamed from: com.tencent.mm.chatroom.ui.RoomRightUI$1 */
    class C260201 implements OnMenuItemClickListener {
        C260201() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104204);
            RoomRightUI.this.aqX();
            RoomRightUI.this.finish();
            AppMethodBeat.m2505o(104204);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomRightUI$4 */
    class C324544 implements C23280a {
        C324544() {
        }

        /* renamed from: bD */
        public final void mo27248bD(boolean z) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8529bd;
    }

    /* renamed from: Ke */
    private void m53126Ke() {
        AppMethodBeat.m2504i(104208);
        int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(135175, null), 0);
        Preference aqO = this.ehK.aqO("settings_room_size");
        if (aqO != null && a > 0) {
            aqO.setSummary(getResources().getQuantityString(C25738R.plurals.f9614a0, a, new Object[]{Integer.valueOf(a)}));
            aqO.setEnabled(false);
        } else if (aqO != null) {
            this.ehK.mo27716d(aqO);
        }
        this.ehK.aqO("room_right_max_tip").setTitle(getString(C25738R.string.dua, new Object[]{Integer.valueOf(a)}));
        int a2 = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(135176, null), 0);
        RoomGrantPreference roomGrantPreference = (RoomGrantPreference) this.ehK.aqO("settings_room_grant");
        if (roomGrantPreference != null && a2 <= 0) {
            this.ehK.mo27716d(roomGrantPreference);
        } else if (roomGrantPreference != null) {
            roomGrantPreference.setEnabled(false);
            String str = getString(C25738R.string.dud, new Object[]{Integer.valueOf(a2)});
            roomGrantPreference.ekv = str;
            if (roomGrantPreference.eku != null) {
                roomGrantPreference.eku.setText(str);
            }
        }
        Preference aqO2 = this.ehK.aqO("room_right_tip");
        Preference aqO3 = this.ehK.aqO("room_right_grant_tip");
        if (a2 <= 0) {
            if (aqO2 != null) {
                this.ehK.mo27716d(aqO2);
            }
            if (aqO3 != null) {
                this.ehK.mo27716d(aqO3);
            }
            Preference aqO4 = this.ehK.aqO("room_grant_to_friend");
            if (aqO4 != null) {
                this.ehK.mo27716d(aqO4);
            }
            if (roomGrantPreference != null) {
                this.ehK.mo27716d(roomGrantPreference);
            }
            AppMethodBeat.m2505o(104208);
            return;
        }
        CharSequence string = getString(C25738R.string.due, new Object[]{Integer.valueOf(a2), Integer.valueOf(a)});
        if (aqO2 != null) {
            aqO2.setTitle(string);
        }
        string = getString(C25738R.string.du8, new Object[]{Integer.valueOf(this.ekD)});
        if (aqO3 != null) {
            aqO3.setTitle(string);
        }
        AppMethodBeat.m2505o(104208);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104209);
        super.onCreate(bundle);
        this.ekD = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(135177, null), 0);
        C1720g.m3535RO().eJo.mo14539a(339, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(30, (C1202f) this);
        C1720g.m3536RP().mo5239Ry().set(135184, Boolean.FALSE);
        initView();
        AppMethodBeat.m2505o(104209);
    }

    public void onResume() {
        AppMethodBeat.m2504i(104210);
        super.onResume();
        m53126Ke();
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(104210);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104212);
        super.onDestroy();
        C1720g.m3535RO().eJo.mo14546b(339, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(30, (C1202f) this);
        AppMethodBeat.m2505o(104212);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(104214);
        C4990ab.m7417i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", Integer.valueOf(i));
        if (i2 != -1 || intent == null) {
            AppMethodBeat.m2505o(104214);
            return;
        }
        switch (i) {
            case 1:
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                C4990ab.m7411d("MicroMsg.RoomRightUI", "pick user %s", stringExtra);
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    this.ekC = stringExtra;
                    final String str = this.ekC;
                    C30379h.m48440a(this.mController.ylL, getString(C25738R.string.dsi, new Object[]{((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str).mo16707Oj(), Integer.valueOf(this.ekD)}), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(104206);
                            final C1207m c6405l = new C6405l(str);
                            RoomRightUI roomRightUI = RoomRightUI.this;
                            Context context = RoomRightUI.this;
                            RoomRightUI.this.getString(C25738R.string.f9238tz);
                            roomRightUI.ehJ = C30379h.m48458b(context, "", true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(104205);
                                    C1720g.m3535RO().eJo.mo14547c(c6405l);
                                    AppMethodBeat.m2505o(104205);
                                }
                            });
                            C1720g.m3535RO().eJo.mo14541a(c6405l, 0);
                            AppMethodBeat.m2505o(104206);
                        }
                    }, null);
                    break;
                }
                AppMethodBeat.m2505o(104214);
                return;
        }
        AppMethodBeat.m2505o(104214);
    }

    /* renamed from: a */
    private void m53129a(final LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(104215);
        Assert.assertTrue(linkedList.size() > 0);
        String string = C4996ah.getContext().getString(C25738R.string.ajw);
        linkedList.size();
        Object[] objArr = new Object[1];
        List linkedList2 = new LinkedList();
        if (C1720g.m3531RK()) {
            for (String mJ : linkedList) {
                linkedList2.add(C1854s.m3866mJ(mJ));
            }
        }
        objArr[0] = C5046bo.m7536c(linkedList2, string);
        C30379h.m48438a((Context) this, getString(C25738R.string.dub, objArr), getString(C25738R.string.f9238tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(104207);
                RoomRightUI.m53128a(RoomRightUI.this, linkedList);
                AppMethodBeat.m2505o(104207);
            }
        });
        AppMethodBeat.m2505o(104215);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(104216);
        C4990ab.m7416i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        if (c1207m.getType() != 339) {
            AppMethodBeat.m2505o(104216);
            return;
        }
        String str2;
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ekC);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            str2 = this.ekC;
        } else {
            str2 = aoO.mo16707Oj();
        }
        if (i == 0 && i2 == 0) {
            C30379h.m48461b((Context) this, getString(C25738R.string.dsl, new Object[]{str2}), getString(C25738R.string.f9238tz), true);
            if (this.ehK != null) {
                m53126Ke();
                this.ehK.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(104216);
        } else if (i2 == -251) {
            C30379h.m48461b((Context) this, getString(C25738R.string.dsj, new Object[]{str2, Integer.valueOf(this.ekD)}), getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(104216);
        } else if (i2 == -44) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.ekC);
            m53129a(linkedList);
            AppMethodBeat.m2505o(104216);
        } else if (i2 == -22) {
            C30379h.m48461b((Context) this, getString(C25738R.string.dsk, new Object[]{str2}), getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(104216);
        } else {
            Toast.makeText(this, "err :" + i + " ," + i2, 0).show();
            AppMethodBeat.m2505o(104216);
        }
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(104211);
        if (preference.mKey.equals("room_grant_to_friend")) {
            Intent intent = new Intent();
            intent.setClassName(C4996ah.getPackageName(), C4996ah.getPackageName() + ".ui.contact.SelectContactUI");
            intent.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
            intent.putExtra("List_Type", 4);
            intent.putExtra("select_contact_pick_result", true);
            List linkedList = new LinkedList();
            linkedList.add("officialaccounts");
            intent.putExtra("Block_list", C5046bo.m7536c(linkedList, ","));
            intent.putExtra("Add_SendCard", true);
            intent.putExtra("is_multi_select", false);
            startActivityForResult(intent, 1);
        }
        AppMethodBeat.m2505o(104211);
        return false;
    }

    public final void initView() {
        AppMethodBeat.m2504i(104213);
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.ea3);
        setBackBtn(new C260201());
        AppMethodBeat.m2505o(104213);
    }
}
