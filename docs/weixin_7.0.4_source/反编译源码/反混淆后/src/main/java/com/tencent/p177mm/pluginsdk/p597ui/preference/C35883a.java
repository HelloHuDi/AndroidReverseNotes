package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C37512c;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.a */
public final class C35883a extends LinearLayout implements C1202f {
    private static C14956a vqm;
    private Context context;
    private TextView gKl;
    private C44275p tipDialog;
    private Button vqn;

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.a$a */
    public static class C14956a {
        public String mGZ;
        public int scene;
        public String talker;
        public int type;
        public String vqs;
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.a$1 */
    class C358841 implements OnClickListener {

        /* renamed from: com.tencent.mm.pluginsdk.ui.preference.a$1$3 */
        class C358853 implements Runnable {
            C358853() {
            }

            public final void run() {
                AppMethodBeat.m2504i(28027);
                if (C35883a.this.context instanceof MMActivity) {
                    ((MMActivity) C35883a.this.context).showVKB();
                }
                AppMethodBeat.m2505o(28027);
            }
        }

        C358841() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(28028);
            View inflate = View.inflate(C35883a.this.context, 2130970617, null);
            ((TextView) inflate.findViewById(2131827352)).setVisibility(8);
            final TextView textView = (TextView) inflate.findViewById(2131823129);
            textView.setVisibility(0);
            textView.setText("50");
            final EditText editText = (EditText) inflate.findViewById(2131827353);
            editText.setSingleLine(false);
            C7357c.m12555d(editText).mo15877PM(100).mo15879a(null);
            editText.addTextChangedListener(new TextWatcher() {
                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.m2504i(28025);
                    int bP = C5584f.m8385bP(100, editable.toString());
                    if (textView != null) {
                        textView.setText(String.valueOf(bP));
                    }
                    AppMethodBeat.m2505o(28025);
                }
            });
            C30379h.m48436a(C35883a.this.context, C35883a.this.context.getString(C25738R.string.f9214t8), inflate, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(28026);
                    String trim = editText.getText().toString().trim();
                    if (trim != null && trim.length() > 0) {
                        C35883a.m58838a(C35883a.this, trim);
                    }
                    AppMethodBeat.m2505o(28026);
                }
            }, null);
            editText.post(new C358853());
            AppMethodBeat.m2505o(28028);
        }
    }

    public static void setFMessageArgs(C14956a c14956a) {
        vqm = c14956a;
    }

    public C35883a(Context context) {
        super(context);
        AppMethodBeat.m2504i(28030);
        this.context = context;
        View inflate = View.inflate(this.context, 2130969583, this);
        this.gKl = (TextView) inflate.findViewById(2131824108);
        this.vqn = (Button) inflate.findViewById(2131824109);
        this.vqn.setOnClickListener(new C358841());
        AppMethodBeat.m2505o(28030);
    }

    public final void detach() {
        AppMethodBeat.m2504i(28031);
        C9638aw.m17182Rg().mo14546b(30, (C1202f) this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(28031);
    }

    private static int ajL(String str) {
        AppMethodBeat.m2504i(28032);
        if (str == null) {
            C4990ab.m7410d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
            AppMethodBeat.m2505o(28032);
            return 6;
        }
        switch (C5138d.apF(str).cAd) {
            case 2:
            case 5:
                AppMethodBeat.m2505o(28032);
                return 6;
            case 6:
                AppMethodBeat.m2505o(28032);
                return 5;
            default:
                AppMethodBeat.m2505o(28032);
                return 6;
        }
    }

    public final void setContentText(String str) {
        AppMethodBeat.m2504i(28033);
        if (C5046bo.isNullOrNil(str)) {
            this.gKl.setVisibility(8);
            AppMethodBeat.m2505o(28033);
            return;
        }
        this.gKl.setVisibility(0);
        this.gKl.setText(C44089j.m79293b(this.context, C5046bo.nullAsNil(str), this.gKl.getTextSize()));
        AppMethodBeat.m2505o(28033);
    }

    public final void setBtnVisibility(int i) {
        AppMethodBeat.m2504i(28034);
        if (this.vqn != null) {
            this.vqn.setVisibility(i);
        }
        AppMethodBeat.m2505o(28034);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(28035);
        if (c1207m.getType() != 30) {
            AppMethodBeat.m2505o(28035);
            return;
        }
        C4990ab.m7410d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            int i3 = ((C46498m) c1207m).cAd;
            String str2 = ((C46498m) c1207m).vbn;
            C4990ab.m7410d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + i3 + ", verifyContent = " + str2);
            C4990ab.m7410d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + vqm.type);
            switch (vqm.type) {
                case 1:
                    C7570bf c7570bf = new C7570bf();
                    c7570bf.field_createtime = ((C6982j) C1720g.m3528K(C6982j.class)).bOo().mo15231QV(vqm.talker);
                    c7570bf.field_isSend = 1;
                    c7570bf.field_content = str2;
                    c7570bf.field_talker = "fmessage";
                    c7570bf.field_sayhiuser = vqm.talker;
                    c7570bf.field_svrid = System.currentTimeMillis();
                    c7570bf.field_status = 4;
                    C41789d.akQ().mo56738a(c7570bf);
                    break;
                case 2:
                    C41338bt c41338bt = new C41338bt();
                    c41338bt.field_createtime = ((C6982j) C1720g.m3528K(C6982j.class)).bOn().mo15363QV(vqm.talker);
                    c41338bt.field_isSend = 1;
                    c41338bt.field_content = str2;
                    c41338bt.field_talker = "fmessage";
                    c41338bt.field_sayhiuser = vqm.talker;
                    c41338bt.field_svrid = System.currentTimeMillis();
                    c41338bt.field_status = 4;
                    C4990ab.m7410d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = ".concat(String.valueOf(C41789d.akR().mo74759a(c41338bt))));
                    break;
                default:
                    C7569ax c7569ax = new C7569ax();
                    c7569ax.field_createTime = C37512c.m63303q(vqm.talker, 0);
                    c7569ax.field_isSend = 1;
                    c7569ax.field_msgContent = str2;
                    c7569ax.field_talker = vqm.talker;
                    c7569ax.field_type = i3 == 5 ? 2 : 3;
                    C4990ab.m7410d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = ".concat(String.valueOf(C41789d.akO().mo17080b(c7569ax))));
                    break;
            }
        }
        CharSequence str3;
        if (i == 4 && i2 == -34) {
            str3 = this.context.getString(C25738R.string.bwe);
        } else if (i == 4 && i2 == -94) {
            str3 = this.context.getString(C25738R.string.bwh);
        } else if (!(i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str3))) {
            str3 = this.context.getString(C25738R.string.e3n);
        }
        Toast.makeText(this.context, str3, 1).show();
        C9638aw.m17182Rg().mo14546b(30, (C1202f) this);
        AppMethodBeat.m2505o(28035);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m58838a(C35883a c35883a, String str) {
        AppMethodBeat.m2504i(28036);
        if (vqm == null) {
            C4990ab.m7412e("MicroMsg.FMessageItemView", "FMessage Args is null");
            AppMethodBeat.m2505o(28036);
            return;
        }
        int i;
        C4990ab.m7410d("MicroMsg.FMessageItemView", "try to reply verify content");
        LinkedList linkedList = new LinkedList();
        linkedList.add(vqm.talker);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(vqm.scene));
        LinkedList linkedList3 = new LinkedList();
        linkedList3.add(vqm.vqs);
        int i2 = vqm.type;
        String str2 = vqm.talker;
        C4990ab.m7410d("MicroMsg.FMessageItemView", "getOpCode, type = " + i2 + ", talker = " + str2);
        switch (i2) {
            case 0:
                boolean z;
                if (str2 != null && str2.length() != 0) {
                    C7569ax apx = C41789d.akO().apx(str2);
                    if (apx != null) {
                        if (apx.field_type == 1 || apx.field_type == 2) {
                            z = true;
                            if (!z) {
                                i = 5;
                                break;
                            }
                        }
                    }
                    C4990ab.m7412e("MicroMsg.FMessageLogic", "isVerifyReceiver, lastRecvFmsg does not exist, talker = ".concat(String.valueOf(str2)));
                } else {
                    C4990ab.m7412e("MicroMsg.FMessageLogic", "isVerifyReceiver, invalid argument");
                }
                z = false;
                if (z) {
                }
                break;
            case 1:
                C7570bf c7570bf;
                C7570bf[] er = C41789d.akQ().mo56741er(str2, 1);
                if (er != null) {
                    c7570bf = er[0];
                } else {
                    c7570bf = null;
                }
                if (c7570bf != null) {
                    i = C35883a.ajL(c7570bf.field_content);
                    break;
                }
                C4990ab.m7412e("MicroMsg.FMessageItemView", "getOpCode, last lbsMsg is null");
            case 2:
                C41338bt c41338bt;
                C41338bt[] et = C41789d.akR().mo74764et(str2, 1);
                if (et != null) {
                    c41338bt = et[0];
                } else {
                    c41338bt = null;
                }
                if (c41338bt != null) {
                    i = C35883a.ajL(c41338bt.field_content);
                    break;
                }
                C4990ab.m7412e("MicroMsg.FMessageItemView", "getOpCode, last shakeMsg is null");
            default:
                i = 6;
                break;
        }
        C4990ab.m7410d("MicroMsg.FMessageItemView", "reply, final opcode = ".concat(String.valueOf(i)));
        C9638aw.m17182Rg().mo14539a(30, (C1202f) c35883a);
        final C1207m c46498m = new C46498m(i, linkedList, linkedList2, linkedList3, str, vqm.mGZ, null, null, "");
        C9638aw.m17182Rg().mo14541a(c46498m, 0);
        Context context = c35883a.context;
        c35883a.context.getString(C25738R.string.f9238tz);
        c35883a.tipDialog = C30379h.m48458b(context, c35883a.context.getString(C25738R.string.f9222th), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(28029);
                C9638aw.m17182Rg().mo14547c(c46498m);
                AppMethodBeat.m2505o(28029);
            }
        });
        AppMethodBeat.m2505o(28036);
    }
}
