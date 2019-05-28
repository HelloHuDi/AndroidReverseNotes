package com.tencent.mm.plugin.expt.roomexpt;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class RoomExptDebugUI extends MMActivity {
    private ListView gGW;
    private ArrayAdapter lOF;
    private TextView lOG;
    private Button lOH;
    private Button lOI;
    private Button lOJ;
    private Button lOK;
    private Button lOL;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(RoomExptDebugUI roomExptDebugUI) {
        AppMethodBeat.i(73604);
        roomExptDebugUI.aWK();
        AppMethodBeat.o(73604);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73599);
        super.onCreate(bundle);
        this.lOH = (Button) findViewById(R.id.lx);
        this.lOH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73590);
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(73589);
                        RoomExptDebugUI.a(RoomExptDebugUI.this);
                        AppMethodBeat.o(73589);
                    }
                });
                AppMethodBeat.o(73590);
            }
        });
        this.lOI = (Button) findViewById(R.id.ly);
        this.lOI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73592);
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(73591);
                        RoomExptDebugUI.b(RoomExptDebugUI.this);
                        AppMethodBeat.o(73591);
                    }
                });
                AppMethodBeat.o(73592);
            }
        });
        this.lOK = (Button) findViewById(R.id.m0);
        this.lOK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73593);
                a.brg().brk();
                RoomExptDebugUI.c(RoomExptDebugUI.this);
                Toast.makeText(RoomExptDebugUI.this, "reset finish", 0).show();
                AppMethodBeat.o(73593);
            }
        });
        this.lOJ = (Button) findViewById(R.id.lz);
        this.lOJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73594);
                a.brg().brj();
                RoomExptDebugUI.this.lOF.clear();
                Toast.makeText(RoomExptDebugUI.this, "del db finish", 0).show();
                AppMethodBeat.o(73594);
            }
        });
        this.lOL = (Button) findViewById(R.id.m1);
        this.lOL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73595);
                a.brg().lOx = 3;
                Toast.makeText(RoomExptDebugUI.this, "set show finish", 0).show();
                AppMethodBeat.o(73595);
            }
        });
        this.lOG = (TextView) findViewById(R.id.m2);
        aWK();
        this.gGW = (ListView) findViewById(R.id.m3);
        this.lOF = new ArrayAdapter(this) {
            public final View getView(int i, View view, ViewGroup viewGroup) {
                AppMethodBeat.i(73596);
                View view2 = super.getView(i, view, viewGroup);
                TextView textView = (TextView) view2.findViewById(R.id.e3s);
                if (i % 2 == 0) {
                    textView.setBackgroundResource(R.color.a61);
                } else {
                    textView.setBackgroundResource(R.color.a3p);
                }
                AppMethodBeat.o(73596);
                return view2;
            }
        };
        this.gGW.setAdapter(this.lOF);
        AppMethodBeat.o(73599);
    }

    private void aWK() {
        AppMethodBeat.i(73600);
        this.lOG.setText(a.brg().brl());
        AppMethodBeat.o(73600);
    }

    public final int getLayoutId() {
        return R.layout.ao;
    }

    public void onDestroy() {
        AppMethodBeat.i(73601);
        if (this.lOF != null) {
            this.lOF.setNotifyOnChange(false);
            this.lOF.clear();
        }
        super.onDestroy();
        AppMethodBeat.o(73601);
    }

    static /* synthetic */ void a(RoomExptDebugUI roomExptDebugUI) {
        AppMethodBeat.i(73602);
        List brn = a.brg().lOt.brn();
        if (brn.size() > 0) {
            roomExptDebugUI.lOF.setNotifyOnChange(false);
            roomExptDebugUI.lOF.clear();
            roomExptDebugUI.lOF.addAll(brn);
        } else {
            roomExptDebugUI.lOF.setNotifyOnChange(false);
            roomExptDebugUI.lOF.clear();
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(73598);
                RoomExptDebugUI.this.lOF.notifyDataSetChanged();
                RoomExptDebugUI.c(RoomExptDebugUI.this);
                AppMethodBeat.o(73598);
            }
        });
        AppMethodBeat.o(73602);
    }

    static /* synthetic */ void b(RoomExptDebugUI roomExptDebugUI) {
        AppMethodBeat.i(73603);
        List<c> bri = a.brg().bri();
        ArrayList arrayList = new ArrayList();
        if (bri != null) {
            for (c cVar : bri) {
                arrayList.add(cVar.toString());
            }
        }
        if (arrayList.size() > 0) {
            roomExptDebugUI.lOF.setNotifyOnChange(false);
            roomExptDebugUI.lOF.clear();
            roomExptDebugUI.lOF.addAll(arrayList);
        } else {
            roomExptDebugUI.lOF.setNotifyOnChange(false);
            roomExptDebugUI.lOF.clear();
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(73597);
                RoomExptDebugUI.this.lOF.notifyDataSetChanged();
                RoomExptDebugUI.c(RoomExptDebugUI.this);
                AppMethodBeat.o(73597);
            }
        });
        AppMethodBeat.o(73603);
    }
}
