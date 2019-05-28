package com.tencent.p177mm.plugin.downloader_app.p380ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView */
public class TaskManagerHeaderView extends LinearLayout {
    private TextView kQs = ((TextView) LayoutInflater.from(getContext()).inflate(2130969816, this, true).findViewById(2131822274));

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView$1 */
    class C388691 implements OnClickListener {
        C388691() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136314);
            if (TaskManagerHeaderView.this.getContext() instanceof DownloadMainUI) {
                ((DownloadMainUI) TaskManagerHeaderView.this.getContext()).kQc.biU();
            }
            AppMethodBeat.m2505o(136314);
        }
    }

    public TaskManagerHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(136315);
        setOrientation(1);
        this.kQs.setOnClickListener(new C388691());
        View view = new View(getContext());
        view.setBackgroundColor(getResources().getColor(C25738R.color.f11945mj));
        addView(view, -1, 1);
        AppMethodBeat.m2505o(136315);
    }
}
