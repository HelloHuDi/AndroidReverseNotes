package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class VideoStatusLayout extends RelativeLayout {
    private a ANA;
    private VideoDotPercentIndicator ANw;
    private TextView ANx;
    private TextView ANy;
    private LinearLayout ANz;
    private int duration = 1000;
    private ImageView kla;

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(VideoStatusLayout videoStatusLayout, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(84567);
            VideoStatusLayout.this.setVisibility(8);
            AppMethodBeat.o(84567);
        }
    }

    public VideoStatusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(84568);
        LayoutInflater.from(context).inflate(R.layout.asv, this);
        this.kla = (ImageView) findViewById(R.id.edk);
        this.ANw = (VideoDotPercentIndicator) findViewById(R.id.edm);
        this.ANx = (TextView) findViewById(R.id.edi);
        this.ANy = (TextView) findViewById(R.id.edl);
        this.ANz = (LinearLayout) findViewById(R.id.edj);
        this.ANA = new a(this, (byte) 0);
        setVisibility(8);
        AppMethodBeat.o(84568);
    }

    public final void show() {
        AppMethodBeat.i(84569);
        setVisibility(0);
        removeCallbacks(this.ANA);
        postDelayed(this.ANA, (long) this.duration);
        AppMethodBeat.o(84569);
    }

    public void setVolumnProgress(int i) {
        AppMethodBeat.i(84570);
        this.ANw.setProgress((float) i);
        this.ANw.setVisibility(0);
        this.ANy.setText(R.string.gbo);
        this.ANz.setVisibility(0);
        this.kla.setImageResource(R.drawable.a86);
        this.ANx.setVisibility(8);
        AppMethodBeat.o(84570);
    }

    public void setBrightProgress(int i) {
        AppMethodBeat.i(84571);
        this.ANw.setProgress((float) i);
        this.ANw.setVisibility(0);
        this.ANy.setText(R.string.gbn);
        this.ANz.setVisibility(0);
        this.kla.setImageResource(R.drawable.a7w);
        this.ANx.setVisibility(8);
        AppMethodBeat.o(84571);
    }

    public void setVideoTimeProgress(String str) {
        AppMethodBeat.i(84572);
        this.ANx.setText(str);
        this.ANx.setVisibility(0);
        this.ANz.setVisibility(8);
        AppMethodBeat.o(84572);
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(84573);
        this.kla.setImageResource(i);
        AppMethodBeat.o(84573);
    }
}
