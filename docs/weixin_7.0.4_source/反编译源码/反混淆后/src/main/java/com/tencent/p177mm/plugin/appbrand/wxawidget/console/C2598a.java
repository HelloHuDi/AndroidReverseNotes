package com.tencent.p177mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.graphics.Color;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.LogInfo;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.smtt.sdk.WebView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.a */
final class C2598a extends C41523a {
    private static final SimpleDateFormat jpD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    List<LogInfo> jpE = new LinkedList();
    LayoutInflater mInflater;

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.a$a */
    static class C2599a extends C41531v {
        TextView gKl;
        TextView jpF;

        public C2599a(View view, int i) {
            super(view);
            AppMethodBeat.m2504i(11125);
            this.jpF = (TextView) view.findViewById(2131822952);
            this.gKl = (TextView) view.findViewById(2131822953);
            switch (i) {
                case 1:
                    this.jpF.setText("L");
                    this.gKl.setTextColor(-7829368);
                    AppMethodBeat.m2505o(11125);
                    return;
                case 2:
                    this.jpF.setText("I");
                    this.gKl.setTextColor(WebView.NIGHT_MODE_COLOR);
                    AppMethodBeat.m2505o(11125);
                    return;
                case 3:
                    this.jpF.setText(QLog.TAG_REPORTLEVEL_COLORUSER);
                    this.gKl.setTextColor(Color.rgb(0, 0, 204));
                    AppMethodBeat.m2505o(11125);
                    return;
                case 4:
                    this.jpF.setText(QLog.TAG_REPORTLEVEL_USER);
                    this.gKl.setTextColor(-65536);
                    AppMethodBeat.m2505o(11125);
                    return;
                default:
                    this.jpF.setText("L");
                    this.gKl.setTextColor(-7829368);
                    AppMethodBeat.m2505o(11125);
                    return;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(11131);
        AppMethodBeat.m2505o(11131);
    }

    C2598a(Context context) {
        AppMethodBeat.m2504i(11126);
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.m2505o(11126);
    }

    /* renamed from: a */
    public final C41531v mo4976a(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(11127);
        C2599a c2599a = new C2599a(this.mInflater.inflate(2130969193, viewGroup, false), i);
        AppMethodBeat.m2505o(11127);
        return c2599a;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(11129);
        int size = this.jpE.size();
        AppMethodBeat.m2505o(11129);
        return size;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(11130);
        int i2 = ((LogInfo) this.jpE.get(i)).level;
        AppMethodBeat.m2505o(11130);
        return i2;
    }

    /* renamed from: a */
    public final void mo4977a(C41531v c41531v, int i) {
        AppMethodBeat.m2504i(11128);
        LogInfo logInfo = (LogInfo) this.jpE.get(i);
        ((C2599a) c41531v).gKl.setText(String.format("[%s] %s", new Object[]{jpD.format(new Date(logInfo.f16124ts)), logInfo.message}));
        AppMethodBeat.m2505o(11128);
    }
}
