package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.smtt.sdk.WebView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final class a extends android.support.v7.widget.RecyclerView.a {
    private static final SimpleDateFormat jpD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    List<LogInfo> jpE = new LinkedList();
    LayoutInflater mInflater;

    static class a extends v {
        TextView gKl;
        TextView jpF;

        public a(View view, int i) {
            super(view);
            AppMethodBeat.i(11125);
            this.jpF = (TextView) view.findViewById(R.id.b13);
            this.gKl = (TextView) view.findViewById(R.id.b14);
            switch (i) {
                case 1:
                    this.jpF.setText("L");
                    this.gKl.setTextColor(-7829368);
                    AppMethodBeat.o(11125);
                    return;
                case 2:
                    this.jpF.setText("I");
                    this.gKl.setTextColor(WebView.NIGHT_MODE_COLOR);
                    AppMethodBeat.o(11125);
                    return;
                case 3:
                    this.jpF.setText(QLog.TAG_REPORTLEVEL_COLORUSER);
                    this.gKl.setTextColor(Color.rgb(0, 0, 204));
                    AppMethodBeat.o(11125);
                    return;
                case 4:
                    this.jpF.setText(QLog.TAG_REPORTLEVEL_USER);
                    this.gKl.setTextColor(-65536);
                    AppMethodBeat.o(11125);
                    return;
                default:
                    this.jpF.setText("L");
                    this.gKl.setTextColor(-7829368);
                    AppMethodBeat.o(11125);
                    return;
            }
        }
    }

    static {
        AppMethodBeat.i(11131);
        AppMethodBeat.o(11131);
    }

    a(Context context) {
        AppMethodBeat.i(11126);
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(11126);
    }

    public final v a(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(11127);
        a aVar = new a(this.mInflater.inflate(R.layout.px, viewGroup, false), i);
        AppMethodBeat.o(11127);
        return aVar;
    }

    public final int getItemCount() {
        AppMethodBeat.i(11129);
        int size = this.jpE.size();
        AppMethodBeat.o(11129);
        return size;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(11130);
        int i2 = ((LogInfo) this.jpE.get(i)).level;
        AppMethodBeat.o(11130);
        return i2;
    }

    public final void a(v vVar, int i) {
        AppMethodBeat.i(11128);
        LogInfo logInfo = (LogInfo) this.jpE.get(i);
        ((a) vVar).gKl.setText(String.format("[%s] %s", new Object[]{jpD.format(new Date(logInfo.ts)), logInfo.message}));
        AppMethodBeat.o(11128);
    }
}
