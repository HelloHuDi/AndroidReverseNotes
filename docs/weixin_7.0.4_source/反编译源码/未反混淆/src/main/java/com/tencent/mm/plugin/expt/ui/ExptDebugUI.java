package com.tencent.mm.plugin.expt.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.b.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ExptDebugUI extends MMActivity {
    private Button grC;
    private Button gzI;
    private TextView lOS;
    private Button lOT;
    private Button lOU;
    private TextView lOV;
    private TextView lOW;
    private TextView lOX;
    private TextView lOY;
    private TextView lOZ;
    private EditText lPa;
    private Button lPb;
    private int lPc = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73639);
        super.onCreate(bundle);
        setMMTitle("Expt debug ui");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73632);
                ExptDebugUI.this.finish();
                AppMethodBeat.o(73632);
                return true;
            }
        });
        this.lOS = (TextView) findViewById(R.id.lk);
        this.grC = (Button) findViewById(R.id.ll);
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73633);
                ExptDebugUI.a(ExptDebugUI.this, bo.getInt(ExptDebugUI.this.lOS.getText().toString().trim(), 0));
                AppMethodBeat.o(73633);
            }
        });
        this.lPa = (EditText) findViewById(R.id.lu);
        this.lPb = (Button) findViewById(R.id.lv);
        this.lPb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73634);
                ExptDebugUI.b(ExptDebugUI.this);
                AppMethodBeat.o(73634);
            }
        });
        this.lOT = (Button) findViewById(R.id.lm);
        this.lOT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ArrayList brx;
                AppMethodBeat.i(73636);
                a bqR = a.bqR();
                if (bqR.lNF != null) {
                    brx = bqR.lNF.brx();
                } else {
                    brx = null;
                }
                if (brx != null && brx.size() > 0) {
                    final String[] strArr = new String[brx.size()];
                    for (int i = 0; i < strArr.length; i++) {
                        strArr[i] = brx.get(i);
                    }
                    final b bVar = new b(ExptDebugUI.this.mController.ylL, strArr);
                    bVar.Qq(0);
                    bVar.zSq = new b.a() {
                        public final void d(boolean z, Object obj) {
                            AppMethodBeat.i(73635);
                            bVar.hide();
                            ExptDebugUI.a(ExptDebugUI.this, bo.getInt(strArr[bVar.dLl()], 0));
                            AppMethodBeat.o(73635);
                        }
                    };
                    bVar.Qp(com.tencent.mm.bz.a.fromDPToPix(ExptDebugUI.this.mController.ylL, d.MIC_PTU_YOUJIALI));
                    bVar.show();
                }
                AppMethodBeat.o(73636);
            }
        });
        this.lOU = (Button) findViewById(R.id.ln);
        this.lOU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73637);
                a.bqR();
                a.va(1);
                AppMethodBeat.o(73637);
            }
        });
        this.gzI = (Button) findViewById(R.id.lo);
        this.gzI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73638);
                com.tencent.mm.plugin.expt.d.a uZ = a.bqR().uZ(ExptDebugUI.this.lPc);
                if (uZ != null && uZ.bro()) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(ExptDebugUI.this.lPc));
                    a.bqR();
                    a.a(null, null, linkedList);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(ExptDebugUI.this.lPc));
                ExptDebugUI.this.lOZ.setText(" del :" + ExptDebugUI.this.lPc + " " + (a.bqR().bB(arrayList) > 0));
                AppMethodBeat.o(73638);
            }
        });
        this.lOV = (TextView) findViewById(R.id.lp);
        this.lOW = (TextView) findViewById(R.id.lq);
        this.lOX = (TextView) findViewById(R.id.lr);
        this.lOY = (TextView) findViewById(R.id.ls);
        this.lOZ = (TextView) findViewById(R.id.lt);
        AppMethodBeat.o(73639);
    }

    public final int getLayoutId() {
        return R.layout.am;
    }

    static /* synthetic */ void a(ExptDebugUI exptDebugUI, int i) {
        AppMethodBeat.i(73640);
        exptDebugUI.lPc = i;
        com.tencent.mm.plugin.expt.d.a uZ = a.bqR().uZ(exptDebugUI.lPc);
        if (uZ != null) {
            exptDebugUI.lOV.setText(uZ.field_exptId);
            exptDebugUI.lOW.setText(uZ.field_groupId);
            exptDebugUI.lOX.setText(uZ.field_exptSeq);
            exptDebugUI.lOY.setText(" start: " + uZ.field_startTime + " end: " + uZ.field_endTime);
        }
        HashMap a = a.bqR().a(exptDebugUI.lPc, false, null, new PBool());
        if (a != null) {
            exptDebugUI.lOZ.setText(" args : " + a.toString());
        }
        AppMethodBeat.o(73640);
    }

    static /* synthetic */ void b(ExptDebugUI exptDebugUI) {
        AppMethodBeat.i(73641);
        a.bqR().KY(exptDebugUI.lPa.getText().toString().trim());
        exptDebugUI.lPa.setText("");
        AppMethodBeat.o(73641);
    }
}
