package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.chatroom.e.b;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e;

@Deprecated
public class RoomInfoDetailUI extends MMPreference implements a {
    private boolean cEH;
    private f ehK;
    private ad ehM;
    private CheckBoxPreference ehT;
    private String ehq;
    private boolean eig = false;
    private String eis;
    private int ekw;
    private SignaturePreference ekx;
    private CheckBoxPreference eky;
    private CheckBoxPreference ekz;
    private boolean isDeleteCancel = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104192);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(104192);
    }

    public void onResume() {
        AppMethodBeat.i(104193);
        super.onResume();
        JL();
        Kd();
        if (!(this.ehM == null || this.eky == null)) {
            u ob = ((c) g.K(c.class)).XV().ob(this.ehq);
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (ob.drX()) {
                this.eky.uOT = true;
                sharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
            } else {
                this.eky.uOT = false;
                sharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(104193);
    }

    public final void initView() {
        AppMethodBeat.i(104194);
        setMMTitle((int) R.string.dvh);
        this.ehK = this.yCw;
        this.eis = getPackageName() + "_preferences";
        this.cEH = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ehq = getIntent().getStringExtra("RoomInfo_Id");
        if (this.ehq == null) {
            this.ehq = getIntent().getStringExtra("Single_Chat_Talker");
        }
        this.ehM = ((j) g.K(j.class)).XM().aoO(this.ehq);
        if (this.cEH) {
            this.ekw = this.ehM.dua;
            Kb();
        } else {
            this.ekw = 1;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104185);
                RoomInfoDetailUI.this.finish();
                AppMethodBeat.o(104185);
                return true;
            }
        });
        AppMethodBeat.o(104194);
    }

    private void Kb() {
        AppMethodBeat.i(104195);
        this.ekx = (SignaturePreference) this.ehK.aqO("room_name");
        this.ehT = (CheckBoxPreference) this.ehK.aqO("room_msg_notify");
        this.ekz = (CheckBoxPreference) this.ehK.aqO("room_show_msg_count");
        this.eky = (CheckBoxPreference) this.ehK.aqO("room_msg_show_username");
        this.ekz.yDf = false;
        AppMethodBeat.o(104195);
    }

    public final void a(String str, m mVar) {
    }

    public final int JC() {
        return R.xml.be;
    }

    public void onPause() {
        AppMethodBeat.i(104197);
        super.onPause();
        if (this.eig) {
            u oa = ((c) g.K(c.class)).XV().oa(this.ehq);
            ((c) g.K(c.class)).XV().c(oa, new String[0]);
            String Yz = r.Yz();
            boolean drX = oa.drX();
            bbs bbs = new bbs();
            bbs.vEf = this.ehq;
            bbs.jBB = Yz;
            bbs.wGd = 1;
            bbs.pXD = drX ? 1 : 0;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(49, bbs));
        }
        AppMethodBeat.o(104197);
    }

    private boolean Kc() {
        AppMethodBeat.i(104198);
        if ((((c) g.K(c.class)).XV().oa(this.ehq).field_chatroomdataflag & 2) == 0) {
            AppMethodBeat.o(104198);
            return true;
        }
        AppMethodBeat.o(104198);
        return false;
    }

    private String JD() {
        AppMethodBeat.i(104199);
        u oa = ((c) g.K(c.class)).XV().oa(this.ehq);
        String str;
        if (oa == null) {
            str = "";
            AppMethodBeat.o(104199);
            return str;
        }
        str = oa.field_selfDisplayName;
        AppMethodBeat.o(104199);
        return str;
    }

    private void Kd() {
        AppMethodBeat.i(104200);
        if (!(this.ehM == null || this.ekx == null)) {
            CharSequence JD = JD();
            if (bo.isNullOrNil(JD)) {
                JD = r.YB();
            }
            if (bo.isNullOrNil(JD)) {
                this.ekx.setSummary((CharSequence) "");
            } else {
                SignaturePreference signaturePreference = this.ekx;
                if (JD.length() <= 0) {
                    JD = getString(R.string.eal);
                }
                signaturePreference.setSummary((CharSequence) com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, JD));
                AppMethodBeat.o(104200);
                return;
            }
        }
        AppMethodBeat.o(104200);
    }

    private void JL() {
        boolean z = true;
        AppMethodBeat.i(104201);
        if (this.cEH) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (this.ekw == 0) {
                setTitleMuteIconVisibility(0);
                if (this.ehT != null) {
                    this.ehT.uOT = true;
                    sharedPreferences.edit().putBoolean("room_msg_notify", true).commit();
                }
                if (this.ekz != null) {
                    this.ekz.uOT = Kc();
                }
            } else if (this.ekw == 1) {
                setTitleMuteIconVisibility(8);
                if (this.ehT != null) {
                    this.ehT.uOT = false;
                    sharedPreferences.edit().putBoolean("room_msg_notify", false).commit();
                }
            }
            f fVar = this.ehK;
            String str = "room_show_msg_count";
            if (this.ekw != 1) {
                z = false;
            }
            fVar.ce(str, z);
            AppMethodBeat.o(104201);
            return;
        }
        AppMethodBeat.o(104201);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(104202);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(104202);
            return;
        }
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1);
                    finish();
                    AppMethodBeat.o(104202);
                    return;
                }
                break;
            case 2:
                if (intent != null) {
                    String bc = bo.bc(intent.getStringExtra("Contact_Nick"), "");
                    if (!bo.isNullOrNil(bc)) {
                        u uVar;
                        String Yz = r.Yz();
                        u oa = ((c) g.K(c.class)).XV().oa(this.ehq);
                        if (oa == null) {
                            uVar = new u();
                        } else {
                            uVar = oa;
                        }
                        uVar.field_chatroomname = this.ehq;
                        uVar.field_selfDisplayName = bc;
                        ((c) g.K(c.class)).XV().c(uVar, new String[0]);
                        bbr bbr = new bbr();
                        bbr.vEf = this.ehq;
                        bbr.jBB = Yz;
                        bbr.vXl = bo.nullAsNil(bc);
                        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(48, bbr));
                        Kd();
                        break;
                    }
                }
                AppMethodBeat.o(104202);
                return;
                break;
        }
        AppMethodBeat.o(104202);
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        String string;
        boolean z = true;
        AppMethodBeat.i(104196);
        String str = preference.mKey;
        ab.d("MicroMsg.RoomInfoDetailUI", "click key : %s", str);
        if (str.equals("room_name")) {
            intent = new Intent();
            intent.setClass(this, e.g.class);
            intent.putExtra("Contact_mode_name_type", 4);
            String Yz = r.Yz();
            intent.putExtra("Contact_Nick", JD());
            intent.putExtra("Contact_User", Yz);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
            this.mController.ylL.startActivityForResult(intent, 2);
        }
        if (str.equals("room_msg_show_username")) {
            u oa = ((c) g.K(c.class)).XV().oa(this.ehq);
            oa.pq(!oa.drX());
            this.eig = true;
        }
        if (str.equals("room_msg_notify")) {
            this.ekw = this.ekw == 0 ? 1 : 0;
            ((j) g.K(j.class)).XL().c(new b(this.ehq, this.ekw));
            this.ehM = ((j) g.K(j.class)).XM().aoO(this.ehq);
            this.ehM.hE(this.ekw);
            ((j) g.K(j.class)).XM().b(this.ehq, this.ehM);
            JL();
            this.ehM = ((j) g.K(j.class)).XM().aoO(this.ehq);
            this.ehK.notifyDataSetChanged();
        }
        if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.ehM.field_username);
            d.b((Context) this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 1);
        }
        if (str.equals("room_clear_chatting_history")) {
            if (this.cEH) {
                string = getString(R.string.bx2);
            } else {
                string = getString(R.string.bx1, new Object[]{this.ehM.Oj()});
            }
            h.a((Context) this, string, new String[]{getString(R.string.drt)}, null, new h.c() {
                public final void iE(int i) {
                    AppMethodBeat.i(104189);
                    switch (i) {
                        case 0:
                            String str;
                            RoomInfoDetailUI.this.isDeleteCancel = false;
                            Context context = RoomInfoDetailUI.this;
                            RoomInfoDetailUI.this.getString(R.string.tz);
                            final ProgressDialog b = h.b(context, RoomInfoDetailUI.this.getString(R.string.un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(104186);
                                    RoomInfoDetailUI.this.isDeleteCancel = true;
                                    AppMethodBeat.o(104186);
                                }
                            });
                            if (RoomInfoDetailUI.this.isDeleteCancel) {
                                str = null;
                            } else {
                                str = com.tencent.mm.pluginsdk.wallet.e.akq(RoomInfoDetailUI.this.ehM.field_username);
                            }
                            if (bo.isNullOrNil(str)) {
                                RoomInfoDetailUI.a(RoomInfoDetailUI.this, b);
                                break;
                            }
                            b.dismiss();
                            h.a(RoomInfoDetailUI.this, false, RoomInfoDetailUI.this.getString(R.string.fdk, new Object[]{str}), null, RoomInfoDetailUI.this.getString(R.string.c9y), RoomInfoDetailUI.this.getString(R.string.ar1), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(104187);
                                    RoomInfoDetailUI.this.isDeleteCancel = true;
                                    Intent intent = new Intent();
                                    intent.putExtra("Chat_User", RoomInfoDetailUI.this.ehM.field_username);
                                    intent.addFlags(67108864);
                                    d.f(RoomInfoDetailUI.this, ".ui.chatting.ChattingUI", intent);
                                    AppMethodBeat.o(104187);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(104188);
                                    b.show();
                                    RoomInfoDetailUI.this.isDeleteCancel = false;
                                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, b);
                                    AppMethodBeat.o(104188);
                                }
                            }, -1, R.color.ei);
                            AppMethodBeat.o(104189);
                            return;
                    }
                    AppMethodBeat.o(104189);
                }
            });
        }
        if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (this.ehM != null) {
                if (((j) g.K(j.class)).XR().aph(this.ehM.field_username)) {
                    t.x(this.ehM.field_username, true);
                } else {
                    t.w(this.ehM.field_username, true);
                }
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", ((j) g.K(j.class)).XR().aph(this.ehM.field_username)).commit();
            }
        }
        if ("room_show_msg_count".equals(str)) {
            boolean z2;
            int i;
            boolean Kc = Kc();
            ab.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", Boolean.valueOf(Kc), Boolean.valueOf(Kc));
            if (Kc) {
                z2 = false;
            } else {
                z2 = true;
            }
            u oa2 = ((c) g.K(c.class)).XV().oa(this.ehq);
            if (z2) {
                oa2.ji(0);
            } else {
                oa2.ji(2);
            }
            ab.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", Boolean.valueOf(z2));
            ((c) g.K(c.class)).XV().c(oa2, new String[0]);
            string = r.Yz();
            bbs bbs = new bbs();
            bbs.vEf = this.ehq;
            bbs.jBB = string;
            bbs.wGd = 2;
            if (z2) {
                i = 2;
            } else {
                i = 1;
            }
            bbs.pXD = i;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(49, bbs));
            if (this.ekz != null) {
                CheckBoxPreference checkBoxPreference = this.ekz;
                if (Kc) {
                    z = false;
                }
                checkBoxPreference.uOT = z;
            }
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.o(104196);
        return false;
    }
}
