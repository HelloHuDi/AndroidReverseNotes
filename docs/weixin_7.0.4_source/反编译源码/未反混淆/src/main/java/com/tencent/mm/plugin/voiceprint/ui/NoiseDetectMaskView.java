package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class NoiseDetectMaskView extends RelativeLayout {
    ProgressBar gHA = null;
    private Context mContext = null;
    TextView mMV;
    TextView sLY;
    private b sLZ;
    private a sMa;

    public interface a {
        void cHX();
    }

    public interface b {
        void cHY();
    }

    public NoiseDetectMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(26143);
        this.mContext = context;
        this.mContext.getSystemService("layout_inflater");
        LayoutInflater.from(this.mContext).inflate(R.layout.aj0, this);
        this.gHA = (ProgressBar) findViewById(R.id.di_);
        this.mMV = (TextView) findViewById(R.id.dia);
        this.sLY = (TextView) findViewById(R.id.dib);
        this.sLY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26141);
                if (NoiseDetectMaskView.this.sLZ != null) {
                    NoiseDetectMaskView.this.sLZ.cHY();
                }
                AppMethodBeat.o(26141);
            }
        });
        findViewById(R.id.bn8).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26142);
                if (NoiseDetectMaskView.this.sMa != null) {
                    NoiseDetectMaskView.this.sMa.cHX();
                }
                AppMethodBeat.o(26142);
            }
        });
        AppMethodBeat.o(26143);
    }

    public void setOnClickRetryCallback(b bVar) {
        this.sLZ = bVar;
    }

    public void setOnCancelDetectCallback(a aVar) {
        this.sMa = aVar;
    }

    public final void reset() {
        AppMethodBeat.i(26144);
        if (this.gHA != null) {
            this.gHA.setVisibility(0);
        }
        this.mMV.setText(R.string.f2n);
        this.sLY.setVisibility(8);
        AppMethodBeat.o(26144);
    }
}
