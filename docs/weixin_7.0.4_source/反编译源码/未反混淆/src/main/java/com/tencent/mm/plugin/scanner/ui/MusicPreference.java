package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference extends Preference {
    private boolean isPlaying;
    private View mView;
    private OnClickListener pLd;
    public String pZl;
    public String pZm;
    public String pZn;
    a qcA;
    private ImageButton qcz;

    public interface a {
        void d(MusicPreference musicPreference);
    }

    public MusicPreference(Context context) {
        this(context, null);
    }

    public MusicPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(81036);
        this.mView = null;
        this.qcz = null;
        this.pZl = "";
        this.pZm = "";
        this.pZn = "";
        setLayoutResource(R.layout.afy);
        AppMethodBeat.o(81036);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(81037);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(81037);
        return view2;
    }

    public final void kk(boolean z) {
        AppMethodBeat.i(81038);
        this.isPlaying = z;
        if (this.qcz != null) {
            if (z) {
                this.qcz.setImageResource(R.drawable.x6);
                AppMethodBeat.o(81038);
                return;
            }
            this.qcz.setImageResource(R.drawable.x5);
        }
        AppMethodBeat.o(81038);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(81039);
        super.onBindView(view);
        if (this.pLd == null) {
            this.pLd = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(81035);
                    if (MusicPreference.this.qcA == null) {
                        AppMethodBeat.o(81035);
                        return;
                    }
                    if (view.getId() == R.id.dai) {
                        if (MusicPreference.this.isPlaying) {
                            MusicPreference.this.isPlaying = false;
                            MusicPreference.this.qcz.setImageResource(R.drawable.x5);
                        } else {
                            MusicPreference.this.isPlaying = true;
                            MusicPreference.this.qcz.setImageResource(R.drawable.x6);
                        }
                        MusicPreference.this.qcA.d(MusicPreference.this);
                    }
                    AppMethodBeat.o(81035);
                }
            };
        }
        this.qcz = (ImageButton) view.findViewById(R.id.dai);
        this.qcz.setOnClickListener(this.pLd);
        if (this.isPlaying) {
            this.qcz.setImageResource(R.drawable.x6);
            AppMethodBeat.o(81039);
            return;
        }
        this.qcz.setImageResource(R.drawable.x5);
        AppMethodBeat.o(81039);
    }
}
