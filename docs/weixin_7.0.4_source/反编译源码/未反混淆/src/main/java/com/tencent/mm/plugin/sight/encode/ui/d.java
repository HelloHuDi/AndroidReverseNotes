package com.tencent.mm.plugin.sight.encode.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements TextWatcher, OnClickListener, OnFocusChangeListener, l {
    private ak handler = new ak(Looper.getMainLooper());
    public EditText qAV;
    public TextView qAW;
    public View qAX;
    private com.tencent.mm.plugin.fts.a.a.a qAY;
    InputMethodManager qAZ;
    public b qBa = b.normal;
    public a qBb;

    public enum b {
        search,
        normal;

        static {
            AppMethodBeat.o(25074);
        }
    }

    public interface a {
        void clO();

        void clP();

        void db(List<String> list);
    }

    public d() {
        AppMethodBeat.i(25075);
        AppMethodBeat.o(25075);
    }

    public final boolean clK() {
        return this.qBa == b.search;
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(25076);
        if (!z) {
            this.qAV.clearFocus();
            bo.hideVKB(this.qAV);
        }
        AppMethodBeat.o(25076);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(25077);
        if (view.getId() == R.id.d21) {
            if (clK()) {
                clL();
            } else {
                AppMethodBeat.o(25077);
                return;
            }
        }
        AppMethodBeat.o(25077);
    }

    public final void clL() {
        AppMethodBeat.i(25078);
        if (clK()) {
            clN();
            AppMethodBeat.o(25078);
            return;
        }
        clM();
        AppMethodBeat.o(25078);
    }

    private void clM() {
        AppMethodBeat.i(25079);
        if (clK()) {
            AppMethodBeat.o(25079);
            return;
        }
        this.qBa = b.search;
        this.qAX.setVisibility(0);
        if (this.qBb != null) {
            this.qBb.clO();
        }
        this.qAV.requestFocus();
        this.qAZ.showSoftInput(this.qAV, 0);
        AppMethodBeat.o(25079);
    }

    public final void clN() {
        AppMethodBeat.i(25080);
        if (clK()) {
            this.qAV.setText("");
            this.qAV.clearFocus();
            bo.hideVKB(this.qAV);
            this.qBa = b.normal;
            this.qAX.setVisibility(8);
            if (this.qBb != null) {
                this.qBb.clP();
            }
            AppMethodBeat.o(25080);
            return;
        }
        AppMethodBeat.o(25080);
    }

    public final void b(j jVar) {
        AppMethodBeat.i(25081);
        if (jVar.bFZ == 0) {
            if (jVar.mEy == null || this.qBb == null) {
                AppMethodBeat.o(25081);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.l lVar : jVar.mEy) {
                arrayList.add(lVar.mDx);
            }
            this.qBb.db(arrayList);
        }
        AppMethodBeat.o(25081);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        AppMethodBeat.i(25082);
        if (bo.isNullOrNil(editable.toString())) {
            AppMethodBeat.o(25082);
            return;
        }
        ab.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", editable.toString());
        if (this.qAY != null) {
            ((n) g.M(n.class)).cancelSearchTask(this.qAY);
            this.qAY = null;
        }
        this.qAY = ((n) g.M(n.class)).search(2, i.a(r0, new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075}, null, 3, new HashSet(), com.tencent.mm.plugin.fts.a.c.b.mEV, this, this.handler));
        AppMethodBeat.o(25082);
    }
}
