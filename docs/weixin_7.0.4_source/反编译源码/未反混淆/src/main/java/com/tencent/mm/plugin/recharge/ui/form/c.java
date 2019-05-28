package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public boolean a(MallFormView mallFormView) {
            return true;
        }

        public boolean cev() {
            return false;
        }

        public String VG(String str) {
            return null;
        }
    }

    public static class b {
        public List<String[]> pGw;
        public com.tencent.mm.plugin.recharge.model.a pGx = null;
        public MallFormView pIg = null;
        public d pIh;
        boolean pIi = false;

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$5 */
        public class AnonymousClass5 implements OnClickListener {
            final /* synthetic */ InstantAutoCompleteTextView pIk;

            public AnonymousClass5(InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.pIk = instantAutoCompleteTextView;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(44371);
                this.pIk.requestFocus();
                AppMethodBeat.o(44371);
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$4 */
        public class AnonymousClass4 implements OnFocusChangeListener {
            final /* synthetic */ InstantAutoCompleteTextView pIk;

            public AnonymousClass4(InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.pIk = instantAutoCompleteTextView;
            }

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(44370);
                if (z) {
                    this.pIk.setHintTextColor(view.getContext().getResources().getColor(R.color.l5));
                    if (b.this.pGx != null && b.this.pGx.cvp == 2 && !b.this.pIi) {
                        ab.d(c.TAG, "clear input");
                        b.this.pIg.cey();
                        b.this.pGx = null;
                    } else if (b.this.pIi) {
                        b.this.pIi = false;
                    }
                    if (bo.isNullOrNil(this.pIk.getText().toString())) {
                        this.pIk.showDropDown();
                    }
                }
                AppMethodBeat.o(44370);
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$3 */
        public class AnonymousClass3 implements OnItemClickListener {
            final /* synthetic */ InstantAutoCompleteTextView pIk;

            public AnonymousClass3(InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.pIk = instantAutoCompleteTextView;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(44369);
                b.this.pGx = b.this.pIh.BA(i);
                if (b.this.pGx != null) {
                    ab.i(c.TAG, "onItemClick record.record " + b.this.pGx.pFM + ", record.name " + b.this.pGx.name);
                    b.this.pIi = true;
                    b.this.setInput(b.this.pGx);
                } else {
                    ab.w(c.TAG, "record is null");
                }
                this.pIk.dismissDropDown();
                AppMethodBeat.o(44369);
            }
        }

        public b(MallFormView mallFormView) {
            this.pIg = mallFormView;
        }

        public final void setInput(com.tencent.mm.plugin.recharge.model.a aVar) {
            AppMethodBeat.i(44372);
            this.pGx = aVar;
            if (aVar != null) {
                if (bo.isNullOrNil(this.pIg.getText()) || !this.pIg.getText().equals(aVar.pFM)) {
                    this.pIg.getContentEditText().setText(com.tencent.mm.plugin.recharge.model.b.VB(aVar.pFM));
                }
                this.pIg.getContentEditText().setSelection(this.pIg.getContentEditText().getText().length());
                ab.d(c.TAG, "editTv.setText %s, name: %s, location: %s, type: %s", aVar.pFM, aVar.name, aVar.pFN, Integer.valueOf(aVar.cvp));
                Context context = this.pIg.getContext();
                if (this.pGx.cvp == 3) {
                    this.pIg.getTipsTv().setText(this.pGx.name);
                    this.pIg.getTipsTv().setTextColor(context.getResources().getColor(R.color.xp));
                    AppMethodBeat.o(44372);
                    return;
                } else if (this.pGx.cvp == 1) {
                    CharSequence string;
                    if (bo.isNullOrNil(this.pGx.name)) {
                        string = context.getString(R.string.fr7);
                        if (!bo.isNullOrNil(this.pGx.pFN)) {
                            string = string + context.getString(R.string.fqx, new Object[]{this.pGx.pFN});
                        }
                        this.pIg.getTipsTv().setText(string);
                        this.pIg.getTipsTv().setTextColor(context.getResources().getColor(R.color.xh));
                        AppMethodBeat.o(44372);
                        return;
                    }
                    string = this.pGx.name;
                    if (!bo.isNullOrNil(this.pGx.pFN)) {
                        string = string + context.getString(R.string.fqx, new Object[]{this.pGx.pFN});
                    }
                    this.pIg.getTipsTv().setText(string);
                    this.pIg.getTipsTv().setTextColor(context.getResources().getColor(R.color.w4));
                    AppMethodBeat.o(44372);
                    return;
                } else if (this.pGx.cvp != 2) {
                    if (this.pGx.cvp == 0) {
                        if (bo.isNullOrNil(this.pGx.pFN)) {
                            if (bo.isNullOrNil(this.pGx.name)) {
                                this.pIg.getTipsTv().setText("");
                                this.pIg.getTipsTv().setTextColor(context.getResources().getColor(R.color.w4));
                            } else {
                                this.pIg.getTipsTv().setText(this.pGx.name);
                                this.pIg.getTipsTv().setTextColor(context.getResources().getColor(R.color.xh));
                                AppMethodBeat.o(44372);
                                return;
                            }
                        } else if (bo.isNullOrNil(this.pGx.name)) {
                            this.pIg.getTipsTv().setText(this.pGx.pFN);
                            this.pIg.getTipsTv().setTextColor(context.getResources().getColor(R.color.w4));
                            AppMethodBeat.o(44372);
                            return;
                        } else {
                            this.pIg.getTipsTv().setText(this.pGx.name + context.getString(R.string.fqx, new Object[]{this.pGx.pFN}));
                            this.pIg.getTipsTv().setTextColor(context.getResources().getColor(R.color.xh));
                            AppMethodBeat.o(44372);
                            return;
                        }
                    }
                    AppMethodBeat.o(44372);
                    return;
                } else if (bo.isNullOrNil(this.pGx.pFN)) {
                    this.pIg.getTipsTv().setText("");
                    this.pIg.getTipsTv().setTextColor(context.getResources().getColor(R.color.xh));
                    AppMethodBeat.o(44372);
                    return;
                } else {
                    this.pIg.getTipsTv().setText(this.pGx.pFN);
                    this.pIg.getTipsTv().setTextColor(context.getResources().getColor(R.color.w4));
                    AppMethodBeat.o(44372);
                    return;
                }
            }
            this.pIg.getContentEditText().setText("");
            ab.d(c.TAG, "editTv.setText null");
            this.pIg.getTipsTv().setText("");
            AppMethodBeat.o(44372);
        }

        public final void kd(boolean z) {
            List arrayList;
            AppMethodBeat.i(44373);
            ab.d(c.TAG, "needSetInput: %s", Boolean.valueOf(z));
            List ceb = com.tencent.mm.plugin.recharge.a.a.cea().ceb();
            com.tencent.mm.plugin.recharge.model.a cec;
            if (ceb == null) {
                arrayList = new ArrayList();
                cec = com.tencent.mm.plugin.recharge.a.a.cec();
                if (cec != null) {
                    arrayList.add(cec);
                    com.tencent.mm.plugin.recharge.a.a.cea().a(cec);
                }
            } else {
                String str = (String) g.RP().Ry().get(6, null);
                for (int i = 0; i < ceb.size(); i++) {
                    cec = (com.tencent.mm.plugin.recharge.model.a) ceb.get(i);
                    if (bo.isNullOrNil(cec.pFM) || !cec.pFM.equals(str)) {
                        if (!(bo.isNullOrNil(cec.pFM) || !bo.isNullOrNil(cec.name) || this.pGw == null)) {
                            for (String[] strArr : this.pGw) {
                                if (cec.pFM.equals(com.tencent.mm.plugin.recharge.model.b.ws(strArr[2]))) {
                                    cec.name = strArr[1];
                                    ab.i(c.TAG, "add name: %s", strArr[1]);
                                    break;
                                }
                            }
                        }
                    } else if (bo.isNullOrNil(cec.name) || !cec.name.equals(this.pIg.getContext().getString(R.string.fr5))) {
                        cec.name = this.pIg.getContext().getString(R.string.fr5);
                    } else {
                    }
                    com.tencent.mm.plugin.recharge.a.a.cea().cK(ceb);
                }
                arrayList = ceb;
            }
            this.pIh.cK(arrayList);
            if (arrayList != null && arrayList.size() > 0 && z) {
                this.pGx = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                setInput(this.pGx);
            }
            AppMethodBeat.o(44373);
        }
    }

    public static void b(MallFormView mallFormView) {
        AppMethodBeat.i(44374);
        if (mallFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(44374);
            return;
        }
        mallFormView.setLogicDelegate(new a() {
            public final boolean a(MallFormView mallFormView) {
                AppMethodBeat.i(44366);
                boolean isGlobalPhoneNumber = PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.ws(mallFormView.getText().toString()));
                AppMethodBeat.o(44366);
                return isGlobalPhoneNumber;
            }

            public final boolean cev() {
                return true;
            }

            public final String VG(String str) {
                AppMethodBeat.i(44367);
                String str2;
                if (str == null) {
                    str2 = "";
                    AppMethodBeat.o(44367);
                    return str2;
                }
                str2 = str.replaceAll(" ", "");
                AppMethodBeat.o(44367);
                return str2;
            }
        });
        AppMethodBeat.o(44374);
    }
}
