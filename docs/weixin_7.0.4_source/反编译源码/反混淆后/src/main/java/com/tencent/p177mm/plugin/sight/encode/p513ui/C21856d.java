package com.tencent.p177mm.plugin.sight.encode.p513ui;

import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p975c.C39132b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sight.encode.ui.d */
public final class C21856d implements TextWatcher, OnClickListener, OnFocusChangeListener, C28114l {
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    public EditText qAV;
    public TextView qAW;
    public View qAX;
    private C28106a qAY;
    InputMethodManager qAZ;
    public C13339b qBa = C13339b.normal;
    public C21857a qBb;

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.d$b */
    public enum C13339b {
        search,
        normal;

        static {
            AppMethodBeat.m2505o(25074);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.d$a */
    public interface C21857a {
        void clO();

        void clP();

        /* renamed from: db */
        void mo37331db(List<String> list);
    }

    public C21856d() {
        AppMethodBeat.m2504i(25075);
        AppMethodBeat.m2505o(25075);
    }

    public final boolean clK() {
        return this.qBa == C13339b.search;
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.m2504i(25076);
        if (!z) {
            this.qAV.clearFocus();
            C5046bo.hideVKB(this.qAV);
        }
        AppMethodBeat.m2505o(25076);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(25077);
        if (view.getId() == 2131825724) {
            if (clK()) {
                clL();
            } else {
                AppMethodBeat.m2505o(25077);
                return;
            }
        }
        AppMethodBeat.m2505o(25077);
    }

    public final void clL() {
        AppMethodBeat.m2504i(25078);
        if (clK()) {
            clN();
            AppMethodBeat.m2505o(25078);
            return;
        }
        clM();
        AppMethodBeat.m2505o(25078);
    }

    private void clM() {
        AppMethodBeat.m2504i(25079);
        if (clK()) {
            AppMethodBeat.m2505o(25079);
            return;
        }
        this.qBa = C13339b.search;
        this.qAX.setVisibility(0);
        if (this.qBb != null) {
            this.qBb.clO();
        }
        this.qAV.requestFocus();
        this.qAZ.showSoftInput(this.qAV, 0);
        AppMethodBeat.m2505o(25079);
    }

    public final void clN() {
        AppMethodBeat.m2504i(25080);
        if (clK()) {
            this.qAV.setText("");
            this.qAV.clearFocus();
            C5046bo.hideVKB(this.qAV);
            this.qBa = C13339b.normal;
            this.qAX.setVisibility(8);
            if (this.qBb != null) {
                this.qBb.clP();
            }
            AppMethodBeat.m2505o(25080);
            return;
        }
        AppMethodBeat.m2505o(25080);
    }

    /* renamed from: b */
    public final void mo8215b(C28109j c28109j) {
        AppMethodBeat.m2504i(25081);
        if (c28109j.bFZ == 0) {
            if (c28109j.mEy == null || this.qBb == null) {
                AppMethodBeat.m2505o(25081);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (C45966l c45966l : c28109j.mEy) {
                arrayList.add(c45966l.mDx);
            }
            this.qBb.mo37331db(arrayList);
        }
        AppMethodBeat.m2505o(25081);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        AppMethodBeat.m2504i(25082);
        if (C5046bo.isNullOrNil(editable.toString())) {
            AppMethodBeat.m2505o(25082);
            return;
        }
        C4990ab.m7417i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", editable.toString());
        if (this.qAY != null) {
            ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(this.qAY);
            this.qAY = null;
        }
        this.qAY = ((C12029n) C1720g.m3530M(C12029n.class)).search(2, C20846i.m32057a(r0, new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075}, null, 3, new HashSet(), C39132b.mEV, this, this.handler));
        AppMethodBeat.m2505o(25082);
    }
}
