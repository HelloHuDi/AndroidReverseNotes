package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends AlertDialog {
    private CharSequence IT;
    private View jcl;
    public BaseAdapter khG;
    private Context mContext;
    private ListView mListView;
    public OnItemClickListener vtI;

    public k(Context context) {
        super(context, R.style.zt);
        AppMethodBeat.i(106682);
        this.mContext = context;
        if (a.ga(this.mContext)) {
            this.jcl = View.inflate(this.mContext, R.layout.adz, null);
        } else {
            this.jcl = View.inflate(this.mContext, R.layout.ady, null);
        }
        this.mListView = (ListView) this.jcl.findViewById(R.id.l9);
        AppMethodBeat.o(106682);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(106683);
        super.onCreate(bundle);
        setContentView(this.jcl);
        AppMethodBeat.o(106683);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.IT = charSequence;
        } else {
            this.IT = null;
        }
    }

    public final void show() {
        AppMethodBeat.i(106684);
        if (this.IT != null) {
            this.IT.length();
        }
        if (this.vtI != null) {
            this.mListView.setOnItemClickListener(this.vtI);
        }
        if (this.khG != null) {
            this.mListView.setAdapter(this.khG);
        }
        super.show();
        AppMethodBeat.o(106684);
    }

    public final void dismiss() {
        AppMethodBeat.i(106685);
        try {
            super.dismiss();
            AppMethodBeat.o(106685);
        } catch (Exception e) {
            ab.e("MicroMsg.MMListDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(106685);
        }
    }
}
