package com.tencent.p177mm.p612ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.k */
public final class C30394k extends AlertDialog {
    /* renamed from: IT */
    private CharSequence f13741IT;
    private View jcl;
    public BaseAdapter khG;
    private Context mContext;
    private ListView mListView;
    public OnItemClickListener vtI;

    public C30394k(Context context) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(106682);
        this.mContext = context;
        if (C1338a.m2865ga(this.mContext)) {
            this.jcl = View.inflate(this.mContext, 2130970122, null);
        } else {
            this.jcl = View.inflate(this.mContext, 2130970121, null);
        }
        this.mListView = (ListView) this.jcl.findViewById(2131820986);
        AppMethodBeat.m2505o(106682);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(106683);
        super.onCreate(bundle);
        setContentView(this.jcl);
        AppMethodBeat.m2505o(106683);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f13741IT = charSequence;
        } else {
            this.f13741IT = null;
        }
    }

    public final void show() {
        AppMethodBeat.m2504i(106684);
        if (this.f13741IT != null) {
            this.f13741IT.length();
        }
        if (this.vtI != null) {
            this.mListView.setOnItemClickListener(this.vtI);
        }
        if (this.khG != null) {
            this.mListView.setAdapter(this.khG);
        }
        super.show();
        AppMethodBeat.m2505o(106684);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(106685);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(106685);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMListDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(106685);
        }
    }
}
