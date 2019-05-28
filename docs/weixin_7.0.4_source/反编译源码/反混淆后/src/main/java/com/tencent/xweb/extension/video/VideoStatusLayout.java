package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

public class VideoStatusLayout extends RelativeLayout {
    private C16385a ANA;
    private VideoDotPercentIndicator ANw;
    private TextView ANx;
    private TextView ANy;
    private LinearLayout ANz;
    private int duration = 1000;
    private ImageView kla;

    /* renamed from: com.tencent.xweb.extension.video.VideoStatusLayout$a */
    class C16385a implements Runnable {
        private C16385a() {
        }

        /* synthetic */ C16385a(VideoStatusLayout videoStatusLayout, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(84567);
            VideoStatusLayout.this.setVisibility(8);
            AppMethodBeat.m2505o(84567);
        }
    }

    public VideoStatusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(84568);
        LayoutInflater.from(context).inflate(2130970674, this);
        this.kla = (ImageView) findViewById(2131827557);
        this.ANw = (VideoDotPercentIndicator) findViewById(2131827559);
        this.ANx = (TextView) findViewById(2131827555);
        this.ANy = (TextView) findViewById(2131827558);
        this.ANz = (LinearLayout) findViewById(2131827556);
        this.ANA = new C16385a(this, (byte) 0);
        setVisibility(8);
        AppMethodBeat.m2505o(84568);
    }

    public final void show() {
        AppMethodBeat.m2504i(84569);
        setVisibility(0);
        removeCallbacks(this.ANA);
        postDelayed(this.ANA, (long) this.duration);
        AppMethodBeat.m2505o(84569);
    }

    public void setVolumnProgress(int i) {
        AppMethodBeat.m2504i(84570);
        this.ANw.setProgress((float) i);
        this.ANw.setVisibility(0);
        this.ANy.setText(C25738R.string.gbo);
        this.ANz.setVisibility(0);
        this.kla.setImageResource(C25738R.drawable.a86);
        this.ANx.setVisibility(8);
        AppMethodBeat.m2505o(84570);
    }

    public void setBrightProgress(int i) {
        AppMethodBeat.m2504i(84571);
        this.ANw.setProgress((float) i);
        this.ANw.setVisibility(0);
        this.ANy.setText(C25738R.string.gbn);
        this.ANz.setVisibility(0);
        this.kla.setImageResource(C25738R.drawable.a7w);
        this.ANx.setVisibility(8);
        AppMethodBeat.m2505o(84571);
    }

    public void setVideoTimeProgress(String str) {
        AppMethodBeat.m2504i(84572);
        this.ANx.setText(str);
        this.ANx.setVisibility(0);
        this.ANz.setVisibility(8);
        AppMethodBeat.m2505o(84572);
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setImageResource(int i) {
        AppMethodBeat.m2504i(84573);
        this.kla.setImageResource(i);
        AppMethodBeat.m2505o(84573);
    }
}
