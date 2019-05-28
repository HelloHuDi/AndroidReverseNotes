package com.tencent.p177mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.Intent;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.downloader_app.p1646c.C45838a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.downloader_app.search.a */
public final class C20344a extends C41523a<C20340a> {
    ArrayList<C42924b> iPr = new ArrayList();
    DownloadSearchListView kPj;
    Context mContext;

    /* renamed from: com.tencent.mm.plugin.downloader_app.search.a$a */
    public class C20340a extends C41531v {
        public View contentView;
        public View kPk = this.contentView.findViewById(2131827271);
        public TextView kPl = ((TextView) this.contentView.findViewById(2131827273));
        public View kPm;
        public TextView kPn;
        public ImageView kPo;
        public View kPp;
        public ImageView kPq;
        public Button kPr;
        public TextView kPs;
        public LinearLayout kPt;
        public TextView kPu;

        public C20340a(View view) {
            super(view);
            AppMethodBeat.m2504i(136166);
            this.contentView = view;
            this.kPl.setOnClickListener(new OnClickListener(C20344a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(136163);
                    DownloadSearchListView downloadSearchListView = C20344a.this.kPj;
                    downloadSearchListView.mContext.getSharedPreferences("search_history_href", 0).edit().putString("search_history_list", "").commit();
                    if (downloadSearchListView.kPz != null) {
                        downloadSearchListView.kPz.clear();
                    }
                    downloadSearchListView.setData(null);
                    C45838a.m84850a(13, 1302, 21, 81, "", "", "");
                    AppMethodBeat.m2505o(136163);
                }
            });
            this.kPm = this.contentView.findViewById(2131827274);
            this.kPn = (TextView) this.contentView.findViewById(2131827277);
            this.kPo = (ImageView) this.contentView.findViewById(2131827276);
            this.kPo.setOnClickListener(new OnClickListener(C20344a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(136164);
                    C42924b c42924b = (C42924b) view.getTag();
                    DownloadSearchListView downloadSearchListView = C20344a.this.kPj;
                    String str = c42924b.kPJ;
                    if (!C5046bo.isNullOrNil(str)) {
                        C42924b.m76228am(downloadSearchListView.mContext, str);
                        downloadSearchListView.kPz = C42924b.m76229dD(downloadSearchListView.mContext);
                        downloadSearchListView.setData(downloadSearchListView.kPz);
                    }
                    C45838a.m84850a(13, 1302, c42924b.position, 81, "", "", "");
                    AppMethodBeat.m2505o(136164);
                }
            });
            this.kPp = this.contentView.findViewById(2131827278);
            this.kPq = (ImageView) this.contentView.findViewById(2131821433);
            this.kPr = (Button) this.contentView.findViewById(2131827279);
            this.kPr.setOnClickListener(new OnClickListener(C20344a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(136165);
                    C42924b c42924b = (C42924b) view.getTag();
                    C20344a.this.kPj.mo54482IN(c42924b.kPJ);
                    if (C20344a.this.mContext.getResources().getString(C25738R.string.cm9).equals(C20340a.this.kPr.getText().toString())) {
                        C33913a.m55500a(C20344a.this.mContext, c42924b.appId, null);
                        C45838a.m84850a(13, 1303, c42924b.position, 22, c42924b.appId, "", "");
                        AppMethodBeat.m2505o(136165);
                    } else if (C20344a.this.mContext.getResources().getString(C25738R.string.cdv).equals(C20340a.this.kPr.getText().toString())) {
                        C42911a In = C2895c.m5140In(c42924b.appId);
                        if (In == null) {
                            AppMethodBeat.m2505o(136165);
                            return;
                        }
                        if (C5730e.m8628ct(In.field_filePath)) {
                            C33913a.m55499a(In.field_downloadId, false, null);
                            C45838a.m84850a(13, 1303, c42924b.position, 44, c42924b.appId, "", "");
                        }
                        AppMethodBeat.m2505o(136165);
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("appId", c42924b.appId);
                        ((C38855d) C1720g.m3528K(C38855d.class)).mo61727a(C20344a.this.mContext, intent, null);
                        C45838a.m84850a(13, 1303, c42924b.position, 23, c42924b.appId, "", "");
                        AppMethodBeat.m2505o(136165);
                    }
                }
            });
            this.kPs = (TextView) this.contentView.findViewById(2131821138);
            this.kPt = (LinearLayout) this.contentView.findViewById(2131827281);
            this.kPu = (TextView) this.contentView.findViewById(2131827282);
            AppMethodBeat.m2505o(136166);
        }

        /* renamed from: hE */
        static String m31438hE(long j) {
            AppMethodBeat.m2504i(136167);
            String format;
            if (j >= 1073741824) {
                format = String.format("%.1fGB", new Object[]{Float.valueOf(((((float) j) / 1024.0f) / 1024.0f) / 1024.0f)});
                AppMethodBeat.m2505o(136167);
                return format;
            } else if (j >= 1048576) {
                format = String.format("%.1fMB", new Object[]{Float.valueOf((((float) j) / 1024.0f) / 1024.0f)});
                AppMethodBeat.m2505o(136167);
                return format;
            } else {
                format = String.format("%.2fMB", new Object[]{Float.valueOf((((float) j) / 1024.0f) / 1024.0f)});
                AppMethodBeat.m2505o(136167);
                return format;
            }
        }
    }

    C20344a(Context context, DownloadSearchListView downloadSearchListView) {
        AppMethodBeat.m2504i(136168);
        this.mContext = context;
        this.kPj = downloadSearchListView;
        AppMethodBeat.m2505o(136168);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(136169);
        int i2 = ((C42924b) this.iPr.get(i)).type;
        AppMethodBeat.m2505o(136169);
        return i2;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(136170);
        int size = this.iPr.size();
        AppMethodBeat.m2505o(136170);
        return size;
    }
}
