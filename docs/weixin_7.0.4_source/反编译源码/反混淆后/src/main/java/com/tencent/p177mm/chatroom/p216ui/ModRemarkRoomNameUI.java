package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C23480e;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI */
public class ModRemarkRoomNameUI extends MMActivity implements C5581a {
    private String ehq;
    private C44275p eir = null;
    private String ejG = "";
    private MMEditText ejH;

    /* renamed from: com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI$2 */
    class C324512 implements OnMenuItemClickListener {
        C324512() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104118);
            ModRemarkRoomNameUI.this.setResult(0);
            ModRemarkRoomNameUI.this.finish();
            AppMethodBeat.m2505o(104118);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI$3 */
    class C324523 implements OnMenuItemClickListener {
        C324523() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104119);
            ModRemarkRoomNameUI.this.aqX();
            String str = "";
            String Ne = C42164b.m74343Ne();
            if (C5046bo.isNullOrNil(Ne) || !str.matches(".*[" + Ne + "].*")) {
                C7357c.m12555d(ModRemarkRoomNameUI.this.ejH).mo15880hz(1, 32).mo15879a(ModRemarkRoomNameUI.this);
                AppMethodBeat.m2505o(104119);
                return true;
            }
            C30379h.m48461b(ModRemarkRoomNameUI.this.mController.ylL, ModRemarkRoomNameUI.this.getString(C25738R.string.ce4, new Object[]{Ne}), ModRemarkRoomNameUI.this.getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(104119);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104121);
        super.onCreate(bundle);
        this.ehq = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        AppMethodBeat.m2505o(104121);
    }

    public final void initView() {
        AppMethodBeat.m2504i(104122);
        setMMTitle((int) C25738R.string.drh);
        this.ejH = (MMEditText) findViewById(2131826141);
        final CharSequence nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra("room_name"));
        if (C5046bo.isNullOrNil(nullAsNil)) {
            this.ejH.setHint(C44089j.m79293b((Context) this, ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14883mJ(this.ehq), this.ejH.getTextSize()));
            this.ejH.setEllipsize(TruncateAt.END);
        } else {
            this.ejH.setText(C44089j.m79293b((Context) this, nullAsNil, this.ejH.getTextSize()));
        }
        this.ejH.setSelection(this.ejH.getText().length());
        this.ejH.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.m2504i(104117);
                if (!nullAsNil.equals(charSequence)) {
                    ModRemarkRoomNameUI.this.enableOptionMenu(true);
                }
                if (charSequence.length() > 0) {
                    ModRemarkRoomNameUI.this.ejH.setEllipsize(null);
                    AppMethodBeat.m2505o(104117);
                    return;
                }
                ModRemarkRoomNameUI.this.ejH.setEllipsize(TruncateAt.END);
                AppMethodBeat.m2505o(104117);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        C7357c hz = C7357c.m12555d(this.ejH).mo15880hz(1, 32);
        hz.zIx = false;
        hz.mo15879a(null);
        setBackBtn(new C324512());
        mo17379a(0, getString(C25738R.string.f9218tc), (OnMenuItemClickListener) new C324523(), C5535b.GREEN);
        enableOptionMenu(false);
        AppMethodBeat.m2505o(104122);
    }

    public void onPause() {
        AppMethodBeat.m2504i(104123);
        super.onPause();
        AppMethodBeat.m2505o(104123);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104124);
        super.onDestroy();
        AppMethodBeat.m2505o(104124);
    }

    public final int getLayoutId() {
        return 2130970242;
    }

    /* renamed from: ki */
    public final void mo11317ki(String str) {
        AppMethodBeat.m2504i(104125);
        this.ejG = str;
        final C46610a M = C30262b.alY(this.ehq).mo20630M(this.ehq, this.ejG);
        M.mo74755d(new C23480e() {
            /* renamed from: a */
            public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
                AppMethodBeat.m2504i(104120);
                C23480e c23480e = (C23480e) c46609a;
                if (this.ret != 0) {
                    M.cancel();
                    if (!(C5046bo.isNullOrNil(c23480e.content) && C5046bo.isNullOrNil(c23480e.title))) {
                        C30379h.m48461b(ModRemarkRoomNameUI.this, c23480e.content, c23480e.title, true);
                        AppMethodBeat.m2505o(104120);
                        return;
                    }
                } else if (this.ret == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("room_name", ModRemarkRoomNameUI.this.ejG);
                    ModRemarkRoomNameUI.this.setResult(-1, intent);
                    ModRemarkRoomNameUI.this.finish();
                }
                AppMethodBeat.m2505o(104120);
            }
        });
        AppCompatActivity appCompatActivity = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        M.mo48450a(appCompatActivity, getString(C25738R.string.av5), false, null);
        AppMethodBeat.m2505o(104125);
    }

    /* renamed from: JW */
    public final void mo11315JW() {
        AppMethodBeat.m2504i(104126);
        C30379h.m48467g(this, C25738R.string.e8m, C25738R.string.e8p);
        AppMethodBeat.m2505o(104126);
    }

    /* renamed from: JX */
    public final void mo11316JX() {
        AppMethodBeat.m2504i(104127);
        C30379h.m48467g(this, C25738R.string.e8n, C25738R.string.e8p);
        AppMethodBeat.m2505o(104127);
    }
}
