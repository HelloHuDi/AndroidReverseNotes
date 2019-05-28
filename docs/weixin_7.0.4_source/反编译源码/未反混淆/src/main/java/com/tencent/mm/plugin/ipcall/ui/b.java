package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    MMActivity crP;
    String fmB;
    private av gGg;
    TextView goa;
    String nAa;
    String nAb = "";
    String nAc;
    LinkedList<crw> nAd;
    long nAe = 0;
    boolean nAf = false;
    private Runnable nAg = new Runnable() {
        public final void run() {
            AppMethodBeat.i(21969);
            if (System.currentTimeMillis() - b.this.nAe >= 500) {
                b.this.nAc = com.tencent.mm.plugin.ipcall.b.a.aE(b.this.crP, b.this.nAa + b.this.nAb);
                final c OQ = i.bHw().OQ(b.this.nAc);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(21967);
                        if (OQ == null || OQ.xDa == -1) {
                            b.this.goa.setText("");
                            AppMethodBeat.o(21967);
                            return;
                        }
                        b.this.goa.setText(OQ.field_systemAddressBookUsername);
                        AppMethodBeat.o(21967);
                    }
                });
                AppMethodBeat.o(21969);
                return;
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21968);
                    b.this.goa.setText("");
                    b.this.nAc = null;
                    b.this.fmB = null;
                    AppMethodBeat.o(21968);
                }
            });
            AppMethodBeat.o(21969);
        }
    };
    private al nAh = new al("IPCallDialQueryPhoneNumber");
    boolean nAi = false;
    private TextWatcher nAj = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int measureText;
            AppMethodBeat.i(21970);
            if (b.this.nzW.getLayoutParams() != null) {
                int i4;
                TextPaint paint = b.this.nzS.getPaint();
                if ("+".equals(b.this.nzS.getText().toString())) {
                    measureText = (int) paint.measureText(b.this.nzS.getText().toString());
                    b.this.nzU.setVisibility(8);
                    b.this.nzX.setVisibility(8);
                    i4 = measureText;
                } else {
                    measureText = (int) paint.measureText(b.this.nzS.getText() + "+");
                    b.this.nzU.setVisibility(0);
                    b.this.nzX.setVisibility(0);
                    i4 = measureText;
                }
                LayoutParams layoutParams = (LayoutParams) b.this.nzW.getLayoutParams();
                layoutParams.width = i4;
                b.this.nzW.setLayoutParams(layoutParams);
            }
            String replace = b.this.nzS.getText().toString().replace("+", "");
            if (com.tencent.mm.plugin.ipcall.b.a.Pt(replace)) {
                b.this.nzX.setText(com.tencent.mm.plugin.ipcall.b.a.Pq(replace));
                if (b.this.nAd != null && b.this.nAd.size() > 0) {
                    String Pr = com.tencent.mm.plugin.ipcall.b.a.Pr(replace);
                    Iterator it = b.this.nAd.iterator();
                    while (it.hasNext()) {
                        crw crw = (crw) it.next();
                        if (crw != null && crw.guW.equals(Pr)) {
                            measureText = 1;
                            break;
                        }
                    }
                    measureText = 0;
                }
                measureText = 0;
            } else {
                b.this.nzX.setText(b.this.crP.getString(R.string.cgi));
                measureText = 0;
            }
            if (measureText != 0) {
                b.this.nzY.setVisibility(0);
            } else {
                b.this.nzY.setVisibility(8);
            }
            if (b.this.nzQ != null) {
                b.this.nzQ.Pa(replace);
            }
            AppMethodBeat.o(21970);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(21971);
            String replace = b.this.nzS.getText().toString().replace("+", "");
            if (replace.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO) || replace.startsWith("*") || replace.startsWith("#")) {
                b.this.nzS.setText("+");
                b.this.nAa = "+";
            }
            AppMethodBeat.o(21971);
        }
    };
    String nAk = "";
    a nzQ;
    private DialPad nzR;
    TextView nzS;
    EditText nzT;
    View nzU;
    private ImageButton nzV;
    View nzW;
    TextView nzX;
    TextView nzY;
    String nzZ;

    public interface a {
        void Pa(String str);

        void Pb(String str);

        void p(String str, String str2, String str3, String str4);
    }

    public b(MMActivity mMActivity, EditText editText, TextView textView, View view, DialPad dialPad, ImageButton imageButton, TextView textView2, View view2, TextView textView3, TextView textView4) {
        AppMethodBeat.i(21980);
        this.crP = mMActivity;
        this.nzT = editText;
        this.nzS = textView;
        this.nzU = view;
        this.nzR = dialPad;
        this.nzV = imageButton;
        this.goa = textView2;
        this.nzW = view2;
        this.nzX = textView3;
        this.nzY = textView4;
        this.gGg = new av();
        this.nAa = com.tencent.mm.plugin.ipcall.b.c.bIR();
        String string = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
        if (bo.isNullOrNil(string)) {
            string = com.tencent.mm.plugin.ipcall.b.a.Pq(com.tencent.mm.plugin.ipcall.b.a.bIN());
        }
        this.nzZ = string;
        this.nzS.addTextChangedListener(this.nAj);
        this.nzS.setText("+" + this.nAa);
        this.nzR.setDialButtonClickListener(new com.tencent.mm.plugin.ipcall.ui.DialPad.a() {
            public final void OX(String str) {
                AppMethodBeat.i(21972);
                b.this.nAb = b.this.nzT.getText().toString();
                if (b.this.nAf) {
                    b.this.nAa += str;
                    b.this.nzS.setText(b.this.nAa);
                    if (com.tencent.mm.plugin.ipcall.b.a.Pt(b.this.nAa.replace("+", "")) || b.this.nAa.replace("+", "").length() >= 4) {
                        h.pYm.e(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                        b.this.nAf = false;
                        b.this.nzZ = com.tencent.mm.plugin.ipcall.b.a.Pq(b.this.nAa.replace("+", ""));
                        b.this.nAb = b.eL(b.this.nAa.replace("+", ""), b.this.nAb);
                        b.this.cq(b.this.nAb, -1);
                        AppMethodBeat.o(21972);
                        return;
                    }
                }
                String replace = b.this.nzS.getText().toString().replace("+", "");
                if (b.this.nAi) {
                    StringBuffer stringBuffer = new StringBuffer(b.this.nAb);
                    stringBuffer.insert(b.this.nzT.getSelectionStart(), str);
                    b.this.nAb = stringBuffer.toString();
                } else {
                    b.this.nAb += str;
                }
                if (b.this.nAb.equals("00")) {
                    b.this.nzS.setText("+");
                    b.this.nAf = true;
                    b.this.nAa = "+";
                    b.this.nAb = "";
                }
                if (com.tencent.mm.plugin.ipcall.b.a.Pt(b.this.nAa.replace("+", "") + b.this.nAb)) {
                    b.this.nzS.setText("+" + b.this.nAa.replace("+", "") + b.this.nAb);
                    b.this.nzZ = com.tencent.mm.plugin.ipcall.b.a.Pq(b.this.nAa.replace("+", ""));
                    b.this.nAf = false;
                    b.this.nAa = b.this.nAa.replace("+", "") + b.this.nAb;
                    b.this.nAb = "";
                }
                String str2 = b.this.nAb;
                b.this.nAb = b.eL(replace, b.this.nAb);
                if (!b.this.nAi) {
                    b.this.cq(b.this.nAb, -1);
                } else if (str2.length() < b.this.nAb.length()) {
                    b.this.cq(b.this.nAb, b.this.nzT.getSelectionEnd() + 2);
                } else if (str2.length() == b.this.nAb.length()) {
                    b.this.cq(b.this.nAb, b.this.nzT.getSelectionEnd() + 1);
                } else if (str2.length() > b.this.nAb.length()) {
                    b.this.cq(b.this.nAb, (b.this.nzT.getSelectionEnd() + 1) - (str2.length() - b.this.nAb.length()));
                }
                b.this.nAe = System.currentTimeMillis();
                if (b.this.nAb.length() > com.tencent.mm.plugin.ipcall.b.a.nGS && !bo.isNullOrNil(b.this.nAa + b.this.nAb)) {
                    b.this.bId();
                }
                AppMethodBeat.o(21972);
            }

            public final void OY(String str) {
                AppMethodBeat.i(21973);
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    b.this.nzS.setText("+");
                    b.this.nAf = true;
                    b.this.nAa = "+";
                }
                AppMethodBeat.o(21973);
            }
        });
        this.nzU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21974);
                String obj = b.this.nzT.getText().toString();
                if (bo.isNullOrNil(obj)) {
                    obj = b.this.nzS.getText().toString();
                    if (!bo.isNullOrNil(obj)) {
                        obj = obj.substring(0, obj.length() - 1);
                        if (bo.isNullOrNil(obj) || obj.equals("+")) {
                            b.this.nzS.setText("+");
                            b.this.nAa = "+";
                            b.this.nAf = true;
                        } else {
                            b.this.nzS.setText(obj);
                            b.this.nAa = obj;
                            AppMethodBeat.o(21974);
                            return;
                        }
                    }
                    AppMethodBeat.o(21974);
                    return;
                }
                int selectionStart = b.this.nzT.getSelectionStart();
                if (!b.this.nAi || selectionStart - 1 < 0) {
                    obj = obj.substring(0, obj.length() - 1);
                } else {
                    Editable text = b.this.nzT.getText();
                    text.delete(selectionStart - 1, selectionStart);
                    obj = text.toString();
                }
                if (bo.isNullOrNil(obj)) {
                    b.this.nAb = "";
                    b.this.cq("", -1);
                } else {
                    String replace = b.this.nzS.getText().toString().replace("+", "");
                    if (b.this.nAi) {
                        b.this.nAb = b.eL(replace, obj);
                        b.this.cq(b.this.nAb, (b.this.nAb.length() - obj.length()) + (selectionStart - 1));
                    } else {
                        b.this.nAb = b.eL(replace, obj);
                        b.this.cq(b.this.nAb, -1);
                    }
                    b.this.bId();
                }
                b.this.nAc = "";
                b.this.goa.setText("");
                AppMethodBeat.o(21974);
            }
        });
        this.nzU.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(21975);
                if (b.this.nAf) {
                    b.this.nAa = "+";
                    b.this.nzS.setText(b.this.nAa);
                } else {
                    b.this.goa.setText("");
                    b.this.nAb = "";
                    b.this.cq("", -1);
                }
                AppMethodBeat.o(21975);
                return true;
            }
        });
        this.nzS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21976);
                h.pYm.e(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
                String replace = b.this.nzS.getText().toString().replace("+", "");
                Intent intent = new Intent(b.this.crP, IPCallCountryCodeSelectUI.class);
                intent.putExtra("couttry_code", replace);
                intent.putExtra("CountryCodeUI_isShowCountryCode", true);
                b.this.crP.startActivityForResult(intent, 100);
                b.this.crP.overridePendingTransition(R.anim.cg, -1);
                AppMethodBeat.o(21976);
            }
        });
        this.nzV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21977);
                b bVar = b.this;
                bVar.nAa = bVar.nzS.getText().toString();
                bVar.nAb = bVar.nzT.getText().toString();
                String string;
                if (bo.isNullOrNil(bVar.nAa) || bo.isNullOrNil(bVar.nAb)) {
                    string = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
                    if (!bo.isNullOrNil(string)) {
                        bVar.nAb = b.eL(bVar.nzS.getText().toString().replace("+", ""), com.tencent.mm.plugin.ipcall.b.c.PA(string));
                        bVar.cq(bVar.nAb, -1);
                        bVar.bId();
                    }
                } else {
                    bVar.nAa = bVar.nzS.getText().toString().replace("+", "");
                    bVar.nAc = com.tencent.mm.plugin.ipcall.b.a.aE(bVar.crP, bVar.nAa + bVar.nAb);
                    bVar.fmB = com.tencent.mm.plugin.ipcall.b.a.aG(bVar.crP, bVar.nAc);
                    string = com.tencent.mm.plugin.ipcall.b.c.PA(bVar.nAb);
                    Editor edit = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                    edit.putString("IPCall_LastInputPhoneNumber", string);
                    edit.apply();
                    String charSequence = bVar.nzS.getText().toString();
                    string = bVar.nzZ;
                    if (!bo.isNullOrNil(charSequence)) {
                        if (bo.isNullOrNil(string)) {
                            string = "";
                        }
                        Editor edit2 = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                        edit2.putString("IPCall_LastInputCountryCode", charSequence.replace("+", ""));
                        edit2.putString("IPCall_LastInputCountryName", string);
                        edit2.apply();
                    }
                    if (bVar.nzQ != null) {
                        bVar.nzQ.p(bVar.nAa, com.tencent.mm.plugin.ipcall.b.c.PA(bVar.nAb), bVar.nAc, bVar.fmB);
                        AppMethodBeat.o(21977);
                        return;
                    }
                }
                AppMethodBeat.o(21977);
            }
        });
        this.nzT.setHorizontallyScrolling(true);
        this.nzT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21978);
                b.this.nzT.setCursorVisible(true);
                b.this.crP.aqX();
                b.this.nAi = true;
                AppMethodBeat.o(21978);
            }
        });
        this.nzT.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(21979);
                String PA = bo.PA(charSequence.toString());
                if (PA.contains(" ")) {
                    PA = PA.replace(" ", "");
                    b.this.nzT.setText(bo.ad(PA));
                } else if ((!b.this.nAk.equals(PA) || i3 > 0) && bo.isNullOrNil(PA)) {
                    b.this.nAk = PA;
                    b.this.nzT.setText("");
                }
                if (com.tencent.mm.plugin.ipcall.b.a.Pu(PA)) {
                    String Ps = com.tencent.mm.plugin.ipcall.b.a.Ps(PA);
                    if (!bo.isNullOrNil(Ps)) {
                        b.this.nzS.setText("+".concat(String.valueOf(Ps)));
                        b.this.nzT.setText(com.tencent.mm.plugin.ipcall.b.a.Px(PA));
                    }
                } else if (!PA.equals(b.this.nAk)) {
                    b.this.nAk = PA;
                    b.this.nzT.setText(PA);
                    if (bo.isNullOrNil(b.this.nzS.getText().toString())) {
                        b.this.nzS.setText("+" + com.tencent.mm.plugin.ipcall.b.a.bIN());
                    }
                }
                if (b.this.nzQ != null) {
                    b.this.nzQ.Pb(b.this.nzT.getText().toString());
                }
                AppMethodBeat.o(21979);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        if (d.iW(16)) {
            this.nzS.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nzT.setTypeface(Typeface.create("sans-serif-light", 0));
            this.goa.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        AppMethodBeat.o(21980);
    }

    public final void OZ(String str) {
        AppMethodBeat.i(21981);
        this.nAa = str;
        if (this.nzS != null) {
            this.nzS.setText("+".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(21981);
    }

    public final void ae(LinkedList<crw> linkedList) {
        int i;
        AppMethodBeat.i(21982);
        this.nAd = linkedList;
        String replace = this.nzS.getText().toString().replace("+", "");
        if (com.tencent.mm.plugin.ipcall.b.a.Pt(replace) && this.nAd != null && this.nAd.size() > 0) {
            String Pr = com.tencent.mm.plugin.ipcall.b.a.Pr(replace);
            Iterator it = this.nAd.iterator();
            while (it.hasNext()) {
                crw crw = (crw) it.next();
                if (crw != null && crw.guW.equals(Pr)) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i != 0) {
            this.nzY.setVisibility(0);
            AppMethodBeat.o(21982);
            return;
        }
        this.nzY.setVisibility(8);
        AppMethodBeat.o(21982);
    }

    static String eL(String str, String str2) {
        AppMethodBeat.i(21983);
        String formatNumber = av.formatNumber(str, com.tencent.mm.plugin.ipcall.b.c.PA(str2));
        if (bo.isNullOrNil(formatNumber)) {
            AppMethodBeat.o(21983);
            return str2;
        }
        AppMethodBeat.o(21983);
        return formatNumber;
    }

    public final void cq(String str, int i) {
        AppMethodBeat.i(21984);
        this.nzT.setText(str);
        if (!bo.isNullOrNil(str)) {
            if (i != -1) {
                if (this.nAi) {
                    if (i > 0 && i <= this.nzT.getText().length()) {
                        this.nzT.setSelection(i);
                    }
                }
            }
            this.nzT.setSelection(this.nzT.getText().length());
        }
        this.nAb = str;
        AppMethodBeat.o(21984);
    }

    public final void bId() {
        AppMethodBeat.i(21985);
        this.nAh.doN().removeCallbacks(this.nAg);
        this.nAh.m(this.nAg, 500);
        AppMethodBeat.o(21985);
    }
}
