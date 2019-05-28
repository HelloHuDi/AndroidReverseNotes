package com.tencent.p177mm.plugin.nearlife.p471ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C18333mn;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI */
public class SelectPoiCategoryUI extends MMActivity {
    static final String oSN = (C5128ac.eSj + "poi_categories");
    private ListView mListView;
    private OnMenuItemClickListener oSI = new C433452();
    private C6995a oSO;
    private ArrayAdapter<String> oSP;
    private List<String> oSQ;
    private OnItemClickListener oSR = new C394651();

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI$a */
    class C6995a extends C4884c<C18333mn> {
        SelectPoiCategoryUI oST;

        public C6995a() {
            super(0);
            AppMethodBeat.m2504i(23000);
            this.xxI = C18333mn.class.getName().hashCode();
            AppMethodBeat.m2505o(23000);
        }

        /* renamed from: a */
        private boolean m11659a(C18333mn c18333mn) {
            AppMethodBeat.m2504i(23001);
            if (c18333mn instanceof C18333mn) {
                SelectPoiCategoryUI selectPoiCategoryUI = this.oST;
                byte[] bArr = c18333mn.cIq.content;
                File file = new File(SelectPoiCategoryUI.oSN);
                if (!file.exists()) {
                    file.mkdir();
                }
                try {
                    String str = SelectPoiCategoryUI.oSN + "/lastest_poi_categories.dat";
                    File file2 = new File(str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    C1173e.m2559b(str, bArr, bArr.length);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + e.getMessage());
                }
                selectPoiCategoryUI.mo68885bc(bArr);
                selectPoiCategoryUI.bVr();
            }
            AppMethodBeat.m2505o(23001);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI$1 */
    class C394651 implements OnItemClickListener {
        C394651() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22998);
            C4990ab.m7411d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", Integer.valueOf(i), Integer.valueOf(SelectPoiCategoryUI.this.oSQ.size()));
            Intent intent = new Intent();
            intent.putExtra("poi_category", (String) SelectPoiCategoryUI.this.oSQ.get(i));
            SelectPoiCategoryUI.this.setResult(-1, intent);
            SelectPoiCategoryUI.this.finish();
            AppMethodBeat.m2505o(22998);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI$2 */
    class C433452 implements OnMenuItemClickListener {
        C433452() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22999);
            SelectPoiCategoryUI.this.setResult(0, null);
            SelectPoiCategoryUI.this.finish();
            AppMethodBeat.m2505o(22999);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SelectPoiCategoryUI() {
        AppMethodBeat.m2504i(23003);
        AppMethodBeat.m2505o(23003);
    }

    static {
        AppMethodBeat.m2504i(23011);
        AppMethodBeat.m2505o(23011);
    }

    public final int getLayoutId() {
        return 2130970600;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(23004);
        super.onCreate(bundle);
        this.oSQ = new ArrayList();
        initView();
        this.oSO = new C6995a();
        C4879a.xxA.mo10052c(this.oSO);
        this.oSO.oST = this;
        C9638aw.m17182Rg().mo14541a(new C45181k(17), 0);
        AppMethodBeat.m2505o(23004);
    }

    public final void initView() {
        AppMethodBeat.m2504i(23005);
        setMMTitle((int) C25738R.string.d7f);
        setBackBtn(this.oSI);
        this.oSP = new ArrayAdapter(this, 2130970365);
        this.mListView = (ListView) findViewById(2131827329);
        this.mListView.setAdapter(this.oSP);
        this.mListView.setOnItemClickListener(this.oSR);
        if (!m77351TF(oSN + "/lastest_poi_categories.dat")) {
            try {
                m77350D(getAssets().open("default_poi_categories.dat"));
            } catch (IOException e) {
                C4990ab.m7410d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + e.getMessage());
            }
        }
        bVr();
        AppMethodBeat.m2505o(23005);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048 A:{SYNTHETIC, Splitter:B:15:0x0048} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0096 A:{SYNTHETIC, Splitter:B:28:0x0096} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: D */
    private boolean m77350D(InputStream inputStream) {
        IOException e;
        Throwable th;
        AppMethodBeat.m2504i(23006);
        if (inputStream == null) {
            AppMethodBeat.m2505o(23006);
            return false;
        }
        this.oSQ.clear();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.oSQ.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            C4990ab.m7410d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e2.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        C4990ab.m7410d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e22) {
                                C4990ab.m7410d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e22.getMessage());
                            }
                        }
                        inputStream.close();
                        AppMethodBeat.m2505o(23006);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                        }
                        inputStream.close();
                        AppMethodBeat.m2505o(23006);
                        throw th;
                    }
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            C4990ab.m7410d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
            if (bufferedReader != null) {
            }
            inputStream.close();
            AppMethodBeat.m2505o(23006);
            return true;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                    C4990ab.m7410d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e5.getMessage());
                    AppMethodBeat.m2505o(23006);
                    throw th;
                }
            }
            inputStream.close();
            AppMethodBeat.m2505o(23006);
            throw th;
        }
        AppMethodBeat.m2505o(23006);
        return true;
    }

    /* renamed from: TF */
    private boolean m77351TF(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(23007);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(23007);
        } else {
            File file = new File(str);
            if (file.exists()) {
                try {
                    z = m77350D(new FileInputStream(file));
                    AppMethodBeat.m2505o(23007);
                } catch (FileNotFoundException e) {
                    C4990ab.m7411d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", str, e.getMessage());
                    AppMethodBeat.m2505o(23007);
                }
            } else {
                AppMethodBeat.m2505o(23007);
            }
        }
        return z;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(23008);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.oSO);
        AppMethodBeat.m2505o(23008);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bc */
    public final void mo68885bc(byte[] bArr) {
        AppMethodBeat.m2504i(23009);
        String[] split = new String(bArr).split(IOUtils.LINE_SEPARATOR_UNIX);
        this.oSQ.clear();
        for (String trim : split) {
            this.oSQ.add(trim.trim());
        }
        AppMethodBeat.m2505o(23009);
    }

    /* Access modifiers changed, original: final */
    public final void bVr() {
        AppMethodBeat.m2504i(23010);
        this.oSP.clear();
        for (int i = 0; i < this.oSQ.size(); i++) {
            this.oSP.add(this.oSQ.get(i));
        }
        this.oSP.notifyDataSetChanged();
        AppMethodBeat.m2505o(23010);
    }
}
