package com.tencent.p177mm.plugin.ipcall.p442ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.plugin.ipcall.p442ui.DialPad.C34384a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.crw;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.b */
public final class C12313b {
    MMActivity crP;
    String fmB;
    private C5025av gGg;
    TextView goa;
    String nAa;
    String nAb = "";
    String nAc;
    LinkedList<crw> nAd;
    long nAe = 0;
    boolean nAf = false;
    private Runnable nAg = new C123161();
    private C5004al nAh = new C5004al("IPCallDialQueryPhoneNumber");
    boolean nAi = false;
    private TextWatcher nAj = new C123142();
    String nAk = "";
    C12323a nzQ;
    private DialPad nzR;
    TextView nzS;
    EditText nzT;
    View nzU;
    private ImageButton nzV;
    View nzW;
    TextView nzX;
    TextView nzY;
    String nzZ;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$8 */
    class C33248 implements OnClickListener {
        C33248() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21978);
            C12313b.this.nzT.setCursorVisible(true);
            C12313b.this.crP.aqX();
            C12313b.this.nAi = true;
            AppMethodBeat.m2505o(21978);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$2 */
    class C123142 implements TextWatcher {
        C123142() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int measureText;
            AppMethodBeat.m2504i(21970);
            if (C12313b.this.nzW.getLayoutParams() != null) {
                int i4;
                TextPaint paint = C12313b.this.nzS.getPaint();
                if ("+".equals(C12313b.this.nzS.getText().toString())) {
                    measureText = (int) paint.measureText(C12313b.this.nzS.getText().toString());
                    C12313b.this.nzU.setVisibility(8);
                    C12313b.this.nzX.setVisibility(8);
                    i4 = measureText;
                } else {
                    measureText = (int) paint.measureText(C12313b.this.nzS.getText() + "+");
                    C12313b.this.nzU.setVisibility(0);
                    C12313b.this.nzX.setVisibility(0);
                    i4 = measureText;
                }
                LayoutParams layoutParams = (LayoutParams) C12313b.this.nzW.getLayoutParams();
                layoutParams.width = i4;
                C12313b.this.nzW.setLayoutParams(layoutParams);
            }
            String replace = C12313b.this.nzS.getText().toString().replace("+", "");
            if (C46041a.m85634Pt(replace)) {
                C12313b.this.nzX.setText(C46041a.m85631Pq(replace));
                if (C12313b.this.nAd != null && C12313b.this.nAd.size() > 0) {
                    String Pr = C46041a.m85632Pr(replace);
                    Iterator it = C12313b.this.nAd.iterator();
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
                C12313b.this.nzX.setText(C12313b.this.crP.getString(C25738R.string.cgi));
                measureText = 0;
            }
            if (measureText != 0) {
                C12313b.this.nzY.setVisibility(0);
            } else {
                C12313b.this.nzY.setVisibility(8);
            }
            if (C12313b.this.nzQ != null) {
                C12313b.this.nzQ.mo24182Pa(replace);
            }
            AppMethodBeat.m2505o(21970);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(21971);
            String replace = C12313b.this.nzS.getText().toString().replace("+", "");
            if (replace.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO) || replace.startsWith("*") || replace.startsWith("#")) {
                C12313b.this.nzS.setText("+");
                C12313b.this.nAa = "+";
            }
            AppMethodBeat.m2505o(21971);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$9 */
    class C123159 implements TextWatcher {
        C123159() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(21979);
            String PA = C5046bo.m7509PA(charSequence.toString());
            if (PA.contains(" ")) {
                PA = PA.replace(" ", "");
                C12313b.this.nzT.setText(C5046bo.m7520ad(PA));
            } else if ((!C12313b.this.nAk.equals(PA) || i3 > 0) && C5046bo.isNullOrNil(PA)) {
                C12313b.this.nAk = PA;
                C12313b.this.nzT.setText("");
            }
            if (C46041a.m85635Pu(PA)) {
                String Ps = C46041a.m85633Ps(PA);
                if (!C5046bo.isNullOrNil(Ps)) {
                    C12313b.this.nzS.setText("+".concat(String.valueOf(Ps)));
                    C12313b.this.nzT.setText(C46041a.m85638Px(PA));
                }
            } else if (!PA.equals(C12313b.this.nAk)) {
                C12313b.this.nAk = PA;
                C12313b.this.nzT.setText(PA);
                if (C5046bo.isNullOrNil(C12313b.this.nzS.getText().toString())) {
                    C12313b.this.nzS.setText("+" + C46041a.bIN());
                }
            }
            if (C12313b.this.nzQ != null) {
                C12313b.this.nzQ.mo24183Pb(C12313b.this.nzT.getText().toString());
            }
            AppMethodBeat.m2505o(21979);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$1 */
    class C123161 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$1$2 */
        class C123182 implements Runnable {
            C123182() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21968);
                C12313b.this.goa.setText("");
                C12313b.this.nAc = null;
                C12313b.this.fmB = null;
                AppMethodBeat.m2505o(21968);
            }
        }

        C123161() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21969);
            if (System.currentTimeMillis() - C12313b.this.nAe >= 500) {
                C12313b.this.nAc = C46041a.m85640aE(C12313b.this.crP, C12313b.this.nAa + C12313b.this.nAb);
                final C21083c OQ = C21088i.bHw().mo36404OQ(C12313b.this.nAc);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(21967);
                        if (OQ == null || OQ.xDa == -1) {
                            C12313b.this.goa.setText("");
                            AppMethodBeat.m2505o(21967);
                            return;
                        }
                        C12313b.this.goa.setText(OQ.field_systemAddressBookUsername);
                        AppMethodBeat.m2505o(21967);
                    }
                });
                AppMethodBeat.m2505o(21969);
                return;
            }
            C5004al.m7441d(new C123182());
            AppMethodBeat.m2505o(21969);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$3 */
    class C123193 implements C34384a {
        C123193() {
        }

        /* renamed from: OX */
        public final void mo24177OX(String str) {
            AppMethodBeat.m2504i(21972);
            C12313b.this.nAb = C12313b.this.nzT.getText().toString();
            if (C12313b.this.nAf) {
                C12313b.this.nAa += str;
                C12313b.this.nzS.setText(C12313b.this.nAa);
                if (C46041a.m85634Pt(C12313b.this.nAa.replace("+", "")) || C12313b.this.nAa.replace("+", "").length() >= 4) {
                    C7060h.pYm.mo8381e(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                    C12313b.this.nAf = false;
                    C12313b.this.nzZ = C46041a.m85631Pq(C12313b.this.nAa.replace("+", ""));
                    C12313b.this.nAb = C12313b.m20238eL(C12313b.this.nAa.replace("+", ""), C12313b.this.nAb);
                    C12313b.this.mo24167cq(C12313b.this.nAb, -1);
                    AppMethodBeat.m2505o(21972);
                    return;
                }
            }
            String replace = C12313b.this.nzS.getText().toString().replace("+", "");
            if (C12313b.this.nAi) {
                StringBuffer stringBuffer = new StringBuffer(C12313b.this.nAb);
                stringBuffer.insert(C12313b.this.nzT.getSelectionStart(), str);
                C12313b.this.nAb = stringBuffer.toString();
            } else {
                C12313b.this.nAb += str;
            }
            if (C12313b.this.nAb.equals("00")) {
                C12313b.this.nzS.setText("+");
                C12313b.this.nAf = true;
                C12313b.this.nAa = "+";
                C12313b.this.nAb = "";
            }
            if (C46041a.m85634Pt(C12313b.this.nAa.replace("+", "") + C12313b.this.nAb)) {
                C12313b.this.nzS.setText("+" + C12313b.this.nAa.replace("+", "") + C12313b.this.nAb);
                C12313b.this.nzZ = C46041a.m85631Pq(C12313b.this.nAa.replace("+", ""));
                C12313b.this.nAf = false;
                C12313b.this.nAa = C12313b.this.nAa.replace("+", "") + C12313b.this.nAb;
                C12313b.this.nAb = "";
            }
            String str2 = C12313b.this.nAb;
            C12313b.this.nAb = C12313b.m20238eL(replace, C12313b.this.nAb);
            if (!C12313b.this.nAi) {
                C12313b.this.mo24167cq(C12313b.this.nAb, -1);
            } else if (str2.length() < C12313b.this.nAb.length()) {
                C12313b.this.mo24167cq(C12313b.this.nAb, C12313b.this.nzT.getSelectionEnd() + 2);
            } else if (str2.length() == C12313b.this.nAb.length()) {
                C12313b.this.mo24167cq(C12313b.this.nAb, C12313b.this.nzT.getSelectionEnd() + 1);
            } else if (str2.length() > C12313b.this.nAb.length()) {
                C12313b.this.mo24167cq(C12313b.this.nAb, (C12313b.this.nzT.getSelectionEnd() + 1) - (str2.length() - C12313b.this.nAb.length()));
            }
            C12313b.this.nAe = System.currentTimeMillis();
            if (C12313b.this.nAb.length() > C46041a.nGS && !C5046bo.isNullOrNil(C12313b.this.nAa + C12313b.this.nAb)) {
                C12313b.this.bId();
            }
            AppMethodBeat.m2505o(21972);
        }

        /* renamed from: OY */
        public final void mo24178OY(String str) {
            AppMethodBeat.m2504i(21973);
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                C12313b.this.nzS.setText("+");
                C12313b.this.nAf = true;
                C12313b.this.nAa = "+";
            }
            AppMethodBeat.m2505o(21973);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$4 */
    class C123204 implements OnClickListener {
        C123204() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21974);
            String obj = C12313b.this.nzT.getText().toString();
            if (C5046bo.isNullOrNil(obj)) {
                obj = C12313b.this.nzS.getText().toString();
                if (!C5046bo.isNullOrNil(obj)) {
                    obj = obj.substring(0, obj.length() - 1);
                    if (C5046bo.isNullOrNil(obj) || obj.equals("+")) {
                        C12313b.this.nzS.setText("+");
                        C12313b.this.nAa = "+";
                        C12313b.this.nAf = true;
                    } else {
                        C12313b.this.nzS.setText(obj);
                        C12313b.this.nAa = obj;
                        AppMethodBeat.m2505o(21974);
                        return;
                    }
                }
                AppMethodBeat.m2505o(21974);
                return;
            }
            int selectionStart = C12313b.this.nzT.getSelectionStart();
            if (!C12313b.this.nAi || selectionStart - 1 < 0) {
                obj = obj.substring(0, obj.length() - 1);
            } else {
                Editable text = C12313b.this.nzT.getText();
                text.delete(selectionStart - 1, selectionStart);
                obj = text.toString();
            }
            if (C5046bo.isNullOrNil(obj)) {
                C12313b.this.nAb = "";
                C12313b.this.mo24167cq("", -1);
            } else {
                String replace = C12313b.this.nzS.getText().toString().replace("+", "");
                if (C12313b.this.nAi) {
                    C12313b.this.nAb = C12313b.m20238eL(replace, obj);
                    C12313b.this.mo24167cq(C12313b.this.nAb, (C12313b.this.nAb.length() - obj.length()) + (selectionStart - 1));
                } else {
                    C12313b.this.nAb = C12313b.m20238eL(replace, obj);
                    C12313b.this.mo24167cq(C12313b.this.nAb, -1);
                }
                C12313b.this.bId();
            }
            C12313b.this.nAc = "";
            C12313b.this.goa.setText("");
            AppMethodBeat.m2505o(21974);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$6 */
    class C123216 implements OnClickListener {
        C123216() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21976);
            C7060h.pYm.mo8381e(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
            String replace = C12313b.this.nzS.getText().toString().replace("+", "");
            Intent intent = new Intent(C12313b.this.crP, IPCallCountryCodeSelectUI.class);
            intent.putExtra("couttry_code", replace);
            intent.putExtra("CountryCodeUI_isShowCountryCode", true);
            C12313b.this.crP.startActivityForResult(intent, 100);
            C12313b.this.crP.overridePendingTransition(C25738R.anim.f8375cg, -1);
            AppMethodBeat.m2505o(21976);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$7 */
    class C123227 implements OnClickListener {
        C123227() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21977);
            C12313b c12313b = C12313b.this;
            c12313b.nAa = c12313b.nzS.getText().toString();
            c12313b.nAb = c12313b.nzT.getText().toString();
            String string;
            if (C5046bo.isNullOrNil(c12313b.nAa) || C5046bo.isNullOrNil(c12313b.nAb)) {
                string = C4996ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
                if (!C5046bo.isNullOrNil(string)) {
                    c12313b.nAb = C12313b.m20238eL(c12313b.nzS.getText().toString().replace("+", ""), C34382c.m56377PA(string));
                    c12313b.mo24167cq(c12313b.nAb, -1);
                    c12313b.bId();
                }
            } else {
                c12313b.nAa = c12313b.nzS.getText().toString().replace("+", "");
                c12313b.nAc = C46041a.m85640aE(c12313b.crP, c12313b.nAa + c12313b.nAb);
                c12313b.fmB = C46041a.m85642aG(c12313b.crP, c12313b.nAc);
                string = C34382c.m56377PA(c12313b.nAb);
                Editor edit = C4996ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                edit.putString("IPCall_LastInputPhoneNumber", string);
                edit.apply();
                String charSequence = c12313b.nzS.getText().toString();
                string = c12313b.nzZ;
                if (!C5046bo.isNullOrNil(charSequence)) {
                    if (C5046bo.isNullOrNil(string)) {
                        string = "";
                    }
                    Editor edit2 = C4996ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                    edit2.putString("IPCall_LastInputCountryCode", charSequence.replace("+", ""));
                    edit2.putString("IPCall_LastInputCountryName", string);
                    edit2.apply();
                }
                if (c12313b.nzQ != null) {
                    c12313b.nzQ.mo24184p(c12313b.nAa, C34382c.m56377PA(c12313b.nAb), c12313b.nAc, c12313b.fmB);
                    AppMethodBeat.m2505o(21977);
                    return;
                }
            }
            AppMethodBeat.m2505o(21977);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$a */
    public interface C12323a {
        /* renamed from: Pa */
        void mo24182Pa(String str);

        /* renamed from: Pb */
        void mo24183Pb(String str);

        /* renamed from: p */
        void mo24184p(String str, String str2, String str3, String str4);
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.b$5 */
    class C123245 implements OnLongClickListener {
        C123245() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(21975);
            if (C12313b.this.nAf) {
                C12313b.this.nAa = "+";
                C12313b.this.nzS.setText(C12313b.this.nAa);
            } else {
                C12313b.this.goa.setText("");
                C12313b.this.nAb = "";
                C12313b.this.mo24167cq("", -1);
            }
            AppMethodBeat.m2505o(21975);
            return true;
        }
    }

    public C12313b(MMActivity mMActivity, EditText editText, TextView textView, View view, DialPad dialPad, ImageButton imageButton, TextView textView2, View view2, TextView textView3, TextView textView4) {
        AppMethodBeat.m2504i(21980);
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
        this.gGg = new C5025av();
        this.nAa = C34382c.bIR();
        String string = C4996ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
        if (C5046bo.isNullOrNil(string)) {
            string = C46041a.m85631Pq(C46041a.bIN());
        }
        this.nzZ = string;
        this.nzS.addTextChangedListener(this.nAj);
        this.nzS.setText("+" + this.nAa);
        this.nzR.setDialButtonClickListener(new C123193());
        this.nzU.setOnClickListener(new C123204());
        this.nzU.setOnLongClickListener(new C123245());
        this.nzS.setOnClickListener(new C123216());
        this.nzV.setOnClickListener(new C123227());
        this.nzT.setHorizontallyScrolling(true);
        this.nzT.setOnClickListener(new C33248());
        this.nzT.addTextChangedListener(new C123159());
        if (C1443d.m3068iW(16)) {
            this.nzS.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nzT.setTypeface(Typeface.create("sans-serif-light", 0));
            this.goa.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        AppMethodBeat.m2505o(21980);
    }

    /* renamed from: OZ */
    public final void mo24164OZ(String str) {
        AppMethodBeat.m2504i(21981);
        this.nAa = str;
        if (this.nzS != null) {
            this.nzS.setText("+".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(21981);
    }

    /* renamed from: ae */
    public final void mo24165ae(LinkedList<crw> linkedList) {
        int i;
        AppMethodBeat.m2504i(21982);
        this.nAd = linkedList;
        String replace = this.nzS.getText().toString().replace("+", "");
        if (C46041a.m85634Pt(replace) && this.nAd != null && this.nAd.size() > 0) {
            String Pr = C46041a.m85632Pr(replace);
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
            AppMethodBeat.m2505o(21982);
            return;
        }
        this.nzY.setVisibility(8);
        AppMethodBeat.m2505o(21982);
    }

    /* renamed from: eL */
    static String m20238eL(String str, String str2) {
        AppMethodBeat.m2504i(21983);
        String formatNumber = C5025av.formatNumber(str, C34382c.m56377PA(str2));
        if (C5046bo.isNullOrNil(formatNumber)) {
            AppMethodBeat.m2505o(21983);
            return str2;
        }
        AppMethodBeat.m2505o(21983);
        return formatNumber;
    }

    /* renamed from: cq */
    public final void mo24167cq(String str, int i) {
        AppMethodBeat.m2504i(21984);
        this.nzT.setText(str);
        if (!C5046bo.isNullOrNil(str)) {
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
        AppMethodBeat.m2505o(21984);
    }

    public final void bId() {
        AppMethodBeat.m2504i(21985);
        this.nAh.doN().removeCallbacks(this.nAg);
        this.nAh.mo10310m(this.nAg, 500);
        AppMethodBeat.m2505o(21985);
    }
}
