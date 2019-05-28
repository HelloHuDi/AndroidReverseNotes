package com.tencent.mm.plugin.kitchen.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KvInfoUI extends MMActivity {
    private c gLj;
    private Button grC;
    private MMSwitchBtn ixT;
    private ArrayAdapter lOF;
    private EditText nHf;
    private Button nHg;
    private ListView nHh;
    private TextView nHi;
    private String nHj;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(114449);
        super.onCreate(bundle);
        setMMTitle("Debug show kv log");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(114440);
                KvInfoUI.this.finish();
                AppMethodBeat.o(114440);
                return true;
            }
        });
        this.nHf = (EditText) findViewById(R.id.cnu);
        this.nHi = (TextView) findViewById(R.id.cnx);
        this.nHg = (Button) findViewById(R.id.cnv);
        this.nHg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(114442);
                HashMap hashMap = j.cgu().pYD;
                if (hashMap != null && hashMap.size() > 0) {
                    final ArrayList arrayList = new ArrayList(hashMap.keySet());
                    final b bVar = new b(KvInfoUI.this.mController.ylL, arrayList);
                    bVar.Qq(0);
                    bVar.zSq = new a() {
                        public final void d(boolean z, Object obj) {
                            AppMethodBeat.i(114441);
                            bVar.hide();
                            KvInfoUI.a(KvInfoUI.this, (String) arrayList.get(bVar.dLl()));
                            AppMethodBeat.o(114441);
                        }
                    };
                    bVar.Qp(com.tencent.mm.bz.a.fromDPToPix(KvInfoUI.this.mController.ylL, d.MIC_PTU_YOUJIALI));
                    bVar.show();
                }
                AppMethodBeat.o(114442);
            }
        });
        this.ixT = (MMSwitchBtn) findViewById(R.id.cnw);
        this.ixT.setCheck(j.cgu().pWV);
        this.ixT.setSwitchListener(new MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(114443);
                j cgu = j.cgu();
                cgu.pWV = z;
                e.kh(cgu.pWV);
                com.tencent.mm.plugin.report.a.kh(cgu.pWV);
                AppMethodBeat.o(114443);
            }
        });
        this.grC = (Button) findViewById(R.id.ll);
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(114444);
                KvInfoUI.a(KvInfoUI.this, KvInfoUI.this.nHf.getText().toString().trim());
                AppMethodBeat.o(114444);
            }
        });
        this.nHh = (ListView) findViewById(R.id.cny);
        this.lOF = new ArrayAdapter(this) {
            public final View getView(int i, View view, ViewGroup viewGroup) {
                AppMethodBeat.i(114445);
                View view2 = super.getView(i, view, viewGroup);
                com.tencent.mm.plugin.report.service.d dVar = (com.tencent.mm.plugin.report.service.d) KvInfoUI.this.lOF.getItem(i);
                TextView textView = (TextView) view2.findViewById(R.id.cnz);
                if (dVar == null || !dVar.pXS) {
                    textView.setBackgroundResource(R.color.a3p);
                } else {
                    textView.setBackgroundResource(R.color.a61);
                }
                AppMethodBeat.o(114445);
                return view2;
            }
        };
        this.nHh.setAdapter(this.lOF);
        this.nHh.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(114448);
                com.tencent.mm.plugin.report.service.d dVar = (com.tencent.mm.plugin.report.service.d) KvInfoUI.this.lOF.getItem(i);
                if (dVar == null) {
                    AppMethodBeat.o(114448);
                    return;
                }
                if (dVar.cvZ == null || dVar.cvZ.length() <= 0) {
                    dVar.cvZ = ag.ck(dVar.value);
                }
                final String str = (String) j.cgu().pYE.get(dVar.cvZ);
                if (KvInfoUI.this.gLj != null) {
                    KvInfoUI.this.gLj.dismiss();
                }
                if (!bo.isNullOrNil(str)) {
                    KvInfoUI.this.gLj = h.a(KvInfoUI.this, str, "", KvInfoUI.this.getString(R.string.s6), KvInfoUI.this.getString(R.string.oy), true, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(114446);
                            dialogInterface.cancel();
                            AppMethodBeat.o(114446);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(114447);
                            try {
                                ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("kv_info", str));
                                Toast.makeText(KvInfoUI.this.mController.ylL, KvInfoUI.this.mController.ylL.getString(R.string.oz), 0).show();
                                AppMethodBeat.o(114447);
                            } catch (Exception e) {
                                ab.e("MicroMsg.KvInfoUI", "copy error [%s]", e.toString());
                                Toast.makeText(KvInfoUI.this.mController.ylL, "copy failure", 0).show();
                                AppMethodBeat.o(114447);
                            }
                        }
                    }, -1);
                }
                AppMethodBeat.o(114448);
            }
        });
        AppMethodBeat.o(114449);
    }

    public final int getLayoutId() {
        return R.layout.a9c;
    }

    private void PC(String str) {
        AppMethodBeat.i(114450);
        ab.i("MicroMsg.KvInfoUI", "updateData new[%s] old[%s]", str, this.nHj);
        this.nHj = str;
        List list = (List) j.cgu().pYD.get(this.nHj);
        if (list != null) {
            this.nHi.setText(this.nHj + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + list.size());
            this.lOF.setNotifyOnChange(false);
            this.lOF.clear();
            this.lOF.addAll(list);
            this.lOF.notifyDataSetChanged();
            AppMethodBeat.o(114450);
            return;
        }
        this.nHi.setText(this.nHj + ":0");
        this.lOF.clear();
        AppMethodBeat.o(114450);
    }

    public void onDestroy() {
        AppMethodBeat.i(114451);
        if (this.lOF != null) {
            this.lOF.setNotifyOnChange(false);
            this.lOF.clear();
        }
        if (this.gLj != null) {
            this.gLj.dismiss();
        }
        aqX();
        super.onDestroy();
        AppMethodBeat.o(114451);
    }

    public void onResume() {
        AppMethodBeat.i(114452);
        if (!bo.isNullOrNil(this.nHj)) {
            PC(this.nHj);
        }
        super.onResume();
        AppMethodBeat.o(114452);
    }
}
