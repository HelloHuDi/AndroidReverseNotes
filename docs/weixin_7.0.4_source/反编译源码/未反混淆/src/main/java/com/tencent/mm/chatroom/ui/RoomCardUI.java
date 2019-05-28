package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.view.d;

public class RoomCardUI extends MMActivity implements f {
    private String ejD;
    private String ejR;
    private int ejS;
    private String ejT;
    private boolean ejU;
    private boolean ejV;
    private String ejW;
    private String ejX;
    private long ejY;
    private p ejZ;
    private TextView eka;
    private MMEditText ekb;
    private TextView ekc;
    private TextView ekd;
    private ImageView eke;
    private LinearLayout ekf;
    private LinearLayout ekg;
    private LinearLayout ekh;
    private LinearLayout eki;
    private b ekj;
    private c ekk = new c<mc>() {
        {
            AppMethodBeat.i(104147);
            this.xxI = mc.class.getName().hashCode();
            AppMethodBeat.o(104147);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(104148);
            mc mcVar = (mc) bVar;
            String str = mcVar.cHU.cHV;
            String str2 = mcVar.cHU.cHW;
            int i = mcVar.cHU.ret;
            if (i != 0 && str2 != null) {
                h.b(RoomCardUI.this, str2, str, true);
                if (RoomCardUI.this.ekj != null) {
                    ((j) g.K(j.class)).XL().d(RoomCardUI.this.ekj);
                }
            } else if (i == 0) {
                if (RoomCardUI.this.ekl) {
                    RoomCardUI.a(RoomCardUI.this, RoomCardUI.this.ekb.getText().toString());
                } else {
                    RoomCardUI.i(RoomCardUI.this);
                }
            }
            if (!(RoomCardUI.this.ekl || RoomCardUI.this.ejZ == null || !RoomCardUI.this.ejZ.isShowing())) {
                RoomCardUI.this.ejZ.dismiss();
            }
            AppMethodBeat.o(104148);
            return false;
        }
    };
    private boolean ekl = false;

    class a implements TextWatcher {
        private int eko;
        private String ekp;
        private boolean ekq;

        private a() {
            this.eko = d.MIC_PTU_TRANS_XINXIAN;
            this.ekp = "";
            this.ekq = false;
        }

        /* synthetic */ a(RoomCardUI roomCardUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(104157);
            RoomCardUI.d(RoomCardUI.this);
            AppMethodBeat.o(104157);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RoomCardUI() {
        AppMethodBeat.i(104158);
        AppMethodBeat.o(104158);
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, int i, int i2, String str) {
        AppMethodBeat.i(104177);
        roomCardUI.d(i, i2, str);
        AppMethodBeat.o(104177);
    }

    static /* synthetic */ void c(RoomCardUI roomCardUI) {
        AppMethodBeat.i(104173);
        roomCardUI.goBack();
        AppMethodBeat.o(104173);
    }

    static /* synthetic */ void d(RoomCardUI roomCardUI) {
        AppMethodBeat.i(104174);
        roomCardUI.JZ();
        AppMethodBeat.o(104174);
    }

    static /* synthetic */ boolean e(RoomCardUI roomCardUI) {
        AppMethodBeat.i(104175);
        boolean JY = roomCardUI.JY();
        AppMethodBeat.o(104175);
        return JY;
    }

    static /* synthetic */ void i(RoomCardUI roomCardUI) {
        AppMethodBeat.i(104178);
        roomCardUI.Ka();
        AppMethodBeat.o(104178);
    }

    public final int getLayoutId() {
        return R.layout.aox;
    }

    public final void initView() {
        AppMethodBeat.i(104159);
        setMMTitle((int) R.string.dtp);
        a(0, getString(R.string.pg), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104145);
                if (menuItem.getTitle().equals(RoomCardUI.this.getString(R.string.qt))) {
                    RoomCardUI.a(RoomCardUI.this);
                }
                RoomCardUI.this.ekb.setEnabled(true);
                RoomCardUI.this.ekb.setFocusableInTouchMode(true);
                RoomCardUI.this.ekb.setFocusable(true);
                RoomCardUI.this.ekb.setCursorVisible(true);
                RoomCardUI.this.updateOptionMenuText(0, RoomCardUI.this.getString(R.string.qt));
                RoomCardUI.this.enableOptionMenu(false);
                RoomCardUI.this.showVKB();
                RoomCardUI.this.ekb.setSelection(RoomCardUI.this.ekb.getText().toString().length());
                AppMethodBeat.o(104145);
                return true;
            }
        }, q.b.GREEN);
        enableOptionMenu(true);
        this.ekh = (LinearLayout) findViewById(R.id.e3h);
        this.eki = (LinearLayout) findViewById(R.id.e3n);
        this.ekb = (MMEditText) findViewById(R.id.e3l);
        this.ekc = (TextView) findViewById(R.id.e3k);
        this.ekd = (TextView) findViewById(R.id.e3j);
        this.ekf = (LinearLayout) findViewById(R.id.e3o);
        this.eke = (ImageView) findViewById(R.id.e3i);
        this.ekg = (LinearLayout) findViewById(R.id.e3q);
        this.ekb.setText(this.ejW);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.ekb.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) - 100);
        com.tencent.mm.pluginsdk.ui.e.j.b(this.ekb, Integer.valueOf(31));
        this.eka = (TextView) findViewById(R.id.e3m);
        this.eka.setText(Integer.toString(com.tencent.mm.ui.tools.f.bP(d.MIC_PTU_TRANS_XINXIAN, this.ejW)));
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
            this.ekb.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(104150);
                    RoomCardUI.a(RoomCardUI.this, RoomCardUI.this.ekb);
                    AppMethodBeat.o(104150);
                    return true;
                }
            });
        }
        if (this.ejY != 0) {
            this.ekc.setVisibility(0);
            this.ekc.setText(com.tencent.mm.pluginsdk.f.h.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, this.ejY));
        } else {
            this.ekc.setVisibility(8);
        }
        if (bo.isNullOrNil(this.ejW)) {
            this.ekb.setEnabled(true);
            this.ekb.setFocusableInTouchMode(true);
            this.ekb.setFocusable(true);
            this.ekh.setVisibility(8);
            this.ekb.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) + 100);
            this.ekb.requestFocus();
            this.ekb.setCursorVisible(true);
            updateOptionMenuText(0, this.mController.ylL.getString(R.string.qt));
            JZ();
            this.ekb.performClick();
            showVKB();
        } else {
            this.ekh.setVisibility(0);
        }
        this.ekd.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, s.mJ(this.ejX), this.ekd.getTextSize()));
        ImageView imageView = this.eke;
        String str = this.ejX;
        if (bo.isNullOrNil(str)) {
            imageView.setImageResource(R.drawable.ad2);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str);
        }
        this.ekb.addTextChangedListener(new a(this, (byte) 0));
        AppMethodBeat.o(104159);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104160);
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.h.pYm.a(219, 0, 1, true);
        g.RO().eJo.a((int) TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, (f) this);
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
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104153);
                RoomCardUI.c(RoomCardUI.this);
                AppMethodBeat.o(104153);
                return true;
            }
        });
        AppMethodBeat.o(104160);
    }

    public void onDestroy() {
        AppMethodBeat.i(104161);
        super.onDestroy();
        g.RO().eJo.b((int) TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, (f) this);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        AppMethodBeat.o(104161);
    }

    private void goBack() {
        AppMethodBeat.i(104162);
        if (!this.ejU && !this.ejV) {
            setResult(0);
            finish();
            AppMethodBeat.o(104162);
        } else if (JY()) {
            h.d(this, getString(R.string.dri), null, getString(R.string.drk), getString(R.string.drj), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(104154);
                    RoomCardUI.this.setResult(0);
                    RoomCardUI.this.finish();
                    AppMethodBeat.o(104154);
                }
            });
            AppMethodBeat.o(104162);
        } else {
            setResult(0);
            finish();
            AppMethodBeat.o(104162);
        }
    }

    private boolean JY() {
        AppMethodBeat.i(104163);
        String obj = this.ekb.getText().toString();
        if (bo.isNullOrNil(obj)) {
            if (bo.isNullOrNil(this.ejW)) {
                AppMethodBeat.o(104163);
                return false;
            }
            AppMethodBeat.o(104163);
            return true;
        } else if (this.ejW == null || !this.ejW.equals(obj)) {
            AppMethodBeat.o(104163);
            return true;
        } else {
            AppMethodBeat.o(104163);
            return false;
        }
    }

    private void JZ() {
        AppMethodBeat.i(104164);
        if (JY()) {
            enableOptionMenu(true);
            AppMethodBeat.o(104164);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(104164);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(104165);
        super.onKeyDown(i, keyEvent);
        if (keyEvent.getKeyCode() == 4) {
            goBack();
            AppMethodBeat.o(104165);
            return true;
        }
        AppMethodBeat.o(104165);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(104166);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(104166);
        } else {
            AppMethodBeat.o(104166);
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(104167);
        if (mVar.getType() == TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE) {
            d(i, i2, str);
            AppMethodBeat.o(104167);
            return;
        }
        ab.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", Integer.valueOf(mVar.getType()));
        AppMethodBeat.o(104167);
    }

    private void d(int i, int i2, String str) {
        AppMethodBeat.i(104168);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
            this.ejW = this.ekb.getText().toString();
            com.tencent.mm.plugin.report.service.h.pYm.a(219, 15, 1, true);
            Ka();
            AppMethodBeat.o(104168);
            return;
        }
        kj(str);
        ab.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.o(104168);
    }

    private void Ka() {
        AppMethodBeat.i(104169);
        Intent intent = new Intent();
        intent.putExtra("room_name", this.ejR);
        intent.putExtra("room_notice", this.ejW);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(104169);
    }

    private void kj(String str) {
        AppMethodBeat.i(104170);
        ab.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", str);
        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
        if (jY != null) {
            jY.a(this, new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(104149);
                    RoomCardUI.this.finish();
                    AppMethodBeat.o(104149);
                }
            });
        }
        AppMethodBeat.o(104170);
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI) {
        AppMethodBeat.i(104171);
        if (roomCardUI.JY()) {
            String str = roomCardUI.ekb.getText().toString();
            String Ne = com.tencent.mm.m.b.Ne();
            if (bo.isNullOrNil(Ne) || !str.matches(".*[" + Ne + "].*")) {
                int i;
                int i2;
                roomCardUI.showVKB();
                if (bo.isNullOrNil(roomCardUI.ekb.getText().toString())) {
                    i = R.string.etv;
                    i2 = R.string.etu;
                } else {
                    i = R.string.d8e;
                    i2 = R.string.d8g;
                }
                h.a((Context) roomCardUI, i, 0, i2, (int) R.string.d8f, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(104155);
                        RoomCardUI roomCardUI = RoomCardUI.this;
                        Context context = RoomCardUI.this.mController.ylL;
                        RoomCardUI.this.getString(R.string.tz);
                        roomCardUI.ejZ = h.b(context, RoomCardUI.this.getString(R.string.dul), false, null);
                        if (RoomCardUI.e(RoomCardUI.this)) {
                            RoomCardUI.this.ekl = false;
                            RoomCardUI.a(RoomCardUI.this, RoomCardUI.this.ekb.getText().toString());
                        }
                        AppMethodBeat.o(104155);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(104156);
                        RoomCardUI.d(RoomCardUI.this);
                        AppMethodBeat.o(104156);
                    }
                });
                AppMethodBeat.o(104171);
                return;
            }
            h.b(roomCardUI.mController.ylL, roomCardUI.getString(R.string.ce4, new Object[]{Ne}), roomCardUI.getString(R.string.tz), true);
            AppMethodBeat.o(104171);
            return;
        }
        roomCardUI.Ka();
        AppMethodBeat.o(104171);
    }
}
