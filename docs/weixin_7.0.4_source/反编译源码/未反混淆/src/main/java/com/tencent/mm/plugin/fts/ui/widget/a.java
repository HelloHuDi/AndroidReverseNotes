package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a extends LinearLayout {
    private View mMp = findViewById(R.id.l0);
    private FTSEditTextView mMq;
    private a mMr;

    public interface a {
        void onClickBackBtn(View view);
    }

    public interface b extends Comparable {
        String getTagName();
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(62158);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.a0z, this, true);
        this.mMp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(62157);
                if (a.this.mMr != null) {
                    a.this.mMr.onClickBackBtn(view);
                }
                AppMethodBeat.o(62157);
            }
        });
        this.mMq = (FTSEditTextView) findViewById(R.id.bxc);
        AppMethodBeat.o(62158);
    }

    public final void setSearchViewListener(a aVar) {
        this.mMr = aVar;
    }

    public final FTSEditTextView getFtsEditText() {
        return this.mMq;
    }
}
