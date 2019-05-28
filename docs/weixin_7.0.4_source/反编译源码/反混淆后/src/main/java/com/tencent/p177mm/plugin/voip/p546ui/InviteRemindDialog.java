package com.tencent.p177mm.plugin.voip.p546ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.plugin.voip.C43728c;
import com.tencent.p177mm.plugin.voip.model.C14044h;
import com.tencent.p177mm.plugin.voip.model.C29498i.C22459a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.voip.ui.InviteRemindDialog */
public class InviteRemindDialog extends MMBaseActivity {
    private TextView gsf;
    private TextView sVO;
    private String talker = "";
    private int type = 0;

    /* renamed from: com.tencent.mm.plugin.voip.ui.InviteRemindDialog$1 */
    class C224631 implements OnClickListener {
        C224631() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4770);
            if (InviteRemindDialog.this.talker != null) {
                try {
                    Map abV = C22459a.abV((String) C1720g.m3536RP().mo5239Ry().get(77829, null));
                    C22459a c22459a;
                    if (abV != null) {
                        if (abV != null && abV.size() > 0) {
                            if (abV.containsKey(InviteRemindDialog.this.talker)) {
                                c22459a = (C22459a) abV.get(InviteRemindDialog.this.talker);
                                c22459a.fMk++;
                                abV.put(InviteRemindDialog.this.talker, c22459a);
                            } else {
                                c22459a = new C22459a();
                                c22459a.fMk++;
                                abV.put(InviteRemindDialog.this.talker, c22459a);
                            }
                        }
                        C1720g.m3536RP().mo5239Ry().set(77829, C22459a.m34142ah(abV));
                        for (Entry value : abV.entrySet()) {
                            c22459a = (C22459a) value.getValue();
                            C4990ab.m7410d("MMInviteRemindDialog", "val " + c22459a.hitCount + " " + c22459a.fMk);
                        }
                    } else {
                        HashMap hashMap = new HashMap();
                        C22459a c22459a2 = new C22459a();
                        c22459a2.fMk++;
                        hashMap.put(InviteRemindDialog.this.talker, c22459a2);
                        C1720g.m3536RP().mo5239Ry().set(77829, C22459a.m34142ah(hashMap));
                        for (Entry value2 : hashMap.entrySet()) {
                            c22459a = (C22459a) value2.getValue();
                            C4990ab.m7410d("MMInviteRemindDialog", "val " + c22459a.hitCount + " " + c22459a.fMk);
                        }
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MMInviteRemindDialog", e, "", new Object[0]);
                }
            }
            String string = InviteRemindDialog.this.type == 0 ? InviteRemindDialog.this.getString(C25738R.string.f5y) : InviteRemindDialog.this.type == 1 ? InviteRemindDialog.this.getString(C25738R.string.f7h) : null;
            C1720g.m3540Rg().mo14541a(new C14044h(InviteRemindDialog.this.talker, string, C1855t.m3925nK(InviteRemindDialog.this.talker)), 0);
            Intent intent = new Intent();
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", InviteRemindDialog.this.talker);
            C43728c.gkE.mo38915d(intent, InviteRemindDialog.this);
            InviteRemindDialog.this.finish();
            AppMethodBeat.m2505o(4770);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.InviteRemindDialog$2 */
    class C224642 implements OnClickListener {
        C224642() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4771);
            InviteRemindDialog.this.finish();
            AppMethodBeat.m2505o(4771);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(4772);
        super.onCreate(bundle);
        setContentView(2130970228);
        this.gsf = (TextView) findViewById(2131824517);
        this.sVO = (TextView) findViewById(2131824518);
        this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
        this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
        if (this.type == 0) {
            this.gsf.setText(getString(C25738R.string.f6w));
            this.sVO.setText(getString(C25738R.string.f5z));
        } else if (this.type == 1) {
            this.gsf.setText(getString(C25738R.string.f7r));
            this.sVO.setText(getString(C25738R.string.f7i));
        }
        findViewById(2131822912).setOnClickListener(new C224631());
        findViewById(2131822911).setOnClickListener(new C224642());
        AppMethodBeat.m2505o(4772);
    }

    public void finish() {
        AppMethodBeat.m2504i(4773);
        super.finish();
        AppMethodBeat.m2505o(4773);
    }

    /* renamed from: p */
    public static void m78402p(Context context, String str, int i) {
        AppMethodBeat.m2504i(4774);
        Intent intent = new Intent(context, InviteRemindDialog.class);
        intent.putExtra("InviteRemindDialog_User", str);
        intent.putExtra("InviteRemindDialog_Type", i);
        context.startActivity(intent);
        AppMethodBeat.m2505o(4774);
    }
}
