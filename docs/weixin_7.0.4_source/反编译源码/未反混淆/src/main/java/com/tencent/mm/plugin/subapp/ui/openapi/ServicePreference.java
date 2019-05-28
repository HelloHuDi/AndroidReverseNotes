package com.tencent.mm.plugin.subapp.ui.openapi;

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
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class ServicePreference extends Preference {
    private Context context;
    private boolean ogU;
    List<f> qnw;
    private OnItemClickListener suA;
    private OnClickListener suB;
    private int suC;
    private int suD;
    b suS;
    OnItemClickListener suz;

    public ServicePreference(Context context) {
        this(context, null);
    }

    public ServicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ServicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(25485);
        this.suz = null;
        this.suA = null;
        this.suB = null;
        this.ogU = false;
        this.suD = 0;
        this.context = context;
        setLayoutResource(R.layout.e6);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.AppPreference);
        this.suC = obtainStyledAttributes.getInt(0, 8);
        this.ogU = obtainStyledAttributes.getBoolean(1, false);
        this.suD = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(25485);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(25486);
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.id.xy);
        if (mMGridView == null) {
            AppMethodBeat.o(25486);
            return;
        }
        this.suS = new b(this.context, this.qnw);
        am.bYJ().d(this.suS);
        am.bYJ().c(this.suS);
        mMGridView.setAdapter(this.suS);
        mMGridView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(25483);
                if (ServicePreference.this.suS.wK(i)) {
                    ServicePreference.this.suS.lX(false);
                    AppMethodBeat.o(25483);
                    return;
                }
                if (ServicePreference.this.suS.suv) {
                    if (ServicePreference.this.suA != null) {
                        ServicePreference.this.suA.onItemClick(adapterView, view, i, j);
                        AppMethodBeat.o(25483);
                        return;
                    }
                } else if (ServicePreference.this.suz != null) {
                    ServicePreference.this.suz.onItemClick(adapterView, view, i, j);
                }
                AppMethodBeat.o(25483);
            }
        });
        if (this.ogU) {
            mMGridView.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(25484);
                    ServicePreference servicePreference = ServicePreference.this;
                    if (servicePreference.suS != null) {
                        boolean z;
                        b bVar = servicePreference.suS;
                        if (servicePreference.suS.suv) {
                            z = false;
                        } else {
                            z = true;
                        }
                        bVar.lX(z);
                    }
                    AppMethodBeat.o(25484);
                    return true;
                }
            });
        }
        TextView textView = (TextView) view.findViewById(R.id.xz);
        if (this.suS.getCount() == 0) {
            textView.setVisibility(0);
            textView.setText(this.suD);
            mMGridView.setVisibility(8);
        } else {
            textView.setVisibility(8);
            mMGridView.setVisibility(0);
        }
        Button button = (Button) view.findViewById(R.id.y0);
        button.setVisibility(this.suC);
        button.setOnClickListener(this.suB);
        AppMethodBeat.o(25486);
    }

    public final f Fq(int i) {
        AppMethodBeat.i(25487);
        if (i < 0 || i >= this.suS.getCount()) {
            AppMethodBeat.o(25487);
            return null;
        }
        f fVar = (f) this.suS.getItem(i);
        AppMethodBeat.o(25487);
        return fVar;
    }

    public final void onResume() {
        AppMethodBeat.i(25488);
        if (this.suS != null) {
            am.bYJ().c(this.suS);
        }
        AppMethodBeat.o(25488);
    }

    public final void onPause() {
        AppMethodBeat.i(25489);
        if (this.suS != null) {
            am.bYJ().d(this.suS);
        }
        AppMethodBeat.o(25489);
    }
}
