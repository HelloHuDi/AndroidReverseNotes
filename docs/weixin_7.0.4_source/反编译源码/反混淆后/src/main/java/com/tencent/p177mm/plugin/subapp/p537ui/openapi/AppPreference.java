package com.tencent.p177mm.plugin.subapp.p537ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.MMGridView;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;

/* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AppPreference */
public class AppPreference extends Preference {
    private Context context;
    private boolean ogU;
    OnItemClickListener suA;
    private OnClickListener suB;
    private int suC;
    private int suD;
    int suw;
    C29400a suy;
    OnItemClickListener suz;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AppPreference$2 */
    class C399412 implements OnItemLongClickListener {
        C399412() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25442);
            AppPreference appPreference = AppPreference.this;
            if (appPreference.suy != null) {
                boolean z;
                C29400a c29400a = appPreference.suy;
                if (appPreference.suy.suv) {
                    z = false;
                } else {
                    z = true;
                }
                c29400a.mo47639lX(z);
            }
            AppMethodBeat.m2505o(25442);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AppPreference$1 */
    class C436711 implements OnItemClickListener {
        C436711() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25441);
            if (AppPreference.this.suy.mo47640wK(i)) {
                AppPreference.this.suy.mo47639lX(false);
                AppMethodBeat.m2505o(25441);
                return;
            }
            if (AppPreference.this.suy.suv) {
                if (AppPreference.this.suA != null) {
                    AppPreference.this.suA.onItemClick(adapterView, view, i, j);
                    AppMethodBeat.m2505o(25441);
                    return;
                }
            } else if (AppPreference.this.suz != null) {
                AppPreference.this.suz.onItemClick(adapterView, view, i, j);
            }
            AppMethodBeat.m2505o(25441);
        }
    }

    public AppPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(25443);
        this.suz = null;
        this.suA = null;
        this.suB = null;
        this.suw = 0;
        this.ogU = false;
        this.suD = 0;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25738R.C8899a.AppPreference);
        this.suC = obtainStyledAttributes.getInt(0, 8);
        this.ogU = obtainStyledAttributes.getBoolean(1, false);
        this.suD = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(25443);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(25444);
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(2131821456);
        this.suy = new C29400a(this.context, this.suw);
        mMGridView.setAdapter(this.suy);
        mMGridView.setOnItemClickListener(new C436711());
        if (this.ogU) {
            mMGridView.setOnItemLongClickListener(new C399412());
        }
        TextView textView = (TextView) view.findViewById(2131821457);
        if (this.suy.getCount() == 0) {
            textView.setVisibility(0);
            textView.setText(this.suD);
            mMGridView.setVisibility(8);
        } else {
            textView.setVisibility(8);
            mMGridView.setVisibility(0);
        }
        Button button = (Button) view.findViewById(2131821458);
        button.setVisibility(this.suC);
        button.setOnClickListener(this.suB);
        AppMethodBeat.m2505o(25444);
    }

    /* renamed from: Fq */
    public final C40439f mo69311Fq(int i) {
        AppMethodBeat.m2504i(25445);
        if (i < 0 || i >= this.suy.getCount()) {
            AppMethodBeat.m2505o(25445);
            return null;
        }
        C40439f c40439f = (C40439f) this.suy.getItem(i);
        AppMethodBeat.m2505o(25445);
        return c40439f;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(25446);
        if (this.suy != null) {
            C14877am.bYJ().mo10116c(this.suy);
        }
        AppMethodBeat.m2505o(25446);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(25447);
        if (this.suy != null) {
            C14877am.bYJ().mo10117d(this.suy);
        }
        AppMethodBeat.m2505o(25447);
    }
}
