package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.b.c;

@a(17)
public class SnsCommentUI extends MMActivity implements f {
    private int cNE;
    private int czs;
    private SnsEditText rrH;
    private int rrI = 0;
    private boolean rrJ = false;
    private boolean rrK = false;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38920);
        super.onCreate(bundle);
        this.cNE = getIntent().getIntExtra("sns_comment_localId", 0);
        this.rrI = getIntent().getIntExtra("sns_comment_type", 0);
        this.czs = getIntent().getIntExtra("sns_source", 0);
        g.RQ();
        g.RO().eJo.a(213, (f) this);
        initView();
        AppMethodBeat.o(38920);
    }

    public void onPause() {
        AppMethodBeat.i(38921);
        super.onPause();
        if (this.rrH != null) {
            Object trim = this.rrH.getText().toString().trim();
            g.RQ();
            g.RP().Ry().set(68408, trim);
            if (bo.isNullOrNil(trim)) {
                g.RQ();
                g.RP().Ry().set(7489, Integer.valueOf(0));
            } else {
                g.RQ();
                g.RP().Ry().set(7489, Integer.valueOf(this.rrH.getPasterLen()));
                AppMethodBeat.o(38921);
                return;
            }
        }
        AppMethodBeat.o(38921);
    }

    public void onResume() {
        AppMethodBeat.i(38922);
        super.onResume();
        showVKB();
        AppMethodBeat.o(38922);
    }

    public void onDestroy() {
        AppMethodBeat.i(38923);
        super.onDestroy();
        g.RQ();
        g.RO().eJo.b(213, (f) this);
        AppMethodBeat.o(38923);
    }

    public final void initView() {
        AppMethodBeat.i(38924);
        this.rrH = (SnsEditText) findViewById(R.id.m5);
        a(0, getString(R.string.tf), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i;
                AppMethodBeat.i(38917);
                if (SnsCommentUI.this.rrI == 0) {
                    b.MX();
                }
                if (SnsCommentUI.this.rrI == 2) {
                    i = 200;
                } else {
                    i = b.MW();
                }
                c PM = c.d(SnsCommentUI.this.rrH).PM(i);
                PM.zIx = true;
                PM.a(new c.a() {
                    public final void ki(String str) {
                        AppMethodBeat.i(38915);
                        String trim = SnsCommentUI.this.rrH.getText().toString().trim();
                        SnsCommentUI.this.rrH.setText("");
                        if (trim.length() > 0) {
                            switch (SnsCommentUI.this.rrI) {
                                case 0:
                                    SnsCommentUI.this.aqX();
                                    SnsCommentUI.a(SnsCommentUI.this, trim);
                                    AppMethodBeat.o(38915);
                                    return;
                                case 1:
                                    SnsCommentUI.this.aqX();
                                    SnsCommentUI.b(SnsCommentUI.this, trim);
                                    AppMethodBeat.o(38915);
                                    return;
                                case 2:
                                    SnsCommentUI.this.aqX();
                                    long longExtra = SnsCommentUI.this.getIntent().getLongExtra("sns_id", 0);
                                    long longExtra2 = SnsCommentUI.this.getIntent().getLongExtra("action_st_time", 0);
                                    String bc = bo.bc(SnsCommentUI.this.getIntent().getStringExtra("sns_uxinfo"), "");
                                    trim = bo.bc(SnsCommentUI.this.getIntent().getStringExtra("sns_actionresult"), "") + "|4:1:" + trim;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    h coB = af.cnx().coB();
                                    if (coB != null && coB.coC()) {
                                        String str2 = coB.qPn;
                                        String str3 = coB.qPm;
                                        ab.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + bc + " actionresult: " + trim + " " + longExtra2 + " " + currentTimeMillis);
                                        com.tencent.mm.plugin.report.service.h.pYm.e(11988, str2, str3, "", "", i.jV(longExtra), bc, trim, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000));
                                        SnsCommentUI.this.rrK = true;
                                        SnsCommentUI.this.finish();
                                        break;
                                    }
                                    AppMethodBeat.o(38915);
                                    return;
                                    break;
                            }
                        }
                        AppMethodBeat.o(38915);
                    }

                    public final void JW() {
                    }

                    public final void JX() {
                        AppMethodBeat.i(38916);
                        com.tencent.mm.ui.base.h.g(SnsCommentUI.this, R.string.eqg, R.string.eqh);
                        AppMethodBeat.o(38916);
                    }
                });
                AppMethodBeat.o(38917);
                return false;
            }
        }, q.b.GREEN);
        if (this.rrI == 0) {
            setMMTitle((int) R.string.ek3);
        } else if (this.rrI == 1) {
            setMMTitle((int) R.string.eqp);
            g.RQ();
            String bc = bo.bc((String) g.RP().Ry().get(68408, (Object) ""), "");
            g.RQ();
            this.rrH.setPasterLen(bo.a((Integer) g.RP().Ry().get(7489, Integer.valueOf(0)), 0));
            this.rrH.append(bo.bc(bc, ""));
            if (bc == null || bc.length() <= 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        } else if (this.rrI == 2) {
            setMMTitle((int) R.string.eit);
            enableOptionMenu(false);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38918);
                SnsCommentUI.this.aqX();
                SnsCommentUI.this.finish();
                AppMethodBeat.o(38918);
                return true;
            }
        });
        this.rrH.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(38919);
                if (SnsCommentUI.this.rrH.getText().toString().trim().length() > 0) {
                    SnsCommentUI.this.enableOptionMenu(true);
                    AppMethodBeat.o(38919);
                    return;
                }
                SnsCommentUI.this.enableOptionMenu(false);
                AppMethodBeat.o(38919);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        AppMethodBeat.o(38924);
    }

    public final int getLayoutId() {
        return R.layout.av4;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(38925);
        ab.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + mVar.getType() + " @" + hashCode());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (mVar.getType()) {
            case 213:
                if (this.rrJ) {
                    finish();
                    break;
                }
                break;
        }
        AppMethodBeat.o(38925);
    }

    public void finish() {
        AppMethodBeat.i(38926);
        super.finish();
        if (!this.rrK && this.rrI == 2) {
            long longExtra = getIntent().getLongExtra("sns_id", 0);
            long longExtra2 = getIntent().getLongExtra("action_st_time", 0);
            String bc = bo.bc(getIntent().getStringExtra("sns_uxinfo"), "");
            String str = bo.bc(getIntent().getStringExtra("sns_actionresult"), "") + "|4:0:";
            long currentTimeMillis = System.currentTimeMillis();
            h coB = af.cnx().coB();
            if (coB == null || !coB.coC()) {
                AppMethodBeat.o(38926);
                return;
            }
            String str2 = coB.qPn;
            String str3 = coB.qPm;
            ab.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + bc + " actionresult: " + str + " " + longExtra2 + " " + currentTimeMillis);
            com.tencent.mm.plugin.report.service.h.pYm.e(11988, str2, str3, "", "", i.jV(longExtra), bc, str, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000));
        }
        AppMethodBeat.o(38926);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(38927);
        if (i == 4) {
            aqX();
            finish();
            AppMethodBeat.o(38927);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(38927);
        return onKeyDown;
    }

    static /* synthetic */ void a(SnsCommentUI snsCommentUI, String str) {
        AppMethodBeat.i(38928);
        n DK = af.cnF().DK(snsCommentUI.cNE);
        if (DK != null) {
            snsCommentUI.rrJ = true;
            if (DK.cqT()) {
                am.a.a(DK, 2, str, "", snsCommentUI.czs);
            } else {
                am.a.a(DK.field_userName, 3, str, DK, snsCommentUI.czs);
            }
            snsCommentUI.aqX();
            snsCommentUI.getString(R.string.tz);
            snsCommentUI.tipDialog = com.tencent.mm.ui.base.h.b((Context) snsCommentUI, snsCommentUI.getString(R.string.th), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
        AppMethodBeat.o(38928);
    }

    static /* synthetic */ void b(SnsCommentUI snsCommentUI, String str) {
        AppMethodBeat.i(38929);
        if (!snsCommentUI.isFinishing()) {
            r.Yz();
            ax axVar = new ax(2);
            axVar.Ym(str);
            if (snsCommentUI.rrH.getPasterLen() > com.tencent.mm.plugin.sns.c.a.qFE) {
                axVar.Dd(2);
            }
            axVar.commit();
            snsCommentUI.setResult(-1);
            snsCommentUI.finish();
        }
        AppMethodBeat.o(38929);
    }
}
