package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;
import java.util.LinkedList;
import junit.framework.Assert;

public final class s implements f {
    String content = "";
    Context context;
    View gub;
    c gud = null;
    LinkedList<Integer> pAT;
    TextView pCu;
    EditText pwu;
    p tipDialog;
    private LinkedList<String> vjJ = new LinkedList();
    String vjK;
    a vlk;
    LinkedList<String> vll;
    boolean vlm = true;
    private boolean vln = false;

    public interface a {
        void bD(boolean z);
    }

    public s(Context context, a aVar) {
        AppMethodBeat.i(79794);
        this.context = context;
        this.vlk = aVar;
        AppMethodBeat.o(79794);
    }

    /* Access modifiers changed, original: final */
    public final void onStart() {
        AppMethodBeat.i(79795);
        g.RO().eJo.a(30, (f) this);
        g.RO().eJo.a(243, (f) this);
        AppMethodBeat.o(79795);
    }

    /* Access modifiers changed, original: final */
    public final void onStop() {
        AppMethodBeat.i(79796);
        g.RO().eJo.b(30, (f) this);
        g.RO().eJo.b(243, (f) this);
        if (this.gud != null) {
            this.gud.dismiss();
            this.gud = null;
        }
        AppMethodBeat.o(79796);
    }

    public final void g(LinkedList<String> linkedList, LinkedList<Integer> linkedList2) {
        AppMethodBeat.i(79797);
        a(linkedList, linkedList2, new LinkedList());
        AppMethodBeat.o(79797);
    }

    public final void a(LinkedList<String> linkedList, LinkedList<Integer> linkedList2, LinkedList<String> linkedList3) {
        boolean z;
        AppMethodBeat.i(79798);
        Assert.assertTrue(linkedList.size() > 0);
        if (linkedList2.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        onStart();
        this.vll = linkedList;
        this.pAT = linkedList2;
        this.vjJ = linkedList3;
        this.gub = View.inflate(this.context, R.layout.arb, null);
        String str = "MicroMsg.SendVerifyRequest";
        String str2 = "verifyTip is null: %b, length : %d, value : [%s]";
        Object[] objArr = new Object[3];
        if (this.vjK == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(this.vjK == null ? 0 : this.vjK.length());
        objArr[2] = this.vjK;
        ab.i(str, str2, objArr);
        if (!bo.isNullOrNil(this.vjK)) {
            ((TextView) this.gub.findViewById(R.id.e91)).setText(this.vjK);
        }
        this.pwu = (EditText) this.gub.findViewById(R.id.e92);
        this.pCu = (TextView) this.gub.findViewById(R.id.b5v);
        this.pCu.setVisibility(0);
        this.pwu.setText(null);
        this.pCu.setText("50");
        this.pwu.setFilters(com.tencent.mm.pluginsdk.ui.tools.g.vuR);
        this.pwu.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(79788);
                int length = 50 - editable.length();
                if (length < 0) {
                    length = 0;
                }
                if (s.this.pCu != null) {
                    s.this.pCu.setText(String.valueOf(length));
                }
                AppMethodBeat.o(79788);
            }
        });
        this.gud = h.a(this.context, this.context.getString(R.string.e3t), this.gub, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(79790);
                if (s.this.gud != null) {
                    s.this.gud.dismiss();
                    s.this.gud = null;
                }
                new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(79789);
                        if (s.this.gub != null) {
                            s sVar = s.this;
                            String trim = s.this.pwu.getText().toString().trim();
                            Context context = sVar.context;
                            sVar.context.getString(R.string.tz);
                            sVar.tipDialog = h.b(context, sVar.context.getString(R.string.e3p), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(79793);
                                    s.this.onStop();
                                    if (s.this.vlk != null) {
                                        s.this.vlk.bD(false);
                                    }
                                    AppMethodBeat.o(79793);
                                }
                            });
                            sVar.content = trim;
                            if (sVar.vll.size() == 1 && ad.aox((String) sVar.vll.getFirst())) {
                                sVar.djH();
                            } else {
                                g.RO().eJo.a(new m(2, sVar.vll, sVar.pAT, trim, ""), 0);
                            }
                        }
                        AppMethodBeat.o(79789);
                        return false;
                    }
                }, false).ae(500, 500);
                AppMethodBeat.o(79790);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(79791);
                if (s.this.gud != null) {
                    s.this.gud.dismiss();
                    s.this.gud = null;
                }
                s.this.onStop();
                if (s.this.vlk != null) {
                    s.this.vlk.bD(false);
                }
                AppMethodBeat.o(79791);
            }
        });
        if (this.gud == null) {
            onStop();
        }
        this.pwu.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(79792);
                if (s.this.context instanceof MMActivity) {
                    ((MMActivity) s.this.context).showVKB();
                }
                AppMethodBeat.o(79792);
            }
        });
        AppMethodBeat.o(79798);
    }

    /* Access modifiers changed, original: final */
    public final void djH() {
        AppMethodBeat.i(79799);
        if (this.vjJ.isEmpty()) {
            this.vln = true;
            g.RO().eJo.a(881, (f) this);
            g.RO().eJo.a(new com.tencent.mm.openim.b.h((String) this.vll.getFirst(), "", ""), 0);
            AppMethodBeat.o(79799);
            return;
        }
        g.RO().eJo.a(new o((String) this.vll.getFirst(), this.content, (String) this.vjJ.getFirst()), 0);
        AppMethodBeat.o(79799);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(79800);
        if (mVar.getType() == 881) {
            g.RO().eJo.b(881, (f) this);
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.context, this.context.getString(R.string.e3n), 1).show();
            } else if (this.vln) {
                g.RO().eJo.a(new o((String) this.vll.getFirst(), this.content, ((com.tencent.mm.openim.b.h) mVar).gfb.vEP), 0);
            }
            this.vln = false;
            AppMethodBeat.o(79800);
        } else if (mVar.getType() == 30 || mVar.getType() == 243) {
            ab.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            onStop();
            if (i == 0 && i2 == 0) {
                if (this.vlm) {
                    h.bQ(this.context, this.context.getString(R.string.e3o));
                }
                this.vlk.bD(true);
                AppMethodBeat.o(79800);
                return;
            }
            CharSequence str2;
            if (i == 4 && i2 == -34) {
                str2 = this.context.getString(R.string.bwe);
            } else if (i == 4 && i2 == -94) {
                str2 = this.context.getString(R.string.bwh);
            } else if (!(i == 4 && i2 == -24 && !bo.isNullOrNil(str2)) && (i != 4 || bo.isNullOrNil(str2))) {
                str2 = this.context.getString(R.string.e3n);
            }
            if (this.vlm) {
                Toast.makeText(this.context, str2, 1).show();
            }
            this.vlk.bD(false);
            AppMethodBeat.o(79800);
        } else {
            ab.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + mVar.getType());
            AppMethodBeat.o(79800);
        }
    }
}
