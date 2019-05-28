package com.tencent.sqlitelint.behaviour.alert;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public class IssueDetailActivity extends SQLiteLintBaseActivity {
    public static final String KEY_ISSUE = "issue";
    private static final String TAG = "MicroMsg.IssueDetailActivity";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(94064);
        super.onCreate(bundle);
        initView((SQLiteLintIssue) getIntent().getParcelableExtra(KEY_ISSUE));
        AppMethodBeat.o(94064);
    }

    private void initView(final SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.i(94065);
        if (sQLiteLintIssue == null) {
            AppMethodBeat.o(94065);
            return;
        }
        LinearLayout linearLayout;
        setTitle(getString(R.string.g6u));
        TextView textView = (TextView) findViewById(R.id.lb);
        ((TextView) findViewById(R.id.la)).setText(SQLiteLintUtil.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, sQLiteLintIssue.createTime));
        textView.setText(SQLiteLintIssue.getLevelText(sQLiteLintIssue.level, getBaseContext()));
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.desc)) {
            linearLayout = (LinearLayout) findViewById(R.id.lc);
            ((TextView) findViewById(R.id.ld)).setText(sQLiteLintIssue.desc);
            linearLayout.setVisibility(0);
            linearLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppMethodBeat.i(94062);
                    SLog.v(IssueDetailActivity.TAG, sQLiteLintIssue.desc.replace("%", "###"), new Object[0]);
                    AppMethodBeat.o(94062);
                }
            });
        }
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.detail)) {
            linearLayout = (LinearLayout) findViewById(R.id.le);
            textView = (TextView) findViewById(R.id.lf);
            textView.setText(sQLiteLintIssue.detail);
            linearLayout.setVisibility(0);
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppMethodBeat.i(94063);
                    SLog.v(IssueDetailActivity.TAG, sQLiteLintIssue.detail.replace("%", "###"), new Object[0]);
                    AppMethodBeat.o(94063);
                }
            });
        }
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.advice)) {
            linearLayout = (LinearLayout) findViewById(R.id.lg);
            ((TextView) findViewById(R.id.lh)).setText(sQLiteLintIssue.advice);
            linearLayout.setVisibility(0);
        }
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.extInfo)) {
            linearLayout = (LinearLayout) findViewById(R.id.li);
            ((TextView) findViewById(R.id.lj)).setText(getString(R.string.g6v, new Object[]{sQLiteLintIssue.extInfo}));
            linearLayout.setVisibility(0);
        }
        AppMethodBeat.o(94065);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutId() {
        return R.layout.al;
    }
}
