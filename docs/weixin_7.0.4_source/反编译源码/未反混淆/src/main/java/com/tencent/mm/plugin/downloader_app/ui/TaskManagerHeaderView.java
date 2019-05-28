package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class TaskManagerHeaderView extends LinearLayout {
    private TextView kQs = ((TextView) LayoutInflater.from(getContext()).inflate(R.layout.a6p, this, true).findViewById(R.id.aiq));

    public TaskManagerHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(136315);
        setOrientation(1);
        this.kQs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136314);
                if (TaskManagerHeaderView.this.getContext() instanceof DownloadMainUI) {
                    ((DownloadMainUI) TaskManagerHeaderView.this.getContext()).kQc.biU();
                }
                AppMethodBeat.o(136314);
            }
        });
        View view = new View(getContext());
        view.setBackgroundColor(getResources().getColor(R.color.mj));
        addView(view, -1, 1);
        AppMethodBeat.o(136315);
    }
}
