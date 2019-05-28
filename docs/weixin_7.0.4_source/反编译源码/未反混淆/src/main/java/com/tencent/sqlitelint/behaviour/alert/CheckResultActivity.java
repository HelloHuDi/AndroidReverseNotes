package com.tencent.sqlitelint.behaviour.alert;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckResultActivity extends SQLiteLintBaseActivity {
    public static final String KEY_DB_LABEL = "db_label";
    private static final String TAG = "MpApp.CheckResultActivity";
    private CheckResultListAdapter mAdapter;
    private List<SQLiteLintIssue> mCheckResultList;
    private String mDbLabel;

    class CheckResultListAdapter extends BaseAdapter {
        private final LayoutInflater mInflater;

        CheckResultListAdapter() {
            AppMethodBeat.i(94037);
            this.mInflater = LayoutInflater.from(CheckResultActivity.this);
            AppMethodBeat.o(94037);
        }

        public int getCount() {
            AppMethodBeat.i(94038);
            if (CheckResultActivity.this.mCheckResultList == null) {
                AppMethodBeat.o(94038);
                return 0;
            }
            int size = CheckResultActivity.this.mCheckResultList.size();
            AppMethodBeat.o(94038);
            return size;
        }

        public SQLiteLintIssue getItem(int i) {
            AppMethodBeat.i(94039);
            SQLiteLintIssue sQLiteLintIssue = (SQLiteLintIssue) CheckResultActivity.this.mCheckResultList.get(i);
            AppMethodBeat.o(94039);
            return sQLiteLintIssue;
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            AppMethodBeat.i(94040);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.b1m, viewGroup, false);
                ViewHolder viewHolder2 = new ViewHolder();
                viewHolder2.checkResultTv = (TextView) view.findViewById(R.id.eot);
                viewHolder2.diagnosisLevelTv = (TextView) view.findViewById(R.id.lb);
                viewHolder2.timeTv = (TextView) view.findViewById(R.id.la);
                view.setTag(viewHolder2);
                viewHolder = viewHolder2;
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            SQLiteLintIssue item = getItem(i);
            viewHolder.checkResultTv.setText(String.format("%d、%s", new Object[]{Integer.valueOf(i + 1), item.desc}));
            viewHolder.timeTv.setText(SQLiteLintUtil.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, item.createTime));
            viewHolder.diagnosisLevelTv.setText(SQLiteLintIssue.getLevelText(item.level, CheckResultActivity.this.getBaseContext()));
            AppMethodBeat.o(94040);
            return view;
        }
    }

    static class ViewHolder {
        public TextView checkResultTv;
        public TextView diagnosisLevelTv;
        public TextView timeTv;

        ViewHolder() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(94042);
        super.onCreate(bundle);
        this.mDbLabel = getIntent().getStringExtra(KEY_DB_LABEL);
        initView();
        refreshData();
        AppMethodBeat.o(94042);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(94043);
        super.onNewIntent(intent);
        refreshData();
        AppMethodBeat.o(94043);
    }

    private void refreshData() {
        AppMethodBeat.i(94044);
        List issueListByDb = IssueStorage.getIssueListByDb(this.mDbLabel);
        if (this.mCheckResultList == null) {
            this.mCheckResultList = issueListByDb;
        } else {
            this.mCheckResultList.clear();
            this.mCheckResultList.addAll(issueListByDb);
        }
        SLog.d(TAG, "refreshData size %d", Integer.valueOf(this.mCheckResultList.size()));
        this.mAdapter.notifyDataSetChanged();
        AppMethodBeat.o(94044);
    }

    private void initView() {
        AppMethodBeat.i(94045);
        setTitle(getString(R.string.g6h, new Object[]{SQLiteLintUtil.extractDbName(this.mDbLabel)}));
        ListView listView = (ListView) findViewById(R.id.l9);
        this.mAdapter = new CheckResultListAdapter();
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(94036);
                SQLiteLintIssue sQLiteLintIssue = (SQLiteLintIssue) adapterView.getItemAtPosition(i);
                Intent intent = new Intent();
                intent.putExtra(IssueDetailActivity.KEY_ISSUE, sQLiteLintIssue);
                intent.setClass(CheckResultActivity.this.getBaseContext(), IssueDetailActivity.class);
                CheckResultActivity.this.startActivity(intent);
                AppMethodBeat.o(94036);
            }
        });
        listView.setAdapter(this.mAdapter);
        this.mAdapter.notifyDataSetChanged();
        AppMethodBeat.o(94045);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutId() {
        return R.layout.aj;
    }
}
