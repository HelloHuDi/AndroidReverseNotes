package com.tencent.mm.ui;

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
import com.tencent.mm.R;

public final class ab extends LinearLayout {
    private String hint;
    private EditText iXZ;
    private ImageView lnh = ((ImageView) findViewById(R.id.kx));
    private Context mContext;
    private ImageButton mpR;
    private a ypV;

    public interface a {
        void onClickBackBtn(View view);
    }

    public ab(Context context) {
        super(context);
        AppMethodBeat.i(112462);
        this.mContext = context;
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.ac, this, true);
        this.lnh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112459);
                if (ab.this.ypV != null) {
                    ab.this.ypV.onClickBackBtn(view);
                }
                AppMethodBeat.o(112459);
            }
        });
        this.iXZ = (EditText) findViewById(R.id.ky);
        this.iXZ.requestFocus();
        this.mpR = (ImageButton) findViewById(R.id.kz);
        this.mpR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112460);
                ab.b(ab.this);
                AppMethodBeat.o(112460);
            }
        });
        this.iXZ.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(112461);
                if (editable == null || editable.length() <= 0) {
                    ab.this.mpR.setVisibility(8);
                    AppMethodBeat.o(112461);
                    return;
                }
                ab.this.mpR.setVisibility(0);
                AppMethodBeat.o(112461);
            }
        });
        AppMethodBeat.o(112462);
    }

    public final void setSearchViewListener(a aVar) {
        this.ypV = aVar;
    }

    public final EditText getSearchEditText() {
        return this.iXZ;
    }

    public final void setHint(String str) {
        this.hint = str;
    }

    static /* synthetic */ void b(ab abVar) {
        AppMethodBeat.i(112463);
        abVar.iXZ.setText("");
        abVar.iXZ.setHint(abVar.hint);
        abVar.mpR.setVisibility(8);
        AppMethodBeat.o(112463);
    }
}
