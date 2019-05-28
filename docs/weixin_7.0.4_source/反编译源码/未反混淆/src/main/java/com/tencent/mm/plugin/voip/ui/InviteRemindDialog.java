package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.h;
import com.tencent.mm.plugin.voip.model.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class InviteRemindDialog extends MMBaseActivity {
    private TextView gsf;
    private TextView sVO;
    private String talker = "";
    private int type = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(4772);
        super.onCreate(bundle);
        setContentView(R.layout.agu);
        this.gsf = (TextView) findViewById(R.id.c6d);
        this.sVO = (TextView) findViewById(R.id.c6e);
        this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
        this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
        if (this.type == 0) {
            this.gsf.setText(getString(R.string.f6w));
            this.sVO.setText(getString(R.string.f5z));
        } else if (this.type == 1) {
            this.gsf.setText(getString(R.string.f7r));
            this.sVO.setText(getString(R.string.f7i));
        }
        findViewById(R.id.b00).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(4770);
                if (InviteRemindDialog.this.talker != null) {
                    try {
                        Map abV = a.abV((String) g.RP().Ry().get(77829, null));
                        a aVar;
                        if (abV != null) {
                            if (abV != null && abV.size() > 0) {
                                if (abV.containsKey(InviteRemindDialog.this.talker)) {
                                    aVar = (a) abV.get(InviteRemindDialog.this.talker);
                                    aVar.fMk++;
                                    abV.put(InviteRemindDialog.this.talker, aVar);
                                } else {
                                    aVar = new a();
                                    aVar.fMk++;
                                    abV.put(InviteRemindDialog.this.talker, aVar);
                                }
                            }
                            g.RP().Ry().set(77829, a.ah(abV));
                            for (Entry value : abV.entrySet()) {
                                aVar = (a) value.getValue();
                                ab.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.fMk);
                            }
                        } else {
                            HashMap hashMap = new HashMap();
                            a aVar2 = new a();
                            aVar2.fMk++;
                            hashMap.put(InviteRemindDialog.this.talker, aVar2);
                            g.RP().Ry().set(77829, a.ah(hashMap));
                            for (Entry value2 : hashMap.entrySet()) {
                                aVar = (a) value2.getValue();
                                ab.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.fMk);
                            }
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MMInviteRemindDialog", e, "", new Object[0]);
                    }
                }
                String string = InviteRemindDialog.this.type == 0 ? InviteRemindDialog.this.getString(R.string.f5y) : InviteRemindDialog.this.type == 1 ? InviteRemindDialog.this.getString(R.string.f7h) : null;
                g.Rg().a(new h(InviteRemindDialog.this.talker, string, t.nK(InviteRemindDialog.this.talker)), 0);
                Intent intent = new Intent();
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", InviteRemindDialog.this.talker);
                c.gkE.d(intent, InviteRemindDialog.this);
                InviteRemindDialog.this.finish();
                AppMethodBeat.o(4770);
            }
        });
        findViewById(R.id.azz).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(4771);
                InviteRemindDialog.this.finish();
                AppMethodBeat.o(4771);
            }
        });
        AppMethodBeat.o(4772);
    }

    public void finish() {
        AppMethodBeat.i(4773);
        super.finish();
        AppMethodBeat.o(4773);
    }

    public static void p(Context context, String str, int i) {
        AppMethodBeat.i(4774);
        Intent intent = new Intent(context, InviteRemindDialog.class);
        intent.putExtra("InviteRemindDialog_User", str);
        intent.putExtra("InviteRemindDialog_Type", i);
        context.startActivity(intent);
        AppMethodBeat.o(4774);
    }
}
