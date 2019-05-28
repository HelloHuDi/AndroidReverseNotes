package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;

public class SnsSingleTextViewUI extends MMActivity {
    private String czD;
    private d jOb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(39305);
            switch (menuItem.getItemId()) {
                case 0:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        SnsSingleTextViewUI.this.mmO.setText(SnsSingleTextViewUI.this.rxb.getText());
                        h.bQ(SnsSingleTextViewUI.this.mController.ylL, SnsSingleTextViewUI.this.mController.ylL.getString(R.string.oz));
                        if (SnsSingleTextViewUI.this.qNM != null) {
                            a aVar = a.qjm;
                            a.h(2, bo.mz(SnsSingleTextViewUI.this.qNM.field_snsId), bo.ana(SnsSingleTextViewUI.this.rxb.getText().toString()));
                        }
                    }
                    AppMethodBeat.o(39305);
                    return;
                case 1:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        cl clVar = new cl();
                        com.tencent.mm.plugin.sns.j.a.a(clVar, SnsSingleTextViewUI.this.czD, SnsSingleTextViewUI.this.rxb.getText());
                        clVar.cvA.activity = SnsSingleTextViewUI.this;
                        clVar.cvA.cvH = 18;
                        com.tencent.mm.sdk.b.a.xxA.m(clVar);
                    }
                    AppMethodBeat.o(39305);
                    return;
                case 6:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        Intent intent = new Intent();
                        n YT = af.cnF().YT(SnsSingleTextViewUI.this.czD);
                        intent.putExtra("k_username", YT == null ? "" : YT.field_userName);
                        intent.putExtra("k_expose_msg_id", YT == null ? Integer.valueOf(0) : YT.cqA());
                        intent.putExtra("showShare", false);
                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        com.tencent.mm.bp.d.b(SnsSingleTextViewUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                    AppMethodBeat.o(39305);
                    return;
                case 14:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        ap.r(af.cnF().YT(SnsSingleTextViewUI.this.czD));
                    }
                    AppMethodBeat.o(39305);
                    return;
                case 15:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        ap.a(new l(null, SnsSingleTextViewUI.this.qNM.cqA(), SnsSingleTextViewUI.this.rxg, null, SnsSingleTextViewUI.this.rxg.ncM, null, 1));
                    }
                    AppMethodBeat.o(39305);
                    return;
                case 16:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        ap.s(af.cnF().YT(SnsSingleTextViewUI.this.czD));
                    }
                    AppMethodBeat.o(39305);
                    return;
                case 17:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        ap.b(new l(null, SnsSingleTextViewUI.this.qNM.cqA(), SnsSingleTextViewUI.this.rxg, null, SnsSingleTextViewUI.this.rxg.ncM, null, 1));
                    }
                    AppMethodBeat.o(39305);
                    return;
                default:
                    AppMethodBeat.o(39305);
                    return;
            }
        }
    };
    private ClipboardManager mmO;
    private n qNM;
    protected int requestType = 0;
    private TextView rxb;
    private String rxc = null;
    private String rxd = null;
    private int rxe;
    private byte[] rxf = null;
    private cat rxg = null;
    private boolean rxh = false;
    private SnsTranslateResultView rxi;
    private c rxj = new c<ry>() {
        {
            AppMethodBeat.i(39298);
            this.xxI = ry.class.getName().hashCode();
            AppMethodBeat.o(39298);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(39299);
            ry ryVar = (ry) bVar;
            if ((ryVar instanceof ry) && SnsSingleTextViewUI.this.qNM != null && bo.isEqual(SnsSingleTextViewUI.this.rxd, ryVar.cNT.id)) {
                ap.cZ(SnsSingleTextViewUI.this.rxd, 8);
                SnsSingleTextViewUI.this.rxi.setVisibility(0);
                SnsSingleTextViewUI.this.rxi.El(SnsSingleTextViewUI.this.rxe);
                SnsSingleTextViewUI.this.rxh = false;
            }
            AppMethodBeat.o(39299);
            return false;
        }
    };
    private c rxk = new c<rx>() {
        {
            AppMethodBeat.i(39300);
            this.xxI = rx.class.getName().hashCode();
            AppMethodBeat.o(39300);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(39301);
            rx rxVar = (rx) bVar;
            if ((rxVar instanceof rx) && SnsSingleTextViewUI.this.qNM != null && bo.isEqual(SnsSingleTextViewUI.this.rxd, rxVar.cNR.id)) {
                ap.cZ(SnsSingleTextViewUI.this.rxd, 8);
                String str = rxVar.cNR.result;
                String str2 = rxVar.cNR.cNS;
                if (bo.isNullOrNil(str)) {
                    SnsSingleTextViewUI.this.rxi.setVisibility(8);
                    ap.da(SnsSingleTextViewUI.this.rxd, 8);
                } else {
                    SnsSingleTextViewUI.this.rxi.setVisibility(0);
                    SnsSingleTextViewUI.this.rxi.a(null, SnsSingleTextViewUI.this.rxe, str, str2, true);
                    SnsSingleTextViewUI.this.rxh = true;
                }
            }
            AppMethodBeat.o(39301);
            return false;
        }
    };
    private c rxl = new c<rz>() {
        {
            AppMethodBeat.i(39302);
            this.xxI = rz.class.getName().hashCode();
            AppMethodBeat.o(39302);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(39303);
            rz rzVar = (rz) bVar;
            if ((rzVar instanceof rz) && bo.isEqual(SnsSingleTextViewUI.this.rxd, rzVar.cNU.id)) {
                ap.da(rzVar.cNU.id, 8);
                SnsSingleTextViewUI.this.rxi.setVisibility(8);
                SnsSingleTextViewUI.this.rxh = false;
            }
            AppMethodBeat.o(39303);
            return false;
        }
    };
    private String text;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsSingleTextViewUI() {
        AppMethodBeat.i(39306);
        AppMethodBeat.o(39306);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39307);
        super.onCreate(bundle);
        this.mmO = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        setMMTitle((int) R.string.ejo);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39304);
                SnsSingleTextViewUI.this.finish();
                AppMethodBeat.o(39304);
                return true;
            }
        });
        this.text = getIntent().getStringExtra("sns_text_show");
        this.czD = bo.bc(getIntent().getStringExtra("sns_local_id"), "");
        this.rxf = getIntent().getByteArrayExtra("sns_comment_buf");
        if (this.rxf != null && this.rxf.length > 0) {
            this.rxg = new cat();
            try {
                long j;
                this.rxg.parseFrom(this.rxf);
                StringBuilder stringBuilder = new StringBuilder();
                if (this.rxg.wZG != 0) {
                    j = (long) this.rxg.wZG;
                } else {
                    j = this.rxg.wZJ;
                }
                this.rxc = stringBuilder.append(j).toString();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.SnsSingleTextViewUI", e, "initCommentInfo error.", new Object[0]);
            }
        }
        this.qNM = af.cnF().YT(this.czD);
        if (bo.isNullOrNil(this.text)) {
            this.text = "";
        }
        this.rxb = (TextView) findViewById(R.id.elh);
        this.rxb.setText(this.text, BufferType.SPANNABLE);
        j.h(this.rxb, 2);
        this.rxb.setOnTouchListener(new m());
        new com.tencent.mm.ui.tools.j(this).a(this.rxb, this, this.jOb);
        this.rxi = (SnsTranslateResultView) findViewById(R.id.ehu);
        this.rxi.setResultTextSize(this.rxb.getTextSize());
        if (this.qNM != null) {
            if (ctO()) {
                this.rxd = ap.ga(this.qNM.cqA(), this.rxc);
                this.rxe = 2;
            } else {
                this.rxd = this.qNM.cqA();
                this.rxe = 1;
            }
            if (ap.db(this.rxd, 8)) {
                ap.b Ye = ap.Ye(this.rxd);
                if (Ye != null && Ye.foa) {
                    this.rxi.setVisibility(0);
                    this.rxi.a(null, this.rxe, Ye.result, Ye.fwM, false);
                    this.rxh = true;
                }
            }
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.rxj);
        com.tencent.mm.sdk.b.a.xxA.c(this.rxk);
        com.tencent.mm.sdk.b.a.xxA.c(this.rxl);
        AppMethodBeat.o(39307);
    }

    public void onDestroy() {
        AppMethodBeat.i(39308);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.rxj);
        com.tencent.mm.sdk.b.a.xxA.d(this.rxk);
        com.tencent.mm.sdk.b.a.xxA.d(this.rxl);
        AppMethodBeat.o(39308);
    }

    public final int getLayoutId() {
        return R.layout.awb;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        boolean z = true;
        AppMethodBeat.i(39309);
        if (view instanceof TextView) {
            contextMenu.add(0, 0, 0, getString(R.string.oy));
            if (com.tencent.mm.bp.d.afj("favorite") && !ctO()) {
                contextMenu.add(0, 1, 0, getString(R.string.bnl));
            }
            contextMenu.add(0, 6, 1, getString(R.string.pu));
            if (this.rxh) {
                if (ctO()) {
                    z = false;
                }
                ap.b(contextMenu, z);
            } else {
                if (ctO()) {
                    z = false;
                }
                ap.a(contextMenu, z);
                AppMethodBeat.o(39309);
                return;
            }
        }
        AppMethodBeat.o(39309);
    }

    private boolean ctO() {
        boolean z = false;
        AppMethodBeat.i(39310);
        if (!(this.rxg == null || ((this.rxg.wZG == 0 && this.rxg.wZJ == 0) || bo.isNullOrNil(this.rxg.ncM)))) {
            z = true;
        }
        AppMethodBeat.o(39310);
        return z;
    }
}
