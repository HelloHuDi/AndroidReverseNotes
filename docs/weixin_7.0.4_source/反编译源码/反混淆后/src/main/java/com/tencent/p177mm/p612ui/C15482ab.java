package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.ab */
public final class C15482ab extends LinearLayout {
    private String hint;
    private EditText iXZ;
    private ImageView lnh = ((ImageView) findViewById(2131820974));
    private Context mContext;
    private ImageButton mpR;
    private C15484a ypV;

    /* renamed from: com.tencent.mm.ui.ab$3 */
    class C154833 implements TextWatcher {
        C154833() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(112461);
            if (editable == null || editable.length() <= 0) {
                C15482ab.this.mpR.setVisibility(8);
                AppMethodBeat.m2505o(112461);
                return;
            }
            C15482ab.this.mpR.setVisibility(0);
            AppMethodBeat.m2505o(112461);
        }
    }

    /* renamed from: com.tencent.mm.ui.ab$a */
    public interface C15484a {
        void onClickBackBtn(View view);
    }

    /* renamed from: com.tencent.mm.ui.ab$2 */
    class C154852 implements OnClickListener {
        C154852() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112460);
            C15482ab.m23798b(C15482ab.this);
            AppMethodBeat.m2505o(112460);
        }
    }

    /* renamed from: com.tencent.mm.ui.ab$1 */
    class C154861 implements OnClickListener {
        C154861() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112459);
            if (C15482ab.this.ypV != null) {
                C15482ab.this.ypV.onClickBackBtn(view);
            }
            AppMethodBeat.m2505o(112459);
        }
    }

    public C15482ab(Context context) {
        super(context);
        AppMethodBeat.m2504i(112462);
        this.mContext = context;
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130968615, this, true);
        this.lnh.setOnClickListener(new C154861());
        this.iXZ = (EditText) findViewById(2131820975);
        this.iXZ.requestFocus();
        this.mpR = (ImageButton) findViewById(2131820976);
        this.mpR.setOnClickListener(new C154852());
        this.iXZ.addTextChangedListener(new C154833());
        AppMethodBeat.m2505o(112462);
    }

    public final void setSearchViewListener(C15484a c15484a) {
        this.ypV = c15484a;
    }

    public final EditText getSearchEditText() {
        return this.iXZ;
    }

    public final void setHint(String str) {
        this.hint = str;
    }

    /* renamed from: b */
    static /* synthetic */ void m23798b(C15482ab c15482ab) {
        AppMethodBeat.m2504i(112463);
        c15482ab.iXZ.setText("");
        c15482ab.iXZ.setHint(c15482ab.hint);
        c15482ab.mpR.setVisibility(8);
        AppMethodBeat.m2505o(112463);
    }
}
