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

public class AppPreference extends Preference {
    private Context context;
    private boolean ogU;
    OnItemClickListener suA;
    private OnClickListener suB;
    private int suC;
    private int suD;
    int suw;
    a suy;
    OnItemClickListener suz;

    public AppPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(25443);
        this.suz = null;
        this.suA = null;
        this.suB = null;
        this.suw = 0;
        this.ogU = false;
        this.suD = 0;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.AppPreference);
        this.suC = obtainStyledAttributes.getInt(0, 8);
        this.ogU = obtainStyledAttributes.getBoolean(1, false);
        this.suD = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(25443);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(25444);
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.id.xy);
        this.suy = new a(this.context, this.suw);
        mMGridView.setAdapter(this.suy);
        mMGridView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(25441);
                if (AppPreference.this.suy.wK(i)) {
                    AppPreference.this.suy.lX(false);
                    AppMethodBeat.o(25441);
                    return;
                }
                if (AppPreference.this.suy.suv) {
                    if (AppPreference.this.suA != null) {
                        AppPreference.this.suA.onItemClick(adapterView, view, i, j);
                        AppMethodBeat.o(25441);
                        return;
                    }
                } else if (AppPreference.this.suz != null) {
                    AppPreference.this.suz.onItemClick(adapterView, view, i, j);
                }
                AppMethodBeat.o(25441);
            }
        });
        if (this.ogU) {
            mMGridView.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(25442);
                    AppPreference appPreference = AppPreference.this;
                    if (appPreference.suy != null) {
                        boolean z;
                        a aVar = appPreference.suy;
                        if (appPreference.suy.suv) {
                            z = false;
                        } else {
                            z = true;
                        }
                        aVar.lX(z);
                    }
                    AppMethodBeat.o(25442);
                    return true;
                }
            });
        }
        TextView textView = (TextView) view.findViewById(R.id.xz);
        if (this.suy.getCount() == 0) {
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
        AppMethodBeat.o(25444);
    }

    public final f Fq(int i) {
        AppMethodBeat.i(25445);
        if (i < 0 || i >= this.suy.getCount()) {
            AppMethodBeat.o(25445);
            return null;
        }
        f fVar = (f) this.suy.getItem(i);
        AppMethodBeat.o(25445);
        return fVar;
    }

    public final void onResume() {
        AppMethodBeat.i(25446);
        if (this.suy != null) {
            am.bYJ().c(this.suy);
        }
        AppMethodBeat.o(25446);
    }

    public final void onPause() {
        AppMethodBeat.i(25447);
        if (this.suy != null) {
            am.bYJ().d(this.suy);
        }
        AppMethodBeat.o(25447);
    }
}
