package com.tencent.mm.pluginsdk.ui.preference;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.b.c;
import java.util.LinkedList;

public final class a extends LinearLayout implements f {
    private static a vqm;
    private Context context;
    private TextView gKl;
    private p tipDialog;
    private Button vqn;

    public static class a {
        public String mGZ;
        public int scene;
        public String talker;
        public int type;
        public String vqs;
    }

    public static void setFMessageArgs(a aVar) {
        vqm = aVar;
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(28030);
        this.context = context;
        View inflate = View.inflate(this.context, R.layout.a0e, this);
        this.gKl = (TextView) inflate.findViewById(R.id.bvb);
        this.vqn = (Button) inflate.findViewById(R.id.bvc);
        this.vqn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(28028);
                View inflate = View.inflate(a.this.context, R.layout.arb, null);
                ((TextView) inflate.findViewById(R.id.e91)).setVisibility(8);
                final TextView textView = (TextView) inflate.findViewById(R.id.b5v);
                textView.setVisibility(0);
                textView.setText("50");
                final EditText editText = (EditText) inflate.findViewById(R.id.e92);
                editText.setSingleLine(false);
                c.d(editText).PM(100).a(null);
                editText.addTextChangedListener(new TextWatcher() {
                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        AppMethodBeat.i(28025);
                        int bP = com.tencent.mm.ui.tools.f.bP(100, editable.toString());
                        if (textView != null) {
                            textView.setText(String.valueOf(bP));
                        }
                        AppMethodBeat.o(28025);
                    }
                });
                h.a(a.this.context, a.this.context.getString(R.string.t8), inflate, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(28026);
                        String trim = editText.getText().toString().trim();
                        if (trim != null && trim.length() > 0) {
                            a.a(a.this, trim);
                        }
                        AppMethodBeat.o(28026);
                    }
                }, null);
                editText.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(28027);
                        if (a.this.context instanceof MMActivity) {
                            ((MMActivity) a.this.context).showVKB();
                        }
                        AppMethodBeat.o(28027);
                    }
                });
                AppMethodBeat.o(28028);
            }
        });
        AppMethodBeat.o(28030);
    }

    public final void detach() {
        AppMethodBeat.i(28031);
        aw.Rg().b(30, (f) this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(28031);
    }

    private static int ajL(String str) {
        AppMethodBeat.i(28032);
        if (str == null) {
            ab.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
            AppMethodBeat.o(28032);
            return 6;
        }
        switch (d.apF(str).cAd) {
            case 2:
            case 5:
                AppMethodBeat.o(28032);
                return 6;
            case 6:
                AppMethodBeat.o(28032);
                return 5;
            default:
                AppMethodBeat.o(28032);
                return 6;
        }
    }

    public final void setContentText(String str) {
        AppMethodBeat.i(28033);
        if (bo.isNullOrNil(str)) {
            this.gKl.setVisibility(8);
            AppMethodBeat.o(28033);
            return;
        }
        this.gKl.setVisibility(0);
        this.gKl.setText(j.b(this.context, bo.nullAsNil(str), this.gKl.getTextSize()));
        AppMethodBeat.o(28033);
    }

    public final void setBtnVisibility(int i) {
        AppMethodBeat.i(28034);
        if (this.vqn != null) {
            this.vqn.setVisibility(i);
        }
        AppMethodBeat.o(28034);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(28035);
        if (mVar.getType() != 30) {
            AppMethodBeat.o(28035);
            return;
        }
        ab.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            int i3 = ((com.tencent.mm.pluginsdk.model.m) mVar).cAd;
            String str2 = ((com.tencent.mm.pluginsdk.model.m) mVar).vbn;
            ab.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + i3 + ", verifyContent = " + str2);
            ab.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + vqm.type);
            switch (vqm.type) {
                case 1:
                    bf bfVar = new bf();
                    bfVar.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOo().QV(vqm.talker);
                    bfVar.field_isSend = 1;
                    bfVar.field_content = str2;
                    bfVar.field_talker = "fmessage";
                    bfVar.field_sayhiuser = vqm.talker;
                    bfVar.field_svrid = System.currentTimeMillis();
                    bfVar.field_status = 4;
                    com.tencent.mm.bi.d.akQ().a(bfVar);
                    break;
                case 2:
                    bt btVar = new bt();
                    btVar.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOn().QV(vqm.talker);
                    btVar.field_isSend = 1;
                    btVar.field_content = str2;
                    btVar.field_talker = "fmessage";
                    btVar.field_sayhiuser = vqm.talker;
                    btVar.field_svrid = System.currentTimeMillis();
                    btVar.field_status = 4;
                    ab.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = ".concat(String.valueOf(com.tencent.mm.bi.d.akR().a(btVar))));
                    break;
                default:
                    ax axVar = new ax();
                    axVar.field_createTime = com.tencent.mm.bi.c.q(vqm.talker, 0);
                    axVar.field_isSend = 1;
                    axVar.field_msgContent = str2;
                    axVar.field_talker = vqm.talker;
                    axVar.field_type = i3 == 5 ? 2 : 3;
                    ab.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = ".concat(String.valueOf(com.tencent.mm.bi.d.akO().b(axVar))));
                    break;
            }
        }
        CharSequence str3;
        if (i == 4 && i2 == -34) {
            str3 = this.context.getString(R.string.bwe);
        } else if (i == 4 && i2 == -94) {
            str3 = this.context.getString(R.string.bwh);
        } else if (!(i == 4 && i2 == -24 && !bo.isNullOrNil(str3))) {
            str3 = this.context.getString(R.string.e3n);
        }
        Toast.makeText(this.context, str3, 1).show();
        aw.Rg().b(30, (f) this);
        AppMethodBeat.o(28035);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(28036);
        if (vqm == null) {
            ab.e("MicroMsg.FMessageItemView", "FMessage Args is null");
            AppMethodBeat.o(28036);
            return;
        }
        int i;
        ab.d("MicroMsg.FMessageItemView", "try to reply verify content");
        LinkedList linkedList = new LinkedList();
        linkedList.add(vqm.talker);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(vqm.scene));
        LinkedList linkedList3 = new LinkedList();
        linkedList3.add(vqm.vqs);
        int i2 = vqm.type;
        String str2 = vqm.talker;
        ab.d("MicroMsg.FMessageItemView", "getOpCode, type = " + i2 + ", talker = " + str2);
        switch (i2) {
            case 0:
                boolean z;
                if (str2 != null && str2.length() != 0) {
                    ax apx = com.tencent.mm.bi.d.akO().apx(str2);
                    if (apx != null) {
                        if (apx.field_type == 1 || apx.field_type == 2) {
                            z = true;
                            if (!z) {
                                i = 5;
                                break;
                            }
                        }
                    }
                    ab.e("MicroMsg.FMessageLogic", "isVerifyReceiver, lastRecvFmsg does not exist, talker = ".concat(String.valueOf(str2)));
                } else {
                    ab.e("MicroMsg.FMessageLogic", "isVerifyReceiver, invalid argument");
                }
                z = false;
                if (z) {
                }
                break;
            case 1:
                bf bfVar;
                bf[] er = com.tencent.mm.bi.d.akQ().er(str2, 1);
                if (er != null) {
                    bfVar = er[0];
                } else {
                    bfVar = null;
                }
                if (bfVar != null) {
                    i = ajL(bfVar.field_content);
                    break;
                }
                ab.e("MicroMsg.FMessageItemView", "getOpCode, last lbsMsg is null");
            case 2:
                bt btVar;
                bt[] et = com.tencent.mm.bi.d.akR().et(str2, 1);
                if (et != null) {
                    btVar = et[0];
                } else {
                    btVar = null;
                }
                if (btVar != null) {
                    i = ajL(btVar.field_content);
                    break;
                }
                ab.e("MicroMsg.FMessageItemView", "getOpCode, last shakeMsg is null");
            default:
                i = 6;
                break;
        }
        ab.d("MicroMsg.FMessageItemView", "reply, final opcode = ".concat(String.valueOf(i)));
        aw.Rg().a(30, (f) aVar);
        final m mVar = new com.tencent.mm.pluginsdk.model.m(i, linkedList, linkedList2, linkedList3, str, vqm.mGZ, null, null, "");
        aw.Rg().a(mVar, 0);
        Context context = aVar.context;
        aVar.context.getString(R.string.tz);
        aVar.tipDialog = h.b(context, aVar.context.getString(R.string.th), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(28029);
                aw.Rg().c(mVar);
                AppMethodBeat.o(28029);
            }
        });
        AppMethodBeat.o(28036);
    }
}
