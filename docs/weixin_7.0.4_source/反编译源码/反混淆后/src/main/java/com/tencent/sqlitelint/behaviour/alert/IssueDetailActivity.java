package com.tencent.sqlitelint.behaviour.alert;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public class IssueDetailActivity extends SQLiteLintBaseActivity {
    public static final String KEY_ISSUE = "issue";
    private static final String TAG = "MicroMsg.IssueDetailActivity";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(94064);
        super.onCreate(bundle);
        initView((SQLiteLintIssue) getIntent().getParcelableExtra(KEY_ISSUE));
        AppMethodBeat.m2505o(94064);
    }

    private void initView(final SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.m2504i(94065);
        if (sQLiteLintIssue == null) {
            AppMethodBeat.m2505o(94065);
            return;
        }
        LinearLayout linearLayout;
        setTitle(getString(C25738R.string.g6u));
        TextView textView = (TextView) findViewById(2131820989);
        ((TextView) findViewById(2131820988)).setText(SQLiteLintUtil.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, sQLiteLintIssue.createTime));
        textView.setText(SQLiteLintIssue.getLevelText(sQLiteLintIssue.level, getBaseContext()));
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.desc)) {
            linearLayout = (LinearLayout) findViewById(2131820990);
            ((TextView) findViewById(2131820991)).setText(sQLiteLintIssue.desc);
            linearLayout.setVisibility(0);
            linearLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppMethodBeat.m2504i(94062);
                    SLog.m8894v(IssueDetailActivity.TAG, sQLiteLintIssue.desc.replace("%", "###"), new Object[0]);
                    AppMethodBeat.m2505o(94062);
                }
            });
        }
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.detail)) {
            linearLayout = (LinearLayout) findViewById(2131820992);
            textView = (TextView) findViewById(2131820993);
            textView.setText(sQLiteLintIssue.detail);
            linearLayout.setVisibility(0);
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppMethodBeat.m2504i(94063);
                    SLog.m8894v(IssueDetailActivity.TAG, sQLiteLintIssue.detail.replace("%", "###"), new Object[0]);
                    AppMethodBeat.m2505o(94063);
                }
            });
        }
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.advice)) {
            linearLayout = (LinearLayout) findViewById(2131820994);
            ((TextView) findViewById(2131820995)).setText(sQLiteLintIssue.advice);
            linearLayout.setVisibility(0);
        }
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.extInfo)) {
            linearLayout = (LinearLayout) findViewById(2131820996);
            ((TextView) findViewById(2131820997)).setText(getString(C25738R.string.g6v, new Object[]{sQLiteLintIssue.extInfo}));
            linearLayout.setVisibility(0);
        }
        AppMethodBeat.m2505o(94065);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutId() {
        return 2130968624;
    }
}
