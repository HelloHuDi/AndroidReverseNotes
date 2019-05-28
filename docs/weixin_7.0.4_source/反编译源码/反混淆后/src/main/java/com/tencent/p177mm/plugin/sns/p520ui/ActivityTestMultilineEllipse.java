package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.ActivityTestMultilineEllipse */
public class ActivityTestMultilineEllipse extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38045);
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        addContentView(linearLayout, new LayoutParams(-1, -1));
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.addView(scrollView);
        linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        scrollView.addView(linearLayout);
        QTextView qTextView = new QTextView(this);
        qTextView.setLayoutParams(new LayoutParams(-1, -2));
        qTextView.setEllipsis("...");
        qTextView.setEllipsisMore(" Read More!");
        qTextView.setText("This is some short text. It won't need to be ellipsized.");
        qTextView.setMaxLines(3);
        qTextView.setPadding(10, 10, 10, 10);
        qTextView.setBackgroundColor(-1786127);
        linearLayout.addView(qTextView);
        qTextView = new QTextView(this);
        qTextView.setLayoutParams(new LayoutParams(-1, -2));
        qTextView.setEllipsis("...");
        qTextView.setEllipsisMore(" Read More!");
        qTextView.setMaxLines(3);
        qTextView.setText("This is some longer text. It should wrap and then eventually be ellipsized once it gets way too long for the horizontal width of the current application screen. We should be fixed to max [N] lines height.");
        qTextView.setPadding(10, 10, 10, 10);
        qTextView.setBackgroundColor(-204878);
        qTextView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(38044);
                QTextView qTextView;
                if (qTextView.getIsExpanded()) {
                    qTextView = qTextView;
                    qTextView.rms = false;
                    qTextView.requestLayout();
                    qTextView.invalidate();
                    AppMethodBeat.m2505o(38044);
                    return;
                }
                qTextView = qTextView;
                qTextView.rms = true;
                qTextView.requestLayout();
                qTextView.invalidate();
                AppMethodBeat.m2505o(38044);
            }
        });
        linearLayout.addView(qTextView);
        AppMethodBeat.m2505o(38045);
    }
}
