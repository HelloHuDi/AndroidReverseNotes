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
import java.util.List;

/* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference */
public class ServicePreference extends Preference {
    private Context context;
    private boolean ogU;
    List<C40439f> qnw;
    private OnItemClickListener suA;
    private OnClickListener suB;
    private int suC;
    private int suD;
    C13913b suS;
    OnItemClickListener suz;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference$2 */
    class C41962 implements OnItemLongClickListener {
        C41962() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25484);
            ServicePreference servicePreference = ServicePreference.this;
            if (servicePreference.suS != null) {
                boolean z;
                C13913b c13913b = servicePreference.suS;
                if (servicePreference.suS.suv) {
                    z = false;
                } else {
                    z = true;
                }
                c13913b.mo26126lX(z);
            }
            AppMethodBeat.m2505o(25484);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference$1 */
    class C41971 implements OnItemClickListener {
        C41971() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25483);
            if (ServicePreference.this.suS.mo26127wK(i)) {
                ServicePreference.this.suS.mo26126lX(false);
                AppMethodBeat.m2505o(25483);
                return;
            }
            if (ServicePreference.this.suS.suv) {
                if (ServicePreference.this.suA != null) {
                    ServicePreference.this.suA.onItemClick(adapterView, view, i, j);
                    AppMethodBeat.m2505o(25483);
                    return;
                }
            } else if (ServicePreference.this.suz != null) {
                ServicePreference.this.suz.onItemClick(adapterView, view, i, j);
            }
            AppMethodBeat.m2505o(25483);
        }
    }

    public ServicePreference(Context context) {
        this(context, null);
    }

    public ServicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ServicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(25485);
        this.suz = null;
        this.suA = null;
        this.suB = null;
        this.ogU = false;
        this.suD = 0;
        this.context = context;
        setLayoutResource(2130968756);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25738R.C8899a.AppPreference);
        this.suC = obtainStyledAttributes.getInt(0, 8);
        this.ogU = obtainStyledAttributes.getBoolean(1, false);
        this.suD = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(25485);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(25486);
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(2131821456);
        if (mMGridView == null) {
            AppMethodBeat.m2505o(25486);
            return;
        }
        this.suS = new C13913b(this.context, this.qnw);
        C14877am.bYJ().mo10117d(this.suS);
        C14877am.bYJ().mo10116c(this.suS);
        mMGridView.setAdapter(this.suS);
        mMGridView.setOnItemClickListener(new C41971());
        if (this.ogU) {
            mMGridView.setOnItemLongClickListener(new C41962());
        }
        TextView textView = (TextView) view.findViewById(2131821457);
        if (this.suS.getCount() == 0) {
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
        AppMethodBeat.m2505o(25486);
    }

    /* renamed from: Fq */
    public final C40439f mo9110Fq(int i) {
        AppMethodBeat.m2504i(25487);
        if (i < 0 || i >= this.suS.getCount()) {
            AppMethodBeat.m2505o(25487);
            return null;
        }
        C40439f c40439f = (C40439f) this.suS.getItem(i);
        AppMethodBeat.m2505o(25487);
        return c40439f;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(25488);
        if (this.suS != null) {
            C14877am.bYJ().mo10116c(this.suS);
        }
        AppMethodBeat.m2505o(25488);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(25489);
        if (this.suS != null) {
            C14877am.bYJ().mo10117d(this.suS);
        }
        AppMethodBeat.m2505o(25489);
    }
}
