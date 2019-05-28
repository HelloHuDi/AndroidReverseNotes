package com.tencent.p177mm.plugin.expt.roomexpt;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI */
public class RoomExptDebugUI extends MMActivity {
    private ListView gGW;
    private ArrayAdapter lOF;
    private TextView lOG;
    private Button lOH;
    private Button lOI;
    private Button lOJ;
    private Button lOK;
    private Button lOL;

    /* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI$3 */
    class C30083 implements OnClickListener {
        C30083() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73593);
            C27899a.brg().brk();
            RoomExptDebugUI.m85106c(RoomExptDebugUI.this);
            Toast.makeText(RoomExptDebugUI.this, "reset finish", 0).show();
            AppMethodBeat.m2505o(73593);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI$4 */
    class C30094 implements OnClickListener {
        C30094() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73594);
            C27899a.brg().brj();
            RoomExptDebugUI.this.lOF.clear();
            Toast.makeText(RoomExptDebugUI.this, "del db finish", 0).show();
            AppMethodBeat.m2505o(73594);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI$1 */
    class C206031 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI$1$1 */
        class C117621 implements Runnable {
            C117621() {
            }

            public final void run() {
                AppMethodBeat.m2504i(73589);
                RoomExptDebugUI.m85104a(RoomExptDebugUI.this);
                AppMethodBeat.m2505o(73589);
            }
        }

        C206031() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73590);
            C1720g.m3539RS().mo10302aa(new C117621());
            AppMethodBeat.m2505o(73590);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI$2 */
    class C340802 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI$2$1 */
        class C340791 implements Runnable {
            C340791() {
            }

            public final void run() {
                AppMethodBeat.m2504i(73591);
                RoomExptDebugUI.m85105b(RoomExptDebugUI.this);
                AppMethodBeat.m2505o(73591);
            }
        }

        C340802() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73592);
            C1720g.m3539RS().mo10302aa(new C340791());
            AppMethodBeat.m2505o(73592);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI$5 */
    class C340815 implements OnClickListener {
        C340815() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73595);
            C27899a.brg().lOx = 3;
            Toast.makeText(RoomExptDebugUI.this, "set show finish", 0).show();
            AppMethodBeat.m2505o(73595);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI$7 */
    class C340827 implements Runnable {
        C340827() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73597);
            RoomExptDebugUI.this.lOF.notifyDataSetChanged();
            RoomExptDebugUI.m85106c(RoomExptDebugUI.this);
            AppMethodBeat.m2505o(73597);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI$8 */
    class C340838 implements Runnable {
        C340838() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73598);
            RoomExptDebugUI.this.lOF.notifyDataSetChanged();
            RoomExptDebugUI.m85106c(RoomExptDebugUI.this);
            AppMethodBeat.m2505o(73598);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    static /* synthetic */ void m85106c(RoomExptDebugUI roomExptDebugUI) {
        AppMethodBeat.m2504i(73604);
        roomExptDebugUI.aWK();
        AppMethodBeat.m2505o(73604);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(73599);
        super.onCreate(bundle);
        this.lOH = (Button) findViewById(2131821011);
        this.lOH.setOnClickListener(new C206031());
        this.lOI = (Button) findViewById(2131821012);
        this.lOI.setOnClickListener(new C340802());
        this.lOK = (Button) findViewById(2131821014);
        this.lOK.setOnClickListener(new C30083());
        this.lOJ = (Button) findViewById(2131821013);
        this.lOJ.setOnClickListener(new C30094());
        this.lOL = (Button) findViewById(2131821015);
        this.lOL.setOnClickListener(new C340815());
        this.lOG = (TextView) findViewById(2131821016);
        aWK();
        this.gGW = (ListView) findViewById(2131821017);
        this.lOF = new ArrayAdapter(this) {
            public final View getView(int i, View view, ViewGroup viewGroup) {
                AppMethodBeat.m2504i(73596);
                View view2 = super.getView(i, view, viewGroup);
                TextView textView = (TextView) view2.findViewById(2131827158);
                if (i % 2 == 0) {
                    textView.setBackgroundResource(C25738R.color.a61);
                } else {
                    textView.setBackgroundResource(C25738R.color.a3p);
                }
                AppMethodBeat.m2505o(73596);
                return view2;
            }
        };
        this.gGW.setAdapter(this.lOF);
        AppMethodBeat.m2505o(73599);
    }

    private void aWK() {
        AppMethodBeat.m2504i(73600);
        this.lOG.setText(C27899a.brg().brl());
        AppMethodBeat.m2505o(73600);
    }

    public final int getLayoutId() {
        return 2130968627;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(73601);
        if (this.lOF != null) {
            this.lOF.setNotifyOnChange(false);
            this.lOF.clear();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(73601);
    }

    /* renamed from: a */
    static /* synthetic */ void m85104a(RoomExptDebugUI roomExptDebugUI) {
        AppMethodBeat.m2504i(73602);
        List brn = C27899a.brg().lOt.brn();
        if (brn.size() > 0) {
            roomExptDebugUI.lOF.setNotifyOnChange(false);
            roomExptDebugUI.lOF.clear();
            roomExptDebugUI.lOF.addAll(brn);
        } else {
            roomExptDebugUI.lOF.setNotifyOnChange(false);
            roomExptDebugUI.lOF.clear();
        }
        C5004al.m7441d(new C340838());
        AppMethodBeat.m2505o(73602);
    }

    /* renamed from: b */
    static /* synthetic */ void m85105b(RoomExptDebugUI roomExptDebugUI) {
        AppMethodBeat.m2504i(73603);
        List<C11764c> bri = C27899a.brg().bri();
        ArrayList arrayList = new ArrayList();
        if (bri != null) {
            for (C11764c c11764c : bri) {
                arrayList.add(c11764c.toString());
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
        C5004al.m7441d(new C340827());
        AppMethodBeat.m2505o(73603);
    }
}
