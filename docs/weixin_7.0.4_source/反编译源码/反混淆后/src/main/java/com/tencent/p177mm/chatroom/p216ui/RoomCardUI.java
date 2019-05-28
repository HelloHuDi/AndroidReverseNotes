package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42023mc;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI */
public class RoomCardUI extends MMActivity implements C1202f {
    private String ejD;
    private String ejR;
    private int ejS;
    private String ejT;
    private boolean ejU;
    private boolean ejV;
    private String ejW;
    private String ejX;
    private long ejY;
    private C44275p ejZ;
    private TextView eka;
    private MMEditText ekb;
    private TextView ekc;
    private TextView ekd;
    private ImageView eke;
    private LinearLayout ekf;
    private LinearLayout ekg;
    private LinearLayout ekh;
    private LinearLayout eki;
    private C3463b ekj;
    private C4884c ekk = new C92183();
    private boolean ekl = false;

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$2 */
    class C92172 implements C46609a {
        C92172() {
        }

        /* renamed from: a */
        public final void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(104146);
            RoomCardUI.m28587a(RoomCardUI.this, i, i2, str);
            AppMethodBeat.m2505o(104146);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$3 */
    class C92183 extends C4884c<C42023mc> {
        C92183() {
            AppMethodBeat.m2504i(104147);
            this.xxI = C42023mc.class.getName().hashCode();
            AppMethodBeat.m2505o(104147);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(104148);
            C42023mc c42023mc = (C42023mc) c4883b;
            String str = c42023mc.cHU.cHV;
            String str2 = c42023mc.cHU.cHW;
            int i = c42023mc.cHU.ret;
            if (i != 0 && str2 != null) {
                C30379h.m48461b(RoomCardUI.this, str2, str, true);
                if (RoomCardUI.this.ekj != null) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7921d(RoomCardUI.this.ekj);
                }
            } else if (i == 0) {
                if (RoomCardUI.this.ekl) {
                    RoomCardUI.m28589a(RoomCardUI.this, RoomCardUI.this.ekb.getText().toString());
                } else {
                    RoomCardUI.m28598i(RoomCardUI.this);
                }
            }
            if (!(RoomCardUI.this.ekl || RoomCardUI.this.ejZ == null || !RoomCardUI.this.ejZ.isShowing())) {
                RoomCardUI.this.ejZ.dismiss();
            }
            AppMethodBeat.m2505o(104148);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$12 */
    class C1814012 implements OnClickListener {
        C1814012() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(104156);
            RoomCardUI.m28593d(RoomCardUI.this);
            AppMethodBeat.m2505o(104156);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$9 */
    class C181419 implements OnClickListener {
        C181419() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$1 */
    class C181421 implements OnMenuItemClickListener {
        C181421() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104145);
            if (menuItem.getTitle().equals(RoomCardUI.this.getString(C25738R.string.f9142qt))) {
                RoomCardUI.m28586a(RoomCardUI.this);
            }
            RoomCardUI.this.ekb.setEnabled(true);
            RoomCardUI.this.ekb.setFocusableInTouchMode(true);
            RoomCardUI.this.ekb.setFocusable(true);
            RoomCardUI.this.ekb.setCursorVisible(true);
            RoomCardUI.this.updateOptionMenuText(0, RoomCardUI.this.getString(C25738R.string.f9142qt));
            RoomCardUI.this.enableOptionMenu(false);
            RoomCardUI.this.showVKB();
            RoomCardUI.this.ekb.setSelection(RoomCardUI.this.ekb.getText().toString().length());
            AppMethodBeat.m2505o(104145);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$8 */
    class C181438 implements OnMenuItemClickListener {
        C181438() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104153);
            RoomCardUI.m28591c(RoomCardUI.this);
            AppMethodBeat.m2505o(104153);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$5 */
    class C181445 implements OnLongClickListener {
        C181445() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(104150);
            RoomCardUI.m28588a(RoomCardUI.this, RoomCardUI.this.ekb);
            AppMethodBeat.m2505o(104150);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$11 */
    class C1814611 implements OnClickListener {
        C1814611() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(104155);
            RoomCardUI roomCardUI = RoomCardUI.this;
            Context context = RoomCardUI.this.mController.ylL;
            RoomCardUI.this.getString(C25738R.string.f9238tz);
            roomCardUI.ejZ = C30379h.m48458b(context, RoomCardUI.this.getString(C25738R.string.dul), false, null);
            if (RoomCardUI.m28594e(RoomCardUI.this)) {
                RoomCardUI.this.ekl = false;
                RoomCardUI.m28589a(RoomCardUI.this, RoomCardUI.this.ekb.getText().toString());
            }
            AppMethodBeat.m2505o(104155);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$a */
    class C18147a implements TextWatcher {
        private int eko;
        private String ekp;
        private boolean ekq;

        private C18147a() {
            this.eko = C31128d.MIC_PTU_TRANS_XINXIAN;
            this.ekp = "";
            this.ekq = false;
        }

        /* synthetic */ C18147a(RoomCardUI roomCardUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(104157);
            RoomCardUI.m28593d(RoomCardUI.this);
            AppMethodBeat.m2505o(104157);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$10 */
    class C1814810 implements OnClickListener {
        C1814810() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(104154);
            RoomCardUI.this.setResult(0);
            RoomCardUI.this.finish();
            AppMethodBeat.m2505o(104154);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$4 */
    class C181494 implements OnDismissListener {
        C181494() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(104149);
            RoomCardUI.this.finish();
            AppMethodBeat.m2505o(104149);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomCardUI$6 */
    class C181506 implements C36073c {
        C181506() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(104151);
            c44273l.add((int) C25738R.string.f9082oy);
            AppMethodBeat.m2505o(104151);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RoomCardUI() {
        AppMethodBeat.m2504i(104158);
        AppMethodBeat.m2505o(104158);
    }

    /* renamed from: a */
    static /* synthetic */ void m28587a(RoomCardUI roomCardUI, int i, int i2, String str) {
        AppMethodBeat.m2504i(104177);
        roomCardUI.m28592d(i, i2, str);
        AppMethodBeat.m2505o(104177);
    }

    /* renamed from: c */
    static /* synthetic */ void m28591c(RoomCardUI roomCardUI) {
        AppMethodBeat.m2504i(104173);
        roomCardUI.goBack();
        AppMethodBeat.m2505o(104173);
    }

    /* renamed from: d */
    static /* synthetic */ void m28593d(RoomCardUI roomCardUI) {
        AppMethodBeat.m2504i(104174);
        roomCardUI.m28583JZ();
        AppMethodBeat.m2505o(104174);
    }

    /* renamed from: e */
    static /* synthetic */ boolean m28594e(RoomCardUI roomCardUI) {
        AppMethodBeat.m2504i(104175);
        boolean JY = roomCardUI.m28582JY();
        AppMethodBeat.m2505o(104175);
        return JY;
    }

    /* renamed from: i */
    static /* synthetic */ void m28598i(RoomCardUI roomCardUI) {
        AppMethodBeat.m2504i(104178);
        roomCardUI.m28584Ka();
        AppMethodBeat.m2505o(104178);
    }

    public final int getLayoutId() {
        return 2130970528;
    }

    public final void initView() {
        AppMethodBeat.m2504i(104159);
        setMMTitle((int) C25738R.string.dtp);
        mo17379a(0, getString(C25738R.string.f9099pg), (OnMenuItemClickListener) new C181421(), C5535b.GREEN);
        enableOptionMenu(true);
        this.ekh = (LinearLayout) findViewById(2131827147);
        this.eki = (LinearLayout) findViewById(2131827153);
        this.ekb = (MMEditText) findViewById(2131827151);
        this.ekc = (TextView) findViewById(2131827150);
        this.ekd = (TextView) findViewById(2131827149);
        this.ekf = (LinearLayout) findViewById(2131827154);
        this.eke = (ImageView) findViewById(2131827148);
        this.ekg = (LinearLayout) findViewById(2131827156);
        this.ekb.setText(this.ejW);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.ekb.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) - 100);
        C44089j.m79296b(this.ekb, Integer.valueOf(31));
        this.eka = (TextView) findViewById(2131827152);
        this.eka.setText(Integer.toString(C5584f.m8385bP(C31128d.MIC_PTU_TRANS_XINXIAN, this.ejW)));
        this.ekg.setVisibility(8);
        this.ekb.setCursorVisible(false);
        this.ekb.setFocusable(false);
        if (this.ejU || this.ejV) {
            this.eki.setVisibility(8);
        } else {
            removeOptionMenu(0);
            this.eki.setVisibility(0);
            this.ekb.setFocusable(false);
            this.ekb.setCursorVisible(false);
            this.ekb.setOnLongClickListener(new C181445());
        }
        if (this.ejY != 0) {
            this.ekc.setVisibility(0);
            this.ekc.setText(C14835h.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, this.ejY));
        } else {
            this.ekc.setVisibility(8);
        }
        if (C5046bo.isNullOrNil(this.ejW)) {
            this.ekb.setEnabled(true);
            this.ekb.setFocusableInTouchMode(true);
            this.ekb.setFocusable(true);
            this.ekh.setVisibility(8);
            this.ekb.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) + 100);
            this.ekb.requestFocus();
            this.ekb.setCursorVisible(true);
            updateOptionMenuText(0, this.mController.ylL.getString(C25738R.string.f9142qt));
            m28583JZ();
            this.ekb.performClick();
            showVKB();
        } else {
            this.ekh.setVisibility(0);
        }
        this.ekd.setText(C44089j.m79293b((Context) this, C1854s.m3866mJ(this.ejX), this.ekd.getTextSize()));
        ImageView imageView = this.eke;
        String str = this.ejX;
        if (C5046bo.isNullOrNil(str)) {
            imageView.setImageResource(C25738R.drawable.ad2);
        } else {
            C40460b.m69434b(imageView, str);
        }
        this.ekb.addTextChangedListener(new C18147a(this, (byte) 0));
        AppMethodBeat.m2505o(104159);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104160);
        super.onCreate(bundle);
        C7060h.pYm.mo8378a(219, 0, 1, true);
        C1720g.m3535RO().eJo.mo14539a((int) TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, (C1202f) this);
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        this.ejW = getIntent().getStringExtra("room_notice");
        this.ejX = getIntent().getStringExtra("room_notice_editor");
        this.ejY = getIntent().getLongExtra("room_notice_publish_time", 0);
        this.ejR = getIntent().getStringExtra("room_name");
        this.ejS = getIntent().getIntExtra("room_member_count", 0);
        this.ejT = getIntent().getStringExtra("room_owner_name");
        this.ejU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.ejV = getIntent().getBooleanExtra("Is_RoomManager", false);
        initView();
        setBackBtn(new C181438());
        AppMethodBeat.m2505o(104160);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104161);
        super.onDestroy();
        C1720g.m3535RO().eJo.mo14546b((int) TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, (C1202f) this);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        AppMethodBeat.m2505o(104161);
    }

    private void goBack() {
        AppMethodBeat.m2504i(104162);
        if (!this.ejU && !this.ejV) {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(104162);
        } else if (m28582JY()) {
            C30379h.m48466d(this, getString(C25738R.string.dri), null, getString(C25738R.string.drk), getString(C25738R.string.drj), new C181419(), new C1814810());
            AppMethodBeat.m2505o(104162);
        } else {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(104162);
        }
    }

    /* renamed from: JY */
    private boolean m28582JY() {
        AppMethodBeat.m2504i(104163);
        String obj = this.ekb.getText().toString();
        if (C5046bo.isNullOrNil(obj)) {
            if (C5046bo.isNullOrNil(this.ejW)) {
                AppMethodBeat.m2505o(104163);
                return false;
            }
            AppMethodBeat.m2505o(104163);
            return true;
        } else if (this.ejW == null || !this.ejW.equals(obj)) {
            AppMethodBeat.m2505o(104163);
            return true;
        } else {
            AppMethodBeat.m2505o(104163);
            return false;
        }
    }

    /* renamed from: JZ */
    private void m28583JZ() {
        AppMethodBeat.m2504i(104164);
        if (m28582JY()) {
            enableOptionMenu(true);
            AppMethodBeat.m2505o(104164);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.m2505o(104164);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(104165);
        super.onKeyDown(i, keyEvent);
        if (keyEvent.getKeyCode() == 4) {
            goBack();
            AppMethodBeat.m2505o(104165);
            return true;
        }
        AppMethodBeat.m2505o(104165);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(104166);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(104166);
        } else {
            AppMethodBeat.m2505o(104166);
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(104167);
        if (c1207m.getType() == TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE) {
            m28592d(i, i2, str);
            AppMethodBeat.m2505o(104167);
            return;
        }
        C4990ab.m7421w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", Integer.valueOf(c1207m.getType()));
        AppMethodBeat.m2505o(104167);
    }

    /* renamed from: d */
    private void m28592d(int i, int i2, String str) {
        AppMethodBeat.m2504i(104168);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        if (i == 0 && i2 == 0) {
            C4990ab.m7416i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
            this.ejW = this.ekb.getText().toString();
            C7060h.pYm.mo8378a(219, 15, 1, true);
            m28584Ka();
            AppMethodBeat.m2505o(104168);
            return;
        }
        m28600kj(str);
        C4990ab.m7417i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.m2505o(104168);
    }

    /* renamed from: Ka */
    private void m28584Ka() {
        AppMethodBeat.m2504i(104169);
        Intent intent = new Intent();
        intent.putExtra("room_name", this.ejR);
        intent.putExtra("room_notice", this.ejW);
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(104169);
    }

    /* renamed from: kj */
    private void m28600kj(String str) {
        AppMethodBeat.m2504i(104170);
        C4990ab.m7421w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", str);
        C42124a jY = C42124a.m74268jY(str);
        if (jY != null) {
            jY.mo67669a(this, new C181494());
        }
        AppMethodBeat.m2505o(104170);
    }

    /* renamed from: a */
    static /* synthetic */ void m28586a(RoomCardUI roomCardUI) {
        AppMethodBeat.m2504i(104171);
        if (roomCardUI.m28582JY()) {
            String str = roomCardUI.ekb.getText().toString();
            String Ne = C42164b.m74343Ne();
            if (C5046bo.isNullOrNil(Ne) || !str.matches(".*[" + Ne + "].*")) {
                int i;
                int i2;
                roomCardUI.showVKB();
                if (C5046bo.isNullOrNil(roomCardUI.ekb.getText().toString())) {
                    i = C25738R.string.etv;
                    i2 = C25738R.string.etu;
                } else {
                    i = C25738R.string.d8e;
                    i2 = C25738R.string.d8g;
                }
                C30379h.m48428a((Context) roomCardUI, i, 0, i2, (int) C25738R.string.d8f, new C1814611(), new C1814012());
                AppMethodBeat.m2505o(104171);
                return;
            }
            C30379h.m48461b(roomCardUI.mController.ylL, roomCardUI.getString(C25738R.string.ce4, new Object[]{Ne}), roomCardUI.getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(104171);
            return;
        }
        roomCardUI.m28584Ka();
        AppMethodBeat.m2505o(104171);
    }
}
