package com.tencent.rtmp.p1423ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.baseutils.IOUtils;
import java.text.SimpleDateFormat;

/* renamed from: com.tencent.rtmp.ui.TXLogView */
public class TXLogView extends LinearLayout {
    /* renamed from: a */
    StringBuffer f17955a;
    /* renamed from: b */
    private TextView f17956b;
    /* renamed from: c */
    private TextView f17957c;
    /* renamed from: d */
    private ScrollView f17958d;
    /* renamed from: e */
    private ScrollView f17959e;
    /* renamed from: f */
    private final int f17960f;
    /* renamed from: g */
    private boolean f17961g;

    public TXLogView(Context context) {
        this(context, null);
    }

    public TXLogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(65560);
        this.f17955a = new StringBuffer("");
        this.f17960f = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        this.f17961g = false;
        setOrientation(1);
        this.f17956b = new TextView(context);
        this.f17957c = new TextView(context);
        this.f17958d = new ScrollView(context);
        this.f17959e = new ScrollView(context);
        LayoutParams layoutParams = new LayoutParams(-1, 0);
        layoutParams.weight = 0.2f;
        this.f17958d.setLayoutParams(layoutParams);
        this.f17958d.setBackgroundColor(1627389951);
        this.f17958d.setVerticalScrollBarEnabled(true);
        this.f17958d.setScrollbarFadingEnabled(true);
        this.f17956b.setLayoutParams(new LayoutParams(-1, -1));
        this.f17956b.setTextSize(2, 11.0f);
        this.f17956b.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.f17956b.setTypeface(Typeface.MONOSPACE, 1);
        this.f17956b.setLineSpacing(4.0f, 1.0f);
        this.f17956b.setPadding(TXLogView.m88565a(context, 2.0f), TXLogView.m88565a(context, 2.0f), TXLogView.m88565a(context, 2.0f), TXLogView.m88565a(context, 2.0f));
        this.f17958d.addView(this.f17956b);
        layoutParams = new LayoutParams(-1, 0);
        layoutParams.weight = 0.8f;
        layoutParams.topMargin = TXLogView.m88565a(context, 2.0f);
        this.f17959e.setLayoutParams(layoutParams);
        this.f17959e.setBackgroundColor(1627389951);
        this.f17959e.setVerticalScrollBarEnabled(true);
        this.f17959e.setScrollbarFadingEnabled(true);
        this.f17957c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f17957c.setTextSize(2, 13.0f);
        this.f17957c.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.f17957c.setPadding(TXLogView.m88565a(context, 2.0f), TXLogView.m88565a(context, 2.0f), TXLogView.m88565a(context, 2.0f), TXLogView.m88565a(context, 2.0f));
        this.f17959e.addView(this.f17957c);
        addView(this.f17958d);
        addView(this.f17959e);
        setVisibility(8);
        AppMethodBeat.m2505o(65560);
    }

    /* renamed from: a */
    public static int m88565a(Context context, float f) {
        AppMethodBeat.m2504i(65561);
        int i = (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
        AppMethodBeat.m2505o(65561);
        return i;
    }

    /* renamed from: a */
    public void mo75194a(Bundle bundle, Bundle bundle2, int i) {
        AppMethodBeat.m2504i(65562);
        if (this.f17961g) {
            AppMethodBeat.m2505o(65562);
        } else if (i == 2011 || i == 2012) {
            AppMethodBeat.m2505o(65562);
        } else {
            if (bundle != null && getVisibility() == 0) {
                this.f17956b.setText(mo75191a(bundle));
            }
            if (this.f17955a.length() <= 0) {
                this.f17955a.append("liteav sdk version:" + TXLiveBase.getSDKVersionStr());
            }
            if (bundle2 != null) {
                String string = bundle2.getString(TXLiveConstants.EVT_DESCRIPTION);
                if (!(string == null || string.isEmpty())) {
                    mo75193a(i, string);
                    if (getVisibility() == 0) {
                        this.f17957c.setText(this.f17955a.toString());
                        m88566a(this.f17959e, this.f17957c);
                    }
                }
            }
            AppMethodBeat.m2505o(65562);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo75193a(int i, String str) {
        AppMethodBeat.m2504i(65563);
        if (i == 1020) {
            AppMethodBeat.m2505o(65563);
            return;
        }
        String format = new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
        while (this.f17955a.length() > AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS) {
            int indexOf = this.f17955a.indexOf(IOUtils.LINE_SEPARATOR_UNIX);
            if (indexOf == 0) {
                indexOf = 1;
            }
            this.f17955a = this.f17955a.delete(0, indexOf);
        }
        this.f17955a = this.f17955a.append("\n[" + format + "]" + str);
        AppMethodBeat.m2505o(65563);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public String mo75191a(Bundle bundle) {
        AppMethodBeat.m2504i(65564);
        r1 = new Object[12];
        r1[7] = "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_CODEC_CACHE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", new Object[]{Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_PLAY_SPEED))}).toString();
        r1[8] = "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps";
        r1[9] = "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_CODEC_DROP_CNT) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_DROP_SIZE);
        r1[10] = "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP);
        r1[11] = "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO);
        String format = String.format("%-16s %-16s %-16s\n%-12s %-12s %-12s %-12s\n%-14s %-14s %-14s\n%-16s %-16s", r1);
        AppMethodBeat.m2505o(65564);
        return format;
    }

    /* renamed from: a */
    public void mo75192a() {
        AppMethodBeat.m2504i(65565);
        this.f17955a.setLength(0);
        this.f17956b.setText("");
        this.f17957c.setText("");
        AppMethodBeat.m2505o(65565);
    }

    /* renamed from: a */
    public void mo75195a(boolean z) {
        AppMethodBeat.m2504i(65566);
        setVisibility(z ? 0 : 8);
        if (z) {
            this.f17957c.setText(this.f17955a.toString());
            m88566a(this.f17959e, this.f17957c);
            AppMethodBeat.m2505o(65566);
            return;
        }
        this.f17957c.setText("");
        AppMethodBeat.m2505o(65566);
    }

    /* renamed from: b */
    public void mo75196b(boolean z) {
        this.f17961g = z;
    }

    /* renamed from: a */
    private void m88566a(ScrollView scrollView, View view) {
        AppMethodBeat.m2504i(65567);
        if (scrollView == null || view == null) {
            AppMethodBeat.m2505o(65567);
            return;
        }
        int measuredHeight = view.getMeasuredHeight() - scrollView.getMeasuredHeight();
        if (measuredHeight < 0) {
            measuredHeight = 0;
        }
        scrollView.scrollTo(0, measuredHeight);
        AppMethodBeat.m2505o(65567);
    }
}
